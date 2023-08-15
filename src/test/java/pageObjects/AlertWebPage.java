package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.w3c.dom.html.HTMLInputElement;
import stepDefs.BaseClass;

public class AlertWebPage extends BaseClass {

    public AlertWebPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    WebElement inputUsername;

    @FindBy(xpath = "//input[@id='alertexamples']")
    WebElement simpleAlertBox;

    public void ClickSimpleAlertBox() {
        simpleAlertBox.click();
    }

    @FindBy(xpath = "//input[@id='promptexample']")
    WebElement promptAlertBox;

    public void ClickPromptAlertBox() {
        promptAlertBox.click();
    }
}