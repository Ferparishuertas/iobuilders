# iobuilders

# INTRODUCCIÓN

Se establece la necesidad de crear un sistema que permita al usuario de forma sencilla y seguro intercambiar dinero FIAT por tokens alojados en un contrato inteligente. El sistema debe cumplir con los estándares de seguridad y regulatorios. Esto requiere un esfuerzo que trasciende el ámbito tecnológico y que tiene complejas implicaciones legales.
Sucintamente podemos describir el proceso a nivel usuario de la siguiente manera:


![Diagrama introduccuón](./resources/1.Introduccion.bmp)

El usuario a través de aplicaciones usables debe ser capaz de:
- Transforma dinero en tokens para su uso posterior en otros servicios / soluciones (compras, transferencias de tokens…). Esto debe poder realizarse mediante las operaciones bancarias estándar: transferencias, pago con tarjeta de crédito, etcétera.
- Retirar el dinero en forma de tokens y transformarlo en dinero FIAT en la cuenta bancaria del usuario

Es necesario por parte de IOBuilders mantener una cuenta con la contraparte de todos los tokens emitidos. Para ello se destinará una cuenta ómnibus que almacenará todos los fondos FIAT de los usuarios. Esta cuenta únicamente almacenará los fondos, pero no dispondrá de información concreta sobre los fondos de todos los usuarios. Esa información será almacenada en el contrato de token. 
Dado que el cumplimento de la regulación es un requisito indispensable, se establecerán medidas de control de acceso a los usuarios y de identidad digital. Se plantea que el certificador último de la identidad de los usuarios pueda ser una entidad de confianza o bien la propia IOBUilders.
Llegados a este punto merece la pena destacar que la transparencia es vital en una solución como la que se está describiendo. En este sentido, sería muy conveniente que una entidad certificadora certificara que todos los tokens están respaldados por fondos en la cuenta omnibus. La solución planteada no dista mucho de que es una clásica stablecoin.
Queda fuera del este análisis establecer los “tokenomics”, es decir si se va a acuñar nuevos tokens o estos se van a quemar en ciertas circunstancias. Tampoco se hace mención a la posibilidad de establecer una comisión por transferencia de token que permita establecer modelos de negocio.

# ARQUITECTURA

Sucintamente podemos describir la arquitectura del sistema de la siguiente forma:

![Diagrama introduccuón](./resources/2.Arquitectura.bmp)

## ENTORNO BANCARIO
Tiene como objetivo transferir fondos de los usuarios hacia la cuenta ómnibus y viceversa. La gestión de estos procesos es compleja dado que tenemos que acceder a infraestructura bancaria que no siempre es fácilmente accesible. 
Los servicios bancarios serán provistos por Inversis y se usarán las funcionalidades de Momopocket para las transferencias de dinero desde la cuenta del usuario a la cuenta ómnibus y viceversa. 
Para la operativa de la cuenta omnibus (saldo, transferencias, etcétera) se usará las APIs que Inversis pone a disposición de todos sus clientes. Resulta importante tener en cuenta que esta operativa deber respetar la atomicidad con las operacines en Blockchain. Si se retiran fondos en token, es necesario que se remitan esos fondos al usuario o la operación deberá ser abortada en su conjunto. 

## APLICACIÓN DE USUARIO
La aplicación de usuario deberá estar diseñada para funcionar en dispositivos móviles. La creación de una aplicación de este tipo no está exenta de complejidad, pues existe un ecosistema heterogéneo de tipos y familias de dispositivos. Debemos recordar que los requisitos exigen que la aplicación funcione en entornos Android e iOS.
En este sentido y de forma general, se recomienda el uso de Flutter, un completo framework de desarrollo de aplicaciones móviles de Google que es compatible con ambas familas de dispositivos (Android e iOS).
  
Esta aplicación deberá disponer de varias funcionalidades fundamentales:
*	Carga / descarga de tokens: Permitirá añadir más tokens desde FIAT o canjear tokens existentes a FIAT, y por lo tanto a su cuenta bancaria.
*	Trasferencias y otras operaciones que se desee realizar con los tokens y que no requieran canjearlos por FIAT. Ejemplo, trasferir tokens desde una dirección hasta otra dirección
*	Visión completa del estado de las cuentas
    *	Cargas / descargas realizadas
    *	Transferencias / pagos / compras con tokens
    *	Saldos en la cuenta de tokens (posibles allowances)

Para poder implementar estas funcionalidades se recomienda desarrollar un APIs en el Backend de la aplicación que se encargue de realizar estas operaciones. Para lo cual se establecerán sistemas de autenticación y cifrado de alta seguridad.

## BLOCKCHAIN
En el siguiente esquema podemos encontrar la estructura de contratos inteligentes y subsistemas de apoyo.
![Diagrama introduccuón](./resources/3.blockchain.bmp)

Conviene destacar:
* API: Será el punto de entrada de todas las peticiones desde el punto de vista de la estructura de contratos. Este subsistema es complejo y será descrito con detalle en el capítulo siguiente.
* Subsistema de Identidad. Este subsistema basado en el estándar de identidad digital ERC 725 y cuenta con dos elementos
    * ERC725X que se encarga de ejecutar contratos inteligentes en el nombre del usuario. Es un contrato tipo PROXY que invoca las funciones de otros contratos de forma totalmente verificable. El contrato a validado la identidad del usuario y ejecuta una acción en su nombre en otro contrato (ejemplo: tranferir fondos en el token ERC20). Actúa también de claim holder, almacenando todas las invocaciones realizadas a los contratos (en este caso al contrato de Token)  
    *	EC725Y es un almacén clave-valor que permite alojar las identidades del usuario. Es usado por el elemento anterior para garantizar que la invocación es realizada por un usuario identificado.
*	El contrato de token, el cual será un contrato ERC20 clásico. Este contrato mantendrá los fondos en tokens de los holders. Una cuenta central y bajo el control de IOBuilders, almacenará todos los fondos que no hayan sido distribuidos. Esta cuenta permitirá controlar la liquidez de la plataforma. Este contrato deberá poder enviar fondos y retenerlos a la espera de que las operaciones bancarias se realicen correctamente. Si todo va bien, los tokens retenidos se terminarán de enviar cuando el contrat reciba la confirmación que los fondos en cuenta han sido transferifos. En caso de que la operación bancaria haya fallado por la razón que sea, los tokens retenidos podrán ser reclamados por el usuario. 
Adicionalmente, se establecerá un sistema de pause que se activaría si se detectara un problema. El contrato pausado no responderá a ninguna invocación a menos que se invoque unpause. Ambas operaciones serán realizadas por una entidad con los permisos suficientes.
*	Los contratos generan una enorme cantidad de eventos. Estos eventos son una información valiosa que puede ser utilizada de muchas maneras. En el punto siguiente se detallará este subsistema con detalle. Simplemente adelantar que el registro de eventos permitirá a la capa de gobernanza tomar decisiones.
*	La gobernanza es un elemento transversal que permite tomar decisiones en función de las circunstancias que pueden venir determinadas por los eventos o por decisiones de los responsables de la plataforma. Este elemento puede tomar decisiones como pausar el contrato de token, o poner un usuario en la lista negra.

Para la codificación de los contratos se recomienda Hardhat con un completo juego de tests unitarios que incluya información de consumo de gas y los tests de cobertura. Se recomienda la ejecución de tests de seguridad automatizada y la certificación de los contratos por empresas de confianza (OpenZeppelin, Consensys…)

## BACKEND

Como norma general, se va optar por una arquitectura basada en microservicios desplegados en contenedores Docker. En cada uno de los subsistemas que se van a establecer aquí, se detallará la estructura de microservicios.
Dada la criticidad de la plataforma, se desplegará toda la infraestructura en alta disponibilidad usando para ello un clúster de Kubernetes en la nube como por ejemplo Elastic Kubernetes Service (EKS).

### Subsistema API de usuario
Este subsistema será el encargado de procesar las peticiones de los usuarios:
* Altas de los usuarios que requerirán validación de la identidad del usuario. La forma más sencilla de realizar dicha identificación es mediante un proceso que envíe un SMS con un código de un solo uso que el usuario deberá introducir como parte de proceso identificación. Dado que en España los números de teléfono están totalmente identificados, el envío de un SMS a un móvil es la alternativa más sencilla.
* Carga o descarga de tokens. El problema principal de este proceso es la atomicidad. Es necesario acceder a sistemas no integrados, como son el sistema de gestión bancaria por un lado y los sistemas de acceso a los contratos inteligentes por otro. Ello exigirá que el proceso sea totalmente tolerante a fallos para lo cual se propone usar contratos inteligentes parecidos a los HTLC usados para los atomics swaps. De esta forma sólo se completará la trasferencia de tokens cuando se verifique la operación en la cuenta ómnibus se ha realizado con éxito-
Para los movimientos de la cuenta de usuario a la cuenta ómnibus y viceversa, se usaría la TPV virtual de Momopocket. Para el acceso a los accesos los contratos inteligentes, se usaría librerías estándar (Web3, Ethers…)
* Operación de gestión de los fondos del contrato ERC20. Transferencias, aprobaciones…
Todos los accesos a los contratos se realizarán mediante API dado que el usuario nunca gestionará una clave privada de Ethereum, toda su identificación se realzará a través de evidencias verificables.
Se plantea alojar toda la lógica correspondiente a este subsistema en único microservicio.

### Subistema de eventos (Auditoría)

Los contratos inteligentes generan una enorme cantidad de eventos. Estos eventos son una ventana que proporciona una visión de 360º de lo que sucede en la plataforma. Se plantea extraer toda esta información y alojarla en una base de datos para su posterior explotación, para lo cual se propone el uso de Eventeum que remita los eventos a una base de datos a través de un RabbitMQ y que estos acaben siendo consolidados en una BBDD.
Se plantean disponer de tres tipos de contenedores Docker:
* Base de datos (una BBDD Postgres, por ejemplo)
* RabitMQ
* Eventeum
Todos los eventos se registran en la cadena de bloques lo que constituye un registro inmutable de auditoría. Dado que es una PoC y que estamos buscando carriles rápidos, usaremos los eventos como auditoría. Si se considerara que la lógica de los contratos debe tener en cuenta los eventos de auditoría, la alternativa sería localizar el registro de eventos en contratos inteligentes.
Para la el acceso la infraestructura Alastria, se optará por un clásico endpoint RPC que permita rastrear los eventos de los diferentes contratos. No obstante, es previsible que en las pruebas de carga de este subsistema se obtenga un bajo rendimiento. En ese caso, se deberá considerar el despliegue de un nodo completamente sincronizado contra la red Alastria para poder extraer todos los eventos.

### Subsistema de gobernanza

Será el encargado de la gestión de alto nivel de la plataforma. Determinará quien deja de tener acceso o lo recupera en función de las circunstancias. Si se detectar un uso de la plataforma sospechoso por parte de un usuario, se le podría denegar el acceso o en casos extremos, se podría congelar el contrato de token para evitar que la gente pueda seguir utilizándolo.
Las circunstancias pueden provenir de la captura de eventos o puede venir de acciones manuales de usuarios con suficientes permisos de acceso.

## EQUIPO

TBD

### CULTURA Y ENTORNO MERODOLÓGICO

En este punto resulta necesario resaltar dos cuestiones:
* Hoy en día se trabaja principalmente en remoto, por lo que es necesario contar con profesionales que dominen la comunicación en todos sus aspectos y que puedan dialogar con otros profesionales de forma eficaz, es decir, ser capaces de sintetizar las cuestiones o las respuestas para que la otra persona pueda entender el problema.
El uso de herramientas de comunicación y colaboración es crítico. Por destacar algunas:
    * Herramientas de comunicación o colaboración: Google Chat, Meet, Office 365
    * Herramientas de compartición de código: github, Gogs, etcétera
* Por parte del responsable de proyecto / líder de grupo, la gestión de los RRHH en remoto requiere un sobreesfuerzo en la comunicación y un liderazgo claro.
* Dado que se trata de una PoC y que la tecnología Blockchain se encuentra en continuo cambio, conviene optar por una metodología que aumente la flexibilidad del equipo de trabajo, razón por la cual, se recomienda Scrum.
