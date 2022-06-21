package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DualListPage;

import java.util.concurrent.TimeUnit;

public class DualListBoxTest extends BaseTest{

    WebDriver driver;


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
    public void TestAddSingleElement()
    {
        DualListPage dualListPage = new DualListPage(driver);

        dualListPage.navigate();
        dualListPage.addOne();

        int expectedSource = 14;
        int actualSource = dualListPage.countDataInSource();

        Assertions.assertEquals(expectedSource, actualSource);
        Assertions.assertTrue(dualListPage.isElementInList());

    }

    @Test
    public void TestAddAllElementButton()
    {
        DualListPage dualListPage = new DualListPage(driver);

        dualListPage.navigate();
        dualListPage.addAll();

        int expected = 15;
        int actual = dualListPage.countDataInResult();

        Assertions.assertEquals(expected, actual);

    }

    @AfterEach
    public void close() {
        driver.close();
    }

}
