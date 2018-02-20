Tokenized Money PoC
===================

## Goal

The goal of this documents is response to IOBuilders Challenge based on [Tokenized Money PoC](https://github.com/Ferparishuertas/iobuilders/wiki/IoBuilders-POC).

There is a [glossary](./glossary.md), with terms and concepts used in this project.


## Architecture & technology


I've stated defining some architecture views of the system, following the [C4 Model](https://c4model.com/). 

I've only use three of the four model views, because the *class diagrmas* is tightly couplled to implementtation, so change prone during development phases, then can become waste.


## Context

In this view we define the actors (people, roles,...) involved in the system, and also we define the system boundaries. 

![C4 Context diagram](./resources/iobuilders-tokenizedmoney-contextdiagram.png)

| Actor    | Description   
| ---------|:--------------------
| Customer | A person using the system via the application
| Inversis | Company that will provide us banking services.


### Containers

In this diagram we'll model the different application's containers involved in the system, defining their responsabilities, as well as their technical roles.  

![C4 Context diagram](./resources/iobuilders-tokenizedmoney-containerdiagram.png)

| Actor    | Description   
| ---------|:--------------------
| Tokenized Money UI | 
| Tokenized Money    | 
| Wallet             |  
| Identity           | 


### Components

