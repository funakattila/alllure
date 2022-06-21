package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertPage;

import java.util.concurrent.TimeUnit;

public class AlertTest extends BaseTest{

    WebDriver driver;

    String sendNameOne = "Monica Belucci";
    String sendNameTwo = "Kim Basinger";
    String message = "You have entered 'Monica Belucci' !";

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

    @Test
    public void TestSubmitValidInput()
    {
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigate();
        alertPage.clickButton();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(sendNameOne);
        alert.accept();

        String expected = message;
        String actual = alertPage.getMessage();

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void TestInputCancel() throws InterruptedException {
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigate();
        alertPage.clickButton();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(sendNameOne);
        alert.accept();

        Thread.sleep(5000);

        alertPage.clickButton();
        WebDriverWait waitTwo = new WebDriverWait(driver, 20);
        Alert alertTwo = waitTwo.until(ExpectedConditions.alertIsPresent());
        alertTwo.sendKeys(sendNameTwo);
        alertTwo.dismiss();

        String expected = message;
        String actual = alertPage.getMessage();

        Assertions.assertEquals(expected, actual);

    }


    @AfterEach
    public void close() {
        driver.close();
    }


}
