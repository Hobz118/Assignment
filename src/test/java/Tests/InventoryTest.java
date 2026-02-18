package Tests;

import Base.BaseTests;
import Pages.LoginPage;
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

//    @Test
//    public void noOfItemsTest() {
//        String username = DataDriven.getUsername("validUser");
//        String password = DataDriven.getPassword("validUser");
//        var inventoryPage = loginPage.login(username, password);
//        assertEquals(inventoryPage.noOfItems(), 6,
//                "Number of Items is not 6" + inventoryPage.noOfItems());
//    }
//
//    @Test
//    public void logoAppearanceTest() {
//        String username = DataDriven.getUsername("validUser");
//        String password = DataDriven.getPassword("validUser");
//        var inventoryPage = loginPage.login(username, password);
//        assertTrue(inventoryPage.cartIsDisplayed(), "Cart is not displayed");
//    }
//
//    @Test
//    public void titleTest() {
//        String username = DataDriven.getUsername("validUser");
//        String password = DataDriven.getPassword("validUser");
//        var inventoryPage = loginPage.login(username, password);
//        assertEquals(inventoryPage.getPageTitle(), "Swag Labs",
//                "Wrong title");
//    }
}
