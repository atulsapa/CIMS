package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;
import CIMS.CIMS_Regression_Suite;
import util.UtilFunction;

public class CIMS_Login
{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	private Robot Robot;
	//Veriables-------------

	//Project_Initiation_login()	 
	//Methods Xpaths	
	private static String UsernameTextBoxXpath="//*[@id='txtUsername']";
	private static String GOButtonXpath="//*[@id='btnLogin']";
	private static String PasswordTextBoxXpath="//*[@id='txtPassword']";
	private static String LoginButtonXpath=".//*[@id='btnLogin']";
	private static String Employeebuttonlinktext="Employees";
	private static String Employeename=".//*[@id='SearchText']";
	private static String Employeesearch=".//*[@id='btnSearch']";
	private static String sidebarxpath=".//*[@id='slider-icon']";
	private static String employeexpath= ".//*[@id='visacase-list-header']/tbody/tr[1]/td[2]/a";
	private static String projectbutton=".//*[@id='anchorProject']";
	private static String projectreference=".//*[@id='caseNumber']";
	private static String buttonprojectsearch=".//*[@id='btnSearchProject']";
	private static String profileQuestionaireEmployeeerecord=".//*[@id='dvUserList']//*[@class='table-rec-container']/table[1]/tbody/tr[1]/td[1]/a";
	//private String fileName="Test Data.xls";
	//private String sheetName="URLANDNAME";

	///dev
	private static String Employeebuttonlinktext1="Projects";
	private static String buttonprojectsearch1=".//*[@id='btnSearch']";

	public static String QuestionaireURL="";
	public static String QuestionaireName="";

	//Excel sheet Data collection
	private static String Username=UtilFunction.getCellData(CIMS_Regression_Suite.ExcelFileName, "Credentials", 2, 1);
	private static String Password=UtilFunction.getCellData(CIMS_Regression_Suite.ExcelFileName, "Credentials", 3, 1);
	//private static String Employeesearchname=UtilFunction.getCellData("Test Data.xls", "Credentials", 4, 1);


	//Welcome_Page()

	//Methods Xpaths	
	//private static String WelcomeTextXpath="//*[@class='span10']/div[1]/table/tbody/tr/td[1]";
	//modified
	private static String WelcomeTextXpath=".//*[@id='main-container']/div/div[1]/span[1]";


	//private static String WelcomeTextXpath="//*[@id='main-container']/div/center/div[1]/table/tbody/tr/td[1]/div";
	private static String InitiateProjectButtonXpath="//*[@class='btn btn-primary']";
	String Employeefieldxpath=".//*[@class='table table-item-list grid']//tbody/tr[xx]/td[1]/a";
	String Employeecounterxpath=".//*[@class='table table-item-list grid']//tbody/tr";
	String EmployeeNamexpath="//*[@id='SearchText']";


	//Constructor----------
	//// This is a constructor, as every page need a base driver to find web elements

	public CIMS_Login(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}

	public void Project_login(String loginFilename) throws AWTException, InterruptedException
	{	
		String myUserName =	UtilFunction.getCellData(loginFilename, "Credentials", 2, 1);
		String myPassword	=	UtilFunction.getCellData(loginFilename, "Credentials", 3, 1);
		Reporter.log("COBALT Project Statstics Report");		 
		//Reporter.log("---------------------------------------------------------------------------------------");
		Reporter.log("");	
		// Reporter.log("-------------------------------CIMS Login Page Verification----------------------------");
		try{
			utilfunc.findElementByXpath(UsernameTextBoxXpath);
			utilfunc.MakeElement(UsernameTextBoxXpath).sendKeys(myUserName);		  
			utilfunc.MakeElement(GOButtonXpath).click();
			System.out.println("User is successfully clicked on the First Login Page Successfully");

			utilfunc.MakeElement(PasswordTextBoxXpath).sendKeys(myPassword);		  
			utilfunc.MakeElement(LoginButtonXpath).click();
			//Temporary code==//
			//		 webdriver.navigate().back();
			//===============//
			System.out.println("User is successfully clicked on the Secound Login Page Successfully");
			System.out.println("---------------------------------------------------------------------------------------");
		}
		catch(Exception e){
			System.out.println("Login verfication Failed due to an error");
			System.out.println("------------------------------------------------------------------------------------");
			TakeScreenshot();
		}
	}
	//Functions--------------
	/**
	 * Verify that User is able to logged in successfully 
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Project_login() throws AWTException, InterruptedException
	{	
		Reporter.log("COBALT Project Statstics Report");		 
		//Reporter.log("---------------------------------------------------------------------------------------");
		Reporter.log("");	
		// Reporter.log("-------------------------------CIMS Login Page Verification----------------------------");
		try{
			utilfunc.findElementByXpath(UsernameTextBoxXpath);
			utilfunc.MakeElement(UsernameTextBoxXpath).sendKeys(Username);		  
			utilfunc.MakeElement(GOButtonXpath).click();
			System.out.println("User is successfully clicked on the First Login Page Successfully");

			utilfunc.MakeElement(PasswordTextBoxXpath).sendKeys(Password);		  
			utilfunc.MakeElement(LoginButtonXpath).click();
			//Temporary code==//
			//		 webdriver.navigate().back();
			//===============//
			System.out.println("User is successfully clicked on the Secound Login Page Successfully");
			System.out.println("---------------------------------------------------------------------------------------");
		}
		catch(Exception e){
			System.out.println("Login verfication Failed due to an error");
			System.out.println("------------------------------------------------------------------------------------");
			TakeScreenshot();
		}
	}


	/**
	 * Verify that User is able to logged in successfully 
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Welcome_Page(){
		System.out.println("");
		System.out.println("-------------------------------CIMS Welcome Page Verification---------------------------");
		try{
			String Welcometext=utilfunc.MakeElement(WelcomeTextXpath).getText();	
			if(Welcometext.contains("Welcome to BAL’s integrated visa processing system")){
				System.out.println("User is Landed on the CIMS Welcome Page successfully"); 
				System.out.println("CIMS Page Message is : "+Welcometext);				 
				System.out.println("---------------------------------------------------------------------------------------");
			}else{
				System.out.println("User is Landed on the Diffrent Page");
				System.out.println("---------------------------------------------------------------------------------------");
				TakeScreenshot();
			}
		}catch(Exception e){
			System.out.println("Welcome Message is Missing");
			System.out.println("---------------------------------------------------------------------------------------");
			TakeScreenshot();
		}
	}

	public void searchemployee(String Employeenamecheck,String Employeesearchname){
		System.out.println("");
		System.out.println("-------------------------------CIMS EMPLOYEE SEARCHING---------------------------");
		try{

			utilfunc.LinkText(Employeebuttonlinktext).click();
			if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Project")){
				utilfunc.MakeElement(projectbutton).click();
				utilfunc.MakeElement(projectreference).sendKeys(Employeesearchname);
				utilfunc.MakeElement(buttonprojectsearch).click();
				Thread.sleep(5000);
			}
			else if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Profile")){
				utilfunc.MakeElement(EmployeeNamexpath).sendKeys(Employeenamecheck);
				utilfunc.MakeElement(Employeesearch).click();
				Thread.sleep(5000);
			}

			else if(CIMS_MainProject.SelectQuestionnairetype.equalsIgnoreCase("Project")){
				utilfunc.MakeElement(projectbutton).click();
				utilfunc.MakeElement(projectreference).sendKeys(Employeesearchname);
				utilfunc.MakeElement(buttonprojectsearch).click();
				Thread.sleep(5000);
			}
			else if(CIMS_MainProject.SelectQuestionnairetype.equalsIgnoreCase("Profile")){
				utilfunc.MakeElement(EmployeeNamexpath).sendKeys(Employeenamecheck);
				utilfunc.MakeElement(Employeesearch).click();
				Thread.sleep(5000);
			}

			
			try {
				if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Project")||CIMS_MainProject.SelectQuestionnairetype.equalsIgnoreCase("Project"))
				{
					utilfunc.MakeElement(employeexpath).click();
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				System.out.println("unable to get project link");
			}
			
			try {
				if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("PROFILE")||CIMS_MainProject.SelectQuestionnairetype.equalsIgnoreCase("PROFILE"))
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


	/**
	 * 
	 * @param Employeenamecheck
	 * @param Employeesearchname
	 */

	public void advancedSearchEmployeeOrProject(String Employeenamecheck,String Employeesearchname){
		System.out.println("");
		System.out.println("-------------------------------CIMS EMPLOYEE SEARCHING---------------------------");
		try{

			utilfunc.LinkText(Employeebuttonlinktext).click();
			if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Project")){
				utilfunc.MakeElement(projectbutton).click();
				utilfunc.MakeElement(projectreference).sendKeys(Employeesearchname);
				utilfunc.MakeElement(buttonprojectsearch).click();
				Thread.sleep(5000);
			}
			else if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Profile")){
				utilfunc.MakeElement(EmployeeNamexpath).sendKeys(Employeenamecheck);
				utilfunc.MakeElement(Employeesearch).click();
				Thread.sleep(5000);
			}

			/*if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Project"))
			{
				utilfunc.MakeElement(employeexpath).click();
				Thread.sleep(5000);
			}else if(CIMS_Regression_Suite.SelectQuestionnairetype.equalsIgnoreCase("Profile"))
			{
				utilfunc.MakeElement(profileQuestionaireEmployeeerecord).click();
				Thread.sleep(5000);
			}
*/
			utilfunc.MakeElement(employeexpath).click();
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
				String SubMenuProfilexpath=".//*[@class='gn-submenu']/li[2]/a";
				utilfunc.MakeElement(SubMenuProfilexpath).click();

			}catch(Exception f){
				ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
				System.out.println("NOT ABLE TO FOUND THE USER");
				utilfunc.assertion();			
				utilfunc.TakeScreenshot();
			}

		}


	}

	//Take a Screen shot
	public void TakeScreenshot(){
		utilfunc.takeScreenShot(System.getProperty("user.dir")+"/test-output/Error Screenshot/errorSceenshot"+UtilFunction.currentDateTime()+".jpg");
	}

}