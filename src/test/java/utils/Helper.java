package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {
    private static Helper Helper;
    private static WebDriver driver;
    public final static int TIMEOUT = 2;

    private Helper() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void NavBack() {
        driver.navigate().back();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (Helper == null) {
            Helper = new Helper();
        }
    }

    public static void driverWaitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            takeScreenshot();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void tearDown() {
        if (driver != null) {
            //driver.close();
            driver.quit();
        }
        Helper = null;
    }

    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void enterAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public static void dragDrop(WebElement draggableItem, WebElement dropZone) {
        Actions action = new Actions(driver);
        action.dragAndDrop(draggableItem, dropZone).build().perform();
        driverWaitSeconds(5);
    }

    public static void takeScreenshot() {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File ss1 = scrShot.getScreenshotAs(OutputType.FILE);
        String fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\";
        try {
            FileUtils.copyFile(ss1, new File(fileLocation + "screenshot_" + randomNumber() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String randomNumber() {
        return String.valueOf(System.currentTimeMillis());
    }
}