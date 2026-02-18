package Base;

import Pages.InventoryPage;
import Pages.LoginPage;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);

            try {
                //            Files.move(screenShot, new File("D:\\Ahmed Ehab\\TestingCourse\\AutomationAssignment\\src\\main\\resources\\ScreenShots\\test.png"));
                Files.move(screenShot, new File("src/main/resources/ScreenShots/" + testResult.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
