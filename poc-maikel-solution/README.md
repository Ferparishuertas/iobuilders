# IoBuilders Tokenized Money

## Tech + Architecture

### What are your thoughts, ideas about tech, architecture with this context?

To fulfill the described requirements I would develop the POC base on:
- A monolithic application for the backend with the next details:
    - PHP as language. Just because I already have code components to build everything I describe below and the learning curve for any programmer with OOP experience is very low. I would make it clear that this choice is just for the POC, as PHP can be not the best decision to find devs in the future. After the POC, I would analyze whether it makes more sense splitting the monolith and using a new language (probably golang for performance and simplicity reasons) for the new microservices, or refactoring the monolith instead if it affordable.
    - Lightweight framework with basic routing and Dependency Injection capabilities.
    - Rest API for HTTP communication with the UI clients.
    - Hexagonal Architecture (Ports & Adapters) to have our code as much decoupled from frameworks as possible.
    - Good components definition. Although doing a monolith, I would encourage to split what we consider different contexts without dependencies between them. NOTE: I need more domain context to be able to draw an initial context map showing how the first version would look like (to be discussed).
    - CQRS architecture style with events as mean to build our View models synchronously. This way we make sure that events are well defined/designed and they carry the information enough to recreate our domain in case that we need it at some point. The Aggregate Roots would not use events to instantiate their state (no Event Sourcing) but we leave the door open to do it easily in the future if needed.
    - Command Bus & Command Handler patterns to implement our use cases.
    - Don't know if asynchronous tasks are possible/required for the POC (to be discussed). If needed, I would implement an easy solution with just one queue for events with as much consumers as needed bound to it which just map events to commands. Then another queue to receive the commands with as many consumers as we see we need. This way we leave the door opened for an Actor Model reactive style architecture which fits really well with serverless. The RabbitMQ would be an instance in a SAAS provider such as CloudAMQP.
    - I would introduce correlationId, causationId and streamId identifiers for traceability purposes.
    - Relational database with ACID capabilities for both our writing and reading models.
    - JWT method for representing claims securely between back and mobile app.

- An hybrid based technology for the frontend to develop a multi-platform solution (iOS & Android). Although I am not an expert in this side, I would suggest going for React native. Don't know if this solution can have security problems for a wallet.

- A CI tool (SAAS) since the beginning.

- Amazon Web Services.

- Github as CVS. 

## Team

### Describe the skills, roles and team size, that you think is the best fit for this project.

To have the POC working in 4 months I would consider a must:

- 1 Senior frontend.
- 1 Senior + 1 mid senior backends.
- 1 Blockchain technology related expert.

I would make sure that, at least, one the of them has DevOps skills to build a basic dev/staging/prod environments.

It depends on the knowledge of the team about the context that I would consider mandatory or not having a Product Owner for the POC.

I would try to name one of them as Lead, just to make sure that the team does not get stuck in any decision.

I don't know exactly how the product should look like. Depending on the complexity of the app I would consider whether hiring an UX or not. A PO could provide that experience as well for the POC.  

Depending on the budget, I would reconsider hiring a PO and UX so they get involved into the project from the very beginning. 

## Culture

### Go into the details, about which tech/business methodologies, tools, etc..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company

As toolbox to organize the team I would use mainly Domain Driven Design and Scrum with Extreme Programming practices.

Domain Driven Design as the base to build our products/projects always focused on the Domain. It is highly important that all members are part of meetings with the domain experts whether they are the end customer or the Product Owner. This is important for many reasons:
- The team is more involved/engaged with the product they are part of, providing ideas and approaches to build short and iterable solutions. Feeling the pains of not reaching commitments and the satisfaction of success.
- Ubiquitous Language is shared, improving communication with the business side.
- All the team is part of the context map definition, being aware of the relationships between the different domains the system consists of.
- Usage of Event Storming as a communication mechanism with stakeholders to put events at the top of the definition so even business people get used to talk about them. 
- With a layered architecture style to organize our code (Domain, Application and Infrastructure) it is easier to focus more junior people on the outer parts (Persistence, Controllers...), leaving the domain for the more senior ones, producing also shorter PRs easier to be reviewed and merged.

Scrum as methodology:
- Since the definition of the POC seems quite stable, I would suggest sprints of 2 weeks duration. This gives more time (compared with 1 week sprints) to the PO to be able to define in more detail each use story based on the feedback devs provide the first week of the sprint, so the backlog has a better definition on the second week.
- Sprint planning on Monday.
- The first week of the sprint the team is focused on implementing the committed tasks.
- Grooming sessions (1 hour) on Monday, Tuesday and Wednesday of the second week. Here, devs should be able to start designing what is coming for the next sprint based on what is already done and learnings. Functional doubts should be shared with the PO so he can meet with whoever has context to solve them and provide answers for the next session.
- On Friday last week, short retrospective session to see what either we did well or can be improved.
- On Friday too, short demo session to show advances to business people. This routine allows devs to be more in contact with the business side and viceversa. It is important that the PO highlights the benefits of the released features so that devs can see that their work is having an impact out there.
- Stand-ups every day where blocking points are shared. This should not be a "what I did yesterday/what I am going to do today" chat. We are a team, we know what we are doing. An issue tracking tool should allow us to see what it is done and in progress at any moment.
- Have a clear milestone for each sprint. Having a well defined goal for each sprint forces the team to be focused on a single thing, improving performance.
- Have a clear priorities definition and work as a team. All the team must work together to move the first user story from "TO DO" to "DONE". In case that not everyone can work on the first user story, they will move on to the second one. It must be clear that, at the end of the sprint, we give more value by having 2 user stories DONE than 5 IN PROGRESS. This way, everyone has the same goal and the whole team pushes to score the goal.

XP practices:
- Code review is very important to share knowledge, encourage team contribution, and of course identify wrong design decisions before going to production.
- Pair programming allows also to share experience and, for user stories more complex, reach a better code design.
- TDD. Whether the test is done at the beginning or not, the team must strive to have a good testing suite. Functional tests (testing from the Application layer) is a must. Contract Testing is also a must to ensure that clients don't get broken, and they can be used to test HTTP and Persistence adapters. We are doing a POC so we will probably take quick paths in some decisions, we need test to ensure that, when refactoring, the behavior remains the same. As part of implementing first the test, most senior people can do first the test, so more junior people can start working on the domain more confident.
- Continuous Integration to get rapid feedback and avoid deploying a bug.
- Continuous Delivery. The shorter the release is, the easier is to catch the bug and fix it. Otherwise, we can end up in Big Bang releases where it is impossible to spot the problem.

To build a good and healthy culture that, when hiring more people, is so solid that new members get into it easily is important:
- Transparency. Be aware of the situation of the company in a regular basis. It lets people be more conscious of the problems and successes, improving empathy.
- Team building sessions. Nothing better than grabbing some beers together after a good meetup to become not only workmates but also friends.
- Reading club/kata/lightning talk sessions. It just needs to be 30min one day per week where we can talk about technology. This way, someone can have always the opportunity to lear something learn even if it was not the best week for him to do it. 
- Remote culture: Use the chat as communication mechanism so that people working remotely don't feel alone and know what's going on at any moment.
