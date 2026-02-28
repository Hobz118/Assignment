package Tests;


import Base.BaseTests;
import Utils.DataDriven;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTests extends BaseTests {

    @Test
    public void isCartEmptyTest() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        var cartPage = inventoryPage.clickCartLogo();
        assertEquals(cartPage.isCartEmpty(), 0, "Cart isn't empty");
    }

    @Test
    public void cartItemsTest() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        inventoryPage.addToCart();
        var cartPage = inventoryPage.clickCartLogo();
        assertTrue(cartPage.getItemNames().contains("Sauce Labs Backpack"), "Backpack not found");
        assertTrue(cartPage.getItemNames().contains("Sauce Labs Bolt T-Shirt"), "There is no Bolt t-shirt");
        assertTrue(cartPage.getItemNames().contains("Sauce Labs Onesie"), "Onesie not found");
    }
    @Test
    public void removeItemFromTheCart(){
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        inventoryPage.addToCart();
        var cartPage = inventoryPage.clickCartLogo();
        cartPage.removeTshirt();
        var inventoryPage2 = cartPage.goBackToInventoryPage();
        assertFalse(inventoryPage2.isProductInCart("sauce-labs-bolt-t-shirt"),
                "Backpack not found");
        assertTrue(inventoryPage2.isProductInCart("sauce-labs-backpack"),
                "Backpack not found");
        assertTrue(inventoryPage2.isProductInCart("sauce-labs-onesie"),
                "Onesie not found");
    }
}
