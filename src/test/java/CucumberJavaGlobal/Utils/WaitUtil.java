package CucumberJavaGlobal.Utils;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	Logger logger = LoggerUtil.getLogger(WaitUtil.class);

	private WebDriver driver;

	public WaitUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForElement(By element) {
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.of(Long.parseLong(PropertyReaderUtil.getProperty("explicitWait")), SECONDS));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		logger.info("element is visible..");
	}

	public void WaitForElementInvisibility(By element) {
		logger.info("waiting for element invisibility..");
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.of(Long.parseLong(PropertyReaderUtil.getProperty("explicitWait")), SECONDS));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		logger.info("element is invisible..");
	}
	
	

}
