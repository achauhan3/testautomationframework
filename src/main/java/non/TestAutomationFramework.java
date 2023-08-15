package non;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestAutomationFramework {

    public static void main(String[] args) {

        System.out.println("Test Automation Framework using Selenium");
        // Set system property for chrome driver using relative path to the project
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\driver\\chromedriver.exe");
        // Set system property for firefox driver using relative path to the project
        System.setProperty("webdriver.gecko.driver",
                "src\\main\\resources\\driver\\geckodriver.exe");
        // Create a new instance of the Firefox driver  and Chrome driver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");
        String value = driver.findElement(By.xpath("//*[@id=\"stable\"]/div/table/tbody/tr[1]/th[1]/code")).getText();
        System.out.println(value);
        // add a testng test below
        Assert.assertEquals(value, "chrome");
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website test site");
        // Close the driver
        driver.quit();
    }
}