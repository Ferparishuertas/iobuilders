# iobuilders

## Arquitectura
El ecosistema estará formando por dos aplicaciones:

Se creará una aplicación móvil para la parte visual y con la cual el usuario puede interactuar con ella. Dada la definición del problema y pensando en la posible escalabilidad de ella de cara al futuro y
al ser una parte 'core' de neustro producto, lo mejor sería oriantarlo a un diseño basado por componentes y teniendo especial cuidado con la separación de lo visual y de la lógica o funcionalidad más compleja.
Usaría también un diseño atomico para dividir dependiendo el tamaño de nuestros componentes y la composición entre ellos.

Con respecto a la parte back-end yo propondría usar un enfoque dirigido a microservicios, la razón para ellos es además de cumplir con principios SOLID también seguir Clean Code y buscando el reducir
al máximo todas las complejidades que conlleva una aplicación Fintech. A la hora de desarrollar y añadir nueva funcionalidad considero que teniendo este tipo de arquitectura únicamente usaremos la que demande la tarea que estemos
realizando sin necesidad de invertir tiempo de espera en ocasiones el tener que levantar toda la aplicación entera.

Por ejemplo, un servicio sería registro de usuario, otro servicio la BBDD y sus relaciones, otro servicio la creación de transacciones etc.


## Tecnología


Para la parte Front-End dada la tendencia actual optaría por usar React Native ya que React está en su auge y con un futuro prometedor y por ende React Native sería un framework que nos podría facilitar el desarrollo.
Ya que tenemos poco tiempo para desarrollar, optaría por usar una librería gráfica en mi caso Ant Design para el estilo de los componentes y no tener que rehacer la rueda, usar componentes ya testados y con mucho tiempo
invertido para su funcionamiento óptimo. Optaría por TS para el fuerte tipado que esto proporciona sin tener que usar librerías de terceros para JS.También usaría Redux para tener un estado y en concreto usaría saga ya que el usuario va a realizar mucha interacción con la app y lanzar acciones que deben ser controladas y gestionadas por este estado.

Añadiria eslint junto a prettier para definir unos estandares de desarrollo y usaría husky para lanzar hooks antes de cada commit y tener mejor organizado el trabajo.

Una pequeña inversión que puede facilitarnos la vida de cara al futuro y presente inmediato, es crear un sistema de diseño con Storybook, donde tengamos los componentes customizados, además de temas, fuentes etc,
acompañado de test unitarios, la razón es para poder compartir esto con el resto de equipos y mejorar la consistencia de como marca. Una vez terminando podríamos mantener una líbreria en NPM para su instalación.
Para ello el framework que usuaría es React Native Testing Library ya que es un framework que facilita mucho este tipo de testing.

Sobre el stack técnologico usariamos Java para el Back-End con Spring Boot para facilitar la creación de estos microservicios y usaria AWS para la computación que sea necesaria.
Aquí si intentaría tener tanto tests de unidad coomo test de integración priorizando los de unidad, debido al corto espacio de tiempo con el que contamos.

Intentaría aplicar TDD con esos test de unidad tanto en el Sistema de Diseño como en el Front ya que en un principio no añadiria por el momento test end to end al tener estos periodos de tiempo.
Sería algo flexible con la aplicación de TDD ya que en ocasiones necesitamos tener primero esa base funcional y principalmente por el tema tiempo y el desarrollo iterativo que queremos tener.

Para desplegar configuraría pipelines en GitLab ya que es bastante fácil y configurable el poder hacer deploys de una forma muy sencilla ya sea a stage o a producción.
Y que únicamente después de configurarlo con darle a un botón se haría el despliegue.

Cosas que tendría en cuenta una vez salidos a producción serían, añadir esos test de integración que nos faltaría, empezar a realizar test AB para mejorar la conversión y sobre todo seguir con buenas prácticas ya que este
proyecto seguirá creciendo con el paso del tiempo, añadir sonar para mejora de código y plantearse el uso de contenedores para levantar las aplicaciones.

## Equipo

El equipo estaría formando por los siguientes integrantes

- 1 PO/Product Manager dedicado a este proyecto
- 1 Tech Lead dedicado a este proyecto
- 1 Desarrollador front-end senior dededicado a este proyectodi
- 1 Desarrollador back-end senior dedicado a este proyecto
- 1 Desarrollador front-end intermedio/junior dedicado a este proyecto
- 1 Desarrollador back-end intermedio/junior dedicado a este proyecto
- 1 Diseñador UI/UX puede ser compartido con otro equipo
- 1 Especialista en Seguridad puede ser compartido con otro equipo
- 1 QA puede ser compartido con otro equipo

El PO/PM es el encargado de dar ese enfoque desde la parte de negocio
El Tech Lead sería el encargado de realizar los despliegues a producción y coordinar al equipo y aportar su experiencia.
Los desarrolladores seniors serán los encargados de revisar el código y validarlo, además de desarrollar funcionalidades.
Los desarrolladores juniors al igual que los seniors, aunque para realizar alguna subida a una rama para producción si deben pasar por el aprobado del senior.
UX, QA y especialista atienden más a la demanda y pueden estar en varios equipos de forma simultanea, lo ideal sería dedicados pero tampoco podemos realizar ese esfuerzo hasta no tenerlo comprobado.

## Metodología

Optaría por una metodologia de desarrollo SCRUM, las razones es porque al empezar un nuevo proyecto este tipo de proceso funciona muy bien para cohesionar al equipo y que todos sepan sobre que hace cada uno en que momento y
resolver problemas durante el desarrollo.

Tendría sesiones de retrospectiva, planning, dailies y unos sprints entre 2-3 semanas, para mí es muy importanto el poder tener este tipo de metodologia ya que la comunicación mejora muchisimo y la confianza entre el equipo.

## Cultura

En la empresa dentro del equipo creariamos sesiones online o presencial de Team Building para mejorar y continuar con el buen ambiente del equipo.
Permitiria el teletrabajo, aunque si recomendaria que en esas sesiones mensuales o bimensuales estuviera todo el equipo presente fisicamente. 
Yo he vivido con esta situación y aunque la gente y yo mismo en ocasiones se necesita ese trato humano real es posible crearlo con este tipo de eventos. También ofrecería seminarios a nivel de equipo front-back para compartir
parte del trabajo realizado como de forma trasversal al equipo front y al equipo back por separado, la razón de ello es por dar la posibilidad de que se conviertan en full stack o se especialicen y conozca más sobre su área.