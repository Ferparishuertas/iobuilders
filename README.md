# IoBuilders Tokenized Money

## Introduction

### **Description**

A quick summary of this feature is the ability of converting a fiat currency into a token, and viceversa, on an easy and fast way, following all the defined regulations and laws.

### **Definitions**

Definimos palabras clave de la POC para tener contexto del proyecto

**Fiat**: Is a government-issued currency that is not backed by a physical commodity
**Token**: Represents a set of rules encoded in a smart contract. Each token belongs to a blockchain address. It’s essentially a digital asset that is stored securely on the blockchain.
**ERC20**: Is a smart contract that has a pre-established data structure.
**ERC725**: is a proposed standard for blockchain-based identity authored by Fabian Vogelsteller
**Blockchain**: Is essentially a digital ledger of transactions that is duplicated and distributed across the entire network of computer systems.
**Etherum**:Ethereum is an open source, distributed software platform that is based on blockchain technology. Ethereum enables developers to build decentralized applications
**Omnibus account**: Is a specific kind of stock holding account that involves multiple investors.

### **Target**
The objective is to be able to perform a service that is consumed by a mobile application, where you can manage transactions, and perform different operations on it. To do this we must be able to tokenize fiat money and viceversa. The system must be able to operate as a banking system, a very important factor is being able to be a **white label**. This will allow us to be able to sell this service to different clients (financial companies, etc) who only add their Etherum account, IBAN, etc. and this companies have their own customers. In other words, it can be considered as a SaaS service, where different companies that provide this service of tokenizing money and managing transactions (for their own end customers) can be integrated.

## **Tech and Architecture**

### **Risks**
We will assess the risks taking into consideration that the service is a POC. If the service continues to evolve, some would become more critical.
#### 1. Legal Risks
| Description | Solution | Severity |
|--|--|--|
| legal requirements | Definition of all legal requirements. And monitoring of regulatory changes | High |
| Have all the necessary licenses to operate | Have a correct mechanism for managing licenses, alerting in case of error, inventory of licenses| Medium

#### 2. Service (application) Risks
| Description | Solution | Severity |
|--|--|--|
| Poor implementation of the white label branding | This risk is critical, if we think of a multitennant SaaS system where different financial clients can be connected (such as banks that we provide them with their brand through the white label system) it is critical to manage the sensitive data of the users of each of the brands, since we must not allow data to be crossed. For this, if we define a SaaS service with a multitenant architecture, it is important to define the data model (being able to work with shared databases, by brand or hybrid formats)| High
| End user (client) access control | Debemos definir una correcta política de autenticación mediate Oauth2, preferiblemente code flow + PKCE: [PKCE RFC](https://datatracker.ietf.org/doc/html/rfc7636) o [Code flow + PKCE Auth0 Doc](https://auth0.com/docs/get-started/authentication-and-authorization-flow/authorization-code-flow-with-proof-key-for-code-exchange-pkce). In addition, we will have to enable these end clients with double authentication (MFA) to comply with security policies and requirements.| High
| Connectivity or service errors with third-party integrations | When errors occur in the communication or response of a third party, we must have error management developed. Among other controls, we must implement a SAGA pattern to manage the transactions that we must carry out in the event of an error to maintain the consistency of the data.| Medium
|Coupling of services (microservices) to the solution| Microservices must be implemented in order to be reusable, not only for this service, but also thinking about possible new services, for example, the microservice in charge of tokenizing| Medium
|Technology stack security risks| In addition to working with an architecture manifest, you must have a constant audit of the dependencies used in the development of the solution for possible security problems that may be found (for example, [Log4j2 Vulnerability](https://nvd.nist.gov/vuln/detail/CVE-2021-44228)| High
|High availability of services and databases|We must ensure high availability of services and databases to avoid downtime (for deployment of new releases, high concurrency, etc). For example, we will use Kubernetes where we can perform a horizontal scaling for high concurrency.| Medium

#### 3. Team Risks
| Description | Solution | Severity |
|--|--|--|
| Curve learning of the tech stack | the technological stack used is common, there should not be a bottleneck in this part, with the exception of blockchain technology, where we must look for a profile with strong knowledge. | Low |
| New technologies can have an impact on continuous deliverable times | It is very important to work with a corporate manifesto so that technological on-boarding is as simple as possible. For new technologies, both the team and the architecture team must be able to unlock that bottleneck.| Low |
| Major changes in requirements and continuous flow of deliverables | The PO will be in charge of the communication and deviations of each of the requirements that come from the stakeholders. You must correctly define its scope and be able to deal with ambiguous messages and deprioritize requirements from the roadmap that should not be in the MVP of the POC | High

## **Architecture**

The architecture that we are going to work on will be a **microservices architecture**, where the different domains will have to be identified in order to correctly define the microservices (Some microservices that we can identify would be: Customers, Tokenizer, Transactions, ...).

In the development of the APIs we will work with the **API First** paradigm. This will help parallelize developments between API consumers (since they will already have their contract) and the backend

In addition, an **event-driven architecture** will be used. This provides us with a number of benefits: Loose coupling, resilience, scales easily, etc.

We will use **clean-architectures**, in this case, we will go to the paradigm of **hexagonal architectures** or also known as **port-adapters architecture**. Where we will decouple the business logic (domain) from external actors. Combined with **domain-driven design** as a software development pattern.

Another architecture that we must take into account, if we finally want to work as a SaaS service and that can help us meet the white label requirement, is the **Multi-Tenant architecture**. In this way, we will have at least one cluster to serve each of the brands and, consequently, each of the clients associating them with the brand to which they belong. Even so, we must bear in mind that this solution, this POC, can be installed (on-premise or cloud) for the specific use of a client, instead of being used as a SaaS service.

It would be interesting to study, to be able to apply the **Backend-For-FrontEnd** (BFF) pattern to facilitate the interaction of a client with the backend, although currently the only consumer will be the mobile application, we may be interested in keeping this architecture in mind for other clients/consumers.

As a programming practice we will use **TDD or Test-Driven Development**, which is a programming practice that consists of first writing the tests (usually unit tests).

## **Other requirements**
- **KYC (Know Your Customer)**: We must find the best solution to uniquely identify customers.
- **Third party Integrations**: As it is the core of our application, the integration with third parties must be robust and with good error and exception management.

## **Tech Stack**

### Infra architecture
Once the requirements and architecture have been analyzed, we must select where to deploy the solution. We must evaluate the vendor-locking that we want to have in the solution in order to have a solution that is compatible with solutions from different cloud and/or on-premise. As it is a POC and it is very important to have the ASAP product, we have decided to use AWS.

We will use the following technologies (some of them will refer to the name of AWS if it is a technology managed by this cloud):
- **EKS**: It will be the Kubernetes cluster where we will have the different contenerized microservices deployed. Through k8s we will be able to have a high availability system, with horizontal scalability, in addition, as we have designed the architecture, it will be stateless, which will allow us to scale the solution more easily.
- **RabbitMq**: For message management. We have decided on this messaging broker since it is the one currently used within ioBuilders, and it has also continued to evolve (for example quorum queues...). We will create a rabbitmq cluster on k8s. In addition, it ensures you at-most-once delivery. Even so, I would propose a change in the future to use **Kafka**, since it is the distributed data transmission platform that has evolved the most. Not only for pub-sub use of messages, but also to persist data, query streams (for example with ksqldb), etc. We have Kafka as a service managed in AWS through MSK. Although we could install a cluster on Kafka's k8s. Other possible solutions handled within AWS are: SQS or Amazon MQ for RabbitMQ.
- **ELB**: The Load Balancer of AWS
- **VPC**: Networking in AWS
- **Security Groups**: Security rules, for example, firewall rules.
- **RDS Postrgesql**: Reational Databases for many of the microservices. 
- **MongoDB Cluster**: For some cases, we need a NoSQL databases. One option is MongoDB database. The AWS version **DocumentDB** is compatible with the diferent clients but it has less functionalities. With AWS we can use **DynamoDB** is a scalable and high performance database, but you have to initially define the type of queries to create the global and local indexes. It works using a table format, and it is a key-value database. It has less versatility than mongodb but very high performance (and it's a serverless database).
- **S3**: It will have several use cases. One of then, it will be used to store static resources that will be accessed from the mobile application. Another use case is the storage of files that may have to be uploaded from the application (for example, DNI if the user is asked at  or differnte documents of the clients, in this case, you can take advantage of services such as self-signed urls to publish the document with a TTL and that a customer can consult). And finally, it can be used as a datalake. It can be generated in S3, for example, the event audit and they can be consulted by services such as AWS Athena.
- **Cloudfront**: CDN of the static resources
- **Prometheus**: The monitoring solution
- **ELK Stack**: To manage the logs. Another use case of the logs, is to persist all the events (event audit). For the POC it is faster to have this solution to have all the events in the logs.
- **Amazon SES**: Email system to send emails to the users
- **Amazon Cognito**: Oauth2 authentication (Code flow + PKCE). We can work with a user pool or we can integrate with some idP. It's a good solution, but there are better (and more expensive) ones like Okta or Auth0.
- **Api gateway**: AWS provides an API Gateway service integrated with OpenAPI, but some more robust solutions exist. Anyway, the solution must be the corporate api management.
- **WAF**: To control access and apply security policies, we should have a WAF that gives us added value in access control. AWS already provides a managed service (**AWS WAF**).
- **Terraform**: IaC to create all the infrastructure.
- **CI/CD**: The actual ioBuilder solution. For CI we can use **Jenkins**, and for CD in k8s we can use **ArgoCD**.
- **SonarQube**: To evaluate the quality code, coverage, etc
- **Nexus**: Repository of the internal libraries and releases. We use the corporate registry
- **Images Registry**: We use the corporate registry to push and pull the private images. We can use **dockerhub**, other solution is de aws registry **Amazon Elastic Container registry**
- **Git**: Is a distributed version control system. We must use the iobuilders version control. We work with trunk based, we see in this article that is the standard version control management practice [trunk based](https://www.atlassian.com/continuous-delivery/continuous-integration/trunk-based-development)

### Mobile Application

One of the requirements is the need to have a mobile application for our service. It must be able to run on Android and IOS. Time-To-Market is very important, so the best solution isn't to work with a native framework. There are different options that we can evaluate (no-native) Ionic, Flutter, Vue Native, React Native, etc. The technology that we will finally use will be:
- [**React Native**](https://reactnative.dev/). Is a JavaScript-based mobile app framework that allows to build natively-rendered mobile apps for iOS and Android. This framework lets create an application for various platforms by using the same codebase. [Advantages and Disadvantages](https://pagepro.co/blog/react-native-pros-and-cons/), some of them:
        **Advantages**:
            - Faster time to market
            - Reuse Components
            - Speed development
            - Large Community
            - Easy to work for developers 
            - And many more advantages...
        **Disadvantages**:
            - Performance is still lower than native
            - It lacks some custom modules
            - Compatibility and debugging issues

### **Back End**

In this case, for the development of microservices it is necessary to take into account (even if an external team is to be hired) the know-how of the company: **Spring (Spring-Boot)** and **Micronaut**. Our proposal is to do it in Spring-Boot due to the know-how of the company and the market, but taking into account that today it is not possible to work with native images (Micronaut if it allows it) which means that microservices have higher performance, lower CPU consumption at start-up, and lower memory consumption.

Spring is working on the **spring native** project to work with native images, which although it is still in beta, comes to solve the problems that spring consumption has.

As an added note, I think creating an archetype should be considered in order to work with **Quarkus**. Not only because Red Hat is behind it, which ensures that it will be a framework that will continue to evolve. The learning curve is very fast coming from Spring (it covers several Spring projects). Furthermore, if we implement the hexagonal architecture correctly, and in the domain layer we are able to have only the business logic, migrating a microservice should be easy.

Therefore, for the POC we will use:
- **Spring Framework** v.5.3.17. The latest version. Note: We will really have to work with the corporate archetype of iobuilder following the philosophy of starters for extended functionalities
- **Spring Boot** v.2.6.5. The latest version. Note: We will really have to work with the corporate archetype of iobuilder following the philosophy of starters for extended functionalities
- The programming language: **Java**. The version **17**
- Maven
- **junit** to unit test
- **mockito**
- **Reactive programing with Reactor**: To get better performance and no-blocking request the better solution is to develop with this paradigm.
- **OpenAPI 3**: API First approach.

## Team

The definition of the team for this 4-month project is one of the most critical parts for success. Must be Autonomous and multidisciplinary, stable and dedicated, a team between 5 and 10 people. We can see an interesting article on [agile team building](https://www.atlassian.com/agile/teams)
The team will consist of:
- **1 Product Owner**: is in charge of optimizing and maximizing the value of the product, being the person in charge of managing the value flow of the product through the Product Backlog. His work as an interlocutor with the stakeholders is fundamental, as well as his role as speaker of the requests and requirements of the clients.
- **1 Scrum Master**: It is responsible for managing and ensuring that the Scrum process is carried out correctly. It must also be responsible for removing impediments. The Scrum Master must be responsible for ensuring that Scrum is carried out, transmitting its benefits to the organization, facilitating its implementation.Scrum master role can be in more teams.
- **1 junior frontend developer** with experience in React Native
- **1 senior frontend developer** with experience in React Native
- **1 Mid developers** in the backend technologies (Spring) with microservices
- **1 Senior developers** in the backend technologies (Spring) with microservices
- **1 Senior developer** with strongly knowledges of Blockchain

Cross Team:
- **1 DevOps engineer**
- **Software Architect**: With a deep knowledge of technologies and business. You will need to be actively involved in the first phase of the project. Strong knowledge of blockchain.
- **UX/UI Team**: To work in the look&feel of the mobile application and enphasys and put emphasis on the user experience. Although as it is a POC, it should be studied through analytical data to refine the appearance and usability of the mobile application.


## Culture

The tech culture, methodologies that will be part of the ADN of the company, are going to be shaped during this project. Which is your proposal, personal point of view, to have a common sense culture, methodologies, mindset, knowing the context, business needs, and a usual venture builder operation? Some base concepts that are a must:

- Multifunctional, autonomous and business oriented teams is the base line. The business domain is the centre
- Everybody counts, and is able to propose things, and communication is key
- Listen to others before arguing. Empathy!
- Continuous improvement must be tattooed on every single member's body :)
- We are building POC's to test business scenarios and then based on the insights, decide if it makes sense to create a venture or not.

To have this we must take care of the talent. Hierarchical companies are not the best example, we must go to horizontal teams.

Allow team members to give their opinion, have access to a career plan, access to training. Managers must work with 1:1 to know the status of the team, receive feedback to understand their needs.

This [article](https://www.linkedin.com/pulse/scrum-es-cultura-marvin-l%C3%B3pez/?originalSubdomain=es) is very interesting to be able to compare company culture with Scrum.

### Tools

- Jira
- Confluence
- Slack

