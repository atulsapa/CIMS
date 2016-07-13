package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;

import util.UtilFunction;

public class CIMS_Regresssion_Suite_Bulk_Initiation {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Regresssion_Suite_Bulk_Initiation(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	public boolean Bulk_Initiation(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

		boolean Flag	=	false;
		System.out.println("user is on '"+sheetName+"' module");
		System.out.println("entering "+mode+" mode for "+sheetName+" module");

		// excel sheet data
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String DestinationCountry							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String FirstName									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String MiddleName									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String LastName										=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String EmailAddrees									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String uCitizenship									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String WebAccess									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);

		
		

		if(TestcaseRunMode.equals("Y")){

			
			
			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;


			if(mode.equals("New")){

				String NewFieldXPath="";
				System.out.println("entering "+mode+" mode for "+sheetName+" module");

				/**
				 * activate Project initiation form
				 */

				String FormFeildXPath						=		"//*[@id='panel-body-container']//*[contains(@class,'header-feilds')][xx]//*[@name]";
				String FormFeildXCounterPath				=		"//*[@id='panel-body-container']//*[contains(@class,'header-feilds')]//*[@name]";

				int count									=		utilfunc.GetObjectCount(FormFeildXCounterPath);

				for(int r=1;r<=count;r++){

					Thread.sleep(1000);

					try{
							NewFieldXPath					=		FormFeildXPath.replace("xx", Integer.toString(r));
							String AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
		
							if(AttributeName.equals("uCompanyObj")){
								utilfunc.MakeElement(NewFieldXPath).clear();
								CompanyName	=	CompanyName.substring(0,CompanyName.length()-1);
								utilfunc.MakeElement(NewFieldXPath).sendKeys(CompanyName);
								Thread.sleep(800);
								utilfunc.selectFirstResultFromAutoSuggestion(NewFieldXPath);
							}
							else if(AttributeName.equals("uDestinationCountry")){
								utilfunc.Selectdropdownvaluebytext(NewFieldXPath,DestinationCountry);
							}
					}catch(Exception e){
						System.out.println("no element found for "+NewFieldXPath +" xpath");
					}
				}
				
				/**
				 * now click on continue button so that next form should appear..
				 */
				
				try{
					Thread.sleep(2000);
					String continueButton				=		".//*[contains(@class,'btn') and contains(text(),'Continue')]";
					utilfunc.MakeElement(continueButton).click();
					System.out.println("clicked on continue button.. let us wait for form to load");
				}catch(Exception e){
					System.out.println("some error occured while clicking on continue button");
				}
				
				Thread.sleep(1000);


				/**
				 * fill name & email & citizenship
				 */

				String	SecondRowFieldCounterXPath				=			".//*[@id='panel-body-container']//*[contains(@class,'form-row')][1]//*[contains(@class,'combo-fields')]";
				String	secondRowFieldXPath						=			".//*[@id='panel-body-container']//*[contains(@class,'form-row')][1]//*[contains(@class,'combo-fields')]//*[@name][yy]";

				int sCount										=			utilfunc.GetObjectCount(SecondRowFieldCounterXPath);

				for(int s=1;s<=sCount;s++){
					Thread.sleep(1000);
					String NewXPath							=			secondRowFieldXPath.replace("yy", Integer.toString(s));
					String AttrName							=			utilfunc.MakeElement(NewXPath).getAttribute("name");
					if(AttrName.equals("uFirstName")){

						String FirstNameXPath		=	secondRowFieldXPath.replace("yy", "1");
						utilfunc.MakeElement(FirstNameXPath).clear();
						utilfunc.MakeElement(FirstNameXPath).sendKeys(FirstName);
						// middle name
						String middleNameXPath		=	secondRowFieldXPath.replace("yy", "2");
						utilfunc.MakeElement(middleNameXPath).clear();
						utilfunc.MakeElement(middleNameXPath).sendKeys(MiddleName);
						
						// last name
						String LastNameXPath		=	secondRowFieldXPath.replace("yy", "3");
						utilfunc.MakeElement(LastNameXPath).clear();
						utilfunc.MakeElement(LastNameXPath).sendKeys(LastName);
						
						
						// email
						String EmailXPath		=	secondRowFieldXPath.replace("yy", "4");
						utilfunc.MakeElement(EmailXPath).clear();
						utilfunc.MakeElement(EmailXPath).sendKeys(EmailAddrees);
						
						
						// citizenship
						String citizenshipXPath		=	secondRowFieldXPath.replace("yy", "5");
						//utilfunc.MakeElement(citizenshipXPath).clear();
						utilfunc.Selectdropdownvaluebytext(citizenshipXPath,uCitizenship);
						
						// enable web access
						try{
						if(WebAccess.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(".//*[@id='EnableLogin']", true);
						}else if(WebAccess.equalsIgnoreCase("No")){
							utilfunc.enableOrDisableCheckbox(".//*[@id='EnableLogin']", false);
						}
						}catch(Exception e){
							System.out.println("unale to play checkbox..");
						}
					}
					
				}

				
				
				/**
				 * fill data in 
				 */

				try{
				//*[@id='panel-body-container']//*[contains(@class,'form-row')]//*[@class='input-parent']//*[@name]
				String PIFeildCounterXPath					=		"//*[@id='panel-body-container']//*[@class='ng-scope']//*[contains(@class,'form-row')]//*[@class='input-parent']";
				String PIFeildXPath							=		"//*[@id='panel-body-container']//*[@class='ng-scope'][xx]//*[contains(@class,'form-row')]//*[@class='input-parent']";
				
//				utilfunc.addCustomFieldData(PIFeildCounterXPath, PIFeildXPath,filename,"Additional Info");
				utilfunc.dynamic_data_ng_scope(PIFeildCounterXPath, PIFeildXPath);
				}catch(Exception e){
					System.out.println("unable to set dynamic data ");
				}

//				ctm_tx_4161
/**				
				int countPI									=		utilfunc.GetObjectCount(PIFeildCounterXPath);

				for(int r=1;r<=countPI;r++){

					try{
						NewFieldXPath							=		PIFeildXPath.replace("xx", Integer.toString(r));
						String AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
	
						
						
					}catch(Exception e){
						System.out.println("unable to find attribute for xpath: "+NewFieldXPath);

					}
				}
				*/
				
				/*
				 * 
				 * now click on save button in order to initiate the project
				 */
				
				/**
				 * now click on continue button so that next form should appear..
				 */
				
				try{
					String submitButton				=		".//*[contains(@class,'btn') and contains(text(),'Initiate')]";
					utilfunc.MakeElement(submitButton).click();
					System.out.println("clicked on submit Button .. let us wait for form to load");
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed");
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
					System.out.println("some error occured while clicking on submit Button");
				}
				
			}
		}
		
		return Flag;
	}
}
