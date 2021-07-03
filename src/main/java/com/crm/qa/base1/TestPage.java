package com.crm.qa.base1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util1.TestUtil;

public class TestPage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestPage() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace1\\FreeCRMTest1\\src\\main\\java\\com\\crm\\qa\\config1\\config.properties");
			prop.load(ip);
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public static void initialization() {
		String bwsr=prop.getProperty("browser");
		if(bwsr.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		driver=new ChromeDriver();
	}
		if(bwsr.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "");
		driver=new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	}
}