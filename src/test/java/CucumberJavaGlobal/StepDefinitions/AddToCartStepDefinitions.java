package CucumberJavaGlobal.StepDefinitions;

import org.openqa.selenium.WebDriver;

import CucumberJavaGlobal.Pages.AddToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefinitions {
	public static WebDriver driver = ServiceHooks.driver;
	private AddToCartPage addToCartPage = new AddToCartPage(driver);
	private static final String PAGE_TITLE_STRING = "Home Page";

	@Given("the user is on the magento homepage")
	public void openHomePage() {
		assert addToCartPage.getPageTitle().contains(PAGE_TITLE_STRING)
				: "Expected Page title is : " + PAGE_TITLE_STRING + " Actual is : " + addToCartPage.getPageTitle();
	}

	@When("the user adds {string} - {string} with {string} size and {string} color to the cart")
	public void addToCartItem(String quantity, String productName, String size, String color) {
		addToCartPage.searchAndSelectProduct(productName);
		addToCartPage.selectColour(color);
		addToCartPage.selectSize(size);
		addToCartPage.selectNumberOfItems(quantity);
		addToCartPage.clickAddToCart();
	}

	@And("the user selects {string} as the delivery address")
	public void userCheckOutWithAddress(String address) {
		addToCartPage.clickOnCart();
		addToCartPage.clickOnCheckout();
		addToCartPage.enterAddress(address);
		addToCartPage.clickNext();
	}

	@Then("the cart total is {string}")
	public void verifyCartTotal(String total) {
		assert addToCartPage.getCartTotal().contains(total)
				: "Expected Total is: " + total + " Actual total is: " + addToCartPage.getCartTotal();
	}

	@And("the discount is applied")
	public void verifyDiscountApplied() {
		assert addToCartPage.isDiscountApplied() : "Discount is not applied";
	}

	@When("the user updates the quantity of {string} to {string}")
	public void updateTheQuantityOfProduct(String productName, String quantity) {
		addToCartPage.gotoHomePage();
		addToCartPage.updateQuantityOfProduct(productName);
		addToCartPage.selectNumberOfItems(quantity);
		addToCartPage.clickOnUpdateCart();

	}

	@And("the user adds {string} - {string} to the cart")
	public void addToCartItem(String quantity, String productName) {
		addToCartPage.searchAndSelectProduct(productName);
		addToCartPage.selectNumberOfItems(quantity);
		addToCartPage.clickAddToCart();
	}

	@And("the user navigates to checkout page")
	public void navigateToCheckoutPage() {
		addToCartPage.clickOnCart();
		addToCartPage.clickOnCheckout();
		addToCartPage.clickNext();
	}

}
