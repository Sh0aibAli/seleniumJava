package StepDefinitions;

import PageObjects.ContactListAppHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.PropFileHandler;

public class LoginStepDef {
    ContactListAppHomePage contactListAppHomePage = new ContactListAppHomePage();

    @Given("Launch Application")
    public void launch_Application() {
        contactListAppHomePage.launchApplication(PropFileHandler.readProperty("appUrl"));
    }

    @When("User lands on the LoginPage")
    public void user_lands_on_the_LoginPage() {
        Assert.assertTrue(contactListAppHomePage.contactListHeader());
    }

    @When("User enters email address")
    public void user_enters_email_address() {
        contactListAppHomePage.enterEmailAddress(PropFileHandler.readProperty("username"));
    }

    @And("User enters password")
    public void user_enters_password() {
        contactListAppHomePage.enterPassword(PropFileHandler.readProperty("password"));
    }

    @When("User enters incorrect email address")
    public void user_enters_Incorrect_email_address() {
        contactListAppHomePage.enterEmailAddress(PropFileHandler.readProperty("password"));
    }

    @And("User enters incorrect password")
    public void user_enters_Incorrect_password() {
        contactListAppHomePage.enterPassword("1234567890");
    }

    @And("User clicks on Submit")
    public void user_clicks_on_Submit() {
        contactListAppHomePage.clickOnSubmit();
    }

    @Then("alert message is displayed")
    public void alert_message_is_displayed() {
        Assert.assertTrue(contactListAppHomePage.alertMessage());
    }
}
