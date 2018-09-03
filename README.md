# iobuilders
# Tech + Architecture
Regarding that we are going to do a POC we should focus on implementing business logic and reducing as much as possible any technical issue, delegating the infrastructure in some vendor.
In order to know the POC complexity and which technologies we should use, we have to work closelly with the business team to identify the different scenarios, business risk and prioritize them.
Focusing on the system architecture, let's start with the mobile applications.
## Mobile app
Here we have two possibilities a native app or a webview (except that it's not mandatory have the apps in the stores, otherwise we can skip the webview and access through a browser).
We need to identify the pros and cons of each client in order to take a decision:
### Native app
#### Pros
 - Great user experience (UI & usability)
 - Native SDKs (supposing that they exist for the vendors that we choose)
#### Cons
 - In order get a great user experience you need UX and iOS/Android developers which knows perfectly the native components, otherwise the experience could be even worst compared to a webview
 - Fragmentation of Android devices
 - Development speed compared to javascript
 - People doesn't need to update to the latest version, what will happend if we have a bug which allows the user to exploit some system feature, we have to add other mechanism to deactivate some feature or versions
 - Release cycle
### Mobile web app
#### Pros
 - Easy to develop and iterate
 - Bug fixing for every user
 - One app covers iOS and Android
##### Cons
 - Are there libraries to use the wallet or other needed systems
 - Worst user experience (UI & usability)
 - Browser fragmentation (we can reduce this impact using some library, like Babel)
Regarding this, I would suggest to use a Mobile web app. If we need native capabilities like push notifications we could choose to create a Progressive web app. Although I'm not an expert in frontend, it's possible create a simple web app using tools like firebase and you could even have hosting with them. In this case you don't need to have your own web server or create some platform to deploy this app. Another point is to evaluate the possibility of using server side rendering and leave everything on the server side, if we choose this option we should check the wallet integration just to confirm that we will be able to interact with it.

Based on my experience we should try to create the app as thinner as possible. I mean, the app should only have the minimum business logic and the backend part as much as possible. With this we improve the security, less code is delivered outside of our system, and maintenance, it will be reduced just to UI changes (if possible).

If we proof the hypthesis behind the POC as valid, we could start thinking of using another provider to host the web app, create a newer one using some javascript library from scratch (Vue, ReactJS, Angular...) to remove the dependency with firebase and even move to a native app now that we gain knowledge about our users and about the business logic, so we are less prone to make mistakes.
## App services
This component will be composed with several modules, so this component should be as much secure as possible following good practices (i.e.: OWASP).
As we are doing a POC we should identify the most important pieces of the component and have a clear idea about their responsabilities and business logic before we decide and architecture.
Probably the easiest architecture to start with is having a main module which coordinates each transaction and different smaller modules which will be the gateway with the different external providers.
### Gateways
This gateways should convert our own domain to the providers domain and they will isolate us from any change performed on the provider. This modules should be reusable for future POCs as we have the integration done. Based on this we can create different modules to do the integration with momopocket, inversis, etc.
Regarding the technology used to implement them I suggest to use some serverless infrastructure, with this approach we could have all the business rules implemented and if at some point we need to move to a different infrastructure we won't need to change any business rule. Also it's important that we can audit all the transactions.
We can evaluate too the possibility to have an API-gateway module (Backend for front), within this module we can add security to the system and create an homogeneus layer for the front apps. This module could have a RESTful API or we can think in other transports like GRPC with protobuf or flatbuffers. This API-gateway will comunicate with the different services which can compose the controller module.
### Controller module
This module should be a unique module (when we implement it) at the beginning to control the business rules, but if at some point it starts growing too much, we feel that it's taking too many responsabilities or we see that we can reuse some part in other modules across the company we should start breaking it in more modules. For that it is important that we create that module following some pattern just to help us later to split it in several modules (Bounded context if we are using DDD). In order to implement this module we could use also a serverless infrastructure with the different use cases that we have.
### Audit system
If we need an audit system we should evaluate which fields will be the base of our audit. We will need to generate unique ids for each transaction, a unique id for a user so we can trace back all the activity for that user and the worthiest fields. Regarding this we will need a UUID generator for each transaction, this could be a responsability of the audit system or probably we can create a service when we feel the need to reuse it in other parts of the company.
When we start with the implementation of this system we should evaluate to use the infrastructure to have this audit so we don't need to call from the business logic (although if it's a business requirement may be it's important to have it explicit in the busines logic so if at some point we refactor we don't lose the feature just because the infrastructure changed).
Probably for this audit system we could use elasticsearch and kibana so we could have a dashboard to check any issue very fast or if we use the same vendor for our serverless infrastructure maybe he provide some mechanism to audit our services.
Imagine that we use elastic + kibana then we should decide if use something like logstash, fluentd or create an scheme in elastic and use the API directly.
Another approach will be evaluate the use of a eventsourcing system. In this case we will already have an audit system in which every transaction done in the system will be audited. We will need to create some UI to show  But this comes with some costs because it's not something natural for a regular system but if we feel that every application in the company will need audit probably we can reuse it for other projects. With this approach we need to evaluate the use of CQRS. But I'm not an expert implementing this patterns.
# Team and culture
Every team member should have a can-do attitude and a business mindset. This is important above all for UX and Tech people because it's really easy lose the focus and design things losing usability or trying to use good technologies but complex at the same time. As this is a POC we need to iterate fast and make quick decisions, learning from our fails and trying new approaches of some of them didn't work.
## Business side
As we don't have too much time to evaluate all the scenarios we will need at least one business person with a lot of experience in banking and it would be nice if that person has also experience with blockchain, so we can handle, define and prioritize properly the different functionalities of the system.
UX as our app needs a very good user experience we will need an expert designer, moreover if we decide to use native apps he must have a very good knowledge of native elements.
## Technical side
On thechnical side, as this is a POC the team should be relative small. And we should start since the beginning with every member, otherwise we will slow down some member due to on boarding tasks.
Probably we will need some expert on the different technologies that we decided to use but each team member must have really good communication skills just to explain others how to be proficient in that technology.
Also team members must have a full stack mindset trying to learn from each others, so if we need help on some module others can take the lead and do the job.
People should have in mind to be proactive and try to help each others even if it's not his responsability (i.e.: The PO can help doing some manual tests or the UX doing pixel perfect).
Another important thing is that the company must encourage this practices and help the people to reach all his potential.
