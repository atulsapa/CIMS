package CIMS.Modules.GlobalCheck;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import CIMS.Modules.Questionnaires.CIMS_Assessment_Module;

import util.UtilFunction;

public class CIMS_GCP_project_Initiation {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	private CIMS_Assessment_Module obj_CIMS_Assessment_Module;
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 private static String GCPNewQueryTitleXpath="//*[@id='panel-header']";

	 
	
		
	 
	 public CIMS_GCP_project_Initiation(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
				
		}	
		 
	 }
	 
	 public boolean GCP_NewQuery_Initiation_Page(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
		
		 setobj_CIMS_Assessment_Module(new CIMS_Assessment_Module(webdriver,utilfunc));
		 boolean Flag	=	false;
			
			
			String error_flag                ="";
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.....");
			
			 String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			 String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			 String Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			 String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			 String Duplicatename                               =           UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
			 
			 String NewProfile                                  =           UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
			 String ExpectedErrorMessage                        =            UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
			    
			    testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){
					
					if(mode.equals("New")){
						
						String InitiationBtn=".//*[contains(@class,'btn') and text()='Initiate']";
						
						try {
							utilfunc.MakeElement(InitiationBtn).click();
						} catch (Exception e) {
							System.out.println("Unable to click on the button");
						}
						
						try {
							if(!Duplicatename.isEmpty()){
								
							String DuplicateCounterXpath=".//*[contains(@class,'form-')]//*[contains(@class,'table table-item-list')]//tbody//tr//td/input";
							String DuplicateXpath=".//*[contains(@class,'form-')]//*[contains(@class,'table table-item-list')]//tbody//tr[xx]//td/input";
							String DupliateText=".//*[contains(@class,'form-')]//*[contains(@class,'table table-item-list')]//tbody//tr[1]//td[2]/b";
							int DuplicateCounter=utilfunc.GetObjectCount(DuplicateCounterXpath);
							
							for(int i=1; i<=DuplicateCounter; i++){
								
								String NewTextXpath		=			DupliateText.replace("xx",Integer.toString(i));

							    String DuplicateName=utilfunc.MakeElement(NewTextXpath).getText();
							    
							    
							    if(Duplicatename.equals(DuplicateName)){
							    	
							    	String NewDuplicateXpath=DuplicateXpath.replace("xx",Integer.toString(i));
							    	
							    	try {
							    		Thread.sleep(1000);
										utilfunc.MakeElement(NewDuplicateXpath).click();
										Thread.sleep(1000);
									} catch (Exception e) {
										System.out.println("Unable to click on the radio button");
									}
							    	 System.out.println("DuplicateName is" + DuplicateName);
							    }else{
							    	System.out.println("Not able to find the field.");
							    }
							    }
							

					    	String NewProfileXpath =".//*[contains(@class,'checkbox')]//input";
							
							if(NewProfile.equals("Yes")){
								Thread.sleep(1000);
								utilfunc.MakeElement(NewProfileXpath).click();
								Thread.sleep(1000);
							}
							}else{   
								
								
								System.out.println("Not Found the record");
								
								
								
							}
						} catch (Exception e) {
							
						}
							
						}
					
					
					try{
						 // save button after saving all data..
						String saveBtn	=	".//a[contains(@class,'btn') and text()='Start Initiation']";
			        	utilfunc.MakeElement(saveBtn).click();
			        	Thread.sleep(2000);
					}catch(Exception e){}
					
					
					try{
						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
						error_flag=utilfunc.ErrorMessageGCPTravelHistoyhandlerExperiment();
					//	ExpectedErrorMessage=ExpectedErrorMessage.trim();
						System.out.println("==="+ExpectedErrorMessage+"===");
						System.out.println("==="+error_flag+"===");
						
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;
							 webdriver.navigate().back();
						 }else{
							 Flag=false;
							 utilfunc.TakeScreenshot();
						 }
					}catch(Exception e){
						Flag	=	false;
						System.out.println("Data is not saved because all fields are not set in the form.");
						
				}
						
						
						
					}
				String DoneBtnXpath ="//*[contains(@class,'btn') and text()='Done']";
				
				try {
					utilfunc.MakeElement(DoneBtnXpath).click();
				} catch (Exception e) {
				System.out.println("Not Able to click on the Done Btn");
				}
					
				
					
					
					
					
				
			 
			 
			 
			 return Flag;

	 }
	 public void setobj_CIMS_Assessment_Module(CIMS_Assessment_Module setobj_CIMS_Assessment_Module) {
			this.obj_CIMS_Assessment_Module = setobj_CIMS_Assessment_Module;  
		}
	 
}
