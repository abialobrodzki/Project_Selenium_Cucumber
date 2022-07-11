package main02;

import io.cucumber.java.en.Given;
import main02.page.MainPage;
import org.openqa.selenium.WebDriver;

public class NewOrderSteps {
    private WebDriver driver;

    @Given("I'm on main page - order.")
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }
}
