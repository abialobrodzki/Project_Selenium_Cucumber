package main02.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@name,'confirm-addresses')]")
    private WebElement confirmAddressBtn;

    public void confirmAddress() {
        confirmAddressBtn.click();
    }

    @FindBy(xpath = "//*[contains(@value,'1,')]")
    private WebElement setDelivery;
    @FindBy(xpath = "//*[contains(@name,'confirmDeliveryOption')]")
    private WebElement confirmDeliveryBtn;

    public void confirmDelivery(String delivery) {
        Assert.assertTrue(setDelivery.isSelected());
        System.out.println("Weryfikacja sposobu dostawy \"" + delivery + "\": poprawna");
        confirmDeliveryBtn.click();
    }
}
