## ioBuilders POC

#### Tech + Architecture

La prioridad es tener un MVP funcional y sobre el que se pueda construir más adelante.

Para facilitar la construcción de la interfaz y hacer una experiencia de usuario rápida, tanto en Android como iOS, Flutter 
sería buena opción, al igual que React Native.

El proceso KYC de escaneo de documentos sería mediante librerías / APIs.

El proceso de creación del wallet debe ser ultrasencillo, con una interfaz intuitiva estilo coinbase; el usuario no necesita saber que 
su cuenta es 0x3245..., sólo que se ha creado una identidad digital automáticamente y que va a poder operar con su dinero y tener acceso 
a una serie de servicios intercambiando valor.
¿Qué hay por detrás? identidad con ERC725, comunicaciones encriptadas, llamadas a servicios del backend...

Para que el tiempo de respuesta de tokenizar / destokenizar sea aceptable, es problable que se necesitara una solución de Sharding como 
PLASMA.

Desde el principio, se debe seguir una arquitectura clean, dividiendo el negocio de la capa de aplicación y frameworks. Esto nos permitirá
adaptarnos en el futuro a posibles necesidades y escalar mejor.

La arquitectura debería ser híbrida, con una capa de servicio continuo para garantizar la inmediatez de las peticiones, y otra serverless 
para servicios que permitan algo de latencia, pero nos de la flexibilidad y ahorro de costes del serverless.

La arquitectura de base de datos, tanto para eventos como para gestión de datos, será híbrida: noSQL para un acceso rápido y RDBMS para 
almacén de datos y consultas complejas.

Las interacciones con momopocket, inversis, etc, serán mediante APIs quizá ya definidas o por implementar. Es necesario verificar la capa 
de seguridad que rodea a estos servicios.

Smart contracts: Identiificación, tokenización, traspaso entre cuentas, intercambio de tokens, airdrop, promociones de bienvenida, etc.

#### Team

Al tratarse de un MVP, necesitamos roles multidisciplinares senior, cada uno con su especialidad. Cada uno tendrá un 80% al menos de su 
especialidad y conocerá otras disciplinas para poder aportar e interpretar.
2 backend
1 hybrid frontend
1 UX specialist
1 blockchain engineer

Uno de los participantes, actuará como product owner.

#### Cultura

- Agile: Reunión a principios de mes para definir objetivos del mismo. Sprint semanal, ya que permite tener pormenorizadas las tareas. 
Retro a final de mes, donde nos decimos lo guay y lo que hay que mejorar.
- Git-flow para el desarrollo de features, releases, etc.
- Kanban
- Preguntar es bueno, pero busca primero en Google...
- Focus, focus, focus. Si tienes que interrumpir a un compañero, pregúntale antes por slack si puede atenderte o le queda mucho pomodoro
- Transparecia: así el equipo tiene más sensación de pertenencia al proyecto
- Los problemas y peros se sacan a la palestra cuanto antes, pero si se aporta una visión de la solución, mejor.
- Acordar un "momento de esparcimiento" del equipo para hacer team building
