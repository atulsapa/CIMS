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

public class CIMS_Medical_Treatment_Module {
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
	 
		public CIMS_Medical_Treatment_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Medical_Treatment_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 0, ColumnCounter);
			String Medical_TreatmentScenerio=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 2, ColumnCounter);
			String Medical_TreatmentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 3, ColumnCounter);		
			String Medical_TreatmentPageURL=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 4, ColumnCounter);
			String Medical_TreatmentID=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 5, ColumnCounter);
			
			String HasMedicalTreatmentradio=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 6, ColumnCounter);
			String IsPayTreatmentradio=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 7, ColumnCounter);
			String WhereReceiveTreatment=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 8, ColumnCounter);
			String NameOfTreatment=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 9, ColumnCounter);
			String AddressLookup=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 10, ColumnCounter);
			String StreetAddress=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 11, ColumnCounter);
			String locality=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 12, ColumnCounter);
			String StateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 13, ColumnCounter);
			String PostalCode=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 14, ColumnCounter);
			String PhoneNumber=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 15, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Medical_Treatment", 16, ColumnCounter);
			
			String addreslookupxpath=".//*[@id='dvHasMedicalTreatment_']//*[@class='question-group-address']//*[@id]";
			
			String HasMedicalTreatment=".//*[@class='form-horizontal']/*[@class='question-group']//*[@id]";
			
			String IsPayTreatment=".//*[@id='dvHasMedicalTreatment_']/*[@class='question-group']//*[@id]";
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
			
			String Medical_Treatment_attributeFiledXpath=".//*[@id='dvHasMedicalTreatment_']/*[@class='control-group'][xx]//*[@id]";
			String Medical_TreatmentCounterXpath=".//*[@id='dvHasMedicalTreatment_']/*[@class='control-group']//*[@id]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Medical Treatment";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			 URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Medical_TreatmentScenerio;
			 description=Medical_TreatmentTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION) | mode.equals(ACTION1)){
				 
				 /*String Medical_TreatmentURLwithID=Medical_TreatmentPageURL+Medical_TreatmentID;
				 utilfunc.NavigatetoURL(Medical_TreatmentURLwithID);*/
				 
				 utilfunc.NavigatetoURL(URLwithID);				 
				 utilfunc.ServerErrorHandler();
				 Thread.sleep(2000);
				 ///////////////////Have you ever received medical treatment in the ? //////////////
				try{
				 if(HasMedicalTreatmentradio.equals("Yes")){
					try{
					 //String NewXpath1=HasMedicalTreatment.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
						String NewXpath1=HasMedicalTreatment.replace("//*[@id]", "//*[@id='HasMedicalTreatment' and contains(@value,'rue')]");
						
					 Thread.sleep(1000);
					 utilfunc.MakeElement(NewXpath1).click();
					 Thread.sleep(1000);
					 
					 ////////////////////////Did you have to pay for the treatment?/////////////////////////
					 if(IsPayTreatmentradio.equals("Yes")){
						try{ 
							//String NewXpath2=IsPayTreatment.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
							String NewXpath2=IsPayTreatment.replace("//*[@id]", "//*[@id='IsPayTreatment' and contains(@value,'rue')]");
						Thread.sleep(1000);
						utilfunc.MakeElement(NewXpath2).click();
						Thread.sleep(1000);
						}catch(Exception error){}
					 }else if(IsPayTreatmentradio.equals("No")){
						 try{
						 String NewXpath2=IsPayTreatment.replace("//*[@id]", "//*[@id='IsPayTreatment' and contains(@value,'alse')]");
						 Thread.sleep(1000);
						 utilfunc.MakeElement(NewXpath2).click();
						 Thread.sleep(1000);
						 }catch(Exception error){}
					 }
					 ///////////////////////////////////////////////////////////////////////////////////////
					 try{
						 int ObjCount=utilfunc.GetObjectCount(Medical_TreatmentCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 Thread.sleep(300);
							 String NewXpath=Medical_Treatment_attributeFiledXpath.replace("xx", Integer.toString(count));
							 
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 //System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("WhereReceiveTreatment")){
								try{
									utilfunc.MakeElement(NewXpath).clear();						
									 utilfunc.MakeElement(NewXpath).sendKeys(WhereReceiveTreatment);
								 }catch(Exception error){}
								 }	
								 else if(AttributeName.equals("NameOfTreatment")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(NameOfTreatment);
								 }catch(Exception error){}
								 }
								 else if(AttributeName.equals("route")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress);
								 }catch(Exception error){}
								 }
								 else if(AttributeName.equals("locality")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(locality);
								 }catch(Exception error){}
								 }
								 else if(AttributeName.equals("administrative_area_level_1")){		
								try{
									utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(StateProvinceRegion);
								 }catch(Exception error){}
								 }
								 else if(AttributeName.equals("postal_code")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(PostalCode);
								 }catch(Exception error){}
								 }
								 else if(AttributeName.equals("Number")){		
								try{
									utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(PhoneNumber);
								 }catch(Exception error){}
								 } 
							 }catch(Exception e){	 }
						 }
						 //////////////////////////////////////address lookup////////////////////////////////
						 try{
							 String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("id");
							 if(AttributeName.contains("form2_autocomplete")){	
								try{ 
									utilfunc.MakeElement(addreslookupxpath).clear();
								 utilfunc.MakeElement(addreslookupxpath).sendKeys(AddressLookup);
								 utilfunc.mouseaction();
								}catch(Exception error){}
							 }
						 }
						 catch(Exception f){
						 }
					 }catch(Exception e){
						 
					 }
				 }catch(Exception e){utilfunc.NavigatetoURL(URLwithID); }
				 }else if(HasMedicalTreatmentradio.equals("No")){
				try{
					 String NewXpath1=HasMedicalTreatment.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
					 Thread.sleep(1000);
					 utilfunc.MakeElement(NewXpath1).click();
				}catch(Exception error){}
				 }
			 //catch
			 }catch(Exception e){
			 }
				 //////////////////////Additional info handle///////////////////////////////
				try{ utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
				}catch(Exception error){}
				
				try{
				 utilfunc.savebutton();
				}catch(Exception error){}
			        
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
						Thread.sleep(2000);
						
						try{
						String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
						utilfunc.MakeElement(deletexpath).click();
						Thread.sleep(3000);
						utilfunc.isAlertPresent();
						}catch(Exception error){}
						
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in Medical Treatment Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				 
				
				 }///////////url ckeck end
			 
			
			 return Flag;
	 	}

}
