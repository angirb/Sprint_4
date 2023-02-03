import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MainPageTest {
WebDriver driver;
WebDriver ffDriver;

    @Before
    public void before() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    WebDriverManager.firefoxdriver().setup();
//    ffDriver = new FirefoxDriver();
//    ffDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void checkFaqQuestions() {

        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(0);
        mainPage.clickFaqQuestions(1);
        mainPage.clickFaqQuestions(2);
        mainPage.clickFaqQuestions(3);
        mainPage.clickFaqQuestions(4);
        mainPage.clickFaqQuestions(5);
        mainPage.clickFaqQuestions(6);
        mainPage.clickFaqQuestions(7);
        // проверям отображение текста в последнем вопросе
        boolean isDisplayed = mainPage.clickLastQuestion();
       assertTrue(isDisplayed);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
