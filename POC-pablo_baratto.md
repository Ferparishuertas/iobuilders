# IoBuilders Tokenized Money

## Indice
[[_TOC_]]

## Alcance

  Construir una aplicación capaz de contener una wallet segura y agil, que permita ingesar dinero FIAT en la misma de una fo rma agil y segura.

### Modulos

Estructura de la aplicación

![](https://www.lucidchart.com/publicSegments/view/bbc8eda2-83c8-4971-90ea-184442d01643/image.jpeg)

- Integraciones
    Se requiere una integración para el sistema bancario. Se utilizará a travez de una Licencia de e-money provista, para pagos utilizaremos momopocket y para tecnologia bancaria inversis.
    - Para la base de la identificación y wallet se utilizará la propuesta de alastria
    Más info en Demo-Entidad (https://github.com/alastria/alastria-identity-entity) y Demo-Wallet (https://github.com/alastria/alastria-wallet/)

- Desarrollos
    - Conversión de tenencias FIAT a blockchain via Tokenizer
    - Almacenaje, tracking y monitoreo de todas las transacciónes de su cuenta omnibus
    - Ingresar tenencias mediante IBAN o targeta de credito.
    - Las transacciónes deven ser instantaneas

#### Notas

  * Al basarnos en la wallet de alastria y dado que es una poc, se utilizará parte del stack tecnologico propuesto, ionic, y se modificará luego de analizar la app para utilizar GraphQL como Api Gateway.

### Technologias

#### Diseño

 * Arquitectura Hexagonal

#### Backend

 * Lenguaje principal Groovy
 * Cola de mensajes para comunicacion entre servicios: Kafka. Esto permite tambien trazabilidad y seguridad de datos mediante servicios de auditoria.
 * Seguridad OAuth2, HTTPS (tls).
 * Tokenizer: Solidity
 * BBDD: MongoDB, DynamoDb, Postgresql, MariaDB (segun entorno)

#### Frontend
 * Wallet: GraphQL como API Gateway / REST. Base de datos SQLite encriptada
    * Usabilidad y diseño basado en los estandares de Android y iOS

### Testing y calidad

 * Testing: Jest, JUnit, JunitPerf 
 * Sonarqube para testing de calidad

#### Infraestructura

 * AWS
 * Entornos docker: linux alpine y/o debian segun requerimeinto
 * Backups: Aws Backups

## Team

 * 1 Arquitecto Senior + Product Owner. MicroServicios, groovy o java, JavaSCript, Orientacion al OpenSource. Al menos 5 años de experiencia desarrollo + arquitectura. 10 años experiencia.
 * 1 Experto BlockChain con Solidity. Al menos 2 años de experiencia
 * 2 Desarrollador backend: Groovy
 * 1 Senior Front + UX. Ionic, GraphQL, algo de diseño de UX. Conocimientos de encriptación y certificados. Deseable React Native. Al menos 3 años de experiencia
 * 1 Senior QA + Seguridad. 5 años experiencia
 * 1 DevOps AWS + Docker. Automatizaciónes: integracion continua (Jenkins). Deseable ansible, salt, bash, o algun otro lenguaje de deploy.

### Culture

 * Meotodologias Agiles
    * Sprint 2 semanas
 * Buenas practicas de Arquitectura
 * Buenas practicas de programación es la base de todo el equipo.
 * Test del 80% del desarrollo
 * Pair programming siempre que sea posible
 * Exposición de ideas en todo el grupo para transformarlo en equipo
 * Toda idea es aceptada, al construir una POC hay que arriezgarse un poco a probar enfoques diferentes, ya que va a ser la base de una empresa, tiene que ser dentro de lo posible disrruptivo y con posibilidades de crecimiento.
 * 100% remoto opcional

## Tools

 * Jira o Trello. Dependiendo del presupuesto.
 * GitLab
 * Se recomendaria Visual Studio Code como editor, ya que es muy bueno para realizar pair programming.
 