package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class AddUserPage extends BaseFunctions {
    public AddUserPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    //Locators
    public static By addUserHeader = By.xpath("//div/h1[contains(text(),'Add User')]");
    public static By emailAlertHeader = By.xpath("//span[@id='error'][contains(text(),'Email address is already in use')]");

    //Action Methods
    public boolean addUserHeader() {
        return element(addUserHeader).isDisplayed();
    }
    public boolean emailAddressIsAlreadyInUseHeader()
    {
        return element(emailAlertHeader).isDisplayed();
    }
}
