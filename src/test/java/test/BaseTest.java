package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	
	@BeforeSuite
	public void initBrowser() throws IOException {
		
		  WebDriverManager.chromedriver().setup();	
			//step-1 Launch browser
		   driver=new ChromeDriver();
			
			//Step-2 Maximize window
			driver.manage().window().maximize();
			
			//Step-2a
			prop=new Properties();
			fis=new FileInputStream(path);
			prop.load(fis);
			
			//step-3
			driver.get(prop.getProperty("url"));
			//step-4
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@Test
	public void f() {
		System.out.println("this is my new TEST");
		
		System.out.println("my name is khan");
		//this my new test.
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.close();
	}
	

	
}
