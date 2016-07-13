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

import CIMS.CIMS_MainProject;
import util.UtilFunction;

public class CIMS_AWARDS_MODULES {
	
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
public CIMS_AWARDS_MODULES(WebDriver driver,UtilFunction utilfunc) 
{
this.webdriver =driver;
this.utilfunc=utilfunc;		
// TODO Auto-generated constructor stub
}
/**
 * Verify that User is able to landed on the awards Page
 * 	
 * @throws AWTException
 * @throws InterruptedException
 */
		public boolean CIMS_AWARDS_ModulePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
		{
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "awards", 0, ColumnCounter);
		String Awards_Scenerio=UtilFunction.getCellData("Test Data.xls", "awards", 2, ColumnCounter);
		String Awards_TestcaseDescription=UtilFunction.getCellData("Test Data.xls", "awards", 3, ColumnCounter);		
		String Awards_PageURL=UtilFunction.getCellData("Test Data.xls", "awards", 4, ColumnCounter);
		String Awards_ID=UtilFunction.getCellData("Test Data.xls", "awards", 5, ColumnCounter);
			
		String Awards_name=UtilFunction.getCellData("Test Data.xls", "awards", 6, ColumnCounter);
		String Awards_date=UtilFunction.getCellData("Test Data.xls", "awards", 7, ColumnCounter);
		String Awardsorganization=UtilFunction.getCellData("Test Data.xls", "awards", 8, ColumnCounter);
		
		String Awards_achievementaward=UtilFunction.getCellData("Test Data.xls", "awards", 9, ColumnCounter);
		String Awards_recognition_of_your_excellence=UtilFunction.getCellData("Test Data.xls", "awards", 10, ColumnCounter);
		String Awards_Criteria=UtilFunction.getCellData("Test Data.xls", "awards", 11, ColumnCounter);
		String Awards_selection_process_available=UtilFunction.getCellData("Test Data.xls", "awards", 12, ColumnCounter);
		
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "awards", 13, ColumnCounter);
		String Fileupload=UtilFunction.getCellData("Test Data.xls", "awards", 14, ColumnCounter);
		//String Awards_selectioncopy=UtilFunction.getCellData("Test Data.xls", "awards", 12, ColumnCounter);
		
		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";
		
		////////////////Additional info handler ////////////////////
		String Xpathnew1=".//div/h4/..//*[@class='control-group']//*[@id]";
		String Xpathnew2=".//div/h4/..//*[@class='control-group'][xx]//*[@id]";
		
		
		
		String CitizenshipFieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
		String CounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
		
		///Radio handle XPATH
		String CitizenshipRadioFieldxpath="//*[@class='form-horizontal']//*[@class='question-group'][xx]//*[@name]";
		String RadioCounterXpath="//*[@class='form-horizontal']//*[@class='question-group']//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////
	
		String QuestionarieName="Awards";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
	 	URLwithID=utilfunc.geturldirect(QuestionarieName);
	
			 boolean Flag =false;
			testcaseid=TestcaseID;
			scenerio=Awards_Scenerio;
			description=Awards_TestcaseDescription;
			String ACTION="New";
			String ACTION1="Edit";
			String ACTION2="Delete";
	
			if(URLwithID.equals("")){
				utilfunc.closesidebar();
				Flag=false; 
			 }else{
			
			if(mode.equals(ACTION)){
				//1st try
				try{
				/*String AwardsURLwithID=Awards_PageURL+Awards_ID;
				utilfunc.NavigatetoURL(AwardsURLwithID);*/
				
				try{
					webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(1000);
					}catch(Exception error){}
				
				
				
				String AddbuttonXpath="//*[@class='btn']";
				try{
					utilfunc.MakeElement(AddbuttonXpath).click();
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.globalerrormessage="";
//					webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					
				}catch(Exception error){}
	
				
	
				 
				int ObjCount=utilfunc.GetObjectCount(CounterXpath);
				//////////////////
	try{
				for(int count=1; count<=ObjCount; count++)
				{
					Thread.sleep(300);
					//Label Printing
					String NewXpath=CitizenshipFieldxpath.replace("xx", Integer.toString(count));
					// String LabelName=utilfunc.MakeElement(NewXpath).getText();
			 
					try{
						String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute name "+count+"is : "+AttributeName);
				 
					 if(AttributeName.contains("Name")){			
							utilfunc.MakeElement(NewXpath).sendKeys(Awards_name);
						}
					 else if(AttributeName.contains("AwardedDate")){
						 	utilfunc.MakeElement(NewXpath).sendKeys(Awards_date);
						 	utilfunc.MakeElement("html").click();
					 	}
					 else if(AttributeName.contains("OrganizationName")){
						 utilfunc.MakeElement(NewXpath).sendKeys(Awardsorganization);
					 	}
					 
				 }catch(Exception z){
					 
				 	}
				 }
	}catch(Exception error){}
				
				////////////Radio XPATH//////////////////////
				int ObjCount1=utilfunc.GetObjectCount(RadioCounterXpath);
				//////////////////
				try{for(int count=1; count<=ObjCount1; count++)
				{
					String NewXpath=CitizenshipRadioFieldxpath.replace("xx", Integer.toString(count));
					
					try{
						String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute name "+count+"is : "+AttributeName);
						
						if(AttributeName.contains("IsAwarded")){			
							if(Awards_achievementaward.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
							Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
								}
							}
						else if(AttributeName.contains("IsExcellence")){
							if(Awards_recognition_of_your_excellence.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
								}
							}
						else if(AttributeName.contains("SelectionCriteria")){
						 	utilfunc.MakeElement(NewXpath).sendKeys(Awards_Criteria);
						}
						else if(AttributeName.contains("IsDocumentExists")){
							if(Awards_selection_process_available.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath1).click();
								Thread.sleep(800);
								}
						}
						
					}catch(Exception e){
						
					}
				}
				}catch(Exception error){}
				
				
				
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
					
			//function to call the dynamic text data
			try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);}catch(Exception error){}
			
			/*String SaveButtonXpath=".//*[@id='btnSave']";
			utilfunc.MakeElement(SaveButtonXpath).click();*/
			Thread.sleep(999);
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
				
			}catch (Exception e){
				
			}
			
	
			}else if(mode.equals(ACTION1)){
			//1st try
			try{
			/*String AwardsURLwithID=Awards_PageURL+Awards_ID;
			utilfunc.NavigatetoURL(AwardsURLwithID);*/
			
			utilfunc.NavigatetoURL(URLwithID);
			
			utilfunc.ServerErrorHandler();
			
			String editxpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
			utilfunc.MakeElement(editxpath).click();
		
			int ObjCount=utilfunc.GetObjectCount(CounterXpath);
			//////////////////
			for(int count=1; count<=ObjCount; count++)
			{
				//Label Printing
				String NewXpath=CitizenshipFieldxpath.replace("xx", Integer.toString(count));
				// String LabelName=utilfunc.MakeElement(NewXpath).getText();
		 
				try{
					String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
					System.out.println("Attribute name "+count+"is : "+AttributeName);
			 
				 if(AttributeName.contains("Name")){	
					 utilfunc.MakeElement(NewXpath).clear();
					 utilfunc.MakeElement(NewXpath).sendKeys(Awards_name);
						
					}
				 else if(AttributeName.contains("AwardedDate")){
					 utilfunc.MakeElement(NewXpath).clear();
					 utilfunc.MakeElement(NewXpath).sendKeys(Awards_date);
				 	}
				 else if(AttributeName.contains("OrganizationName")){
					 utilfunc.MakeElement(NewXpath).clear();
					 utilfunc.MakeElement(NewXpath).sendKeys(Awardsorganization);
				 	}
				 
			 }catch(Exception z){
				 
			 	}
			 }
			
			////////////Radio XPATH//////////////////////
				int ObjCount1=utilfunc.GetObjectCount(RadioCounterXpath);
				//////////////////
				for(int count=1; count<=ObjCount1; count++)
				{
					String NewXpath=CitizenshipRadioFieldxpath.replace("xx", Integer.toString(count));
					
					try{
						String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute name "+count+"is : "+AttributeName);
						
						if(AttributeName.contains("IsAwarded")){			
							if(Awards_achievementaward.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								utilfunc.MakeElement(NewXpath1).click();
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								utilfunc.MakeElement(NewXpath1).click();
								}
							}
						else if(AttributeName.contains("IsExcellence")){
							if(Awards_recognition_of_your_excellence.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								utilfunc.MakeElement(NewXpath1).click();
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								utilfunc.MakeElement(NewXpath1).click();
								}
							}
						else if(AttributeName.contains("SelectionCriteria")){
							utilfunc.MakeElement(NewXpath).clear();
						 	utilfunc.MakeElement(NewXpath).sendKeys(Awards_Criteria);
						}
						else if(AttributeName.contains("IsDocumentExists")){
							if(Awards_selection_process_available.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								utilfunc.MakeElement(NewXpath1).click();
							}else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								utilfunc.MakeElement(NewXpath1).click();
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
			
			
			//function to call the dynamic text data
			utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
			
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
			}catch (Exception e){
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
			/*String AwardsURLwithID=Awards_PageURL+Awards_ID;
			utilfunc.NavigatetoURL(AwardsURLwithID);*/
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
		
		
		
		
