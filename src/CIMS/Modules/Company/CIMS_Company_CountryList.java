package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;



public class CIMS_Company_CountryList {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_CountryList(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_Country(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on Add Country module");
		boolean Flag	=	false;
		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String TravelOrigin									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String TravelDestination							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					if(mode.equals("Delete")){
						
						System.out.println("User is deleting travel origin/destination");
						
						if(TravelOrigin!=null){
							String TravelOriginDeleteXPath			=	"//*[@id='OriginCountryList']//*[contains(text(),'"+ TravelOrigin +"')]//*[@class='icon-trash icon-muted']";
							try{
								utilfunc.MakeElement(TravelOriginDeleteXPath).click();
								utilfunc.isAlertPresent();
							}catch(Exception s){
								System.out.println("Unable to delete origin for "+TravelOrigin);
							}
						}
						if(TravelDestination!=null){
							String TravelDestinationXPath		=	"//*[@id='DestinationCountryList']//*[contains(text(),'"+ TravelDestination +"')]//*[@class='icon-trash icon-muted']";
							try{
								utilfunc.MakeElement(TravelDestinationXPath).click();
								utilfunc.isAlertPresent();
							}catch(Exception s){
								System.out.println("Unable to delete destination: "+TravelDestination);
							}
						}
						if(TravelOrigin!=null || TravelDestination!=null){
							try{
								String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
								utilfunc.MakeElement(saveBtn).click();
								System.out.println("record deleted successfully!");
								Flag=true;
								
							}catch(Exception s){
								System.out.println("Unable to delete record");
							}
						}
						else{
							Flag=false;
						}
						
						
					}else{
					
					try{
							// select travel origin and click on add
		//					String //*[@class='input-append']
							String OriginSelectXPath		=	"//*[@name='OriginCountryCode']";
							String OriginCountryAddBtn		=	"//*[@id='btnOriginCountryAdd']";
							String DestinationSelectXPath		=	"//*[@name='DestinationCountryCode']";
							String DestinationCountryAddBtn		=	"//*[@id='btnDestinationCountryAdd']";
		
							utilfunc.Selectdropdownvaluebytext(OriginSelectXPath, TravelOrigin);
							utilfunc.MakeElement(OriginCountryAddBtn).click();
							utilfunc.Selectdropdownvaluebytext(DestinationSelectXPath, TravelDestination);
							utilfunc.MakeElement(DestinationCountryAddBtn).click();
							System.out.println("Desitination added");
								
						}catch(Exception e){
							Flag	=	false;
							System.out.println("Unable to add destination & origin of travel");
						}
					 
					 try{
						 // save button after saving all data..
						String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	    	        	utilfunc.MakeElement(saveBtn).click();
						//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;
							 webdriver.navigate().back();
						 }else{
							 Flag=false;
							 utilfunc.TakeScreenshot();
						 }
					}catch(Exception e){
						Flag	=	false;
						System.out.println("Data is not saved because all fields are not set in the form.");
					}
					}
				}			
		return Flag;
	}
}
