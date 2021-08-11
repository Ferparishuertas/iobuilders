# iobuilders

## Arquitectura y tecnología

### Aplicaciones

* *Mobile App*. Este es el punto de entrada de nuestro sistema para los usuarios finales. Desde aquí se podrán realizar diversas acciones como las que se especifican en el documento. 
* *Backend App*. En esta parte incluiremos un (micro)servicio que actuará como punto de entrada para gestionar los recursos del cliente y la integración con otros servicios externos(inversis, por ejemplo).
  * *Tokenizer*. Para llevar el dinero fiat al blockchain.
  * *Identity*. Smart contract para los documentos oficiales de identidad.
  * *Wallet*. Smart contract para manejar o gestionar el dinero del cliente.

#### Mobile App

La primera decisión es saber qué enfoque seguir ya que uno de los requisitos es que tiene que ser para IOS y Android. 

Hay dos opciones: 

##### Native

Aplicación nativa del SO. Suelen tener su propio SDK y entorno. 

Ventajas:
* UX
* Rendimiento

Desventajas:
* Habría que mantener dos aplicaciones

##### Híbridas o PWA

Aplicaciones web que se hacen pasar por nativas para el usuario final. 

Ventajas:
* Todo en uno. Se desarrolla y se mantiene una sola aplicación que además puede ser adaptada a más plataformas.
* No es necesario contratar gente específica de mobile.
* Buenas integraciones con servicios cloud como AWS Amplify o AWS Cognito.
* Mejora la contratación de personal(web devs)

Desventajas:
* Peor rendimiento que las nativas
* Peor UX
* Muchas alternativas y si se escoge una mala opción puedes tener problemas de soporte a largo plazo(Cordova). 
* Hay bastante nicho de especialidad dependendiendo de la plataforma. 

========

La UX y el rendimiento es un precio a pagar para reducir el time to market en una startup. Creo que el hecho de aprovechar los escasos recursos es un factor determinante para optar por una híbrida.

Es más sencillo contrata a desarrolladores full stack o de front que a gente exclusiva de mobile. Además pueden también colaborar con cualquier otra de las aplicaciones del sistema.

Hay varias opciones a la hora de elegir framework, pero no sabría si decidirme por Angular(ionic) o React(R.Native).

La opción de Angular puede ser interesante si se busca gente con experiencia en Java. Hay muchos proyectos empresariales en los que se usan ambos, además es un framework bastante robusto con una estructura bastante definida. 

De React no conozco lo suficiente pero de primeras diría que es más minimalista, tiene bastante comunidad y buen soporte. Además React Native parece ser una de las opciones más usadas, por lo que tanto, los pros serían tanto el soporte como el contratar a gente con experiencia en el medio plazo.

Para desplegar imagino que se puede usar algún bucket de S3 en Amazon.

#### Backend App

Este back es relativamente pequeño ya que sólo logro detecta un dominio, el dominio relativo a tokenizar el dinero.

El back tiene un punto de entrada HTTP(driving adapter). Por el lado de los driven adapters tenemos tanto la integración con el servicio externo como con los smart contracts.

Respecto al stack tenemos varias opciones, y el punto de inflexión para optar por una u otra es decidir si tenemos los recursos y el tiempo suficiente como para gestionar y administrar nuestra propia infraestructura. 

Si la respuesta es no, la mejor alternativa es sin duda alguna, optar por un enfoque serverless.

Optaría por AWS porque es con el que he trabajado y es el que cuenta con un mayor uso de la comunidad. 

El "sólo se paga por lo que usas" es una gran ventaja cuando se está empezando y no sabes realmente el tráfico que vas a tener. Además a nivel de seguridad con el principio de menor privilegio de IAM, nos ayuda a que si en caso de que una lambda o servicio queda comprometido, no se vean afectados los demás servicios. 

Para nuestro caso usaremos un servicio serverless. El punto de entrada será un api gateway para cada acción de cada recurso. El trigger para cada una de las acciones será una AWS Lambda. 

AWS Lambda acepta varios lenguajes, ampliables mediante AWS Lambda Layers con custom runtimes(Se podría usar Java 16 si se quisiese, por ejemplo).

Hay dos variables a tener en cuenta para escoger uno u otro:

1. Cold Start
2. Tiempo de ejecución
3. Tamaño de los desplegables

La cold start en producción no suele ser un factor determinante pues salvo que sea un servicio con unos intervalos de uso a partir de los 30-50 minutos o más. 

Ahora bien, para desarrollo, puede reducir la productividad. Al igual que el tamaño de los desplegables. Puede ser un infierno si tu conexión no es muy buena.

Este servicio parece de alta demanda por lo que optaría por un lenguaje compilado como podría ser alguna basado en la JVM(Java o Kotlin). Existen más opciones interesantes como Go pero no tengo la información suficiente como para opinar.

Para la observabilidad se puede plantear la posibilidad de usar AWS X-RAY. También se puede estudiar la aplicación de event sourcing dentro del ecosistema de AWS.

Para lidiar con la problemática de los eventos fallidos se puede implementar una DLQ en SQS. Es importante diseñar las funciones con idempotencia porque hay que tener clara una cosa, y es que es posible que haya duplicidades. Además, por defecto, cada función lambda tiene reintentos cuando falla.

## Equipo y cultura

Soy partidario de separar, al menos, el back del front.

- Front-end
- Full stack: Balanceando la carga de trabajo de ambas partes
- Back-end
- Team leader

La filosofía del equipo es devops y la metodología a seguir es la agile, aplicando TDD y DDD.

Considero que la clave es seguir una buena comunicación. 










