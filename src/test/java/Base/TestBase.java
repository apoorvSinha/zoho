package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import steps.AppPage;
import steps.ContactPage;
import steps.HomePage;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis ;
    public static WebDriverWait wait;
    public static App_log log = new App_log();
    public static Actions actions;
    public static HomePage homes;
    public static ContactPage contactPage;
    public static AppPage applications;
    public static ChromeOptions opt;
    

    public static void initDriver(){
        //load config files
        try{
            fis = new FileInputStream("./src/test/resources/properties/config.properties");
            config.load(fis);
            App_log.logger.info("Config file loaded");
        }catch (IOException e){
            App_log.logger.info("Config file load error due to :" +e.getMessage());
        }

        //load correct browser as per config file
        if(config.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            if(config.getProperty("headless").equalsIgnoreCase("yes")) {
            	opt = new ChromeOptions();
            	opt.addArguments("--headless");
            	driver = new ChromeDriver(opt);
            } else if(config.getProperty("headless").equalsIgnoreCase("no")) {
            	driver = new ChromeDriver();
            }
            
            
            App_log.logger.info("Chrome driver launched successfully");
        } else if (config.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            App_log.logger.info("Edge driver launched successfully");
        } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            App_log.logger.info("Firefox driver launched successfully");
        }
        //initilazing pages
        
        //manager waits
        driver.get(config.getProperty("testSite"));
        App_log.logger.log(Level.INFO, "Navigating to: "+ config.getProperty("testSite"));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit_wait"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("eplicit_wait"))));
    }
    

	public static void click(WebElement  element) {
		element.click();
		App_log.logger.log(Level.INFO, "Clicking on: " + element);
	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);
		App_log.logger.log(Level.INFO, "Typing in: " + element + " entered value is: " + value);
	}
	
	public static String[] getElementsFromList(List<WebElement> elems) {
		String[] arr = new String[elems.size()];
		int i=0;
		for(WebElement elem: elems) {
			arr[i] = elem.getText();
			i++;
		}
		return arr;
	}
	/*
	static WebElement dropDown;

	public static void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			dropDown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropDown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropDown = driver.findElement(By.id(OR.getProperty(locator)));
		}else if(locator.endsWith("_linkText")) {
			dropDown = driver.findElement(By.linkText(OR.getProperty(locator)));
		}
		Select selected = new Select(dropDown);
		selected.selectByVisibleText(value);

		test.log(Status.INFO, "Selecting from dropdown: " + locator + " value as: " + value);
		log.debug("Selecting from dropdown: " + locator + " value as: " + value);
	}
	
	*/
	public static boolean isElementPresent(WebElement elem) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.getText();
			return true;
		}catch(NoSuchElementException | TimeoutException e) {
			return false;
		}
	}
	public static String getPageTitle() {
		return driver.getTitle();
	}

    //closing the browser
    public static void teardown(){
        driver.quit();
        App_log.logger.log(Level.INFO, "Closing the browser and session");
    }
}
