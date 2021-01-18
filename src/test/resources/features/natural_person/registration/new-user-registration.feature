@tag
Feature: Registration of new natural person users
  Registration of new users in the system.

  @tag1
  Scenario Outline: A new natural person fills all the data and registers in the system.
    Given The canditate <person> fills the registration data
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| person          |  app                | version | status | code | payload |
      | 'new_user_1'    |  'poc-registration' |   '1.0' |    200 |    0 | '"User recorded in the system."' |
      | 'new_user_2'    |  'poc-registration' |   '1.0' |    200 |    0 | '"User recorded in the system."' |
      
      
	@tag2
  Scenario Outline: An already registered user who is still is pending of confirmation,
  									finally, sends the confirmation token.
    Given The still pending of confirmation user <person>, he/she checks his/her token from his/her email.
    When The still pending of confirmation user sends a <correctness> token.
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| person        |  correctness        | app                | version | status | code | payload |
      | 'new_user_1'  |  'wrong'            | 'poc-registration' |   '1.0' |    404 |  127 | '"Token register cannot be found for such token value."' |
      | 'new_user_1'  |  'right'            | 'poc-registration' |   '1.0' |    200 |    0 | '"User registration verified."' |

