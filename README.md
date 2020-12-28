# iobuilders - Proposal for POC

---

## ARCHITECTURE + TECH

### GENERAL OVERVIEW

In this section, I will include some notes and random considerations about the architecture and the technology I would use/evaluate. I will start from a general abstract position to a more concrete one. If you want to know my conclusions, please, jump to the resume subsection.

### DEFAULT ARCHITECTURE ORIENTATION

My default preference for the general architecture and for each module, it would be a SOA architecture based on microservices, to get flexibility and scalability. Having a quick glance of this scenario, the chief global technical risks we could face are, as in any other general e-commerce/exchange project like this one:

1.1) Design of the connectors between the components => Specially have a clear idea of the App Services and the APIs. This force us to find a good description of the business and set up the limits and the scope of this project.

1.2) Security in communication and storage => Third parties such as Alastria or Inversis offer many of the key services. Also, the users connect to the system using a mobile app. Following the track of the security, it is worthy to notice that in many cases the authorization and authentication could be built on the top of blockchain because of its own nature. This is an option where we could have a parallel tokanizer system conceptually independent of the transaction and pure finance stuff. It might be external to our own system or distributed to make it robust.

(We will link these points and going into them deeper later, when analysing the requirements for each one of the modules. Additionally, the performance issue, that is one of the requirements indicated in the specs, will be reviewed at the end)

Some of the advantages in microservice architectures are:

2.1.- It allows decoupling and independence for modules and components => This helps in getting parallel analysis and development of each microservice. The deployment could be orchestrated and tuned based on demand if they are correctly designed (horizontal scalability)

2.2.- Decoupling (or loosely coupling) helps in adopting different communication styles other than synchronous direct one. For example, you can use asynchronous or message oriented. However, we must have present that the simplest communication and more intuitive for developers is always the synchronous direct one. The "fire and forget" communications force us to think in extra ways of coordination between processes.

2.3.- It can be easily aligned with event-driven architectures. This is a positive argument which may have been included in the previous point. Indeed, for software architectures at business level, it is usually stick to the concept of asynchronous communication.

2.4.- It helps with TDD and specifically with generation of tests for specific domains, automation of data generation for unitary testing but also for integration and stress loads.


### MODULES BOUNDARIES AND PROJECT SCOPE

In this section, my intention is to roughly limit the modules and their boundaries to get a gross outline of what the final microservices could be. Many of these microservices might be aggregated or packaging in miniservices if necessary, depending on the infrastructure, performance, or fair code organization. In some cases, the services of a domain could be provided as a middleware solution, so you do not have to implement them but inject them (IoC). I will not show any technology, language, or infrastructure yet. Nor the way these modules or microservices are connected either.

Regarding to the picture and the description, the main business domains seem to correspond to the biggest areas depicted in the schema. From them, we could suggest thinner interfaces and submodules and think about those services that could not be considered in the business scope, but they are necessary. Between squared brackets, I include observations and explanatory notes.

    D.1.- Mobile apps [ They are frontend software but their services should be implemented in D.2 ]

      D.1.1.- Apple

      D.1.2.- Android

      [ Evaluate if they can be unified in a single webapp or any tool to make it native from a common source. Check in such cases, that security is not compromised.]

    D.2.- App Services [ This is a real hotspot point. Key services that are used by the mobile’s apps should be defined as soon as possible, at least to allow parallel development if needed]

      D.2.1.- API interface / server.

      D.2.2.- Session management.

    D.3.- Electronic Data Exchange

      D.3.1.- Operations on fiat money

        D.3.1.1.- Bank transactions (credit card and transactions movements -payments, draw money, transfers, etc-) In this functional area are included the direct calls or any wrapper or aggregation risen from the external services of Momopocket and Inversis:

          D.3.1.1.1.- Momopocket services

          D.3.1.1.2.- Inversis services

          D.3.1.1.3.- Management of white label ISBAN / bank accounts

      D.3.2.- Operations on tokens/crCcy

        D.3.2.1.- Management of tokens and cryptocurrencies.

          D.3.2.1.1.- Tokanizer and Alastria services (direct use or wrappers/aggregators around Alastria Services), management of contracts and transactions records.

            D.3.2.1.1.1.- Module for identity and wallet management

            D.3.2.1.1.2.- Tokanizer module [Basic operations for creating and managing tokens]

            D.3.2.1.1.3.- A specific ethereum contract management/repository.

      D.3.3.- Cross domain exchange operations.

          [ This comprehends operations and auxiliar operations that are shared between the previous two sections, or they include functional actions layered in both and/or it is not easy to classify them completely in one of them. ]

          D.3.3.1.- Top level services for conversion fia <-> token [ This could provide us with a plain interface and a connector point for fia to token and vice versa conversion. It should rely on D.3.1.1.1, D.3.1.1.3, D.3.2.1.1.1, D.3.2.1.1.2 and in many cases being a bridge to their services ]

    D.4.- Security / authentication modules.

      D.4.1.- Self sovereign Identity / KYC [Evaluate having a 3rd party library for biometry collection. How to manage recovery of lost wallets? Use multiple channels other than this app to set up a recovery system ]

      D.4.2.- Session restrictions and timeout

      D.4.3.- Administrator security.
      
    D.5.- Storage services [ Traceability is a basic concern. When persisting entities it is as good practise to save attached to their information the tupla: entities ids + creation/modification timestamps + creation/modification agent ]

      D.5.1.- Storage of events and actions on D.3.1

      D.5.2.- Storage of events and actions on D.3.2

      D.5.3.- Storage of events and actions on D.3.3

      D.5.4.- Storage of events and actions on D.2

      D.5.5.- Record of sessions and access for D.4.

      D.5.6.- Record of administrator’s actions.

      D.5.7.- Historical repository and traceability [ Define the policy of deletion and expiration date of sensitive data, usually in response to legal conditions. Breaking traceability could impact in our data quality and consistence if it is going to be used in future Business Intelligence or metric applications. What must the system do with explicit requests of data cancellation from customers such as personal data removal? ]

    D.6.- Logging systems, monitoring system.

    D.7.- Administrator domain. [ This module groups and adds extra functionality to the other business modules. ]


[

  Connections between microservices are key elements that can influence the performance strongly -then, they will be treated in a specific section following the current one-. Nevertheless, we should be able of detaching the core business component of each module from the way they communicate with each other. In an ideal encapsulation process for building and implementing the core business functionality in the backend, it should be presented as a set of domain classes/objects only -in many cases these are grouped and materialized in compiled binary libraries, you might be able of "building a monolithic desktop application easily, including all of them"-.

  A good starting point to check and go farther with the specific requirements is trying to define the API associated to D2 and D.3.3. In parallel we can evaluate the complexity of crossed services such as D.4. or the rules that must be applied in D.5.7

  D.5, D.6 are functionalities that could be injected and provided as a service from infrastructure or middleware. Each microservice must write its own log or set of logs. Information written in the logs must not compromise the security.

  D.4 is a cross domain that is required for fulling necessities or aspects of D.1 and D.2. In the case of D.2. it could be integrated as middleware solutions injected in the server (D.2.1)

  Then, the domains that will be likely implemented and materialized in microservices for the backend are:

  * D.2   => MS.2

  * D.3.1 => MS.3.1

  * D.3.2 => MS.3.2

  * D.3.3 => MS.3.3

]


### CONEXION AND EVENTS


C.1.- EVENTS/MESSAGES AND BROKERS


One desired aspect of connections is the possibility of decoupling the messages, actions or calls triggered from a source or producer and their target or receptor. Events and messages mechanisms arise for this sort of requirements. The use of queue brokers and event streaming platforms are in many cases offered as a middleware solution by infrastructure providers. The most prominent benefit I could consider for queue brokers are:

* Asynchronous reception of the messages/events [ temporal decoupling ]

* Storage and traceability of the messages [ Temporal decoupling implies a persistence database for saving the messages. In many cases, they can be additionally configured as "an event repository as well" ]

* Bus of data for communication of all the elements connected. [ Possibility of integrating filters, mappers, aggregators, etc -pipe chained flow- ]

On the other hand:

* Performance penalty. (However, it could be discarded, in fact, in most of the cases. I do think it does not apply for this scenario. If the current number of consumers are not enough for processing all the messages arrived through the queue, more consumers could be deployed. -[staged event-driven architecture](https://en.wikipedia.org/wiki/Staged_event-driven_architecture)-)

* ACID transactions are harder to achieve in event/message driven architectures. It forces us to some architectonical patterns such as [SAGA](event-driven-deadletter-queue-pattern) or [CQRS](https://www.ibm.com/cloud/architecture/architectures/event-driven-cqrs-pattern/)

* Duplicated events should be considered (Try to follow the idempotency principle for all the services -identify entities ids in a clear unique way-)


C.2.- DIRECT SYNCHRONOUS CONNECTIONS: HTTP, SOCKETS, RMI

Direct asynchronous calls are more intuitive and easier to be handled for single processes. However, they can block running threads waiting for remote responses, and this effect can be spread through many microservices if they are chaining using the same kind of connection (Timeout and synchronization is needed). Loose decoupling of data flows is not possible.

C.3.- EVENTS/MESSAGES THROUGH CACHES

Complex caches are horizontal scalable and, in many cases, they offer synchronization, ACID transactions, streaming and messaging. They are fast for serving data but hard to manage and expensive. It is the usual choise for intensive data processing.

[

My default option for connecting the microservices would be C.1, events using a message broker / event streaming platform as kafka (https://kafka.apache.org/). To improve the performance, a constant socket/RMI connection between M.3.1 and M.3.2 / M.3.3 could be evaluated (C.2). Nevertheless, this implies coordinate the synchronous and asynchronous connections (using patterns like [event-driven-deadletter-queue-pattern](https://www.ibm.com/cloud/architecture/architectures/event-driven-deadletter-queue-pattern)). Before that, it can be tried adaptative load shedding by increasing the number of the instances (running containers) of microservices M.3.2 and/or M.3.3. The last option, C.3. -caches-, could be used if some nodes of the blockchain related to D.3.2 (Operations on tokens/crCcy) have to be deployed locally or running intensive process that could be accelerated using the cache.

MS.1.- Should provide a REST API for the fronted developer

]

### STORAGE

For persistence, the own blockchain technology could be used as a storage system (
  https://www.hackernoon.com/hypothesis-cqrs-models-with-blockchain-as-the-persistence-layer-will-work-a6aa72c31800,
  https://medium.com/validitylabs/how-to-interact-with-the-ethereum-blockchain-and-create-a-database-with-python-and-sql-3dcbd579b3c0
)


### CONTAINERS AND ORCHESTRATION

The main benefits of containers are:

* Portability and adaptation => New images can be created and tunned for different necessities and requirements (for example we can have specific images for developing and production starting from a common image)
* Controlled isolation from other containers and the host environment => Port mapping and direct connection should be explicitly declared.
* Scalability and automatic deployment => They make possible the adaptative deployment of new microservices instances depending on the load.

Indeed, containerization is a current trend and one of the fundamental basis of the [staged event-driven architecture](https://en.wikipedia.org/wiki/Staged_event-driven_architecture) and its application to microservices. Nowadays is quite complicated to separate microservices from containers for deploying in virtual private clouds.


### THE CLOUD

Since the end of the first decade of 2000, the infrastructure as a service (IaS) has emerged as an alternative for traditional bare infrastructures that companies have to manage their self or externalize to specialized data centers. They need high qualified employees to manage and maintain them. Virtualization and containerization push the providers in the path to offer virtual private computers first, then a complete infrastructure of cpus, memory, storage, resources, services, and middleware solutions under the umbrella of virtual private clouds. The infrastructure has turned in many cases as an abstract background tier that can be dynamically adapted to the requirements of the software it supports. The main virtual cloud providers ([VCP](https://en.wikipedia.org/wiki/Virtual_private_cloud)) are:

* [Amazon](https://aws.amazon.com),
* [Azure](https://azure.microsoft.com),
* [Google Cloud](https://azure.microsoft.com))

[ From all the Virtual private clouds I would use AWS because of their acceptance and spread. Nevertheless, depending of SLA and other business restrictions ruled by the corporation/enterprise preferences, it could be swap for any other]


### SECURITY

For D.4.1. (Self sovereign Identity / KYC), => In KYC, at the beginning I would use basic states' official information (such as your national identity card, driving license, etc) and basic biometry measures. A second way of wallet recovery or recovery based on the biometric parameters could be stablished in case of wallet lost.

### MOBILE APPS

It would be nice to have native apps for each platform (android and IOs) because they fit better and has a stronger and direct control of the security, resources, and devices. Nevertheless, this choice adds complexity to the development because you must know about the specific tools, sdks and languages used in each one. In the case of webapps you can take a more platform agnostic solution, but you depend on the web browsers and the security decision should take this under consideration. In addition to the OS version, you have to evaluate the web browser version and compatibility. A third solution is to use a cross platform solution which generates native applications. It saves time and simplifies the tools and procedures of building the software. Some examples:

* [React native](https://reactnative.dev/)
* [Dart + Flutter](https://flutter.dev/)
* [Native script](https://nativescript.org/)

For such kind of applications, the “look and feel” is the business card of the company for many of the customers. It should follow the corporative style and take distinct kinds of accessibilities under consideration.

### TECHNOLGY AND LANGUAGE

Backend => 

* Microservices have the ability of encapsulating the language in which they are implemented in (Specially if they implement a REST - API for their interfaces and use a traversal language such as json or serialized object in protobuf), nevertheless I would use one of "biggest" industry languages with a large ecosystems and bibliography about them: JAVA / C# by default. (At least for MS.3.1-3) In the case of java, Spring is the most complete framework (well known and stablished)

* The reason why I discard python (cpython), php, javascript (npm) or any other interpreted/script language is because their lack or deficient support for "real multithread support". I would consider any of them for the MS.2

* I would not use c / c++ because of their complexity in memory management.

* Some of the business logic could be programmed as smart contracts: Solidity

* New languages could be considered: Go

* Specific for fronted language and framework: Dart + Flutter (MS.1)

[
  My best candidates would be:
  * The default option would be java + springboot for backend development
  * For the frontend Dart + Flutter (Dart is quite similar in syntaxis to java)
  * Solidity for smart contracts if needed.
]

### RESUME

* Backend:
    * SOA architecture based on microservices based on events/messages
    * Kafka data bus (json messages / protobuf)
    * REST API (with OpenAPI) for app services (http server)
    * Containerization (Docker / Kubernete) 
    * AWS
    * Java based technology + spring framework => Springboot / spring cloud
    * Smart contracts in solidity

* Frontend:
    * Dart + Flutter

---

## TEAM

The team members and the roles for a 4 months PoC:

Business =>

* Business analyst: He/she should resolve the doubts about the scope and functionality of the application. Ideally, he/she should have some basic technical culture and a wide knowledge about ethereum and blockchains. He/she should be aware of the legal issues and conditions that the system must comply with (Banking and payments stuff). He/she must be able to "foresight" and "review" the impact of the legal changes and new laws approved. He/she must review if the deliveries meets the specs.

Technical =>

* Blockchain engineer: He/she should have a solid technical knowledge of the blockchains and ethereum ecosystem. Depending on the level of knowledge of the rest of the members in the teams about these issues, he/she should interact more often and support those people who need it more. He/she acts as a senior technical analyst.

    * Desired skills: AWS, DevOps

* 3 x Backoffice developers: They will the people which will develop the microservices and deploy them in the cloud. They will also generate most of the massive data for the tests.

    * Required skills (The most the better): java / spring boot / knowledge about microservices development / docker / kubernetes / API design
    * Desired skills: blockchain and ethereum, HATEOS, OpenAPI


* 2 x Mobile / Fronted developers: Their main target is to develop the mobile app.

    * Required skills (The most the better): javascript + npm / react / angular / react native or nativescript / knowlodge about security in mobiles / webapp.
    * Desired skills: blockchain and ethereum, react native / angular / nativescript / flutter / CSS, SASS, HTML, ...

    [ At least, one of them with experience in android development, the other with experience in IOs development ]

* UX\UI Designer: He/she should 

    * Required skills (The most the better): graphic designs, develop of mocks, accessibility.
    * Desired skills: blockchain and ethereum, javascript, CSS, SASS, HTML, etc

Whoever of the fronted / backend developer should have the will to learn and swap for other peer. Indeed, they should consider the process of developing this software as an opportunity to grow and get new skills. They should tend towards becoming full stack developers if they are not yet and reinforce the already gotten skills while acquiring new ones. At the same time they should be proactive and, once the PoC is finished, they will have to increase their knowledge about blockchain applied to this business since they started the project even greater than the scope reached by the PoC. Nevertheless, they must have a clear target of what should be achieve and the death lines.

* Solution should be cloud oriented, they should be able to addapt and apply CI/CD approches (good to know jenkins, git, gitflow, webhook,...)

* SCRUM or any agile technology or a good selection of [good practises](https://www.altexsoft.com/blog/business/25-scrum-process-best-practices-that-set-your-agile-workflow-for-efficiency/)
( The business analyst should be considered the product owner )

* Realistic target and scheduler based on the capacities of each member and the requirements (First design the interfaces and APIs and use a [TDD](https://en.wikipedia.org/wiki/Test-driven_development) for helping in limiting the scope and mark an objective)

* Pair programming and meetings to evaluate the current state. Technical team, as a whole (all the members participate), checks the targets under realistic assumptions and set a schedule.

---

## CULTURE

* Remember that agile is a [manifesto](https://agilemanifesto.org/principles.html) over any methodology. Nevertheless, being an organized and methodical person for communicating and making your tasks helps to stablish a common "natural" methodology in a group, and materialize the most creative ideas better ([Jazz musicians must learn some basic patterns and practise a lot before jamming](https://www.learnjazzstandards.com/blog/learning-jazz/jazz-advice/beginners-guide-playing-jazz/))
* Be opened to learn and teach continuously, do not worry if you are wrong.
* A good balance between group cooperation and personal space
* Confidence in people and sense of responsibility.
* Build software as if you had been sentenced to maintent it the rest of your life. 


