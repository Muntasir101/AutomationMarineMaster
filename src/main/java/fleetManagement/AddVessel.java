/*
1. Explicit wait
2. Separate Locators
3. Implement data constants
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
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Page Object Locators
    private static final By Fleet_Management_Menu = By.cssSelector("div[data-section='fleet'] span");
    private static final By Add_Vessel_Button = By.cssSelector("#add-vessel-btn");
    private static final By Vessel_Name = By.cssSelector("#vessel-name");
    private static final By Vessel_Type = By.cssSelector("#vessel-type");
    private static final By Year_Build = By.cssSelector("#year-built");
    private static final By Vessel_Capacity = By.cssSelector("#capacity");
    private static final By Vessel_Flag = By.cssSelector("#flag");
    private static final By Vessel_CurrentLocation = By.cssSelector("#current-location");
    private static final By Vessel_register_Button = By.cssSelector("form[id='vessel-form'] button[type='submit']");
    private static final By Vessel_add_success_message =  By.cssSelector("#toast-message");

    // Vessel data constants
    private static final String data_Vessel_Name = "Sea Monster";
    private static final String data_Vessel_Type = "Tanker";
    private static final String data_Vessel_Year = "2020";
    private static final String data_Vessel_Flag = "USA";
    private static final String data_Current_Location = "USA";
    private static final String data_Vessel_Capacity = "50000";

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        driver.get("https://muntasir101.github.io/marineXpress/");
        System.out.println("Navigate to URL");
        // Setup Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        openFleetManagementMenu();
        clickAddVesselButton();
        fillVesselForm();
        submitVesselForm();
        verifyVesselAdded();

        driver.quit();
    }

    public static void openFleetManagementMenu(){
        WebElement FleetManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(Fleet_Management_Menu));
        FleetManagementMenu.click();
        System.out.println("Open Fleet Management Menu.");
    }
    public static void clickAddVesselButton(){
        WebElement AddVesselButton = driver.findElement(Add_Vessel_Button);
        AddVesselButton.click();
        System.out.println("Clicked Add Vessel Button.");
    }
    public static void fillVesselForm(){
        WebElement VesselName = wait.until(ExpectedConditions.visibilityOfElementLocated(Vessel_Name));
        VesselName.sendKeys(data_Vessel_Name);

        WebElement VesselType = driver.findElement(Vessel_Type);
        Select select = new Select(VesselType);
        select.selectByValue(data_Vessel_Type);

        WebElement YearBuild = driver.findElement(Year_Build);
        YearBuild.sendKeys(data_Vessel_Year);

        WebElement VesselFlag = driver.findElement(Vessel_Flag);
        VesselFlag.sendKeys(data_Vessel_Flag);

        WebElement VesselCurrentLocation = driver.findElement(Vessel_CurrentLocation);
        VesselCurrentLocation.sendKeys(data_Current_Location);

        WebElement Capacity = driver.findElement(Vessel_Capacity);
        Capacity.sendKeys(data_Vessel_Capacity);
        System.out.println("Inputted Vessel Form data.");
    }
    public static void submitVesselForm(){
        WebElement VesselRegisterButton = driver.findElement(Vessel_register_Button);
        VesselRegisterButton.click();
        System.out.println("Submitted Vessel Register Form.");
    }
    public static void verifyVesselAdded(){
        try{
            // String successMessage = driver.findElement(Vessel_add_success_message).getText();
            wait.until(ExpectedConditions.visibilityOfElementLocated(Vessel_add_success_message));
            System.out.println("Test Passed!! Vessel Added Successfully.");
        }
        catch (Exception e){
            System.out.println("Test Failed !!! Vessel did not add.");
        }

    }

}
