# IoBuilders Tokenized Money PoC

<!-- @import "[TOC]" {cmd="toc" depthFrom=2 depthTo=5 orderedList=false} -->
<!-- code_chunk_output -->

- [IoBuilders Tokenized Money PoC](#iobuilders-tokenized-money-poc)
  - [Version Control](#version-control)
  - [Tech + Architecture](#tech--architecture)
    - [Architecture](#architecture)
    - [Infrastructure and Deployment](#infrastructure-and-deployment)
    - [Mobile App](#mobile-app)
    - [Backend](#backend)
    - [Ideas about tech](#ideas-about-tech)
    - [Pros](#pros)
    - [Cons](#cons)
  - [Teams](#teams)
  - [Culture](#culture)
    - [Agile](#agile)
    - [Tech](#tech)

<!-- /code_chunk_output -->

## Version Control

| Date | Version | Author | Changes|
| :------------- | :------------- | :------------- | :------------- | :------------- |
| 26/01/2022 | 1.0 | Ramón Bailén Sánchez| PoC

## Tech + Architecture

### Architecture

The overall architecture could be microservices-based, making the services decoupled from each other in the best possible way. They will be managed by a cloud service provider, ensuring high availability and scalability.

We will use a mobile app as a client.

Client-Server communication applying the REST architecture principles.

For security, the Authorization Code grant flow with PKCE (OAuth 2.1) is tipically used with native and mobile apps.

### Infrastructure and Deployment

- Cloud based (AWS)
- CI/CD (Git, Pull Requests, Jenkins, CodeCommit)
  - Multiple integrations per day

### Mobile App

I would create a native app for both Android and iOS using React Native, taking advantage of developing with a single programming language, in this case  Javascript.

### Backend

I would define an API gateway as an entry point to the microservices system, providing functionalities such as authentication, authorization and logging.

From the initial diagram we could create microservices for wallet, token and banking.

- Microservices will be implemented using Spring Boot and deployed on EKS (AWS)
- Queuing technology for inter-service communication that could be Kafka, RabbitMQ or Amazon SNS
- For my project I would use DynamoDB for the tight integration with AWS (fast, highly available and fully managed)
- Unit Testing with JUnit and Mockito and Integration Testing with Testcontainers
- Distributed Tracing using Sleuth and ELK Stack
- OpenAPI for REST APIs and AsyncAPI for messaging

### Ideas about tech

- API First
- Microservice archetype to simplify its creation
- Starters for cross architectural components
- Hexagonal architecture for being ready to change without impacting business logic
- DDD if the business part took part in the process
- Clean Code
- SOLID
- TDD/BDD

### Pros

- There are a lot of engineers around the world with knowledge in most technologies
- Challenging project

### Cons

- React Native is not 100% cross-platform
  - The same behaviour for iOS and Android is not entirely true
- Hard to find people with Blockchain expertise
- Distributed systems
  - Eventual Consistency
  - Fault Tolerance
  - Observability (logs, metrics, traces)
- TDD if the team has experience
    
## Teams

- 1x Scrum Master
- 1x Architect with knowledges in any JVM language, DevOps and Cloud
- 2x Backend Developers with knowledges in any JVM language
- 1x Blockchain Developer
- 2x Frontend Developers with knowledges in React Native
- 1x QA

## Culture

### Agile

We will use an Agile methodology like Scrum to guide team in the delivery of the product.
- 2 weeks by sprint
- Dailies of 15 minutes to inspect the Team progress
- We will introduce the ceremonies we need to achive our goal
- Use of external tools like Jira could help us in the management process

### Tech

- Collaboration
- Communication
- Team work
- Treat failures as a required step towards success
- Challenges
- Remote work friendly
- Flexible working hours