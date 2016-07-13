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

public class CIMS_USImmigration_Module
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

	public CIMS_USImmigration_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean USImmigrationPage(int ColumnCounter, String mode) throws AWTException, InterruptedException
	{	
		boolean flag=false;

		//USImmigration Page Xpath	

		String UsernameXpath="//*[@class='header2 font-accent ']";
		String UsernametypeXpath="//*[@class='font-accent']";
		String CountryXpath="//*[@id='prg-hdr-main']//*[@class='font-accent highlight-blue']";

		//Methods Xpath
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "USImmigration", 0, ColumnCounter);
		String USImmigrationScenerio=UtilFunction.getCellData("Test Data.xls", "USImmigration", 2, ColumnCounter);
		String USImmigrationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "USImmigration", 3, ColumnCounter);		
		String USImmigrationPageURL=UtilFunction.getCellData("Test Data.xls", "USImmigration", 4, ColumnCounter);
		String USImmigrationID=UtilFunction.getCellData("Test Data.xls", "USImmigration", 5, ColumnCounter);

		// Lokehs Add the below lines to get data from  excel sheet to fill data in the US Immigration form on 24-May-2016
		String USImmigrationDropdownvalue=UtilFunction.getCellData("Test Data.xls", "USImmigration", 9, ColumnCounter);
		//String USImmigrationExpected=UtilFunction.getCellData("Test Data.xls", "USImmigration", 7, ColumnCounter);


		/////////////////////////////////URL FETCH///////////////////////////////////


		String QuestionarieName="U.S. Immigration History";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=USImmigrationScenerio;
		description=USImmigrationTestcaseDescription;

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
					//String USImmigrationURLwithID=USImmigrationPageURL+USImmigrationID;

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String Usernametext=utilfunc.MakeElement(UsernameXpath).getText();
					String Usernametypetext=utilfunc.MakeElement(UsernametypeXpath).getText();
					Usernametext=Usernametext+Usernametypetext;

					String UsernameCountrytext=utilfunc.MakeElement(CountryXpath).getText();

					// String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/label[1]";
					String Radio=".//*[@class='question-group'][xx]//*[@class='question-option']/input[1]";
					String Counter=".//*[@class='question-group']";
					String Textbox=".//*[@class='question-group'][xx]/div[2]//textarea";

					int ObjCount=utilfunc.GetObjectCount(Counter);
					String Dropdownxpath=".//*[@class='question-group'][2]//*[@class='question-option']//*[contains(@id,'OtherCompanyLabor')]";

					//String Dropdown=".//*[@class='question-group'][2]//*[@class='question-option'][1]"


					/*for(int count=1; count<=ObjCount; count++)
				 {
					 try{
						 String NewRadio=Radio.replace("xx", Integer.toString(count));
						 utilfunc.MakeElement(NewRadio).click();
						 String NewTextbox=Textbox.replace("xx", Integer.toString(count));
						 String Questionnaire="USImmigration "+count;
						 utilfunc.MakeElement(NewTextbox).clear();
						 utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);

				}
				catch(Exception e){

					try{

						String NewRadio1=Counter+"[xx]//*[@class='question-option']/select";
						NewRadio1=NewRadio1.replace("xx", Integer.toString(count));
						String NewRadio1=".//*[@class='question-option']/select";
						utilfunc.Selectdropdownvaluebyvalue(NewRadio1, "APPROVED");
						String NewTextbox=Textbox.replace("xx", Integer.toString(count));
						String Questionnaire="USImmigration "+count;
						utilfunc.MakeElement(NewTextbox).clear();
						utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);	

					}catch(Exception f){
						System.out.println("Exception --->"+f);
					}

					}

				 	}*/


					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						if(count==2){
							try{
								//System.out.println("\t--->USImmigrationDropdownvalue :"+USImmigrationDropdownvalue);
								if(USImmigrationDropdownvalue!=null)
								{
									try{
										utilfunc.Selectdropdownvaluebytext(Dropdownxpath,USImmigrationDropdownvalue);
										try{
											String NewTextbox=Textbox.replace("xx", Integer.toString(count));
											String Questionnaire="USImmigration "+count;
											utilfunc.MakeElement(NewTextbox).clear();
											utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
										}catch(Exception Error){}
									}catch(Exception Error){}
								}
								else{
									try{utilfunc.DeSelectdropdownvalue(Dropdownxpath);
									}catch(Exception Error){}
								}
							}catch(Exception error){}
						}
						try{
							String NewRadio=Radio.replace("xx", Integer.toString(count));
							try{
								Thread.sleep(1000);
								utilfunc.MakeElement(NewRadio).click();
								Thread.sleep(1000);
								try{
									String NewTextbox=Textbox.replace("xx", Integer.toString(count));
									String Questionnaire="USImmigration "+count;
									Thread.sleep(300);
									utilfunc.MakeElement(NewTextbox).clear();
									utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
								}catch(Exception error){}
							}catch(Exception error){}
						}
						catch(Exception e){

							try{

								/*String NewRadio1=Counter+"[xx]//*[@class='question-option']/select";
						NewRadio1=NewRadio1.replace("xx", Integer.toString(count));*/
								String NewRadio1=".//*[@class='question-option']/select";
								utilfunc.Selectdropdownvaluebyvalue(NewRadio1, "APPROVED");
								String NewTextbox=Textbox.replace("xx", Integer.toString(count));
								String Questionnaire="USImmigration "+count;
								utilfunc.MakeElement(NewTextbox).clear();
								utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);	

							}catch(Exception f){
								System.out.println("\n\nException is "+f+"\n\n");
							}

						}

					}


					//Custom Xpath
					String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
					String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					}catch(Exception Error){}


					try{utilfunc.savebutton();
					}catch(Exception Error){}

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}

					//return Flag;
				}
				catch(Exception e){}

			}else if(mode.equals(ACTION1)){

				try{
					//String USImmigrationURLwithID=USImmigrationPageURL+USImmigrationID;

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
					//String Dropdown=".//*[@class='question-group'][2]//*[@class='question-option'][1]"


					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						try{
							String NewRadio=Radio.replace("xx", Integer.toString(count));
							try{utilfunc.MakeElement(NewRadio).click();
							}catch(Exception error){}
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="USImmigration "+count;
							utilfunc.MakeElement(NewTextbox).clear();
							utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);
						}
						catch(Exception e){
							String NewRadio1=".//*[@class='question-option']/select";
							utilfunc.Selectdropdownvaluebyvalue(NewRadio1, "APPROVED");
							String NewTextbox=Textbox.replace("xx", Integer.toString(count));
							String Questionnaire="USImmigration "+count;
							utilfunc.MakeElement(NewTextbox).clear();
							utilfunc.MakeElement(NewTextbox).sendKeys(Questionnaire);	
						}

					}

					//Custom Xpath
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

					//return Flag;
				}
				catch(Exception e){}

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
					utilfunc.ErrorMessage2="Delete option is not Implimented in U.S. Immigration History - Principal Information Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			
			}
		}///////////url ckeck end
		return Flag;
	}			 
}