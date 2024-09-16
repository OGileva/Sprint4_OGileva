package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ScooterForPage;
import pages.AboutRentPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStationName;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String comment;
    private WebDriver driver;
    private MainPage mainPage;
    private ScooterForPage scooterForPage;
    private AboutRentPage aboutRentPage;

    public OrderTest(String name, String surname, String address, String metroStationName, String phoneNumber, String deliveryDate, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationName = metroStationName;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] addOrder(){
        return new Object[][] {
                {"Анна", "Иванова", "Ленина, 5", "Черкизовская", "89997776655", "20.09.2024", "Позвонить"},
                {"Иван", "Петров", "Маркса 10", "Арбатская", "79876543322", "11.09.2024", "Добрый день"}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        scooterForPage = new ScooterForPage(driver);
        aboutRentPage = new AboutRentPage(driver);
        driver.manage().window().maximize();
        mainPage.closeCookie();
    }

    @Test
    public void addOrderTest() {
        mainPage.clickUpOrderButton();
        scooterForPage.allFields(name, surname, address, metroStationName, phoneNumber);
        scooterForPage.clickNextButton();
        aboutRentPage.allFieldsAboutRent(deliveryDate, comment);
        aboutRentPage.clickOrderButtonAboutRentPage();
        aboutRentPage.clickYesButton();
        aboutRentPage.isOrderCompleteTextVisible();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
