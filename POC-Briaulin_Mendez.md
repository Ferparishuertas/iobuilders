# Io Builder

## Resumen

---

### **Introcucción**

Es necesario crear una aplicación móvil para convertir monedas fiduciarias en tokens y viceversa. Es requerido que la misma sea intuitiva, escalable y estable.

### **Contexto**

Al momento de elegir la tecnología con la que desarrollar una aplicación se debe tomar en cuenta múltiples factores: tiempos del proyecto, costo, capacidad técnica, las ventajas y desventajas de cada tecnología.

El desarrollo de aplicaciones móviles con tecnologías web ha revolucionado el mercado debido a que con estas tecnologías podemos aprovechar las caracteríasticas del desarrollo nativo además de toda las facilidades que nos ofrecen las tecnologías web.

La tecnología híbrida nació para reducir los costes, los tiempos, facilitar el aprendizaje y desarrollo de aplicaciones móviles, aportando también la posibilidad de crear webs con estos desarrollos. El desarrollo de aplicaciones híbridas tiene una curva de aprendizaje mucho más suave que el desarrollo nativo. Para desarrollos nativos se requiere tener conocimientos en lenguajes de programación como java, kotlin o swift, además de las herramientas y particularidades para IOS y android. Esto supone mayores costes al tener que contar con personal específico para cada plataforma, un aumento en el tiempo de desarrollo y tener que coordinar el diseño de manera que se asemeje lo máximo posible en ambas plataformas.

Es por esto que se decide hacer el desarrollo con tecnologías híbridas.

## Arquitectura

---

La arquitectura de software describe sus componentes principales, sus relaciones y cómo interactúan entre sí proporcionando una abstracción para gestionar la complejidad del sistema, estableciendo comunicación y coordinación entre componentes. Puntos claves:

- La arquitectura ayuda a definir una solución para cumplir con todos los requisitos técnicos y operativos, con el objetivo común de optimizar el rendimiento y la seguridad.

- EL diseño de la arquitectura implica la intersección de las necesidades de la organización y las necesidades del equipo de desarrollo. Cada decisión puede tener un impacto considerable en la calidad, el mantenimiento y el rendimiento.

**_Cliente - Servidor para la arquitectura del sistema_**

_Esta arquitectura funciona sobre un modelo de solicitud respuesta. El cliente envía la solicitud al servidor para obtener información y el servidor responde. La conexion entre el cliente y el servidor se producirá mediante una API Rest._

- **Back end:** Estará orientado a microservicios con una arquitectura hexagonal. Este tipo de arquitectura nos facilitará el mantenimiento, el desarrollo de funcionalidades y la escalabilidad. El objetivo de implementar esta arquitectura es hacer que los diferentes componentes de la aplicación sean independientes, ligeramente acoplados y fáciles de probar.

  - Desventajas:
    - Complejidad adicional.
    - Costo de creación.
    - No hay ninguna orientación sobre la organización del código.

- **Front end:** **Atomic Design** es la metodología escogida. Entre las ventajas de esta metodología está en que facilita la creación de la guía de estilo, permite hacer más rápido los prototipos, hace más rápido el proceso de actualizar el diseño del producto o añadir funcionalidades, menos componentes hará el diseño y el código más consistentes y eficientes, permite reutilizar átomos para crear cualquier diseño que se requiera, ayuda a escalar reduciendo costes, entre otras.

## Tecnologías

---

- **Front end**: **React Native** es un framework para crear aplicaciones híbridas que está basado en javascript. Actualmente es uno de los más populares y cuenta con una gran comunidad de desarrollo. Al ser híbrida nos ahorrará tiempo y dinero, al ser una tecnología con mucha popularidad será fácil contratar recursos humanos para el desarrollo, está respaldada por facebook por lo tanto nos da una garantía de que podremos generar un producto de calidad, tiene una comunidad muy activa y nos compila el proyecto en código nativo. Por todas estas razones react native es hoy en día la mejor alternativa para desarrollar la aplicación.

  - **Limitaciones:**

    - A pesar de las excelentes características, React Native está aun en versión Beta, es por esto que todavía tiene algunos problemas aparentes, como la complejidad de depurar aplicaciones. Hay que tener en cuenta que trabajar con esta tecnología puede resultar tedioso cuando surge la necesidad de depurar.

    - Aunque la experencia en javascript puede llevarnos lejos en el desarrollo, aun necesitamos conocimientos de algunos desarrollos nativos para implementar ciertas funciones de la aplicación.

    - La gestión de la memoria no es sobresaliente. Esto puede ocasionar algunos problemas cuando necesitemos realizar cálculos intensivos.

    - La adopción lenta de funcionalidades recientes. La innovación en tecnología móvill está de moda. Casi todos los modelos nuevos introducen funciones novedosas que necesitan nuevas actualizaciones de software para utilizarlas de manera eficiente. React native tiene un historial de brindar soporte para nuevas funciones de hardware, pero a menudo llegan tarde.

    - Los componentes necesarios para crear algunos tipos de aplicaciones faltan en react Native, por lo tanto, se deberá utilizar recursos de terceros para agregar estos componentes a la aplicación.

- **Back end**: Seleccionar la tecnología de backend adecuada es crucial para determinar el éxito del proyecto. Una tecnología de backend bien elegida puede garantizarnos la escalabilidad, la velocidad de funcionamiento, la seguridad y la respuesta instantánea a las necesidades de los usuarios. **Java** con **Spring Boot** es una de las tecnologías back end más poderosas que ocupa el segundo lugar según el índice **TIOBE 2021**. Es altamente escalable porque permite numerosas instancias a las solicitudes del servidor, nos permite manejar todas las solicitudes en hilos independientes gracias a un servidor multiproceso. Con esta función de multiprocesos podemos optimizar mejor los recursos de la CPU. Tiene una gran variedad de código abierto, java ofrece excelentes funciones para superar los riesgos de seguridad.

  - **Limitaciones:**

    - Consume más tiempo y memoria.
    - Java no ofrece control sobre la recolección de basura, y también falta el soporte de programación de bajo nivel en java.
    - Debido al elevado coste del hardware, puede resultar caro utilizar java.

- **Base de datos**: Escoger una BD adecuada tiene una importancia crítica para el posible éxito del proyecto. Antes de escoger una BD conviene preguntarse cual de todas puede cumplir mejor con nuestros requisitos: ¿qué cantidad de datos vamos a almacenar cuando la aplicación esté madura? ¿cuantos usuarios se van a conectar de forma simultánea en hora punta? ¿qué disponibilidad, escalabilidad, latencia, rendimiento y consistencia de datos necesitamos para nuestra aplicación? ¿cual es la distribución geográfica de los usuarios? etc... La que más se adecua a nuestras necesidades es **PostgreSQL** porque nos brinda una gran usabilidad, más opciones respecto a la competencia, nos da una gran escalabilidad, es open source, entre otras cosas. Es la mejor opción ya que requerimos de una base de datos robusta y con muchas consultas largas y frecuentes. La frecuencia será un punto importante para nuestra aplicación. Sin embargo hay algunos puntos a tener en cuenta:

  - Aunque sus 20 años de desarrollo activo y constante mejora nos proporciona mucha estabilidad y confiabilidad, no cuenta con un soporte en línea o teléfono.
  - La sintaxis de algunos de sus comandos o sentencias puede llegar a no ser muy intuitiva si no tienes un nivel avanzado de conocimientos en lenguaje SQL.

- **Blockchain:** **Solidity** es la tecnología escogida por su rápido crecimiento. Fue desarrollado principalmente por el equipo central de Ethereum que es en la plataforma de cadena de bloques en la que se basan la mayoría de contratos inteligentes. Posibles inconvenientes:
  - Poca o nula experiencia sobre la tecnología.
  - Pocos especialistas en el mercado haciendo de esto un costo elevado el poder contar con uno.

## Equipo

---

Para el desarrollo del POC se necesitarán profesionales experimentados en las distintas áreas:

- Un diseñador UX encargado de diseñar las vistas y dar la mejor experiencia de usuario.
- Un desarrollador Full Stack senior que funja como tech lead para que lidere el equipo tanto de back como de front.
- Dos desarrolladores back end.
- Dos desarroladores front end.
- Un especialista en Blockchain.
- Un QA para que realice todas las pruebas necesarias y pueda detectar errores en el desarrollo.
- Un PO encargado de organizar las tareas de cada miembro del equipo de desarrollo.
- Un especialista en seguridad.

## Metodología

---

Scrum es un modelo de desarrollo de _software_ que posibilita paso a paso establecer de manera exitosa y organizada los proyectos. Puntos fuertes de esta metodología:

- Ayuda a ahorrar tiempo y dinero.
- Fomenta el trabajo en equipo.
- Se adapta a la empresa.
- Es de fácil manejor.
- Otorga respuesta rápida a los cambios.
- Las pruebas funcionales son frecuentes en el proceso.
- Hace que el cliente colabore directamente con el equipo de desarrollo.
- Otorga motivación y responsabilidad en los equipos.

## Cultura

---

El equipo debe tener una cultura _agile_. Es un modelo de desarrollo colaborativo basado en frecuentes entregas incrementales e iterativas con feedback. Todas las personas de cada equipo son responsables de identificar los vacíos e ineficiencias en las actividades del día a día y estarán habilitadas para sugerir mejoras que puedan aplicarse en su área. Trabajarán juntos para resolver problemas. El proyecto se realizará en 16 sprints de una semana cada uno. Se establecerán reuniones diarias de no más de 15 minutos para que cada miembro del equipo pueda realizar una breve síntesis de lo que cree más importante para lograr sincronizarse con el resto de sus compañeros. En el último día de sprint se hará una breve demostración de lo logrado hasta la fecha y luego una reunión de no más de 2 horas de lo que se ha hecho bien y en lo que ha fallado en el sprint en curso y qué debemos mejorar en el sprint siguiente.

**_Fuentes:_**

- https://medium.com/@ktufernando/la-gu%C3%ADa-definitiva-de-la-arquitectura-del-software-f419db9c6bf7
- https://blog.back4app.com/es/las-10-mejores-tecnologias-de-backend/
- https://blog.back4app.com/es/react-native-ventajas-y-desventajas-reveladas/
- https://www.uifrommars.com/atomic-design-ventajas/
- https://www.youtube.com/watch?v=VwcdgONc-r4&ab_channel=CanariasJS
- https://guiadev.com/postgresql-vs-mysql/
- https://www.blockchaines.tech/tutoriales/guia-para-principiantes-de-la-programacion-en-blockchain/
- https://invidgroup.com/es/4-razones-para-utilizar-scrum-la-hora-de-desarrollar-software/
