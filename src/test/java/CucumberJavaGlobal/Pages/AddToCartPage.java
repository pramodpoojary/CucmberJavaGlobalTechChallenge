package CucumberJavaGlobal.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import CucumberJavaGlobal.Utils.LoggerUtil;
import CucumberJavaGlobal.Utils.PropertyReaderUtil;
import CucumberJavaGlobal.Utils.WaitUtil;

public class AddToCartPage {
	private WebDriver driver;

	Logger logger;
	WaitUtil wait;

	private static final String PRODUCT_SELECTION = "(//ol//div/strong/a[contains(text(),'%1$s')])[1]";
	private static final String PRODUCT_COLOUR = "//div[@attribute-code='color']/div/div[@aria-label='%1$s']";
	private static final String PRODUCT_SIZE = "//div[@attribute-code='size']/div/div[@aria-label='%1$s']";
	private static final String PRODUCT_QUANTITY_UPDATE = "//a[text()='%1$s']/parent::strong/parent::div//a[@title='Edit item']";

	By searchField = By.xpath("//input[@id='search']");
	By quantityInput = By.xpath("//input[@id='qty']");
	By addToCartButton = By.xpath("//button[@id='product-addtocart-button']");
	By miniCartButton = By.xpath("//div[@data-block='minicart']/a");
	By cartButtonBy = By.xpath("//div/a[text()='shopping cart']");
	By proceedToCheckoutButton = By.xpath("//li//button[@title='Proceed to Checkout']");
	By emailInput = By.xpath("//div[@class='field required']//input[@type='email']");
	By orderTotal = By.xpath("//strong[contains(text(),'Order Total')]");
	By firstNameInput = By.xpath("//div[@class='field _required']//input[@name='firstname']");
	By lastNameInput = By.xpath("//div[@class='field _required']//input[@name='lastname']");
	By streetAdressInput = By.xpath("//div[@class='field _required']//input[@name='street[0]']");
	By cityInput = By.xpath("//div[@class='field _required']//input[@name='city']");
	By countryDropDown = By.xpath("//div[@class='field _required']//select[@name='country_id']");
	By phoneInput = By.xpath("//div[@class='field _required']//input[@name='telephone']");
	By nextButton = By.xpath("//button/span[text()='Next']/..");
	By loader = By.xpath("//div[@class='loader']");
	By cartTotal = By.xpath("//tr[@class='grand totals']/td/strong/span");
	By discount = By.xpath("//tr[@class='totals discount']/th/span");
	By homePageLogo = By.xpath("//a[@class='logo']");
	By cartCount = By.xpath("//span[@class='counter-number']");
	By updateCartButtonBy = By.xpath("//button[@id='product-updatecart-button']");

	public AddToCartPage(WebDriver webDriver) {
//        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
		this.driver = webDriver;
//        PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,
				Integer.parseInt(PropertyReaderUtil.getProperty("impliciteWait"))), this);
		wait = new WaitUtil(driver);
		logger = LoggerUtil.getLogger(WaitUtil.class);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void searchAndSelectProduct(String productName) {
		driver.findElement(searchField).sendKeys(productName, Keys.ENTER);
		String xpath = String.format(PRODUCT_SELECTION, productName);
		wait.WaitForElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		// driver.findElement(By.xpath(xpath)).click();
	}

	public void selectColour(String color) {
		String xpath = String.format(PRODUCT_COLOUR, color);
		wait.WaitForElement(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void selectSize(String size) {
		switch (size.toLowerCase()) {
		case "medium":
			driver.findElement(By.xpath(String.format(PRODUCT_SIZE, "M"))).click();
			break;
		case "small":
			driver.findElement(By.xpath(String.format(PRODUCT_SIZE, "S"))).click();
			// We can add further
		default:
			break;
		}

	}

	public void selectNumberOfItems(String numberOfItems) {
		driver.findElement(quantityInput).clear();
		driver.findElement(quantityInput).sendKeys(numberOfItems);
	}

	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();
		wait.WaitForElementInvisibility(loader);
	}

	public void clickOnCart() {
		driver.findElement(cartButtonBy).click();
	}

	public void clickOnCheckout() {
		wait.WaitForElement(orderTotal);
		driver.findElement(proceedToCheckoutButton).click();
	}

	public void enterAddress(String address) {
		wait.WaitForElement(countryDropDown);
		Select select = new Select(driver.findElement(countryDropDown));
		select.selectByVisibleText(address);
		wait.WaitForElementInvisibility(loader);
		driver.findElement(emailInput).sendKeys("pramoda@pramoda.com");
		driver.findElement(firstNameInput).sendKeys("Pramoda");
		driver.findElement(lastNameInput).sendKeys("Poojary");
		driver.findElement(streetAdressInput).sendKeys("Test street");
		driver.findElement(cityInput).sendKeys("Test City");
		driver.findElement(phoneInput).sendKeys("1234567890");
		wait.WaitForElement(loader);
		wait.WaitForElementInvisibility(loader);
	}

	public void clickNext() {
		wait.WaitForElement(nextButton);
		driver.findElement(nextButton).click();
	}

	public String getCartTotal() {
		wait.WaitForElement(cartTotal);
		wait.WaitForElementInvisibility(loader);
		return driver.findElement(cartTotal).getText();
	}

	public boolean isDiscountApplied() {
		return driver.findElement(discount).isDisplayed();
	}

	public void gotoHomePage() {
		wait.WaitForElementInvisibility(loader);
		driver.findElement(homePageLogo).click();
	}

	public void updateQuantityOfProduct(String productName) {
		wait.WaitForElement(miniCartButton);
		wait.WaitForElement(cartCount);
		driver.findElement(miniCartButton).click();
		String xpath = String.format(PRODUCT_QUANTITY_UPDATE, productName);
		wait.WaitForElement(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void clickOnUpdateCart() {
		driver.findElement(updateCartButtonBy).click();
		wait.WaitForElementInvisibility(loader);

	}

}
