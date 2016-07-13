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

public class CIMS_Family_Members_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String ErrorMessage4="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	 
	 //Constructor----------
	 
		public CIMS_Family_Members_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Family_Members_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Family_Members", 0, ColumnCounter);
			String FamilyMembersScenerio=UtilFunction.getCellData("Test Data.xls", "Family_Members", 2, ColumnCounter);
			String FamilyMembersTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Family_Members", 3, ColumnCounter);		
			String FamilyMembersPageURL=UtilFunction.getCellData("Test Data.xls", "Family_Members", 4, ColumnCounter);
			String FamilyMembersID=UtilFunction.getCellData("Test Data.xls", "Family_Members", 5, ColumnCounter);
			
			String FamilyMembersPrincipalRelationship=UtilFunction.getCellData("Test Data.xls", "Family_Members", 6, ColumnCounter);
			String FamilyMembersFirstname=UtilFunction.getCellData("Test Data.xls", "Family_Members", 7, ColumnCounter);
			String FamilyMembersmiddlename=UtilFunction.getCellData("Test Data.xls", "Family_Members", 8, ColumnCounter);
			String FamilyMemberslastname=UtilFunction.getCellData("Test Data.xls", "Family_Members", 9, ColumnCounter);
			String FamilyMembersMaidenOtherNames=UtilFunction.getCellData("Test Data.xls", "Family_Members", 10, ColumnCounter);
			String FamilyMembersDateofBirth=UtilFunction.getCellData("Test Data.xls", "Family_Members", 11, ColumnCounter);
			String FamilyMembersCountryofBirth=UtilFunction.getCellData("Test Data.xls", "Family_Members", 12, ColumnCounter);
			String FamilyMembersStateProvinceofBirth=UtilFunction.getCellData("Test Data.xls", "Family_Members", 13, ColumnCounter);
			String FamilyMembersCityofBirth=UtilFunction.getCellData("Test Data.xls", "Family_Members", 14, ColumnCounter);
			String FamilyMembersCountryofResidence=UtilFunction.getCellData("Test Data.xls", "Family_Members", 15, ColumnCounter);
			String FamilyMembersStateProvinceofResidence=UtilFunction.getCellData("Test Data.xls", "Family_Members", 16, ColumnCounter);
			String FamilyMembersCityofResidence=UtilFunction.getCellData("Test Data.xls", "Family_Members", 17, ColumnCounter);
			String FamilyMembersCitizenship=UtilFunction.getCellData("Test Data.xls", "Family_Members", 18, ColumnCounter);
			String FamilyMembersDeceased=UtilFunction.getCellData("Test Data.xls", "Family_Members", 19, ColumnCounter);
			String FamilyMembersDateDeceased=UtilFunction.getCellData("Test Data.xls", "Family_Members", 20, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Family_Members", 21, ColumnCounter);
			
			String FamilyMembers_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String FamilyMembersCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			 
			String FamilyMembersNamexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			String FamilyMembersNamecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";
			String addbuttonxpathforcitizenship=".//*[@id='btnAddCitzenship']";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Family Members";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			testcaseid=TestcaseID;
			scenerio=FamilyMembersScenerio;
			description=FamilyMembersTestcaseDescription;
		
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String FamilyMembersURLwithID=FamilyMembersPageURL+FamilyMembersID;
					 
					 utilfunc.NavigatetoURL(FamilyMembersURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(1000);
					 //String AddbuttonXpath="//*[@class='btnAddNew']";
					 String AddbuttonXpath="//*[@id='btnAddNew']";
					try{ 
						utilfunc.MakeElement(AddbuttonXpath).click();
					Thread.sleep(2000);
					}catch(Exception error){}
					 
					
					 int ObjCount=utilfunc.GetObjectCount(FamilyMembersNamecounterxpath);
					 int ObjCount1=utilfunc.GetObjectCount(FamilyMembersCounterXpath);
					 try{
					 for(int count=1; count<=ObjCount; count++)
					 {
						 Thread.sleep(300);
						 String NewXpath=FamilyMembersNamexpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersFirstname);
					        	}	
							 else if(AttributeName.equals("MiddleName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersmiddlename);
					        	}
							 else if(AttributeName.equals("LastName")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMemberslastname);
					        	}
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
				 }catch(Exception error){}
					 try{
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=FamilyMembers_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("RelationshipToPrincipal")){							
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersPrincipalRelationship);
					        	}	
							 else if(AttributeName.equals("MaidenOrOtherNames")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersMaidenOtherNames);
					        	}
							 else if(AttributeName.equals("DateOfBirth")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersDateofBirth);
					        	}
							 else if(AttributeName.equals("CountryOfBirth")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCountryofBirth);
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfBirth")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersStateProvinceofBirth);
					        	}
							 else if(AttributeName.equals("CityOfBirth")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersCityofBirth);
					        	}
							 else if(AttributeName.equals("CountryOfResidence")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCountryofResidence);
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfResidence")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersStateProvinceofResidence);
					        	}
							 else if(AttributeName.equals("CityOfResidence")){							
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersCityofResidence);
					        	}
							 else if(AttributeName.equals("CountryCode")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCitizenship);
								 Thread.sleep(1000);
								 utilfunc.MakeElement(addbuttonxpathforcitizenship).click();
								 Thread.sleep(1000);
					        	}
							 else if(AttributeName.equals("Deceased")){							
								 Thread.sleep(1000);
								 utilfunc.MakeElement(NewXpath).click();
								 Thread.sleep(1000);
					        	}
							 
							 
						 }catch(Exception f){
							 
						 }
					 }
					 }catch(Exception error){}
					 //Lokesh try this in case Deceased in not clicked 15June2016
					 //Start
					 try{
						 Thread.sleep(1000);
						 // this code always click on No radio button for deceased radio buttons.
						 utilfunc.MakeElement(".//*[@name='Deceased' and contains(@value,'alse')]").click();
						 Thread.sleep(1000);
					 }catch(Exception error){}
					 //Start
					 
					 ///////////////////////Additional info handled/////////////////////////////
					 try{utilfunc.dynamic_data(FamilyMembersCounterXpath, FamilyMembers_attributeFiledXpath);}catch(Exception error){}
					 
					 String SaveButtonXpath=".//*[@id='btnSave']";
					 try{utilfunc.MakeElement(SaveButtonXpath).click();}catch(Exception error){}
					 //utilfunc.savebutton();
					 
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
				 catch(Exception e){
					 
				 }
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					 /*String FamilyMembersURLwithID=FamilyMembersPageURL+FamilyMembersID;
					 
					 utilfunc.NavigatetoURL(FamilyMembersURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='question-group'][1]//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 
					
					 int ObjCount=utilfunc.GetObjectCount(FamilyMembersNamecounterxpath);
					 int ObjCount1=utilfunc.GetObjectCount(FamilyMembersCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=FamilyMembersNamexpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){		
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersFirstname);
							        utilfunc.mouseaction();
					        	}	
							 else if(AttributeName.equals("MiddleName")){		
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersmiddlename);
					        	}
							 else if(AttributeName.equals("LastName")){		
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMemberslastname);
					        	}
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=FamilyMembers_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("RelationshipToPrincipal")){							
							        utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersPrincipalRelationship);
					        	}	
							 else if(AttributeName.equals("MaidenOrOtherNames")){
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersMaidenOtherNames);
					        	}
							 else if(AttributeName.equals("DateOfBirth")){	
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersDateofBirth);
					        	}
							 else if(AttributeName.equals("CountryOfBirth")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCountryofBirth);
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfBirth")){
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersStateProvinceofBirth);
					        	}
							 else if(AttributeName.equals("CityOfBirth")){	
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersCityofBirth);
					        	}
							 else if(AttributeName.equals("CountryOfResidence")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCountryofResidence);
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfResidence")){	
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersStateProvinceofResidence);
					        	}
							 else if(AttributeName.equals("CityOfResidence")){
								 utilfunc.MakeElement(NewXpath).clear();
							        utilfunc.MakeElement(NewXpath).sendKeys(FamilyMembersCityofResidence);
					        	}
							 else if(AttributeName.equals("CountryCode")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, FamilyMembersCitizenship);
					        	}
							 else if(AttributeName.equals("Deceased")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 
							 
						 }catch(Exception f){
							 
						 }
					 }
					 ///////////////////////Additional info handled/////////////////////////////
					 utilfunc.dynamic_data(FamilyMembersCounterXpath, FamilyMembers_attributeFiledXpath);
					 
					 String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();
					//utilfunc.savebutton();
				        
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
					 /*String FamilyMembersURLwithID=FamilyMembersPageURL+FamilyMembersID;
					 
					 utilfunc.NavigatetoURL(FamilyMembersURLwithID);*/
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String DeletebuttonXpath=".//*[@class='question-group'][1]//*[@class='icon-remove']";
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
