package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Survey_Search {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	public CIMS_Survey_Search(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	public boolean Survey_Search(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

		boolean Flag	=	false;

		System.out.println("user is on '"+sheetName+"' module...");
		System.out.println("entering "+mode+" mode for "+sheetName+" module.");

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String SearchText							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Email							            =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String BalNumber							        =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String AttorneySearchText							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String AssistantSearchText							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String NPSearchText							        =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String GetCompanyId							        =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String DestinationCountryCode		                =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String CompletedStatus							    =			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String FromDate							            =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String ToDate							            =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String ProjectName							        =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String RecommendScore							    =			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);


		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);


		testcaseid=TestcaseID;
		scenerio=Scenario;
		description=TestCaseDescription;


		if(TestcaseRunMode.equals("Y")){


			String SurveySearchCounterXPath		=	".//*[@id='panel-body-container']//*[contains(@class,'projectSearchFields')]//div//.[contains(@class,'form-horizontal')]";
			String SurveySearchXPath				=	".//*[@id='panel-body-container']//*[contains(@class,'projectSearchFields')]//div[xx]//.[contains(@class,'form-horizontal')]";
			int numberOfSurveySearchFieldCounter		=	0;
			int innerFieldCounter						=	0;


			String AttributeId;

			try {
				try{
					numberOfSurveySearchFieldCounter		=		utilfunc.GetObjectCount(SurveySearchCounterXPath);
				}catch(Exception e){
					System.out.println("unable to get row count of advanced employee search");

				}
				if(numberOfSurveySearchFieldCounter>0){

					for (int j = 1; j <= numberOfSurveySearchFieldCounter; j++) {

						Thread.sleep(2000);
						String newCounterXPath		=	SurveySearchXPath.replace("xx", Integer.toString(j));
						String innerxpth=newCounterXPath;

						// now let us find out counter inside each row of counter..
						newCounterXPath				=	newCounterXPath + "//*[@name]";

						System.out.println("new counter xpath: "+newCounterXPath);
						//String RowXpath =newCounterXPath;

						try {
							AttributeId					=		utilfunc.MakeElement(newCounterXPath).getAttribute("id");

						//	if(AttributeId.equals("SearchText")){
								// now run again for inner loops
								innerFieldCounter			=	utilfunc.GetObjectCount(newCounterXPath);


								if(innerFieldCounter>0){
									for (int i = 1; i <= innerFieldCounter; i++) {
										try{
											Thread.sleep(2000);
											String atrbut_id	=	"";
											String inner_xpath	=	innerxpth+"/div["+i+"]//*[@name]";
											try{
												atrbut_id			=	utilfunc.MakeElement(inner_xpath).getAttribute("id");
												System.out.println("attribute id is: "+atrbut_id);
												System.out
												.println("inner_xpath is" + inner_xpath);
												if(atrbut_id.equals("SearchText")){
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(SearchText);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
													
													
												}else if(atrbut_id.equals("Email")){
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(Email);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
													
													
												}
												
												
												else if(atrbut_id.equals("BalNumber")){
													// now set Name value..
													try {
														Thread.sleep(2000);
														utilfunc.MakeElement(inner_xpath).clear();
														utilfunc.MakeElement(inner_xpath).sendKeys(BalNumber);
													} catch (Exception e) {
														System.out.println("unable to place value in text box.");
													}
													
												}
												else if(atrbut_id.equals("AttorneySearchText")){
													utilfunc.MakeElement(inner_xpath).clear();
													try {
														utilfunc.MakeElement(inner_xpath).sendKeys(AttorneySearchText);
													} catch (Exception e) {System.out
															.println("Unable to enter the value");}
													
												}else if(atrbut_id.equals("AssistantSearchText")){
													utilfunc.MakeElement(inner_xpath).clear();
													try {
														utilfunc.MakeElement(inner_xpath).sendKeys(AssistantSearchText);
													} catch (Exception e) {System.out
															.println("Unable to enter the value");}
													
												}
												else if(atrbut_id.equals("NPSearchText")){
													utilfunc.MakeElement(inner_xpath).clear();
													try {
														utilfunc.MakeElement(inner_xpath).sendKeys(NPSearchText);
													} catch (Exception e) {System.out
															.println("Unable to enter the value");}
													
												}
												else if(atrbut_id.equals("GetCompanyId")){
													utilfunc.MakeElement(inner_xpath).clear();
													try {
														utilfunc.MakeElement(inner_xpath).sendKeys(GetCompanyId);
													} catch (Exception e) {System.out
															.println("Unable to enter the value");}
													
												}
												else if(atrbut_id.equals("DestinationCountryCode")){
													//utilfunc.MakeElement(inner_xpath).clear();
													try
													{
														utilfunc.Selectdropdownvaluebytext(inner_xpath, DestinationCountryCode);
													}catch(Exception error){}
												}
												else if(atrbut_id.equals("CompletedStatus")){
													//utilfunc.MakeElement(inner_xpath).clear();
													try
													{ 
														utilfunc.Selectdropdownvaluebytext(inner_xpath, CompletedStatus);
													}catch(Exception error){}
												}
												else if(atrbut_id.equals("FromDate")){
													utilfunc.MakeElement(inner_xpath).clear();
													try
													{
														utilfunc.MakeElement(inner_xpath).sendKeys(FromDate);
													}catch(Exception error){}
												}else if(atrbut_id.equals("ToDate")){
													utilfunc.MakeElement(inner_xpath).clear();
													try
													{
														utilfunc.MakeElement(inner_xpath).sendKeys(ToDate);
													}catch(Exception error){}
												}
												else if(atrbut_id.equals("ProjectName")){
													//utilfunc.MakeElement(inner_xpath).clear();
													try
													{
														utilfunc.Selectdropdownvaluebytext(inner_xpath, ProjectName);
													}catch(Exception error){}
												}
												else if(atrbut_id.equals("RecommendScore")){
													//utilfunc.MakeElement(inner_xpath).clear();
													try
													{
														utilfunc.Selectdropdownvaluebytext(inner_xpath, RecommendScore);
													}catch(Exception error){}
												}
												
											}catch(Exception error){}
										}catch(Exception error){System.out.println("unable to get inner field");}
									}	
								}
							//}
						} catch (Exception e) {System.out.println("unable to get attribute id");}

					}




				}
			} catch (Exception e) {System.out.println("unable to get row xpath");}
			
			String SearchbtnXpath=".//*[contains(@class,'btn') and text()='Search ']";
			
			try {
				utilfunc.MakeElement(SearchbtnXpath).click();
			} catch (Exception e) {System.out.println("Unable to click on the search button ");}
			
			
			
		 String NorecordXpath=".//*[@id='dvUserList']/div/table/tbody/tr[2]/td";
       	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();

       	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
       		  
       		Flag=false;
					return Flag;
       	   }else{
       		   utilfunc.scrollToTop();
       		String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[3]";
       		
       		try {
				utilfunc.MakeElement(EditIconXpath).click();
			} catch (Exception e) {System.out.println("Unable to click on the link");}
       		try{
       		System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
			String error_flag=utilfunc.PoclassificationErrorMessageHandler();
			ExpectedErrorMessage=ExpectedErrorMessage.trim();
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

		return Flag;
	}

}
