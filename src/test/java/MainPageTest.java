import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {

   @Before
    public void before() {
       super.before();
   }

    @Parameterized.Parameters
    public static Object[][] getFaq() {
        return new Object[][]{
                {"browser1"},
                {"browser2"},
        };
    }

    @Test
    public void checkFaqQuestion1() {

        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(0);
        mainPage.waitForLoadMainPage();
        mainPage.clickFirstQuestionAnswer();
        boolean isDisplayed = mainPage.clickFirstQuestionAnswer();
        assertTrue(isDisplayed);
    }

    @Test
    public void checkFaqQuestion2() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(1);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickSecondQuestion();
        assertTrue(isDisplayed);
    }

    @Test
        public void checkFaqQuestion3() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(2);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickThirdQuestion();
        assertTrue(isDisplayed);
    }
    @Test
    public void checkFaqQuestion4() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(3);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickFourthQuestion();
        assertTrue(isDisplayed);
    }
    @Test
    public void checkFaqQuestion5() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(4);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickFifthQuestion();
        assertTrue(isDisplayed);
    }
    @Test
    public void checkFaqQuestion6() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(5);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickSixthQuestion();
        assertTrue(isDisplayed);
    }
    @Test
    public void checkFaqQuestion7() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(6);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickSeventhQuestion();
        assertTrue(isDisplayed);

    }
    @Test
    public void checkFaqQuestion8() {
        MainPage mainPage = new MainPage(driver);
        // открываем главную страницу
        mainPage.openMainPage();
        // кликаем куки
        mainPage.clickCookiesButton();
        // скроолим до faq
        mainPage.scrollDownToFaqSection();
        // кликаем на каждый вопрос
        mainPage.clickFaqQuestions(7);
        mainPage.waitForLoadMainPage();
        boolean isDisplayed = mainPage.clickLastQuestion();
        assertTrue(isDisplayed);
        // проверям отображение текста в последнем вопросе

    }

}
