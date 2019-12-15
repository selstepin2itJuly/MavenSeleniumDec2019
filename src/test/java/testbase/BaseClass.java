package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Constants;


public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	/*
	 * Initialize WebDriver
	 * 
	 */
	public static WebDriver init() throws IOException {
		String file="./src/main/java/config/config.properties";
		FileInputStream inStream=new FileInputStream(new File(file));
		prop=new Properties();
		prop.load(inStream);
		Constants.browser=prop.getProperty("browser");
		Constants.url=prop.getProperty("url");
		if(Constants.browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}else if(Constants.browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Dimension dim = new Dimension(320, 568);
		//driver.manage().window().setSize(dim);
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		
		return driver;
	}
}
