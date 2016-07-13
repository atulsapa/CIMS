package CIMS;


import java.awt.AWTException;
import java.io.IOException;
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
//import util.Email;
import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Basic_Information_module;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Questionnaires.CIMS_Other_Name_Module;

import CIMS.Modules.Questionnaires.CIMS_P2PBasicinfoModule;





//import util.questionariesutility;




	public class CIMS_P2PMain

	{
		private String sysDate;
		private WebDriver webdriver;		
		private UtilFunction utilfunc;		
		private CIMS_Login obj_CIMS_Login;
		private CIMS_Basic_Information_module obj_CIMS_Basic_Information_Module;
		private CIMS_Other_Name_Module obj_CIMS_Other_Name_Module;
		
		private CIMS_P2PBasicinfoModule obj_CIMS_P2PBasicinfoModule;
		
	    
	    //file name that takes dynamically in all modules.
	    public static String ExcelFileName="Test Data.xls";
		
		//timer
	    StopWatch pageLoad = new StopWatch();


		private String fileName="Test Data.xls";
		private String sheetName="Questionnaires";		
		private String columnName="RUNMODE";
		private String columnName5="ACTION";
		public static String  questionarie_name1=null;
		
		//Employee search declaration
		private String fileNameemployee="Test Data.xls";
		private String sheetNameemployee="EmployeeSearch";	
		private String columnNameemployeeRUNMODE="RUNMODE";
		public static String  Employee_namecheck=null;
		public static String  Employee_search=null;
		public static String  SelectQuestionnairetype=null;
		
		public static String  timer;
		
		//P2P
		public static String ProcessandQuestionnairexpath=".//*[@id='right-nav']/div[4]/a/strong";
		public static String TransferQuestionnaireDatatoAnotherProjectxpath=".//*[@class='btn btn-primary dropdown-toggle pull-center']//*[@class='glyphicon glyphicon-pencil right-margin-5']";
		public static String SelectProjecttoTransferxpath=".//tr[2]//*[@id='projectRadio']";
		public static String Transferprojectbuttonxpath=".//*[@id='btnTransferProject']";
		public static String ClickallmoduletoTransferxpath=".//*[@id='checkAll']";
		public static String completetransferxpath=".//*[@id='btnTransferSelected']";
	
		public static String Questionnaire_Name_array[]=new String [100];
		
		static int instanceCounter = 0;
		static int counter = 0;
		
		static int instanceCounter1 = 0;
		static int counter1 = 0;
		
	//Initiate the class Before TEST method
	@BeforeClass		
		public void isSkipped(){			
			if(RunMode.isSkip(this.ExcelFileName,this.getClass().getName())){
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
				
				setobj_CIMS_P2PBasicinfoModule(new CIMS_P2PBasicinfoModule(webdriver, utilfunc));
				
				
				if(utilfunc.Actualbrw.equals("IE")){
					webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}else{
				webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				}
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
			
			
			
// Our Test start from here.
@Test()	
public void CIMSMain() throws InterruptedException, IOException, AWTException {
			
		try {
			
						
			// Project  Login	
			obj_CIMS_Login.Project_login(ExcelFileName);
		
			//Welcome page
			obj_CIMS_Login.Welcome_Page();
		
			
			
			int rowCountemployeesearch	=	UtilFunction.usedRowCount(fileNameemployee,sheetNameemployee);
			int RUNMODEemployeesearch=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameemployeeRUNMODE);
			String columnNameEN="EMPLOYEE NAME";
			int Employee_name=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameEN);
			String columnNameES="EMPLOYEE SEARCH NAME";
			int Employee_search_name=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameES);
			String columnNameSQT="QUESTIONNAIRE TYPE";
			int Questionnairetype=UtilFunction.getColumnWithCellData(fileNameemployee, sheetNameemployee, columnNameSQT);
			
			for(int j = 1;j<rowCountemployeesearch;j++){
				if(UtilFunction.getCellData(fileNameemployee, sheetNameemployee, RUNMODEemployeesearch,j).equals("Y")){
					Employee_namecheck=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Employee_name, j);
					Employee_search=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Employee_search_name, j);
					SelectQuestionnairetype=UtilFunction.getCellData(fileNameemployee, sheetNameemployee, Questionnairetype, j);
					
					
				
			obj_CIMS_Login.searchemployee(Employee_namecheck,Employee_search);
			
			try{
			if(SelectQuestionnairetype.equals("PROFILE")){
				String Principalheaderxpath=".//*[@id='rnav-principal-header']/a";
				utilfunc.MakeElement(Principalheaderxpath).click();
				
				String Basicinfoxpath=".//*[@id='sectBasicInformation']/a";
				utilfunc.MakeElement(Basicinfoxpath).click();
			}
			}catch(Exception e){
								
			}
			//do stuff 
			try{
				utilfunc.MakeElement(ProcessandQuestionnairexpath).click();
				utilfunc.MakeElement(TransferQuestionnaireDatatoAnotherProjectxpath).click();
				utilfunc.MakeElement(SelectProjecttoTransferxpath).click();
				utilfunc.MakeElement(Transferprojectbuttonxpath).click();
				utilfunc.MakeElement(ClickallmoduletoTransferxpath).click();
				utilfunc.MakeElement(completetransferxpath).click();
				Thread.sleep(5000);
				utilfunc.isAlertPresent();
				
				
			}catch(Exception e){
				
			}
			
	
			int rowCount	=	UtilFunction.usedRowCount(fileName,sheetName);
			int columnNumber_RUNMODE=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName);
		
		
			int columnNumber_ACTION=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName5);
			//questionarie label
			String columnName1="Questionnaire Name";
			int questionarie_name=UtilFunction.getColumnWithCellData(fileName, sheetName, columnName1);
		
		
			int counter=0;
			for(int i = 1;i<rowCount;i++){
			
			//Below condition is used to check the RUNMODE for the Questionnaire modules
			if(UtilFunction.getCellData(fileName, sheetName, columnNumber_RUNMODE, i).equals("Y")){
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
				
					
			
					
///////////////////////START OF BASIC INFORMATION MODULES//////////////////////////////////////////////////
if (  questionarie_name1.contains("Basic_Information" )) {
	
	try{
			
	boolean BasicInformationPage_flag=obj_CIMS_P2PBasicinfoModule.Basic_Information_info();
										
	}catch(Exception e){
	System.out.println("Exception occured:"+e);					
	}

	
}else if(questionarie_name1.contains("Other_Name")){
	
}else if(questionarie_name1.contains("USImmigration")){
	
}else if(questionarie_name1.contains("Education_History")){
	
}else if(questionarie_name1.contains("Group_Memberships")){
	
}else if(questionarie_name1.contains("Health_Insurance")){
	
}else if(questionarie_name1.contains("Medical_History")){
	
}else if(questionarie_name1.contains("Teacher_ChildHealthCare")){
	
}else if(questionarie_name1.contains("Patents")){
	
}else if(questionarie_name1.contains("Id_Documents")){
	
}else if(questionarie_name1.contains("Citizenship")){
	
}else if(questionarie_name1.equals("Membership")){
	
}else if(questionarie_name1.contains("SpeakingEngagements")){
	
}else if(questionarie_name1.contains("Global_Immigration_History")){
	
}else if(questionarie_name1.contains("Exhibitions_and_Showcases")){
	
}else if(questionarie_name1.contains("Medical Cost")){
	
}else if(questionarie_name1.contains("Pregnancy")){
	
}else if(questionarie_name1.contains("SpecialAbility")){
	
}else if(questionarie_name1.contains("Employment History")){
	
}else if(questionarie_name1.contains("EmployeeProcessing")){
	
}else if(questionarie_name1.contains("awards")){
	
}else if(questionarie_name1.contains("AddionalQuestionnaire")){
	
}else if(questionarie_name1.contains("Additional_Medical-history")){
	
}else if(questionarie_name1.contains("Passport")){
	
}else if(questionarie_name1.contains("compensation_and_benifit")){
	
}else if(questionarie_name1.contains("Memberships_in_Professional")){
	
}else if(questionarie_name1.contains("Residence_History")){
	
}else if(questionarie_name1.contains("Marriages")){
	
}else if(questionarie_name1.contains("Family_Members")){
	
}else if(questionarie_name1.contains("Immigration_Documents")){
	
}else if(questionarie_name1.contains("Visits")){
	
}else if(questionarie_name1.contains("Work_Locations")){
	
}
else if(questionarie_name1.contains("Employer_Processing")){
	
}
else if(questionarie_name1.contains("Personal_Attributes")){
	
}
else if(questionarie_name1.contains("Child_Details")){
	
}else if(questionarie_name1.contains("CitationsofYourWork")){
	
}else if(questionarie_name1.contains("LCA_INFO")){
	
}else if(questionarie_name1.contains("Commercial_Success")){
	
}else if(questionarie_name1.contains("Travel_Plans")){
	
}else if(questionarie_name1.contains("Offsite_Employment")){
	
}else if(questionarie_name1.contains("Employment_History")){
	
}else if(questionarie_name1.contains("Contact_Information")){
	
}else if(questionarie_name1.contains("Destination_Country_Employment")){
	
}else if(questionarie_name1.contains("Position_Requirements")){
	
}else if(questionarie_name1.contains("Contributions_to_Your_Field")){
	
}
else if(questionarie_name1.contains("Publications_Authored")){
	
}else if(questionarie_name1.contains("Leading_or_Critical_Role")){
	
}else if(questionarie_name1.contains("Other_Evidence_of_Special")){
	
}else if(questionarie_name1.contains("Parent")){
	
}else if(questionarie_name1.contains("Language_Proficiency")){
	
}else if(questionarie_name1.contains("Language_Study")){
	
}else if(questionarie_name1.contains("Medical_Treatment")){
	
}else if(questionarie_name1.contains("Contacts_and_References")){
	
}else if(questionarie_name1.contains("Home_Country_Employment")){
	
}else if(questionarie_name1.contains("Participation_as_Judge")){
	
}else if(questionarie_name1.contains("EnglishLanguageAbility")){
	
}else if(questionarie_name1.contains("QualifyingExperienceWithCompany")){
	
}else if(questionarie_name1.contains("Company_Contacts")){
	
}else if(questionarie_name1.contains("Assessment")){
	
}

			}
			
			
			}}
			
			}
			System.out.println("PASS Object:" + instanceCounter);
			String strI = Integer.toString(instanceCounter);
			//Reporter.log("POSTIVE TESTCASES: "+strI);
		
			System.out.println("FAIL Object:" + instanceCounter1);
			String strI1 = Integer.toString(instanceCounter1);
			//Reporter.log("NEGATIVE TESTCASES: "+strI1);

			}
			catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed");
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
			public void setobj_CIMS_Basic_Information_Module(CIMS_Basic_Information_module setobj_CIMS_Basic_Information_Module) {
				this.obj_CIMS_Basic_Information_Module = setobj_CIMS_Basic_Information_Module;
			}
			public void setobj_CIMS_Other_Name_Module(CIMS_Other_Name_Module setobj_CIMS_Other_Name_Module) {
				this.obj_CIMS_Other_Name_Module = setobj_CIMS_Other_Name_Module;
			}
			public void setobj_CIMS_P2PBasicinfoModule(CIMS_P2PBasicinfoModule setobj_CIMS_P2PBasicinfoModule) {
				this.obj_CIMS_P2PBasicinfoModule = setobj_CIMS_P2PBasicinfoModule;
			}
			
			
			
			
			//  private CIMS_P2PBasicinfoModule ob_CIMS_P2PBasicinfoModule;
				
	}

