# iobuilders

**(1) What are your thoughts, ideas about tech, architecture with this context?**

First of all, for my thoughts and ideas, I will assume that is an MVP and not a POC, because for a POC we can avoid some of the risks and we can "mock" the real money usage.

## Risks
- Data leakage of data (KYC, IBAN, Cards)
- Real money being moved, so interesting for fraudsters and attackers

## Key components

### Identified workflows, use cases
- Authentication & Authorisation:
  - Auth Provider: Auth0, firebase auth
  - KYC provider: IDnow
- Wallet management:
  - Create an Ethereum wallet
    - Store wallet private key encrypted (with a master key, for example) in the "server"
  - Create IBAN and associate with wallet
- Money movement
  - Top up by IBAN
    - Connection with Inversis to know when customers receive money on the omnibus account
    - Serverless function or API to call a smart contract to issue the tokens and deposits into the customer wallet
  - External IBAN
    - Mobile send transactions request with IBAN
      - Execute smart contract to withdraw tokens from customer and delete the token
      - Call Inversis API with the money movement to the external IBAN
  - Internal IBAN (customer to customer)
      - Mobile send transaction request with IBAN/AccountId
      - Serverless function executes smart contract function to transfer tokens from one customer to the other

### Mobile
- React Native: Since it is an MVP will allow us for faster development cycle, where we can learn with a single code base for both Android and iOS

### Backend
- Java with microservices (with an extra cost in time and maintaining) and/or Serverless (AWS lambda)
- RDS PostgreSQL for persistent storage
- AWS Kinesis for event processing

### Data
- Charts management
- Logging
- Audits

**(2) Describe the skills, roles and team size, that you think is the best fit for this project.**

## Team
- 2 Senior Front end (mobile) for the app to build integration with our backend (react native)
- 2 Senior Backend for the serverless functions, API, etc (Node, Go, Java, Python)
- 1 Solidity Engineer Highly experienced in smart contracts
- 1 Product Designer, to design the flows and handle customer feedback (maybe with a part-time user researcher)
- 1 Product Manager - For stakeholder management, product prioritization and roadmap
- 1 DevOps Engineer for building and maintaining the infrastructure with some Infrastructure as a code solution
- 1 Security Engineer (ideally with blockchain knowledge) for penetration testing and threat modelling (maybe hiring an external firm instead of in house)
- 1 Quality Engineer for building the automated testing pipelines
- 1 Data Analyst for auditing and product metrics
> In case of a POC the team could be smaller

**(3) Go into the details, about which tech/business methodologies, tools, etc..., you think fit best to the scenario, and the culture you like and makes sense to apply on this company**

## Culture
- Lean agile mindset
- Design Driven
- Data Driven
- Collaborative tools, such as JIRA
- Google docs for sharking knowledge
- Notion.so for documentation and decision snapshots
- Diverse team
- Bottom-up culture, where everyone has a voice
