package Tests;

import Base.BaseTests;
import Utils.DataDriven;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InventoryTest extends BaseTests {

    @Test
    public void inventoryTest() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        assertEquals(inventoryPage.noOfItems(), 6,
                "Number of Items is not 6" + inventoryPage.noOfItems());
        assertTrue(inventoryPage.cartIsDisplayed(), "Cart is not displayed");
        assertEquals(inventoryPage.getPageTitle(), "Swag Labs",
                "Wrong title");

    }

    @Test
    public void testFacebookLogo() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        inventoryPage.clickLogo("Facebook");
        getWindowManager().switchWindow("Sauce Labs");
        System.out.println("URL: " + inventoryPage.getPageURL());
        assertTrue(inventoryPage.getPageURL().contains("facebook"), "wrong url");
    }
    @Test
    public void testLinkedInLogo() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        inventoryPage.clickLogo("LinkedIn");
        getWindowManager().switchWindow("Sauce Labs");
        System.out.println("URL: " + inventoryPage.getPageURL());
        assertTrue(inventoryPage.getPageURL().contains("linkedin"), "wrong url");
    }
    @Test
    public void testXLogo() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
        var inventoryPage = loginPage.login(username, password);
        inventoryPage.clickLogo("Twitter");
        getWindowManager().switchWindow("Sauce Labs");
        System.out.println("URL: " + inventoryPage.getPageURL());
        assertTrue(inventoryPage.getPageURL().contains("x"), "wrong url");
    }

}
