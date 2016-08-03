package CIMS;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import listner.ErrorUtil;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Reports.*;

public class CIMS_Dashboard {

	private String 						sysDate;
	private WebDriver 					webdriver;		
	private UtilFunction 				utilfunc;


	private CIMS.Reports.dashboard 		obj_Report_Dashboard;
	
	public static ArrayList<String> ModuleList 	= new ArrayList<String>();

	//timer
    StopWatch pageLoad = new StopWatch();


	@BeforeClass
	public void Setter(){
		setobj_dashboard((new dashboard()));

	}


@Test
public void CobaltDashboard() throws InterruptedException, IOException, AWTException{


	System.out.println("now we are preparing dashboard report. Please wait...");
//	Thread.sleep(15000);

	int nmbrOfModule				=	0;
	String numberOfModule			=	"";
	int nmbrOfPositive				=	0;
	String numberOfPositive			=	"";
	int nmbrOfNegative				=	0;
	String numberOfNegative			=	"";
	String numberOfTotalTestCases	=	"";



	// list of all suites
//	String[] SuiteLists			=	{"Left Navigation","Regression Suites","Questionnaires","Company","General Admin"};
	String[] SuiteLists			=	{CIMS_Left_Navigation.suiteName,CIMS_Regression_Suite.suiteName,
									CIMS_MainProject.suiteName,CIMS_Company.suiteName,CIMS_General_Admin.suiteName,CIMS_WebAccess.suiteName,
									CIMS_MyTaskProjectHistory.suiteName};



	for(int s=0;s<SuiteLists.length;s++){

		String SuiteName			=	SuiteLists[s];

		String SuiteFileName		=	"";
		String SuiteClassName		=	"";
		String SuiteModuleName		=	"";


			try {
				if(SuiteName.equals(CIMS_Company.suiteName)){
					SuiteFileName		=	CIMS_Company.ExcelFileName;
					SuiteModuleName		=	"TAB NAME";
					SuiteClassName		=	"CIMS_Company";
				}else if(SuiteName.equals(CIMS_MainProject.suiteName)){
					SuiteFileName		=	CIMS_MainProject.ExcelFileName;
					SuiteModuleName		=	"Questionnaire Name";
					SuiteClassName		=	"CIMS_MainProject";
				}else if(SuiteName.equals(CIMS_Left_Navigation.suiteName)){
					SuiteFileName		=	CIMS_Left_Navigation.ExcelFileName;
					SuiteModuleName		=	"Suite Name";
					SuiteClassName		=	"CIMS_Left_Navigation";
				}else if(SuiteName.equals(CIMS_Regression_Suite.suiteName)){
					SuiteFileName		=	CIMS_Regression_Suite.ExcelFileName;
					SuiteModuleName		=	"Suite Name";
					SuiteClassName		=	"CIMS_Regression_Suite";
				}else if(SuiteName.equals(CIMS_General_Admin.suiteName)){
					SuiteFileName		=	CIMS_General_Admin.ExcelFileName;
					SuiteModuleName		=	"Suite Name";
					SuiteClassName		=	"CIMS_General_Admin";
				}
			else if(SuiteName.equals(CIMS_WebAccess.suiteName)){
				SuiteFileName		=	CIMS_WebAccess.ExcelFileName;
				SuiteModuleName		=	"Suite Name";
				SuiteClassName		=	"CIMS_WebAccess";
			}
			else if(SuiteName.equals(CIMS_MyTaskProjectHistory.suiteName)){
				SuiteFileName		=	CIMS_MyTaskProjectHistory.ExcelFileName;
				SuiteModuleName		=	"Suite Name";
				SuiteClassName		=	"CIMS_MyTaskProjectHistory";
			}
			
			} catch (Exception e1) {
				System.out.println("unable to set suite name, file name and module name");
			}

		/**
		 * before proceeding let us check if RUN mode is set to Yes for this suite class or not..
		 * 
		 */


			try {
				if(RunMode.isSkip(SuiteFileName,"CIMS."+SuiteClassName)){

					System.out.println("Run mode is set No for "+SuiteName);
				}else{

//					try {
//						if(!SuiteName.equals(CIMS_Regression_Suite.suiteName)){
//							ModuleList.add(SuiteName);
//						}
//					} catch (Exception e1) {
//						// issue with assigning array data
//						System.out.println("issue with assigning array");
//					}
					System.out.println("run mode yes for: "+SuiteName);

					if(SuiteName.equals(CIMS_Regression_Suite.suiteName)){
						
						System.out.println("me yaha hun..");
						// in case of regression every module is treated as suite..
						// get total number of counter for company test data
						
			        	int RowCount							=		UtilFunction.usedRowCount(SuiteFileName, SuiteName);
			        	int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(SuiteFileName, SuiteName, "RUNMODE");

			        	int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(SuiteFileName, SuiteName, SuiteModuleName);

			        	// loop running for Company suites
			        	for(int modCounter = 1;modCounter<RowCount;modCounter++){
			        		
							ArrayList<String> my	=	numberOfModuleCounters(SuiteFileName, SuiteName, columnNumber_RUNMODE, columnNumber_SuiteName, SuiteModuleName, modCounter);
							Iterator<String> itr = my.iterator();

							try{

								int i=0;

								while (itr.hasNext()) {
									switch(i){
			
									case 0:
										
										try {
											ModuleList.add(itr.next());

										} catch (Exception e) {
											System.out.println("unable to add module name "+SuiteName);
										}
										i++;
										break;
									case 1:
			
										try {
											System.out.println(SuiteName+" prev total module: " + nmbrOfModule);
											nmbrOfModule	=	nmbrOfModule+ Integer.parseInt(itr.next());
											System.out.println(SuiteName+ " new total module: " + nmbrOfModule);
										} catch (Exception e) {
											System.out.println("unable to add number of modules for "+SuiteName);
										}
										i++;
										break;
			
									case 2:
										try {
											nmbrOfPositive	=	nmbrOfPositive+ Integer.parseInt(itr.next());
										} catch (Exception e) {
											System.out.println("unable to add number of positive for "+SuiteName);
										}
										i++;
										break;
									case 3:
										try {
											nmbrOfNegative	=	nmbrOfNegative+ Integer.parseInt(itr.next());
										} catch (Exception e) {
											System.out.println("unable to add number of negative for "+SuiteName);
										}
										i++;
										break;
									default:
								        System.out.println( "comp: " + itr.next());
										i++;
								        break;

									}
								}
								}catch(Exception e){
									System.out.println("exception in "+SuiteName+" array");
								}
			        	}

					}else{

						// get total number of counter for company test data
						ArrayList<String> my	=	numberOfSuiteCounters(SuiteFileName, SuiteName, "RUNMODE", "ACTION", SuiteModuleName);
						Iterator<String> itr = my.iterator();

						try{

						int i=0;

						while (itr.hasNext()) {
							switch(i){
	
							case 0:
								
								try {
									ModuleList.add(itr.next());
								} catch (Exception e) {
									System.out.println("unable to add module name "+SuiteName);
								}
								i++;
								break;
							case 1:
	
								try {
									System.out.println(SuiteName+" prev total module: " + nmbrOfModule);
									nmbrOfModule	=	nmbrOfModule+ Integer.parseInt(itr.next());
									System.out.println(SuiteName+ " new total module: " + nmbrOfModule);
								} catch (Exception e) {
									System.out.println("unable to add number of modules for "+SuiteName);
								}
								i++;
								break;
	
							case 2:
								try {
									nmbrOfPositive	=	nmbrOfPositive+ Integer.parseInt(itr.next());
								} catch (Exception e) {
									System.out.println("unable to add number of positive for "+SuiteName);
								}
								i++;
								break;
							case 3:
								try {
									nmbrOfNegative	=	nmbrOfNegative+ Integer.parseInt(itr.next());
								} catch (Exception e) {
									System.out.println("unable to add number of negative for "+SuiteName);
								}
								i++;
								break;
							default:
						        System.out.println( "comp: " + itr.next());
								i++;
						        break;
	
							}
						}
						}catch(Exception e){
							System.out.println("exception in "+SuiteName+" array");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("unable to process & calculate counter for module: "+SuiteName);
			}
	}




	numberOfModule					=	Integer.toString(nmbrOfModule);
	numberOfPositive				=	Integer.toString(nmbrOfPositive);
	numberOfNegative				=	Integer.toString(nmbrOfNegative);
	numberOfTotalTestCases			=	Integer.toString(nmbrOfPositive+nmbrOfNegative);


	System.out.println("now generate report");
//	String[] ModuleLists	= {"Company", "Left Navigation", "General Admin"};
	String[] ModuleLists			=	new String[ModuleList.size()];
	ModuleList.toArray(ModuleLists);

	System.out.println(Arrays.toString(ModuleLists));

	System.out.println("yaha wait abhi..");

	// now generating report
	try {
		obj_Report_Dashboard.generateReport(ModuleLists,numberOfModule, numberOfTotalTestCases, numberOfPositive, numberOfNegative);
	} catch (Exception e) {
		System.out.println("unable to generate final report");
	}

	// after generating report let us clear file data..
/*
	try{
	    // file path variables..
	    String projectReportPath				=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator	;
	    String projectReportTempPath			=	projectReportPath + "temp"	+ File.separator;
		String passCounterFilePath				=	projectReportTempPath + "pass_counter";
		String failCounterFilePath				=	projectReportTempPath + "fail_counter";
		String moduleNotAssignedCounterFilePath	=	projectReportTempPath + "module_not_assigned_counter";
		String totalTimeFilePath				=	projectReportTempPath + "total_time";
		String barGraphFilePath					=	projectReportTempPath + "bar_graph";
	
		obj_Report_Dashboard.WriteToFile("", passCounterFilePath);
		obj_Report_Dashboard.WriteToFile("", failCounterFilePath);
		obj_Report_Dashboard.WriteToFile("", moduleNotAssignedCounterFilePath);
		obj_Report_Dashboard.WriteToFile("", totalTimeFilePath);
		obj_Report_Dashboard.WriteToFile("", barGraphFilePath);
		

	}catch(Exception e){
		System.out.println("unable to clear temp data of counters..");
	}
*/


}



public ArrayList<String> numberOfModuleCounters(String fileName, String CompanySuites, int columnNumber_RUNMODE,
		int columnNumber_SuiteName, String suiteName, int modCounter) throws InterruptedException, IOException, AWTException {

	ArrayList<String> al = new ArrayList<String>();
		try {


	        /**
	         * code for Company suite starts here
	         * @author Brij
	         */

			String ModuleName=	"";

				int positiveScenarioCounter						=	0;
		        int negativeScenarioCounter						=	0;
		        int totalNumberOfModules						=	0;

	
		    		try{
		    			// check if current suite name is set to runmode Y..
	
		        	        // counter variables for scenarios..
		    			if(UtilFunction.getCellData(fileName, CompanySuites, columnNumber_RUNMODE, modCounter).equals("Y")){
	
		    				totalNumberOfModules++;
	
		    			// now pick the name of Company suite, action, etc that is set to runmode Y
	
		    			String sheetName				=		UtilFunction.getCellData(fileName, CompanySuites, columnNumber_SuiteName, modCounter);
		    			ModuleName	=	sheetName;
	//					System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName 	 );
	
							// now check module run modes with Y.. and call module objects..

		    					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
		    					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, "RUNMODE");
		    		        	int columnNumber_Scenario				=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");//2;


				    			for(int count=1; count<rowCount; count++)
								{
	
				    				if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){
	
				    					String Scenario					=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
	//			    					String suiteActionName				=		UtilFunction.getCellData(fileName, sheetName, ActionName, count);
			    					// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched
	//			    					System.out.println("Sheet selected to pull data is: "	+ sheetName	+	" and with Action: "	+	ActionName 	+	" and with Scenerio: "	+	Scenerio );
				    					if(Scenario.equals("Positive")
				    							|| Scenario.contains("Pos")
				    							){
				    						positiveScenarioCounter++;
				    					}
				    					if(Scenario.equals("Negative") 
				    							|| Scenario.contains("Neg")
				    							){
				    						negativeScenarioCounter++;
				    					}
	
									}
								}
	
				    			System.out.println(CompanySuites + "\t" + sheetName + "\t" + positiveScenarioCounter + "\t" + negativeScenarioCounter);
	
		    			}
	
		    		}catch(Exception e){
		    			
		    		}

		    		//in case of regression we are treating each module as suite
	        		if(CompanySuites.equals(CIMS_Regression_Suite.suiteName) && !ModuleName.isEmpty()){
//	    				System.out.println("chal bhai start ho ja..");
//	    				al.add(CompanySuites);
	    	        	al.add(ModuleName);
	    	        	al.add(Integer.toString(totalNumberOfModules));
	    	        	  al.add(Integer.toString(positiveScenarioCounter));
	                      al.add(Integer.toString(negativeScenarioCounter));
	    			}


			}
			catch(Exception e){
				ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
				System.out.println("Script Failed!!!");
			}

		return al;
}




public ArrayList<String> numberOfSuiteCounters(String fileName, String CompanySuites, String columnNameRM,
		String columnNameAction, String suiteName) throws InterruptedException, IOException, AWTException {

	ArrayList<String> al = new ArrayList<String>();
		try {


	        /**
	         * code for Company suite starts here
	         * @author Brij
	         */

			
				int positiveScenarioCounter						=	0;
		        int negativeScenarioCounter						=	0;
		        int totalNumberOfModules						=	0;

	        	int RowCount							=		UtilFunction.usedRowCount(fileName, CompanySuites);
	        	int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, columnNameRM);
	        	int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, columnNameAction);
	        	int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, CompanySuites, suiteName);

	        	// loop running for Company suites
	        	for(int modCounter = 1;modCounter<RowCount;modCounter++){
	        		
	        		String ModuleName=	"";
	        		
	        		

		    		try{
		    			// check if current suite name is set to runmode Y..
	
		        	        // counter variables for scenarios..
		    			if(UtilFunction.getCellData(fileName, CompanySuites, columnNumber_RUNMODE, modCounter).equals("Y")){
	
		    				totalNumberOfModules++;
	
		    			// now pick the name of Company suite, action, etc that is set to runmode Y
	
		    			String sheetName				=		UtilFunction.getCellData(fileName, CompanySuites, columnNumber_SuiteName, modCounter);
		    			ModuleName	=	sheetName;
	//					System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName 	 );
	
							// now check module run modes with Y.. and call module objects..
	
		    					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
		    					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
		    		        	int columnNumber_Scenario				=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");//2;
	
	
				    			for(int count=1; count<rowCount; count++)
								{
	
				    				if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){
	
				    					String Scenario					=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
	//			    					String suiteActionName				=		UtilFunction.getCellData(fileName, sheetName, ActionName, count);
			    					// check if user is looking for immigration or document then click on Menu>Imiggration Status only after user is searched
	//			    					System.out.println("Sheet selected to pull data is: "	+ sheetName	+	" and with Action: "	+	ActionName 	+	" and with Scenerio: "	+	Scenerio );
				    					if(Scenario.equals("Positive")
				    							|| Scenario.contains("Pos")
				    							){
				    						positiveScenarioCounter++;
				    					}
				    					if(Scenario.equals("Negative") 
				    							|| Scenario.contains("Neg")
				    							){
				    						negativeScenarioCounter++;
				    					}
	
									}
								}
	
				    			System.out.println(CompanySuites + "\t" + sheetName + "\t" + positiveScenarioCounter + "\t" + negativeScenarioCounter);
	
		    			}
	
		    		}catch(Exception e){
		    			
		    		}

		    		//in case of regression we are treating each module as suite
/*	        		if(CompanySuites.equals(CIMS_Regression_Suite.suiteName) && !ModuleName.isEmpty()){
//	    				System.out.println("chal bhai start ho ja..");
//	    				al.add(CompanySuites);
	    	        	al.add(ModuleName);
	    	        	al.add(Integer.toString(totalNumberOfModules));
	    	        	  al.add(Integer.toString(positiveScenarioCounter));
	                      al.add(Integer.toString(negativeScenarioCounter));
	    			}*/

	        	}

	        	// this is for all except for Regression suite
	        	if(!CompanySuites.equals(CIMS_Regression_Suite.suiteName)){

						al.add(CompanySuites);
						//	        	al.add(sheetName);
						al.add(Integer.toString(totalNumberOfModules));
						al.add(Integer.toString(positiveScenarioCounter));
						al.add(Integer.toString(negativeScenarioCounter));
	        	}

		}
		catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed!!!");
		}

		return al;
}

//dashboard report

	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
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

}
