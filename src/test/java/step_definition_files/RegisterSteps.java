package step_definition_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorialsNinja.Pages.AccountSuccessPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.RegisterPage;

public class RegisterSteps {
	public WebDriver driver;
	public HomePage homePage;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;

    @Given("I am on the register page")
    public void i_am_on_the_register_page() {
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo");
        homePage = new HomePage(driver);
        registerPage = homePage.twoInOneActionThenRegisterPage();
    }

    @When("I register with mandatory details")
    public void i_register_with_mandatory_details() {
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage("John", "Doe", "john@example.com", "1234567890", "password123", "password123");
    }

    @Then("I should see the account success message")
    public void i_should_see_the_account_success_message() {
        Assert.assertTrue(accountSuccessPage.validateAccountSuccessCreatedMessage());
    }

    // Similar step definitions for other scenarios
}
