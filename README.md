#IoBuilders-POC

## Tecnología + Arquitectura

La arquitectura pensada para abordar este POC, es una arquitetura basada en microservicios ya que estos nos permiten trabajar en las diferentes funcionalidades de manera separada facilitando así la tarea de los desarrolladores. 

El lenguaje propuesto para el back-end sería Typescript, en concreto el entorno de NodeJs. Esta herramienta es muy utilizada en la industria y tiene la ventaja de utilizar el mismo lenguaje que utilizaremos en la parte front-end (comentado más adelante). Esto nos va a permitir que sea más fácil que un desarrollador front-end aporte a la parte back-end y viceversa. En cuanto a la base de datos a utilizar, sería una base de datos relacional como Mysql o SQL Server, ya que éstas tienen una estructura más rígida y resulta más útil para la información crítica con la que vamos a trabajar.

Por otro lado, para el desarrollo de la aplicación utilizaria React Native, ya que permite utilizar la misma base de código para las plataformas de Android/Apple. He elegido esta opción frente a realizar una apliación nativa para cada plataforma porque no es una apliación que requiera de un excesivo rendimiento, ni que utilice de manera muy demandante características avanzadas como el GPS de móvil. En cuanto el lenguaje, lo adaptaría para utilizar TypeScript, que, aparte de ser el mismo lenguaje que utilizaremos en la parte back-end, tiene la ventaja de permitir el tipado de datos, haciendo así que los modelos de datos utilizados en ambas parte coincidan y así hacer mucho más simple y fiable el desarrollo. Como queremos que los componentes puedan ser reutilizados utilizaremos styled-components para encapsular los estilos de cada componente.

Para la parte de blockchain se utilizará las tecnologías básicas que ahora mismo son estándares en la industria: el lenguaje Solidity para la programación de Smart Contracts, utilizando el entorno online Remix; la librería web3 para la conexión con la red y la funcionalidad ganache para la realización de pruebas en local.

En cuanto al control de versiones se utilizará Git, utilizando un repositorio privado basado en GitLab y se desarrollará un despliegue continuo con la herramienta Jenkins que comprueba que se pasen las pruebas unitarias y así asegurar el correcto funcionamiento de la apliación.

## Equipo

Para el desarrollo del POC se propone esta composición de equipo:

#### UX- UI

Una persona encargada de diseñar la interfaz y experiencia de usuario de la aplicación móvil.

#### Desarrolladores Fullstack

Tres personas encargadas del desarrollo back-end y front-end, estas personas son muy importantes porque tendrán el contexto entero del desarrollo y lideraran al resto de desarrolladores.

#### Desarrolladores Back-end

Tres personas encargadas al 100% en el desarrollo de las funcionalidades del back-end.

#### Desarrolladores Front-end

Tres personas encargadas al 100% en el desarrollo de las funcionalidades del front-end.

#### Desarrolladores Blockchain

Dos personas especializadas en el desarrollo de Smarth Contracts con Solidity y en desarrollo de Dapps.

#### QA

Una persona que realice pruebas del desarrollo para detectar errores (Esta persona se incorporaría en el tercer mes del desarrollo).


## Cultura

En cuanto a la metodología a utilizar, sería basada en Scrum, con reuniones diarias en las que se comente el avance de cada tarea. En estos casos los desarrolladores fullstack serán los encargados de organizar el equipo y planificar las tareas. Esto no quita que el resto de los desarrolladores no puedan aportar ideas y soluciones para tener más puntos de vista para abordar el proyecto. 

En cuanto a tecnologías, utilizaría Jira ya que es la herramienta que más conozco y tiene muchas características útiles para organizar equipos de trabajo, como una pizarra estilo Kanban.

Por otro lado, destacar que hay que tener siempre comunicación entre el equipo y también con otros posibles involucrados como el cliente en el caso de tener que adaptar el proyecto en un futuro.

Por último añadir que es importante también crear cultura de equipo realizando reuniones más informales por lo menos una vez por semana (ya sea presencial o de manera remota) en la cual se fortalezca el vínculo entre los desarrolladores.