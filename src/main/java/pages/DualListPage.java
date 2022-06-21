package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DualListPage extends Page {

    private final String url = "http://demo.seleniumeasy.com/jquery-dual-list-box-demo.html";
    private final By addAllButton = By.xpath("//*[@class=\"pAddAll btn btn-primary btn-sm\"]");
    private final By addButton = By.xpath("//*[@class=\"pAdd btn btn-primary btn-sm\"]");
    private final By sourceData = By.xpath("//*[@class=\"form-control pickListSelect pickData\"]/option");
    private final By resultData = By.xpath("//*[@class=\"form-control pickListSelect pickListResult\"]/option");
    private final By isabella = By.xpath("//option[@data-id=\"4\"]");



    public DualListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void addAll() {
        driver.findElement(addAllButton).click();
    }

    public int countDataInResult() {
        int numberOfData = 0;
        List<WebElement> list = driver.findElements(resultData);

        for (WebElement item : list) {
            numberOfData += 1;
        }

        return numberOfData;
    }

    public void addOne() {
        driver.findElement(isabella).click();
        driver.findElement(addButton).click();
    }

    public int countDataInSource() {
        int numberOfData = 0;
        List<WebElement> list = driver.findElements(sourceData);

        for (WebElement item : list) {
            numberOfData += 1;
        }

        return numberOfData;
    }

    public boolean isElementInList() {

        List<WebElement> list = driver.findElements(resultData);
        boolean isIn = false;

        for (WebElement item : list) {
            if (item.getText().equals("Isabella")) {
                isIn = true;
                break;
            }
        }
         return isIn;
    }



}
