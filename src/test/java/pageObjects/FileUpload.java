package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefs.BaseClass;

import static utils.Helper.getDriver;

public class FileUpload extends BaseClass {

    public FileUpload(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='fileinput']")
    WebElement selectFile;

    public void uploadFile() {
        selectFile.sendKeys("C:\\Users\\Abhishek\\Documents\\sample.txt");
    }

    public void clickBrowseButton() {
        if (selectFile.isDisplayed()) {
            JavascriptExecutor executor = (JavascriptExecutor)getDriver();
            executor.executeScript("arguments[0].click();", selectFile);
        } else {
            System.out.println("Element not found");
            Assert.fail("Element not found");
        }
    }

    @FindBy(xpath = "//input[@id='itsafile']")
    WebElement selectOption;

    public void selectOption() {
        selectOption.click();
    }

    @FindBy(xpath = "//input[@name='upload']")
    WebElement confirmButton;

    public void clickButton() {
        confirmButton.click();
    }


}