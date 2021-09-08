# IOBuilders Tokenized Money - POC

In this document there are some information about the analysis and documentation for develop the Tokenized Money Solution.

This is the First Exersise with the information about:

1. Tech Risks, ideas and information about the technology selected and some architecture points.
2. Team Skills, roles and all the information needed for develop this POC solution.
3. Cuture used for the several methodologies used for this POC.

## Tech Risks

First of all, we need to see all the tech risks and points needed for create this solution.

1. **Security**. This is our main risk. We are working with real money (crypto currency and real money); so we need to maintain all the security for use this prupose.
2. **Scalability**. Our application can grown in number of users and (and its one of the more important features) in number of services (wallets and pay services). So we need to focus in this risk too.
3. **Trazability**. We have several important operations; like money transfers (even with crypto currency); so we need to trace all the operations of our system.
4. **Failure Tolerancy and Asynchrony**. Our system should be robust; so we need to maintain the Failure Tolerancy when we use third party services; so all the Third party connections should be Asynchronous.

After see the main Tech Risks, we need to study all the parts of our solution and see how to minimize all the earlier mentioned risks.

1. Mobile App

We need to study how these apps (mainly developed for Android and IOS) should be developed. We can see some Hybrid technologies like IOnic or Xamarin, or develop the apps using Native Technology. We need to see the Pros and Cons of the use of Hybrid:

* Pros: More Quickly Developed.
* Cons: Can be some Security Problems and maintenance issues that can be at risk with our main tech risk.

After the Pros and Cons study, I think that we can choose the **Native Development**.

2. Wallet

This is one of the main feature of our solution, there are some Wallets for use with some pay services and use with some crypo currency services. So we need to create our applications for use with some of this wallets and of course, increase the number of these wallets with more integrations.

3. Payment Services.

Our Solution, need to connect to some Payment services for transfer currency change; so we need to integrate our system with some Existing Payment services; like:

* Banking Payment Plattform (Ie RedSys).
* Stripe.
* Paypal.

4. Trazability

As one of our Tech Risks, we need to focus on the trazability. So we need to log all the events and operations of our system. We can use some solutions like ELK (ElastickSearch+LogStash+Kibana) for trace all the operations and events.

5. Failure Tolerancy and Asinchrony.

This is another of our tech Risk; so we need to minimize the failures using Asinchrony for the atomic operations like money Transfers depending of Third Party Services (IE for downtime issues); we can use some Message Queues solutions like Apache Kafka.

6. UX

One of our main features is the design and usability; so we need to create a UX research for all of the designs and focus on this feature. We can use some tools like Invisio for create some MockUps or prototypes.

### Architecture

Once seen the main Tech Risks and some of the main features of our POC solution, we can see the architecture of our system, focus on the backend. We can use some aproximations.

Our First Backend entrypoint its a Restfull API for connect with all of our services. This is important for isolate the Apps/Web developments of all the connected Services.

The use of a REST API, can be very usefull for use with some architectures like the Microservices approach; we can develop some microservices for each services connected or each feature provided for our API; and focused on high scalability.

Also, we can focus on another important architecture approaching; like the use of DDD (Domain Driven Development); because we are focusing on our domain (Tokenized Money and Crypto Currency). So we can create our solution using this architecture too.

Next, after see the main points of our architecture, we need to decide the main technology used for create our API and all the Backend Services; we can choose one of these techonologies:

* **NodeJS**: We can use NodeJS for create our Backend App, because we have some important documentation and its focused for a some microservices approaching (using frameworks like Express,etc.).
* **Java or Kotlin (JVM)**: We can use Java or other JVM based languajes like Kotlin, for create the microservice architecture, using some usefull frameworks like Spring Boot due the lot of information that we can see and the quickly development and deployment times.

After see the two choices, I think that de Spring boot + Java (Or Kotlin) approaching can be the most usefull techology to use.

**Deployments**

This is one of the most important things for our system. Our system needs to be deployed on a environment that must be strong and needs to be easily maintained. Of course, there is one important point; the use of best practices, and use of Continuous Delivery using some platforms like Jenkins or other CI/CD engines.

We can use some Cloud approach like AWS or Azure, for deploy our software (of course we can use containers like K8s or other solutions like OpenShift).

We need to decide the best solution for our system after study all the early points.

## Team

Once see the main architecture points, we can focus on the team needed for the apps, web, API and QA members:

* **2 Backend Dev.**
* **2 Android Dev.**
* **2 IOS Dev.**
* **2 Front Dev.**
* **1 UX Analyst.**
* **1 Tech Lead with Domain knowledge** as a Scrum Master and Tech Lead.
* 1 **QA Analyst**. For some Quality and testing prupouses.

If we follow an agile Approach like SCRUM, we need a **Product Owner** for stablish priorities and some changes during the development.

## Culture

As noticed before, we can follow an agile methodology like SCRUM; so we need to follow the 1 o 2 weeks Sprints, to develop the solution; lets check de time in each case (we have 4 months for develop the POC).

* For 1 Week Sprint we have 16 sprints. This can be usefull for highly adaptated teams and can be great for fast changed user stories. But its not recomended for use with othe cases.
* For 2 week sprints we have 8 sprints. This is usefull for highly focused teams and can be a great choice for our solution.

After see the two choices; I Think that we can use **2 week sprint for our solution with 8 sprints**. We can use some usefull tools for register the User Histories like Jira or Notion.

For last, its very important follow the bests practices for our POC Solution; so we can follow the next recomendations:

* **Code Reviews**. Its very important for use code reviews (IE Pull Request with code reviews approvals) with all the features developed.
* **CI/CD**. As we mentioned on the Deployment part, we need continuous Integration and Continuous Delivery for our development and deployment; using tools like Jenkins or others CI/CD engines.
* **Security reviews**; one of our main tech risks its the security so our code and our solutions need to be persistently reviewed in order to minimize the security issues; we can use some code static analysis like sonarqube or kiuwan.
