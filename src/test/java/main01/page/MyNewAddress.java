package main01.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class MyNewAddress {
    private WebDriver driver;
    public final String NAME = "Adrianna";
    public final String LASTNAME = "Nowak";
    public final String FULLNAME = "Adrianna Nowak";

    public MyNewAddress(WebDriver driver) {
        this.driver = driver;
    }

    public void NewAddressData(String alias, String address, String city, String postcode, String country, String phone) {
        WebElement aliasElement = driver.findElement(By.xpath("//*[contains(@name,'alias')]"));
        aliasElement.clear();
        aliasElement.sendKeys(alias);
        WebElement nameElement = driver.findElement(By.xpath("//*[contains(@name,'firstname')]"));
        String name = nameElement.getAttribute("value");
        Assert.assertEquals(NAME, name);
        WebElement lastnameElement = driver.findElement(By.xpath("//*[contains(@name,'lastname')]"));
        String lastname = lastnameElement.getAttribute("value");
        Assert.assertEquals(LASTNAME, lastname);
        WebElement addressElement = driver.findElement(By.xpath("//*[contains(@name,'address1')]"));
        addressElement.clear();
        addressElement.sendKeys(address);
        WebElement cityElement = driver.findElement(By.xpath("//*[contains(@name,'city')]"));
        cityElement.clear();
        cityElement.sendKeys(city);
        WebElement postcodeElement = driver.findElement(By.xpath("//*[contains(@name,'postcode')]"));
        postcodeElement.clear();
        postcodeElement.sendKeys(postcode);
        WebElement countryElement = driver.findElement(By.xpath("//*[contains(@value,'17')]"));
        countryElement.getText();
        WebElement phoneElement = driver.findElement(By.xpath("//*[contains(@name,'phone')]"));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void clickBtn() {
        driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary')]")).click();
    }

    /**
     * sprawdzenie dodanych danych adresowych do stworzonego adresu
     */
    public void checkAddress(String alias, String address, String city, String postcode, String country, String phone) {
        String actualAlias = driver.findElement(By.xpath("/*//div[5]//h4")).getText();
        Assert.assertEquals(actualAlias, alias);
        String[] actualAddress = driver.findElement(By.xpath("//div[5]//div[1]/address")).getText().split("\n");
        actualAddress = Arrays.copyOf(actualAddress, actualAddress.length);
        System.out.println(String.join("\n", actualAddress));
        Assert.assertEquals(FULLNAME, actualAddress[0]);
        Assert.assertEquals(address, actualAddress[1]);
        Assert.assertEquals(city, actualAddress[2]);
        Assert.assertEquals(postcode, actualAddress[3]);
        Assert.assertEquals(country, actualAddress[4]);
        Assert.assertEquals(phone, actualAddress[5]);
        System.out.println("Weryfikacja dodanego adresu: poprawna");
    }
}
