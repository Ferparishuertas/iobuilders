# Tech + Architecture

## Architecture

We will use a client-server architecture based on the PoC requirements.

On the client side we will use a mobile app as a client.

On the server side we will have multiple microservices with the different parts of the backend functions (and they can be used another time).

The communication between the app and the server side will be using REST services.

All the microservices are:

- Gateway: distributes the requests to the others microservices
- Identity: login, KYC and regulatory stuff.
- Core: actions of the application. Example: get stats...
- Wallet: tokenizer and blockchain actions. Also links 
- Bank: aquirer and custody actions, communication with inversis.

## Frontend

The mobile app should be available for iOS and Android. We should use a cross platform framework. React Native is suitable for our needs. 

With this framework we can build the app in a shorter period of time than other frameworks or native code.

This framework has near-native code performance.

This framework has JavaScript as programming language. There are many packages developed on this language. Also has a wide community.

React Native is the most used framework at the time of write.

Javascript is event-driven language so it can be audited.

## Backend

The backend will be developed with Java. We choose Java because it has a wide support and it's used widely in enterprise solutions (it's easy to find Java developers).

We will use Spring Boot framework because it's a microservice oriented framework.

We will use gradle for project management. I was thinking about maven but i prefer gradle because it's a clearer and faster project manager.

We will use web3j framework to communicate with the Ethereum Blockchain.

Also we will have a Postgres SQL database.

We will use kubernetes for the microservice management and deployment.

We will use Apache Kafka software for communications between microservices. This is a queue manager service.

## Tech risks

The tech risks associated with this project are:

- Architecture design (mainly from the microservices).
- Regulatory risks.

# Team

- 1 scrum master and team leader
- 1 UI/UX expert
- 2 frontend developers (with knowledge and react)
- 4 backend developers (with Java knowledge)
- 1 legal advisor
- 1 cybersecurity pentester

# Culture

## Methodologies

We must employ scrum methodology because is an user oriented development.

## Culture

- Open-source culture
- Remote work friendly
- Flexible working hours
- Listen to everybody
- Trust to make mistakes
- Continuous learning
- Team building activities