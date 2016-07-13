package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Global_Immigration_History_Module
{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------
	public static String Deletecheck="";
	public static String ErrorMessage="";
	public static String ErrorMessage1="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	//Constructor----------

	public CIMS_Global_Immigration_History_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

	}


	//Functions--------------
	/**
	 * Verify that User is able to landed on the Project Initiation Page
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean Global_Immigration_HistoryPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		boolean flag=false;
		//AddionalQuestionnairePage	

		//Methods Xpath
		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 0, ColumnCounter);
		String GlobalImmigrationHistoryScenerio=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 2, ColumnCounter);
		String GlobalImmigrationHistoryTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 3, ColumnCounter);		
		String GlobalImmigrationHistoryPageURL=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 4, ColumnCounter);
		String GlobalImmigrationHistoryID=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 5, ColumnCounter);			
		String GlobalImmigrationHistorytextQ1=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 6, ColumnCounter);
		String GlobalImmigrationHistoryQ2=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 7, ColumnCounter);
		String GlobalImmigrationHistoryQ3=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 8, ColumnCounter);
		String GlobalImmigrationHistoryQ4=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 9, ColumnCounter);
		String GlobalImmigrationHistoryQ5=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 10, ColumnCounter);
		String GlobalImmigrationHistoryQ6=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 11, ColumnCounter); 	
		String GlobalImmigrationHistoryQ7=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 12, ColumnCounter); 
		String GlobalImmigrationHistoryQ8=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 13, ColumnCounter); 
		String GlobalImmigrationHistoryQ9=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 14, ColumnCounter); 
		String GlobalImmigrationHistoryQ10=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 15, ColumnCounter); 
		String GlobalImmigrationHistoryQ11=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 16, ColumnCounter); 
		String GlobalImmigrationHistoryQ12=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 17, ColumnCounter);
		String GlobalImmigrationHistoryQ13=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 18, ColumnCounter);
		String AddionalQuestionnaireQQE_DD=UtilFunction.getCellData("Test Data.xls", "Global_Immigration_History", 19, ColumnCounter);

		String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/label[1]";
		String Counter=".//*[@class='question-group']";
		String Textbox=".//*[@class='question-group'][xx]/div[2]//textarea";

		String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
		String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Global Immigration History";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=GlobalImmigrationHistoryScenerio;
		description=GlobalImmigrationHistoryTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String GlobalImmigrationHistoryURLwithID=GlobalImmigrationHistoryPageURL+GlobalImmigrationHistoryID;

				 utilfunc.NavigatetoURL(GlobalImmigrationHistoryURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
					String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
					Usernametext=Usernametext+Usernametypetext;
					//Reporter.log("User is : "+Usernametext);

					String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();
					//Reporter.log("User Country is : "+UsernameCountrytext);



					int ObjCount=utilfunc.GetObjectCount(Counter);



					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewRadio=Radio.replace("xx", Integer.toString(count));
						try{
							Thread.sleep(1000);
							utilfunc.MakeElement(NewRadio).click();
							Thread.sleep(500);
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="Global Q"+count;
							utilfunc.MakeElement(NewTextbox).clear();
							utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
						}catch(Exception error){}			 
					}
				}catch(Exception e){}

				//function to call the dynamic text data
				try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2); 
				}catch(Exception e){}

				try{utilfunc.savebutton();
				}catch(Exception e){}

				boolean error_flag=utilfunc.ErrorMessagehandler();
				if (error_flag){
					Flag=true;
				}else{
					Flag=false;
				}


			}else if(mode.equals(ACTION1)){
				try{
					/*String GlobalImmigrationHistoryURLwithID=GlobalImmigrationHistoryPageURL+GlobalImmigrationHistoryID;

				 utilfunc.NavigatetoURL(GlobalImmigrationHistoryURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler(); 
					Thread.sleep(2000);

					String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
					String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
					Usernametext=Usernametext+Usernametypetext;
					//Reporter.log("User is : "+Usernametext);

					String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();
					//Reporter.log("User Country is : "+UsernameCountrytext);


					int ObjCount=utilfunc.GetObjectCount(Counter);



					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						try{
							String NewRadio=Radio.replace("xx", Integer.toString(count));
							Thread.sleep(1000);
							utilfunc.MakeElement(NewRadio).click();
							Thread.sleep(500);
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="Global Q"+count;
							utilfunc.MakeElement(NewTextbox).clear();
							utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
						}catch(Exception e){}			 
					}


					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2); 
					}catch(Exception e){}

					try{
						utilfunc.savebutton();
					}catch(Exception e){}

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}
				}catch(Exception e){}	 
			}else if(mode.equals(ACTION2)){

				try{	
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);					

					String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(deletexpath).click();
						Thread.sleep(3000);
						utilfunc.isAlertPresent();
					}catch(Exception e){}	

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}
				}catch(Exception z){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					Deletecheck="Delete";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					utilfunc.ErrorMessage2="Delete option is not Implimented in Global Immigration History Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			
			}			//////flag  check////
		}///////////url ckeck end
		return Flag;
	}
}