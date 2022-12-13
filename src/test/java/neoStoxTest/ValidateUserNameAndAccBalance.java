package neoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.base;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;
import neoStoxUtility.Utility;

public class ValidateUserNameAndAccBalance extends base
{
  
	NeoStoxHomePage home;
	NeoStoxPasswordPage password;
	NeoStoxSignInPage logIn;
	
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		
		launchBrowser();
		home=new NeoStoxHomePage(driver);
		logIn=new NeoStoxSignInPage(driver);
		password=new NeoStoxPasswordPage(driver);
		
		
		
	}
	
	@BeforeMethod
	public void logInToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logIn.sendMobNumb(driver,Utility.readDataFromExcel(0, 1));
		logIn.clickOnSignInButton(driver);
		
		Utility.wait(driver, 2000);
		
		password.enterPassword(driver,Utility.readDataFromExcel(1,1));
		password.clickOnSubmitButton(driver);
		Thread.sleep(1000);
		home.popUpHandle(driver);
		
		
	}
	
	
	@Test
	 public void validateUserName() throws EncryptedDocumentException, IOException
	{

		Assert.assertEquals(home.getUserName(driver), Utility.readDataFromExcel(3, 2),"TC failed, actual and expected User Name is not matching");
	    Utility.takesScreenShot(driver,home.getUserName(driver));
	
	}
	
	
	@Test
	public void validateAcBalance()
	{
	
		Assert.assertNotNull(home.getAccountBalance(driver));
	
		Reporter.log("AC balance is "+home.getAccountBalance(driver), true);
	
	}
	
	@AfterMethod
	public void logout()
	{
	
		home.logOutFromNeoStox(driver);
	}
	
	
	
	@AfterClass
	public void closeApplication() throws InterruptedException
	{
	  closingBrowser();
	}
}
