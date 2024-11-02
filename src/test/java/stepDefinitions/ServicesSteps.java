package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class ServicesSteps {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;
    }

    @Given("I click the Services button")
    public void i_click_the_services_button() {
        initializeDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("//a[text()='Services']")).click();
    }
    @Then("The Services page loads")
    public void the_services_page_loads() {
        String expectedUrl = "https://parabank.parasoft.com/parabank/index.htm";
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[3]/a")).isDisplayed(), "The Services header is not visible.");
    }
}
