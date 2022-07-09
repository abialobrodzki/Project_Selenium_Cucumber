package main01.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginIn(String login, String passwd) {
        WebElement loginInput = driver.findElement(By.xpath("//*[contains(@name,'email')]"));
        loginInput.clear();
        loginInput.sendKeys(login);

        WebElement passwdInput = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        passwdInput.clear();
        passwdInput.sendKeys(passwd);

        driver.findElement(By.xpath("//*[contains(@id,'submit-login')]")).click();
    }
}
