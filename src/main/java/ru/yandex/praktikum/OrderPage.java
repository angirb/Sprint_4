package ru.yandex.praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPage {

    private final WebDriver driver;

    // поле ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода фамилии
    private final By surnameField = By.xpath(".//.//input[@placeholder='* Фамилия']");
    // поле ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле выбора метро
    private final By subwayStation = By.xpath("//input[@class='select-search__input']");
    // поле ввода телефона
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // выбор даты
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // выбор срока аренды
    private final By rentField = By.xpath(".//div[@class='Dropdown-root']");
    // выбор черного цвета
    private final By colourBlackCheck = By.xpath(".//input[@id = 'black']");
    // выбор серого цвета
    private final By colourGrayCheck = By.xpath(".//input[@id = 'grey']");
    // поле ввода комментария
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // кнопка подтверждения заказа
    private final By yesButton = By.xpath(".//button[text() = 'Да']");
    // подтверждение по тексту на экране
    private final By orderSuccess = By.xpath(".//div[text() = 'Заказ оформлен']");

    // методы заполнения информации пользователя и нажатя на кнопки
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void setSubwayStation(String text) {
        driver.findElement(subwayStation).click();
        driver.findElement(subwayStation).sendKeys(text, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    // метод нажатия на кнопку далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    // метода заполнения информации по заказу
    public void setDateField() {
        driver.findElement(dateField).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__week'][2]/div[1]")).click();
    }
    public void setRentField() {
        driver.findElement(rentField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div")).click();
    }
    public void setColourField(String colour) {
        if ("чёрный жемчуг".equals(colour)) {
            driver.findElement(colourBlackCheck).click();
        } else if ("серая безысходность".equals(colour)) {
            driver.findElement(colourGrayCheck).click();
        }
    }
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void setOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void setYesButton() {
        driver.findElement(yesButton).click();
    }
    public boolean isYesButtonIsVisible() {
        return driver.findElement(yesButton).isDisplayed();
    }
    public boolean isOrderSuccess() {
        return driver.findElement(orderSuccess).isDisplayed();
    }

}
