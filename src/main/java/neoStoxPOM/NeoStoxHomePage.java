package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxHomePage 

{
	
	@FindBy(xpath="(//a[text()='OK'])[2]") private WebElement okButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]") private WebElement closeButton;
	
	@FindBy(id="lbl_username") private WebElement userName;
	
	@FindBy(id="lbl_curbalancetop") private WebElement balance;
	
	@FindBy(xpath="//span[text()='Logout']") private WebElement logOutButton;
	

	public NeoStoxHomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void popUpHandle(WebDriver driver)
	{
		
		if(okButton.isDisplayed())
		{
			Utility.wait(driver,2000);
			Utility.wait(driver,2000);
			
			okButton.click();
			
			Utility.scrollIntoView(driver, closeButton);
			
			Utility.wait(driver, 2000);
			
			closeButton.click();
			Reporter.log("Handeling PopUp", true);
		}
		
		else 
		{
			Utility.wait(driver, 1000);
			
			Reporter.log("There is no popUp", true);
			
			
		}
		
	}
	
	
	public String getUserName(WebDriver driver)
	{
		Utility.wait(driver, 1000);
		
		String actualUserName = userName.getText();
		
		Reporter.log("Getting Username", true);
		
		return actualUserName;
		
		
	}
	
	public String getAccountBalance(WebDriver driver)
	{
		Utility.wait(driver, 2000);
	
		String accountBalance = balance.getText();
		
		Reporter.log("Getting account Balance", true);
		
		return accountBalance;
		
	}

	
	public void logOutFromNeoStox(WebDriver driver)
	{
		Utility.wait(driver, 2000);
		
		userName.click();
		
		Utility.wait(driver, 2000);
		
		logOutButton.click();
		
		Reporter.log("LogOut From NeoStox", true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
