package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private WebDriver driver;


    public WindowManager(WebDriver driver) {
        this.driver = driver;

    }
    public void switchWindow(String tabTitle) {
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("No. of Windows: " + windowHandles.size());
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(tabTitle)) {
                break;
            }
        }

    }

}
