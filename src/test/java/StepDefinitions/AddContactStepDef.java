package StepDefinitions;

import PageObjects.AddContactPage;
import PageObjects.ContactDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import junit.framework.Assert;

public class AddContactStepDef {
    AddContactPage addContactPage = new AddContactPage();
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage();

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

    @And("^User enters ([^\"]*) in the firstname field$")
    public void user_enters_first_name_in_the_firstname_field(String firstName) {
        addContactPage.enterFirstName(firstName);
    }

    @And("^User enters ([^\"]*) in the lastname field$")
    public void user_enters_last_name_in_the_lastname_field(String lastName) {
        addContactPage.enterLastName(lastName);
    }

    @And("^User enters ([^\"]*) in the email field$")
    public void user_enters_email_in_the_email_field(String email) {
        addContactPage.enterEmailAddress(email);
    }

    @And("^User enters ([^\"]*) in the phone number field$")
    public void user_enters_phoneNo_in_the_phone_number_field(String phone) {
        addContactPage.enterPhone(phone);
    }

    @And("User clicks on the existing contact need to be edited")
    public void user_clicks_on_the_existing_contact_need_to_be_edited() {
        addContactPage.clickOnExistingContactTable();
    }

    @Then("User lands on Contact Details Page")
    public void user_lands_on_Contact_Details_Page() {
        Assert.assertTrue(contactDetailsPage.contactDetailHeader());
    }

    @And("User clicks on the edit contact")
    public void user_clicks_on_the_edit_contact() {
        addContactPage.clickOnEditContactButton();
    }

    @And("^User enters ([^\"]*) in the city field$")
    public void user_enters_city_in_the_city_field(String city) {
        addContactPage.enterCity(city);
    }

    @And("^User enters ([^\"]*) in the country field$")
    public void user_enters_country_in_the_country_field(String country) {
        addContactPage.enterCountry(country);
    }

    @And("User captures email address")
    public void user_captures_email_address() {
        System.setProperty("emailAdd", contactDetailsPage.captureEmailAddress());
    }
}
