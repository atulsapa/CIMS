package CIMS;


import java.awt.AWTException;
import java.io.IOException;
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
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.thoughtworks.selenium.Wait;

//import util.Email;
import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Company.CIMS_Company_Functions;

import bsh.util.Util;

import CIMS.Modules.Company.*;


public class CIMS_Company {

	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	
	private CIMS.Modules.Company.CIMS_Company_Functions obj_CIMS_Company_Functions;

    
    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test Company Data.xls";
    public static String suiteName	=	"Company";
    public static String os=System.getProperty("os.name");
    public static String osbit=System.getProperty("sun.arch.data.model");
    public static String moduleName="";
    public static String Employee_namecheck=null;
    public static String companyName=null;
    public static String timer;

    
	//timer
    StopWatch pageLoad = new StopWatch();


 // get link/url to visit
 	private String fileName="Test Company Data.xls";		
 	private String columnNameRM="RUNMODE";
 	private String columnNameAction="ACTION";


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
//				System.out.println(this.getClass().getName());
				setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
				setSysDate(UtilFunction.currentDateTime());				
				setUtilfunc(new UtilFunction(this.getDriver()));	
				setobj_CIMS_Login(new CIMS_Login(webdriver, utilfunc));
//				setobj_Project_Initiation(new Project_Initiation (webdriver,utilfunc));
				setobj_CIMS_Company_Functions(new CIMS_Company_Functions(webdriver,utilfunc));
			

				//CIMS_Organization_Information_Module
				
				
				if(UtilFunction.Actualbrw.equals("IE")){
					webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
				}else if(UtilFunction.Actualbrw.equals("CHROME")){
					webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					
				}else{
				webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
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
			
	

	@Test
//Our Test start from here.
public void CIMSCompany() throws InterruptedException, IOException, AWTException {


	try {
		/*p = System.getProperty("os.name");
		System.out.println("Operating system is"+p);*/

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
        
        utilfunc.zoomOut(5);
        
        // add new company
		obj_CIMS_Company_Functions.addCompany(fileName, columnNameRM, columnNameAction);


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
		
//		public void setobj_Project_Initiation(Project_Initiation setobj_Project_Initiation) {
//			 this.obj_Project_Initiation	=	setobj_Project_Initiation;	 
//					 
//		}

		/*public void setDriver(WebDriver driver) {
			this.driver = driver;
		}*/

		public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
			this.obj_CIMS_Login = setobj_CIMS_Login;
		}
		
		public void setobj_CIMS_Company_Functions(CIMS_Company_Functions setobj_CIMS_Company_Functions) {
			this.obj_CIMS_Company_Functions = setobj_CIMS_Company_Functions;
		}
		
		

		
	}

