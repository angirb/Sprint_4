package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    // локатор для принятия куков
    private final By acceptCookies = By.className("App_CookieButton__3cvqF");
    // Кнопка заказа наверху страницы
    private final By orderUpButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // кнопка заказа внизу страницы
    private final By orderBottomButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор секции Вопросы о важном
    private final By faqSection = By.xpath(".//div[text()='Вопросы о важном']");
    // локатор ответа первого вопроса
    private final By faqFirstQuestionAnswer = By.xpath(".//p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    // локатор ответа второго вопроса
    private final By faqSecondQuestionAnswer = By.xpath(".//p[text() = 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    // локатор ответа третьего вопроса
    private final By faqThirdQuestionAnswer = By.xpath(".//p[text() = 'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    // локатор ответа четвертого вопроса
    private final By faqFourthQuestionAnswer = By.xpath(".//p[text() = 'Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    // локатор ответа пятого вопроса
    private final By faqFifthQuestionAnswer = By.xpath(".//p[text() = 'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    // локатор ответа шестого вопроса
    private final By faqSixthQuestionAnswer = By.xpath(".//p[text() = 'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    // локатор ответа седьмого вопроса
    private final By faqSeventhQuestionAnswer = By.xpath(".//p[text() = 'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    // локатор ответа последннго вопроса
    private final By faqLastQuestion = By.xpath(".//p[text() = 'Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    // метод нажатия кнопки куки
    public void clickCookiesButton() {
        if (driver.findElement(acceptCookies).isDisplayed()) ;
        driver.findElement(acceptCookies).click();
    }
    // метод нажатия верхней кнопки заказать
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }
    // метод нажатия нижней кнопки заказать
    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }
    // метод скрола страницы
    public void scrollDownToFaqSection() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(faqSection));
    }
    // клик на вопросы faq
    public void clickFaqQuestions(int index) {
        By locator = By.id("accordion__heading-" + index);
        driver.findElement(locator).click();
    }
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(faqSection));
    }
    // метод проверки первого ответа на вопросы
    public boolean clickFirstQuestionAnswer() {
        return driver.findElement(faqFirstQuestionAnswer).isDisplayed();
    }
    public boolean clickSecondQuestion() {
        return driver.findElement(faqSecondQuestionAnswer).isDisplayed();
    }
    public boolean clickThirdQuestion() {
        return driver.findElement(faqThirdQuestionAnswer).isDisplayed();
    }
    public boolean clickFourthQuestion() {
        return driver.findElement(faqFourthQuestionAnswer).isDisplayed();
    }
    public boolean clickFifthQuestion() {
        return driver.findElement(faqFifthQuestionAnswer).isDisplayed();
    }
    public boolean clickSixthQuestion() {
        return driver.findElement(faqSixthQuestionAnswer).isDisplayed();
    }
    public boolean clickSeventhQuestion() {
        return driver.findElement(faqSeventhQuestionAnswer).isDisplayed();
    }
    // метод проверки последнего ответа на вопросы
    public boolean clickLastQuestion() {
       return driver.findElement(faqLastQuestion).isDisplayed();
    }

}

