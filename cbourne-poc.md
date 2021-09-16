# IOBuilders Tokenized Money PoC


## Mobile App
We will build a mobile app that has to be delivered for both IOS and Android platforms. 
This app will be able to create an identity via a Self Sovereign Identity implementation, pass the wallet KYC and create a local wallet and operate with it. Identity implementation and wallet will be achieved by an integration with Alastria.
Wallet operations will be done through a REST api developed in our backend.
Wallet KYC management will need to integrate both Alastria services and our backend services too.

Due to the low technical requirements of the app, it's not necessary to use native developement. Moreover, we don't have much time to deliver the product (only 4 months), so my thought is to use **React Native** for the app developement as you can deliver both IOS and Android versions coding only once.


## Backend
We need to develop a **tokenizer** which will be integrated with inversis and momopocket, to do so we need an e-money license which is already provided. We will also need some solidity development to be able to bring fiat into the blockchain.
We also need a **custody service** to keep track of all the operations over the client wallets.
An **authentication service** will also be needed to validate the client identity with OAuth2, probably also integrated with Alastria.
There will be another service which will expose the **REST API** to operate from the mobile app. This service will call the other services whenever it's needed.

As we want the product to be reusable, we need to decouple our services. In my opinion the best approach for these requirements is to use a **microservices** architecture with **ports and adapters** architecture on each of them to keep responsabilities isolated.

As it is a key point to be able to monitor all the transactions, we will use **event sourcing** to be able to ensure that every change is captured in an event object. This way, we will be able to reconstruct an entity state at any certain moment.

I propose to develop these microservices under **Spring Boot** with **PostgreSQL** databases. We will need some message broker to communicate between our services asynchronously, **Apache Kafka** will fit well for our purposes.
We will also need some other components such as an api gateway, a service discovery tool and a service registry.


## Infrastructure
It must be **cloud based** (Azure DevOps, AWS, Google Cloud...) due to the short deadline to deliver the project.

I will suggest **Azure DevOps**.
**CI/CD** will be a must.


## Security
* Every API call will be identified via OAuth2, and will be over HTTPS / TLS1.2.
* Only the mobile app REST API will be callable from the internet.
* Database encryption.
* MutualTLS to communicate between services is another option.
* Additional measures will be taken into account if needed (probably data encryption in transit or masking them into the database).


## Auditing and monitoring
We will use **ELK** (elastic, logstash, kibana) to centralize our logs and to be able to audit them in a comfortable way.
**Prometheus + Grafana** will give us dashboards to audit our infrastructure.
**OpenTracing** will provide us distributed tracing.


## Team
* 1 Senior FrontEnd Developer - React Native with UX capacities.
* 1 Senior DevOps with cloud, microservices and JVM environments experience.
* 1 Senior DevSecOps with cloud, microservices and JVM environments experience.
* 2 Senior Backend developers with Spring Boot and microservices experience.
* 1 Solidity/blockchain developer with experience (if possible)
* 1 Architect with solid microservices and event sourcing pattern knowledge.
* 1 PO with the whole project concept to coordinate the team and take decissions.


## Risks
One of the key points here are the **blockchain developments** we need to do and the poor experience in this field currently available on the market.
On the other hand, the **microservices architecture pain points and complexity**. Specifically, **event sourcing** is a complex pattern that has a learning curve. It will be a hard work to deliver in 4 months.
Choosing the right patterns and products to use in this microservices echosystem will be a key point too.


## Culture and methodologies
The team will follow agile development methodologies. **Scrum** with 2 week sprints will fit well (maybe not being too much strict on this methodology, adapting it to our needs).
We will follow **DDD and testing** will be a must in every development.
**Nomenclatures and standards**. The team will define an ubicuous language according to the domain objects and will standarize processes and nomenclatures.



