package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.BaseClass;

public class BasicWebPage extends BaseClass {

    private String ele_setBasicWebPageDivText;
    private String ele_setBasicWebPageText;

    public BasicWebPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    WebElement inputUsername;

    @FindBy(xpath = "//a[contains(text(),'Index')]")
    @CacheLookup
    WebElement index;

    public void ClickIndex() {
        index.click();
    }

    @FindBy(xpath = "//h1[contains(text(),'Basic Web Page Example')]")
    @CacheLookup
    WebElement basicWebPageText;

    public String getBasicWebPageText() {
        return ele_setBasicWebPageText;
    }

    public void setBasicWebPageText() {
        ele_setBasicWebPageText = basicWebPageText.getText();
    }

    @FindBy(xpath = "//*[contains(text(),'Very')]")
    @CacheLookup
    WebElement basicWebPageDivText;

    public String getBasicWebPageDivText() {
        return ele_setBasicWebPageDivText;
    }

    public void setBasicWebPageDivText() {
        ele_setBasicWebPageDivText = basicWebPageDivText.getText();
    }

}