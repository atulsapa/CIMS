package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Processandquestionnaire_ProcessType {
	
	

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	public CIMS_Processandquestionnaire_ProcessType(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	public boolean Process_Type(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		System.out.println("User is on "+sheetName+" Module.");
		boolean Flag	=	false;
		
		
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String ProcessType                  			    =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		
		if(TestcaseRunMode.equals("Y")){
			
			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;
			
			String ProcessDropDownXpath=".//*[contains(@class,'light')]//*[@id='ProcessType']//.[contains(@name,'ProcessType')]";
			String saveBtn	=	"//*[contains(@class,'btn-info')]//*[contains(@class,'icon-white')]";
			
			if(mode.equals("New") || mode.equals("Edit")){
			// Select the process name 
			
			try {
				Thread.sleep(1500);
				utilfunc.Selectdropdownvaluebytext(ProcessDropDownXpath, ProcessType);
			} catch (Exception e1) {
				System.out.println("Clicked on the process drop down");
			}
			
	}
			
			try{
				 // save button after saving all data..
				//String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	        	utilfunc.MakeElement(saveBtn).click();
	        	Thread.sleep(3000);
			}
			catch(Exception e){}
			try{
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
				String error_flag=utilfunc.ErrorMessagehandlerExperiment();
			//	ExpectedErrorMessage=ExpectedErrorMessage.trim();
				System.out.println("==="+ExpectedErrorMessage+"===");
				System.out.println("==="+error_flag+"===");
				
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
		
		
		
		
		return Flag;
	}

}
