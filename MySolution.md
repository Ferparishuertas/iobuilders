# Tech + Architecture
For my approach I'm going to choose a tech stack that is more conservative in terms of modernity in favor of a faster and more reliable development. Since we want *quick wins* and *fast lanes*, this approach will allow us to reduce the boilerplate to a minimum by leveraging modern established frameworks.

## Mobile app
I'd choose **React Native** as framework.
### Rationale
It has much traction in the market and it's relatively easy to find developers. Also, those developers will be suitable to work on a web project if needed with almost no ramp-up time if using React.

## App services (Backend)
- Language: A JVM language, preferably **Kotlin**.
- Framework: A well stablished framework like **Spring Boot**.

For the architecture on the backend, I'd use microservices or a fragmented monolith.
### Rationale
#### JVM
It has an extremely solid community and it's easy to find developers.

**Kotlin** is a "newer" language which will attract more interesting developers that surpassed the good ol' Java.
#### Spring Boot
Well stablished software in continuous development. It's easy to apply on a microservices architecture, and is utterly extensible.
#### Architecture
When starting a PoC I always prefer to start with a fragmented monolith. This is a mono-repo application that is created to be deployed as a single app but modularized using DDD.
By using this approach, you can leverage free deployment environments like Heroku easily. But also, you can migrate to a microservice architecture or just fragment the monolith into services on demand with almost no effort.
### Future
When migrating to microservices, it may be worth to change to a more mid-level language to boost performance like `Go` or `Rust`. I'd not suggest to start with this because the development may be delayed because complexity grows and it's more difficult (and expensive) to find expert developers.

# Team

### Senior Front-end developer
- Must have
  - React Native 2y minimum XP
  - Front-end development 5y minimum XP
  - State framework (i.e. Redux) 1y minimum XP
- Nice to have
  - Full stack XP
  - SEO
  - IOS or Android native XP
  - Blockchain tech knowledge


### Senior Back-end developer
- Must Have
  - Java 8+ 5y minimum XP
  - Kotlin 1y minimum XP
  - Spring Boot 3y minimum XP
  - Unit and integration testing
  - Blockchain tech demonstrable knowledge or XP
  - Docker XP
  - Microservices architecture
- Nice to have
  - Full stack XP
  - Devops XP
  - TDD XP
  - Cloud development XP (AWS, Azure, GCP, ...)
  - OWASP security XP


### Mid Back-end developer
- Must have
  - Java 8+ 3y minimum XP
  - Spring Boot 2y minimum XP
- Nice to have
  - Blockchain knowledge
  - Kotlin XP
  - Docker XP


### Cloud engineer / Devops
- Must have
  - Cloud architecture 2y minimum XP (The chosen cloud services)
  - CI/CD pipelines XP
  - Docker & Kubernetes 2y minimum XP
  - Cloud integration security


### Product Owner
- Must have
  - Tech background
  - Banking integration XP
  - Blockchain tech XP
  - Cloud development XP
  - 5y XP as PO

# Culture
For this type of team we are looking for startup-like people. A team with agile mindset, deep divers, and tinkers.

Culture DNA:
- Accountable. Each member of the team is responsible for the team outcome.
- Feature oriented. Each iteration on the PoC should bring a new feature.
- Fix on the go. Fixes and tech debt should be addressed on the go. If the fix takes longer than expected, check for prioritisation.
- TDD oriented. Write readable tests to be agreed with between developers and PO before implementation.

