package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.BaseClass;

public class DragDrop extends BaseClass {

    public DragDrop(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    WebElement inputUsername;

    @FindBy(xpath = "//div[@id='draggable1']")
    @CacheLookup
    WebElement dragableOne;

    @FindBy(xpath = "//div[@id='droppable1']")
    @CacheLookup
    WebElement dropZone;


    public WebElement getDraggableItem() {
        return dragableOne;
    }

    public WebElement getDropZone() {
        return dropZone;
    }
}