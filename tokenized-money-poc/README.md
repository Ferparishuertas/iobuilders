Tokenized Money PoC
===================

## Goal

The goal of this documents is response to IOBuilders Challenge based on [Tokenized Money PoC](https://github.com/Ferparishuertas/iobuilders/wiki/IoBuilders-POC).

There is a [glossary](./glossary.md), with terms and concepts used in this project.


## Architecture & technology

### C4 model

I've stated defining **architectural views** of the system, following the [C4 Model](https://c4model.com/). 

The main goal of this model is describe and comunicate architecture decissions. Also, this diagrams are a great starting point for discussions about system design during up-front sessions.

I've only used three of the four model views, because the *class diagrmas* is tightly coupled to implementtation, so change prone during development phases, then can become waste.


#### Context

In this view we define the actors (people, roles,...) involved in the system, and also we define the system boundaries. 

![C4 Context diagram](./resources/iobuilders-tokenizedmoney-contextdiagram.png)

| Actor    | Description   
| ---------|:--------------------
| Customer | People using the system via the application. They will create tokens from fiat, and reverse. 
| Inversis | The company that will provide us banking services.


#### Containers

In this diagram we'll model the different application containers involved in the system, defining their responsabilities, as well as their technical roles.

> In this context a container is something that hosts code and/or data. The containers are the different parts of the system needs to be running in order for the overall system to work.

![C4 Context diagram](./resources/iobuilders-tokenizedmoney-containerdiagram.png)


#### Components

> TBD

### Technology

As seen in the container diagram, this system is composed of different subsystems, each of them with different requisites, there will be more than one application architecture and technology involved. 

Let's split by application subsystem.

#### Mobile Wallet

This is the application the customers will use to interact with his/her wallet. It will be an IOS and Android mobile application. Other targets, like for example desktop, browser-based or Windows Phone, are out of scope.

We have two main scenarios: a **native** or a **hybrid/PWA** application. Each of the solution have pros and cons:

##### Native application

This applications are native to device target. Usually are built with the platform SDK. 

**PROS**

  - Platform *Look&Feel*. Better usability and UX.

**CONS**

  - Two applications to build and maintain.
  - Worst release rollout process.


##### Hybrid/PWA application

**PROS**

  - Only one application to be built.

**CONS**

  - Worst UX, because won't be native to the plafform.


##### Application architecture proposed

Taking into account other requirements, like time to market, quick wins, etc; and also related to initial team, I propose to build an Hybrid/PWA.

A


#### Tokenized Money

A set os REST resources to be consumed by the **Mobile Wallet** application.

> TBD


#### Wallet

> TBD


#### Identity

> TBD


## Team

> TBD


## Culture

> TBD
