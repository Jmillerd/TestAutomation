package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExampleSteps {
    WebDriver driver;

    @Given("I open the browser")
    public void i_open_the_browser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @When("I navigate to the website")
    public void i_navigate_to_the_website() {
        driver.get("https://www.example.com");
    }

    @Then("I verify the website title")
    public void i_verify_the_website_title() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Example Domain"));
        driver.quit();
    }
}
