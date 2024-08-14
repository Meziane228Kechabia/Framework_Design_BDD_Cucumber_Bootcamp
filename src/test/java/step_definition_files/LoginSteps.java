package step_definition_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorialsNinja.Pages.AccountPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.LoginPage;

public class LoginSteps {
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo");
        homePage = new HomePage(driver);
        loginPage = homePage.twoInOneActionThenLogin();
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        accountPage = loginPage.navigateToLoginPageByCombining3Actions("valid@example.com", "password123");
    }

    @Then("I should see the account page with logout link")
    public void i_should_see_the_account_page_with_logout_link() {
        Assert.assertTrue(accountPage.validateDisplayStatusOfLogoutLink());
    }

    @When("I login with invalid password")
    public void i_login_with_invalid_password() {
        loginPage.navigateToLoginPageByCombining3Actions("valid@example.com", "invalidPassword");
    }

    @Then("I should see a warning message")
    public void i_should_see_a_warning_message() {
        String warningMessage = loginPage.retrieveLoginMessageWarningText();
        Assert.assertTrue(warningMessage.contains("Warning: No match for E-Mail Address and/or Password."));
    }

    // Similar step definitions for other scenarios
}


//@After
//public void tearDown() {
//	driver.quit();
//
//}
