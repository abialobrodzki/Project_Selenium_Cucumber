package main01.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyNewAddress {
    private WebDriver driver;

    public MyNewAddress(WebDriver driver) {
        this.driver = driver;
    }

    public void NewAddressData(String alias, String address, String city, String postcode, String country, String phone) {
        WebElement aliasElement = driver.findElement(By.xpath("//*[contains(@name,'alias')]"));
        aliasElement.clear();
        aliasElement.sendKeys(alias);
        WebElement nameElement = driver.findElement(By.xpath("//*[contains(@name,'firstname')]"));
        nameElement.getText();
        WebElement lastnameElement = driver.findElement(By.xpath("//*[contains(@name,'lastname')]"));
        lastnameElement.getText();
        WebElement addressElement = driver.findElement(By.xpath("//*[contains(@name,'address1')]"));
        addressElement.clear();
        addressElement.sendKeys(address);
        WebElement cityElement = driver.findElement(By.xpath("//*[contains(@name,'city')]"));
        cityElement.clear();
        cityElement.sendKeys(city);
        WebElement postcodeElement = driver.findElement(By.xpath("//*[contains(@name,'postcode')]"));
        postcodeElement.clear();
        postcodeElement.sendKeys(postcode);
        WebElement countryElement = driver.findElement(By.xpath("//*[contains(@name,'country')]"));
        countryElement.getText();
        WebElement phoneElement = driver.findElement(By.xpath("//*[contains(@name,'phone')]"));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void clickBtn() {
        driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary')]")).click();
    }

}
