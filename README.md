# IoBuilders Tokenized Money POC


# Tech

### Mobile Apps
- Shared development for Android and IOS based on React Native/Flutter or other framework:
    - limit costs, complexity and development time
- Integration with a commercial KYC solution
    - the design and develop of a custom solution will be very costly and it's out of the scope of the POC
- Communication with backend services using REST API (https). Authentication based on OAuth2 protocol
    - Identity service
    - Catalog service
    - Shopping Cart service
    - Order Service
    - Wallet App service

### Backend

- **Identity Service**
    - Authentication server based on OAuth2 linked in some way with Alastria to provide a link between traditional app identity
      and digital (blockchain) identity


- **Wallet App service**
    - Functionalities:
        - topup
        - withdraw
        - transfer
    - Tech:
        - Spring boot
        - Expose rest interface to support the functionality above
        - Hexagonal architecture
        - Event Sourcing (Using kafka or Axon)
        - **C**QRS (Using kafka or Axon as above)
        - Event store (MongoDB if kafka)
    - Depends on:
        - EDE service... and other services related with blockchain
    - Risks:
        - Event Sourcing/CQRS complexity


- **Wallet App Query service**
    - Functionalities
        - wallet current status service
        - wallet history
    - Tech
        - Spring boot
        - Expose rest interface to support the functionality above
        - Hexagonal Architecture
        - C**Q**RS
        - Relational database (Mysql or other)
    - Risks
        - CQRS complexity

- **Shopping Cart service?**
    - Functionalities
        - make shopping cart stateful
    - Tech
        - Spring boot
        - Expose REST interface to support the functionality above
        - Relational database
    - Risks
        - No risks detected


- **Order service**
    - Functionalities
        - buy
        - retrieve info from previous orders
    - Tech
        - Spring boot
        - Expose REST interface to support the functionality above
        - Transactions (SAGA?)
        - Relational database
    - Depends on:
        - Catalog
        - Wallet service
    - Risks
        - Transactionality management


- **Catalog service**
    - Functionalities:
        - list items avaiable to buy
    - Tech
        - Spring boot
        - Caching solution?
    - Depends on:
        - External providers
    - Risks
        - Time consuming service if multiple providers exists. In that case probably a cache solution should be used


- **Transversal services**
    - **Api Gateway**
        - Security
        - Traceability (Audit logging)
    - **Aggregation log and distributed tracing**
        - ELK stack, Spring sleuth
    - **Health check**
        - Spring actuator
    - **Observability**
        - Grafana, Prometheus

### Assumptions
assuming deployment on some cloud:
- no service discovery or service registry is needed


# Team
- Product Owner
- FrontEnd Developer/s with React Native/Flutter experience and UX capacities.
- 3 Senior Backend developers with Spring Boot and microservices experience.
- 1 Devops engineer with experience in cloud deployments
- Developer/s with experience in Blockchain/ethereum


# Culture and methodologies
- Agile methodologies (SCRUM)
- SOLID, clean Code. Hexagonal architecture for all services. Gitflow
- Test (Unit-test, Integration test, BDD)