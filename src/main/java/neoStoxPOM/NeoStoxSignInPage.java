package neoStoxPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxSignInPage 

{
     @FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobNumbField;
     
     @FindBy(id="lnk_signup1") private WebElement signInButton;
     
     
  public NeoStoxSignInPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
    	 
     }
	
  public void sendMobNumb(WebDriver driver,String mobNumb)
  {
	  Utility.wait(driver, 2000);
	  
	  mobNumbField.sendKeys(mobNumb);
	  Reporter.log("Entering Mobile Number", true);
	  
  }
  
  public void clickOnSignInButton(WebDriver driver)
  {
	  Utility.wait(driver, 2000);
	  signInButton.click();
	  
	  Reporter.log("Clicing on Sign In Button", true);
	  
  }
	
}
