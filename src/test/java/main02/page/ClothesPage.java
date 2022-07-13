package main02.page;

import org.junit.Assert;
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

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[1]")
    private WebElement sizeS;
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement sizeM;
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[3]")
    private WebElement sizeL;
    @FindBy(xpath = "//*[@id=\"group_1\"]/option[4]")
    private WebElement sizeXL;

    public void selectSize(String size) {
        if (size.equals("S")) {
            sizeS.click();
        } else if (size.equals("M")) {
            sizeM.click();
        } else if (size.equals("L")) {
            sizeL.click();
        } else if (size.equals("XL")) {
            sizeXL.click();
        }
    }

    @FindBy(xpath = "//*[contains(@class,'touchspin-up')]")
    private WebElement upArrowBtn;
    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement setQuantity;

    public void selectQuantity(String qty) throws InterruptedException {
        int quantity = Integer.parseInt(qty);
        for (int i = 0; i <= quantity; i++) {
            upArrowBtn.click();
            Thread.sleep(10);
        }
        Thread.sleep(10);
        String getQuantity = setQuantity.getAttribute("value");
        int checkQuantity = Integer.parseInt(getQuantity);
        if (quantity == 1) {
            setQuantity.clear();
            upArrowBtn.click();
        } else if (checkQuantity != quantity) {
            upArrowBtn.click();
        }
    }

    @FindBy(xpath = "//*[contains(@data-button-action,'add-to-cart')]")
    private WebElement addToCartBTn;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div")
    private WebElement successCart;

    public void addToCart() {
        addToCartBTn.click();
        Assert.assertTrue(successCart.isEnabled());
        System.out.println("Weryfikacja dodania do koszyka: poprawna");
    }

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]//a")
    private WebElement checkoutBtn;

    public void proceedToCheckout() {
        checkoutBtn.click();
    }


}
