package neoStoxPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxPasswordPage 


{
	@FindBy(id="txt_accesspin") private WebElement passwordField;
	
	@FindBy(id="lnk_submitaccesspin") private WebElement submitButton;
	
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterPassword(WebDriver driver,String pwd)
	{
		Utility.wait(driver,2000);
		
		passwordField.sendKeys(pwd);
		Reporter.log("Entering Password", true);
		
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{   
		
		Utility.wait(driver,2000);
	 	submitButton.click();
		Reporter.log("Clicking on Submit Button", true);
	}
	
	

}
