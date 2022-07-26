package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageObject {
    @FindBy(xpath = "//button[@data-zcqa='cv_createbtn']")
    public WebElement create_account;
    @FindBy(xpath = "//*[@id=\"Crm_Contacts_SMOWNERID\"]/lyte-dropdown/div[1]/lyte-drop-button/span")
    public WebElement contact_owner;
    @FindBy(xpath = "//*[@id=\"Crm_Contacts_LEADSOURCE\"]/div[1]/lyte-drop-button/span")
    public WebElement pre_lead_source;
    @FindBy(xpath="//lyte-drop-body/lyte-drop-item[@data-value='Online Store']")
    public WebElement lead_source_OnlineStore;
    @FindBy(css = "#Crm_Contacts_FIRSTNAME_LInput")
    public WebElement first_name;
    @FindBy(css = "#Crm_Contacts_LASTNAME_LInput")
    public WebElement last_name;
    @FindBy(css = "#Crm_Contacts_ACCOUNTID")
    public WebElement account_name;
    @FindBy(css=  "#Crm_Contacts_TITLE_LInput")
    public WebElement title;
    @FindBy(css=  "#Crm_Contacts_EMAIL_LInput")
    public WebElement email;
    @FindBy(css=  "#Crm_Contacts_DEPARTMENT_LInput")
    public WebElement department;
    @FindBy(css=  "#Crm_Contacts_PHONE_LInput")
    public WebElement phone;
    @FindBy(css = "#Crm_Contacts_HOMEPHONE_LInput")
    public WebElement home_phone;
    @FindBy(css= "#Crm_Contacts_OTHERPHONE_LInput")
    public WebElement other_phone;
    @FindBy(css= "#Crm_Contacts_FAX_LInput")
    public WebElement fax;
    @FindBy(css= "#Crm_Contacts_MOBILE_LInput")
    public WebElement mobile;
    @FindBy(css = "#Crm_Contacts_BIRTHDAY_LInput")
    public WebElement pre_dob;
    @FindBy(xpath = "//*[@id=\"lyteCalendar\"]/lyte-calendar/div/div/div[1]/div/span[1]")
    public WebElement dob_back;
    @FindBy(xpath = "//*[@id=\"lyteCalendar\"]/lyte-calendar/div/div/div[1]/div/span[3]")
    public WebElement dob_forwatd;
    
    
}
