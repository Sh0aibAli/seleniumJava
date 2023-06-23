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
    public static By contacts = By.xpath("//table/thead/tr/th[contains(text(),'Name')]/following::tr/td[2]");

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
    public boolean contactsArePresent()
    {
        hardwait(2);
        return element(contacts).isDisplayed();
    }
    public void clickOnContact()
    {
        element(contacts).click();
    }
    public void captureContacts()
    {
//        int ar[] = new int[0];
//        for (int element : ar)
//
//            System.out.print(element + " ");
        /*

        Need to implement for each loo here in the above code

        */
    }
}
