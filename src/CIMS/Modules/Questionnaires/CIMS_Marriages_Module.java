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

public class CIMS_Marriages_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static  String modulename="Marriages Page Report";
	 public static String URLwithID="";
		//excel data fetch
		//Excel sheet Data collection
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 

	 //Constructor----------
	 
		public CIMS_Marriages_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		
		public boolean Marriages_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Marriages", 0, ColumnCounter);
			String MarriagesScenerio=UtilFunction.getCellData("Test Data.xls", "Marriages", 2, ColumnCounter);
			String MarriagesTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Marriages", 3, ColumnCounter);		
			String MarriagesPageURL=UtilFunction.getCellData("Test Data.xls", "Marriages", 4, ColumnCounter);
			String MarriagesID=UtilFunction.getCellData("Test Data.xls", "Marriages", 5, ColumnCounter);
			
			String MarriagesFirstname=UtilFunction.getCellData("Test Data.xls", "Marriages", 6, ColumnCounter);
			String Marriagesmiddlename=UtilFunction.getCellData("Test Data.xls", "Marriages", 7, ColumnCounter);
			String Marriageslastname=UtilFunction.getCellData("Test Data.xls", "Marriages", 8, ColumnCounter);
			String MarriagesMaidenOtherNames=UtilFunction.getCellData("Test Data.xls", "Marriages", 9, ColumnCounter);
			String MarriagesSpouseDateofBirth=UtilFunction.getCellData("Test Data.xls", "Marriages", 10, ColumnCounter);
			String MarriagesDateofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 11, ColumnCounter);
			String MarriagesCountryofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 12, ColumnCounter);
			String MarriagesCityofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 13, ColumnCounter);
			String MarriagesDateofTerminationofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 14, ColumnCounter);
			String MarriagesCountryofTerminationofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 15, ColumnCounter);
			String MarriagesCityofTerminationofMarriage=UtilFunction.getCellData("Test Data.xls", "Marriages", 16, ColumnCounter);
			String MarriagesReasonforTerminatione=UtilFunction.getCellData("Test Data.xls", "Marriages", 17, ColumnCounter);
			
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Marriages", 18, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Marriages", 19, ColumnCounter);

			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";
		
			String Marriages_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String MarriagesCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
			 
			String MarriagesNamexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			String MarriagesNamecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
		
			String QuestionarieName="Marriages";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			testcaseid=TestcaseID;
			scenerio=MarriagesScenerio;
			description=MarriagesTestcaseDescription;
			
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 
				 try{
					 /*String MarriagesURLwithID=MarriagesPageURL+MarriagesID;
					 
					 utilfunc.NavigatetoURL(MarriagesURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(800);
					 String AddbuttonXpath="//*[@class='btn']";
					try{ utilfunc.MakeElement(AddbuttonXpath).click();
					Thread.sleep(2000);
					}catch(Exception error){}
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(MarriagesNamecounterxpath);
					 int ObjCount1=utilfunc.GetObjectCount(MarriagesCounterXpath);
					 
					 //coded object count for name
					 for(int count=1; count<=3; count++)
					 {
						 String NewXpath=MarriagesNamexpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesFirstname);
							        utilfunc.mouseaction();
					        	}	
							 else if(AttributeName.equals("MiddleName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(Marriagesmiddlename);
					        	}
							 else if(AttributeName.equals("LastName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(Marriageslastname);
					        	}
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=Marriages_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("MaidenOrOtherNames")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesMaidenOtherNames);
							        utilfunc.mouseaction();
					        	}	
							 else if(AttributeName.equals("DateOfBirth")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesSpouseDateofBirth);
					        	}
							 else if(AttributeName.equals("DateOfMarriage")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesDateofMarriage);
					        	}
							 else if(AttributeName.equals("CountryOfMarriage")){							
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesCountryofMarriage);
					        	}
							 else if(AttributeName.equals("CityOfMarriage")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(MarriagesCityofMarriage);
					        	}
							 else if(AttributeName.equals("DateOfTermination")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesDateofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("CountryOfTermination")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesCountryofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("CityOfTermination")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesCityofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("ReasonForTermination")){							
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesReasonforTerminatione);
					        	}
							 else if(AttributeName.equals("MarriageDecreeDocumentId")){							
								 if(Fileupload.equals("Yes")){
									 /*utilfunc.MakeElement(showbuttonxpath).click();
										Thread.sleep(2000);
										utilfunc.MakeElement(uploadbuttonxpath).click();
										Thread.sleep(1000);    
							         utilfunc.uploadfile(fileuploadpath);
							         Thread.sleep(5000);
							         utilfunc.MakeElement(fileuploadbutton).click();*/
									 }
					        	}
							 else if(AttributeName.equals("MarriageCertificateDocumentId")){							
								 if(Fileupload.equals("Yes")){
									 utilfunc.MakeElement(".//*[@id='btnShowDocUpload2']").click();
										Thread.sleep(2000);
										utilfunc.MakeElement(".//*[@id='DocUploadModal']//*[@class='modal-body']//button[1]").click();
										Thread.sleep(1000);    
							         utilfunc.uploadfile(fileuploadpath);
							         Thread.sleep(5000);
							         utilfunc.MakeElement(fileuploadbutton).click();
									 }
					        	}
													 
							 
						 }catch(Exception f){
							 
						 }
						 
					 }
					 //////////////////Application info handled//////////////////////////////
					try{ utilfunc.dynamic_data(MarriagesCounterXpath, Marriages_attributeFiledXpath);}catch(Exception error){}
					 
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
					 
				 }catch(Exception e){
					 
				 }
				 
			 }else if(mode.equals(ACTION1)){
					 try{
					 /*String MarriagesURLwithID=MarriagesPageURL+MarriagesID;
					 
					 utilfunc.NavigatetoURL(MarriagesURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='question-group'][1]//*[@class='tblMarriage']//../td/a//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(MarriagesNamecounterxpath);
					 int ObjCount1=utilfunc.GetObjectCount(MarriagesCounterXpath);
					 
					 for(int count=1; count<=3; count++)
					 {
						 String NewXpath=MarriagesNamexpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){	
								  	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesFirstname);
							        utilfunc.mouseaction();
					        	}	
							 else if(AttributeName.equals("MiddleName")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(Marriagesmiddlename);
					        	}
							 else if(AttributeName.equals("LastName")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(Marriageslastname);
					        	}
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=Marriages_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("MaidenOrOtherNames")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesMaidenOtherNames);
							        utilfunc.mouseaction();
					        	}	
							 else if(AttributeName.equals("DateOfBirth")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesSpouseDateofBirth);
					        	}
							 else if(AttributeName.equals("DateOfMarriage")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesDateofMarriage);
					        	}
							 else if(AttributeName.equals("CountryOfMarriage")){							
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesCountryofMarriage);
					        	}
							 else if(AttributeName.equals("CityOfMarriage")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(MarriagesCityofMarriage);
					        	}
							 else if(AttributeName.equals("DateOfTermination")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesDateofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("CountryOfTermination")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesCountryofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("CityOfTermination")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(MarriagesCityofTerminationofMarriage);
					        	}
							 else if(AttributeName.equals("ReasonForTermination")){
								 	utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, MarriagesReasonforTerminatione);
					        	}
							 else if(AttributeName.equals("MarriageDecreeDocumentId")){							
								 if(Fileupload.equals("Yes")){
									 utilfunc.MakeElement(showbuttonxpath).click();
										Thread.sleep(2000);
										utilfunc.MakeElement(uploadbuttonxpath).click();
										Thread.sleep(1000);    
							         utilfunc.uploadfile(fileuploadpath);
							         Thread.sleep(5000);
							         utilfunc.MakeElement(fileuploadbutton).click();
									 }
					        	}
							 else if(AttributeName.equals("MarriageCertificateDocumentId")){							
								 if(Fileupload.equals("Yes")){
									 utilfunc.MakeElement(showbuttonxpath).click();
										Thread.sleep(2000);
										utilfunc.MakeElement(uploadbuttonxpath).click();
										Thread.sleep(1000);    
							         utilfunc.uploadfile(fileuploadpath);
							         Thread.sleep(5000);
							         utilfunc.MakeElement(fileuploadbutton).click();
									 }
					        	}
													 
							 
						 }catch(Exception f){
							 
						 }
						 
					 }
					 //////////////////Application info handled//////////////////////////////
					 utilfunc.dynamic_data(MarriagesCounterXpath, Marriages_attributeFiledXpath);
					 
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
					 
				 }catch(Exception e){
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
					 /*String MarriagesURLwithID=MarriagesPageURL+MarriagesID;
					 
					 utilfunc.NavigatetoURL(MarriagesURLwithID);*/
					  utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					
					 utilfunc.NavigatetoURL(URLwithID);
					
					 utilfunc.ServerErrorHandler();
					 
					 String DeletebuttonXpath=".//*[@class='question-group'][1]//*[@class='tblMarriage']//../td/a//*[@class='icon-trash']";
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
