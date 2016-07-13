package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
import CIMS.CIMS_EmployeeProfile;
import CIMS.CIMS_Regression_Suite;
import CIMS.Modules.Questionnaires.*;
import CIMS.Reports.dashboard;


public class CIMS_Regression_Suite_Employee_Profile {


	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.


	/**
	 * profile related obj..	
	 */
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
	    private dashboard 	obj_Report_Dashboard;
	    
	    //Lokesh Add these Code on 30June2016 STARTS
	    private CIMS_ContactInformation_Mailing_Address obj_CIMS_ContactInformation_Mailing_Address;
		private CIMS_ContactInformation_Permanent_Address obj_CIMS_ContactInformation_Permanent_Address;
		private CIMS_ContactInformation_Email_Address obj_CIMS_ContactInformation_Email_Address;
		private CIMS_ContactInformation_Phone_Number obj_CIMS_ContactInformation_Phone_Number;
	    //Lokesh Add these Code on 30June2016 ENDS
	   /**
	    * profile related obj ends here..
	    */
		
	    private String fileName="Test Data.xls";
		public static String sheetName="Employee Profile";		
		private String columnName="RUNMODE";
		private String columnName5="ACTION";
		public static String  questionarie_name1=null;

	/**
	 * @param args
	 */

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public static int PositiveScenarioCounter				=	0;
	public static int NegativeScenarioCounter				=	0;
	public static int TotalTestCaseCounter				=	0;
	public static int NotassignedModuleCount_NAMC=0;
	
	public static boolean passCounter	=	false;
	public static boolean failCounter	=	false;
	public static boolean notAssignedCounter	=	false;
	public static boolean negativePassCounter	=	false;
	
	public static String questionarie_name_temp="";

	public static int passTestCaseCounter					=	0;
	public static int failTestCaseCounter					=	0;
	public static int NotAssignedModuleCounter			=	0;
	long startTotalTime						=	0;

	//ArrayList NumberOfNotAssignModule = new ArrayList();
	
	public CIMS_Regression_Suite_Employee_Profile(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	@SuppressWarnings("static-access")
	public void Employee_Profile(String questionarie_name1, String QUESTIONNAIR_ACTION,
			String fileName,String  sheetName1,int columnNumber_RUNMODE1, int rowCount1,
			String Employee_namecheck, String SuiteName, ArrayList NumberOfNotAssignModule) throws Exception{
		questionarie_name_temp=questionarie_name1;
		System.out.println("\n===========\nWe are here to work with Employee Profile with \""+CIMS_EmployeeProfile.Employee_namecheck+"\" for \""+questionarie_name1+"\".");
		//CIMS_Basic_Information_Module
		setobj_CIMS_Basic_Information_module(new CIMS_Basic_Information_module(webdriver,utilfunc));
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
		//obj_CIMS_SpecialAbility_Module
		setobj_dashboard((new dashboard()));
		
		//Lokesh Add these code on 30June2016 STARTS
		setobj_CIMS_ContactInformation_Mailing_Address(new CIMS_ContactInformation_Mailing_Address(webdriver,utilfunc));
		setobj_CIMS_ContactInformation_Permanent_Address(new CIMS_ContactInformation_Permanent_Address(webdriver,utilfunc));
		setobj_CIMS_ContactInformation_Email_Address(new CIMS_ContactInformation_Email_Address(webdriver,utilfunc));
		setobj_CIMS_ContactInformation_Phone_Number(new CIMS_ContactInformation_Phone_Number(webdriver,utilfunc));
		//Lokesh Add these code on 30June2016 ENDS

//		long startTime	=	0;
		String timer;
//		String status;
		int instanceCounter = 0;
		int instanceCounter1 = 0;
		int counter1 = 0;
		int counter	=	0;
		//String status="";
		//notAssignedCounter=false;

		//Reset report flags false for headers
		notAssignedCounter=false;
		passCounter=false;
		negativePassCounter=false;
		failCounter=false;

System.out.println("notAssignedCounter is set to : "+notAssignedCounter+"\npassCounter is set to : "+passCounter+"\nnegativePassCounter is set to : "+negativePassCounter+"\nfailCounter is set to :"+failCounter+"\n===========\n");
		
		
		///////////////////////START OF BASIC INFORMATION MODULES//////////////////////////////////////////////////
		if (questionarie_name1.contains("Basic_Information")) {
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
		notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
		notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
									utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Commercial_Success_Module.testcaseid, utilfunc.Actualbrw, obj_CIMS_Commercial_Success_Module.scenerio,QUESTIONNAIR_ACTION, obj_CIMS_Commercial_Success_Module.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage4,utilfunc.ErrorMessage4);
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
	
		
		//////////////Lokesh Add These Modules here on 30June2016 STARTS
		
		else if (questionarie_name1.contains("ContactInformationMailingAddres")){
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
			notAssignedCounter=false;passCounter=false;negativePassCounter=false;failCounter=false;
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
		//////////////Lokesh Add These Modules here on 30June2016 ENDS
	
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.addAll(NumberOfNotAssignModule);
		NumberOfNotAssignModule.clear();
		NumberOfNotAssignModule.addAll(lhs);
		NotAssignedModuleCounter=NumberOfNotAssignModule.size();
		
		
		//Set report flags True for headers
				notAssignedCounter=true;
				passCounter=true;
				negativePassCounter=true;
				failCounter=true;
				questionarie_name_temp="";
	}
	
	
	
	
	public void setobj_CIMS_Basic_Information_module(CIMS_Basic_Information_module setobj_CIMS_Basic_Information_module) {
		this.obj_CIMS_Basic_Information_Module	=	setobj_CIMS_Basic_Information_module;
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
	

    //Lokesh Add these Code on 30June2016 STARTS
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
    //Lokesh Add these Code on 30June2016 ENDS
	
	
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

	
	
	public boolean Employee_Profiles(String filename, String sheetName,int ColumnCounter,String mode,String current_baseurl) throws AWTException, InterruptedException{

		boolean Flag	=	false;
		System.out.println("user is on '"+sheetName+"' module.");
		System.out.println("Entering "+mode+" mode for "+sheetName+" module");
		utilfunc.zoomOut(3);

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
		//String Document                                     =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
		String Renewing                                     =           UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
		String ReferenceNumber                              =           UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);

		System.out.println("\n\n============>\n"+TestcaseRunMode+"\n============>\n");

		if(TestcaseRunMode.equals("Y")){

			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;

			if(mode.equals("New")){
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

					if(AttrName.equalsIgnoreCase("CountryCode")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CountryCode);}catch(Exception error){}
						Thread.sleep(200);

					}else if(AttrName.equalsIgnoreCase("AuthorizedWorkCityOrProvince")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(AuthorizedWorkCityOrProvince);}catch(Exception error){}
						System.out.println("AuthorizedWorkCityOrProvince has been saved");
					}else if (AttrName.equalsIgnoreCase("CategoryId")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CategoryId );}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ClassificationId")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ClassificationId);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ProjectsAssociated")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ProjectsAssociated);}catch(Exception error){}
						Thread.sleep(200);
						String Addbtn=".//*[@id='form1']//*[@class='control-group'][6]//*[contains(text(),'Add') and contains(@class,'btn')]";
						try{utilfunc.MakeElement(Addbtn).click();}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("IssueDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(IssueDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("StartDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(StartDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("EndDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(EndDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ExpirationDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(ExpirationDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("MaximumDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(MaximumDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("LegalStatusCode")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, LegalStatusCode);}catch(Exception error){}
					}else if(AttrName.equalsIgnoreCase("Tracking"))
						{
						Thread.sleep(1000);
						try{
							if(Tracking.equalsIgnoreCase("Yes")){
								utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
							}else{
								utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
							}
						}catch(Exception errror){}
					}else if (AttrName.equalsIgnoreCase("Sponsor")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(Sponsor);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("BeneficiaryNumber")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(BeneficiaryNumber);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("Intermittent")){
						//utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(1000);
						try{
						if(Intermittent.equalsIgnoreCase("Yes")){
							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
						}else{
							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
						}}catch(Exception error){}
						try{
							if(Intermittent.equalsIgnoreCase("yes")){
								NewXpath=NewXpath+"//.[@value='True']";
								utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);
							}
							else{NewXpath=NewXpath+"//.[@value='False']";
							utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);}
						}catch(Exception error){}
						
					}else if(AttrName.equalsIgnoreCase("NoExpirationDate")){
						Thread.sleep(1000);
						try{
						if(NoExpirationDate.equalsIgnoreCase("Yes")){
							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
						}else{
							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
						}}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("FirstUse")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, FirstUse);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("Renewing")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, Renewing);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("ReferenceNumber")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(ReferenceNumber);}catch(Exception error){}
					}	
					else{}
				}
			}
			
			if(mode.equals("Edit")){
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

				int count = utilfunc.GetObjectCount(FormFeildXPath);
				System.out.println(count);

				for(int i=1; i <=count; i++){
					String NewXpath=FormFeildXCounterPath.replace("aa", Integer.toString(i));
					System.out.println("Print Xpath:" + NewXpath);
					String AttrName="";
					try{
						AttrName= utilfunc.MakeElement(NewXpath).getAttribute("name");
					}catch(Exception e){

					}
					System.out.println("Print AttrName " + AttrName);

					if(AttrName.equalsIgnoreCase("CountryCode")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CountryCode);}catch(Exception error){}
						Thread.sleep(200);

					}else if(AttrName.equalsIgnoreCase("AuthorizedWorkCityOrProvince")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(AuthorizedWorkCityOrProvince);}catch(Exception error){}
						System.out.println("AuthorizedWorkCityOrProvince has been saved");
					}else if (AttrName.equalsIgnoreCase("CategoryId")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath,CategoryId );}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ClassificationId")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ClassificationId);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ProjectsAssociated")){
						Thread.sleep(1000);
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, ProjectsAssociated);}catch(Exception error){}
						Thread.sleep(200);
						String Addbtn=".//*[@id='form1']//*[@class='control-group'][6]//*[contains(text(),'Add') and contains(@class,'btn')]";
						try{utilfunc.MakeElement(Addbtn).click();}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("IssueDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(IssueDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("StartDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(StartDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("EndDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(EndDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("ExpirationDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(ExpirationDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("MaximumDate")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(MaximumDate);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("LegalStatusCode")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, LegalStatusCode);}catch(Exception error){}
					}else if(AttrName.equalsIgnoreCase("Tracking"))
						{
						try{
							if(Tracking.equalsIgnoreCase("Yes")){
								utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
							}else{
								utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
							}
						}catch(Exception errror){}
					}else if (AttrName.equalsIgnoreCase("Sponsor")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(Sponsor);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("BeneficiaryNumber")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(BeneficiaryNumber);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("Intermittent")){
						//utilfunc.MakeElement(NewXpath).click();
						try{
						if(Intermittent.equalsIgnoreCase("Yes")){
							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
						}else{
							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
						}}catch(Exception error){}
						try{
							if(Intermittent.equalsIgnoreCase("yes")){
								NewXpath=NewXpath+"//.[@value='True']";
								utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);
							}
							else{NewXpath=NewXpath+"//.[@value='False']";
							utilfunc.Selectdropdownvaluebytext(NewXpath, Intermittent);}
						}catch(Exception error){}
						
					}else if(AttrName.equalsIgnoreCase("NoExpirationDate")){
						try{
						if(NoExpirationDate.equalsIgnoreCase("Yes")){
							utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
						}else{
							utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
						}}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("FirstUse")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, FirstUse);}catch(Exception error){}
					}else if (AttrName.equalsIgnoreCase("Renewing")){
						try{utilfunc.Selectdropdownvaluebytext(NewXpath, Renewing);}catch(Exception error){}
					}
					else if (AttrName.equalsIgnoreCase("ReferenceNumber")){
						try{utilfunc.MakeElement(NewXpath).sendKeys(ReferenceNumber);}catch(Exception error){}
					}	
					else{}
				}
			}
			
			
			try{
				// save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
				try{
					utilfunc.MakeElement(saveBtn).click();}
				catch(Exception error){System.out.println("some error during click save button");}
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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
					//webdriver.navigate().back();
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



		utilfunc.zoomIn(3);
		return Flag;
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
	
	

}
