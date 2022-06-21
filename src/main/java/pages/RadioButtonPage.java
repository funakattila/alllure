package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends Page{

    private final String url = "http://demo.seleniumeasy.com/basic-radiobutton-demo.html";
    private final By femaleCheckBoxOne = By.xpath("//*[@class=\"panel panel-default\"][1]//input[@value=\"Female\"]");

    private final By getFemaleCheckBoxTwo = By.xpath("//*[@class=\"panel panel-default\"][2]//input[@value=\"Female" +
            "\"]");
    private final By age = By.xpath("//input[@value=\"15 - 50\"]");
    private final By buttonOne = By.xpath("//*[@class=\"panel panel-default\"][1]//button");
    private final By buttonTwo = By.xpath("//*[@class=\"panel panel-default\"][2]//button");
    private final By textOne = By.xpath("//*[@class=\"panel panel-default\"][1]//p[@class=\"radiobutton\"]");
    private final By textTwo = By.xpath("//*[@class=\"groupradiobutton\"]");




    private final By closePopUp = By.id("at-cv-lightbox-close");


    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;

    }

    public void navigate() {
        driver.navigate().to(url);
        //driver.findElement(closePopUp).click();
    }

    public void clickRadioButton(){
        driver.findElement(femaleCheckBoxOne).click();
    }

    public void clickSubmitButton() {
        driver.findElement(buttonOne).click();
    }

    public void clickFemaleTwo() {
        driver.findElement(getFemaleCheckBoxTwo).click();
    }

    public void clickAge() {
        driver.findElement(age).click();
    }

    public void clickSubmitTwo() {
        driver.findElement(buttonTwo).click();
    }

    public String getMessage() {
        String returnText = "";
        returnText = driver.findElement(textOne).getText();
        return returnText;
    }

    public String getMessageTwo() {
        String returnText = "";
        returnText = driver.findElement(textTwo).getText();
        return returnText;
    }


}
