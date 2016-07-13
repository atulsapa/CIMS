package CIMS.Modules.Counter;


import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.util.Arrays;
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

import CIMS.Modules.Regression.*;



@SuppressWarnings("deprecation")
public class CIMS_Regression_Suite_Counter {

	private String 										sysDate;
	private WebDriver 									webdriver;		
	private UtilFunction 								utilfunc;



    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test Regression Suite Data.xls";
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


	//Our Test start from here.

	@Test
	
	public void CIMSSingleProjectInitiation() throws InterruptedException, IOException, AWTException {


	try {
	

        /**
         * code for regression suite starts here
         * @author Brij
         */

    	//initialize variables that will be used..

        String fileName							=	"Test Regression Suite Data.xls";
        

        	// let us choose Regrssion suites from excel with Run mode Yes 
        	String 	RegressionSuites				=		"Regression Suites";
        	int RowCount							=		UtilFunction.usedRowCount(fileName, RegressionSuites);
        	int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, columnNameRM);
        	int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, columnNameAction);
        	int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, RegressionSuites, "Suite Name");



        	// loop running for regression suites
        	for(int modCounter = 1;modCounter<RowCount;modCounter++){

    		try{
    			// check if current suite name is set to runmode Y..
        		
        	        // counter variables for scenarios..
        	        
        	        int positiveScenarioCounter						=	0;
        	        int negativeScenarioCounter						=	0;


    			// now pick the name of regression suite, action, etc that is set to runmode Y

    			String SuiteName				=		UtilFunction.getCellData(fileName, RegressionSuites, columnNumber_SuiteName, modCounter);
    			String ActionName				=		UtilFunction.getCellData(fileName, RegressionSuites, columnNumber_ACTION, modCounter);

//				System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName 	 );

					// now check module run modes with Y.. and call module objects..

						String sheetName					=	SuiteName;
    					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
    					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
    		        	int columnNumber_Scenario				=		2;//UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");


		    			for(int count=1; count<rowCount; count++)
						{

//		    				if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){

		    					String Scenario					=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
//		    					String suiteActionName				=		UtilFunction.getCellData(fileName, sheetName, ActionName, count);
	    					// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched
//		    					System.out.println("Sheet selected to pull data is: "	+ sheetName	+	" and with Action: "	+	ActionName 	+	" and with Scenario: "	+	Scenario );
		    					if(Scenario.equals("Positive") || Scenario.contains("sitive") || Scenario.contains("Pos")){
		    						positiveScenarioCounter++;
		    					}else if(Scenario.equals("Negative") || Scenario.contains("gative") || Scenario.contains("gavtive") ){
		    						negativeScenarioCounter++;
		    					}
		    					

//							}
						}
		    			System.out.println(RegressionSuites + "\t" + sheetName + "\t" + positiveScenarioCounter + "\t" + negativeScenarioCounter);

        		
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
		
	

		
		//LOKESH CODE 
		public String myfunction(String SuiteName,String Actionname)
		{
			String suiteLink="";
			if(Actionname.equalsIgnoreCase("New")){
			try{
				utilfunc.MakeElement(".//*[@id='local-navigation']//*[contains(@class,'btn')]//*[contains(@class,'icon-plus')]").click();
			}catch(Exception e){
				System.out.println("Unable to find the Add Button");

			}
			suiteLink			=		".//*[@id='docs']/center//*[contains(@class,'btn') and text()='"+ SuiteName +"']";
			}
			else if(Actionname.equalsIgnoreCase("Edit"))
			{
				try{
					utilfunc.MakeElement(".//*[@id='divVisaCaseLegalStatus_MX']//tbody/tr[1]/td[2]").click();
					Thread.sleep(1500);
					utilfunc.MakeElement(".//*[@id='divVisaCaseLegalStatus_MX']//tbody/tr[2]//*[contains(@class,'btn-group')]//*[contains(@class,'dropdown-toggle')]//*[contains(@class,'icon-cog')]").click();
					Thread.sleep(1500);
					utilfunc.MakeElement(".//*[@id='divVisaCaseLegalStatus_MX']//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Edit')]").click();
					Thread.sleep(1500);
				}catch(Exception error){}
				suiteLink			=		".//*[@id='docs']/center//*[contains(@class,'btn') and text()='"+ SuiteName +"']";
			}
			else if(Actionname.equalsIgnoreCase("Delete"))
			{
				try{
					utilfunc.MakeElement(".//*[@id='divVisaCaseLegalStatus_MX']//tbody/tr[1]/td[2]").click();
					Thread.sleep(1500);
				}catch(Exception error){}
				suiteLink			=		".//*[@id='divVisaCaseLegalStatus_MX']//tbody/tr[2]//*[contains(@class,'btn-group')]//*[contains(@class,'dropdown-toggle')]//*[contains(@class,'icon-cog')]";
			}
			return suiteLink;
		}
		//LOKESH CODE
		
		
	}

