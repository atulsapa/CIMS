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

public class CIMS_Position_Requirements_Module {
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
	 
		public CIMS_Position_Requirements_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Position_Requirements_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 0, ColumnCounter);
			String Position_RequirementsScenerio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 2, ColumnCounter);
			String Position_RequirementsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 3, ColumnCounter);		
			String Position_RequirementsPageURL=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 4, ColumnCounter);
			String Position_RequirementsID=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 5, ColumnCounter);
			
			String Position_RequirementDegreeRequired=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 6, ColumnCounter);
			String Position_RequirementsFieldofStudy=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 7, ColumnCounter);
			String Position_RequirementsYearsOfExperience=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 8, ColumnCounter);
			String Position_RequirementsDescription=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 9, ColumnCounter);
			String Position_RequirementsSkillCode=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 10, ColumnCounter);
			String Position_RequirementsReasonForChosen=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 11, ColumnCounter);
			String Position_RequirementsPleaseidentifythecompanyproduct=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 12, ColumnCounter);
			String Position_RequirementsPleaseclarifywhattraining=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 13, ColumnCounter);
			String Position_Requirementsdifficult=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 14, ColumnCounter);
			String Position_RequirementsExperiencewithEmployer=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 15, ColumnCounter);
			String Position_RequirementsExperiencewiththeemployerradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 16, ColumnCounter);
			String Position_RequirementsExperiencewiththeemployerifyes=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 17, ColumnCounter);
			String Position_RequirementsKnowledgeoftheemployerradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 18, ColumnCounter);
			String Position_RequirementsKnowledgeoftheemployerifyes=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 19, ColumnCounter);
			
			String Position_RequirementsPersonnelManagementradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 20, ColumnCounter);
			String Position_RequirementsMinimumemployee=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 21, ColumnCounter);
			String Position_RequirementsMaximumemployee=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 22, ColumnCounter);
			String Position_RequirementsListjobtitles=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 23, ColumnCounter);
			String Position_RequirementsDirectionofmanagement=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 24, ColumnCounter);
			String Position_RequirementAdministrationofbudgetradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 25, ColumnCounter);
			String Position_RequirementAdministrationofbudgetifyes=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 26, ColumnCounter);
			String Position_Requirementsdescriptionoftheproduct=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 27, ColumnCounter);
			String Position_RequirementsEstimatedvalue=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 28, ColumnCounter);
			String Position_RequirementsExplainhowemployeewillact=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 29, ColumnCounter);
			
			String Position_Requirementsmanagerialduties=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 30, ColumnCounter);
			String Position_Requirementscertificationlicensingradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 31, ColumnCounter);
			String Position_Requirementscertificationlicensingdesc=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 32, ColumnCounter);
			String Position_Requirementsrequiredcertificationsradio=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 33, ColumnCounter);
			String Position_RequirementsIslanguagefluencyradio =UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 34, ColumnCounter);
			String Position_RequirementsIslanguagefluencydesc =UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 35, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Position_Requirements", 36, ColumnCounter);
			
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			String Position_Requirements_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String Position_RequirementsCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			String fieldofstudyother=".//*[@id='FieldOfStudyOther']";
			String Estimatedvaluexpath=".//*[@class='control-group field-group-inline']//*[@id]";
			
			String radiofieldxpath=".//*[@class='question-group'][xx]//*[@class='control-group']//*[@name]";
			String radiocounterxpath=".//*[@class='question-group']//*[@class='control-group']//*[@name]";
			String radioinput1=".//*[@id='F120b']";
			String radioinput2=".//*[@id='Language']";


			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Position Requirements";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Position_RequirementsScenerio;
			 description=Position_RequirementsTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)| mode.equals(ACTION1)){
				 try{
					 /*String Position_RequirementsURLwithID=Position_RequirementsPageURL+Position_RequirementsID;
					 utilfunc.NavigatetoURL(Position_RequirementsURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 int ObjCount=utilfunc.GetObjectCount(Position_RequirementsCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Position_Requirements_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("DegreeRequired")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Position_RequirementDegreeRequired);
					        	}	
							 else if(AttributeName.equals("FieldOfStudy")){	
								 String Businesspath1=NewXpath+"[1]";
								 String Computerpath2=NewXpath+"[3]";
								 String Engineeringpath3=NewXpath+"[5]";
								 
								 utilfunc.MakeElement(Businesspath1).click();
								 utilfunc.MakeElement(Computerpath2).click();
								 utilfunc.MakeElement(Engineeringpath3).click();
								 
								 utilfunc.MakeElement(fieldofstudyother).clear();
								 utilfunc.MakeElement(fieldofstudyother).sendKeys("TEST DATA");
								 
					        	}
							 else if(AttributeName.equals("YearsOfExperience")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsYearsOfExperience);
					        	}
							 else if(AttributeName.equals("Description")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsDescription);
								}
							 else if(AttributeName.equals("SkillCode")){							
								 String path1=NewXpath+"[1]";
								 String path2=NewXpath+"[3]";
								 String path3=NewXpath+"[5]";
								 
								 utilfunc.MakeElement(path1).click();
								 utilfunc.MakeElement(path2).click();
								 utilfunc.MakeElement(path3).click();
					        	}
							 else if(AttributeName.equals("ReasonForChosen")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsReasonForChosen);
					        	}
							 else if(AttributeName.equals("F116")){			
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsPleaseidentifythecompanyproduct);
					        	}
							 else if(AttributeName.equals("F117")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsPleaseclarifywhattraining);
					        	}
							 else if(AttributeName.equals("F118")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_Requirementsdifficult);
					        	}
							 else if(AttributeName.equals("F101a")){									
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F101b")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsExperiencewithEmployer);
					        	}
							 else if(AttributeName.equals("F102a")){	
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F102b")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsExperiencewiththeemployerifyes);
					        	}
							 else if(AttributeName.equals("F103a")){							
								 utilfunc.MakeElement(NewXpath).click();
							 	}
							 else if(AttributeName.equals("F103b")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsKnowledgeoftheemployerifyes);
					        	}
							 else if(AttributeName.equals("F104a")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F104b")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F104c")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F104d")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F104e")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F105a")){							
								 String Minimumxpath=NewXpath+"[1]";
								 String Maximumxpath=NewXpath+"[2]";
								 utilfunc.MakeElement(Minimumxpath).clear();
								 utilfunc.MakeElement(Maximumxpath).clear();
								 utilfunc.MakeElement(Minimumxpath).sendKeys(Position_RequirementsMinimumemployee);
								 utilfunc.MakeElement(Maximumxpath).sendKeys(Position_RequirementsMaximumemployee);
								 
					        	}
							 else if(AttributeName.equals("F106")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsListjobtitles);
					        	}
							 else if(AttributeName.equals("F107")){							
								 utilfunc.MakeElement(NewXpath).click();
					        	}
							 else if(AttributeName.equals("F108a")){
								 utilfunc.MakeElement(NewXpath).click();
								 String dollarvalue=".//*[@id='F108b']";
								 utilfunc.MakeElement(dollarvalue).clear();
								 utilfunc.MakeElement(dollarvalue).sendKeys(Position_RequirementAdministrationofbudgetifyes);
								
					        	}
							 else if(AttributeName.equals("F109")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_Requirementsdescriptionoftheproduct);
					        	}
							 else if(AttributeName.equals("F111")){	
								 utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsExplainhowemployeewillact);
					        	}
							 else if(AttributeName.equals("F112")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_Requirementsmanagerialduties);
					        	}
							 else if(AttributeName.equals("F110")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Position_RequirementsEstimatedvalue);
					        	}
														 
							 
						 }catch(Exception e){
							 
						 }
					 }
					/* /////////Estimated value////////
					 utilfunc.MakeElement(Estimatedvaluexpath).clear();
					 utilfunc.MakeElement(Estimatedvaluexpath).sendKeys(Position_RequirementsEstimatedvalue);*/
					 ////////////////////////radio handler//////////////////////////////////////
					 int ObjCount1=utilfunc.GetObjectCount(radiocounterxpath);
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=radiofieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("F120a")){		
								 if(Position_Requirementscertificationlicensingradio.equals("Yes")){
								 utilfunc.MakeElement(NewXpath).click();
								 utilfunc.MakeElement(radioinput1).clear();
								 utilfunc.MakeElement(radioinput1).sendKeys(Position_Requirementscertificationlicensingdesc);
								 }
					        	}	
							 else if(AttributeName.equals("F121a")){	
								 if(Position_Requirementsrequiredcertificationsradio.equals("Yes")){
								 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("F119a")){
								 if(Position_RequirementsIslanguagefluencyradio.equals("Yes")){
								 utilfunc.MakeElement(NewXpath).click();
								 utilfunc.MakeElement(radioinput2).clear();
								 utilfunc.MakeElement(radioinput2).sendKeys(Position_RequirementsIslanguagefluencydesc);
					        	}
							 }
						 }catch(Exception e){
							 
						 }
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				
				 
				 }///////////url ckeck end
			
			 return Flag;
	 	}

}
