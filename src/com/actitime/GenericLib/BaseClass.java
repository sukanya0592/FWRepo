package com.actitime.GenericLib;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.ObjectRepositoryLib.Common;
import com.actitime.ObjectRepositoryLib.Login;

public class BaseClass {
	
public static WebDriver driver;
FileUtils lib=new FileUtils();

@Parameters("browser")
@BeforeClass
public void configBC() throws Throwable
{
	Properties pobj=lib.getPropertiesFileObj();
	String bName=pobj.getProperty("browser");
	
	if(bName.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(bName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./Browser//chromedriver.exe");
	    driver= new ChromeDriver();
	}
}

@BeforeMethod
public void configBM() throws Throwable //Login
{
	System.out.println("Login");
	Properties pobj=lib.getPropertiesFileObj();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(pobj.getProperty("Url"));
	
	Login lp=PageFactory.initElements(driver, Login.class);
	lp.login(pobj.getProperty("Username"),pobj.getProperty("Password"));
}

@AfterMethod
public void configAM()  //logout
{
	System.out.println("Logout");
	Common cp=PageFactory.initElements(driver, Common.class);
	cp.logout();
}

@AfterClass
public void configAC()//Close Browser
{
	System.out.println("-----Close Browser-----");
	driver.close();
}

}
