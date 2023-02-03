package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
    // метод проверки последнего ответа на вопросы
    public boolean clickLastQuestion() {
       return driver.findElement(faqLastQuestion).isDisplayed();
    }

}

