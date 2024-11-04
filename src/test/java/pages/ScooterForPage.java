package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterForPage {
    private final WebDriver driver;
    public ScooterForPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    //поле Имя
    private final By nameFiled = By.xpath("//input[@placeholder='* Имя']");
    //поле Фамилия
    private final By surnameFiled = By.xpath("//input[@placeholder='* Фамилия']");
    //поле Адрес
    private final By addressFiled = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле Метро
    private final By metroStationFiled = By.xpath("//input[@placeholder='* Станция метро']");
    //выбранная станции метро
    //private final By metroStation = By.xpath(".//*[text() = 'Черкизовская']");
    //поле Телефон
    private final By phoneFiled = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //заголовок Для кого самокат
    private final By scooterForHeaderText = By.xpath(".//*[text() = 'Для кого самокат']");


    //Методы
    //заполнение поля Имя
    public void setName(String name) {
        driver.findElement(nameFiled).sendKeys(name);
    }
    //заполнение поля Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameFiled).sendKeys(surname);
    }
    //заполнение поля Адрес
    public void setAddress(String address) {
        driver.findElement(addressFiled).sendKeys(address);
    }
    //заполнение поля Метро
    public void setMetroStation(String metroStationName) {
        driver.findElement(metroStationFiled).click();
        driver.findElement(By.xpath(".//*[text() = '" + metroStationName + "']")).click();
    }
    //заполнение поля Телефон
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneFiled).sendKeys(phoneNumber);
    }
    //заполнение всех полей
    public void allFields(String name, String surname, String address, String metroStationName, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStationName);
        setPhoneNumber(phoneNumber);
    }
    //нажатие на кнопку Далее
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    //проверить заголовок Для кого самокат
    public void isScooterForTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkScooterForText = wait.until(ExpectedConditions.visibilityOfElementLocated(scooterForHeaderText));
        Assert.assertTrue("Текст 'Для кого самокат' не виден", checkScooterForText.isDisplayed());
    }
}
