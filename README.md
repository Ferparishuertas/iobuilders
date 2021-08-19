# iobuilders

# Objetivo

    Este documento va dirigido a plantear las bases sobre las que se cimentará un futuro POC de 'Tokenized Money'. El cual permitirá transacciones entre moneda FIAT y Tokens de manera rápida, segura y confiable.

# Elementos a utilizar o diseñar

    1. Aplicación movil (Front End)
    2. Servicios necesarios (Back End)
        - Servicios a consumir
            -Alastria
                -Proveedor de Carteras e Identidades con protocolo ERC20
            -Inversis
                -Proveedor de la tecnología bancaria
            -Momopocket
                -Proveedor del servicio de pago que asegure y facilite la gestión de las transacciones cliente - aplicación
        - Servicios a crear
            -Tokenizer:
                -Servicio que permita la conversión confiable y segura entre moneda Fiat y Token, y viceversa.
            -Base de datos:
                -Necesaria para almacenar los datos de usuarios que sean imprescindibles para el funcionamiento de la plataforma, así como para el apartado jurídico de la misma.

# Tecnologías a utilizar:

    Front-End:
    
        Debidas nuestras necesidades, y plazos estimados, a pesar de que en otros muchos casos podrían haberse creado equipos separados que desarrollen cada una de las plataformas que queramos considerar, en este caso IOS y Android, creo que una buena opción es utilizar tecnología en el Front que nos permita trabajar en dichas plataformas simultáneamente sin tener que crear duplicidades de código o especificaciones únicas (más que las necesarias) para cada plataforma.
	
	    Esto nos lleva a aquellos frameworks o librerías centradas en componentes nativos y reutilizables. Dado que la empresa tiene otros proyectos que actualmente ya trabajan con frameworks que encajan en estas necesidades, para agilizar aún más el proyecto, sería cuanto menos conveniente tener en consideración React Native para esta tarea.

	    Existen otras tecnologías a considerar como pueden ser Vue o Angular. Pero dado el escaso tiempo que tenemos para la creación del POC, considero lo más sensato intentar reutilizar la mayor cantidad de tecnología ya desarrollada. Además, en comparación con Vue nos permitirá encontrar más rápidamente empleados en caso de que el proyecto siga adelante.

	    Si bien, dado lo sensible de los datos a manejar, así como las operaciones y transacciones, considero que lo mejor será utilizar TypeScript como lenguaje sobre el que desarrollar el Front-End. Añadiendo el fuerte tipado necesario para minimizar las incidencias.

	    En cuanto a estilos, si bien StyleSheet podría ser suficiente considero que es valorable introducir StyledComponents, puesto que es una solución bastante eficiente y que a posteriori es más limpia y rápida de leer y cambiar para los desarrolladores.

    -Conclusión:
        -Considero que las opciones más interesantes y óptimas para el desarrollo son: React Native con StyledComponents sobre TypeScript.

    Back-End:

        Debido al corto periodo de tiempo que tenemos para la finalización del POC, considero necesario poder aunar fuerzas en los distintos momentos del desarrollo. Si bien dentro del equipo habrá personas encargadas de aspectos concretos del proyecto, sería interesante que todos pudieran manejarse correctamente en el cómputo global del mismo.

        Para ello considero que mantener un mismo lenguaje de programación en ambas partes (Back y Front) podría ser una ventaja. A esto hay que añadir que Solidity, el lenguaje por excelencia para la implementación de Smart Contracts en ERC20, está inspirado, entre otros, por JavaScript, lo que facilita el aprendizaje para aquellos desarrolladores que no conozcan esta tecnología..

	    Como ya habíamos expuesto antes, TypeScript puede ser utilizado para crear aplicaciones en React, añadiendo el tipado fuerte que tanto se echa de menos en el JavaScript común.

	    Todo lo anterior nos indica que lo más inteligente sería utilizar Node.Js. Este entorno de ejecución nos permitiría crear los servicios necesarios para gestionar la aplicación e integrar los servicios que necesitamos consumir para la misma.

	    Debido a lo sensible de los datos a manipular, y que algunos de ellos están protegidos bajo la RGPD, considero más inteligente darle prioridad a la seguridad añadida que suponen las distintas herramientas que pone a nuestra disposición SQL.

	    Una vez elegidas las herramientas, deberíamos plantear las diferentes arquitecturas que podemos construir para cubrir los requerimientos. 

        En este caso, dado que ya hemos estructurado correctamente los distintos procesos que debemos atender y consumir, podríamos fácilmente encarar el desarrollo hacía una estructura de microservicios. Lo cual también influye en la mejora de una escalabilidad futura. Sin embargo, no debemos perder nunca de vista los ‘peros’ que está arquitectura trae, como el manejo de la caída de los distintos servicios.
    
    -Conclusión:
        -Considero que el desarrollo del Backend debería ser en el entorno de Node.Js utilizando TypeScript y con una base de datos SQL como MariaDB o MySQL.

# Equipo

    - 1 Product Manager / Scrum Master
    - 2 Senior Full Stack Engineer
    - 2 Junior Full Stack Engineer
    - 1 UX/UI Designer
    - 1 Senior Back End Engineer
    - 1 Devops Engineer

# Cultura

    -Test
        - Todo el desarrollo debería ir enfocado hacía la implementación de Test de todo tipo, desde tests unitarios hasta End-to-End. Esto se debe mayoritariamente a los beneficios derivados de los test unitarios para la empresa. Un error a la hora de desarrollar pequeñas piezas de codigo son comunes, suelen solucionarse rápidamente. Sin embargo, hemos de estimar que el gasto tanto de tiempo como de dinero para la empresa es mucho menor cuando hablamos de test unitarios en comparación con los que supondrían arreglar aquellos errores que afecten posteriormente al funcionamiento de la plataforma. Para esto utilizaremos Jest para los test unitarios y de integración y dejaremos Cypress para los test End to End.
    -Metodologias ágiles
        - Dada la necesidad de cumplir con los plazos, considero prácticamente obligatorio la implementación de metodologias ágiles para mejorar el rendimiento general de todo el equipo. Actos como las 'daily' son muy importantes a la hora de fomentar la comunicación del equipo. Se podría, además, implementar un sistema de Sprints que dividan de forma eficiente la carga de trabajo. Jira es una gran herramienta para la implementación de estas metodologías.
    -Trabajo en equipo
        - Creo importante el crear lazos en el equipo, así que fomentaría un ambiente de trabajo en el que todos los desarrolladores tengan la confianza y seguridad de preguntar, contribuir y proponer ideas. Tal vez sea recomendable fomentar reuniones fuera del trabajo.

-----------

# Objective

    This document aims to lay the foundations for a the Tokenized Money Feature. It will enable transactions between FIAT currency and Tokens in a fast, secure and reliable way.

# Elements to be used or designed

    1. Mobile application (Front End)
    2. Services needed (Back End)
        - Services to be consumed
            -Alastria
                -ERC20 protocol wallet and identity provider
            -Inversis
                -Banking Tech provider
            -Momopocket
                -Payment service provider securing and facilitating the management of transactions between customer and application.
        - Services to be developed
            -Tokenizer:
                -Service enabling reliable and secure conversion between FIAT currency and token.
            -DataBase:
                -Necessary to store user data that are essential for the operation of the platform, as well as for the legal section of the platform.

# Technologies to use

    Front-End:
        
        Due to our needs, and estimated deadlines, although in many other cases separate teams could have been created to develop each of the platforms we want to consider, in this case IOS and Android, I think a good option is to use technology in Front that allows us to work on these platforms simultaneously without having to create duplicate code or unique specifications (more than necessary) for each platform.
	
	    This brings us to those frameworks or libraries focused on native and reusable components. Given that the company has other projects that are already working with frameworks that fit these needs, in order to speed up the project even more, it would be at least convenient to consider React Native for this task.

	    There are other technologies to consider such as Vue or Angular. But given the limited time we have for the creation of the POC, I think it makes the most sense to try to reuse as much of the already developed technology as possible. Also, compared to Vue, it will allow us to find employees more quickly in case the project goes ahead.

	    However, given the sensitivity of the data to be handled, as well as the operations and transactions, I think it would be best to use TypeScript as the language on which to develop the Front-End. Adding the necessary strong typing to minimise incidents.

	    As for styles, although StyleSheet could be enough, I think it is valuable to introduce StyledComponents, since it is a fairly efficient solution that is cleaner and quicker to read and change for developers.


    -Conclusion:
        -I consider that the most interesting and optimal options for development are: React Native with StyledComponents on top of TypeScript.

    Back-End:

        Due to the short period of time we have for the completion of the POC, I consider it necessary to be able to join forces in the different moments of the development. Although within the team there will be people in charge of specific aspects of the project, it would be interesting that everyone could manage correctly in the overall computation of the project.

        To this end, I believe that maintaining the same programming language in both parts (Back and Front) could be an advantage. In addition, Solidity, the language par excellence for the implementation of Smart Contracts in ERC20, is inspired, among others, by JavaScript, which facilitates learning for developers who do not know this technology...

	    As we have already exposed before, TypeScript can be used to create applications in React, adding the strong typing that is missing in common JavaScript.

	    All of the above tells us that the smartest thing to do would be to use Node.Js. This runtime environment would allow us to create the necessary services to manage the application and integrate the services we need to consume for it.

	    Due to the sensitivity of the data to be manipulated, and the fact that some of them are protected under the RGPD, I consider it smarter to give priority to the added security provided by the different tools that SQL makes available to us.

	    Once the tools have been chosen, we should consider the different architectures we can build to meet the requirements. 

        In this case, given that we have already correctly structured the different processes that we need to attend to and consume, we could easily approach the development towards a microservices structure. This also has an impact on improving future scalability. However, we must never lose sight of the 'buts' that this architecture brings, such as the handling of the fall of the different services.
    
    -Conclusion:
        -I consider that the backend development should be in the Node.Js environment using TypeScript and with a SQL database such as MariaDB or MySQL.

# Team

    - 1 Product Manager / Scrum Master
    - 2 Senior Full Stack Engineer
    - 2 Junior Full Stack Engineer
    - 1 UX/UI Designer
    - 1 Senior Back End Engineer
    - 1 Devops Engineer

# Culture

    -Test
        - All development should be focused on the implementation of tests of all kinds, from unit tests to end-to-end tests. This is mostly due to the benefits derived from unit testing for the company. Mistakes in the development of small pieces of code are common, they are usually fixed quickly. However, we have to estimate that the time and money spent for the company is much less when it comes to unit testing compared to fixing bugs that later affect the operation of the platform. For this we can use Jest for unit and integration tests, leaving Cypress for End to End tests.
    -Agile methodologies
        - Given the need to meet deadlines, I consider it almost mandatory to implement agile methodologies to improve the overall performance of the whole team. Events such as the 'daily' are very important when it comes to fostering team communication. In addition, a system of sprints could be implemented to efficiently divide the workload. Jira is a great tool for implementing these methodologies.
    -Team Work
        - I think team bonding is important, so I would encourage a working environment where all developers have the confidence and security to ask questions, contribute and propose ideas. It might be advisable to encourage meetings outside of work.
