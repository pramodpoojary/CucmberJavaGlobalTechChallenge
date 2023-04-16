package CucumberJavaGlobal.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitialization {
	public static WebDriver driver;

	public static WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
//					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
//					driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
//Add other browsers if needed
		return driver;
	}
}
