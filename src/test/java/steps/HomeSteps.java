package steps;

import common.PageManager;
import common.ScenarioContext;
import driver.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import static com.codeborne.selenide.Condition.exactText;

public class HomeSteps  {

    PageManager pageManager = new PageManager();
    @Given("openPage")
    public void openpage () {
        pageManager.homePage.open();
        String URL = DriverFactory.currentDriver ( ).getCurrentUrl ( );
        Assert.assertEquals(URL, "https://demoqa.com/elements" );
    }

    @When("User click buttons button")
    public void userClickButtonsButton () {
        pageManager.homePage.buttonsButton.click ();
        String URL = DriverFactory.currentDriver ( ).getCurrentUrl ( );
        Assert.assertEquals(URL, "https://demoqa.com/buttons" );
    }

    @And("User clicks click me button")
    public void userClicksClickMeButton () {
        pageManager.homePage.clickMeButton.click ();
    }

    @Then("user checks dynamic message")
    public void userChecksDynamicMessage () {
        String actualElement= pageManager.homePage.getTextDynamicMessage.getText();
        Assert.assertEquals(actualElement, "You have done a dynamic click" );
    }

    @Given("user click add button")
    public void userClickAddButton () {
        pageManager.homePage.addButton.click ( );
    }

    @And("user enter data")
    public void userEnterData () {
        pageManager.homePage.firstNameText.sendKeys ( "Ali Isa" );
        pageManager.homePage.surNameText.sendKeys ( "Tas" );
        pageManager.homePage.emailText.sendKeys ( "blas@hotmail.com" );
        pageManager.homePage.ageText.sendKeys ( "31" );
        pageManager.homePage.salaryText.sendKeys ( "3500" );
        pageManager.homePage.departmentText.sendKeys ( "QA" );
    }

    @And("user click save button")
    public void userClickSaveButton () {
        pageManager.homePage.saveButton.click ( );

    }

    @Given("open WebTable Page")
    public void openWebTablePage () {
        pageManager.homePage.openWebTable();
        String URL = DriverFactory.currentDriver ( ).getCurrentUrl ( );
        Assert.assertEquals(URL, "https://demoqa.com/webtables" );
    }

    @Given("user click edit button")
    public void userClickEditButton () {
        pageManager.homePage.editButton.click ( );
    }

    @And("user enter data for {string} {string} {string} {string} {string} {string}")
    public void userEnterDataFor ( String name, String surname, String email, String age, String salary, String department ) {
        pageManager.homePage.editUser(name,surname,email,age,salary,department);

    }

    @Then("check edited area {string}")
    public void checkEditedArea ( String username ) {
        pageManager.homePage.editedName.shouldHave(exactText ( username));
    }

}
