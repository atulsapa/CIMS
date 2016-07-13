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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.openqa.selenium.JavascriptExecutor;

import util.UtilFunction;

public class CIMS_SpecialAbility_Module
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

	public CIMS_SpecialAbility_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean SpecialAbilityModulePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 0, ColumnCounter);
		String SpecialAbilityScenerio=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 2, ColumnCounter);
		String SpecialAbilityTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 3, ColumnCounter);		
		String SpecialAbilityPageURL=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 4, ColumnCounter);
		String SpecialAbilityID=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 5, ColumnCounter);

		String SpecialAbility_Job_Title=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 6, ColumnCounter);
		String SpecialAbility_Amount =UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 7, ColumnCounter);
		String SpecialAbility_Currency=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 8, ColumnCounter);
		String SpecialAbility_Per=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 9, ColumnCounter);
		String SpecialAbility_Position_Status=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 10, ColumnCounter);
		String SpecialAbility_Ifthisisnotradio =UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 11, ColumnCounter);
		String SpecialAbility_Ifyespleaseexplaintinymce =UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 12, ColumnCounter);
		String SpecialAbility_Provideadetailed=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 13, ColumnCounter);
		String SpecialAbility_Whyisthisproject=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 14, ColumnCounter);
		String SpecialAbility_AreaofEndeavor=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 15, ColumnCounter);
		String SpecialAbility_Specificfieldofendeavor=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 16, ColumnCounter);
		String SpecialAbility_Fulldescriptionofspecialability=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 17, ColumnCounter);
		String SpecialAbility_Whyisyourareaofexpertise=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 18, ColumnCounter);
		String SpecialAbility_Willresearchdutiesradio=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 19, ColumnCounter);
		String SpecialAbility_Provideadetaileddescription=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 20, ColumnCounter);
		String SpecialAbility_Istheresearchradio=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 21, ColumnCounter);
		String SpecialAbility_Istheresearchtinymce=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 22, ColumnCounter);

		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "SpecialAbility", 23, ColumnCounter);

		//XPATH define
		String specialabilityFiledxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
		//		String specialabilitycountermainxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
		String specialabilitycountermainxpath=".//*[@class='form-horizontal']/*[@class='control-group']/*[@id]";

		String CurrentSalary=".//*[@id='CurrentSalary']";
		String CurrencyList=".//*[@id='CurrencyList']";
		String PayPeriodList=".//*[@id='PayPeriodList']";

		String radiofieldxpath=".//*[@class='question-group'][xx]//*[@class='radio inline']//*[@name]";
		String radiocounterxpath=".//*[@class='question-group']//*[@class='radio inline']//*[@name]";

		String aditionalinfofieldxpath=".//*[@class='form-horizontal']/div[14]//*[@class='control-group'][xx]//*[@id]";
		String aditionalinfocounterxpath=".//*[@class='form-horizontal']/div[14]//*[@class='control-group']//*[@id]";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Special Ability, Recognition, or Research";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=SpecialAbilityScenerio;
		description=SpecialAbilityTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)|mode.equals(ACTION1)){

				try{

					/*	String SpecialAbilityURLwithID=SpecialAbilityPageURL+SpecialAbilityID;*/
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					int ObjCount=utilfunc.GetObjectCount(specialabilitycountermainxpath);

					for(int count=1; count<=15; count++)
					{
						String NewXpath=specialabilityFiledxpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							// System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.contains("JobTitle")){	
								try{ 
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(SpecialAbility_Job_Title);
									Thread.sleep(1000);
									utilfunc.MakeElement(CurrentSalary).clear();
									utilfunc.MakeElement(CurrentSalary).sendKeys(SpecialAbility_Amount);
									Thread.sleep(1500);
									utilfunc.Selectdropdownvaluebytext(CurrencyList, SpecialAbility_Currency);
									Thread.sleep(1500);
									utilfunc.Selectdropdownvaluebytext(PayPeriodList, SpecialAbility_Per);
								}catch(Exception error){}
							}
							else if(AttributeName.contains("PositionStatus")){
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, SpecialAbility_Position_Status);
								}catch(Exception error){}
							}
							else if(AttributeName.contains("tinymce-23")){
								try{
									webdriver.switchTo().frame("WorkPerformed_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Provideadetailed+"</h3>'");
									webdriver.switchTo().defaultContent();
								}catch(Exception error){}
							}
							else if(AttributeName.contains("tinymce-38")){
								try{
									webdriver.switchTo().frame("ProjectInterest_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Whyisthisproject+"</h3>'");
									webdriver.switchTo().defaultContent();
								}catch(Exception error){}
							}
							else if(AttributeName.contains("AreaEndeavor")){
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath,SpecialAbility_AreaofEndeavor );
								}catch(Exception error){}
							}
							else if(AttributeName.contains("SpecificEndeavor")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(SpecialAbility_Specificfieldofendeavor);
								}catch(Exception error){}
							}
							else if(AttributeName.contains("tinymce-53")){
								try{
									webdriver.switchTo().frame("AbilityDescription_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Fulldescriptionofspecialability+"</h3>'");
									webdriver.switchTo().defaultContent();
								}catch(Exception error){}
							}
							else if(AttributeName.contains("tinymce-68")){
								try{
									webdriver.switchTo().frame("AreaExpertise_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Whyisyourareaofexpertise+"</h3>'");
									webdriver.switchTo().defaultContent();
								}catch(Exception error){}
							}
							else if(AttributeName.contains("tinymce-83")){
								try{
									webdriver.switchTo().frame("EmployerDescription_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Provideadetaileddescription+"</h3>'");
									webdriver.switchTo().defaultContent();
								}catch(Exception error){}
							}
						}catch(Exception e){
						}	 
					}
					int ObjCount1=utilfunc.GetObjectCount(radiocounterxpath);

					for(int count=1; count<=ObjCount1; count++)
					{
						Thread.sleep(300);
						String NewXpath=radiofieldxpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							//System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.contains("IsPosition")){			
								if(SpecialAbility_Ifthisisnotradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][1]/input");
										//		System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
										webdriver.switchTo().frame("IsPositionDesc_ifr");
										webdriver.findElement(By.id("tinymce")).clear();
										((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Ifyespleaseexplaintinymce+"</h3>'");
										webdriver.switchTo().defaultContent();
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}

							}
							else if(AttributeName.contains("DutiesComprise")){
								if(SpecialAbility_Willresearchdutiesradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][1]/input");
										//	System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][2]/input");
										//System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.contains("IsResearch")){
								if(SpecialAbility_Istheresearchradio.equals("Yes")){
									try{							String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][1]/input");
									//	System.out.println(NewXpath1);
									Thread.sleep(1000);							
									utilfunc.MakeElement(NewXpath1).click();
									Thread.sleep(1000);
									webdriver.switchTo().frame("IsResearchDesc_ifr");
									webdriver.findElement(By.id("tinymce")).clear();
									((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+SpecialAbility_Istheresearchtinymce+"</h3>'");
									webdriver.switchTo().defaultContent();
									}catch(Exception error){}						 

								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}	
								}
							}			 
						}catch(Exception e){

						}
					}


					try{
						utilfunc.dynamic_data(aditionalinfocounterxpath, aditionalinfofieldxpath);
					}catch(Exception error){}	

					try{
						utilfunc.savebutton();
					}catch(Exception error){}	

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.equals("")){
						Flag=true;
					}else if (error_flag.contains("Success!")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}


				}catch(Exception e){

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
					Thread.sleep(2000);
					try{
						String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
						utilfunc.MakeElement(deletexpath).click();
						Thread.sleep(1000);
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Special Ability Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			

			}	 
		}///////////url ckeck end
		return Flag;
	}
}