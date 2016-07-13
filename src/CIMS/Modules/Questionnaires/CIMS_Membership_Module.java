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
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Membership_Module
{
	
	
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String URLwithID="";
	
	 //Constructor----------
	 
		public CIMS_Membership_Module(WebDriver driver,UtilFunction utilfunc) 
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
	 public boolean MembershipPage(int ColumnCounter) throws AWTException, InterruptedException
	 	{	
		
		//Passport Page	
		 
		//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Membership", 0, ColumnCounter);
			String CitizenshipScenerio=UtilFunction.getCellData("Test Data.xls", "Membership", 2, ColumnCounter);
			String MembershipTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Membership", 3, ColumnCounter);		
			String MembershipPageURL=UtilFunction.getCellData("Test Data.xls", "Membership", 4, ColumnCounter);
			
			
			String MembershipID=UtilFunction.getCellData("Test Data.xls", "Membership", 5, ColumnCounter);			
			String MembershipAssociationName=UtilFunction.getCellData("Test Data.xls", "Membership", 6, ColumnCounter);
			String MembershipMembershipStartDate=UtilFunction.getCellData("Test Data.xls", "Membership", 7, ColumnCounter);
			String MembershipMembershipEndDate=UtilFunction.getCellData("Test Data.xls", "Membership", 8, ColumnCounter);
			String MembershipOutstandingAchievement=UtilFunction.getCellData("Test Data.xls", "Membership", 9, ColumnCounter);
			
					
			String MembershipSelectionCriteria=UtilFunction.getCellData("Test Data.xls", "Membership", 10, ColumnCounter);
			String MembershipDocumentation=UtilFunction.getCellData("Test Data.xls", "Membership", 11, ColumnCounter);
			
			
			//Custom Field  
			
			
			//Methods Xpath
		 
		 
		 
		 
		 boolean Flag =false;
		 Reporter.log("__________________________________________________________________________________________");
		 Reporter.log("______________________________MembershipPage Report___________________________________");
		 Reporter.log("");	
		 Reporter.log("1. Test Case ID - "+TestcaseID );
		 Reporter.log("2. Browser - "+ utilfunc.Actualbrw);
		 Reporter.log("3. Scenerio - "+ CitizenshipScenerio);	
		 Reporter.log("4. Test Case Description - "+ MembershipTestcaseDescription);
		 
		 
		 try{
		 String MembershipURLwithID=MembershipPageURL+MembershipID;
		 
		 utilfunc.NavigatetoURL(MembershipURLwithID);
		 String AddbuttonXpath="//*[@class='btn']";
		 utilfunc.MakeElement(AddbuttonXpath).click();
		 String MembershipFiledXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]";
		 String MembershipLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
		 String CounterXpath=".//*[@id='form1']//*[@class='control-group']";
		 
		 int ObjCount=utilfunc.GetObjectCount(CounterXpath);
		 
		 for(int count=1; count<=ObjCount; count++)
		 {
			 //Label Printing
			 String NewXpath=MembershipLabelXpath.replace("xx", Integer.toString(count));
			 String LabelName=utilfunc.MakeElement(NewXpath).getText();
			 System.out.println("Label "+count+"is : "+LabelName);
			 
			//Filed value Entering
			 String NewXpath1=MembershipFiledXpath.replace("xx", Integer.toString(count));
			 try {
			 String SelectXpath1=NewXpath1+"/input";	
			 if(LabelName.contains("Association Name")) {
					utilfunc.MakeElement(SelectXpath1).sendKeys(MembershipAssociationName);
				}
			 else if(LabelName.contains("Membership Start Date")) {
					utilfunc.MakeElement(SelectXpath1).sendKeys(MembershipMembershipStartDate);
				}
			 else if(LabelName.contains("Membership End Date")) {
					utilfunc.MakeElement(SelectXpath1).sendKeys(MembershipMembershipEndDate);
				}
			 
			  String Text=utilfunc.MakeElement(SelectXpath1).getText();
				System.out.println(Text);
			 }
		
			 catch(Exception e){
				 try{
					 
				String FiledXpath1=NewXpath1+"/label[1]/input";	
				
				if(LabelName.contains("Outstanding Achievement")) {
					utilfunc.MakeElement(FiledXpath1).click();
				}
				
				
				
				String Text=utilfunc.MakeElement(FiledXpath1).getText();
				System.out.println(Text);
				 }
				 catch(Exception f){
					 try{
					 String FiledXpath1=NewXpath1+"/textarea"; 
					 
					 if(LabelName.contains("Selection Criteria")) {
							utilfunc.MakeElement(FiledXpath1).sendKeys(MembershipSelectionCriteria);
					 }
					 
				 String Text=utilfunc.MakeElement(FiledXpath1).getText();
				 System.out.println(Text);
					 }
					 catch(Exception g){
					 String FiledXpath1=NewXpath1+"/label[1]/input"; 
					 if (LabelName.contains("Documentation")){
						 utilfunc.MakeElement(FiledXpath1).click();
					 }
					 }
					 }
					 
				  
			 }
		 }
		 return true;
		 
	 }
		
		 catch(Exception Ex){
			String Xpathnew1= ".//*[@id='form1']/div//*[@class='control-group']/div//*[@id]";
			int ObjCount1=utilfunc.GetObjectCount(Xpathnew1);
			Xpathnew1=".//*[@id='form1']/div//*[@class='control-group'][xx]/div//*[@id]";
			
			String 	DropDownXpath="";
	 		int Value=0;
	 		
			for(int ControlCount=1;ControlCount<=ObjCount1;ControlCount++){		 		
				String ObjectControlsXpath=Xpathnew1.replace("xx", Integer.toString(ControlCount));	
				try{
		 		String ControlType=utilfunc.MakeElement(ObjectControlsXpath).getAttribute("id");
		 		
		 		if(ControlType.contains("ctm_bt")){
  					
				        utilfunc.MakeElement(ObjectControlsXpath).click();
 	        	}	
		 		else if(ControlType.contains("ctm_sl")){
		 				utilfunc.Selectdropdownvaluebyvalue(DropDownXpath, "589");
		 			
		 				}
		 				else if(ControlType.contains("ctm_tx")&& Value!=1){
		 					
		 					utilfunc.MakeElement(ObjectControlsXpath).sendKeys("Dynamic Text");
		 					Value=1;
		 					
		 				}
		 				else if(ControlType.contains("ctm_ta")){
		 					 					
		 					utilfunc.MakeElement(ObjectControlsXpath).sendKeys("Dynamic Text Area");
		 					
		 				}	
		 				
		 				else if(ControlType.contains("ctm_tx")){
		 				        utilfunc.MakeElement(ObjectControlsXpath).sendKeys("Dynamic Text 2");
		 				}	
		 	        	else if(ControlType.contains("ctm_bt")){
 					         					
 					        utilfunc.MakeElement(ObjectControlsXpath).click();
		 	        	}	
		 	        	else if(ControlType.contains("ctm_in")){
	         					
 					        utilfunc.MakeElement(ObjectControlsXpath).sendKeys("1233");
		 	        	}	   
		 		
				}catch(Exception df){
					
				}
					}
		 		
				        String SaveButtonXpath=".//*[@id='btnSave']";
	 					
				        utilfunc.MakeElement(SaveButtonXpath).click();
			
		 }
			
		 
			return false; 
		 }
	 		 
	
	
}

		
	
		