# IoBuilders Tokenized Money
## Tech + Architecture
### Risks
Technological complexity - Selecting immature technology / framework can add unnecessary complexity.
Work team - Having an unqualified team requires training time, which can affect project times.
Planning and control - Not having the requirements properly detailed  or lack of follow up can delay the project.
Security - The exposed services are a problem for all systems and being a system that manages money is of greater interest to computer criminals.
### Architecture
The project must follow good software development practices, a model based on microservices is selected to maintain weak coupling, with REST integration for client-server communication, allowing easy scaling in containers.
For the KYC requirement, it is proposed to use an OAUTH2 server linked to the public key of the client's wallet.
### Backend
The proposed backend technology is JAVA with the Spring Boot framework, due to the number of developers who have experience with this technology, it also allows us to use components such as Spring Security to secure our services, Spring Cloud Config to facilitate configuration management, among others. others.
For communication between microservices, it is proposed to use a message broker such as Kafka or RabbitMQ and for client-server communication, an API Gateway would be implemented as the only entry point for mobile applications, to facilitate security monitoring and management.
PostgreSQL to store data.
OpenID Connect/OAuth2 for authentication and authorization linked to the clients' wallet.
### Mobile App
React Native is a framework for the development of iOS and Android mobile applications, it is popular which makes it easy to find specialized personnel, with TypeScript as a superset of JavaScript, adding features facilitating the maintenance of large-scale applications, one of the main disadvantages of React Native is that the applications are not completely compatible between platforms, so specific issues must be addressed for each operating system.
### Infrastructure and Deployment
AWS EKS Fargate for container deployment.
AWS ECR to store Docker images.
GitHub and GitGitHub Actions for code versioning and CI/CD.
## Team
- Product Owner
- Team Lead
- Senior Full Stack Developer
- Senior Backend Developer
- Senior Frontend Developer
- Blockchain developer
- QA
## Culture
### Agile
Use the Scrum methodology, hold 15 minute meetings or use tools like Slack's Status Update to notify blockers and tasks on a daily basis. Maintain good practices in using Git, use Pull Request to push changes to test and production branches, require peer approval to continue pull request.
### Tools
- Jira
- Confluence
- Slack
