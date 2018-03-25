IoBuilders Tokenized Money PoC solution
=

### Architecture security risks

Private data as private ethereum keys or credentials for the banking systems should be
isolated from the rest of the application componentes (apis, backend)

So, all the operations against the core banking system or any other secured layer with high private
data should be done indirectly through a queue system. For instance, instead of connecting from
the backend to our banking system for creating new IBAN or new private ethereum private keys:

 `Java core -> Private data`
 
We hide the privaste data layer from our core: 

  `Java core -> Active MQ`
  `Active MQ -> Java worker -> Private data`
  
So, if the java core is compromised, the hacker will not have (easy) access to the
banking system.  
  
We should run our own full Alastria Ethereum node isolated of the public network
(but connected/synchronized to it) and use it (or them) to ensure availability to the
Ethereum network and our smart contracts.

**Tech proposal**

- Mobile wallet: React native. It will allow to develop once and release for IOs and Android.
- Core Backend / API Rest:
  - Java functions as lambda AWS functions. It's the easiest way to create scalable apps
without dealing with EC2 instances. Ideal for mobile apps.
  - Java fat-jar apps (Spring Boot / Grails 3) deployed as docker containers.
  - PostgresQL / Redis: storage

### Team

- 1 x React developer. Skills: Javascript, React Native. Android and IOS. Responsibility: create the mobile app.
- 1 x graphic designer. Skills: Photoshop, Illustrator or Indesign. HTML5/CSS3. Responsibility: create all the assets for the mobile app. 
- 1 x UX/UI for the mobile app. Skills and responsibilities: ensure the UI of the mobile app has the perfect
balance between UI and functionality.
- 2 x Java backend developer. Skills: Java, PostgresQL, Redis, Docker, Active MQ. Responsibilities:
create the core, workers and api for all the mobile user operations (login, topup, pay). 
- 1 x Smart contracts developer. Skills: Solidity. Responsibilities: create all the smart contracts. 

        
      

