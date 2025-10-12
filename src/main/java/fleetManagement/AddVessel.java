package fleetManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class AddVessel {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://muntasir101.github.io/marineXpress/");

        WebElement FleetManagementMenu = driver.findElement(By.cssSelector("div[data-section='fleet'] span"));
        FleetManagementMenu.click();

        WebElement AddVesselButton = driver.findElement(By.cssSelector("#add-vessel-btn"));
        AddVesselButton.click();

        WebElement VesselName = driver.findElement(By.cssSelector("#vessel-name"));
        VesselName.sendKeys("Sea Super");

        WebElement VesselType = driver.findElement(By.cssSelector("#vessel-type"));
        Select select = new Select(VesselType);
        select.selectByValue("Tanker");

        WebElement YearBuild = driver.findElement(By.cssSelector("#year-built"));
        YearBuild.sendKeys("2020");

        WebElement Capacity = driver.findElement(By.cssSelector("#capacity"));
        Capacity.sendKeys("20000");


    }
}
