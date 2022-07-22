package rough;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {
	static Actions actions ;
	
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver =  new ChromeDriver();
    	actions =new Actions(driver);
    	driver.get("https://www.zoho.com/");
    	driver.findElement(By.linkText("Sign in")).click();
    	driver.findElement(By.cssSelector("#login_id")).sendKeys("apoorvlifeok@outlook.com");
    	WebElement elem = null;
    	try {
    		elem = driver.findElement(By.xpath("//div[contains(text(),'This account cannot be found. Please use a different account or ')]"));
    		
    	}catch (NoSuchElementException e) {
    		System.out.println(isElementPresent(elem));
    		
		}
    
        
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
