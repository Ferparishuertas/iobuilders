##RISKS
******************************
Time limit
Security and compliance
Reusability
Budget
Team management


##Mobile App
******************************
Options:
 - CrossPlatform (ReactNative) :
 	- One codebase 
 	- Quicker solution 
 	- Lower budget (developer)
 	- Device issues


 - Native (Android & iOS SDK)
 	- Two codebases 
 	- Performance and security
 	- higher budget (developers)
 	- Device support
 	- Community
 	- UX

 -- Although time is a mayor issue,  time is likely enough  to develop the app natively (involves 2 codebases and longer time to market). I believe it would be a better option given the nature of the project and the importance of security and performance.  


##Backend
******************************
Microservices or Service oriented based on team experience. Microservices add a level of complexity although in the long run provide greater benefits. As time is a mayor issue a SOA approch is probably a good alternative as it will allow for decoupled services and an easier down the road migration to proper microservices. Event driven, this allows for decoupling, scaling and  store/audit all transactions by event processing and persistance.

- REST API layer to respond to the mobile app Mobile APP.
- Event streaming platform 
- Event processors to interact with the different domains.
	- Fiat Money: implies interacting with 3rd party and internal exchages
	- Crypto: cryptocurrency operations
	- Auth: Authentication and Authorization
	- Exchange fiat-crypto: This is really a cross domain interaction and implies interacting with both Fiat Money and Crypto domains.


##Technology:
******************************
REST APIs : Java Spring Boot or NodeJs are good alternatives, quick development, great comunity and large developer pool
Event streaming - Kafka or even full Confluent - "De facto" standard, full Confluent platform hosted on all 3 mayor cloud providers (AWS, GCP, Azure) easy curve and free tier 
Event processors : Again Java Spring Boot or NodeJs are good alternatives. Should be, initially at least the same option as chosen for REST APIs to allow for faster development and knowledge expansion throught the team

Blockchain
 Solidity - Ethereum

## SECURITY
******************************
SSI/KYC  official ID picture to be validated 
All messages should be signed and verified (JWT)
Mobile app session control



## Team
******************************
Backend x2
Android x1
Ios x1
Blockchain x2
Product owner x1
Scrum Master x1 
Tech Lead x1


-- Cross Team
SRE x1
UX Designer x1

Cross team elements are an important asset but will rarely be needed to remain focused on this project throughout the full lifespan. Most likely they will required at different times but may provide support to other teams as well. 
The "Tech Lead" is there to provide tehcnical coherence and be a tie breaker for technical issues. It is particularly important role over a short period of time and specially in a potentially new team. It is a role that may very well fade away along the way given enough experience and synergy in the team.
The Product owner must maintain the business focus and validate outcome.
The Scrum Master (if Scrum is chosen as framework) must focus on enabling developers over ceremonies. 


Overall the team should be mid-Senior developers with container, cloud and deployment knowledge. 


## Culture
******************************
Agile development: Initially (for the purpose of the POC) SCRUM is probably a good framework given the limited amount of time and the perspective of a having a new team roll out product in a short period of time.  Following this principle, SCRUM with two week sprints could be a good starting point. Kanban is also a good option that would also allow avoiding having to hire Scrum Masters and working with cross team Agile specialists.

Autonomous accountable teams: free to develop, breaker fixes.
Testing is key. TDD would be desirable but certainly test supported clean code is a must.
Automation is key (infra as code, CI/CD)

Career growth and talent retention is a must. This implies satisfaction management and worker benefits (flexible schedules, remote friendly, team building, salary reviews, growth budget and time, visibility and freedom to speak out)

