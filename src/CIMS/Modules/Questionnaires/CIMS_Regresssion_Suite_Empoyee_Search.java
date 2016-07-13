package CIMS.Modules.Questionnaires;

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

public class CIMS_Regresssion_Suite_Empoyee_Search {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Regresssion_Suite_Empoyee_Search(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	
	public boolean Employee_Search(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

		boolean Flag	=	false;
		System.out.println("user is on '"+sheetName+"' module");
		System.out.println("entering "+mode+" mode for "+sheetName+" module");

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String DestinationCountry							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String FirstName									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String LastName										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String MiddleName									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String uLastName									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String EmailAddrees									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String uCitizenship									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String WebAccess									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String GlobalSPIField								=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);


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

					Thread.sleep(400);

					try{
							NewFieldXPath					=		FormFeildXPath.replace("xx", Integer.toString(r));
							String AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
		
							if(AttributeName.equals("uCompanyObj")){
								utilfunc.MakeElement(NewFieldXPath).clear();
								utilfunc.MakeElement(NewFieldXPath).sendKeys(CompanyName);
								Thread.sleep(800);
								utilfunc.selectFirstResultFromAutoSuggestion(NewFieldXPath);
							}
							else if(AttributeName.equals("uDestinationCountry")){
								utilfunc.MakeElement(NewFieldXPath).sendKeys(DestinationCountry);
								Thread.sleep(800);
								utilfunc.selectFirstResultFromAutoSuggestion(NewFieldXPath);
							}
					}catch(Exception e){
						System.out.println("no element found for "+NewFieldXPath +" xpath");
					}
				}
				
				/**
				 * now click on continue button so that next form should appear..
				 */
				
				try{
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
				
				String	SecondRowFieldCounterXPath				=			".//*[@id='panel-body-container']//*[contains(@class,'form-row')]//*[contains(@class,'combo-fields')]";
				String	secondRowFieldXPath						=			".//*[@id='panel-body-container']//*[contains(@class,'form-row')]//*[contains(@class,'combo-fields')][yy][@name]";

				int sCount										=			utilfunc.GetObjectCount(SecondRowFieldCounterXPath);

				for(int s=1;s<=sCount;s++){
					String NewXPath							=			secondRowFieldXPath.replace("yy", Integer.toString(s));
					String AttrName							=			utilfunc.MakeElement(NewXPath).getAttribute("name");
					if(AttrName.equals("uFirstName")){

						String FirstNameXPath		=	NewXPath+"[1]";
						utilfunc.MakeElement(FirstNameXPath).clear();
						utilfunc.MakeElement(FirstNameXPath).sendKeys(FirstName);
						// middle name
						String middleNameXPath		=	NewXPath+"[2]";
						utilfunc.MakeElement(middleNameXPath).clear();
						utilfunc.MakeElement(middleNameXPath).sendKeys(MiddleName);
						
						// last name
						String LastNameXPath		=	NewXPath+"[3]";
						utilfunc.MakeElement(LastNameXPath).clear();
						utilfunc.MakeElement(LastNameXPath).sendKeys(LastName);
						
						
						// email
						String EmailXPath		=	NewXPath+"[4]";
						utilfunc.MakeElement(EmailXPath).clear();
						utilfunc.MakeElement(EmailXPath).sendKeys(EmailAddrees);
						
						
						// citizenship
						String citizenshipXPath		=	NewXPath+"[5]";
						utilfunc.MakeElement(citizenshipXPath).clear();
						utilfunc.MakeElement(citizenshipXPath).sendKeys(uCitizenship);
						
						if(WebAccess.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(".//*[@id='EnableLogin']", true);
						}else if(WebAccess.equalsIgnoreCase("No")){
							utilfunc.enableOrDisableCheckbox(".//*[@id='EnableLogin']", false);
						}
					}
				}

				
				
				/**
				 * fill data in 
				 */

				
				//*[@id='panel-body-container']//*[contains(@class,'form-row')]//*[@class='input-parent']//*[@name]
				String PIFeildCounterXPath					=		"//*[@id='panel-body-container']//*[@class='ng-scope']//*[contains(@class,'form-row')]";
				String PIFeildXPath							=		"//*[@id='panel-body-container']//*[@class='ng-scope'][xx]//*[contains(@class,'form-row')]";
				
				utilfunc.addCustomFieldData(PIFeildCounterXPath, PIFeildXPath,filename,"Additional Info");

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
