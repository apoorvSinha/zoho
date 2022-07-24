package steps;

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
    public void enterContact(){
        String owner = data.getCellData("Contacts", "Contact Owner", 2);
        Assert.assertEquals(owner.trim(), contact.contact_owner.getText());
    }
    public void enterFirstName(){
        String name = data.getCellData("Contacts", "Lead Source", 2);
        contact.first_name.sendKeys(name);
    }
}
