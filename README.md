# IoBuilders POC - Tokenized Money

_Disclaimer:
This is the first time that I work with Blockchain technology and specifically with
Ethereum ecosystem. Although I've tried to be informed about how it all works, maybe
I will have some gaps regarding technology details that could be taken into account
when designing this POC._

## Objective

This document aims to propose a way to build a POC for a mobile application that will
allow users to convert their fiat to a token and viceversa on an easy, fast and secure way.
Roughly, users will be able to put fiat into the wallet using their IBAN or credit
card, transfer to other users, buy assets and withdraw the fiat money back.

## 1.- Tech + Architecture

There are some pieces that must be linked to make the POC work:

- Mobile App: The user interface
- App Services: Microservices that will support the app and the bussiness flows.
- Alastria Services: for Wallet and Identity (the Ethereum part).
- EDE Services: for fiat management. Momopocket will be used for acquirement and Inversis
  for banking.
- Tokenizer: The microservice that will link fiat to the wallet. It will have the
  responsibility to guard, trace and monitor all the transactions.

From all these pieces, we have to develop three of them: Mobile App, App Services and the
Tokenizer.

### Mobile App

There's always a problem when an app must be implemented for Android and iOS. They are
very different systems and technology stacks and tooling are very different too. This
usually brings in the problem of having duplicate teams and code base for each version.
It has to be minimized, so my proposal would be to develop two native
apps with the maximum number of flows done with webviews. These can be optimized to be
almost like native flows in terms of performance, UX and UI. Some flows must be done
native like for example:
- the ones when there's no internet connection.
- those that must use OS APIs directly (for example for taking a photo of the ID card).
- those that have a bad UX for being webviews and can't be fixed.

Taking this approach we would be able to hire a minimum number of Android/iOS developers
and the rest would be fullstack engineers that would implement the App Services and the
webview parts of the Mobile App.

Regarding technology, Android developers would use Java/Kotlin and iOS developers Swift
and their associate tooling. For webviews we would use HTML5, CSS and Javascript with the
a widely used framework like React, Angular or Vue.js for example. All developments in
native or web technologies must have automated testing.

### App Services

They would be API REST microservices that would handle absolutely all requests from
the mobile app. Almost every endpoint will need the user to be logged in, i.e., to have
a valid access token. The exception would be the one needed for logging in, so the
mobile app can get a valid access token or the ones needed for new users registration.
Take into account that the access token is not the same as the blockchain token.

The App Services would be responsible to interact with the Tokenizer, Alastria and
Acquirement services for certain flows.

In terms of tech used for microservices, I would choose Java/Kotlin languages because
the JVM ecosystem is very well known and well proved in enterprise systems. They're
strong typed languages which allow to have a lot of errors controlled at compilation
time. IDEs help a lot with this too showing those errors directly as the developer
writes code. Frameworks like Spring, Hibernate or JUnit are used a lot. In both
languages and frameworks there's a strong community and developments are fast and
reliable. Because of that, developers are easier to find and hire.

All microservices would be containerized with Docker and orchestrated with Kubernetes
so their number can expand and shrink easily when needed. All of them would live in
several environments in a cloud provider (for example, AWS), for DEVELOPMENT,
CERTIFICATION, PRE-RELEASE and PRODUCTION uses.

All microservices must have automated testing.

Some microservices that could be created for the proposed business flows (not exhaustive):
- **Registration** (no access token required): Alastria (Wallet and Identity creation).
- **Login** (no access token required): Alastria (Identity checks)
- **Acquirement**: Tokenizer.
- **Transfer**: Alastria (Wallet) (supposing both users have tokens).
- **Buy**: Tokenizer and EDE Services (supposing commerces don't have tokens)
- **Withdraw**: Tokenizer.
- **Monitor**: Will receive functional events from all microservices and mobile apps and
  log them. Then an external SaaS service like Devo can be used to trace information
  in real time. Technical logs (warnings, errors) can be sent to a SaaS or
  on-premise service too.

### Data repositories

Another important part of the technical architecture is the data repositories.
Each microservice can have a unique repository whose tables can be partitioned if
necessary. It allows having as many microservice instances as needed but a unique
point where the information is stored. The partition mechanism can be used if
repositories must be scaled. Depending on the specific needs there can be relational
databases (MySQL, MariaDB, Postgres) or non-relational databases (MongoDB).

### Identificator

It would be a microservice not reachable from the Mobile App, only from App Services
and Tokenizer. Its main goal would be to associate an access token to an Identity. It
would be used by Login, Transfer and Tokenizer.

### Tokenizer

It would be a special microservice that wouldn't be reachable from the mobile app
directly, only by some microservices. Its main goal is to convert fiat to tokens
and viceversa using EDE and Alastria services. It would be the only actor capable
of doing that, making this critical operation in a secure and controlled way. Like
the rest of the microservices it could be scaled properly when it's needed.

## 2.- Team

For developing this product, we need people, starting from the definition and ending
with the ops team.

- **1 Product Manager**: If no one from the management has this role already. She would be
  the responsible of defining exactly what the Mobile App has to do, what the
  flows would be like.
- **1 UX/UI Designer**: This person would work closely with the Product Manager to put her
  thoughts in final designs that would later be brought to HTML and native code by
  engineers.
- **1 Android engineer**: Responsible of developing native flows in the Android App version.
- **1 iOS engineer**: Responsible of developing native flows in the iOS App version.
- **1 Senior Frontend engineer**: She will be the person of reference when designing
  and implementing webview based app flows. She will support all Full Stack engineers
  regarding frontend tasks.
- **2 Senior Full Stack engineers**: They will have to understand the requirements for
  all microservices and webview based app flows, write technical specifications and
  implement them accordingly. They will support Junior Full Stack engineers. They
  will be the responsible of implementing core microservices like the Tokenizer and
  overview the rest of them with special attention on security and monitoring.
- **2 Junior Full Stack engineers**: They will implement what is proposed in technical
  specifications. Of course they can challenge those specifications or even product
  definitions. Everyone must be heard.
- **1 Quality Assurance engineer**: She will use the information provided by the
  Product Manager to make sure that the Mobile App does what it has to do. Additionally,
  she will automatize testing as much as possible.
- **1 Devops engineer**: She will provide assistance to all engineers for environments,
  tooling, CI/CD, Docker and Kubernetes infra, source code version control system (Git),
  etc. She  will try to make things as easier as possible for them.
- **1 Operations engineer**: Once the Mobile App has real users, someone has to make
  sure things work fine reviewing monitoring tools, metrics, adjusting microservices
  instances, APIs status, monitoring releases and so on.

## 3.- Culture

Because the company is starting, or at least we want to use this project to start
its tech culture, I would say that Agile methodologies are needed in order to be able
to have a POC ready in 4 months. A lot of communication is needed between all
stakeholders. There should be appropriate communication tools that will allow that
to happen even when everyone is working remotely. Slack, Google Workspace, Zoom, for
example can do the trick.

The management team has to be very clear with the Product Manager, because she will be
the hinge between them and the tech team. She will have to listen to all of them
after presenting her product definitions because not all things are technically
possible and these issues must be addressed as soon as possible.

Normally a Daily Standup will be necessary in order to be in sync all with each other. At
this moment they are all working in the same product, so every one of them must assist
this meeting.

Tasks for every one will be put in 2-week Sprints and if for example they use a tool
like Jira with Kanban boards, they will have:
- **Product Board**: Product definition and design tasks. For PM, Designer, frontend/native
  engineers and QA engineer.
- **Tech Board**: Tech definition and implementation tasks. For frontend/native and
  fullstack engineers.
- **Devops Board**: Devops tooling improvements and BAU tasks. For Devops engineer.
- **Operations Board**: Monitoring tools preparation and needs definition for engineers.
  For Operations engineer.

After each Sprint there will be a retro meeting where pain points will be addressed and
action points proposed and assigned specifically to someone.

Everyone must trust and listen to any member of the team. All people have interesting
opinions that must be heard and taken into consideration. Everyone should be open-minded,
responsible and willing to learn from anybody. Challenge and prepare to be challenged.

Although the goal is to build a POC as fast as possible, everything must be designed
to be reusable for other projects when possible because this one will be a base
component for the company. 