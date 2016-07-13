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

public class CIMS_Pregnancy_Module
{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------
	public static String Deletecheck="";
	public static String ErrorMessage="";
	public static String ErrorMessage1="";

	public static String URLwithID="";
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	//Constructor----------

	public CIMS_Pregnancy_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean PregnancyModulePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Basic Information Page	



		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 0, ColumnCounter);
		String PregnancyScenerio=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 2, ColumnCounter);
		String PregnancyTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 3, ColumnCounter);		
		String PregnancyPageURL=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 4, ColumnCounter);
		String PregnancyID=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 5, ColumnCounter);

		String Pregnancyradio=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 6, ColumnCounter);
		String Pregnancyduedate=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 7, ColumnCounter);
		String Pregnancy_Areyouintendingtogivebirth=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 8, ColumnCounter);
		String textDate=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 9, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 10, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 11, ColumnCounter);

		/////upload document popup element value(s)/////////////////
		String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 13, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Pregnancy",14, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Pregnancy", 15, ColumnCounter);


		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";

		//////////////////Pop-up window controls xpath/////////////////////////////
		String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
		String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
		String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
		String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";




		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		//String radioYes=".//*[@class='question-group']//*[@class='radio inline'][1]//*[@id]";
		//String radioNo=".//*[@class='question-group']//*[@class='radio inline'][2]//*[@id]";
		String radioYes=".//*[@id='IsApplicantOrSpusePregnant' and contains(@value,'True')]";
		String radioNo=".//*[@id='IsApplicantOrSpusePregnant' and contains(@value,'False')]";

		String pregnancyduedate=".//*[@id='DueDate']";

		//String radioYes1=".//*[@id='dvIsApplicantOrSpusePregnant']//*[@class='question-option']//*[@class='radio inline'][1]//*[@id]";
		///String radioNo1=".//*[@id='dvIsApplicantOrSpusePregnant']//*[@class='question-option']//*[@class='radio inline'][2]//*[@id]";

		String radioYes1=".//*[@id='IsCost' and contains(@value,'True')]";
		String radioNo1=".//*[@id='IsCost' and contains(@value,'False')]";

		String radio=".//*[@id='WhatCost']";

		///Addition info handler///
		String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Pregnancy";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=PregnancyScenerio;
		description=PregnancyTestcaseDescription;

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
					/* String PregnancyURLwithID=PregnancyPageURL+PregnancyID;			 
				 utilfunc.NavigatetoURL(PregnancyURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					try{
						if(Pregnancyradio.equals("Yes")){
							try{
								Thread.sleep(1000);
								utilfunc.MakeElement(radioYes).click();
								Thread.sleep(1000);
							}catch(Exception error){}

							if(Pregnancy_Areyouintendingtogivebirth.equals("Yes")){
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(radioYes1).click();
									Thread.sleep(1000);
								}catch(Exception error){}

								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(radio).click();
									Thread.sleep(1000);
								}catch(Exception error){}

							}else if(Pregnancy_Areyouintendingtogivebirth.equals("No")){
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(radioNo1).click();
									Thread.sleep(1000);
								}catch(Exception error){}
							}

						}else if(Pregnancyradio.equals("No")){
							try{
								Thread.sleep(1000);
								utilfunc.MakeElement(radioNo).click();
							}catch(Exception error){}
						}
					}catch(Exception e){
					}
					//pregnancy due date
					try{
						utilfunc.MakeElement(pregnancyduedate).clear();
						utilfunc.MakeElement(pregnancyduedate).sendKeys(Pregnancyduedate);
					}catch(Exception e){
					}

					Thread.sleep(2000);
					try{
						if(Pregnancy_Areyouintendingtogivebirth.equalsIgnoreCase("yes"))
						{
							try{
							String PregnancyAreyouinten=".//*[@id='IsCost' and contains(@value,'rue')]";
							Thread.sleep(1000);
							utilfunc.MakeElement(PregnancyAreyouinten).click();
							Thread.sleep(1000);
							}catch(Exception error){}
						}
						else{
							try{
							String PregnancyAreyouinten=".//*[@id='IsCost' and contains(@value,'alse')]";
							Thread.sleep(1000);
							utilfunc.MakeElement(PregnancyAreyouinten).click();
							Thread.sleep(1000);
							}catch(Exception error){}
						}
					}catch(Exception error){}

					try{
						/*if(Fileupload.equals("Yes")){
						utilfunc.MakeElement(showbuttonxpath).click();
						Thread.sleep(2000);
						utilfunc.MakeElement(uploadbuttonxpath).click();
						Thread.sleep(1000);    
			         utilfunc.uploadfile(fileuploadpath);
			         Thread.sleep(5000);
			         utilfunc.MakeElement(fileuploadbutton).click();
					}*/
					}catch(Exception e){

					}Thread.sleep(800);
					
					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception error){}

					//////////////////Add Document (Upload file)//////////////////////
					System.out.println("We are going to upload files.\nPlease wait...");
					Thread.sleep(5000);

				try{
						if(Fileupload.equals("Yes")){
							try{utilfunc.MakeElement(showbuttonxpath).click();}catch(Exception error){}
							Thread.sleep(3000);
							try{utilfunc.MakeElement(uploadbuttonxpath).click();}catch(Exception error){}
							Thread.sleep(3000);    
							try{utilfunc.uploadfile(fileuploadpath);}catch(Exception error){}
							Thread.sleep(5000);
							///////////// ----Fill the pop-up window which appears after document upload--- ////////////////
							try{

								int elementcounter=utilfunc.GetObjectCount(DocumentUploadControlcounterxpath);
								//							System.out.println("\t--->Element counter :"+elementcounter);

								for(int count=1;count<=elementcounter;count++)
								{
									Thread.sleep(2000);
									if(count>=3)
									{
										DocumentUploadControlsxpath=DocumentUploadControlsxpath.replace("//*[@name]",DocumentUploadUpdatexpath);
									}
									String docuattribute="";
									String DocumentUploadControlsxpathcopy="";
									try{
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpath);
										DocumentUploadControlsxpathcopy=DocumentUploadControlsxpath;
										DocumentUploadControlsxpathcopy=DocumentUploadControlsxpathcopy.replace("xyz",Integer.toString(count));
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpathcopy);
										docuattribute=utilfunc.MakeElement(DocumentUploadControlsxpathcopy).getAttribute("name");
										//									System.out.println("DocumentUploadControlsxpath is :"+DocumentUploadControlsxpathcopy);
										//									System.out.println("Attribute is :"+docuattribute);
									}catch(Exception error){}

									if(docuattribute.contains("fld-title"))
									{
										///Document Name
										try{
											utilfunc.MakeElement(DocumentUploadControlsxpathcopy).sendKeys(Education_HistoryDocumentUploadPopUpDocName);
										}catch(Exception error){}
									}
									else if(docuattribute.contains("BalNumber1"))
									{
										///Project associate
										try{
											System.out.println("Education_HistoryDocumentUploadPopUpProjectAssociated :"+Education_HistoryDocumentUploadPopUpProjectAssociated+":");
											Thread.sleep(1000);
											try{
												utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, Education_HistoryDocumentUploadPopUpProjectAssociated);
												Thread.sleep(2000);
												try{
													utilfunc.MakeElement(DocumentUploadProjectAssociAddBtnxpath).click();
												}catch(Exception error){
													System.out.println("Unable to click add button");
												}
											}catch(Exception error){
												System.out.println("Unable to select value in Project Associate dropdown");
											}


										}catch(Exception error){}
									}
									else if(docuattribute.contains("fld-documentHighSecurity"))
									{
										///Document Visibility
										try{
											utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, Education_HistoryDocumentUploadPopUpDocVisibility);
										}catch(Exception error){}
									}


								}

								Thread.sleep(5000);
								utilfunc.MakeElement(fileuploadbutton).click();
								Thread.sleep(2000);

							}catch(Exception error){}
						}
					}catch(Exception error){}

					try{
						utilfunc.MakeElement(".//*[@id='DocUploadModal']//*[@class='close']").click();
						Thread.sleep(2000);
					}catch(Exception error){}

					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception error){}

					try{utilfunc.savebutton();
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
				}catch(Exception e){
				}
			}else if(mode.equals(ACTION1)){
				try{
					/*String PregnancyURLwithID=PregnancyPageURL+PregnancyID;			 
				 utilfunc.NavigatetoURL(PregnancyURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					try{
						if(Pregnancyradio.equals("Yes")){
							try{
								Thread.sleep(1000);
							utilfunc.MakeElement(radioYes).click();
							}catch(Exception error){}

							if(Pregnancy_Areyouintendingtogivebirth.equals("Yes")){
								try{
									Thread.sleep(1000);
								utilfunc.MakeElement(radioYes1).click();
								Thread.sleep(1000);
								utilfunc.MakeElement(radio).click();
								}catch(Exception error){}

							}else if(Pregnancy_Areyouintendingtogivebirth.equals("No")){
								try{
									Thread.sleep(1000);
								utilfunc.MakeElement(radioNo1).click();
								}catch(Exception error){}
							}



						}else if(Pregnancyradio.equals("No")){
							try{utilfunc.MakeElement(radioNo).click();
						}catch(Exception error){}
						}
					}catch(Exception e){

					}
					//pregnancy due date
					try{
						utilfunc.MakeElement(pregnancyduedate).clear();
						utilfunc.MakeElement(pregnancyduedate).sendKeys(Pregnancyduedate);
					}catch(Exception e){

					}

					try{
						if(Fileupload.equals("Yes")){
							try{
								utilfunc.MakeElement(showbuttonxpath).click();
							Thread.sleep(2000);
							utilfunc.MakeElement(uploadbuttonxpath).click();
							Thread.sleep(1000);    
							utilfunc.uploadfile(fileuploadpath);
							Thread.sleep(5000);
							utilfunc.MakeElement(fileuploadbutton).click();
							}catch(Exception error){}							
						}
					}catch(Exception e){

					}

					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception error){}
					
					try{utilfunc.savebutton();
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Pregnancy Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			
			}
		}///////////url ckeck end
		return Flag;
	}
}