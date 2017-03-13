package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by michel on 13-3-2017.
 */
public class ExampleSteps {

    public WebDriver driver;

    @Before
    public void startUp() throws Throwable {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^I am on the Polteq WebShop home page$")
    public void I_am_on_the_Polteq_WebShop_home_page() throws Throwable {
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @When("^I log into the site as a \"([^\"]*)\" user$")
    public void I_log_into_the_site_as_a_user(String arg1) throws Throwable {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("michel.lalmohamed@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("pswpsw123");
        driver.findElement(By.id("SubmitLogin")).click();

    }

    @Then("^I should be taken to the \"([^\"]*)\" page$")
    public void I_should_be_taken_to_the_page(String arg1) throws Throwable {
        Assertions.assertThat(driver.getTitle()).isEqualTo("My account - TestShop");
    }

    @After
    public void cleanUp() throws Throwable {
        driver.quit();
    }
}
