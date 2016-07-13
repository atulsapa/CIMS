package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_EnglishLanguageAbility_Module {
	
private static final String Counter = null;
private WebDriver webdriver;	// Will be Provide by Calling Class.	
private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
//Veriables-------------
public static String Deletecheck="";
public static String ErrorMessage="";
public static String ErrorMessage1="";
public static String ErrorMessage2="";
public static String URLwithID="";

public static String testcaseid="";
public static String scenerio="";
public static String description="";

//Constructor----------	 
public CIMS_EnglishLanguageAbility_Module(WebDriver driver,UtilFunction utilfunc) 
{
this.webdriver =driver;
this.utilfunc=utilfunc;		
// TODO Auto-generated constructor stub
}
/**
 * Verify that User is able to landed on the EnglishLanguageAbility Page
 * 	
 * @throws AWTException
 * @throws InterruptedException
 */
	public boolean CIMS_EnglishLanguageAbility_ModulePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
	String TestcaseID=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 0, ColumnCounter);
	String EnglishLanguageAbility_Scenerio=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 2, ColumnCounter);
	String EnglishLanguageAbility_TestcaseDescription=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 3, ColumnCounter);		
	String EnglishLanguageAbility_PageURL=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 4, ColumnCounter);
	String EnglishLanguageAbility_ID=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 5, ColumnCounter);
		
	String EnglishLanguageAbility_FirstLanguage=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 6, ColumnCounter);
	
	String EnglishLanguageAbility_EnglishTest=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 7, ColumnCounter);
	String EnglishLanguageAbility_TestName=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 8, ColumnCounter);
	String EnglishLanguageAbility_TestDate=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 9, ColumnCounter);
	String EnglishLanguageAbility_ReferenceNumber=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 10, ColumnCounter);
	String EnglishLanguageAbility_TestScore=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 11, ColumnCounter);
	String EnglishLanguageAbility_TertiaryInstitution=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 12, ColumnCounter);
	String EnglishLanguageAbility_Passport=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 13, ColumnCounter);
	String EnglishLanguageAbility_HigherDegree=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 14, ColumnCounter);
	
	String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "EnglishLanguageAbility", 15, ColumnCounter);
	
	String EnglishlanguageabilityFieldxpath=".//*[@class='form-horizontal']/*[@class='question-group'][xx]//*[@name]";
	String EnglishlanguageabilityControlxpath=".//*[@class='form-horizontal']/*[@class='question-group']//*[@name]";
		
	String EnglishlanguageSecFieldxpath=".//*[@id='FirstLanguageNo']/*[@class='question-group'][xx]//*[@id]";
	String Englangcounterxpath=".//*[@id='FirstLanguageNo']/*[@class='question-group']//*[@id]";
	
	String EnglishlanguageThirdFieldxpath=".//*[@id='FirstLanguageNo']//*[@class='question-group'][xx]//*[@id]";
	String EnglishlanguageThirdcounterxpath=".//*[@id='FirstLanguageNo']//*[@class='question-group']//*[@id]";
	
	String Xpathnew1=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
	String Xpathnew2=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
	/////////////////////////////////URL FETCH///////////////////////////////////
	
	String QuestionarieName="English Language Ability";
	//String URLwithID=UtilFunction.geturl(QuestionarieName);
	URLwithID=utilfunc.geturldirect(QuestionarieName);
	
	boolean Flag =false;
	testcaseid=TestcaseID;
	scenerio=EnglishLanguageAbility_Scenerio;
	description=EnglishLanguageAbility_TestcaseDescription;
	
	String ACTION="New";
	String ACTION1="Edit";
	String ACTION2="Delete";
	
	if(URLwithID.equals("")){
		utilfunc.closesidebar();
		Flag=false; 
		}else{
		 
	
	
	if(mode.equals(ACTION) | mode.equals(ACTION1)){
		
		try{
			utilfunc.NavigatetoURL(URLwithID);
			
			utilfunc.ServerErrorHandler();
			///////////////////////////////////////////////////////////////////////////////
			int ObjCount=utilfunc.GetObjectCount(EnglishlanguageabilityControlxpath);
			for(int count=1; count<=ObjCount; count++)
			{
				Thread.sleep(300);
				String NewXpath=EnglishlanguageabilityFieldxpath.replace("xx", Integer.toString(count));
				try{
					
					String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
					
					if(AttributeName.contains("FirstLanguage")){	
						
						if(EnglishLanguageAbility_FirstLanguage.equals("Yes")){
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='FirstLanguage' and contains(@value,'rue')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {System.out.println("Unable to click on the radio button");}
						}else{
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='FirstLanguage' and contains(@value,'alse')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {System.out.println("Unable to click on the radio button");}
						}
						
					}else if(AttributeName.contains("PassportInEnglishLanguageCountries")){
						
						if(EnglishLanguageAbility_Passport.equals("Yes")){
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='PassportInEnglishLanguageCountries' and contains(@value,'rue')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {System.out.println("Unable to click on the radio button");
							}
						}else{
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='PassportInEnglishLanguageCountries' and contains(@value,'alse')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {System.out.println("Unable to click on the radio button");
							}
						}
					}else if(AttributeName.contains("DegreeInEnglishLanguageCountries")){
						
						if(EnglishLanguageAbility_HigherDegree.equals("Yes")){
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='DegreeInEnglishLanguageCountries' and contains(@value,'rue')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
						}else{
							String NewXpath1=NewXpath.replace("//*[@name]", "//*[@name='DegreeInEnglishLanguageCountries' and contains(@value,'alse')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
						}
					}
					
				}catch(Exception e){
					
				}
				
			}
			///////////////////////////////////////////////////////////////////////////////////////////
			int ObjCount1=utilfunc.GetObjectCount(Englangcounterxpath);
			for(int count=1; count<=ObjCount1; count++)
			{
				String NewXpath=EnglishlanguageSecFieldxpath.replace("xx", Integer.toString(count));
				try{
					String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
					if(AttributeName.contains("TookTest")){
						
						if(EnglishLanguageAbility_EnglishTest.equals("Yes")){
							String NewXpath1=NewXpath.replace("//*[@id]", "//*[@name='TookTest' and contains(@value,'rue')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
							
							int ObjCount2=utilfunc.GetObjectCount(EnglishlanguageThirdcounterxpath);
							for(int count1=1; count1<=ObjCount2; count1++){
								String NewXpath2=EnglishlanguageThirdFieldxpath.replace("xx", Integer.toString(count1));
								try{
									String AttributeName1=utilfunc.MakeElement(NewXpath2).getAttribute("id");
									if(AttributeName1.contains("TestName")){
										try {
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebyindex(NewXpath2, 1);
										} catch (Exception e) {
											System.out.println("Unable to select the value");										}
										
									}else if(AttributeName1.contains("TestDate")){
										utilfunc.MakeElement(NewXpath2).clear();
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath2).sendKeys(EnglishLanguageAbility_TestDate);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}
										
									}else if(AttributeName1.contains("TestReference")){
										utilfunc.MakeElement(NewXpath2).clear();
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath2).sendKeys(EnglishLanguageAbility_ReferenceNumber);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}
										
									}else if(AttributeName1.contains("TestScore")){
										utilfunc.MakeElement(NewXpath2).clear();
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath2).sendKeys(EnglishLanguageAbility_TestScore);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}
										
									}
									
								}catch(Exception f){
									
								}
								
							}
							
						}else{
							String NewXpath1=NewXpath.replace("//*[@id]", "//*[@name='TookTest' and contains(@value,'alse')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
						}
						
						
					}else if(AttributeName.contains("Instructions")){
						
						if(EnglishLanguageAbility_TertiaryInstitution.equals("Yes")){
							String NewXpath1=NewXpath.replace("//*[@id]", "//*[@name='Instructions' and contains(@value,'rue')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
						}else{
							String NewXpath1=NewXpath.replace("//*[@id]", "//*[@name='Instructions' and contains(@value,'alse')]");
							System.out.println(NewXpath1);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
							} catch (Exception e) {
								System.out.println("Unable to click on the radio button");
							}
						}
					}
					
				}catch(Exception e){
					
				}
			}
			Thread.sleep(1000);
			try {
				utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
			} catch (Exception e) {

			}
			
			/*String SaveButtonXpath=".//*[@id='btnSave']";
			utilfunc.MakeElement(SaveButtonXpath).click();*/
			try {
				utilfunc.savebutton();
			} catch (Exception e) {

			}
			
			String error_flag=utilfunc.questionnaireErrorMessageHandler();
			if (error_flag.equals(ExpectedErrorMessage)){
			Flag=true;
			utilfunc.TakeScreenshot();
			}else if (error_flag.contains("Success!")){
			Flag=true;
			}else if (error_flag.equals("")){
			Flag=true;
			}else if(error_flag.equals("Server Error in '/' Application.")){
			Flag=false;
			webdriver.navigate().back();
			}else{
			Flag=false;
			utilfunc.TakeScreenshot();
			}
			
		}catch(Exception e){
			utilfunc.NavigatetoURL(URLwithID);
			
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
				try {
					utilfunc.MakeElement(deletexpath).click();
				} catch (Exception e) {
					System.out.println("Unable to click on the delete button");
				}
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in English language Ability Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
			}			
		 
	 }
	
		}///////////url ckeck end
	return Flag;
	}
	}



