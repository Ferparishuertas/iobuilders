# iobuilders


For the mentioned POC, the simplest possible architecture will be deployed without penalizing any improvemente/scalability option. 

For this reason, a serverless architecture based on microservices and deployed on Amazon WS (known for the pay for use politic) has been considered, thinking on reducing each project costs.

A linux base virtual machine will be rent on which all the necessary modules will be deployed avoiding extra costs for using Amazon softwares. This politic will reduce the monthly service costs to the minimum possible.

Initially, we will have the following modules:

 - Mobile APP - Client mobile application.
 - WALLET smart contract - Client wallet.
 - IDENTITY smart contract - Service who will deal with the Sovereign Self Identity.
 - INVERSIS - Third party service (bank).
 - APP-WALLET MS - Microservice who provides the static resources to the client mobile application.
 - TOKENIZER MS - Microservice in charge of all those monetary exchange operations.
 - SECURITY MS - Microservice based on OAUTH2 technology and JWT tokens for securing communications between the client mobile application and the system.
 - KAFKA - This service will act as system data bus allowing us to save all events passing through it.
 - BBDD - The chosen database to store all of client static data is MySQL. This database has a very agile and powerful engine for scalable apps in which data reading speed is the most important thing.
 - NGINX - Reverse proxy service in charge of anonymizing the system's URLs as well as blocking any unsecure request (HTTP protocol). This will be the system entrypoint.
 
 
## Architecture
 
The objetive of this point is to present the chosen architecture and the interconnections of all system modules. 

For this POC, the architecture will follow the EDA pattern - event-driven architecture - having the Kafka services as the system's cornerstone. The point is if any module wants to alter the current system state, this have to be informed to Kafka and he will be the one who performs that action, logging the event.
 
As this is a proof of concept and, in order of reducing costs to the minimum possible, the system will be deployed on the same machine under DOCKER technology, using DOCKER-COMPOSE. In this way, if the services scales, a easy transistion to more complex infraestructures has been ensured.
 
In terms of event logging, at this moment they will be saved in the server file system.

++ Future lines

In architectural terms, the following concepts must be taken into account: scalability and availability. In this way, the designed architecture must be base on these two points and, looking to the future, we have the following options:

- Scalability
 
 - Moving from DOCKER standalone deployment to docker-swarm. This transition offers a very low resources costs since the learning curve is very small.
 - DOCKER standalone deployment to Kubernetes. Here, the learning curve is hiher and the resources costs is higher. Maybe new infraestructure engineer must be hired.
 
- Availability

 - Rent N Amazon WS server replicas, located on different Amazon data centers.
 - Rent new virtual machines, also located in different data centers, to replicate the whole system. In this way, at least two new ones must be rent: system entrypoint and load balancer + system replica.
 
Regarding the event logging, the goal must be a distributed datalake system. My personal recommendation is to use either the Amazon WS cloud environment or a local Hadoop cluster since its easily scalable, economical and offers a good performance having the data locally.
 
 
## Technology

The architecture used for this POC will be based on CLEAN code (hexagonal architecture) and TDD pattern (test-drive domain). The programming paradigm that will be used will be functional, which allows to include reactivity if necessary.

Mobile application

In order to reduce costs, the use of a hybrid technology has been considered. Since the costs and resources are the first, If we put the cost of resources first, the application will be written in React-Native. In addition, those Javascript developers can always lend a hand in Java and viceversa.

Backend-end

In relation to the backend, three microservices have to be developed: SECURITY MS, APP-WALLET MS and TOKENIZER MS. The programming language used will be Java (openjdk-16) and SPRING framework, this ones offers the whole needs we have to have:

 - Java programming community is the best one.
 - Hire Java developer will be easy.
 - Spring framework is one of the most popular.

The microservices to be developed are:
 
 - MS SECURITY - Microservice based on the OAUTH2 system + JWT tokens.
 - APP-WALLET MS - API-type microservice that allows to retrieve user static resources.
 - TOKENIZER MS - API-type microservice that includes each interaction with the WALLET, IDENTITY and INVERSIS services.

On the other hand, we need to deploy the following services:

 - KAFKA - Deployment plus topic configuration for each module who can alter the system state.
 - NGINX - Create the proper configuration of a reverse proxy for our system entry points: TOKENIZER and APP-WALLET.
 - MySQL - DB service deployment and configuration (tunning).

Finally, for WALLET and INDENTITY services, based on blockchain technology, the Solidity language will be used in order to programming the Smart Contracts.


## Team

Regarding the team, based on technical requirements and execution times, the team must be composed of:

- 1 Technical leader: manage and supervise whole project.
- 1 Infraestructure sr. engineer: deploy & configuration of NGINX, KAFKA & MySQL.
- 1 UX/UI designer: create mobile frontend.
- 2 Mobile sr. engineer - hybrid/PWA applications oriented: develop mobile app.
- 4 Backend sr. engineer - knowledge in blockchain & smart contracts: develop APP-WALLET MS, OAUTH2 MS, TOKENIZER MS, WALLET and IDENTITY.
 
## Culture

The project must be developed in fourth months; so for this, AGILE methodology fits perfect here: eight sprints of two weeks each.

Regarding the team itself, each engineer must be focused on:

- Be open minded.
- Continuous learning.
- Open-source mindset.
- TDD focused.
- Open to be assigned to do cross work.
