package main01;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main01.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewAddressSteps {
    private WebDriver driver;

    @Given("I'm on main page.")
    public void openMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I go to login page.")
    public void openLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }

    @And("I login using {string} and {string}.")
    public void userLogin(String login, String passwd) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn(login, passwd);
    }

    @And("I go to my {string} page url: {string}.")
    public void openAddressesPage(String ExpectedPage, String ExpectedUrl) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.signIn(ExpectedPage, ExpectedUrl);
    }

    @Then("I can see button \"Create new address\".")
    public void seeBtn() {
        MyAddresses myAddresses = new MyAddresses(driver);
        myAddresses.seeBtn();
    }

    @When("I go to create new address.")
    public void createNewAddress() {
        MyAddresses myAddresses = new MyAddresses(driver);
        myAddresses.clickBtn();
    }

    @And("^I enter new address data: (.+), (.+), (.+), (.+), (.+), (.+).$")
    public void enterNewAddressData(String alias, String address, String city, String postcode, String country, String phone) {
        MyNewAddress myNewAddress = new MyNewAddress(driver);
        myNewAddress.NewAddressData(alias, address, city, postcode, country, phone);
        myNewAddress.clickBtn();
    }
//
//        //nowy obiekt klasy - uruchomienie przeglądarki - implementacja interfejsu WebDriver
//        WebDriver driver = new ChromeDriver();
//        //maksymalizacja okna przeglądarki
//        driver.manage().window().maximize();
//        //wejście na stronę Google.com
//        driver.get("http://www.google.com");
//        //dodanie kodu na minimalizację zgód RODO - znalezienie elementu na stronie
//        driver.findElement(By.id("L2AGLb")).click();
//        //szukanie elementu - pola do wpisania w wyszukiwarce
//        WebElement element = driver.findElement(By.name("q"));
//        //czyszczenie pola formularza
//        element.clear();
//        //wpisanie zawartości w pole formularze
//        element.sendKeys("Coderslab");
//        //wysłanie formularza
//        element.submit();
//        //zamknięcie przeglądarki
//        driver.quit();
}
