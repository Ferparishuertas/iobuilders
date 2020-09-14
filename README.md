# iobuilders

## Tech + Architecture:
- Mobile App: React Native app because that we help up to deliver the same app for both Android and iOS with (almost) just one piece of code. Publish apps to their market as soon as possible will reduce the risk of getting them rejected (especially by Apple) when we wanted to go into production.
- Usability and design: Besides the obvious thing that we need a good look&feel and UX, we should take accessibility seriously.
- Backend technology: Node is a good option because is mature enough, fast, with good ecosystem and using the same language in both front (mobile) and back would help us to get a multifunctional team.
- Performance: Lambda functions to scale quickly if/when needed. 
- Traceability: Implement Opentracing would be a good choice.
- Security: PCI DSS compliance seems important. Use third party services at the beginnig to manage money transactions could reduce the risk of security problems and maybe PCI DSS compliance could be postponed.
- Events audited: Event sourcing pattern seems the best choice. 
- Reusable components: DDD could help to create domains that could be used in another project within the company. React Native components (Storybook) and Lambda functions also help us to reuse code.
- Versioning: Mobile apps can get out of date easily because users could decide not update them. This makes very important to have a good methodology of APIs versioning and mobile app should be ready for managing out-of-date behaviour to force the user to update it when required because an important update. APIs need to be able to work with different mobile apps versions.

## Team:
- 1 blockchain expert who knows how to work with Ethereum and their ecosystem.
- 1 React Native developer expert with Node knowledge.
- 1 Node expert with React [Native] knowledge. 
- Myself. Orchestration role, helping with the development in all areas.
- 1 UI/UX contractor. Can be 2, one UI and one UX. Knowledge of a11y should be required.
- 1 security expert contractor. He/she would suggest an architecture at the beginning and review the progress from time to time.
- 1 PCI DSS advisor contractor?. He/she would help us with the implementation of PCI DSS if that's required.
- Everyone should be senior/experts at the beginning because we only have 4 months for this POC, but keeping in mind that hire people with less experience will be important in the near future.

## Culture:
- Hire the best people we can, so English as a main language and remote first are important things to consider.
- With small teams like this, we don't need any explicit leader. Anyone would have their role based on expertise, personality, etc.
- Create an environment where anyone can express their opinion without any fear is the key.
- Main goal should be to have a multifunctional team, so everyone in the team should learn how to work with all technologies used. For instance, the React Native expert should learn how to create a smart contract. Everyone in the team should be aware of security best practices.
- Team members' career is important, so the company provides the stuff needed (tools, spare time, money, etc.) to improve everyone's skills. Study groups, membership to courses platforms, internal presentations, internal mentoring programs, etc. are a good to achieve that.
- Having a smooth onboarding process for new hirings should be a thing that is always in our mind. 

## Methodology:
- Scrum at the beginning can be the best approach because it gives context and keeps our focus in the next 2 or 3 weeks tasks. Whenever the project is in "cruising speed", we could think of moving to something more similar to Kanban.

## Disclaimer
Although some methodologies, tools and development patterns are mentioned here (Scrum, Kanban, DDD, event sourcing, etc.), the last decision should be made by the whole team. My main responsibility would be to give the maximum amount of context to the team, so that we could decide all together based on our individual experience.