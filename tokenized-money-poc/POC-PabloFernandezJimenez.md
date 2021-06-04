
#	Tech + Architecture

Para comenzar con esta prueba, lo primero que hay que decidir es qué estructura va a tener este proyecto. Al tratarse de una aplicación móvil, la solución que resulta más cómoda y óptima a mi parecer para esta herramienta es una solución software organizada en una arquitectura de tres niveles.

El primer nivel es el conocido como capa de datos, en la cual se alojará toda la información necesaria para desplegar la herramienta, esto quiere decir, toda la información de los usuarios (teniendo en cuenta la ley de protección de datos vigente) y los datos que se consideren necesarios sobre transacciones (p. ej. : un historial de transacciones que pueda consultar el usuario, entre otros). Este primer nivel se podría implementar mediante un sistema de base de datos MySQL, el cual se apoya en un modelo de base de datos relacional, es decir, los datos se alojan en diferentes tablas en lugar de un único fichero, lo que nos proporciona una mayor organización. Este sistema de BBDD es recomendado debido a que no requiere una máquina de alto rendimiento para ejecutar consultas y, también, debido a su facilidad para instalar y configurar la propia base de datos.

El segundo nivel se conoce como capa de negocio. Este nivel también se conoce como back end. En este nivel se implementará una API REST en un servidor al cual los usuarios realizarán las diferentes peticiones que necesiten (el servidor recibirá peticiones HTTP). Pueden implementarse servidores basados en diferentes lenguajes de programación: PHP, Python, Java, etc. Para desarrollar esta herramienta se opta por una solución basada en JavaScript, Node.js, debido a que es un entorno ligero y en el que la compilación se realiza en tiempo de ejecución, por lo que obtenemos una mayor celeridad para apreciar los cambios realizados en el código fuente. Además, Node.js posee un alto rendimiento en herramientas que requieran ejecución en tiempo real, como es nuestro caso. 
El servidor se implementará mediante Express, que es un framework de Node.js, que permite implementar de una manera cómoda y sencilla microservicios. Una de sus características más llamativas es la posibilidad de añadir un procesamiento de peticiones middleware, por ejemplo, en el caso de que el login del usuario en la aplicación se realizará mediante autenticación basada en token, proporcionando una mayor seguridad a nuestra API establecida en el servidor y, por tanto, a nuestra herramienta.

El tercer y último nivel, se conoce como capa de presentación, conocido como cliente, o front end. Para esta herramienta se ha decidido desarrollar una aplicación para smartphone para iOS y Android. Debido a esto, se ha optado por el framework Flutter, que se trata de un SDK de Google de código abierto para desarrollar aplicaciones basadas en una UI. La ventaja más importante de este framework es que genera código nativo para cada plataforma, lo que quiere decir que a raíz del mismo código fuente generado se puede desplegar en ambos sistemas operativos, iOS y Android. Es una alternativa más moderna a JavaScript para la capa de presentación y se basa en el lenguaje Dart, que es sencillo de aprender ya que su sintaxis es bastante clara. Se ha optado por Flutter en lugar de React Native (que es uno de los frameworks más utilizados para desarrollar este tipo de aplicaciones) ya que, en cuanto a rendimiento, Flutter tiene ventaja ya que está compilado con bibliotecas nativas ARM o x86, lo que hace que sea realmente rápido. Otra de las grandes características de Flutter es la manera de presentar la interfaz de usuario. Es un framework basado en widgets y contiene dos colecciones de widgets: una colección llamada Material Design widgets que implementa los componentes de Google con el mismo nombre, por lo que a los usuarios de Android les resultará bastante familiar esta interfaz, y, otra colección llamada Cupertino widgets que imita el diseño de las aplicaciones de iOS. 

Es por esto, que considero Flutter un gran framework para realizar esta herramienta, ya que los usuarios van a conocer los componentes que forman la interfaz de usuario, ya que son los propios utilizados por iOS y Android.

Además, en esta arquitectura de 3 niveles, se incluirá un sistema de logging para registrar los eventos que se consideren necesarios y aquella información relevante en un sistema de ficheros.



#	Tech Risks
· Encontrar una arquitectura que funcione de manera óptima. Principalmente, que se realicen de manera correcta las peticiones que sean asíncronas y se siga un flujo de trabajo predefinido al realizar el diseño de los diferentes microservicios que se vayan a implementar en la herramienta.

· Hay que estar muy pendiente de la normativa vigente en cuanto a protección de datos de los usuarios. También, al tratarse de una herramienta es una wallet, hay que ser muy meticuloso con la seguridad que se implementa en la herramienta, por ello considero necesario realizar pruebas de penetración, más conocidas como pentesting, una vez se haya desarrollado la herramienta para poner a prueba la seguridad y prevenir posibles ataques en el futuro.

 
#	Team

· 1 Project Leader encargado de dirigir y gestionar el proyecto, así como los diferentes ciclos o sprints del proyecto (ya que como explicaré en el siguiente punto, la metodología que elegiría para este proyecto sería scrum)

· 2 desarrolladores para la capa de presentación que tengan conocimiento en Flutter. Considero que mínimo deben ser 2 desarrolladores ya que siempre está bien tener un feedback para resolver posibles dudas que puedan surgir a lo largo del proyecto.

· 3-4 desarrolladores para la capa de negocio con conocimiento en Node.js. Considero que se deben añadir más desarrolladores para esta capa ya que es el core de nuestra herramienta y va a ser bastante más extensa. También es donde se va a incluir toda la seguridad de la herramienta por lo que viene bien tener un equipo amplio para desarrollar esta capa, ya que recordemos que la seguridad es clave para esta herramienta.


	Los desarrolladores serán los encargados de realizar las pruebas unitarias que se consideren necesarias al realizar la integración del proyecto.


· 1 experto en ciberseguridad, que será el encargado de realizar las pruebas de penetración mencionadas anteriormente, para comprobar la seguridad del sistema.

· 1 experto en interfaces de usuario con conocimiento en Flutter. Considero que es óptimo separar la parte del diseño de interfaz de usuario del desarrollo de la funcionalidad de la aplicación para acelerar el proceso de creación de la capa de presentación y asegurarnos una interfaz de usuario impecable, ya que hay que tener en cuenta que el usuario va a utilizar exclusivamente esta parte de la herramienta.

· 1 Encargado del tratamiento de datos personales con conocimiento en diferentes normativas para cumplir con la ley vigente.


#	Culture

Al tratarse de un proyecto de 4 meses, considero que la metodología ágil scrum es una que se ajusta bastante a las necesidades del proyecto, realizando así 8 sprints de 15 días cada uno, en el cual el Project leader decidirá las diferentes tareas a desarrollar por parte del equipo para cada sprint. De la misma manera, se realizará un seguimiento diario a través de las conocidas dailies.

En cuanto a la cultura de trabajo de la empresa, considero que es necesario un buen ambiente de trabajo, por lo que una buena posibilidad sería estrechar lazos mediante actividades de team building. También creo que es necesario un feedback por parte de los compañeros de equipo, para destacar las labores que se han realizado de manera óptima y dar ideas de cómo se pueden mejorar las que no han ido tan bien, siempre desde la amabilidad ya que un equipo rema en la misma dirección. 
Tener los errores como herramienta de aprendizaje. Todo el mundo comete algún error y no se debe machacar a alguien por ello, si no aprender del mismo y ponerlo en común para evitar repetirlo en un futuro.
Fomentaría el horario de trabajo flexible ya que considero que hay múltiples circunstancias en las que a algún compañero le viene bien entrar un poco más tarde, siempre y cuando se respeten los horarios de reuniones.
Fomentar el aprendizaje activo, ya que este sector se renueva muy rápidamente y siempre hay cosas nuevas que se pueden aprender. Creo que el promover determinados cursos o formaciones en diferentes tecnologías proporcionaría un mayor conocimiento a los empleados y, por tanto, un mayor abanico de soluciones para las implementaciones.
