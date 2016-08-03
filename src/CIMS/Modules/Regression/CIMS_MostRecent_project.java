package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_MostRecent_project {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	 public CIMS_MostRecent_project(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 

	      public boolean Most_Recent(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module.");
			System.out.println("entering "+mode+" mode for "+sheetName+" module..");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Profile_UserName							    =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String MostRecentUserName                           =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ExpectedErrorMessage      				    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				boolean MatchFlag= false;
				
				String error_flag                ="";
				String error_msg                ="";
				
				if(mode.equals("New")){
					
					String peopleLink=".//*[@id='quickLinksContainer']/ul[1]/li[text()='People']";
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(peopleLink).click();
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Unable to click on the on the link");
					}
					
					String CounterXpath =".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]";
					String FieldXpath =".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')][xx]//*[@class='ng-binding']";
					//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]//*[contains(text(),'@@@@ !!!')]
					String MatchTextXpath	=	".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]//*[contains(text(),'"+Profile_UserName+"')]";	
					int resultCount			=	utilfunc.GetObjectCount(CounterXpath);
					
					try {
						MatchFlag  =	utilfunc.MakeElement(MatchTextXpath).toString() != null;
						
						System.out.println(MatchTextXpath);
						
						
						if(MatchFlag==true){
							
							if(MatchTextXpath.equals(MostRecentUserName)){
							
								
								System.out.println("Value has been matched");
								
							}else{
								
								System.out.println("Value is not matching");
							}
							
							
							
							
							
						}
					} catch (Exception e) {
						System.out.println("MatchFlag"+MatchFlag);
					}
					
				}
				if(MatchFlag==true){
					Flag=true;
					try {
						Thread.sleep(1500);
					
						utilfunc.MakeElement(".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')][1]//a").click();
					
						Thread.sleep(1500);
					} catch (Exception e) {
					  System.out.println("Unable to click on the link");
					}
				}
				else
				{
					System.out.println("Please wait we are checking for error... ... ...");
					try{
						error_flag=utilfunc.ErrorMessagehandlerExperiment();
					}
					catch(Exception e){}
					
					System.out.println("We are done with error check.");
					System.out.println("error_flag---"+error_flag);
					if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						utilfunc.TakeScreenshot();
					}
					else if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}
					else if (error_msg.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.globalerrormessage=error_msg;
						utilfunc.ErrorMessage4=error_msg;
						utilfunc.TakeScreenshot();
						Thread.sleep(1000);
					}
					else
					{
						Flag=false;
						
						try {
							Thread.sleep(1500);
						
							utilfunc.MakeElement(".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')][1]//a").click();
						
							Thread.sleep(1500);
						} catch (Exception e) {
						  System.out.println("Unable to click on the link");
						}
						utilfunc.TakeScreenshot();
					}
					

				}
			
			
			
			}
			
			
			return Flag;
			
			}
	      


}
