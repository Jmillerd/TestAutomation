package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class ProductsSteps {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;
    }

    @Given("I click the Products button")
    public void i_click_the_about_us_button() {

        initializeDriver().get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.xpath("//a[text()='Products']")).click();
    }

    @Then("The Products page loads")
    public void the_about_us_page_loads() {
        String expectedUrl = "https://parabank.parasoft.com/parabank/index.htm";
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div[2]/div/div/div[1]/p[1]")).isDisplayed(), "The Products header is not visible.");
        driver.quit();
    }
}
