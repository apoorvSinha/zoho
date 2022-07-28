package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {

	@FindBy(linkText = "Sign in")
	public WebElement SignInButton;
	@FindBy(id = "login_id")
	public WebElement email_id;
	@FindBy(xpath = "//button[@id='nextbtn']")
	public WebElement email_id_next;
	@FindBy(id = "password")
	public WebElement password_id;
	@FindBy(xpath = "//button[@id='nextbtn' and @class='btn blue']")
	public WebElement sign_in_button;
	@FindBy(xpath = "//div[contains(text(),'This account cannot be found. Please use a different account or ')]")
	public WebElement email_invalid;
	
}



