package tutorialsNinja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.AddToCartPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.ProductPage;
import tutorialsNinja.TestBase.TestBase;

public class AddToCartTest extends TestBase {

	public AddToCartTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;
	public AddToCartPage addTocartPage;
	
	@BeforeMethod
	public void AddToCartTestSetup() {
		driver = openAppWithAnyBrowser(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
	}

	@Test(priority = 1)
	public void validatingValidProduct() {
		AssertJUnit.assertTrue(productPage.verifyValidProductPresence());
	}

	@Test(priority = 2)
	public void validateCompleteCheckoutWithValidProductPositiveFlow() {
		addTocartPage = productPage.clickOnAddToCartButton();
		AssertJUnit.assertTrue(addTocartPage.displayStatusOfLaptopPrice());
		driver.findElement(By.id("button-cart")).click();

		String actualSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]"))
				.getText();
		String expectedSuccessMessage = "Success: You have added ";
		AssertJUnit.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
		AssertJUnit.assertTrue(driver.findElement(By.xpath(" //span[@id = 'cart-total'][text() = ' 1 item(s) - $122.00']"))
				.isDisplayed());
		driver.findElement(By.id("cart")).click();

	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
//
}