package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class cartPage {
    private WebDriver driver;
    private By itemName = By.className("inventory_item_name");
    private By removetshirtButton = By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']");
    private By continueShopping = By.xpath("//button[@data-test='continue-shopping']");

    public cartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getItemNames() {
        List<WebElement> list = driver.findElements(itemName);
        List<String> allNames = new ArrayList<>();
        for (WebElement element : list) {
            allNames.add(element.getText());
        }
        return allNames;
    }

    public int isCartEmpty() {
        List<WebElement> list = driver.findElements(itemName);
        return list.size();
    }

    public void removeTshirt() {
        driver.findElement(removetshirtButton).click();
    }
    public inventoryPage goBackToInventoryPage(){
        driver.findElement(continueShopping).click();
        return new inventoryPage(driver);
    }
}
