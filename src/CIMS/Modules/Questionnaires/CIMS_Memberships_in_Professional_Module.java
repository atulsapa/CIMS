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

public class CIMS_Memberships_in_Professional_Module
{
	
	
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
	 
		public CIMS_Memberships_in_Professional_Module(WebDriver driver,UtilFunction utilfunc) 
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
	 public boolean Memberships_in_ProfessionalPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{	
		
		//Passport Page	
		 
		//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 0, ColumnCounter);
			String Memberships_in_ProfessionalScenerio=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 2, ColumnCounter);
			String Memberships_in_ProfessionalTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 3, ColumnCounter);		
			String Memberships_in_ProfessionalPageURL=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 4, ColumnCounter);
			String Memberships_in_ProfessionalID=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 5, ColumnCounter);
			
			String Memberships_in_ProfessionalGAssociationName=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 6, ColumnCounter);
			String Memberships_in_ProfessionalMembershipStartDate=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 7, ColumnCounter);
			String Memberships_in_ProfessionalMembershipEndDate=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 8, ColumnCounter);
			String MembershipLevel=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 9, ColumnCounter);
			
			String Memberships_in_ProfessionalOutstandingAchievement=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 10, ColumnCounter);
			String Memberships_in_ProfessionalSelectionCriteria=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 11, ColumnCounter);
			String Memberships_in_ProfessionalDocumentation=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 12, ColumnCounter);
			//String Memberships_in_ProfessionalDescription=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 12, ColumnCounter);
		
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 13, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Memberships_in_Professional", 14, ColumnCounter);

			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			String Memberships_in_ProfessionalFiledXpath=".//*[@id='form1']//*[@class='control-group'][xx]//*[@id]";
			String CounterXpath=".//*[@id='form1']//*[@class='control-group']//*[@id]";
			
			String Xpathnew1=".//div/h4/..//*[@class='control-group']//*[@id]";
			String Xpathnew2=".//div/h4/..//*[@class='control-group'][xx]//*[@id]";
			
			
			String QuestionarieName="Memberships in Professional or Exclusive Organizations";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			 URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			 boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Memberships_in_ProfessionalScenerio;
			 description=Memberships_in_ProfessionalTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 if(mode.equals(ACTION)){
				 try{
					 /*String Memberships_in_ProfessionalURLwithID=Memberships_in_ProfessionalPageURL+Memberships_in_ProfessionalID;
					 
					 utilfunc.NavigatetoURL(Memberships_in_ProfessionalURLwithID);*/
		
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String AddbuttonXpath="//*[@class='btn']";
				 utilfunc.MakeElement(AddbuttonXpath).click();
			
				 int ObjCount=utilfunc.GetObjectCount(CounterXpath);
				 
				 for(int count=1; count<=ObjCount; count++)
				 {
					 String NewXpath=Memberships_in_ProfessionalFiledXpath.replace("xx", Integer.toString(count));
					 
					 try{
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.contains("NameOfAssociation")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalGAssociationName);
						 }
						 else if(AttributeName.contains("StartDate")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalMembershipStartDate);
						 }
						 else if(AttributeName.contains("EndDate")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalMembershipEndDate);
						 }
						 else if(AttributeName.contains("MembershipLevel")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(MembershipLevel);
						 }
						 else if(AttributeName.contains("SelectionNoteriety")){
							 if(Memberships_in_ProfessionalOutstandingAchievement.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								System.out.println(NewXpath1);
								utilfunc.MakeElement(NewXpath1).click();
							 }else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								System.out.println(NewXpath1);
								utilfunc.MakeElement(NewXpath1).click();
							 }
						 }
						 else if(AttributeName.contains("SelectionCriteria")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalSelectionCriteria);
						 }
						 else if(AttributeName.contains("DocumentationAvailable")){
							 if(Memberships_in_ProfessionalDocumentation.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									System.out.println(NewXpath1);
									utilfunc.MakeElement(NewXpath1).click();
								 }else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									System.out.println(NewXpath1);
									utilfunc.MakeElement(NewXpath1).click();
								 }
						 }
						 else if(AttributeName.contains("btn_uploader")){
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
				 
				  try {
					utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
				} catch (Exception e) {
				}
				 
				  try {
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
				
				 }
				
				 catch(Exception Ex){
					
				 }
				 
			}//else
		 else if(mode.equals(ACTION1)){
			 try{
				 /*String Memberships_in_ProfessionalURLwithID=Memberships_in_ProfessionalPageURL+Memberships_in_ProfessionalID;
				 
				 utilfunc.NavigatetoURL(Memberships_in_ProfessionalURLwithID);*/
				
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
				 utilfunc.MakeElement(EditbuttonXpath).click();
				 
				 int ObjCount=utilfunc.GetObjectCount(CounterXpath);
				 
				 for(int count=1; count<=ObjCount; count++)
				 {
					 String NewXpath=Memberships_in_ProfessionalFiledXpath.replace("xx", Integer.toString(count));
					 
					 try{
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.contains("NameOfAssociation")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalGAssociationName);
						 }
						 else if(AttributeName.contains("StartDate")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalMembershipStartDate);
						 }
						 else if(AttributeName.contains("EndDate")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalMembershipEndDate);
						 }
						 else if(AttributeName.contains("MembershipLevel")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(MembershipLevel);
						 }
						 else if(AttributeName.contains("SelectionNoteriety")){
							 if(Memberships_in_ProfessionalOutstandingAchievement.equals("Yes")){
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
								System.out.println(NewXpath1);
								utilfunc.MakeElement(NewXpath1).click();
							 }else{
								String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
								System.out.println(NewXpath1);
								utilfunc.MakeElement(NewXpath1).click();
							 }
						 }
						 else if(AttributeName.contains("SelectionCriteria")){
							 utilfunc.MakeElement(NewXpath).clear();
							 	utilfunc.MakeElement(NewXpath).sendKeys(Memberships_in_ProfessionalSelectionCriteria);
						 }
						 else if(AttributeName.contains("DocumentationAvailable")){
							 if(Memberships_in_ProfessionalDocumentation.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									System.out.println(NewXpath1);
									utilfunc.MakeElement(NewXpath1).click();
								 }else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									System.out.println(NewXpath1);
									utilfunc.MakeElement(NewXpath1).click();
								 }
						 }
						 else if(AttributeName.contains("btn_uploader")){
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
				 
				  utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
				 
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
					
				
		 }//esle
		 else if(mode.equals(ACTION2)){
			 
			 try{
				 /*String Memberships_in_ProfessionalURLwithID=Memberships_in_ProfessionalPageURL+Memberships_in_ProfessionalID;
				 
				 utilfunc.NavigatetoURL(Memberships_in_ProfessionalURLwithID);*/
				 utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
				 	testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
		
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String deletebuttonxpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
				 utilfunc.MakeElement(deletebuttonxpath).click();
				 
				 Thread.sleep(10000);
				 utilfunc.isAlertPresent();
			     
				 boolean error_flag=utilfunc.ErrorMessagehandler();
				 if (error_flag){
					 Flag=true;
				 }else{
					 Flag=false;
				 }
				 
			 }catch(Exception s){
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

		
	
		