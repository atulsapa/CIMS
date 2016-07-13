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

public class CIMS_Additional_Medical_History_Module
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
	 
		public CIMS_Additional_Medical_History_Module(WebDriver driver,UtilFunction utilfunc) 
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
	 public boolean Additional_Medical_HistoryPage(int ColumnCounter, String mode) throws AWTException, InterruptedException
	 	{	
		 
		 boolean flag=false;
		//AddionalQuestionnairePage	
		 
			//Methods Xpath
		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";
		
		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 0, ColumnCounter);
		String Additional_Medical_HistoryScenerio=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 2, ColumnCounter);
		String Additional_Medical_HistoryTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 3, ColumnCounter);		
		String Additional_Medical_HistoryPageURL=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 4, ColumnCounter);
		String Additional_Medical_HistoryID=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 5, ColumnCounter);			
		String Additional_Medical_HistoryQ1=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 6, ColumnCounter);
		String GAdditional_Medical_HistoryQ2=UtilFunction.getCellData("Test Data.xls", "Additional_Medical-history", 7, ColumnCounter);
		
		String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/label[1]";
		String Counter=".//*[@class='question-group']";
		String Textbox=".//*[@class='question-group'][xx]/div[2]//textarea";
		
		//Additional info handle XPATH
		String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
		String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";
		
		/////////////////////////////////URL FETCH///////////////////////////////////		
		String QuestionarieName="Additional Medical History";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		 URLwithID=utilfunc.geturldirect(QuestionarieName);
		
		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Additional_Medical_HistoryScenerio;
		description=Additional_Medical_HistoryTestcaseDescription;
	
		 String ACTION="New";
		 String ACTION1="Edit";
		 String ACTION2="Delete";
		 
		 if(URLwithID.equals("")){
			 utilfunc.closesidebar();
				Flag=false; 
			 }else{
		 
		 if(mode.equals(ACTION)){
			 try{
				/* String dditional_Medical_HistoryURLwithID=Additional_Medical_HistoryPageURL+Additional_Medical_HistoryID;
				 
				 utilfunc.NavigatetoURL(dditional_Medical_HistoryURLwithID);*/
				 
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
				 String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
				 Usernametext=Usernametext+Usernametypetext;
		
					 int ObjCount=utilfunc.GetObjectCount(Counter);
				
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewRadio=Radio.replace("xx", Integer.toString(count));
							 utilfunc.MakeElement(NewRadio).click();
							 String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							 String Questionnaire="Global Q"+count;
							 utilfunc.MakeElement(NewTextbox).clear();
							 utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
							 				 
						 }
							
					 }
				 catch(Exception e){
							  
				 }
		
					//function to call the dynamic text data
					utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
					utilfunc.savebutton();
					 
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
		 }else if(mode.equals(ACTION1)){
			 try{
				 /*String dditional_Medical_HistoryURLwithID=Additional_Medical_HistoryPageURL+Additional_Medical_HistoryID;
				 
				 utilfunc.NavigatetoURL(dditional_Medical_HistoryURLwithID);*/
				
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
				 String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
				 Usernametext=Usernametext+Usernametypetext;
			
				  int ObjCount=utilfunc.GetObjectCount(Counter);
					
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewRadio=Radio.replace("xx", Integer.toString(count));
							 utilfunc.MakeElement(NewRadio).click();
							 String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							 String Questionnaire="Global Q"+count;
							 utilfunc.MakeElement(NewTextbox).clear();
							 utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
							 				 
						 }
							
					 }
				 catch(Exception e){
							  
				 }
					
					//function to call the dynamic text data
					utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/

					utilfunc.savebutton();
					
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
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
					
					String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					utilfunc.MakeElement(deletexpath).click();
					utilfunc.isAlertPresent();
					
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
						utilfunc.ErrorMessage2="Delete option is not Implimented in Additional Medical History Module.";
						utilfunc.TakeScreenshot();
						Flag=false;
				}			
			 
		 }
		 
		 
	 	 }///////////url ckeck end
			 
		return Flag;
	 	}	

}


