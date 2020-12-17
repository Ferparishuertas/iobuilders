# POC Exercise

###Tech + Architecture

#### Architecture Solution

For a fast lane development of the POC I propose a Monolith architecure based on **Event-Driven Architecture, Command Query Responsibility Segregation and Domain-Driven Design**. These tools will allow the proyect to grow and to be easily designed.

- **Event-Driven Architecture** will allow the extensibility for further functionality, scalability, traceability and monitoriability
- **Command Query Responsibility Segregation** will provide the application with an abstraction layer, decoupling it from the framework used and making different contexts as decoupled as they can be.
- **Domain-Driven Design** will allow both to put the domain of the whole project and business logic in the center, and to create contexts on the monolith that can easily be promoted to microservices in the future.

With all this joined we can have multiple applications on a **mono-repo** sharing key infrastructure components like the framework and shared libraries without the costs of creating a dedicated dependency server. Taking advantage of the **Event-Driven Architecture**, the project can also scalate horizontally, deploying different workers on the infrastructure, being also is a good method to trace every single action that happens in the system, and a way to get data for **Business Inteligence** *near real time* decoupled from production databases or ETL processes.

Defining **clearly differentiated contexts** will allow the integration with diferents partners and services (Inversis, Alastria...) while keeping them out of the domain and the business logic. The business services and these partners services will communicate between them with messages via an **integration bus**. Depending on the configuration and the technology choosed it can also provide with a resilience layer in the infrastructure, for example, when a partner's endpoint is down, a message can be retried multiple times.

**Comunicating services with messages** also provides agnostic contexts that don't know each other. With a closed contract (the messages themselves) between the different contexts these can be replaced for new ones without impact on the others.

#### Tech

##### Backend

I'm not a really big fan of any language on particular, for a POC with a tight time I would choose a language with a great ecosystem like TypeScript, PHP, Python or Java, in example. For me PHP is a language of which I know it's tools and how it works. We can also use TypeScript, which allows to create the backend and the frontend in the same language, but not with the same tools.

The main issue is how to design every context. As said in the **Architecture Solution**, we must create a context for the business and for the different applications we will need: BackOffice, Alastria, Inversis. Every one of these contexts must have their own *framework app* too with its configuration (config files, resources, controllers...). 

```
# Context and Apps example on a monorepo
apps
	TokenizedMoneyApp
		frameworkConfig
	BackOfficeApp
		frameworkConfig
	AlastriaApp
		frameworkConfig
	...
src
	Shared
	BackOffice
	Alastria
	TokenizedMoney
	...
ThirdPartyLibraries
	frameworkSource
	...
```

The comunication between services via messages can be achieved in different ways. One is **serializing the message** in a notation that most of languages can understand, like **json**, and then provide a contract to validate the message, like **json schema**. This allows to create multi-lenguage apps. Another option to achieve the communication between services is through a serialized object of a specific language providing a **Data Transfer Object** that ensure that the contract is closed.

An integration bus like **RabbitMQ** or **SNS and SQS** adds the abstraction layer to ensure agnostics services via messages.

##### Frontend

It should be used a solution that could provide a way to compile the application for Android and IOs. It can be done using a language like **React Native**. A fast way to do it is creating a web app with a framework like **Angular** and then displaying this on the native apps, using them as frames. With this method any update can be easily deployed without any deployment process on the different stores. It also provides a way to interact with the application from other operating systems. As a counterpart, this solution needs extra infrastructure: *load balancer* and *static hosting* (like AWS S3 Bucket).

As in the backend, it is important to keep an EDA to avoid the Callback Hell and apply the Open/Closed principle.

##### Metrics & Traceability

Metrics can be obtained using an application like **Prometheus**. It has a good ecosystem and SDKs for differents languages. This way it can create metrics over **commands** and **queries** with a middleware on the communication bus and over **events** with subscribers. It also provides scalability with **Cortex**.

Traceability can be archived in the same way. Subscribing to the published **events**, traces can be created on a system, like **ElasticSearch** or **CloudWatch**.

##### Infrastructure

For the infrastruture, there is a high value on using a system of **Infrastructure as Code** like **Terraform**. It keeps the repositories as **source of truth**. The infraestructure can be versioned as the application. Terraform also has a registry where there can be found different architectures for different **cloud providers**.

More advantages of the **IaC** are that **modules created can be reused** when it is needed to provide more infrastructures, like promoting a context to microservice by configuring new elements on an inventary.

##### DevOps

For environment standarization, containerization is a must. This will provide a quick way to deploy the application and mantain integrity. Also with highly configurable images the application can be tested easily if there are different deployments with different configurations on different productive environments.

For a quick launch, it can be used a **SaaS** for automatization like **CodeShip** or **AWS CodeDeploy** to define a pipe of actions for the application like: testing, complexity scan, static code analysis... and of course deployments.

##### Performance & Risks

While most common risks - like DDoS or SQL Inyections - are tackled down by tools like *ORMs* or the *Cloud Provider*, others must be considered. Tasks with high demand of resources must be done in background, which means that a machine attending request of the users musn't also be a consumer. This ensures that the service is not degraded due to a heavy operation, and this controller is not exposed to the public network. Also this kind of process must be ordered or triggered by the business logic and not by a user's direct action. This orchestration offers to the user a better experience, and security, performance and scalability to the app.

Self sovereign identity should deal with the identity suplantation, as it must be confirmed by multiple nodes.

When working with third parties the data integrity is a risk. Each Context must validate its data and then conciliate it with the common language between services. Transactions between services with non-integral data muns't be commited.

Different production environments should be isolated one from another, so a breach in the security in one of them doesn't affect the others.

### Team

**Product Manager**: This is more a role than a member itself, it can be an engineer or not. It must define the overall needs of the product and identify its future users, the *"valuable"* and the *"nice to have"* characteristics, based both on those characteristics and on the target of the product. It also must support the rest of the team in the definition of the roadmap and the prototypes. It must identify ongoing development costs, and the post-launch costs. It's the principal role/member to collect requirements, identify needs and define functional tasks.

**UX\UI Designer**: Must work on the flow and create the visual resources of the application. It has to define the general Look and Feel of the product - app, transactional emails, marketing emails, landing pages... - and create a guide with clear rules of design to mantain de consistence of the whole product during the development and the further work.

**2 x FullStack Engineer**: Should be frontend oriented but must be capable to work on the frontend and the backend. It has to tightly work with the *UX\UI Designer* to define and create the application's Look and Feel on the different devices.

**3 x Backend Engineer**: Must work on the backend services and partners integrations and should work tightly with the *Product Manager* to define the flow of the business logic and define the key aspect and the business use cases.

####Transversal skills of the team

- The team must work on the solution together to define a roadmap and the strategies to accomplish it.
  - Strategies objectives must be clear and every member who takes part of it must be capable to perform any task described.
- Collect requirements from the strategies and define the specific tasks.
- Create clear documentation of the product, including functional and technical documentation.

**Engineers**:

- Must be capable of working on the infrastructure of the solution.
- Create the continuous integration automated tasks.
- Must know the SOLID principles and how to apply them.
- Must know the principles of DDD.
- Nice to know:
  - CQRS
  - IaC
  - DevOps Skills

### Culture

A culture of **liberty** and **responsibility** should drive the daily work of the team on how to address the challenges of the project. The entire **team should follow a clearly stated methodology**. As previously said, the team should create a **roadmap** for the project once the requeriments of the target have been identified. After this, squads can be created to define concrete stragies on how to adress the steps to reach each checkpoint, e.g: 

**First checkpoint:** 

```
User management: an user should be able to identify with self sovereign identification. 

The team must define the requirements, like: Define a contract for user login on the system, define the transaction of the login operation and the business logic, define an endpoint to commit the transaction, etc. Then the team can divide into two squads. Front squad must define the specific tasks to do on the app, like controllers, models, events, views, etc., while back squad must define the tasks to do: controllers, schema validations, use cases, events...
```

When enough tasks have been refined, squads must estimate the effort needed to address them in order to create a *"work iteration"*. Once finished the *iteration*, the team has an idea of the average speed with which they can resolve tasks, and has metrics that allow identifying posible improvements on the working method during the *iteration* revision. 

Any task included in the *iteration* can't be longer than the iteration time. i.e: A task that has an estimation of three weeks while working on iterations of two weeks can't be addressed on 1,5 iterations, so the task must be redefined or the team must work on a longer iteration. Therefore, it is important to identify the *critical path* of a feature to know how many tasks can be done in parallel to ensure the estimated effort fits with the *iteration* time, and members are occupied the maximum time.

During the  *iteration*, the work of defining strategies and tasks to address the next checkpoint must continue, so after finishing an *iteration* a new one can begin.

This way the team makes itself autosuficient and can work with a constant performance. It also can identify better ways to approach the challenges, so as the mistakes in order improve the daily work. Working with a clear methodoly also **puts the product as key aspect** and involves everybody in it. Therefore, total transparency is needed.

