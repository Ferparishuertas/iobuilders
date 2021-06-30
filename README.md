# Tech + Arquitecture

La arquitectura software a desarrollar debería estar compuesta principalmente por una app móvil (Android e iOS) y por una API que ofreciera los diferentes servicios a las apps.
La solución propuesta debe ofrecer un sistema seguro, fiable y robusto. Se debe incidir en la seguridad, al tratarse de un sistema que opera con divisas, haciendo hincapié en la correcta identificación de los usuarios y la seguridad en las transacciones (wallet).
También hay que evaluar cómo tratar y almacenar los datos generados por el sistema debido a las leyes de protección de datos.

## API

Para la construcción de la API deberíamos considerar el lenguaje y framework que mejor se adaptaran para una arquitectura API RESTful y las operaciones que realizarán con otros sistemas.
Teniendo en cuenta que debemos priorizar la seguridad en el sistema, el tiempo que tardaríamos en desarrollar la arquitectura, la disponibilidad de determinadas librerías que pudiéramos necesitar para operar con otros sistemas y otros factores, elegiríamos un lenguaje y framework concreto.
En principio, podríamos escoger de entre los más populares, los siguientes:

- **.NET** : Core
- **Python** : Django, Flask
- **Java** : Spring
- **NodeJS** : ExpressJS
- **PHP** : Laravel

Personalmente, escogería el lenguaje y framework en el que mejor se desenvolviera el equipo de desarrollo al haber un límite de tiempo establecido de 4 meses (como se menciona en la sección posterior). Siempre y cuando la elección ofreciera la seguridad y robustez que buscamos en la arquitectura. El lenguaje Java y un framework como Spring podría ser una buena elección, debido a su popularidad de uso, documentación disponible y ofrecer un buen nivel en las características buscadas.
Habría que considerar también las herramientas para el testeo de la API como podría ser Postman, RapidAPI, Katalon o de integración continua, como Jenkins.


## Aplicación móvil 

Una de las decisiones a tomar a la hora de desarrollar las aplicaciones móviles es la elección entre el desarrollo multiplataforma (Android e iOS) o el desarrollo nativo.
En esta decisión se debe valorar si debemos priorizar el ahorro de costes, tiempo y mantenimiento o por el contrario nos interesa enfatizar más el rendimiento de las apps
o experiencia de usuario.
En el caso que se nos presenta pienso que puede ser más interesante optar por un desarrollo multiplataforma por el tipo de app a desarrollar, donde la exigencia del rendimiento
del dispositivo no es tan relevante y si el tiempo de desarrollo, marcado por los plazos indicados.

**Frameworks para el desarrollo de aplicaciones móviles multiplataforma**

- *Basados en aplicaciones multiplataformas con compilación nativa*: Xamarin, Flutter
- *Basados en aplicaciones híbridas*: Apache Cordova, ionic 
- *Basados en JavaScript*: NativeScript, React Native

Personalmente, escogería un framework que permitiera el desarrollo de aplicaciones multiplataformas como Xamarin o Flutter que aprovechan además la ventaja de estar compiladas nativamente, lo que supone un mejor rendimiento de la app, y posiblemente mejor diseño de la misma.

# Team

Con la arquitectura software a desarrollar pienso que debería formarse un equipo de desarrollo liderado por un gestor de proyecto y dividido en dos grupos de trabajo. Uno de los grupos estará centrado en el desarrollo de la API y otro en el desarrollo de las aplicaciones móviles. Si se optara por el desarrollo nativo de las apps móviles y dependiendo de los conocimientos de los desarrolladores, podría ser necesario disponer de desarrolladores especializados en iOS y en Android.
En este caso, he considerado el desarrollo multiplataforma.

- 1 **Gestor de proyecto**. Será el encargado de coordinar el equipo de desarrollo, siendo a su vez el Scrum Master.
- 1 **Desarrollador Backend senior**. Experto en la creación de APIs RESTful. Enfocado en el core de la API, la seguridad y optimización.
- 2 **Desarrolladores Backend (API)**. Desarrollaran las diferentes funcionalidades de la API, operaciones con otros sistemas, etc…
- 1 **Desarrollador Backend senior (apps)**. Experto en la creación de aplicaciones moviles. Preferiblemente con experiencia en aplicaciones multiplataforma.
- 2 **Desarrolladores Backend (apps)**. Desarrollaran las funcionalidades de las aplicaciones móviles.
- 2 **Desarrolladores Frontend (apps)**. Desarrollaran la interfaz. Tendrían conocimientos de UX/UI.

Entre los desarrolladores deberian haber algunos expertos en ciberseguridad, testing y UX/UI.

# Culture

## Metodologías y herramientas

Al tratarse de un proyecto donde la innovación tiene un papel fundamental y en que el i+d ocuparía una parte del desarrollo, las metodologías agiles (como Scrum) son bastante adecuadas.
Permite realizar entregas de forma continuada y rápida. Minimizando los riesgos de que el proyecto no llegue en los plazos adecuados a los clientes, se estanque o que un algún planteamiento inicial de la arquitectura pudiera lastrar el desarrollo.
También hay que destacar que existe un plazo limitado a 4 meses de desarrollo, por lo que el Gestor de proyecto deberá prestar especial atención a los diferentes contratiempos que pudieran surgir.

Como he mencionado anteriormente sería necesario utilizar herramientas de testeo automatizado en la medida de lo posible y de integración continua.
Un sistema de control de versiones (Git, Mercurial, CVS, Subversion, etc…), como en cualquier otro proyecto.
Herramientas de apoyo para la gestión de proyectos, como Trello o Jira.

## Valores de empresa

En cuanto a los valores de empresa que personalmente me gustaría encontrar, se encuentran los siguientes:

- Buen ambiente de trabajo.
- Colaboración y trabajo en equipo.
- Plan de formación.
- Horario flexible y teletrabajo.
- Conciliación de la vida laboral, familiar y personal.
