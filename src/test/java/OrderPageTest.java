import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.OrderPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest {

    WebDriver driver;
    // driver для запуска теста на firefox
    WebDriver ffdriver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //ffdriver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //ffdriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    }
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String colour;
    private final String comment;


    public OrderPageTest(String name, String surname, String address, String phone,
                         String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.colour = colour;
        this.comment = comment;


    }

    @Parameterized.Parameters
    public static String[][] getClientData() {
        return new String[][]{
                {"Ян", "Тян", "Варшавское шоссе 234", "89296636404", "чёрный жемчуг", "комментарий"},
                {"Василий", "Петров", "Ставропольская 17", "892966363232", "серая безысходность", "Придивыфвыфвыфвыф"}
        };
    }



    @Test
    public void checkFieldsInputUpButtonOrder() {
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);

        // открываем главную страницу
        mainPage.openMainPage();
        // принимаем куки
        mainPage.clickCookiesButton();
        // нажимаем на кнопку Заказать в верхней части страницы
        mainPage.clickOrderUpButton();
        // заполняем информацию на первой странице заказа
        orderPage.setNameField(name);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setSubwayStation("текст");
        orderPage.setPhoneField(phone);
        // нажимаем кнопку далее
        orderPage.clickNextButton();
        // заполняем информацию на второй странице заказа
        orderPage.setDateField();
        orderPage.setRentField();
        orderPage.setColourField(colour);
        orderPage.setCommentField(comment);
        // нажимаем кнопку заказать
        orderPage.setOrderButton();
        // Подтверждаем заказ
        orderPage.setYesButton();

        boolean isDisplayed = orderPage.isOrderSuccess();
        assertTrue(isDisplayed);


    }

    @Test
    public void checkFieldsInputBottomButtonOrder() {
        OrderPage orderPage = new OrderPage(driver);

        MainPage mainPage = new MainPage(driver);

        // открываем главную страницу
        mainPage.openMainPage();
        // принимаем куки
        mainPage.clickCookiesButton();
        // скролим до нижней книпки заказать
        mainPage.scrollDownToFaqSection();
        // нажимаем на кнопку Заказать внизу страницы
        mainPage.clickOrderBottomButton();
        // заполняем информацию на первой странице заказа
        orderPage.setNameField(name);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setSubwayStation("текст");
        orderPage.setPhoneField(phone);
        // нажимаем кнопку далее
        orderPage.clickNextButton();
        // заполняем информацию на второй странице заказа
        orderPage.setDateField();
        orderPage.setRentField();
        orderPage.setColourField(colour);
        orderPage.setCommentField(comment);
        orderPage.setOrderButton();

        boolean isVisible = orderPage.isYesButtonIsVisible();
        assertTrue(isVisible);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

