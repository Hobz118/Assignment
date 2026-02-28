package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.className("error-message-container");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public inventoryPage login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new inventoryPage(driver);
    }

//    public void setPassword(String password) {
//        driver.findElement(passwordField).sendKeys(password);
//    }
//
//    public InventoryPage clickLoginButton() {
//        driver.findElement(loginButton).click();
//        return new InventoryPage(driver);
//    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }
}
