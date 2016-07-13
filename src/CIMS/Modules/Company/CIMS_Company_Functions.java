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
import javax.swing.text.StyledEditorKit.BoldAction;
import listner.ErrorUtil;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.jna.platform.win32.WinUser.FLASHWINFO;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.sun.tracing.dtrace.ModuleName;

import util.UtilFunction;

import CIMS.Modules.Company.*;
import CIMS.Reports.*;

public class CIMS_Company_Functions {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	private CIMS_Company_Organization_Info obj_CIMS_Organization_Info;
	private CIMS_Company_General_Info obj_CIMS_Company_General_Info;
	private CIMS_Company_Subscribed_Services obj_CIMS_Company_Subscribed_Services;

	private CIMS_Company_Notes obj_CIMS_Company_Notes;
	private CIMS_Company_Entity obj_CIMS_Company_Entity;
	private CIMS_Company_CountryList obj_CIMS_Company_CountryList;
	private CIMS_Company_Communication obj_CIMS_Company_Communication;
	private CIMS_Company_RoleAssignment obj_CIMS_Company_RoleAssignment;
	private CIMS_Company_CompanyBatchRecruitment obj_CIMS_Company_CompanyBatchRecruitment;
	private CIMS_Company_VisaProfile obj_CIMS_Company_VisaProfile;

	private CIMS_Company_CustomLabels obj_CIMS_Company_CustomLabels;
	private CIMS_Company_PurposeCategories obj_CIMS_Company_PurposeCategories;

	//private CIMS_Company_Contacts_Module obj_CIMS_Company_Contacts_Module;

	//Lokesh Kumar Sharma code Start here
	private CIMS_Company_Statistics obj_CIMS_Company_Statistics;
	private CIMS_Company_Report_List obj_CIMS_Company_Report_List;
	private CIMS_Company_Integration obj_CIMS_Company_Integration;
	private CIMS_Company_Custom_Field obj_CIMS_Company_Custom_Field;
	private CIMS_Company_Document obj_CIMS_Company_Document;
	private CIMS_Company_RelocationCompanySetup obj_CIMS_Company_RelocationCompanySetup;
	private CIMS_Company_PrimaryCompanyRoles obj_CIMS_Company_PrimaryCompanyRoles;
	private CIMS_Company_NetworkPartnerContracts obj_CIMS_Company_NetworkPartnerContracts;
	private CIMS_Company_Contacts obj_CIMS_Company_Contacts;
	private CIMS_Company_Company_Job_Catalog obj_CIMS_Company_Company_Job_Catalog;

	private CIMS_Company_Perm_Posting_Notice obj_CIMS_Company_Perm_Posting_Notice;
	private CIMS_Company_RequestAccesstoCompany obj_CIMS_Company_RequestAccesstoCompany;
	private dashboard 									obj_Report_Dashboard;
	// Lokesh Kumar Sharma code Ends here

	//Devesh code Start here
	private CIMS_Company_Add_Business_Units  		obj_CIMS_Company_Add_Business_Units;
	//private CIMS_Company_CompanyJobCatalog 			obj_CIMS_Company_CompanyJobCatalog;
	private CIMS_Company_Company_Settings 			obj_CIMS_Company_Company_Settings;
	private CIMS_Company_Notifications 				obj_CIMS_Company_Notifications;
	//	private CIMS_Company_PermPostingNotice 			obj_CIMS_Company_PermPostingNotice;
	private CIMS_Company_ReferenceList 				obj_CIMS_Company_ReferenceList;
	private CIMS_Company_Locations					obj_CIMS_Company_Locations;
	private CIMS_Company_Network_Partner_Info		obj_CIMS_Company_Network_Partner_Info;
	//Devesh code Ends here


	public static String  timer;

	public static String  Employee_namecheck=null;
	public static String companyName=null;

	static int instanceCounter = 0;
	static int instanceCounter1 = 0;
	static int counter1 = 0;
	



	public CIMS_Company_Functions(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public void setobj_CIMS_Organization_Info(CIMS_Company_Organization_Info setobj_CIMS_Organization_Info) {
		this.obj_CIMS_Organization_Info = setobj_CIMS_Organization_Info;
	}

	public void setobj_CIMS_Company_Genral_Info(CIMS_Company_General_Info setobj_CIMS_Company_Genral_Info){
		this.obj_CIMS_Company_General_Info = setobj_CIMS_Company_Genral_Info;
	}

	public void setobj_CIMS_Company_Subscribed_Services(CIMS_Company_Subscribed_Services setobj_CIMS_Company_Subscribed_Services){
		this.obj_CIMS_Company_Subscribed_Services = setobj_CIMS_Company_Subscribed_Services;
	}

	public void setobj_CIMS_Company_Notes(CIMS_Company_Notes setobj_CIMS_Company_Notes){
		this.obj_CIMS_Company_Notes = setobj_CIMS_Company_Notes;
	}

	public void setobj_CIMS_Company_Entity(CIMS_Company_Entity setobj_CIMS_Company_Entity){
		this.obj_CIMS_Company_Entity = setobj_CIMS_Company_Entity;
	}

	public void setobj_CIMS_Company_CountryList(CIMS_Company_CountryList setobj_CIMS_Company_CountryList){
		this.obj_CIMS_Company_CountryList = setobj_CIMS_Company_CountryList;
	}

	public void setobj_CIMS_Company_Communication(CIMS_Company_Communication setobj_CIMS_Company_Communication){
		this.obj_CIMS_Company_Communication = setobj_CIMS_Company_Communication;
	}

	public void setobj_CIMS_Company_RoleAssignment(CIMS_Company_RoleAssignment setobj_CIMS_Company_RoleAssignment){
		this.obj_CIMS_Company_RoleAssignment = setobj_CIMS_Company_RoleAssignment;
	}

	public void setobj_CIMS_Company_CompanyBatchRecruitment(CIMS_Company_CompanyBatchRecruitment setobj_CIMS_Company_CompanyBatchRecruitment){
		this.obj_CIMS_Company_CompanyBatchRecruitment	=	setobj_CIMS_Company_CompanyBatchRecruitment;
	}

	public void setobj_CIMS_Company_VisaProfile(CIMS_Company_VisaProfile setobj_CIMS_Company_VisaProfile){
		this.obj_CIMS_Company_VisaProfile		=		setobj_CIMS_Company_VisaProfile;
	}

	public void setobj_CIMS_Company_CustomLabels(CIMS_Company_CustomLabels setobj_CIMS_Company_CustomLabels){
		this.obj_CIMS_Company_CustomLabels		=		setobj_CIMS_Company_CustomLabels;
	}

	public void setobj_CIMS_Company_PurposeCategories(CIMS_Company_PurposeCategories setobj_CIMS_Company_PurposeCategories){
		this.obj_CIMS_Company_PurposeCategories		=		setobj_CIMS_Company_PurposeCategories;
	}

	//	public void setobj_CIMS_Lo(CIMS_Company_Contacts_Module setobj_CIMS_Company_Contacts_Module){
	//		this.obj_CIMS_Company_Contacts_Module		=		setobj_CIMS_Company_Contacts_Module;
	//	}


	/**
	 * Lokesh Code Start here
	 */

	//for Company Statistics page
	public void setobj_CIMS_Company_Statistics(CIMS_Company_Statistics setobj_CIMS_Company_Statistics){
		this.obj_CIMS_Company_Statistics = setobj_CIMS_Company_Statistics;
	}
	// for Company Report List page
	public void setobj_CIMS_Company_Report_List(CIMS_Company_Report_List setobj_CIMS_Company_Report_List){
		this.obj_CIMS_Company_Report_List = setobj_CIMS_Company_Report_List;
	}
	//for Company Integration page
	public void setobj_CIMS_Company_Integration(CIMS_Company_Integration setobj_CIMS_Company_Integration){
		this.obj_CIMS_Company_Integration = setobj_CIMS_Company_Integration;
	}
	//for Company Custom field page
	public void setobj_CIMS_Company_Custom_Field(CIMS_Company_Custom_Field setobj_CIMS_Company_Custom_Field){
		this.obj_CIMS_Company_Custom_Field = setobj_CIMS_Company_Custom_Field;
	}
	//for Company Document page
	public void setobj_CIMS_Company_Document(CIMS_Company_Document setobj_CIMS_Company_Document){
		this.obj_CIMS_Company_Document = setobj_CIMS_Company_Document;
	}
	//for Company Relocation Company Setup page
	public void setobj_CIMS_Company_RelocationCompanySetup (CIMS_Company_RelocationCompanySetup setobj_CIMS_Company_RelocationCompanySetup){
		this.obj_CIMS_Company_RelocationCompanySetup=setobj_CIMS_Company_RelocationCompanySetup;
	}
	//for Company - Primary Company Roles page 
	public void setobj_CIMS_Company_PrimaryCompanyRoles(CIMS_Company_PrimaryCompanyRoles setobj_CIMS_Company_PrimaryCompanyRoles){
		this.obj_CIMS_Company_PrimaryCompanyRoles=setobj_CIMS_Company_PrimaryCompanyRoles;
	}
	//for Company - Network Partner Contracts
	public void setobj_CIMS_Company_NetworkPartnerContracts(CIMS_Company_NetworkPartnerContracts setobj_CIMS_Company_NetworkPartnerContracts){
		this.obj_CIMS_Company_NetworkPartnerContracts=setobj_CIMS_Company_NetworkPartnerContracts;
	}
	//for Company - Contacts
	public void setobj_CIMS_Company_Contacts(CIMS_Company_Contacts setobj_CIMS_Company_Contacts)
	{
		this.obj_CIMS_Company_Contacts=setobj_CIMS_Company_Contacts;
	}
	//for Company Company Job Catalog
	public void setobj_CIMS_Company_Company_Job_Catalog(CIMS_Company_Company_Job_Catalog setobj_CIMS_Company_Company_Job_Catalog){
		this.obj_CIMS_Company_Company_Job_Catalog=setobj_CIMS_Company_Company_Job_Catalog;
	}
	//for Company Perm Posting Notice
	public void setobj_CIMS_Company_Perm_posting_Notice(CIMS_Company_Perm_Posting_Notice setobjCims_Company_Perm_Posting_Notice){
		this.obj_CIMS_Company_Perm_Posting_Notice=setobjCims_Company_Perm_Posting_Notice;
	}
	//for Company Request Access to Company
	public void  setobj_CIMS_Company_RequestAccesstoCompany(CIMS_Company_RequestAccesstoCompany setobj_CIMS_Company_RequestAccesstoCompany){
		this.obj_CIMS_Company_RequestAccesstoCompany = setobj_CIMS_Company_RequestAccesstoCompany;
	}
	/**
	 * Lokesh Code End here 
	 */


	/**
	 * Devesh Code Starts here 
	 */

	public void setobj_CIMS_Company_Locations(CIMS_Company_Locations setobj_CIMS_Company_Locations){
		this.obj_CIMS_Company_Locations		=		setobj_CIMS_Company_Locations;
	}




	public void setobj_CIMS_Company_Add_Business_Units(CIMS_Company_Add_Business_Units setobj_CIMS_Company_Add_Business_Units){
		this.obj_CIMS_Company_Add_Business_Units=setobj_CIMS_Company_Add_Business_Units;
	}
	//	public void setobj_CIMS_Company_CompanyJobCatalog(CIMS_Company_CompanyJobCatalog setobj_CIMS_Company_CompanyJobCatalog){
	//		this.obj_CIMS_Company_CompanyJobCatalog=setobj_CIMS_Company_CompanyJobCatalog;
	//	}
	public void setobj_CIMS_Company_Company_Settings(CIMS_Company_Company_Settings setobj_CIMS_Company_Company_Settings){
		this.obj_CIMS_Company_Company_Settings	=	setobj_CIMS_Company_Company_Settings;
	}
	public void setobj_CIMS_Company_Notifications(CIMS_Company_Notifications setobj_CIMS_Company_Notifications){
		this.obj_CIMS_Company_Notifications=setobj_CIMS_Company_Notifications;
	}
	//	public void setobj_CIMS_Company_PermPostingNotice(CIMS_Company_PermPostingNotice setobj_CIMS_Company_PermPostingNotice){
	//		this.obj_CIMS_Company_PermPostingNotice=setobj_CIMS_Company_PermPostingNotice;
	//	}
	public void setobj_CIMS_Company_ReferenceList (CIMS_Company_ReferenceList  setobj_CIMS_Company_ReferenceList ){
		this.obj_CIMS_Company_ReferenceList =setobj_CIMS_Company_ReferenceList ;
	}
	public void setobj_CIMS_Company_Network_Partner_Info(CIMS_Company_Network_Partner_Info  setobj_CIMS_Company_Network_Partner_Info){
		this.obj_CIMS_Company_Network_Partner_Info =setobj_CIMS_Company_Network_Partner_Info ;
	}
	/**
	 * Devesh Code End here 
	 */


/*	@BeforeClass
	public void isSkipped(){

	}*/

	/**
	 * 
	 * @param fileName data excel sheet name
	 * @param columnNameRM run mode column name 
	 * @param columnNameAction action column name
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void addCompany(String fileName, String columnNameRM, String columnNameAction) throws AWTException, InterruptedException {


		System.out.println("\n=== === ===\tWelcome\n=== === === ");

		// setter
		setobj_CIMS_Organization_Info(new CIMS_Company_Organization_Info(webdriver, utilfunc));
		setobj_CIMS_Company_Genral_Info(new CIMS_Company_General_Info(webdriver, utilfunc));
		setobj_CIMS_Company_Subscribed_Services(new CIMS_Company_Subscribed_Services(webdriver, utilfunc));
		setobj_CIMS_Company_Notes(new CIMS_Company_Notes(webdriver, utilfunc));
		setobj_CIMS_Company_Entity(new CIMS_Company_Entity(webdriver, utilfunc));
		setobj_CIMS_Company_CountryList(new CIMS_Company_CountryList(webdriver, utilfunc));
		setobj_CIMS_Company_Communication(new CIMS_Company_Communication(webdriver, utilfunc));
		setobj_CIMS_Company_RoleAssignment(new CIMS_Company_RoleAssignment(webdriver, utilfunc));
		setobj_CIMS_Company_CompanyBatchRecruitment(new CIMS_Company_CompanyBatchRecruitment(webdriver, utilfunc));
		setobj_CIMS_Company_VisaProfile(new CIMS_Company_VisaProfile(webdriver, utilfunc));
	
		/**
		 * Lokesh code start here
		 */
		setobj_CIMS_Company_Statistics(new CIMS_Company_Statistics(webdriver,utilfunc));
		setobj_CIMS_Company_Report_List(new CIMS_Company_Report_List(webdriver,utilfunc));
		setobj_CIMS_Company_Integration(new CIMS_Company_Integration(webdriver,utilfunc));
		setobj_CIMS_Company_Custom_Field(new CIMS_Company_Custom_Field(webdriver,utilfunc));
		setobj_CIMS_Company_Document(new CIMS_Company_Document(webdriver, utilfunc));
		setobj_CIMS_Company_RelocationCompanySetup(new CIMS_Company_RelocationCompanySetup(webdriver, utilfunc));
		setobj_CIMS_Company_PrimaryCompanyRoles(new CIMS_Company_PrimaryCompanyRoles(webdriver, utilfunc));
		setobj_CIMS_Company_NetworkPartnerContracts(new CIMS_Company_NetworkPartnerContracts(webdriver, utilfunc));
		setobj_CIMS_Company_Contacts(new CIMS_Company_Contacts(webdriver, utilfunc));
		setobj_CIMS_Company_Company_Job_Catalog(new CIMS_Company_Company_Job_Catalog(webdriver, utilfunc));
	
		setobj_CIMS_Company_Perm_posting_Notice(new CIMS_Company_Perm_Posting_Notice(webdriver, utilfunc));
		setobj_CIMS_Company_RequestAccesstoCompany (new CIMS_Company_RequestAccesstoCompany(webdriver, utilfunc));
		/**
		 * Lokesh code ends here
		 */
	
		/**
		 * Lokesh code start here
		 */
	
		setobj_CIMS_Company_Locations(new CIMS_Company_Locations(webdriver, utilfunc));
	
		setobj_CIMS_Company_Statistics(new CIMS_Company_Statistics(webdriver,utilfunc));
		setobj_CIMS_Company_Report_List(new CIMS_Company_Report_List(webdriver,utilfunc));
		setobj_CIMS_Company_Integration(new CIMS_Company_Integration(webdriver,utilfunc));
		setobj_CIMS_Company_Custom_Field(new CIMS_Company_Custom_Field(webdriver,utilfunc));
		setobj_CIMS_Company_Document(new CIMS_Company_Document(webdriver, utilfunc));
		setobj_CIMS_Company_RelocationCompanySetup(new CIMS_Company_RelocationCompanySetup(webdriver, utilfunc));
		setobj_CIMS_Company_PrimaryCompanyRoles(new CIMS_Company_PrimaryCompanyRoles(webdriver, utilfunc));
		setobj_CIMS_Company_NetworkPartnerContracts(new CIMS_Company_NetworkPartnerContracts(webdriver, utilfunc));
		/**
		 * Lokesh code ends here
		 */
		setobj_CIMS_Company_Company_Settings(new CIMS_Company_Company_Settings(webdriver, utilfunc));
		setobj_CIMS_Company_CustomLabels(new CIMS_Company_CustomLabels(webdriver, utilfunc));
		setobj_CIMS_Company_Notifications(new CIMS_Company_Notifications(webdriver,utilfunc));
		setobj_CIMS_Company_ReferenceList(new CIMS_Company_ReferenceList(webdriver, utilfunc));
	
		setobj_CIMS_Company_Add_Business_Units(new CIMS_Company_Add_Business_Units(webdriver, utilfunc));
		setobj_CIMS_Company_Company_Settings(new CIMS_Company_Company_Settings(webdriver, utilfunc));
		setobj_CIMS_Company_PurposeCategories(new CIMS_Company_PurposeCategories(webdriver, utilfunc));
		setobj_CIMS_Company_Network_Partner_Info(new CIMS_Company_Network_Partner_Info(webdriver, utilfunc));
		setobj_dashboard((new dashboard()));




		// initializing variables 
		boolean  visitCompanyMenu		=	false;
		boolean VisitCompanyPage_flag	=	false;
		boolean VisitModule_flag		=	false;
		long startTime					=	0;
		String AddCompanySheetName		=	"Company";
		
		int AddCompanyRowCount			=0;
		int columnNumber_RUNMODE		=0;
		int columnNumber_ACTION			=0;
		int columnNumber_TabName		=0;
		int columnNumber_CompanyName	=0;
		
		
		//Lokesh add these lines for get count of +ve and -ve test cases.
		int PositiveScenarioCounter				=	0;
		int NegativeScenarioCounter				=	0;
		int ModuleCounter						=	0;
		int TotalTestCaseCounter				=	0;
		int passTestCaseCounter					=	0;
		int failTestCaseCounter					=	0;
		int NotAssignedModuleCounter			=	0;
		ArrayList NumberOfNotAssignModule = new ArrayList();
		long startTotalTime						=	0;
		String TotalTime						=	"";

		companyName			=	UtilFunction.getCellData(fileName, "Credentials", 4, 1);
		System.out.println(companyName);



		AddCompanyRowCount			=	UtilFunction.usedRowCount(fileName, AddCompanySheetName);
		columnNumber_RUNMODE		=	UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, columnNameRM);
		columnNumber_ACTION			=	UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, columnNameAction);
		columnNumber_TabName		=	UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, "TAB NAME");
		columnNumber_CompanyName	=	UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, "Company Name");

		//Getting employee Name
		try{
			utilfunc.MakeElement("//*[@id='user-profile']").click();
			Employee_namecheck				=	utilfunc.MakeElement(".//*[@id='user-name']").getText();
			Thread.sleep(200);
			utilfunc.MakeElement("//*[@id='user-profile']").click();
			System.out.println(Employee_namecheck);
			System.out.println("number of run mode Y are "+ AddCompanyRowCount);
		}catch(Exception e){
			System.out.println("Unable to find Employee name and using username instead");	
		}
		startTotalTime = System.currentTimeMillis();
		for(int modCounter = 1;modCounter<AddCompanyRowCount;modCounter++){
			
			boolean passCounter			=	false;
			boolean failCounter			=	false;
			boolean notAssignedCounter	=	false;
			
			Thread.sleep(1000);
			
			try{
				if(UtilFunction.getCellData(fileName, AddCompanySheetName, columnNumber_RUNMODE, modCounter).equals("Y")){
					ModuleCounter=ModuleCounter+1;
					System.out.println("Current run mode Y number is "+ modCounter);
					Thread.sleep(1000);

					utilfunc.ErrorMessage1="";
					utilfunc.ErrorMessage2="";
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.globalerrormessage="";
					String TabName		="";
					String ActionName	="";
					int columnCount_RUNMODE	=	0;
					int rowCount1			=	0;
					String status="";
					boolean Page_flag	=	false;

					TabName				=	UtilFunction.getCellData(fileName, AddCompanySheetName, columnNumber_TabName, modCounter);
					ActionName			=	UtilFunction.getCellData(fileName, AddCompanySheetName, columnNumber_ACTION, modCounter);
					//String companyName			=	UtilFunction.getCellData(fileName, AddCompanySheetName, columnNumber_CompanyName, modCounter);
					columnCount_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, TabName, "RUNMODE");
					int Scenariocol	=	UtilFunction.getColumnWithCellData(fileName, TabName, "SCENARIO");
					rowCount1	=	UtilFunction.usedRowCount(fileName,TabName);


					if((TabName.equals("Organization Info"))&& ((ActionName.equals("New")) ||((ActionName.equals("Delete")))))
					{
					VisitCompanyPage_flag	=	false;
					}
					
					System.out.println("Sheet selected to pull data is: "	+ TabName	+	" and with Action: "	+	ActionName);

					if(VisitCompanyPage_flag==false){

						try{
							//Company Page landing 
							visitCompanyMenu	=	utilfunc.goToAnyMenuByNavPath("Menu,Company");
							System.out.println("Before visiting any module lets find out the company");

							try{
								if((TabName.equals("Organization Info"))&& ((ActionName.equals("New")) ||((ActionName.equals("Delete")))))
								{
									VisitCompanyPage_flag=true;

								}
								else if(TabName.equals("Request Access to Company"))
								{
									VisitCompanyPage_flag=true;
								}
								else{
									//Company Search
									//company_name=companyName;
									VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");
								}
							}catch(Exception e){
								System.out.println("Unable to search for company from companies list");
							}
						}catch(Exception e){
							System.out.println("unable to go to company page");
						}
					}
					//Module Search
					for(int count=1; count<=rowCount1; count++)
					{

						Thread.sleep(1000);
						System.out.println("we are in loop current value of count is :"+count);
						try{
							if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){
								
								String Scenariotext	= 	UtilFunction.getCellData(fileName, TabName, Scenariocol, count);
								
								 if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
									 PositiveScenarioCounter++;
			    					}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
			    						NegativeScenarioCounter++;
			    					}
								TotalTestCaseCounter=TotalTestCaseCounter+1;

								utilfunc.ErrorMessage1="";
								utilfunc.ErrorMessage2="";
								utilfunc.ErrorMessage4="";
								utilfunc.ErrorMessage5="";
								utilfunc.globalerrormessage="";

								Thread.sleep(1000);

								if(VisitCompanyPage_flag==true){
									System.out.println("---- User is on selected company name " + companyName	 + " for module "+ TabName +" ----");
									try{
										if((TabName.equals("Organization Info"))&& ((ActionName.equals("New"))||(ActionName.equals("Delete"))) )
										{
											VisitModule_flag=true;
										}
										else if(TabName.equals("Request Access to Company"))
										{
											VisitModule_flag=true;
										}
										else{	// visit the module
											VisitModule_flag	= goToCompanyModuleByName(TabName);
											System.out.println("user is on module: "+TabName);
										}
									}catch(Exception e){
										System.out.println("problem occured while user tried to go to module: "+TabName);
									}

									if(VisitModule_flag==true){	//If user is assigned to the user

										utilfunc.ErrorMessage1="";
										utilfunc.ErrorMessage2="";
										utilfunc.ErrorMessage4="";
										utilfunc.ErrorMessage5="";
										utilfunc.globalerrormessage="";
										Thread.sleep(1000);

										// module is assigned and lets proceed further 
										//now call specific method for requested module name

										if(TabName.equals("Client Communication Protocol"))
										{
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Communication.Communication(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio, ActionName, obj_CIMS_Company_Communication.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Visa Profile")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_VisaProfile.VisaProfile(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_VisaProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_VisaProfile.scenerio,ActionName, obj_CIMS_Company_VisaProfile.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_VisaProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_VisaProfile.scenerio,ActionName, obj_CIMS_Company_VisaProfile.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User has successfully saved data in "+TabName+" module");
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_VisaProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_VisaProfile.scenerio, ActionName, obj_CIMS_Company_VisaProfile.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
						
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_VisaProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_VisaProfile.scenerio,ActionName, obj_CIMS_Company_VisaProfile.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													//System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_VisaProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_VisaProfile.scenerio,ActionName, obj_CIMS_Company_VisaProfile.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Batch Recruitment")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_CompanyBatchRecruitment.BatchRecruitment(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_CompanyBatchRecruitment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CompanyBatchRecruitment.scenerio,ActionName, obj_CIMS_Company_CompanyBatchRecruitment.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_CompanyBatchRecruitment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CompanyBatchRecruitment.scenerio,ActionName, obj_CIMS_Company_CompanyBatchRecruitment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CompanyBatchRecruitment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CompanyBatchRecruitment.scenerio, ActionName, obj_CIMS_Company_CompanyBatchRecruitment.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_CompanyBatchRecruitment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CompanyBatchRecruitment.scenerio,ActionName, obj_CIMS_Company_CompanyBatchRecruitment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CompanyBatchRecruitment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CompanyBatchRecruitment.scenerio,ActionName, obj_CIMS_Company_CompanyBatchRecruitment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Roles Assignment")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_RoleAssignment.RoleAssignment(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_RoleAssignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RoleAssignment.scenerio,ActionName, obj_CIMS_Company_RoleAssignment.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_RoleAssignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RoleAssignment.scenerio,ActionName, obj_CIMS_Company_RoleAssignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RoleAssignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RoleAssignment.scenerio, ActionName, obj_CIMS_Company_RoleAssignment.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_RoleAssignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RoleAssignment.scenerio,ActionName, obj_CIMS_Company_RoleAssignment.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RoleAssignment.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RoleAssignment.scenerio,ActionName, obj_CIMS_Company_RoleAssignment.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Entity")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Entity.Company_Entity(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Entity.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Entity.scenerio,ActionName, obj_CIMS_Company_Entity.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Entity.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Entity.scenerio,ActionName, obj_CIMS_Company_Entity.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Entity.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Entity.scenerio, ActionName, obj_CIMS_Company_Entity.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Entity.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Entity.scenerio,ActionName, obj_CIMS_Company_Entity.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Entity.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Entity.scenerio,ActionName, obj_CIMS_Company_Entity.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Notes")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Notes.Company_Notes(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Notes.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notes.scenerio,ActionName, obj_CIMS_Company_Notes.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Notes.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notes.scenerio,ActionName, obj_CIMS_Company_Notes.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Notes.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notes.scenerio, ActionName, obj_CIMS_Company_Notes.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Notes.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notes.scenerio,ActionName, obj_CIMS_Company_Notes.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Notes.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notes.scenerio,ActionName, obj_CIMS_Company_Notes.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Origin Destination Countries")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_CountryList.Add_Country(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_CountryList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CountryList.scenerio,ActionName, obj_CIMS_Company_CountryList.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_CountryList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CountryList.scenerio,ActionName, obj_CIMS_Company_CountryList.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CountryList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CountryList.scenerio, ActionName, obj_CIMS_Company_CountryList.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_CountryList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CountryList.scenerio,ActionName, obj_CIMS_Company_CountryList.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CountryList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CountryList.scenerio,ActionName, obj_CIMS_Company_CountryList.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Subscribed Services")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Subscribed_Services.Add_Subscribed_Services(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Subscribed_Services.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Subscribed_Services.scenerio,ActionName, obj_CIMS_Company_Subscribed_Services.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Subscribed_Services.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Subscribed_Services.scenerio,ActionName, obj_CIMS_Company_Subscribed_Services.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Subscribed_Services.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Subscribed_Services.scenerio, ActionName, obj_CIMS_Company_Subscribed_Services.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Subscribed_Services.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Subscribed_Services.scenerio,ActionName, obj_CIMS_Company_Subscribed_Services.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Subscribed_Services.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Subscribed_Services.scenerio,ActionName, obj_CIMS_Company_Subscribed_Services.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("General Info")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_General_Info.Add_General_Info(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_General_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_General_Info.scenerio,ActionName, obj_CIMS_Company_General_Info.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_General_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_General_Info.scenerio,ActionName, obj_CIMS_Company_General_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_General_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_General_Info.scenerio, ActionName, obj_CIMS_Company_General_Info.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_General_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_General_Info.scenerio,ActionName, obj_CIMS_Company_General_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_General_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_General_Info.scenerio,ActionName, obj_CIMS_Company_General_Info.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Organization Info")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Organization_Info.Add_Organization_Info(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Organization_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Organization_Info.scenerio,ActionName, obj_CIMS_Organization_Info.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Organization_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Organization_Info.scenerio,ActionName, obj_CIMS_Organization_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Organization_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Organization_Info.scenerio, ActionName, obj_CIMS_Organization_Info.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Organization_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Organization_Info.scenerio,ActionName, obj_CIMS_Organization_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
							    						obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
							    						failCounter	= true;
						    						}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Organization_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Organization_Info.scenerio,ActionName, obj_CIMS_Organization_Info.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Locations")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Locations.Locations(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Locations.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Locations.scenerio,ActionName, obj_CIMS_Company_Locations.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Locations.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Locations.scenerio,ActionName, obj_CIMS_Company_Locations.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Locations.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Locations.scenerio, ActionName, obj_CIMS_Company_Locations.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Locations.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Locations.scenerio,ActionName, obj_CIMS_Company_Locations.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													

													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Locations.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Locations.scenerio,ActionName, obj_CIMS_Company_Locations.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Custom Labels")){
											try{
												Thread.sleep(1000);
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_CustomLabels.Add_CustomLabels(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														utilfunc.TestngReportPass(obj_CIMS_Company_CustomLabels.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CustomLabels.scenerio, ActionName, obj_CIMS_Company_CustomLabels.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_CustomLabels.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_CustomLabels.scenerio,ActionName,obj_CIMS_Company_CustomLabels.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CustomLabels.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CustomLabels.scenerio, ActionName, obj_CIMS_Company_CustomLabels.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else
												{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_CustomLabels.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CustomLabels.scenerio,ActionName, obj_CIMS_Company_CustomLabels.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												

													// fail dashboard report..
												    if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
												 try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_CustomLabels.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_CustomLabels.scenerio,ActionName, obj_CIMS_Company_CustomLabels.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("Some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Purpose Categories")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_PurposeCategories.Add_PurposeCategories(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if(Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_PurposeCategories.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PurposeCategories.scenerio,ActionName, obj_CIMS_Company_PurposeCategories.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_PurposeCategories.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PurposeCategories.scenerio,ActionName, obj_CIMS_Company_PurposeCategories.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_PurposeCategories.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PurposeCategories.scenerio, ActionName, obj_CIMS_Company_PurposeCategories.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_PurposeCategories.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PurposeCategories.scenerio,ActionName, obj_CIMS_Company_PurposeCategories.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_PurposeCategories.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PurposeCategories.scenerio,ActionName, obj_CIMS_Company_PurposeCategories.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
											/**
											 * Devesh code implementation
											 */
										}else if(TabName.equals("Business Units")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Add_Business_Units.Businessunit_info(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Add_Business_Units.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Add_Business_Units.scenerio,ActionName, obj_CIMS_Company_Add_Business_Units.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Add_Business_Units.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Add_Business_Units.scenerio,ActionName, obj_CIMS_Company_Add_Business_Units.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													System.out.println("User has successfully saved data in "+TabName+" module");
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Add_Business_Units.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Add_Business_Units.scenerio, ActionName, obj_CIMS_Company_Add_Business_Units.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Add_Business_Units.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Add_Business_Units.scenerio,ActionName, obj_CIMS_Company_Add_Business_Units.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													System.out.println("User is Getting an Error Message while saving Information in "+TabName + " module");
													
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Add_Business_Units.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Add_Business_Units.scenerio,ActionName, obj_CIMS_Company_Add_Business_Units.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
										/**
										 * Lokesh code starts here..
										 */
										else if(TabName.equals("Company Statistics")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Statistics.Company_Statistics(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Statistics.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Statistics.scenerio, ActionName, obj_CIMS_Company_Statistics.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Statistics.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Statistics.scenerio,ActionName,obj_CIMS_Company_Statistics.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Statistics.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Statistics.scenerio, ActionName, obj_CIMS_Company_Statistics.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Statistics.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Statistics.scenerio,ActionName, obj_CIMS_Company_Statistics.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Statistics.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Statistics.scenerio,ActionName, obj_CIMS_Company_Statistics.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}

										}else if(TabName.equals("Report List")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Report_List.Company_Report_List(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_Report_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Report_List.scenerio, ActionName, obj_CIMS_Company_Report_List.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Report_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Report_List.scenerio,ActionName,obj_CIMS_Company_Report_List.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Report_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Report_List.scenerio, ActionName, obj_CIMS_Company_Report_List.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Report_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Report_List.scenerio,ActionName, obj_CIMS_Company_Report_List.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Report_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Report_List.scenerio,ActionName, obj_CIMS_Company_Report_List.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Custom Fields")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Custom_Field.Company_Custom_Field(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_Custom_Field.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Custom_Field.scenerio, ActionName, obj_CIMS_Company_Custom_Field.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Custom_Field.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Custom_Field.scenerio,ActionName,obj_CIMS_Company_Custom_Field.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Custom_Field.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Custom_Field.scenerio, ActionName, obj_CIMS_Company_Custom_Field.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Custom_Field.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Custom_Field.scenerio,ActionName, obj_CIMS_Company_Custom_Field.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Custom_Field.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Custom_Field.scenerio,ActionName, obj_CIMS_Company_Custom_Field.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("Some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Integration")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Integration.Company_Integration(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_Integration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Integration.scenerio, ActionName, obj_CIMS_Company_Integration.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Integration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Integration.scenerio,ActionName,obj_CIMS_Company_Integration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Integration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Integration.scenerio, ActionName, obj_CIMS_Company_Integration.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Integration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Integration.scenerio,ActionName, obj_CIMS_Company_Integration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Integration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Integration.scenerio,ActionName, obj_CIMS_Company_Integration.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("Some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Documents")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Document.Company_Document(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Document.scenerio, ActionName, obj_CIMS_Company_Document.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Document.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Document.scenerio,ActionName,obj_CIMS_Company_Document.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Document.scenerio, ActionName, obj_CIMS_Company_Document.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Document.scenerio,ActionName, obj_CIMS_Company_Document.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Document.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Document.scenerio,ActionName, obj_CIMS_Company_Document.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Relocation Company Setup")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_RelocationCompanySetup.Company_RelocationCompanySetup(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_RelocationCompanySetup.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RelocationCompanySetup.scenerio, ActionName, obj_CIMS_Company_RelocationCompanySetup.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_RelocationCompanySetup.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_RelocationCompanySetup.scenerio,ActionName,obj_CIMS_Company_RelocationCompanySetup.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RelocationCompanySetup.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RelocationCompanySetup.scenerio, ActionName, obj_CIMS_Company_RelocationCompanySetup.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else
												{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_RelocationCompanySetup.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RelocationCompanySetup.scenerio,ActionName, obj_CIMS_Company_RelocationCompanySetup.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RelocationCompanySetup.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RelocationCompanySetup.scenerio,ActionName, obj_CIMS_Company_RelocationCompanySetup.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Primary Company Roles")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_PrimaryCompanyRoles.Company_PrimaryCompanyRoles(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName+" - "+obj_CIMS_Company_PrimaryCompanyRoles.Primary_Company_Roles+" - ", Employee_namecheck, timer);
												System.out.println("Page Flag:"+Page_flag);
												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_PrimaryCompanyRoles.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PrimaryCompanyRoles.scenerio, ActionName, obj_CIMS_Company_PrimaryCompanyRoles.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_PrimaryCompanyRoles.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_PrimaryCompanyRoles.scenerio,ActionName,obj_CIMS_Company_PrimaryCompanyRoles.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_PrimaryCompanyRoles.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PrimaryCompanyRoles.scenerio, ActionName, obj_CIMS_Company_PrimaryCompanyRoles.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else
												{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_PrimaryCompanyRoles.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PrimaryCompanyRoles.scenerio,ActionName, obj_CIMS_Company_PrimaryCompanyRoles.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_PrimaryCompanyRoles.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_PrimaryCompanyRoles.scenerio,ActionName, obj_CIMS_Company_PrimaryCompanyRoles.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Contracts")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_NetworkPartnerContracts.Company_NetworkPartnerContracts(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_NetworkPartnerContracts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_NetworkPartnerContracts.scenerio, ActionName, obj_CIMS_Company_NetworkPartnerContracts.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_NetworkPartnerContracts.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_NetworkPartnerContracts.scenerio,ActionName,obj_CIMS_Company_NetworkPartnerContracts.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_NetworkPartnerContracts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_NetworkPartnerContracts.scenerio, ActionName, obj_CIMS_Company_NetworkPartnerContracts.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}
												else
												{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_NetworkPartnerContracts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_NetworkPartnerContracts.scenerio,ActionName, obj_CIMS_Company_NetworkPartnerContracts.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_NetworkPartnerContracts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_NetworkPartnerContracts.scenerio,ActionName, obj_CIMS_Company_NetworkPartnerContracts.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
												ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
												utilfunc.assertion();			
												utilfunc.TakeScreenshot();
											}
										}
										else if(TabName.equals("Perm Posting Notice")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Perm_Posting_Notice.Company_Perm_Posting_Notice(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Perm_Posting_Notice.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Perm_Posting_Notice.scenerio,ActionName, obj_CIMS_Company_Perm_Posting_Notice.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Perm_Posting_Notice.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Perm_Posting_Notice.scenerio,ActionName, obj_CIMS_Company_Perm_Posting_Notice.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}

													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Perm_Posting_Notice.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Perm_Posting_Notice.scenerio, ActionName, obj_CIMS_Company_Perm_Posting_Notice.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}
												else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Perm_Posting_Notice.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Perm_Posting_Notice.scenerio,ActionName, obj_CIMS_Company_Perm_Posting_Notice.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Perm_Posting_Notice.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Perm_Posting_Notice.scenerio,ActionName, obj_CIMS_Company_Perm_Posting_Notice.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Contacts")){
											Thread.sleep(1000);
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Contacts.Company_Contacts(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag)
												{
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals(""))
													{
														utilfunc.TestngReportPass(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio, ActionName, obj_CIMS_Company_Contacts.testcasedescription, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw,obj_CIMS_Company_Contacts.scenerio,ActionName,obj_CIMS_Company_Contacts.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio, ActionName, obj_CIMS_Company_Contacts.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio,ActionName, obj_CIMS_Company_Contacts.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Contacts.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Contacts.scenerio,ActionName, obj_CIMS_Company_Contacts.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}	
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
												ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
												utilfunc.assertion();			
												utilfunc.TakeScreenshot();
											}
										}else if(TabName.equals("Notifications")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Notifications.Notifications(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Notifications.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notifications.scenerio,ActionName, obj_CIMS_Company_Notifications.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Notifications.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notifications.scenerio,ActionName, obj_CIMS_Company_Notifications.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Notifications.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notifications.scenerio, ActionName, obj_CIMS_Company_Notifications.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Notifications.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notifications.scenerio,ActionName, obj_CIMS_Company_Notifications.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Notifications.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Notifications.scenerio,ActionName, obj_CIMS_Company_Notifications.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Reference List")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_ReferenceList.Add_ReferenceList(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_ReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_ReferenceList.scenerio,ActionName, obj_CIMS_Company_ReferenceList.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_ReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_ReferenceList.scenerio,ActionName, obj_CIMS_Company_ReferenceList.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_ReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_ReferenceList.scenerio, ActionName, obj_CIMS_Company_ReferenceList.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_ReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_ReferenceList.scenerio,ActionName, obj_CIMS_Company_ReferenceList.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_ReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_ReferenceList.scenerio,ActionName, obj_CIMS_Company_ReferenceList.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Company Settings")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Company_Settings.Settings(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Company_Settings.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Settings.scenerio,ActionName, obj_CIMS_Company_Company_Settings.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Company_Settings.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Settings.scenerio,ActionName, obj_CIMS_Company_Company_Settings.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Company_Settings.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Settings.scenerio, ActionName, obj_CIMS_Company_Company_Settings.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Company_Settings.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Settings.scenerio,ActionName, obj_CIMS_Company_Company_Settings.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Company_Settings.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Settings.scenerio,ActionName, obj_CIMS_Company_Company_Settings.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Company Job Catalog")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Company_Job_Catalog.CompanyJobCatalog_info(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Company_Job_Catalog.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Job_Catalog.scenerio,ActionName, obj_CIMS_Company_Company_Job_Catalog.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Company_Job_Catalog.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Job_Catalog.scenerio,ActionName, obj_CIMS_Company_Company_Job_Catalog.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Company_Job_Catalog.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Job_Catalog.scenerio, ActionName, obj_CIMS_Company_Company_Job_Catalog.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Company_Job_Catalog.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Job_Catalog.scenerio,ActionName, obj_CIMS_Company_Company_Job_Catalog.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Company_Job_Catalog.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Company_Job_Catalog.scenerio,ActionName, obj_CIMS_Company_Company_Job_Catalog.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
										else if(TabName.equals("Request Access to Company")){
											try{
												startTime = System.currentTimeMillis(); 
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_RequestAccesstoCompany.Requestaccesstocompany(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_RequestAccesstoCompany.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RequestAccesstoCompany.scenerio,ActionName, obj_CIMS_Company_RequestAccesstoCompany.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_RequestAccesstoCompany.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RequestAccesstoCompany.scenerio,ActionName, obj_CIMS_Company_RequestAccesstoCompany.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RequestAccesstoCompany.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RequestAccesstoCompany.scenerio, ActionName, obj_CIMS_Company_RequestAccesstoCompany.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_RequestAccesstoCompany.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RequestAccesstoCompany.scenerio,ActionName, obj_CIMS_Company_RequestAccesstoCompany.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_RequestAccesstoCompany.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_RequestAccesstoCompany.scenerio,ActionName, obj_CIMS_Company_RequestAccesstoCompany.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}else if(TabName.equals("Network Partner Info")){
											try{
												startTime = System.currentTimeMillis();
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
												Page_flag	=	obj_CIMS_Company_Network_Partner_Info.Info(fileName,TabName,count,ActionName);
												timer = getTimeTakenByModule(startTime);
												utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);

												if (Page_flag){
													status="PASS";passTestCaseCounter++;
													if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
														utilfunc.TestngReportPass(obj_CIMS_Company_Network_Partner_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Network_Partner_Info.scenerio,ActionName, obj_CIMS_Company_Network_Partner_Info.description, status);
													}else{
														utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Network_Partner_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Network_Partner_Info.scenerio,ActionName, obj_CIMS_Company_Network_Partner_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
													
													// pass dashboard report..
													if(passCounter==false){
														 try {	obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Pass");} catch (Exception e) {}
														 passCounter=true;
													 }
													try {obj_Report_Dashboard.writeDashBoardPassReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Network_Partner_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Network_Partner_Info.scenerio, ActionName, obj_CIMS_Company_Network_Partner_Info.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+TabName);}
													//System.out.println("User has successfully saved data in "+TabName+" module");
												}else{
													status="FAIL";failTestCaseCounter++;
													//utilfunc.TakeScreenshot();
													utilfunc.TestngReportFail1(obj_CIMS_Company_Network_Partner_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Network_Partner_Info.scenerio,ActionName, obj_CIMS_Company_Network_Partner_Info.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												
													// fail dashboard report..
													if(failCounter==false){
													obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Fail");
													failCounter	= true;
													}
													try {obj_Report_Dashboard.writeDashBoardFailReport(AddCompanySheetName, Employee_namecheck, obj_CIMS_Company_Network_Partner_Info.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Network_Partner_Info.scenerio,ActionName, obj_CIMS_Company_Network_Partner_Info.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+TabName);}
												}
											}catch(Exception s){
												System.out.println("some error occured in : "+ TabName);
											}
										}
									}	//if(VisitModule_flag==true) ends here
									else{	

										//	utilfunc.ErrorMessage1="";
										//	utilfunc.ErrorMessage2="";
										//	utilfunc.ErrorMessage4="";
										//	utilfunc.ErrorMessage5="";
										//	utilfunc.globalerrormessage="";

										//If user is not assigned to the user
										Thread.sleep(3000);

										status="PASS";
										String Errormessage="";
										String NotAssignTestCaseID="";
										String NotAssignScenerio="";
										String NotAssignTestCaseDescription="";

										int columnNumber_TCID=-1;
										int columnNumber_Scenario=-1;
										int columnNumber_TestCaseDescription=-1;

										timer = getTimeTakenByModule(startTime);
										utilfunc.updateModuleDataForReportGeneration(TabName, Employee_namecheck, timer);
										Errormessage=""+TabName+" is not assigned to "+Employee_namecheck+" User";

										//System.out.println(Errormessage);
										//System.out.println("fileName:"+fileName);
										//System.out.println("AddCompanySheetName:"+AddCompanySheetName);

										try {	columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, "TCID");} catch (Exception e) {}
										try {	columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, "SCENARIO");} catch (Exception e) {}
										try {	columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, AddCompanySheetName, "Test Case Description");} catch (Exception e) {}

										System.out.println("columnNumber_TCID is: "+columnNumber_TCID);
										System.out.println("columnNumber_Scenario is: "+columnNumber_Scenario);
										System.out.println("columnNumber_TestCaseDescripton is: "+columnNumber_TestCaseDescription);
										
										try{	NotAssignTestCaseID=UtilFunction.getCellData(fileName, TabName, columnNumber_TCID, count);} catch (Exception e) {}
										try{	NotAssignScenerio=UtilFunction.getCellData(fileName, TabName, columnNumber_Scenario, count);} catch (Exception e) {}
										try{	NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, TabName, columnNumber_TestCaseDescription, count);} catch (Exception e) {}

										utilfunc.TestngReportFail(NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio,ActionName,NotAssignTestCaseDescription,status,Errormessage);
										NotAssignedModuleCounter++;

										NumberOfNotAssignModule.add(TabName);

										if(notAssignedCounter==false){
											 obj_Report_Dashboard.writeReportHeader(AddCompanySheetName, TabName,"Not Assigned");
											 notAssignedCounter=true;
										 }
										try {obj_Report_Dashboard.writeDashBoardNotAssignedReport(AddCompanySheetName, Employee_namecheck, NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio, ActionName, NotAssignTestCaseDescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard not assigned report for : "+TabName);}
									}


								}else{
									System.out.println("unable to find company in search list");
								}

							}else{
								System.out.println("run mode is set No for record number: " + count + " in sheet "+TabName);
							}
						}
						catch(Exception e){
							System.out.println("unable to execute module code for sheet name : "+TabName);
						}

					}
					// out of one sheet
					System.out.println("out of one sheet");
				}else{
					System.out.println("runmode No for "+ modCounter);
				}
			}catch(Exception e){
				System.out.println("Unale to go to company sheet");
			}
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
		try{	TotalTestCaseCount				=	Integer.toString(TotalTestCaseCounter);	}catch(Exception error){}
		try{	FinalPositiveCount				=	Integer.toString(passTestCaseCounter);	}catch(Exception error){}
		try{	FinalNegativeCount				=	Integer.toString(failTestCaseCounter);	}catch(Exception error){}
		try{	NotAssignedModuleCount			=	Integer.toString(NotAssignedModuleCounter);	}catch(Exception error){}
		
		//utilfunc.TestngDashBoardReport("Left Navigation",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,FinalPositiveCount,FinalNegativeCount,NotAssignedModuleCount);
		TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
		try{
		obj_Report_Dashboard.generateReportForSuite("Company",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
				FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
		}catch(Exception e){
			System.out.println("unable to call & generate dashboard report..");
		}
	}


	public String getTimeTakenByModule(long startTime){
		///////TIMER END/////////////
		long endTime = System.currentTimeMillis();
		float seconds = (endTime - startTime) / 1000F;
		System.out.println();
		System.out.println("Test total run time = "+Float.toString(seconds) + " seconds");
		CIMS.CIMS_Company.timer	=	timer;
		System.out.println();
		return Float.toString(seconds);
	}

	public boolean goToCompanyModuleByName(String moduleName) throws InterruptedException{

		boolean flag = false;
		boolean	clickedOnSliderIcon	=	false;
		System.out.println("User is looking for "+moduleName+" module ");

		try{

			Thread.sleep(1000);

			//				  String reduceScreenSize = Keys.chord(Keys.CONTROL, Keys.SUBTRACT);
			webdriver.findElement(By.tagName("html")).click();

			// for this we need to click on company slider icon

			//   utilfunc.explicitwait(companySliderIcon);
			// before we bind click on company menu, let us reduce the size of the html

			try{
				String companySliderIcon = "//*[@id='slider-icon']";
				waitForAnElementToLoad(companySliderIcon, true);
				Thread.sleep(1000);
				utilfunc.MakeElement(companySliderIcon).click();
				Thread.sleep(1000);
				clickedOnSliderIcon	=	true;
			}catch(Exception e){
				System.out.println("slider icon is not clicked..");
			}

			if(clickedOnSliderIcon==false){return false;}

			flag = false;
			System.out.println("User has clicked on slider icon");

		}catch(Exception e){
			System.out.println("unable to find company slider icon & click on it");
		}

		try{

			//				  Thread.sleep(800);
			String  MenuGroupCounter = "//*[@class='accordion-group']";
			String  MenuGroupXPath  = "//*[@class='accordion-group'][yy]";

			for(int w=1; w<=utilfunc.GetObjectCount(MenuGroupCounter);w++){

				if(flag==true){ break;}
				//*[contains(@class,'sub-menu accordion-body collapse in')]//*[@class='accordion-inner']//li===//*[@id='rnavsub-general']//*[@class='accordion-inner']//li
				String companyModuleListXpath  = MenuGroupXPath.replace("yy", Integer.toString(w)) +"//*[@class='accordion-inner']//li[zz]/a";
				String companyModuleCounterList   = MenuGroupXPath.replace("yy", Integer.toString(w)) +"//*[@class='accordion-inner']//li/a";

				Thread.sleep(400);
				waitForAnElementToLoad(companyModuleCounterList, true);
				//   utilfunc.explicitwait(companyModuleCounterList);
				int moduleCount = utilfunc.GetObjectCount(companyModuleCounterList);

				for(int m=1;m<=moduleCount;m++){

					Thread.sleep(400);
					String NewXPath    = companyModuleListXpath.replace("zz", Integer.toString(m));
					waitForAnElementToLoad(NewXPath, true);
					//    utilfunc.explicitwait(NewXPath);
					String LinkTitle   = utilfunc.MakeElement(NewXPath).getText();
					LinkTitle					=	LinkTitle.replaceAll("/", " ");
					//		      System.out.println("Picking the Module link by comparing it with title");
					System.out.println(LinkTitle);
					if(LinkTitle.equals(moduleName)){
						try{
							utilfunc.MakeElement(NewXPath).click();
							flag = true;
							System.out.println("User has clicked on "+moduleName+" module ");
							break;
						}catch(Exception e){
							flag = false;
							System.out.println("Unable to find module - "+moduleName+" link in slider menu ");
						}
						break;
					}
				}

			}
		}catch(Exception e){
			flag = false;
			System.out.println("Unable to get company module links");
			utilfunc.closesidebar();
		}
		return flag;
	}



	public boolean waitForAnElementToLoad(String elementXpath,boolean clickable){

		boolean	flag	=	false;
		try{
			WebDriverWait wait = new WebDriverWait(webdriver, 2);
			if(clickable==true){
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
				flag	=	true;
			}else{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
				flag	=	true;
			}
			System.out.println("Element with xpath: " + elementXpath + " found on the page");

		}catch(Exception e){

			System.out.println("Unable to locate the element with xpath: " + elementXpath );
		}
		return flag;
	}



	public boolean getCompanyByName(String companyName, String searchFieldXPath, String searchButtonXPath,String searchResultListLiXpath)throws AWTException, InterruptedException{

		// first of all let us make sure that user on company page..
		boolean flag	=	false;
		//		WebDriverWait wait = new WebDriverWait(webdriver, 15);

		System.out.println("User is looking for: "+companyName);

		String CompanyResultCounterXpath	=	searchResultListLiXpath.replace("[dd]", ""); //"//*[@id='dvList']/table/tbody/tr/td[1]/a";

		//		boolean openCompany	=	false;
		//		openCompany	=	goToAnyMenuByNavPath("Menu,Company");
		//		if(openCompany==true){
		try{

			System.out.println("Let us wait for listing to load for the first time");
			Thread.sleep(1500);
			//			waitForAnElementToLoad(CompanyResultCounterXpath, false);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CompanyResultCounterXpath)));

			utilfunc.MakeElement(searchFieldXPath).clear();
			utilfunc.MakeElement(searchFieldXPath).sendKeys(companyName);
			System.out.println("Company name is set in search box");
			//			utilfunc.explicitwait(searchButtonXPath);
			Thread.sleep(1600);
			waitForAnElementToLoad(searchButtonXPath, true);

			//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchButtonXPath)));
			utilfunc.MakeElement(searchButtonXPath).click();
			flag	=	false;
		}catch(Exception s){
			System.out.println("Unable to set search for company "+companyName);
		}

		System.out.println("wating for company search result to populate");
		//		Thread.sleep(5000);
		//		String CompanyResultRowCountXpath	=	"//*[@id='dvList']/table/tbody/tr/td[1]/a";

		try{

			//			String CompanyResultCounterXpath	=	searchResultListLiXpath.replace("[dd]", ""); //"//*[@id='dvList']/table/tbody/tr/td[1]/a";
			Thread.sleep(3000);
			CompanyResultCounterXpath	=	null;
			CompanyResultCounterXpath	=	searchResultListLiXpath.replace("[dd]", "");
			waitForAnElementToLoad(CompanyResultCounterXpath, false);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CompanyResultCounterXpath)));

			int resultCount			=	utilfunc.GetObjectCount(CompanyResultCounterXpath);

			for(int r=1;r<=resultCount;r++){

				//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultListLiXpath)));
				String NewXpath			=	searchResultListLiXpath.replace("dd", Integer.toString(r));
				System.out.println("New string" + NewXpath.toString());
				waitForAnElementToLoad(NewXpath, true);
				//				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(NewXpath)));
				//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NewXpath)));

				String AttributeName	=	utilfunc.MakeElement(NewXpath).getText();
				//				System.out.println("Picking the Company by comparing the name");
				//				System.out.println("Attr name: "+AttributeName);
				if(AttributeName.equals(companyName)){
					try{
						System.out.println("We have found the company in the result");
						try{utilfunc.MakeElement(NewXpath).click();}catch(Exception e){}
						System.out.println("User has clicked on the selected company");
					}catch(Exception d){
						System.out.println("some error occured while finding the company from the search result");
					}
					flag	=	true;
					break;
				}
			}
		}
		catch(Exception s){
			System.out.println("Some error occured while selecting/finding company record from the result");
		}
		//		}else{
		//			System.out.println("unable to open company menu");
		//		}
		return flag;
	}
	// dashboard report
		public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
			this.obj_Report_Dashboard = setobj_Report_Dashboard;
		}

}