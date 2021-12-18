# POC Tokenización FIAT
##  Tecnología + Arquitectura

####  - Arquitectura
Dado que se cuenta con cuatro meses para desarrollar la prueba de concepto, se ha optado por un modelo de microservicios serverless ya que así, nos abstraemos de la gestión de escalabilidad, del balanceo de carga y del mantenimiento del servidor.

Al tratarse de una prueba de concepto, debe de primar la operatividad y el tiempo de implementación, siendo ésta una solución bastante robusta que podrá cambiarse asépticamente en un futuro. Así mismo, los componentes podrán ser reutilizados en diferentes proyectos de la empresa.

Lo ideal sería tener un proyecto java con el sdk de Amazon que programáticamente cree los componentes de AWS con CloudFormation, pero como es una prueba de concepto, inicialmente el stack se creará a mano.

Para la auditoría se dejarán trazas en ELK Stack (Elasticsearch, Logstash, Kibana)

####  - Infraestructura
La infraestructura donde estarán alojados los microservicios y su interconexión se realizará como se describe a continuación.
El servicio de Login irá contra el servicio de indentidad de Amazon Cognito
Para los servicios de escritura se llamará desde la app móvil mediante REST a un AWS API Gateway donde se validará mediante Policy quién llama, así como mediante un token bearer previamente generado en login.
Este API Gateway escribirá en una cola SQS la petición, en la SQS tendremos preparado un Triger de Kinesis que invocará a la función Lambda donde tendremos el código Java. Cuando sea necesario invocar a otro microservicio desde ahí, se escribirá en la cola SQS correspondiente y ésta lanzará el Triger de Kinesis que invoque a la Lambda. Las funciones escribirán un evento de fin en una SQS.

Para los servicios de lectura, se llamará desde la app móvil mediante REST a un AWS API Gateway donde se validará mediante Policy quién llama, así como mediante un token bearer previamente generado en login.
Este API Gateway invocará síncronamente a la función lambda de lectura, y esta quedará escuchando la SQS de fin de la escritura, en caso de superar x(parametrizables) segundos lanzará un timeout.

####  - Integración Continua
Para la integración continua se usará bitbucket con un modelo gitflow de ramas, que, a su vez, estará integrado con Jenkins, que realizará varios pasos en función de la rama que se despliegue.
- Pasar la validación de Sonar
- Pasar los test unitarios
- Pasar los test de integración
- Compilar el código y desplegarlo en la Lambda de AWS

####  - Desarrollo
#####  Front-End
La aplicación móvil se desarrollaría en React por la cantidad de componentes que se pueden utilizar, y la comunidad y el soporte que ofrece a la hora de adquisición de talento para su desarrollo. También hay que tener en cuenta que utiliza el estándar ECMAScript 6 lo que evita muchos problemas de compatibilidad. Y con React Native tenemos la facilidad para generar aplicaciones móviles usando el mismo código JavaScript de la aplicación web.
#####  Back-End-OffChain
La aplicación servidor estaría desarrollada con spring-boot 2.6.1 sobre java 11. Al ser una solución madura, y bastante extendida entre los desarrolladores, permitirá encontrar una amplia comunidad y soporte, así como la adquisición de talento.
Elimina la necesidad de escribir código repetitivo gracias a las anotaciones y permite un rápido  y robusto desarrollo.
Cuenta con módulos de seguridad ampliamente testados, que garantizan la robustez de la aplicación.
A medida que avance el desarrollo se podrán añadir nuevas dependencias, pero inicialmente se utilizaran la siguientes:
- Function
- Lombok
- Test
- Function-web
- Devtools
- aws-lambda-java-events
- aws-lambda-java-core
- aws-java-sdk-s3
- function-adapter-aws
- web3j
- Spring Data JPA

Se mantendrá una BBDD PostgreSQL sobre AWS que contenga una relación entre usuarios de AWS Cognito, y cuentas del wallet.

#####  Back-End-OnChain
- Para el wallet usaremos los AlatriaWallet https://github.com/alastria/alastria-wallet/
- Para implementar la divisa usaremos el estándar ERC 20 de OpenZeppeling (https://docs.openzeppelin.com/contracts/4.x/erc20)
Este token corresponde a su equivalente moneda FIAT
- Para implementar el token no fungible usaremos el estandard ERC 721 de OpenZeppeling (https://docs.openzeppelin.com/contracts/4.x/api/token/erc721)
Este token lo crearemos para representar las tarjetas de crédito/débito que realizarían las operativas
- Para implementar la identidad digital usaremos el estándar ERC 725 para la gestión de claves y como un proxy de identidad
Y un el estándar ERC 735  para solicitar, añadir y verificar las alegaciones.
https://github.com/OriginProtocol/origin-playground/blob/master/contracts/KeyHolder.sol
https://github.com/OriginProtocol/origin-playground/blob/master/contracts/ClaimHolder.sol
https://github.com/OriginProtocol/origin-playground/blob/master/contracts/ClaimVerifier.sol

Se recomienda utilizar Remix para el desarrollo de los contratos.
Durante el desarrollo de los smart contracts usaremos truffle para realizar test y validaremos sobre Mythril.
También se realizarán pruebas en redes locales con Ganache y en la TestNet de Alastria.
Una vez probados, se desplegarán con un truffle conectado al nodo de Alastria de IoBuilders


###  - Riesgos tecnológicos
El mayor riesgo tecnológico, supone la caída de un servicio de terceros con el que estemos integrados, por lo que para la Prueba de concepto se crearán API Gateway que sirvan de Mock en caso de caída.

##  Equipo
El equipo de desarrollo debe de componerse por:
- 1 Product Owner que conozca el producto a nivel funcional y junto con el ScrumMaster defina las historias de usuario
- 1 Architect/ScrumMaster que gestione y defina las historias de usuario así como la arquitectura del proyecto.
- 1 FrontEnd Developer especializado en React Native con experiencia en UX.
- 2 Backend Developer especializados en microservicios Spring Boot.
- 1 Devops Engineer especializado en AWS
- 1 Blockchain Developer

Estos perfiles pueden ser cross y que una misma persona puede realizar tareas de varios roles.

##  Cultura
El proyecto se desarrollara utilizando:
- TDD
- Agile methodologies (SCRUM)
- Gitflow
- CleanCode
- Integración Continua
- SOLID
- Cobertura del 85% como mínimo

##  Conclusiones
Con este planteamiento se podría hacer una PoC inicial en cuatro meses y, una vez se acepte el proyecto, escalar las funcionalidades para plantear diferentes evolutivos. Cuando cambie el alcance habrá que contar con un experto en QA para validar la solución.
Tras este planteamiento inicial, sería recomendable mantener una reunión con el cliente para ampliar la información.
