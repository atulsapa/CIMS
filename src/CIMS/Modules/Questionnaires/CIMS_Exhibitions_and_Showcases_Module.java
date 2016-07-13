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

import CIMS.CIMS_MainProject;

import util.UtilFunction;

public class CIMS_Exhibitions_and_Showcases_Module
{


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

	public CIMS_Exhibitions_and_Showcases_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean Exhibitions_and_ShowcasesPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Passport Page	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 0, ColumnCounter);
		String Exhibitions_and_ShowcasesScenerio=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 2, ColumnCounter);
		String Exhibitions_and_ShowcasesTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 3, ColumnCounter);		
		String Exhibitions_and_ShowcasesPageURL=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 4, ColumnCounter);
		String Exhibitions_and_ShowcasesID=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 5, ColumnCounter);			

		String Exhibitions_and_ShowcasesName=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 6, ColumnCounter);
		String BriefDescriptionofEvent=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 7, ColumnCounter);
		String Exhibitions_and_ShowcasesNameDate=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 8, ColumnCounter);
		String Exhibitions_and_Showcasesradio1=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 9, ColumnCounter);

		String Exhibitions_and_ShowcasesReasonsyouwereselected=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 10, ColumnCounter);
		String Exhibitions_and_Showcasesradio2=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 11, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 12, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Exhibitions_and_Showcases", 13, ColumnCounter);

		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";


		//Methods Xpath

		String Exhibitions_and_ShowcasesFieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String Exhibitions_and_ShowcasesCounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		///Additional info xpath
		String Additionalinfofieldxpath=".//*[@class='form-horizontal']/div//*[@class='control-group'][xx]//*[@id]";
		String Additioninfocounterxpath=".//*[@class='form-horizontal']/div//*[@class='control-group']//*[@id]";



		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Exhibitions and Showcases";
		// String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Exhibitions_and_ShowcasesScenerio;
		description=Exhibitions_and_ShowcasesTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String Exhibitions_and_ShowcasesURLwithID=Exhibitions_and_ShowcasesPageURL+Exhibitions_and_ShowcasesID;

				 utilfunc.NavigatetoURL(Exhibitions_and_ShowcasesURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					try{
						String AddbuttonXpath="//*[@class='btn']";
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);

						int ObjCount=utilfunc.GetObjectCount(Exhibitions_and_ShowcasesCounterxpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Exhibitions_and_ShowcasesFieldxpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								//System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("EventName")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesName);
									}catch(Exception Ex){}
								}	
								else if(AttributeName.equals("EventDate")){							
									try{ utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesNameDate);
									}catch(Exception Ex){}
								}
								else if(AttributeName.equals("IsRecognized")){							
									try{ utilfunc.MakeElement(NewXpath).click();
									}catch(Exception Ex){}
								}
								else if(AttributeName.equals("SelectionReasons")){							
									try{ utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesReasonsyouwereselected);
									}catch(Exception Ex){}
								}
								else if(AttributeName.equals("IsDocumentation")){							
									try{ utilfunc.MakeElement(NewXpath).click();
									}catch(Exception Ex){}
								}
								else if(AttributeName.contains("btnShowDocUpload")){
									if(Fileupload.equals("Yes")){
										try{ utilfunc.MakeElement(showbuttonxpath).click();
										Thread.sleep(2000);
										utilfunc.MakeElement(uploadbuttonxpath).click();
										Thread.sleep(1000);    
										utilfunc.uploadfile(fileuploadpath);
										Thread.sleep(5000);
										utilfunc.MakeElement(fileuploadbutton).click();
										}catch(Exception Ex){}
									}
								}
								else if(AttributeName.equals("BriefDescription")){							
									try{ utilfunc.MakeElement(NewXpath).sendKeys(BriefDescriptionofEvent);
									}catch(Exception Ex){}
								}
							}catch(Exception e){}
						}
						////////Additional info handled////////////

						try{utilfunc.dynamic_data(Additioninfocounterxpath, Additionalinfofieldxpath);
						}catch(Exception Ex){}

						try{utilfunc.savebutton();
						}catch(Exception Ex){}

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

					}catch(Exception Ex){utilfunc.NavigatetoURL(URLwithID);}
				}catch(Exception Ex){}



			}else if(mode.equals(ACTION1)){

				try{
					/* String Exhibitions_and_ShowcasesURLwithID=Exhibitions_and_ShowcasesPageURL+Exhibitions_and_ShowcasesID;

				 utilfunc.NavigatetoURL(Exhibitions_and_ShowcasesURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					try{
						String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
						utilfunc.MakeElement(EditbuttonXpath).click();
						Thread.sleep(2000);

						int ObjCount=utilfunc.GetObjectCount(Exhibitions_and_ShowcasesCounterxpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Exhibitions_and_ShowcasesFieldxpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								//System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("EventName")){		
									try{ 
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesName);
									}catch(Exception error){}
								}	
								else if(AttributeName.equals("EventDate")){
									try{ 
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesNameDate);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("IsRecognized")){							
									try{utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
								else if(AttributeName.equals("SelectionReasons")){	
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Exhibitions_and_ShowcasesReasonsyouwereselected);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("IsDocumentation")){							
									try{ utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
								else if(AttributeName.contains("btnShowDocUpload")){

									if(Fileupload.equals("Yes")){
										try{	 utilfunc.MakeElement(showbuttonxpath).click();
										Thread.sleep(2000);
										utilfunc.MakeElement(uploadbuttonxpath).click();
										Thread.sleep(1000);    
										utilfunc.uploadfile(fileuploadpath);
										Thread.sleep(5000);
										utilfunc.MakeElement(fileuploadbutton).click();
										}catch(Exception error){}
									}
								}
								else if(AttributeName.equals("BriefDescription")){							
									try{ utilfunc.MakeElement(NewXpath).sendKeys(BriefDescriptionofEvent);
									}catch(Exception error){}}
							}catch(Exception error){}
						}
						////////Additional info handled////////////
						try{utilfunc.dynamic_data(Additioninfocounterxpath, Additionalinfofieldxpath);
						}catch(Exception error){}

						try{utilfunc.savebutton();
						}catch(Exception error){}

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


					}catch(Exception error){}
				}catch(Exception Ex){
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
					/*	 String Exhibitions_and_ShowcasesURLwithID=Exhibitions_and_ShowcasesPageURL+Exhibitions_and_ShowcasesID;

				 utilfunc.NavigatetoURL(Exhibitions_and_ShowcasesURLwithID);*/
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
					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(DeletebuttonXpath).click();
						Thread.sleep(10000);
						utilfunc.isAlertPresent();
					}catch(Exception error){}

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