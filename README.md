

#	Técnología y Arquitectura
## Arquitectura
Sistema cliente – servidor donde la parte cliente será una aplicación móvil híbrida lo que nos permitirá con un solo desarrollo tener un completo entorno multilplataforma (a futuro y tras la POC se podría considerar realizar desarrollos nativos) y la parte servidora se basará en una arquitectura de microservicios desplegados en nube pública.
Constará de un api Gateway que procesará todas las llamadas desde la parte cliente y proveerá la seguridad por token.
La comunicación entre los distintos microservicios se realizará a través de un bróker de mensajería
Toda comunicación será correctamente trazeada y almacenada para su monitorización y auditoría.
La gestión de acceso (autenticación + autorización) se realizará mediante el almacenamiento de los usuario registrado en un directorio activo y acceso mediante un SSO publico con autenticación de doble factor
Toda la información de carácter sensible estará correctamente cifrada y se mantendrán procesos automatizados de bloqueo y limpieza para el cumplimiento de las distintas normativas de seguridad.

## Tecnología
Para la aplicación móvil se usará algún framework de caracter híbrido que permita con un unico desarrollo poder desplegar en Android, IOS y Web. Existen varias alternativas en el mercado, opciones válidas, podrían ser Flutter o React Native.
En cuanto al backend, los desarrollos de los microservicios se realizarían en lenguaje Java mediante Spring Boot apoyandose en los distintos componentes del fwk (REST, DATA, etc.)
En cuanto al resto de componentes que intervendrían en el proceso como BBDD, Broker de mensajería, API Gateway, etc.. por defecto se usarían aquellos ofrecidos por el Cloud público elegido, pero en caso de preferirse no depender de estos servicios, tenemos opciones como MongoDB, Kafka, WSO2, etc..
Lo mismo ocurre en la parte de Autenticación y Autorización, dependerá del Cloud elegido, on premise, podríamos optar por soluciones como KeyCloack + LDAP

## Riesgos tecnológicos
Los principales riesgos identificados para esta POC son los siguientes:
+	Modelar correctamente la arquitectura del proyecto
+	Cumplimiento de las normativas de seguridad
+	Presión en los miembros del equipo por tiempos ajustados
+	Formación inicial necesaria para los miembros del equipo

#	Equipo:
De forma ideal, el equipo estaría compuesto por los siguientes miembros:
+ 1 Scrum Master
+ 1 Product Owner
+ 1 Jefe de proyecto
+ 1 Arquitecto de Software
+ 2 Programadores senior movilidad
+ 4 Programadores senior backend
+ 1 DevOps
+ 1 Experto en seguridad (Cloud y normativas)
+ 1 Diseñador UX
 
#	Cultura:
## Metodología
La metodología de trabajo se basaría en las siguientes propuestas:
+ Agile + SCRUM (JIRA)
+ IC/DC (GIT, GitHub, Jenkis, etc.)
+ API First
+ DDD
+ TDD
+ SOLID + Clean Code

## Valores
Los valores que queremos construir y que serán la base de la empresa son:
+ Transparencia
+ Posibilidad de trabajo remoto
+ Flexibilidad horaria
+ Fomentar el aprendizaje (Cursos, plataforma eLearning, etc.)
+ Fomentar el trabajo en equipo (Dinámicas de grupo)
