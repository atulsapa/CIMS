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

public class CIMS_CitationsofYourWork_Module {
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

	public CIMS_CitationsofYourWork_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean CitationsofYourWork_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 0, ColumnCounter);
		String Media_and_PublicationsScenerio=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 2, ColumnCounter);
		String Media_and_PublicationsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 3, ColumnCounter);		
		String Media_and_PublicationsPageURL=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 4, ColumnCounter);
		String Media_and_PublicationsID=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 5, ColumnCounter);

		String Media_and_PublicationsCompletecitation=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 6, ColumnCounter);
		String Media_and_PublicationsWhywereyouoryourworkselected=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 7, ColumnCounter);
		String Media_and_PublicationsDidthisarticleappearinamagazine=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 8, ColumnCounter);
		String Media_and_PublicationsDidthisarticleappearinamagazinedesc=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 9, ColumnCounter);
		String Media_and_PublicationsAreyouabletoprovidecopyofthearticle=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 10, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 11, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Media_and_Publications", 12, ColumnCounter);

		/////upload document popup element value(s)/////////////////
		String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Education_History", 52, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Education_History", 53, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Education_History", 54, ColumnCounter);
		//////////////////Pop-up window controls xpath/////////////////////////////
		String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
		String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
		String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
		String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";

		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";

		String Media_and_Publications_attributeFiledXpath=".//*[@class='question-group']//*[@class='control-group'][xx]//*[@id]";
		String Media_and_PublicationsCounterXpath=".//*[@class='question-group']//*[@class='control-group']//*[@id]";

		String magazinedescriptionxpath=".//*[@id='AppearMagzineDesc']";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Media and Publications By Others About You";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Media_and_PublicationsScenerio;
		description=Media_and_PublicationsTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String Media_and_PublicationsURLwithID=Media_and_PublicationsPageURL+Media_and_PublicationsID;
					 utilfunc.NavigatetoURL(Media_and_PublicationsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();
					Thread.sleep(1000);
					String AddbuttonXpath="//*[@class='btn']";
					try{
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);
					}
					catch(Exception error){}

					int ObjCount=utilfunc.GetObjectCount(Media_and_PublicationsCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(400);
						String NewXpath=Media_and_Publications_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("CompleteCitation")){	
							try{	utilfunc.MakeElement(NewXpath).sendKeys(Media_and_PublicationsCompletecitation);	}catch(Exception error){}
							}	
							else if(AttributeName.equals("Why")){									 
								try{	utilfunc.MakeElement(NewXpath).sendKeys(Media_and_PublicationsWhywereyouoryourworkselected);	}catch(Exception error){}
							}
							else if(AttributeName.equals("AppearMagzine")){	
								if(Media_and_PublicationsDidthisarticleappearinamagazine.equals("Yes")){
									try{String NewXpath1=NewXpath.replace("//*[@id]", "//input[1]");
									utilfunc.MakeElement(NewXpath1).click();
									utilfunc.MakeElement(magazinedescriptionxpath).clear();
									utilfunc.MakeElement(magazinedescriptionxpath).sendKeys(Media_and_PublicationsDidthisarticleappearinamagazinedesc);}catch(Exception error){}
								}else{
									try{
									String NewXpath1=NewXpath.replace("//*[@id]", "//input[2]");
									utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("CopyAvailable")){	

								if(Media_and_PublicationsAreyouabletoprovidecopyofthearticle.equals("Yes")){
							try{		
								String NewXpath1=NewXpath.replace("//*[@id]", "//input[1]");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(magazinedescriptionxpath).clear();
									utilfunc.MakeElement(magazinedescriptionxpath).sendKeys(Media_and_PublicationsDidthisarticleappearinamagazinedesc);
							}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input[2]");
									utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}



						}catch(Exception e){

						}
					}
					///upload document/////
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

					}

					//////////////////  Add Document (Upload file)//////////////////////

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
					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);}catch(Exception error){}

					/*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
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

				}


			}else if(mode.equals(ACTION1)){
				try{
					/*String Media_and_PublicationsURLwithID=Media_and_PublicationsPageURL+Media_and_PublicationsID;
					 utilfunc.NavigatetoURL(Media_and_PublicationsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();

					int ObjCount=utilfunc.GetObjectCount(Media_and_PublicationsCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=Media_and_Publications_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("CompleteCitation")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Media_and_PublicationsCompletecitation);
							}	
							else if(AttributeName.equals("Why")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Media_and_PublicationsWhywereyouoryourworkselected);
							}
							else if(AttributeName.equals("AppearMagzine")){	

								if(Media_and_PublicationsDidthisarticleappearinamagazine.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(magazinedescriptionxpath).clear();
									utilfunc.MakeElement(magazinedescriptionxpath).sendKeys(Media_and_PublicationsDidthisarticleappearinamagazinedesc);
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									utilfunc.MakeElement(NewXpath1).click();
								}
							}
							else if(AttributeName.equals("CopyAvailable")){	

								if(Media_and_PublicationsAreyouabletoprovidecopyofthearticle.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(magazinedescriptionxpath).clear();
									utilfunc.MakeElement(magazinedescriptionxpath).sendKeys(Media_and_PublicationsDidthisarticleappearinamagazinedesc);
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									utilfunc.MakeElement(NewXpath1).click();
								}
							}



						}catch(Exception e){

						}
					}

					///upload document/////
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

					/*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
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
					/*String Media_and_PublicationsURLwithID=Media_and_PublicationsPageURL+Media_and_PublicationsID;
					 utilfunc.NavigatetoURL(Media_and_PublicationsURLwithID);*/
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
