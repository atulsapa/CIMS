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

public class CIMS_Other_Name_Module
{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------

	public static String Deletecheck="Delete";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	//Constructor----------

	public CIMS_Other_Name_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}


	//Functions--------------
	/**
	 * Verify that User is able to landed on the Project Initiation Page
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean OtherNamePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Basic Information Page	

		//Methods Xpath
		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";

		String OtherNameFirstNameXpath="//*[@id='FirstName']";
		String OtherNameMiddleNameXpath="//*[@id='MiddleName']";
		String OtherNameLastNameXpath="//*[@id='LastName']";
		String OtherNameTypeofNameXpath="//*[@id='TypeOfName']";
		String OtherNameSaveButtonXpath="//*[@id='btnSave']";



		String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Other_Name", 0, ColumnCounter);
		String OtherNameScenerio=UtilFunction.getCellData("Test Data.xls", "Other_Name", 2, ColumnCounter);
		String OtherNameTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Other_Name", 3, ColumnCounter);		
		String OtherNamePageURL=UtilFunction.getCellData("Test Data.xls", "Other_Name", 4, ColumnCounter);
		String OtherNameID=UtilFunction.getCellData("Test Data.xls", "Other_Name", 5, ColumnCounter);			

		String OtherNameFirstName=UtilFunction.getCellData("Test Data.xls", "Other_Name", 6, ColumnCounter);
		String OtherNameMiddleName=UtilFunction.getCellData("Test Data.xls", "Other_Name", 7, ColumnCounter);
		String OtherNameLastName=UtilFunction.getCellData("Test Data.xls", "Other_Name", 8, ColumnCounter);
		String OtherNameTypeofName=UtilFunction.getCellData("Test Data.xls", "Other_Name", 9, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Other_Name", 10, ColumnCounter);

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Other Names";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=OtherNameScenerio;
		description=OtherNameTestcaseDescription;

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
					/*String OtherNameURLwithID=OtherNamePageURL+OtherNameID;

				 utilfunc.NavigatetoURL(OtherNameURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String AddbuttonXpath="//*[@class='btn']";
					try{
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);

						String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
						String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
						Usernametext=Usernametext+Usernametypetext;
						//Reporter.log("User is : "+Usernametext);

						String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();
						//Reporter.log("User Country is : "+UsernameCountrytext);


						try{utilfunc.MakeElement(OtherNameFirstNameXpath).sendKeys(OtherNameFirstName);
						}catch(Exception e){}

						try{utilfunc.MakeElement(OtherNameMiddleNameXpath).sendKeys(OtherNameMiddleName);
						}catch(Exception e){}

						try{utilfunc.MakeElement(OtherNameLastNameXpath).sendKeys(OtherNameLastName);
						}catch(Exception e){}

						try{utilfunc.Selectdropdownvaluebyvalue(OtherNameTypeofNameXpath, OtherNameTypeofName);
						}catch(Exception e){}

						//////////////////////Additional info handle///////////////////////////////
						try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
						}catch(Exception e){}

						//Submit the page with details
						try{utilfunc.savebutton();
						}catch(Exception e){}

						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						if (error_flag.equals(ExpectedErrorMessage)){
							Flag=true;
							utilfunc.TakeScreenshot();
						}else if (error_flag.equals("")){
							Flag=true;
						}else if(error_flag.equals("Server Error in '/' Application.")){
							Flag=false;
							webdriver.navigate().back();
						}else{
							Flag=false;
							utilfunc.TakeScreenshot();
						}
					}catch(Exception error)
					{utilfunc.NavigatetoURL(URLwithID);
					}
					//Reporter.log("---------------------------------------------------------------------------------------");
				}
				catch(Exception e){
				}

			}else if(mode.equals(ACTION1)){
				try{
					/*String OtherNameURLwithID=OtherNamePageURL+OtherNameID;

				 utilfunc.NavigatetoURL(OtherNameURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					try{
						utilfunc.MakeElement(EditbuttonXpath).click();
						Thread.sleep(2000);

						String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
						String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
						Usernametext=Usernametext+Usernametypetext;
						//Reporter.log("User is : "+Usernametext);

						String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();
						//Reporter.log("User Country is : "+UsernameCountrytext);
						try{
							utilfunc.MakeElement(OtherNameFirstNameXpath).clear();
							utilfunc.MakeElement(OtherNameFirstNameXpath).sendKeys(OtherNameFirstName);
						}catch(Exception error){}
						
						try{
							utilfunc.MakeElement(OtherNameMiddleNameXpath).clear();
							utilfunc.MakeElement(OtherNameMiddleNameXpath).sendKeys(OtherNameMiddleName);
						}catch(Exception error){}

						try{
							utilfunc.MakeElement(OtherNameLastNameXpath).clear();
							utilfunc.MakeElement(OtherNameLastNameXpath).sendKeys(OtherNameLastName);
						}catch(Exception error){}
						
						try{
							utilfunc.Selectdropdownvaluebyvalue(OtherNameTypeofNameXpath, OtherNameTypeofName);
						}catch(Exception error){}

						//////////////////////Additional info handle///////////////////////////////
						try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
						}catch(Exception error){}
						//Submit the page with details
						try{
							utilfunc.savebutton();
						}catch(Exception error){}
						
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						if (error_flag.equals(ExpectedErrorMessage)){
							Flag=true;
							utilfunc.TakeScreenshot();
						}else if (error_flag.equals("")){
							Flag=true;
						}else if(error_flag.equals("Server Error in '/' Application.")){
							Flag=false;
							webdriver.navigate().back();
						}else{
							Flag=false;
							utilfunc.TakeScreenshot();
						}

						//Reporter.log("---------------------------------------------------------------------------------------");

					}catch(Exception error){
						utilfunc.NavigatetoURL(URLwithID);
					}
				}
				catch(Exception e){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.ErrorMessage2="No Records Found to Edit";
					Flag=false;
					utilfunc.TakeScreenshot();
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
					/*String OtherNameURLwithID=OtherNamePageURL+OtherNameID;
				 utilfunc.NavigatetoURL(OtherNameURLwithID);*/
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(DeletebuttonXpath).click();
						Thread.sleep(3000);
						utilfunc.isAlertPresent();
					}catch(Exception error){}
					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}
				}catch(Exception e){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					utilfunc.ErrorMessage2="No Records Found to Delete";
					Flag=false;
					utilfunc.TakeScreenshot();
				}
			}
		}///////////url ckeck end
		return Flag;
	}

}