package main02.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    private WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@alt,'sweater')]")
    private WebElement selectSweater;

    public void selectSweater() {
        selectSweater.click();
    }

    @FindBy(xpath = "//*[contains(@class,'discount-percentage')]")
    private WebElement discount;

    @FindBy(xpath = "//*[contains(@class,'regular-price')]")
    private WebElement priceBefore;

    @FindBy(xpath = "//*[@id=\"main\"]//div[2]/div/span[1]")
    private WebElement priceAfter;

    public void checkDiscount() {
        /** pobranie cen i wyliczenie obniżki */
        String priceDiscount = discount.getText().substring(5, 7);
        String priceOld = priceBefore.getText().substring(1);
        String priceNew = priceAfter.getText().substring(1);
        double discount = Double.parseDouble(priceDiscount);
        double priceO = Double.parseDouble(priceOld);
        double priceN = Double.parseDouble(priceNew);
        double result = (100 - discount) / 100 * priceO;
        double resultRound = Math.round(result * 100.0) / 100.0;
        if (resultRound == priceN) {
            System.out.println("Weryfikacja wysokości obniżki o " + discount + "%: poprawna");
        } else {
            System.out.println("Weryfikacja wysokości obniżki o " + discount + "%: niepoprawna");
        }
    }
}
