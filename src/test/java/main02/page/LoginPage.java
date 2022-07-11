package main02.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@name,'email')]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[contains(@name,'password')]")
    private WebElement passwdInput;

    @FindBy(xpath = "//*[contains(@id,'submit-login')]")
    private WebElement signInBtn;

    public void loginIn(String login, String passwd) {
        loginInput.clear();
        loginInput.sendKeys(login);

        passwdInput.clear();
        passwdInput.sendKeys(passwd);

        signInBtn.click();
    }
}
