/*
1. Explicit wait
2. Separate Locators
 */

package fleetManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class AddVessel {

    // Page Object Locators
    private static final By Fleet_Management_Menu = By.cssSelector("div[data-section='fleet'] span");
    private static final By Add_Vessel_Button = By.cssSelector("#add-vessel-btn");
    private static final By Vessel_Name = By.cssSelector("#vessel-name");
    private static final By Vessel_Type = By.cssSelector("#vessel-type");
    private static final By Year_Build = By.cssSelector("#year-built");
    private static final By Vessel_Capacity = By.cssSelector("#capacity");

    // Vessel data constants
    private static final String data_Vessel_Name = "Sea Monster";
    private static final String data_Vessel_Type = "Tanker";
    private static final String data_Vessel_Year = "2020";
    private static final String data_Vessel_Capacity = "50000";

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://muntasir101.github.io/marineXpress/");

        // Setup Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement FleetManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(Fleet_Management_Menu));
        FleetManagementMenu.click();

        WebElement AddVesselButton = driver.findElement(Add_Vessel_Button);
        AddVesselButton.click();

        WebElement VesselName = wait.until(ExpectedConditions.visibilityOfElementLocated(Vessel_Name));
        VesselName.sendKeys(data_Vessel_Name);

        WebElement VesselType = driver.findElement(Vessel_Type);
        Select select = new Select(VesselType);
        select.selectByValue(data_Vessel_Type);

        WebElement YearBuild = driver.findElement(Year_Build);
        YearBuild.sendKeys(data_Vessel_Year);

        WebElement Capacity = driver.findElement(Vessel_Capacity);
        Capacity.sendKeys(data_Vessel_Capacity);

        driver.quit();

    }
}
