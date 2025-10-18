package fleetManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Initialize WebDriver
    public static void initDriver(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void navigateURL(String URL){
        driver.get(URL);
    }
    // Get driver instance
    public static WebDriver getDriver(){
        if(driver == null){
            throw new IllegalStateException("WebDriver not Initialized.Call initDriver() first");
        }
        return driver;
    }
    // Get wait instance
    public static WebDriverWait getWait(){
        if(wait == null){
            throw new IllegalStateException("WebDriverWait not initialized.Call initDriver() first.");
        }
        return wait;
    }
    // Quit driver
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
            wait = null;
        }
    }

}
