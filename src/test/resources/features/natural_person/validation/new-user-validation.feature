@tag
Feature: Validation of new natural person users
  The validations of the information made by the system when a new user of type
  natural person tries to register in the system for the first time. The system
  should detect any no acceptable data and report it to who is trying to register.

  @tag1
  Scenario Outline: A new candidate introduces all the data correctly but his/her NAME.
    Given A new canditate fills the registration data
    But The user name is <name>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| name      |  app                | version | status | code | payload |
      | 'null'    |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.name": "Name is mandatory."}' |
      | 'a'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.name": "The name must be grater than 2 characters long and less than 250."}' |
      | 'ab'      |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.name": "The name must be grater than 2 characters long and less than 250."}' |
 
	@tag2
  Scenario Outline: A new candidate introduces all the data correctly but his/her SURNAME1.
    Given A new canditate fills the registration data
    But The user surname1 is <surname1>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| surname1  |  app                | version | status | code | payload |
      | 'null'    |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.surname1": "First surname is mandatory."}' |
      | 'a'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.surname1": "The first surname must be grater than 2 characters long and less than 250."}' |
      | 'ab'      |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.surname1": "The first surname must be grater than 2 characters long and less than 250."}' |
      
      
	@tag3
  Scenario Outline: A new candidate introduces all the data correctly but his/her SEX.
    Given A new canditate fills the registration data
    But The user sex is <sex>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| sex     |  app                | version | status | code | payload |
    	| 'null'  |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.sex": "Sex is mandatory."}' |
      | 0       |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.sex": "Sex is not valid."}' |
      | 3       |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.sex": "Sex is not valid."}' |
      
  @tag4
  Scenario Outline: A new candidate introduces all the data correctly but his/her BIRTHDATE.
    Given A new canditate fills the registration data
    But The user birthdate is <birthdate>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| birthdate        |  app                | version | status | code | payload |
    	| 'null'           |  'poc-registration' |   '1.0' |    400 |   22 | '"JSON Date bad format. Json date format is not compatible with YYYY-MM-DD for value: null"' |
      | '11122-12-21'    |  'poc-registration' |   '1.0' |    400 |   22 | '"JSON Date bad format. Json date format is not compatible with YYYY-MM-DD for value: 11122-12-21"' |
      | '31-12-2021'     |  'poc-registration' |   '1.0' |    400 |   22 | '"JSON Date bad format. Json date format is not compatible with YYYY-MM-DD for value: 31-12-2021"' |
      | '2021-01-01'     |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.birthdate": "Under the legal age (18)"}' |
      
  @tag5
  Scenario Outline: A new candidate introduces all the data correctly but his/her MAIN NATIONALITY.
    Given A new canditate fills the registration data
    But The user nationality is <nationality>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| nationality      |  app                | version | status | code | payload |
    	| 'null'           |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.mainNationality": "Default/main nationality is mandatory."}' |
      |  0               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.mainNationality": "The default/main nationality is not valid."}' |
      | 1000000          |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.mainNationality": "The default/main nationality is not valid."}' |
      | 'ABCDDE'         |  'poc-registration' |   '1.0' |    400 |   22 | '"Invalid JSON message. Cannot deserialize value of type java.lang.Long from String ABCDDE: not a valid Long value"' |
      
  @tag6
  Scenario Outline: A new candidate introduces all the data correctly but his/her SECONDARY NATIONALITIES.
    Given A new canditate fills the registration data
    But The user secondary nationalities are <nationalities>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| nationalities   |  app                | version | status | code | payload |
    	| '[0]'           |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.otherNationalities": "[{0}]The country is not valid"}' |
      | '[0, 10000]'    |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.otherNationalities": "[{0}]The country is not valid\|[{10000}]The country is not valid"}' |
      
  @tag7
  Scenario Outline: A new candidate introduces all the data correctly but his/her CONTACT CHANNELS.
    Given A new canditate fills the registration data
    But The user contact channels are <contact_channel_refs>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| contact_channel_refs                        |  app                | version | status | code | payload |
    	| '001_empty'                                 |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels": "At least, a geographical address, an email and a telphone number must be indicated for a natural person."}' |
      | '002_lack_address'                          |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels": "At least, a geographical address, an email and a telphone number must be indicated for a natural person."}' |
      | '003_lack_telephone'                        |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels": "At least, a geographical address, an email and a telphone number must be indicated for a natural person."}' |
      | '004_lack_email'                            |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels": "At least, a geographical address, an email and a telphone number must be indicated for a natural person."}' |
      | '005_blank_address_value'                   |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[address !!! ]Address is mandatory.;[address !!! ]Address should be between 5 and 250 characters long."}' |
      | '006_null_address_value'                    |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[address !!! null]Address is mandatory."}' |
      | '007_blank_postalCode_value'                |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[address !!! C/ NoName, 7, Madrid]Postal code is mandatory.;[address !!! C/ NoName, 7, Madrid]Postal code should be between 5 and 250 characters long."}' |
      | '008_null_postalCode_value'                 |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[address !!! C/ NoName, 7, Madrid]Postal code is mandatory."}' |
      | '009_blank_telephone_value'                 |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[telephone !!! ]The value for establishing a connection using the channel is mandatory;[telephone !!! ]The value for the telephone must be longer than 6 characters and shorter or equals to 250."}' |
      | '010_null_telephone_value'                  |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[telephone !!! null]The value for establishing a connection using the channel is mandatory"}' |
      | '011_wrong_telephone_type_I'                |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[telephone !!! +349100001]The telephone type is not correct."}' |
      | '012_wrong_telephone_type_II'               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[telephone !!! +349100001]The telephone type is not correct."}' |
      | '013_null_telephone_type_III'               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[telephone !!! +349100001]The telephone type is madatory."}' |
      | '014_blank_email_value'                     |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[email !!! ]The email is mandatory."}' |
      | '015_null_email_value'                      |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[email !!! null]The email is mandatory."}' |
      | '016_wrong_email_value_I'                   |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[email !!! jose@nomail@net]The email is not valid."}'|
      | '017_wrong_email_value_II'                  |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[email !!! @nomail.net]The email is not valid."}' |
      | '018_wrong_email_value_III'                 |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[email !!! josenomail.net]The email is not valid."}' |
      | '019_blank_messenger_value'                 |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[messenger !!! ]The value for establishing a connection using the channel is mandatory;[messenger !!! ]The value for the messenger provider must be longer than 6 characters and shorter or equals to 250."}' |
      | '020_null_messenger_value'                  |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[messenger !!! null]The value for establishing a connection using the channel is mandatory"}' |
      | '021_null_messenger_provider'               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[messenger !!! +3466500001]The messenger provider (messenger type) is mandatory."}' |
      | '022_wrong_messenger_provider_I'            |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[messenger !!! +3466500001]The messenger provider is not valid."}' |
      | '023_wrong_messenger_provider_II'           |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.contactChannels":"[messenger !!! +3466500001]The messenger provider is not valid."}' |
      
  @tag8
  Scenario Outline: A new candidate introduces all the data correctly but his/her OFFICIAL DOCUMENTS.
    Given A new canditate fills the registration data
    But The user official documents are <official_documents_ref>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
    
    Examples:
    	| official_documents_ref                        |  app                | version | status | code | payload |
    	| '001_empty'                               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments":"One official personal document is mandatory."}' |
    	| '002_lack_value'                          |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].value":"The value of the official document is mandatory."}' |
      | '003_blank_value'                         |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].value":"The value of the official document must be between 5 and 250 characters long."}~{"personalInfo.personOfficialDocuments[0].value":"The value of the official document is mandatory."}' |
      | '004_null_value'                          |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].value":"The value of the official document is mandatory."}' |
      | '005_wrong_value'                         |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].value":"The value of the official document must be between 5 and 250 characters long."}' |
      | '006_lack_type'                           |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].type":"The type of personal document is mandatory."}' |
      | '007_null_type'                           |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].type":"The type of personal document is mandatory."}' |
      | '008_wrong_type_I'                        |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].type":"The type of personal document is not valid."}' |
      | '009_wrong_type_II'                       |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].type":"The type of personal document is not valid."}' |
      | '010_lack_country'                        |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].country":"The country for the personal document is mandatory."}' |
      | '011_null_country'                        |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].country":"The country for the personal document is mandatory."}' |
      | '012_wrong_country_I'                     |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].country":"The country for the personal document is not valid."}' |
      | '013_wrong_country_II'                    |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].country":"The country for the personal document is not valid."}' |
      | '014_lack_validUntil'                     |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].validUntil":"The expiration date is mandatory."}' |
      | '015_null_validUntil'                     |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].validUntil":"The expiration date is mandatory."}' |
      | '016_wrong_validUntil_I'                  |  'poc-registration' |   '1.0' |    400 |   22 | '"JSON Date bad format. Json date format is not compatible with YYYY-MM-DD for value: 31-12-2021"' |
      | '017_wrong_validUntil_II'                 |  'poc-registration' |   '1.0' |    400 |   22 | '"JSON Date bad format. Json date format is not compatible with YYYY-MM-DD for value: 20211231"' |
      | '018_outdated_validUntil_I'               |  'poc-registration' |   '1.0' |    400 |   22 | '{"personalInfo.personOfficialDocuments[0].validUntil":"The document is outdated."}' |
  
  @tag9
  Scenario Outline: A new candidate introduces all the data correctly but his/her LOGIN ALIAS.
    Given A new canditate fills the registration data
    But The user login alias is <alias>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
  Examples:
    	| alias     |  app                | version | status | code | payload |
    	| ''        |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.alias":"The login alias must be between 3 and 50 characters long."}~{"loginInfo.alias":"The login alias must start with a letter followed by a combination of _, a-z, A-Z, 0-9"}' |
    	| 'null'    |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.alias":"The login alias is mandatory."}' |
    	| 'aa'      |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.alias":"The login alias must be between 3 and 50 characters long."}' |
      | '_asdfas' |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.alias":"The login alias must start with a letter followed by a combination of _, a-z, A-Z, 0-9"}' |
      | '3_sdfas' |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.alias":"The login alias must start with a letter followed by a combination of _, a-z, A-Z, 0-9"}' |
  
      
  @tag10
  Scenario Outline: A new candidate introduces all the data correctly but his/her LOGIN PASSWORD.
    Given A new canditate fills the registration data
    But The user login password is <password>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
	Examples:
			| password          |  app                | version | status | code | payload  |
			| ''                |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.password":"The login password is mandatory"}~{"loginInfo.password":"Password must be 8 or more characters in length.\|Password must contain 1 or more digit characters.\|Password must contain 1 or more lowercase characters.\|Password must contain 1 or more special characters.\|Password must contain 1 or more uppercase characters."}' |
			| 'aa'              |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.password":"Password must be 8 or more characters in length.\|Password must contain 1 or more digit characters.\|Password must contain 1 or more special characters.\|Password must contain 1 or more uppercase characters."}' |
      | '________'        |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.password":"Password must contain 1 or more digit characters.\|Password must contain 1 or more lowercase characters.\|Password must contain 1 or more uppercase characters."}' |
      | '_aA1'            |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.password":"Password must be 8 or more characters in length."}' |
      | '12345678'        |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.password":"Password contains the illegal numerical sequence \'12345678\'.\|Password must contain 1 or more lowercase characters.\|Password must contain 1 or more special characters.\|Password must contain 1 or more uppercase characters."}' |
    
 	@tag11
  Scenario Outline: A new candidate introduces all the data correctly but his/her LOGIN EMAIL.
    Given A new canditate fills the registration data
    But The user login email is <email>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>
  Examples:
    	| email                        |  app                | version | status | code | payload  |
    	| ''                           |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.email":"The login email is mandatory."}' |
    	| 'null'                       |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.email":"The login email is mandatory."}' |
    	| 'abcde'                      |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.email":"A valid email address must be specified for the login email."}' |
    	| 'abcde@abcde@'               |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.email":"A valid email address must be specified for the login email."}' |
      | 'abcde@?.@.?'                |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.email":"A valid email address must be specified for the login email."}' |

    
 	@tag12
  Scenario Outline: A new candidate introduces all the data correctly but his/her LOGIN MOBILE.
    Given A new canditate fills the registration data
    But The user login mobile is <mobile>
    When The candidate sends the registration data
    Then The system returns an app envelop with: <app>, <version>, <status>, <code>, <payload>    
   Examples:
    	| mobile                  |  app                | version | status | code | payload  |
    	| ''                      |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
    	| '+001'                  |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
    	| '+012'                  |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
      | '555555555555555'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
      | '5a5555555555555'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
      | '+5555555555555a'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
      | '00555555555555a'       |  'poc-registration' |   '1.0' |    400 |   22 | '{"loginInfo.mobile":"Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country\'s prefix and XXXXXXX = number (6 to 15 digits)."}' |
 
