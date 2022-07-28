package rough;


import static org.hamcrest.CoreMatchers.containsString;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class Rough {
	static Actions actions ;
	
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions opt = new ChromeOptions();
    	opt.addArguments("disable-infobars");	
		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	WebDriver driver =  new ChromeDriver(opt);
    	/*      	actions =new Actions(driver);
    	driver.get("https://chromedriver.chromium.org/capabilities");
    	
    	  	driver.findElement(By.linkText("Sign in")).click();
    	driver.findElement(By.cssSelector("#login_id")).sendKeys("apoorvlifeok@outlook.com");
    	WebElement elem = null;
    	try {
    		elem = driver.findElement(By.xpath("//div[contains(text(),'This account cannot be found. Please use a different account or ')]"));
    		
    	}catch (NoSuchElementException e) {
    		System.out.println(isElementPresent(elem));
    		
		}
		actions.sendKeys(Keys.PAGE_DOWN).perform();
    	
*/
    	ExcelReader reader = new ExcelReader("./src/test/resources/testData/TestData.xlsx");
    	String date = reader.getCellData("Contacts", "Date of Birth", 2);
    	
    	String day = date.substring(0, 2);
		String month = date.substring(2, 4);
		String year = date.substring(4,8);
        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
        
    }
    
    public static boolean isElementPresent(WebElement elem) {
		try {
			actions.moveToElement(elem);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
