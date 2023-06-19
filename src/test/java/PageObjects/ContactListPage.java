package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class ContactListPage extends BaseFunctions {
    public ContactListPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    //Locators
    public static By contactListPageHeader = By.xpath("//h1[contains(text(),'Contact List')]");
    public static By logoutButton = By.xpath("//button[@id='logout']");
    public static By addContactButton = By.xpath("//button[@id='add-contact']");

    //Action Methods
    public boolean contactListHeader() {
        return element(contactListPageHeader).isDisplayed();
    }

    public void clickOnLogout() {
        element(logoutButton).click();
    }

    public void clickOnAddContact() {
        element(addContactButton).click();
    }
}
