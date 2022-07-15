package main02.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static main02.page.OrderConfirmationPage.expectOrderNumber;
import static main02.page.OrderConfirmationPage.expectPrice;

public class MyOrdersHistory {
    private WebDriver driver;

    public MyOrdersHistory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]//span")
    private WebElement userBtn;

    public void clickUserBtn() {
        userBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"history-link\"]/span")
    private WebElement ordersHistoryBtn;

    public void clickOrdersHistoryBtn() {
        ordersHistoryBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"content\"]//tr[1]/td[4]/span")
    private WebElement orderStatus;
    @FindBy(xpath = "//*[@id=\"content\"]//tbody/tr[1]/th")
    private WebElement orderNumber;

    public void checkOrderStatus(String expectStatus) {
        String actualStatus = orderStatus.getText();
        String number = orderNumber.getText();
        Assert.assertEquals(expectStatus, actualStatus);
        System.out.println("Weryfikacja statusu \"" + expectStatus + "\" dla zamówienia \"" + number + "\": poprawna");
    }

    @FindBy(xpath = "//*[@id=\"content\"]//tr[1]/td[2]")
    private WebElement orderPrice;

    public void checkOrderPrice() {
        String actualPrice = orderPrice.getText().substring(1);
        String actualOrderNumber = orderNumber.getText();
        Assert.assertEquals(expectPrice, actualPrice);
        Assert.assertEquals(expectOrderNumber, actualOrderNumber);
        System.out.println("Weryfikacja ceny \"" + actualPrice + "\" dla zamówienia \"" + actualOrderNumber + "\": poprawna");
    }
}
