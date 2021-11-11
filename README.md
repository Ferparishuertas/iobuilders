# iobuilders

Based in this scenerio https://github.com/Ferparishuertas/iobuilders/wiki/IoBuilders-POC


# Describe Techcnial architecture
	

	1-Front services:
		1-mobile wayllet on angular
	
	
	2-Backend services:
	
		2.1-waylet authorization service this service make the register user and login-->generates token oauth for security the api
		
			-user/login POST
			-user/register POST --> use api for create new address with erc-token
			
		2.2-waylet service backend
		
			2.2.1-Transferring ERC-20 Token --> integration api work with Ethereum https://www.blockcypher.com/dev/ethereum/#introduction
			
				-waylet/address GET (this service use the api blockcyper for load the user waylet )
				-waylet/transaction POST (this service use the api blockcyper for transfer money to another address)
				-waylet/transaction GET (this service use the api blockcyper for load all the transaction user)
				
			2.2.2-Inversis redsis api -->transfer money to global account
			
				-waylet/transfermoney POST (this service does a transfer money from the userAccount to the companyBankAccount)
				
				2.2.2.1 waylet/transaction (originGlobalAdress,targetAddress,amount) (this service transfer a token money to the user address)


		2.3-JPA repositories:
			-users (email,password, address, pri
			vate key, public key, phone)
			-transactionsAudit(when exists a transfer ERC-20 audit) (addressOrigin, addressTarget, amount,date)
			-transferencesAudit(when exists a transfer from inversis audit) (bankAccountOrigin, amount,date)
			-globalAccountAudit(when exists a transfer from inversis increase the amount) 
								(when exists a transfer from ERC-20 decrease the amount) 
								(bankAccount, address,amount,date)
	
	3-Deployment backend services and database on Azure platform
	4-Deployment front on Google playstore

# Describe Team roles

	Team roles:

		-three backend developers for spring boot in these branches (rest services, jpa, security )
		-one front developers for angular js
		-one operation team for devops in azure architecture (kubernetes,Ethereum Blockchain as a Service now on Azure)
	
	
# Culture

	-Agile Methodology
	-8 scrums periods, each peridod 15 days (Four months)

	1-4 scrums perdiods for developing (two initial months)

	Backend services: each developer will have responsability for one domain

		- backend developer 1: inservis redsis api
		- backend developer 2: api waylet
		- backend developer 3: authorization service
		
	- front developer: angular aplication
	- azuere operation support: azure platform deploy backend services, jenkins, sonar, database, kubernetes


	5-8 (two final months) for integration and deploy on production and testing
