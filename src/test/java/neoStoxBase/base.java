package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.Utility;

public class base
{
   protected static WebDriver driver;

   public void launchBrowser() throws IOException
    {  //Launch Browser
	   System.setProperty("webdriver.chrome.driver","E:\\Software Testing\\chromedriver.exe");	
	   driver=new ChromeDriver();
	   driver.get(Utility.readDataFromPropertyFile("url"));
	   Reporter.log("Launching Browser", true);
	  
	   Utility.wait(driver,2000);
	  
	    }
   
   public static void closingBrowser()
   {
	   Reporter.log("Closing Browser", true);
	   Utility.wait(driver, 1000);
	   driver.close();
   }
   
   
}


	
	

