package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import PageObjects.HomePageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utils.Hook;

public class HomePageStepDefinitions {

	private HomePageObjects homePage;
	private EventFiringWebDriver driver;

	public HomePageStepDefinitions(HomePageObjects trainLineHomePage) {

		driver = Hook.getBrowser();
		homePage = trainLineHomePage;
	}

	@Given("a user search for return ticket for below details")
	public void a_user_search_for_return_ticket_for_below_details(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		for (int i = 0; i < list.size(); i++) {

			homePage.searchForReturnJourneyDetails(list.get(i).get("Outward Journey Station"),
					list.get(i).get("Inward Journey Station"), list.get(i).get("Outward Journey Date"),
					list.get(i).get("Outward Journey Time"), list.get(i).get("Inward Journey Date"),
					list.get(i).get("Inward Journey Time"), list.get(i).get("Adults Traveling"),
					list.get(i).get("RailCard Type"));

		}

	}

	@When("the user seach for time & tickets")
	public void the_user_seach_for_time_tickets() throws InterruptedException {

		homePage.selectTimeAndTicketButton();

	}

	@Then("the ticket information for Outward Journey Station {string} and Inward Journey Station {string} should be displayed")
	public void the_ticket_information_for_Outward_Journey_Station_and_Inward_Journey_Station_should_be_displayed(
			String fromlocation, String toLocation) throws InterruptedException {   

//      ==== Explicit Wait statement ===
//       WebDriverWait wait = new WebDriverWait(driver, 15); //you can play with the time integer  to wait for longer than 15 seconds.`
//       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div._1c5dl1r"))));
        
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

		System.out.println("My test for Searchch : "+driver.findElement(By.cssSelector("div._1c5dl1r")).getText());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div._1c5dl1r")).getText().toLowerCase().contains(String.format("%s to %sreturn journey", fromlocation.toLowerCase(), toLocation.toLowerCase())));
	}

}
