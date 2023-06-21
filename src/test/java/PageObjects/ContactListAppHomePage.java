package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

import java.util.Base64;

public class ContactListAppHomePage extends BaseFunctions {
    public ContactListAppHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    static String decodedString(String str) {
        byte[] decouser = Base64.getDecoder().decode(str);
        return (new String(decouser));
    }

    //Locators
    public static By contactListAppHeader_XPATH = By.xpath("//h1[text()='Contact List App']");
    public static By emailInput = By.xpath("//input[@id='email']");
    public static By passInput = By.xpath("//input[@id='password']");
    public static By submitBtn = By.xpath("//button[@id='submit']");
    public static By alertMessage = By.xpath("//span[@id='error']");
    public static By signUpBtn = By.xpath("//button[@id='signup']");

    //Action Methods
    public boolean contactListHeader() {
        return element(contactListAppHeader_XPATH).isDisplayed();
    }

    public void clickOnSignUp() {
        element(signUpBtn).click();
    }

    public void enterEmailAddress(String username) {
        element(emailInput).sendKeys(decodedString(username));
    }

    public void enterPassword(String pass) {
        element(passInput).sendKeys(pass);
    }

    public void clickOnSubmit() {
        element(submitBtn).click();
    }

    public boolean alertMessage() {
        return element(alertMessage).isDisplayed();
    }
}
