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

import CIMS.CIMS_MainProject;

import util.UtilFunction;

public class CIMS_Other_Evidence_of_Special_Ability_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 

	
	 //Constructor----------
	 
		public CIMS_Other_Evidence_of_Special_Ability_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Other_Evidence_of_Special_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 0, ColumnCounter);
			String Other_Evidence_of_SpecialScenerio=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 2, ColumnCounter);
			String Other_Evidence_of_SpecialTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 3, ColumnCounter);		
			String Other_Evidence_of_SpecialPageURL=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 4, ColumnCounter);
			String Other_Evidence_of_SpecialID=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 5, ColumnCounter);
			
			String Description=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 6, ColumnCounter);
			String Descriptiondate=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 7, ColumnCounter);
			String WhyYouRegard=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 8, ColumnCounter);
			String Canyouprovidedocumentationradio=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 9, ColumnCounter);
			
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 10, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Other_Evidence_of_Special", 11, ColumnCounter);

			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";
			
			String Other_Evidence_of_Special_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
			String Other_Evidence_of_SpecialCounterXpath=".//*[@class='control-group']//*[@id]";
			
			String other_Evidenceradioxpath=".//*[@class='question-group']//*[@id]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Other Evidence of Special Ability or Recognition";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Other_Evidence_of_SpecialScenerio;
			 description=Other_Evidence_of_SpecialTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
		
			 
			 if(mode.equals(ACTION)){
				 try{
					/* String Other_Evidence_of_SpecialURLwithID=Other_Evidence_of_SpecialPageURL+Other_Evidence_of_SpecialID;
					 utilfunc.NavigatetoURL(Other_Evidence_of_SpecialURLwithID);*/
					 
					 Thread.sleep(1000);
						utilfunc.NavigatetoURL(URLwithID);
					
					 
					
						Thread.sleep(1000);
						utilfunc.ServerErrorHandler();
					
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						utilfunc.MakeElement(AddbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Other_Evidence_of_SpecialCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Other_Evidence_of_Special_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("Description")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Description);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("DescriptionDate")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Descriptiondate);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("WhyYouRegard")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(WhyYouRegard);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("btn_uploader")){
								 
								 if(Fileupload.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(uploadbuttonxpath).click();
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.uploadfile(fileuploadpath);
								} catch (Exception e) {
									
								}
								 	}
								}
						 }catch(Exception e){
							 
						 }
					 }
					 ////////////////////////////radio/////////////////////////////////////////
					 try{
					 if(Canyouprovidedocumentationradio.equals("Yes")){
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(other_Evidenceradioxpath).click();
					} catch (Exception e) {
						
					}
					 }
					 }catch(Exception e){
						 
					 }
					 
					 /////////////////upload////////////////////////////////////
						try{
							if(Fileupload.equals("Yes")){
								try {
									Thread.sleep(1000);
									utilfunc.MakeElement(showbuttonxpath).click();
								} catch (Exception e) {
									
								}
								Thread.sleep(2000);
								try {
									utilfunc.MakeElement(uploadbuttonxpath).click();
								} catch (Exception e) {
									
								}
								Thread.sleep(1000);    
					         try {
								utilfunc.uploadfile(fileuploadpath);
							} catch (Exception e) {
								
							}
					         Thread.sleep(5000);
					         try {
								utilfunc.MakeElement(fileuploadbutton).click();
							} catch (Exception e) {
								
							}
							 }
							
						}catch(Exception e){
							
						}
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e) {
						
					}
					 
					 try {
						 Thread.sleep(1000);
						utilfunc.savebutton();
					} catch (Exception e) {
						
					}
					 
				        
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
					 
				 }catch(Exception e){
					 utilfunc.NavigatetoURL(URLwithID);
				 }
				 
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					/* String Other_Evidence_of_SpecialURLwithID=Other_Evidence_of_SpecialPageURL+Other_Evidence_of_SpecialID;
					 utilfunc.NavigatetoURL(Other_Evidence_of_SpecialURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@id='divList']/tbody/tr/td[3]/a/i";
					 try {
						utilfunc.MakeElement(EditbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Other_Evidence_of_SpecialCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Other_Evidence_of_Special_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("Description")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Description);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("DescriptionDate")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Descriptiondate);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("WhyYouRegard")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(WhyYouRegard);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("btn_uploader")){
								 
								 if(Fileupload.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(uploadbuttonxpath).click();
								} catch (Exception e) {
									
								}
								 try {
									 Thread.sleep(1000);
									utilfunc.uploadfile(fileuploadpath);
								} catch (Exception e) {
									
								}
								 	}
								}
						 }catch(Exception e){
							 
						 }
					 }
					 ////////////////////////////radio/////////////////////////////////////////
					 try{
					 if(Canyouprovidedocumentationradio.equals("Yes")){
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(other_Evidenceradioxpath).click();
					} catch (Exception e) {
						
					}
					 }
					 }catch(Exception e){
						 
					 }
					 
					 /////////////////upload////////////////////////////////////
						try{
							if(Fileupload.equals("Yes")){
								try {
									Thread.sleep(1000);
									utilfunc.MakeElement(showbuttonxpath).click();
								} catch (Exception e) {
									
								}
								Thread.sleep(2000);
								try {
									utilfunc.MakeElement(uploadbuttonxpath).click();
								} catch (Exception e) {
									
								}
								Thread.sleep(1000);    
					         try {
								utilfunc.uploadfile(fileuploadpath);
							} catch (Exception e) {
								
							}
					         Thread.sleep(5000);
					         try {
								utilfunc.MakeElement(fileuploadbutton).click();
							} catch (Exception e) {
								
							}
							 }
							
						}catch(Exception e){
							
						}
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e) {
						
					}
					 
					 try {
						 Thread.sleep(1000);
						utilfunc.savebutton();
					} catch (Exception e) {
						
					}
					 
				        
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
					 
				 }catch(Exception e){
					 utilfunc.ErrorMessage="";
					 utilfunc.ErrorMessage1="";							
					 utilfunc.ErrorMessage4="";
					 utilfunc.ErrorMessage5="";
					 utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();
					 utilfunc.NavigatetoURL(URLwithID);
				 }
				
				 
			 }else if(mode.equals(ACTION2)){
				 try{
					 /*String Other_Evidence_of_SpecialURLwithID=Other_Evidence_of_SpecialPageURL+Other_Evidence_of_SpecialID;
					 utilfunc.NavigatetoURL(Other_Evidence_of_SpecialURLwithID);*/
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					 try {
						utilfunc.MakeElement(DeletebuttonXpath).click();
					} catch (Exception e) {
					}
					 
					 Thread.sleep(10000);
					 
					 utilfunc.isAlertPresent();
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
