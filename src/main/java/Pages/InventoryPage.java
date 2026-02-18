package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By pageTitle = By.className("app_logo");
    private By cartLogo = By.className("shopping_cart_link");
    private By items = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public boolean cartIsDisplayed() {
        return driver.findElement(cartLogo).isDisplayed();
    }

    public int noOfItems() {
        List<WebElement> list = driver.findElements(items);
        return list.size();

    }
}
