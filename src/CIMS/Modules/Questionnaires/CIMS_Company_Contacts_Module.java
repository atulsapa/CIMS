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

public class CIMS_Company_Contacts_Module {
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
	 
		public CIMS_Company_Contacts_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Company_Contacts_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 0, ColumnCounter);
			String Company_ContactsScenerio=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 2, ColumnCounter);
			String Company_ContactsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 3, ColumnCounter);		
			String Company_ContactsPageURL=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 4, ColumnCounter);
			String Company_ContactsID=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 5, ColumnCounter);
			
			String Type=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 6, ColumnCounter);
			String usersearch=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 7, ColumnCounter);
			String emailsearch=UtilFunction.getCellData("Test Data.xls", "Company_Contacts", 8, ColumnCounter);
			
			String Company_Contacts_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='table table-item-list']/tbody/tr[xx]//*[@class='icon-edit']";
			String Company_ContactsCounterXpath=".//*[@class='form-horizontal']//*[@class='table table-item-list']/tbody/tr//*[@class='icon-edit']";

			String companycontacttypexpath=".//*[@class='form-horizontal']//*[@class='table table-item-list']/tbody/tr[xx]/td[1]";
			
			
			String dropdownxpath=".//*[@class='form-horizontal']//tr[xx]//*[@class='dropdown-menu']/li/a";
			
			
			String usersearchxpath=".//*[@id='SearchText']";
			String emailsearchxpath=".//*[@id='Email']";
			
			String searchbuttonxpath=".//*[@id='btnSearch']";
			
			String Assignxpath=".//*[@class='form-horizontal']//*[@class='table table-item-list']/tbody/tr[1]/td[5]/a";
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Company Contacts";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Company_ContactsScenerio;
			 description=Company_ContactsTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)|mode.equals(ACTION1)){
				 try{
					 /*String Company_ContactsURLwithID=Company_ContactsPageURL+Company_ContactsID;
					 utilfunc.NavigatetoURL(Company_ContactsURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 if(Type.equals("HR Contact")){
				
					 int ObjCount=utilfunc.GetObjectCount(Company_ContactsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 
						 String NewXpath2=companycontacttypexpath.replace("xx", Integer.toString(count));
						 String NewXpath=Company_Contacts_attributeFiledXpath.replace("xx", Integer.toString(count));
						 String NewXpath3=dropdownxpath.replace("xx", Integer.toString(count));
						 
						 String contacttype=utilfunc.MakeElement(NewXpath2).getText();
						 
						 if(contacttype.equals("HR Contact")){
						 try{
							 utilfunc.MakeElement(NewXpath).click();	
							 utilfunc.MakeElement(NewXpath3).click();
							 
							 utilfunc.MakeElement(usersearchxpath).sendKeys(usersearch);
							 ////utilfunc.MakeElement(emailsearchxpath).sendKeys(emailsearch);
							 utilfunc.MakeElement(searchbuttonxpath).click();
							 
							 utilfunc.MakeElement(Assignxpath).click();	
					
					 }catch(Exception e){
						 
					 }
					 }
					 }
					 }else  if(Type.equals("HR Contact Survey")){
							
						 int ObjCount=utilfunc.GetObjectCount(Company_ContactsCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 
							 String NewXpath2=companycontacttypexpath.replace("xx", Integer.toString(count));
							 String NewXpath=Company_Contacts_attributeFiledXpath.replace("xx", Integer.toString(count));
							 String NewXpath3=dropdownxpath.replace("xx", Integer.toString(count));
							 
							 String contacttype=utilfunc.MakeElement(NewXpath2).getText();
							 
							 if(contacttype.equals("HR Contact Survey")){
							 try{
								 utilfunc.MakeElement(NewXpath).click();	
								 utilfunc.MakeElement(NewXpath3).click();
								 
								 utilfunc.MakeElement(usersearchxpath).sendKeys(usersearch);
								 ////utilfunc.MakeElement(emailsearchxpath).sendKeys(emailsearch);
								 utilfunc.MakeElement(searchbuttonxpath).click();
								 
								 utilfunc.MakeElement(Assignxpath).click();	
						
						 }catch(Exception e){
							 
						 }
						 }
						 }
						 }else  if(Type.equals("L3 Manager ")){
								
							 int ObjCount=utilfunc.GetObjectCount(Company_ContactsCounterXpath);
							 
							 for(int count=1; count<=ObjCount; count++)
							 {
								 
								 String NewXpath2=companycontacttypexpath.replace("xx", Integer.toString(count));
								 String NewXpath=Company_Contacts_attributeFiledXpath.replace("xx", Integer.toString(count));
								 String NewXpath3=dropdownxpath.replace("xx", Integer.toString(count));
								 
								 String contacttype=utilfunc.MakeElement(NewXpath2).getText();
								 
								 if(contacttype.equals("L3 Manager")){
								 try{
									 utilfunc.MakeElement(NewXpath).click();	
									 utilfunc.MakeElement(NewXpath3).click();
									 
									 utilfunc.MakeElement(usersearchxpath).sendKeys(usersearch);
									 ////utilfunc.MakeElement(emailsearchxpath).sendKeys(emailsearch);
									 utilfunc.MakeElement(searchbuttonxpath).click();
									 
									 utilfunc.MakeElement(Assignxpath).click();	
							
							 }catch(Exception e){
								 
							 }
							 }
							 }
							 }
					 
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
				 }catch(Exception e){
					 
				 }
				 
				 
			 } else if(mode.equals(ACTION2)){
				 
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
							Deletecheck="Delete";
							testcaseid="TC001";
							scenerio="Positive";
							description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
							utilfunc.ErrorMessage2="Delete option is not Implimented in Company Contact Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				
				 }///////////url ckeck end
			 
			
			 return Flag;
	 	}

}
