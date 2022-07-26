package steps;

import Base.TestBase;
import Pages.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC02_CRM_create_accounts {

	
	@When("client clicks on CRM on applications")
	public void client_clicks_on_crm_on_applications() {
		TestBase.applications.navigateToCRM();
		TestBase.contactPage =  new ContactPage();
	}
	@Then("client clicks account from topmenu")
	public void client_clicks_account_from_topmenu() {
		TestBase.applications.enterContactDetails();
	}
	@And("client clicks on creates account")
	public void client_clicks_on_creates_account() {
		TestBase.contactPage.createAccountButton();
	}
	@And("client enters Account information")
	public void client_enters_account_information() {
		TestBase.contactPage.enterContactInfo();
	}
	@And("client enters Address information")
	public void client_enters_address_information() {
		
	}
	@And("client enters display information")
	public void client_enters_display_information() {
		
	}
	@Then("client clicks on save button")
	public void client_clicks_on_save_button() {
		
	}




}
