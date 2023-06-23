package StepDefinitions;

import PageObjects.ContactDetailsPage;
import PageObjects.ContactListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.awt.*;

public class ContactListStepDef {
    ContactListPage contactListPage = new ContactListPage();
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage();

    @Then("User lands on Contact List Page")
    public void user_lands_on_Contact_List_Page() {
        Assert.assertTrue(contactListPage.contactListHeader());
    }

    @And("User clicks on Logout")
    public void user_clicks_on_Logout() {
        contactListPage.clickOnLogout();
    }

    @When("User clicks On Add Contact")
    public void click_On_AddContact() {
        contactListPage.clickOnAddContact();
    }

    @When("User clicks on contact")
    public void user_clicks_on_contact() {
        Assert.assertTrue(contactListPage.contactsArePresent());
        contactListPage.clickOnContact();
    }

    @And("User clicks on Delete")
    public void user_clicks_on_Delete() throws InterruptedException, AWTException {
        contactDetailsPage.clickOnDelete();
        contactDetailsPage.acceptDeleteThisContactPopup();
    }

    @And("User captures contacts")
    public void user_captures_contacts() {
    contactListPage.captureContacts();
    }
}
