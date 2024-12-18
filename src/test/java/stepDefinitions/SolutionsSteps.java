package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class SolutionsSteps {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;
    }

    @Given("I click the Solutions button")
    public void i_click_the_solutions_button() {
        initializeDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        // This button is not clickable
        driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[1]")).isDisplayed();
    }

}
