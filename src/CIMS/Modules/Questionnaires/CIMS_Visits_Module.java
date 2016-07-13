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

import CIMS.CIMS_MainProject;
import util.UtilFunction;

public class CIMS_Visits_Module {
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

	public CIMS_Visits_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Visits_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 0, ColumnCounter);
		String Previous_TravelScenerio=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 2, ColumnCounter);
		String Previous_TravelTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 3, ColumnCounter);		
		String Previous_TravelPageURL=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 4, ColumnCounter);
		String Previous_TravelID=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 5, ColumnCounter);

		String Previous_TravelDestinationCountry=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 6, ColumnCounter);
		String Previous_TravelDateofEntry=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 7, ColumnCounter);
		String Previous_TravelDateofDeparture=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 8, ColumnCounter);
		String Previous_TravelTypeofVisaStatus=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 9, ColumnCounter);
		String Previous_TravelCityTownLocalityofEntry=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 10, ColumnCounter);
		String Previous_TravelStateProvinceRegionofEntry=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 11, ColumnCounter);
		String Previous_TravelCompaniesorPlacesVisited=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 12, ColumnCounter);
		String Previous_TravelWereyouinspectedbyanImmigrationOffice=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 13, ColumnCounter);
		String Previous_TravelWereyoudeniedentry=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 14, ColumnCounter);
		String Previous_TravelNotes=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 15, ColumnCounter);
		String Previous_TravelDocumentNumber=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 16, ColumnCounter);
		String Previous_TravelExpirationDate=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 17, ColumnCounter);
		String Previous_TravelSpecialNotationsonCard=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 18, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 19, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 20, ColumnCounter);
		
		
	/////upload document popup element value(s)/////////////////
			//String Fileupload=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 19, ColumnCounter);
			String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 21, ColumnCounter);
			String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 22, ColumnCounter);
			String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Previous_Travel", 23, ColumnCounter);
			//////////////////Pop-up window controls xpath/////////////////////////////
			String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
			String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
			String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
			String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		//String fileuploadbutton=".//*[@id='btnUploadDocuments']";


		String addditionalinfoxpath=".//*[@class='action-bar']//*[@class='control-group'][xx]//*[@name]";
		String addditionalinfocounterxpath=".//*[@class='action-bar']//*[@class='control-group']//*[@name]";

		String Previous_Travel_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
		String Previous_TravelCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Previous Travel";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Previous_TravelScenerio;
		description=Previous_TravelTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String Previous_TravelURLwithID=Previous_TravelPageURL+Previous_TravelID;
					 utilfunc.NavigatetoURL(Previous_TravelURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String AddbuttonXpath="//*[@class='btn']";
					try{					 
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);
					}catch(Exception error){}				 


					int ObjCount=utilfunc.GetObjectCount(Previous_TravelCounterXpath);

					try{
						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(400);
							String NewXpath=Previous_Travel_attributeFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("CountryCode")){							
									try{Thread.sleep(1000);
									utilfunc.DeSelectdropdownvalue(NewXpath);
									
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, Previous_TravelDestinationCountry);
									}catch(Exception error){}
								}	
								else if(AttributeName.equals("DateOfEntry")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDateofEntry);
								}
								else if(AttributeName.equals("DateOfExit")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDateofDeparture);
								}
								else if(AttributeName.equals("VisaClassId")){							
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Previous_TravelTypeofVisaStatus);
								}
								else if(AttributeName.equals("CityOfEntry")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelCityTownLocalityofEntry);
								}
								else if(AttributeName.equals("StateOrProvinceOfEntry")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelStateProvinceRegionofEntry);
								}
								else if(AttributeName.equals("CompanyOrPlaceVisited")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelCompaniesorPlacesVisited);
								}
								else if(AttributeName.equals("InspectedByImmigrantOfficer")){							
									utilfunc.MakeElement(NewXpath).click();
								}
								else if(AttributeName.equals("EntryDenied")){							
									try{utilfunc.MakeElement(NewXpath).click();}
									catch(Exception error){}
								}
								else if(AttributeName.equals("Note")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelNotes);
								}
								else if(AttributeName.equals("DocumentNumber")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDocumentNumber);
								}
								else if(AttributeName.equals("DocumentExpirationDate")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelExpirationDate);
								}
								else if(AttributeName.equals("DocumentSpecialNotation")){							
									utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelSpecialNotationsonCard);
								}
								else if(AttributeName.contains("uploaderFile")){
try{
									if(Fileupload.equals("Yes")){
										utilfunc.MakeElement(uploadbuttonxpath).click();
										utilfunc.uploadfile(fileuploadpath);
									}
}catch(Exception error){}
								}



							}catch(Exception e){

							}
						}

					}catch(Exception error){}
					/////////////////upload////////////////////////////////////
					/*try{
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

					}*/
					
					
					
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

					//////////////////////Additional info handle///////////////////////////////
					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);}
					catch(Exception erorr){}

				try{	utilfunc.savebutton();}
				catch(Exception error){}


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

				}


			}else if(mode.equals(ACTION1)){
				try{
					/*String Previous_TravelURLwithID=Previous_TravelPageURL+Previous_TravelID;
					 utilfunc.NavigatetoURL(Previous_TravelURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();

					int ObjCount=utilfunc.GetObjectCount(Previous_TravelCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=Previous_Travel_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("CountryCode")){	

								if(Previous_TravelDestinationCountry.equals("")){
									utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
								}else{
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Previous_TravelDestinationCountry);
								}

							}	
							else if(AttributeName.equals("DateOfEntry")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDateofEntry);
							}
							else if(AttributeName.equals("DateOfExit")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDateofDeparture);
							}
							else if(AttributeName.equals("VisaClassId")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Previous_TravelTypeofVisaStatus);
							}
							else if(AttributeName.equals("CityOfEntry")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelCityTownLocalityofEntry);
							}
							else if(AttributeName.equals("StateOrProvinceOfEntry")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelStateProvinceRegionofEntry);
							}
							else if(AttributeName.equals("CompanyOrPlaceVisited")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelCompaniesorPlacesVisited);
							}
							else if(AttributeName.equals("InspectedByImmigrantOfficer")){							
								utilfunc.MakeElement(NewXpath).click();
							}
							else if(AttributeName.equals("EntryDenied")){							
								utilfunc.MakeElement(NewXpath).click();
							}
							else if(AttributeName.equals("Note")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelNotes);
							}
							else if(AttributeName.equals("DocumentNumber")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelDocumentNumber);
							}
							else if(AttributeName.equals("DocumentExpirationDate")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelExpirationDate);
							}
							else if(AttributeName.equals("DocumentSpecialNotation")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Previous_TravelSpecialNotationsonCard);
							}
							else if(AttributeName.contains("uploaderFile")){

								if(Fileupload.equals("Yes")){
									utilfunc.MakeElement(uploadbuttonxpath).click();
									utilfunc.uploadfile(fileuploadpath);
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
					//////////////////////Additional info handle///////////////////////////////
					utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);

					utilfunc.savebutton();


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
					/*String Previous_TravelURLwithID=Previous_TravelPageURL+Previous_TravelID;
					 utilfunc.NavigatetoURL(Previous_TravelURLwithID);*/
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					utilfunc.MakeElement(DeletebuttonXpath).click();

					Thread.sleep(10000);

					utilfunc.isAlertPresent();
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
