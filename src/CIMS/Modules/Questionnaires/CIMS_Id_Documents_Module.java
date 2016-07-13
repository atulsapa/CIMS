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

public class CIMS_Id_Documents_Module
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

	public CIMS_Id_Documents_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean Id_DocumentsPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Passport Page	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 0, ColumnCounter);
		String Id_DocumentsScenerio=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 2, ColumnCounter);
		String Id_DocumentsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 3, ColumnCounter);		
		String Id_DocumentsPageURL=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 4, ColumnCounter);
		String Id_DocumentsID=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 5, ColumnCounter);	

		String Id_DocumentsCountry=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 6, ColumnCounter);
		String Id_DocumentsDocumentType=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 7, ColumnCounter);
		String Id_DocumentsValidityStartDate=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 8, ColumnCounter);
		String Id_DocumentsValidityEndDate=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 9, ColumnCounter);


		String Id_DocumentsIssuedatCountry=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 10, ColumnCounter);
		String Id_DocumentsIssuedatCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 11, ColumnCounter);
		String Id_DocumentsIssuedatStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 12, ColumnCounter);
		String Id_DocumentsDocumentID=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 13, ColumnCounter);
		String Id_DocumentsNotesAdditionalInformation=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 14, ColumnCounter);

		String Id_DocumentsDriverLicenseNumber=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 15, ColumnCounter);
		String Id_DocumentsFromUS_StateUtilFunction=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 16, ColumnCounter);


		//Custom Field  
		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 17, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 18, ColumnCounter);
		/////upload document popup element value(s)/////////////////
		String DocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 19, ColumnCounter);
		String DocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 20, ColumnCounter);
		String DocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Id_Documents", 21, ColumnCounter);

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

		//Methods Xpath
		String Id_DocumentsFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String Id_DocumentscounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="ID Documents";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Id_DocumentsScenerio;
		description=Id_DocumentsTestcaseDescription;

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
					/* String Id_DocumentsURLwithID=Id_DocumentsPageURL+Id_DocumentsID;			 
			 utilfunc.NavigatetoURL(Id_DocumentsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String AddbuttonXpath="//*[@class='btn']";
					try{
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);
				

					int ObjCount=utilfunc.GetObjectCount(Id_DocumentscounterXpath);
					try{ 
						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Id_DocumentsFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("CountryCode")){							
									try
									{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsCountry);}
									catch(Exception error){}
									try{utilfunc.Selectdropdownvaluebytext(NewXpath, Id_DocumentsCountry);}
									catch(Exception error){}
								}	
								else if(AttributeName.equals("DocumentType")){							
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsDocumentType);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("EffectiveDate")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsValidityStartDate);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("ExpirationDate")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsValidityEndDate);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("IssuedAtCountry")){							
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsIssuedatCountry);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("IssuedAtCity")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsIssuedatCityTownLocality);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("IssuedAtStateOrProvince")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsIssuedatStateProvinceRegion);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("DocumentNumber")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsDocumentID);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("Note")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsNotesAdditionalInformation);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("DriverLicenseNumber")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsDriverLicenseNumber);
									}catch(Exception error){}
									}
								else if(AttributeName.equals("FromUSState")){							
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsFromUS_StateUtilFunction);
									}catch(Exception error){}
									}
								else if(AttributeName.contains("btnShowDocUpload")){

									if(Fileupload.equals("Yes")){
										/*utilfunc.MakeElement(showbuttonxpath).click();
								Thread.sleep(2000);
								utilfunc.MakeElement(uploadbuttonxpath).click();
								Thread.sleep(1000);    
					         utilfunc.uploadfile(fileuploadpath);
					         Thread.sleep(5000);
					         utilfunc.MakeElement(fileuploadbutton).click();*/
									}
								}
							}catch(Exception e){}
						}
					}catch(Exception error){}

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
					////////////////////additional info handle//////////////////
					try{utilfunc.dynamic_data(Id_DocumentscounterXpath, Id_DocumentsFiledXpath);
					}catch(Exception error){}
					//////////////////////////////////////////////////////////////
try{
					utilfunc.savebutton();	
}catch(Exception error){}

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					System.out.println("error_flag          :"+error_flag);
					System.out.println("ExpectedErrorMessage:"+ExpectedErrorMessage);
					if (error_flag.equals(ExpectedErrorMessage)){
						System.out.println("\n\n\n-------------------HAI--------------------------\n\n\n");
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.equals("")){
						System.out.println("\n\n\n-------------------BHAI--------------------------\n\n\n");
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}

				}catch(Exception error){utilfunc.NavigatetoURL(URLwithID);}

				}catch(Exception error){}

				//return false; 
			}else if(mode.equals(Module1)){

				try{
					/*String Id_DocumentsURLwithID=Id_DocumentsPageURL+Id_DocumentsID;			 
				 utilfunc.NavigatetoURL(Id_DocumentsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();

					int ObjCount=utilfunc.GetObjectCount(Id_DocumentscounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{	
						Thread.sleep(300);
						
						String NewXpath=Id_DocumentsFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("CountryCode")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsCountry);
							}catch(Exception error){}
							}	
							else if(AttributeName.equals("DocumentType")){							
								try{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsDocumentType);
							}catch(Exception error){}	
								}
							else if(AttributeName.equals("EffectiveDate")){
							try{
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsValidityStartDate);
							}catch(Exception error){}
							}

							else if(AttributeName.equals("ExpirationDate")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsValidityEndDate);
								}catch(Exception error){}
								}

							else if(AttributeName.equals("IssuedAtCountry")){							
							try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsIssuedatCountry);
							}catch(Exception error){}
							}
							///
							else if(AttributeName.equals("IssuedAtCity")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsIssuedatCityTownLocality);
								}catch(Exception error){}}
							else if(AttributeName.equals("IssuedAtStateOrProvince")){	
							try{
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsIssuedatStateProvinceRegion);
							}catch(Exception error){}
							}
							//
							else if(AttributeName.equals("DocumentNumber")){
							try{
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsDocumentID);
							}catch(Exception error){}
							}
							else if(AttributeName.equals("Note")){	
							try{
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsNotesAdditionalInformation);
							}catch(Exception error){}
							}
							else if(AttributeName.equals("DriverLicenseNumber")){							
							try{
								utilfunc.MakeElement(NewXpath).sendKeys(Id_DocumentsDriverLicenseNumber);
								utilfunc.MakeElement(NewXpath).clear();
							}catch(Exception error){}
							}
							else if(AttributeName.equals("FromUSState")){							
							try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Id_DocumentsFromUS_StateUtilFunction);
							}catch(Exception error){}
							}
							else if(AttributeName.contains("btnShowDocUpload")){

								if(Fileupload.equals("Yes")){
									utilfunc.MakeElement(showbuttonxpath).click();
									Thread.sleep(2000);
									utilfunc.MakeElement(uploadbuttonxpath).click();
									Thread.sleep(1000);    
									utilfunc.uploadfile(fileuploadpath);
									Thread.sleep(5000);
									utilfunc.MakeElement(fileuploadbutton).click();
								}
							}

						}catch(Exception e){

						}


					}
					////////////////////additional info handle//////////////////
					try{utilfunc.dynamic_data(Id_DocumentscounterXpath, Id_DocumentsFiledXpath);
					}catch(Exception error){}
					
					//////////////////////////////////////////////////////////////
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

				}catch(Exception e){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.ErrorMessage2="No Records Found to Edit";
					Flag=false;
					utilfunc.TakeScreenshot();
				}



			}else if(mode.equals(Module2)){
				try{
					/*String Id_DocumentsURLwithID=Id_DocumentsPageURL+Id_DocumentsID;			 
				 utilfunc.NavigatetoURL(Id_DocumentsURLwithID);*/
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

					Thread.sleep(3000);
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
		return Flag;
	}
}