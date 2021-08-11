# iobuilders
## IMPORTANTE

## Es muy importante tener en cuenta que no soy un experto en desarrollo de aplicaciones móviles ni un super experto en la generación de Smart Contracts en remix con solidity, toda la información que se va a visualizar la he ido investigando y recopilando, nunca he hecho una app móvil ni he utilizado muchos sistemas que se nombran. Opto a formar parte del equipo para aprender durante el proceso centrado en algún área, busco aprender, ganar experiencia y lo dicho, sobre todo aprender rápidamente.  


## Arquitectura 

La arquitectura principal del proyecto debería estar basada en una arquitectura MVC (Model, Visión, Controler), para separar en distintas capas las distintas funciones de la lógica de la App, de tal forma que tenemos Model que sería la parte encargada de la gestión de los datos para consulta de datos, prevención de ataques, cumplimientos de las normas RGPD (Reglamento General de Protección de Datos), luego estaría la capa de Visión que es la que el usuario va a ver y con la que va a poder interactuar, es decir, la interfaz, y por último la capa lógica llamada Controller, que contiene el código necesario para responder a las acciones que se solicitan en la aplicación, como visualizar un elemento, realizar la compra de un token, etc... (Esta parte se divide en sub-partes comentadas en la sección de tecnología / back end).

# Lógica global de la app

1. Un usuario A de la app móvil se registra en la aplicación bajo un proceso KYC para la prevención de blanqueo de capitales. 
2. El usuario A una vez tiene validado su KYC, quiere comprar un token (Sólo los que sean ERC20, por el momento) con moneda fiat.
3. El usuario A  hará un pago con su tarjeta o una transferencia que irá dirijida a el IBAN asociado a la ethaccount.
4. El usuario A recibe su token en su billetera (wallet). 
5. El usuario puede mantener ese token (hold), puede converitlo (swap) o puede venderlo y recuperar su dinero fiat.


## Riesgos

El riesgo principal aquí es un posible blanqueo de capitales, aunque si no mal recuerdo, ha salido una nueva ley que dice que toda empresa que se cree en España y comercialice con criptomonedas u activos de inversión, está obligada a aportar los datos de los usuarios de su plataforma (En caso de que esté constituida en España, si no lo está...). 

Por otra parte, al ser un app de intercambio monetario seguramente habrán muchos intentos de hackeos y es muy importante por tanto la encriptación de los datos y la eliminación de vulnerabilidades, así como el correcto funcionamiento de las API y prevención de bugs. 

Por último y quizás lo más importante, la legalidad, es muy importante que se tenga todo el respaldo legal que se necesita para la comercialización de dichos activos, que tendrán que estar regulados por la CNMV a través de una EAFI o algo similar, además de tener que cumplir con todos los aspectos legales frente al banco y hacienda, porque en caso de que hubiese algún problema con la empresa creadora de la app móvil de intercambio de fíat por tokens, no solo se vería involucrada la empresa, sino que también los usuarios se verían afectados, tal y como ha pasado recientemente con el Exchange tan conocido mundialmente llamado "Binance", que ha tenido problemas legales en Europa y por ello se han parado durante una línea temporal las transferencias SEPA para todos los usuarios de Binance y algunos problemas más. 

Ahí se ve la importancia de cumplir con todas las legalidades.  


## Tecnología

La tecnología detrás de el proyecto se podría centrar en 3 partes básicas: 

En primer lugar tendríamos el desarrollo de lo que es la interfaz que verá el usuario final y con la que interactuará. Más conocido como el desarrollo Front - End, parte en la cual daremos los aspectos generales y la creación de la APP Móvil como tal. 

Las APP Móviles tienen lenguajes de programación distintos en función de para que sistema operativo se desarrolle, si desarrollamos una app móvil para Android, podemos programar en Android Studio cuyo lenguaje es java y/o kotlin y si queremos programar para iOS se utilizaría Xcode o Swift con un lenguaje tal como Objective-C.

Sin embargo, como en el POC se quiere desarrollar la app móvil en ambos sistemas y en un periodo de tiempo relativamente corto, se deberá optar por una solución mixta que nos permita programar una app válida para ambos sistemas. 

Las dos opciones más utilizadas en el mercado son Xamarin y React Native, en el caso de Xamarin el lenguaje de programación es C# y para una mejor optimización de tiempo no sería lo más recomendable ya que es un lenguaje más difícil de trabajar que el que utiliza React Native que es Javascript.  

Tenemos que contar también con que nuestra App deberá conectarse a una API Javascript de un proveedor de "servicios" para la conexión con la red de Ethereum, para ello nuestra aplicación debe conectarse a una Web3.js que es una API que implementa las especificaciones genéricas para la conexión con la red de eth. 

Para web3js, existen 2 plataformas que son las más conocidas, la primera es Infura, que está bien y tiene un plan gratuito para la creación de 3 proyectos y luego está Metamask que es gratuito y de código abierto, y hasta donde yo sé, el más utilizado a nivel de usuarios. 

En segundo lugar, se tiene "por separado" el desarrollo Back End, el cual tendrá endpoints a los que nuestro código de JavasCript apuntará para hacer llamadas API para los eventos que hayamos programado en el Back-End.

Desde el Back-End se programará con: 

Spring Boot para la programación Back - End en el lenguaje Java ya que es un lenguaje muy utilizado, muy extendido, con una comunidad muy grande y en todas las carreras de ingeniería o módulos, se enseña Java como mínimo, por lo que será fácil la búsqueda de programadores java o incluso ayudas/dudas y respuestas rápidas a cuestiones en foros de internet. Se podría utilizar NodeJS y programarlo en javascript pero como queremos una App segura y que seamos capaces de detallar el código y hacerlo robusto frente a fallos, considero que es mejor el lenguaje java. 

En tercer lugar tenemos el la generación de los Smart Contracts: 

Uso del lenguaje de Solidity para la generación de los Smart Contract de los tokens en Remix (IDE online para programación en Solidity), Ganache de Truffle Suite para las pruebas de funcionamiento de los Smart Contracts y los contratos generados para el control de identidad soberana. (Los Smart Contracts se conectarán con los servicios de Web3.js)


## Equipo 

	1 Project Manager encargado de gestionar el proyecto, coordinar las tareas y estar al tanto de que se cumplen todas en su tiempo.
	2 Desarrollador Solidity para la generación de Smart Contracts correspondientes y el sesteo en truffle. (Podrían estar 2 personas aquí y así ser más rápido todos los procesos).
	3 Desarrollador Javascript (Front - End) para la generación de la App Móvil en React Native.
	4 Desarrollador Java (Back-End) para hacer toda la lógica detrás de la aplicación
	5 Desarrollador de servcios API REST (Back-End) para la generación del endpoint y las correspondientes llamadas desde React Native. 
	6 Diseñador UI/UX para el diseño principal de la app móvil
	7 Experto en ciberseguridad ó Ingeniero de Data Scients para control de datos y de posibles amenazas al sistema.

## Metodología

La principal metodología que utilizaría sería la metodología Kanban ya que es un tipo de metodología continua, con un testo continuo de lo que se va consiguiendo, sin embargo como el proyecto se requiere que se haga a un a velocidad "rápida", es mejor el uso de la metodología Scrum, la cual se centra en sacar un proyecto con mayor velocidad a través de Sprints, srpints planning y sprints reviews, optimizando así mucho más el tiempo. 
 
## Cultura

En la empresa es importante que haya buen ambiente de trabajo, que todo el mundo pueda opinar y todos escuchen y digan cuan locura es lo que está diciendo una persona o quizás " ¡Qué idea más buena, la veremos!. 

También es importante dar cursos de formación, o estar dispuestos a ayudarse mutuamente, para poder dar oportunidad a nuevos integrantes con no mucha experiencia pero con muchas ganas de aprender. Veo muy necesario el asunto de formación en la empresa ya que este es un mundo que cada día avanza más y más y no siempre se estará al día, será cuestión de ir aprendiendo cada día un poco más. 

Por último, veo bien que se haga teletrabajo, pero es muy importante hacer reuniones presenciales para poder conocerse en persona, hablar en persona y tener contacto real y no solo virtual, ya que muchas veces el ir a las oficinas físicamente ayuda más de lo que pensamos.

No soy un fanático del teletrabajo, pero es verdad que abre las puertas a mucha gente que no hace falta que este ni en el mismo país para trabajar, sin embargo, el trabajo en oficinas con compañeros, siempre lo superará. 
