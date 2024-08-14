package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Utilities.Util;

import tutorialsNinja.Pages.AccountPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.LoginPage;
import tutorialsNinja.TestBase.TestBase;

public class LoginTest extends TestBase{
	
	public LoginTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public AccountPage accountPage;
	
	@BeforeMethod
	public void loginSetup() {
		driver = openAppWithAnyBrowser(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		loginPage = homePage.twoInOneActionThenLogin();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials(String email, String password) {
		accountPage = loginPage.navigateToLoginPageByCombining3Actions(email, password);
		Assert.assertTrue(accountPage.validateDisplayStatusOfLogoutLink());
	}
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginPage.navigateToLoginPageByCombining3Actions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}

	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


