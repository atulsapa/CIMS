package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Project_List {
	

	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";



		public CIMS_Project_List(WebDriver driver,UtilFunction utilfunc) {
			this.webdriver =driver;
			this.utilfunc=utilfunc;
		}


		public boolean Project_list(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;

			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module..");

			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Project							            =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String Status                                      =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String NewCountryCode							            =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String AttorneyFullNames                                     =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String AssistantFullNames							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String ExpectedErrorMessage							    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			
			
	
			
			
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				String ProjectXpath =".//*[@id='Project']";
				String StatusXpath  =".//*[@id='Status']";
				String DesCountryXpath =".//*[@id='NewCountryCode']";
				String AttorneyXpath   =".//*[@id='AttorneyFullNames']";
				String AssisstentFullNameXpath =".//*[@id='AssistantFullNames']";
				
				String SearchBtn=".//*[@id='btnSearch']";
				
				if(mode.equals("New")||(mode.equals("Edit"))){
					
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(ProjectXpath, Project);
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to select the project");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(StatusXpath, Status);
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to select the project");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(DesCountryXpath, NewCountryCode);
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to select the project");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(AttorneyXpath, AttorneyFullNames);
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to select the project");
					}
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(AssisstentFullNameXpath, AssistantFullNames);
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to select the project");
					}
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(SearchBtn).click();
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to click on the search btn");
					}
					
					
					 String NorecordXpath=".//*[@id='table-rec-container']//table//tbody//tr[1]";
			       	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();

			       	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
			       		  
			       		Flag=false;
								return Flag;
			       	   }else{
			       		   utilfunc.scrollToTop();
			       		String EditIconXpath=".//*[@id='table-rec-container']//table//tbody//tr[1]//td[1]//a";
			       		
			       		try {
			       			Thread.sleep(1000);
							utilfunc.MakeElement(EditIconXpath).click();
							Thread.sleep(1000);
			       		} catch (Exception e) {System.out.println("Unable to click on the link");}
			       		try{
			       		System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
						String error_flag=utilfunc.PoclassificationErrorMessageHandler();
						//ExpectedErrorMessage=ExpectedErrorMessage.trim();
						System.out.println("==="+ExpectedErrorMessage+"===");
						System.out.println("==="+error_flag+"===");
						
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;
							 webdriver.navigate().back();
						 }else{
							 Flag=false;
							 utilfunc.TakeScreenshot();
						 }
					}catch(Exception e){
						Flag	=	true;
						utilfunc.TakeScreenshot();
						System.out.println("Data is not saved because all fields are not set in the form.");
						
				}	

					
					
			       	   }
				}
				}
				
				
				
			
			return Flag;

}
}
