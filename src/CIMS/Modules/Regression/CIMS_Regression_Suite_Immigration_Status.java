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


public class CIMS_Regression_Suite_Immigration_Status {


	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	public CIMS_Regression_Suite_Immigration_Status(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	public boolean Immigration_Documents(String filename, String sheetName,int ColumnCounter,String mode,String current_baseurl) throws AWTException, InterruptedException{

		boolean Flag	=	false;
		System.out.println("========================\nReady to work with "+sheetName+" module in "+mode+" mode.\n========================");

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Name                                         =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);

		String AuthorizedWorkCityOrProvince                 =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String CategoryId                  				    =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String CategoryId_edit             				    =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String ClassificationId								=           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String ClassificationId_edit						=           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Document_A                                   =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String Issue_Date                                   =           UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);

		String Expiration_Date                              =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String Document_Number                              =           UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String Sponsor_B                                    =           UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String Track                                        =           UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String ProjectsAssociated                           =           UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);

		String IssueDate                                    =           UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String IssueDate_edit                               =           UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String StartDate                                    =           UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		String StartDate_edit                               =           UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String EndDate                                      =           UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		String EndDate_edit                                 =           UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
		String ExpirationDate                               =           UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
		String ExpirationDate_edit                          =           UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
		String MaximumDate                                  =           UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
		String MaximumDate_edit                             =           UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);

		String LegalStatusCode                              =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
		String LegalStatusCode_edit	                        =           UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
		String Tracking                                     =           UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
		String Tracking_edit                                =           UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
		String Sponsor                                      =           UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
		String BeneficiaryNumber                            =           UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
		String Intermittent                                 =           UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);

		String NoExpirationDate                             =           UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
		String FirstUse                                     =           UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
//    	String Document                                     =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
		String Renewing                                     =           UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
		String ReferenceNumber                              =           UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);


		if(TestcaseRunMode.equals("Y")){

			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;

			
			if(mode.equals("Delete")){
				String DeleteXPath	=	".//*[contains(@id,'Status')]//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Delete Record')]";
						// now code for delete button here...
				System.out.println("now code for delete button here...");
				
				try {
					utilfunc.MakeElement(DeleteXPath).click();
				} catch (Exception e) {
				
					System.out.println("Unable to delete the record");
			    }
				Thread.sleep(1000);
				utilfunc.isAlertPresent();
				
			}
			
			if(mode.equals("New") || mode.equals("Edit")){
				
				Thread.sleep(1000);
				String EditStatusXpath=".//*[contains(@id,'Status')]//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Edit')]";
				
				System.out.println("Now code for edoit button........");
				
				try {
					Thread.sleep(1000);
					utilfunc.MakeElement(EditStatusXpath).click();
					Thread.sleep(1000);
				} catch (Exception e) {
				
					System.out.println("Unable to edit the record");
			    }
				
				
				
				
				//					try{
				//					String ImmigrationBtn =".//*[@id='local-navigation']//*[contains(@class,'btn')]//*[contains(@class,'icon-plus')]";
				//					utilfunc.MakeElement(ImmigrationBtn).click();
				//					System.out.println("Clicked on the Immigration Status");
				//					}catch(Exception e){
				//						
				//						System.out.println("Unable to click on the Immigration Status");
				//						
				//					}

				String FormFeildXPath=".//*[@id='form1']//*[@class='control-group']";
				String FormFeildXCounterPath=".//*[@id='form1']//*[@class='control-group'][aa]//*[@class='controls']//*[@name]";
				String Addbtn=".//*[@id='form1']//*[@class='control-group'][6]//*[contains(text(),'Add') and contains(@class,'btn')]";
				int count = utilfunc.GetObjectCount(FormFeildXPath);
				//System.out.println(count);

				for(int i=1; i <=count; i++){
					String NewXpath=FormFeildXCounterPath.replace("aa", Integer.toString(i));
					//System.out.println("Print Xpath:" + NewXpath);
					String AttrName="";
					try{
						AttrName= utilfunc.MakeElement(NewXpath).getAttribute("name");
					}catch(Exception e){

					}
					System.out.println("Print AttrName :" + AttrName);

					if(AttrName.equalsIgnoreCase("CountryCode"))
					{
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath,CountryCode);
						}catch(Exception error){}
						Thread.sleep(200);
					}
					else if(AttrName.equalsIgnoreCase("AuthorizedWorkCityOrProvince"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(AuthorizedWorkCityOrProvince);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("CategoryId"))
					{
						Thread.sleep(1000);
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath,CategoryId );
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("ClassificationId"))
					{
						Thread.sleep(1000);
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath, ClassificationId);
						}catch(Exception error){}
					}else if(AttrName.equalsIgnoreCase("ProjectsAssociated")){
						Thread.sleep(1000);
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath, ProjectsAssociated);
						}catch(Exception error){}
						Thread.sleep(200);
						try
						{
							utilfunc.MakeElement(Addbtn).click();
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("IssueDate"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(IssueDate);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("StartDate"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(StartDate);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("EndDate"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(EndDate);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("ExpirationDate"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(ExpirationDate);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("MaximumDate"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(MaximumDate);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("LegalStatusCode"))
					{
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath, LegalStatusCode);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("Tracking"))
					{
						Thread.sleep(1000);
						try{
								if(Tracking.equalsIgnoreCase("Yes"))
								{
								utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
								}
								else
								{
									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
								}
							}catch(Exception errror){}
					}
					else if(AttrName.equalsIgnoreCase("Sponsor"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(Sponsor);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("BeneficiaryNumber"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(BeneficiaryNumber);
						}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("Intermittent"))
					{
						//utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(1000);
						try{
								if(Intermittent.equalsIgnoreCase("Yes"))
								{
									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
								}
								else
								{
									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
								}
							}catch(Exception error){}
						
						try{
								if(Intermittent.equalsIgnoreCase("yes"))
								{
									NewXpath=NewXpath+"//.[@value='True']";
									utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);
								}
								else
								{
									NewXpath=NewXpath+"//.[@value='False']";
								utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);
								}
							}catch(Exception error){}
					}
					else if(AttrName.equalsIgnoreCase("NoExpirationDate"))
					{
						Thread.sleep(1000);
						try{
								if(NoExpirationDate.equalsIgnoreCase("Yes"))
								{
									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
								}
								else
								{
									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
								}
							}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("FirstUse"))
					{
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath, FirstUse);
						}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("Renewing"))
					{
						try
						{
							utilfunc.Selectdropdownvaluebytext(NewXpath, Renewing);
						}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("ReferenceNumber"))
					{
						try
						{
							utilfunc.MakeElement(NewXpath).sendKeys(ReferenceNumber);
						}catch(Exception error){}
					}	
					else
					{
						System.out.println("Unknown Attribute");
					}
				}
			}
			
if(mode.equals("Edit")){
//
//				String FormFeildXPath=".//*[@id='form1']//*[@class='control-group']";
//				String FormFeildXCounterPath=".//*[@id='form1']//*[@class='control-group'][aa]//*[@class='controls']//*[@name]";
//
//				int count = utilfunc.GetObjectCount(FormFeildXPath);
//				System.out.println(count);
//
//				for(int i=1; i <=count; i++){
//					String NewXpath=FormFeildXCounterPath.replace("aa", Integer.toString(i));
//					System.out.println("Print Xpath:" + NewXpath);
//					String AttrName="";
//					try{
//						AttrName= utilfunc.MakeElement(NewXpath).getAttribute("name");
//					}catch(Exception e){
//
//					}
//					System.out.println("Print AttrName " + AttrName);
//
//					if(AttrName.equalsIgnoreCase("CountryCode")){
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CountryCode);}catch(Exception error){}
//						Thread.sleep(200);
//
//					}else if(AttrName.equalsIgnoreCase("AuthorizedWorkCityOrProvince")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(AuthorizedWorkCityOrProvince);}catch(Exception error){}
//						System.out.println("AuthorizedWorkCityOrProvince has been saved");
//					}else if (AttrName.equalsIgnoreCase("CategoryId")){
//						Thread.sleep(1000);
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CategoryId );}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("ClassificationId")){
//						Thread.sleep(1000);
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ClassificationId);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("ProjectsAssociated")){
//						Thread.sleep(1000);
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ProjectsAssociated);}catch(Exception error){}
//						Thread.sleep(200);
//						String Addbtn=".//*[@id='form1']//*[@class='control-group'][6]//*[contains(text(),'Add') and contains(@class,'btn')]";
//						try{utilfunc.MakeElement(Addbtn).click();}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("IssueDate")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(IssueDate);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("StartDate")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(StartDate);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("EndDate")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(EndDate);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("ExpirationDate")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(ExpirationDate);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("MaximumDate")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(MaximumDate);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("LegalStatusCode")){
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath, LegalStatusCode);}catch(Exception error){}
//					}else if(AttrName.equalsIgnoreCase("Tracking"))
//						{
//						try{
//							if(Tracking.equalsIgnoreCase("Yes")){
//								utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
//							}else{
//								utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
//							}
//						}catch(Exception errror){}
//					}else if (AttrName.equalsIgnoreCase("Sponsor")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(Sponsor);}catch(Exception error){}
//					}
//					else if (AttrName.equalsIgnoreCase("BeneficiaryNumber")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(BeneficiaryNumber);}catch(Exception error){}
//					}
//					else if (AttrName.equalsIgnoreCase("Intermittent")){
//						//utilfunc.MakeElement(NewXpath).click();
//						try{
//						if(Intermittent.equalsIgnoreCase("Yes")){
//							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
//						}else{
//							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
//						}}catch(Exception error){}
//						try{
//							if(Intermittent.equalsIgnoreCase("yes")){
//								NewXpath=NewXpath+"//.[@value='True']";
//								utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);
//							}
//							else{NewXpath=NewXpath+"//.[@value='False']";
//							utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);}
//						}catch(Exception error){}
//						
//					}else if(AttrName.equalsIgnoreCase("NoExpirationDate")){
//						try{
//						if(NoExpirationDate.equalsIgnoreCase("Yes")){
//							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
//						}else{
//							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
//						}}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("FirstUse")){
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath, FirstUse);}catch(Exception error){}
//					}else if (AttrName.equalsIgnoreCase("Renewing")){
//						try{utilfunc.Selectdropdownvaluebytext(NewXpath, Renewing);}catch(Exception error){}
//					}
//					else if (AttrName.equalsIgnoreCase("ReferenceNumber")){
//						try{utilfunc.MakeElement(NewXpath).sendKeys(ReferenceNumber);}catch(Exception error){}
//					}	
//					else{}
//				}
			}
			
			
			try{
				// save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
				try{
						utilfunc.MakeElement(saveBtn).click();
					}
				catch(Exception error)
				{
					System.out.println("some error during click save button");
				}
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
                      
				String error_flag=utilfunc.ErrorMessagehandlerExperiment();
				ExpectedErrorMessage=ExpectedErrorMessage.trim();
				System.out.println("==="+ExpectedErrorMessage+"===");
				System.out.println("==="+error_flag+"===");
				utilfunc.scrollToTop();
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
				}else if ((error_flag.contains("Error!"))||(error_flag.contains("Please"))){
					Flag=false;
					utilfunc.TakeScreenshot();
					Thread.sleep(500);
					webdriver.get(current_baseurl);
				}
				else{
					Flag=false;
					utilfunc.TakeScreenshot();
					webdriver.get(current_baseurl);
				}
			}catch(Exception e){
				Flag	=	false;
				webdriver.get(current_baseurl);
				System.out.println("Data is not saved because all fields are not set in the form.");
			}

		}

		return Flag;
		// TODO Auto-generated method stub

	}

}
