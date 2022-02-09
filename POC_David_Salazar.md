# IOBuilders Tokenized Money PoC

### Tech + Architecture

For the proposal of this project based on the need for quick wins and fast lanes we will use tools that give us confidence, fast learning, support / documentation and a wide range of experienced developers

## Risks

The main risks for this PoC are:

- The hiring of personnel with the necessary skills for the required roles
- The time available for the development of the project
- Information about third-party components
- General level of complexity of the project

## **Mobile App**

For this scenario it is proposed to use React Native; javascript framework based on react for the development of cross-platform mobile applications. It has excellent documentation, a wide range of developers and, being javascript, it allows us to use the available Web3 tools that exist in this language.

## Backend

This will be one of the most complex and critical components; since it will be the communication bridge from mobile clients to our services, so a scalable, resilient and fault-tolerant design is needed. It is proposed to use an architecture oriented to (micro)services deployed with containers

### Programming Language

It is proposed to use Java as the main backend language and Spring as the main Framework. This is one of the most used languages in the world and one of the most important worldwide and has an excellent offer of experienced developers. 

By focusing on a (micro) service-oriented architecture, other languages can be used, depending on whether they are more efficient in a future use case.

### Code Repository

For this case, it is proposed to use Gitlab, which is an open source project, with a large community and that allows us unlimited private repositories in addition to services for deployment. 

### Design Patterns

For a case like this, you need an architecture that can be scalable and event-oriented. For this, it is proposed to use the standards of the [Clean arquitecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), the patterns of [Domain Driven Design](https://martinfowler.com/tags/domain%20driven%20design.html) and [Event Driven Architecture](https://aws.amazon.com/event-driven-architecture/).

### Cloud Provider

An important part is choosing the cloud provider to deploy our applications; It is proposed to use the most popular option on the market: AWS. It has great documentation and support that will help us implement our architecture in the fastest way.

The most important services that we would need from this cloud provider for the proposed architecture are:

- ECR
- ECS
- Cloudwatch
- CloudFormation
- SQS
- SNS
- S3
- EC2
- Lambda
- Route53
- ELB

### To consider

A template with the proposed design patterns written in Java can be found [here](https://github.com/DaveSalazar/java-clean-arch-ddd), and will allow us to quickly start the project

The SNS and SQS services in combination will allow us to implement the Event Driven Architecture design pattern. As an alternative to these services, there is Eventbridge, but due to costs and ease of implementation, SNS/SQS is chosen.

The code analysis for quality and security issues, Sonar Cloud is proposed

### Team

The equipment needed to carry out this project consists of:

- Team Lead
- Senior Backend Developer
- Senior Mobile/Frontend Developer
- UI/UX Designer
- Blockchain Developer
- DevOps Engineer
- QA
- Product Manager

### Culture

The main methodology to use will be SCRUM, since it is the most standard in the field and most are familiar with it. The tool that is proposed for the management of tasks and sprints will be Jira.

The project time will be divided into phases, each divided into sprints

Code reviews in each Pull Request and that has at least 2 team reviewers

Promote the documentation and registration of the components that are developed

Something to consider is to provide perks and benefits to the team, that the work be more than stressful, fun 😉. For this some benefits to offer could be:

- Gym membership: Healthy body, healthy mind **🙂**
- Subscription to education platforms: These can be courses from Udemy, Platzi, Codely, etc.