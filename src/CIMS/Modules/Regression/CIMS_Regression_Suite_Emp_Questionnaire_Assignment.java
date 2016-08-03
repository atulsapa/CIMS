package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

import CIMS.Modules.Custom.Questionnaire_Assignment;
import util.UtilFunction;

public class CIMS_Regression_Suite_Emp_Questionnaire_Assignment {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	/**
	 * @param args
	 */

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

 
	public CIMS_Regression_Suite_Emp_Questionnaire_Assignment(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}


	public boolean Employer_Questionnaire(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on "+sheetName+" Module....");
		boolean Flag	=	false;


		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String QuestionnaireEmployerContactId				=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String CategoryId							        =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String ClassificationId							    =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String ContactId							        =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String EmprQUestionnaireName							        =			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		
		String status;
		
		if(TestcaseRunMode.equals("Y")){
			
			testcaseid		=		TestcaseID;
			scenerio		=		Scenario;
			description		=		TestCaseDescription;
			
			
			if(mode.equals("Delete")){
				String DeleteXPath	=	".//*[contains(@id,'Status')]//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Delete Record')]";
						// now code for delete button here...
				System.out.println("now code for delete button here....");
				
				try {
					utilfunc.MakeElement(DeleteXPath).click();
				} catch (Exception e) {
				
					System.out.println("Unable to delete the record");
			    }
				Thread.sleep(1000);
				utilfunc.isAlertPresent();
				
			}
			
			String EmployerDropDownXpath="//*[@class='desc4']//*[@id='QuestionnaireEmployerContactId']";
			String QuesEmployerAddmoreBtnXpath=".//*[@id='vqn-emr']//*[contains(@class,'icon-plus-sign')]";
			
            //Questionnaire assignment page innitilazation 
			
			String FieldXpath =".//*[@id='FormAddQuestionnaire']//*[contains(@class,'desc4')]//.[@name]";
			String RowXpath=".//*[@id='FormAddQuestionnaire']//*[contains(@class,'desc4')][xx]//.[@name]";
			
			
			
			if(mode.equals("New") || mode.equals("Edit")){
				
				
				
				 try {
					 System.out.println("\n---------\nEmployerDropDownXpath :"+EmployerDropDownXpath);
					 System.out.println("QuestionnaireEmployerContactId :"+QuestionnaireEmployerContactId);
				    	Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(EmployerDropDownXpath, QuestionnaireEmployerContactId);
						
						Thread.sleep(1000);
						
						try {
							utilfunc.MakeElement(QuesEmployerAddmoreBtnXpath).click();
							int Count=0;
							int element_row=utilfunc.GetObjectCount(FieldXpath);
						    System.out.println("Print The Result Count:" +element_row);
							
							for(int i=1; i<=element_row; i++){
								Thread.sleep(1500);
								try{
									String New_RowXpath=RowXpath.replace("xx", Integer.toString(i));
									String MyAttrName=utilfunc.MakeElement(New_RowXpath).getAttribute("name");
									System.out.println("My Attr name is:" + MyAttrName);
									
									if(MyAttrName.equals("CategoryId")){
										Thread.sleep(1000);
										try {
											utilfunc.Selectdropdownvaluebytext(New_RowXpath, CategoryId);
											System.out.println("Vlaue has been select from" +MyAttrName);
										} catch (Exception e) {
											System.out.println("Unable to select the value from dropdown" +MyAttrName);
										}
										
									}else if(MyAttrName.equals("ClassificationId")){
										Thread.sleep(1000);
										try {
											utilfunc.Selectdropdownvaluebytext(New_RowXpath, ClassificationId);
											System.out.println("Unable to select the value from dropdown" +MyAttrName);
										} catch (Exception e) {
											System.out.println("Unable to select the value from dropdown" +MyAttrName);
										}
									}else if (MyAttrName.equals("ContactId")){
										Thread.sleep(1000);
										try {
											utilfunc.Selectdropdownvaluebytext(New_RowXpath, ContactId);
											System.out.println("Unable to select the value from dropdown" +MyAttrName);
										} catch (Exception e) {
											System.out.println("Unable to select the value from dropdown" +MyAttrName);
										}
										
									}else{}
									        
								  
									}catch(Exception e){
									
								}
								
								
								
							}	if(!EmprQUestionnaireName.isEmpty()){


								String CheckboxcounterXpath="//*[@class='table-rec-container']/table/tbody/tr/td[1]//*[@type='checkbox']";
							    String CheckboxXpath="//*[@class='table-rec-container']/table/tbody/tr[xx]/td[1]//*[@type='checkbox']";
							    
							    String QuestionaireNameXpath="//*[@class='table-rec-container']/table/tbody/tr[xx]/td[2]";
							    
							    int ResultCount= utilfunc.GetObjectCount(CheckboxcounterXpath);

							    for(int i=1;i<=ResultCount;i++){

							    	Thread.sleep(1000);

							    	// now let us find  out the questionnaire title
							    	String NewTextXpath		=			QuestionaireNameXpath.replace("xx",Integer.toString(i));

							        String QuestionnaireText=utilfunc.MakeElement(NewTextXpath).getText();
							        
							        // now match the title questionnaire with provided questionnaire 
							        if(EmprQUestionnaireName.equals(QuestionnaireText)){
							        
							        	// now click on check against questionnaire title matched
								    	String NewChkXpath=CheckboxXpath.replace("xx",Integer.toString(i));
								        try {
											utilfunc.MakeElement(NewChkXpath).click();;
										} catch (Exception e) {
											System.out.println("issue occured while clicking on checkbox..");
										}
								        
							        }
							
							
							    }
							}else{
							    	
							    	Thread.sleep(3000);
							    	// this function use to select first questionnaire from the list and assign..
									questionnaireAssignment();

							}																					 

																												 

						} catch (Exception e) {
							System.out.println("Unable To click on the ");
						}
					} catch (Exception e) {
						
						System.out.println("Unable to select the value from the dropdown" + QuestionnaireEmployerContactId);
					}


			}
			try{
				 // save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn')]//*[contains(@class,'icon-white')]";
	        	utilfunc.MakeElement(saveBtn).click();
	        	Thread.sleep(1000);
	        	utilfunc.isAlertPresent();
	        	

	        	Thread.sleep(3000);
			}
			catch(Exception e){}
			try{
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
				String error_flag=utilfunc.ErrorMessagehandlerExperiment();
				//ExpectedErrorMessage=ExpectedErrorMessage;
				System.out.println("==="+ExpectedErrorMessage+"===");
				System.out.println("==="+error_flag+"===");
				
				 if (error_flag.equals(ExpectedErrorMessage)){
					 Flag=true;
					 utilfunc.TakeScreenshot();
					 
				 }else if (error_flag.equals("")){
					 Flag=true;
					 webdriver.navigate().back();
				 }else if (error_flag.contains("Success!")){
					 Flag=true;
				 }else if(error_flag.equals("Server Error in '/' Application.")){
					 Flag=false;
					 webdriver.navigate().back();
				 }else if(error_flag.equals("An error has occurred.Can not assign duplicate questionnaires under the same project")){
					 Flag=false;
					 webdriver.navigate().back();
				 }
				 else{
					 Flag=false;
					 utilfunc.TakeScreenshot();
					 webdriver.navigate().back();
				 }
			}catch(Exception e){
				Flag	=	false;
				System.out.println("Data is not saved because all fields are not set in the form.");
			}		
			
			
		}
			
		return Flag;

}
       public boolean questionnaireAssignment(){
		
		boolean flag=false;
		String SecetedCheckbox = "";
		 // select questionnaires for employer & employee..

		 try{

			 String QuestionnairesCounterXPath	=	"//*[@class='table-rec-container']/table";

			 String QuestionnairesXPath			=	"//*[@class='table-rec-container'][xx]/table";
			 
			 String QuestionnaireHeaderXPath			=	"//*[@class='table-rec-container'][xx]/table/thead";

			 // find number of questionnaires present on the page..

			 int quesCount						=	utilfunc.GetObjectCount(QuestionnairesCounterXPath);


			 if(quesCount>=1){

				 // before selecting all let us find out if they are 

				 for (int i = 1; i <= quesCount; i++) {


					 Thread.sleep(1000);

					 String NewQuestionnaireHeaderXPath			=		QuestionnaireHeaderXPath.replace("xx", Integer.toString(i));

					 // before clicking on  checkbox, click on its header so that it appears on the top..
					 utilfunc.MakeElement(NewQuestionnaireHeaderXPath).click();

					 Thread.sleep(1500);

					 String NewQuestionnairesCheckBoxXPath		=	QuestionnairesXPath.replace("xx", Integer.toString(i)) + "/tbody/tr[1]/td[1]//*[@type='checkbox']";

					 String NewQuestionnairesLabelXPath		=	QuestionnairesXPath.replace("xx", Integer.toString(i)) + "/tbody/tr[1]/td[2]";

					 // now we are in particular Questionnaires table , now let us select first checkbox of each & then go for next to save..

					 utilfunc.enableOrDisableCheckbox(NewQuestionnairesCheckBoxXPath, true);
					 flag = true;

					 SecetedCheckbox=utilfunc.MakeElement(NewQuestionnairesLabelXPath).getText();

					 Thread.sleep(900);

				}

			 }

			 System.out.println("Selected Checkbox is : "+SecetedCheckbox);

			 System.out.println("");

		 }catch(Exception e){

			 System.out.println("unable to collect questionnaires..");

		 }
		
		
		return flag;
		
	}

	
}
