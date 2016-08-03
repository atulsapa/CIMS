package CIMS.Modules.Advanced;

import java.awt.AWTException;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;

import CIMS.Modules.Company.CIMS_Company_Contacts;
import CIMS.Reports.dashboard;

import util.UtilFunction;

public class Employee_Search {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	private CIMS_Company_Contacts obj_CIMS_Company_Contacts;
	private dashboard 									obj_Report_Dashboard;

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description	=	null;
	private String ActionName;
	

	public Employee_Search(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean advanced_Employee_Search(String filename, String sheetName, int ColumnCounter, String mode) throws AWTException, InterruptedException
	{
		setobj_CIMS_Company_Contacts(new CIMS_Company_Contacts(webdriver, utilfunc));
		setobj_dashboard((new dashboard()));
		boolean flag=false;

		System.out.println("User is on "+sheetName+" Module with "+mode+" Mode.");

		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);

		if(TestcaseRunMode.equals("Y"))
		{
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String EmployeeName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String Email										=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Status										=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String BalNumber									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String EmployeeNumber								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String Company										=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String GovtReceiptIDNumber							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String PhoneNumber									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String CustomFeildName								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String CustomFieldValue								=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			String PrincipalOnly								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String IncludeIndividual							=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			String SearchRoster									=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);

			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
			String status;
			
			boolean passCounter			=	false;
			boolean failCounter			=	false;
			boolean notAssignedCounter	=	false;
			

			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			description = TestCaseDescription;


//			if(mode.equals("New")){
//				
				// let us collect data & find xpath of advanced search form..
				
				String empAdvancedSearchCounterXPath		=	".//*[@id='panel-body-container']//*[contains(@class,'employeeSearchFields')]//*[contains(@class,'searchFields')]";
				String empAdvancedSearchXPath				=	".//*[@id='panel-body-container']//*[contains(@class,'employeeSearchFields')]//*[contains(@class,'searchFields')][xx]";
				String MoreOptionsXPath						=	".//*[contains(text(),'More options') and contains(@id,'Employee')]"; ////*[@id='spanEmployee']
				int numberOfAdvFieldCounter					=	0;
				int innerFieldCounter						=	0;
				String AttributeId;
				
				long startTime 								= 0;
				int count									= 0;	
				String AttributeName						=	"";
				String timer								=	"";
				
				
				

				//*[@id='panel-body-container']//*[contains(@class,'employeeSearchFields')]//*[contains(@class,'searchFields')][2]//*[@name and not(@type='hidden')]

				
				// first of all click on More options link..
				Thread.sleep(1500);
				try {
					utilfunc.MakeElement(MoreOptionsXPath).click();
					Thread.sleep(3000);
				} catch (Exception e) {
					System.out.println("unable to click on more button..");
				}

				try{
				
					/// now let us place values into advanced form fields in order to push data...
				try{
					numberOfAdvFieldCounter		=		utilfunc.GetObjectCount(empAdvancedSearchCounterXPath);
				}catch(Exception e){
					System.out.println("unable to get row count of advanced employee search");
				}

				// run only if number of records are present
				if(numberOfAdvFieldCounter>0){
					//
					for (int j = 1; j <= numberOfAdvFieldCounter; j++) {
						Thread.sleep(2000);
						String newCounterXPath		=	empAdvancedSearchXPath.replace("xx", Integer.toString(j));
						
						// now let us find out counter inside each row of counter..
						newCounterXPath				=	newCounterXPath + "//*[@name]";

						System.out.println("new counter xpath: "+newCounterXPath);

						try{
							
							AttributeId					=		utilfunc.MakeElement(newCounterXPath).getAttribute("id");
							
							System.out.println("Attribute Id: "+AttributeId + " for row "+j);

							// first row, set data for name email, status
							if(AttributeId.equals("SearchText")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);
		
								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										//
										try {
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	empAdvancedSearchXPath.replace("xx", Integer.toString(j))+"/div"+"["+i+"]"+ "//*[@name]";
											System.out.println("inner xpath: "+inner_xpath);
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												if(atrbut_id.equals("SearchText")){
													// now set Name value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(EmployeeName);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("Email")){
													// now set Email value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(Email);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("Status")){
													// now set Status value..
													try {
														Thread.sleep(2000);
														utilfunc.Selectdropdownvaluebytext(inner_xpath,Status);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												}catch(Exception error){}
										} catch (Exception e) {
											System.out.println("unable to get inner field");
										}
									}
								}
							}
							
							// set data for second row...
							else if(AttributeId.equals("BalNumber")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);
		
								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										//
										try {
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	empAdvancedSearchXPath.replace("xx", Integer.toString(j))+"/div"+"["+i+"]"+ "//*[@name]";
											System.out.println("inner xpath: "+inner_xpath);
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												if(atrbut_id.equals("BalNumber")){
													// now set BalNumber value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(BalNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("EmployeeNumber")){
													// now set Employee number value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(EmployeeNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("GetCompanyId")){
													// now set Company value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(Company);
														// let us wait for companies to populate in auto suggestion
														try {
															utilfunc.selectFirstResultFromAutoSuggestion(inner_xpath);
														} catch (Exception e) {
															System.out.println("issue occured while selecting value from auto suggestion");
														}
														Thread.sleep(2000);
														
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												}catch(Exception error){}
										} catch (Exception e) {
											System.out.println("unable to get inner field");
										}
									}
								}
							}

							
							// set data for third row...
							else if(AttributeId.equals("GovernmentCase")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);

								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										//
										try {
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	empAdvancedSearchXPath.replace("xx", Integer.toString(j))+"/div"+"["+i+"]"+ "//*[@name]";
											System.out.println("inner xpath: "+inner_xpath);
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												if(atrbut_id.equals("GovernmentCase")){
													// now set BalNumber value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(GovtReceiptIDNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("PhoneNumber")){
													// now set Employee number value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(PhoneNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
											

												}catch(Exception error){}
										} catch (Exception e) {
											System.out.println("unable to get inner field");
										}
									}
								}
							}
							
							
							
							// set data for forth row...
							else if(AttributeId.equals("GetCustomFieldId")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);

								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										//
										try {
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	empAdvancedSearchXPath.replace("xx", Integer.toString(j))+"/div"+"["+i+"]"+ "//*[@name]";
											System.out.println("inner xpath: "+inner_xpath);
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												if(atrbut_id.equals("GetCustomFieldId")){
													// now set BalNumber value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(GovtReceiptIDNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("CustomFieldValue")){
													// now set Custom Field Value 
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(CustomFieldValue);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}


												}catch(Exception error){}
										} catch (Exception e) {
											System.out.println("unable to get inner field");
										}
									}
								}
							}
							
							
							// set data for fifth row...
							else if(AttributeId.equals("divCustomField")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);

								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										//
										try {
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	empAdvancedSearchXPath.replace("xx", Integer.toString(j))+"/div"+"["+i+"]"+ "//*[@name]";
											System.out.println("inner xpath: "+inner_xpath);
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												if(atrbut_id.equals("GetCustomFieldId")){
													// now set BalNumber value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(GovtReceiptIDNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}
												else if(atrbut_id.equals("CustomFieldValue")){
													// now set Custom Field Value 
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(CustomFieldValue);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
												}


												}catch(Exception error){}
										} catch (Exception e) {
											System.out.println("unable to get inner field");
										}
									}
								}
							}
							
							
						}catch(Exception e){
							System.out.println("unable to get attribute id");
						}
						
					}	
				}
				}catch(Exception w){
					System.out.println("unable to get row xpath");
				}
				
				String Add_ContactXpath =".//a[contains(@class,'btn')]//.[(text()='Add Contact ')]";
				
				try {
					Thread.sleep(1000);
					utilfunc.MakeElement(Add_ContactXpath).click();
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Unable to click on the Add contact button.");
				}
				
                try{
				startTime = System.currentTimeMillis();
				//utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
				flag	=	obj_CIMS_Company_Contacts.Company_Contacts("Test Company Data.xls","Contacts",1,"New");
				timer = utilfunc.getTimeTakenByModule(startTime);
			//	utilfunc.updateModuleDataForReportGeneration(filename, Employee_namecheck, timer);

				if (flag)
				{
					status="PASS";
					//passTestCaseCounter++;
					if(utilfunc.globalerrormessage.equals(""))
					{
						utilfunc.TestngReportPass(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio, ActionName, obj_CIMS_Company_Contacts.testcaseid, status);
					}else{
						utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Contacts.scenerio,ActionName,obj_CIMS_Company_Contacts.testcaseid, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
					}
					
					// pass dashboard report..
					if(passCounter==false){
						 try {	obj_Report_Dashboard.writeReportHeader("Test Company Data.xls","Contacts","Pass");} catch (Exception e) {}
						 passCounter=true;
					 }
					try {obj_Report_Dashboard.writeDashBoardPassReport("Test Company Data.xls","Contacts", obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio, ActionName, obj_CIMS_Company_Contacts.testcaseid, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+sheetName);}
				}else{
				status="FAIL";
					//;failTestCaseCounter++;
					//utilfunc.TakeScreenshot();
					utilfunc.TestngReportFail1(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio,ActionName, obj_CIMS_Company_Contacts.testcaseid, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
				
					// fail dashboard report..
					if(failCounter==false){
					obj_Report_Dashboard.writeReportHeader("Test Company Data.xls","Contacts","Fail");
					failCounter	= true;
					}
					try {obj_Report_Dashboard.writeDashBoardFailReport("Test Company Data.xls","Contacts", obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio,ActionName, obj_CIMS_Company_Contacts.testcaseid, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+sheetName);}
				}	
			}catch(Exception s){
				System.out.println("some error occured in : "+ sheetName);
				ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
				utilfunc.assertion();			
				utilfunc.TakeScreenshot();
			}
				
//			}

		}
		return flag;
	}
	public void setobj_CIMS_Company_Contacts(CIMS_Company_Contacts setobj_CIMS_Company_Contacts)
	{
		this.obj_CIMS_Company_Contacts=setobj_CIMS_Company_Contacts;
	}
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}
}
