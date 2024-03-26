package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    public SelenideElement buttonsButton = $ ( "div[class='element-list collapse show'] li[class='btn btn-light ']:nth-child(5)" );
    public SelenideElement clickMeButton = $ ("div[class='col-12 mt-4 col-md-6'] div:nth-child(4) button");
    public SelenideElement getTextDynamicMessage = $("p[id='dynamicClickMessage']");
    public SelenideElement addButton = $("button#addNewRecordButton");
    public SelenideElement firstNameText = $("input#firstName");
    public SelenideElement surNameText = $("input#lastName");
    public SelenideElement emailText = $("input#userEmail");
    public SelenideElement ageText = $("input#age");
    public SelenideElement salaryText = $("input#salary");
    public SelenideElement departmentText = $("input#department");
    public SelenideElement saveButton = $("button#submit");
    public SelenideElement editButton = $("span#edit-record-3 >svg");
    public SelenideElement editedName=$("#app > div > div > div > div.col-12.mt-4.col-md-6 > div.web-tables-wrapper > div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody > div:nth-child(3) > div > div:nth-child(1)");



    public HomePage(String pageUrl) {
        super(pageUrl);
    }



    public void editUser(String name, String surname, String email, String age, String salary, String department) {
        firstNameText.setValue(name);
        surNameText.setValue(surname);
        emailText.setValue(email);
        ageText.setValue(age);
        salaryText.setValue(salary);
        departmentText.setValue(department);
    }


}
