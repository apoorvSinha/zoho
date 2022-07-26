package Pages;

import Base.TestBase;
import objects.ContactPageObject;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelReader;

public class ContactPage extends TestBase {
    ExcelReader data = new ExcelReader("./src/test/resources/testData/TestData.xlsx");
    ContactPageObject contact;
    public ContactPage() {
        this.contact = new ContactPageObject();
        PageFactory.initElements(driver, this.contact);
    }
    public void createAccountButton(){
        click(contactPage.contact.create_account);
    }
    public void enterContactInfo() {
    	int rowNum = data.getRowCount("Contacts");
    	String sheetName = "Contacts";
    	for(int row=2; row<=rowNum; row++) {
    		//enter contact info
        	String owner = data.getCellData(sheetName.trim(), "Contact Owner", row);
            Assert.assertEquals(owner.trim(), contact.contact_owner.getText());
            
            //enter first name
            String fname = data.getCellData(sheetName.trim(), "First Name", row);
            contact.first_name.sendKeys(fname);
            
            //enter last name
            String lname = data.getCellData(sheetName.trim(), "Last Name", row);
            contact.last_name.sendKeys(lname);
            
            //lead source
            contact.pre_lead_source.click();
            String lead_source = data.getCellData(sheetName.trim(), "Lead Source", row);
            if(lead_source.equalsIgnoreCase("Online Store")) {
            	actions.moveToElement(contact.lead_source_OnlineStore);
            	contact.lead_source_OnlineStore.click();
            }
            
            //account name
            String account_Name = data.getCellData(sheetName.trim(), "Account Name", row);
            contact.account_name.sendKeys(account_Name);
            
            //title
            String Title = data.getCellData(sheetName.trim(), "Title", row);
            contact.title.sendKeys(Title);
            
            //email
            String email_input = data.getCellData(sheetName.trim() , "Email", row);
            contact.email.sendKeys(email_input);
            
            //Department
            String department_input = data.getCellData(sheetName.trim(), "Department", rowNum);
            contact.department.sendKeys(department_input);
            
            //Phone
            String phone_input = data.getCellData(sheetName, "Phone", row);
            contact.phone.sendKeys(phone_input);
            
            //home phone
            String home_phone_input = data.getCellData(sheetName, "Home Phone", row);
            contact.home_phone.sendKeys(home_phone_input);
            
            //Other phone
            String otherPhone_input = data.getCellData(sheetName, "Other Phone", row);
            contact.other_phone.sendKeys(otherPhone_input);
            
            //fax
            String fax_input = data.getCellData(sheetName, "Fax", row);
            contact.fax.sendKeys(fax_input);
            
            //mobile
            String mobile_input = data.getCellData(sheetName, "Mobile", row);
            contact.mobile.sendKeys(mobile_input);
            
            //dateOfBirth
            
    	}    
    }

    
}
