package CIMS.Modules.Counter;


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


public class CIMS_Company_Counter {
	
	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	
//	private Project_Initiation obj_Project_Initiation;
	private CIMS.Modules.Company.CIMS_Company_Functions obj_CIMS_Company_Functions;

    
    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test Company Data.xls";
    public static String os=System.getProperty("os.name");
    public static String osbit=System.getProperty("sun.arch.data.model");
    public static String moduleName="";
    public static String Employee_namecheck=null;
    public static String timer;

    
	//timer
    StopWatch pageLoad = new StopWatch();


 // get link/url to visit
 	private String fileName="Test Company Data.xls";		
 	private String columnNameRM="RUNMODE";
 	private String columnNameAction="ACTION";


	
			
	

	@Test
//Our Test start from here.
public void CIMSCompany() throws InterruptedException, IOException, AWTException {

		try {
			

	        /**
	         * code for Company suite starts here
	         * @author Brij
	         */

	    	//initialize variables that will be used..
	        String fileName							=	ExcelFileName;

	        boolean employeeSearchFlag				=	false;
	        

	        

	        	// let us choose Company suites from excel with Run mode Yes 
	        	String 	CompanySuites				=		"Company";
	        	int RowCount							=		UtilFunction.usedRowCount(fileName, CompanySuites);
	        	int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, columnNameRM);
	        	int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, columnNameAction);
	        	int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, "TAB NAME");

	        	// loop running for Company suites
	        	for(int modCounter = 1;modCounter<RowCount;modCounter++){

	    		try{
	    			// check if current suite name is set to runmode Y..
	        	
	        	        // counter variables for scenarios..
	        	        
	        	        int positiveScenarioCounter						=	0;
	        	        int negativeScenarioCounter						=	0;

	    			// now pick the name of Company suite, action, etc that is set to runmode Y

	    			String SuiteName				=		UtilFunction.getCellData(fileName, CompanySuites, columnNumber_SuiteName, modCounter);
	    			String ActionName				=		UtilFunction.getCellData(fileName, CompanySuites, columnNumber_ACTION, modCounter);

//					System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName 	 );

						// now check module run modes with Y.. and call module objects..

							String sheetName					=	SuiteName;
	    					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
	    					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
	    		        	int columnNumber_Scenario				=		2;//UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenerio");
//	    					int columnNumber_suiteNm_ACTION			=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameAction);


			    			for(int count=1; count<rowCount; count++)
							{

			    				if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){

			    					String Scenerio					=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
//			    					String suiteActionName				=		UtilFunction.getCellData(fileName, sheetName, ActionName, count);
		    					// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched
//			    					System.out.println("Sheet selected to pull data is: "	+ sheetName	+	" and with Action: "	+	ActionName 	+	" and with Scenerio: "	+	Scenerio );
			    					if(Scenerio.equals("Positive")){
			    						positiveScenarioCounter++;
			    					}else if(Scenerio.equals("Negative")){
			    						negativeScenarioCounter++;
			    					}
			    					

								}
							}
			    			System.out.println(CompanySuites + "\t" + sheetName + "\t" + positiveScenarioCounter + "\t" + negativeScenarioCounter);

	        		
	    		}catch(Exception e){
	    			
	    		}
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
		
/*		public void setobj_Project_Initiation(Project_Initiation setobj_Project_Initiation) {
			 this.obj_Project_Initiation	=	setobj_Project_Initiation;	 
					 
		}*/

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

