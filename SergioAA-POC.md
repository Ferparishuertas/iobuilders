# iobuilders

## Key Risks
Based on the application description, we may identify a few key risks involving the main components of the PoC and the services it depends on:
| ID | Impact | Probability| Description | Possible Solutions | Notes |
|--|--|--|--|--|--|
| 1 | High | High | Rapid-changing legal and audit requirements to comply with laws | Include legal personnel in the development process to quickly adapt to changes | Current events indicate a high chance of changes in gov. regulations |
| 2 | Medium | Low/Medium | Tech stack longevity, end of support for dependencies | The technologies chosen for the PoC need to be proven, well-established technologies that are known to have long-term support |
| 3 | Medium | Medium | Lack of specialized developers | Team members and any job listings needed should be planned in the early stages and be acted on fast to have enough time margin |
| 4 | Medium | Low| Partner and third-party availability | Design an error-resilient architecture, replicate backend services across multiple geographical regions | Key functionalities of the app depend on third-party availability |
| 5 | Medium | Low| Tech Stack learning curve | Choose technologies that are easier to find fitting profiles for |  |
| 6 | High | Medium | Low security and exposed services| Security experts should be in the team and review / test for any security vulnerabilities|  |

## Architecture
Based on the context of the [project](https://github.com/Ferparishuertas/iobuilders/wiki/IoBuilders-POC#tech--architecture), an *[event-driven architecture](https://aws.amazon.com/es/event-driven-architecture/)* approach, combined with *[domain-driven design](https://www.paradigmadigital.com/techbiz/domain-driven-design-y-arquitectura-onion/)*  should be the best fitting patterns for the back end architecture. The former will not only allow for an efficient scaling and low deployment overhead, but it also facilitates greatly the auditing process.  A *domain-driven design* development process will help with aligning and communicating the business logic between stakeholders and domain experts and developers, as well as creating a well-defined division of the components based on the business logic they handle. 

Due to the loosely coupled requirement for the application and components, as well as the necessity for these to be highly testable and audited, these should be designed as microservices, each organized around the key business logic process (decomposed with the previously mentioned DDD sub-domains). This approach also allows to deploy each service independently and fault isolation, but also increases overall complexity for communications between services, deployments and debugging errors.

Regarding the front end, a [modular and domain-driven design](https://dev.to/crinklesio/how-to-create-a-scalable-and-maintainable-front-end-architecture-4f47) is proposed. Each module will contain the logic for the sub-domain, and the user will interact with each of the modules according to the app routing. Although some coupling will occur, this SoC will let the business logic be well separated and  easier to maintain and scale. 


## Tech Stack
### Mobile App
The mobile app needs to support both iOS and Android, as well as be as reusable as possible, while being quick to work with, due to the length of the PoC. With this factors in mind, the options proposed are as follows:

 - [**React Native**](https://reactnative.dev/).
	 - A mobile application framework based on JS. It allows to develop multiplatform applications with ease, based on the popular front-end framework [React](https://es.reactjs.org/). 
	 - **Pros**:
		 - JavaScript is a popular language and used widely in web and app development nowadays, therefore, it's also easier to find developers with plenty of experience.
		 - Single codebase, JS code is complied to native.
		 - Stable, widely used and maintained by a big community.
		 - High reusability of components.
	 - **Cons**:
		 - Harder to debug than native applications.
		 - Support is not certain and issues/bugs may not be handled quickly.
		 - Not all native functionality is supported, some native knowledge may be required.
		 - Performance is worse than native, with specially well-known bad memory management.
 - **[Flutter](https://flutter.dev/)**
	 - Open-source multiplatform framework by Google, uses Dart as the programming language. The code is complied as a native application and native code may be used within an application.
	 - **Pros**:
		 - Instant changes on the app, hot-reload.
		 - Great performance.
		 - Single codebase.
	 - **Cons**:
		 - Dart is a lesser known programming language, it may be harder to find developers.
		 - It's a young framework.
		 - Smaller community.

 - **Native Application**
	 - The applications may be also developed with the native tech stack, using Swift for iOS and Java or Kotlin for Android.
	 - **Pros:**
		 - Best performance out of all options since code is already native.
		 - Well-maintained and stable development environments, so support and bug-fixing is the best out of all options.
		 - Easier to debug.
	 - **Cons:**
		 - Multiple codebases, each platform has to have it's separate application and may not be shared between them.
		 - Lower reusability.

The recommendation given the requirements would be to use React Native, since we can have a single codebase for the application, reuse components more easily and it uses JavaScript, a popular and well-known language. Native applications require to develop a single application for each platform, so the resources and time needed could extend over the PoC's 4 month deadline.  

To add to this stack:
- **Testing:** Can be done with [Detox](https://github.com/wix/Detox), one of the most popular testing libraries for React Native.
- **UI**: [React Native Elements](https://reactnativeelements.com/) is an UI component library that may help with the early stages of development, so components can be quickly thrown in and iterations on the design and usability of the application can be done faster and more efficiently. This may be then replaced by self-made ones once the UI and UX design choices are fully known.

### Back End

Since the back end is designed around a microservices architecture, some centralization of incoming requests and events is required, so the mobile app may interact with the different components and systems. The following is a solution based on AWS's services, but it may be done with the analogous services on other providers.
- **CloudFormation**, for fast infrastructure provisioning and better documentation.
- **EventBridge**, essentially an event bus with added functionalities and better integration with AWS services. It makes event auditing and security easier to manage and can be integrated with third-party services with ease. Events can also be replayed and archived to ensure consistency.
- **API Gateways**, for both public and private facing APIs.
- **SNS**, to send the processed events  from the bus onto the specified services.
- **JWT/OpenID Connect/OAuth2** for authentication and authorization, integrated out-of-the box with EventBridge. 
- **EKS** or **ECS** to deploy and manage the containerized services.
- **CloudWatch** and/or **Elastic Search**, for auditing and logging and querying logs.
- **MongoDB** for the persistence layer.
- **Java/Groovy (Spring)** or **NodeJS** may be used for the underlying language. Java is more robust, but NodeJS can offer better development timing since is JS and used in the mobile application. Both of these languages have SDKs for the aforementioned services.
- **VPC**, to isolate critical systems and services from the public cloud.

### Other
#### Version Control
Any Git based version control platform, such as GitLab, Azure DevOps or BitBucket. It's important to have support for CI/CD workflows / pipelines, if possible.
#### CI/CD
The platforms mentioned above have CI/CD capabilities for the tech stack proposed. If needed, other solutions, such as Jenkins, can also be used, due to knowledge within the development team members or other factors. AWS also has solutions such as CodeBuild or CodePipeline for these purposes.

## Team
The team in charge of developing the PoC could look like:
|Role|Quantity|Notes|
|--|--|--|
| Product Owner | 1 | To communicate with stakeholders and domain experts. |
| Team Lead | 1 | Experienced tech lead that will distribute the work, communicate with the developers and the product owner and establish priorities and facilitate decision-making in core issues. |
| Senior Backend developer | 1 | With experience in Java (Spring) / NodeJS, preferably with serverless computing experience and NoSQL databases, experience with CI/CD. |
| Senior Frontend developer | 1 | With experience in React Native, experience with CI/CD. |
| Senior Full-Stack developer | 1 | With experience in React Native and Java (Spring) / NodeJS, experience with CI/CD.|
| Blockchain developer | 1 | With experience developing in the Ethereum network. |
| Cloud Engineer | 1 | With experience with AWS, experience with CI/CD. |


## Culture

Task organization and communication between team members is at the core of a successful development process. 
Choosing the right methodology and creating the environment with all the tools and resources members may need to organize is critical.
Since it is required to have an autonomous and multifunctional team, an agile structure is a great candidate to organize the project.
Some key concepts include:
- **Code Reviews.** Allows to share knowledge and expose team members to new ideas and points of view, as well as identifying logic mistakes early. 
- **Mentoring.** Team members sharing knowledge between them.
- **Shared Skillsets.** As members share knowledge, they will be more capable to be autonomous and multifunctional.
- **Continuous Feedback.** Feedback on progress and decisions made will help meeting the key goals and deadlines.

Daily meetings might be necessary at the beginning, if the team members have not worked together yet, to promote better guidance from the team lead, roles are well established and more feedback is given.

Sprints can be allocated to two weeks as an initial value, but can be adjusted if necessary further on.

In order to promote efficient communication and a proper environment to organize, a few tools can be used:
- **Slack.** Create channels for the team, keep resources and important announcements in the channel to better isolate project-related information. Members will be encouraged to share new knowledge, make questions and share resources related to the development in this channel.
- **Jira + Confluence.** Agile project management tool and shared pages tool that makes setting up the project plan and documentation faster and more efficient. It's very versatile and allows to keep track of issues, bugs and plan sprints.





