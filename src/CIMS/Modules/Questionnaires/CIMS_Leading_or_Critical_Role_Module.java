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

public class CIMS_Leading_or_Critical_Role_Module {
	
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
	 
		public CIMS_Leading_or_Critical_Role_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
		}
		public boolean Leading_or_Critical_Role_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 0, ColumnCounter);
			String Leading_or_Critical_RoleScenerio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 2, ColumnCounter);
			String Leading_or_Critical_RoleTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 3, ColumnCounter);		
			String Leading_or_Critical_RolePageURL=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 4, ColumnCounter);
			String Leading_or_Critical_RoleID=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 5, ColumnCounter);
			
			String NameofOrganization=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 6, ColumnCounter);
			String PleaseprovidenatureofRole=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 7, ColumnCounter);
			String ProjectTitle=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 8, ColumnCounter);
			String EmployerName=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 9, ColumnCounter);
			String WasthisProjectSuccessfulradio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 10, ColumnCounter);
			String IsLeadingRoleradio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 11, ColumnCounter);
			
			String WasthisProjectSuccessfuldesc=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 12, ColumnCounter);
			String DidyouplayaLeadingradio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 13, ColumnCounter);
			String DidyouplayaLeadingroledesc=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 14, ColumnCounter);
			String Howtheorganization=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 15, ColumnCounter);
			String obtainreferencelettersradio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 16, ColumnCounter);
			String Canyouprovidedocumentationradio=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 17, ColumnCounter);
			
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 18, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Leading_or_Critical_Role", 19, ColumnCounter);

			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";
			
			String Leading_or_Critical_Role_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String Leading_or_Critical_RoleCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";

			String radiofieldxpath=".//*[@class='question-group Fulldiv-clour'][xx]//*[@class='control-group']//*[@name]";
			String radiocounterxpath=".//*[@class='question-group Fulldiv-clour']//*[@class='control-group']//*[@name]";
			
			String SuccessDescxpath=".//*[@id='IsSuccessDesc']";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Leading or Critical Role in Distinguished Organizations";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Leading_or_Critical_RoleScenerio;
			 description=Leading_or_Critical_RoleTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Leading_or_Critical_RoleURLwithID=Leading_or_Critical_RolePageURL+Leading_or_Critical_RoleID;
					 utilfunc.NavigatetoURL(Leading_or_Critical_RoleURLwithID);*/
				
					
						utilfunc.NavigatetoURL(URLwithID);
					
					 
					
						utilfunc.ServerErrorHandler();
					
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						utilfunc.MakeElement(AddbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Leading_or_Critical_RoleCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Leading_or_Critical_Role_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("OrganizationName")){							
							     try {
									utilfunc.MakeElement(NewXpath).sendKeys(NameofOrganization);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("RoleNature")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(PleaseprovidenatureofRole);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Title")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(ProjectTitle);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("EmployerName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(EmployerName);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("IsLeadingRole")){	
								 if(DidyouplayaLeadingradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
									
								}
					        	}
							 }
							 else if(AttributeName.equals("IsLeadingRoleDesc")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(DidyouplayaLeadingroledesc);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("OrganizationDesc")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Howtheorganization);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("uploaderFile")){
								 
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
					 ////////////////////////Radio ////////////////////////////////////////////
					 int ObjCount1=utilfunc.GetObjectCount(radiocounterxpath);
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=radiofieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("IsSuccess")){		
								 if(WasthisProjectSuccessfulradio.equals("Yes")){
							     try {
							    	 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
							     try {
									utilfunc.MakeElement(SuccessDescxpath).sendKeys(WasthisProjectSuccessfuldesc);
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }else if(AttributeName.equals("IsLeadingRole")){
								 
								 if(IsLeadingRoleradio.equals("Yes")){
								     try {
								    	 Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
									} catch (Exception e) {
										
									}
								     try {
										utilfunc.MakeElement(SuccessDescxpath).sendKeys(WasthisProjectSuccessfuldesc);
									} catch (Exception e) {
										
									}
						        	}else{
						        		try {
						        			Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
										} catch (Exception e) {
											
										}
						        	}
								 
								 
								 
							 }
							 else if(AttributeName.equals("IsObtainReferenceLetters")){	
								 if(obtainreferencelettersradio.equals("Yes")){
								  try {
									  Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("IsDocProvided")){	
								 if(Canyouprovidedocumentationradio.equals("Yes")){
								  try {
									  Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					 /////////////////upload////////////////////////////////////
						try{
							if(Fileupload.equals("Yes")){
								utilfunc.MakeElement(showbuttonxpath).click();
								Thread.sleep(2000);
								utilfunc.MakeElement(uploadbuttonxpath).click();
								Thread.sleep(1000);    
					         utilfunc.uploadfile(fileuploadpath);
					         Thread.sleep(5000);
					         utilfunc.MakeElement(fileuploadbutton).click();
							 }
							
						}catch(Exception e){
							
						}
					 
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e1) {
						
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
					 /*String Leading_or_Critical_RoleURLwithID=Leading_or_Critical_RolePageURL+Leading_or_Critical_RoleID;
					 utilfunc.NavigatetoURL(Leading_or_Critical_RoleURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(EditbuttonXpath).click();
					} catch (Exception e1) {
						
					}
					 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Leading_or_Critical_RoleCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Leading_or_Critical_Role_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("OrganizationName")){							
							     try {
									utilfunc.MakeElement(NewXpath).sendKeys(NameofOrganization);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("RoleNature")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(PleaseprovidenatureofRole);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Title")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(ProjectTitle);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("EmployerName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(EmployerName);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("IsLeadingRole")){	
								 if(DidyouplayaLeadingradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
									
								}
					        	}
							 }
							 else if(AttributeName.equals("IsLeadingRoleDesc")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(DidyouplayaLeadingroledesc);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("OrganizationDesc")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Howtheorganization);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.contains("uploaderFile")){
								 
								 if(Fileupload.equals("Yes")){
								 try {
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
					 ////////////////////////Radio ////////////////////////////////////////////
					 int ObjCount1=utilfunc.GetObjectCount(radiocounterxpath);
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=radiofieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("IsSuccess")){		
								 if(WasthisProjectSuccessfulradio.equals("Yes")){
							     try {
							    	 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
							     try {
									utilfunc.MakeElement(SuccessDescxpath).sendKeys(WasthisProjectSuccessfuldesc);
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }else if(AttributeName.equals("IsLeadingRole")){
								 
								 if(IsLeadingRoleradio.equals("Yes")){
								     try {
								    	 Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
									} catch (Exception e) {
										
									}
								     try {
										utilfunc.MakeElement(SuccessDescxpath).sendKeys(WasthisProjectSuccessfuldesc);
									} catch (Exception e) {
										
									}
						        	}else{
						        		try {
						        			Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
										} catch (Exception e) {
											
										}
						        	}
								 
								 
								 
							 }
							 else if(AttributeName.equals("IsObtainReferenceLetters")){	
								 if(obtainreferencelettersradio.equals("Yes")){
								  try {
									  Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("IsDocProvided")){	
								 if(Canyouprovidedocumentationradio.equals("Yes")){
								  try {
									  Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[contains(@value,'true')]").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[contains(@value,'false')]").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					 /////////////////upload////////////////////////////////////
						try{
							if(Fileupload.equals("Yes")){
								utilfunc.MakeElement(showbuttonxpath).click();
								Thread.sleep(2000);
								utilfunc.MakeElement(uploadbuttonxpath).click();
								Thread.sleep(1000);    
					         utilfunc.uploadfile(fileuploadpath);
					         Thread.sleep(5000);
					         utilfunc.MakeElement(fileuploadbutton).click();
							 }
							
						}catch(Exception e){
							
						}
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e1) {
						
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
					 /*String Leading_or_Critical_RoleURLwithID=Leading_or_Critical_RolePageURL+Leading_or_Critical_RoleID;
					 utilfunc.NavigatetoURL(Leading_or_Critical_RoleURLwithID);*/
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
						 Thread.sleep(1000);
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
