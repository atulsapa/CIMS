package CIMS;


import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import listner.ErrorUtil;



import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.NullPointerException;

//import util.Email;
import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.*;
import CIMS.Reports.dashboard;


//import util.questionariesutility;


public class CIMS_MainProject

{

	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	private CIMS_Basic_Information_module obj_CIMS_Basic_Information_Module;
	private CIMS_Other_Name_Module obj_CIMS_Other_Name_Module;
	private CIMS_Addional_Questionnaire_Module obj_CIMS_Addional_Questionnaire_Module;
	private CIMS_Passport_Module obj_CIMS_Passport_Module;
	private CIMS_USImmigration_Module obj_CIMS_USImmigration_Module; 
	private CIMS_Education_History_Module obj_CIMS_Education_History_Module; 
	private CIMS_GroupMemberships_Module obj_CIMS_GroupMemberships_Module;
	private CIMS_Health_Insurance_Module obj_CIMS_Health_Insurance_Module;
	private CIMS_Medical_History_Module obj_CIMS_Medical_History_Module;
	private CIMS_Teacher_ChildHealthCare_Module obj_CIMS_Teacher_ChildHealthCare_Module;
	private CIMS_Patents_Module obj_CIMS_Patents_Module; 
	private CIMS_Id_Documents_Module obj_CIMS_Id_Documents_Module; 
	private CIMS_Citizenship_Module obj_CIMS_Citizenship_Module; 
	private CIMS_Membership_Module obj_CIMS_Membership_Module;
	private CIMS_Speaking_Engagements_Module obj_CIMS_Speaking_Engagements_Module;
	private CIMS_Global_Immigration_History_Module obj_CIMS_Global_Immigration_History_Module;
	private CIMS_Exhibitions_and_Showcases_Module obj_CIMS_Exhibitions_and_Showcases_Module;
	private CIMS_AWARDS_MODULES obj_CIMS_AWARDS_MODULES;
	private Project_Initiation obj_CIMS_Project_Initiation;
	private CIMS_Additional_Medical_History_Module obj_CIMS_Additional_Medical_History_Module;
	private CIMS_Compensation_and_benifits_Module obj_CIMS_Compensation_and_benifits_Module;
	private CIMS_Memberships_in_Professional_Module obj_CIMS_Memberships_in_Professional_Module;
	private CIMS_EmployeeProcessing_Module obj_CIMS_EmployeeProcessing_Module;
	private CIMS_SpecialAbility_Module obj_CIMS_SpecialAbility_Module;
	private CIMS_Residence_History_Module obj_CIMS_Residence_History_Module;
	private CIMS_Marriages_Module obj_CIMS_Marriages_Module;
	private CIMS_Family_Members_Module obj_CIMS_Family_Members_Module;
	private CIMS_Immigration_Documents_Module obj_CIMS_Immigration_Documents_Module;
	private CIMS_Visits_Module obj_CIMS_Visits_Module;
	private CIMS_Pregnancy_Module obj__CIMS_Pregnancy_Module;
	private CIMS_Work_Locations_Module obj_CIMS_Work_Locations_Module;
	private CIMS_Employer_Processing_Module obj_CIMS_Employer_Processing_Module;
	private CIMS_Personal_Attributes_Module obj_CIMS_Personal_Attributes_Module;
	private CIMS_Child_Details_Module obj_CIMS_Child_Details_Module;
	private CIMS_CitationsofYourWork_Module obj_CIMS_CitationsofYourWork_Module;
	private CIMS_LCA_info_Module obj_CIMS_LCA_info_Module;
	private CIMS_Commercial_Success_Module obj_CIMS_Commercial_Success_Module;
	private CIMS_Travel_Plans_Module obj_CIMS_Travel_Plans_Module;
	private CIMS_Offsite_Employment_Module obj_CIMS_Offsite_Employment_Module;
	private CIMS_Employment_History_Module obj_CIMS_Employment_History_Module;
	private CIMS_Contact_Information_Module obj_CIMS_Contact_Information_Module;
	private CIMS_Destination_Country_Employment_Module obj_CIMS_Destination_Country_Employment_Module;
	private CIMS_Position_Requirements_Module obj_CIMS_Position_Requirements_Module;
	private CIMS_Contributions_to_Your_Field_Module obj_CIMS_Contributions_to_Your_Field_Module;
	private CIMS_Publications_Authored_Module obj_CIMS_Publications_Authored_Module;
	private CIMS_Leading_or_Critical_Role_Module obj_CIMS_Leading_or_Critical_Role_Module;
	private CIMS_Other_Evidence_of_Special_Ability_Module obj_CIMS_Other_Evidence_of_Special_Ability_Module;
	private CIMS_Parent_Module obj_CIMS_Parent_Module;
	private CIMS_Language_Proficiency_Module obj_CIMS_Language_Proficiency_Module;
	private CIMS_Language_Study_Module obj_CIMS_Language_Study_Module;
	private CIMS_Medical_Treatment_Module obj_CIMS_Medical_Treatment_Module;
	private CIMS_Contacts_and_References_Module obj_CIMS_Contacts_and_References_Module;
	private CIMS_Home_Country_Employment_Module obj_CIMS_Home_Country_Employment_Module;
	private CIMS_Participation_as_Judge_Module obj_CIMS_Participation_as_Judge_Module;
	private CIMS_EnglishLanguageAbility_Module obj_CIMS_EnglishLanguageAbility_Module;
	private CIMS_QualifyingExperienceWithCompany_Module obj_CIMS_QualifyingExperienceWithCompany_Module;
	private CIMS_Company_Contacts_Module obj_CIMS_Company_Contacts_Module;
	private CIMS_Assessment_Module obj_CIMS_Assessment_Module;


	private CIMS_ContactInformation_Mailing_Address obj_CIMS_ContactInformation_Mailing_Address;
	private CIMS_ContactInformation_Permanent_Address obj_CIMS_ContactInformation_Permanent_Address;
	private CIMS_ContactInformation_Email_Address obj_CIMS_ContactInformation_Email_Address;
	private CIMS_ContactInformation_Phone_Number obj_CIMS_ContactInformation_Phone_Number;


	//file name that takes dynamically in all modules.
	public static String ExcelFileName="Test Data.xls";
	public static String os=System.getProperty("os.name");
	public static String osbit=System.getProperty("sun.arch.data.model");

	//timer
	StopWatch pageLoad = new StopWatch();


	private String fileName="Test Data.xls";
	public static String suiteName	=	"Questionnaires";
	public static String sheetName="Questionnaires";		
	private String columnName="RUNMODE";
	private String columnName5="ACTION";
	public static String  questionarie_name1=null;
	public static String Main_questionarie_name_temp="";

	//Employee search declaration
	private String fileNameemployee="Test Data.xls";
	private String sheetNameemployee="EmployeeSearch";	
	private String columnNameemployeeRUNMODE="RUNMODE";
	public static String  Employee_namecheck=null;
	public static String  Employee_search=null;
	public static String  SelectQuestionnairetype=null;

	public static String  timer;


	public static String Questionnaire_Name_array[]=new String [100];

	static int instanceCounter = 0;
	static int instanceCounter1 = 0;
	static int counter1 = 0;

	public static int PositiveScenarioCounter				=	0;
	public static int NegativeScenarioCounter				=	0;
	public static int TotalTestCaseCounter				=	0;
	public static int NotassignedModuleCount_NAMC=0;

	public static boolean passCounter	=	false;
	public static boolean failCounter	=	false;
	public static boolean notAssignedCounter	=	false;
	public static boolean negativePassCounter	=	false;		

	public static int passTestCaseCounter					=	0;
	public static int failTestCaseCounter					=	0;
	public static int NotAssignedModuleCounter			=	0;
	long startTotalTime						=	0;


	private dashboard 	obj_Report_Dashboard;

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

			setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
			setSysDate(UtilFunction.currentDateTime());				
			setUtilfunc(new UtilFunction(this.getDriver()));	
			setobj_CIMS_Login(new CIMS_Login(webdriver, utilfunc));
			//CIMS_Basic_Information_Module
			setobj_CIMS_Basic_Information_Module(new CIMS_Basic_Information_module(webdriver, utilfunc));
			setobj_CIMS_Other_Name_Module(new CIMS_Other_Name_Module(webdriver, utilfunc));
			setobj_CIMS_Addional_Questionnaire_Module(new CIMS_Addional_Questionnaire_Module(webdriver, utilfunc));
			setobj_CIMS_Passport_Module(new CIMS_Passport_Module(webdriver, utilfunc));
			setobj_CIMS_USImmigration_Module(new CIMS_USImmigration_Module(webdriver, utilfunc));
			setobj_CIMS_Education_History_Module(new CIMS_Education_History_Module(webdriver, utilfunc));
			setobj_CIMS_GroupMemberships_Module(new CIMS_GroupMemberships_Module(webdriver, utilfunc));
			setobj_CIMS_Health_Insurance_Module(new CIMS_Health_Insurance_Module(webdriver, utilfunc));
			setobj_CIMS_Teacher_ChildHealthCare_Module(new CIMS_Teacher_ChildHealthCare_Module(webdriver, utilfunc));
			setobj_CIMS_Patents_Module(new CIMS_Patents_Module(webdriver, utilfunc));
			setobj_CIMS_Id_Documents_Module(new CIMS_Id_Documents_Module(webdriver, utilfunc));
			setobj_CIMS_Citizenship_Module(new CIMS_Citizenship_Module(webdriver, utilfunc));
			setobj_CIMS_Membership_Module(new CIMS_Membership_Module(webdriver, utilfunc));
			setobj_CIMS_Speaking_Engagements_Module(new CIMS_Speaking_Engagements_Module(webdriver, utilfunc));
			setobj_CIMS_Global_Immigration_History_Module(new CIMS_Global_Immigration_History_Module(webdriver, utilfunc));
			setobj_CIMS_Exhibitions_and_Showcases_Module(new CIMS_Exhibitions_and_Showcases_Module(webdriver, utilfunc));
			setobj_CIMS_AWARDS_MODULES(new CIMS_AWARDS_MODULES(webdriver,utilfunc));
			//				setobj_Project_Initiation(new Project_Initiation (webdriver,utilfunc));
			setobj_CIMS_Additional_Medical_History_Module(new CIMS_Additional_Medical_History_Module(webdriver, utilfunc));
			setobj_CIMS_Medical_History_Module(new CIMS_Medical_History_Module(webdriver, utilfunc));
			setobj_CIMS_Compensation_and_benifits_Module(new CIMS_Compensation_and_benifits_Module(webdriver, utilfunc));
			setobj_CIMS_Memberships_in_Professional_Module(new CIMS_Memberships_in_Professional_Module(webdriver, utilfunc));
			setobj_CIMS_EmployeeProcessing_Module(new CIMS_EmployeeProcessing_Module(webdriver, utilfunc));
			setobj_CIMS_SpecialAbility_Module(new CIMS_SpecialAbility_Module(webdriver, utilfunc));
			setobj_CIMS_Residence_History_Module(new CIMS_Residence_History_Module(webdriver, utilfunc));
			setobj_CIMS_Marriages_Module(new CIMS_Marriages_Module(webdriver, utilfunc));
			setobj_CIMS_Family_Members_Module(new CIMS_Family_Members_Module(webdriver, utilfunc));
			setobj_CIMS_Immigration_Documents_Module(new CIMS_Immigration_Documents_Module(webdriver, utilfunc));
			setobj_CIMS_Visits_Module(new CIMS_Visits_Module(webdriver, utilfunc));
			setobj_CIMS_Pregnancy_Module(new CIMS_Pregnancy_Module(webdriver, utilfunc));
			setobj_CIMS_Work_Locations_Module(new CIMS_Work_Locations_Module(webdriver,utilfunc));
			setobj_CIMS_Employer_Processing_Module(new CIMS_Employer_Processing_Module(webdriver,utilfunc));
			setobj_CIMS_Personal_Attributes_Module(new CIMS_Personal_Attributes_Module(webdriver,utilfunc));
			setobj_CIMS_Child_Details_Module(new CIMS_Child_Details_Module(webdriver,utilfunc));
			setobj_CIMS_CitationsofYourWork_Module(new CIMS_CitationsofYourWork_Module(webdriver,utilfunc));
			setobj_CIMS_LCA_info_Module(new CIMS_LCA_info_Module(webdriver,utilfunc));
			setobj_CIMS_Commercial_Success_Module(new CIMS_Commercial_Success_Module(webdriver,utilfunc));
			setobj_CIMS_Travel_Plans_Module(new CIMS_Travel_Plans_Module(webdriver,utilfunc));
			setobj_CIMS_Offsite_Employment_Module(new CIMS_Offsite_Employment_Module(webdriver,utilfunc));
			setobj_CIMS_Employment_History_Module(new CIMS_Employment_History_Module(webdriver,utilfunc));
			setobj_CIMS_Contact_Information_Module(new CIMS_Contact_Information_Module(webdriver,utilfunc));
			setobj_CIMS_Destination_Country_Employment_Module(new CIMS_Destination_Country_Employment_Module(webdriver,utilfunc));
			setobj_CIMS_Position_Requirements_Module(new CIMS_Position_Requirements_Module(webdriver,utilfunc));
			setobj_CIMS_Contributions_to_Your_Field_Module(new CIMS_Contributions_to_Your_Field_Module(webdriver,utilfunc));
			setobj_CIMS_Publications_Authored_Module(new CIMS_Publications_Authored_Module(webdriver,utilfunc));
			setobj_CIMS_Leading_or_Critical_Role_Module(new CIMS_Leading_or_Critical_Role_Module(webdriver,utilfunc));
			setobj_CIMS_Other_Evidence_of_Special_Ability_Module(new CIMS_Other_Evidence_of_Special_Ability_Module(webdriver,utilfunc));
			setobj_CIMS_Parent_Module(new CIMS_Parent_Module(webdriver,utilfunc));
			setobj_CIMS_Language_Proficiency_Module(new CIMS_Language_Proficiency_Module(webdriver,utilfunc));
			setobj_CIMS_Language_Study_Module(new CIMS_Language_Study_Module(webdriver,utilfunc));
			setobj_CIMS_Medical_Treatment_Module(new CIMS_Medical_Treatment_Module(webdriver,utilfunc));
			setobj_CIMS_Contacts_and_References_Module(new CIMS_Contacts_and_References_Module(webdriver,utilfunc));
			setobj_CIMS_Home_Country_Employment_Module(new CIMS_Home_Country_Employment_Module(webdriver,utilfunc));
			setobj_CIMS_Participation_as_Judge_Module(new CIMS_Participation_as_Judge_Module(webdriver,utilfunc));
			setobj_CIMS_EnglishLanguageAbility_Module(new CIMS_EnglishLanguageAbility_Module(webdriver,utilfunc));
			setobj_CIMS_QualifyingExperienceWithCompany_Module(new CIMS_QualifyingExperienceWithCompany_Module(webdriver,utilfunc));
			setobj_CIMS_Company_Contacts_Module(new CIMS_Company_Contacts_Module(webdriver,utilfunc));
			setobj_CIMS_Assessment_Module(new CIMS_Assessment_Module(webdriver,utilfunc));


			setobj_CIMS_ContactInformation_Mailing_Address(new CIMS_ContactInformation_Mailing_Address(webdriver,utilfunc));
			setobj_CIMS_ContactInformation_Permanent_Address(new CIMS_ContactInformation_Permanent_Address(webdriver,utilfunc));
			setobj_CIMS_ContactInformation_Email_Address(new CIMS_ContactInformation_Email_Address(webdriver,utilfunc));
			setobj_CIMS_ContactInformation_Phone_Number(new CIMS_ContactInformation_Phone_Number(webdriver,utilfunc));



			//obj_CIMS_SpecialAbility_Module
			//setobj_Email(new Email(webdriver, utilfunc));
			//setobj_questionariesutility(new questionariesutility(webdriver,utilfunc));
			//private CIMS_Medical_History_Module obj_CIMS_Medical_History_Module;

			setobj_dashboard((new dashboard()));

			if(utilfunc.Actualbrw.equals("IE")){
				webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			}else if(utilfunc.Actualbrw.equals("CHROME")){
				webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			}else{
				webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			}

			webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

			Reporter.log("");
			Reporter.log("***************************Opening the Application*********************************");

			boolean StartApplicationFlag = utilfunc.startApplication(fileName);
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


	public void searchProjectOrProfile() throws InterruptedException, IOException, AWTException{

	}


	// Our Test start from here.
	@Test()	
	public void CIMSMain() throws InterruptedException, IOException, AWTException {


		//for get count of +ve and -ve test cases.
		//int PositiveScenarioCounter				=	0;
		//int NegativeScenarioCounter				=	0;
		int ModuleCounter						=	0;
		//int TotalTestCaseCounter				=	0;

		String TotalTime						=	"";
		ArrayList NumberOfNotAssignModule = new ArrayList();


		try {
			/*p = System.getProperty("os.name");
			System.out.println("Operating system is"+p);*/

			// Project  Login	
			obj_CIMS_Login.Project_login(ExcelFileName);

			//Welcome page
			obj_CIMS_Login.Welcome_Page();
			utilfunc.zoomOut(6);

			//privacy disclaimer check
			try{
				String check=".//*[@id='chkConfirm']";
				String Agreebutton=".//*[@id='btnNext']";

				utilfunc.MakeElement(check).click();                               
				utilfunc.MakeElement(Agreebutton).click();

			}catch(Exception e){
				System.out.println("Privacy policy Disclaimer is not Exist on the Page");

			}

			System.out.println(Employee_namecheck+"\n"+"Questionnaire");
			int rowCountemployeesearch	=	UtilFunction.usedRowCount(fileNameemployee,sheetNameemployee);
			int RUNMODEemployeesearch=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameemployeeRUNMODE);
			String columnNameEN="EMPLOYEE NAME";
			int Employee_name=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameEN);
			String columnNameES="EMPLOYEE SEARCH NAME";
			int Employee_search_name=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameES);
			String columnNameSQT="QUESTIONNAIRE TYPE";
			int Questionnairetype=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameSQT);


			startTotalTime = System.currentTimeMillis();
			webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			for(int j = 1;j<rowCountemployeesearch;j++){
				if(UtilFunction.getCellData(fileNameemployee, sheetNameemployee, RUNMODEemployeesearch,j).equals("Y")){
					Employee_namecheck=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Employee_name, j);
					Employee_search=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Employee_search_name, j);
					SelectQuestionnairetype=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Questionnairetype, j);



					obj_CIMS_Login.searchemployee(Employee_namecheck,Employee_search);

					try{
						if(SelectQuestionnairetype.equals("PROFILE")){
							//modification
							String sidebarxpath=".//*[@id='slider-icon']";
							utilfunc.MakeElement(sidebarxpath).click();

							try{
								String Principalheaderxpath=".//*[@id='rnav-principal-header']/a";
								utilfunc.MakeElement(Principalheaderxpath).click();

								String Basicinfoxpath=".//*[@id='sectBasicInformation']/a";
								utilfunc.MakeElement(Basicinfoxpath).click();
							}catch(Exception error){}
						}
					}catch(Exception e){

					}

					/*String sidebarxpath=".//*[@id='slider-icon']";
			utilfunc.MakeElement(sidebarxpath).click();*/

					int rowCount	=	UtilFunction.usedRowCount(fileName,sheetName);
					int columnNumber_RUNMODE=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName);


					int columnNumber_ACTION=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName5);
					//questionarie label
					String columnName1="Questionnaire Name";
					int questionarie_name=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName1);


					//code
					Reporter.log("<br/>");
					Reporter.log("<img class='image1' style='width:100%;height:30px;' src='"+System.getProperty("user.dir")+"/CIMS/img.png'/>");


					System.out.println("\n\n---"+Employee_namecheck+"---\n\n");
					int counter=0;
					for(int i = 1;i<rowCount;i++){

						passCounter	=	false;
						failCounter	=	false;
						notAssignedCounter	=	false;
						negativePassCounter=false;

						//Below condition is used to check the RUNMODE for the Questionnaire modules
						if(UtilFunction.getCellData(fileName, sheetName, columnNumber_RUNMODE, i).equals("Y")){
							ModuleCounter=ModuleCounter+1;
							//if(UtilFunction.getCellData(fileName, sheetName, columnNumber_ACTION, i-1).equals("New")){

							//Questionnaire action mode(New,Edit, Delete)
							String QUESTIONNAIR_ACTION=UtilFunction.getCellData(fileName, sheetName, columnNumber_ACTION, i);

							//Questionnaire module name 
							questionarie_name1=UtilFunction.getCellData(fileName, sheetName, questionarie_name, i);

							// Do some stuff.  
							String fileName="Test Data.xls";
							String sheetName1=questionarie_name1;		
							String columnName="RUNMODE";
							//String columnName5="ACTION";
							int columnNumber_RUNMODE1=UtilFunction.getColumnWithCellData(fileName, sheetName1, columnName);
							int rowCount1	=	UtilFunction.usedRowCount(fileName,sheetName1);
							Main_questionarie_name_temp	=	SelectQuestionnairetype;
							
							
							// executing approx half modules
							firstHalfModulesOfQuestionnaire(QUESTIONNAIR_ACTION,rowCount1,sheetName1,columnNumber_RUNMODE1,counter,NumberOfNotAssignModule);



							///////////////////////START OF ContactInformationMailingAddres MODULES/////////////////////////////			
							if (questionarie_name1.contains("ContactInformationMailingAddres")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);					
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try{
												BasicInformationPage_flag=obj_CIMS_ContactInformation_Mailing_Address.ContactInformation_Mailing_Address(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_ContactInformation_Mailing_Address.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_ContactInformation_Mailing_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Mailing_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Mailing_Address.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_ContactInformation_Mailing_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Mailing_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Mailing_Address.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_ContactInformation_Mailing_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Mailing_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Mailing_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the ContactInformationMailingAddres Information");	
												}
												else{
													String status="FAIL";
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_ContactInformation_Mailing_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Mailing_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Mailing_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF ContactInformationMailingAddres MODULES//////////////////////////////////////////
							///////////////////////START OF ContactInfoPermanentAddres MODULES/////////////////////////////			
							else if (questionarie_name1.contains("ContactInfoPermanentAddres")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);					
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try{
												BasicInformationPage_flag=obj_CIMS_ContactInformation_Permanent_Address.ContactInformation_Mailing_Address(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_ContactInformation_Permanent_Address.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++; 
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_ContactInformation_Permanent_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Permanent_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Permanent_Address.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++; 
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_ContactInformation_Permanent_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Permanent_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Permanent_Address.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_ContactInformation_Permanent_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Permanent_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Permanent_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the ContactInfoPermanentAddres Information");	
												}
												else{
													String status="FAIL"; 
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_ContactInformation_Permanent_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Permanent_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Permanent_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF ContactInfoPermanentAddres MODULES//////////////////////////////////////////
							///////////////////////START OF ContactInformation_Email MODULES/////////////////////////////			
							else if(questionarie_name1.contains("ContactInformation_Email")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();		
										try{
											boolean BasicInformationPage_flag	=	false;
											try{
												BasicInformationPage_flag=obj_CIMS_ContactInformation_Email_Address.ContactInformation_Email_Address(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_ContactInformation_Email_Address.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_ContactInformation_Email_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Email_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Email_Address.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++; 
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_ContactInformation_Email_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Email_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Email_Address.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_ContactInformation_Email_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Email_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Email_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the ContactInformation_Email Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_ContactInformation_Email_Address.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Email_Address.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Email_Address.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF ContactInformation_Email MODULES//////////////////////////////////////////
							///////////////////////START OF ContactInformation_Phone MODULES/////////////////////////////			
							else if(questionarie_name1.contains("ContactInformation_Phone")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();		
										try{
											boolean BasicInformationPage_flag	=	false;
											try{
												BasicInformationPage_flag=obj_CIMS_ContactInformation_Phone_Number.ContactInformation_phone_Number(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_ContactInformation_Phone_Number.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_ContactInformation_Phone_Number.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Phone_Number.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Phone_Number.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_ContactInformation_Phone_Number.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Phone_Number.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Phone_Number.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_ContactInformation_Phone_Number.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Phone_Number.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Phone_Number.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the ContactInformation_Phone Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_ContactInformation_Phone_Number.testcaseid, utilfunc.Actualbrw, obj_CIMS_ContactInformation_Phone_Number.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_ContactInformation_Phone_Number.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF ContactInformation_Phone MODULES///////////////////////////////////
							///////////////////////START OF Destination_Country_Employment MODULES/////////////////////////////			
							else if(questionarie_name1.contains("Destination_Country_Employment")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Destination_Country_Employment_Module.Destination_Country_Employment_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Destination_Country_Employment_Module.URLwithID.equals("")){		//Not Assigned
												String status="FAIL";
												failTestCaseCounter++; 
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Destination_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Destination_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Destination_Country_Employment_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Destination_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Destination_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Destination_Country_Employment_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Destination_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Destination_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Destination_Country_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Destination_Country_Employment Information");	
												}
												else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Destination_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Destination_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Destination_Country_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}								
							///////////////////////END OF Destination_Country_Employment MODULES/////////////////////////////
							///////////////////////START OF  MODULES///////////////////////////////////				
							else if(questionarie_name1.contains("Position_Requirements")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();		
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Position_Requirements_Module.Position_Requirements_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Position_Requirements_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Position_Requirements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Position_Requirements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Position_Requirements_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Position_Requirements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Position_Requirements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Position_Requirements_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Position_Requirements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Position_Requirements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Position_Requirements_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Destination_Country_Employment Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Position_Requirements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Position_Requirements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Position_Requirements_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Position_Requirements MODULES///////////////////////////////////
							///////////////////////START OF Contributions_to_Your_Field MODULES///////////////////////////	
							else if(questionarie_name1.contains("Contributions_to_Your_Field")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_Contributions_to_Your_Field_Module.Contributions_to_Your_Field_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Contributions_to_Your_Field_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Contributions_to_Your_Field_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contributions_to_Your_Field_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contributions_to_Your_Field_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Contributions_to_Your_Field_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contributions_to_Your_Field_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contributions_to_Your_Field_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Contributions_to_Your_Field_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contributions_to_Your_Field_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contributions_to_Your_Field_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Contributions_to_Your_Field Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...														
													utilfunc.TestngReportFail1(obj_CIMS_Contributions_to_Your_Field_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contributions_to_Your_Field_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contributions_to_Your_Field_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Contributions_to_Your_Field MODULES///////////////////////////	
							///////////////////////START OF Publications_Authored MODULES///////////////////////////					
							else if(questionarie_name1.contains("Publications_Authored")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										///TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Publications_Authored_Module.Publications_Authored_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Publications_Authored_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Publications_Authored_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Publications_Authored_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Publications_Authored_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Publications_Authored_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Publications_Authored_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Publications_Authored_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Publications_Authored_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Publications_Authored_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Publications_Authored_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Publications_Authored Information");	
												}else{
													String status="FAIL";
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...														
													utilfunc.TestngReportFail1(obj_CIMS_Publications_Authored_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Publications_Authored_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Publications_Authored_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Publications_Authored MODULES///////////////////////////
							///////////////////////START OF Leading_or_Critical_Role MODULES//////////////////////				
							else if(questionarie_name1.contains("Leading_or_Critical_Role")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();

										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Leading_or_Critical_Role_Module.Leading_or_Critical_Role_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Leading_or_Critical_Role_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Leading_or_Critical_Role_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Leading_or_Critical_Role_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Leading_or_Critical_Role_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Leading_or_Critical_Role_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Leading_or_Critical_Role_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Leading_or_Critical_Role_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Leading_or_Critical_Role_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Leading_or_Critical_Role_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Leading_or_Critical_Role_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Leading_or_Critical_Role Information");	

												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Leading_or_Critical_Role_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Leading_or_Critical_Role_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Leading_or_Critical_Role_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Leading_or_Critical_Role MODULES//////////////////////
							///////////////////////START OF Other_Evidence_of_Special MODULES///////////////////	
							else if(questionarie_name1.contains("Other_Evidence_of_Special")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Other_Evidence_of_Special_Ability_Module.Other_Evidence_of_Special_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Other_Evidence_of_Special_Ability_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Other_Evidence_of_Special_Ability_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Evidence_of_Special_Ability_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Evidence_of_Special_Ability_Module.description, status, Errormessage);

											}else{
												if(BasicInformationPage_flag){		//PASS

													String status="PASS"; passTestCaseCounter++; if(passCounter==false){try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,status);} catch (Exception e) {}passCounter=true;}
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Other_Evidence_of_Special_Ability_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Evidence_of_Special_Ability_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Evidence_of_Special_Ability_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Other_Evidence_of_Special_Ability_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Evidence_of_Special_Ability_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Evidence_of_Special_Ability_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Other_Evidence_of_Special_Ability Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Other_Evidence_of_Special_Ability_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Evidence_of_Special_Ability_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Evidence_of_Special_Ability_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Other_Evidence_of_Special MODULES///////////////////
							///////////////////////START OF Parent MODULES///////////////////////////////////				
							else if(questionarie_name1.contains("Parent")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();

										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Parent_Module.Parent_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Parent_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Parent_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Parent_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Parent_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Parent_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Parent_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Parent_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Parent_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Parent_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Parent_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Parent Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Parent_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Parent_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Parent_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}

								}
							}
							///////////////////////END OF Parent MODULES///////////////////////////////////
							///////////////////////START OF Language_Proficiency MODULES/////////////////////////		
							else if(questionarie_name1.contains("Language_Proficiency")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_Language_Proficiency_Module.Language_Proficiency_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Language_Proficiency_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Language_Proficiency_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Proficiency_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Proficiency_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Language_Proficiency_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Proficiency_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Proficiency_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...	
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Language_Proficiency_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Proficiency_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Proficiency_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Language_Proficiency Information");	
												}else{
													String status="FAIL";
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Language_Proficiency_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Proficiency_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Proficiency_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Language_Proficiency MODULES/////////////////////////	
							///////////////////////START OF Language_Study MODULES/////////////////////////					
							else if(questionarie_name1.contains("Language_Study")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();

										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Language_Study_Module.Language_Study_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Language_Study_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Language_Study_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Study_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Study_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Language_Study_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Study_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Study_Module.description, status);
													}else {
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Language_Study_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Study_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Study_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Language_Study Information");	
												}else{
													String status="FAIL"; failTestCaseCounter++; if(failCounter==false){	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,status);	failCounter	= true;}
													utilfunc.TestngReportFail1(obj_CIMS_Language_Study_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Language_Study_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Language_Study_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}

								}

							}
							///////////////////////END OF Language_Study MODULES/////////////////////////
							///////////////////////START OF Medical_Treatment MODULES/////////////////////////					
							else if(questionarie_name1.contains("Medical_Treatment")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Medical_Treatment_Module.Medical_Treatment_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Medical_Treatment_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...													
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Medical_Treatment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_Treatment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_Treatment_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++; 
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Medical_Treatment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_Treatment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_Treatment_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Medical_Treatment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_Treatment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_Treatment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Medical_Treatment Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Medical_Treatment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_Treatment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_Treatment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Medical_Treatment MODULES/////////////////////////
							///////////////////////START OF Contacts_and_References MODULES//////////////////		
							else if(questionarie_name1.contains("Contacts_and_References")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);		
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Contacts_and_References_Module.Contacts_and_References_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Contacts_and_References_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Contacts_and_References_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contacts_and_References_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contacts_and_References_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Contacts_and_References_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contacts_and_References_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contacts_and_References_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Contacts_and_References_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contacts_and_References_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contacts_and_References_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Contacts_and_References Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Contacts_and_References_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contacts_and_References_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contacts_and_References_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Contacts_and_References MODULES//////////////////
							///////////////////////START OF Home_Country_Employment MODULES//////////////////				
							else if(questionarie_name1.contains("Home_Country_Employment")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_Home_Country_Employment_Module.Home_Country_Employment_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Home_Country_Employment_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Home_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Home_Country_Employment_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Home_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Home_Country_Employment_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Home_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Home_Country_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Home_Country_Employment Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Home_Country_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Home_Country_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Home_Country_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Home_Country_Employment MODULES//////////////////	
							///////////////////////START OF Participation_as_Judge MODULES//////////////////					
							else if(questionarie_name1.contains("Participation_as_Judge")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_Participation_as_Judge_Module.Participation_as_Judge_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Participation_as_Judge_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Participation_as_Judge_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Participation_as_Judge_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Participation_as_Judge_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Participation_as_Judge_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Participation_as_Judge_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Participation_as_Judge_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Participation_as_Judge_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Participation_as_Judge_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Participation_as_Judge_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Participation_as_Judge Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Participation_as_Judge_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Participation_as_Judge_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Participation_as_Judge_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF Participation_as_Judge MODULES//////////////////
							///////////////////////START OF EnglishLanguageAbility MODULES//////////////////				
							else if(questionarie_name1.contains("EnglishLanguageAbility")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();

										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_EnglishLanguageAbility_Module.CIMS_EnglishLanguageAbility_ModulePage(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_EnglishLanguageAbility_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_EnglishLanguageAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EnglishLanguageAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EnglishLanguageAbility_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS"; 
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_EnglishLanguageAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EnglishLanguageAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EnglishLanguageAbility_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_EnglishLanguageAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EnglishLanguageAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EnglishLanguageAbility_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the EnglishLanguageAbility Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_EnglishLanguageAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EnglishLanguageAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EnglishLanguageAbility_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF EnglishLanguageAbility MODULES//////////////////
							///////////////////////START OF QualifyingExperienceWithCompany MODULES//////////////////				
							else if(questionarie_name1.contains("QualifyingExperienceWithCompany")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;		
											try {
												BasicInformationPage_flag =obj_CIMS_QualifyingExperienceWithCompany_Module.CIMS_QualifyingExperienceWithCompany_ModulePage(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_QualifyingExperienceWithCompany_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_QualifyingExperienceWithCompany_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_QualifyingExperienceWithCompany_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_QualifyingExperienceWithCompany_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_QualifyingExperienceWithCompany_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_QualifyingExperienceWithCompany_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_QualifyingExperienceWithCompany_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_QualifyingExperienceWithCompany_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_QualifyingExperienceWithCompany_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_QualifyingExperienceWithCompany_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the QualifyingExperienceWithCompany Information");	
												}else{
													String status="FAIL"; 
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_QualifyingExperienceWithCompany_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_QualifyingExperienceWithCompany_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_QualifyingExperienceWithCompany_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
							///////////////////////END OF QualifyingExperienceWithCompany MODULES//////////////////	
							///////////////////////START OF Company_Contacts MODULES//////////////////				
							else if(questionarie_name1.contains("Company_Contacts")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Company_Contacts_Module.Company_Contacts_info(newcounter,QUESTIONNAIR_ACTION);
											}catch(Exception e){
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Company_Contacts_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS";
												passTestCaseCounter++;
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...													
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Company_Contacts_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Company_Contacts_Module.description, status, Errormessage);
											}else{
												if(BasicInformationPage_flag){		//PASS
													String status="PASS";
													passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Company_Contacts_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Company_Contacts_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Contacts_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Company_Contacts_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the QualifyingExperienceWithCompany Information");	
												}else{
													String status="FAIL";
													failTestCaseCounter++;
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Company_Contacts_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Company_Contacts_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}			
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
								///////////////////////END OF Company_Contacts MODULES//////////////////	
								///////////////////////START OF Assessment MODULES//////////////////						
							else if(questionarie_name1.contains("Assessment")){
								for(int newcounter=1;newcounter<rowCount1;newcounter++){
									if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
										ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
										////TIMER START///////
										long startTime = System.currentTimeMillis();			
										try{
											boolean BasicInformationPage_flag	=	false;
											try {
												BasicInformationPage_flag =obj_CIMS_Assessment_Module.Assessment_info(newcounter,QUESTIONNAIR_ACTION);
											} catch (Exception e) {
												System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
											///////TIMER END/////////////
											long endTime = System.currentTimeMillis();
											float seconds = (endTime - startTime) / 1000F;
											timer=Float.toString(seconds);
											if(obj_CIMS_Assessment_Module.URLwithID.equals("")){		//Not Assigned
												String status="PASS"; 
												passTestCaseCounter++;  
												//now write it in a notAssign file START...
												if(notAssignedCounter==false){
													try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
													}catch(Exception e){}
													notAssignedCounter=true;
													NumberOfNotAssignModule.add(questionarie_name1);
												}//now write it in a notAssign file ENDS...
												String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);
												utilfunc.TestngReportFail(obj_CIMS_Assessment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Assessment_Module.description, status, Errormessage);

											}else{
												if(BasicInformationPage_flag){		//PASS				
													String status="PASS"; 
													passTestCaseCounter++; 														
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
														// now write it in a pass file START...
														if(passCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
															}catch(Exception e){}
															passCounter=true;
														}// now write it in a pass file ENDS...
														utilfunc.TestngReportPass(obj_CIMS_Assessment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Assessment_Module.description, status);
													}else{
														// now write it in a negative pass dashboard file START...
														if(negativePassCounter==false){
															try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
															}catch(Exception e){}
															negativePassCounter=true;
														}// now write it in a negative pass dashboard file ENDS...
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Assessment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Assessment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User is Sucessfully Saved the Assessment Information");
												}else{
													String status="FAIL"; 
													failTestCaseCounter++; 
													// now write it in a fail dashboard file START...
													if(failCounter==false){
														try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
														}catch(Exception e){}
														failCounter	= true;
													}// now write it in a fail dashboard file ENDS...
													utilfunc.TestngReportFail1(obj_CIMS_Assessment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Assessment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Assessment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saveing the Information");
													utilfunc.TakeScreenshot();
												}
											}
										}catch(Exception e){
											ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
											System.out.println("Script Failed");
											utilfunc.assertion();			
											utilfunc.TakeScreenshot();
										}
									}
								}
							}
								///////////////////////END OF Assessment MODULES//////////////////
							Main_questionarie_name_temp="";
						}
					}
					}
			}
			System.out.println("PASS Object:" + instanceCounter);
			String strI = Integer.toString(instanceCounter);
			//Reporter.log("POSTIVE TESTCASES: "+strI);

			System.out.println("FAIL Object:" + instanceCounter1);
			String strI1 = Integer.toString(instanceCounter1);
			//Reporter.log("NEGATIVE TESTCASES: "+strI1);




			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(NumberOfNotAssignModule);
			NumberOfNotAssignModule.clear();
			NumberOfNotAssignModule.addAll(lhs);
			NotAssignedModuleCounter=NumberOfNotAssignModule.size();



		}
		catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed");
			utilfunc.assertion();			
			utilfunc.TakeScreenshot();
		}



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
		try{	TotalTestCaseCount				=	Integer.toString(TotalTestCaseCounter);		}catch(Exception error){}
		try{	FinalPositiveCount				=	Integer.toString(passTestCaseCounter);		}catch(Exception error){}
		try{	FinalNegativeCount				=	Integer.toString(failTestCaseCounter);		}catch(Exception error){}
		try{	NotAssignedModuleCount			=	Integer.toString(NotAssignedModuleCounter);	}catch(Exception error){}


		//utilfunc.TestngDashBoardReport("Left Navigation",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,FinalPositiveCount,FinalNegativeCount,NotAssignedModuleCount);
		// before generating final report let us check the time taken by the script..
		TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
		try{
			obj_Report_Dashboard.generateReportForSuite("Questionnaires",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
					FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
		}catch(Exception e){
			System.out.println("unable to call & generate dashboard report..");
		}
		Employee_namecheck=null;
		Employee_search=null;

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
	public void setobj_CIMS_Basic_Information_Module(CIMS_Basic_Information_module setobj_CIMS_Basic_Information_Module) {
		this.obj_CIMS_Basic_Information_Module = setobj_CIMS_Basic_Information_Module;
	}
	public void setobj_CIMS_Other_Name_Module(CIMS_Other_Name_Module setobj_CIMS_Other_Name_Module) {
		this.obj_CIMS_Other_Name_Module = setobj_CIMS_Other_Name_Module;
	}

	public void setobj_CIMS_Addional_Questionnaire_Module(CIMS_Addional_Questionnaire_Module setobj_CIMS_Addional_Questionnaire_Module) {
		this.obj_CIMS_Addional_Questionnaire_Module = setobj_CIMS_Addional_Questionnaire_Module;}

	public void setobj_CIMS_Passport_Module(CIMS_Passport_Module setobj_CIMS_Passport_Module) {
		this.obj_CIMS_Passport_Module = setobj_CIMS_Passport_Module; }

	public void setobj_CIMS_USImmigration_Module(CIMS_USImmigration_Module setobj_CIMS_USImmigration_Module) {
		this.obj_CIMS_USImmigration_Module = setobj_CIMS_USImmigration_Module;}

	public void setobj_CIMS_Education_History_Module(CIMS_Education_History_Module setobj_CIMS_Education_History_Module) {
		this.obj_CIMS_Education_History_Module = setobj_CIMS_Education_History_Module;}	

	public void setobj_CIMS_GroupMemberships_Module(CIMS_GroupMemberships_Module setobj_CIMS_GroupMemberships_Module) {
		this.obj_CIMS_GroupMemberships_Module = setobj_CIMS_GroupMemberships_Module;}	

	public void setobj_CIMS_Health_Insurance_Module(CIMS_Health_Insurance_Module setobj_CIMS_Health_Insurance_Module) {
		this.obj_CIMS_Health_Insurance_Module = setobj_CIMS_Health_Insurance_Module;	 }

	public void setobj_CIMS_Medical_History_Module(CIMS_Medical_History_Module setobj_CIMS_Medical_History_Module) {
		this.obj_CIMS_Medical_History_Module = setobj_CIMS_Medical_History_Module;	 }

	public void setobj_CIMS_Teacher_ChildHealthCare_Module(CIMS_Teacher_ChildHealthCare_Module setobj_CIMS_Teacher_ChildHealthCare_Module) {
		this.obj_CIMS_Teacher_ChildHealthCare_Module = setobj_CIMS_Teacher_ChildHealthCare_Module;	 

	}
	public void setobj_CIMS_Patents_Module(CIMS_Patents_Module setobj_CIMS_Patents_Module) {
		this.obj_CIMS_Patents_Module = setobj_CIMS_Patents_Module;	 

	}
	public void setobj_CIMS_Id_Documents_Module(CIMS_Id_Documents_Module setobj_CIMS_Id_Documents_Module) {
		this.obj_CIMS_Id_Documents_Module = setobj_CIMS_Id_Documents_Module;	 

	}
	public void setobj_CIMS_Citizenship_Module(CIMS_Citizenship_Module setobj_CIMS_Citizenship_Module) {
		this.obj_CIMS_Citizenship_Module = setobj_CIMS_Citizenship_Module;	 

	}
	public void setobj_CIMS_Membership_Module(CIMS_Membership_Module setobj_CIMS_Membership_Module) {
		this.obj_CIMS_Membership_Module = setobj_CIMS_Membership_Module;	 

	}
	public void setobj_CIMS_Speaking_Engagements_Module(CIMS_Speaking_Engagements_Module setobj_CIMS_Speaking_Engagements_Module) {
		this.obj_CIMS_Speaking_Engagements_Module = setobj_CIMS_Speaking_Engagements_Module;	 

	}

	public void setobj_CIMS_Global_Immigration_History_Module(CIMS_Global_Immigration_History_Module setobj_CIMS_Global_Immigration_History_Module) {
		this.obj_CIMS_Global_Immigration_History_Module = setobj_CIMS_Global_Immigration_History_Module;	 

	}
	public void setobj_CIMS_Exhibitions_and_Showcases_Module(CIMS_Exhibitions_and_Showcases_Module setobj_CIMS_Exhibitions_and_Showcases_Module) {
		this.obj_CIMS_Exhibitions_and_Showcases_Module = setobj_CIMS_Exhibitions_and_Showcases_Module;	 

	}


	public void setobj_CIMS_AWARDS_MODULES(CIMS_AWARDS_MODULES setobj_CIMS_AWARDS_MODULES) {
		this.obj_CIMS_AWARDS_MODULES = setobj_CIMS_AWARDS_MODULES;	 

	}

	public void setobj_Project_Initiation(Project_Initiation setobj_Project_Initiation) {
		this.obj_CIMS_Project_Initiation = setobj_Project_Initiation;	 

	}
	public void setobj_CIMS_Additional_Medical_History_Module(CIMS_Additional_Medical_History_Module setobj_CIMS_Additional_Medical_History_Module) {
		this.obj_CIMS_Additional_Medical_History_Module = setobj_CIMS_Additional_Medical_History_Module;	 
	}

	public void setobj_CIMS_Compensation_and_benifits_Module(CIMS_Compensation_and_benifits_Module obj_CIMS_Compensation_and_benifits_Module){
		this.obj_CIMS_Compensation_and_benifits_Module=obj_CIMS_Compensation_and_benifits_Module;
	}
	public void setobj_CIMS_Memberships_in_Professional_Module(CIMS_Memberships_in_Professional_Module setobj_CIMS_Memberships_in_Professional_Module) {
		this.obj_CIMS_Memberships_in_Professional_Module = setobj_CIMS_Memberships_in_Professional_Module;  
	}

	public void setobj_CIMS_EmployeeProcessing_Module(CIMS_EmployeeProcessing_Module setobj_CIMS_EmployeeProcessing_Module) {
		this.obj_CIMS_EmployeeProcessing_Module = setobj_CIMS_EmployeeProcessing_Module;  
	}

	public void setobj_CIMS_SpecialAbility_Module(CIMS_SpecialAbility_Module setobj_CIMS_SpecialAbility_Module) {
		this.obj_CIMS_SpecialAbility_Module = setobj_CIMS_SpecialAbility_Module;  
	}
	public void setobj_CIMS_Residence_History_Module(CIMS_Residence_History_Module setobj_CIMS_Residence_History_Module) {
		this.obj_CIMS_Residence_History_Module = setobj_CIMS_Residence_History_Module;  
	}
	public void setobj_CIMS_Marriages_Module(CIMS_Marriages_Module setobj_CIMS_Marriages_Module) {
		this.obj_CIMS_Marriages_Module = setobj_CIMS_Marriages_Module;  
	}
	public void setobj_CIMS_Family_Members_Module(CIMS_Family_Members_Module setobj_CIMS_Family_Members_Module) {
		this.obj_CIMS_Family_Members_Module = setobj_CIMS_Family_Members_Module;  
	}
	public void setobj_CIMS_Immigration_Documents_Module(CIMS_Immigration_Documents_Module setobj_CIMS_Immigration_Documents_Module) {
		this.obj_CIMS_Immigration_Documents_Module = setobj_CIMS_Immigration_Documents_Module;  
	}
	public void setobj_CIMS_Visits_Module(CIMS_Visits_Module setobj_CIMS_Visits_Module) {
		this.obj_CIMS_Visits_Module = setobj_CIMS_Visits_Module;  
	}
	public void setobj_CIMS_Pregnancy_Module(CIMS_Pregnancy_Module setobj_CIMS_Pregnancy_Module) {
		this.obj__CIMS_Pregnancy_Module = setobj_CIMS_Pregnancy_Module;  
	}
	public void setobj_CIMS_Work_Locations_Module(CIMS_Work_Locations_Module setobj_CIMS_Work_Locations_Module) {
		this.obj_CIMS_Work_Locations_Module = setobj_CIMS_Work_Locations_Module;  
	}
	public void setobj_CIMS_Employer_Processing_Module(CIMS_Employer_Processing_Module setobj_CIMS_Employer_Processing_Module) {
		this.obj_CIMS_Employer_Processing_Module = setobj_CIMS_Employer_Processing_Module;  
	}
	public void setobj_CIMS_Personal_Attributes_Module(CIMS_Personal_Attributes_Module setobj_CIMS_Personal_Attributes_Module) {
		this.obj_CIMS_Personal_Attributes_Module = setobj_CIMS_Personal_Attributes_Module;  
	}
	public void setobj_CIMS_Child_Details_Module(CIMS_Child_Details_Module setobj_CIMS_Child_Details_Module) {
		this.obj_CIMS_Child_Details_Module = setobj_CIMS_Child_Details_Module;  
	}
	public void setobj_CIMS_CitationsofYourWork_Module(CIMS_CitationsofYourWork_Module setobj_CIMS_CitationsofYourWork_Module) {
		this.obj_CIMS_CitationsofYourWork_Module = setobj_CIMS_CitationsofYourWork_Module;  
	}
	public void setobj_CIMS_LCA_info_Module(CIMS_LCA_info_Module setobj_CIMS_LCA_info_Module) {
		this.obj_CIMS_LCA_info_Module = setobj_CIMS_LCA_info_Module;  
	}
	public void setobj_CIMS_Commercial_Success_Module(CIMS_Commercial_Success_Module setobj_CIMS_Commercial_Success_Module) {
		this.obj_CIMS_Commercial_Success_Module = setobj_CIMS_Commercial_Success_Module;  
	}
	public void setobj_CIMS_Travel_Plans_Module(CIMS_Travel_Plans_Module setobj_CIMS_Travel_Plans_Module) {
		this.obj_CIMS_Travel_Plans_Module = setobj_CIMS_Travel_Plans_Module;  
	}
	public void setobj_CIMS_Offsite_Employment_Module(CIMS_Offsite_Employment_Module setobj_CIMS_Offsite_Employment_Module) {
		this.obj_CIMS_Offsite_Employment_Module = setobj_CIMS_Offsite_Employment_Module;  
	}
	public void setobj_CIMS_Employment_History_Module(CIMS_Employment_History_Module setobj_CIMS_Employment_History_Module) {
		this.obj_CIMS_Employment_History_Module = setobj_CIMS_Employment_History_Module;  
	}
	public void setobj_CIMS_Contact_Information_Module(CIMS_Contact_Information_Module setobj_CIMS_Contact_Information_Module) {
		this.obj_CIMS_Contact_Information_Module = setobj_CIMS_Contact_Information_Module;  
	}
	public void setobj_CIMS_Destination_Country_Employment_Module(CIMS_Destination_Country_Employment_Module setobj_CIMS_Destination_Country_Employment_Module) {
		this.obj_CIMS_Destination_Country_Employment_Module = setobj_CIMS_Destination_Country_Employment_Module;  
	}
	public void setobj_CIMS_Position_Requirements_Module(CIMS_Position_Requirements_Module setobj_CIMS_Destination_Country_Employment_Module) {
		this.obj_CIMS_Position_Requirements_Module = setobj_CIMS_Destination_Country_Employment_Module;  
	}
	public void setobj_CIMS_Contributions_to_Your_Field_Module(CIMS_Contributions_to_Your_Field_Module setobj_CIMS_Contributions_to_Your_Field_Module) {
		this.obj_CIMS_Contributions_to_Your_Field_Module = setobj_CIMS_Contributions_to_Your_Field_Module;  
	}
	public void setobj_CIMS_Publications_Authored_Module(CIMS_Publications_Authored_Module setobj_CIMS_Publications_Authored_Module) {
		this.obj_CIMS_Publications_Authored_Module = setobj_CIMS_Publications_Authored_Module;  
	}
	public void setobj_CIMS_Leading_or_Critical_Role_Module(CIMS_Leading_or_Critical_Role_Module setobj_CIMS_Leading_or_Critical_Role_Module) {
		this.obj_CIMS_Leading_or_Critical_Role_Module = setobj_CIMS_Leading_or_Critical_Role_Module;  
	}
	public void setobj_CIMS_Other_Evidence_of_Special_Ability_Module(CIMS_Other_Evidence_of_Special_Ability_Module setobj_CIMS_Other_Evidence_of_Special_Ability_Module) {
		this.obj_CIMS_Other_Evidence_of_Special_Ability_Module = setobj_CIMS_Other_Evidence_of_Special_Ability_Module;  
	}
	public void setobj_CIMS_Parent_Module(CIMS_Parent_Module setobj_CIMS_Parent_Module) {
		this.obj_CIMS_Parent_Module = setobj_CIMS_Parent_Module;  
	}
	public void setobj_CIMS_Language_Proficiency_Module(CIMS_Language_Proficiency_Module setobj_CIMS_Language_Proficiency_Module) {
		this.obj_CIMS_Language_Proficiency_Module = setobj_CIMS_Language_Proficiency_Module;  
	}
	public void setobj_CIMS_Language_Study_Module(CIMS_Language_Study_Module setobj_CIMS_Language_Study_Module) {
		this.obj_CIMS_Language_Study_Module = setobj_CIMS_Language_Study_Module;  
	}
	public void setobj_CIMS_Medical_Treatment_Module(CIMS_Medical_Treatment_Module setobj_CIMS_Medical_Treatment_Module) {
		this.obj_CIMS_Medical_Treatment_Module = setobj_CIMS_Medical_Treatment_Module;  
	}

	public void setobj_CIMS_Contacts_and_References_Module(CIMS_Contacts_and_References_Module setobj_CIMS_Contacts_and_References_Module) {
		this.obj_CIMS_Contacts_and_References_Module = setobj_CIMS_Contacts_and_References_Module;  
	}
	public void setobj_CIMS_Home_Country_Employment_Module(CIMS_Home_Country_Employment_Module setobj_CIMS_Home_Country_Employment_Module) {
		this.obj_CIMS_Home_Country_Employment_Module = setobj_CIMS_Home_Country_Employment_Module;  
	}
	public void setobj_CIMS_Participation_as_Judge_Module(CIMS_Participation_as_Judge_Module setobj_CIMS_Participation_as_Judge_Module) {
		this.obj_CIMS_Participation_as_Judge_Module = setobj_CIMS_Participation_as_Judge_Module;  
	}
	public void setobj_CIMS_EnglishLanguageAbility_Module(CIMS_EnglishLanguageAbility_Module setobj_CIMS_EnglishLanguageAbility_Module) {
		this.obj_CIMS_EnglishLanguageAbility_Module = setobj_CIMS_EnglishLanguageAbility_Module;  
	}
	public void setobj_CIMS_QualifyingExperienceWithCompany_Module(CIMS_QualifyingExperienceWithCompany_Module setobj_CIMS_QualifyingExperienceWithCompany_Module) {
		this.obj_CIMS_QualifyingExperienceWithCompany_Module = setobj_CIMS_QualifyingExperienceWithCompany_Module;  
	}
	public void setobj_CIMS_Company_Contacts_Module(CIMS_Company_Contacts_Module setobj_CIMS_Company_Contacts_Module) {
		this.obj_CIMS_Company_Contacts_Module = setobj_CIMS_Company_Contacts_Module;  
	}
	public void setobj_CIMS_Assessment_Module(CIMS_Assessment_Module setobj_CIMS_Assessment_Module) {
		this.obj_CIMS_Assessment_Module = setobj_CIMS_Assessment_Module;  
	}




	public void setobj_CIMS_ContactInformation_Mailing_Address(CIMS_ContactInformation_Mailing_Address setobj_CIMS_ContactInformation_Mailing_Address) {
		this.obj_CIMS_ContactInformation_Mailing_Address = setobj_CIMS_ContactInformation_Mailing_Address;  
	}
	public void setobj_CIMS_ContactInformation_Permanent_Address(CIMS_ContactInformation_Permanent_Address setobj_CIMS_ContactInformation_Permanent_Address) {
		this.obj_CIMS_ContactInformation_Permanent_Address = setobj_CIMS_ContactInformation_Permanent_Address;  
	}
	public void setobj_CIMS_ContactInformation_Email_Address(CIMS_ContactInformation_Email_Address setobj_CIMS_ContactInformation_Email_Address) {
		this.obj_CIMS_ContactInformation_Email_Address = setobj_CIMS_ContactInformation_Email_Address;  
	}
	public void setobj_CIMS_ContactInformation_Phone_Number(CIMS_ContactInformation_Phone_Number setobj_CIMS_ContactInformation_Phone_Number) {
		this.obj_CIMS_ContactInformation_Phone_Number = setobj_CIMS_ContactInformation_Phone_Number;  
	}






	//  CIMS_Assessment_Module

	// dashboard report
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}

	public void ScenarioAndTotalcounter(String fileName,String SheetName1, int newcounter,int PositiveScenarioCount, int NegativeScenarioCount, int TotalTestCaseCoun )
	{
		try{
			int Scenariocol	=	UtilFunction.getColumnWithCellData(fileName, SheetName1, "SCENARIO");
			String Scenariotext	= 	UtilFunction.getCellData(fileName, SheetName1, Scenariocol, newcounter);
			if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos"))
			{
				PositiveScenarioCounter++;
			}
			else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") )
			{
				NegativeScenarioCounter++;
			}
			TotalTestCaseCounter++;
		}catch(Exception error){}
	}



	public void firstHalfModulesOfQuestionnaire(String QUESTIONNAIR_ACTION, int rowCount1, String sheetName1, int columnNumber_RUNMODE1, int counter,ArrayList NumberOfNotAssignModule){

		///////////////////////START OF BASIC INFORMATION MODULES//////////////////////////////////////////////////
		if (questionarie_name1.contains("Basic_Information")) {
			for(int newcounter=1;newcounter<rowCount1;newcounter++){//Below condition is used to check the run mode of Basic Information page from excel sheet
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);	
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try{
							BasicInformationPage_flag = obj_CIMS_Basic_Information_Module.Basic_Information_info(newcounter,QUESTIONNAIR_ACTION);
						} catch (Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);

						if(obj_CIMS_Basic_Information_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++; 
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Basic_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Basic_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Basic_Information_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");} catch (Exception e) {}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Basic_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Basic_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Basic_Information_Module.description, status);	
								}else{	//Negative Pass
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");} catch (Exception e) {}
										negativePassCounter=true;
									}//now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Basic_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Basic_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Basic_Information_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);									
								}
								System.out.println("User is Sucessfully Saved the BASIC INFORMATION Information");

							}
							else{	//Fail
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Basic_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Basic_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Basic_Information_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);									System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}					
					}						
					catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}				
				}
			}
		}
		///////////////////////END OF BASIC INFORMATION MODULES//////////////////////////////////////////////////
		///////////////////////START OF OTHER NAME MODULES//////////////////////////////////////////////////				
		else if(questionarie_name1.contains("Other_Name")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Other_Name_Module.OtherNamePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);							
						if(obj_CIMS_Other_Name_Module.URLwithID.equals("")){		//Not Assigned 
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Other_Name_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Name_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Name_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Other_Name_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Name_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Name_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Other_Name_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Name_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Name_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Other Name Information");
								instanceCounter++;
								counter = counter + 1;
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Other_Name_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Other_Name_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Other_Name_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
								instanceCounter1++;
								counter1 = counter1 + 1;
							}					
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}				
			}
		}
		///////////////////////END OF OTHER NAME MODULES//////////////////////////////////////////////////		
		///////////////////////START OF US Immigration MODULES////////////////////////////////////////////
		else if(questionarie_name1.contains("USImmigration")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;		
						try {
							BasicInformationPage_flag =obj_CIMS_USImmigration_Module.USImmigrationPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_USImmigration_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_USImmigration_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_USImmigration_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_USImmigration_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_USImmigration_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_USImmigration_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_USImmigration_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_USImmigration_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_USImmigration_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_USImmigration_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Immigration Information");
								instanceCounter++;
								counter = counter + 1;
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_USImmigration_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_USImmigration_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_USImmigration_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}							
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}			
			}
		}
		///////////////////////END OF US Immigration MODULES//////////////////////////////////////////////////
		///////////////////////START OF US EDUCATION HISTORY MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Education_History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Education_History_Module.Education_HistoryPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);		
						if(obj_CIMS_Education_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Education_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Education_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Education_History_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;

								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Education_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Education_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Education_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Education_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Education_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Education_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Education_History Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Education_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Education_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Education_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}					
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}	
			}
		}
		///////////////////////END OF US EDUCATION HISTORY MODULES//////////////////////////////////////////////////
		///////////////////////START OF US Group Membership MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Group_Memberships")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_GroupMemberships_Module.PassportPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_GroupMemberships_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_GroupMemberships_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_GroupMemberships_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_GroupMemberships_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_GroupMemberships_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_GroupMemberships_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_GroupMemberships_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_GroupMemberships_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_GroupMemberships_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_GroupMemberships_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Group Memberships Information");	
							}else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_GroupMemberships_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_GroupMemberships_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_GroupMemberships_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}	
		///////////////////////END OF US Group Membership MODULES//////////////////////////////////////////////////	
		///////////////////////START OF Health Insurance MODULES//////////////////////////////////////////////////	
		else if(questionarie_name1.contains("Health_Insurance")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();								
					try{
						boolean BasicInformationPage_flag	=	false;
						try{
							BasicInformationPage_flag =obj_CIMS_Health_Insurance_Module.Health_InsurancePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Health_Insurance_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Health_Insurance_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Health_Insurance_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Health_Insurance_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Health_Insurance_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Health_Insurance_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Health_Insurance_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Health_Insurance_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Health_Insurance_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Health_Insurance_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Health Insurance Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Health_Insurance_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Health_Insurance_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Health_Insurance_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}			
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}				
		///////////////////////END OF Health Insurance MODULES//////////////////////////////////////////////////	
		///////////////////////START OF Medical History MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Medical_History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Medical_History_Module.Medical_HistoryPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Medical_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_History_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Medical History Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Medical_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}				
		///////////////////////END OF Medical History MODULES//////////////////////////////////////////////////	
		///////////////////////START OF Teacher Child HealthCare MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Teacher_ChildHealthCare")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Teacher_ChildHealthCare_Module.Teacher_ChildHealthCarePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Teacher_ChildHealthCare_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Teacher_ChildHealthCare_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Teacher_ChildHealthCare_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Teacher_ChildHealthCare_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Teacher_ChildHealthCare_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Teacher_ChildHealthCare_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Teacher_ChildHealthCare_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Teacher_ChildHealthCare_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Teacher_ChildHealthCare_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Teacher_ChildHealthCare_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Teacher Child HealthCare Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Teacher_ChildHealthCare_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Teacher_ChildHealthCare_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Teacher_ChildHealthCare_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is GCIMSetting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Teacher Child HealthCare MODULES//////////////////////////////////////////////////	
		///////////////////////START OF Parents MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Patents")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Patents_Module.PatentsPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}									
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Patents_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Patents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Patents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Patents_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Patents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Patents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Patents_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Patents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Patents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Patents_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Patents Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Patents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Patents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Patents_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}
		///////////////////////END OF Parents MODULES//////////////////////////////////////////////////
		///////////////////////START OF ID Documents MODULES//////////////////////////////////////////////////
		else if(questionarie_name1.contains("Id_Documents")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Id_Documents_Module.Id_DocumentsPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Id_Documents_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Id_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Id_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Id_Documents_Module.description, status, Errormessage);

						}else{
							if(BasicInformationPage_flag){		//PASS

								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Id_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Id_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Id_Documents_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Id_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Id_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Id_Documents_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully handle ID Documents module");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Id_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Id_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Id_Documents_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();										
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF ID Documents MODULES//////////////////////////////////////////////////	
		///////////////////////START OF Citizenship MODULES//////////////////////////////////////////////////	
		else if(questionarie_name1.contains("Citizenship")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;		try {BasicInformationPage_flag =obj_CIMS_Citizenship_Module.CitizenshipPage(newcounter,QUESTIONNAIR_ACTION);} catch (Exception e) {System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}

						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;


						timer=Float.toString(seconds);


						if(obj_CIMS_Citizenship_Module.URLwithID.equals("")){		//Not Assigned

							String status="PASS";
							passTestCaseCounter++;
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							utilfunc.TestngReportFail(obj_CIMS_Citizenship_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Citizenship_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Citizenship_Module.description, status, Errormessage);

						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Citizenship_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Citizenship_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Citizenship_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Citizenship_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Citizenship_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Citizenship_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Citizenship Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Citizenship_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Citizenship_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Citizenship_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage4,utilfunc.ErrorMessage1);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF Citizenship MODULES//////////////////////////////////////////////////
		///////////////////////START OF Membership Review MODULES//////////////////////////////
		else if(questionarie_name1.equals("Membership")){
			/*
			 * 
			 */
		}
		///////////////////////END OF Membership MODULES//////////////////////////////////////////////////
		///////////////////////START OF SpeakingEngagements MODULES//////////////////////
		else if(questionarie_name1.contains("SpeakingEngagements")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;		try {BasicInformationPage_flag =obj_CIMS_Speaking_Engagements_Module.Speaking_EngagementsPage(newcounter,QUESTIONNAIR_ACTION);} catch (Exception e) {System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Speaking_Engagements_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							utilfunc.TestngReportFail(obj_CIMS_Speaking_Engagements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Speaking_Engagements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Speaking_Engagements_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Speaking_Engagements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Speaking_Engagements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Speaking_Engagements_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Speaking_Engagements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Speaking_Engagements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Speaking_Engagements_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the SpeakingEngagements Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Speaking_Engagements_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Speaking_Engagements_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Speaking_Engagements_Module.description, status, utilfunc.ErrorMessage6,utilfunc.ErrorMessage6,utilfunc.globalerrormessage);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}					
		///////////////////////END OF Speaking Engagements MODULES//////////////////////////////////////////////////
		///////////////////////START OF Global Immigration History MODULES//////////////////////////////////////////
		else if(questionarie_name1.contains("Global_Immigration_History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Global_Immigration_History_Module.Global_Immigration_HistoryPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Global_Immigration_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Global_Immigration_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Immigration_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Global_Immigration_History_Module.description, status, Errormessage);

						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Global_Immigration_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Immigration_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Global_Immigration_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Global_Immigration_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Immigration_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Global_Immigration_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Global Immigration History");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Global_Immigration_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Immigration_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Global_Immigration_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF Global Immigration History MODULES//////////////////////////////////////////	
		///////////////////////START OF Exibition and Showcase MODULES///////////////////////////////////////////
		else if(questionarie_name1.contains("Exhibitions_and_Showcases")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;		try {BasicInformationPage_flag =obj_CIMS_Exhibitions_and_Showcases_Module.Exhibitions_and_ShowcasesPage(newcounter,QUESTIONNAIR_ACTION);} catch (Exception e) {System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Exhibitions_and_Showcases_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...								
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Exhibitions_and_Showcases_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Exhibitions_and_Showcases_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Exhibitions_and_Showcases_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Exhibitions_and_Showcases_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Exhibitions_and_Showcases_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Exhibitions_and_Showcases_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Exhibitions_and_Showcases_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Exhibitions_and_Showcases_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Exhibitions_and_Showcases_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Exhibitions_and_Showcases Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Exhibitions_and_Showcases_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Exhibitions_and_Showcases_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Exhibitions_and_Showcases_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Exibition and Showcase MODULES///////////////////////////////////////////	
		/*
		///////////////////////START OF Medical Cost MODULES//////////////////////////////////////////////////	
		else if(questionarie_name1.contains("Medical Cost")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;		try {BasicInformationPage_flag =obj_CIMS_Other_Name_Module.OtherNamePage(newcounter,QUESTIONNAIR_ACTION);} catch (Exception e) {System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}

						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;


						timer=Float.toString(seconds);


						if(obj_CIMS_Other_Name_Module.URLwithID.equals("")){		//Not Assigned

							String status="PASS"; passTestCaseCounter++;  if(notAssignedCounter==false){obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");notAssignedCounter=true;}
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);NumberOfNotAssignModule.add(questionarie_name1);
							//utilfunc.TestngReportFail(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status, Errormessage);

						}else{
							if(BasicInformationPage_flag){		//PASS

								Reporter.log("3. Exceution Status - PASS");
								Reporter.log("4. Sucess Message - ");

								System.out.println("User is Sucessfully Saved the Health_Insurance Information");	
							}
							else{
								Reporter.log("3. Exceution Status - FAIL");
								Reporter.log("4. Error Message - ");
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}
			///////////////////////END OF Medical Cost MODULES///////////////////////////////////////////////////
			*/
			///////////////////////START OF Pregnancy MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Pregnancy")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj__CIMS_Pregnancy_Module.PregnancyModulePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj__CIMS_Pregnancy_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj__CIMS_Pregnancy_Module.testcaseid, utilfunc.Actualbrw, obj__CIMS_Pregnancy_Module.scenerio,QUESTIONNAIR_ACTION, obj__CIMS_Pregnancy_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj__CIMS_Pregnancy_Module.testcaseid, utilfunc.Actualbrw, obj__CIMS_Pregnancy_Module.scenerio,QUESTIONNAIR_ACTION, obj__CIMS_Pregnancy_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj__CIMS_Pregnancy_Module.testcaseid, utilfunc.Actualbrw, obj__CIMS_Pregnancy_Module.scenerio,QUESTIONNAIR_ACTION, obj__CIMS_Pregnancy_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Pregnancy Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj__CIMS_Pregnancy_Module.testcaseid, utilfunc.Actualbrw, obj__CIMS_Pregnancy_Module.scenerio,QUESTIONNAIR_ACTION, obj__CIMS_Pregnancy_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Pregnancy MODULES////////////////////////////////////////////////////////////
		///////////////////////START OF Special Ability MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("SpecialAbility")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_SpecialAbility_Module.SpecialAbilityModulePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_SpecialAbility_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							utilfunc.TestngReportFail(obj_CIMS_SpecialAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_SpecialAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_SpecialAbility_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_SpecialAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_SpecialAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_SpecialAbility_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_SpecialAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_SpecialAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_SpecialAbility_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the SpecialAbility Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_SpecialAbility_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_SpecialAbility_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_SpecialAbility_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF Special Ability MODULES/////////////////////////////////////////////////////////
	/*
		///////////////////////START OF Employment History MODULES////////////////////////////////////////////////////
	
		else if(questionarie_name1.contains("Employment History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;		try {BasicInformationPage_flag =obj_CIMS_Other_Name_Module.OtherNamePage(newcounter,QUESTIONNAIR_ACTION);} catch (Exception e) {System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}

						//////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;


						timer=Float.toString(seconds);


						if(obj_CIMS_Other_Name_Module.URLwithID.equals("")){		//Not Assigned

							String status="PASS"; passTestCaseCounter++;  if(notAssignedCounter==false){obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");notAssignedCounter=true;}
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);NumberOfNotAssignModule.add(questionarie_name1);
							//utilfunc.TestngReportFail(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status, Errormessage);

						}else{
							if(BasicInformationPage_flag){		//PASS

								Reporter.log("3. Exceution Status - PASS");
								Reporter.log("4. Sucess Message - ");

								System.out.println("User is Sucessfully Saved the Health_Insurance Information");	
							}
							else{
								Reporter.log("3. Exceution Status - FAIL");
								Reporter.log("4. Error Message - ");
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Employment History MODULES////////////////////////////////////////////////////
		*/
			///////////////////////START OF Employee Processing MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("EmployeeProcessing")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_EmployeeProcessing_Module.EmployeeProcessing_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_EmployeeProcessing_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_EmployeeProcessing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EmployeeProcessing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EmployeeProcessing_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_EmployeeProcessing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EmployeeProcessing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EmployeeProcessing_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_EmployeeProcessing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EmployeeProcessing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EmployeeProcessing_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the EmployeeProcessing");	
							}
							else{
								String status="FAIL"; failTestCaseCounter++; if(failCounter==false){	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,status);	failCounter	= true;}
								utilfunc.TestngReportFail1(obj_CIMS_EmployeeProcessing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_EmployeeProcessing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_EmployeeProcessing_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage4,utilfunc.ErrorMessage5);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}					
		///////////////////////END OF Employee Processing MODULES////////////////////////////////////////////////////
		///////////////////////START OF awards MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("awards")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_AWARDS_MODULES.CIMS_AWARDS_ModulePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_AWARDS_MODULES.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_AWARDS_MODULES.testcaseid, utilfunc.Actualbrw, obj_CIMS_AWARDS_MODULES.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_AWARDS_MODULES.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_AWARDS_MODULES.testcaseid, utilfunc.Actualbrw, obj_CIMS_AWARDS_MODULES.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_AWARDS_MODULES.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_AWARDS_MODULES.testcaseid, utilfunc.Actualbrw, obj_CIMS_AWARDS_MODULES.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_AWARDS_MODULES.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the awards Information");
							}
							else{	//Fail
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_AWARDS_MODULES.testcaseid, utilfunc.Actualbrw, obj_CIMS_AWARDS_MODULES.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_AWARDS_MODULES.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage5,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF awards MODULES////////////////////////////////////////////////////
		//////////////////////START OF AddionalQuestionnaire module////////////////////////////////////
		else if(questionarie_name1.contains("AddionalQuestionnaire")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Addional_Questionnaire_Module.AddionalQuestionnairePage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Addional_Questionnaire_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Addional_Questionnaire_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Addional_Questionnaire_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Addional_Questionnaire_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Addional_Questionnaire_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Addional_Questionnaire_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Addional_Questionnaire_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Addional_Questionnaire_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Addional_Questionnaire_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Addional_Questionnaire_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Additional Questions Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Addional_Questionnaire_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Addional_Questionnaire_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Addional_Questionnaire_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF AddionalQuestionnaire MODULES////////////////////////////////////////////////////
		///////////////////////START OF Additional_Medical-history MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Additional_Medical-history")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Additional_Medical_History_Module.Additional_Medical_HistoryPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Additional_Medical_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++; 
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Additional_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Additional_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Additional_Medical_History_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Additional_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Additional_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Additional_Medical_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Additional_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Additional_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Additional_Medical_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Additional_Medical-history Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Additional_Medical_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Additional_Medical_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Additional_Medical_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}					
		///////////////////////END OF Additional_Medical-history MODULES////////////////////////////////////////////////////
		///////////////////////START OF PASSPORT MODULES///////////////////////////////////////////////
		else if(questionarie_name1.contains("Passport")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Passport_Module.PassportPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Passport_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Passport_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Passport_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Passport_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Passport_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Passport_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Passport_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Passport_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Passport_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Passport_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Passport Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Passport_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Passport_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Passport_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();										
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}
		///////////////////////END OF passport MODULES////////////////////////////////////////////////////
		////////////////////////START OF COMPENSATION AND BENIFIT MODULES///////////////////////////////
		else if(questionarie_name1.contains("compensation_and_benifit")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Compensation_and_benifits_Module.compensationPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Compensation_and_benifits_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Compensation_and_benifits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Compensation_and_benifits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Compensation_and_benifits_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Compensation_and_benifits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Compensation_and_benifits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Compensation_and_benifits_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Compensation_and_benifits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Compensation_and_benifits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Compensation_and_benifits_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the compensation_and_benifit Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Compensation_and_benifits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Compensation_and_benifits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Compensation_and_benifits_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		////////////////////////END OF COMPENSATION AND BENIFIT MODULES///////////////////////////////
		///////////////////////START OF Memberships_in_Professional MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Memberships_in_Professional")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);		
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Memberships_in_Professional_Module.Memberships_in_ProfessionalPage(newcounter,QUESTIONNAIR_ACTION);
						} catch (Exception e) {
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Memberships_in_Professional_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Memberships_in_Professional_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Memberships_in_Professional_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Memberships_in_Professional_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Memberships_in_Professional_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Memberships_in_Professional_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Memberships_in_Professional_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Memberships_in_Professional_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Memberships_in_Professional_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Memberships_in_Professional_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Memberships_in_Professional Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Memberships_in_Professional_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Memberships_in_Professional_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Memberships_in_Professional_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Memberships_in_Professional MODULES/////////////////////////////////////////
		///////////////////////START OF Residence_History MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Residence_History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Residence_History_Module.Residence_History_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Residence_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;  
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Residence_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Residence_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Residence_History_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Residence_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Residence_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Residence_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Residence_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Residence_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Residence_History_Module.description, status,utilfunc.ErrorMessage1,utilfunc.ErrorMessage2,utilfunc.ErrorMessage5);
								}
								System.out.println("User is Sucessfully Saved the Residence_History Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Residence_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Residence_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Residence_History_Module.description, status,utilfunc.ErrorMessage1,utilfunc.ErrorMessage2,utilfunc.ErrorMessage5);
								System.out.println("<font color='red'> User is Getting an Error Message while saveing the Information </font>");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Residence_History MODULES///////////////////////////////////////////
		///////////////////////START OF Marriages MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Marriages")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Marriages_Module.Marriages_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Marriages_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Marriages_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Marriages_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Marriages_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Marriages_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Marriages_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Marriages_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Marriages_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Marriages_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Marriages_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Marriages Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Marriages_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Marriages_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Marriages_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Marriages MODULES////////////////////////////////////////////////////
		///////////////////////START OF Family_Members MODULES///////////////////////////////////////////////
		else if(questionarie_name1.contains("Family_Members")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Family_Members_Module.Family_Members_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Family_Members_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Family_Members_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Family_Members_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Family_Members_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Family_Members_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Family_Members_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Family_Members_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Family_Members_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Family_Members_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Family_Members_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Family_Members Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Family_Members_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Family_Members_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Family_Members_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Family_Members MODULES///////////////////////////////////////////////
		///////////////////////START OF Immigration_Documents MODULES///////////////////////////////////////
		else if(questionarie_name1.contains("Immigration_Documents")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Immigration_Documents_Module.Immigration_Documents_info(newcounter,QUESTIONNAIR_ACTION);
						} catch (Exception e) {
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Immigration_Documents_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Immigration_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Immigration_Documents_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Immigration_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Immigration_Documents_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Immigration_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Immigration_Documents_Module.description, status,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Immigration_Documents Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Immigration_Documents_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Immigration_Documents_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Immigration_Documents_Module.description, status,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Immigration_Documents MODULES///////////////////////////////////////
		///////////////////////START OF Previous_Travel MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Previous_Travel")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Visits_Module.Visits_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Visits_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;  
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Visits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Visits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Visits_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Visits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Visits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Visits_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Visits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Visits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Visits_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Visits Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Visits_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Visits_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Visits_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Previous_Travel MODULES////////////////////////////////////////////////////	
		///////////////////////START OF Work_Locations MODULES//////////////////////////////////////////
		else if(questionarie_name1.contains("Work_Locations")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Work_Locations_Module.Work_Locations_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Work_Locations_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...								
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Work_Locations_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Work_Locations_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Work_Locations_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Work_Locations_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Work_Locations_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Work_Locations_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Work_Locations_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Work_Locations_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Work_Locations_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Work_Locations Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Work_Locations_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Work_Locations_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Work_Locations_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Work_Locations MODULES//////////////////////////////////////////
		///////////////////////START OF  Employer_Processing////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Employer_Processing")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Employer_Processing_Module.Employer_Processing_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Employer_Processing_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Employer_Processing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employer_Processing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employer_Processing_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Employer_Processing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employer_Processing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employer_Processing_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Employer_Processing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employer_Processing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employer_Processing_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Employer_Processing Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Employer_Processing_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employer_Processing_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employer_Processing_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}				
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF  Employer_Processing////////////////////////////////////////////////////
		///////////////////////START OF  Personal_Attributes MODULES//////////////////////////////////////////
		else if(questionarie_name1.contains("Personal_Attributes")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Personal_Attributes_Module.Personal_Attributes_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						//////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Personal_Attributes_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Personal_Attributes_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Personal_Attributes_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Personal_Attributes_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Personal_Attributes_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Personal_Attributes_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Personal_Attributes_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Personal_Attributes_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Personal_Attributes_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Personal_Attributes_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Personal_Attributes Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Personal_Attributes_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Personal_Attributes_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Personal_Attributes_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF  Personal_Attributes MODULES//////////////////////////////////////////
		///////////////////////START OF Child_Details MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Child_Details")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Child_Details_Module.Child_Details_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Child_Details_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Child_Details_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Child_Details_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Child_Details_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Child_Details_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Child_Details_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Child_Details_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Child_Details_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Child_Details_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Child_Details_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Child_Details Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Child_Details_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Child_Details_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Child_Details_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Child_Details MODULES////////////////////////////////////////////////////
		///////////////////////START OF Media_and_Publications MODULES////////////////////////////////////////////
		else if(questionarie_name1.contains("Media_and_Publications")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_CitationsofYourWork_Module.CitationsofYourWork_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_CitationsofYourWork_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;  
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_CitationsofYourWork_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_CitationsofYourWork_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_CitationsofYourWork_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...								
									utilfunc.TestngReportPass(obj_CIMS_CitationsofYourWork_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_CitationsofYourWork_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_CitationsofYourWork_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_CitationsofYourWork_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_CitationsofYourWork_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_CitationsofYourWork_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the CitationsofYourWork Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_CitationsofYourWork_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_CitationsofYourWork_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_CitationsofYourWork_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}						
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Media_and_Publications MODULES/////////////////////////////////
		///////////////////////START OF LCA_INFO MODULES//////////////////////////////////////////
		else if(questionarie_name1.contains("LCA_INFO")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_LCA_info_Module.LCA_info_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_LCA_info_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;  
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...								
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the LCA_INFO Information");
							}else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_LCA_info_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_LCA_info_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_LCA_info_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF LCA_INFO MODULES//////////////////////////////////////////
		///////////////////////START OF Commercial_Success MODULES////////////////////////////////////////////////////
		else if(questionarie_name1.contains("Commercial_Success")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);			
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;	
						try {
							BasicInformationPage_flag =obj_CIMS_Commercial_Success_Module.Commercial_SuccessPage(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Commercial_Success_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;  
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Commercial_Success_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Commercial_Success_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Commercial_Success_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Commercial_Success_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Commercial_Success_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Commercial_Success_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Commercial_Success_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Commercial_Success_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Commercial_Success_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Commercial_Success Information");	
							}
							else{
								String status="FAIL"; failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Commercial_Success_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Commercial_Success_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Commercial_Success_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage4,utilfunc.ErrorMessage5);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Commercial_Success MODULES//////////////////////////////////
		///////////////////////START OF Future_Travel MODULES//////////////////////////////////////////
		else if(questionarie_name1.contains("Future_Travel")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Travel_Plans_Module.Future_Travel_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Travel_Plans_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Travel_Plans_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_Plans_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Travel_Plans_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++;
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Travel_Plans_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_Plans_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Travel_Plans_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Travel_Plans_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_Plans_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Travel_Plans_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
								}
								System.out.println("User is Sucessfully Saved the Travel_Plans Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++;
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Travel_Plans_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_Plans_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Travel_Plans_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage5);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Future_Travel MODULES//////////////////////////////////////////
		///////////////////////START OF Offsite_Employment MODULES//////////////////////////////////////////	
		else if(questionarie_name1.contains("Offsite_Employment")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();
					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Offsite_Employment_Module.Offsite_Employment_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Offsite_Employment_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Offsite_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Offsite_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Offsite_Employment_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS";
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){	//Positive Pass
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Offsite_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Offsite_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Offsite_Employment_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Offsite_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Offsite_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Offsite_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Offsite_Employment Information");	
							}
							else{
								String status="FAIL";
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Offsite_Employment_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Offsite_Employment_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Offsite_Employment_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Offsite_Employment MODULES//////////////////////////////////////////	
		///////////////////////START OF Employment_History MODULES//////////////////////////////////////////		
		else if(questionarie_name1.contains("Employment_History")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;
						try {
							BasicInformationPage_flag =obj_CIMS_Employment_History_Module.Employment_History_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Employment_History_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS"; 
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Employment_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employment_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employment_History_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Employment_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employment_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employment_History_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Employment_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employment_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employment_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Employment_History Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Employment_History_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Employment_History_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Employment_History_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}
			}
		}
		///////////////////////END OF Employment_History MODULES//////////////////////////////////////////
		///////////////////////START OF Contact_Information MODULES//////////////////////////////////////////			
		else if(questionarie_name1.contains("Contact_Information")){
			for(int newcounter=1;newcounter<rowCount1;newcounter++){
				if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){					
					ScenarioAndTotalcounter(fileName, sheetName1, newcounter, PositiveScenarioCounter, NegativeScenarioCounter, TotalTestCaseCounter);					
					////TIMER START///////
					long startTime = System.currentTimeMillis();

					try{
						boolean BasicInformationPage_flag	=	false;
						try{
							BasicInformationPage_flag=obj_CIMS_Contact_Information_Module.Contact_Information_info(newcounter,QUESTIONNAIR_ACTION);
						}catch(Exception e){
							System.out.println("unable to execute questionnaire:  "+ questionarie_name1);}
						///////TIMER END/////////////
						long endTime = System.currentTimeMillis();
						float seconds = (endTime - startTime) / 1000F;
						timer=Float.toString(seconds);
						if(obj_CIMS_Contact_Information_Module.URLwithID.equals("")){		//Not Assigned
							String status="PASS";
							passTestCaseCounter++;
							//now write it in a notAssign file START...
							if(notAssignedCounter==false){
								try{	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Not Assigned");
								}catch(Exception e){}
								notAssignedCounter=true;
								NumberOfNotAssignModule.add(questionarie_name1);
							}//now write it in a notAssign file ENDS...
							String Errormessage=""+questionarie_name1+" is not assigned to "+Employee_namecheck+" User";
							System.out.println(Errormessage);
							utilfunc.TestngReportFail(obj_CIMS_Contact_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contact_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contact_Information_Module.description, status, Errormessage);
						}else{
							if(BasicInformationPage_flag){		//PASS
								String status="PASS"; 
								passTestCaseCounter++; 
								if(utilfunc.globalerrormessage.equals("")){
									// now write it in a pass file START...
									if(passCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1, "Pass");
										}catch(Exception e){}
										passCounter=true;
									}// now write it in a pass file ENDS...
									utilfunc.TestngReportPass(obj_CIMS_Contact_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contact_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contact_Information_Module.description, status);
								}else{
									// now write it in a negative pass dashboard file START...
									if(negativePassCounter==false){
										try {	obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Negative Pass");
										}catch(Exception e){}
										negativePassCounter=true;
									}// now write it in a negative pass dashboard file ENDS...
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Contact_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contact_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contact_Information_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
								System.out.println("User is Sucessfully Saved the Contact_Information Information");	
							}
							else{
								String status="FAIL"; 
								failTestCaseCounter++; 
								// now write it in a fail dashboard file START...
								if(failCounter==false){
									try{ obj_Report_Dashboard.writeReportHeader(sheetName, questionarie_name1,"Fail");
									}catch(Exception e){}
									failCounter	= true;
								}// now write it in a fail dashboard file ENDS...
								utilfunc.TestngReportFail1(obj_CIMS_Contact_Information_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Contact_Information_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Contact_Information_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								System.out.println("User is Getting an Error Message while saveing the Information");
								utilfunc.TakeScreenshot();
							}
						}
					}catch(Exception e){
						ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
						System.out.println("Script Failed");
						utilfunc.assertion();			
						utilfunc.TakeScreenshot();
					}
				}

			}
		}
		///////////////////////END OF Contact_Information MODULES//////////////////////////////////////////
	}

}

