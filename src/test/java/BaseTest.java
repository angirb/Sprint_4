import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
protected WebDriver driver;

@Before
    public void before() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    WebDriverManager.firefoxdriver().setup();
//    ffDriver = new FirefoxDriver();
//    ffDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
    @After
    public void tearDown() {
        driver.quit();
    }
}
