package step_definition_files;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.ProductPage;
import tutorialsNinja.TestBase.TestBase;

public class SearchProductSteps extends TestBase {
	
	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;
	
	public SearchProductSteps() throws Exception {
		super();
	}
    @Given("I am on the homepage")
    public void i_am_on_the_home_page() {
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo");
        homePage = new HomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        productPage = homePage.navigateToProductPage(product);
    }

    @Then("I should see {string} message")
    public void i_should_see_message(String expectedMessage) {
        assertTrue(productPage.verifyInvalidProductWarningMessageDisplay());;
    }
    @Then("I should see message in the search results {string}")
    public void i_should_see_message_in_the_search_result(String expectedMessage) {
    	assertTrue(productPage.verifyInvalidProductWarningMessageDisplay());
    	
    }
   
    

    // Similar step definitions for other scenarios
}
