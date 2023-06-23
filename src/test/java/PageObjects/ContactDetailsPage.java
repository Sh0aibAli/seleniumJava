package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

import java.awt.*;

public class ContactDetailsPage extends BaseFunctions {
    public ContactDetailsPage()
    {
        super();
        PageFactory.initElements(driver, this);
    }

    //Locators
    public static By contactDetailsHeader_xpath = By.xpath("//h1[text()='Contact Details']");
    public static By emailAddress = By.xpath("//span[@id='email']");
    public static By delete = By.xpath("//button[@id='delete']");

    //Action Methods
    public boolean contactDetailHeader() {return element(contactDetailsHeader_xpath).isDisplayed();}
    public String captureEmailAddress()
    {
        return element(emailAddress).getText();
    }
    public void clickOnDelete()
    {
        element(delete).click();
    }
    public void acceptDeleteThisContactPopup() throws InterruptedException, AWTException {
        vk_TAB(12);
        vk_Enter(1);
    }
}
