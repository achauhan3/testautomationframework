package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;
import pageObjects.BasicWebPage;
import utils.Helper;

public class TestStepDef extends BaseClass {

    WebDriver driver = Helper.getDriver();
    BasicWebPage basicWebPage = new BasicWebPage(Helper.getDriver());
    LoginPage loginPage = new LoginPage(Helper.getDriver());

    AlertWebPage alertWebPage = new AlertWebPage(Helper.getDriver());

    DragDrop dragDrop = new DragDrop(Helper.getDriver());


    FileUpload fileUpload = new FileUpload(Helper.getDriver());

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        System.out.println("I am on the Index page");

        Helper.openPage("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
    }

    @When("^I click on the link(\\d+)$")
    public void i_click_on_the_link(int arg1) throws Exception {
        System.out.println("Click on the index link");
        // loginPage.ClickIndex();
    }

    @Then("^I should see the page(\\d+)$")
    public void i_should_see_the_page(int arg1) throws Exception {
        System.out.println("I am on the Home page");
        System.out.println("The home page - " + Helper.getTitle());

    }

    @When("I click on fetch the page values")
    public void iClickOnFetchThePageValues() {
        basicWebPage.setBasicWebPageText();
        basicWebPage.setBasicWebPageDivText();
    }

    @Then("I validate the values")
    public void iValidateTheValues() {
        Assert.assertTrue(basicWebPage.getBasicWebPageText().contains("Basic Web Page"));
        Assert.assertTrue(basicWebPage.getBasicWebPageDivText().contains("Very simple web pages"));
    }

    @Given("I am on the alert home page")
    public void iAmOnTheAlertHomePage() {
        Helper.openPage("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        //Helper.driverWaitSeconds(5);
    }

    @When("I click on simple alert box")
    public void iClickOnSimpleAlertBox() {
        alertWebPage.ClickSimpleAlertBox();
        Helper.driverWaitSeconds(5);
    }

    @Then("I dismiss the value")
    public void iDismissTheValue() {
        Helper.acceptAlert();
    }

    @When("I click on promt alert box")
    public void iClickOnPromtAlertBox() {
        alertWebPage.ClickPromptAlertBox();
    }

    @Then("I enter the value")
    public void iEnterTheValue() {
        Helper.enterAlertText("This is text message");
        Helper.driverWaitSeconds(5);
    }

    @Then("I accept the value")
    public void iAcceptTheValue() {
        Helper.acceptAlert();
    }

    @Given("I am on the drag home page")
    public void iAmOnTheDragHomePage() {
        Helper.openPage("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
        Helper.driverWaitSeconds(5);
    }

    @When("I click on draggable item")
    public void iClickOnDraggableItem() {
        Helper.dragDrop(dragDrop.getDraggableItem(), dragDrop.getDropZone());

    }

    @Given("I am on the upload page")
    public void iAmOnTheUploadPage() {
        Helper.openPage("https://testpages.herokuapp.com/styled/file-upload-test.html");
        Helper.driverWaitSeconds(5);
    }

    @When("I upload the file")
    public void iUploadTheFile() {
        fileUpload.uploadFile();
        Helper.driverWaitSeconds(5);
    }

    @Then("I press the submit button")
    public void iPressTheSubmitButton() {
        fileUpload.selectOption();
        Helper.driverWaitSeconds(5);
        fileUpload.clickButton();
        Helper.driverWaitSeconds(5);
    }
}

