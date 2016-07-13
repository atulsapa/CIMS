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

public class CIMS_Language_Study_Module {
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
	 
		public CIMS_Language_Study_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Language_Study_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Language_Study", 0, ColumnCounter);
			String Language_StudyScenerio=UtilFunction.getCellData("Test Data.xls", "Language_Study", 2, ColumnCounter);
			String Language_StudyTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Language_Study", 3, ColumnCounter);		
			String Language_StudyPageURL=UtilFunction.getCellData("Test Data.xls", "Language_Study", 4, ColumnCounter);
			String Language_StudyID=UtilFunction.getCellData("Test Data.xls", "Language_Study", 5, ColumnCounter);
			
			String LanguageName=UtilFunction.getCellData("Test Data.xls", "Language_Study", 6, ColumnCounter);
			String School=UtilFunction.getCellData("Test Data.xls", "Language_Study", 7, ColumnCounter);
			String StudyCity=UtilFunction.getCellData("Test Data.xls", "Language_Study", 8, ColumnCounter);
			String StudyCountry=UtilFunction.getCellData("Test Data.xls", "Language_Study", 9, ColumnCounter);
			String Course=UtilFunction.getCellData("Test Data.xls", "Language_Study", 10, ColumnCounter);
			String Grade=UtilFunction.getCellData("Test Data.xls", "Language_Study", 11, ColumnCounter);
			String DatesStudyfrom=UtilFunction.getCellData("Test Data.xls", "Language_Study", 12, ColumnCounter);
			String DatesStudyTo=UtilFunction.getCellData("Test Data.xls", "Language_Study", 13, ColumnCounter);
			String StudyYears=UtilFunction.getCellData("Test Data.xls", "Language_Study", 14, ColumnCounter);
			String StudyHours=UtilFunction.getCellData("Test Data.xls", "Language_Study", 15, ColumnCounter);
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Language_Study", 16, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Language_Study", 17, ColumnCounter);

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
			
			String Language_Study_attributeFiledXpath=".//*[@class='question-group']//*[@class='control-group'][xx]//*[@id]";
			String Language_StudyCounterXpath=".//*[@class='question-group']//*[@class='control-group']//*[@id]";
			
			String DatesofStudyfrom=".//*[@class='control-group field-group-inline']//*[@class='controls'][1]//*[@id]";
			String DatesofStudyTo=".//*[@class='control-group field-group-inline']//*[@class='controls'][2]//*[@id]";
			
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Language Study";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Language_StudyScenerio;
			 description=Language_StudyTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Language_StudyURLwithID=Language_StudyPageURL+Language_StudyID;
					 utilfunc.NavigatetoURL(Language_StudyURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 Thread.sleep(5000);
					 utilfunc.ServerErrorHandler();
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						utilfunc.MakeElement(AddbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Language_StudyCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Language_Study_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("LanguageName")){		
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(LanguageName);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("School")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(School);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyCity")){
								 String newpath1=NewXpath.replace("//*[@id]", "//*[@class='controls'][1]//*[@id]");
								 String newpath2=NewXpath.replace("//*[@id]", "//*[@class='controls'][2]//*[@id]");
								 try {
									utilfunc.MakeElement(newpath1).sendKeys(StudyCity);
								} catch (Exception e) {
																	}
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(newpath2, StudyCountry);
								} catch (Exception e) {
									
								}
								 
					        	}
							 else if(AttributeName.equals("Course")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Course);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Grade")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Grade);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyYears")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StudyYears);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyHours")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StudyHours);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("LanguageStudyDocumentId")){
								 
								 if(Fileupload.equals("Yes")){
									 try {
										 Thread.sleep(1000);
										utilfunc.MakeElement(showbuttonxpath).click();
									} catch (Exception e) {
										
									}
										try {
											Thread.sleep(2000);
											utilfunc.MakeElement(uploadbuttonxpath).click();
											Thread.sleep(1000);
										} catch (Exception e) {
											
										}    
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
								}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 ////////////////////////DatesofStudy//////////////////////////////////////
					 try{
					 utilfunc.MakeElement(DatesofStudyfrom).clear();
					 utilfunc.MakeElement(DatesofStudyTo).clear();
					 utilfunc.MakeElement(DatesofStudyfrom).sendKeys(DatesStudyfrom);
					 utilfunc.MakeElement(DatesofStudyTo).sendKeys(DatesStudyTo);
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
					/* String Language_StudyURLwithID=Language_StudyPageURL+Language_StudyID;
					 utilfunc.NavigatetoURL(Language_StudyURLwithID);*/
			
					 utilfunc.NavigatetoURL(URLwithID);
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Language_StudyCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Language_Study_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("LanguageName")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(LanguageName);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("School")){
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(School);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyCity")){
								 String newpath1=NewXpath.replace("//*[@id]", "//*[@class='controls'][1]//*[@id]");
								 String newpath2=NewXpath.replace("//*[@id]", "//*[@class='controls'][2]//*[@id]");
								 utilfunc.MakeElement(newpath1).clear();
								 try {
									utilfunc.MakeElement(newpath1).sendKeys(StudyCity);
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.Selectdropdownvaluebyvalue(newpath2, StudyCountry);
								} catch (Exception e) {
									
								}
								 
					        	}
							 else if(AttributeName.equals("Course")){
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Course);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Grade")){
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Grade);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyYears")){
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StudyYears);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StudyHours")){
								 utilfunc.MakeElement(NewXpath).clear();
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StudyHours);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("LanguageStudyDocumentId")){
								 
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
								}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 ////////////////////////DatesofStudy//////////////////////////////////////
					 try{
					 utilfunc.MakeElement(DatesofStudyfrom).clear();
					 utilfunc.MakeElement(DatesofStudyTo).clear();
					 utilfunc.MakeElement(DatesofStudyfrom).sendKeys(DatesStudyfrom);
					 utilfunc.MakeElement(DatesofStudyTo).sendKeys(DatesStudyTo);
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
					 /*String Language_StudyURLwithID=Language_StudyPageURL+Language_StudyID;
					 utilfunc.NavigatetoURL(Language_StudyURLwithID);*/
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
			
					 try {
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
					} catch (Exception e) {
						
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
