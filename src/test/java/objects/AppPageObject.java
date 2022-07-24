package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppPageObject {
	@FindBy(xpath = "//div[@class='ea-app-container']/div")
	public List<WebElement> apps;
	@FindBy(xpath = "//div[@class='ea-app-container']/div/div/a/div[contains(text(), 'CRM')]")
	public WebElement CRM;
	@FindBy(linkText = "Contacts")
	public WebElement contact_topMenu;


}
