package myrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		strict = true, 
		features = "..\\sowmyaTest\\src\\test\\java\\feature",
		glue = { "stepdefinition", "utils" },
		plugin = { "pretty", "html:target/cucumber" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider (parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}


}
