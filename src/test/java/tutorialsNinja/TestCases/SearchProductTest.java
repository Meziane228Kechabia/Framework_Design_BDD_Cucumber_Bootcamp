package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.ProductPage;
import tutorialsNinja.TestBase.TestBase;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;

	@BeforeMethod
	public void loginSetup() {
		driver = openAppWithAnyBrowser(prop.getProperty("browser"));
	}

	@Test(priority = 1)
	public void verifySearchValidProduct() {
		homePage = new HomePage(driver);
		productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
		Assert.assertTrue(productPage.verifyValidProductPresence());
	}

	@Test(priority = 2)
	public void verifySearchInvalidProduct() {
		homePage = new HomePage(driver);
		productPage = homePage.navigateToProductPage(dataProp.getProperty("invalidProduct"));
		Assert.assertFalse(productPage.verifyInvalidProductWarningMessageDisplay());
	}

	@Test(priority = 3)
	public void verifySearchNoProduct() {
		homePage = new HomePage(driver);
		productPage = homePage.clickOnSearchButton();
		Assert.assertTrue(productPage.verifyInvalidProductWarningMessageDisplay());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
