package Pages;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;

import org.openqa.selenium.support.PageFactory;

import Base.App_log;
import Base.TestBase;
import objects.HomePageObject;

public class HomePage extends TestBase{
	HomePageObject home;
	
	public HomePage() {
		this.home = new HomePageObject();
		PageFactory.initElements(driver, this.home);
	}
	
	public void ClickSignIn() {
		click(home.SignInButton);
	}
	public void enterEmail(String str) {
		type(home.email_id, str);
		click(home.email_id_next);
		App_log.logger.log(Level.INFO, "Entered email as " +str+ "successfully" );
	}
	
	public boolean checkInvalidEmail() {
		System.out.println(TestBase.isElementPresent(home.email_invalid));
		
		return TestBase.isElementPresent(home.email_invalid);
	}
	
	
	public void enterPassWord(String str) {
		type(home.password_id, str);
	}
	public void ClickSignInWithCred() {
		click(home.sign_in_button);
	}
	public void assertStatement(String expected) {
		String actual = TestBase.getPageTitle();
		assertEquals(actual, expected);
	}
}
