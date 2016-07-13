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

public class CIMS_Addional_Questionnaire_Module
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
	 
		public CIMS_Addional_Questionnaire_Module(WebDriver driver,UtilFunction utilfunc) 
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
	 public boolean AddionalQuestionnairePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{	
		 
		 boolean flag=false;
		//AddionalQuestionnairePage	
		 
			//Methods Xpath
		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";
		
		

		
		//String AddionalQuestionnaireSaveButtonXpath=".//*[@id='btnSave']"; 
		
		
		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 0, ColumnCounter);
		String AddionalQuestionnaireScenerio=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 2, ColumnCounter);
		String AddionalQuestionnaireTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 3, ColumnCounter);		
		String AddionalQuestionnairePageURL=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 4, ColumnCounter);
		String AddionalQuestionnaireID=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 5, ColumnCounter);			
		String AddionalQuestionnairetextQ1=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 6, ColumnCounter);
	/*	String AddionalQuestionnaireQ2=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 7, ColumnCounter);
		String AddionalQuestionnaireQ3=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 8, ColumnCounter);
		String AddionalQuestionnaireQ4=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 9, ColumnCounter);
		String AddionalQuestionnaireQ5=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 10, ColumnCounter);
		String AddionalQuestionnaireQ6=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 11, ColumnCounter); 	
		String AddionalQuestionnaireQ7=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 12, ColumnCounter); 
		String AddionalQuestionnaireQ8=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 13, ColumnCounter); 
		String AddionalQuestionnaireQ9=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 14, ColumnCounter); 
		String AddionalQuestionnaireQ10=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 15, ColumnCounter); 
		String AddionalQuestionnaireQ11=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 16, ColumnCounter); 
		String AddionalQuestionnaireQ12=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 17, ColumnCounter);
		String AddionalQuestionnaireQ13=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 18, ColumnCounter);
		String AddionalQuestionnaireQ14=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 19, ColumnCounter);
		String AddionalQuestionnaireQ15=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 20, ColumnCounter);
		String AddionalQuestionnaireQ16=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 21, ColumnCounter);
		String AddionalQuestionnaireQ17=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 22, ColumnCounter);
		String AddionalQuestionnaireQ18=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 23, ColumnCounter);
		String AddionalQuestionnaireQ19=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 24, ColumnCounter);
		String AddionalQuestionnaireQ20=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 25, ColumnCounter);
		String AddionalQuestionnaireQ21=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 26, ColumnCounter);
		String AddionalQuestionnaireQ22=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 27, ColumnCounter);
		String AddionalQuestionnaireQ23=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 28, ColumnCounter);
		String AddionalQuestionnaireQ24=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 29, ColumnCounter);
		String AddionalQuestionnaireQ25=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 30, ColumnCounter);
		String AddionalQuestionnaireQ26=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 31, ColumnCounter);
		String AddionalQuestionnaireQ27=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 32, ColumnCounter);
		String AddionalQuestionnaireQ28=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 33, ColumnCounter);
		String AddionalQuestionnaireQ29=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 34, ColumnCounter);
		String AddionalQuestionnaireQ30=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 35, ColumnCounter);
		String AddionalQuestionnaireQ31=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 36, ColumnCounter);
		String AddionalQuestionnaireQ32=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 37, ColumnCounter);
		String AddionalQuestionnaireQ33=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 38, ColumnCounter);
		String AddionalQuestionnaireQ34=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 39, ColumnCounter);
		String AddionalQuestionnaireQ35=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 40, ColumnCounter);
		String AddionalQuestionnaireQ36=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 41, ColumnCounter);
		String AddionalQuestionnaireQ37=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 42, ColumnCounter);
		String AddionalQuestionnaireQ38=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 43, ColumnCounter);
		String AddionalQuestionnaireQ39=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 44, ColumnCounter);
		String AddionalQuestionnaireQ40=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 45, ColumnCounter);
		String AddionalQuestionnaireQ41=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 46, ColumnCounter);
		String AddionalQuestionnaireQ42=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 47, ColumnCounter);
		String AddionalQuestionnaireQ43=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 48, ColumnCounter);
		String AddionalQuestionnaireQ44=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 49, ColumnCounter);
		String AddionalQuestionnaireQ45=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 50, ColumnCounter);
		String AddionalQuestionnaireQ46=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 51, ColumnCounter);
		String AddionalQuestionnaireQ47=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 52, ColumnCounter);
		String AddionalQuestionnaireQ48=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 53, ColumnCounter);
		
		
		
		String AddionalQuestionnaireQQE_DD=UtilFunction.getCellData("Test Data.xls", "AddionalQuestionnaire", 54, ColumnCounter);
*/
		//String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/label[1]//*[@id]";
		String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']//input[1]";
		String Counter=".//*[@class='question-group']";
		//String Textbox=".//*[@class='form-horizontal']/*[@class='question-group'][xx]/div[2]//textarea";
		String Textbox=".//*[@class='question-group'][xx]//*[@class='control-group'][2]//*[contains(@class,'control-explainationtext')]";
		String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
		String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";
		
		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Additional Questions";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);
		
		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=AddionalQuestionnaireScenerio;
		description=AddionalQuestionnaireTestcaseDescription;
		 String ACTION="New";
		 String ACTION1="Edit";
		 String ACTION2="Delete";
		 
		 if(URLwithID.equals("")){
			 utilfunc.closesidebar();
				Flag=false; 
			 }else{
			 
		 
		 if(mode.equals(ACTION)|mode.equals(ACTION1)){
			 try{
				 /*String AddionalQuestionnaireURLwithID=AddionalQuestionnairePageURL+AddionalQuestionnaireID;
				 
				 utilfunc.NavigatetoURL(AddionalQuestionnaireURLwithID);*/
				 
				 try{
					 utilfunc.NavigatetoURL(URLwithID);
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(2000);
					 }catch(Exception error){}
				 
				 
				 
				 String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
				 String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
				 Usernametext=Usernametext+Usernametypetext;
					
				 int ObjCount=utilfunc.GetObjectCount(Counter);
				 
				 	try{			 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 try{
								 String NewRadio=Radio.replace("xx", Integer.toString(count));
								 Thread.sleep(1000);
								try{ utilfunc.MakeElement(NewRadio).click();
								 try{
									 String NewTextbox=Textbox.replace("xx", Integer.toString(count));
									 String Questionnaire="AddionalQuestionnairetextQ"+count;
									 utilfunc.MakeElement(NewTextbox).clear();
									 utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
								 }catch(Exception f){}
								}catch(Exception e){}
							 }catch(Exception f){}
		 
						 }
				 	}catch(Exception error){}


						 //function to call the dynamic text data
					try{
						utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
						}catch(Exception error){}

					 	 /*String SaveButtonXpath=".//*[@id='btnSave']";					
					     utilfunc.MakeElement(SaveButtonXpath).click();*/
					 	utilfunc.savebutton();

					     boolean error_flag=utilfunc.ErrorMessagehandler();
						 if (error_flag){
							 Flag=true;
						 }else{
							 Flag=false;
						 }
			
				 }
			 catch(Exception e){

				 System.out.println("Exception ---->"+e);

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
						utilfunc.ErrorMessage2="Delete option is not Implimented in Additional Questionnaire Module.";
						utilfunc.TakeScreenshot();
						Flag=false;
				}			
			 
		 }
		 
			 }///////////url ckeck end
		 
		return Flag;
	 	}	

}


