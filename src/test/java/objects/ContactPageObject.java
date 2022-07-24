package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageObject {
    @FindBy(xpath = "//button[@data-zcqa='cv_createbtn']")
    public WebElement create_account;
    @FindBy(xpath = "//*[@id=\"Crm_Contacts_SMOWNERID\"]/lyte-dropdown/div[1]/lyte-drop-button/span")
    public WebElement contact_owner;
    @FindBy(css = "#Crm_Contacts_FIRSTNAME_LInput")
    public WebElement first_name;
}
