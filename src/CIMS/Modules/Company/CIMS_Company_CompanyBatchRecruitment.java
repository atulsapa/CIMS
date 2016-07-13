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



public class CIMS_Company_CompanyBatchRecruitment {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_CompanyBatchRecruitment(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean BatchRecruitment(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on "+sheetName+" module");
		boolean Flag	=	false;

		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String AdConfirmationOrBatchNumber					=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String LocationName									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String LocationAddress1								=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String LocationAddress2								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String LocationUnitType								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String LocationCity									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String LocationStateOrProvince						=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String LocationPostalCode							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String LocationCountryCode							=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String PermWorkLocationAddress1						=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String PermWorkLocationAddress2						=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String PermWorkLocationUnitType						=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String PermWorkLocationCity							=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String PermWorkLocationStateorProvinc				=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String PermWorkLocationPostalCode					=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String PermWorkLocationCountryCode					=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String PWDRequestSubmitted							=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				String PWDReceiptNumber								=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String PrevailingWage								=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				String PrevailingWagePer							=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
				String PWDJobCode									=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
				String PWDSource									=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
				String PWDOtherSource								=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
				String PWDValidityStartDate							=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
				String PWDValidityEndDate							=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
				String FirstSundayName								=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
				String FirstSundayDate								=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
				String SecondSundayName								=			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
				String SecondSundayDate								=			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
				String SWAJobOrderFirstDate							=			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
				String SWAJobOrderLastDate							=			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
				String RecruitmentActivity1							=			UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
				String Recruitment1Title							=			UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
				String Recruitment1StartDate						=			UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);
				String Recruitment1EndDate							=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
				String RecruitmentActivity2							=			UtilFunction.getCellData(filename, sheetName, 40, ColumnCounter);
				String Recruitment2Title							=			UtilFunction.getCellData(filename, sheetName, 41, ColumnCounter);
				String Recruitment2StartDate						=			UtilFunction.getCellData(filename, sheetName, 42, ColumnCounter);
				String Recruitment2EndDate							=			UtilFunction.getCellData(filename, sheetName, 43, ColumnCounter);
				String RecruitmentActivity3							=			UtilFunction.getCellData(filename, sheetName, 44, ColumnCounter);
				String Recruitment3Title							=			UtilFunction.getCellData(filename, sheetName, 45, ColumnCounter);
				String Recruitment3StartDate						=			UtilFunction.getCellData(filename, sheetName, 46, ColumnCounter);
				String Recruitment3EndDate							=			UtilFunction.getCellData(filename, sheetName, 47, ColumnCounter);
				String TearSheetsReceived							=			UtilFunction.getCellData(filename, sheetName, 48, ColumnCounter);
				String LevelOfExperienceList						=			UtilFunction.getCellData(filename, sheetName, 49, ColumnCounter);
				String Closed										=			UtilFunction.getCellData(filename, sheetName, 50, ColumnCounter);
				String ApplicantReceivedCount						=			UtilFunction.getCellData(filename, sheetName, 51, ColumnCounter);
				String QualifiedApplicantCount						=			UtilFunction.getCellData(filename, sheetName, 52, ColumnCounter);
				
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 53, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					
//					if(mode.equals("Delete")){
//						return false;
//					}
//					else{

						if(mode.equals("New")){

							System.out.println("entering add mode for "+sheetName+" module");

							String AddNewBtnXpath	=	"//a[contains(@class,'btn') and contains(text(),'Add Batch Recruitment')]";
							utilfunc.MakeElement(AddNewBtnXpath).click();
							System.out.println("User is now about to add batch recruitment");

						}else if(mode.equals("Edit") || mode.equals("Delete")){
//
							System.out.println("User has entered "+mode+" mode");
							String BatchListCounterXPath		=	".//*[@id='divList']/tbody/tr";
							String BatchListXPath				=	".//*[@id='divList']/tbody/tr[rr]";

							int rCount	=	utilfunc.GetObjectCount(BatchListCounterXPath);
							for(int a=1;a<=rCount;a++){

								String NewXPath							=	BatchListXPath.replace("rr", Integer.toString(a));
								String BatchNumberList					=	utilfunc.MakeElement(NewXPath+"/td[1]").getText();
								String LocationNameList					=	utilfunc.MakeElement(NewXPath+"/td[2]").getText();
								String JobCodeList						=	utilfunc.MakeElement(NewXPath+"/td[3]").getText();
								String ReceiptNumberList				=	utilfunc.MakeElement(NewXPath+"/td[4]").getText();

								if(AdConfirmationOrBatchNumber.equalsIgnoreCase(BatchNumberList) &&  LocationName.equalsIgnoreCase(LocationNameList)
										&& PWDJobCode.equalsIgnoreCase(JobCodeList) && PWDReceiptNumber.equalsIgnoreCase(ReceiptNumberList)
										){

									if(mode.equals("Edit")){

										System.out.println("Record found in the list, now let us open the same for edit");
										String BatchListEditXPath	=	NewXPath+"/td[6]/a/i";
										try{
											utilfunc.MakeElement(BatchListEditXPath).click();
											break;
										}catch(Exception e){
											System.out.println("editing record as per");
										}
									}else if(mode.equals("Delete")){
										
										System.out.println("Record found in the list, now let us delete the record");
										String BatchListDeleteXPath	=	NewXPath+"/td[7]/a/i";
										
										try{
											utilfunc.MakeElement(BatchListDeleteXPath).click();
											utilfunc.isAlertPresent();
											System.out.println("record deleted succesfully!");
											Flag=true;
											return Flag;
										}catch(Exception s){
											Flag	=	false;
											System.out.println("unable to delete record successfully!");
										}
										return Flag;
										
									}
								}
							}
						}
						
						try{
								String FormFieldCounterXPath					=		".//*[@id='form1']//*[@class='control-group']";
								String FormFieldXPath							=		".//*[@id='form1']//*[@class='control-group'][gg]//*[@class='controls']//*[@name]";

								int count						=		utilfunc.GetObjectCount(FormFieldCounterXPath);

								for(int r=1;r<=count;r++){

									String NewFieldXPath		=		FormFieldXPath.replace("gg",Integer.toString(r));
									String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
									
									if(AttributeName.equals("AdConfirmationOrBatchNumber")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(AdConfirmationOrBatchNumber);
									}
									else if(AttributeName.equals("LocationName")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationName);
									}
									else if(AttributeName.equals("LocationAddress1")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationAddress1);
									}
									else if(AttributeName.equals("LocationAddress2")){

										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationAddress2);
									}
									else if(AttributeName.equals("LocationUnitType")){

										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, LocationUnitType);
									}
									else if(AttributeName.equals("LocationCity")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationCity);
									}
									else if(AttributeName.equals("LocationStateOrProvince")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationStateOrProvince);
									}
									else if(AttributeName.equals("LocationPostalCode")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(LocationPostalCode);
									}
									else if(AttributeName.equals("LocationCountryCode")){
										
										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, LocationCountryCode);
									}

									else if(AttributeName.equals("PermWorkLocationAddress1")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PermWorkLocationAddress1);
									}
									else if(AttributeName.equals("PermWorkLocationAddress2")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PermWorkLocationAddress2);
									}
									else if(AttributeName.equals("PermWorkLocationUnitType")){
										
										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, PermWorkLocationUnitType);
									}
									else if(AttributeName.equals("PermWorkLocationCity")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PermWorkLocationCity);
									}
									else if(AttributeName.equals("PermWorkLocationStateorProvinc")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PermWorkLocationStateorProvinc);
									}
									else if(AttributeName.equals("PermWorkLocationPostalCode")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PermWorkLocationPostalCode);
									}
									else if(AttributeName.equals("PermWorkLocationCountryCode")){
										
										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, PermWorkLocationCountryCode);
									}
									else if(AttributeName.equals("PWDRequestSubmitted")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDRequestSubmitted.replaceAll("\\.0*$", ""));
									}
									else if(AttributeName.equals("PWDReceiptNumber")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDReceiptNumber);
									}
									else if(AttributeName.equals("PrevailingWage")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PrevailingWage);
									}
									else if(AttributeName.equals("PrevailingWagePer")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PrevailingWagePer);
									}
									else if(AttributeName.equals("PWDJobCode")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDJobCode);
									}
									else if(AttributeName.equals("PWDSource")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDSource);
										utilfunc.scrollToBottom();
									}
									else if(AttributeName.equals("PWDOtherSource")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDOtherSource);
									}
									else if(AttributeName.equals("PWDValidityStartDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDValidityStartDate);
									}
									else if(AttributeName.equals("PWDValidityEndDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(PWDValidityEndDate);
									}
									else if(AttributeName.equals("FirstSundayName")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(FirstSundayName);
									}
									else if(AttributeName.equals("FirstSundayDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(FirstSundayDate);
									}
									else if(AttributeName.equals("SecondSundayName")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(SecondSundayName);
									}
									else if(AttributeName.equals("SecondSundayDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(SecondSundayDate);
									}
									else if(AttributeName.equals("SWAJobOrderFirstDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(SWAJobOrderFirstDate);
									}
									else if(AttributeName.equals("SWAJobOrderLastDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(SWAJobOrderLastDate);
									}
									else if(AttributeName.equals("RecruitmentActivity1")){
										
										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, RecruitmentActivity1);
									}
									else if(AttributeName.equals("Recruitment1Title")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment1Title);
									}
									else if(AttributeName.equals("Recruitment1StartDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment1StartDate);
									}
									else if(AttributeName.equals("Recruitment1EndDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment1EndDate);
									}
									else if(AttributeName.equals("RecruitmentActivity2")){

										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(RecruitmentActivity2);
									}
									else if(AttributeName.equals("Recruitment2Title")){

										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment2Title);
									}
									else if(AttributeName.equals("Recruitment2StartDate")){

										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment2StartDate);
									}
									else if(AttributeName.equals("Recruitment2EndDate")){

										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment2EndDate);
									}
									else if(AttributeName.equals("RecruitmentActivity3")){

										utilfunc.Selectdropdownvaluebytext(NewFieldXPath, RecruitmentActivity3);
									}
									else if(AttributeName.equals("Recruitment3Title")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment3Title);
									}									
									else if(AttributeName.equals("Recruitment3StartDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment3StartDate);
									}
									else if(AttributeName.equals("Recruitment3EndDate")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(Recruitment3EndDate);
									}									
									else if(AttributeName.equals("TearSheetsReceived")){

										if(Closed.equalsIgnoreCase("Yes")){
											utilfunc.MakeElement("//input[@name='Closed' and @value='True']").click();
										}else if(Closed.equalsIgnoreCase("No")){
											utilfunc.MakeElement("//input[@name='Closed' and @value='False']").click();
										}
									}									
									else if(AttributeName.equals("ApplicantReceivedCount")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(ApplicantReceivedCount);
									}									
									else if(AttributeName.equals("QualifiedApplicantCount")){
										
										utilfunc.MakeElement(NewFieldXPath).clear();
										utilfunc.MakeElement(NewFieldXPath).sendKeys(QualifiedApplicantCount);
									}									

								}
//								Flag	=	true;
									
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to excute batch recruitment");
							}
					 
//						if(Flag==true){
							 try{
								 // save button after saving all data..
								String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
			    	        	utilfunc.MakeElement(saveBtn).click();
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
								Flag	=	false;
								System.out.println("Data is not saved because all fields are not set in the form.");
							}
//						}
					}
//				}	
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();
		return Flag;
	}
}
