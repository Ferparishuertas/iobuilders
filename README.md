# ioBuilders

## Español

### _Arquitectura_

La arquitectura está orientada a ser una app de móvil (Android y iOS) y se optará por el Patrón **Modelo-vista-controlador**

### _Tecnologías_

- **FRONTED**: se utilizará React Native con un template de TypeScript para evitar posibles problemas de datos, para el testing hay que diferenciar que se quiere probar, es decir para los componentes lo mejor es usar [Test Render](https://reactjs.org/docs/test-renderer.html), para el conjunto total [React Native Testing Library](https://callstack.github.io/react-native-testing-library/) y para el end to end [Detox](https://github.com/wix/detox/). Para el estilo se usará SCSS.

- **BACKEND**: funcionará a través de contenedores Docker, donde se contendrá: **Django**, un Framework robusto de Python, el cual encaja muy bien con la modelo cascada de React, gracias a este framework se facilitarán varias tareas, como el testing que viene integrado o los middlewares que ofrece; **Node** para hacer encapsular los frameworks que su utilizará en el front; **MYSQL** como la base de datos por excelencia.

- **Smart Contracts**: se desarrollará en el lenguaje de Solidity ya que vamos a trabajar con Ethereum.

- **Versiones**: se habilitará un Git para que los integrantes puedan hacer pull request.

- **Metodología**: se utilizará Scrum la metodología más utilizada de agile.

### _Equipo_

Debido a que el proyecto se ha de entregar en 4 meses, el tiempo es un factor muy importante a tener en cuenta, por ello necesitaremos:

| Posición                       | nº de personas |
| :----------------------------- | :------------: |
| Jefe de proyecto               |       1        |
| Desarrollador senior FullStack |       1        |
| Desarrollador junior Backend   |       3        |
| Desarrollador junior Frontend  |       3        |
| Diseñador UX-UI                |       1        |

El jefe de proyecto es posible que también está encargada de otros proyectos por ello tendrá solo el rol de Scrum Master, el cual se reunirá con el equipo cada 2 semanas.

El desarrollador senior será el encargado de supervisar los cambios al git y ver como avanza el desarrollo de una manera más global.

También es posible añadir a una persona con conocimientos en criptomonedas que ayude con las funciones en Solidity.

### _Cultura_

Se buscará crear una cultura de compañerismo entre los miembros del equipo con reuniones por la mañana de lo que se hizo el día anterior y para resolver problemas que se hayan ido encontrando en el desarrollo.

En todo momento estará habilitado una plataforma de comunicación entre el equipo por si surge algo de urgencia que no pueda esperar al día siguiente.

Si el equipo se mantendrá más allá de los 4 meses, también se podría incentivar la posibilidad de hacer actividades extralaborales que fortalezcan las dinámicas de equipo.

## English

### Architecture

The architecture is oriented to be a mobile app (Android and iOS) and will opt for the **Model-view-controller** pattern.

### _Technologies_

- **FRONTED**: we will use React Native with a TypeScript template to avoid possible data problems, for testing we must differentiate what we want to test, i.e. for the components it is best to use [Test Render](https://reactjs.org/docs/test-renderer.html), for the total set [React Native Testing Library](https://callstack.github.io/react-native-testing-library/) and for the end to end [Detox](https://github.com/wix/detox/). SCSS will be used for styling.

- **BACKEND**: it will work through Docker containers, where it will contain: **Django**, a robust Python Framework, which fits very well with the React waterfall model, thanks to this framework several tasks will be facilitated, such as the testing that comes integrated or the middlewares it offers; **Node** to encapsulate the frameworks that will be used on the front; **MYSQL** as the database par excellence.

- **Smart Contracts**: it will be developed in the Solidity language as we are going to work with Ethereum.

- **Versions**: a Git will be enabled so that members can make pull requests.

- **Methodology**: we will use Scrum, the most used agile methodology.

### _Team_.

Due to the fact that the project has to be delivered in 4 months, time is a very important factor to take into account, that's why we will need:

| Position                   | number of people |
| :------------------------- | :--------------: |
| Project Manager            |        1         |
| Senior FullStack Developer |        1         |
| Junior Backend Developer   |        3         |
| Junior Frontend Developer  |        3         |
| UX-UI Designer             |        1         |

The project manager is likely to be in charge of other projects as well, so he/she will have only the role of Scrum Master, who will meet with the team every 2 weeks.

The senior developer will be in charge of monitoring changes to git and see how the development is progressing in a more global way.

It is also possible to add a person with cryptocurrency knowledge to help with the functions in Solidity.

### _Culture_

We will seek to create a culture of camaraderie among team members with meetings in the morning to discuss what was done the day before and to solve problems that have been encountered in the development.

At all times there will be a communication platform between the team in case something urgent arises that cannot wait until the next day.

If the team is to be maintained beyond 4 months, the possibility of extra-work activities that strengthen team dynamics could also be encouraged.
