package StepDefinitions;

import PageObjects.ContactListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactListStepDef {
    ContactListPage contactListPage = new ContactListPage();

    @Then("User lands on Contact List Page")
    public void user_lands_on_Contact_List_Page() {
        Assert.assertTrue(contactListPage.contactListHeader());
    }
    @And("User clicks on Logout")
    public void user_clicks_on_Logout()
    {
        contactListPage.clickOnLogout();
    }
    @When("User clicks On Add Contact")
    public void click_On_AddContact()
    {
        contactListPage.clickOnAddContact();
    }
}
