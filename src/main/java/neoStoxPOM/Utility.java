package neoStoxPOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 

{
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		
		FileInputStream myFile=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\SeleniumPractice\\neoStox.properties");
		prop.load(myFile);
		
		 String value = prop.getProperty(key);
		 
		 Reporter.log("Reading value of "+key+" from Property File", true);
		 return value;
		 
		 
	}
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myFile=new File("E:\\Software Testing\\excelworksheet.xlsx");

		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
		
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		
		Reporter.log("Reading Value from Excel Sheet", true);
		
		return value;
		
		
	}
	
	
	public static void takesScreenShot(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest =new File("E:\\Software Testing\\Screen Shots"+fileName+".png");
		
		FileHandler.copy(src, dest);
		
		Reporter.log("Taking Screen Shot", true);
		
	
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("arguments[0].scrollIntoView(true)", element);
	    
	    Reporter.log("ScrollInto view "+element.getText(), true);
		
	}
	
	public static void wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		
		Reporter.log("Waiting for "+waitTime+" millis", true);
		
	}

}
