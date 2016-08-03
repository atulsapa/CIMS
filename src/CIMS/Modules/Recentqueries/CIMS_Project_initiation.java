package CIMS.Modules.Recentqueries;

import java.awt.AWTException;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;
import CIMS.Modules.Regression.CIMS_MostRecentTopTen_project;
import CIMS.Modules.Regression.CIMS_MostRecent_project;
import CIMS.Reports.dashboard;

public class CIMS_Project_initiation {

	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	private CIMS_MostRecentTopTen_project   obj_CIMS_MostRecentTopTen_project;
	private CIMS_MostRecent_project   obj_CIMS_MostRecent_project;

	private dashboard 									obj_Report_Dashboard;
	private String ActionName;
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Project_initiation(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean initiation(String filename, String sheetName,int ColumnCounter,String mode, String EmployeeName) throws AWTException, InterruptedException{

			setobj_CIMS_MostRecent_project(new CIMS_MostRecent_project (webdriver,utilfunc));
			setobj_dashboard((new dashboard()));
			setobj_CIMS_MostRecentTopTen_project(new CIMS_MostRecentTopTen_project(webdriver,utilfunc) );
			
			
			boolean Flag	=	false;

			
			
			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Password							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String ConfirmPassword							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			String status;
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				// initialize variable that will be used again and again.. like , start time, end time, module name , etc..
				long startTime 								= 0;
				int count									= 0;	
				String AttributeName						=	"";
				String timer								=	"";
				
				
				boolean Mostrecent_NotassignFlag=false;
				boolean Mostrecent_PassFlag=false;
				boolean Mostrecent_FailFlag=false;
				boolean Mostrecent_NegativePassFlag=false;
				
				boolean Mostrecent_PassFlag2=false;
				boolean Mostrecent_FailFlag2=false;
				boolean Mostrecent_NegativePassFlag2=false;
				boolean Mostrecent_FailFlag1FINALREPORT=false;
				boolean Mostrecent_PassFlag1FINALREPORT=false;
				
				//Allocated
				
				boolean MostRecent_FlagStep1 = false;
				boolean MostRecent_FlagStep2 = false;
				
				// click on link
//				try{
//					Thread.sleep(1000);
//					utilfunc.MakeElement(Mostrecent_Xpath).click();
//					Thread.sleep(1000);
//				}catch(Exception e){
//					System.out.println("unable to click on employee icons");
//				}
				try{
					
					// Step 1 code Start here 
					

					try{
						MostRecent_FlagStep1	=	obj_CIMS_MostRecent_project.Most_Recent("Test Regression Suite Data.xls","Most Recent",1,"New");
					}catch(Exception e){}

					timer = utilfunc.getTimeTakenByModule(startTime);
					utilfunc.updateModuleDataForReportGeneration("Most Recent" + "User", EmployeeName, timer);
				//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

					if (MostRecent_FlagStep1)
					{
						status="PASS";
						//Mostrecent_passTestCaseCounter++;
						if(utilfunc.globalerrormessage.equals(""))
						{
							utilfunc.TestngReportPass(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status);
							// now write it in a pass file START...
							if(Mostrecent_PassFlag==false){
								try {	obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent"+ "User", "Pass");
								}catch(Exception e){}
								Mostrecent_PassFlag=true;
							}// now write it in a pass file ENDS...

							//Write Positive Pass dashboard report 
							try {
								obj_Report_Dashboard.writeDashBoardPassReport("Test Regression Suite Data.xls", EmployeeName, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status, timer);
							}catch(Exception e){
								System.out.println("unable to write dasboard pass report for : "+"Most Recent");}
						}
						else
						{
							utilfunc.TestngReportNegativePassTestcase(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw,obj_CIMS_MostRecent_project.scenerio,ActionName,obj_CIMS_MostRecent_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
							// now write it in a negative pass dashboard file START...
							if(Mostrecent_NegativePassFlag==false){
								try {	obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent","Negative Pass");
								}catch(Exception e){}
								Mostrecent_NegativePassFlag=true;
							}// now write it in a negative pass dashboard file ENDS...

							//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
							try {
								obj_Report_Dashboard.writeDashBoardNegativePassReport("Test Regression Suite Data.xls",EmployeeName,obj_CIMS_MostRecent_project.testcaseid,utilfunc.Actualbrw,obj_CIMS_MostRecent_project.scenerio,ActionName,obj_CIMS_MostRecent_project.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
							} catch (Exception e) {
								System.out.println("unable to write dasboard negative pass report for : "+ "Most Recent");}
						}
						/*											if(passCounter==false){
							try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
							passCounter=true;
						}
						try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, EmployeeName, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
						 */
					}
					else
					{
						status="FAIL";
					//	Mostrecent_failTestCaseCounter++;
						//									utilfunc.TakeScreenshot();
						utilfunc.TestngReportFail1(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
						// now write it in a fail dashboard file START...
						if(Mostrecent_FailFlag==false){
							try{ obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent"+ "User","Fail");
							}catch(Exception e){}
							Mostrecent_FailFlag= true;
						}// now write it in a fail dashboard file ENDS...
						try {
							obj_Report_Dashboard.writeDashBoardFailReport("Test Regression Suite Data.xls", EmployeeName, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
						} catch (Exception e) {
							System.out.println("unable to write dasboard fail report for : "+"Most Recent");}
						/*										if(failCounter==false){
							obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
							failCounter	= true;
						}
						try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, EmployeeName, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
						 */
					}
				}catch(Exception e){
					ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
					System.out.println("Script Failed");
					utilfunc.assertion();			
					utilfunc.TakeScreenshot();
				}
				
				// Step 1 code end here
				
				
				// Step 2 code Start here
				
//				try{
//					Thread.sleep(1000);
//					utilfunc.MakeElement(Mostrecent_Xpath).click();
//					Thread.sleep(1000);
//				}catch(Exception e){
//					System.out.println("unable to click on employee icons");
//				}
				
				Thread.sleep(3000);
				startTime = System.currentTimeMillis();
				try{
					MostRecent_FlagStep2	=	obj_CIMS_MostRecentTopTen_project.Most_Recent("Test Regression Suite Data.xls","Most Recent",1,"New");
					timer = utilfunc.getTimeTakenByModule(startTime);
					utilfunc.updateModuleDataForReportGeneration("Most Recent"+" Project", EmployeeName, timer);
					if (MostRecent_FlagStep2)
					{
						status="PASS";
						if(utilfunc.globalerrormessage.equals(""))
						{
							utilfunc.TestngReportPass(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status);
							// now write it in a pass file START...
							if(Mostrecent_PassFlag2==false){
								try {	obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent"+" Project", "Pass");
								}catch(Exception e){}
								Mostrecent_PassFlag2=true;
							}// now write it in a pass file ENDS...

							//Write Positive Pass dashboard report 
							try {
								obj_Report_Dashboard.writeDashBoardPassReport("Test Regression Suite Data.xls", EmployeeName, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer);
							}catch(Exception e){
								System.out.println("unable to write dasboard pass report for : "+"Most Recent"+" -Questionnaires for Employee");}
						}
						else
						{
							utilfunc.TestngReportNegativePassTestcase(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw,obj_CIMS_MostRecentTopTen_project.scenerio,ActionName,obj_CIMS_MostRecentTopTen_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
							// now write it in a negative pass dashboard file START...
							if(Mostrecent_NegativePassFlag2==false){
								try {	obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent"+" Project","Negative Pass");
								}catch(Exception e){}
								Mostrecent_NegativePassFlag2=true;
							}// now write it in a negative pass dashboard file ENDS...

							//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
							try {
								obj_Report_Dashboard.writeDashBoardNegativePassReport("Test Regression Suite Data.xls",EmployeeName,obj_CIMS_MostRecentTopTen_project.testcaseid,utilfunc.Actualbrw,obj_CIMS_MostRecentTopTen_project.scenerio,ActionName,obj_CIMS_MostRecentTopTen_project.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
							} catch (Exception e) {
								System.out.println("unable to write dasboard negative pass report for : "+ "Most Recent"+" -Questionnaires for Employee");}
						}
						/*	if(passCounter==false){
						try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
						passCounter=true;
					}
					try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, EmployeeName, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}*/
					}
					else
					{
						status="FAIL";
						utilfunc.TakeScreenshot();
						utilfunc.TestngReportFail1(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
						// now write it in a fail dashboard file START...
						if(Mostrecent_FailFlag2==false){
							try{ obj_Report_Dashboard.writeReportHeader("Test Regression Suite Data.xls","Most Recent"+" Project","Fail");
							}catch(Exception e){}
							Mostrecent_FailFlag2= true;
						}// now write it in a fail dashboard file ENDS...
						try {
							obj_Report_Dashboard.writeDashBoardFailReport("Test Regression Suite Data.xls", EmployeeName, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
						} catch (Exception e) {
							System.out.println("unable to write dasboard fail report for : "+"Most Recent"+" -Questionnaires for Employee");}
						/*if(failCounter==false){
						obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
						failCounter	= true;
					}
					try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, EmployeeName, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}*/
					}
				}catch(Exception e){
					ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
					System.out.println("Script Failed");
					utilfunc.assertion();			
					utilfunc.TakeScreenshot();
				}

			}
			return Flag;
}

		public void setobj_CIMS_MostRecent_project(CIMS_MostRecent_project setobj_CIMS_MostRecent_project) {
			this.obj_CIMS_MostRecent_project = setobj_CIMS_MostRecent_project;
		}
		
		public void setobj_CIMS_MostRecentTopTen_project(CIMS_MostRecentTopTen_project setobj_CIMS_MostRecentTopTen_project) {
			this.obj_CIMS_MostRecentTopTen_project = setobj_CIMS_MostRecentTopTen_project;
		}
		// dashboard report
		public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
			this.obj_Report_Dashboard = setobj_Report_Dashboard;
		}
		


}
