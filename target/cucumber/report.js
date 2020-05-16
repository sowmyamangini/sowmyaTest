$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/feature/SearchTrainTickets.feature");
formatter.feature({
  "name": "",
  "description": "As a user of trainline portal i would like to search for train ticket for various ticket types ",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a user search for a return ticket for 26-30 Railcard rail card",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user search for return ticket for below details",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinition.HomePageStepDefinitions.a_user_search_for_return_ticket_for_below_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user seach for time \u0026 tickets",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinition.HomePageStepDefinitions.the_user_seach_for_time_tickets()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the ticket information for Outward Journey Station \"Manchester Airport\" and Inward Journey Station \"London Bridge\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinition.HomePageStepDefinitions.the_ticket_information_for_Outward_Journey_Station_and_Inward_Journey_Station_should_be_displayed(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});