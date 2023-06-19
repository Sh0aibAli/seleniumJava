package StepDefinitions;

import PageObjects.AddContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import junit.framework.Assert;

public class AddContactStepDef {
    AddContactPage addContactPage = new AddContactPage();

    @Then("User lands on Add Contact Page")
    public void user_lands_on_add_Contact_Header() {
        Assert.assertTrue(addContactPage.addContactHeader());
    }

    @And("User enter contact Details")
    public void user_enter_contact_Details() {
        addContactPage.enterFirstName("Akash");
        addContactPage.enterLastName("Kumar");
        addContactPage.enterDOB("2000-01-01");
        addContactPage.enterEmailAddress("abcd@1234");
        addContactPage.enterPhone("1234567890");
    }

    @And("^User enter ([^\"]*) and ([^\"]*)$")
    public void user_enters_first_name_and_last_name(String firstName, String lastName) {
        System.out.println("Step def parameters:"+firstName+" ****************"+lastName);
        addContactPage.enterFirstName(firstName);
        addContactPage.enterLastName(lastName);
    }

    @And("^User enters incorrect ([^\"]*) and ([^\"]*)$")
    public void user_enters_incorrect_email_and_phone(String email, String phone) {
        addContactPage.enterEmailAddress(email);
        addContactPage.enterPhone(phone);
    }

    @Then("User verifies Contact validation is failed for email and phone")
    public void user_verifies_Contact_validation_is_failed_for_email_and_phone() {
        Assert.assertTrue(addContactPage.contactValidationMessage());
        Assert.assertTrue(addContactPage.emailValidationMessage());
        Assert.assertTrue(addContactPage.phoneValidationMessage());
    }

    @And("User clicks on Cancel")
    public void user_clicks_on_Cancel() {
        addContactPage.clickOncancelButton();
    }

}
