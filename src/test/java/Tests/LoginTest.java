package Tests;

import Base.BaseTests;
import Utils.DataDriven;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LoginTest extends BaseTests {
    @Test
    public void validLoginTest() {
        String username = DataDriven.getUsername("validUser");
        String password = DataDriven.getPassword("validUser");
//        loginPage.login(username, password);
        var inventoryPage = loginPage.login(username, password);
//        System.out.println(inventoryPage.getPageURL());
        assertEquals(inventoryPage.getPageTitle(), "Swag Labs",
                "Login Failed");
        assertTrue(inventoryPage.getPageURL().contains("/inventory.html"),
                "Login Failed");
    }

    @Test
    public void invalidLoginTest() {

        String username = DataDriven.getUsername("invalidUser");
        String password = DataDriven.getPassword("invalidUser");
        loginPage.login(username, password);
//        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
//                "Wrong Error");
        assertTrue(loginPage.getErrorMessage().contains("Username and password"),
                "Login Failed");
    }

    @Test
    public void loginWithoutPasswordTest(){
        String username = DataDriven.getUsername("noPassword");
        String password = DataDriven.getPassword("noPassword");
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Login Failed");
    }
}
