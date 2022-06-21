package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends Page{

    private final String url = "http://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private final By allertButton = By.xpath("//*[@class=\"panel panel-primary\"][3]//button");
    private final By promtMessage = By.xpath("//*[@id=\"prompt-demo\"]");


    private final By closePopUp = By.id("at-cv-lightbox-close");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigate() {
        driver.navigate().to(url);
        //driver.findElement(closePopUp).click();
    }

    public void clickButton() {
        driver.findElement(allertButton).click();
    }

    public String getMessage() {
        return driver.findElement(promtMessage).getText();
    }


}
