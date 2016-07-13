package CIMS.Modules.GlobalCheck;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Query_History {
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Query_History(WebDriver driver,UtilFunction utilfunc) {
	    	  {
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    			}
         	}


		public boolean Query_History(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String DateOfArrival							    =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String DateOfDeparture							    =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ResultVerified_13385							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String txtNote_13385							    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				String FieldCounter=".//*[@class='form-horizontal']//table//tbody//tr//*[contains(@class,'Form3')]//*[@name]";
				String NewfieldXpath =".//*[@class='form-horizontal']//table//tbody//tr[xx]//*[contains(@class,'Form3')]//*[@name]";
				String NewXpath;
				String AttributeName;
				
				if(mode.equals("New")|| mode.equals("Edit")){
					
					String SearchDateOfArrival=".//*[@id='DateOfArrival']";
					String SearchDateOfDeparture=".//*[@id='DateOfDeparture']";
					
					String SearchBtn=".//*[contains(@class,'btn') and text()='Search ']";
					
					try {
						utilfunc.MakeElement(SearchDateOfArrival).clear();
						utilfunc.MakeElement(SearchDateOfArrival).sendKeys(DateOfArrival);
					} catch (Exception e) {
						
					}
					
					try {
						utilfunc.MakeElement(SearchDateOfDeparture).clear();
						utilfunc.MakeElement(SearchDateOfDeparture).sendKeys(DateOfDeparture);
					} catch (Exception e) {
						
					}
					
					try {
						Thread.sleep(2000);
						
						utilfunc.MakeElement(SearchBtn).click();
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.println("Unable to click on the search button");
					}
					
					
					
					try {
						String NorecordXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//*[@id='visacase-list-header']/tbody/tr[1]";
						 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
						 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
							  
							Flag=false;
							return Flag;
						   }else{
							   
							   String FirstRecordXpath =".//*[@id='serachpanel']//tbody//tr[1]//td[2]//a";
								
								try {
									Thread.sleep(2000);
									utilfunc.MakeElement(FirstRecordXpath).click();
									Thread.sleep(2000);
								} catch (Exception e) {
									System.out.println("Unable to find the link");
								}
								
								
								
								int resultCount			=	utilfunc.GetObjectCount(FieldCounter);
								
								for(int i=1; i<=resultCount; i++){
									
									try {
										Thread.sleep(3000);
										
										NewXpath	=	NewfieldXpath.replace("xx",Integer.toString(i));
										AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
										System.out.println("Attribute Name is" + " " + AttributeName);
										System.out.println("New Xpath is:" + " "+ NewXpath);
										
										if(AttributeName.equals("ResultVerified_13385")){
											
											try {
												Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebytext(NewXpath, ResultVerified_13385);
											
												Thread.sleep(1000);
												} catch (Exception e) {
												System.out.println("Unable to select the value ");
											}
											
										}else if(AttributeName.equals("txtNote_13385")){
											
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(txtNote_13385);
										}
									
									
									
									} catch (Exception e) {

										System.out.println("Record not found");
									}
									
									
								}
								
								
							   
						   }
					} catch (Exception e) {
						System.out.println("I m here");
					}
					
					
					
					
					
				}
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
//				try {
//					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
//					utilfunc.MakeElement(updateBtnXpath).click();
//				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.GCPQuryHistoryErrorMessageHandler();
					ExpectedErrorMessage=ExpectedErrorMessage.trim();
				//	System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.equals("")){
						 Flag=true;
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
					 }else if(error_flag.equals("Server Error in '/' Application..")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else if(error_flag.contains("Error! This role name is already existed.")){
						 Flag= false;
						 utilfunc.TakeScreenshot();
						 webdriver.navigate().back();
						 
					 }
					 else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
					
			}
				
				
		
			
			}
		
		
		return Flag;
}
}
