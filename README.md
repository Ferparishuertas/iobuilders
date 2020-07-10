### (1) What are your thoughts, ideas about tech, architecture with this context?

In my opinion there are 2 keypoints of this project that should be crucial to define everything else:

* Since this is a software that involves user identification and money it should be as secure as possible, it should be resistant to failure, meaning if something goes wrong it should be able to recover and do whatever it was meant to do and everything should be encrypted and tracked down for legal reasons.
* As this will be a base project for the company every functionality should be divided in small components/parts, not only because it's easier to develop and test things when they are smaller and have just one functionality but in order to guarantee that any functionality can be easily used across other projects of the company without needing to do adhoc development. 

Taking this into account:

* **FRONTEND**: Because of time to develop the app is short and since the market for hybrid apps keeps growing and feels quite mature we should go that way. There are quite a lot of frameworks that would do the job like React. Ionic (at the end you can even use Ionic + React), NativeScript.. etc. Designs or at least UI/UX look&feel should be defined from the first moment so the app can be divided in components and define schemes, colours, margins.. consistently. WebComponents allow you to create web components in any framework that can be customizable without modifying the core of the component. These components could be shared within the company with tools like Bit.dev (like swagger but for frontends!). KPIs with Firebase Analytics to keep track of user behavior
* **BACKEND**: Microservices aproach should be taken dividing BE in parts like CORE, DAO, REST. We could use classic technologies like Java + SpringBoot or something newer like Golang. Both of them has their pros and cons mainly being that with Go it's really easy to write scalable apps but the perfomance is quite similar even thought Java usually consumes more CPU + memory. FluentD / Logstash logging

Everything should be automatized in order to focus in real manual tasks instead of spending time, for example, babysitting deploys. CI/CD, automatically deploying backend, automatically generating apks/ipas and uploading them to stores directly (this is a bit harder tho!), pipelines to autoformat code so developers don't need to take care of this.

### (2) Describe the skills, roles and team size, that you think is the best fit for this project.

3 Senior FE: 

* Experience with native app development, even if we use hybrid apps at the end we are still developing for that platforms and there many times where you need to dive deep in native features.
* Experience converting designs into real apps with HTML, CSS, JS that are responsive across different sizes devices and adaptable if needed
* Testing skills, unit testings / e2e / appium

* Experience uploading apps to PlayStore / Appstore (and fighting vs Apple!)

3 Senior BE:

* Experience developing microservices
* REST 
* Experience with blockchain, DLT, etc.
* DOCKER 
* INFRAESTRUCTURE deployment

1 UX/UI:

* Really important role in my opinion, should take care of product usability and creating something that is great to see following guidelines proposed by Google and Apple.
* Besides that, it should be a person that has at least some experience with HTML, CSS so he/she can understand developers in terms keeping everything consistent, adapting something if it's overcomplicating development and it's not worth it.
* Designs, prototypes, Flow charts, Mocks

PO:

+ Despite being a company product there should be someone that defines use cases, roadmaps, user stories, feed team with tickets in backlog, prioritazing work.. etc

As it's a quite small team and everyone is senior I don't think there is need for scrum master. 

General skills for everyone: communication, being independent but working in team accomplish our goals helping each other if needed, being able to understand requisites easily, debugging/profiling skills, in general be someone that loves what you do and create something that you feel proud of 

### (3) Go into the details, about which tech/business methodologies, tools, etc...

SCRUM 

JIRA 

GIT, GITFLOW

Open Source mentality

Remote objective based team with few days per week in office

CLEAN CODE / GUIDESTYLES (I.E FRONTEND AIRBNB GUIDELINES)

PR, CODE REVIEWS

DOCUMENTATION

