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

public class CIMS_Contributions_to_Your_Field_Module {
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

	public CIMS_Contributions_to_Your_Field_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Contributions_to_Your_Field_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 0, ColumnCounter);
		String Contributions_to_Your_FieldScenerio=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 2, ColumnCounter);
		String Contributions_to_Your_FieldTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 3, ColumnCounter);		
		String Contributions_to_Your_FieldPageURL=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 4, ColumnCounter);
		String Contributions_to_Your_FieldID=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 5, ColumnCounter);

		String Natureofcontribution=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 6, ColumnCounter);
		String Detaileddescriptionofitsoriginality=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 7, ColumnCounter);
		String Importanceofcontribution=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 8, ColumnCounter);
		String Projecttitle=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 9, ColumnCounter);
		String EmployerName=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 10, ColumnCounter);
		String Wasthisprojectsuccessful=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 11, ColumnCounter);
		String Wasthisprojectsuccessfuldesc=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 12, ColumnCounter);
		String Didyouplayradio=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 13, ColumnCounter);
		String Didyouplayifyesdesc=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 14, ColumnCounter);
		String originaltechniquesradio=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 15, ColumnCounter);
		String originaltechniquesdesc=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 16, ColumnCounter);
		String referenceletterradio=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 17, ColumnCounter);
		String Canyouprovideevidenceradio=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 18, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 19, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 20, ColumnCounter);
		String jobtitle=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 21, ColumnCounter);

		/////upload document popup element value(s)/////////////////
		String DocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 23, ColumnCounter);
		String DocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 24, ColumnCounter);
		String DocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Contributions_to_Your_Field", 25, ColumnCounter);
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

		String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";

		String ContributionsattributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String ContributionsCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		String Contributionsradiofieldxpath=".//*[@class='question-group Fulldiv-clour'][xx]//*[@class='control-group']//*[@name]";
		String Contributionsradiocounterxpath=".//*[@class='question-group Fulldiv-clour']//*[@class='control-group']//*[@name]";

		String ProjectSuccessfulDescxpath=".//*[@id='IsProjectSuccessfulDesc']";
		String LeadingRoleDescxpath=".//*[@id='IsLeadingRoleDesc']";
		String EmployerAppliedDescxpath=".//*[@id='IsEmployerAppliedDesc']";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Contributions to Your Field";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Contributions_to_Your_FieldScenerio;
		description=Contributions_to_Your_FieldTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String Contributions_to_Your_FieldURLwithID=Contributions_to_Your_FieldPageURL+Contributions_to_Your_FieldID;
					 utilfunc.NavigatetoURL(Contributions_to_Your_FieldURLwithID);*/

					try{ utilfunc.NavigatetoURL(URLwithID);
					Thread.sleep(2000);		}catch(Exception error){}			 
					utilfunc.ServerErrorHandler();

					String AddbuttonXpath="//*[@class='btn']";
					try{	 utilfunc.MakeElement(AddbuttonXpath).click();	
					webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					
					Thread.sleep(2000);
					}
					catch(Exception error){}


					int ObjCount=utilfunc.GetObjectCount(ContributionsCounterXpath);

					try{
						for(int count=1; count<=ObjCount; count++)
						{
							String NewXpath=ContributionsattributeFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("ContributionNature")){
									Thread.sleep(1500);
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Natureofcontribution);
									} catch (Exception e) {
										
									}
								}	
								else if(AttributeName.equals("DetailedDescription")){	
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Detaileddescriptionofitsoriginality);
									} catch (Exception e) {
										
									}
								}
								else if(AttributeName.equals("ImportanceDescription")){	
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Importanceofcontribution);
									} catch (Exception e) {
										
									}
								}
								else if(AttributeName.equals("JobTitle")){	
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(jobtitle);
									} catch (Exception e) {
										
									}
								}
								else if(AttributeName.equals("ProjectTitle")){	
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Projecttitle);
									} catch (Exception e) {
										
									}
								}
								else if(AttributeName.equals("EmployerName")){
									utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(EmployerName);
									} catch (Exception e) {
										
									}
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


							}catch(Exception e){

							}
						}
					}catch(Exception error){}
					////////////////////////////radio handled////////////////////////////////
					int ObjCount1=utilfunc.GetObjectCount(Contributionsradiocounterxpath);

					try{ 
						for(int count=1; count<=ObjCount1; count++)
						{
							String NewXpath=Contributionsradiofieldxpath.replace("xx", Integer.toString(count));
							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("IsProjectSuccessful")){
									if(Wasthisprojectsuccessful.equals("Yes")){
										try{ 
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();				 }catch(Exception error){}
										utilfunc.MakeElement(ProjectSuccessfulDescxpath).clear();
										utilfunc.MakeElement(ProjectSuccessfulDescxpath).sendKeys(Wasthisprojectsuccessfuldesc);
									}
								}	
								else if(AttributeName.equals("IsLeadingRole")){
									if(Didyouplayradio.equals("Yes")){
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
											
										}
										utilfunc.MakeElement(LeadingRoleDescxpath).clear();
										utilfunc.MakeElement(LeadingRoleDescxpath).sendKeys(Didyouplayifyesdesc);
									}
								}
								else if(AttributeName.equals("IsEmployerApplied")){
									if(originaltechniquesradio.equals("Yes")){
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
										}
										utilfunc.MakeElement(EmployerAppliedDescxpath).clear();
										utilfunc.MakeElement(EmployerAppliedDescxpath).sendKeys(originaltechniquesdesc);
									}
								}
								else if(AttributeName.equals("ReferenceLetterExists")){	
									if(referenceletterradio.equals("Yes")){
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
											
										}
									}
								}
								else if(AttributeName.equals("IsEvidenceProvided")){	
									if(Canyouprovideevidenceradio.equals("Yes")){
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
											
										}
									}
								}
							}catch(Exception e){

							}
						}
					}catch(Exception error){}


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
											utilfunc.MakeElement(DocumentUploadControlsxpathcopy).sendKeys(DocumentUploadPopUpDocName);
										}catch(Exception error){}
									}
									else if(docuattribute.contains("BalNumber1"))
									{
										///Project associate
										try{
											System.out.println("DocumentUploadPopUpProjectAssociated :"+DocumentUploadPopUpProjectAssociated+":");
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
											Thread.sleep(1000);
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

					//////////////////////Additional info handle///////////////////////////////
					try{
						Thread.sleep(1000); utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);}catch(Exception error){}

					/*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
					try {
						Thread.sleep(1000);
						utilfunc.savebutton();
					} catch (Exception e) {
						
					}

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
					utilfunc.NavigatetoURL(URLwithID);
				}


			}else if(mode.equals(ACTION1)){
				try{
					/*String Contributions_to_Your_FieldURLwithID=Contributions_to_Your_FieldPageURL+Contributions_to_Your_FieldID;
					 utilfunc.NavigatetoURL(Contributions_to_Your_FieldURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					try {
						
						utilfunc.MakeElement(EditbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}

					int ObjCount=utilfunc.GetObjectCount(ContributionsCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=Contributionsradiofieldxpath.replace("xx", Integer.toString(count));
						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("IsProjectSuccessful")){
								if(Wasthisprojectsuccessful.equals("Yes")){
									try{ 
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();				 }catch(Exception error){}
									utilfunc.MakeElement(ProjectSuccessfulDescxpath).clear();
									utilfunc.MakeElement(ProjectSuccessfulDescxpath).sendKeys(Wasthisprojectsuccessfuldesc);
								}
							}	
							else if(AttributeName.equals("IsLeadingRole")){
								if(Didyouplayradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
									utilfunc.MakeElement(LeadingRoleDescxpath).clear();
									utilfunc.MakeElement(LeadingRoleDescxpath).sendKeys(Didyouplayifyesdesc);
								}
							}
							else if(AttributeName.equals("IsEmployerApplied")){
								if(originaltechniquesradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
									}
									utilfunc.MakeElement(EmployerAppliedDescxpath).clear();
									utilfunc.MakeElement(EmployerAppliedDescxpath).sendKeys(originaltechniquesdesc);
								}
							}
							else if(AttributeName.equals("ReferenceLetterExists")){	
								if(referenceletterradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
								}
							}
							else if(AttributeName.equals("IsEvidenceProvided")){	
								if(Canyouprovideevidenceradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
								}
							}
						}catch(Exception e){

						}
					}
					////////////////////////////radio handled////////////////////////////////
					int ObjCount1=utilfunc.GetObjectCount(Contributionsradiocounterxpath);

					for(int count=1; count<=ObjCount1; count++)
					{
						String NewXpath=Contributionsradiofieldxpath.replace("xx", Integer.toString(count));
						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("IsProjectSuccessful")){
								if(Wasthisprojectsuccessful.equals("Yes")){
									try{ 
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();				 }catch(Exception error){}
									utilfunc.MakeElement(ProjectSuccessfulDescxpath).clear();
									utilfunc.MakeElement(ProjectSuccessfulDescxpath).sendKeys(Wasthisprojectsuccessfuldesc);
								}
							}	
							else if(AttributeName.equals("IsLeadingRole")){
								if(Didyouplayradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
									utilfunc.MakeElement(LeadingRoleDescxpath).clear();
									utilfunc.MakeElement(LeadingRoleDescxpath).sendKeys(Didyouplayifyesdesc);
								}
							}
							else if(AttributeName.equals("IsEmployerApplied")){
								if(originaltechniquesradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
									}
									utilfunc.MakeElement(EmployerAppliedDescxpath).clear();
									utilfunc.MakeElement(EmployerAppliedDescxpath).sendKeys(originaltechniquesdesc);
								}
							}
							else if(AttributeName.equals("ReferenceLetterExists")){	
								if(referenceletterradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
								}
							}
							else if(AttributeName.equals("IsEvidenceProvided")){	
								if(Canyouprovideevidenceradio.equals("Yes")){
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									} catch (Exception e) {
										
									}
								}
							}
						}catch(Exception e){

						}
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
					/*String Contributions_to_Your_FieldURLwithID=Contributions_to_Your_FieldPageURL+Contributions_to_Your_FieldID;
					 utilfunc.NavigatetoURL(Contributions_to_Your_FieldURLwithID);*/
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
					try {
						utilfunc.MakeElement(DeletebuttonXpath).click();
					} catch (Exception e) {
						
					}

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
