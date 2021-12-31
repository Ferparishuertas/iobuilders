# Tecnología y Arquitectura
En resumen lo que se quiere conseguir en esta POC es comprobar la viabilidad de una solución para convertir una fiat en un token y al contrario.

## Riesgos tecnológicos
Algunos de los riesgos que se pueden plantear a priori son:
- La seguridad que conlleva todo lo relacionado con movimientos bancarios.
- La obtención de perfiles a contratar y tiempos de incorporación.
- La integración de distintos servicios de terceros.
- Posibles reuniones y cambios de alcance.

## Tecnologías
Dado que no queremos que la tecnología sea un problema intentaremos usar siempre que se pueda las tecnologías más estables y mas usada para tener apoyo de la comunidad.

Detalle de que se usara en cada capa:
### App Móvil
Ya que se trata de una POC y queremos realizarla rápido y ademas la app no dispone de una alta demanda de recursos del móvil la mejor solución seria una aplicación híbrida. Para este escenario se nos podrían plantear varias opciones:
- Ionic (React, Angular o VUE)
- React Native
- Native script

En este caso podría  ser mejor **Ionic**, por la facilidad poder programar con cualquiera de los 3 frameworks populares y de poder trabajarlos a la vez, así es mas fácil encontrar perfiles. Ademas tiene una gran documentación y gran comunidad detrás.

### Back
En back podríamos tener que decidir entre java o .Net core, ambos se usan bastante y se parecen cada uno con sus características. En cuanto al uso va cambiando cada año y se adelantan el uno al otro de vez en cuando, por lo que el lenguaje a usar podría decidirse según petición del cliente o disponibilidad de perfiles, siendo ambos buenas elecciones.
Podriamos escoger **.net core** ya que es open source.

### Datos
En cuanto a la base de datos, podríamos tener que escoger entre relacional o no relacional. Siendo en este caso mejor la relacional para tener una fuerte relación entre los distintos datos y que estén bien controlados. En cuanto a que base de datos usar podría ser cualquiera de las mas populares:
- SqlServer
- PostgreSQL
- MySQL
- Oracle

Siendo cualquiera una buena opción podríamos user postgreSql  o MySql ya que es open source, ya que PostgreSql tiene algunas características extras a mySql optaremos por **PostgreSql**.

## Arquitectura
Dado que queremos tener el control de cada cosa que pase en la solución y que sea escalable se podría hacer todo sobre un kubernetes, así tmb podremos ahorrar y no tener un servicio para cada cosa y tener una maquina más grande que escale según se necesite.

Implementaremos una solución con una base de microservicios para que escale a futuro, comenzaremos con un servicio para todas las transacciones del monedero y otro para las integraciones con servicios de terceros, **alastria** e **inversis**.

Al basarnos en kubernetes para alojar todo los servicios que necesitemos, este puede estar alojado en cualquier nube sin alterar el desarrollo, así que podremos optar a la que más barata o a la que el equipo tenga conocimientos. Dado que **AWS** es mas usado nos basaremos en este para la POC

### Servicios de AWS
- Amazon Cognito para la gestión de usuarios
- EKS para alojar kubernetes
- AWS API Gateway, para redirigir las peticiones desde un punto común al servicio que sea dentro del kubernetes.
- AWS Key Management Service, para centralizar las diferentes claves y configuraciones de los distintos entornos.
- AWS RDS para postgreSQL
- AWS EventBridge para comunicar los servicios de back

### Servicios dentro del Kubernetes
- Api de las distintas funcionalidades a implementar en la POC.
- Servicio de integraciones el cual se comunica con la api mediante eventos.

### Logs
Dado que se necesita un buen log y auditoria de todo lo que pase habrá que guardar mucha información y que sea accesible, para esto guardaremos todo en elasticSearch y usaremos kibana para la visualización de estos. En la POC solo nos centraremos en guardar en **elasticaSearch**.

### Seguridad
Habra que asegurarse de que se cumplan los distintos protocolos que se piden:
- ERC20
- ERC725

### Reusabilidad
Dado que en una POC y en general en el desarrollo software lo que se busca es no repetir código y poder aprovechar lo máximo si ya esta hecho nos basaremos en alguno pilares a la hora de ir desarrollando:
- Todos los servicios de comunicación front-> back deberán autogenerarse con nswagg.
- Tener una librería de componentes "funcionales" en front para aprovechar algunos componentes entre proyectos, mas allá de visualización.
- En back también habrá que tirar de paquetes generales de la empresa, por ejemplo temas de autenticación ya realizados en otros proyectos o lógicas que se repitan mediante proyectos librería.


## Proceso
La POC se realizara mediante las siguientes etapas o hitos:
- **UI/UX**: En esta etapa la persona de UX/UI deberá hacer unos flujos y unos diseños básicos para la POC, sin entrar mucho a detalle ya que no daría tiempo de todo pero es importante esta etapa en todo proyecto.
- **Definición de funcionalidades**: Product Owner y techLead deberán decidir y enumerar las distintas funcionalidades y criterios de aceptación que tendrá cada parte de la aplicación.
- **Planteamiento de contratos back/front**: Los arquitectos tendrán que hacer una versión preliminar de los posible contratos que habrá en cada llamada http entre la app y el back.
- **Arquitectura**: Se pondrá en marcha el proyecto mientras se terminar de definir las funcionalidades. Proyecto de front y back así como repositorios, infraestructura e integración continua.
- **Mocks simples**: Una vez definidos los contratos y puesta en marcha los proyectos se procede a generar todos los endpoints y que devuelvan un mock para que se pueda trabajar en base a eso tanto back como front.
- **Desarrollo**: En esta etapa se desarrollara la POC.
- **Demos**: Se hará demo cada mes de lo que se lleva desarrollado.
- **Despliegues**: Se harán despliegues de manera continua en un entorno de desarrollo y al finalizar se dejara en un entorno de demo.

# Equipo
El equipo no seria el mismo durante todo el proceso, habría que tirar de perfiles un poco más **cross** durante algunas partes del proceso.

## Primera fase (2 semanas)
Durante las dos primeras semanas lo ideal seria que se trabajar en paralelo en los **diseños**, **arquitectura inicial**, **integración continua**, **contratos back/front** y **definición de hitos**.

En este proceso participarían los perfiles:
- Product Owner
- TechLead / scrum master
- Diseñador UX/UI
- Arquitecto Back y Front o FullStack
- Devops

## Segunda fase (3 meses)
(sprints bisemanales demos mensuales)
Durante esta fase de desarrollaran todos los hitos descritos durante la fase inicial.

En este proceso participarían los perfiles:
- Product Owner
- TechLead / scrum master
- Desarrollador Back Senior
- Desarrollador Front Senior
- Desarrollador BlockChain

## Tercera fase (2 semanas)
Durante esta fase pasara la solución por el controla de calidad y seguridad y se corregirán posibles errores detectados. También se dejara la solución en un entorno estable para su defensa.
En este proceso participarían los perfiles:
- Product Owner
- TechLead / scrum master
- Desarrollador Back Senior
- Desarrollador Front Senior
- Desarrollador BlockChain
- Analista QA / Analista de seguridad

# Cultura
Para mejorar tanto profesionalmente como personalmente se podrían establecer distintas dinámicas de grupo:
- Los viernes de talento: Espacio donde quién quiera puede hablar sobre una tecnología o dinámica que controle para compartir conocimiento, si es presencial se puede acompañar de churros.
- Quedadas trimestrales del equipo en algún bar o actividad para fomentar el Team Building.
- Plan de carrera y formaciones.
- Fomentar la participación y la discusión constructiva para resolver los distintos problemas del proyecto.
