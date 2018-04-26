**(1) What are your thoughts, ideas about tech, architecture with this context?**

Several items to bean in mind:
* Application designed in several layers, mostly based on REST services stored on the cloud
* Key points are identified as Performance, Traceability and Security, and for this:
    * Core modules are independent and isolated in one layer in order to keep security, as this is one of the key points
    * To enhance the performance, some data can be stored on a **cache**, which can be based on Redis
    * Communication between components are based on REST and Messages (with ActiveMQ. Redis is also available for this matter)
    * Data storage (apart from logs) can be both relational (PostgreSQL) or non relational (MongoDB). The first deep analysis will determine the one to be chosen.
    * Encryption is also key part as stored / transmission data shall be encrypted due to LOPD and other regulations.

* Front based on React Native, in order to be able to deliver to IOS and Android, and also web clients. UX analysis is highly recommended
* Short developments for small modules, inter-related as dependencies / inter-communicated between them.
    * Small modules are great for POC's, as easy to drop
    * In order to get quick success, different QA thresholds might be defined
        * For POC's
        * For consistent modules
        * For final modules.

**(2) Describe the skills, roles and team size, that you think is the best fit for this project.**
* Team
    * 2 Front Ends : React Native and UX design - Create well designed and usable web / mobile apps
    * 2 Back Ends (or Full Stack) Java developers - Core, and APIs and Messages for Mobile & inter-module communications.
    * 1 / 2 Back Ends BlockChain (Go / Java) - Blockchain layer.
    * 1 DevOps (optional but nice to have) - to Ease the lifecycle, deployments, and automated processes
    * Scrum positions (Scrum master, PO ) - Roles to be taken within the team
* Culture
    * Flat hierarchy team
    * Agile (Scrum?)
    * Autonomous but team oriented
    * License to the team to choose technology
    * Flexible and Remote work!
    * Nice to listen, talk and complain... good on receiving feedbacks (good and bad ones). Focus on learning from each-other
    * Some team meetings  / Inner tech talks / beers
    * Coffee required / Fruit desired
    * Clear tech debt when possible (A void sprint?)
    * License to talk bullshit.... some ideas might become from it

**(3) Go into the details, about which tech/business methodologies, tools, etc..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company

* Development
    * Agree in a code style / formatting (We can use Google's by default.)
    * JIRA stack is a nice to have
        * Bitbucket for VCS
        * JIRA for scrum
        * Confluence for documentations
        * Bamboo for CI/CD
    * Slack for team communications
    * Philosophy:
        * Git flow: Branch on each user story / Task, pull request, code review, merge to develop branch
        * One branch with valid products. Always
        * Git hooks to ensure quality before push to repo, to ensure code quality
        * After merging, SONAR will report metrics, coverage, code quality, tech deb.
    * TDD as much as possible, but balance between speed and QA
* Architecture
    * SpringBoot for services
    * ActiveMQ / Redis for queues
    * Redis for cache
    * MongoDB / PostgreSQL / Redis for storage
    * AWS for cloud
    * Docker for containers
    * LogTool TBD (LogStash? / Paid solution)
    * Front:
        * React Native
        * D3.js for graphics
        * Leaflet for maps (if applicable)
