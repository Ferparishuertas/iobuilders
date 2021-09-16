# IOBuilders - POC

En este documento se recoge toda la información sobre el análisis y la documentación necesaria para el desarrollo de la solución del problema planteado.

## 1. Tecnologías y arquitectura

Algunos de los riegos que tenemos que tener en cuenta para desarrollar el proyecto son:
- **Tolerancia a fallos y disponibilidad**, nuestro sistema tiene que ser robusto para mantener una disponibilidad 24/7 de nuestros servicios.
- **Escabilidad**, porque la cantidad de usuarios que utilizaran la aplicación ira aumentando con el tiempo, así que tenemos que aumentar los servicios acorde con el número de usuarios.
- **Seguridad e integridad**, debido a que estamos trabajando con dinero real y con criptomonedas, así que tenemos que garantizar unos buenos niveles de seguridad para que los usuarios confíen en nuestro producto.

En cuando a la arquitectura me basaria en utilitzar una arquitectura hexagonal, en la cual dividiriamos en distintos bloques el proyecto para así disiminuir esas dependencias entre ellos y poder desarrollar sin depender de otro bloque del proyecto. Esta arquitectura además, nos permitirá realizar el control de calidad de cada bloque de manera independiente a partir de test de caja negra. Estos bloques serian:

- **a. Aplicación móvil**

Esta parte es la que contendria todas la tareas relacionadas con el desarrollo de la aplicación móvil. Es muy importante tener en cuenta que tiene que ser una aplicación intuitiva y sencilla para el cliente y que se pueda usar en diferentes plataformas.

- **b. Wallet**

Este es una de los bloques más importantes, ya que tenemos que elegir una Wallet con la cual ejecutar todos los servicios de pago y de criptomonedas. Así que tenemos que hacer que la aplicación pueda utilizar alguna de estas Wallets, alguna posible idea seria utilizar MetaMask debido a su fácil utilización e interpretación.

- **c. Servicios de pago**

Una de las funcionalidades es relacionar el aplicativo con un sistema bancario, para ello será necesario conectar nuestra solución con un servicio de pago para hacer las pertinentes transferencias como una plataforma bancaria o con PayPal.

- **d. UX**

Una de las características principales es el diseño y usabilidad de la aplicación, así que es necesario desarrollar un análisis exhaustivo de distintos diseños para así elegir cuál es el más conveniente.

En cuando a las tecnologías que utilizaria serían:

- **React Native o Flutter:** Propondria utilizar alguna de estos lenguajes de programación debido a que son tecnologías que se encuentran en auge y que tienen un futuro prometedor. Además como queremos desarrollar una aplicación móvil híbrida que sea compatible en diferentes plataformas como Android y iOS, estos lenguajes nos permiten tener que desarrollar únicamente una vez y permiten un desarrollo muy rápido que nos permite ver los resultados de forma casi instantanea.

- **NodeJS:** Siguiendo con el uso de frameworks de JavaScript, de esta manera seria más fácil la implementación, ya que son lenguajes muy parecidos entre ellos. Propondria utilizar **NodeJS** para crear toda la parte del **Back-end**, debido a su elevada documentación y porque esta centrado en microservicios, también contiene muchas librerias que nos facilitarian el trabajo como **Express**.

- **Server:** Necesitamos un servidor Cloud donde desplegar nuestro proyecto, para ello propondria el úso de alguno de los proveedores más conocidos como **AWS**, **Google App Engine** o **Azure**. Aún así, me decantaria por **Azure**, ya que te permite elegir entre un escalado horizontal, vertical o automático y dispone de una mayor cantidad de frameworks (Django, Cakephp) y de infraestructura (14 centros repartidos en todo el mundo).

- **Smart Contracts:** En cuando a la parte relacionada con **Ethereum**, me centraría en el desarrollo de un **smart contract** que nos permitiria hacer las diferentes funcionalidades relacionadas con las transferencias y el intercambio de tokens. Para ello utilizaria **Solidity** que es uno de los lenguajes más comunes y fáciles de utilizar para la creación de estos contratos. De esta manera no solo desarrollariamos los contratos, sino que también podriamos crear distintos tests para comprobar el correcto funcionamiento.

## 2. Equipo

Se nos marca un plazo de 4 meses para desarrollar el proyecto. Teniendo en cuenta su importancia y su carga de trabajo, nos centraremos en el equipo necesario para la web, API, aplicación y control de calidad.

- **Scrum Master/Project Manager**
- **Analista QA** (Puede formar parte de otro equipo)
- **Desarrollador Blockchain con bastante experiencia** (Estará involucrado en tareas de seguridad)
- **2 Desarrolladores Front-end** (Uno senior como mínimo)
- **2 Desarrolladores Back-end** (Uno senior como mínimo)
- **Desarrollador Full stack**

El equipo estaría formado por un total de 7 trabajadores y un jefe de equipo. El jefe de proyecto sería el encargado de dar ese enfoque más relacionado con la parte de negocio y de coordinar el equipo con la metodología elegida. Luego tenemos un analista QA que sería el encargado de realizar los test y las pertinentes pruebas de calidad, puede que no sea necesario que esté solo dedicado a este proyecto. También encontramos a los pertinentes desarrolladores Back-end y Front-end para toda la parte de desarrollo de la interficie y el servidor. Un desarrollador FullStack que daría soporte tanto en las distintas tareas según la necesidad y un desarrollador blockchain para toda la parte técnica y relacionada con la seguridad.

## 3. Cultura

Para este proyecto es muy importante tener un buen ambiente de trabajo y una buena comunicación, por ello creo que la metodología más ideal sería una metodología ágil como **SCRUM**. Debido a que es una forma de trabajar que plasma la esencia de la empresa en la cual todo el mundo es importante y también es una metodología que se suele usar en otros proyectos, así que la gente ya la conocerá. Con ella Para este proyecto es muy importante tener un buen ambiente de trabajo y una buena comunicación, por ello creo que la metodología más ideona sería una metodología ágil como **SCRUM**. Debido a que es una forma de trabajar que plasma la esencia de la empresa en la cual todo el mundo es importante y también es una metodología que se suele usar en otros proyectos, así que la gente ya la conocerá. Con ella vamos a hacer Sprints de 1 o 2 semanas para el desarrollo del proyecto en pequeñas tareas. Al finalizar este periodo, se realizarán reuniones con las cuales se va a comentar el estado de las tareas para controlar el correcto desarrollo y para poder cumplir con los plazos estimados de tiempo.

Sería importante utilizar alguna herramienta para tener un control de las diferentes tareas y controlar el tiempo dedicado a cada una, así también para controlar las diferentes versiones del código. Una buena idea sería el uso de **GitHub** o **Jira** para así realizar este control del desarrollo, minimizando así los errores y posibles vulnerabilidades. Para el control de tareas sería buena idea utilizar **KanBan** o **Trello** para así separar las tareas que se tienen que realizar y las que se están desarrollando en este momento.

Para crear un buen ambiente de trabajo realizaría sesiones recreativas fuera del horario laboral para mejorar esa confianza entre trabajadores y crear química entre ellos. Permitiría flexibilidad en la presencialidad a la oficina para que todo el mundo estuviera cómodo y contento, porque hay gente que rinde más en su espacio de trabajo personal. Aún así obligaría a ir un mínimo de 2 días a la oficina para crear equipo y fortalecer las relaciones.SEGUIR AQUÍ

Para crear un buen ambiente de trabajo realizaría sesiones recreativas fuera del horario laboral para mejorar esa confianza entre trabajadores y crear química entre ellos. Permitiría flexibilidad en la presencialidad a la oficina para que todo el mundo estuviera cómodo y contento, porque hay gente que rinde más en su espacio de trabajo personal. Aún así obligaría a ir un mínimo de 2 días a la oficina para crear equipo y fortalecer las relaciones.
