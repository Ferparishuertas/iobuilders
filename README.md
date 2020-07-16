# iobuilders
### (1) What are your thoughts, ideas about tech, architecture with this context?

Knowing that it is a POC of 4 months duration, on the FrontEnd side I consider that a hybrid technology should be used, because it allows us to do development for iOS and Android with the same code, with the disadvantage that there is some plugins that doesn't work the same for both OS, but without the need of have two different teams doing different code.

A good modern technology, with extensive documentation and great community support such as React, I think it would be the best option, due to the advantages described above and because it is a technology based on components, which will help us to reuse pieces of code for this same POC, or for other future projects.

On the BackEnd side, I would have a microservices-based structure, which will help us defragment the code for better reading and make it easier to update it in the future. It also helps us to make reusable code for other projects, which only have to import that service, and to be able to use it. To carry it out, I would use a technology such as Spring Boot with Java, since Java is one of the most used languages ​​in the world and with more documentation than others, and together with the spring boot framework that makes things much easier to use microservices. Another point in favor is all the core that spring boot has, with a lot of tools prepared, whether to work with encryption, sessions, DB ...

Finally, on the DevOps side, it would have technologies such as GitLab to save all the code, CI / CD tools (Jenkins or GitLab's own) for automatic deployments on dockers and code review (SonarQ). The DB would have a duplicate mongoDB docker to be able to save the data before any failure, and it would use mongoDB because it is a non-relational DB, which allows us to create our own objects in the DB, and it may be more comfortable to work with JSON type data.

### (2) Describe the skills, roles and team size, that you think is the best fit for this project.

* 2/3 Senior FE with experience in:
- HTML, CSS, JS and experience with some framework like Angular / React
- With Java / Kotlin or Swift, in case you have to touch a plugin that does not work well for any of the S.O.
- Uploading applications to PlayStore
- Google/Firebase analitycts
- Git and agile methodologies
- Automation tools like Appium and Selenium
- Teamwork

* 1 Junior FE with experience in:
- HTML, CSS, JS and experience with some framework like Angular / React
- Some experience in Native
- Google/Firebase analitycts
- Git and agile methodologies
- Teamwork

* 2/3 Sernior BackEnd with experience in:
- Java, c ++, Go ...
- Spring boot and spring boot core
- Microservices
- Database technologies such as MongoDb, FirebaseDb, Oracle, MySql Server
- Blockchain, AWS, Docker, JUnit
- Git and agile methodologies
- CI / CD, Jenkins, SonarQ
- Teamwork

* 1 Junior BackEnd with experience in:
- Java, c ++, Go ...
- Spring boot and spring boot core
- Microservices
- Database technologies such as MongoDb, FirebaseDb, Oracle, MySql Server
- Docker, JUnit
- Git and agile methodologies
- Knowledge with CI / CD, Jenkins
- Teamwork

* SCRUM Master
To organize the work of the sprint, with experience in working with teams and the organization of the tasks.

* UI / UX designer
A designer with experience of UI and UX to be able to analyze the target audience well, and be able to make a coherent and beautiful design for the user. Experience with technologies such as Figma, Invision, tools for making mocks and prototypes, experience interviewing people and analyzing user requirements.

* Product Owner
A product owner who knows the product and all the functionalities of the POC, being able to organize the work of different US so that developers can analyze the work to be done. It will also do the end client functionality, which has to be comfortable with the app and the POC demos will be done in each sprint final.

### (3) Go into the details, about which tech/business methodologies, tools, etc..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company

The POC would base it on an agile methodology such as Scrum, with sprints of 2 weeks since the total duration of the POC is 4 months, which will allow us to update the progress to the PO frequently. The work would be controlled with a tool like Jira/Trello, which allow tracking the development status.

The code would be saved in GitLab, using gitFlow for the use of the branches within the repository, with PRs and MRs to upload the code according the environment, and the CI/CD to do the automatic deployment.

The REST documentation would be in swagger, since it allows us to see the calls and their answers very easilyand it's very intuitive. I would also have the readMe of each repository explaining how to set up the project and interesting tips to keep in mind.

To test the API calls, Postman or SoapUi would be used, since they are very complete and easy-to-use tools to check how the REST works.
