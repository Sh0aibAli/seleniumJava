package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class AddContactPage extends BaseFunctions {
    public AddContactPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    //Locators
    public static By addContactHeader = By.xpath("//h1[contains(text(),'Add Contact')]");
    public static By firstNameField = By.xpath("//input[@id='firstName']");
    public static By lastNameField = By.xpath("//input[@id='lastName']");
    public static By dobField = By.xpath("//input[@id='birthdate']");
    public static By emailField = By.xpath("//input[@id='email']");
    public static By phoneField = By.xpath("//input[@id='phone']");
    public static By contactValidationAlert = By.xpath("//span[@id='error'][contains(text(),'Contact validation failed:')]");
    public static By emailValidationAlert = By.xpath("//span[@id='error'][contains(text(),'email: Email is invalid')]");
    public static By phoneValidationAlert = By.xpath("//span[@id='error'][contains(text(),'phone: Phone number is invalid')]");
    public static By firstNameValidationAlert = By.xpath("//span[@id='error'][contains(text(),'firstName: Path `firstName` is required.')]");
    public static By lastNameValidationAlert = By.xpath("//span[@id='error'][contains(text(),'lastName: Path `lastName` is required.')]");
    public static By cancelButton = By.xpath("//button[@id='cancel']");
    public static By clickOnExistingContact = By.xpath("//table[@id='myTable']/tr/td[2]");
    public static By editContactButton = By.xpath("//button[@id='edit-contact']");
    public static By cityField = By.xpath("//input[@id='city']");
    public static By countryField = By.xpath("//input[@id='country']");

    //Action Methods
    public boolean addContactHeader() {
        return element(addContactHeader).isDisplayed();
    }

    public void enterFirstName(String fname) {
        element(firstNameField).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        element(lastNameField).sendKeys(lname);
    }

    public void enterDOB(String dob) {
        element(dobField).sendKeys(dob);
    }

    public void enterEmailAddress(String email) {
        element(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        element(phoneField).sendKeys(phone);
    }

    public boolean contactValidationMessage() {
        return element(contactValidationAlert).isDisplayed();
    }

    public boolean emailValidationMessage() {
        return element(emailValidationAlert).isDisplayed();
    }

    public boolean phoneValidationMessage() {
        return element(phoneValidationAlert).isDisplayed();
    }

    public void clickOncancelButton() {
        element(cancelButton).click();
    }

    public void clickOnExistingContactTable()
    {
        hardwait(3);
        element(clickOnExistingContact).click();
    }

    public void clickOnEditContactButton()
    {
        element(editContactButton).click();
    }

    public void enterCity(String city)
    {
        element(cityField).clear();
        element(cityField).sendKeys(city);
    }

    public void enterCountry(String country)
    {
        element(countryField).clear();
        element(countryField).sendKeys(country);
    }
}
