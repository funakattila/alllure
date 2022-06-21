package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgressBarPage extends Page{

    private final String url = "http://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private final By downloadBtn = By.xpath("//*[@id=\"cricle-btn\"]");
    private final By percenttext = By.xpath("//*[@class=\"percenttext\"]");


    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void clickToDownload() {
        driver.findElement(downloadBtn).click();
    }









}
