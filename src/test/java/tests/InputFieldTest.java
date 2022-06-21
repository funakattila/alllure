package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.InputFieldPage;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class InputFieldTest {

    WebDriver driver;

    String validFirstNum = "5";
    String validSecondNum = "6";

    String validTotal = "11";

    String inValidFirstNum = "abc";
    String inValidSecondNum = "def";
    String invalidTotal = "NaN";

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

    @Description("Összeadás valid adatokkal")
    @Test
    public void TestSumTwoNumbers()
    {
        InputFieldPage inputFieldPage = new InputFieldPage(driver);

        inputFieldPage.navigate();
        inputFieldPage.addNumbers(validFirstNum, validSecondNum);
        inputFieldPage.clickButton();

        String expected = validTotal;
        String actual = inputFieldPage.getValue();

        Allure.addAttachment("Valid eredmény",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Assertions.assertEquals(expected, actual);


    }

    @Description("Összeadás invalid adatokkal")
    @Test
    public void TestSumTwoInvalidInputs()
    {
        InputFieldPage inputFieldPage = new InputFieldPage(driver);

        inputFieldPage.navigate();
        inputFieldPage.addNumbers(inValidFirstNum, inValidSecondNum);
        inputFieldPage.clickButton();

        String expected = invalidTotal;
        String actual = inputFieldPage.getValue();

        Allure.addAttachment("Invalid eredmény",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Assertions.assertEquals(expected, actual);



    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
