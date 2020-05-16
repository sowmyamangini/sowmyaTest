package utils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

	private RemoteWebDriver webdriver;
	private static EventFiringWebDriver driver;
	private DesiredCapabilities capability;
	public Properties prop;

	@Before
	public void BrowserStartup() throws Exception {

		prop = new Properties();
		FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");

		prop.load(fl);

		if (prop.getProperty("browser").toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe"); 
			capability = DesiredCapabilities.chrome();
			capability.setPlatform(Platform.WINDOWS);

		} else if (prop.getProperty("browser").toLowerCase().equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			capability = DesiredCapabilities.firefox();
			capability.setPlatform(Platform.WINDOWS);

		} 

		webdriver = new RemoteWebDriver(getNodeURL(), capability);

		driver = new EventFiringWebDriver(webdriver);

		driver.navigate().to(prop.getProperty("baseurl"));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	private URL getNodeURL() throws Exception {
		return new URL(String.format("http://%s:%s/wd/hub", prop.getProperty("hubHost"), prop.getProperty("hubPort")));
	}

	public static EventFiringWebDriver getBrowser() {
		return driver;
	}

	@After
	public void TearDown() {
		webdriver.quit();
	}

}
