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

public class CIMS_Patents_Module
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

	public CIMS_Patents_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean PatentsPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		boolean Flag =false;
		//Patents Page	
		try{
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Patents", 0, ColumnCounter);
			String PatentsScenerio=UtilFunction.getCellData("Test Data.xls", "Patents", 2, ColumnCounter);
			String PatentsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Patents", 3, ColumnCounter);		
			String PatentsPageURL=UtilFunction.getCellData("Test Data.xls", "Patents", 4, ColumnCounter);
			String PatentsID=UtilFunction.getCellData("Test Data.xls", "Patents", 5, ColumnCounter);	

			String PatentsCountry=UtilFunction.getCellData("Test Data.xls", "Patents", 6, ColumnCounter);
			String PatentsPatentNumber=UtilFunction.getCellData("Test Data.xls", "Patents", 7, ColumnCounter);
			String PatentsNameDescription=UtilFunction.getCellData("Test Data.xls", "Patents", 8, ColumnCounter);


			String PatentsDateApplied=UtilFunction.getCellData("Test Data.xls", "Patents", 9, ColumnCounter);
			String PatentsPendingorIssued=UtilFunction.getCellData("Test Data.xls", "Patents", 10, ColumnCounter);
			String PatentsDateIssued=UtilFunction.getCellData("Test Data.xls", "Patents", 11, ColumnCounter);


			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Patents", 12, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Patents", 13, ColumnCounter);

			/////upload document popup element value(s)/////////////////
			String DocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Patents", 14, ColumnCounter);
			String DocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Patents", 15, ColumnCounter);
			String DocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Patents", 16, ColumnCounter);

			//		try{}catch(Exception e){System.out.println("issue while fetching data");}
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

			String Patentsfieldxpath=".//*[@class='control-group'][xx]//*[@name]";
			String Patentscounterxpath=".//*[@class='control-group']//*[@name]";

			/////////////////////////////////URL FETCH///////////////////////////////////

			String QuestionarieName="Patents";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);


			testcaseid=TestcaseID;
			scenerio=PatentsScenerio;
			description=PatentsTestcaseDescription;

			String Module="New";
			String Module1="Edit";
			String Module2="Delete";
			webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			if(URLwithID.equals("")){
				utilfunc.closesidebar();
				Flag=false; 
			}else{



				if(mode.equals(Module)){
					try{
						/*String PatentsURLwithID=PatentsPageURL+PatentsID;

		 			utilfunc.NavigatetoURL(PatentsURLwithID);*/

						utilfunc.NavigatetoURL(URLwithID);
						utilfunc.ServerErrorHandler();
						Thread.sleep(2000);

						String AddbuttonXpath="//*[@class='btn']";
						try{
							utilfunc.MakeElement(AddbuttonXpath).click();
							Thread.sleep(2000);
							int ObjCount=utilfunc.GetObjectCount(Patentscounterxpath);

							for(int count=1; count<=ObjCount; count++)
							{
								Thread.sleep(300);
								String NewXpath=Patentsfieldxpath.replace("xx", Integer.toString(count));

								try{							 
									String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									//System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.equals("ddlCountry")){
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, PatentsCountry);}
										catch(Exception error){}

									}else if(AttributeName.equals("patentNo")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(PatentsPatentNumber);}
										catch(Exception error){}

									}else if(AttributeName.equals("description")){	
										try{utilfunc.MakeElement(NewXpath).sendKeys(PatentsNameDescription);}
										catch(Exception error){}

									}else if(AttributeName.equals("DateApplied")){	
										try{utilfunc.MakeElement(NewXpath).sendKeys(PatentsDateApplied);}
										catch(Exception error){}

									}else if(AttributeName.equals("ddlStatusType")){	
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, PatentsPendingorIssued);}
										catch(Exception error){}

									}else if(AttributeName.equals("DateIssued")){	
										try{utilfunc.MakeElement(NewXpath).sendKeys(PatentsDateIssued);
										utilfunc.MakeElement(".//*[@id='panel-header']").click();
										
										}
										catch(Exception error){}

									}else if(AttributeName.contains("btn_uploader")){

										if(Fileupload.equals("Yes")){
											//
										}
									}
								}catch(Exception e){

								}
							}
							/////////////////upload////////////////////////////////////

							
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
											Thread.sleep(300);
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
													utilfunc.MakeElement(DocumentUploadControlsxpathcopy).sendKeys(DocumentUploadPopUpDocName);
												}catch(Exception error){}
											}
											else if(docuattribute.contains("BalNumber1"))
											{
												///Project associate
												try{
													System.out.println("Education_HistoryDocumentUploadPopUpProjectAssociated :"+DocumentUploadPopUpProjectAssociated+":");
													Thread.sleep(1000);
													try{
														utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, DocumentUploadPopUpProjectAssociated);
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
													utilfunc.Selectdropdownvaluebytext(DocumentUploadControlsxpathcopy, DocumentUploadPopUpDocVisibility);
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


							//function to call the dynamic text data
							try{utilfunc.dynamic_data(Patentscounterxpath, Patentsfieldxpath);}
							catch(Exception error){}

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

						}catch(Exception error){	utilfunc.NavigatetoURL(URLwithID);}
					}catch(Exception Ex){}

				}

				else if(mode.equals(Module1)){
					try{
						/* String PatentsURLwithID=PatentsPageURL+PatentsID;

			 utilfunc.NavigatetoURL(PatentsURLwithID);*/

						utilfunc.NavigatetoURL(URLwithID);
						utilfunc.ServerErrorHandler();
						Thread.sleep(2000);

						String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
						utilfunc.MakeElement(EditbuttonXpath).click();
						Thread.sleep(2000);


						int ObjCount=utilfunc.GetObjectCount(Patentscounterxpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Patentsfieldxpath.replace("xx", Integer.toString(count));

							try{ 
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("ddlCountry")){
									try{ utilfunc.Selectdropdownvaluebyvalue(NewXpath, PatentsCountry);
									}catch(Exception error){}				 
								}else if(AttributeName.equals("patentNo")){
									try{ 
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(PatentsPatentNumber);
									}catch(Exception error){}
								}else if(AttributeName.equals("description")){	
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(PatentsNameDescription);
									}catch(Exception error){}
								}else if(AttributeName.equals("DateApplied")){	
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(PatentsDateApplied);
									}catch(Exception error){}
								}else if(AttributeName.equals("ddlStatusType")){	
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, PatentsPendingorIssued);
									}catch(Exception error){}				 
								}else if(AttributeName.equals("DateIssued")){	
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(PatentsDateIssued);
									}catch(Exception error){} 						 
								}else if(AttributeName.contains("btn_uploader")){

									if(Fileupload.equals("Yes")){
										/*	utilfunc.MakeElement(uploadbuttonxpath).click();
										utilfunc.uploadfile(fileuploadpath);*/
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
						//function to call the dynamic text data
						try{utilfunc.dynamic_data(Patentscounterxpath, Patentsfieldxpath);	
						}catch(Exception error){}

						try{
							utilfunc.savebutton();
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

					}catch(Exception Ex){
						utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
						utilfunc.ErrorMessage2="No Records Found to Edit";
						Flag=false;
						utilfunc.TakeScreenshot();
					}

					return Flag; 

				}
				else if(mode.equals(Module2)){
					try{
						/*String PatentsURLwithID=PatentsPageURL+PatentsID;
				 utilfunc.NavigatetoURL(PatentsURLwithID);*/
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


						Thread.sleep(6000);


						String delete=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
						try{
							utilfunc.MakeElement(delete).click();
							Thread.sleep(10000);
							utilfunc.isAlertPresent();
						}catch(Exception error){}


						boolean error_flag=utilfunc.ErrorMessagehandler();
						if (error_flag){
							Flag=true;
						}else{
							Flag=false;
						}
					}
					catch(Exception s){
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
		}catch(Exception e){System.out.println("issue while fetching data");}
		return Flag;
	}	 
}