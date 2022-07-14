package main02.page;

import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void TakeScreenShot() throws IOException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File("screenshot.png"));
    }
}
