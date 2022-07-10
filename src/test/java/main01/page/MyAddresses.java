package main01.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddresses {
    private WebDriver driver;

    public MyAddresses(WebDriver driver) {
        this.driver = driver;
    }

    public void seeBtn() {
        WebElement btnCreateNewAddress = driver.findElement(By.xpath("//*[contains(@data-link-action,'add-address')]"));
        Assert.assertTrue(btnCreateNewAddress.isDisplayed());
        System.out.println("Weryfikacja widoczności przycisku \"Create new address\": poprawna");
    }

    public void clickBtn() {
        driver.findElement(By.xpath("//*[contains(@data-link-action,'add-address')]")).click();
    }

    public void clickDelete() {
        driver.findElement(By.xpath("/*//div[5]//a[2]/span")).click();
    }

    public void checkDelete() {
        WebElement message = driver.findElement(By.xpath("//*[contains(@data-alert,'success')]"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("Weryfikacja usunięcia adresu: poprawna");
    }

    public void browserExit() {
        driver.quit();
    }
}
