# POC - Manuel FHG.

## 1. Tech + Arquitecture

Necesidades:

-   Desarrollar una aplicación móvil (Mobile Wallet) para los **sistemas operativos IOS y Android**, con un **diseño intuitivo y sencillo** para el usuario final y un **estilo moderno.**
-   La aplicación debe contar con un **buen rendimiento** y funcionalidades de **seguridad y trazabilidad.**
-   **Audición** de todos los eventos del sistema.
-   Los **componentes** desarrollados deben ser **reutilizables** para futuros proyectos.
-   Uso de **tecnologia moderna**, óptima para las habilidades del equipo.

Propuesta:

Este POC se fundamenta en el desarrollo de una aplicación móvil, basándose en una cartera digital, con la cual el usuario final podrá realizar acciones financieras con dinero tokenizado. (activos criptográficos generados en una blockchain). Algunas de las ventajas que nos brinda el uso de la tokenización en los pagos son: seguridad, eliminación de duplicados de la información, comodidad e inmediatez en las transacciones, entre otras [[1]].

Como posible solución a este desarrollo, se propone la siguiente configuración:

**_1. Frontend_**: puesto que el proyecto cuenta con la necesidad del desarrollo de una aplicación móvil híbrida, compatible tanto para IOS como para Android, se propone el uso de **React Native**, framework basado en JavaScript. Ademas, puesto que existe la necesidad de un diseño fácil y un estilo moderno, se propone la utilización de librerias como **Material UI** o **Ant Design**. La desventaja de usar librerias para dar estilo a una aplicación es la pérdida de la marca personal de la empresa, pero como el tiempo es un factor importante a tener en cuenta, el uso de dichas librerias rebajarían la carga de trabajo. En cuanto al resto de librerias necesarias, cabe destacar **react-router-dom**, con la cual se implemente un enrutamiento dinámico, y **web3j**, para la comunicación con la Blockchain de Ethereum.

**_2. Backend_**: puesto que la aplicación necesita de microservicios para las diferentes funcionalidades establecidas, se propone el uso de **Spring Boot** junto con la librería **Hibernate**.

**_3. Smart Contracts_**: para la creación de los contratos inteligentes, necesarios para las transferencias, se propone el uso de **Solidity**, el lenguaje de programación mas común para la creación de dichos contratos inteligentes en la red de Ethereum.

**_4. Server_**: la aplicación necesita de un servidor de aplicaciones en donde poder desplegarse. Para ello se propone el uso de PaaS (Platform as a Service) como **AWS (Amazon Web Services)** o **WA (Windows Azure)**. Entre la multitud de servicios que disponen estas plataformas, encontramos la auditoria de los eventos, que es otra necesidad del proyecto (AWS Audit Manager por ejemplo).

**_5. Control de versiones_**: a la hora de desarrollar una aplicación, una herramienta imprescindible es el controlador de versiones, la cual permite tener un seguimiento de todos los cambios realizados en el código de la aplicación. Se propone el uso de **Git** o **SVN** para ello.

**_6. Integración Continua_**: es una practica del desarrollo software con la cual, tras depositar los cambios de código en un repositorio central, permite realizar pruebas de rendimiento o calidad de código. Se propone el uso de **Jenkins** con el plugin **SonarQube**.

## 2. Team

Necesidades:

-   El tiempo disponible para el POC es de 4 meses.
-   Este proyecto se utilizará como base a proyectos futuros de la empresa.

Propuesta:

Se propone un equipo con un total de 6 trabajadores y 1 jefe de equipo. El puesto de jefe de equipo será el encargado de distribuir el trabajo en el tiempo del proyecto, así como de llevar a cabo la metodología de trabajo seleccionada. Se propone el siguiente listado de trabajadores:

| Puesto                                                        | Nº de empleados |
| ------------------------------------------------------------- | --------------- |
| Desarrollador Frontend con experiencia en React Native        | 1               |
| Desarrollador Backend con experiencia en Spring Boot          | 1               |
| Desarrollador FullStack con experiencia mínima de 3 años      | 2               |
| Desarrollador BlockChain con experiencia en Solidity          | 1               |
| Ingeniero informático de sistemas con experiencia en AWS o MA | 1               |
| Jefe de equipo                                                | 1               |

## 3. Culture

Necesidad:

-   Metodología de trabajo que plasme la esencia de la empresa.

Propuesta:

Para el desarrollo de este proyecto se propone la metodología de trabajo **SCRUM**, la cual es una metodología de trabajo ágil, cuya finalidad es la entrega o finalización de pequeñas tareas en cortos periodos de tiempos. Se recomienda que los periodos de tiempos no sean superiores a 2 semanas. Al finalizar dicho periodo, el jefe de equipo se reunirá con cada una de las partes del equipo de desarrollo para comentar el estado de las tareas que se encontraban propuestas para ese periodo de tiempo. Una herramienta que puede ser muy útil para el control de tareas es **Trello**.

A parte de la metodología de trabajo, se propone que el equipo de desarrollo se encuentre en un ambiente cómodo a la vez que fluido, con ayuda constante entre todos los miembros del equipo.

[1]: https://www.mychoice2pay.com/es/blog/tokenizacion-en-pagos
