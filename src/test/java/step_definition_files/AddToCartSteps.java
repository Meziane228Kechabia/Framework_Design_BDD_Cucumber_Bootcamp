package step_definition_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorialsNinja.Pages.AddToCartPage;
import tutorialsNinja.Pages.HomePage;
import tutorialsNinja.Pages.ProductPage;

public class AddToCartSteps {
	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;
	public AddToCartPage addToCartPage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo");
        homePage = new HomePage(driver);
    }

    @When("I search for a valid product")
    public void i_search_for_a_valid_product() {
        productPage = homePage.navigateToProductPage("HP");
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        addToCartPage = productPage.clickOnAddToCartButton();
    }

    @Then("I should see the product price in the cart")
    public void i_should_see_the_product_price_in_the_cart() {
        Assert.assertTrue(addToCartPage.displayStatusOfLaptopPrice());
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        String actualSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedSuccessMessage = "Success: You have added ";
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
    }

    @Then("I should see the cart updated")
    public void i_should_see_the_cart_updated() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='cart-total'][text()=' 1 item(s) - $122.00']")).isDisplayed());
        driver.findElement(By.id("cart")).click();
    }
}

