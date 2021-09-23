# Tech + Architecture

En primer lugar utilizaría arquitectura basada en cliente-servidor

La aplicación móvil (cliente) se encargará de interactuar con el usuario y de formular las solicitudes al servidor y recibir su respuesta, por lo que deberá encargarse de una parte de la lógica de la aplicación y de realizar algunas validaciones de forma local.
                                   
En el lado servidor, lo plantearé distribuido entre varios microservicios que cubran las necesidades funcionales desde un punto de vista atomico. 

La comunicación entre cliente-servidor en general se utilizará servicios REST, aunque en casos especiales podria ser útil usar websockets.

### Frontend

Uno de los requisitos es que la aplicación sea compatible tanto para iOS como para android, por lo que las posibilidades que hay son hacer un desarrollo nativo para cada una de las plataformas (por tanto dos desarrollos) o hacer un desarrollo híbrido.
El desarrollo nativo aprovecha más el potencial del teléfono y sistema operativo, puede aprovechar funciones exclusivas de un modelo o de su SO, pero como problema principal tiene el sobre coste de tener que desarrollar para dos sistemas diferentes (problemas: mantener luego dos proyectos diferentes, desarrolladores iOS, desarrolladores android, normalmente no los hay con las dos cualidades)

El desarrollo híbrido nos puede solventar los problemas del nativo, pero nos penaliza en el rendimiento y el aprovechamiento de las funciones exclusivas del SO. 

En los ultimos años los frameworks para desarrollo híbrido se han ido puliendo y consiguiendo cada vez estar más cercano al desarrollo nativo tanto como en rendimiento como en diseño. Además los sistemas operativos también han ido mejorando lo que estaba en su mano para favorecer este desarrollo nativo.
Ionic o React Native son dos muy buenas alternativas, en este caso Ionic por funcionar sobre angular permite que desarrolladores mas cercanos al backend puedan manejarse con soltura con una curva de aprendizaje relativamente rápida pero su rendimiento puede llegar todavía a no ser el mejor,
sin embargo React Native utiliza los componentes nativos del SO y proporciona mayor rendimiento. Además utiliza javascript, el lenguaje más extendido entre los desarrolladores front y en los últimos años parece que tiene más recorrido que ionic. Como contra React Native está enfocado para desarrollar las aplicaciones en móvil (iOs y android) y Ionic se puede también utilizar el desarrollo desplegar la aplicacion como herramienta web, pero al no ser este un requisito de esta poc me decanto finalmente por React Native. 


### Backend

El back lo plantearía como un conjunto de microservicios desarrollados en spring-boot. Este planteamiento nos permite que otros desarrollos de iobuilder puedan utilizar nuestros componentes en microservicios.

Respecto a spring-boot es un framework muy asentado y estable y no es difícil encontrar desarrolladores con mucha experiencia y pericia. Las plataformas de cloud están perfectamente preparados para esta arquitectura y automatizar el despliegue y la orquestacion de ellos de forma ágil.
Complementaria este conjunto de microservicios, con alguna función especial concreta que se pudiese desarrollar como función serverles, ya bien sea en google fuctions o en amazon lambda.

El despliegue lo realizaría mediante kubernetes en alguna de las nubes publicas (gcloud, aws o azure) enfocandolo como IaaS y utilizarían terraform para gestionar los recursos necesarios de estos micros.

Para toda la monitorización, trazabilidad y auditoria de eventos estas nubes proporcionan herramientas para realizarlo de forma fácil y poder luego obtener o trabajar sobre esos datos. 

Si que haría un esfuerzo en generar una buena infraestructura que permitiese CI/CD, con git, jenkins (o google build) y analizadores de código (SonarQube, Kiuwan...)

# Team

- 1 analista funcional con experiencia en blockchain (y regulación legal)
- 1 experto UI/UX expert
- 2 desarrolladores frontend (con conocimientos react)
- 1 desarrollador fullstack (con conocimientos react y spring-boot)
- 2 desarrolladores back (con conocimientos spring-boot y alguno de ellos conocimientos en blockchain)

La función de scrum master, al menos en los cuatro meses de la POC, la realizaria de forma temporal y cíclica entre los integrantes del equipo.
Cada sprint sería uno el encargado, aunque si vería interesante que los dos primeros sprints tomasen este rol el analista funcional y el experto UI/UX
mientras los desarrolladores analizan y diseñan la plataforma. 

Respecto la metodología usada aplicaría scrum, metodología que para un POC o para una puesta en producción rápida nos aporta grandes ventajas y el desarrollo lo enfocaría mediante TDD

# Cultura

Trabajaría la transparencia e intentaría mostrar continuamente hacia donde va el producto, cual es su objetivo y que quiere aportar. Creo que de esta manera el equipo se siente mucho más motivado e implicado. 

Implicaría en las primeras fases del análisis a todo el equipo ya fuesen analistas o desarrolladores, ect. >>brainstorming<<.  Creo que fomenta también la motivación a medida que pasen los sprints.

Fomentaría un buen ambiente de trabajo, ayudando dentro de lo posible a mejorar las condiciones (confianza, conciliación, flexibilidad) y el entorno de los equipos. 

Fomentaría las actividades fuera del ambiente laboral, como paintball, karts, barbacoa, etc.

*Hago mucho hincapié en la motivación porque creo que es el aspecto fundamental para sacar lo mejor de cada miembro del equipo.
