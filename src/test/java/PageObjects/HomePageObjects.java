package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import support.DateFormatter;
import utils.Hook;

public class HomePageObjects {

	private EventFiringWebDriver driver;

	private String outwardJourneySearchBox = "from.text";
	private String inwardJourneySearchBox = "to.text";
	private String returnRadioButton = "return";
	private String outwardJourneyDate = "page.journeySearchForm.outbound.title";
	private String outwardJourneyTimeHours = "hours";
	private String outwardJourneyTimeMinutes = "minutes";
	private String inwardJourneyDate = "page.journeySearchForm.inbound.title";
	private String searchBox = "_1orpsl8"; 
	private String inwardJourneyTimeHours = "//div[@id='ll-home']/div/main/div/div/div/div/div/section/form/div[3]/fieldset[2]/div[4]/div/select";
	private String inwardJourneyTimeMinutes = "minutes";
	private String railCardType = "//button[@id='passenger-summary-btn']/div";
	private String passengerAdults = "adults";
	private String addRailCard = "//div[@id='ll-home']/div/main/div/div/div/div/div/section/form/div[4]/div/div/ul/li/button/span[2]";
	private String optionRailCardType = "railcardRow0";
	private String doneButton = "_1lxtsu6b";
	private String gettimesAndticketsButton = "_h9fi920";

	public HomePageObjects() {
		driver = Hook.getBrowser();
	}

	private void setOutwardJourney(String fromStation) {

		driver.findElement(By.id(outwardJourneySearchBox)).sendKeys(fromStation);

	}

	private void setInwardJourney(String toStation) {
		driver.findElement(By.id(inwardJourneySearchBox)).sendKeys(toStation);
	}

	private void returnJourneyType() {
		driver.findElement(By.id(returnRadioButton)).click();
	}

	private void outJourneyDateTime(String outDate, String outTime) {
		
		// setting the date for outward journey

		String alreadyDate = driver.findElement(By.id(outwardJourneyDate)).getAttribute("value");

		if (!alreadyDate.equals(DateFormatter.ParseDate(outDate))) {
			driver.findElement(By.id(outwardJourneyDate)).clear();
			driver.findElement(By.id(outwardJourneyDate)).sendKeys(DateFormatter.ParseDate(outDate));
		}

		// selecting hours for outward journey
		Select hoursInfo = new Select(driver.findElement(By.name(outwardJourneyTimeHours)));
		hoursInfo.selectByValue(DateFormatter.ParseTime(outTime));

		// selecting minutes for outward journey

		Select minutesInfo = new Select(driver.findElement(By.name(outwardJourneyTimeMinutes)));
		minutesInfo.selectByValue("00");

	}

	private void returnJourneyDateTime(String returnDate, String returnTime) {
		
		// setting the date for inward journey

		driver.findElement(By.id(inwardJourneyDate)).sendKeys(DateFormatter.ParseDate(returnDate));
		
		driver.findElement(By.className(searchBox)).click();
		
		
		// selecting hours for inward journey

		Select hoursInfo = new Select(driver.findElement(By.xpath(inwardJourneyTimeHours)));
		hoursInfo.selectByValue(DateFormatter.ParseTime(returnTime));
		
		// selecting minutes for inward journey

		Select minutesInfo = new Select(driver.findElement(By.name(inwardJourneyTimeMinutes)));
		minutesInfo.selectByValue("00"); 

	}

	private void selectPassengerAndTheirRailCardType(String adults, String railcardType) {

		driver.findElement(By.xpath(railCardType)).click();

		Select adultsInfo = new Select(driver.findElement(By.name(passengerAdults)));
		adultsInfo.selectByValue(adults);

		driver.findElement(By.xpath(addRailCard)).click();

		Select railcardInfo = new Select(driver.findElement(By.id(optionRailCardType)));
		railcardInfo.selectByVisibleText(railcardType);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className(doneButton)));
		driver.findElement(By.className(doneButton)).click();

	}

	public void selectTimeAndTicketButton() throws InterruptedException {
		driver.findElement(By.className(gettimesAndticketsButton)).click();

	}

	public void searchForReturnJourneyDetails(String outJourney, String returnJourney, String outDate, String outTime,
			String returnDate, String returnTime, String people, String railCardType) {
		setOutwardJourney(outJourney);
		setInwardJourney(returnJourney);
		returnJourneyType();
		outJourneyDateTime(outDate, outTime);
		returnJourneyDateTime(returnDate, returnTime);
		selectPassengerAndTheirRailCardType(people, railCardType);

	}

}
