package Pages;

import org.openqa.selenium.support.PageFactory;

import Base.App_log;
import Base.TestBase;
import objects.AppPageObject;

public class AppPage extends TestBase {
	AppPageObject app;

	public AppPage() {
		this.app = new AppPageObject();
		PageFactory.initElements(driver, this.app);
	}

	public void CheckNumberOfApps() {

		for (String str : getElementsFromList(app.apps)) {
			System.out.println(str);
			App_log.logger.info("Apps on home page after successful login are: "+ str);;
		}
	}
	
	public void navigateToCRM() {
		click(app.CRM);
		App_log.logger.info("Navigated to CRM home page");
	}

	public void enterContactDetails(){
		click(app.contact_topMenu);

	}


}
