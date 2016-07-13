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

import CIMS.CIMS_MainProject;
import util.UtilFunction;

public class CIMS_Commercial_Success_Module
{
	
	
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
	 
		public CIMS_Commercial_Success_Module(WebDriver driver,UtilFunction utilfunc) 
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
	 public boolean Commercial_SuccessPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{	

		//Commercial_Success Page	

		//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 0, ColumnCounter);
			String Commercial_SuccessScenerio=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 2, ColumnCounter);
			String Commercial_SuccessTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 3, ColumnCounter);		
			String Commercial_SuccessPageURL=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 4, ColumnCounter);
			String Commercial_SuccessID=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 5, ColumnCounter);	
			
			String Commercial_SuccessNameofproject=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 6, ColumnCounter);
			String Commercial_SuccessGrossboxofficereceipt=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 7, ColumnCounter);
			String Commercial_SuccessWastheCommercialSuccess =UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 8, ColumnCounter);
			String Commercial_SuccessIsareferenceavailable=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 9, ColumnCounter);
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 10, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 11, ColumnCounter);
			
		/////upload document popup element value(s)/////////////////
					//String Fileupload=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 19, ColumnCounter);
					String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 12, ColumnCounter);
					String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Commercial_Success", 13, ColumnCounter);
					String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Commercial_Success",14, ColumnCounter);
					//////////////////Pop-up window controls xpath/////////////////////////////
					String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
					String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
					String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
					String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";
					String fileuploadbutton=".//*[@id='btnUploadDocuments']";

			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			//String fileuploadbutton=".//*[@id='btnUploadDocuments']";
		
			String Commercial_sucessfieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String Commercial_sucesscounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			

			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";
		 
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Commercial Success";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			 boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Commercial_SuccessScenerio;
			 description=Commercial_SuccessTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 
			 if(mode.equals(ACTION)){
				 try{
				 /*String Commercial_SuccessURLwithID=Commercial_SuccessPageURL+Commercial_SuccessID;
				 utilfunc.NavigatetoURL(Commercial_SuccessURLwithID);*/
				 
				
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
				 String AddbuttonXpath="//*[@class='btn']";
			try{	 utilfunc.MakeElement(AddbuttonXpath).click();
			Thread.sleep(2000);
			}catch(Exception error){}
				 
				 int ObjCount=utilfunc.GetObjectCount(Commercial_sucesscounterxpath);
				 try{
				 for(int count=1; count<=ObjCount; count++)
				 {
					 Thread.sleep(400);
					 String NewXpath=Commercial_sucessfieldxpath.replace("xx", Integer.toString(count));
					 
					 try{
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.equals("ProjectName")){							
						     utilfunc.MakeElement(NewXpath).sendKeys(Commercial_SuccessNameofproject);
				        	}	
						 else if(AttributeName.equals("ReceiptDescription")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(Commercial_SuccessGrossboxofficereceipt);
				        	}
						 else if(AttributeName.equals("IsDirectResult")){
							 if(Commercial_SuccessWastheCommercialSuccess.equals("Yes")){
							 try{
								 String nEwxpath=".//*[@class='form-horizontal']//*[@class='control-group'][3]//*[@class='radio inline']//input[@value='true']"; 
								 utilfunc.MakeElement(nEwxpath).click();
								 }catch(Exception error){}
							 }
							 else{
								 try{
									 String nEwxpath=".//*[@class='form-horizontal']//*[@class='control-group'][3]//*[@class='radio inline']//input[@value='false']"; 
								 utilfunc.MakeElement(nEwxpath).click();
								 }catch(Exception error){}
							 }
				        	}
						 else if(AttributeName.equals("HasReference")){
							 if(Commercial_SuccessIsareferenceavailable.equals("Yes")){
								 try{
									 String nEwxpath=".//*[@class='form-horizontal']//*[@class='control-group'][4]//*[@class='radio inline']//input[@value='true']"; 
									 utilfunc.MakeElement(nEwxpath).click();
									 }catch(Exception error){}
								 }
								 else{
									 try{
										 String nEwxpath=".//*[@class='form-horizontal']//*[@class='control-group'][4]//*[@class='radio inline']//input[@value='false']"; 
									 utilfunc.MakeElement(nEwxpath).click();
									 }catch(Exception error){}
								 }
				        	}
						 else if(AttributeName.contains("uploaderFile")){
							 
							 /*if(Fileupload.equals("Yes")){
							 utilfunc.MakeElement(uploadbuttonxpath).click();
							 utilfunc.uploadfile(fileuploadpath);
							 	}*/
							  }
					 }catch(Exception e){
						 
					 }
				 }
				 }catch(Exception error){}
				 /////////////////upload////////////////////////////////////
					try{
						/*if(Fileupload.equals("Yes")){
							utilfunc.MakeElement(showbuttonxpath).click();
							Thread.sleep(2000);
							utilfunc.MakeElement(uploadbuttonxpath).click();
							Thread.sleep(1000);    
				         utilfunc.uploadfile(fileuploadpath);
				         Thread.sleep(5000);
				         utilfunc.MakeElement(fileuploadbutton).click();
						 }*/
						
					}catch(Exception e){
						
					}
					
//////////////////  Add Document (Upload file)//////////////////////
System.out.println("we are going to work with upload document.\n Please Wait...");
					Thread.sleep(5000);


					try{
						if(Fileupload.equals("Yes")){
							try{utilfunc.MakeElement(showbuttonxpath).click();}catch(Exception error){}
							Thread.sleep(3000);
							try{utilfunc.MakeElement(uploadbuttonxpath).click();}catch(Exception error){}
							Thread.sleep(3000);    
							try{utilfunc.uploadfile(fileuploadpath);}catch(Exception error){}
							Thread.sleep(5000);
							///////////// ----Fill the pop-up window which appears after document upload--- ////////////////
							try{

								int elementcounter=utilfunc.GetObjectCount(DocumentUploadControlcounterxpath);
								//							System.out.println("\t--->Element counter :"+elementcounter);

								for(int count=1;count<=elementcounter;count++)
								{
									Thread.sleep(2000);
									if(count>=3)
									{
										DocumentUploadControlsxpath=DocumentUploadControlsxpath.replace("//*[@name]",DocumentUploadUpdatexpath);
									}
									String docuattribute="";
									String DocumentUploadControlsxpathcopy="";
									try{
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpath);
										DocumentUploadControlsxpathcopy=DocumentUploadControlsxpath;
										DocumentUploadControlsxpathcopy=DocumentUploadControlsxpathcopy.replace("xyz",Integer.toString(count));
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpathcopy);
										docuattribute=utilfunc.MakeElement(DocumentUploadControlsxpathcopy).getAttribute("name");
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpathcopy);
										//									System.out.println("Attribute is :"+docuattribute);
									}catch(Exception error){}

									if(docuattribute.contains("fld-title"))
									{
										///Document Name
										try{
											utilfunc.MakeElement(DocumentUploadControlsxpathcopy).sendKeys(Education_HistoryDocumentUploadPopUpDocName);
										}catch(Exception error){}
									}
									else if(docuattribute.contains("BalNumber1"))
									{
										///Project associate
										try{
											System.out.println("Education_HistoryDocumentUploadPopUpProjectAssociated :"+Education_HistoryDocumentUploadPopUpProjectAssociated+":");
											Thread.sleep(1000);
											try{
												utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, Education_HistoryDocumentUploadPopUpProjectAssociated);
												Thread.sleep(2000);
												try{
													utilfunc.MakeElement(DocumentUploadProjectAssociAddBtnxpath).click();
												}catch(Exception error){
													System.out.println("Unable to click add button");
												}
											}catch(Exception error){
												System.out.println("Unable to select value in Project Associate dropdown");
											}


										}catch(Exception error){}
									}
									else if(docuattribute.contains("fld-documentHighSecurity"))
									{
										///Document Visibility
										try{
											utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, Education_HistoryDocumentUploadPopUpDocVisibility);
										}catch(Exception error){}
									}


								}

								Thread.sleep(5000);
								utilfunc.MakeElement(fileuploadbutton).click();
								Thread.sleep(2000);

							}catch(Exception error){}
						}
					}catch(Exception error){}

					try{
						utilfunc.MakeElement(".//*[@id='DocUploadModal']//*[@class='close']").click();
						Thread.sleep(2000);
					}catch(Exception error){}
					
					
					
				 //////////////////////Additional info handle///////////////////////////////
				 try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);}catch(Exception error){}
				 
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
				 }else if (error_flag.equals("")){
					 Flag=true;
				 }else if(error_flag.equals("Server Error in '/' Application.")){
					 Flag=false;
					 webdriver.navigate().back();
				 }else{
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
				
				 
			 }
				
				 catch(Exception Ex){
					 
				 }
		 }else if(mode.equals(ACTION1)){
			 try{
				/* String Commercial_SuccessURLwithID=Commercial_SuccessPageURL+Commercial_SuccessID;
				 
				 utilfunc.NavigatetoURL(Commercial_SuccessURLwithID);*/
				 
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
				 utilfunc.MakeElement(EditbuttonXpath).click();
				 
				 
				 int ObjCount=utilfunc.GetObjectCount(Commercial_sucesscounterxpath);
				 
				 for(int count=1; count<=ObjCount; count++)
				 {
					 String NewXpath=Commercial_sucessfieldxpath.replace("xx", Integer.toString(count));
					 
					 try{
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.equals("ProjectName")){	
							 utilfunc.MakeElement(NewXpath).clear();
						     utilfunc.MakeElement(NewXpath).sendKeys(Commercial_SuccessNameofproject);
				        	}	
						 else if(AttributeName.equals("ReceiptDescription")){
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(Commercial_SuccessGrossboxofficereceipt);
				        	}
						 else if(AttributeName.equals("IsDirectResult")){
							 if(Commercial_SuccessWastheCommercialSuccess.equals("Yes")){
							 utilfunc.MakeElement(NewXpath).click();
							 }
				        	}
						 else if(AttributeName.equals("HasReference")){
							 if(Commercial_SuccessIsareferenceavailable.equals("Yes")){
							 utilfunc.MakeElement(NewXpath).click();
							 }
				        	}
						 else if(AttributeName.contains("uploaderFile")){
							 
							 if(Fileupload.equals("Yes")){
							 utilfunc.MakeElement(uploadbuttonxpath).click();
							 utilfunc.uploadfile(fileuploadpath);
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
				 }else if(error_flag.equals("Server Error in '/' Application.")){
					 Flag=false;
					 webdriver.navigate().back();
				 }else{
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
				
				 
			 }
				
				 catch(Exception Ex){
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
				 /*String Commercial_SuccessURLwithID=Commercial_SuccessPageURL+Commercial_SuccessID;
				 
				 utilfunc.NavigatetoURL(Commercial_SuccessURLwithID);*/
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
				 utilfunc.MakeElement(DeletebuttonXpath).click();
				 
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

		
	
		