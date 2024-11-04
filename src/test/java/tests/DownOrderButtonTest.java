package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ScooterForPage;

public class DownOrderButtonTest {
    private WebDriver driver;
    private MainPage mainPage;
    private ScooterForPage scooterForPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        scooterForPage = new ScooterForPage(driver);
        mainPage.closeCookie();
        driver.manage().window().maximize();
    }

    @Test
    public void downOrderButtonTest() {
        mainPage.scrollToDownOrderButton();
        mainPage.clickDownOrderButton();
        scooterForPage.isScooterForTextVisible();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
