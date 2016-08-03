package CIMS;


import java.awt.AWTException;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
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
public class CIMS_Regression_Suite {

	private String 										sysDate;
	private WebDriver 									webdriver;		
	private UtilFunction 								utilfunc;		
	private CIMS_Login 									obj_CIMS_Login;

	private Employee_Search								obj_Employee_Search;

	private Project_Initiation 							obj_Project_Initiation;

	private CIMS_Single_Project_Initiation 				obj_CIMS_Single_Project_Initiation;
	private CIMS_Regresssion_Suite_Bulk_Initiation 		obj_CIMS_Regresssion_Suite_Bulk_Initiation;
	private CIMS_Regression_Suite_Immigration_Status   	obj_CIMS_Regression_Suite_Immigration_Status;
	private CIMS_Immigration_Document                   obj_CIMS_Immigration_Document;
	private CIMS_Regression_Suite_Employee_Profile		obj_CIMS_Regression_Suite_Employee_Profile;
	private CIMS_GCP_NewQuery							obj_CIMS_GCP_NewQuery;
	private Project_Search								obj_Project_Search;
	private CIMS_Travel_History      obj_CIMS_Travel_History;

	private dashboard 									obj_Report_Dashboard;
	//Lokesh append this code for "ALL MY TASKS" on welcome page
	//private CIMS_Regression_Suite_AllMyTasks			obj_CIMS_Regression_Suite_AllMyTasks; 
	//Lokesh append this code for "NEWS" on welcome page
	private CIMS_Regression_Suite_News			obj_CIMS_Regression_Suite_News;

	private CIMS_Secure_Messaging      obj_CIMS_Secure_Messaging;

	private CIMS_Regression_Suite_Process_Questionnaire_Assignment obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment;
	private CIMS_Processandquestionnaire_ProcessType         obj_CIMS_Processandquestionnaire_ProcessType;
	private CIMS_Regression_Suite_Emp_Questionnaire_Assignment obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment;
	private CIMS_Regression_ProcessAndQuestionnaire_contact obj_CIMS_Regression_ProcessAndQuestionnaire_contact;


	private CIMS_MostRecent_project   obj_CIMS_MostRecent_project;
	private CIMS_MostRecentTopTen_project   obj_CIMS_MostRecentTopTen_project;
	private CIMS_Project_Detail  obj_CIMS_Project_Detail;
	
	//Code by dharam -26-july-2016
	private CIMS_Project_Summary obj_CIMS_Project_Summary;
	private CIMS_Assessment_Summary obj_CIMS_Assessment_Summary;
	
	private CIMS_Project_List obj_CIMS_Project_List;

	//file name that takes dynamically in all modules.
	public static String ExcelFileName="Test Regression Suite Data.xls";
	public static String suiteName		=	"Regression Suites";
	public String sheetName="URLANDNAME";
	public static String os=System.getProperty("os.name");
	public static String osbit=System.getProperty("sun.arch.data.model");
	public static String moduleName="";
	public static String Employee_namecheck=null;
	public static String questionarie_name1="";
	public static String timer;
	private String columnNameRM="RUNMODE";
	private String columnNameAction="ACTION";


	public static String SelectQuestionnairetype	=		"";

	public static String Questionnaire_Name_array[]=new String [100];

	static int instanceCounter = 0;
	static int instanceCounter1 = 0;
	static int counter1 = 0;


	//timer
	StopWatch pageLoad = new StopWatch();

	//Initiate the class Before TEST method

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

			setobj_CIMS_Single_Project_Initiation(new CIMS_Single_Project_Initiation (webdriver,utilfunc));
			setobj_CIMS_Regresssion_Suite_Bulk_Initiation(new CIMS_Regresssion_Suite_Bulk_Initiation (webdriver,utilfunc));


			// Lokesh add these line(s) on 06-May-2016 for Advance Project search
			setobj_Project_Search(new Project_Search(webdriver,utilfunc));

			setobj_CIMS_Secure_Messaging(new CIMS_Secure_Messaging (webdriver,utilfunc));


			/**
			 * code added by Brij, starts here
			 */

			setobj_Project_Initiation(new Project_Initiation (webdriver,utilfunc));
			setobj_CIMS_Regression_Suite_Immigration_Status(new CIMS_Regression_Suite_Immigration_Status(webdriver, utilfunc));
			setobj_CIMS_Immigration_Document(new CIMS_Immigration_Document(webdriver, utilfunc));
			setobj_CIMS_Regression_Suite_Employee_Profile(new CIMS_Regression_Suite_Employee_Profile(webdriver, utilfunc));
			setobj_CIMS_GCP_NewQuery(new CIMS_GCP_NewQuery(webdriver, utilfunc));
			//Lokesh Append this code for "All My Tasks" Module
			//		setobj_CIMS_Regression_Suite_AllMyTasks(new CIMS_Regression_Suite_AllMyTasks(webdriver,utilfunc));
			//Lokesh Append this code for "News" Module
			setobj_CIMS_Regression_Suite_News(new CIMS_Regression_Suite_News(webdriver,utilfunc));

			setobj_CIMS_Regression_Suite_Process_Questionnaire_Assignment(new CIMS_Regression_Suite_Process_Questionnaire_Assignment(webdriver,utilfunc));
			setobj_CIMS_Processandquestionnaire_ProcessType(new CIMS_Processandquestionnaire_ProcessType(webdriver,utilfunc));
			setobj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment(new CIMS_Regression_Suite_Emp_Questionnaire_Assignment(webdriver,utilfunc));
			setobj_CIMS_Regression_ProcessAndQuestionnaire_contact(new CIMS_Regression_ProcessAndQuestionnaire_contact(webdriver,utilfunc));

			setobj_Employee_Search(new Employee_Search(webdriver,utilfunc));

			setobj_CIMS_Travel_History(new CIMS_Travel_History(webdriver,utilfunc));

			/**
			 * code added by Brij, ends here   
			 */
			setobj_CIMS_MostRecent_project(new CIMS_MostRecent_project (webdriver,utilfunc));
			setobj_CIMS_Project_Detail(new CIMS_Project_Detail (webdriver,utilfunc));
			setobj_CIMS_MostRecentTopTen_project(new CIMS_MostRecentTopTen_project(webdriver,utilfunc));
            setobj_CIMS_Project_Summary(new CIMS_Project_Summary(webdriver,utilfunc));
            setobj_CIMS_Assessment_Summary(new CIMS_Assessment_Summary(webdriver,utilfunc));
            setobj_CIMS_Project_List(new CIMS_Project_List(webdriver,utilfunc));
            


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
			/*p = System.getProperty("os.name");
		System.out.println("Operating system is"+p);*/

			// Project  Login	
			obj_CIMS_Login.Project_login();

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
			//String []	EmpDependantSuiteName		=	{"Immigration Status","Employee Profile","Document","ProcessQuestionnaire Assignment"};
			String []	EmpDependantSuiteName		=	{"Immigration Status","Employee Profile","Document","ProcessQuestionnaire Assignment","Most Recent","Project Detail","Assessment Summary","Secure Messaging","Project List"};
			
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

			//for Old SPI
			int OldSPI_PositiveScenarioCounter				=	0;
			int OldSPI_NegativeScenarioCounter				=	0;
			int OldSPI_ModuleCounter						=	1;
			int OldSPI_TotalTestCaseCounter					=	0;
			int OldSPI_passTestCaseCounter					=	0;
			int OldSPI_failTestCaseCounter					=	0;
			int OldSPI_NotAssignedModuleCounter			=	0;
			ArrayList NumberOfNotAssignModule = new ArrayList();

			//for Advance Search Project
			int AdvanceSearchProject_PositiveScenarioCounter	=	0;
			int AdvanceSearchProject_NegativeScenarioCounter	=	0;
			int AdvanceSearchProject_TotalTestCaseCounter		=	0;
			int AdvanceSearchProject_passTestCaseCounter		=	0;
			int AdvanceSearchProject_failTestCaseCounter		=	0;
			int AdvanceSearchProject_NotAssignedModuleCounter	=	0;
			int AdvanceSearchProject_ModuleCounter				=	1;

			//for Advance Search Employee
			int AdvanceSearchEmployee_PositiveScenarioCounter	=	0;
			int AdvanceSearchEmployee_NegativeScenarioCounter	=	0;
			int AdvanceSearchEmployee_TotalTestCaseCounter		=	0;
			int AdvanceSearchEmployee_passTestCaseCounter		=	0;
			int AdvanceSearchEmployee_failTestCaseCounter		=	0;
			int AdvanceSearchEmployee_NotAssignedModuleCounter	=	0;
			int AdvanceSearchEmployee_ModuleCounter				=	1;

			//for NEWS
			int News_PositiveScenarioCounter	=	0;
			int News_NegativeScenarioCounter	=	0;
			int News_TotalTestCaseCounter		=	0;
			int News_passTestCaseCounter		=	0;
			int News_failTestCaseCounter		=	0;
			int News_NotAssignedModuleCounter	=	0;
			int News_ModuleCounter				=	1;

			//for ProcessQuestionnaire Assignment
			int ProcessQuestionnaireAssignment_PositiveScenarioCounter	=	0;
			int ProcessQuestionnaireAssignment_NegativeScenarioCounter	=	0;
			int ProcessQuestionnaireAssignment_TotalTestCaseCounter		=	0;
			int ProcessQuestionnaireAssignment_passTestCaseCounter		=	0;
			int ProcessQuestionnaireAssignment_failTestCaseCounter		=	0;
			int ProcessQuestionnaireAssignment_NotAssignedModuleCounter	=	0;
			int ProcessQuestionnaireAssignment_ModuleCounter			=	1;

			//for GCP_NewQuery
			int GCP_NewQuery_PositiveScenarioCounter	=	0;
			int GCP_NewQuery_NegativeScenarioCounter	=	0;
			int GCP_NewQuery_TotalTestCaseCounter		=	0;
			int GCP_NewQuery_passTestCaseCounter		=	0;
			int GCP_NewQuery_failTestCaseCounter		=	0;
			int GCP_NewQuery_NotAssignedModuleCounter	=	0;
			int GCP_NewQuery_ModuleCounter				=	1;

			//for GCP_TravelHistory
			int GCP_TravelHistory_PositiveScenarioCounter	=	0;
			int GCP_TravelHistory_NegativeScenarioCounter	=	0;
			int GCP_TravelHistory_TotalTestCaseCounter		=	0;
			int GCP_TravelHistory_passTestCaseCounter		=	0;
			int GCP_TravelHistory_failTestCaseCounter		=	0;
			int GCP_TravelHistory_NotAssignedModuleCounter	=	0;
			int GCP_TravelHistory_ModuleCounter				=	1;

			//for Initiate a single project
			int InitiateSingleproject_PositiveScenarioCounter	=	0;
			int InitiateSingleproject_NegativeScenarioCounter	=	0;
			int InitiateSingleproject_TotalTestCaseCounter		=	0;
			int InitiateSingleproject_passTestCaseCounter		=	0;
			int InitiateSingleproject_failTestCaseCounter		=	0;
			int InitiateSingleproject_NotAssignedModuleCounter	=	0;
			int InitiateSingleproject_ModuleCounter				=	1;

			//for Initiate Multiple Project
			int InitiateMultipleProjects_PositiveScenarioCounter	=	0;
			int InitiateMultipleProjects_NegativeScenarioCounter	=	0;
			int InitiateMultipleProjects_TotalTestCaseCounter		=	0;
			int InitiateMultipleProjects_passTestCaseCounter		=	0;
			int InitiateMultipleProjects_failTestCaseCounter		=	0;
			int InitiateMultipleProjects_NotAssignedModuleCounter	=	0;
			int InitiateMultipleProjects_ModuleCounter				=	1;

			//for Immigration Status and Doc
			int ImmigrationStatusAndDoc_PositiveScenarioCounter		=	0;
			int ImmigrationStatusAndDoc_NegativeScenarioCounter		=	0;
			int ImmigrationStatusAndDoc_TotalTestCaseCounter		=	0;
			int ImmigrationStatusAndDoc_passTestCaseCounter			=	0;
			int ImmigrationStatusAndDoc_failTestCaseCounter			=	0;
			int ImmigrationStatusAndDoc_NotAssignedModuleCounter	=	0;
			int ImmigrationStatusAndDoc_ModuleCounter				=	1;

			//for Secure Messaging
			int SecureMessaging_PositiveScenarioCounter		=	0;
			int SecureMessaging_NegativeScenarioCounter		=	0;
			int SecureMessaging_TotalTestCaseCounter		=	0;
			int SecureMessaging_passTestCaseCounter			=	0;
			int SecureMessaging_failTestCaseCounter			=	0;
			int SecureMessaging_NotAssignedModuleCounter	=	0;
			int SecureMessaging_ModuleCounter				=	1;
			
			//for project Messaging
			int Projectdetail_PositiveScenarioCounter		=	0;
			int Projectdetail_NegativeScenarioCounter		=	0;
			int Projectdetail_TotalTestCaseCounter		=	0;
			int Projectdetail_passTestCaseCounter			=	0;
			int Projectdetail_failTestCaseCounter			=	0;
			int Projectdetail_NotAssignedModuleCounter	=	0;
			int Projectdetail_ModuleCounter				=	1;
			
			//for Most recent 
			
			
			int Mostrecent_PositiveScenarioCounter		=	0;
			int Mostrecent_NegativeScenarioCounter		=	0;
			int Mostrecent_TotalTestCaseCounter		=	0;
			int Mostrecent_passTestCaseCounter			=	0;
			int Mostrecent_failTestCaseCounter			=	0;
			int Mostrecent_NotAssignedModuleCounter	=	0;
			int Mostrecent_ModuleCounter				=	1;
			
			// code for project summary 
			

            int Projectsummary_PositiveScenarioCounter		=	0;
            int Projectsummary_NegativeScenarioCounter		=	0;
            int Projectsummary_TotalTestCaseCounter		    =	0;
            int Projectsummary_passTestCaseCounter			=	0;
            int Projectsummary_failTestCaseCounter			=	0;
            int Projectsummary_NotAssignedModuleCounter	    =	0;
            int Projectsummary_ModuleCounter				=	1;
            
            
            // code for project summary 
			

            int Assessmentsummary_PositiveScenarioCounter		=	0;
            int Assessmentsummary_NegativeScenarioCounter		=	0;
            int Assessmentsummary_TotalTestCaseCounter		    =	0;
            int Assessmentsummary_passTestCaseCounter			=	0;
            int Assessmentsummary_failTestCaseCounter			=	0;
            int Assessmentsummary_NotAssignedModuleCounter	    =	0;
            int Assessmentsummary_ModuleCounter				    =	1;
            
            // code for project list 
            
            int ProjectList_PositiveScenarioCounter		        =	0;
			int ProjectList_NegativeScenarioCounter		        =	0;
			int ProjectList_TotalTestCaseCounter		        =	0;
			int ProjectList_passTestCaseCounter			        =	0;
			int ProjectList_failTestCaseCounter			        =	0;
			int ProjectList_NotAssignedModuleCounter            =	0;
			int ProjectList_ModuleCounter				        =	1;









			// let us choose Regrssion suites from excel with Run mode Yes 
			String 	RegressionSuites				=		"Regression Suites";
			int RowCount							=		UtilFunction.usedRowCount(fileName, RegressionSuites);
			int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, columnNameRM);
			int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, columnNameAction);
			int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, "Suite Name");


			startTotalTime = System.currentTimeMillis();
			// loop running for regression suites
			for(int modCounter = 1;modCounter<RowCount;modCounter++){

				try{

					boolean passCounter	=	false;
					boolean failCounter	=	false;
					boolean notAssignedCounter	=	false;
					boolean negativePassCounter=false;

					//Flags used for AdvanceSearchProject Module
					boolean AdvanceSearchProject_NotAssignFlag=false;
					boolean AdvanceSearchProject_PassFlag=false;
					boolean AdvanceSearchProject_FailFlag=false;
					boolean AdvanceSearchProject_NegativePassFlag=false;

					//Flags used for AdvanceSearchEmployee Module
					boolean AdvanceSearchEmployee_NotassignFlag=false;
					boolean AdvanceSearchEmployee_PassFlag=false;
					boolean AdvanceSearchEmployee_FailFlag=false;
					boolean AdvanceSearchEmployee_NegativePassFlag=false;

					//Flags used for News Module
					boolean News_NotassignFlag=false;
					boolean News_PassFlag=false;
					boolean News_FailFlag=false;
					boolean News_NegativePassFlag=false;

					//Flags used for ProcessQuestionnaire Assignment Module
					boolean ProcessQuestionnaireAssignment_NotassignFlag=false;
					boolean ProcessQuestionnaireAssignment_PassFlag1=false;
					boolean ProcessQuestionnaireAssignment_PassFlag2=false;
					boolean ProcessQuestionnaireAssignment_PassFlag3=false;
					boolean ProcessQuestionnaireAssignment_PassFlag4=false;
					boolean ProcessQuestionnaireAssignment_FailFlag1=false;
					boolean ProcessQuestionnaireAssignment_FailFlag2=false;
					boolean ProcessQuestionnaireAssignment_FailFlag3=false;
					boolean ProcessQuestionnaireAssignment_FailFlag4=false;
					boolean ProcessQuestionnaireAssignment_NegativePassFlag1=false;
					boolean ProcessQuestionnaireAssignment_NegativePassFlag2=false;
					boolean ProcessQuestionnaireAssignment_NegativePassFlag3=false;
					boolean ProcessQuestionnaireAssignment_NegativePassFlag4=false;
					boolean ProcessQuestionnaireAssignment_PassFlag1FINALREPORT=false;
					boolean ProcessQuestionnaireAssignment_FailFlag1FINALREPORT=false;
					
					//Flags used for GCP_NewQuery Module
					boolean GCP_NewQuery_NotassignFlag=false;
					boolean GCP_NewQuery_PassFlag=false;
					boolean GCP_NewQuery_FailFlag=false;
					boolean GCP_NewQuery_NegativePassFlag=false;

					//Flags used for GCP_TravelHistory Module
					boolean GCP_TravelHistory_NotassignFlag=false;
					boolean GCP_TravelHistory_PassFlag=false;
					boolean GCP_TravelHistory_FailFlag=false;
					boolean GCP_TravelHistory_NegativePassFlag=false;

					//Flags used for News Module
					boolean InitiateSingleproject_NotassignFlag=false;
					boolean InitiateSingleproject_PassFlag=false;
					boolean InitiateSingleproject_FailFlag=false;
					boolean InitiateSingleproject_NegativePassFlag=false;

					//Flags used for News Module
					boolean InitiateMultipleProjects_NotassignFlag=false;
					boolean InitiateMultipleProjects_PassFlag=false;
					boolean InitiateMultipleProjects_FailFlag=false;
					boolean InitiateMultipleProjects_NegativePassFlag=false;

					//Flags used for Immigration Status And Doc Module
					boolean ImmigrationStatusAndDoc_NotassignFlag=false;
					boolean ImmigrationStatusAndDoc_STATUS_PassFlag=false;
					boolean ImmigrationStatusAndDoc_STATUS_FailFlag=false;
					boolean ImmigrationStatusAndDoc_STATUS_NegativePassFlag=false;
					boolean ImmigrationStatusAndDoc_DOC_PassFlag=false;
					boolean ImmigrationStatusAndDoc_DOC_FailFlag=false;
					boolean ImmigrationStatusAndDoc_DOC_NegativePassFlag=false;

					//Flags used for Immigration Status And Doc Module
					boolean Securemessaging_NotassignFlag=false;
					boolean Securemessaging_PassFlag=false;
					boolean Securemessaging_FailFlag=false;
					boolean Securemessaging_NegativePassFlag=false;

					
					//Flags used for Project detail
					boolean Projectdetail_NotassignFlag=false;
					boolean Projectdetail_PassFlag=false;
					boolean Projectdetail_FailFlag=false;
					boolean Projectdetail_NegativePassFlag=false;
					
					//Flags used for Project summary
					boolean Projectsummary_NotassignFlag=false;
					boolean Projectsummary_PassFlag=false;
					boolean Projectsummary_FailFlag=false;
					boolean Projectsummary_NegativePassFlag=false;
					
					//Flags used for Project summary
					boolean Assessmentsummary_NotassignFlag=false;
					boolean Assessmentsummary_PassFlag=false;
					boolean Assessmentsummary_FailFlag=false;
					boolean Assessmentsummary_NegativePassFlag=false;
					
					//Flags used for most recent And Doc Module
					boolean Mostrecent_NotassignFlag=false;
					boolean Mostrecent_PassFlag=false;
					boolean Mostrecent_FailFlag=false;
					boolean Mostrecent_NegativePassFlag=false;
					
					boolean Mostrecent_PassFlag2=false;
					boolean Mostrecent_FailFlag2=false;
					boolean Mostrecent_NegativePassFlag2=false;
					boolean Mostrecent_FailFlag1FINALREPORT=false;
					boolean Mostrecent_PassFlag1FINALREPORT=false;
					
					//Flag used for Project list 
					
					boolean ProjectList_NotassignFlag=false;
					boolean ProjectList_PassFlag=false;
					boolean ProjectList_FailFlag=false;
					boolean ProjectList_NegativePassFlag=false;
					


					// check if current suite name is set to runmode Y..
					if(UtilFunction.getCellData(fileName, RegressionSuites, columnNumber_RUNMODE, modCounter).equals("Y")){
						ModuleCounter=ModuleCounter+1;
						// now pick the name of regression suite, action, etc that is set to runmode Y

						String SuiteName				=		UtilFunction.getCellData(fileName, RegressionSuites, columnNumber_SuiteName, modCounter);
						String ActionName				=		UtilFunction.getCellData(fileName, RegressionSuites, columnNumber_ACTION, modCounter);


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
											obj_CIMS_Login.searchemployee(Employee_namecheck, Employee_search);
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
							// code for employee profile
							if(SuiteName.equals("Employee Profile")){
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

								String sheetName				=	"Questionnaires";
								String ExcelSheetname			=	"Test Data.xls";
								int rowCount					=	UtilFunction.usedRowCount(ExcelSheetname,sheetName);
								int columnNumber_emp_RUNMODE	=	UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnNameRM);
								int columnNumber_emp_ACTION		=	UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnNameAction);
//								ArrayList NumberOfNotAssignModule = new ArrayList();
								//questionnaire label
								String columnName1="Questionnaire Name";
								int questionnarie_name=UtilFunction.getColumnWithCellData(ExcelSheetname, sheetName, columnName1);
								for(int in=1;in<=rowCount;in++){
									int counter=0;
									//Below condition is used to check the RUNMODE for the Questionnaire modules
									if(UtilFunction.getCellData(ExcelSheetname, sheetName, columnNumber_emp_RUNMODE, in).equals("Y")){

										//Questionnaire action mode(New,Edit, Delete)
										String QUESTIONNAIR_ACTION				=		UtilFunction.getCellData(ExcelSheetname, sheetName, columnNumber_emp_ACTION, in);

										//Questionnaire module name 
										String questionnarie_name1				=		UtilFunction.getCellData(ExcelSheetname, sheetName, questionnarie_name, in);

										//		    					String sheetName1						=		questionnarie_name1;		
										//		    					String column_ques_Name						=		"RUNMODE";
										//String columnName5="ACTION";
										int columnNumber_RUNMODE1	=	UtilFunction.getColumnWithCellData(ExcelSheetname, questionnarie_name1, columnNameRM);
										int rowCount1	=	UtilFunction.usedRowCount(ExcelSheetname,questionnarie_name1);

										try{
											Thread.sleep(2500);
											//obj_CIMS_Regression_Suite_Employee_Profile.Employee_Profile(questionnarie_name1, QUESTIONNAIR_ACTION, ExcelSheetname, questionnarie_name1, columnNumber_RUNMODE1, rowCount1, Employee_namecheck, SuiteName,NumberOfNotAssignModule);
											obj_CIMS_Regression_Suite_Employee_Profile.Employee_Profile(questionnarie_name1, QUESTIONNAIR_ACTION, ExcelSheetname, questionnarie_name1, columnNumber_RUNMODE1, rowCount1, Employee_namecheck, SuiteName);
										}catch(Exception e){ 
											System.out.println("unable to process employee profile");
										}
									}

								}

							}

						}


						// now check module run modes with Y.. and call module objects..

						String sheetName					=	SuiteName;
						int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
						int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
						int Scenariocol=0;
						if(sheetName.equalsIgnoreCase("old Initiation"))
						{
							Scenariocol	=	UtilFunction.getColumnWithCellData("Test Data.xls", "Project Initiation", "SCENARIO");
						}
						else{
							Scenariocol	=	UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
						}//    					int columnNumber_suiteNm_ACTION			=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameAction);
						//						
						//		    			
						for(int count=1; count<rowCount; count++)
						{

							if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){
								String Scenariotext="";
								if(sheetName.equalsIgnoreCase("old Initiation"))
								{
									Scenariotext	= 	UtilFunction.getCellData("Test Data.xls", "Project Initiation", Scenariocol, count);
								}
								else
								{
									Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);
								}

								if(sheetName.equalsIgnoreCase("Old Initiation"))
								{
									if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
										OldSPI_PositiveScenarioCounter++;
									}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
										OldSPI_NegativeScenarioCounter++;
									}
									OldSPI_TotalTestCaseCounter=OldSPI_TotalTestCaseCounter+1;
								}
								else{
									if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
										PositiveScenarioCounter++;
									}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
										NegativeScenarioCounter++;
									}
									TotalTestCaseCounter=TotalTestCaseCounter+1;
								}


								//		    					String suiteActionName				=		UtilFunction.getCellData(fileName, sheetName, ActionName, count);
								// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched

								if(SuiteName.equals("Immigration Status") || SuiteName.equals("Document")){
									System.out.println("Immigration status and Document Module....");

									String ImmigrationStatusandDoc_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(ImmigrationStatusandDoc_Scenariotext.equals("Positive") || ImmigrationStatusandDoc_Scenariotext.contains("sitive") || ImmigrationStatusandDoc_Scenariotext.contains("Pos")){
										ImmigrationStatusAndDoc_PositiveScenarioCounter++;
									}else if(ImmigrationStatusandDoc_Scenariotext.equals("Negative") || ImmigrationStatusandDoc_Scenariotext.contains("gative") || ImmigrationStatusandDoc_Scenariotext.contains("gavtive") ){
										ImmigrationStatusAndDoc_PositiveScenarioCounter++;
									}
									ImmigrationStatusAndDoc_TotalTestCaseCounter++;


									Thread.sleep(1000);
									//visitSPILink	=	utilfunc.goToMenuSubItems("Immigration Status");
									String ProfileIConXPath			=			".//*[@id='local-navigation']//*[contains(@class,'dropdown-icon')]";
									String ImmigrationLinkXPath			=			"//*[@id='dpdmenu']//*[text()='Immigration Status']";
									boolean ImmigrationStatusAndDocAllocatedorNot=false;

									// click on profile drop menu icon
									try {
										utilfunc.waitForAnElementToLoad(ProfileIConXPath, true);
										utilfunc.MakeElement(ProfileIConXPath).click();
										System.out.println("user has clicked on drop menu icon of user profile");
										Thread.sleep(1000);

										// Check for immigration link. is it allocated or not.
										try {
											ImmigrationStatusAndDocAllocatedorNot=utilfunc.waitForAnElementToLoad(ImmigrationLinkXPath, true);
											if(ImmigrationStatusAndDocAllocatedorNot==true)
											{//Module assigned
												try{
													Thread.sleep(1000);
													utilfunc.MakeElement(ImmigrationLinkXPath).click();
													// search for name or click on first record..
													Thread.sleep(7000);
													int row_count=utilfunc.GetObjectCount(".//*[@id='tblFamilyList']/tbody/tr");
													System.out.println("\n\t-------\n\tHere we have "+(row_count/2)+" record for add/edit.\n\t-------");


													String principal1_spouse1_child1_firstRecord="";
													String firstRecord	="";

													for(int ImmigrationstatusAndDoc_i=1;ImmigrationstatusAndDoc_i<=row_count;ImmigrationstatusAndDoc_i+=2)
													{

														try{
															System.out.println("Wait for a min before start next record. Who's name is \""+utilfunc.MakeElement(".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a").getText()+"\". \n Current loop iteration number. "+ImmigrationstatusAndDoc_i+"Please wait...   ...   ...");
															System.out.println("\n\n\n\t==========\n\tNow we are going to add record with in "+utilfunc.MakeElement(".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a").getText()+" At row number "+ImmigrationstatusAndDoc_i+"\n\t==========\n\n");
															Thread.sleep(1000);

															principal1_spouse1_child1_firstRecord="";
															firstRecord="";
															String Xpath_GetPrincipalText=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[2]";
															String  gettext=utilfunc.MakeElement(Xpath_GetPrincipalText).getText();
															String ExcelSheetName	=	SuiteName;


															if(gettext.equalsIgnoreCase("Principal"))
															{	//System.out.println("\t---Value of i is: "+ImmigrationstatusAndDoc_i+" and value we get is: --"+gettext+"--.");
																try{
																	firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																	principal1_spouse1_child1_firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																}catch(Exception e){System.out.println("Unable to find the ");}
															}else if(gettext.equalsIgnoreCase("SPOUSE"))
															{	//System.out.println("\t---Value of i is: "+ImmigrationstatusAndDoc_i+" and value we get is: --"+gettext+"--.");
																try{
																	firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																	principal1_spouse1_child1_firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																	ExcelSheetName		+=	" Spouse";
																}catch(Exception e){System.out.println("Unable to find the ");}
															}else if(gettext.equalsIgnoreCase("CHILD"))
															{	//System.out.println("\t---Value of i is: "+ImmigrationstatusAndDoc_i+" and value we get is: --"+gettext+"--.");
																try{
																	firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																	principal1_spouse1_child1_firstRecord	=".//*[@id='tblFamilyList']/tbody/tr["+ImmigrationstatusAndDoc_i+"]/td[3]/a";
																	ExcelSheetName		+=	" Child";
																}catch(Exception e){System.out.println("Unable to find the ");}
															}

															String current_baseurl=utilfunc.getPageUrl();

															try{
																try{
																	utilfunc.MakeElement(principal1_spouse1_child1_firstRecord).click();
																	Thread.sleep(5000);
																	suiteLink=Immigration_Status_Document(SuiteName,ActionName);
																}catch(Exception e){
																	System.out
																	.println("unable to click for principal record "+SuiteName+" row number: " + ImmigrationstatusAndDoc_i);
																}

																try{
																	openSuite =	utilfunc.waitForAnElementToLoad(suiteLink, true);
																	utilfunc.MakeElement(suiteLink).click();
																}catch(Exception e){
																	System.out.println("clicked on tab for : "+SuiteName);
																}

																if(openSuite==true){
																	if(SuiteName.equals("Immigration Status")){
																		// now call modules according to enable modules

																		startTime = System.currentTimeMillis();

																		try{

																			try{																						
																				Page_flag	=	obj_CIMS_Regression_Suite_Immigration_Status.Immigration_Documents(fileName,ExcelSheetName,count,ActionName,current_baseurl);
																			}catch(Exception e){}

																			timer = utilfunc.getTimeTakenByModule(startTime);
																			utilfunc.updateModuleDataForReportGeneration(ExcelSheetName, Employee_namecheck, timer);
																			if (Page_flag)
																			{
																				status="PASS";
																				ImmigrationStatusAndDoc_passTestCaseCounter++;

																				if(utilfunc.globalerrormessage.equals(""))
																				{//Positive pass
																					utilfunc.TestngReportPass(obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio, ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status);
																					// now write it in a pass file START...
																					if(ImmigrationStatusAndDoc_STATUS_PassFlag==false){
																						try {	obj_Report_Dashboard.writeReportHeader(SuiteName, ExcelSheetName, "Pass");
																						}catch(Exception e){}
																						ImmigrationStatusAndDoc_STATUS_PassFlag=true;
																					}// now write it in a pass file ENDS...

																					//Write Positive Pass dashboard report 
																					try { 
																						obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio, ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, timer);
																					}catch(Exception e){
																						System.out.println("unable to write dasboard pass report for : "+ExcelSheetName);}
																				}
																				else
																				{	//Negative pass
																					utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName,obj_CIMS_Regression_Suite_Immigration_Status.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					// now write it in a negative pass dashboard file START...
																					if(ImmigrationStatusAndDoc_STATUS_NegativePassFlag==false){
																						try {	obj_Report_Dashboard.writeReportHeader(SuiteName, ExcelSheetName,"Negative Pass");
																						}catch(Exception e){}
																						ImmigrationStatusAndDoc_STATUS_NegativePassFlag=true;
																					}// now write it in a negative pass dashboard file ENDS...

																					//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
																					try {
																						obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regression_Suite_Immigration_Status.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName,obj_CIMS_Regression_Suite_Immigration_Status.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					} catch (Exception e) {
																						System.out.println("unable to write dasboard negative pass report for : "+ ExcelSheetName);}
																				}
																				/*if(passCounter==false){
																							try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
																							passCounter=true;
																						}
																						try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio, ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
																				 */
																			}
																			else
																			{
																				status="FAIL";
																				ImmigrationStatusAndDoc_failTestCaseCounter++;
																				//													utilfunc.TakeScreenshot();
																				utilfunc.TestngReportFail1(obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

																				// now write it in a fail dashboard file START...
																				if(ImmigrationStatusAndDoc_STATUS_FailFlag==false){
																					try{ obj_Report_Dashboard.writeReportHeader(SuiteName, ExcelSheetName,"Fail");
																					}catch(Exception e){}
																					ImmigrationStatusAndDoc_STATUS_FailFlag	= true;
																				}// now write it in a fail dashboard file ENDS...
																				try {
																					obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																				} catch (Exception e) {
																					System.out.println("unable to write dasboard fail report for : "+SuiteName);}

																				/*if(failCounter==false){
																							obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
																							failCounter	= true;
																						}
																						try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
																				 */
																			}
																		}catch(Exception e){
																			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
																			System.out.println("Script Failed");
																			utilfunc.assertion();			
																			utilfunc.TakeScreenshot();
																		}

																	}
																	/****/
																	if(SuiteName.equals("Document")){
																		//utilfunc.zoomOut(1);
																		// now call modules according to enable modules
																		//	System.out.println("calling "+SuiteName+" module..");
																		try{
																			startTime = System.currentTimeMillis();
																			try{
																				Page_flag	=	obj_CIMS_Immigration_Document.Documents(fileName,ExcelSheetName,count,ActionName,current_baseurl);
																			}catch(Exception e){}
																			timer = utilfunc.getTimeTakenByModule(startTime);
																			utilfunc.updateModuleDataForReportGeneration(ExcelSheetName, Employee_namecheck, timer);
																			if (Page_flag)
																			{
																				status="PASS";
																				ImmigrationStatusAndDoc_passTestCaseCounter++;

																				if(utilfunc.globalerrormessage.equals(""))
																				{
																					utilfunc.TestngReportPass(obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw,obj_CIMS_Immigration_Document.scenerio, ActionName,obj_CIMS_Immigration_Document.description, status);
																					// now write it in a pass file START...
																					if(ImmigrationStatusAndDoc_DOC_PassFlag==false){
																						try {	obj_Report_Dashboard.writeReportHeader(SuiteName, ExcelSheetName, "Pass");
																						}catch(Exception e){}
																						ImmigrationStatusAndDoc_DOC_PassFlag=true;
																					}// now write it in a pass file ENDS...

																					//Write Positive Pass dashboard report 
																					try {
																						obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Document.scenerio, ActionName, obj_CIMS_Immigration_Document.description, status, timer);
																					}catch(Exception e){
																						System.out.println("unable to write dasboard pass report for : "+ExcelSheetName);}
																				}
																				else
																				{
																					utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw,obj_CIMS_Immigration_Document.scenerio,ActionName,obj_CIMS_Immigration_Document.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					// now write it in a negative pass dashboard file START...
																					if(ImmigrationStatusAndDoc_DOC_NegativePassFlag==false){
																						try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
																						}catch(Exception e){}
																						ImmigrationStatusAndDoc_DOC_NegativePassFlag=true;
																					}// now write it in a negative pass dashboard file ENDS...

																					//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
																					try {
																						obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Immigration_Document.testcaseid,utilfunc.Actualbrw,obj_CIMS_Immigration_Document.scenerio,ActionName,obj_CIMS_Immigration_Document.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																					} catch (Exception e) {
																						System.out.println("unable to write dasboard negative pass report for : "+ ExcelSheetName);}
																				}
																				/*if(passCounter==false){
																							try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
																							passCounter=true;
																						}
																						try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Document.scenerio, ActionName, obj_CIMS_Immigration_Document.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
																				 */
																			}


																			else
																			{
																				status="FAIL";
																				ImmigrationStatusAndDoc_failTestCaseCounter++;
																				//													utilfunc.TakeScreenshot();
																				utilfunc.TestngReportFail1(obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw,obj_CIMS_Immigration_Document.scenerio,ActionName,obj_CIMS_Immigration_Document.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																				// now write it in a fail dashboard file START...
																				if(ImmigrationStatusAndDoc_DOC_FailFlag==false){
																					try{ obj_Report_Dashboard.writeReportHeader(SuiteName, ExcelSheetName,"Fail");
																					}catch(Exception e){}
																					ImmigrationStatusAndDoc_DOC_FailFlag	= true;
																				}// now write it in a fail dashboard file ENDS...
																				try {
																					obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Immigration_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Document.scenerio,ActionName, obj_CIMS_Immigration_Document.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																				} catch (Exception e) {
																					System.out.println("unable to write dasboard fail report for : "+ExcelSheetName);}
																				/*if(failCounter==false){
																							obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
																							failCounter	= true;
																						}
																						try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Immigration_Status.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Immigration_Status.scenerio,ActionName, obj_CIMS_Regression_Suite_Immigration_Status.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
																				 */

																			}
																		}catch(Exception e){
																			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
																			System.out.println("Script Failed");
																			utilfunc.assertion();			
																			utilfunc.TakeScreenshot();
																		}
																	}

																}
															}catch(Exception e){
																System.out.println("Unable to find the link");
															}
															//utilfunc.zoomreset();
															webdriver.get(current_baseurl);											



														}catch(Exception error){System.out.println("Error occured while executing for loop for itteration no."+ImmigrationstatusAndDoc_i+"\nError details are: "+error);}
													}
													//////////////////////////////////////////////////////////
													//////////////////////////////////////////////////////////
													/////////////////////////////////////////////////////////

												}catch(Exception e)
												{
													System.out.println("Unable to click Immigration Link");
												}
											}
											else{//Not Assigned 

												try
												{	
													timer = utilfunc.getTimeTakenByModule(startTime);
													status="PASS";
													String ImmigrationStatusandDoc_NA_Errormessage="";
													String ImmigrationStatusandDoc_NA_NotAssignTestCaseID="";
													String ImmigrationStatusandDoc_NA_NotAssignScenerio="";
													String ImmigrationStatusandDoc_NA_NotAssignTestCaseDescription="";
													int ImmigrationStatusandDoc_NA_columnNumber_TCID;
													int ImmigrationStatusandDoc_NA_columnNumber_Scenario;
													int ImmigrationStatusandDoc_NA_columnNumber_TestCaseDescription;

													utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
													ImmigrationStatusandDoc_NA_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
													System.out.println(ImmigrationStatusandDoc_NA_Errormessage);

													ImmigrationStatusandDoc_NA_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
													ImmigrationStatusandDoc_NA_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
													ImmigrationStatusandDoc_NA_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

													ImmigrationStatusandDoc_NA_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, ImmigrationStatusandDoc_NA_columnNumber_TCID, count);
													ImmigrationStatusandDoc_NA_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, ImmigrationStatusandDoc_NA_columnNumber_Scenario, count);
													ImmigrationStatusandDoc_NA_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, ImmigrationStatusandDoc_NA_columnNumber_TestCaseDescription, count);

													utilfunc.TestngReportFail(ImmigrationStatusandDoc_NA_NotAssignTestCaseID, utilfunc.Actualbrw, ImmigrationStatusandDoc_NA_NotAssignScenerio,ActionName,ImmigrationStatusandDoc_NA_NotAssignTestCaseDescription,status,ImmigrationStatusandDoc_NA_Errormessage);
													//now write it in a notAssign file START...
													if(ImmigrationStatusAndDoc_NotassignFlag==false){
														try{	obj_Report_Dashboard.writeReportHeader(RegressionSuites, SuiteName,"Not Assigned");
														}catch(Exception e){}
														ImmigrationStatusAndDoc_NotassignFlag=true;
													}//now write it in a notAssign file ENDS...
													ImmigrationStatusAndDoc_NotAssignedModuleCounter=1;	
													try {
														obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, ImmigrationStatusandDoc_NA_NotAssignTestCaseID, utilfunc.Actualbrw, ImmigrationStatusandDoc_NA_NotAssignScenerio, ActionName, ImmigrationStatusandDoc_NA_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
													} catch (InterruptedException e) {
														System.out.println("unable to write Not Assign report");
													}

												}
												catch(Exception e){}
											}
										} catch (Exception e) 
										{	System.out.println("unable to click on immigration status link");	}

									} catch (Exception e) 
									{	System.out.println("unable to click on drop menu icon of user profile");	}








									/*
									 * Code added by lokesh for principal,child,spouse
									 */

								}

								// run modules without employee search.. 
								else if(SuiteName.equals("Globalchek Plus"))
								{
									String GCP_NewQuery_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(GCP_NewQuery_Scenariotext.equals("Positive") || GCP_NewQuery_Scenariotext.contains("sitive") || GCP_NewQuery_Scenariotext.contains("Pos")){
										GCP_NewQuery_PositiveScenarioCounter++;
									}else if(GCP_NewQuery_Scenariotext.equals("Negative") || GCP_NewQuery_Scenariotext.contains("gative") || GCP_NewQuery_Scenariotext.contains("gavtive") ){
										GCP_NewQuery_NegativeScenarioCounter++;
									}
									GCP_NewQuery_TotalTestCaseCounter++;

									// click on Globalcheck plus link under Menu
									try{
										visitSPILink	=	utilfunc.goToMenuSubItems("New Query");
										System.out.println("user has clicked on New Query link");
									}catch(Exception e){
										System.out.println("user is unable to click on New Query link");
									}

									// now call modules according to enable modules
									//																System.out.println("calling "+SuiteName+" module..");
									startTime = System.currentTimeMillis();

									//check is GCP_NewQuery allocated or not.
									if(visitSPILink==true)
									{//allocated
										try{

											try{
												Page_flag	=	obj_CIMS_GCP_NewQuery.GCP_NewQuery_Initiation_Page(fileName,sheetName,count,ActionName);
											}catch(Exception error){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												GCP_NewQuery_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status);
													// now write it in a pass file START...
													if(GCP_NewQuery_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														GCP_NewQuery_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio,ActionName,obj_CIMS_GCP_NewQuery.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(GCP_NewQuery_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														GCP_NewQuery_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_GCP_NewQuery.testcaseid,utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio,ActionName,obj_CIMS_GCP_NewQuery.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												GCP_NewQuery_failTestCaseCounter++;
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio,ActionName, obj_CIMS_GCP_NewQuery.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(GCP_NewQuery_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													GCP_NewQuery_FailFlag	= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio,ActionName, obj_CIMS_GCP_NewQuery.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio,ActionName, obj_CIMS_GCP_NewQuery.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();												//		    					
											utilfunc.TakeScreenshot();
										}
									}else{//not allocated
										//GCP_NewQuery is not assigned to the user


										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String GCP_NewQuery_Errormessage="";
										String GCP_NewQuery_NotAssignTestCaseID="";
										String GCP_NewQuery_NotAssignScenerio="";
										String GCP_NewQuery_NotAssignTestCaseDescription="";
										int GCP_NewQuery_columnNumber_TCID;
										int GCP_NewQuery_columnNumber_Scenario;
										int GCP_NewQuery_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										GCP_NewQuery_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(GCP_NewQuery_Errormessage);

										GCP_NewQuery_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										GCP_NewQuery_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										GCP_NewQuery_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										GCP_NewQuery_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, GCP_NewQuery_columnNumber_TCID, count);
										GCP_NewQuery_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, GCP_NewQuery_columnNumber_Scenario, count);
										GCP_NewQuery_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, GCP_NewQuery_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(GCP_NewQuery_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_NewQuery_NotAssignScenerio,ActionName,GCP_NewQuery_NotAssignTestCaseDescription,status,GCP_NewQuery_Errormessage);
										//now write it in a notAssign file START...
										if(GCP_NewQuery_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											GCP_NewQuery_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										GCP_NewQuery_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, GCP_NewQuery_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_NewQuery_NotAssignScenerio, ActionName, GCP_NewQuery_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}

									}



								}
								else if(SuiteName.equals("Travel History")){
									String GCP_TravelHistory_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(GCP_TravelHistory_Scenariotext.equals("Positive") || GCP_TravelHistory_Scenariotext.contains("sitive") || GCP_TravelHistory_Scenariotext.contains("Pos")){
										GCP_TravelHistory_PositiveScenarioCounter++;
									}else if(GCP_TravelHistory_Scenariotext.equals("Negative") || GCP_TravelHistory_Scenariotext.contains("gative") || GCP_TravelHistory_Scenariotext.contains("gavtive") ){
										GCP_TravelHistory_NegativeScenarioCounter++;
									}
									GCP_TravelHistory_TotalTestCaseCounter++;

									// click on Globalcheck plus link under Menu
									try{
										visitSPILink	=	utilfunc.goToMenuSubItems("Travel History");
										System.out.println("user has clicked on Travel History link");
									}catch(Exception e){
										System.out.println("user is unable to click on Travel History link");
									}

									// now call modules according to enable modules
									//																System.out.println("calling "+SuiteName+" module..");
									startTime = System.currentTimeMillis();
									if(visitSPILink==true){
										try{
											Page_flag	=	obj_CIMS_Travel_History.Travel_History(fileName,sheetName,count,ActionName);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												GCP_TravelHistory_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status);
													// now write it in a pass file START...
													if(GCP_TravelHistory_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														GCP_TravelHistory_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw,obj_CIMS_Travel_History.scenerio,ActionName,obj_CIMS_Travel_History.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(GCP_TravelHistory_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														GCP_TravelHistory_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Travel_History.testcaseid,utilfunc.Actualbrw,obj_CIMS_Travel_History.scenerio,ActionName,obj_CIMS_Travel_History.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*if(passCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												 passCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												GCP_TravelHistory_failTestCaseCounter++;
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(GCP_TravelHistory_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													GCP_TravelHistory_FailFlag	= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*if(failCounter==false){
					    						obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
					    						failCounter	= true;
				    						}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}else{//not allocated
										//GCP_TrevalHistory is not assigned to the user


										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String GCP_TravelHistory_Errormessage="";
										String GCP_TravelHistory_NotAssignTestCaseID="";
										String GCP_TravelHistory_NotAssignScenerio="";
										String GCP_TravelHistory_NotAssignTestCaseDescription="";
										int GCP_TravelHistory_columnNumber_TCID;
										int GCP_TravelHistory_columnNumber_Scenario;
										int GCP_TravelHistory_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										GCP_TravelHistory_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(GCP_TravelHistory_Errormessage);

										GCP_TravelHistory_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										GCP_TravelHistory_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										GCP_TravelHistory_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										GCP_TravelHistory_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, GCP_TravelHistory_columnNumber_TCID, count);
										GCP_TravelHistory_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, GCP_TravelHistory_columnNumber_Scenario, count);
										GCP_TravelHistory_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, GCP_TravelHistory_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(GCP_TravelHistory_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_TravelHistory_NotAssignScenerio,ActionName,GCP_TravelHistory_NotAssignTestCaseDescription,status,GCP_TravelHistory_Errormessage);
										//now write it in a notAssign file START...
										if(GCP_TravelHistory_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											GCP_TravelHistory_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										GCP_TravelHistory_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, GCP_TravelHistory_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_TravelHistory_NotAssignScenerio, ActionName, GCP_TravelHistory_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}

									}
								}
								//		    				/****/
								//LOKESH append this code for "ALL MY TASKS" on welcome page on 11-April-2016 ===START HERE===
								/*else if(SuiteName.equals("All My Tasks"))
		    				{
		    					System.out.println("\n---\n---\n---\tAll my tasks");

		    					startTime = System.currentTimeMillis();

								try{
								Page_flag	=	obj_CIMS_Regression_Suite_AllMyTasks.AllMyTasks(fileName,SuiteName,count,ActionName);
								timer = utilfunc.getTimeTakenByModule(startTime);
								utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
								if (Page_flag)
								{
									status="PASS";passTestCaseCounter++;
									if(utilfunc.globalerrormessage.equals(""))
									{
										utilfunc.TestngReportPass(obj_CIMS_Regression_Suite_AllMyTasks.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_AllMyTasks.scenerio, ActionName, obj_CIMS_Regression_Suite_AllMyTasks.description, status);
									}
									else
									{
										utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_Suite_AllMyTasks.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_Suite_AllMyTasks.scenerio,ActionName,obj_CIMS_Regression_Suite_AllMyTasks.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									}
								}
								else
								{
									status="FAIL";failTestCaseCounter++;
//									utilfunc.TakeScreenshot();
									utilfunc.TestngReportFail1(obj_CIMS_Regression_Suite_AllMyTasks.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_AllMyTasks.scenerio,ActionName, obj_CIMS_Regression_Suite_AllMyTasks.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								}catch(Exception e){
									ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
									System.out.println("Script Failed");
									utilfunc.assertion();			
									utilfunc.TakeScreenshot();
									}

		    				}*/

								//LOKESH append this code for "ALL MY TASKS" on welcome page on 11-April-2016 ===END HERE===

								//LOKESH append this code for "News" on welcome page on 11-April-2016 ===START HERE===
								else if(SuiteName.equals("News"))
								{
									String News_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(News_Scenariotext.equals("Positive") || News_Scenariotext.contains("sitive") || News_Scenariotext.contains("Pos")){
										News_PositiveScenarioCounter++;
									}else if(News_Scenariotext.equals("Negative") || News_Scenariotext.contains("gative") || News_Scenariotext.contains("gavtive") ){
										News_NegativeScenarioCounter++;
									}
									News_TotalTestCaseCounter++;

									System.out.println("We are on news.........");
									try{
										String curnturlis=webdriver.getCurrentUrl();
										int totallenth=curnturlis.length();
										int positon=curnturlis.indexOf("com/");
										if((totallenth-(positon+4))>0)
										{
											System.out.println("we have to go to home page...");
											utilfunc.MakeElement(".//*[@id='gn-menu']//*[@id='logo']/a").click();
											Thread.sleep(2000);
										}
									}catch(Exception error ){System.out.println("unable to click on logo to go to home page");}

									String NewsSectionisAssignedorNot_gettext="";
									String NewsSectionisAssignedorNot_Xpath=".//*[@id='panel-header' and contains(text(),'News')]"; 
									try{
										NewsSectionisAssignedorNot_gettext=utilfunc.MakeElement(NewsSectionisAssignedorNot_Xpath).getText();
									}catch(Exception error){}

									startTime = System.currentTimeMillis();

									//check News is assigned to the user or not.
									if(NewsSectionisAssignedorNot_gettext.equalsIgnoreCase("News"))
									{//News is assigned to the user
										try{
											try{
												Page_flag	=	obj_CIMS_Regression_Suite_News.News(fileName,SuiteName,count,ActionName);
											}catch(Exception error){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												News_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio, ActionName, obj_CIMS_Regression_Suite_News.description, status);
													// now write it in a pass file START...
													if(News_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														News_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio, ActionName, obj_CIMS_Regression_Suite_News.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}

												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_Suite_News.scenerio,ActionName,obj_CIMS_Regression_Suite_News.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(News_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														News_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regression_Suite_News.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regression_Suite_News.scenerio,ActionName,obj_CIMS_Regression_Suite_News.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio, ActionName, obj_CIMS_Regression_Suite_News.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												News_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio,ActionName, obj_CIMS_Regression_Suite_News.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(News_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													News_FailFlag	= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio,ActionName, obj_CIMS_Regression_Suite_News.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}

												/*if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_News.scenerio,ActionName, obj_CIMS_Regression_Suite_News.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
									else
									{//News is not assigned to the user


										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String News_Errormessage="";
										String News_NotAssignTestCaseID="";
										String News_NotAssignScenerio="";
										String News_NotAssignTestCaseDescription="";
										int News_columnNumber_TCID;
										int News_columnNumber_Scenario;
										int News_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										News_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(News_Errormessage);

										News_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										News_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										News_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										News_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, News_columnNumber_TCID, count);
										News_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, News_columnNumber_Scenario, count);
										News_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, News_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(News_NotAssignTestCaseID, utilfunc.Actualbrw, News_NotAssignScenerio,ActionName,News_NotAssignTestCaseDescription,status,News_Errormessage);
										//now write it in a notAssign file START...
										if(News_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											News_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										News_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, News_NotAssignTestCaseID, utilfunc.Actualbrw, News_NotAssignScenerio, ActionName, News_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								}

								//LOKESH append this code for "ALL MY TASKS" on welcome page on 11-April-2016 ===END HERE===

								/****/
								else if(SuiteName.equals("Old Initiation") || SuiteName.equals("Initiate a single project") 
										|| SuiteName.equals("Initiate multiple projects")){

									// use is looking for module that do not require employee to search before going on the module..

									// fixing link for old initiation page
									/*if(SuiteName.equals("Old Initiation")){
										webdriver.get("http://cobaltqa.daxima.com/Initiation");
									}*/

									try{
										// check if current browser is IE8 then click link for IE8 only
										System.out.println("check if current browser is IE then click link for IE only");

										String InitiationLink		=		"//*[contains(@id,'divis')]";
										//	    					String InitiateLinkXPath	=		"SinglepageInitiation"; // this is used to get the link of enabled(display: none is missing) link
												int InitiationLinkGetObjCounter=0;
												InitiationLinkGetObjCounter=utilfunc.GetObjectCount(InitiationLink);
										for(int w=1;w<=InitiationLinkGetObjCounter;w++){
											Thread.sleep(2500);

											String InitiateLinkXPath	=	InitiationLink+"["+w+"]";
											Boolean	styleAttrPresent	=		utilfunc.isAttributePresent(utilfunc.MakeElement(InitiateLinkXPath), "style");

											if(styleAttrPresent==false){
												System.out.println("style tag not present.."+utilfunc.MakeElement(InitiateLinkXPath).getText());
												// clicking on initiation page.. let us save the id to identify if we need to call old initiation page
												IdentifyIE			=		utilfunc.MakeElement(InitiateLinkXPath).getAttribute("id");
												System.out.println("ie-: "+IdentifyIE);
												String newInitiateLinkXPath=InitiateLinkXPath+"/a";
												try {
													utilfunc.MakeElement(newInitiateLinkXPath).click();
												} catch (Exception e) {
													System.out.println("unable to click on single page initiation link");
												}
												break;
											}

										}

									}catch(Exception e){
										System.out.println("unable to go to "+ SuiteName + " page");
									}

									Thread.sleep(3000);
									String LinkPrefix		=		".//*[@id='panel-body-container']//*[contains(@class,'btn-group')]";

									if(SuiteName.equals("Initiate a single project") || SuiteName.equals("Old Initiation")){

										Thread.sleep(2000);

										try {
											suiteLink			=		LinkPrefix	+	"//*[contains(@href,'single')]";
											openSuite =	utilfunc.waitForAnElementToLoad(suiteLink, true);
											utilfunc.MakeElement(suiteLink).click();
											System.out.println("clicked on single page initiation link");
										} catch (Exception e) {

											System.out.println("unable to click on single page initiation link");
										}

										// now call modules according to enable modules

										System.out.println("calling SPI add module..");
										////TIMER START///////
										startTime = System.currentTimeMillis();

										//								if(IdentifyIE.equals("divisIE8")){
										// in case of IE8 browser call old single page initiation

										if(SuiteName.equals("Old Initiation")){

											OldSPI_TotalTestCaseCounter++;
											try{

												boolean FlagStep1 = false;
												boolean FlagStep2 = false;
												boolean FlagStep3 = false;
												boolean FlagStep4 = false;
												boolean FlagStep5 = false;
												boolean FlagStep6 = false;

												////TIMER START///////
												startTime = System.currentTimeMillis();
												//Project Initiate page
												obj_Project_Initiation.Project_Initiation_Page();

												//Project_Initiation_Step1_Page
												FlagStep1=obj_Project_Initiation.Project_Initiation_Step1_Page();
												timer = utilfunc.getTimeTakenByModule(startTime);

												utilfunc.updateModuleDataForReportGeneration(SuiteName + " - Step 1", Employee_namecheck, timer);
												if(!FlagStep1){
													System.out.println("Step 1 Script Failed due to an Exception");	
													status="FAIL";

													utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_Project_Initiation.testcaseId, utilfunc.Actualbrw, obj_Project_Initiation.testcasescenario,ActionName, obj_Project_Initiation.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

													//// now write it in a fail dashboard file..
													try {
														obj_Report_Dashboard.writeReportHeader(SuiteName, "Old Initiation Step 1","Fail");
													} catch (Exception e1) {
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_Project_Initiation.testcaseId, utilfunc.Actualbrw, obj_Project_Initiation.testcasescenario, ActionName, obj_Project_Initiation.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}


												}
												else {
													System.out
													.println("Successfully Executed- Step 1 for Project Initation");
													status = "PASS";

													if (utilfunc.globalerrormessage
															.equals("")) {
														utilfunc.TestngReportPass(
																obj_Project_Initiation.testcaseId,
																utilfunc.Actualbrw,
																obj_Project_Initiation.testcasescenario,
																ActionName,
																obj_Project_Initiation.testcasedescription,
																status);

														// now write it in a
														// pass file..
														try {
															obj_Report_Dashboard
															.writeReportHeader(
																	SuiteName,
																	"Old Initiation Step 1",
																	"Pass");
														} catch (Exception e1) {
														}

														try {
															obj_Report_Dashboard
															.writeDashBoardPassReport(
																	SuiteName,
																	Employee_namecheck,
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status,
																	timer);
														} catch (Exception e) {
															System.out
															.println("unable to write dasboard pass report for : "
																	+ SuiteName);
														}

													} else {
														utilfunc.TestngReportNegativePassTestcase(
																obj_Project_Initiation.testcaseId,
																utilfunc.Actualbrw,
																obj_Project_Initiation.testcasescenario,
																ActionName,
																obj_Project_Initiation.testcasedescription,
																status,
																utilfunc.ErrorMessage2,
																utilfunc.ErrorMessage1,
																utilfunc.ErrorMessage4);

														// negative pass
														// dashboard report
														try {
															obj_Report_Dashboard
															.writeReportHeader(
																	SuiteName,
																	"Old Initiation Step 1",
																	"Negative Pass");
														} catch (Exception e1) {
														}
														try {
															obj_Report_Dashboard.
															writeDashBoardNegativePassReport(
																	SuiteName,
																	Employee_namecheck,
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status,
																	timer,
																	utilfunc.ErrorMessage2,
																	utilfunc.ErrorMessage1,
																	utilfunc.ErrorMessage4);
														} catch (Exception e) {
															System.out
															.println("unable to write dasboard negative pass report for : "
																	+ SuiteName);
														}
													}

													// call second step only if
													// step one is passed
													// Project_Initiation_Step2_Page
													Thread.sleep(1500);
													// //TIMER START///////
													startTime = System.currentTimeMillis();
													FlagStep2 = obj_Project_Initiation.Project_Initiation_Step2_Page();
													timer = utilfunc.getTimeTakenByModule(startTime);

													utilfunc.updateModuleDataForReportGeneration(SuiteName+ " - Step 2",
															Employee_namecheck,
															timer);
													if (!FlagStep2) {
														System.out
														.println("Step 2 Script Failed due to an Exception");
														status = "FAIL";

														utilfunc.TakeScreenshot();
														utilfunc.TestngReportFail1(
																obj_Project_Initiation.testcaseId,
																utilfunc.Actualbrw,
																obj_Project_Initiation.testcasescenario,
																ActionName,
																obj_Project_Initiation.testcasedescription,
																status,
																utilfunc.ErrorMessage2,
																utilfunc.ErrorMessage1,
																utilfunc.ErrorMessage4);

														// now write it in a
														// fail dashboard file..
														try {
															obj_Report_Dashboard
															.writeReportHeader(
																	SuiteName,
																	"Old Initiation Step 2",
																	"Fail");
														} catch (Exception e1) {
														}
														try {
															obj_Report_Dashboard
															.writeDashBoardFailReport(
																	SuiteName,
																	Employee_namecheck,
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status,
																	timer,
																	utilfunc.ErrorMessage2,
																	utilfunc.ErrorMessage1,
																	utilfunc.ErrorMessage4);
														} catch (Exception e) {
															System.out
															.println("unable to write dasboard fail report for : "
																	+ SuiteName);
														}

													} else {
														System.out
														.println("Successfully Executed- Step 2 for Project Initation");
														status = "PASS";

														if (utilfunc.globalerrormessage
																.equals("")) {
															utilfunc.TestngReportPass(
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status);
															// now write it in a
															// pass file..
															try {
																obj_Report_Dashboard
																.writeReportHeader(
																		SuiteName,
																		"Old Initiation Step 2",
																		"Pass");
															} catch (Exception e1) {
															}

															try {
																obj_Report_Dashboard
																.writeDashBoardPassReport(
																		SuiteName,
																		Employee_namecheck,
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status,
																		timer);
															} catch (Exception e) {
																System.out
																.println("unable to write dasboard pass report for : "
																		+ SuiteName);
															}
														} else {
															utilfunc.TestngReportNegativePassTestcase(
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status,
																	utilfunc.ErrorMessage2,
																	utilfunc.ErrorMessage1,
																	utilfunc.ErrorMessage4);

															// negative pass

															// dashboard report
															try {
																obj_Report_Dashboard
																.writeReportHeader(
																		SuiteName,
																		"Old Initiation Step 2",
																		"Negative Pass");
															} catch (Exception e1) {
															}
															try {
																obj_Report_Dashboard
																.writeDashBoardNegativePassReport(
																		SuiteName,
																		Employee_namecheck,
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status,
																		timer,
																		utilfunc.ErrorMessage2,
																		utilfunc.ErrorMessage1,
																		utilfunc.ErrorMessage4);
															} catch (Exception e) {
																System.out
																.println("unable to write dasboard negative pass report for : "
																		+ SuiteName);
															}

														}

														// call third only if

														// Project_Initiation_Step3_Page
														Thread.sleep(1500);
														// //TIMER START///////
														startTime = System
																.currentTimeMillis();
														FlagStep3 = obj_Project_Initiation
																.Project_Initiation_Step3_Page();
														timer = utilfunc
																.getTimeTakenByModule(startTime);

														utilfunc.updateModuleDataForReportGeneration(
																SuiteName
																+ " - Step 3",
																Employee_namecheck,
																timer);
														if (!FlagStep3) {
															System.out
															.println("Step 3 Script Failed due to an Exception");
															status = "FAIL";

															utilfunc.TakeScreenshot();
															utilfunc.TestngReportFail1(
																	obj_Project_Initiation.testcaseId,
																	utilfunc.Actualbrw,
																	obj_Project_Initiation.testcasescenario,
																	ActionName,
																	obj_Project_Initiation.testcasedescription,
																	status,
																	utilfunc.ErrorMessage2,
																	utilfunc.ErrorMessage1,
																	utilfunc.ErrorMessage4);
															// now write it in a
															// fail dashboard
															// file..
															try {
																obj_Report_Dashboard
																.writeReportHeader(
																		SuiteName,
																		"Old Initiation Step 3",
																		"Fail");
															} catch (Exception e1) {
															}
															try {
																obj_Report_Dashboard
																.writeDashBoardFailReport(
																		SuiteName,
																		Employee_namecheck,
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status,
																		timer,
																		utilfunc.ErrorMessage2,
																		utilfunc.ErrorMessage1,
																		utilfunc.ErrorMessage4);
															} catch (Exception e) {
																System.out
																.println("unable to write dasboard fail report for : "
																		+ SuiteName);
															}

														} else {
															System.out
															.println("Successfully Executed- Step 3 for Project Initation");
															status = "PASS";

															if (utilfunc.globalerrormessage
																	.equals("")) {
																utilfunc.TestngReportPass(
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status);
																// now write it
																// in a pass
																// file..
																try {
																	obj_Report_Dashboard
																	.writeReportHeader(
																			SuiteName,
																			"Old Initiation Step 3",
																			"Pass");
																} catch (Exception e1) {
																}

																try {
																	obj_Report_Dashboard
																	.writeDashBoardPassReport(
																			SuiteName,
																			Employee_namecheck,
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status,
																			timer);
																} catch (Exception e) {
																	System.out
																	.println("unable to write dasboard pass report for : "
																			+ SuiteName);
																}
															} else {
																utilfunc.TestngReportNegativePassTestcase(
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status,
																		utilfunc.ErrorMessage2,
																		utilfunc.ErrorMessage1,
																		utilfunc.ErrorMessage4);
																// negative pass
																// dashboard
																// report
																try {
																	obj_Report_Dashboard
																	.writeReportHeader(
																			SuiteName,
																			"Old Initiation Step 3",
																			"Negative Pass");
																} catch (Exception e1) {
																}
																try {
																	obj_Report_Dashboard
																	.writeDashBoardNegativePassReport(
																			SuiteName,
																			Employee_namecheck,
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status,
																			timer,
																			utilfunc.ErrorMessage2,
																			utilfunc.ErrorMessage1,
																			utilfunc.ErrorMessage4);
																} catch (Exception e) {
																	System.out
																	.println("unable to write dasboard negative pass report for : "
																			+ SuiteName);
																}
															}

															// call forth only
															// if step 3 is
															// working fine..
															// Project_Initiation_Step4_Page
															Thread.sleep(1500);
															// //TIMER
															// START///////
															startTime = System
																	.currentTimeMillis();
															FlagStep4 = obj_Project_Initiation
																	.Project_Initiation_Step4_Page();
															timer = utilfunc
																	.getTimeTakenByModule(startTime);

															utilfunc.updateModuleDataForReportGeneration(
																	SuiteName
																	+ " - Step 4",
																	Employee_namecheck,
																	timer);
															if (!FlagStep4) {
																System.out
																.println("Step 4 Script Failed due to an Exception");
																status = "FAIL";

																utilfunc.TakeScreenshot();
																utilfunc.TestngReportFail1(
																		obj_Project_Initiation.testcaseId,
																		utilfunc.Actualbrw,
																		obj_Project_Initiation.testcasescenario,
																		ActionName,
																		obj_Project_Initiation.testcasedescription,
																		status,
																		utilfunc.ErrorMessage2,
																		utilfunc.ErrorMessage1,
																		utilfunc.ErrorMessage4);
																// now write it
																// in a fail
																// dashboard
																// file..
																try {
																	obj_Report_Dashboard
																	.writeReportHeader(
																			SuiteName,
																			"Old Initiation Step 4",
																			"Fail");
																} catch (Exception e1) {
																}
																try {
																	obj_Report_Dashboard
																	.writeDashBoardFailReport(
																			SuiteName,
																			Employee_namecheck,
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status,
																			timer,
																			utilfunc.ErrorMessage2,
																			utilfunc.ErrorMessage1,
																			utilfunc.ErrorMessage4);
																} catch (Exception e) {
																	System.out
																	.println("unable to write dasboard fail report for : "
																			+ SuiteName);
																}

															} else {

																System.out
																.println("Successfully Executed- Step 4 for Project Initation");
																status = "PASS";

																if (utilfunc.globalerrormessage
																		.equals("")) {
																	utilfunc.TestngReportPass(
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status);
																	// now write
																	// it in a
																	// pass
																	// file..
																	try {
																		obj_Report_Dashboard
																		.writeReportHeader(
																				SuiteName,
																				"Old Initiation Step 4",
																				"Pass");
																	} catch (Exception e1) {
																	}

																	try {
																		obj_Report_Dashboard
																		.writeDashBoardPassReport(
																				SuiteName,
																				Employee_namecheck,
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status,
																				timer);
																	} catch (Exception e) {
																		System.out
																		.println("unable to write dasboard pass report for : "
																				+ SuiteName);
																	}

																} else {
																	utilfunc.TestngReportNegativePassTestcase(
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status,
																			utilfunc.ErrorMessage2,
																			utilfunc.ErrorMessage1,
																			utilfunc.ErrorMessage4);
																	// negative
																	// pass
																	// dashboard
																	// report
																	try {
																		obj_Report_Dashboard
																		.writeReportHeader(
																				SuiteName,
																				"Old Initiation Step 4",
																				"Negative Pass");
																	} catch (Exception e1) {
																	}
																	try {
																		obj_Report_Dashboard
																		.writeDashBoardNegativePassReport(
																				SuiteName,
																				Employee_namecheck,
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status,
																				timer,
																				utilfunc.ErrorMessage2,
																				utilfunc.ErrorMessage1,
																				utilfunc.ErrorMessage4);
																	} catch (Exception e) {
																		System.out
																		.println("unable to write dasboard negative pass report for : "
																				+ SuiteName);
																	}
																}

																// call fifth
																// only if forth
																// is done..

																// Project_Initiation_Step5_Page
																Thread.sleep(1500);
																// //TIMER
																// START///////
																startTime = System
																		.currentTimeMillis();
																FlagStep5 = obj_Project_Initiation
																		.Project_Initiation_Step5_Page();
																timer = utilfunc
																		.getTimeTakenByModule(startTime);

																utilfunc.updateModuleDataForReportGeneration(
																		SuiteName
																		+ " - Step 5",
																		Employee_namecheck,
																		timer);
																if (!FlagStep5) {
																	System.out
																	.println("Script Failed due to an Exception");
																	status = "FAIL";

																	utilfunc.TakeScreenshot();
																	utilfunc.TestngReportFail1(
																			obj_Project_Initiation.testcaseId,
																			utilfunc.Actualbrw,
																			obj_Project_Initiation.testcasescenario,
																			ActionName,
																			obj_Project_Initiation.testcasedescription,
																			status,
																			utilfunc.ErrorMessage2,
																			utilfunc.ErrorMessage1,
																			utilfunc.ErrorMessage4);
																	// now write
																	// it in a
																	// fail
																	// dashboard
																	// file..
																	try {
																		obj_Report_Dashboard
																		.writeReportHeader(
																				SuiteName,
																				"Old Initiation Step 5",
																				"Fail");
																	} catch (Exception e1) {
																	}
																	try {
																		obj_Report_Dashboard
																		.writeDashBoardFailReport(
																				SuiteName,
																				Employee_namecheck,
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status,
																				timer,
																				utilfunc.ErrorMessage2,
																				utilfunc.ErrorMessage1,
																				utilfunc.ErrorMessage4);
																	} catch (Exception e) {
																		System.out
																		.println("unable to write dasboard fail report for : "
																				+ SuiteName);
																	}

																} else {
																	System.out
																	.println("Successfully Executed- Step 5 for Project Initation");
																	status = "PASS";

																	if (utilfunc.globalerrormessage
																			.equals("")) {
																		utilfunc.TestngReportPass(
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status);
																		// now
																		// write
																		// it in
																		// a
																		// pass
																		// file..
																		try {
																			obj_Report_Dashboard
																			.writeReportHeader(
																					SuiteName,
																					"Old Initiation Step 5",
																					"Pass");
																		} catch (Exception e1) {
																		}

																		try {
																			obj_Report_Dashboard
																			.writeDashBoardPassReport(
																					SuiteName,
																					Employee_namecheck,
																					obj_Project_Initiation.testcaseId,
																					utilfunc.Actualbrw,
																					obj_Project_Initiation.testcasescenario,
																					ActionName,
																					obj_Project_Initiation.testcasedescription,
																					status,
																					timer);
																		} catch (Exception e) {
																			System.out
																			.println("unable to write dasboard pass report for : "
																					+ SuiteName);
																		}

																	} else {
																		utilfunc.TestngReportNegativePassTestcase(
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status,
																				utilfunc.ErrorMessage2,
																				utilfunc.ErrorMessage1,
																				utilfunc.ErrorMessage4);
																		// negative
																		// pass
																		// dashboard
																		// report
																		try {
																			obj_Report_Dashboard.writeReportHeader(SuiteName,"Old Initiation Step 5","Negative Pass");
																		} catch (Exception e1) {
																		}
																		try {
																			obj_Report_Dashboard
																			.writeDashBoardNegativePassReport(
																					SuiteName,
																					Employee_namecheck,
																					obj_Project_Initiation.testcaseId,
																					utilfunc.Actualbrw,
																					obj_Project_Initiation.testcasescenario,
																					ActionName,
																					obj_Project_Initiation.testcasedescription,
																					status,
																					timer,
																					utilfunc.ErrorMessage2,
																					utilfunc.ErrorMessage1,
																					utilfunc.ErrorMessage4);
																		} catch (Exception e) {
																			System.out
																			.println("unable to write dasboard negative pass report for : "
																					+ SuiteName);
																		}
																	}

																	// call stp
																	// 6 only if
																	// fifth is
																	// passed

																	// Project_Initiation_Step6_Page
																	Thread.sleep(3500);
																	// //TIMER
																	// START///////
																	startTime = System
																			.currentTimeMillis();
																	FlagStep6 = obj_Project_Initiation
																			.Project_Initiation_Step6_Page();
																	timer = utilfunc
																			.getTimeTakenByModule(startTime);

																	utilfunc.updateModuleDataForReportGeneration(
																			SuiteName
																			+ " - Step 6",
																			Employee_namecheck,
																			timer);
																	if (!FlagStep6) {
																		System.out
																		.println("Script Failed due to an Exception");
																		status = "FAIL";

																		utilfunc.TakeScreenshot();
																		utilfunc.TestngReportFail1(
																				obj_Project_Initiation.testcaseId,
																				utilfunc.Actualbrw,
																				obj_Project_Initiation.testcasescenario,
																				ActionName,
																				obj_Project_Initiation.testcasedescription,
																				status,
																				utilfunc.ErrorMessage2,
																				utilfunc.ErrorMessage1,
																				utilfunc.ErrorMessage4);
																		// now
																		// write
																		// it in
																		// a
																		// fail
																		// dashboard
																		// file..
																		try {
																			obj_Report_Dashboard
																			.writeReportHeader(
																					SuiteName,
																					"Old Initiation Step 6",
																					"Fail");
																		} catch (Exception e1) {
																		}
																		try {
																			obj_Report_Dashboard
																			.writeDashBoardFailReport(
																					SuiteName,
																					Employee_namecheck,
																					obj_Project_Initiation.testcaseId,
																					utilfunc.Actualbrw,
																					obj_Project_Initiation.testcasescenario,
																					ActionName,
																					obj_Project_Initiation.testcasedescription,
																					status,
																					timer,
																					utilfunc.ErrorMessage2,
																					utilfunc.ErrorMessage1,
																					utilfunc.ErrorMessage4);
																		} catch (Exception e) {
																			System.out
																			.println("unable to write dasboard fail report for : "
																					+ SuiteName);
																		}

																	} else {
																		System.out
																		.println("Successfully Executed- Step 6 for Project Initation");
																		status = "PASS";

																		if (utilfunc.globalerrormessage
																				.equals("")) {
																			utilfunc.TestngReportPass(
																					obj_Project_Initiation.testcaseId,
																					utilfunc.Actualbrw,
																					obj_Project_Initiation.testcasescenario,
																					ActionName,
																					obj_Project_Initiation.testcasedescription,
																					status);
																			// now
																			// write
																			// it
																			// in
																			// a
																			// pass
																			// file..
																			try {
																				obj_Report_Dashboard
																				.writeReportHeader(
																						SuiteName,
																						"Old Initiation Step 6",
																						"Pass");
																			} catch (Exception e1) {
																			}

																			try {
																				obj_Report_Dashboard
																				.writeDashBoardPassReport(
																						SuiteName,
																						Employee_namecheck,
																						obj_Project_Initiation.testcaseId,
																						utilfunc.Actualbrw,
																						obj_Project_Initiation.testcasescenario,
																						ActionName,
																						obj_Project_Initiation.testcasedescription,
																						status,
																						timer);
																			} catch (Exception e) {
																				System.out
																				.println("unable to write dasboard pass report for : "
																						+ SuiteName);
																			}

																		} else {
																			utilfunc.TestngReportNegativePassTestcase(
																					obj_Project_Initiation.testcaseId,
																					utilfunc.Actualbrw,
																					obj_Project_Initiation.testcasescenario,
																					ActionName,
																					obj_Project_Initiation.testcasedescription,
																					status,
																					utilfunc.ErrorMessage2,
																					utilfunc.ErrorMessage1,
																					utilfunc.ErrorMessage4);
																			// negative
																			// pass
																			// dashboard
																			// report
																			try {
																				obj_Report_Dashboard
																				.writeReportHeader(
																						SuiteName,
																						"Old Initiation Step 6",
																						"Negative Pass");
																			} catch (Exception e1) {
																			}
																			try {
																				obj_Report_Dashboard
																				.writeDashBoardNegativePassReport(
																						SuiteName,
																						Employee_namecheck,
																						obj_Project_Initiation.testcaseId,
																						utilfunc.Actualbrw,
																						obj_Project_Initiation.testcasescenario,
																						ActionName,
																						obj_Project_Initiation.testcasedescription,
																						status,
																						timer,
																						utilfunc.ErrorMessage2,
																						utilfunc.ErrorMessage1,
																						utilfunc.ErrorMessage4);
																			} catch (Exception e) {
																				System.out
																				.println("unable to write dasboard negative pass report for : "
																						+ SuiteName);
																			}
																		}

																	}
																}

															}
														}
													}


												}

												if(!FlagStep1 || !FlagStep2 ||!FlagStep3 || !FlagStep4 || !FlagStep5 || !FlagStep6){
													OldSPI_failTestCaseCounter = 1;
												}else{
													OldSPI_passTestCaseCounter	=1;
												}

											}catch(Exception e){
												ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
												System.out.println("Script Failed");
												utilfunc.assertion();
												obj_Project_Initiation.TakeScreenshot();
											}





											System.out.println("========\n========\n========");
											System.out.println("OldSPI_PositiveScenarioCounter : "+OldSPI_PositiveScenarioCounter);
											System.out.println("OldSPI_NegativeScenarioCounter : "+OldSPI_NegativeScenarioCounter);
											System.out.println("OldSPI_TotalTestCaseCounter : "+OldSPI_TotalTestCaseCounter);
											System.out.println("OldSPI_passTestCaseCounter : "+OldSPI_passTestCaseCounter);
											System.out.println("OldSPI_failTestCaseCounter : "+OldSPI_failTestCaseCounter);
											System.out.println("OldSPI_NotAssignedModuleCounter : "+OldSPI_NotAssignedModuleCounter);
											System.out.println("========\n========\n========");

											// adding dashboard code here..
											String OldSPI_PositiveScenarioCount="";
											String OldSPI_NegativeScenarioCount="";
											String OldSPI_ModuleCount="";
											String OldSPI_TotalTestCaseCount="";
											String OldSPI_FinalPositiveCount="";
											String OldSPI_FinalNegativeCount="";
											String OldSPI_NotAssignedModuleCount="";

											try{	OldSPI_PositiveScenarioCount			=	Integer.toString(OldSPI_PositiveScenarioCounter);	}catch(Exception error){}
											try{	OldSPI_NegativeScenarioCount			=	Integer.toString(OldSPI_NegativeScenarioCounter);	}catch(Exception error){}
											try{	OldSPI_ModuleCount						=	Integer.toString(OldSPI_ModuleCounter);			}catch(Exception error){}
											try{	OldSPI_TotalTestCaseCount				=	Integer.toString(OldSPI_TotalTestCaseCounter);	}catch(Exception error){}
											try{	OldSPI_FinalPositiveCount				=	Integer.toString(OldSPI_passTestCaseCounter);	}catch(Exception error){}
											try{	OldSPI_FinalNegativeCount				=	Integer.toString(OldSPI_failTestCaseCounter);	}catch(Exception error){}
											try{	OldSPI_NotAssignedModuleCount			=	Integer.toString(OldSPI_NotAssignedModuleCounter);	}catch(Exception error){}

											//utilfunc.TestngDashBoardReport("Left Navigation",OldSPI_ModuleCount,OldSPI_TotalTestCaseCount,OldSPI_PositiveScenarioCount,OldSPI_NegativeScenarioCount,OldSPI_FinalPositiveCount,OldSPI_FinalNegativeCount,OldSPI_NotAssignedModuleCount,OldSPI_NotAssignedModuleCount);
											TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
											try{
												obj_Report_Dashboard.generateReportForSuite(SuiteName,OldSPI_ModuleCount,OldSPI_TotalTestCaseCount,OldSPI_PositiveScenarioCount,OldSPI_NegativeScenarioCount,
														OldSPI_FinalPositiveCount,OldSPI_FinalNegativeCount,TotalTime,OldSPI_NotAssignedModuleCount);
											}catch(Exception e){
												System.out.println("unable to call & generate dashboard report for old..");
											}




										}

										else if(SuiteName.equals("Initiate a single project")){
											//openSuite==false;
											System.out.println("We are here");
											if(openSuite==true){//Initiate a single project assigned
												String InitiateSingleProject_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

												if(InitiateSingleProject_Scenariotext.equals("Positive") || InitiateSingleProject_Scenariotext.contains("sitive") || InitiateSingleProject_Scenariotext.contains("Pos")){
													InitiateSingleproject_PositiveScenarioCounter++;
												}else if(InitiateSingleProject_Scenariotext.equals("Negative") || InitiateSingleProject_Scenariotext.contains("gative") || InitiateSingleProject_Scenariotext.contains("gavtive") ){
													InitiateSingleproject_NegativeScenarioCounter++;
												}
												InitiateSingleproject_TotalTestCaseCounter++;
												try{
													Page_flag	=	obj_CIMS_Single_Project_Initiation.Single_Project_Initiation_Suite(fileName,sheetName,count,ActionName,Employee_namecheck);
												}catch(Exception error){}

												timer = utilfunc.getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(SuiteName+" Final Report", Employee_namecheck, timer);

												//								}else{

												if (Page_flag)
												{
													status="PASS";
													InitiateSingleproject_passTestCaseCounter++;

													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio, ActionName, obj_CIMS_Single_Project_Initiation.description, status);
														// now write it in a pass file START...
														if(InitiateSingleproject_PassFlag==false){
															try {	obj_Report_Dashboard.writeReportHeader(SuiteName+" Final Report", SuiteName, "Pass");
															}catch(Exception e){}
															InitiateSingleproject_PassFlag=true;
														}// now write it in a pass file ENDS...

														//Write Positive Pass dashboard report 
														try {
															obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio, ActionName, obj_CIMS_Single_Project_Initiation.description, status, timer);
														}catch(Exception e){
															System.out.println("unable to write dasboard pass report for : "+SuiteName+" Final Report");}
													}
													else
													{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Single_Project_Initiation.scenerio,ActionName,obj_CIMS_Single_Project_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														// now write it in a negative pass dashboard file START...
														if(InitiateSingleproject_NegativePassFlag==false){
															try {	obj_Report_Dashboard.writeReportHeader(SuiteName+" Final Report", SuiteName,"Negative Pass");
															}catch(Exception e){}
															InitiateSingleproject_NegativePassFlag=true;
														}// now write it in a negative pass dashboard file ENDS...

														//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
														try {
															obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Single_Project_Initiation.testcaseid,utilfunc.Actualbrw,obj_CIMS_Single_Project_Initiation.scenerio,ActionName,obj_CIMS_Single_Project_Initiation.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														} catch (Exception e) {
															System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
													}
													/*if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio, ActionName, obj_CIMS_Single_Project_Initiation.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
													 */
												}
												else
												{
													status="FAIL";
													InitiateSingleproject_failTestCaseCounter++;
													utilfunc.TakeScreenshot();

													utilfunc.TestngReportFail1(obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio,ActionName, obj_CIMS_Single_Project_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a fail dashboard file START...
													if(InitiateSingleproject_FailFlag==false){
														try{ obj_Report_Dashboard.writeReportHeader(SuiteName+" Final Report", SuiteName,"Fail");
														}catch(Exception e){}
														InitiateSingleproject_FailFlag=true;
													}// now write it in a fail dashboard file ENDS...
													try {
														obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio,ActionName, obj_CIMS_Single_Project_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard fail report for : "+SuiteName);}
													/*if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio,ActionName, obj_CIMS_Single_Project_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
													 */
												}
											}else{//Initiate a single project not assigned
												timer = utilfunc.getTimeTakenByModule(startTime);
												status="PASS";
												String InitiateSingleproject_Errormessage="";
												String InitiateSingleproject_NotAssignTestCaseID="";
												String InitiateSingleproject_NotAssignScenerio="";
												String InitiateSingleproject_NotAssignTestCaseDescription="";

												int InitiateSingleproject_columnNumber_TCID;
												int InitiateSingleproject_columnNumber_Scenario;
												int InitiateSingleproject_columnNumber_TestCaseDescription;

												utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
												InitiateSingleproject_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(InitiateSingleproject_Errormessage);

												InitiateSingleproject_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
												InitiateSingleproject_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
												InitiateSingleproject_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

												InitiateSingleproject_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, InitiateSingleproject_columnNumber_TCID, count);
												InitiateSingleproject_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, InitiateSingleproject_columnNumber_Scenario, count);
												InitiateSingleproject_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, InitiateSingleproject_columnNumber_TestCaseDescription, count);

												utilfunc.TestngReportFail(InitiateSingleproject_NotAssignTestCaseID, utilfunc.Actualbrw, InitiateSingleproject_NotAssignScenerio,ActionName,InitiateSingleproject_NotAssignTestCaseDescription,status,InitiateSingleproject_Errormessage);

												//now write it in a notAssign file START...
												if(InitiateSingleproject_NotassignFlag==false){
													try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
													}catch(Exception e){}
													InitiateSingleproject_NotassignFlag=true;
												}//now write it in a notAssign file ENDS...
												InitiateSingleproject_NotAssignedModuleCounter=1;	

												try {
													obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, InitiateSingleproject_NotAssignTestCaseID, utilfunc.Actualbrw, InitiateSingleproject_NotAssignScenerio, ActionName, InitiateSingleproject_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
												} catch (InterruptedException e) {
													System.out.println("unable to write Not Assign report");}
											}
										}

									}else if(SuiteName.equals("Initiate multiple projects")){

										// multiple projects code starts here..
										suiteLink			=		LinkPrefix	+	"//*[contains(@href,'multi')]";
										openSuite =	utilfunc.waitForAnElementToLoad(suiteLink, true);
										utilfunc.MakeElement(suiteLink).click();
										System.out.println("calling "+SuiteName+" module..");
										////TIMER START///////
										startTime = System.currentTimeMillis();

										if(openSuite==true){//assigned
											System.out.println("Initiate multiple projects is assigned...");
											String InitiateMultiProject_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

											if(InitiateMultiProject_Scenariotext.equals("Positive") || InitiateMultiProject_Scenariotext.contains("sitive") || InitiateMultiProject_Scenariotext.contains("Pos")){
												InitiateMultipleProjects_PositiveScenarioCounter++;
											}else if(InitiateMultiProject_Scenariotext.equals("Negative") || InitiateMultiProject_Scenariotext.contains("gative") || InitiateMultiProject_Scenariotext.contains("gavtive") ){
												InitiateMultipleProjects_NegativeScenarioCounter++;
											}
											InitiateMultipleProjects_TotalTestCaseCounter++;

											try{
												Page_flag	=	obj_CIMS_Regresssion_Suite_Bulk_Initiation.Bulk_Initiation(fileName,SuiteName,count,ActionName);
											}catch(Exception error){}

											timer = utilfunc.getTimeTakenByModule(startTime);

											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);

											if (Page_flag)
											{
												status="PASS";
												InitiateMultipleProjects_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio, ActionName, obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status);
													// now write it in a pass file START...
													if(InitiateMultipleProjects_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														InitiateMultipleProjects_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio, ActionName, obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio,ActionName,obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(InitiateMultipleProjects_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														InitiateMultipleProjects_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio,ActionName,obj_CIMS_Regresssion_Suite_Bulk_Initiation.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}

												}
												/*if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio, ActionName, obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												InitiateMultipleProjects_failTestCaseCounter++;
												utilfunc.TakeScreenshot();

												utilfunc.TestngReportFail1(obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio,ActionName, obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(InitiateMultipleProjects_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													InitiateMultipleProjects_FailFlag=true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Single_Project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Single_Project_Initiation.scenerio,ActionName, obj_CIMS_Single_Project_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}

												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regresssion_Suite_Bulk_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regresssion_Suite_Bulk_Initiation.scenerio,ActionName, obj_CIMS_Regresssion_Suite_Bulk_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}else{	//Not Assigned
											System.out.println("Initiate multiple projects is assigned...");

											timer = utilfunc.getTimeTakenByModule(startTime);
											status="PASS";

											String InitiateMultipleProjects_Errormessage="";
											String InitiateMultipleProjects_NotAssignTestCaseID="";
											String InitiateMultipleProjects_NotAssignScenerio="";
											String InitiateMultipleProjects_NotAssignTestCaseDescription="";

											int InitiateMultipleProjects_columnNumber_TCID;
											int InitiateMultipleProjects_columnNumber_Scenario;
											int InitiateMultipleProjects_columnNumber_TestCaseDescription;

											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											InitiateMultipleProjects_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
											System.out.println(InitiateMultipleProjects_Errormessage);

											InitiateMultipleProjects_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
											InitiateMultipleProjects_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
											InitiateMultipleProjects_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

											InitiateMultipleProjects_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, InitiateMultipleProjects_columnNumber_TCID, count);
											InitiateMultipleProjects_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, InitiateMultipleProjects_columnNumber_Scenario, count);
											InitiateMultipleProjects_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, InitiateMultipleProjects_columnNumber_TestCaseDescription, count);

											utilfunc.TestngReportFail(InitiateMultipleProjects_NotAssignTestCaseID, utilfunc.Actualbrw, InitiateMultipleProjects_NotAssignScenerio,ActionName,InitiateMultipleProjects_NotAssignTestCaseDescription,status,InitiateMultipleProjects_Errormessage);

											//now write it in a notAssign file START...
											if(InitiateMultipleProjects_NotassignFlag==false){
												try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
												}catch(Exception e){}
												InitiateMultipleProjects_NotassignFlag=true;
											}//now write it in a notAssign file ENDS...
											InitiateMultipleProjects_NotAssignedModuleCounter=1;	

											try {
												obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, InitiateMultipleProjects_NotAssignTestCaseID, utilfunc.Actualbrw, InitiateMultipleProjects_NotAssignScenerio, ActionName, InitiateMultipleProjects_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
											} catch (InterruptedException e) {
												System.out.println("unable to write Not Assign report");}

										}



									}//Initiate multiple projects ends Here

									//System.out.println("suite link: "+suiteLink);
								}


								// Lokesh add these line(s) on 06-May-2016 for Advance Project search
								else if(SuiteName.equals("Advanced Search Project"))
								{
									String AdvancedSearchProject_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(AdvancedSearchProject_Scenariotext.equals("Positive") || AdvancedSearchProject_Scenariotext.contains("sitive") || AdvancedSearchProject_Scenariotext.contains("Pos")){
										AdvanceSearchProject_PositiveScenarioCounter++;
									}else if(AdvancedSearchProject_Scenariotext.equals("Negative") || AdvancedSearchProject_Scenariotext.contains("gative") || AdvancedSearchProject_Scenariotext.contains("gavtive") ){
										AdvanceSearchProject_NegativeScenarioCounter++;
									}
									AdvanceSearchProject_TotalTestCaseCounter++;


									String AdvSProjectisAssignedorNot_gettext="";
									String AdvSProjectsisAssignedorNot_Xpath="//*[@id='gn-menu']//*[text()='Projects']"; 
									try{
										Thread.sleep(1500);
										AdvSProjectisAssignedorNot_gettext=utilfunc.MakeElement(AdvSProjectsisAssignedorNot_Xpath).getText();
									}catch(Exception error){}

									utilfunc.ErrorMessage1="";
									utilfunc.ErrorMessage2="";
									utilfunc.ErrorMessage4="";
									utilfunc.ErrorMessage5="";
									utilfunc.globalerrormessage="";

									startTime = System.currentTimeMillis();

									//check News is assigned to the user or not.
									if(AdvSProjectisAssignedorNot_gettext.equalsIgnoreCase("Projects"))
									{
										utilfunc.ErrorMessage1="";
										utilfunc.ErrorMessage2="";
										utilfunc.ErrorMessage4="";
										utilfunc.ErrorMessage5="";
										utilfunc.globalerrormessage="";

										// click on link
										try{
											utilfunc.MakeElement(AdvSProjectsisAssignedorNot_Xpath).click();
										}catch(Exception e){
											System.out.println("unable to click on Projects icons");
										}
										try{
											try{
												Page_flag	=	obj_Project_Search.advanced_Project_Search(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												AdvanceSearchProject_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{

													utilfunc.TestngReportPass(obj_Project_Search.testcaseid, utilfunc.Actualbrw, obj_Project_Search.scenerio, ActionName, obj_Project_Search.description, status);

													// now write it in a pass file START...
													if(AdvanceSearchProject_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														AdvanceSearchProject_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_Project_Search.testcaseid, utilfunc.Actualbrw, obj_Project_Search.scenerio, ActionName, obj_Project_Search.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{

													utilfunc.TestngReportNegativePassTestcase(obj_Project_Search.testcaseid, utilfunc.Actualbrw,obj_Project_Search.scenerio,ActionName,obj_Project_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

													// now write it in a negative pass dashboard file START...
													if(AdvanceSearchProject_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														AdvanceSearchProject_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_Project_Search.testcaseid,utilfunc.Actualbrw,obj_Project_Search.scenerio,ActionName,obj_Project_Search.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*												if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_Project_Search.testcaseid, utilfunc.Actualbrw, obj_Project_Search.scenerio, ActionName, obj_Project_Search.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */											}
											else
											{
												status="FAIL";
												AdvanceSearchProject_failTestCaseCounter++;

												//utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_Project_Search.testcaseid, utilfunc.Actualbrw, obj_Project_Search.scenerio,ActionName, obj_Project_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(AdvanceSearchProject_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													AdvanceSearchProject_FailFlag	= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_Project_Search.testcaseid, utilfunc.Actualbrw, obj_Project_Search.scenerio,ActionName, obj_Project_Search.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
									else
									{	//Advance Project Search is not assigned to the user
										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String AdvanceSearchProject_Errormessage="";
										String AdvanceSearchProject_NotAssignTestCaseID="";
										String AdvanceSearchProject_NotAssignScenerio="";
										String AdvanceSearchProject_NotAssignTestCaseDescription="";
										int AdvanceSearchProject_columnNumber_TCID;
										int AdvanceSearchProject_columnNumber_Scenario;
										int AdvanceSearchProject_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										AdvanceSearchProject_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(AdvanceSearchProject_Errormessage);

										AdvanceSearchProject_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										AdvanceSearchProject_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										AdvanceSearchProject_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										AdvanceSearchProject_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchProject_columnNumber_TCID, count);
										AdvanceSearchProject_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchProject_columnNumber_Scenario, count);
										AdvanceSearchProject_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchProject_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(AdvanceSearchProject_NotAssignTestCaseID, utilfunc.Actualbrw, AdvanceSearchProject_NotAssignScenerio,ActionName,AdvanceSearchProject_NotAssignTestCaseDescription,status,AdvanceSearchProject_Errormessage);

										//now write it in a notAssign file START...
										if(AdvanceSearchProject_NotAssignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											AdvanceSearchProject_NotAssignFlag=true;
										}//now write it in a notAssign file ENDS...
										AdvanceSearchProject_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, AdvanceSearchProject_NotAssignTestCaseID, utilfunc.Actualbrw, AdvanceSearchProject_NotAssignScenerio, ActionName, AdvanceSearchProject_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}
								}
								// Lokesh add above line(s) on 06-May-2016 for Advance Project search


								//* code for advanced employee  search..
								else if(SuiteName.equals("Advanced Search Employee"))
								{
									String AdvanceSearchEmployee_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(AdvanceSearchEmployee_Scenariotext.equals("Positive") || AdvanceSearchEmployee_Scenariotext.contains("sitive") || AdvanceSearchEmployee_Scenariotext.contains("Pos")){
										AdvanceSearchEmployee_PositiveScenarioCounter++;
									}else if(AdvanceSearchEmployee_Scenariotext.equals("Negative") || AdvanceSearchEmployee_Scenariotext.contains("gative") || AdvanceSearchEmployee_Scenariotext.contains("gavtive") ){
										AdvanceSearchEmployee_NegativeScenarioCounter++;
									}
									AdvanceSearchEmployee_TotalTestCaseCounter++;


									String AdvSEmpisAssignedorNot_gettext="";
									String AdvSEmpisAssignedorNot_Xpath="//*[@id='gn-menu']//*[text()='Employees']"; 
									try{
										Thread.sleep(1500);
										AdvSEmpisAssignedorNot_gettext=utilfunc.MakeElement(AdvSEmpisAssignedorNot_Xpath).getText();
									}catch(Exception error){}

									startTime = System.currentTimeMillis();

									//check News is assigned to the user or not.
									if(AdvSEmpisAssignedorNot_gettext.equalsIgnoreCase("Employees"))
									{
										// click on link
										try{
											utilfunc.MakeElement(AdvSEmpisAssignedorNot_Xpath).click();
										}catch(Exception e){
											System.out.println("unable to click on employee icons");
										}
										try{
											try{
												Page_flag	=	obj_Employee_Search.advanced_Employee_Search(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												AdvanceSearchEmployee_passTestCaseCounter++;

												if(utilfunc.globalerrormessage.equals(""))
												{											
													utilfunc.TestngReportPass(obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio, ActionName, obj_Employee_Search.description, status);
													// now write it in a pass file START...
													if(AdvanceSearchEmployee_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														AdvanceSearchEmployee_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio, ActionName, obj_Employee_Search.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_Employee_Search.testcaseid, utilfunc.Actualbrw,obj_Employee_Search.scenerio,ActionName,obj_Employee_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(AdvanceSearchEmployee_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														AdvanceSearchEmployee_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_Employee_Search.testcaseid,utilfunc.Actualbrw,obj_Employee_Search.scenerio,ActionName,obj_Employee_Search.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
													/*if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio, ActionName, obj_Employee_Search.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
													 */
												}
											}
											else
											{
												status="FAIL";
												AdvanceSearchEmployee_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio,ActionName, obj_Employee_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(AdvanceSearchEmployee_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													AdvanceSearchEmployee_FailFlag	= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio,ActionName, obj_Employee_Search.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}

												/*if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_Employee_Search.testcaseid, utilfunc.Actualbrw, obj_Employee_Search.scenerio,ActionName, obj_Employee_Search.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
									else
									{//News is not assigned to the user


										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String AdvanceSearchEmployee_Errormessage="";
										String AdvanceSearchEmployee_NotAssignTestCaseID="";
										String AdvanceSearchEmployee_NotAssignScenerio="";
										String AdvanceSearchEmployee_NotAssignTestCaseDescription="";
										int AdvanceSearchEmployee_columnNumber_TCID;
										int AdvanceSearchEmployee_columnNumber_Scenario;
										int AdvanceSearchEmployee_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										AdvanceSearchEmployee_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(AdvanceSearchEmployee_Errormessage);

										AdvanceSearchEmployee_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										AdvanceSearchEmployee_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										AdvanceSearchEmployee_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										AdvanceSearchEmployee_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchEmployee_columnNumber_TCID, count);
										AdvanceSearchEmployee_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchEmployee_columnNumber_Scenario, count);
										AdvanceSearchEmployee_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, AdvanceSearchEmployee_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(AdvanceSearchEmployee_NotAssignTestCaseID, utilfunc.Actualbrw, AdvanceSearchEmployee_NotAssignScenerio,ActionName,AdvanceSearchEmployee_NotAssignTestCaseDescription,status,AdvanceSearchEmployee_Errormessage);
										//now write it in a notAssign file START...
										if(AdvanceSearchEmployee_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											AdvanceSearchEmployee_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										AdvanceSearchEmployee_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, AdvanceSearchEmployee_NotAssignTestCaseID, utilfunc.Actualbrw, AdvanceSearchEmployee_NotAssignScenerio, ActionName, AdvanceSearchEmployee_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								}
								//* advanced employee search **/



								// secure messaging.. //
								else if(SuiteName.equals("Secure Messaging")){
									System.out.println("Execution of Secure Messaging module start here...");
									String SecureMessaging_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(SecureMessaging_Scenariotext.equals("Positive") || SecureMessaging_Scenariotext.contains("sitive") || SecureMessaging_Scenariotext.contains("Pos")){
										SecureMessaging_PositiveScenarioCounter++;
									}else if(SecureMessaging_Scenariotext.equals("Negative") || SecureMessaging_Scenariotext.contains("gative") || SecureMessaging_Scenariotext.contains("gavtive") ){
										SecureMessaging_NegativeScenarioCounter++;
									}
									SecureMessaging_TotalTestCaseCounter++;

									boolean SecureMessagingAllocatedorNot=false;
									String BalNoXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[2]";
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(BalNoXpath).click();
									} catch (Exception e1) {
										System.out.println("==Unable to click on the bal no==");
									}

//									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(1500);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}

									String MessagelinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Message')]";
//									boolean ProjectDetailIsAssignOrNot=false;
//									try {
//										Thread.sleep(1500);
//										utilfunc.MakeElement(MessagelinkXpath).click();
//										ProjectDetailIsAssignOrNot=true;
//									} catch (Exception e1) {
//
//										System.out.println("==Unable to click on the process and questionnaire==");
//
//									}


									SecureMessagingAllocatedorNot=utilfunc.waitForAnElementToLoad(MessagelinkXpath, true);

									if(SecureMessagingAllocatedorNot==true)
									{//Allocated
										// click on link
										try {
											Thread.sleep(1500);
											utilfunc.MakeElement(MessagelinkXpath).click();
											//ProjectDetailIsAssignOrNot=true;
										} catch (Exception e1) {

											System.out.println("==Unable to click on the process and questionnaire==");

										}
										try{

											try{
												Page_flag	=	obj_CIMS_Secure_Messaging.Secure_Messaging(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											if (Page_flag)
											{
												status="PASS";
												SecureMessaging_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio, ActionName, obj_CIMS_Secure_Messaging.description, status);
													// now write it in a pass file START...
													if(Securemessaging_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														Securemessaging_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio, ActionName, obj_CIMS_Secure_Messaging.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw,obj_CIMS_Secure_Messaging.scenerio,ActionName,obj_CIMS_Secure_Messaging.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(Securemessaging_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														Securemessaging_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Secure_Messaging.testcaseid,utilfunc.Actualbrw,obj_CIMS_Secure_Messaging.scenerio,ActionName,obj_CIMS_Secure_Messaging.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio, ActionName, obj_CIMS_Secure_Messaging.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												SecureMessaging_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio,ActionName, obj_CIMS_Secure_Messaging.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(Securemessaging_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													Securemessaging_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio,ActionName, obj_CIMS_Secure_Messaging.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Secure_Messaging.testcaseid, utilfunc.Actualbrw, obj_CIMS_Secure_Messaging.scenerio,ActionName, obj_CIMS_Secure_Messaging.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String SecureMessaging_Errormessage="";
										String SecureMessaging_NotAssignTestCaseID="";
										String SecureMessaging_NotAssignScenerio="";
										String SecureMessaging_NotAssignTestCaseDescription="";
										int SecureMessaging_columnNumber_TCID;
										int SecureMessaging_columnNumber_Scenario;
										int SecureMessaging_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										SecureMessaging_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(SecureMessaging_Errormessage);

										SecureMessaging_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										SecureMessaging_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										SecureMessaging_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										SecureMessaging_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, SecureMessaging_columnNumber_TCID, count);
										SecureMessaging_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, SecureMessaging_columnNumber_Scenario, count);
										SecureMessaging_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, SecureMessaging_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(SecureMessaging_NotAssignTestCaseID, utilfunc.Actualbrw, SecureMessaging_NotAssignScenerio,ActionName,SecureMessaging_NotAssignTestCaseDescription,status,SecureMessaging_Errormessage);
										//now write it in a notAssign file START...
										if(Securemessaging_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											Securemessaging_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										SecureMessaging_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, SecureMessaging_NotAssignTestCaseID, utilfunc.Actualbrw, SecureMessaging_NotAssignScenerio, ActionName, SecureMessaging_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								}
								// secure messaging ends here //
								
								
//Project detail code start here 
								
								else if(SuiteName.equals("Project Detail")){
									

									System.out.println("Execution of Project Detail module start here...");
									String ProjectDetail_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(ProjectDetail_Scenariotext.equals("Positive") || ProjectDetail_Scenariotext.contains("sitive") || ProjectDetail_Scenariotext.contains("Pos")){
										Projectdetail_PositiveScenarioCounter++;
									}else if(ProjectDetail_Scenariotext.equals("Negative") || ProjectDetail_Scenariotext.contains("gative") || ProjectDetail_Scenariotext.contains("gavtive") ){
										Projectdetail_NegativeScenarioCounter++;
									}
									Projectdetail_TotalTestCaseCounter++;
									
									String BalNoXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[2]";
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(BalNoXpath).click();
									} catch (Exception e1) {
										System.out.println("==Unable to click on the bal no==");
									}

//									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(1500);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}

									String ProjectdetaillinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Project Detail')]";
									boolean ProjectDetailIsAssignOrNot=false;
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(ProjectdetaillinkXpath).click();
										ProjectDetailIsAssignOrNot=true;
									} catch (Exception e1) {

										System.out.println("==Unable to click on the process and questionnaire==");

									}


									if(ProjectDetailIsAssignOrNot==true)
									{//Allocated
										// click on link
										
										try{

											try{
												Page_flag	=	obj_CIMS_Project_Detail.Project_Detail(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//		utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

											if (Page_flag)
											{
												status="PASS";
												Projectdetail_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio, ActionName, obj_CIMS_Project_Detail.description, status);
													// now write it in a pass file START...
													if(Projectdetail_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														Projectdetail_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio, ActionName, obj_CIMS_Project_Detail.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_Detail.scenerio,ActionName,obj_CIMS_Project_Detail.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(Projectdetail_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														Projectdetail_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Project_Detail.testcaseid,utilfunc.Actualbrw,obj_CIMS_Project_Detail.scenerio,ActionName,obj_CIMS_Project_Detail.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio, ActionName, obj_CIMS_Project_Detail.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												Projectdetail_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio,ActionName, obj_CIMS_Project_Detail.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(Projectdetail_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													Projectdetail_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio,ActionName, obj_CIMS_Project_Detail.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_Detail.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Detail.scenerio,ActionName, obj_CIMS_Project_Detail.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String Projectdetail_Errormessage="";
										String Projectdetail_NotAssignTestCaseID="";
										String Projectdetail_NotAssignScenerio="";
										String Projectdetail_NotAssignTestCaseDescription="";
										int Projectdetail_columnNumber_TCID;
										int Projectdetail_columnNumber_Scenario;
										int Projectdetail_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

										Projectdetail_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Projectdetail_Errormessage);

										Projectdetail_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										Projectdetail_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										Projectdetail_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										Projectdetail_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, Projectdetail_columnNumber_TCID, count);
										Projectdetail_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, Projectdetail_columnNumber_Scenario, count);
										Projectdetail_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, Projectdetail_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(Projectdetail_NotAssignTestCaseID, utilfunc.Actualbrw, Projectdetail_NotAssignScenerio,ActionName,Projectdetail_NotAssignTestCaseDescription,status,Projectdetail_Errormessage);
										//now write it in a notAssign file START...
										if(Projectdetail_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											Projectdetail_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										Projectdetail_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, Projectdetail_NotAssignTestCaseID, utilfunc.Actualbrw, Projectdetail_NotAssignScenerio, ActionName, Projectdetail_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								
									
									
								}
								
								
								
								//Project detail code end here 
								
								// Project summary code start here
								
								else if (SuiteName.equals("Project Summary")){
									

									System.out.println("Execution of Project Detail module start here...");
									String Projectsummary_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(Projectsummary_Scenariotext.equals("Positive") || Projectsummary_Scenariotext.contains("sitive") || Projectsummary_Scenariotext.contains("Pos")){
										Projectsummary_PositiveScenarioCounter++;
									}else if(Projectsummary_Scenariotext.equals("Negative") || Projectsummary_Scenariotext.contains("gative") || Projectsummary_Scenariotext.contains("gavtive") ){
										Projectsummary_NegativeScenarioCounter++;
									}
									Projectsummary_TotalTestCaseCounter++;
									
									String UserprofileXpath =".//*[@id='user-profile']";
									
									String MyProjectXpath=".//*[contains(@class,'pull-right')]//*[contains(@class,'dropdown-menu')]//*[text()='My Projects']";

//									
//									try {
//										Thread.sleep(3000);
//										utilfunc.MakeElement(UserprofileXpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("unable to click on the link ");
//									}
//									
									try {
										Thread.sleep(3000);
										utilfunc.MakeElement(MyProjectXpath).click();
										Thread.sleep(3000);
									} catch (Exception e) {
										System.out.println("Unable to click on the my profile link");
										}
									
                                        String ProjectNoXpath=".//*[@class='table table-item-list']//tbody/tr[1]//td[1]//*[@class='desc4']";
									
									try {
										Thread.sleep(3000);
										utilfunc.MakeElement(ProjectNoXpath).click();
										Thread.sleep(3000);
									} catch (Exception e2) {
										System.out.println("Unable to click on the project no");
									}

//									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(3000);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}
									
									

									String ProjectdetaillinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Project Summary')]";
									boolean ProjectsummaryIsAssignOrNot=false;
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(ProjectdetaillinkXpath).click();
										ProjectsummaryIsAssignOrNot=true;
									} catch (Exception e1) {

										System.out.println("==Unable to click on the project summary==");

									}


									if(ProjectsummaryIsAssignOrNot==true)
									{//Allocated
										// click on link
										
										try{

											try{
												Page_flag	=	obj_CIMS_Project_Summary.Project_Summary(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//		utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

											if (Page_flag)
											{
												status="PASS";
												Projectsummary_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio, ActionName, obj_CIMS_Project_Summary.description, status);
													// now write it in a pass file START...
													if(Projectsummary_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														Projectsummary_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio, ActionName, obj_CIMS_Project_Summary.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_Summary.scenerio,ActionName,obj_CIMS_Project_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(Projectsummary_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														Projectsummary_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Project_Summary.testcaseid,utilfunc.Actualbrw,obj_CIMS_Project_Summary.scenerio,ActionName,obj_CIMS_Project_Summary.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio, ActionName, obj_CIMS_Project_Summary.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												Projectsummary_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio,ActionName, obj_CIMS_Project_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(Projectsummary_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													Projectsummary_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio,ActionName, obj_CIMS_Project_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_Summary.scenerio,ActionName, obj_CIMS_Project_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String Projectsummary_Errormessage="";
										String Projectsummary_NotAssignTestCaseID="";
										String Projectsummary_NotAssignScenerio="";
										String Projectsummary_NotAssignTestCaseDescription="";
										int Projectsummary_columnNumber_TCID;
										int Projectsummary_columnNumber_Scenario;
										int Projectsummary_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

										Projectsummary_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Projectsummary_Errormessage);

										Projectsummary_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										Projectsummary_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										Projectsummary_columnNumber_TestCaseDescription		    =    		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										Projectsummary_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, Projectsummary_columnNumber_TCID, count);
										Projectsummary_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, Projectsummary_columnNumber_Scenario, count);
										Projectsummary_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, Projectsummary_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(Projectsummary_NotAssignTestCaseID, utilfunc.Actualbrw, Projectsummary_NotAssignScenerio,ActionName,Projectsummary_NotAssignTestCaseDescription,status,Projectsummary_Errormessage);
										//now write it in a notAssign file START...
										if(Projectsummary_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											Projectsummary_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										Projectsummary_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, Projectsummary_NotAssignTestCaseID, utilfunc.Actualbrw, Projectsummary_NotAssignScenerio, ActionName, Projectsummary_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								
									
									
								
									
									
									
								}

								// Project summary code end here
								
								else if(SuiteName.equals("Assessment Summary")){

									

									System.out.println("Execution of Assessment Detail module start here...");
									String Assessmentsummary_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(Assessmentsummary_Scenariotext.equals("Positive") || Assessmentsummary_Scenariotext.contains("sitive") || Assessmentsummary_Scenariotext.contains("Pos")){
										Assessmentsummary_PositiveScenarioCounter++;
									}else if(Assessmentsummary_Scenariotext.equals("Negative") || Assessmentsummary_Scenariotext.contains("gative") || Assessmentsummary_Scenariotext.contains("gavtive") ){
										Assessmentsummary_NegativeScenarioCounter++;
									}
									Assessmentsummary_TotalTestCaseCounter++;
									
									String UserprofileXpath =".//*[@id='user-profile']";
									
									String MyProjectXpath=".//*[contains(@class,'pull-right')]//*[contains(@class,'dropdown-menu')]//*[text()='My Projects']";

//									
//									try {
//										Thread.sleep(3000);
//										utilfunc.MakeElement(UserprofileXpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("unable to click on the link ");
//									}
//									
//									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(3000);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}
									
									

									String AssessmentSummarylinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Assessment Summary')]";
									boolean AssessmentsummaryIsAssignOrNot=false;
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(AssessmentSummarylinkXpath).click();
										AssessmentsummaryIsAssignOrNot=true;
									} catch (Exception e1) {

										System.out.println("==Unable to click on the project summary==");

									}


									if(AssessmentsummaryIsAssignOrNot==true)
									{//Allocated
										// click on link
										
										try{

											try{
												Page_flag	=	obj_CIMS_Assessment_Summary.Assessment_Summary(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//		utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

											if (Page_flag)
											{
												status="PASS";
												Assessmentsummary_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio, ActionName, obj_CIMS_Assessment_Summary.description, status);
													// now write it in a pass file START...
													if(Assessmentsummary_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														Assessmentsummary_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio, ActionName, obj_CIMS_Assessment_Summary.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw,obj_CIMS_Assessment_Summary.scenerio,ActionName,obj_CIMS_Assessment_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(Assessmentsummary_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														Assessmentsummary_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Assessment_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Assessment_Summary.testcaseid,utilfunc.Actualbrw,obj_CIMS_Assessment_Summary.scenerio,ActionName,obj_CIMS_Assessment_Summary.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio, ActionName, obj_CIMS_Assessment_Summary.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												Assessmentsummary_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio,ActionName, obj_CIMS_Assessment_Summary.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(Assessmentsummary_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													Assessmentsummary_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio,ActionName, obj_CIMS_Assessment_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Assessment_Summary.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Summary.scenerio,ActionName, obj_CIMS_Assessment_Summary.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String Assessmentsummary_Errormessage="";
										String Assessmentsummary_NotAssignTestCaseID="";
										String Assessmentsummary_NotAssignScenerio="";
										String Assessmentsummary_NotAssignTestCaseDescription="";
										int Assessmentsummary_columnNumber_TCID;
										int Assessmentsummary_columnNumber_Scenario;
										int Assessmentsummary_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

										Assessmentsummary_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Assessmentsummary_Errormessage);

										Assessmentsummary_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										Assessmentsummary_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										Assessmentsummary_columnNumber_TestCaseDescription		    =    		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										Assessmentsummary_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, Assessmentsummary_columnNumber_TCID, count);
										Assessmentsummary_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, Assessmentsummary_columnNumber_Scenario, count);
										Assessmentsummary_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, Assessmentsummary_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(Assessmentsummary_NotAssignTestCaseID, utilfunc.Actualbrw, Assessmentsummary_NotAssignScenerio,ActionName,Assessmentsummary_NotAssignTestCaseDescription,status,Assessmentsummary_Errormessage);
										//now write it in a notAssign file START...
										if(Assessmentsummary_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											Assessmentsummary_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										Assessmentsummary_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, Assessmentsummary_NotAssignTestCaseID, utilfunc.Actualbrw, Assessmentsummary_NotAssignScenerio, ActionName, Assessmentsummary_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								
									
									
								
									
									
									
								
								}
								else if(SuiteName.equals("Project List")){
									


									

									System.out.println("Execution of project list module start here...");
									String ProjectList_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(ProjectList_Scenariotext.equals("Positive") || ProjectList_Scenariotext.contains("sitive") || ProjectList_Scenariotext.contains("Pos")){
										ProjectList_PositiveScenarioCounter++;
									}else if(ProjectList_Scenariotext.equals("Negative") || ProjectList_Scenariotext.contains("gative") || ProjectList_Scenariotext.contains("gavtive") ){
										ProjectList_NegativeScenarioCounter++;
									}
									ProjectList_TotalTestCaseCounter++;
									
									String UserprofileXpath =".//*[@id='local-navigation']/ol/li[1]/div/a";
									
									String ProjectListXpath=".//*[@id='local-navigation']//*[@class='dropdown-menu']//*[@id='visaproject']//.[text()='Projects']";

					
									try {
										Thread.sleep(3000);
										utilfunc.MakeElement(UserprofileXpath).click();
										Thread.sleep(3000);
									} catch (Exception e1) {
										System.out.println("unable to click on the link ");
									}
									
									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(3000);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}
									
									

									//String ProjectListlinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Assessment Summary')]";
									boolean ProjectListIsAssignOrNot=false;
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(ProjectListXpath).click();
										ProjectListIsAssignOrNot=true;
									} catch (Exception e1) {

										System.out.println("==Unable to click on the project summary==");

									}


									if(ProjectListIsAssignOrNot==true)
									{//Allocated
										// click on link
										
										try{

											try{
												Page_flag	=	obj_CIMS_Project_List.Project_list(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//		utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

											if (Page_flag)
											{
												status="PASS";
												ProjectList_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio, ActionName, obj_CIMS_Project_List.description, status);
													// now write it in a pass file START...
													if(ProjectList_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName, "Pass");
														}catch(Exception e){}
														ProjectList_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio, ActionName, obj_CIMS_Project_List.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Project_List.scenerio,ActionName,obj_CIMS_Project_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(ProjectList_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														ProjectList_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Assessment_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Project_List.testcaseid,utilfunc.Actualbrw,obj_CIMS_Project_List.scenerio,ActionName,obj_CIMS_Project_List.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio, ActionName, obj_CIMS_Project_List.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												ProjectList_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio,ActionName, obj_CIMS_Project_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(ProjectList_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Fail");
													}catch(Exception e){}
													ProjectList_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio,ActionName, obj_CIMS_Project_List.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Project_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Project_List.scenerio,ActionName, obj_CIMS_Project_List.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String ProjectList_Errormessage="";
										String ProjectList_NotAssignTestCaseID="";
										String ProjectList_NotAssignScenerio="";
										String ProjectList_NotAssignTestCaseDescription="";
										int ProjectList_columnNumber_TCID;
										int ProjectList_columnNumber_Scenario;
										int ProjectList_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

										ProjectList_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(ProjectList_Errormessage);

										ProjectList_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										ProjectList_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										ProjectList_columnNumber_TestCaseDescription		    =    		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										ProjectList_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, ProjectList_columnNumber_TCID, count);
										ProjectList_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, ProjectList_columnNumber_Scenario, count);
										ProjectList_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, ProjectList_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(ProjectList_NotAssignTestCaseID, utilfunc.Actualbrw, ProjectList_NotAssignScenerio,ActionName,ProjectList_NotAssignTestCaseDescription,status,ProjectList_Errormessage);
										//now write it in a notAssign file START...
										if(ProjectList_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											ProjectList_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										ProjectList_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, ProjectList_NotAssignTestCaseID, utilfunc.Actualbrw, ProjectList_NotAssignScenerio, ActionName, ProjectList_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								
									
									
								
									
									
									
								
								
									
								}
								
								
								else if(SuiteName.equals("Most Recent")){
									

									System.out.println("Execution of Most Recent module start here...");
									String MostRecent_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(MostRecent_Scenariotext.equals("Positive") || MostRecent_Scenariotext.contains("sitive") || MostRecent_Scenariotext.contains("Pos")){
										Mostrecent_PositiveScenarioCounter++;
									}else if(MostRecent_Scenariotext.equals("Negative") || MostRecent_Scenariotext.contains("gative") || MostRecent_Scenariotext.contains("gavtive") ){
										Mostrecent_NegativeScenarioCounter++;
									}
									Mostrecent_TotalTestCaseCounter++;

									boolean MostRecentAllocatedorNot=false;
									String Mostrecent_Xpath=".//*[contains(@id,'quickLinkHeader')]//.[contains(text(),'Recent Queries')]";

									MostRecentAllocatedorNot=utilfunc.waitForAnElementToLoad(Mostrecent_Xpath, true);

									if(MostRecentAllocatedorNot==true)
									{//Allocated
										
										boolean MostRecent_FlagStep1 = false;
										boolean MostRecent_FlagStep2 = false;
										
										// click on link
										try{
											Thread.sleep(1000);
											utilfunc.MakeElement(Mostrecent_Xpath).click();
											Thread.sleep(1000);
										}catch(Exception e){
											System.out.println("unable to click on employee icons");
										}
										try{
											
											// Step 1 code Start here 

											try{
												MostRecent_FlagStep1	=	obj_CIMS_MostRecent_project.Most_Recent(fileName,SuiteName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName + "User", Employee_namecheck, timer);
										//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

											if (MostRecent_FlagStep1)
											{
												status="PASS";
												Mostrecent_passTestCaseCounter++;
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status);
													// now write it in a pass file START...
													if(Mostrecent_PassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+ "User", "Pass");
														}catch(Exception e){}
														Mostrecent_PassFlag=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw,obj_CIMS_MostRecent_project.scenerio,ActionName,obj_CIMS_MostRecent_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(Mostrecent_NegativePassFlag==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Negative Pass");
														}catch(Exception e){}
														Mostrecent_NegativePassFlag=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_MostRecent_project.testcaseid,utilfunc.Actualbrw,obj_CIMS_MostRecent_project.scenerio,ActionName,obj_CIMS_MostRecent_project.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName);}
												}
												/*											if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
													passCounter=true;
												}
												try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												Mostrecent_failTestCaseCounter++;
												//									utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(Mostrecent_FailFlag==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+ "User","Fail");
													}catch(Exception e){}
													Mostrecent_FailFlag= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												/*										if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
													failCounter	= true;
												}
												try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
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
										
//										try{
//											Thread.sleep(1000);
//											utilfunc.MakeElement(Mostrecent_Xpath).click();
//											Thread.sleep(1000);
//										}catch(Exception e){
//											System.out.println("unable to click on employee icons");
//										}
										
										Thread.sleep(3000);
										startTime = System.currentTimeMillis();
										try{
											MostRecent_FlagStep2	=	obj_CIMS_MostRecentTopTen_project.Most_Recent(fileName,sheetName,count,ActionName);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName+" Project", Employee_namecheck, timer);
											if (MostRecent_FlagStep2)
											{
												status="PASS";
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status);
													// now write it in a pass file START...
													if(Mostrecent_PassFlag2==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" Project", "Pass");
														}catch(Exception e){}
														Mostrecent_PassFlag2=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName+" -Questionnaires for Employee");}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw,obj_CIMS_MostRecentTopTen_project.scenerio,ActionName,obj_CIMS_MostRecentTopTen_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													// now write it in a negative pass dashboard file START...
													if(Mostrecent_NegativePassFlag2==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" Project","Negative Pass");
														}catch(Exception e){}
														Mostrecent_NegativePassFlag2=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_MostRecentTopTen_project.testcaseid,utilfunc.Actualbrw,obj_CIMS_MostRecentTopTen_project.scenerio,ActionName,obj_CIMS_MostRecentTopTen_project.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName+" -Questionnaires for Employee");}
												}
												/*	if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio, ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}*/
											}
											else
											{
												status="FAIL";
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												// now write it in a fail dashboard file START...
												if(Mostrecent_FailFlag2==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" Project","Fail");
													}catch(Exception e){}
													Mostrecent_FailFlag2= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName+" -Questionnaires for Employee");}
												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_MostRecentTopTen_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecentTopTen_project.scenerio,ActionName, obj_CIMS_MostRecentTopTen_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}*/
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

										
										
										
										
										// Step 2 code end here
										
										
										//flag check to make testcase pass or fail
										if(!MostRecent_FlagStep1 || !MostRecent_FlagStep2
												){
											Mostrecent_failTestCaseCounter++;
																						
											utilfunc.TestngReportFail1(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

											// now write it in a fail dashboard file START...
											if(Mostrecent_FailFlag1FINALREPORT==false){
												try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Final Report","Fail");
												}catch(Exception e){}
												Mostrecent_FailFlag1FINALREPORT= true;
											}// now write it in a fail dashboard file ENDS...
											try {
												obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio,ActionName, obj_CIMS_MostRecent_project.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											} catch (Exception e) {
												System.out.println("unable to write dasboard fail report for : "+SuiteName+" - Final Report");}

										
										}else{
											Mostrecent_passTestCaseCounter++;
											
											utilfunc.TestngReportPass(obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status);
											// now write it in a pass file START...
											if(Mostrecent_PassFlag1FINALREPORT==false){
												try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Final Report ", "Pass");
												}catch(Exception e){}
												Mostrecent_PassFlag1FINALREPORT=true;
											}
											// now write it in a pass file ENDS...

											//Write Positive Pass dashboard report 
											try {
												obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_MostRecent_project.testcaseid, utilfunc.Actualbrw, obj_CIMS_MostRecent_project.scenerio, ActionName, obj_CIMS_MostRecent_project.description, status, timer);
											}catch(Exception e){
												System.out.println("unable to write dasboard pass report for : "+SuiteName+" - Final Report");}
											
										}
										
										
										///////////////////////Final Report END//////////////////////

										
										

									}else{//not assigned to the user
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String Mostrecent_Errormessage="";
										String Mostrecent_NotAssignTestCaseID="";
										String Mostrecent_NotAssignScenerio="";
										String Mostrecent_NotAssignTestCaseDescription="";
										int Mostrecent_columnNumber_TCID;
										int Mostrecent_columnNumber_Scenario;
										int Mostrecent_columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									//	utilfunc.RegressionTotalTimeTakenbyModuleForDashboardReport(SuiteName);

										Mostrecent_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Mostrecent_Errormessage);

										Mostrecent_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										Mostrecent_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
										Mostrecent_columnNumber_TestCaseDescription		   =		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										Mostrecent_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, Mostrecent_columnNumber_TCID, count);
										Mostrecent_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, Mostrecent_columnNumber_Scenario, count);
										Mostrecent_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, Mostrecent_columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(Mostrecent_NotAssignTestCaseID, utilfunc.Actualbrw, Mostrecent_NotAssignScenerio,ActionName,Mostrecent_NotAssignTestCaseDescription,status,Mostrecent_Errormessage);
										//now write it in a notAssign file START...
										if(Mostrecent_NotassignFlag==false){
											try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
											}catch(Exception e){}
											Mostrecent_NotassignFlag=true;
										}//now write it in a notAssign file ENDS...
										Mostrecent_NotAssignedModuleCounter=1;	
										try {
											obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, Mostrecent_NotAssignTestCaseID, utilfunc.Actualbrw, Mostrecent_NotAssignScenerio, ActionName, Mostrecent_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
										} catch (InterruptedException e) {
											System.out.println("unable to write Not Assign report");
										}
									}

								
									
									
								
								}
								// secure messaging ends here //



								// code start here for process and questionnaire 
								else if(SuiteName.equals("ProcessQuestionnaire Assignment"))
								{
									String ProcessQuestionnaireAssignment_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

									if(ProcessQuestionnaireAssignment_Scenariotext.equals("Positive") || ProcessQuestionnaireAssignment_Scenariotext.contains("sitive") || ProcessQuestionnaireAssignment_Scenariotext.contains("Pos")){
										ProcessQuestionnaireAssignment_PositiveScenarioCounter++;
									}else if(ProcessQuestionnaireAssignment_Scenariotext.equals("Negative") || ProcessQuestionnaireAssignment_Scenariotext.contains("gative") || ProcessQuestionnaireAssignment_Scenariotext.contains("gavtive") ){
										ProcessQuestionnaireAssignment_NegativeScenarioCounter++;
									}
									ProcessQuestionnaireAssignment_TotalTestCaseCounter++;

									System.out.println(ProcessQuestionnaireAssignment_PositiveScenarioCounter);
									System.out.println(ProcessQuestionnaireAssignment_NegativeScenarioCounter);
									System.out.println(ProcessQuestionnaireAssignment_TotalTestCaseCounter);

//									String BalNoXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[2]";
//									try {
//										Thread.sleep(1500);
//										utilfunc.MakeElement(BalNoXpath).click();
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on the bal no==");
//									}
//
//									String sidebarxpath=".//*[@id='slider-icon']";
//									try {
//										Thread.sleep(1500);
//										utilfunc.MakeElement(sidebarxpath).click();
//										Thread.sleep(3000);
//									} catch (Exception e1) {
//										System.out.println("==Unable to click on slider icon==");
//
//									}

									String ProcessAndQuestionnairelinkXpath="//*[contains(@id,'right-nav')]//*[contains(text(),'Process')]";
									boolean ProcessQuestionnaireAssignmentIsAssignOrNot=false;
									try {
										Thread.sleep(1500);
										utilfunc.MakeElement(ProcessAndQuestionnairelinkXpath).click();
										ProcessQuestionnaireAssignmentIsAssignOrNot=true;
									} catch (Exception e1) {

										System.out.println("==Unable to click on the process and questionnaire==");

									}

									if(ProcessQuestionnaireAssignmentIsAssignOrNot==true)
									{
										boolean ProcessQuestionnaireAssignment_FlagStep1 = false;
										boolean ProcessQuestionnaireAssignment_FlagStep2 = false;
										boolean ProcessQuestionnaireAssignment_FlagStep3 = false;
										boolean ProcessQuestionnaireAssignment_FlagStep4 = false;


										//Step 1: Code process type

										startTime = System.currentTimeMillis();
										try{
											try{
												ProcessQuestionnaireAssignment_FlagStep1	=	obj_CIMS_Processandquestionnaire_ProcessType.Process_Type(fileName,sheetName,count,ActionName);
											}catch(Exception e){}

											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName + " - Process", Employee_namecheck, timer);
											if (ProcessQuestionnaireAssignment_FlagStep1)
											{
												status="PASS";
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio, ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status);
													// now write it in a pass file START...
													if(ProcessQuestionnaireAssignment_PassFlag1==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Process", "Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_PassFlag1=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio, ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName+" - Process");}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw,obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName,obj_CIMS_Processandquestionnaire_ProcessType.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													// now write it in a negative pass dashboard file START...
													if(ProcessQuestionnaireAssignment_NegativePassFlag1==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Process","Negative Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_NegativePassFlag1=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Processandquestionnaire_ProcessType.testcaseid,utilfunc.Actualbrw,obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName,obj_CIMS_Processandquestionnaire_ProcessType.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName+" - Process");}
												}
												/*if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio, ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);

												// now write it in a fail dashboard file START...
												if(ProcessQuestionnaireAssignment_FailFlag1==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Process","Fail");
													}catch(Exception e){}
													ProcessQuestionnaireAssignment_FailFlag1= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName+" - Process");}

												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}




										// Step 2
										// now call modules according to enable modules
										//																System.out.println("calling "+SuiteName+" module..");
										Thread.sleep(1500);
										startTime = System.currentTimeMillis();
										try{
											ProcessQuestionnaireAssignment_FlagStep2	=	obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.Questionnaire_Assignment(fileName,sheetName,count,ActionName);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName+"-Questionnaires for Employee", Employee_namecheck, timer);
											if (ProcessQuestionnaireAssignment_FlagStep2)
											{
												status="PASS";
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status);
													// now write it in a pass file START...
													if(ProcessQuestionnaireAssignment_PassFlag2==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employee", "Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_PassFlag2=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName+" -Questionnaires for Employee");}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio,ActionName,obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													// now write it in a negative pass dashboard file START...
													if(ProcessQuestionnaireAssignment_NegativePassFlag2==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employee","Negative Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_NegativePassFlag2=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio,ActionName,obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName+" -Questionnaires for Employee");}
												}
												/*	if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}*/
											}
											else
											{
												status="FAIL";
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												// now write it in a fail dashboard file START...
												if(ProcessQuestionnaireAssignment_FailFlag2==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employee","Fail");
													}catch(Exception e){}
													ProcessQuestionnaireAssignment_FailFlag2= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName+" -Questionnaires for Employee");}
												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}*/
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}

										// Step 3 - for questionnaire assignment for employer 
										Thread.sleep(1500);
										startTime = System.currentTimeMillis();
										try{
											ProcessQuestionnaireAssignment_FlagStep3	=	obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.Employer_Questionnaire(fileName,sheetName,count,ActionName);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName+" -Questionnaires for Employer", Employee_namecheck, timer);
											if (ProcessQuestionnaireAssignment_FlagStep3)
											{
												status="PASS";
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status);
													// now write it in a pass file START...
													if(ProcessQuestionnaireAssignment_PassFlag3==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employer", "Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_PassFlag3=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName+" -Questionnaires for Employer");}
												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio,ActionName,obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													// now write it in a negative pass dashboard file START...
													if(ProcessQuestionnaireAssignment_NegativePassFlag3==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employer","Negative Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_NegativePassFlag3=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio,ActionName,obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName+" -Questionnaires for Employer");}
												}
												/*if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio, ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												// now write it in a fail dashboard file START...
												if(ProcessQuestionnaireAssignment_FailFlag3==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Questionnaires for Employer","Fail");
													}catch(Exception e){}
													ProcessQuestionnaireAssignment_FailFlag3= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName+" -Questionnaires for Employer");}

												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.scenerio,ActionName, obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}


										// Code End here

										// Step 4: Code start for contact assignment 
										Thread.sleep(1500);

										try{
											ProcessQuestionnaireAssignment_FlagStep4	=	obj_CIMS_Regression_ProcessAndQuestionnaire_contact.Contact_Assignment(fileName,sheetName,count,ActionName,Employee_namecheck);
											timer = utilfunc.getTimeTakenByModule(startTime);
											utilfunc.updateModuleDataForReportGeneration(SuiteName+" -Bal Contact Assignment", Employee_namecheck, timer);
											if (ProcessQuestionnaireAssignment_FlagStep4)
											{
												status="PASS";
												if(utilfunc.globalerrormessage.equals(""))
												{
													utilfunc.TestngReportPass(obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio, ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status);
													// now write it in a pass file START...
													if(ProcessQuestionnaireAssignment_PassFlag4==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Bal Contact Assignment", "Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_PassFlag4=true;
													}// now write it in a pass file ENDS...

													//Write Positive Pass dashboard report 
													try {
														obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio, ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, timer);
													}catch(Exception e){
														System.out.println("unable to write dasboard pass report for : "+SuiteName+" -Bal Contact Assignment");}

												}
												else
												{
													utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw,obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio,ActionName,obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a negative pass dashboard file START...
													if(ProcessQuestionnaireAssignment_NegativePassFlag4==false){
														try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Bal Contact Assignment","Negative Pass");
														}catch(Exception e){}
														ProcessQuestionnaireAssignment_NegativePassFlag4=true;
													}// now write it in a negative pass dashboard file ENDS...

													//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
													try {
														obj_Report_Dashboard.writeDashBoardNegativePassReport(SuiteName,Employee_namecheck,obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid,utilfunc.Actualbrw,obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio,ActionName,obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													} catch (Exception e) {
														System.out.println("unable to write dasboard negative pass report for : "+ SuiteName+" -Bal Contact Assignment");}
												}	

												/*if(passCounter==false){
												try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
												passCounter=true;
											}
											try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio, ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
												 */
											}
											else
											{
												status="FAIL";
												utilfunc.TakeScreenshot();
												utilfunc.TestngReportFail1(obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio,ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a fail dashboard file START...
												if(ProcessQuestionnaireAssignment_FailFlag4==false){
													try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" -Bal Contact Assignment","Fail");
													}catch(Exception e){}
													ProcessQuestionnaireAssignment_FailFlag4= true;
												}// now write it in a fail dashboard file ENDS...
												try {
													obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio,ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard fail report for : "+SuiteName+" -Bal Contact Assignment");}

												/*if(failCounter==false){
												obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
												failCounter	= true;
											}
											try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.testcaseid, utilfunc.Actualbrw, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.scenerio,ActionName, obj_CIMS_Regression_ProcessAndQuestionnaire_contact.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
												 */
											}

										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
										//step4 ends here


										///////////////////////Final Report START//////////////////////
										
										//flag check to make testcase pass or fail
										if(!ProcessQuestionnaireAssignment_FlagStep1 || !ProcessQuestionnaireAssignment_FlagStep2
												||!ProcessQuestionnaireAssignment_FlagStep3 || !ProcessQuestionnaireAssignment_FlagStep4){
											ProcessQuestionnaireAssignment_failTestCaseCounter++;
																						
											utilfunc.TestngReportFail1(obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

											// now write it in a fail dashboard file START...
											if(ProcessQuestionnaireAssignment_FailFlag1FINALREPORT==false){
												try{ obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Process","Fail");
												}catch(Exception e){}
												ProcessQuestionnaireAssignment_FailFlag1FINALREPORT= true;
											}// now write it in a fail dashboard file ENDS...
											try {
												obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio,ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											} catch (Exception e) {
												System.out.println("unable to write dasboard fail report for : "+SuiteName+" - Process");}

										
										}else{
											ProcessQuestionnaireAssignment_passTestCaseCounter++;
											
											utilfunc.TestngReportPass(obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio, ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status);
											// now write it in a pass file START...
											if(ProcessQuestionnaireAssignment_PassFlag1FINALREPORT==false){
												try {	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName+" - Final ", "Pass");
												}catch(Exception e){}
												ProcessQuestionnaireAssignment_PassFlag1FINALREPORT=true;
											}// now write it in a pass file ENDS...

											//Write Positive Pass dashboard report 
											try {
												obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Processandquestionnaire_ProcessType.testcaseid, utilfunc.Actualbrw, obj_CIMS_Processandquestionnaire_ProcessType.scenerio, ActionName, obj_CIMS_Processandquestionnaire_ProcessType.description, status, timer);
											}catch(Exception e){
												System.out.println("unable to write dasboard pass report for : "+SuiteName+" - Process");}
											
										}
										
										
										///////////////////////Final Report END//////////////////////

									}//ProcessQuestionnaireAssignmentIsAssignOrNot==true ENDS here
									else
									{//means ProcessQuestionnaireAssignmentIsAssignOrNot==false
										try{
											Thread.sleep(3000);
											timer = utilfunc.getTimeTakenByModule(startTime);
											status="PASS";
											String ProcessQuestionnaireAssignment_Errormessage="";
											String ProcessQuestionnaireAssignment_NotAssignTestCaseID="";
											String ProcessQuestionnaireAssignment_NotAssignScenerio="";
											String ProcessQuestionnaireAssignment_NotAssignTestCaseDescription="";
											int ProcessQuestionnaireAssignment_columnNumber_TCID;
											int ProcessQuestionnaireAssignment_columnNumber_Scenario;
											int ProcessQuestionnaireAssignment_columnNumber_TestCaseDescription;

											utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
											ProcessQuestionnaireAssignment_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
											System.out.println(ProcessQuestionnaireAssignment_Errormessage);

											ProcessQuestionnaireAssignment_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
											ProcessQuestionnaireAssignment_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
											ProcessQuestionnaireAssignment_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

											ProcessQuestionnaireAssignment_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, ProcessQuestionnaireAssignment_columnNumber_TCID, count);
											ProcessQuestionnaireAssignment_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, ProcessQuestionnaireAssignment_columnNumber_Scenario, count);
											ProcessQuestionnaireAssignment_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, ProcessQuestionnaireAssignment_columnNumber_TestCaseDescription, count);

											utilfunc.TestngReportFail(ProcessQuestionnaireAssignment_NotAssignTestCaseID, utilfunc.Actualbrw, ProcessQuestionnaireAssignment_NotAssignScenerio,ActionName,ProcessQuestionnaireAssignment_NotAssignTestCaseDescription,status,ProcessQuestionnaireAssignment_Errormessage);
											//now write it in a notAssign file START...
											if(ProcessQuestionnaireAssignment_NotassignFlag==false){
												try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
												}catch(Exception e){}
												ProcessQuestionnaireAssignment_NotassignFlag=true;
											}//now write it in a notAssign file ENDS...
											ProcessQuestionnaireAssignment_NotAssignedModuleCounter=1;	
											try {
												obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, ProcessQuestionnaireAssignment_NotAssignTestCaseID, utilfunc.Actualbrw, ProcessQuestionnaireAssignment_NotAssignScenerio, ActionName, ProcessQuestionnaireAssignment_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
											} catch (InterruptedException e) {
												System.out.println("unable to write Not Assign report");
											}

										}catch(Exception e){
											System.out.println("");
										}
									}

									//code end here 

								}
								// code end here for process and questionnaire 

								else{/*

									try{
										Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";
										String Errormessage="";
										String NotAssignTestCaseID="";
										String NotAssignScenerio="";
										String NotAssignTestCaseDescription="";
										int columnNumber_TCID;
										int columnNumber_Scenario;
										int columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Errormessage);

										columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, columnNumber_TCID, count);
										NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
										NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio,ActionName,NotAssignTestCaseDescription,status,Errormessage);
										NotAssignedModuleCounter++;
										NumberOfNotAssignModule.add(SuiteName);

										if(notAssignedCounter==false){
											obj_Report_Dashboard.writeReportHeader(RegressionSuites, SuiteName,"Not Assigned");
											notAssignedCounter=true;
										}
										try {obj_Report_Dashboard.writeDashBoardNotAssignedReport(RegressionSuites, Employee_namecheck, NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio, ActionName, NotAssignTestCaseDescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard not assigned report for : "+SuiteName);}

									}catch(Exception e){
										System.out.println("");
									}

								*/}

							}
						}

					}
				}catch(Exception e){

				}
			}//loop for check that module is Y or N ends here....


			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(NumberOfNotAssignModule);
			NumberOfNotAssignModule.clear();
			NumberOfNotAssignModule.addAll(lhs);
			NotAssignedModuleCounter=NumberOfNotAssignModule.size();

			/*System.out.println("========\n========\n========");
			System.out.println("PositiveScenarioCounter : "+PositiveScenarioCounter);
			System.out.println("NegativeScenarioCounter : "+NegativeScenarioCounter);
			System.out.println("ModuleCounter : "+ModuleCounter);
			System.out.println("TotalTestCaseCounter : "+TotalTestCaseCounter);
			System.out.println("passTestCaseCounter : "+passTestCaseCounter);
			System.out.println("failTestCaseCounter : "+failTestCaseCounter);
			System.out.println("NotAssignedModuleCounter : "+NotAssignedModuleCounter);
			System.out.println("========\n========\n========");

			System.out.println("\n\n\n~~~~~~~~~~ADVANCE SEARCH PROJECT START");
			System.out.println("PositiveScenarioCounter : "+AdvanceSearchProject_PositiveScenarioCounter);
			System.out.println("NegativeScenarioCounter : "+AdvanceSearchProject_NegativeScenarioCounter);
			System.out.println("TotalTestCaseCounter : "+AdvanceSearchProject_TotalTestCaseCounter);
			System.out.println("passTestCaseCounter : "+AdvanceSearchProject_passTestCaseCounter);
			System.out.println("failTestCaseCounter : "+AdvanceSearchProject_failTestCaseCounter);
			System.out.println("NotAssignedModuleCounter : "+AdvanceSearchProject_NotAssignedModuleCounter);
			System.out.println("ModuleCounter : "+AdvanceSearchProject_ModuleCounter);
			System.out.println("ADVANCE SEARCH PROJECT ENDS\n~~~~~~~~~~");

			System.out.println("\n\n\n~~~~~~~~~~NEWS START");
			System.out.println("NEWSPositiveScenarioCounter : "+News_PositiveScenarioCounter);
			System.out.println("NEWSNegativeScenarioCounter : "+News_NegativeScenarioCounter);
			System.out.println("NEWSTotalTestCaseCounter : "+News_TotalTestCaseCounter);
			System.out.println("NEWSpassTestCaseCounter : "+News_passTestCaseCounter);
			System.out.println("NEWSfailTestCaseCounter : "+News_failTestCaseCounter);
			System.out.println("NEWSNotAssignedModuleCounter : "+News_NotAssignedModuleCounter);
			System.out.println("NEWSModuleCounter : "+News_ModuleCounter);
			System.out.println("NEWS ENDS\n~~~~~~~~~~");

			System.out.println("\n\n\n~~~~~~~~~~Process Questionnaire Assignment START");
			System.out.println("Process Questionnaire Assignment PositiveScenarioCounter : "+ProcessQuestionnaireAssignment_PositiveScenarioCounter);
			System.out.println("Process Questionnaire Assignment NegativeScenarioCounter : "+ProcessQuestionnaireAssignment_NegativeScenarioCounter);
			System.out.println("Process Questionnaire Assignment TotalTestCaseCounter : "+ProcessQuestionnaireAssignment_TotalTestCaseCounter);
			System.out.println("Process Questionnaire Assignment passTestCaseCounter : "+ProcessQuestionnaireAssignment_passTestCaseCounter);
			System.out.println("Process Questionnaire Assignment failTestCaseCounter : "+ProcessQuestionnaireAssignment_failTestCaseCounter);
			System.out.println("Process Questionnaire Assignment NotAssignedModuleCounter : "+ProcessQuestionnaireAssignment_NotAssignedModuleCounter);
			System.out.println("Process Questionnaire Assignment ModuleCounter : "+ProcessQuestionnaireAssignment_ModuleCounter);
			System.out.println("Process Questionnaire Assignment ENDS\n~~~~~~~~~~");


			System.out.println("\n\n\n~~~~~~~~~~GCP_NewQuery START");
			System.out.println("GCP_NewQuery PositiveScenarioCounter : "+GCP_NewQuery_PositiveScenarioCounter);
			System.out.println("GCP_NewQuery NegativeScenarioCounter : "+GCP_NewQuery_NegativeScenarioCounter);
			System.out.println("GCP_NewQuery TotalTestCaseCounter : "+GCP_NewQuery_TotalTestCaseCounter);
			System.out.println("GCP_NewQuery passTestCaseCounter : "+GCP_NewQuery_passTestCaseCounter);
			System.out.println("GCP_NewQuery failTestCaseCounter : "+GCP_NewQuery_failTestCaseCounter);
			System.out.println("GCP_NewQuery NotAssignedModuleCounter : "+GCP_NewQuery_NotAssignedModuleCounter);
			System.out.println("GCP_NewQuery ModuleCounter : "+GCP_NewQuery_ModuleCounter);
			System.out.println("GCP_NewQuery ENDS\n~~~~~~~~~~");

			System.out.println("\n\n\n~~~~~~~~~~GCP_TravelHistory START");
			System.out.println("GCP_TravelHistory PositiveScenarioCounter : "+GCP_TravelHistory_PositiveScenarioCounter);
			System.out.println("GCP_TravelHistory NegativeScenarioCounter : "+GCP_TravelHistory_NegativeScenarioCounter);
			System.out.println("GCP_TravelHistory TotalTestCaseCounter : "+GCP_TravelHistory_TotalTestCaseCounter);
			System.out.println("GCP_TravelHistory passTestCaseCounter : "+GCP_TravelHistory_passTestCaseCounter);
			System.out.println("GCP_TravelHistory failTestCaseCounter : "+GCP_TravelHistory_failTestCaseCounter);
			System.out.println("GCP_TravelHistory NotAssignedModuleCounter : "+GCP_TravelHistory_NotAssignedModuleCounter);
			System.out.println("GCP_TravelHistory ModuleCounter : "+GCP_TravelHistory_ModuleCounter);
			System.out.println("GCP_TravelHistory ENDS\n~~~~~~~~~~");*/





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
//			TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
			
			/////////////////////////////// code for Advanced Search Employee...
			// get total time to execuite the Advanced Search Employee module
						String AdvanceSearchEmployee_FileTime			= "00";
						try{
							AdvanceSearchEmployee_FileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"advanced_search_employee_time");
							AdvanceSearchEmployee_FileTime		=	obj_Report_Dashboard.convertSecondsInHourMinuteSeconds(AdvanceSearchEmployee_FileTime);
						}catch(Exception e){
							System.out.println("unable to write for module: "+moduleName);
						}
			try{
				obj_Report_Dashboard.generateReportForSuite("Advanced Search Employee",
						"1",
						Integer.toString(AdvanceSearchEmployee_TotalTestCaseCounter),
						Integer.toString(AdvanceSearchEmployee_PositiveScenarioCounter),
						Integer.toString(AdvanceSearchEmployee_NegativeScenarioCounter),
						Integer.toString(AdvanceSearchEmployee_passTestCaseCounter),
						Integer.toString(AdvanceSearchEmployee_failTestCaseCounter),
						AdvanceSearchEmployee_FileTime,
						Integer.toString(AdvanceSearchEmployee_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Advanced Search Employee\"");
			}


			////////////////////// code for Advanced Search Project...
			// get total time to execuite the Advanced Search Project module
			String AdvanceSearchProject_FileTime			= "00";
			try{
				AdvanceSearchProject_FileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"advanced_search_project_time");
				AdvanceSearchProject_FileTime		=	obj_Report_Dashboard.convertSecondsInHourMinuteSeconds(AdvanceSearchProject_FileTime);
			}catch(Exception e){
				System.out.println("unable to write for module: "+moduleName);
			}
			try{
				obj_Report_Dashboard.generateReportForSuite("Advanced Search Project",
						"1",
						Integer.toString(AdvanceSearchProject_TotalTestCaseCounter),
						Integer.toString(AdvanceSearchProject_PositiveScenarioCounter),
						Integer.toString(AdvanceSearchProject_NegativeScenarioCounter),
						Integer.toString(AdvanceSearchProject_passTestCaseCounter),
						Integer.toString(AdvanceSearchProject_failTestCaseCounter),
						AdvanceSearchProject_FileTime,
						Integer.toString(AdvanceSearchProject_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Advanced Search Project\"");
			}

			// code for Travel History...
			try{
				obj_Report_Dashboard.generateReportForSuite("Travel History",
						"1",
						Integer.toString(GCP_TravelHistory_TotalTestCaseCounter),
						Integer.toString(GCP_TravelHistory_PositiveScenarioCounter),
						Integer.toString(GCP_TravelHistory_NegativeScenarioCounter),
						Integer.toString(GCP_TravelHistory_passTestCaseCounter),
						Integer.toString(GCP_TravelHistory_failTestCaseCounter),
						TotalTime,
						Integer.toString(GCP_TravelHistory_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Travel History\"");
			}

			// code for Secure Messaging...
			try{
				obj_Report_Dashboard.generateReportForSuite("Secure Messaging",
						"1",
						Integer.toString(SecureMessaging_TotalTestCaseCounter),
						Integer.toString(SecureMessaging_PositiveScenarioCounter),
						Integer.toString(SecureMessaging_NegativeScenarioCounter),
						Integer.toString(SecureMessaging_passTestCaseCounter),
						Integer.toString(SecureMessaging_failTestCaseCounter),
						TotalTime,
						Integer.toString(SecureMessaging_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Secure Messaging\"");
			}

			/////////////// code for News...////////////////////			
			// get total time to execuite the news module
			String NewsFileTime			= "00";
			try{
				NewsFileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"news_time");
				System.out.println("\n\n\t\tNEwsFileTime :"+NewsFileTime+"\n\n");
				NewsFileTime		=	obj_Report_Dashboard.convertSecondsInHourMinuteSeconds(NewsFileTime);
				System.out.println("\n\n\t\tNewsFileTime:"+NewsFileTime);
			}catch(Exception e){
				System.out.println("unable to write for module: "+moduleName);
			}
			
			try{
				obj_Report_Dashboard.generateReportForSuite("News",
						"1",
						Integer.toString(News_TotalTestCaseCounter),
						Integer.toString(News_PositiveScenarioCounter),
						Integer.toString(News_NegativeScenarioCounter),
						Integer.toString(News_passTestCaseCounter),
						Integer.toString(News_failTestCaseCounter),
						NewsFileTime,
						Integer.toString(News_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - News\"");
			}

			// code for GlobalChekPlus-NewQuery...
			try{
				obj_Report_Dashboard.generateReportForSuite("GlobalChekPlus - NewQuery",
						"1",
						Integer.toString(GCP_NewQuery_TotalTestCaseCounter),
						Integer.toString(GCP_NewQuery_PositiveScenarioCounter),
						Integer.toString(GCP_NewQuery_NegativeScenarioCounter),
						Integer.toString(GCP_NewQuery_passTestCaseCounter),
						Integer.toString(GCP_NewQuery_failTestCaseCounter),
						TotalTime,
						Integer.toString(GCP_NewQuery_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - GlobalChekPlus-NewQuery\"");
			}
			
			
			
			//code for Project detail 
			
			
						try{
							obj_Report_Dashboard.generateReportForSuite("Project Detail",
									"1",
									Integer.toString(Projectdetail_TotalTestCaseCounter),
									Integer.toString(Projectdetail_PositiveScenarioCounter),
									Integer.toString(Projectdetail_NegativeScenarioCounter),
									Integer.toString(Projectdetail_passTestCaseCounter),
									Integer.toString(Projectdetail_failTestCaseCounter),
									TotalTime,
									Integer.toString(Projectdetail_NotAssignedModuleCounter));
						}catch(Exception e){
							System.out.println("unable to call & generate dashboard report for \"Regression - GlobalChekPlus-NewQuery\"");
						}


						// code for most recent project and user 
						
						
						String Mostrecent_FileTime			= "00";
						try{
							Mostrecent_FileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"Mostrecent");
							System.out.println("\n\n\t\tMostrecent_FileTime :"+Mostrecent_FileTime+"\n\n");
							Mostrecent_FileTime		=	obj_Report_Dashboard.convertSecondsInHourMinuteSeconds(Mostrecent_FileTime);
						}catch(Exception e){
							System.out.println("unable to write for module: "+moduleName);
						}
						
			try{
				obj_Report_Dashboard.generateReportForSuite("Most recent Project and employee",
						"1",
						Integer.toString(Mostrecent_TotalTestCaseCounter),
						Integer.toString(Mostrecent_PositiveScenarioCounter),
						Integer.toString(Mostrecent_NegativeScenarioCounter),
						Integer.toString(Mostrecent_passTestCaseCounter),
						Integer.toString(Mostrecent_failTestCaseCounter),
						Mostrecent_FileTime,
						Integer.toString(Mostrecent_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - ProcessQuestionnaire Assignment\"");
			}

			//////////////////////// code for Process Questionnaire Assignment...
			// get total time to execuite the Process Questionnaire Assignment module
						String ProcessQuestionnaireAssignment_FileTime			= "00";
						try{
							ProcessQuestionnaireAssignment_FileTime		=	obj_Report_Dashboard.ReadFromFile(dashboard.projectReportTempPath + "regression_time"+File.separator+"processquestionnaire_assignment_time");
							System.out.println("\n\n\t\tProcessQuestionnaireAssignment_FileTime :"+ProcessQuestionnaireAssignment_FileTime+"\n\n");
							ProcessQuestionnaireAssignment_FileTime		=	obj_Report_Dashboard.convertSecondsInHourMinuteSeconds(ProcessQuestionnaireAssignment_FileTime);
						}catch(Exception e){
							System.out.println("unable to write for module: "+moduleName);
						}
						
			try{
				obj_Report_Dashboard.generateReportForSuite("ProcessQuestionnaire Assignment",
						"1",
						Integer.toString(ProcessQuestionnaireAssignment_TotalTestCaseCounter),
						Integer.toString(ProcessQuestionnaireAssignment_PositiveScenarioCounter),
						Integer.toString(ProcessQuestionnaireAssignment_NegativeScenarioCounter),
						Integer.toString(ProcessQuestionnaireAssignment_passTestCaseCounter),
						Integer.toString(ProcessQuestionnaireAssignment_failTestCaseCounter),
						ProcessQuestionnaireAssignment_FileTime,
						Integer.toString(ProcessQuestionnaireAssignment_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - ProcessQuestionnaire Assignment\"");
			}

			// code for Initiate a Single Project...
			try{
				obj_Report_Dashboard.generateReportForSuite("Initiate a single project",
						"1",
						Integer.toString(InitiateSingleproject_TotalTestCaseCounter),
						Integer.toString(InitiateSingleproject_PositiveScenarioCounter),
						Integer.toString(InitiateSingleproject_NegativeScenarioCounter),
						Integer.toString(InitiateSingleproject_passTestCaseCounter),
						Integer.toString(InitiateSingleproject_failTestCaseCounter),
						TotalTime,
						Integer.toString(InitiateSingleproject_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Initiate a single project\"");
			}

			// code for Initiate multiple projects...
			try{
				obj_Report_Dashboard.generateReportForSuite("Initiate multiple projects",
						"1",
						Integer.toString(InitiateMultipleProjects_TotalTestCaseCounter),
						Integer.toString(InitiateMultipleProjects_PositiveScenarioCounter),
						Integer.toString(InitiateMultipleProjects_NegativeScenarioCounter),
						Integer.toString(InitiateMultipleProjects_passTestCaseCounter),
						Integer.toString(InitiateMultipleProjects_failTestCaseCounter),
						TotalTime,
						Integer.toString(InitiateMultipleProjects_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Initiate multiple projects\"");
			}
			
			// code for Immigration Status and Document...
			try{
				obj_Report_Dashboard.generateReportForSuite("Immigration Status and Document",
						"1",
						Integer.toString(ImmigrationStatusAndDoc_TotalTestCaseCounter),
						Integer.toString(ImmigrationStatusAndDoc_PositiveScenarioCounter),
						Integer.toString(ImmigrationStatusAndDoc_NegativeScenarioCounter),
						Integer.toString(ImmigrationStatusAndDoc_passTestCaseCounter),
						Integer.toString(ImmigrationStatusAndDoc_failTestCaseCounter),
						TotalTime,
						"1"/*Integer.toString(/*InitiateMultipleProjects_NotAssignedModuleCounter)*/);
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - Immigration Status and Document\"");
			}
			
			// code for project summary 
		
			
			
			try{
				obj_Report_Dashboard.generateReportForSuite("Project Summary",
						"1",
						Integer.toString(Projectsummary_TotalTestCaseCounter),
						Integer.toString(Projectsummary_PositiveScenarioCounter),
						Integer.toString(Projectsummary_NegativeScenarioCounter),
						Integer.toString(Projectsummary_passTestCaseCounter),
						Integer.toString(Projectsummary_failTestCaseCounter),
						TotalTime,
						Integer.toString(Projectsummary_NotAssignedModuleCounter));
			}catch(Exception e){
				System.out.println("unable to call & generate dashboard report for \"Regression - GlobalChekPlus-NewQuery\"");
			}
			
			// code for project summary 
			
			
			
				try{
					obj_Report_Dashboard.generateReportForSuite("Assessment Summary",
							"1",
							Integer.toString(Assessmentsummary_TotalTestCaseCounter),
							Integer.toString(Assessmentsummary_PositiveScenarioCounter),
							Integer.toString(Assessmentsummary_NegativeScenarioCounter),
							Integer.toString(Assessmentsummary_passTestCaseCounter),
							Integer.toString(Assessmentsummary_failTestCaseCounter),
							TotalTime,
							Integer.toString(Assessmentsummary_NotAssignedModuleCounter));
				}catch(Exception e){
					System.out.println("unable to call & generate dashboard report for \"Regression - GlobalChekPlus-NewQuery\"");
				}
				// code for project list
			
				try{
					obj_Report_Dashboard.generateReportForSuite("Project List",
							"1",
							Integer.toString(ProjectList_TotalTestCaseCounter),
							Integer.toString(ProjectList_PositiveScenarioCounter),
							Integer.toString(ProjectList_NegativeScenarioCounter),
							Integer.toString(ProjectList_passTestCaseCounter),
							Integer.toString(ProjectList_failTestCaseCounter),
							TotalTime,
							Integer.toString(ProjectList_NotAssignedModuleCounter));
				}catch(Exception e){
					System.out.println("unable to call & generate dashboard report for \"Regression - GlobalChekPlus-NewQuery\"");
				}
			
		
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

	public void setobj_Project_Initiation(Project_Initiation setobj_Project_Initiation) {
		this.obj_Project_Initiation	=	setobj_Project_Initiation;	 

	}

	public void setobj_CIMS_Single_Project_Initiation(CIMS_Single_Project_Initiation setobj_CIMS_Single_Project_Initiation) {
		this.obj_CIMS_Single_Project_Initiation	=	setobj_CIMS_Single_Project_Initiation;	 

	}


	public void setobj_CIMS_Regresssion_Suite_Bulk_Initiation(CIMS_Regresssion_Suite_Bulk_Initiation setobj_CIMS_Regresssion_Suite_Bulk_Initiation) {
		this.obj_CIMS_Regresssion_Suite_Bulk_Initiation	=	setobj_CIMS_Regresssion_Suite_Bulk_Initiation;
	}

	/*public void setDriver(WebDriver driver) {
			this.driver = driver;
		}*/

	public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
		this.obj_CIMS_Login = setobj_CIMS_Login;
	}


	public void setobj_CIMS_Regression_Suite_Immigration_Status(CIMS_Regression_Suite_Immigration_Status setobj_CIMS_Regression_Suite_Immigration_Status) {
		this.obj_CIMS_Regression_Suite_Immigration_Status	=	setobj_CIMS_Regression_Suite_Immigration_Status;

	}
	public void setobj_CIMS_Immigration_Document(CIMS_Immigration_Document setobj_CIMS_Immigration_Document) {
		this.obj_CIMS_Immigration_Document	=	setobj_CIMS_Immigration_Document;
	}

	public void setobj_CIMS_Regression_Suite_Employee_Profile(CIMS_Regression_Suite_Employee_Profile setobj_CIMS_Regression_Suite_Employee_Profile) {
		this.obj_CIMS_Regression_Suite_Employee_Profile	=	setobj_CIMS_Regression_Suite_Employee_Profile;
	}

	public void setobj_CIMS_GCP_NewQuery(CIMS_GCP_NewQuery setobj_CIMS_GCP_NewQuery) {
		this.obj_CIMS_GCP_NewQuery	=	setobj_CIMS_GCP_NewQuery;
	}
	//Lokesh Append this code for "All My Tasks" on Welcome Page
	/*	public void setobj_CIMS_Regression_Suite_AllMyTasks(CIMS_Regression_Suite_AllMyTasks setobj_CIMS_Regression_Suite_AllMyTasks){
				this.obj_CIMS_Regression_Suite_AllMyTasks	=	setobj_CIMS_Regression_Suite_AllMyTasks;
			}*/
	//Lokesh Append this code for "News" on Welcome Page
	public void setobj_CIMS_Regression_Suite_News(CIMS_Regression_Suite_News setobj_CIMS_Regression_Suite_News){
		this.obj_CIMS_Regression_Suite_News	=	setobj_CIMS_Regression_Suite_News;
	}

	public void setobj_Employee_Search(Employee_Search setobj_Employee_Search){
		this.obj_Employee_Search	=	setobj_Employee_Search;
	}


	// Lokesh add these line(s) on 06-May-2016 for Advance Project search
	public void setobj_Project_Search(Project_Search setobj_Project_Search){
		this.obj_Project_Search	=	setobj_Project_Search;
	}


	// dashboard report
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}

	public void setobj_CIMS_Secure_Messaging(CIMS_Secure_Messaging setobj_CIMS_Secure_Messaging) {
		this.obj_CIMS_Secure_Messaging = setobj_CIMS_Secure_Messaging;
	}
	

	public void setobj_CIMS_Project_Detail(CIMS_Project_Detail setobj_CIMS_Project_Detail) {
		this.obj_CIMS_Project_Detail = setobj_CIMS_Project_Detail;
	}
	

	public void setobj_CIMS_MostRecent_project(CIMS_MostRecent_project setobj_CIMS_MostRecent_project) {
		this.obj_CIMS_MostRecent_project = setobj_CIMS_MostRecent_project;
	}
	
	public void setobj_CIMS_MostRecentTopTen_project(CIMS_MostRecentTopTen_project setobj_CIMS_MostRecentTopTen_project) {
		this.obj_CIMS_MostRecentTopTen_project = setobj_CIMS_MostRecentTopTen_project;
	}
	
	public void setobj_CIMS_Project_Summary(CIMS_Project_Summary setobj_CIMS_Project_Summary) {
		this.obj_CIMS_Project_Summary = setobj_CIMS_Project_Summary;
	}
	public void setobj_CIMS_Assessment_Summary(CIMS_Assessment_Summary setobj_CIMS_Assessment_Summary) {
		this.obj_CIMS_Assessment_Summary = setobj_CIMS_Assessment_Summary;
	}
	
	
	



	// Dharam Code start here CIMS_Regression_ProcessAndQuestionnaire_contact
	public void setobj_CIMS_Regression_Suite_Process_Questionnaire_Assignment(CIMS_Regression_Suite_Process_Questionnaire_Assignment setobj_CIMS_Regression_Suite_Process_Questionnaire_Assignment) {
		this.obj_CIMS_Regression_Suite_Process_Questionnaire_Assignment=setobj_CIMS_Regression_Suite_Process_Questionnaire_Assignment;
	}

	public void setobj_CIMS_Processandquestionnaire_ProcessType(CIMS_Processandquestionnaire_ProcessType setobj_CIMS_Processandquestionnaire_ProcessType) {
		this.obj_CIMS_Processandquestionnaire_ProcessType=setobj_CIMS_Processandquestionnaire_ProcessType;
	}

	public void setobj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment(CIMS_Regression_Suite_Emp_Questionnaire_Assignment setobj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment) {
		this.obj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment=setobj_CIMS_Regression_Suite_Emp_Questionnaire_Assignment;
	}

	public void setobj_CIMS_Regression_ProcessAndQuestionnaire_contact(CIMS_Regression_ProcessAndQuestionnaire_contact setobj_CIMS_Regression_ProcessAndQuestionnaire_contact) {
		this.obj_CIMS_Regression_ProcessAndQuestionnaire_contact=setobj_CIMS_Regression_ProcessAndQuestionnaire_contact;
	}
	public void setobj_CIMS_Travel_History(CIMS_Travel_History setobj_CIMS_Travel_History) {
		this.obj_CIMS_Travel_History=setobj_CIMS_Travel_History;
	}
	public void setobj_CIMS_Project_List(CIMS_Project_List setobj_CIMS_Project_List) {
		this.obj_CIMS_Project_List=setobj_CIMS_Project_List;
	}
	//
	// Dharam Code End here CIMS_Regression_Suite_Emp_Questionnaire_Assignment


	//LOKESH CODE 
	public String Immigration_Status_Document(String SuiteName,String Actionname) throws InterruptedException
	{
		String suiteLink="";
		String AddNewButton=".//*[@id='local-navigation']//*[contains(@class,'btn')]//*[contains(@class,'icon-plus')]";
		if(Actionname.equalsIgnoreCase("New")){
			try{
				utilfunc.scrollToTop();//make sure that before click the add new button; same button should be in visible area.
				Thread.sleep(2000);
				utilfunc.MakeElement(AddNewButton).click();
				Thread.sleep(1500);
			}catch(Exception e){
				System.out.println("Unable to find the Add Button");
			}
			suiteLink			=		".//*[@id='docs']/center//*[contains(@class,'btn') and text()='"+ SuiteName +"']";
		}
		else if(Actionname.equals("Edit") || (Actionname.equals("Delete"))){

			Thread.sleep(1500);

			// before clicking on delete icon let us expand the list...
			String LinkText		=	(SuiteName.equals("Immigration Status")) ? "Status" : "Document";
			String ListExpandXpath		=	".//*[contains(@id,'"+ LinkText +"')]/table/tbody/tr[1]/td[2]";
			Thread.sleep(1500);
			utilfunc.MakeElement(ListExpandXpath).click();
			Thread.sleep(1500);
			// now click on action button
			String ActionBtnXPath		=	".//*[contains(@id,'"+ LinkText +"')]/table/tbody/tr[2]/td//*[contains(@class,'btn-group')]//*[contains(@class,'btn')]//*[contains(@class,'icon-cog')]";
			suiteLink		=	ActionBtnXPath;
			Thread.sleep(1500);
		}			
		return suiteLink;
	}
	//LOKESH CODE


}

