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


//import CIMS.Modules.Project_Initiation;
import bsh.util.Util;



public class CIMS_ProfileQuestionnaire_Counter {
	
	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	

    
    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test Data.xls";
    public static String os=System.getProperty("os.name");
    public static String osbit=System.getProperty("sun.arch.data.model");
    public static String moduleName="";
    public static String Employee_namecheck=null;
    public static String timer;

    
	//timer
    StopWatch pageLoad = new StopWatch();

	
 	private String columnNameRM="RUNMODE";
 	private String columnNameAction="ACTION";


	
			
	

	@Test
//Our Test start from here.
public void CIMSProfileQuestionnaire() throws InterruptedException, IOException, AWTException {

		try {
			


	        /**
	         * code for ProfileQuestionnaire suite starts here
	         * @author Brij
	         */

	    	//initialize variables that will be used..
	        String fileName							=	ExcelFileName;



	        	// let us choose ProfileQuestionnaire suites from excel with Run mode Yes 
	        	String 	ProfileQuestionnaireSuites				=		"Questionnaires";
	        	int RowCount							=		UtilFunction.usedRowCount(fileName, ProfileQuestionnaireSuites);
	        	int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, ProfileQuestionnaireSuites, columnNameRM);
	        	int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, ProfileQuestionnaireSuites, columnNameAction);
	        	int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, ProfileQuestionnaireSuites, "Questionnaire Name");

	        	// loop running for ProfileQuestionnaire suites
	        	for(int modCounter = 1;modCounter<RowCount;modCounter++){

	    		try{
	    			// check if current suite name is set to runmode Y..
	        		

	        			// counter variables for scenarios..
	        	        int positiveScenarioCounter						=	0;
	        	        int negativeScenarioCounter						=	0;

	    			// now pick the name of ProfileQuestionnaire suite, action, etc that is set to runmode Y

	    			String SuiteName				=		UtilFunction.getCellData(fileName, ProfileQuestionnaireSuites, columnNumber_SuiteName, modCounter);

//					System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName 	 );

						// now check module run modes with Y.. and call module objects..

							String sheetName					=	SuiteName;
	    					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
	    					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
	    		        	int columnNumber_Scenario				=		2;//UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenerio");
//	    					int columnNumber_suiteNm_ACTION			=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameAction);


			    			for(int count=1; count<rowCount; count++)
							{

			    				try{

			    					String Scenario					=		UtilFunction.getCellData(fileName, SuiteName, columnNumber_Scenario, count);

		    					// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched
//			    					System.out.println("Sheet selected to pull data is: "	+ sheetName	+	" and with Action: "	+	ActionName 	+	" and with Scenario: "	+	Scenario );
			    					if(Scenario.equals("Positive") || Scenario.contains("sitive")){
			    						positiveScenarioCounter++;
			    					}else if(Scenario.equals("Negative") || Scenario.contains("gative") || Scenario.contains("gavtive") ){
			    						negativeScenarioCounter++;
			    					}
			    				}catch(Exception e){
			    					
			    				}
			    				

//								}
							}
			    			System.out.println(ProfileQuestionnaireSuites + "\t" + sheetName + "\t" + positiveScenarioCounter + "\t" + negativeScenarioCounter);

	        		
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


		/*public void setDriver(WebDriver driver) {
			this.driver = driver;
		}*/

		public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
			this.obj_CIMS_Login = setobj_CIMS_Login;
		}
		
		

		
	}

