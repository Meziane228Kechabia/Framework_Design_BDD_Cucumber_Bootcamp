package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Utilities.Util;

import tutorialsNinja.Pages.AccountSuccessPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.RegisterPage;
import tutorialsNinja.TestBase.TestBase;
import tutorialsNinja.TestData.ExcelCode;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public RegisterPage registerPage;
	public HomePage homePage;
	public AccountSuccessPage accountSuccessPage;

	@BeforeMethod
	public void registerSetup() {
		driver = openAppWithAnyBrowser(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		registerPage = homePage.twoInOneActionThenRegisterPage();
	}

	@Test(priority = 1, dataProvider = "TNRegister", dataProviderClass = ExcelCode.class)
	public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password,
			String confirmpassword) {
		accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname,
				Util.emailWithDateTimeStamp(), telephone, password, confirmpassword);
		Assert.assertTrue(accountSuccessPage.validateAccountSuccessCreatedMessage());
	}

	@Test(priority = 2)
	public void verifyRegisterWithAllDetails() {
		accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(
				dataProp.getProperty("firstname"), dataProp.getProperty("lastname"), Util.emailWithDateTimeStamp(),
				dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		Assert.assertTrue(accountSuccessPage.validateAccountSuccessCreatedMessage());
	}

	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {
		registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"),
				dataProp.getProperty("lastname"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(registerPage.retrieveDuplicateEmailWarningMessage()
				.contains(registerPage.retrieveDuplicateEmailWarningMessage()));

	}

	@Test(priority = 4)
	public void verifyRegisterWithWrongConfirmPassword() {
		registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"),
				dataProp.getProperty("lastname"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(registerPage.retrieveWrongConfirmPasswordWarningMessage()
				.contains(dataProp.getProperty("wrongconfirmPasswordWarning")));

	}

	@Test(priority = 5)
	public void verifyRegisterWithNoDetails() {
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("invalidEmailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));

		// Assert.assertEquals(registerpage.retrievePrivacyPolicyWarningMessage(),
		// dataProp.getProperty("privacyPolicyWarning"));
		// Assert.assertTrue(registerpage.retrieveFirstnameWarningMessage().contains(dataProp.getProperty("firstNameWarning")));
		// Assert.assertTrue(registerpage.retrieveLastnameWarningMessage().contains(dataProp.getProperty("lastNameWarning")));
		// Assert.assertTrue(registerpage.retrieveEmailWarningMessage().contains(dataProp.getProperty("invalidEmailWarning")));
		// Assert.assertTrue(registerpage.retrieveTelephoneWarningMessage().contains(dataProp.getProperty("telephoneWarning")));
		// Assert.assertTrue(registerpage.retrievePasswordWarningMessage().contains(dataProp.getProperty("passwordWarning")));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

