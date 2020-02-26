# PoC Exercise 1 - Sergio Vavassori

## Tech and Architecture

Since for the PoC we don't expect major traffic and frequent DDoS attacks, I think it's best to invest time on the easyness to code and debug and don't focus for the moment on squeeze the 100% of what the hardware can offer. Obviously, this doesn't mean to program by antipatterns but just to favor developer time vs machine time.

### Mobile app
Following the requirement to deliver on iOS and Android, the best would be to use a cross-platform mobile app framework like [IONIC](https://ionicframework.com/). It saves development time because it's necessary to code only once for the two platform (even if minor platform-dependent adjustment have to be expected) and it will also simplify to have a consistent UX between Android and iOS (or iPad/Tablets).
Moreover, UI layout is relatively easy to be done, mocked or modified because it's basically the same technology of Single-Page Application (SPA).

### Backend Services
Backend architecture should be scalable horizontally and it has to be able to handle a lot of short low-traffic connections: because of the domain, we don't expect much traffic per connection but lots of them in parallel and light CPU processing, so it's mainly IO-bound. This will be best handled by a non-blocking approach but, since we're in a PoC and in order to favor development time, it can be implemented with a more easy-to-debug blocking approach for the pure busineess logic and to use a framework for the serialization layer that supports both approaches (e.g. Netty, Tomcat connectors or AWS lambda). In this way it can be changed once the PoC is successfully ended and it is becoming a product.

Since the backend will have to integrate with other providers, it may be necessary to have a translation layer in order to abstract each of them and adapt, if necessary, the API invocation (e.g. batch vs per-message, synchronous vs asynchronous, etc.). This could require message's persistence in order to retry if some third-party API is not working properly.

According to the picture, there shouldn't be a lot of interaction between different services, maybe two or three of them, so the internal mechanism should be easy to partitionate with respect to the functionality and, based on complexity, beging deployed independently.

#### Traceability and logging
Depending on regulation, GDPR may be an issue to deal with, especially for what is related with the user. However, most of transactions will use a token and/or userID to be identified and this will not be a problem to log.
All application logs should be sent to a central dispatcher in a realiable way, this means to support retry mechanism in case there is no connection or a transient problem. This dispatched then can forward the logs to the most appropriate component (e.g. DB for long-term storage, ELK for analytics, thrird-party service for complicance, etc)
Because it's a Poc, `DEBUG` level should be used as default.

## Team

* 1 or 2 person for mobile with IONIC knowledge, otherwise 2 person with Android and iOS knowledge (they can have both or being specialized in one of them) - medium to senior level, not junior. It would be advisable if one of them has UX background/experience in order to have a nice and funcional UI for the mobile.
* 1 senior or 2 junior for back-end (junior must have already the knowledge of the technology and understanding of serialization mechanism)
* 1 technical leader (can be a senior also) to overview the general architecture and ensure consistency between mobile-backend and backend-3rd party. It must contribute with coding.
* (depending on the specific PoC) 1 medium to senior for OPS if it must be installed on client's premises or the set-up requires non-trivial configuration with third-party services.


## Culture

Since it's a PoC, it would be preferable to have first end-to-end mock/scaffolding of the service to check if there are any missing requirements or parameters; then a proper implementation can be done.

From the start, a non-production level of path coverage (80%) can be required (but not enforced strictly); it can be monitored with automatic reporting tools like [checkstyle](https://checkstyle.sourceforge.io/). Then if the PoC is successfull, a target production level of 100% can be set.
Mutation testing can also help to automatically find very poorly written tests.

Assuming the [git-flow](https://nvie.com/posts/a-successful-git-branching-model/) workflow, each member of the team is responsible to have the build green on the `develop` branch, however private branced can have failing commints.
A build service (Jenkins, TravisCI, GitlabCI, CircleCI...) must be used in order to have buildable components all the time and to not depend on the local editor or developer's machine. It is strongly advisable to use docker images to build in order to have a reproducible environment and avoid side effects (e.g. it builds _only_ on the build service).
In addition to be _green_, what is in `develop` branch must be published to an artifact repository and be **deployable** in the test/demo environment, this is in order to verify configuration changes, parameters and possible integration missmatches.

Developers must know the limitation and usefulness of the tools, this means a brain-on approach instead of blindly rely on them. Moreover, they have to understand the general picture of what is being developed and what are the goals of the PoC in order to focus on the correct tasks and not just write a program right. Similarly, the architecture (both back-end and mobile) must be discussed and generally accepted in order to find possible pitfalls o failings.

About business requirements and scenarios, they have to be kept stable for at least 2 weeks (sprint-period). It may happen that something _unexpected_ happens but they cannot be changed or deeply modified very often because otherwise the team will not be able to produce any useful software in the long run.
On the other hand, the team must understand that this is a PoC and the initial requirements can evolve because the client has a better understanding of its _real_ needs, so they cannot be taken as written on rock and design must reflect that.
Because of this, the most important decision on architecture, technology and framework that will impact a lot on the final output, and that cannot have an easy rollback, must be taken **as late as possible**. This is in order to maximize the correct understanding of the actual requiremenents.

As working environment, an open and share-knowledge should be encouraged, even if the actual shared knowledge isn't relevant or specific to the current PoC. This is because people rarely find the tool or the technique when they need it and, more generally, it helps to have a wider view of what and how software is built.
Writing software is an iterative work: having a naïve solution is better than no-solution, but if later someone find a better/clever one, an improving refactor shoudl be encouraged.
