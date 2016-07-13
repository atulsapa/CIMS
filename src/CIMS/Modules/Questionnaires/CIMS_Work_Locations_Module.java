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

public class CIMS_Work_Locations_Module {
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
	 
		public CIMS_Work_Locations_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Work_Locations_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 0, ColumnCounter);
			String Work_LocationsScenerio=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 2, ColumnCounter);
			String Work_LocationsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 3, ColumnCounter);		
			String Work_LocationsPageURL=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 4, ColumnCounter);
			String Work_LocationsID=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 5, ColumnCounter);
			
			String Work_LocationsTypeofLocation=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 6, ColumnCounter);
			String Work_LocationsStartDate=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 7, ColumnCounter);
			String Work_LocationsEnddate=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 8, ColumnCounter);
			String Work_LocationsCountry=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 9, ColumnCounter);
			String Work_LocationsAddressLookup=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 10, ColumnCounter);
			String Work_LocationsStreetAddress=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 11, ColumnCounter);
			String Work_LocationsStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 12, ColumnCounter);
			String Work_LocationsAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 13, ColumnCounter);
			String Work_LocationsCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 14, ColumnCounter);
			String Work_LocationsStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 15, ColumnCounter);
			String Work_LocationsZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 16, ColumnCounter);
			String Work_LocationsPrimaryLocation=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 17, ColumnCounter);
			String Work_LocationsPercentageoftimespentatthislocation=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 18, ColumnCounter);
			String Work_LocationsLocationRemarks=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 19, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Work_Locations", 20, ColumnCounter);
			
			String Work_Locations_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String Work_LocationsCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
			
			String Work_locationaddresslookup=".//*[@class='form-horizontal']//*[@class='question-group-address']//*[@id]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Work Locations";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Work_LocationsScenerio;
			 description=Work_LocationsTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Work_LocationsURLwithID=Work_LocationsPageURL+Work_LocationsID;
					 utilfunc.NavigatetoURL(Work_LocationsURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 Thread.sleep(5000);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 utilfunc.MakeElement(AddbuttonXpath).click();
					 
					/* utilfunc.isAlertPresent();
					 
					 Thread.sleep(10000);*/
					 
					 int ObjCount=utilfunc.GetObjectCount(Work_LocationsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Work_Locations_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("LocationType")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Work_LocationsTypeofLocation);
					        	}	
							 else if(AttributeName.equals("StartDate")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStartDate);
					        	}
							 else if(AttributeName.equals("EndDate")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsEnddate);
					        	}
							 else if(AttributeName.equals("country")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Work_LocationsCountry);
					        	}
							 else if(AttributeName.equals("route")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStreetAddress);
					        	}
							 else if(AttributeName.equals("StreetAddress2")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStreetAddress2);
					        	}
							 else if(AttributeName.equals("UnitType")){	
								 String Newpath=NewXpath+"[1]";
								 utilfunc.Selectdropdownvaluebyvalue(Newpath, Work_LocationsAptSteFlr);
								 
								 String Newpath1=NewXpath+"[2]";
								 utilfunc.MakeElement(Newpath1).sendKeys(Work_LocationsAptSteFlr);
					        	}
							 else if(AttributeName.equals("locality")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsCityTownLocality);
					        	}
							 else if(AttributeName.equals("EntryDenied")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("administrative_area_level_1")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStateProvinceRegion);
					        	}
							 else if(AttributeName.equals("postal_code")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsZipPostalCode);
					        	}
							 else if(AttributeName.equals("IsPrimary")){	
								 if(Work_LocationsPrimaryLocation.equals("checked")){
									 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("TimeSpentPercentage")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsPercentageoftimespentatthislocation);
					        	}
							 else if(AttributeName.equals("Note")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsLocationRemarks);
					        	}
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(Work_locationaddresslookup).getAttribute("id");
						 if(AttributeName.contains("autocomplete")){			
							 utilfunc.MakeElement(Work_locationaddresslookup).sendKeys(Work_LocationsAddressLookup);
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(Work_LocationsCounterXpath, Work_Locations_attributeFiledXpath);
					 
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
					 /*String Work_LocationsURLwithID=Work_LocationsPageURL+Work_LocationsID;
					 utilfunc.NavigatetoURL(Work_LocationsURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Work_LocationsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Work_Locations_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("LocationType")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Work_LocationsTypeofLocation);
					        	}	
							 else if(AttributeName.equals("StartDate")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStartDate);
					        	}
							 else if(AttributeName.equals("EndDate")){	
								 utilfunc.MakeElement(NewXpath).clear();					
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsEnddate);
					        	}
							 else if(AttributeName.equals("country")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Work_LocationsCountry);
					        	}
							 else if(AttributeName.equals("route")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStreetAddress);
					        	}
							 else if(AttributeName.equals("StreetAddress2")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStreetAddress2);
					        	}
							 else if(AttributeName.equals("UnitType")){	
								 String Newpath=NewXpath+"[1]";
								 utilfunc.Selectdropdownvaluebyvalue(Newpath, Work_LocationsAptSteFlr);
								 
								 String Newpath1=NewXpath+"[2]";
								 utilfunc.MakeElement(Newpath1).clear();
								 utilfunc.MakeElement(Newpath1).sendKeys(Work_LocationsAptSteFlr);
					        	}
							 else if(AttributeName.equals("locality")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsCityTownLocality);
					        	}
							 else if(AttributeName.equals("EntryDenied")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("administrative_area_level_1")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsStateProvinceRegion);
					        	}
							 else if(AttributeName.equals("postal_code")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsZipPostalCode);
					        	}
							 else if(AttributeName.equals("IsPrimary")){	
								 if(Work_LocationsPrimaryLocation.equals("checked")){
									 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("TimeSpentPercentage")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsPercentageoftimespentatthislocation);
					        	}
							 else if(AttributeName.equals("Note")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Work_LocationsLocationRemarks);
					        	}
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(Work_locationaddresslookup).getAttribute("id");
						 if(AttributeName.contains("autocomplete")){			
							 utilfunc.MakeElement(Work_locationaddresslookup).sendKeys(Work_LocationsAddressLookup);
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(Work_LocationsCounterXpath, Work_Locations_attributeFiledXpath);
					 
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
					 /*String Work_LocationsURLwithID=Work_LocationsPageURL+Work_LocationsID;
					 utilfunc.NavigatetoURL(Work_LocationsURLwithID);*/
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
