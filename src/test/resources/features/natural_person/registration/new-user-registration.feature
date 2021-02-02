@tag
Feature: Registration of new natural person users
  Registration of new users in the system.

  @tag1
  Scenario Outline: A new natural person fills all the data and registers in the system.
    Given The canditate <person> fills the registration data
    When The candidate <person> sends the registration data
    Then The candidate <person> recieves an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| person          |  app                | version | status | code | payload |
      | 'new_user_1'    |  'poc-registration' |   '1.0' |    200 |    0 | '"User recorded in the system."' |
      | 'new_user_2'    |  'poc-registration' |   '1.0' |    200 |    0 | '"User recorded in the system."' |
      
      
	@tag2
  Scenario Outline: An already registered user who is still is pending of confirmation,
  									finally, sends the confirmation token.
    Given The still pending of confirmation user <person>, he/she checks his/her token from his/her email.
    When The still pending of confirmation user <person> sends a <correctness> token.
    Then The candidate <person> recieves an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| person        |  correctness        | app                | version | status | code | payload |
      | 'new_user_1'  |  'wrong'            | 'poc-registration' |   '1.0' |    404 |  127 | '"Token register cannot be found for such token value."' |
      | 'new_user_1'  |  'right'            | 'poc-registration' |   '1.0' |    200 |    0 | '"User registration verified."' |
      | 'new_user_2'  |  'wrong'            | 'poc-registration' |   '1.0' |    404 |  127 | '"Token register cannot be found for such token value."' |
      | 'new_user_2'  |  'right'            | 'poc-registration' |   '1.0' |    200 |    0 | '"User registration verified."' |

	@tag3
	Scenario Outline: The already registered user asks for his information but without providing the JWT (login) first
		Given A current active user <person> who asks for his/her information without providing the JWT token
		Then The candidate <person> recieves an app envelop with: <app>, <version>, <status>, <code>, <payload>
		
		Examples:
			| person          |  app                | version | status | code | payload |
      | 'new_user_1'    |  'poc-registration' |   '1.0' |    403 |  126 | '"Full authentication is required to access this resource"' |
      | 'new_user_2'    |  'poc-registration' |   '1.0' |    403 |  126 | '"Full authentication is required to access this resource"' |
		
	@tag4
	Scenario Outline: The already registered user asks for his information providing the JWT (login) first
		Given A current active user <person> logs in the system correcty and a JWT is given to him/her.
		When He/she, <person>, asks for his personal information providing the JWT token
		Then The candidate <person> recieves an app envelop with: <app>, <version>, <status>, <code>, <payload>
		
		Examples:
			| person          |  app                | version | status | code | payload |
      | 'new_user_1'    |  'poc-registration' |   '1.0' |    200 |    0 | '{"personalInfo":{"name":"Beatriz","middleName":null,"surname1":"Segovia","surname2":"Martínez","sex":1,"birthdate":null,"mainNationality":724,"otherNationalities":[],"contactChannels":[{"channel":"telephone","description":null,"level":3,"type":1,"value":"+349100003"},{"channel":"telephone","description":null,"level":1,"type":2,"value":"+3466500003"},{"channel":"email","description":null,"level":0,"value":"beatriz@nomail.net"},{"channel":"messenger","description":null,"level":2,"type":1,"value":"+3466500003"},{"channel":"address","description":null,"level":4,"value":"C/ NoName, 9, Madrid","postalCode":"28001","country":724}],"officialDocuments":[{"type":1,"country":724,"value":"5040302013A","validUntil":"1970-01-01","level":0,"description":null}]},"loginInfo":{"alias":"beatriz","password":"*****","email":"beatriz@nomail.net","mobile":"+3466500003","description":"This is a natural person user."}}' |
      | 'new_user_2'    |  'poc-registration' |   '1.0' |    200 |    0 | '{"personalInfo":{"name":"José","middleName":"María","surname1":"García","surname2":"Rodríguez","sex":1,"birthdate":null,"mainNationality":724,"otherNationalities":[32,170],"contactChannels":[{"channel":"telephone","description":null,"level":3,"type":1,"value":"+349100001"},{"channel":"telephone","description":null,"level":1,"type":2,"value":"+3466500001"},{"channel":"email","description":null,"level":0,"value":"jose@nomail.net"},{"channel":"messenger","description":null,"level":2,"type":1,"value":"+3466500001"},{"channel":"address","description":null,"level":4,"value":"C/ NoName, 7, Madrid","postalCode":"28001","country":724}],"officialDocuments":[{"type":1,"country":724,"value":"5040302010A","validUntil":"1970-01-01","level":0,"description":null}]},"loginInfo":{"alias":"jose","password":"*****","email":"jose@nomail.net","mobile":"+3466500001","description":"This is a natural person user."}}' |
		  

