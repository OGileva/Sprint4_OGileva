package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    //Локаторы
    //кнопки выпадающего списка
    private final By questionsToggleArrow = By.className("accordion__button");
    //открывающийся текст
    private final By openedText = By.className("accordion__panel");
    //кнопка "Да все привыкли"
    private final By cookieButton = By.id("rcc-confirm-button");
    //кнопка Заказать вверху страницы
    private final By upOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    //кнопка Заказать внизу страницы
    private final By downOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //


    //Методы
    //закрытие окна куки
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }
    //скролл до списка вопросов
    public void scrollToQuestionsList() {
        WebElement questionsList = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsList);
    }
    //клик на стрелку
    public void clickOnArrow(int index) {
        List<WebElement> buttons = driver.findElements(questionsToggleArrow);
        buttons.get(index).click();
    }
    //получение текста выпадающего списка
    public String getAnswerText(int index) {
        List<WebElement> answers = driver.findElements(openedText);
        return answers.get(index).getText();
    }
    //клик по кнопке 'Заказать' вверху страницы
    public void clickUpOrderButton() {
        WebElement orderButton = driver.findElement(upOrderButton);
        orderButton.click();
    }
    //скролл до кнопки 'Заказать' внизу страницы
    public void scrollToDownOrderButton() {
        WebElement element = driver.findElement(downOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downOrderButton));
    }
    //клик по кнопке 'Заказать' внизу страницы
    public void clickDownOrderButton() {
        WebElement orderButton = driver.findElement(downOrderButton);
        orderButton.click();
    }
}
