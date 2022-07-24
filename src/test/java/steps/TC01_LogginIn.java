package steps;

import java.util.logging.Level;

import Base.App_log;
import Base.TestBase;
import Pages.AppPage;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_LogginIn {
	@Before
	public void setup() {
		TestBase.initDriver();
	}

	@After
	public void tearDown() {
		
	}

	@Given("I am on home page of my test application with testsite url")
	public void i_am_on_home_page_of_my_test_application_with_testsite_url() {
		TestBase.homes = new HomePage();
		TestBase.homes.ClickSignIn();
	}

	@When("I enter my {string} username and {string} password")
	public void i_enter_my_username_and_password(String email, String pwd) throws InterruptedException {
		TestBase.homes.enterEmail(email);
		
		//check exception case where email block password entry
		if(!TestBase.homes.checkInvalidEmail()) {
			App_log.logger.log(Level.INFO, "Entered email is valid so password entry can be done");			
			TestBase.homes.enterPassWord(pwd);
			TestBase.homes.ClickSignInWithCred();
		}else {
			App_log.logger.log(Level.INFO, "Entered email is invalid so password entry not required");			
		}

	}

	@Then("I am {string} logged in to my account and get title as {string}")
	public void i_am_logged_in_to_my_account_and_get_title_as(String isSuccess, String title) throws InterruptedException {
		Thread.sleep(3000);
		TestBase.homes.assertStatement(title);
	}

	@And("I can {string} the applications on my home page")
	public void i_can_the_applications_on_my_home_page(String string) {
		TestBase.applications = new AppPage();

	}
	
	@Given("client is on home page of applications")
	public void client_is_on_home_page_of_applications() {
		TestBase.applications.CheckNumberOfApps();

	}
}

