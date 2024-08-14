package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOptionLink;

	@FindBy(linkText = "Register")
	private WebElement registerOptionLink;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions to call these Object in the form of methods

	public LoginPage twoInOneActionThenLogin() {
		myAccountDropDown.click();
		loginOptionLink.click();
		return new LoginPage(driver);
	}

	public RegisterPage twoInOneActionThenRegisterPage() {
		myAccountDropDown.click();
		registerOptionLink.click();
		return new RegisterPage(driver);
	}

	public void enterValidProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
	}

	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}

	public ProductPage navigateToProductPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
	}
}
