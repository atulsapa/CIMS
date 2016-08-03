package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_MostRecentTopTen_project {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
	 

	      public CIMS_MostRecentTopTen_project(WebDriver driver,UtilFunction utilfunc) {
	    	  
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
			String ProjectNo						            =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String MostRecentprojectno                          =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			String ProjectName						            =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String MostRecentProjectName						=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			
			
			String ExpectedErrorMessage      				    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				boolean PojectNoMatchFlag= false;
				boolean ProjectNameFlag  =false;
				
				String error_flag                ="";
				String error_msg                ="";
				String sliderIcon =".//*[@id='slider-icon']";
				String Mostrecent_Xpath=".//*[contains(@id,'quickLinkHeader')]//.[contains(text(),'Recent Queries')]";
				if(mode.equals("New")){
					
					
					try {
						Thread.sleep(2000);
						utilfunc.MakeElement(sliderIcon).click();
					
						Thread.sleep(2000);
						} catch (Exception e1) {
						System.out.println("Unable to click on the slider icon");
					}
					
					String ProjectnoXpath =".//*[@id='right-nav']//*[@class='sub-menu']//ul//li[1]//a";
					
					try {
						Thread.sleep(2000);
						utilfunc.MakeElement(ProjectnoXpath).click();
						Thread.sleep(2000);
					} catch (Exception e1) {
						System.out.println("unable to click on the ");
					}
					// click on link
					try{
						Thread.sleep(1000);
						utilfunc.MakeElement(Mostrecent_Xpath).click();
						Thread.sleep(1000);
					}catch(Exception e){
						System.out.println("unable to click on employee icons");
					}
					String projectLink=".//*[@id='quickLinksContainer']/ul[1]/li[text()='Projects']";
					
					try {
						Thread.sleep(3000);
						utilfunc.MakeElement(projectLink).click();
						Thread.sleep(3000);
					} catch (Exception e) {
						System.out.println("Unable to click on the on the link");
					}
					
//					String CounterXpath =".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]";
//					String FieldXpath =".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')][xx]//*[@class='ng-binding']";
//					//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]//*[contains(text(),'@@@@ !!!')]
					String MatchTextXpathProjectNO	=	".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]//*[contains(text(),'"+ProjectNo+"')]";
					String MatchTextXpathProjectName	=	".//*[@id='quickLinksContainer']//*[contains(@class,'ng-scope')]//*[contains(text(),'"+ProjectName+"')]";
			//		int resultCount			=	utilfunc.GetObjectCount(CounterXpath);
					
					try {
						PojectNoMatchFlag  =	utilfunc.MakeElement(MatchTextXpathProjectNO).toString() != null;
						//ProjectNameFlag  =	utilfunc.MakeElement(MatchTextXpathProjectNO).toString() != null;
						
						
						
						System.out.println(MatchTextXpathProjectNO);
						
						
						if(PojectNoMatchFlag==true){
							
							if(MatchTextXpathProjectNO.equals(MostRecentprojectno)){
								
								System.out.println("Value has been matched");
								
							}else{
							   System.out.println("Value has not been matched");	
							}
							
							
							
							
							
						}
					} catch (Exception e) {
						System.out.println(PojectNoMatchFlag);
					}
					
//					if(ProjectNameFlag==true){
//						
//						if(MatchTextXpathProjectName.equals(MostRecentProjectName)){
//							
//							System.out.println("Value has been matched");
//							
//						}else{
//						   System.out.println("Value has not been matched");	
//						}
//						
//						
//					}
					
				}
				if(PojectNoMatchFlag==true || !ProjectNameFlag==true ){
					Flag=true;
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
						utilfunc.TakeScreenshot();
					}

				}
			
			
			
			}
			
			
			return Flag;
			
			}
		
	
	      




}
