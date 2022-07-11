package main02.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String ExpectedPage, String ExpectedUrl) {
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ExpectedPage, ActualTitle);
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrl, ActualUrl);
        System.out.println("Weryfikacja logowania i przejścia do zakładki \"My account\": poprawna");
    }
}
