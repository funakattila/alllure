package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFieldPage extends Page{

    private final String url = "http://demo.seleniumeasy.com/basic-first-form-demo.html";

    private final By firstNumber = By.xpath("//input[@id=\"sum1\"]");
    private final By secondNumber = By.xpath("//input[@id=\"sum2\"]");
    private final By getTotalButton = By.xpath("//*[@id=\"gettotal\"]/button");
    private final By value = By.xpath("//*[@id=\"displayvalue\"]");
    private final By closePopUp = By.id("at-cv-lightbox-close");

    public InputFieldPage(WebDriver driver) {
        this.driver = driver;

    }

    public void navigate() {
        driver.navigate().to(url);
        driver.findElement(closePopUp).click();
    }

    public void addNumbers(String a, String b) {
        driver.findElement(firstNumber).sendKeys(a);
        driver.findElement(secondNumber).sendKeys(b);
    }

    public void clickButton() {
        driver.findElement(getTotalButton).click();
    }

    public String getValue() {
        String total = "";
        total = driver.findElement(value).getText();
        return total;
    }


}
