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

public class CIMS_Teacher_ChildHealthCare_Module
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

	public CIMS_Teacher_ChildHealthCare_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean Teacher_ChildHealthCarePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		boolean flag=false;
		//AddionalQuestionnairePage	

		//Methods Xpath
		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";




		//String AddionalQuestionnaireSaveButtonXpath=".//*[@id='btnSave']"; 


		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 0, ColumnCounter);
		String Teacher_ChildHealthCareScenerio=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 2, ColumnCounter);
		String Teacher_ChildHealthCareTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 3, ColumnCounter);		
		String Teacher_ChildHealthCarePageURL=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 4, ColumnCounter);
		String Teacher_ChildHealthCareID=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 5, ColumnCounter);			
		String Teacher_ChildHealthCaretextQ1=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 6, ColumnCounter);
		String Teacher_ChildHealthCareQ2=UtilFunction.getCellData("Test Data.xls", "Teacher_ChildHealthCare", 7, ColumnCounter);


		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Teacher, Child Care, or Health Care";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Teacher_ChildHealthCareScenerio;
		description=Teacher_ChildHealthCareTestcaseDescription;

		String Module="New";
		String Module1="Edit";
		String Module2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(Module)){
				try{
					/*String Teacher_ChildHealthCareURLwithID=Teacher_ChildHealthCarePageURL+Teacher_ChildHealthCareID;

				 utilfunc.NavigatetoURL(Teacher_ChildHealthCareURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
					String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
					Usernametext=Usernametext+Usernametypetext;


					String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();

					String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/input[1]";
					String Counter=".//*[@class='question-group']";
					String Textbox=".//*[@class='question-group'][xx]/div[2]//textarea";
					int ObjCount=utilfunc.GetObjectCount(Counter);


					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewRadio=Radio.replace("xx", Integer.toString(count));
						try{
							Thread.sleep(1000);
							utilfunc.MakeElement(NewRadio).click();
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="Teacher_ChildHealthCaretextQ"+count;
							try
							{
								utilfunc.MakeElement(NewTextbox).clear();
								utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
							}catch(Exception error){}	 
						}catch(Exception error){}

					}

					String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
					String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					}catch(Exception error){}

					try{utilfunc.savebutton();
					}catch(Exception error){}

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}


				}

				catch(Exception e){

				}
			}else if(mode.equals(Module1)){
				try{
					/*String Teacher_ChildHealthCareURLwithID=Teacher_ChildHealthCarePageURL+Teacher_ChildHealthCareID;

				 utilfunc.NavigatetoURL(Teacher_ChildHealthCareURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
					String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
					Usernametext=Usernametext+Usernametypetext;


					String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();

					String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/label[1]";
					String Counter=".//*[@class='question-group']";
					String Textbox=".//*[@class='question-group'][xx]/div[2]//textarea";
					int ObjCount=utilfunc.GetObjectCount(Counter);


					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewRadio=Radio.replace("xx", Integer.toString(count));
						try{
							Thread.sleep(1000);
							utilfunc.MakeElement(NewRadio).click();
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="Teacher_ChildHealthCaretextQ"+count;
							try{
								utilfunc.MakeElement(NewTextbox).clear();
								utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
							}catch(Exception error){}
						}catch(Exception error){}

					}
					String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
					String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					}catch(Exception error){}
					
					try{
					utilfunc.savebutton();
					}catch(Exception error){}
					
					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}


				}

				catch(Exception e){

				}
			}else if(mode.equals(Module2)){

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
				}catch(Exception error){}
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			

			}
		}///////////url ckeck end
		return Flag;
	}	
}