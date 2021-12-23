
# Diseño y solución a alto nivel de POC *IoBuilders Tokenized Money* 

Autor: Arnaldo Trujillo

 
## Apps

### Arquitectura de las apps  

- Desarrollaremos las aplicaciones de forma nativa en iOS y Android para priorizar la usabilidad y UX pero programaremos los objetos de dominio core y la lógica de negocio en Kotlin Native para agilizar los tiempos de desarrollo. De forma específica de cada plataforma solamente tendremos que preocuparnos de la capa de presentación.

  

- Para la comunicación cliente-servidor de los servicios financieros utilizaremos RSocket para resolver los clásicos problemas del protocolo HTTP con este modelo de comunicaciones reactivas no bloqueantes. Este modelo nos permite una amplía gama de interacción con el servidor (channel, streaming, request-response y fire-and-forget). Con este modelo estamos priorizando el rendimiento y trazabilidad de estos servicios críticos.

  

- Utilizaremos una solución de terceros para el KYC

  

- Para garantizar la seguridad implementaremos OAuth2 usando el grant type [Authorization Code with PKCE](https://datatracker.ietf.org/doc/html/rfc7636) que es un sabor mejorado que resuelve los problemas del grant typ Authorization Code clásico en aplicaciones nativas. Usaremos

  

- Dejaremos abiertas ciertas interfaces para implementar otras capas de seguridad que escapan fuera del alcance de esta POC (3DS, 2FA, futuras normativas financieras).

  

## Backend

  

### Infraestructura

  

- Desarrollaremos microservicios reactivos con Spring Boot Webflux alojados y gestionados en una solución Kubernetes de algún proveedor cloud. Para la persistencia usaremos MongoDB aprovechando su conector reactivo.
- Servidor de autenticación basado en OpenID Connect integrado con [Alastra ID](https://github.com/alastria/alastria-identity) que hará la función de Identity Provider.
- Kafka para generación de eventos de forma asíncrona para funcionalidades cómo la auditoría y trazabilidad de las operativas. Encaja como un guante con el modelo reactivo de Webflux.
- API Gateway que se encargará de autorizar y auditar las peticiones entrantes. 

  

### Pipeline

- Alojaremos el código en Github y aprovecharemos las Github Actions junto con [Skaffold](https://github.com/GoogleContainerTools/skaffold) para agilizar al máximo la entrega, el testing y el deployment continuo.
- Utilizaremos Gitflow como política de gestión de ramas apoyándonos en Pull Request para favorecer la democratización del conocimiento entre los miembros del equipo.


  

### Arquitectura de los microservicios

- Spring Boot 2.6.X y construido con Gradle para agilizar los tiempos de compilación y flexibilidad de tareas ad-hoc.
- Java 11 o Kotlin para tener mejor sinergia con el equipo de la App.
- Los microservicios estarán dockerizados utilizando la herramienta [Google JIB](https://github.com/GoogleContainerTools/jib)
- Descripción del API mediante OpenAPI 3 y AsyncAPI y generación de interfaces de entrada y salida mediante plugin de OpenAPI generator.
- Crearemos un arquetipo para crear nuevos microservicios con la misma estructura.
- Librería propia basado en filosofía Spring (gobierno de dependencias) que incluya una serie de starters para gobernar de forma homogénea las funcionalidades transversales entre todos los microservicios (seguridad, persistencia, comunicación, etc)
- Doble verificación de firmado de token JWT contra endpoint JWKS del servidor de autenticación.
- Trazabilidad entre microservicios con Sleuth y logado de peticiones entrantes/salientes e intermedias con  Logbook de Zalando.
-  Test unitarios definiendo una cobertura mínima y testcontainer para mockear sistemas en test de integración.
- El acceso a la persistencia lo haremos utilizando Spring Data Reactive Repositories utilizando el conector reactivo de MongoDB.

**Los microservicios podrán ser de orquestación, integración (Alastria, Tokenizer, IberPay, etc) o de dominio de negocio (gestión de usuarios, operativas, etc).*

## Riesgos

- Curva de aprendizaje de stack reactivo y blockchain o dificultad para encontrar perfiles con expertise.
- Descuido de la seguridad por falta de tiempo para desarrollar la POC.
- Alta complejidad en el caso de que se necesite tener transaccionalidad distribuida.
- Dependencia con servicios de terceros, tanto en disponibilidad cómo en cambios de interfaces.
- Requerimientos legales que vayan en contra de una solución tecnológica limpia .

## Equipo

-  Team Leader (será un perfil mixto entre Arquitecto y Desarrollador Senior que ayudará a diseñar y liderar al equipo desde el ámbito técnico. Hará la función de devops y diseño de la base de datos ) (1)
-  Scrum Master (1)
-  Desarrollador Android con dominio de Kotlin (1) 
-  Desarrollador iOS (1)
-  Desarrolladores Senior Back Java/Kotlin (2)
-  Desarrollador Blockchain (1)
-  QA con alto conocimiento de seguridad y pentesting (1)

## Cultura

Es fundamental que formemos un equipo cohesionado y motivado por el proyecto donde prevalezca una organización horizontal y la distribución transversal del conocimiento.

 Nos basaremos en metodologías ágiles usando el sentido común y solo haciendo las ceremonias imprescindible dado que tenemos un tiempo muy limitado. Debemos ser capaces de planificar y paralelizar correctamente el trabajo y ejecutarlo de manera autónoma una vez se tenga clara la solución.

Es muy importante mantener un alto estándar de calidad técnica en las soluciones generadas, aplicando para esto prácticas de Clean Code, documentando de forma continua, realizando tests.

Se trabajará en remoto pero se fomentará ir a la oficina algún día periódico para construir y mejorar la dinámica del equipo y el team-building.
