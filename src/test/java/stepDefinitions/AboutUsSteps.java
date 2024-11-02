package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class AboutUsSteps {

    private WebDriver driver;

    // Initialize the WebDriver in a non-headless mode
    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;
    }

    @Given("I click the About Us button")
    public void i_click_the_about_us_button() {
        // Open the initial URL
        initializeDriver().get("https://parabank.parasoft.com/parabank/index.htm");  // Replace with your actual URL

        // Click the About Us button using the appropriate XPath
        driver.findElement(By.xpath("//a[text()='About Us']")).click();
    }

    @Then("The About Us page loads")
    public void the_about_us_page_loads() {
        // Verify that the About Us page loads by checking the URL or a specific element on the page
        String expectedUrl = "https://parabank.parasoft.com/parabank/index.htm";  // Replace with the expected URL of the About Us page
       // Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The About Us page did not load as expected.");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
        // Optionally, verify that a unique element on the About Us page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/h1")).isDisplayed(), "The About Us header is not visible.");

        // Close the driver at the end of the test
        driver.quit();
    }
}
