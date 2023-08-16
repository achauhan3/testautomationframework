package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.BaseClass;

public class FileUpload extends BaseClass {

    public FileUpload(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='fileinput']")
    @CacheLookup
    WebElement selectFile;

    public void uploadFile() {
        selectFile.sendKeys("C:\\Users\\Abhishek\\Documents\\sample.txt");
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