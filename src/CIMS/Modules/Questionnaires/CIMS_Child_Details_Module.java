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
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Child_Details_Module {
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
	 
		public CIMS_Child_Details_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Child_Details_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Child_Details", 0, ColumnCounter);
			String Child_DetailsScenerio=UtilFunction.getCellData("Test Data.xls", "Child_Details", 2, ColumnCounter);
			String Child_DetailsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Child_Details", 3, ColumnCounter);		
			String Child_DetailsPageURL=UtilFunction.getCellData("Test Data.xls", "Child_Details", 4, ColumnCounter);
			String Child_DetailsID=UtilFunction.getCellData("Test Data.xls", "Child_Details", 5, ColumnCounter);
			
			String Child_DetailsIsthischildintheprimaryapplicant=UtilFunction.getCellData("Test Data.xls", "Child_Details", 6, ColumnCounter);
			String Child_DetailsDoesanyotherpersonhavecustodial=UtilFunction.getCellData("Test Data.xls", "Child_Details", 7, ColumnCounter);
			String Child_DetailsArethereanylegalimpediments=UtilFunction.getCellData("Test Data.xls", "Child_Details", 8, ColumnCounter);
			String Child_DetailsLegalimpedimentsdescription=UtilFunction.getCellData("Test Data.xls", "Child_Details", 9, ColumnCounter);
			String Child_DetailsIfapplicableadoptionstatus=UtilFunction.getCellData("Test Data.xls", "Child_Details", 10, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Child_Details", 11, ColumnCounter);
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";
			
			String Child_Details_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='question-group'][xx]//*[@id]";
			String Child_DetailsCounterXpath=".//*[@class='form-horizontal']//*[@class='question-group']//*[@id]";
			
			String Legalimpedimentsdescriptionxpath=".//*[@id='ImpedimentsDescription']";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Child Details";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Child_DetailsScenerio;
			 description=Child_DetailsTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					/* String Child_DetailsURLwithID=Child_DetailsPageURL+Child_DetailsID;
					 utilfunc.NavigatetoURL(Child_DetailsURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 			 
				
					 int ObjCount=utilfunc.GetObjectCount(Child_DetailsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 Thread.sleep(400);
						 String NewXpath=Child_Details_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("IsApplicantCare")){	
								 if(Child_DetailsIsthischildintheprimaryapplicant.equals("Yes")){
									 try {
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {}
								 }
					        	}	
							 else if(AttributeName.equals("IsAnyPersonCutodial")){									 
								 if(Child_DetailsDoesanyotherpersonhavecustodial.equals("Yes")){
									try{ utilfunc.MakeElement(NewXpath).click();} catch (Exception e) {}
								 }
					        	}
							 else if(AttributeName.equals("IsImpediment")){									 
								 if(Child_DetailsArethereanylegalimpediments.equals("Yes")){
									try{ utilfunc.MakeElement(NewXpath).click();
									 utilfunc.MakeElement(Legalimpedimentsdescriptionxpath).clear();
									 utilfunc.MakeElement(Legalimpedimentsdescriptionxpath).sendKeys(Child_DetailsLegalimpedimentsdescription);
									} catch (Exception e) {}
									}
								 else if(Child_DetailsArethereanylegalimpediments.equalsIgnoreCase("No"))
								 {
									 try{
									 utilfunc.MakeElement(".//*[@class='form-horizontal']//*[@class='question-group'][3]//*[contains(@id,'IsImpediment') and contains(@value,'0')]").click();
								 }catch(Exception eror){}
								 }
								 else if(Child_DetailsArethereanylegalimpediments.contains("Not A"))
								 {
									 try{
									 utilfunc.MakeElement(".//*[@class='form-horizontal']//*[@class='question-group'][3]//*[contains(@id,'IsImpediment') and contains(@value,'N/A')]").click();
								 }catch(Exception eror){}
								 }
					        	}
							 else if(AttributeName.equals("AdoptionStatus21")){							
								try{ utilfunc.Selectdropdownvaluebyvalue(NewXpath, Child_DetailsIfapplicableadoptionstatus);
								} catch (Exception e) {}
								}
							
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
					 utilfunc.savebutton();
					 
				        
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
				 
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					 /*String Child_DetailsURLwithID=Child_DetailsPageURL+Child_DetailsID;
					 utilfunc.NavigatetoURL(Child_DetailsURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
				
					 int ObjCount=utilfunc.GetObjectCount(Child_DetailsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Child_Details_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("IsApplicantCare")){	
								 if(Child_DetailsIsthischildintheprimaryapplicant.equals("Yes")){
									 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}	
							 else if(AttributeName.equals("IsAnyPersonCutodial")){									 
								 if(Child_DetailsDoesanyotherpersonhavecustodial.equals("Yes")){
									 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("IsImpediment")){									 
								 if(Child_DetailsArethereanylegalimpediments.equals("Yes")){
									 utilfunc.MakeElement(NewXpath).click();
									 utilfunc.MakeElement(Legalimpedimentsdescriptionxpath).clear();
									 utilfunc.MakeElement(Legalimpedimentsdescriptionxpath).sendKeys(Child_DetailsLegalimpedimentsdescription);
								 }
					        	}
							 else if(AttributeName.equals("AdoptionStatus21")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Child_DetailsIfapplicableadoptionstatus);
					        	}
							
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
					 utilfunc.savebutton();
				        
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in Child Details Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				 
				
				 
				 }///////////url ckeck end
			
			 return Flag;
	 	}

}
