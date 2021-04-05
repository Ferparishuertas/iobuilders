
# Tech + Architecture

Based on the requirements of the frontend (mobile apps), the main architecture will be based on client-server model architecture, leveraging rest services as communication protocol, so the backend, will be a common piece for all the apps.

## Frontend

We choose React Native as the frontend framework, so the development of the user interfaces could be shared for the two mobile systems: Android and IOS. The choice of react native, will give us the development speed needed for balance various mobile systems, meanwhile without losing native performance and usability.

## Backend

The backend will be composed on several services, hence we are applying a micro-service architectural style.

The natural needs for making the system performant, reusable, modulable and traceable, will make us choose for a asynchronous message based communication between the services using apache kafka.

Each service will be independent of each others (loosely coupled), and for the communication between them, we will rely on kafka streams. Each service will send/receive messages, that allows the processing of the required business task/rules. Kafka joins will allows us to model a service input in base of more than one services output, that is, one service could use the output of other two services for some business processing.

![Kafka Stream and Table joins](https://i.stack.imgur.com/6frfc.png)

Due to the loosely coupled nature of using kafka streams, we can always "sniff" all the event/messages, so auditing all the systems, could be as simple as subscribe to the needed streams.

### Services

As we need to implement each service very fast, the election of language/framework, is a key decision here. As a personal choose, we will take ruby on rails framework. This framework give us a fast development, with minimal boilerplate setup but with a very good testing roots.


## Tech risks

The higher risk here, is modelling/design and develop the asynchronous stream communication between each service, due that this would be the core/key component of the system and that is the most complexity has. So some initial courses/documentation here for all the backend team, would be a must.

Developing the rest services and UI are lower risks, because they are very know technologies understated and practiced today.





# Team

Expected team size, 7 menbers:

- One graphics designer and UX expert
- One Frontend developer, with some knowledge on mobile and react
- Four backend developers, with experience in rest services, ruby language (and kafka, if posible)
- One Lead with a agile mindset


# Culture

## methodologies

We should apply a scrum methodology due that:

- The development need to be adaptative and iterative.
- Has not been specified, but probably we have some stakeholders and users not related to the team, that probably wants to contribute (be implicated) in the PoC.
- Every team member should participate and improve every second.

## Culture

-   Remote work friendly.
-   Flexible working hours

