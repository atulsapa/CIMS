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
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;
import CIMS.CIMS_Regression_Suite;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Reports.dashboard;
import CIMS.Modules.Custom.*;

public class CIMS_Single_Project_Initiation {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	private Company_Role obj_Company_Role;
	private Questionnaire_Assignment obj_Questionnaire_Assignment;


	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	private dashboard 									obj_Report_Dashboard;
	

	public CIMS_Single_Project_Initiation(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	
	
	public boolean Single_Project_Initiation_Suite(String filename, String sheetName,int ColumnCounter,String mode,String EmployeeName) throws AWTException, InterruptedException{

		setobj_Company_Role(new Company_Role(webdriver,utilfunc));
		setobj_Questionnaire_Assignment(new Questionnaire_Assignment(webdriver,utilfunc));
		setobj_dashboard((new dashboard()));
		
		boolean Flag	=	false;
		String error_flag                ="";
		String error_msg                ="";
		System.out.println("user is on '"+sheetName+"' module..");
		
		//Flags used for ProcessQuestionnaire Assignment Module
		
		boolean SingleProjectInitiation_PassFlag1=false;
		boolean SingleProjectInitiation_PassFlag2=false;
		boolean SingleProjectInitiation_PassFlag3=false;
		boolean SingleProjectInitiation_PassFlag4=false;
		boolean SingleProjectInitiation_PassFlag5=false;
		boolean SingleProjectInitiation_FailFlag1=false;
		boolean SingleProjectInitiation_FailFlag2=false;
		boolean SingleProjectInitiation_FailFlag3=false;
		boolean SingleProjectInitiation_FailFlag4=false;
		boolean SingleProjectInitiation_FailFlag5=false;
		boolean SingleProjectInitiation_NegativePassFlag1=false;
		boolean SingleProjectInitiation_NegativePassFlag2=false;
		boolean SingleProjectInitiation_NegativePassFlag3=false;
		boolean SingleProjectInitiation_NegativePassFlag4=false;
		boolean SingleProjectInitiation_NegativePassFlag5=false;
		

		/*try{
			obj_Questionnaire_Assignment.QuestionnaireAssigment();
		}catch(Exception e){
			System.out.println("unable to set questionnaire role.");
		}*/


		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String DestinationCountry							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String DestinationCity								=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
//		DestinationCountry	=	"AUSTRALLIA";
		String Prefix										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String FirstName									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String MiddleName									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String LastName										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Email										=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		
		String InitiationCmpany								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String RelocationCompanies							=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String Category										=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String Classification								=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String AssignmentType								=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String BusinessUnit									=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String Entity										=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		
		String JobTitle										=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String JobLevel										=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		
		String JobCode										=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String PositionTitle								=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		
		String Salary										=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
		String Currency										=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
		String OriginatingCountry							=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
		String StartDate									=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
		String EndDate										=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);

		String PremiumProcessing										=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
		String PurchaseOrderNumber										=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
		String SpecialInstructions										=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
		String EmployeeID										=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
		String PreferredName							=			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
		String CountryofCitizenship									=			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
		String NoOfPhone										=			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
		
		String Type										=			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
		String Country										=			UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
		String Number										=			UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
		String Extension										=			UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);
		String WorkLocation										=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
		String NoOfFamilyMembers										=			UtilFunction.getCellData(filename, sheetName, 40, ColumnCounter);
		String FMFirstName										=			UtilFunction.getCellData(filename, sheetName, 41, ColumnCounter);
		String FMMiddleName										=			UtilFunction.getCellData(filename, sheetName, 42, ColumnCounter);
		String FMLastName										=			UtilFunction.getCellData(filename, sheetName, 43, ColumnCounter);
		String FMRelationship										=			UtilFunction.getCellData(filename, sheetName, 44, ColumnCounter);
		String IncludeInTrip										=			UtilFunction.getCellData(filename, sheetName, 45, ColumnCounter);
		String UploadDocuments										=			UtilFunction.getCellData(filename, sheetName, 46, ColumnCounter);
		String WebAccess										=			UtilFunction.getCellData(filename, sheetName, 47, ColumnCounter);
		String LoginType										=			UtilFunction.getCellData(filename, sheetName, 48, ColumnCounter);
		String SelectStepsBalContact							=			UtilFunction.getCellData(filename, sheetName, 49, ColumnCounter);
		String SelectStepsCompanyContact						=			UtilFunction.getCellData(filename, sheetName, 50, ColumnCounter);
		String SelectStepsQuestionnaires						=			UtilFunction.getCellData(filename, sheetName, 51, ColumnCounter);
		String CompanyRoles										=			UtilFunction.getCellData(filename, sheetName, 52, ColumnCounter);
		String CompanyContacts										=			UtilFunction.getCellData(filename, sheetName, 53, ColumnCounter);
		String ProcessingCategory								=			UtilFunction.getCellData(filename, sheetName, 54, ColumnCounter);
		String Questionnaires									=			UtilFunction.getCellData(filename, sheetName, 55, ColumnCounter);
		
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 56, ColumnCounter);

		String status;

		if(TestcaseRunMode.equals("Y")){

			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;


			if(mode.equals("New")){

				String NewFieldXPath="";
				System.out.println("entering "+mode+" mode for "+sheetName+" module");

				
				
				 
				// initialize variable that will be used again and again.. like , start time, end time, module name , etc..
				long startTime 								= 0;
				int count									= 0;	
				String AttributeName						=	"";
				String timer								=	"";
				
				// first form xpaths..
				String FormFeildXPath						=		"//*[@id='panel-body-container']//*[contains(@class,'header-feilds')][xx]//*[@name]";
				String FormFeildXCounterPath				=		"//*[@id='panel-body-container']//*[contains(@class,'header-feilds')]";
				String continueButton						=		".//*[contains(@class,'btn') and contains(text(),'Continue')]";


				// second form xpaths
				
				String	DuplicateCounterXPath				=		"//*[contains(@class,'duplicate')]";
				
				String PIFeildCounterXPath					=		"//*[@id='panel-body-container']//*[@class='control-group'][1]//*[contains(@class,'form-row')]//*[@class='input-parent']";
				String PIFeildXPath							=		"//*[@id='panel-body-container']//*[@class='control-group'][1]//*[contains(@class,'form-row')][xx]//*[@name]";
				
				String dyNamicFieldCounterXPath				=		"//*[@class='ng-scope']//*[@class='controls ng-scope']//*[@class='input-parent']//*[@name]";
				String dyNamicFieldXPath					=		"//*[@class='ng-scope']//*[@class='controls ng-scope'][xx]//*[@class='input-parent']//*[@name]";
				
				String PPDFeildCounterXPath						=		"//*[@id='panel-body-container']//*[@class='control-group'][2]//*[contains(@class,'form-row')]//*[@class='input-parent']";
				String PPDFeildXPath							=		"//*[@id='panel-body-container']//*[@class='control-group'][2]//*[contains(@class,'form-row')][xx]//*[@name]";
				String YesSuffixXPath							=		"//.[@value='true']";
				String FalseSuffixXPath							=		"//.[@value='false']";

				String EmpInfoFeildCounterXPath						=		"//*[@id='panel-body-container']//*[@class='control-group'][3]//*[contains(@class,'form-row')]//*[@class='input-parent']";
				String EmpInfoFeildXPath							=		"//*[@id='panel-body-container']//*[@class='control-group'][3]//*[contains(@class,'form-row')][xx]//*[@name]";

				String AddNewFamilyMemberButtonXPath				=		"//*[text()='Add New Family Member']";
				
				// family member fields xpath..
				String FMFirstNameXPath			=	"//*[@name='fmFirstName_www']";
				String FMMiddleNameXPath		=	"//*[contains(@class,'combo-fields')][www]//*[contains(@name,'input')]";//*[contains(@name,'input')]
				String FMLastNameXPath			=	"//*[@name='fmLastName_www']";
				String FMRelationshipXPath		=	"//*[@name='fmRelationship_www']";
				String FMIncludeInTripXPath		=	"//*[contains(@class,'combo-fields')][www]//*[contains(@type,'checkbox')]";

				String ADFeildCounterXPath					=		"//*[@id='panel-body-container']//*[@class='control-group'][4]//*[contains(@class,'form-row')]//*[@class='input-parent']";
				String ADFeildXPath							=		"//*[@id='panel-body-container']//*[@class='control-group'][4]//*[contains(@class,'form-row')][xx]//input";
				String ADFeildSpanXPath						=		"//*[@id='panel-body-container']//*[@class='control-group'][4]//*[contains(@class,'form-row')][xx]//span";
				String	NewSpanXPath						=		"";
				String	NewADFeildSpanXPath						=		"";
				
				
				// third form xpaths
				
				String RoleTypeXPath					=	"//*[@class='balContacts']//*[@name='uRoleType']";
				String AddNewRoleTypeButtonXpath		=	".//*[@id='btnAddNewContact']";


				// forth form xpaths..
				
				
				// step one
				
				////TIMER START///////
				startTime = System.currentTimeMillis();
				Thread.sleep(6000);
				
				/**
				 * activate Project initiation form step 1 form
				 */

				try {

					count										=		utilfunc.GetObjectCount(FormFeildXCounterPath);
					// execute only if counter of form fields are found on the page..

					if(count>0){
						// now proceed with filling first form..
						Thread.sleep(1000);
						
						for(int r=1;r<=count;r++){
							try{
								NewFieldXPath							=		FormFeildXPath.replace("xx", Integer.toString(r));
								AttributeName							=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

								if(AttributeName.equals("uCompanyObj")){
									utilfunc.MakeElement(NewFieldXPath).clear();
									CompanyName		=	CompanyName.substring(0, CompanyName.length()-1);
									utilfunc.MakeElement(NewFieldXPath).sendKeys(CompanyName);
									Thread.sleep(800);
									utilfunc.selectFirstResultFromAutoSuggestion(NewFieldXPath);
								}
								else if(AttributeName.equals("uDestinationCountry")){
									int element_count=utilfunc.GetObjectCount(NewFieldXPath);
									if(element_count>=1)
									{
										for(int i=1;i<=element_count;i++)
										{
											String atrbut_name	=	"";
											String inner_xpath	=	NewFieldXPath+"["+i+"]";
											try{
												atrbut_name			=	utilfunc.MakeElement(inner_xpath).getAttribute("name");	
												}catch(Exception error){}
											if(atrbut_name.equalsIgnoreCase("uDestinationCountry"))
											{
												utilfunc.MakeElement(inner_xpath).clear();
												DestinationCountry		=	DestinationCountry.substring(0, DestinationCountry.length()-1);
												utilfunc.MakeElement(inner_xpath).sendKeys(DestinationCountry.trim());
												Thread.sleep(800);
												utilfunc.selectFirstResultFromAutoSuggestion(inner_xpath);
											}
											else if(atrbut_name.equalsIgnoreCase("uDestinationCity"))
											{
												utilfunc.MakeElement(inner_xpath).clear();
												utilfunc.MakeElement(inner_xpath).sendKeys(DestinationCity.trim());
												Thread.sleep(800);
	
												utilfunc.selectFirstResultFromAutoSuggestion(inner_xpath);
											}
										}
	
									}
								}
								else if(AttributeName.equals("uPrefix")){
									
									String NamePrefixXPath		=	NewFieldXPath+"[1]";
									utilfunc.Selectdropdownvaluebytext(NamePrefixXPath, Prefix);
									// now fill first name & last name
									String FirstNameXPath		=	NewFieldXPath+"[2]";
									utilfunc.MakeElement(FirstNameXPath).clear();
									utilfunc.MakeElement(FirstNameXPath).sendKeys(FirstName);
									String MiddleNameXPath		=	NewFieldXPath+"[3]";
									utilfunc.MakeElement(MiddleNameXPath).clear();
									utilfunc.MakeElement(MiddleNameXPath).sendKeys(MiddleName);
									String LastNameXPath		=	NewFieldXPath+"[4]";
									utilfunc.MakeElement(LastNameXPath).clear();
									utilfunc.MakeElement(LastNameXPath).sendKeys(LastName);
								}
								else if(AttributeName.equals("uEmail")){
									utilfunc.MakeElement(NewFieldXPath).clear();
									utilfunc.MakeElement(NewFieldXPath).sendKeys(Email);
								}
								else{
									continue;
								}
							}catch(Exception e){
//								System.out.println("no element found for "+NewFieldXPath +" xpath");
							}
						}

						// once all data is added to form now lets us save & validate form

						/**
						 * now click on continue button so that next form should appear..
						 */

						try{
							Thread.sleep(2000);
							utilfunc.MakeElement(continueButton).click();
							System.out.println("clicked on continue button.. let us wait for form to load");
							
						}catch(Exception e){
							System.out.println("some error occured while clicking on continue button");
						}

						// now error handler code for step one..
						Thread.sleep(4000);
						try{
							timer = utilfunc.getTimeTakenByModule(startTime);
							// handling error for ng-scope errors
							error_flag=utilfunc.ErrorMessageHandlerInSPI(FormFeildXCounterPath);
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
							 
							 // generate report for step one..

							 utilfunc.updateModuleDataForReportGeneration(sheetName+" - Step 1", EmployeeName, timer);

							 if (Flag)
								{
									status="PASS";
									if(utilfunc.globalerrormessage.equals(""))
									{
										utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
										// now write it in a pass file START...
										if(SingleProjectInitiation_PassFlag1==false){
											try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step1", "Pass");
											}catch(Exception e){}
											SingleProjectInitiation_PassFlag1=true;
										}// now write it in a pass file ENDS...

										//Write Positive Pass dashboard report 
										try {
											obj_Report_Dashboard.writeDashBoardPassReport(sheetName, EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status, timer);
										}catch(Exception e){
											System.out.println("unable to write dasboard pass report for : "+sheetName+" Step1");}
									}
									else
									{
										utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
										// now write it in a negative pass dashboard file START...
										if(SingleProjectInitiation_NegativePassFlag1==false){
											try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step1","Negative Pass");
											}catch(Exception e){}
											SingleProjectInitiation_NegativePassFlag1=true;
										}// now write it in a negative pass dashboard file ENDS...

										//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
										try {
											obj_Report_Dashboard.writeDashBoardNegativePassReport(sheetName,EmployeeName,testcaseid,utilfunc.Actualbrw,scenerio,mode,description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
										} catch (Exception e) {
											System.out.println("unable to write dasboard negative pass report for : "+sheetName+" Step1");}
									
									}
								}
								else
								{
									status="FAIL";
									utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
										// now write it in a fail dashboard file START...
										if(SingleProjectInitiation_FailFlag1==false){
											try{ obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step1","Fail");
											}catch(Exception e){}
											SingleProjectInitiation_FailFlag1	= true;
										}// now write it in a fail dashboard file ENDS...
										try {
											obj_Report_Dashboard.writeDashBoardFailReport(sheetName,EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
										} catch (Exception e) {
											System.out.println("unable to write dasboard fail report for : "+sheetName+" Step1");}
								
								}
							
							 // now execute code for second step..
							 if(Flag && error_flag.isEmpty()){
								 
									 System.out.println(" report generated for 1st step, now going to check if any dublicate record is present..");

									 try{
									 
										int duplicateCount				=		utilfunc.GetObjectCount(DuplicateCounterXPath);
										if(duplicateCount>=1){
											// picking first record for the same

											String NewCheckbox			=		".//*[@class='checkboxLabel blue']/input";			
											// click on first record..
											try {
												utilfunc.MakeElement(NewCheckbox).click();

												System.out.println("clicked on new employee check box..");
											} catch (Exception e) {

												System.out.println("unable to find new emplyee checkbox");
											}
										}
									 }catch(Exception e){
										 System.out.println("no dublicate reord found now continue with filling second form..");
									 }
									 
									 // fill second form..
									////TIMER START///////
									 startTime = System.currentTimeMillis();
									 Thread.sleep(2000);
									 
									 try{
										 
											/**
											 * fill in data for project information
											 */


											int countPI									=		utilfunc.GetObjectCount(PIFeildCounterXPath);
							
											if(countPI>=1){
												AttributeName="";
											for(int r=1;r<=countPI;r++){
												// wait for a while
												Thread.sleep(1000);
												try{
													NewFieldXPath							=		PIFeildXPath.replace("xx", Integer.toString(r));
													AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
								
							//						EnableRelocation
													if(AttributeName.equals("EnableRelocation")){
														if(InitiationCmpany.equalsIgnoreCase("Yes")){
														try {
															utilfunc.enableOrDisableCheckbox(NewFieldXPath, true);
															Thread.sleep(1500);
														} catch (Exception e) {
															
															System.out.println("unable to check initiation company..");
														}
														}
														else{
															utilfunc.enableOrDisableCheckbox(NewFieldXPath, false);
														}
													}
													// relocation company
													else if(AttributeName.equals("uRelocationCompany") && InitiationCmpany.equals("Yes")){
														utilfunc.Selectdropdownvaluebytext(NewFieldXPath, RelocationCompanies);
													}
											
													// Assignment type
													else if(AttributeName.equals("AssignmentType")){
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, AssignmentType);
														} catch (Exception e) {
														
															System.out.println("unable to select assignment type");
														}
													}
													//BusinessUnit
													else if(AttributeName.equals("BusinessUnit")){
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, BusinessUnit);
														} catch (Exception e) {
															
															System.out.println("unable to select business unit");
														}
													}
														
													else if(AttributeName.equals("Entity")){
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, Entity);
														} catch (Exception e) {
							
															
															System.out.println("unable to select Entity");
														}
													}
							
							//						Job Information
													else if(AttributeName.equals("JobTitle")){
							
														int element_count=utilfunc.GetObjectCount(NewFieldXPath);
														String NewXpathForInnerFields		=	NewFieldXPath.replace("//*[@name]", "//*[@class='inline'][kkk]//*[@name]");
														if(element_count>=1)
														{
															for(int in=1;in<=element_count;in++)
															{
																String atrbut_name	=	"";
																String inner_xpath	=	NewXpathForInnerFields.replace("kkk", Integer.toString(in));
																try{
																	atrbut_name			=	utilfunc.MakeElement(inner_xpath).getAttribute("name");	
																	}catch(Exception error){}
																if(atrbut_name.equalsIgnoreCase("JobTitle"))
																{
																	utilfunc.MakeElement(inner_xpath).clear();
																	utilfunc.MakeElement(inner_xpath).sendKeys(JobTitle);
																	Thread.sleep(800);
																}
																else if(atrbut_name.equalsIgnoreCase("JobLevel"))
																{
																	utilfunc.MakeElement(inner_xpath).clear();
																	utilfunc.MakeElement(inner_xpath).sendKeys(JobLevel);
																	Thread.sleep(1000);
							
																	// look up code
																	String LookUpBtnXPath		=	 "//*[contains(@class,'btn') and text()='Lookup']";
																	String SearchBtnXPath		=	 "//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[contains(@class,'btn') and text()='Search']";
																	String CancelBtnXPath		=	"//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[contains(@class,'btn') and text()='Cancel']";
																	utilfunc.MakeElement(LookUpBtnXPath).click();
																	//   
																	Thread.sleep(1000);
																	// set job code & title to search for
																	String PositionSearchFieldCounterXPath			=		"//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[@class='modal-body ng-scope']//*[@class='input-parent']//*[@ng-model]";
																	String PositionSearchFieldXPath					=		"//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[@class='modal-body ng-scope']//*[@class='input-parent']//*[@ng-model][jjj]";
							
																	// now set value for job code & job title in popup window
																	int countJ	=	0;
																	countJ		=		utilfunc.GetObjectCount(PositionSearchFieldCounterXPath);
																	if(countJ>0){
							
																		for(int jj=1;jj<=countJ;jj++){
																			Thread.sleep(800);
																		// set data only when counter has some values in it..
																		String NewPSFXPath			=	PositionSearchFieldXPath.replace("jjj", Integer.toString(jj));
																		String AttributeModel		=	utilfunc.MakeElement(NewPSFXPath).getAttribute("ng-model");
																		if(AttributeModel.equals("jobCode")){
																			utilfunc.MakeElement(NewPSFXPath).clear();
																			utilfunc.MakeElement(NewPSFXPath).sendKeys(JobCode);
																		}
																		else if(AttributeModel.equals("positionTitle")){
																			utilfunc.MakeElement(NewPSFXPath).clear();
																			utilfunc.MakeElement(NewPSFXPath).sendKeys(PositionTitle);
																		}
							
																		}
																		// once details are set, let us search for job titl & pick the first record..
																		Thread.sleep(100);
																		utilfunc.MakeElement(SearchBtnXPath).click();
																		Thread.sleep(3000);
							
																		String PositionListCounterXPath				=	"//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[contains(@class,'contactItem')]";
																		String PositionListFirstSelectXPath		=	"//*[contains(@class,'modal-dialog')]//*[@class='modal-content']//*[contains(@class,'contactItem')][1]//*[@class='blue' and text()='Select']";
							
																		int searchResultCount		=			utilfunc.GetObjectCount(PositionListCounterXPath);
							
																		if(searchResultCount>=1){
							
																			//	record found & now slect first record..
																			utilfunc.MakeElement(PositionListFirstSelectXPath).click();
																		}
																		else{
																			//click on cancel..
																			utilfunc.MakeElement(CancelBtnXPath).click();
																		}
																		
																		
																	}
																	
																}
															}
							
														}
							
														
													}
													// Salary
													else if(AttributeName.equals("uSalary")){
							
														int element_count=utilfunc.GetObjectCount(NewFieldXPath);
														if(element_count>=1)
														{
															for(int in=1;in<=element_count;in++)
															{
																String atrbut_name	=	"";
																String inner_xpath	=	NewFieldXPath+"["+in+"]";
																try{
																	atrbut_name			=	utilfunc.MakeElement(inner_xpath).getAttribute("name");	
																	}catch(Exception error){}
																if(atrbut_name.equalsIgnoreCase("uSalary"))
																{
																	utilfunc.MakeElement(inner_xpath).sendKeys(Salary);
																	Thread.sleep(800);
																}
																else if(atrbut_name.equalsIgnoreCase("uCurrency"))
																{
																	utilfunc.Selectdropdownvaluebytext(inner_xpath, Currency);
																	Thread.sleep(800);
																}
															}
							
														}
							
														
													}
													
													else if(AttributeName.equals("OriginatingCountry")){
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, OriginatingCountry);
														} catch (Exception e) {
															// TODO Auto-generated catch block
															
															System.out.println("unable to select OriginatingCountry");
														}
													}
													
													// start & end date
													else if(AttributeName.equals("uStartDate")){
														Thread.sleep(1000);
														int element_count=utilfunc.GetObjectCount(NewFieldXPath);
														if(element_count>=1)
														{
															Thread.sleep(2000);
															for(int in=1;in<=element_count;in++)
															{
																Thread.sleep(1000);
																String atrbut_name	=	"";
																String inner_xpath	=	NewFieldXPath+"["+in+"]";
																try{
																	atrbut_name			=	utilfunc.MakeElement(inner_xpath).getAttribute("name");	
																	}catch(Exception error){}
																if(atrbut_name.equalsIgnoreCase("uStartDate"))
																{
																	utilfunc.MakeElement(inner_xpath).clear();
																	utilfunc.MakeElement(inner_xpath).sendKeys(StartDate);
																	Thread.sleep(1000);
																	utilfunc.MakeElement("html").click();
																	Thread.sleep(1000);
																}
																else if(atrbut_name.equalsIgnoreCase("uEndDate"))
																{
																	utilfunc.MakeElement(inner_xpath).clear();
																	utilfunc.MakeElement(inner_xpath).sendKeys(EndDate);
																	Thread.sleep(1000);
																	utilfunc.MakeElement("html").click();
																	Thread.sleep(1000);
																}
															}
							
														}
													}
													
													else{
														Thread.sleep(800);
														continue;
													}
												}catch(Exception e){
													System.out.println("unable to find attribute for xpath: "+NewFieldXPath);
							
												}
											}
											// lets wait for some time so that it won't go 
											Thread.sleep(2000);
											}
											
											
											/**
											 * now fill the dynamic fields using their xpath
											 */
							
											//*[@id='panel-body-container']//*[@class='form-parent']//*[@class='ng-scope'][1]//*[@class='controls ng-scope']//*[@name]
											try{
												// wait for a while
												Thread.sleep(1000);

												utilfunc.dynamic_data_ng_scope(dyNamicFieldCounterXPath, dyNamicFieldXPath);
											}catch(Exception e){
												System.out.println("unable to set dynamic data ");
											}
									
											/**
											 * fill in data for project processing details
											 */
							
							
											int countPPD									=		utilfunc.GetObjectCount(PPDFeildCounterXPath);
							
											if(countPPD>=1){
												AttributeName="";
												Thread.sleep(2000);
											for(int r=1;r<=countPPD;r++){
												// wait for a while
												Thread.sleep(1000);
												try{
													NewFieldXPath							=		PPDFeildXPath.replace("xx", Integer.toString(r));
													AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
								
													if(AttributeName.equals("PremiumProcessing")){
														if(PremiumProcessing.equalsIgnoreCase("Yes")){
															try {
																utilfunc.MakeElement(NewFieldXPath+YesSuffixXPath).click();
															} catch (Exception e) {
																
																System.out.println("unable to click on Premiun processing Yes");
															}
														}else if(PremiumProcessing.equalsIgnoreCase("No")){
															try {
																utilfunc.MakeElement(NewFieldXPath+FalseSuffixXPath).click();
															} catch (Exception e) {
																
																System.out.println("unable to click on Premiun processing No");
															}
														}
							
													}
													//Purchase order number
													else if(AttributeName.equals("PurchaseOrderNo")){
														utilfunc.MakeElement(NewFieldXPath).clear();
														utilfunc.MakeElement(NewFieldXPath).sendKeys(PurchaseOrderNumber);
													}
													//Purchase order number
													else if(AttributeName.equals("SpecialInstruction")){
														utilfunc.MakeElement(NewFieldXPath).clear();
														utilfunc.MakeElement(NewFieldXPath).sendKeys(SpecialInstructions);
													}
													
													else{
														continue;
													}
												}catch(Exception e){
													System.out.println("unable to find attribute for xpath: "+NewFieldXPath);
							
												}
											}
											}
											
											
											/**
											 * fill in data for Employee Information details
											 */
							
							
											
											int countEmpInfo									=		utilfunc.GetObjectCount(EmpInfoFeildCounterXPath);
							
											if(countEmpInfo>=1){

											AttributeName	=	"";
											for(int r=1;r<=countEmpInfo;r++){
												// wait for a while
												Thread.sleep(1000);
												try{
													NewFieldXPath							=		EmpInfoFeildXPath.replace("xx", Integer.toString(r));
													AttributeName					=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
								
													// employee id
													if(AttributeName.equals("EmployeeNumber")){
														utilfunc.MakeElement(NewFieldXPath).clear();
														utilfunc.MakeElement(NewFieldXPath).sendKeys(EmployeeID);
													}
													//Preferred Name
													else if(AttributeName.equals("PreferredName")){
														utilfunc.MakeElement(NewFieldXPath).clear();
														utilfunc.MakeElement(NewFieldXPath).sendKeys(PreferredName);
													}
													//Country of Citizenship
													else if(AttributeName.equals("uCitizenship_0")){
							
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, CountryofCitizenship);
														} catch (Exception e) {
															// TODO Auto-generated catch block
															
															System.out.println("unable to select company");
														}
													}
							
													//Country of Citizenship
													else if(AttributeName.equals("uCitizenship_0")){
							
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, CountryofCitizenship);
														} catch (Exception e) {
															// TODO Auto-generated catch block
															
															System.out.println("unable to select company");
														}
													}
													
													//Country of Citizenship
													else if(AttributeName.equals("uPhoneCountry")){
							
														// now set phone numbers
														
														String PhoneCountryXPath		=	NewFieldXPath+"[1]";
														utilfunc.MakeElement(PhoneCountryXPath).clear();
														utilfunc.MakeElement(PhoneCountryXPath).sendKeys(Country);
														String NumberXPath		=	NewFieldXPath+"[2]";
														utilfunc.MakeElement(NumberXPath).clear();
														utilfunc.MakeElement(NumberXPath).sendKeys(Number);
							
														String ExtXPath		=	NewFieldXPath+"[3]";
														utilfunc.MakeElement(ExtXPath).clear();
														utilfunc.MakeElement(ExtXPath).sendKeys(Extension);
													}
													
													//Work Location
													else if(AttributeName.equals("WorkCountry")){
							
														try {
															utilfunc.Selectdropdownvaluebytext(NewFieldXPath, WorkLocation);
														} catch (Exception e) {
															// TODO Auto-generated catch block
															
															System.out.println("unable to select company");
														}
													}
													
													// Web access
													
							
													else{
														continue;
													}
												}catch(Exception e){
													System.out.println("unable to find attribute for xpath: "+NewFieldXPath);
							
												}
											}
											}
											
											
											
											/**
											 * before saving the form let us activate the fields that are left in loop..
											 * like upload documents, web access,  login type.
											 * */
											
											String UploadDocumentXPath		=			"//*[contains(@class,'btn') and text()='Upload']";
											String uploadSelectButton		=			".//*[@id='docUploadModal']//*[@class='modal-body']//button[1]";
											String fileuploadpath			=			"";
											String fileuploadbutton			=			".//*[@id='docUploadModal']//*[contains(@class,'btn') and text()='Upload']";
											String WebAccessXPath			=			"//*[@type='checkbox' and @ng-model='EnableLogin']";
											String LoginTypeXPath			=			"//*[@ng-model='LoginType']";
											
											try{
												// wait for a while
												Thread.sleep(1000);
											if(WebAccess.equalsIgnoreCase("Yes")){
												// click on checkbox to enable user login
												utilfunc.MakeElement(WebAccessXPath).click();
												
												// now select password from login type
												utilfunc.Selectdropdownvaluebytext(LoginTypeXPath, LoginType);
											}
											}catch(Exception e){
												System.out.println("unable to click on web access");
											}

											try{
											// upload documents..
							
											if(UploadDocuments.length()>1 && UploadDocuments!=null){
												Thread.sleep(2000);
												// click on upload buttons
												utilfunc.MakeElement(UploadDocumentXPath).click();
												Thread.sleep(2000);
												utilfunc.MakeElement(uploadSelectButton).click();
												if(CIMS_Regression_Suite.os.contains("Linux")){
													fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
												}else if(CIMS_MainProject.os.contains("Windows")){
													fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
												}
												Thread.sleep(2000);
												utilfunc.uploadfile(fileuploadpath);///UploadDocuments
							
												
												try {
													Thread.sleep(2000);
													utilfunc.MakeElement(fileuploadbutton).click();
												} catch (Exception e) {
													System.out.println("unable to upload file");
													
												}
												
											}
											// wait for a while
												Thread.sleep(2000);
												// before adding family members let us make sure pop up window is closed
												String closeUploadPopUpXPath		=		".//*[@id='docUploadModal']//*[contains(@class,'close')]";
												
												try {
													utilfunc.MakeElement(closeUploadPopUpXPath).click();
												} catch (Exception e1) {
													System.out.println("close popup button not found!");
												}
											
											}
											catch(Exception e){
												System.out.println("unable to run upload");
											}
											
											
											try{



												// family Member
								//					convert family member count into integer from string..
													int TotalNoOfFamilyMembers	=	Integer.parseInt(NoOfFamilyMembers);
												if(TotalNoOfFamilyMembers>=1){
													
													
													String[] FMFirstNames		=	{};
													String[] FMMiddleNames		=	{};
													String[] FMLastNames		=	{};
													String[] FMRelationships		=	{};
													String[] FMIncludeInTrips		=	{};
													// now collect all family members & split them to add one by one
													if(FMFirstName!=null){
														FMFirstNames		=	FMFirstName.split(",");
													}
													if(FMMiddleName!=null){
														FMMiddleNames		=	FMMiddleName.split(",");
													}
													if(FMLastName!=null){
														FMLastNames		=	FMLastName.split(",");
													}
													if(FMRelationship!=null){
														FMRelationships		=	FMRelationship.split(",");
													}
													if(IncludeInTrip!=null){
														FMIncludeInTrips		=	IncludeInTrip.split(",");
													}
								
													
													for(int nmbrOfMem	=	1;nmbrOfMem<=TotalNoOfFamilyMembers;nmbrOfMem++){
								
														//  click on add new member button to add new member
														try {
															utilfunc.MakeElement(AddNewFamilyMemberButtonXPath).click();
															Thread.sleep(2000);
															utilfunc.scrollToBottom();
														} catch (Exception e) {
															System.out.println("unable to click on add new family member");
														}
														// now fill in family member details..
								
								
														// family member first name
														String NewFMFirstName		=	FMFirstNameXPath.replace("www", Integer.toString(nmbrOfMem-1));
														
														try {
															utilfunc.MakeElement(NewFMFirstName).clear();
															utilfunc.MakeElement(NewFMFirstName).sendKeys(FMFirstNames[nmbrOfMem-1]);
														} catch (Exception e) {
															System.out.println("unable to save first name");
														}
								
														// family member middle name
														String NewFMMiddleName		=	FMMiddleNameXPath.replace("www", Integer.toString(nmbrOfMem));
								//						String NewFMMiddleName		=	FMMiddleNameXPath.replace("www", "")+"["+nmbrOfMem+"]";
														
														try {
															utilfunc.MakeElement(NewFMMiddleName).clear();
															utilfunc.MakeElement(NewFMMiddleName).sendKeys(FMMiddleNames[nmbrOfMem-1]);
														} catch (Exception e) {
															System.out.println("unable to save middle name");
														}
								
														// wait for a while
														Thread.sleep(1000);
														// family member last name
														String NewFMLastName		=	FMLastNameXPath.replace("www", Integer.toString(nmbrOfMem-1));
														
														try {
															utilfunc.MakeElement(NewFMLastName).clear();
															utilfunc.MakeElement(NewFMLastName).sendKeys(FMLastNames[nmbrOfMem-1]);
														} catch (Exception e) {
															
															System.out.println("unable to set last name");
														}
														
														// family member relation
														String NewFMRelationship		=	FMRelationshipXPath.replace("www", Integer.toString(nmbrOfMem-1));
														try {
															utilfunc.Selectdropdownvaluebytext(NewFMRelationship, FMRelationships[nmbrOfMem-1].trim());
														} catch (Exception e) {
															
															System.out.println("unable to select relationship");
														}
								
														// family member include in trip
								
														String NewFMIncludeInTrip		=	FMIncludeInTripXPath.replace("www", Integer.toString(nmbrOfMem));
														try {
															Thread.sleep(2000);
															utilfunc.MakeElement(NewFMIncludeInTrip).click();
														} catch (Exception e) {
															System.out.println("unable to click on include this in trip");
														}
								
													}
													
												}
												}
												catch(Exception e){
													System.out.println("unable to run for family members");
												}
											
											/**
											 * fill in data for additional info
											 */
							

											
											int countAD									=		utilfunc.GetObjectCount(ADFeildCounterXPath);
							
											if(countAD>=1){
												AttributeName	=	"";
											for(int r=1;r<=countAD;r++){
							
												try{
													// wait for a while
													Thread.sleep(1000);
													NewADFeildSpanXPath							=		ADFeildSpanXPath.replace("xx", Integer.toString(r));
													
													// now check for all span text present in this group.. and select the appropriate one..
													int countSelectSteps					=		utilfunc.GetObjectCount(NewADFeildSpanXPath);
													
													for(int s=1;s<=countSelectSteps;s++){
							
														Thread.sleep(4500);
														NewSpanXPath				=		NewADFeildSpanXPath+"["+s+"]";
														AttributeName		=		utilfunc.MakeElement(NewSpanXPath).getText().trim();
														String NewInputXPath		=		ADFeildXPath.replace("xx", Integer.toString(r))+"["+s+"]";
														if(AttributeName.equals("BAL Contacts & Process Type") && SelectStepsBalContact.equalsIgnoreCase("Yes")){
															try {
																utilfunc.enableOrDisableCheckbox(NewInputXPath, true);
															} catch (Exception e) {
																
																System.out.println("unable to click on checkbox "+ AttributeName);
															}
														}
														else if(AttributeName.equals("Company Contacts") && SelectStepsCompanyContact.equalsIgnoreCase("Yes")){
															try {
																utilfunc.enableOrDisableCheckbox(NewInputXPath, true);
															} catch (Exception e) {
							
																System.out.println("unable to click on checkbox "+ AttributeName);
															}
														}
														else if(AttributeName.equals("Questionnaires") && SelectStepsQuestionnaires.equalsIgnoreCase("Yes")){
							
															try {
																utilfunc.enableOrDisableCheckbox(NewInputXPath, true);
															} catch (Exception e) {
																
																System.out.println("unable to click on checkbox "+ AttributeName);
															}
														}
													}
													
								
													
												}catch(Exception e){
													System.out.println("unable to find attribute for xpath: "+NewFieldXPath);
							
												}
											}	
											}

								
											// code appended y Brij on 16-May-2016, after debugging SPI, found that div structure is altered hence, it is causing issue in clicking on checkbox for company contacts..
											System.out.println("we are facing issue here");							
											try {
												Thread.sleep(2500);
												if(SelectStepsCompanyContact.equalsIgnoreCase("Yes")){
													String CompanyContactsXPath	=	"//*[@ng-model='AssignmentChkbx']";
													
													utilfunc.enableOrDisableCheckbox(CompanyContactsXPath, true);
													Thread.sleep(2500);
												}
											} catch (Exception e) {
												System.out
														.println("unable to click on company contacts");
											}
																		
											/**
											 * 
											 * now click on save button in order to initiate the project
											 */

											try {
												Thread.sleep(2000);
												String submitButton				=		".//*[contains(@class,'btn') and contains(text(),'Submit')]";
												utilfunc.MakeElement(submitButton).click();
												Thread.sleep(5000);

												System.out.println("Please wait we are checking for error... ... ...");
											} catch (Exception e) {
												System.out.println("unable to click on save button..");
											}
										 
											// now error handler code for step one..
											try{
												timer = utilfunc.getTimeTakenByModule(startTime);
												// handling error for ng-scope errors
												error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
												 
												 // generate report for step two..

												 utilfunc.updateModuleDataForReportGeneration(sheetName+" - Step 2", EmployeeName, timer);

												 if (Flag)
													{
														status="PASS";
														if(utilfunc.globalerrormessage.equals(""))
														{
															utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
															// now write it in a pass file START...
															if(SingleProjectInitiation_PassFlag2==false){
																try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step2", "Pass");
																}catch(Exception e){}
																SingleProjectInitiation_PassFlag2=true;
															}// now write it in a pass file ENDS...

															//Write Positive Pass dashboard report 
															try {
																obj_Report_Dashboard.writeDashBoardPassReport(sheetName, EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status, timer);
															}catch(Exception e){
																System.out.println("unable to write dasboard pass report for : "+sheetName+" Step2");}
														}
														else
														{
															utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a negative pass dashboard file START...
															if(SingleProjectInitiation_NegativePassFlag2==false){
																try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step2","Negative Pass");
																}catch(Exception e){}
																SingleProjectInitiation_NegativePassFlag2=true;
															}// now write it in a negative pass dashboard file ENDS...

															//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
															try {
																obj_Report_Dashboard.writeDashBoardNegativePassReport(sheetName,EmployeeName,testcaseid,utilfunc.Actualbrw,scenerio,mode,description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															} catch (Exception e) {
																System.out.println("unable to write dasboard negative pass report for : "+sheetName+" Step2");}
														
														}
													}
													else
													{
														status="FAIL";
														utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														// now write it in a fail dashboard file START...
														if(SingleProjectInitiation_FailFlag2==false){
															try{ obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step2","Fail");
															}catch(Exception e){}
															SingleProjectInitiation_FailFlag2	= true;
														}// now write it in a fail dashboard file ENDS...
														try {
															obj_Report_Dashboard.writeDashBoardFailReport(sheetName,EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														} catch (Exception e) {
															System.out.println("unable to write dasboard fail report for : "+sheetName+" Step2");}
													}
												 
												 // now call the third form...
												 

												 if(Flag){

														if(SelectStepsBalContact.equalsIgnoreCase("Yes")){

															////TIMER START///////
															startTime = System.currentTimeMillis();

															// code here for third step assignment of company roles, processing, etc 


															if(CompanyRoles!=null){
																try{
																	String [] RoleTypes					=	CompanyRoles.split(",");
																	
																	if(RoleTypes.length>0){
																		
																		// select role types and add..
																		for(int y=0;y<RoleTypes.length;y++){
																			
																			Thread.sleep(3000);
																			try{
																				// select role type 
																				utilfunc.Selectdropdownvaluebytext(RoleTypeXPath, RoleTypes[y]);

																				try{
																					//click on add
																					utilfunc.MakeElement(AddNewRoleTypeButtonXpath).click();
																					Thread.sleep(3000);
																				}catch(Exception e){
																					System.out.println("unable to click on add button..");
																				}
																			}catch(Exception e){
																				System.out.println("unable to add role type for BAL contacts");
																			}
																		}
																	}
																	
																}catch(Exception e){
																	
																}

															}




																// now call assign role name module..
																try{


																	Thread.sleep(7500);
																	
																	Flag	=	obj_Company_Role.CompanyRole(filename,sheetName,"balContacts","BAL Contacts",TestcaseID,false);

																	/// process category code starts here..
																	// now select processing category..
																	
																	String ProcessCategoryXPath		=	"//*[@name='ProcessType']";
																	try{
																		Thread.sleep(4500);
																		utilfunc.Selectdropdownvaluebytext(ProcessCategoryXPath, ProcessingCategory);
																	}catch(Exception we){
																		System.out.println("unable to set process categories");
																	}
																	
																	// click on complete or next button..
																	String CompletBtnXPath		=	".//*[contains(@id,'ButtonDisplayId')]";//*[contains(@class,'btn') and contains(text(),'Complete')]";
																	try{
																		Thread.sleep(2500);
																		utilfunc.MakeElement(CompletBtnXPath).click();

																	}catch(Exception e){
																		System.out.println("unable to click on complete button");
																	}
																	
																	// now error handler code for step one..
																	try{
																		timer = utilfunc.getTimeTakenByModule(startTime);
																		// handling error for ng-scope errors
																		error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
																		 
																		 // generate report for step one..

																		 utilfunc.updateModuleDataForReportGeneration(sheetName+" - Step 3", EmployeeName, timer);

																		 if (Flag)
																			{
																				status="PASS";
																				if(utilfunc.globalerrormessage.equals(""))
																				{
																					utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
																					// now write it in a pass file START...
																					if(SingleProjectInitiation_PassFlag3==false){
																						try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step3", "Pass");
																						}catch(Exception e){}
																						SingleProjectInitiation_PassFlag3=true;
																					}// now write it in a pass file ENDS...

																					//Write Positive Pass dashboard report 
																					try {
																						obj_Report_Dashboard.writeDashBoardPassReport(sheetName, EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status, timer);
																					}catch(Exception e){
																						System.out.println("unable to write dasboard pass report for : "+sheetName+" Step3");}
																				}
																				else
																				{
																					utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					// now write it in a negative pass dashboard file START...
																					if(SingleProjectInitiation_NegativePassFlag3==false){
																						try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step3","Negative Pass");
																						}catch(Exception e){}
																						SingleProjectInitiation_NegativePassFlag3=true;
																					}// now write it in a negative pass dashboard file ENDS...

																					//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
																					try {
																						obj_Report_Dashboard.writeDashBoardNegativePassReport(sheetName,EmployeeName,testcaseid,utilfunc.Actualbrw,scenerio,mode,description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					} catch (Exception e) {
																						System.out.println("unable to write dasboard negative pass report for : "+sheetName+" Step3");}
																				}
																			}
																			else
																			{
																				status="FAIL";
																				utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																				// now write it in a fail dashboard file START...
																				if(SingleProjectInitiation_FailFlag3==false){
																					try{ obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step3","Fail");
																					}catch(Exception e){}
																					SingleProjectInitiation_FailFlag3	= true;
																				}// now write it in a fail dashboard file ENDS...
																				try {
																					obj_Report_Dashboard.writeDashBoardFailReport(sheetName,EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																				} catch (Exception e) {
																					System.out.println("unable to write dasboard fail report for : "+sheetName+" Step3");}
																			}

																		 
																		 if(Flag){
																			 // now code for forth form..
																				// if Company contacts is set to yes
																				
																				if(SelectStepsCompanyContact.equalsIgnoreCase("Yes")){
																
																				// code here for forth step assignment of company contacts, 

																					// code here for third step assignment of company roles, processing, etc 
																					
																					RoleTypeXPath					=	"//*[@class='companyContacts']//*[@name='uRoleType']";
																					AddNewRoleTypeButtonXpath		=	".//*[@id='btnAddNewContact1']";		

																					if(CompanyContacts!=null){
																						try{
																							String [] Contacts					=	CompanyContacts.split(",");
																							
																							if(Contacts.length>0){
																								
																								// select role types and add..
																								for(int y=0;y<Contacts.length;y++){
																									
																									Thread.sleep(3000);
																									try{
																										// select role type 
																										utilfunc.Selectdropdownvaluebytext(RoleTypeXPath, Contacts[y]);

																										try{
																											//click on add
																											utilfunc.MakeElement(AddNewRoleTypeButtonXpath).click();
																											Thread.sleep(3000);
																										}catch(Exception e){
																											System.out.println("unable to click on add button..");
																										}
																									}catch(Exception e){
																										System.out.println("unable to add role type for BAL contacts");
																									}
																								}
																							}
																							
																						}catch(Exception e){
																							
																						}
																						
																					}
																					
																					// now call assign role name module..
																					try{


																						Thread.sleep(6000);
																						////TIMER START///////
																						startTime = System.currentTimeMillis();
																						Flag	=	obj_Company_Role.CompanyRole(filename,sheetName,"companyContacts","Company Contacts",TestcaseID,false);
																						timer = utilfunc.getTimeTakenByModule(startTime);
																						// now error handler code for step one..
																						try{
																							timer = utilfunc.getTimeTakenByModule(startTime);
																							// handling error for ng-scope errors
																							 
																							 // generate report for step one..

																							 utilfunc.updateModuleDataForReportGeneration(sheetName+" - Step 4 - Company Contacts", EmployeeName, timer);

																							 if (Flag)
																								{
																									status="PASS";
																									if(utilfunc.globalerrormessage.equals(""))
																									{
																										utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
																										// now write it in a pass file START...
																										if(SingleProjectInitiation_PassFlag4==false){
																											try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step4", "Pass");
																											}catch(Exception e){}
																											SingleProjectInitiation_PassFlag4=true;
																										}// now write it in a pass file ENDS...

																										//Write Positive Pass dashboard report 
																										try {
																											obj_Report_Dashboard.writeDashBoardPassReport(sheetName, EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status, timer);
																										}catch(Exception e){
																											System.out.println("unable to write dasboard pass report for : "+sheetName+" Step4");}
																									}
																									else
																									{
																										utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																									
																										// now write it in a negative pass dashboard file START...
																										if(SingleProjectInitiation_NegativePassFlag4==false){
																											try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step4","Negative Pass");
																											}catch(Exception e){}
																											SingleProjectInitiation_NegativePassFlag4=true;
																										}// now write it in a negative pass dashboard file ENDS...

																										//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
																										try {
																											obj_Report_Dashboard.writeDashBoardNegativePassReport(sheetName,EmployeeName,testcaseid,utilfunc.Actualbrw,scenerio,mode,description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																										} catch (Exception e) {
																											System.out.println("unable to write dasboard negative pass report for : "+sheetName+" Step4");}

																									}
																								}
																								else
																								{
																									status="FAIL";
																									utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																									// now write it in a fail dashboard file START...
																									if(SingleProjectInitiation_FailFlag4==false){
																										try{ obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step4","Fail");
																										}catch(Exception e){}
																										SingleProjectInitiation_FailFlag4	= true;
																									}// now write it in a fail dashboard file ENDS...
																									try {
																										obj_Report_Dashboard.writeDashBoardFailReport(sheetName,EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																									} catch (Exception e) {
																										System.out.println("unable to write dasboard fail report for : "+sheetName+" Step4");}
																									
																								}
																							 
																							 
																							 // now add questionnaire assignment form
																							 
																								// if questionnaire is set to yes
																								
																								if(SelectStepsQuestionnaires.equalsIgnoreCase("Yes")){


																									// code here for third step assignment of questionnaires 

																									try{

																										Thread.sleep(5000);
																										////TIMER START///////
																										startTime = System.currentTimeMillis();
																										Thread.sleep(4000);
																										Flag	=	obj_Questionnaire_Assignment.QuestionnaireAssigment(ExpectedErrorMessage);

																										// now error handler code for step one..
																										try{
																											timer = utilfunc.getTimeTakenByModule(startTime);
 
																											 // generate report for step one..

																											 utilfunc.updateModuleDataForReportGeneration(sheetName+" - Step 5", EmployeeName, timer);
																											 
																											 if (Flag)
																												{
																													status="PASS";
																													if(utilfunc.globalerrormessage.equals(""))
																													{
																														utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
																														// now write it in a pass file START...
																														if(SingleProjectInitiation_PassFlag5==false){
																															try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step5", "Pass");
																															}catch(Exception e){}
																															SingleProjectInitiation_PassFlag5=true;
																														}// now write it in a pass file ENDS...

																														//Write Positive Pass dashboard report 
																														try {
																															obj_Report_Dashboard.writeDashBoardPassReport(sheetName, EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status, timer);
																														}catch(Exception e){
																															System.out.println("unable to write dasboard pass report for : "+sheetName+" Step5");}
																													}
																													else
																													{
																														utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																														// now write it in a negative pass dashboard file START...
																														if(SingleProjectInitiation_NegativePassFlag5==false){
																															try {	obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step5","Negative Pass");
																															}catch(Exception e){}
																															SingleProjectInitiation_NegativePassFlag5=true;
																														}// now write it in a negative pass dashboard file ENDS...

																														//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
																														try {
																															obj_Report_Dashboard.writeDashBoardNegativePassReport(sheetName,EmployeeName,testcaseid,utilfunc.Actualbrw,scenerio,mode,description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																														} catch (Exception e) {
																															System.out.println("unable to write dasboard negative pass report for : "+sheetName+" Step5");}

																													}
																												}
																												else
																												{
																													status="FAIL";
																													utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																													// now write it in a fail dashboard file START...
																													if(SingleProjectInitiation_FailFlag5==false){
																														try{ obj_Report_Dashboard.writeReportHeader(sheetName, sheetName+" Step5","Fail");
																														}catch(Exception e){}
																														SingleProjectInitiation_FailFlag5	= true;
																													}// now write it in a fail dashboard file ENDS...
																													try {
																														obj_Report_Dashboard.writeDashBoardFailReport(sheetName,EmployeeName, testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																													} catch (Exception e) {
																														System.out.println("unable to write dasboard fail report for : "+sheetName+" Step5");}
																												}

																											 
																										}catch(Exception e){
																											System.out.println("some error occured while questionnaires ");
																										}
																										
																									}catch(Exception e){
																										System.out.println("unable to set questionnaire role assignment.");
																									}

																								}																							 
																							 
																							 
																						}catch(Exception e){
																							System.out.println("some error occured while submitting third form");
																						}
																						
																					}catch(Exception e){
																						System.out.println("unable to call company contacts.");
																					}

																				
																				// click on complete or next button..
																					CompletBtnXPath="";
																				CompletBtnXPath		=	".//*[contains(@id,'ButtonDisplayId')]";//*[contains(@class,'btn') and contains(text(),'Complete')]";
																				try{
																					Thread.sleep(2500);
																					utilfunc.MakeElement(CompletBtnXPath).click();

																				}catch(Exception e){
																					System.out.println("unable to click on complete button");
																				}
																				
																				
																				}
																		 }
																		 
																	}catch(Exception e){
																		System.out.println("some error occured while submitting third form");
																	}
																	

																	
																}catch(Exception e){
																	System.out.println("unable to call company role.");
																}
															
															
															}
												 }
												 
											}catch(Exception e){
												System.out.println("some error occured while clicking on submit Button");
											}
											

											
											
									 }catch(Exception e){
										 System.out.println("some error occured while filling second form");
									 }
									 
								 
							 }
							 
							 
						}catch(Exception e){
							System.out.println("some error occured while clicking on submit Button");
						}
						

					}


				} catch (Exception e) {
					System.out.println("unable to find elements for first form, hence failing..");
				}
				
				
			}
		}
		
		return Flag;
	}
	
	
	
	public void setobj_Company_Role(Company_Role setobj_Company_Role) {
		this.obj_Company_Role = setobj_Company_Role;
	}
	
	public void setobj_Questionnaire_Assignment(Questionnaire_Assignment setobj_Questionnaire_Assignment) {
		this.obj_Questionnaire_Assignment = setobj_Questionnaire_Assignment;
	}
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}
	
	// xpath for getting report counters..
	
}
