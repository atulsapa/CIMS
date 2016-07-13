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

public class CIMS_Compensation_and_benifits_Module {

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

	public CIMS_Compensation_and_benifits_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean compensationPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 0, ColumnCounter);
		String compensationScenerio=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 2, ColumnCounter);
		String compensationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 3, ColumnCounter);		
		String compensationPageURL=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 4, ColumnCounter);
		String compensationID=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 5, ColumnCounter);

		String compensationtype=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 6, ColumnCounter);
		String compensationtypespecify=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 7, ColumnCounter);
		String compensationtamount=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 8, ColumnCounter);
		String compensationcurrency=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 9, ColumnCounter);
		String compensationper=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 10, ColumnCounter);
		String compensationpaid=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 11, ColumnCounter);
		String compensationSpcify=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 12, ColumnCounter);
		String radio=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 13, ColumnCounter);
		String compensationcomments=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 14, ColumnCounter);

		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 15, ColumnCounter);

		/////upload document popup element value(s)/////////////////
		String Fileupload=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 18, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 19, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 20, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "compensation_and_benifit", 21, ColumnCounter);
		//////////////////Pop-up window controls xpath/////////////////////////////
		String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
		String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
		String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
		String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		
		

		String compensationFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String compensationcounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";


		///////////////Additional info handled//////////////////////////////
		String Xpathnew1= ".//*[@class='form-horizontal']//*[@class='control-group']/div//*[@id]";
		String Xpathnew2=".//*[@class='form-horizontal']//*[@class='control-group'][xx]/div//*[@id]";

		////high salary or other remuneration radio handled////
		String radio1xpath=".//*[@id='radOtherJob']";
		String comments=".//*[@id='txtDetailOtherJob']";
		String radio2=".//*[@id='radOtherJob1']";

		//////documentation available radio handled////////////
		String radio2xpath=".//*[@id='radHasDocument']";
		String comments2=".//*[@id='comment']";
		String radio2no=".//*[@id='radHasDocument1']";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Compensation and Benefits";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=compensationScenerio;
		description=compensationTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){


				try{
					/* String CompensationURLwithID=compensationPageURL+compensationID;

						 utilfunc.NavigatetoURL(CompensationURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String AddbuttonXpath="//*[@class='btn']";
					try{ utilfunc.MakeElement(AddbuttonXpath).click();
					
					System.out.println("Page is loading . please wait..."); 
					Thread.sleep(2000);
					}catch(Exception error){}
					int ObjCount=utilfunc.GetObjectCount(compensationcounterXpath);

					try{
						for(int count=1; count<=ObjCount; count++)
						{
							//Thread.sleep(400);
							String NewXpath=compensationFiledXpath.replace("xx", Integer.toString(count));
							try{

								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("ddlTypeOfCompensation")){							
									try{ utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationtype);
									}catch(Exception error){}
								}	
								else if(AttributeName.equals("CompensationTypeOther")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(compensationtypespecify);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("estimatedvalue")){							
									utilfunc.MakeElement(NewXpath).sendKeys(compensationtamount);
								}
								else if(AttributeName.equals("ddlCurrency")){							
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationcurrency);
								}
								else if(AttributeName.equals("ddlPayPeriod")){							
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationper);
								}
								else if(AttributeName.equals("ddlCompanyEntity")){							
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationpaid);
								}
								else if(AttributeName.equals("paidby")){							
									utilfunc.MakeElement(NewXpath).sendKeys(compensationSpcify);
								}


							}catch(Exception e){

							}

						}
					}catch(Exception Error){}
					/////////////
					
					//radio button static
					try{
						if(radio.equalsIgnoreCase("YES")){

							utilfunc.MakeElement(radio1xpath).click();
							utilfunc.MakeElement(comments).sendKeys(compensationcomments);
						}else{
							utilfunc.MakeElement(radio2).click();					 
						}
					}catch(Exception e){

					}
					////////////
					try{
						if(radio.equalsIgnoreCase("YES")){
							utilfunc.MakeElement(radio2xpath).click();
							utilfunc.MakeElement(comments2).sendKeys(compensationcomments);
						}else{
							utilfunc.MakeElement(radio2no).click();
						}
					}catch(Exception e){

					}

//////////////////  Add Document (Upload file)//////////////////////
System.out.println("we are going to work with upload document.\n Please Wait...");
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
					
					
					
					
					try{ utilfunc.dynamic_data(Xpathnew1,Xpathnew2);
					}catch(Exception erorr){}
					/////////////////////////////////////////////////////////////////

					String SaveButtonXpath=".//*[@id='btnSave']";					

					////////flag check after save button click///

					try{	 utilfunc.MakeElement(SaveButtonXpath).click();}
					catch(Exception error){}
					//utilfunc.savebutton();

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					System.out.println("\n\n\n---"+error_flag+"---");
					System.out.println("---"+ExpectedErrorMessage+"---");
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

				}




				/////////////////////////EDIT MODE////////////////////////////////////////    
			}else if(mode.equals(ACTION1)){

				try{
					/*String CompensationURLwithID=compensationPageURL+compensationID;

							 utilfunc.NavigatetoURL(CompensationURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();


					int ObjCount=utilfunc.GetObjectCount(compensationcounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=compensationFiledXpath.replace("xx", Integer.toString(count));
						try{

							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("ddlTypeOfCompensation")){		
								if(compensationtype.equals("")){
									utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
								}else{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationtype);
								}

							}	
							else if(AttributeName.equals("CompensationTypeOther")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(compensationtypespecify);
							}
							else if(AttributeName.equals("estimatedvalue")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(compensationtamount);
							}
							else if(AttributeName.equals("ddlCurrency")){

								if(compensationcurrency.equals("")){
									utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
								}else{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationcurrency);
								}

							}
							else if(AttributeName.equals("ddlPayPeriod")){	

								if(compensationper.equals("")){
									utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
								}else{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationper);
								}

							}
							else if(AttributeName.equals("ddlCompanyEntity")){	

								if(compensationpaid.equals("")){
									utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
								}else{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, compensationpaid);
								}

							}
							else if(AttributeName.equals("paidby")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(compensationSpcify);
							}


						}catch(Exception e){

						}

					}
					/////////////

					try{
						//radio button static
						if(radio.equals("YES")){

							utilfunc.MakeElement(radio1xpath).click();
							utilfunc.MakeElement(comments).sendKeys(compensationcomments);
						}else{
							utilfunc.MakeElement(radio2).click();					 
						}

						if(radio.equals("YES")){
							utilfunc.MakeElement(radio2xpath).click();
							utilfunc.MakeElement(comments2).sendKeys(compensationcomments);
						}else{
							utilfunc.MakeElement(radio2no).click();
						}

					}catch(Exception f){

					}

					utilfunc.dynamic_data(Xpathnew1,Xpathnew2);
					/////////////////////////////////////////////////////////////////

					String SaveButtonXpath=".//*[@id='btnSave']";
					utilfunc.MakeElement(SaveButtonXpath).click();
					//utilfunc.savebutton();

					////////flag check after save button click///


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

					/*String CompensationURLwithID=compensationPageURL+compensationID;

							 utilfunc.NavigatetoURL(CompensationURLwithID);*/
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					Thread.sleep(10000);

					String delete=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					utilfunc.MakeElement(delete).click();

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
