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

public class CIMS_LCA_info_Module {
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
	 
		public CIMS_LCA_info_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean LCA_info_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "LCA_info", 0, ColumnCounter);
			String LCA_infoScenerio=UtilFunction.getCellData("Test Data.xls", "LCA_info", 2, ColumnCounter);
			String LCA_infoTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "LCA_info", 3, ColumnCounter);		
			String LCA_infoPageURL=UtilFunction.getCellData("Test Data.xls", "LCA_info", 4, ColumnCounter);
			String LCA_infoID=UtilFunction.getCellData("Test Data.xls", "LCA_info", 5, ColumnCounter);
			
			String LCA_infoApplicationStatus=UtilFunction.getCellData("Test Data.xls", "LCA_info", 6, ColumnCounter);
			String LCA_infoSalarySurveyName=UtilFunction.getCellData("Test Data.xls", "LCA_info", 7, ColumnCounter);
			String LCA_infoDateOfSurvey=UtilFunction.getCellData("Test Data.xls", "LCA_info", 8, ColumnCounter);
			String LCA_infoPositionTitleInSurvey=UtilFunction.getCellData("Test Data.xls", "LCA_info", 9, ColumnCounter);
			String LCA_infoLevelInSurvey=UtilFunction.getCellData("Test Data.xls", "LCA_info", 10, ColumnCounter);
			
			String LCA_infoOtherMethodology=UtilFunction.getCellData("Test Data.xls", "LCA_info", 11, ColumnCounter);
			String LCA_infoBaseSalary=UtilFunction.getCellData("Test Data.xls", "LCA_info", 12, ColumnCounter);
			String LCA_infoNumberOfEmployeeInPosition=UtilFunction.getCellData("Test Data.xls", "LCA_info", 13, ColumnCounter);
			String LCA_infoPostingNoticeType=UtilFunction.getCellData("Test Data.xls", "LCA_info", 14, ColumnCounter);
			String LCA_infoNumberOfEmployeePaidMore=UtilFunction.getCellData("Test Data.xls", "LCA_info", 15, ColumnCounter);
			String LCA_infoNumberOfEmployeePaidLess=UtilFunction.getCellData("Test Data.xls", "LCA_info", 16, ColumnCounter);
			String LCA_infoSalaryrangelow=UtilFunction.getCellData("Test Data.xls", "LCA_info", 17, ColumnCounter);
			String LCA_infoSalaryrangehigh=UtilFunction.getCellData("Test Data.xls", "LCA_info", 18, ColumnCounter);
			
			String name=UtilFunction.getCellData("Test Data.xls", "LCA_info", 22, ColumnCounter);
			String Title=UtilFunction.getCellData("Test Data.xls", "LCA_info", 23, ColumnCounter);
			String Salary=UtilFunction.getCellData("Test Data.xls", "LCA_info", 24, ColumnCounter);
			String HighestDegreeReceived=UtilFunction.getCellData("Test Data.xls", "LCA_info", 25, ColumnCounter);
			String YearsinField=UtilFunction.getCellData("Test Data.xls", "LCA_info", 26, ColumnCounter);
			String YearswithCompany=UtilFunction.getCellData("Test Data.xls", "LCA_info", 27, ColumnCounter);
			String ReasonPaidMore=UtilFunction.getCellData("Test Data.xls", "LCA_info", 28, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "LCA_info", 29, ColumnCounter);
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			String LCA_info_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String LCA_infoCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			String salaryrangelowxpath=".//*[@id='SalaryRangeFrom']";
			String salaryrangeHighxpath=".//*[@id='SalaryRangeTo']";

			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="LCA Info";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
					
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=LCA_infoScenerio;
			 description=LCA_infoTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				Flag=false; 
			 }else{
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String LCA_infoURLwithID=LCA_infoPageURL+LCA_infoID;
					 utilfunc.NavigatetoURL(LCA_infoURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(LCA_infoCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=LCA_info_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("ApplicationStatus")){							
							     if(LCA_infoApplicationStatus.equals("Yes")){
							    	 utilfunc.MakeElement(NewXpath).click();
							     }
					        	}	
							 else if(AttributeName.equals("SalarySurveyName")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoSalarySurveyName);
					        	}
							 else if(AttributeName.equals("DateOfSurvey")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoDateOfSurvey);
					        	}
							 else if(AttributeName.equals("PositionTitleInSurvey")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoPositionTitleInSurvey);
					        	}
							 else if(AttributeName.equals("LevelInSurvey")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoLevelInSurvey);
					        	}
							 else if(AttributeName.equals("OtherMethodology"))
							 {		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoOtherMethodology);
					        	}
							 else if(AttributeName.equals("BaseSalary")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoBaseSalary);
					        	}
							 else if(AttributeName.equals("NumberOfEmployeeInPosition")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeeInPosition);
					        	}
							 else if(AttributeName.equals("PostingNoticeType")){
								 if(LCA_infoPostingNoticeType.equals("Yes")){					
								 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("NumberOfEmployeePaidMore")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeePaidMore);
					        	}
							 else if(AttributeName.equals("NumberOfEmployeePaidLess")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeePaidLess);
					        	}
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////salary range///
					 try{
						 Thread.sleep(1000);
					 utilfunc.MakeElement(salaryrangelowxpath).clear();
					 utilfunc.MakeElement(salaryrangelowxpath).sendKeys(LCA_infoSalaryrangelow);
					 Thread.sleep(800);
					 utilfunc.MakeElement(salaryrangeHighxpath).clear();
					 utilfunc.MakeElement(salaryrangeHighxpath).sendKeys(LCA_infoSalaryrangehigh);
					 }catch(Exception e){

					 }
					 
					 ////Add Employee////////////
					 
					 String Addbuttonxpath=".//*[@id='Add']";
					 try{
						 utilfunc.MakeElement(Addbuttonxpath).click();
						 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						 Thread.sleep(4500);
						 
						 String AddEmployeeFieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
						 String AddEmployeeContolxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
						 
						 int ObjCount1=utilfunc.GetObjectCount(AddEmployeeContolxpath);
						 for(int count=1; count<=ObjCount1; count++)
						 {
							 String NewXpath=AddEmployeeFieldxpath.replace("xx", Integer.toString(count));
							 
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("FullName")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(name);
						        	}
								 else if(AttributeName.equals("Title")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(Title);
						        	}
								 else if(AttributeName.equals("Salary")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(Salary);
						        	}
								 else if(AttributeName.equals("HighestDegreeReceived")){	
//									 utilfunc.MakeElement(NewXpath).sendKeys(HighestDegreeReceived);
									 utilfunc.Selectdropdownvaluebytext(NewXpath, HighestDegreeReceived);
						        	}
								 else if(AttributeName.equals("YearsInField")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(YearsinField);
						        	}
								 else if(AttributeName.equals("YearsWithCompany")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(YearswithCompany);
						        	}
								 else if(AttributeName.equals("Reasons")){
//									 String contolxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//tr//*[@id]";
									 //String Fieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//tr[xx]//*[@id]";
									 String contolxpath=NewXpath.replace("//*[@id]", "//tr//*[@id]");
									 String Fieldxpath=NewXpath.replace("//tr//", "//tr[yy]//");
									 int ObjCount2=utilfunc.GetObjectCount(contolxpath);
									 for(int count1=1; count1<=ObjCount2; count1++)
									 {
									 String NewXpath1=Fieldxpath.replace("yy", Integer.toString(count)); 
										try{
											String AttributeName1=utilfunc.MakeElement(NewXpath1).getAttribute("id");
											System.out.println("Attribute name "+count+"is : "+AttributeName1);
											 
											if(AttributeName.equals("Reasons")){																		
											 utilfunc.MakeElement(NewXpath).click(); 
																							 
									       }
										 }catch(Exception j){
											 
										 }
									 }
						        	}
								 
							 }catch(Exception e){
								 
							 }
						 }
						 
						 ///save
						 String savebutton=".//*[@id='btnSave']";
						 utilfunc.MakeElement(savebutton).click();
						 
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
						 Thread.sleep(3000);
						 
					 }catch(Exception e){
						 
					 }
					 
					 
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 utilfunc.savebutton();
					 
				        
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

					 
				 }catch(Exception e){
					 
				 }
				 
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					 /*String LCA_infoURLwithID=LCA_infoPageURL+LCA_infoID;
					 utilfunc.NavigatetoURL(LCA_infoURLwithID);*/
			
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 int ObjCount=utilfunc.GetObjectCount(LCA_infoCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=LCA_info_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("ApplicationStatus")){							
							     if(LCA_infoApplicationStatus.equals("Yes")){
							    	 utilfunc.MakeElement(NewXpath).click();
							     }
					        	}	
							 else if(AttributeName.equals("SalarySurveyName")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoSalarySurveyName);
					        	}
							 else if(AttributeName.equals("DateOfSurvey")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoDateOfSurvey);
					        	}
							 else if(AttributeName.equals("PositionTitleInSurvey")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoPositionTitleInSurvey);
					        	}
							 else if(AttributeName.equals("LevelInSurvey")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoLevelInSurvey);
					        	}
							 else if(AttributeName.equals("OtherMethodology")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoOtherMethodology);
					        	}
							 else if(AttributeName.equals("BaseSalary")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoBaseSalary);
					        	}
							 else if(AttributeName.equals("NumberOfEmployeeInPosition")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeeInPosition);
					        	}
							 else if(AttributeName.equals("PostingNoticeType")){
								 if(LCA_infoPostingNoticeType.equals("Yes")){					
								 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("NumberOfEmployeePaidMore")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeePaidMore);
					        	}
							 else if(AttributeName.equals("NumberOfEmployeePaidLess")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(LCA_infoNumberOfEmployeePaidLess);
					        	}
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////salary range///
					 try{
					 utilfunc.MakeElement(salaryrangelowxpath).clear();
					 utilfunc.MakeElement(salaryrangeHighxpath).clear();
					 utilfunc.MakeElement(salaryrangelowxpath).sendKeys(LCA_infoSalaryrangelow);
					 utilfunc.MakeElement(salaryrangeHighxpath).sendKeys(LCA_infoSalaryrangehigh);
					 }catch(Exception e){
						 
					 }
					 
					 ////Add Employee////////////
					 
					 String Addbuttonxpath=".//*[@id='Add']";
					 try{
						 utilfunc.MakeElement(Addbuttonxpath).click();
						 Thread.sleep(3000);
						 
						 String AddEmployeeFieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
						 String AddEmployeeContolxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
						 
						 int ObjCount1=utilfunc.GetObjectCount(AddEmployeeContolxpath);
						 for(int count=1; count<=ObjCount1; count++)
						 {
							 String NewXpath=AddEmployeeFieldxpath.replace("xx", Integer.toString(count));
							 
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("FullName")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(name);
						        	}
								 else if(AttributeName.equals("Title")){
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(Title);
						        	}
								 else if(AttributeName.equals("Salary")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(Salary);
						        	}
								 else if(AttributeName.equals("HighestDegreeReceived")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(HighestDegreeReceived);
						        	}
								 else if(AttributeName.equals("YearsInField")){	
									 utilfunc.MakeElement(NewXpath).sendKeys(YearsinField);
						        	}
								 else if(AttributeName.equals("YearsWithCompany")){	
									 utilfunc.MakeElement(NewXpath).clear();
									 utilfunc.MakeElement(NewXpath).sendKeys(YearswithCompany);
						        	}
								 else if(AttributeName.equals("Reasons")){
									 String contolxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//tr//*[@id]";
									 String Fieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//tr[xx]//*[@id]";
									 int ObjCount2=utilfunc.GetObjectCount(contolxpath);
									 for(int count1=1; count1<=ObjCount2; count1++)
									 {
									 String NewXpath1=Fieldxpath.replace("xx", Integer.toString(count)); 
										try{
											String AttributeName1=utilfunc.MakeElement(NewXpath1).getAttribute("id");
											System.out.println("Attribute name "+count+"is : "+AttributeName1);
											 
											if(AttributeName.equals("Reasons")){																			
											 utilfunc.MakeElement(NewXpath).click(); 
																							 
									       }
										 }catch(Exception j){
											 
										 }
									 }
						        	}
								 
							 }catch(Exception e){
								 
							 }
						 }
						 
						 ///save
						 String savebutton=".//*[@id='btnSave']";
						 utilfunc.MakeElement(savebutton).click();
						 
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
						 Thread.sleep(3000);
						 
					 }catch(Exception e){
						 
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 utilfunc.savebutton();
					 
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
					 
				 }catch(Exception e){
					 
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in LCA Info Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
			 
			 }///////////url ckeck end
			
			 return Flag;
	 	}
	 
}
