package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPage {
    private final WebDriver driver;
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    //поле Когда привезти самокат
    private final By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //поле Срок аренды
    private final By rentTimeField = By.xpath("//div[@class='Dropdown-placeholder']");
    //стрелка Срок аренды
    private final By rentTimeArrow = By.className("Dropdown-arrow");
    //Выбор срока аренды
    private final By getRentTime = By.xpath(".//*[text() = 'сутки']");
    //поле Цвет самоката
    private final By scooterColor = By.xpath("//div[@class='Order_Title__3EKne']");
    //чек бокс Черный жемчуг
    private final By checkBoxBlack = By.xpath("//input[@id='black']");
    //чек бокс Серая безысходность
    private final By checkBoxGrey = By.xpath("//input[@id='grey']");
    //поле Комментарий для курьера
    private final By commentForCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка Заказать формы Про аренду
    private final By orderButtonAboutRentPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Да всплывающего окна 'Хотите оформить заказ'
    private final By yesButton = By.xpath("//button[contains(text(),'Да')]");
    //заголовок окна Заказ оформлен
    private final By orderCompleteText = By.xpath(".//*[text() = 'Заказ оформлен']");



    //Методы
    //заполнение поля Когда привезти самокат
    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(rentTimeArrow).click();
    }
    //заполнение поля Срок Аренды
    public void setRentTime() {
        driver.findElement(getRentTime).click();
    }
    //выбор цвета самоката
    public void setScooterColor() {
        driver.findElement(checkBoxBlack).click();
    }
    //оставить комментарий для курьера
    public void setCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }
    //заполнить поля одним методом
    public void allFieldsAboutRent(String deliveryDate, String comment) {
        setDeliveryDate(deliveryDate);
        setRentTime();
        setScooterColor();
        setCommentForCourier(comment);
    }
    //нажать на кнопку Заказать в форме Про аренду
    public void clickOrderButtonAboutRentPage() {
        driver.findElement(orderButtonAboutRentPage).click();
    }
    //нажать на кнопку Да всплывающего окна
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    //проверить заголовок Заказ оформлен
    public void isOrderCompleteTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkOrderCompleteText = wait.until(ExpectedConditions.visibilityOfElementLocated(orderCompleteText));
        Assert.assertTrue("Текст 'Заказ оформлен' не отображается", checkOrderCompleteText.isDisplayed());
    }
}
