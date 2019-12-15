package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import testbase.BaseClass;

public class Utilities extends BaseClass {

	public static void scrollToElement(WebElement ele) {
		//JavascriptExecutor je=(JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);", "");
	}
	
	public static void clickToElement(WebElement ele) {
		//JavascriptExecutor je=(JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}
	
	public static void sendKeysToElement(WebElement ele, String str) {
		//JavascriptExecutor je=(JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+str+"';", ele);
	}
	
	public static void captureScreen() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("./Images/images_"+Utilities.getcurrentDate()+".jpg"));
	}
	public static String getcurrentDate() {
		String str=null;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss_a");
		str=sdf.format(dt);
		return str;
		}
}
