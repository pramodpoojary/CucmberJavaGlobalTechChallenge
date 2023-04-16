package CucumberJavaGlobal.StepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import CucumberJavaGlobal.Utils.BrowserInitialization;
import CucumberJavaGlobal.Utils.LoggerUtil;
import CucumberJavaGlobal.Utils.PropertyReaderUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHooks {

	public static WebDriver driver;

	Logger log = LoggerUtil.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() {
		driver = BrowserInitialization.selectBrowser(PropertyReaderUtil.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(PropertyReaderUtil.getProperty("app_url"));
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) BrowserInitialization.driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.attach(((TakesScreenshot) BrowserInitialization.driver).getScreenshotAs(OutputType.BYTES),
						"image/png", scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		BrowserInitialization.driver.quit();
	}
}