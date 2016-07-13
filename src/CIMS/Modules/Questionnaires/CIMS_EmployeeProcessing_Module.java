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

public class CIMS_EmployeeProcessing_Module {
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

	public CIMS_EmployeeProcessing_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean EmployeeProcessing_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 0, ColumnCounter);
		String EmployeeProcessingScenerio=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 2, ColumnCounter);
		String EmployeeProcessingTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 3, ColumnCounter);		
		String EmployeeProcessingPageURL=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 4, ColumnCounter);
		String EmployeeProcessingID=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 5, ColumnCounter);

		String PortOfEntry=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 6, ColumnCounter);
		String EmbassyOrConsulate=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 7, ColumnCounter);
		String CurrentEmploymentPlanradio=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 8, ColumnCounter);
		String TravelPlanradio=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 9, ColumnCounter);
		String TravelPlandesc=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 10, ColumnCounter);
		String MovingPlanradio=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 11, ColumnCounter);
		String MovingPlandesc=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 12, ColumnCounter);
		String SameJobAsLaborCertificationradio=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 13, ColumnCounter);
		String CurrentEmploymentPlanSelectBoxIt=UtilFunction.getCellData("Test Data.xls", "EmployeeProcessing", 13, ColumnCounter);

		String addditionalinfoxpath=".//./div/h4/..//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//./div/h4/..//*[@class='control-group']//*[@id]";

		String EmployeeProcessing_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='question-group'][xx]//*[@name]";
		String EmployeeProcessingCounterXpath=".//*[@class='form-horizontal']//*[@class='question-group']//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Employee Processing";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=EmployeeProcessingScenerio;
		description=EmployeeProcessingTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)|mode.equals(ACTION1)){
				try{
					/*String EmployeeProcessingURLwithID=EmployeeProcessingPageURL+EmployeeProcessingID;
					 utilfunc.NavigatetoURL(EmployeeProcessingURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					int ObjCount=utilfunc.GetObjectCount(EmployeeProcessingCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewXpath=EmployeeProcessing_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							//	 System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("PortOfEntry")){	
								try{	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(PortOfEntry);
								}catch(Exception error){}	
							}	
							else if(AttributeName.equals("EmbassyOrConsulate")){	
								try{	 utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(EmbassyOrConsulate);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("CurrentEmploymentPlan")){
								if(CurrentEmploymentPlanradio.equals("Yes")){
									try{ 
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}else{
									try{	
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("TravelPlan")){
								if(TravelPlanradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
										String newpath=NewXpath.replace("//*[@name]", "//textarea");
										utilfunc.MakeElement(newpath).clear();
										utilfunc.MakeElement(newpath).sendKeys(TravelPlandesc);
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("MovingPlan")){	
								if(MovingPlanradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
										String newpath=NewXpath.replace("//*[@name]", "//textarea");
										utilfunc.MakeElement(newpath).clear();
										utilfunc.MakeElement(newpath).sendKeys(MovingPlandesc);
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("SameJobAsLaborCertification")){	
								if(SameJobAsLaborCertificationradio.equals("Yes")){
									try{	 
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										Thread.sleep(1000);
									}catch(Exception error){}
								}
							}
						}catch(Exception e){

						}
					}
					//////////////////////////////
					try{
						String path=".//*[@id='CurrentEmploymentPlanSelectBoxIt']";
						Thread.sleep(1000);
						utilfunc.MakeElement(path).click();
						Thread.sleep(1000);
						utilfunc.mouseaction();
					}catch(Exception e){}

					//////////////////////Additional info handle///////////////////////////////
					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception e){}

					try{utilfunc.savebutton();
					}catch(Exception e){}


					/* boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }*/
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.contains("Success!")){
						Flag=true;
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
						Thread.sleep(1000);
						utilfunc.MakeElement(deletexpath).click();
						Thread.sleep(1000);
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Employee Processing Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			

			}
		}///////////url ckeck end
		return Flag;
	}
}