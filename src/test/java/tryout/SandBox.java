package tryout;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Created by michel on 13-3-2017.
 */
public class SandBox {

    @Test
    public void testRun(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }
}
