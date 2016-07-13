package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Government_Priority_Dates {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	 public CIMS_Government_Priority_Dates(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 

	      public boolean Government_Priority_Dates(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String MonthValue							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String YearValue							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String PreferenceCategory						    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String isCurrent_CN							        =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String GovPriorityDate_CN						    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String isCurrent_IN						            =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String GovPriorityDate_IN					        =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String isCurrent_MX					                =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String GovPriorityDate_MX			                =			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			
			String isCurrent_PH					                =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			String GovPriorityDate_PH 						    =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String Search_Year                                  =           UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
			

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				
				String AddNewPriorityDateXptah	=	".//a[contains(@class,'btn') and contains(text(),'Add New Priority Date')]";
				
				String monthValueXpath="//*[@id='form1']//*[contains(@class,'control-group')]//*[contains(@id,'MonthValue')]";
				String YearValueXpath="//*[@id='form1']//*[contains(@class,'control-group')]//*[contains(@id,'YearValue')]";
				String PreferenceCategoryXpath= "//*[@id='form1']//*[contains(@class,'control-group')]//*[contains(@id,'PreferenceCategory')]";
				String GovPriorityDate_CNXpath=".//*[@id='GovPriorityDate_CN']";
				String isCurrent_CNXpath=".//*[@id='isCurrent_CN']";
				String GovPriorityDate_INXpath=".//*[@id='GovPriorityDate_IN']";
				String isCurrent_INXpath=".//*[@id='isCurrent_IN']";
				String GovPriorityDate_MXXpath=".//*[@id='GovPriorityDate_MX']";
				String isCurrent_MXXpath=".//*[@id='isCurrent_MX']";
				String GovPriorityDate_PHXpath=".//*[@id='GovPriorityDate_PH']";
				String isCurrent_PHXpath=".//*[@id='isCurrent_PH']";
				String SearchYearXpath =".//*[@id='Yearvalue']";
				
				String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
				String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
				String DeleteIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'trash')]";
				
				if(mode.equals("New")){
					
					try{
						
						utilfunc.MakeElement(AddNewPriorityDateXptah).click();
						System.out.println("======Click on the AddNewPriorityDateXptah ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(monthValueXpath, MonthValue);
					} catch (Exception e) {
						System.out.println("===Unable to select the value===");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(YearValueXpath, YearValue);
					} catch (Exception e) {
						System.out.println("===Unable to select the value===");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(PreferenceCategoryXpath, PreferenceCategory);
					} catch (Exception e) {
						System.out.println("===Unable to select the value===");
					}
					
					
				    try {
						if(isCurrent_CN.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(isCurrent_CNXpath, true);
						}else{
							utilfunc.enableOrDisableCheckbox(isCurrent_CNXpath,false);
						}
					} catch (Exception e1) {}
				    
				    try {
						utilfunc.MakeElement(GovPriorityDate_CNXpath).clear();
						Thread.sleep(300);
						utilfunc.MakeElement(GovPriorityDate_CNXpath).sendKeys(GovPriorityDate_CN);
					} catch (Exception e2) {}
					

				    try {
						if(isCurrent_IN.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(isCurrent_INXpath, true);
						}else{
							utilfunc.enableOrDisableCheckbox(isCurrent_INXpath,false);
						}
					} catch (Exception e1) {}
				    
				    try {
						utilfunc.MakeElement(GovPriorityDate_INXpath).clear();
						Thread.sleep(300);
						utilfunc.MakeElement(GovPriorityDate_INXpath).sendKeys(GovPriorityDate_IN);
					} catch (Exception e2) {}
					
					try {
						if(isCurrent_MX.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(isCurrent_MXXpath, true);
						}else{
							utilfunc.enableOrDisableCheckbox(isCurrent_MXXpath,false);
						}
					} catch (Exception e1) {}
				    
				    try {
						utilfunc.MakeElement(GovPriorityDate_MXXpath).clear();
						Thread.sleep(300);
						utilfunc.MakeElement(GovPriorityDate_MXXpath).sendKeys(GovPriorityDate_MX);
					} catch (Exception e2) {}
					
					try {
						if(isCurrent_PH.equalsIgnoreCase("Yes")){
							utilfunc.enableOrDisableCheckbox(isCurrent_PHXpath, true);
						}else{
							utilfunc.enableOrDisableCheckbox(isCurrent_PHXpath,false);
						}
					} catch (Exception e1) {}
				    
				    try {
						utilfunc.MakeElement(GovPriorityDate_PHXpath).clear();
						Thread.sleep(300);
						utilfunc.MakeElement(GovPriorityDate_PHXpath).sendKeys(GovPriorityDate_PH);
					} catch (Exception e1) {}
					
				
				}
				
				if(mode.equals("Edit")){
					
					
					
					
					try {
						Thread.sleep(500);
						utilfunc.Selectdropdownvaluebytext(SearchYearXpath, Search_Year);
					} catch (Exception e) {}
					
					try {
						Thread.sleep(500);
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
					String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
	            		   utilfunc.scrollToTop();
	            		   try {
							utilfunc.MakeElement(EditIconXpath).click();
						} catch (Exception e) {}
	            	
	            		   

	   					
	   					try{
	   						
	   						utilfunc.MakeElement(AddNewPriorityDateXptah).click();
	   						System.out.println("======Click on the AddNewPriorityDateXptah ======");
	   					}catch(Exception e){
	   						System.out.println("unable to click on add new button");
	   					}
	   					
	   					try {
	   						Thread.sleep(1000);
	   						utilfunc.Selectdropdownvaluebytext(monthValueXpath, MonthValue);
	   					} catch (Exception e) {
	   						System.out.println("===Unable to select the value===");
	   					}
	   					try {
	   						Thread.sleep(1000);
	   						utilfunc.Selectdropdownvaluebytext(YearValueXpath, YearValue);
	   					} catch (Exception e) {
	   						System.out.println("===Unable to select the value===");
	   					}
	   					try {
	   						Thread.sleep(1000);
	   						utilfunc.Selectdropdownvaluebytext(PreferenceCategoryXpath, PreferenceCategory);
	   					} catch (Exception e) {
	   						System.out.println("===Unable to select the value===");
	   					}
	   					
	   					
	   				    try {
	   						if(isCurrent_CN.equalsIgnoreCase("Yes")){
	   							utilfunc.enableOrDisableCheckbox(isCurrent_CNXpath, true);
	   						}else{
	   							utilfunc.enableOrDisableCheckbox(isCurrent_CNXpath,false);
	   						}
	   					} catch (Exception e1) {}
	   				    
	   				    try {
	   						utilfunc.MakeElement(GovPriorityDate_CNXpath).clear();
	   						Thread.sleep(300);
	   						utilfunc.MakeElement(GovPriorityDate_CNXpath).sendKeys(GovPriorityDate_CN);
	   					} catch (Exception e2) {}
	   					

	   				    try {
	   						if(isCurrent_IN.equalsIgnoreCase("Yes")){
	   							utilfunc.enableOrDisableCheckbox(isCurrent_INXpath, true);
	   						}else{
	   							utilfunc.enableOrDisableCheckbox(isCurrent_INXpath,false);
	   						}
	   					} catch (Exception e1) {}
	   				    
	   				    try {
	   						utilfunc.MakeElement(GovPriorityDate_INXpath).clear();
	   						Thread.sleep(300);
	   						utilfunc.MakeElement(GovPriorityDate_INXpath).sendKeys(GovPriorityDate_IN);
	   					} catch (Exception e2) {}
	   					
	   					try {
	   						if(isCurrent_MX.equalsIgnoreCase("Yes")){
	   							utilfunc.enableOrDisableCheckbox(isCurrent_MXXpath, true);
	   						}else{
	   							utilfunc.enableOrDisableCheckbox(isCurrent_MXXpath,false);
	   						}
	   					} catch (Exception e1) {}
	   				    
	   				    try {
	   						utilfunc.MakeElement(GovPriorityDate_MXXpath).clear();
	   						Thread.sleep(300);
	   						utilfunc.MakeElement(GovPriorityDate_MXXpath).sendKeys(GovPriorityDate_MX);
	   					} catch (Exception e2) {}
	   					
	   					try {
	   						if(isCurrent_PH.equalsIgnoreCase("Yes")){
	   							utilfunc.enableOrDisableCheckbox(isCurrent_PHXpath, true);
	   						}else{
	   							utilfunc.enableOrDisableCheckbox(isCurrent_PHXpath,false);
	   						}
	   					} catch (Exception e1) {}
	   				    
	   				    try {
	   						utilfunc.MakeElement(GovPriorityDate_PHXpath).clear();
	   						Thread.sleep(300);
	   						utilfunc.MakeElement(GovPriorityDate_PHXpath).sendKeys(GovPriorityDate_PH);
	   					} catch (Exception e1) {}
	   					
	   				
	   				   
	            		   
	            		   
	            	 }
					
				}

				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}
				catch(Exception e){}
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessageHandlerofGEN();
					//ExpectedErrorMessage=ExpectedErrorMessage.trim();
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

                   if(mode.equalsIgnoreCase("Delete")){
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchYearXpath, Search_Year);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
                  	
                  	 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
		            		   utilfunc.scrollToTop();
	   					System.out.println("Record founded. we are going to delete it.");
	   					try{
	   						Thread.sleep(2000);
	   						
	   						utilfunc.MakeElement(DeleteIconXpath).click();
	   						Thread.sleep(300);
	   						Alert alt= webdriver.switchTo().alert();
	   						alt.accept();
	   						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
	   						String  error_flag="";
	   						try{
	   							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
	   						catch(Exception e){}
	   						Thread.sleep(1000);
	   						System.out.println("error_flag is :"+error_flag);
	   						if (error_flag.equals(ExpectedErrorMessage)){
	   							Flag=true;
	   							utilfunc.TakeScreenshot();
	   						}else if (error_flag.equals("")){
	   							Flag=true;
	   						}else if(error_flag.equals("Server Error in '/' Application.")){
	   							Flag=false;
	   							webdriver.navigate().back();
	   						}
	   						else if(error_flag.contains("Error! An error has occurred. Object")){
	   							Flag=false;
	   							utilfunc.TakeScreenshot();
	   							webdriver.navigate().back();
	   						}
	   						
	   						else{
	   							Flag=false;
	   							utilfunc.TakeScreenshot();
	   						}
	   					}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}
	   				}

                   }
			}

			return Flag;
	      }

}
