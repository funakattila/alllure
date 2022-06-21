package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RadioButtonPage;

import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    WebDriver driver;

    String textOneReturned = "Radio button 'Female' is checked";
    String textTwoReturned = "Sex : Female\n" +
            "Age group: 15 - 50";





    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Description("Rádiógomb teszt")
    @Test
    public void TestSingleCheckedButton()
    {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.navigate();
        radioButtonPage.clickRadioButton();
        radioButtonPage.clickSubmitButton();

        String expected = textOneReturned;
        String actual = radioButtonPage.getMessage();

        Assertions.assertEquals(expected, actual);


    }

    @Description("Rádiógomb teszt 2")
    @Test
    public void TestMultipleCheckedButton()
    {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.navigate();
        radioButtonPage.clickFemaleTwo();
        radioButtonPage.clickAge();
        radioButtonPage.clickSubmitTwo();

        String expected = textTwoReturned;
        String actual = radioButtonPage.getMessageTwo();

        Assertions.assertEquals(expected, actual);

    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
