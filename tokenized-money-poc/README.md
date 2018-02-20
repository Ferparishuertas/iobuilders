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


### Technology


## Team


## Culture
