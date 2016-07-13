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

public class CIMS_Residence_History_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static  String modulename="Residence_History Page Report";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	
	 //Constructor----------
	 
	 
		public CIMS_Residence_History_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Residence_History_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Residence_History", 0, ColumnCounter);
			String ResidenceHistoryScenerio=UtilFunction.getCellData("Test Data.xls", "Residence_History", 2, ColumnCounter);
			String ResidenceHistoryTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Residence_History", 3, ColumnCounter);		
			String ResidenceHistoryPageURL=UtilFunction.getCellData("Test Data.xls", "Residence_History", 4, ColumnCounter);
			String ResidenceHistoryID=UtilFunction.getCellData("Test Data.xls", "Residence_History", 5, ColumnCounter);
			
			String ResidenceHistoryLivedatFromDate=UtilFunction.getCellData("Test Data.xls", "Residence_History", 6, ColumnCounter);
			String ResidenceHistoryLivedatToDate=UtilFunction.getCellData("Test Data.xls", "Residence_History", 7, ColumnCounter);
			String ResidenceHistoryCountry=UtilFunction.getCellData("Test Data.xls", "Residence_History", 8, ColumnCounter);
			String ResidenceHistoryAddressLookup=UtilFunction.getCellData("Test Data.xls", "Residence_History", 9, ColumnCounter);
			String ResidenceHistoryStreetAddress=UtilFunction.getCellData("Test Data.xls", "Residence_History", 10, ColumnCounter);
			String ResidenceHistoryStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Residence_History", 11, ColumnCounter);
			String ResidenceHistoryAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Residence_History", 12, ColumnCounter);
			String ResidenceHistoryZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Residence_History", 13, ColumnCounter);
			String ResidenceHistorycitytownlocality=UtilFunction.getCellData("Test Data.xls", "Residence_History", 14, ColumnCounter);
			String ResidenceHistoryStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Residence_History", 15, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Residence_History", 16, ColumnCounter);
			
			String ResidenceHistory_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String ResidenceHistoryCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Residence History";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			
			testcaseid=TestcaseID;
			scenerio=ResidenceHistoryScenerio;
			description=ResidenceHistoryTestcaseDescription;
			
			
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 
					try{
						 /*String ResidenceHistoryURLwithID=ResidenceHistoryPageURL+ResidenceHistoryID;
						 
						 utilfunc.NavigatetoURL(ResidenceHistoryURLwithID);*/
					
						 utilfunc.NavigatetoURL(URLwithID);
						 
						 utilfunc.ServerErrorHandler();
						 
						 Thread.sleep(1000);
						 String AddbuttonXpath="//*[@class='btn']";
						 utilfunc.MakeElement(AddbuttonXpath).click();
						 Thread.sleep(1000);
						 
						 int ObjCount=utilfunc.GetObjectCount(ResidenceHistoryCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 Thread.sleep(300);
							 String NewXpath=ResidenceHistory_attributeFiledXpath.replace("xx", Integer.toString(count));
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 
								 if(AttributeName.equals("autocomplete")){							
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryAddressLookup);
								        utilfunc.mouseaction();
						        	}	
								 else if(AttributeName.equals("StartDate")){							
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatFromDate);
						        	}
								 else if(AttributeName.equals("EndDate")){							
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatToDate);
						        	}
								 else if(AttributeName.equals("CountryCode")){							
								        utilfunc.Selectdropdownvaluebyvalue(NewXpath, ResidenceHistoryCountry);
							 					        
						        	}
								 else if(AttributeName.equals("StreetAddress1")){							
								        //utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatFromDate);
									 	String sNewpath=".//*[@class='form-horizontal']//*[@class='control-group'][5]//*[@id]";
									 	String sNewpath1=".//*[@class='form-horizontal']//*[@class='control-group'][6]//*[@id]";
									 	utilfunc.MakeElement(sNewpath).sendKeys(ResidenceHistoryStreetAddress);
									 	utilfunc.MakeElement(sNewpath1).sendKeys(ResidenceHistoryStreetAddress);
						        	}
								 else if(AttributeName.equals("StreetAddress2")){							
									 	utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryStreetAddress2);
						        	}
								 else if(AttributeName.equals("UnitType")){							
									 	utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryAptSteFlr);
						        	}
								 else if(AttributeName.equals("PostalCode")){							
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryZipPostalCode);
						        	}
								 else if(AttributeName.equals("City")){		
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistorycitytownlocality);
						        	}
								 else if(AttributeName.equals("StateOrProvince")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryStateProvinceRegion);
						        	}
							 }catch(Exception e){
							 }
						 }
						 ////////////////additional info handled/////////////////
						 try {
							utilfunc.dynamic_data(ResidenceHistoryCounterXpath, ResidenceHistory_attributeFiledXpath);
						} catch (Exception e1) {

						}
						 
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

						
					}catch(Exception e){
					}
				 ///////////////edit mode start
			 }else if(mode.equals(ACTION1)){
				 
				 
					try{
						/* String ResidenceHistoryURLwithID=ResidenceHistoryPageURL+ResidenceHistoryID;
						 
						 utilfunc.NavigatetoURL(ResidenceHistoryURLwithID);*/
					
						 utilfunc.NavigatetoURL(URLwithID);
						 
						 utilfunc.ServerErrorHandler();
						 
						 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
						 utilfunc.MakeElement(EditbuttonXpath).click();
						 
						 int ObjCount=utilfunc.GetObjectCount(ResidenceHistoryCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewXpath=ResidenceHistory_attributeFiledXpath.replace("xx", Integer.toString(count));
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 
								 if(AttributeName.equals("autocomplete")){		
									 	utilfunc.MakeElement(NewXpath).clear();
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryAddressLookup);
								        utilfunc.mouseaction();
						        	}	
								 else if(AttributeName.equals("StartDate")){
									 utilfunc.MakeElement(NewXpath).clear();
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatFromDate);
						        	}
								 else if(AttributeName.equals("EndDate")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatToDate);
						        	}
								 else if(AttributeName.equals("CountryCode")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        utilfunc.Selectdropdownvaluebyvalue(NewXpath, ResidenceHistoryCountry);
							 					        
						        	}
								 else if(AttributeName.equals("StreetAddress1")){							
								        //utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryLivedatFromDate);
									 	String sNewpath=".//*[@class='form-horizontal']//*[@class='control-group'][5]//*[@id]";
									 	String sNewpath1=".//*[@class='form-horizontal']//*[@class='control-group'][6]//*[@id]";
									 	utilfunc.MakeElement(sNewpath).clear();
									 	utilfunc.MakeElement(sNewpath1).clear();
									 	utilfunc.MakeElement(sNewpath).sendKeys(ResidenceHistoryStreetAddress);
									 	utilfunc.MakeElement(sNewpath1).sendKeys(ResidenceHistoryStreetAddress);
						        	}
								 else if(AttributeName.equals("StreetAddress2")){	
									 	utilfunc.MakeElement(NewXpath).clear();
									 	utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryStreetAddress2);
						        	}
								 else if(AttributeName.equals("UnitType")){	
									 	utilfunc.MakeElement(NewXpath).clear();
									 	utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryAptSteFlr);
						        	}
								 else if(AttributeName.equals("PostalCode")){
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryZipPostalCode);
						        	}
								 else if(AttributeName.equals("City")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistorycitytownlocality);
						        	}
								 else if(AttributeName.equals("StateOrProvince")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(ResidenceHistoryStateProvinceRegion);
						        	}
							 }catch(Exception e){
							 }
						 }
						 ////////////////additional info handled/////////////////
						 utilfunc.dynamic_data(ResidenceHistoryCounterXpath, ResidenceHistory_attributeFiledXpath);
						 
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
					///delete mode start
			 }else if(mode.equals(ACTION2)){
				 try{
					 
					 /*String ResidenceHistoryURLwithID=ResidenceHistoryPageURL+ResidenceHistoryID;
					 
					 utilfunc.NavigatetoURL(ResidenceHistoryURLwithID);*/
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
