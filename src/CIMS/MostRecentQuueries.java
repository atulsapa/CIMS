package CIMS;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CIMS.Modules.Advanced.Project_Search;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Recentqueries.CIMS_Home_Page_Module;
import CIMS.Modules.Recentqueries.CIMS_Project_initiation;
import CIMS.Modules.Recentqueries.CIMS_Recent_Project_Summary;
import CIMS.Reports.dashboard;
import listner.ErrorUtil;
import util.RunMode;
import util.UtilFunction;

public class MostRecentQuueries {
	
	
	private String 										sysDate;
	private WebDriver 									webdriver;		
	private UtilFunction 								utilfunc;		
	private CIMS_Login 									obj_CIMS_Login;

	//private Employee_Search								obj_Employee_Search;
	
	private dashboard 									obj_Report_Dashboard;
	private Project_Search								obj_Project_Search;
//	private CIMS_Regression_Suite_Employee_Profile		obj_CIMS_Regression_Suite_Employee_Profile;
	
	private CIMS_Home_Page_Module                       obj_CIMS_Home_Page_Module;
	private CIMS_Project_initiation                      obj_CIMS_Project_initiation; 
	private CIMS_Recent_Project_Summary                 obj_CIMS_Recent_Project_Summary;
	

	
	//file name that takes dynamically in all modules.
		public static String ExcelFileName="Test data Most Recent.xls";
		public static String suiteName="Most Recent queries";
		public String sheetName="URLANDNAME";
		public static String os=System.getProperty("os.name");
		public static String osbit=System.getProperty("sun.arch.data.model");
		public static String moduleName="";
		public static String Employee_namecheck=null;
		public static String questionarie_name1="";
		public static String timer;
		private String columnNameRM="RUNMODE";
		private String columnNameAction="ACTION";
		
		private static String Employeebuttonlinktext="Employees";
		private static String Employeename=".//*[@id='SearchText']";
		private static String Employeesearch=".//*[@id='btnSearch']";
		private static String sidebarxpath=".//*[@id='slider-icon']";
		private static String employeexpath= ".//*[@id='visacase-list-header']/tbody/tr[1]/td[2]/a";
		private static String projectbutton=".//*[@id='anchorProject']";
		private static String projectreference=".//*[@id='caseNumber']";
		private static String buttonprojectsearch=".//*[@id='btnSearchProject']";
		private static String profileQuestionaireEmployeeerecord=".//*[@id='dvUserList']//*[@class='table-rec-container']/table[1]/tbody/tr[1]/td[1]/a";
		
		public static String SelectQuestionnairetype	=		"";

		public static String Questionnaire_Name_array[]=new String [100];
		
		//timer
		StopWatch pageLoad = new StopWatch();
		

		@BeforeClass
		public void isSkipped(){

			if(RunMode.isSkip(ExcelFileName,this.getClass().getName())){
				Reporter.log("");
				Reporter.log(this.getClass().getName()+" Test is Skipped Intentionally.");
				Reporter.log("");
				Reporter.log("This Test will be Skipped as Run Mode is set 'No' in the Test Data Excel Sheet.");
				throw new SkipException("Test will be Skiped as Run Mode is Set to 'N' in Test Data xls File.");
			}
			else {	

				//				System.out.println("browser:  "+UtilFunction.getBrowser(this.getClass().getName()));
				setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
				setSysDate(UtilFunction.currentDateTime());				
				setUtilfunc(new UtilFunction(this.getDriver()));	
				setobj_CIMS_Login(new CIMS_Login(webdriver, utilfunc));
				setobj_dashboard((new dashboard()));
				setobj_Project_Search(new Project_Search(webdriver,utilfunc));
				setobj_CIMS_Home_Page_Module(new CIMS_Home_Page_Module(webdriver,utilfunc));
				setobj_CIMS_Project_initiation(new CIMS_Project_initiation(webdriver,utilfunc));
                setobj_CIMS_Recent_Project_Summary(new CIMS_Recent_Project_Summary(webdriver,utilfunc));			

				if(UtilFunction.Actualbrw.equals("IE")){
					webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				}else if(UtilFunction.Actualbrw.equals("CHROME")){
					webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				}else{
					webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				}
				Reporter.log("");
				Reporter.log("***************************Opening the Application*********************************");

				boolean StartApplicationFlag = utilfunc.startApplication(ExcelFileName);
				if(!StartApplicationFlag){
					Reporter.log("User is not able to Open the application");
				}
				else {
					Reporter.log("Opened the Application URL Successfully");
				}
			}
		}
		


		@AfterMethod
		public void closeBrowser() {
			Reporter.log("Closing Opened Browser");
			boolean CloaseBrowserFlag = utilfunc.closeWebDriver();		
			if(!CloaseBrowserFlag){
				Reporter.log("User is not able to close the application");
			}
			else {
				Reporter.log("Closed the application.");
			}

		}



		//Our Test start from here.
@Test

public void CIMSWebAccess() throws InterruptedException, IOException, AWTException {
			
			            try {
							// Project  Login	
							obj_CIMS_Login.Project_login(ExcelFileName);

							//Welcome page
							obj_CIMS_Login.Welcome_Page();
							
							
							//privacy disclaimer check
							try{

								String check=".//*[@id='chkConfirm']";
								String Agreebutton=".//*[@id='btnNext']";

								utilfunc.MakeElement(check).click();                               
								utilfunc.MakeElement(Agreebutton).click();

							}catch(Exception e){
								System.out.println("Privacy policy Disclaimer is not Exist on the Page");
							}

							// let us zoom out 2-3 times of current screen so that slider icon is never missed out while switching any module

							utilfunc.zoomOut(3);

							//Getting employee Name
							try{
								utilfunc.MakeElement("//*[@id='user-profile']").click();
								Employee_namecheck				=	utilfunc.MakeElement(".//*[@id='user-name']").getText();
								Thread.sleep(400);
								utilfunc.MakeElement("//*[@id='user-profile']").click();
								System.out.println(Employee_namecheck);
							}catch(Exception e){
								System.out.println("Unable to find Employee name and using username instead");	
							}
							
							//initialize variables that will be used..

							boolean visitSPILink					=	false;
							boolean	openSuite						=	false;
							boolean Page_flag						=	false;
							String fileName							=	ExcelFileName;
							String suiteLink						=	"";
							String status							=	"";
							long startTime							=	0;
							String MenuLink								=	"";
							boolean employeeSearchFlag				=	false;
							String IdentifyIE						=	"";
							String []	EmpDependantSuiteName		=	{"Project Summary","Account Locaked"};
							long startTotalTime						=	0;
							String TotalTime						=	"";

							//Lokesh add these lines for get count of +ve and -ve test cases.
							int PositiveScenarioCounter				=	0;
							int NegativeScenarioCounter				=	0;
							int ModuleCounter						=	0;
							int TotalTestCaseCounter				=	0;
							int passTestCaseCounter					=	0;
							int failTestCaseCounter					=	0;
							int NotAssignedModuleCounter			=	0;
							
							ArrayList NumberOfNotAssignModule = new ArrayList();

							// let us choose Regrssion suites from excel with Run mode Yes 
							String 	Mostrecentmodule				    =		"Most Recent queries";
							int RowCount							=		UtilFunction.usedRowCount(fileName, Mostrecentmodule);
							int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, Mostrecentmodule, columnNameRM);
							int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, Mostrecentmodule, columnNameAction);
							int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, Mostrecentmodule, "Suite Name");

                            String SlidericonXpath=".//*[@id='slider-icon']";
							startTotalTime = System.currentTimeMillis(); 

							for(int modCounter = 1;modCounter<RowCount;modCounter++){
								try{
									
									boolean passCounter	=	false;
									boolean failCounter	=	false;
									boolean negativePassCounter=false;
									
									
									if(UtilFunction.getCellData(fileName, Mostrecentmodule, columnNumber_RUNMODE, modCounter).equals("Y")){
										ModuleCounter=ModuleCounter+1;
										// now pick the name of regression suite, action, etc that is set to runmode Y

										String SuiteName				=		UtilFunction.getCellData(fileName, Mostrecentmodule, columnNumber_SuiteName, modCounter);
										String ActionName				=		UtilFunction.getCellData(fileName, Mostrecentmodule, columnNumber_ACTION, modCounter);


										System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName);

										// let uss search for employee for modules like Immigration status, document, profile.. etc
										if(Arrays.asList(EmpDependantSuiteName).contains(SuiteName)){

											String empSheetName				=		"Employee Profile";
											String Employee_search			=		"";

											int rowCountemployeesearch		=		UtilFunction.usedRowCount(fileName,empSheetName);
											int RUNMODEemployeesearch		=		UtilFunction.getColumnWithCellData(fileName, empSheetName, "RUNMODE");
											String columnNameEN				=		"EMPLOYEE NAME";
											int Employee_name				=		UtilFunction.getColumnWithCellData(fileName, empSheetName, columnNameEN);
											String columnNameES				=		"EMPLOYEE Reference Number";
											int Employee_search_name		=		UtilFunction.getColumnWithCellData(fileName, empSheetName, columnNameES);
											String columnNameSQT			=		"QUESTIONNAIRE TYPE";
											int Questionnairetype			=		UtilFunction.getColumnWithCellData(fileName, empSheetName, columnNameSQT);


											for(int j = 1;j<rowCountemployeesearch;j++){

												if(UtilFunction.getCellData(fileName, empSheetName, RUNMODEemployeesearch,j).equals("Y") && employeeSearchFlag==false){



													System.out.println("second loop ran for "+j+" time");

													try{
														Thread.sleep(3000);
														Employee_namecheck			=			UtilFunction.getCellData(fileName, empSheetName, Employee_name, j);
														Employee_search				=			UtilFunction.getCellData(fileName, empSheetName, Employee_search_name, j);
														SelectQuestionnairetype		=			UtilFunction.getCellData(fileName, empSheetName, Questionnairetype, j);

														try {
															searchemployee(Employee_namecheck, Employee_search);
															/*System.out.println("current url"+utilfunc.getPageUrl());
													if(utilfunc.getPageUrl().contains("Profile")){
														employeeSearchFlag	=	true;
													}*/
														} catch (Exception e) {
															// TODO: handle exception
														}

													}catch(Exception e){
														System.out.println("employee search falied.."+ e);
													}
												}
											}				

										}
										
										


										// now check module run modes with Y.. and call module objects..

										String sheetName					=	SuiteName;
										int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
										int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
										int Scenariocol=0;
												    			
										for(int count=1; count<rowCount; count++)
										{
											
											

											if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){
												String Scenariotext="";
												
													if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
														PositiveScenarioCounter++;
													}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
														NegativeScenarioCounter++;
													}
													
													
													Thread.sleep(5000);
													try {
														Thread.sleep(1500);
														utilfunc.MakeElement(SlidericonXpath).click();
													} catch (Exception e1) {
														System.out.println("unable to click on the link");
													}
													
												
												if(SuiteName.equals("Home Page"))
												{

												
												  String HomePage =".//*[@id='logo']/a";
												  
												  try {
													  Thread.sleep(1000);
													utilfunc.MakeElement(HomePage).click();
													Thread.sleep(1000);
												} catch (Exception e1) {
													System.out.println("Unable to click on the home page");
												}

													try{
														startTime = System.currentTimeMillis();
														Page_flag	=	obj_CIMS_Home_Page_Module.HomePage(fileName,SuiteName,count,ActionName,Employee_namecheck);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw,obj_CIMS_Home_Page_Module.scenerio, ActionName,obj_CIMS_Home_Page_Module.description, status);
																
																// now write it in a pass file..
																if(passCounter==false){
																	 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Pass");} catch (Exception e) {}
																	 passCounter=true;
																 }
																try {obj_Report_Dashboard.writeDashBoardPassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Page_Module.scenerio, ActionName, obj_CIMS_Home_Page_Module.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw,obj_CIMS_Home_Page_Module.scenerio,ActionName,obj_CIMS_Home_Page_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Negative Pass");} catch (Exception e) {}
																	 negativePassCounter=true;
																 }
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw,obj_CIMS_Home_Page_Module.scenerio,ActionName,obj_CIMS_Home_Page_Module.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

															}
															
															
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															//													utilfunc.TakeScreenshot();
															utilfunc.TestngReportFail1(obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw,obj_CIMS_Home_Page_Module.scenerio,ActionName,obj_CIMS_Home_Page_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														
															// now write it in a fail dashboard file..
															if(failCounter==false){
									    						obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Fail");
									    						failCounter	= true;
								    						}
															try {obj_Report_Dashboard.writeDashBoardFailReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Home_Page_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Page_Module.scenerio, ActionName, obj_CIMS_Home_Page_Module.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
														}
													}catch(Exception s){
														System.out.println("some error occured in : "+ SuiteName);
														
													}
												
												
													
											
												
												
													
													
													
												}
												
												
												
												else if(SuiteName.equals("Initiation")){


													
													  String Initiate =".//*[@id='divisNotIE8']/a";
													  
													  try {
														  Thread.sleep(1000);
														utilfunc.MakeElement(Initiate).click();
														Thread.sleep(1000);
													} catch (Exception e1) {
														System.out.println("Unable to click on the home page");
													}

														try{
															startTime = System.currentTimeMillis();
															Page_flag	=	obj_CIMS_Project_initiation.initiation(fileName,SuiteName,count,ActionName,Employee_namecheck);
															timer = utilfunc.getTimeTakenByModule(startTime);
															utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
															if (Page_flag)
															{
																status="PASS";passTestCaseCounter++;
																if(utilfunc.globalerrormessage.equals(""))
																{
																	utilfunc.TestngReportPass(obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_initiation.scenerio, ActionName,obj_CIMS_Project_initiation.description, status);
																	
																	// now write it in a pass file..
																	if(passCounter==false){
																		 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Pass");} catch (Exception e) {}
																		 passCounter=true;
																	 }
																	try {obj_Report_Dashboard.writeDashBoardPassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_initiation.scenerio, ActionName, obj_CIMS_Project_initiation.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

																}
																else
																{
																	utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_initiation.scenerio,ActionName,obj_CIMS_Project_initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																	// now write it in a negative pass dashboard file..
																	if(negativePassCounter==false){
																		 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Negative Pass");} catch (Exception e) {}
																		 negativePassCounter=true;
																	 }
																	try {obj_Report_Dashboard.writeDashBoardNegativePassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_initiation.scenerio,ActionName,obj_CIMS_Project_initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																	catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

																}
																
																
															}
															else
															{
																status="FAIL";failTestCaseCounter++;
																//													utilfunc.TakeScreenshot();
																utilfunc.TestngReportFail1(obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_initiation.scenerio,ActionName,obj_CIMS_Project_initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															
																// now write it in a fail dashboard file..
																if(failCounter==false){
										    						obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Fail");
										    						failCounter	= true;
									    						}
																try {obj_Report_Dashboard.writeDashBoardFailReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Project_initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_initiation.scenerio, ActionName, obj_CIMS_Project_initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
															}
														}catch(Exception s){
															System.out.println("some error occured in : "+ SuiteName);
															
														}
													
													
														
												
													
													
														
														
														
													
													
													
												}
												
												else if(SuiteName.equals("Project Summary")){



													
													  String Initiate =".//*[@id='divisNotIE8']/a";
													  
													  try {
														  Thread.sleep(1000);
														utilfunc.MakeElement(Initiate).click();
														Thread.sleep(1000);
													} catch (Exception e1) {
														System.out.println("Unable to click on the home page");
													}

														try{
															startTime = System.currentTimeMillis();
															Page_flag	=	obj_CIMS_Recent_Project_Summary.Projectsummary(fileName,SuiteName,count,ActionName,Employee_namecheck);
															timer = utilfunc.getTimeTakenByModule(startTime);
															utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
															if (Page_flag)
															{
																status="PASS";passTestCaseCounter++;
																if(utilfunc.globalerrormessage.equals(""))
																{
																	utilfunc.TestngReportPass(obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Recent_Project_Summary.scenerio, ActionName,obj_CIMS_Recent_Project_Summary.description, status);
																	
																	// now write it in a pass file..
																	if(passCounter==false){
																		 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Pass");} catch (Exception e) {}
																		 passCounter=true;
																	 }
																	try {obj_Report_Dashboard.writeDashBoardPassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Recent_Project_Summary.scenerio, ActionName, obj_CIMS_Recent_Project_Summary.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

																}
																else
																{
																	utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Recent_Project_Summary.scenerio,ActionName,obj_CIMS_Recent_Project_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																	// now write it in a negative pass dashboard file..
																	if(negativePassCounter==false){
																		 try {	obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Negative Pass");} catch (Exception e) {}
																		 negativePassCounter=true;
																	 }
																	try {obj_Report_Dashboard.writeDashBoardNegativePassReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Recent_Project_Summary.scenerio,ActionName,obj_CIMS_Recent_Project_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																	catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

																}
																
																
															}
															else
															{
																status="FAIL";failTestCaseCounter++;
																//													utilfunc.TakeScreenshot();
																utilfunc.TestngReportFail1(obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Recent_Project_Summary.scenerio,ActionName,obj_CIMS_Recent_Project_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															
																// now write it in a fail dashboard file..
																if(failCounter==false){
										    						obj_Report_Dashboard.writeReportHeader(Mostrecentmodule, sheetName,"Fail");
										    						failCounter	= true;
									    						}
																try {obj_Report_Dashboard.writeDashBoardFailReport(Mostrecentmodule, Employee_namecheck, obj_CIMS_Recent_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Recent_Project_Summary.scenerio, ActionName, obj_CIMS_Recent_Project_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
															}
														}catch(Exception s){
															System.out.println("some error occured in : "+ SuiteName);
															
														}
													
													
														
												
													
													
														
														
														
													
													
													
												}
												

											

												
											
												
											}
										}

									}

									
									}catch(Exception e){
									
								}
								
								
							}
							LinkedHashSet<String> lhs = new LinkedHashSet<String>();
							lhs.addAll(NumberOfNotAssignModule);
							NumberOfNotAssignModule.clear();
							NumberOfNotAssignModule.addAll(lhs);
							NotAssignedModuleCounter=NumberOfNotAssignModule.size();
							
							System.out.println("========\n========\n========");
							System.out.println("PositiveScenarioCounter : "+PositiveScenarioCounter);
							System.out.println("NegativeScenarioCounter : "+NegativeScenarioCounter);
							System.out.println("ModuleCounter : "+ModuleCounter);
							System.out.println("TotalTestCaseCounter : "+TotalTestCaseCounter);
							System.out.println("passTestCaseCounter : "+passTestCaseCounter);
							System.out.println("failTestCaseCounter : "+failTestCaseCounter);
							System.out.println("NotAssignedModuleCounter : "+NotAssignedModuleCounter);
							System.out.println("========\n========\n========");

							// adding dashboard code here..
							String PositiveScenarioCount="";
							String NegativeScenarioCount="";
							String ModuleCount="";
							String TotalTestCaseCount="";
							String FinalPositiveCount="";
							String FinalNegativeCount="";
							String NotAssignedModuleCount="";

							try{	PositiveScenarioCount			=	Integer.toString(PositiveScenarioCounter);	}catch(Exception error){}
							try{	NegativeScenarioCount			=	Integer.toString(NegativeScenarioCounter);	}catch(Exception error){}
							try{	ModuleCount						=	Integer.toString(ModuleCounter);			}catch(Exception error){}
							try{	TotalTestCaseCount				=	Integer.toString(TotalTestCaseCounter);	}catch(Exception error){}
							try{	FinalPositiveCount				=	Integer.toString(passTestCaseCounter);	}catch(Exception error){}
							try{	FinalNegativeCount				=	Integer.toString(failTestCaseCounter);	}catch(Exception error){}
							try{	NotAssignedModuleCount			=	Integer.toString(NotAssignedModuleCounter);	}catch(Exception error){}

						//	utilfunc.TestngDashBoardReport("Left Navigation",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,FinalPositiveCount,FinalNegativeCount,NotAssignedModuleCount);
							TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
							try{
								obj_Report_Dashboard.generateReportForSuite(Mostrecentmodule,ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
									FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
							}catch(Exception e){
								System.out.println("unable to call & generate dashboard report for regression..");
							}


							
							
						} catch (Exception e) {
							ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
							System.out.println("Script Failed!!!");
							utilfunc.assertion();
							utilfunc.TakeScreenshot();
							
							
						}
			
			
		}
		
		public String getSysDate() {
			return sysDate;
		}
		public WebDriver getDriver() {
			return webdriver;
		}
		public void setDriver(String browser) {
			this.webdriver = UtilFunction.getDriver(browser);
		}
		public void setSysDate(String sysdate) {
			this.sysDate = sysdate ;
		}
		public UtilFunction getUtilfunc() {
			return utilfunc;
		}

		public void setUtilfunc(UtilFunction utilfunc) {
			this.utilfunc = utilfunc;
		}
		public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
			this.obj_CIMS_Login = setobj_CIMS_Login;
		}

		public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
			this.obj_Report_Dashboard = setobj_Report_Dashboard;
		}
	
		
		public void setobj_Project_Search(Project_Search setobj_Project_Search){
			this.obj_Project_Search	=	setobj_Project_Search;
			}
			
		public void setobj_CIMS_Home_Page_Module(CIMS_Home_Page_Module setobj_CIMS_Home_Page_Module){
			this.obj_CIMS_Home_Page_Module	=	setobj_CIMS_Home_Page_Module;
			}
		
		public void setobj_CIMS_Project_initiation(CIMS_Project_initiation setobj_CIMS_Project_initiation){
			this.obj_CIMS_Project_initiation	=	setobj_CIMS_Project_initiation;
			}
		
		public void setobj_CIMS_Recent_Project_Summary(CIMS_Recent_Project_Summary setobj_CIMS_Recent_Project_Summary){
			this.obj_CIMS_Recent_Project_Summary	=	setobj_CIMS_Recent_Project_Summary;
			}
		
		
		
		
		
		

		
		
		
		

		String EmployeeNamexpath="//*[@id='SearchText']";

		public void searchemployee(String Employeenamecheck,String Employeesearchname){
			System.out.println("");
			System.out.println("-------------------------------CIMS EMPLOYEE SEARCHING---------------------------");
			try{

				utilfunc.LinkText(Employeebuttonlinktext).click();
				if(SelectQuestionnairetype.equalsIgnoreCase("Project")){
					utilfunc.MakeElement(projectbutton).click();
					utilfunc.MakeElement(projectreference).sendKeys(Employeesearchname);
					utilfunc.MakeElement(buttonprojectsearch).click();
					Thread.sleep(5000);
				}
				else if(SelectQuestionnairetype.equalsIgnoreCase("Profile")){
					utilfunc.MakeElement(EmployeeNamexpath).sendKeys(Employeenamecheck);
					utilfunc.MakeElement(Employeesearch).click();
					Thread.sleep(5000);
				}

				

				
				try {
					if(SelectQuestionnairetype.equalsIgnoreCase("Project"))
					{
						utilfunc.MakeElement(employeexpath).click();
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					System.out.println("unable to get project link");
				}
				
				try {
					if(SelectQuestionnairetype.equalsIgnoreCase("PROFILE"))
					{
						utilfunc.MakeElement(profileQuestionaireEmployeeerecord).click();
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					System.out.println("unable to get profile link");
				}

				/////DEV///
				/* utilfunc.LinkText(Employeebuttonlinktext1).click();
				 utilfunc.MakeElement(projectreference).sendKeys(Employeesearchname);
				 utilfunc.MakeElement(buttonprojectsearch1).click();
				 Thread.sleep(5000);
				 utilfunc.MakeElement(employeexpath).click();*/


			}catch(Exception e){

				try{
					String Menuxpath=".//*[@class='gn-icon gn-icon-menu']";
					utilfunc.MakeElement(Menuxpath).click();
					
					try {
						String SubMenuProfilexpath=".//*[@class='gn-submenu']/li[2]/a";
						utilfunc.MakeElement(SubMenuProfilexpath).click();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("unable to find & click on project search sub menu of main menu");
					}

					try {
						utilfunc.MakeElement(".//*[@class='gn-submenu']//*/a[contains(text(),'Project Search')]").click();
					} catch (Exception e1) {
						System.out.println("unable to find project search link");
					}
					
				}catch(Exception f){
					ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
					System.out.println("NOT ABLE TO FOUND THE USER");
					utilfunc.assertion();			
					utilfunc.TakeScreenshot();
				}

			}


		}


		



}
