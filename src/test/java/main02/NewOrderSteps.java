package main02;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main02.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewOrderSteps {
    private WebDriver driver;

    @Given("I'm on main page - order.")
    public void openMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I go to login page - order.")
    public void signIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }

    @And("I login using {string} and {string} - order.")
    public void userLogin(String login, String passwd) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn(login, passwd);
    }

    @Then("I can see my {string} page: {string}.")
    public void signIn(String ExpectedPage, String ExpectedUrl) {
        MyAccountPage accountPage = new MyAccountPage(driver);
        accountPage.signIn(ExpectedPage, ExpectedUrl);
    }

    @When("I go to shop.")
    public void openClothesPage() {
        MyAccountPage accountPage = new MyAccountPage(driver);
        accountPage.openClothesPage();
    }

    @And("I select Hummingbird Printed Sweater.")
    public void selectSweater() {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.selectSweater();
    }

    @And("I see discount 20%.")
    public void checkDiscount() {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.checkDiscount();
    }

    @And("I select {string} size.")
    public void selectSize(String size) {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.selectSize(size);
    }

    @And("I select {string} pieces.")
    public void selectQuantity(String qty) throws InterruptedException {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.selectQuantity(qty);
    }

    @Then("I add item to cart.")
    public void addToCart() {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.addToCart();
    }

    @When("I proceed to checkout.")
    public void proceedToCheckout() {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.proceedToCheckout();
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }

    @When("I confirm address.")
    public void confirmAddress() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.confirmAddress();
    }
}
