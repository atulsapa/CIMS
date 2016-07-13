package CIMS;


import java.awt.AWTException;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.WinUser.FLASHWINFO;
import com.sun.rmi.rmid.ExecPermission;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;












//import util.Email;
import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Questionnaires.Project_Initiation;
import CIMS.Modules.Advanced.*;
import CIMS.Modules.Regression.*; 
import CIMS.Reports.*;


@SuppressWarnings("deprecation")
public class CIMS_EmployeeProfile {

	private String 										sysDate;
	private WebDriver 									webdriver;		
	private UtilFunction 								utilfunc;		
	private CIMS_Login 									obj_CIMS_Login;
	private Employee_Search								obj_Employee_Search;
	
	private CIMS_Regression_Suite_Employee_Profile		obj_CIMS_Regression_Suite_Employee_Profile;
	private dashboard 									obj_Report_Dashboard;
	
	//file name that takes dynamically in all modules.
	public static String ExcelFileName="Test EmployeeProfile Data.xls";
	public static String suiteName		=	"Modules";
	public static String suiteName1		=	"Employee Profile";
	public String sheetName="URLANDNAME";
	public static String os=System.getProperty("os.name");
	public static String osbit=System.getProperty("sun.arch.data.model");
	public static String moduleName="";
	public static String Employee_namecheck=null;
	public static String  loginusername=null;
	public static String  Employee_Profilename=null;
	public static String empSheetName	=	"";
	public static String questionarie_name1="";
	public static String timer;
	private String columnNameRM="RUNMODE";
	private String columnNameAction="ACTION";
	public static String SuiteNameEmpProfile		=	"";

	public static String SelectQuestionnairetype	=		"";
	ArrayList NumberOfNotAssignModule = new ArrayList();
	public static String Questionnaire_Name_array[]=new String [100];

	static int instanceCounter = 0;
	static int instanceCounter1 = 0;
	static int counter1 = 0;
	//timer
	StopWatch pageLoad = new StopWatch();


	//Initiate the class Before TEST method
	@SuppressWarnings("static-access")
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

			setobj_CIMS_Regression_Suite_Employee_Profile(new CIMS_Regression_Suite_Employee_Profile(webdriver, utilfunc));
			setobj_Employee_Search(new Employee_Search(webdriver,utilfunc));

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
	public void CIMSSingleProjectInitiation() throws InterruptedException, IOException, AWTException {
		try {			
			obj_CIMS_Login.Project_login();// Project  Login	
			obj_CIMS_Login.Welcome_Page();//Welcome page

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
				loginusername					=	utilfunc.MakeElement(".//*[@id='user-name']").getText();
				Thread.sleep(400);
				utilfunc.MakeElement("//*[@id='user-profile']").click();
				System.out.println(Employee_namecheck+"\n"+"Employee Profile");
				
			}catch(Exception e){
				System.out.println("Unable to find Employee name and using username instead");	
			}

			/**
			 * code for regression suite starts here
			 * @author Brij
			 */

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
			String EmpDependantSuiteName			=	"Employee Profile";
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

			
			

			//for Employee Profile
			int EmployeeProfile_PositiveScenarioCounter	=	0;
			int EmployeeProfile_NegativeScenarioCounter	=	0;
			int EmployeeProfile_TotalTestCaseCounter		=	0;
			int EmployeeProfile_passTestCaseCounter		=	0;
			int EmployeeProfile_failTestCaseCounter		=	0;
			int EmployeeProfile_NotAssignedModuleCounter	=	0;
			int EmployeeProfile_ModuleCounter				=	1;

			boolean passCounter	=	false;
			boolean failCounter	=	false;
			boolean notAssignedCounter	=	false;
			boolean negativePassCounter=false;

			// let us choose Regrssion suites from excel with Run mode Yes 
			String 	EmployeeProfile				=		"Modules";
			int RowCount							=		UtilFunction.usedRowCount(fileName, EmployeeProfile);
			int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, EmployeeProfile, columnNameRM);
			int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, EmployeeProfile, columnNameAction);
			int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, EmployeeProfile, "Suite Name");
			System.out.println("We are ready...");

			//for generate dashboard report
			Set<String> hs = new HashSet<>();
			ArrayList<String> al=new ArrayList<String>();

			startTotalTime = System.currentTimeMillis();
			// loop running for regression suites
			for(int modCounter = 1;modCounter<RowCount;modCounter++){
				Thread.sleep(300);
				try{
					
					passCounter	=	false;
					failCounter	=	false;
					notAssignedCounter	=	false;
					negativePassCounter=false;					
					System.out.println("All Flags are set to false at loop\'s "+modCounter+" Value.");


					// check if current suite name is set to runmode Y..
					if(UtilFunction.getCellData(fileName, EmployeeProfile, columnNumber_RUNMODE, modCounter).equals("Y")){
						ModuleCounter=ModuleCounter+1;

						// now pick the name of regression suite, action, etc that is set to runmode Y
						String SuiteName				=		UtilFunction.getCellData(fileName, EmployeeProfile, columnNumber_SuiteName, modCounter);
						String ActionName				=		UtilFunction.getCellData(fileName, EmployeeProfile, columnNumber_ACTION, modCounter);
						al.add(SuiteName);
						System.out.println("=======================================\nSheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName+"\n=======================================");

						// let uss search for employee for modules like Immigration status, document, profile.. etc
						if(EmpDependantSuiteName.contains(SuiteName)){
							//if suitename is depend on employee search then Employee name will be chnaged with the name of employee search

							empSheetName				=		"Employee Profile";
							String Employee_search			=		"";
							int rowCountemployeesearch		=		UtilFunction.usedRowCount(fileName,SuiteName);
							int RUNMODEemployeesearch		=		UtilFunction.getColumnWithCellData(fileName, SuiteName, "RUNMODE");
							String columnNameEN				=		"EMPLOYEE NAME";
							int Employee_name				=		UtilFunction.getColumnWithCellData(fileName, SuiteName, columnNameEN);
							String columnNameES				=		"EMPLOYEE Reference Number";
							int Employee_search_name		=		UtilFunction.getColumnWithCellData(fileName, SuiteName, columnNameES);
							String columnNameSQT			=		"QUESTIONNAIRE TYPE";
							int Questionnairetype			=		UtilFunction.getColumnWithCellData(fileName, SuiteName, columnNameSQT);

							for(int j = 1;j<rowCountemployeesearch;j++){
								try{
									ArrayList NumberOfNotAssignModule = new ArrayList();
									if(UtilFunction.getCellData(fileName, SuiteName, RUNMODEemployeesearch,j).equals("Y") && employeeSearchFlag==false){

										System.out.println("second loop ran for "+j+" time");
										try{
											Thread.sleep(3000);
											Employee_namecheck			=			UtilFunction.getCellData(fileName, SuiteName, Employee_name, j);		
											Employee_Profilename		=			UtilFunction.getCellData(fileName, SuiteName, Employee_name, j);		
											Employee_search				=			UtilFunction.getCellData(fileName, SuiteName, Employee_search_name, j);
											SelectQuestionnairetype		=			UtilFunction.getCellData(fileName, SuiteName, Questionnairetype, j);
											System.out.println("Employee Searched for "+Employee_namecheck+ " for "+SuiteName+" Module with "+SelectQuestionnairetype);
											try {
												//obj_CIMS_Login.searchemployee(Employee_namecheck, Employee_search);
												obj_CIMS_Login.EmployeeProfileSearchEmployee(Employee_namecheck, Employee_search);
												
												/*System.out.println("current url"+utilfunc.getPageUrl());
									if(utilfunc.getPageUrl().contains("Profile")){
										employeeSearchFlag	=	true;
									}*/
											} catch (Exception e){
												System.out.println("Unable to find employee");
											}

										}catch(Exception e){
											System.out.println("employee search falied.."+ e);
										}
									}
								}catch(Exception error){}
							}				
							// code for employee profile
							if(SuiteName.equals("Employee Profile")){
								SuiteNameEmpProfile=SuiteName;
								//System.out.println("\n================\n================\n\tEmployee Profile\n================\n================\n\t"+Employee_namecheck);
								// lets click on profile button and run all modules that are enabled for profile
								try{
									if(SelectQuestionnairetype.equals("PROFILE")){
										//modification
										String sidebarxpath=".//*[@id='slider-icon']";
										utilfunc.MakeElement(sidebarxpath).click();
										Thread.sleep(3000);

										String Principalheaderxpath=".//*[@id='rnav-principal-header']//a";
										utilfunc.MakeElement(Principalheaderxpath).click();
										Thread.sleep(3000);

										String Basicinfoxpath=".//*[@id='sectBasicInformation']//a";
										utilfunc.MakeElement(Basicinfoxpath).click();
										Thread.sleep(3000);
									}
								}catch(Exception e){
									System.out.println("unable to click on slider icon...");
								}

								// call all profile modules..'

								String sheetName				=	"Questionnaires";	//String ExcelSheetname			=	"Test Data.xls";
								String ExcelSheetname			=	"Test EmployeeProfile Data.xls";
								int rowCount					=	UtilFunction.usedRowCount(ExcelSheetname,sheetName);
								int columnNumber_emp_RUNMODE	=	UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnNameRM);
								int columnNumber_emp_ACTION		=	UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnNameAction);
								String columnName1				=	"Questionnaire Name";

								int questionnarie_name=UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnName1);
								for(int in=1;in<=rowCount;in++){
									int counter=0;
									//Below condition is used to check the RUNMODE for the Questionnaire modules
									if(UtilFunction.getCellData(ExcelSheetname, sheetName, columnNumber_emp_RUNMODE, in).equals("Y")){

										/*Questionnaire action mode(New,Edit, Delete)*/
										String QUESTIONNAIR_ACTION				=		UtilFunction.getCellData(ExcelSheetname, sheetName, columnNumber_emp_ACTION, in);
										/*Questionnaire module name*/
										String questionnarie_name1				=		UtilFunction.getCellData(ExcelSheetname, sheetName, questionnarie_name, in);

										ExcelSheetname="Test Data.xls";
										int columnNumber_RUNMODE1	=	UtilFunction.getColumnWithCellData(ExcelSheetname, questionnarie_name1, columnNameRM);
										int rowCount1	=	UtilFunction.usedRowCount(ExcelSheetname,questionnarie_name1);

										try{
											Thread.sleep(2500);
											startTime = System.currentTimeMillis();
											utilfunc.updateModuleDataForReportGeneration(sheetName, Employee_Profilename, timer);
											obj_CIMS_Regression_Suite_Employee_Profile.Employee_Profile(questionnarie_name1, QUESTIONNAIR_ACTION, ExcelSheetname, questionnarie_name1, columnNumber_RUNMODE1, rowCount1, Employee_Profilename, SuiteName,NumberOfNotAssignModule);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(sheetName, Employee_namecheck, timer);
											utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);
											ExcelSheetname			=	"Test EmployeeProfile Data.xls";
										}catch(Exception e){ 
											System.out.println("unable to process employee profile");
										}
									}
								}
							}
						}
						// now check module run modes with Y.. and call module objects..

						



						//////////////////////

						//////////////////////




					}
					else{
						//System.out.println("NO");
					}
				}catch(Exception e){

				}
			}//loop for check that module is Y or N ends here....


			




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


			//////////////////////////////////////////////////////////////
			//	Dashboard Report Generation code Start Here				//
			/////////////////////////////////////////////////////////////

			//for print suite name on consol which have runmode "Y" 
			Iterator itr=al.iterator();
			try{
				System.out.println("\n\n===============\n\t\tSuite Name(s) which have runmode \"Y\" are :");
				while(itr.hasNext()){System.out.println("\t\t"+itr.next());}
			}catch(Exception Error){}

			System.out.println("===============\n");


			hs.addAll(al);Thread.sleep(2000);
			al.clear();Thread.sleep(2000);
			al.addAll(hs);Thread.sleep(2000);
			Iterator itr1=al.iterator();
			String Resressionsuitname="";
			try{
				while(itr1.hasNext()){
					Resressionsuitname=itr1.next().toString();
					System.out.println("Suite Name is :"+Resressionsuitname);
					
					if(Resressionsuitname.equals("Employee Profile"))
					{//for Employee Profile
						String EmployeeProfile_FileTime			= "00";
						try{
							EmployeeProfile_FileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"employee_profile_time");
						}catch(Exception e){
							System.out.println("unable to write for module: "+Resressionsuitname);}
						try{
							obj_Report_Dashboard.generateReportForSuite("Employee Profile","1",Integer.toString(CIMS_Regression_Suite_Employee_Profile.TotalTestCaseCounter),Integer.toString(CIMS_Regression_Suite_Employee_Profile.PositiveScenarioCounter),Integer.toString(CIMS_Regression_Suite_Employee_Profile.NegativeScenarioCounter),Integer.toString(CIMS_Regression_Suite_Employee_Profile.passTestCaseCounter),Integer.toString(CIMS_Regression_Suite_Employee_Profile.failTestCaseCounter),EmployeeProfile_FileTime,Integer.toString(CIMS_Regression_Suite_Employee_Profile.NotAssignedModuleCounter));
						}catch(Exception e){
							System.out.println("unable to call & generate dashboard report for \"Regression - Initiate multiple projects\"");}
						

					}
					
				}//while loop ends here
			}catch(Exception e){}

			//////////////////////////////////////////////////////////////
			//	Dashboard Report Generation code ENDS Here			   //
			/////////////////////////////////////////////////////////////

			Employee_namecheck=null;
			Employee_Profilename=null;
			
			}
		catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed!!!");
			utilfunc.assertion();
			utilfunc.TakeScreenshot();
		}

	}



	// Below Methods are getters and setters for Test Parameters.	

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

	
	


	

	/*public void setDriver(WebDriver driver) {
			this.driver = driver;
		}*/

	public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
		this.obj_CIMS_Login = setobj_CIMS_Login;
	}

	public void setobj_CIMS_Regression_Suite_Employee_Profile(CIMS_Regression_Suite_Employee_Profile setobj_CIMS_Regression_Suite_Employee_Profile) {
		this.obj_CIMS_Regression_Suite_Employee_Profile	=	setobj_CIMS_Regression_Suite_Employee_Profile;
	}	

	public void setobj_Employee_Search(Employee_Search setobj_Employee_Search){
		this.obj_Employee_Search	=	setobj_Employee_Search;
	}
	

	// dashboard report
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}

	


	

	

}

