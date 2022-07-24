package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Hashtable;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Utilities extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;

	public static void capturePrint() {
		LocalDateTime ldt = LocalDateTime.now();
		screenshotPath = ".//target/surefire-reports/html";
		screenshotName = "errorAt" + ldt.getHour() + "_" + ldt.getMinute() + ".jpeg";

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath + "/" + screenshotName);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

		}
	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);
		for (int rnum = 2; rnum < rows; rnum++) {
			String testCase = excel.getCellData(sheetName, "TC_ID", rnum);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, "Runmode", rnum);
				if (runMode.equalsIgnoreCase("y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
