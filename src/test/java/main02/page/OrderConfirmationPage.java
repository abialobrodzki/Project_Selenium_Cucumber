package main02.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private WebDriver driver;
    public static String expectPrice;
    public static String expectOrderNumber;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void TakeScreenShot() throws IOException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File("screenshot.png"));
    }

    /**
     * pobranie ceny i numeru aktualnego zamówienia
     */
    public void orderInfoFirst() {
        expectPrice = driver.findElement(By.xpath("//*[@id=\"order-items\"]//tr[3]/td[2]")).getText().substring(1);
        expectOrderNumber = driver.findElement(By.xpath("//*[@id=\"order-details\"]//li[1]")).getText().substring(17);
    }
}
