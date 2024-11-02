package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class ExampleSteps {

    private WebDriver driver; // private = restricted access

    // Getter
    public WebDriver getDriver() {
        return driver;
    }

    // Setter
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

   /* public WebDriver headlessDriver(){
        // Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

        // Path to the headless Chrome binary
        String headlessChromePath = "C:\\Users\\Jessi\\Downloads\\chrome-headless-shell-win64\\chrome-headless-shell-win64\\chrome-headless-shell.exe";


        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setBinary(headlessChromePath);
        options.addArguments("--headless", "--disable-gpu");
        options.addArguments("--remote-allow-origins=*");  // Allow all origins for WebSocket connections

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
        return driver;
    }

    */

    public  WebDriver nonHeadlessDriver() {

        if(driver == null) {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\OneDrive\\Desktop\\Test_Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");

            // Set up ChromeOptions without the headless argument
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");  // Allow WebSocket connections

            // Initialize WebDriver with ChromeOptions in non-headless mode
            driver = new ChromeDriver(options);
            setDriver(driver);
        }

        return driver;
    }



    @Given("I navigate to the website")
    public void i_navigate_to_the_website() {
        nonHeadlessDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        nonHeadlessDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @When("I fill out the login form")
    public void i_fill_out_the_login_form(){
        nonHeadlessDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("username");
        nonHeadlessDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        nonHeadlessDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(20));
    }

    @Then("The submit button is displayed")
    public void the_submit_button_is_displayed() {
        i_fill_out_the_login_form();
        nonHeadlessDriver().findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).isDisplayed();
        nonHeadlessDriver().quit();
    }

}
