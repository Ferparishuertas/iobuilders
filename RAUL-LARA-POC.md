# POC
## - Arquitectura
Analizando el tiempo para realizar esta POC sin duda alguna optaremos por una aquitectura de micro servicios con tipo de Arquitectura CQRS. El motivo de usar micro servicios es porque la reutilización de los mismos una
vez validado el proyecto es sencillo además de disponer ya de una base solida sobre la que trabajar. Sin embargo, aunque es muy importante la configuración de la escalabilidad, gestión de accesos, balanceo, etc en este
caso no debemos perder el tiempo en ello.

Usaremos una arquitectura CQRS, en la cual nuestra fuente de la verdad será Kafka por el cual irá toda la mensajería de nuestro proyecto. Además de esta fuente de la verdad, generaremos vistas materializadas de todos
los tópicos existentes en Kafka siendo este proceso realizado por un micro servicio y guardando todos los mensajes en una base de datos no relacional. (ej: MongoDB). La creación de estas vistas nos permitirá en el 
caso que se pierda la información de Kafka, volverla a insertar para dejar el mismo estado previo a la pérdida de la información.

Todo proceso que genere un cambio de estado se llevará a cabo de manera asíncrona a través de procesos controlados por BPMs, los cuales nos proporcionan una consola de actuación por si hubiera algún error, siendo toda
la comunicación a través de Kafka. 

En el caso de los procesos consultivos serán realizados a través de API REST, para exponer estas APIS y las detonantes de los procesos dispondremos de un API GATEWAY el cual será el encargado de gestionar
la seguridad de las llamadas y el control de mismo.

### - FrontEnd
El lenguaje a usar será React dado que, tendremos una aplicación con múltiples componentes los cuales gestiona muy bien React. Además, React es un lenguaje puramente Javascript salvo por ciertos detalles específicos de React. Por último, 
React dispone de React Native para aplicaciones móviles.
### - BackEnd
Se usará la dupla de Spring boot y Java 11, en este caso es de las combinaciones más usadas en el mercado dado que, son dos tecnologías y muy robustas y con múltiples componentes o librerías ya testeadas que nos proporcionan
una mayor potencia de programación. En este caso, Spring Boot usar el módulo de seguridad de Spring el cual implementa múltiples sistemas de autenticación.
###  - Riesgos tecnológicos
El sistema se ha de crear con una gran resiliencia antes los errores, aunque siempre existe uno no dependiente de nuestro sistema y es cuando se usan aplicaciones externas.
## - Cultura
Se ha de inculcar una filosofía de CI/CD (Continuous Integration / Continuous Delivery) en la cual es necesaria que se apliquen los principios SOLID del desarrollo, al igual que el uso de TDD en el cual lo primero que se desarrolla son los test. 
Con esto conseguiremos tener siempre un código testeado disponible para desplegar en cualqueir momento. Además de esto, se usará el sistema de ramas y gestión Gitflow en el equipo. Para poder fundamentar todo esto necesitaremos trabajar sobre SCRUM.

## - Equipo
El equipo de desarrollo debe de componerse por:
- 1 Product Owner / Scrum Master 
- 1 Arquitecto Software
- 1 FrontEnd
- 3 Backend Developer habituados a trabajar también como DEVOPS
- 1 Desarrollador Blockchain

