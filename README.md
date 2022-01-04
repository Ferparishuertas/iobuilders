#iobuilders
## Tokenized Money PoC


### Tech + Architecture
#### What are your thoughts, ideas about tech, architecture with this context?

##### Architecture
The architecture would be separated into three microservices: Mobile App, Tokens/Wallet App and E-money App.
Being a PoC and being mobile-oriented, it would be advisable to use a framework in which a single development serves
for Android ans IOS. Therefore, the frontEnd will be developed in React Native.
To obtain a usability and design that can be reusable, easily testable and tolerant to change,
we will use a Hexagonal Architecture using DDD(Domain-driven design).
For the audit, ELK(ElasticSearch, Logstash, Kibana) will be used, with which the three modules can be audited.
For security and traceability we can use Spring Security or OAuth2.

##### - Mobile App
In this microservice will be all the functions to the application, identity creation, pass the KYC, operate the
wallet and the mobile features and business flow.
A single development will be implemented in the Front-End, and web services in the Back-End.
##### - Tokens / Wallet App
In this microservice there will be all the functions related to the Tokens, identity and wallet system.
RestFull services and Interfaces related to token, identity and wallet services will be implemented.
##### - E-Money App
In this microservice will be all the functions related to the banking system.
RestFull services and interfaces will be implemented to call third party libraries (e-money License,
acquirer and banking)

###### Front-end, Back-end and DevOps Architecture
- React Native
- Api Restfull
- Java 11
- Spring Boot
- Spring Security
- Maven
- Swagger
- Junit and Jmockit
- Kafka
- Hexagonal architecture
- DDD (Domain-driven design)
- Microservices
- PostgreSQL Relational Database
- ELK
- Jenkins
- Docker And Kubernetes
- AWS or Azure
- GitHub

### Team
#### Describe the skills, roles and team size, that you think is the best fit for this project.
For the development of the application it would be convenient to find T-Shaped profiles.

- 1 Project Manager/Scrum Master in charge of coordinating the tasks and of managing and doing the
  follow-up to the project
- 1 Architect/TechLead with DevOps knowledge
- 1 Senior Backend Developer with Cloud knowledge
- 1 Senior Backend Developer with Blockchain knowledge
- 1 Senior Frontend or FullStack Developer

For testing, An Testing Sessions at the end of every sprint will be held where everyone is involved.

### Culture
#### Go into the details, about which tech / business methodologies, tools, etc ..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company

##### Agile Methodologies
- With an agile methodology, such as Scrum, we could guarantee small deliveries as the project progresses,
carrying out all your artifacts like Dailies, Product Backlog, BurnDown Charts and all the meetings.
#### Developing
- Use of TDD(Test-Driven Development) methodologies will guarantee the correct functioning of the services, in 
addition to the knowledge
Clean Code, SOLID and ACID.
- Development methodology implementing Continuous Integration and Continuous Deployment.
- Practice Code review for commits and merges.
- Run Sonar before every Commit.
#### Test
- The development must contain all kinds of tests, unit, integration, smoke and end to end. 
- Add contract test for external libraries.
- Do performance testing with Jmeter.
