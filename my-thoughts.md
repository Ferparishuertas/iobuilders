# What are your thoughts, ideas about tech, architecture with this context?
 
While Blockchain technology maintains its open source spirit, it is important to identify the tools and frameworks maintained by entities committed to the technology. That is why it is important to offer a solution supported by a broad community and businesses. Ethereum has entities such as ConsenSys that support development, which we can take advantage of with tools such as wallets, testnets and other tools, with the assurance that they will be maintained over time.

We must take into account the scalability of the blockchain system to be used, now we work on a PoC and the number of users is insignificant, but scenarios with real activity would have to be simulated. But not only you have to take into account the activity of your system itself, Ethereum is a global system, if the network saturates your application no matter how good performance you got, it will also be affected.
Using a private blockchain like Quorum (fork of Ethereum) would make the network much faster, but the developed system would no longer be decentralized.
Another option is to use a layer on top of ethereum, which allows instant transactions, like the lightning network in Bitcoin.
These layers or solutions can be very useful, such as atomic swaps between Ethereum tokens, something that can be useful if different assets are digitized.

Blockchain stands out for its security in the protocol, but in the first instance it is humans who add code with Smart contracts to the chain. And because of this it becomes dangerous, it is important to create unit tests for smart contracts and beeing reviewed by third parties, in addition to testing it in the respective testnet. In this case, as a PoC, a production audit would not be necessary.
In addition, one of the issues with Smart contracts is the cost of its execution, therefore it is important to minimize the computation and storage of information (IPFS).
If you want to link a bank account with the mobile application, it is necessary to have a payment processor, either given by the bank itself or using an intermediate tool or gateway, this is Inversis.

#### Infrastructure
La infraestrucura de la app móvil se desplegaría en una VPC de AWS, en donde necesitamos almacenamiento especifico para los logs, ya que es importante monitorizar la actividad del sistema, tanto en tiempo real, como en modo histórico.
Esta información quedaría almacenada y accesible a través de una instancia S3.

Para notificaciones crearía un servicio en Kafka y un sistema CDC (Change Data Capture) para automatizar los avisos sobre cambios y actividades de nuestras bases de datos o del la propia blockchain, y además. Ambos servicios los lanzaría sobre una instancia de ElasticSearch.

El resto de funcionalidades las implementaría a modo de REST en otra instancia de ElasticSearch servido por nginx. Aquí haría uso del framework Express.js con algún tipo de autentificación para establecer la conexión segura.

Entre todos los servicios de la VPC configuraría las comunicaciones con Kerberos, para asegurar las conexiones con el uso de certificados, sin contraseñas. 
La comunicación con la red abierta y el resto de usuarios lo haría con un Gateway al vpc bajo un dominio, que permita el uso de ips dinámicas.

# Describe the skills, roles and team size, that you think is the best fit for this project.

Team member profiles:
1. Backend developer, He would use node.js for the server as REST with Express.js. Knowledge to consume from databases as Postgresql or other services such as Kafka is a plus.
2. Frontend developer.
React native for the user part, as a framework for the mobile app. Knowledge with boostrap and material-ui or some other similar framework.
He knows how to work with the state of the application, share data between the components and it would be good if he knew how to use Redux.
Knowledge to configure calls with authentication such as OAuth, Kerberos, or SCRAM.
Also that he knew how to interact with the device's sensors, such as the camera or biometric sensors.

3. System administrator. With experience in Linux and cloud environments like AWS. It would be in charge of setting up the development environments, only integration, including the maintenance of the instances, security, users and services launched in it (such as databases, microservices, authentication, etc.).
It would also be nice if you had knowledge of Devops to create a pipeline that automates development and deployment, from local to cloud environments, making use of version control such as git from the Gitlab platform.
Here you could establish a process with Jenkins for testing, Sonarqueue for the quality of the code and finally store the binary files in a service like Jfrog (Artifactory), from which you need access from the cloud instances.
In this project the role of system administrator is not as relevant as it would be in a production project, since most environments and tests will be performed locally.
1. Blockchain engineer.
Deploy the ethereum blockchain locally, with which we can interact and test.
Create a light wallet, for this you can make use of open source wallets from an entity or prominent development group in the Ethereum ecosystem, such as the ConsenSys eth-lightwallet wallet. This wallet already comes with the features to send, receive, etc.
Knowledge to encrypt your private keys and your off-chain data, based on a biometric sensor or off-line access key. The ability to regain access in the event of loss of the secondary key is also required, based on a 2factor auth system, such as SMS or email in the worst case.
Knowledge to create fungible tokens to digitize assets such as ERC-20 and to create and manage identities with ERC-725. Both with the Solidity programming language.
Knowledge to interact with the IPFS protocol and its integration in Smart contracts, for off-chain data management without fattening the blockchain and reducing gas costs.
Knowledge to cover and create the corresponding unit tests.
1. Project Manager.
This person would be in charge of directing the team, he would be the one who worked at the highest level of abstraction. He would be in charge of developing the business logic based on the requirements requested by the client. It is important that communication with the rest of the team is clear, since any misunderstanding can generate unexpected behaviors in the final logic and since the tests would not be complete.
Therefore, having knowledge of the databases and models that represent their information would be the most appropriate.
In addition, it is necessary that, as the main connoisseur of the project requirements, he is in charge of the system architecture, identifying the needs and limiting them to the solutions proposed by the systems administrator and the rest of the team.

# Go into the details, about which tech/business methodologies, tools, etc..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company
 
As it is a PoC, the objective is not to launch an application into production but to test whether a use case is technically feasible. With a development duration of 4 months, the development follows the same model as any other project, it would be appropriate to establish a control point every day first thing in the morning, with 15 minutes on average is enough. Here each one would explain what they have done, what they are working on and if something is blocking them. This last part is the most important, and it is the one that should be prioritized, so that no partner is blocked and development continues to advance.

I would develop a basic guide for setting up your pc, to install everything necessary for local development and testing.
This is useful to have so that any new member or fellow can adapt more quickly.

It is possible to work under the SCRUM methodology, with which to establish objectives in time, and thus structure the development in the first instance, although we all know that these dates are indicative, unforeseen events always arise.

As a development methodology I would use TDD, in which the tests would be conditioned by the logic requirements established by the Project Manager.
Unit testing and peer review in Smart contracts is essential, a small bug can cause the loss of a lot of money.

In terms of code maintenance, I would establish two main branches, master and develop. The develop branch is the main one for development, from which we create new branches for more specific developments. After adding a new feature, merge to the develop branch. Once the proposed features have been implemented and all the tests and quality of the code have passed, it is when we create a stable relay to merge master.
It would be useful to have tags in commits, such as 'feat', 'fix', 'test' to reference the topic of the update in the first instance.

It is important to create a base library that abstracts the most complex and common functionalities, both in the backend of the application with Nodejs, as well as in the custom components in React Native. So they can be reused in the future or for other projects.
In the same way, the corresponding libraries should be created in Solidity.

