#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@EvermosLoginFeature
Feature: LoginWeb

	Background:
		Given User membuka https://evermos.com
		When User klik Masuk
	
  @test
  Scenario Outline: User login menggunakan invalid password
  	When User mengisi <noHP> yang benar dan invalid <password>
  	And User klik tombol login
  	Then User akan melihat error 'Nomor Telepon atau Kata Sandi anda salah!'
  	
  	Examples:
  		| noHP  				| password 								 |
      | 6282113225667	| udncYyUJ+jmW3Lvnsj5JXQ== |
      
  Scenario Outline: User login menggunakan invalid No. HP
  	When User mengisi <noHP> yang invalid dan <password> yang benar
  	And User klik tombol login
  	Then User akan melihat error 'Nomor ini belum terdaftar sebagai reseller'
  	
  	Examples:
  		| noHP  				| password 								 |
      | 6282113225699	| jn9+/dk/dX7MRyy6+wlneA== |
  
  Scenario Outline: User melakukan login dengan benar
    When User mengisi <noHP> yang sudah terdaftar and <password> yang benar
    And User klik tombol login
    Then User berhasil login and masuk ke halaman beranda

    Examples: 
      | noHP  				| password 								 |
      | 6282113225667	| jn9+/dk/dX7MRyy6+wlneA== |