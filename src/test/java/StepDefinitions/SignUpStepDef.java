package StepDefinitions;

import PageObjects.AddUserPage;
import PageObjects.ContactListAppHomePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SignUpStepDef {
    AddUserPage addUserPage = new AddUserPage();
    ContactListAppHomePage contactListAppHomePage = new ContactListAppHomePage();

    @Then("User lands on Add User Page")
    public void user_lands_on_Add_User_Page() {
        Assert.assertTrue(addUserPage.addUserHeader());
    }

    @Then("{string} alert is displayed")
    public void email_address_is_already_in_use_alert_is_displayed(String alert) {
        Assert.assertTrue(contactListAppHomePage.alertMessage());
        Assert.assertTrue(addUserPage.emailAddressIsAlreadyInUseHeader());
    }
}
