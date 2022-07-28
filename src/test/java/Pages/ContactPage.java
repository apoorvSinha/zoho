package Pages;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import objects.ContactPageObject;
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
            type(contact.first_name,fname);
            
            //enter last name
            String lname = data.getCellData(sheetName.trim(), "Last Name", row);
            type(contact.last_name, lname);
            
            //lead source
            contact.pre_lead_source.click();
            String lead_source = data.getCellData(sheetName.trim(), "Lead Source", row);
            if(lead_source.equalsIgnoreCase("Online Store")) {
            	actions.moveToElement(contact.lead_source_OnlineStore);
            	click(contact.lead_source_OnlineStore);
            }
            
            //account name
            String account_Name = data.getCellData(sheetName.trim(), "Account Name", row);
            type(contact.account_name, account_Name);
            
            //title
            String Title = data.getCellData(sheetName.trim(), "Title", row);
            type(contact.title, Title);
            
            //email
            String email_input = data.getCellData(sheetName.trim() , "Email", row);
            type(contact.email, email_input);
            
            //Department
            String department_input = data.getCellData(sheetName.trim(), "Department", row);
            type(contact.department, department_input);
            
            //Phone
            String phone_input = data.getCellData(sheetName, "Phone", row);
            type(contact.phone, phone_input);
            
            //home phone
            String home_phone_input = data.getCellData(sheetName, "Home Phone", row);
            type(contact.home_phone, home_phone_input);
            
            //Other phone
            String otherPhone_input = data.getCellData(sheetName, "Other Phone", row);
            type(contact.other_phone, otherPhone_input);
            
            //fax
            String fax_input = data.getCellData(sheetName, "Fax", row);
            type(contact.fax, fax_input);
            
            //moving page down
            page_down();
            
            
            //mobile
            String mobile_input = data.getCellData(sheetName, "Mobile", row);
            type(contact.mobile, mobile_input);
            
            
            //dateOfBirth
            String DOB_dd_mm_yyyy = data.getCellData(sheetName, "Date of Birth", row);
            String dob[] = DOB_dd_mm_yyyy.split("/");
            
            
    	}    
    }

    
}
