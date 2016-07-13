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

public class CIMS_Publications_Authored_Module {
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
	 
		public CIMS_Publications_Authored_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Publications_Authored_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 0, ColumnCounter);
			String Publications_AuthoredScenerio=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 2, ColumnCounter);
			String Publications_AuthoredTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 3, ColumnCounter);		
			String Publications_AuthoredPageURL=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 4, ColumnCounter);
			String Publications_AuthoredID=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 5, ColumnCounter);
			
			String Completecitation=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 6, ColumnCounter);
			String Wasthispeerreviewedradio=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 7, ColumnCounter);
			String Isthispublicationininternationalradio=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 8, ColumnCounter);
			String NumberofCitations=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 9, ColumnCounter);
			String Areyouabletoprovidecopyradio=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 10, ColumnCounter);
			
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 11, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Publications_Authored", 12, ColumnCounter);

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
			
			String Publications_Authored_attributeFiledXpath=".//*[@class='question-group']//*[@class='control-group'][xx]//*[@name]";
			String Publications_AuthoredCounterXpath=".//*[@class='question-group']//*[@class='control-group']//*[@name]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Publications Authored and Citations Of Your Work";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Publications_AuthoredScenerio;
			 description=Publications_AuthoredTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			
			 if(mode.equals(ACTION)){
				 try{
					 /*String Publications_AuthoredURLwithID=Publications_AuthoredPageURL+Publications_AuthoredID;
					 utilfunc.NavigatetoURL(Publications_AuthoredURLwithID);*/
			
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
//					String QuestionGourpXpath =".//*[@id='formHorizontal1']//*[@class='question-group'][xx]//*[@class='controls']//input[@name]";
//					String QuestionGourpcounterXpath =".//*[@id='formHorizontal1']//*[@class='question-group']//*[@class='controls']//input[@name]";
//					
//					int ResultCount=utilfunc.GetObjectCount(QuestionGourpcounterXpath);
					
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(AddbuttonXpath).click();
					} catch (Exception e2) {
						
					}
					 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					 
					 Thread.sleep(10000);
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Publications_AuthoredCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Publications_Authored_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CompleteCitation")){			
								 utilfunc.MakeElement(NewXpath).clear();
							    utilfunc.MakeElement(NewXpath).sendKeys(Completecitation);
					        	}	
							 else if(AttributeName.equals("PeerReviewed")){	
								 
								 if(Wasthispeerreviewedradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
									
								}
					        	}
							 }
							 else if(AttributeName.equals("InternationalCirculation")){	
								 if(Isthispublicationininternationalradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
								}
					        	}
							 }
							 else if(AttributeName.equals("NumberofCitations")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(NumberofCitations);
					        	}
							 else if(AttributeName.equals("CopyAvailable")){
								 if(Areyouabletoprovidecopyradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {								}
					        	}
							 }
							 
						 }catch(Exception e){
							 
						 }
					 }
					 ////upload file///////////////////////////////////////////////////////////
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
					 /*String Publications_AuthoredURLwithID=Publications_AuthoredPageURL+Publications_AuthoredID;
					 utilfunc.NavigatetoURL(Publications_AuthoredURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					 Thread.sleep(10000);
					 
					 int ObjCount=utilfunc.GetObjectCount(Publications_AuthoredCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Publications_Authored_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CompleteCitation")){			
								 utilfunc.MakeElement(NewXpath).clear();
							    utilfunc.MakeElement(NewXpath).sendKeys(Completecitation);
					        	}	
							 else if(AttributeName.equals("PeerReviewed")){	
								 if(Wasthispeerreviewedradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
								}
					        	}
							 }
							 else if(AttributeName.equals("InternationalCirculation")){	
								 if(Isthispublicationininternationalradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
								}
					        	}
							 }
							 else if(AttributeName.equals("NumberofCitations")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(NumberofCitations);
					        	}
							 else if(AttributeName.equals("CopyAvailable")){
								 if(Areyouabletoprovidecopyradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
								}
					        	}
							 }
							 
						 }catch(Exception e){
							 
						 }
					 }
					 
					///upload file///////////////////////////////////////////////////////////
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
					 /*String Publications_AuthoredURLwithID=Publications_AuthoredPageURL+Publications_AuthoredID;
					 utilfunc.NavigatetoURL(Publications_AuthoredURLwithID);*/
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
