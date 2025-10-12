package CargoOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CargoBooking {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://takhangithub.github.io/MavenXpress/");
        driver.manage().window().maximize();

        // Apply Implicit wait: Wait for Dom to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement CargoOperation = driver.findElement(By.cssSelector("div[data-section='cargo'] span"));
        CargoOperation.click();

        //Booking
        WebElement cargoBooking = driver.findElement(By.cssSelector("div[data-tab='booking']"));
        cargoBooking.click();

        WebElement cargoType = driver.findElement(By.cssSelector("#cargo-type"));
        Select selectCarTyp = new Select(cargoType);
        selectCarTyp.selectByValue("Bulk");

        WebElement Weight = driver.findElement(By.cssSelector("#weight"));
        Weight.sendKeys("5200");

        WebElement Origin = driver.findElement(By.cssSelector("#origin"));
        Origin.sendKeys("USA");

        WebElement Destination = driver.findElement(By.cssSelector("#destination"));
        Destination.sendKeys("Chittagong");

        WebElement bookCargBtn = driver.findElement(By.cssSelector("#book-cargo-btn"));
        bookCargBtn.click();

        //Allocation
        WebElement Allocation = driver.findElement(By.cssSelector("div[data-tab='allocation']"));
        Allocation.click();

        WebElement SelectCargoList = driver.findElement(By.cssSelector("#cargo-select"));
        Select selectCargo = new Select(SelectCargoList);
        selectCargo.selectByIndex(1);

        WebElement selctVsl = driver.findElement(By.cssSelector(" #vessel-select"));
        Select selCargVsl = new Select(selctVsl);
        selCargVsl.selectByIndex(1);

        try {
            // Pauses the code execution for 5000 milliseconds (5 seconds)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Handle the interruption exception if the thread is interrupted
            Thread.currentThread().interrupt();
        }

        WebElement LoadingDate = driver.findElement(By.cssSelector("#loading-date"));
        LoadingDate.sendKeys("05/12/2025");

        WebElement ExpArrival = driver.findElement(By.cssSelector("#estimated-arrival"));
        ExpArrival.sendKeys("06/16/2025");

        WebElement AllocateButton = driver.findElement(By.cssSelector("#allocate-cargo-btn"));
        AllocateButton.click();



    }
}