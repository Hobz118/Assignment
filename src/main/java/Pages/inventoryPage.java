package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class inventoryPage {
    private WebDriver driver;
    private By pageTitle = By.className("app_logo");
    private By cartLogo = By.className("shopping_cart_link");
    private By items = By.className("inventory_item");
    private By backpackButton = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    private By shirtButton = By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']");
    private By oneiseButton = By.xpath("//button[@name='add-to-cart-sauce-labs-onesie']");

    public inventoryPage(WebDriver driver) {
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

    public void clickLogo(String x) {
        driver.findElement(By.linkText(x)).click();
    }

    public int noOfItems() {
        List<WebElement> list = driver.findElements(items);
        return list.size();
    }

    public cartPage clickCartLogo() {
        driver.findElement(cartLogo).click();
        return new cartPage(driver);
    }

    public void addToCart() {
        driver.findElement(backpackButton).click();
        driver.findElement(oneiseButton).click();
        driver.findElement(shirtButton).click();
    }

    public boolean isProductInCart(String productName) {
        By removeButton = By.id("remove-" + productName);
        return !driver.findElements(removeButton).isEmpty();
    }

}
