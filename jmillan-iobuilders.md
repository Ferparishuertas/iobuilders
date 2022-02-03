# Tokenized Money - ioBuilders

- [Tokenized Money - ioBuilders](#tokenized-money---iobuilders)
    - [Tech + Architecture](#tech--architecture)
        - [Proposal](#proposal)
          - [Vendor Lock-In](#vendor-lock-in)
          - [Security](#security)
          - [Integration](#integration)
          - [Data Governance](#data-governance)
        - [Tech](#tech)
        - [CI/CD](#cicd)
    - [Team](#team)
    - [Culture](#culture)
        - [Agile](#agile)
        - [Tools](#tools)

## Tech + Architecture

### Proposal

In order to manage some identified risks as:

#### Vendor Lock-In
Microservices architecture based on a kubernetes cluster in the cloud. In that way, we will control the dependencies of the cloud provider.

#### Security
As only point of entry to the system we will need an API Gateway to manage routing and security.

To handle authorization and authentication, we will implement an auth server with an IdP integration. This solution will give us
flexibility to add as many clients as we want as it will support OpenID connect, SAML and federated users, including native mobile 
apps via authorization code flow + PKCE for this case.

#### Integration
Microservices with API-First focus with the goal of keeping all of these services as atomic and decoupled as possible, making it integration easier.

#### Data Governance
It would be appropriate to create a tracking subsystem to obtain the events related to each operation and its correlation with 
Blockchain to persist all the information related to each flow.

### Tech

For **Mobile application** consider using React Native. As a JS framework, it is easier to find technical profiles with 
experience with that language. Using Flutter was an option, but Dart is less popular than Javascript for finding developers.

For the **Backend** my proposal is to develop all the microservices with Spring-Boot because it is one of the most popular frameworks 
and for this reason, it will be easier to find developers. These services will be behind an API Gateway. One of the best options it
could be Kong as Kubernetes ingress controller. It is one of the most loved Gateways, it is simple and highly configurable. 
There are many plugins to configure and extend it, and you can develop new plugins in Lua.

All the microservices will be developed with Hexagonal-Architecture to separate business layers making it more maintainable and scalable.

Like the input adapters, these services will expose an API through the API Gateway, but the communication within the system will be asynchronous, 
being able to have several subscribers to the same brokers and allowing tracking information to be consumed and displayed through a
backoffice for example.

In order to monitor whole system logs, the ELK stack implementation is proposed. 

For the traceability of a distributed system, considering the development of microservices with Spring-boot, Sleuth + Zipkin are a good option.

### CI/CD
If we use GitHub, could use GitHub actions for the CI/CD flow, building each service image and pulling it into repository to deploy with Helm.

## Team

In my opinion, to carry out this poc in the estimated period of 4 months, a multidisciplinary senior team must be available.

We will need the following profiles:

- Senior solutions architect with leadership capabilities
- One senior frontend developer with experience in React Native
- At least three senior backend developers if it's possible with knowledge in Blockchain
- DevOps partially implicated
- Scrum Master or Agile Coach if we achieve mature profiles

I think that communication and leadership skills are almost as important as knowledge and experience to achieve team goals, and 
for me, one of the most important things is support the proactivity of all members, because quality comes from quantity.


## Culture

### Agile

Scrum will be the agile methodology to apply, with 2-week sprints. 

In my experience, 2-week sprints are a good period to deliver value.
We will have a DoR and DoD to focus on delivering value.

Scrum has many benefits to help maintain focus and achieve greater efficiency.

For this, it is important to have all the necessary information to define the backlog correctly and focus the planning and refinement ceremonies.

### Tools

In my experience, Jira is the better tool to managing team work projects.
