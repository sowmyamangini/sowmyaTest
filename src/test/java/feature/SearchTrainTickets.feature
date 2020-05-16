Feature:
As a user of trainline portal i would like to search for train ticket for various ticket types 

@Test 
Scenario: As a user search for a return ticket for 26-30 Railcard rail card 
	Given a user search for return ticket for below details 
		| Outward Journey Station   | Inward Journey Station| Outward Journey Date	| Outward Journey Time| Inward Journey Date | Inward Journey Time | Adults Traveling | RailCard Type | 
		| Manchester Airport		| London Bridge			| Today 			    | CurrentTime+2hr	  |	Today+3   			| CurrentTime+3hr	 | 1 				 | 26-30 Railcard|
	When the user seach for time & tickets 
	Then the ticket information for Outward Journey Station "Manchester Airport" and Inward Journey Station "London Bridge" should be displayed