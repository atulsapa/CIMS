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

public class CIMS_Immigration_Documents_Module {
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

	public CIMS_Immigration_Documents_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Immigration_Documents_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		//Excel sheet Data collection
		/*String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 0, ColumnCounter);
			String ImmigrationDocumentsScenerio=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 2, ColumnCounter);
			String ImmigrationDocumentsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 3, ColumnCounter);		
			String ImmigrationDocumentsPageURL=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 4, ColumnCounter);
			String ImmigrationDocumentsID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 5, ColumnCounter);

			String ImmigrationDocumentsSelectcountry=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 6, ColumnCounter);
			String ImmigrationDocumentsselectdocument=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 7, ColumnCounter);
			String ImmigrationDocumentsDateApplied=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 8, ColumnCounter);
			String ImmigrationDocumentsAppliedatCountry=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 9, ColumnCounter);
			String ImmigrationDocumentsAppliedatCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 10, ColumnCounter);
			String ImmigrationDocumentsAppliedatStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 11, ColumnCounter);
			String ImmigrationDocumentsClassificationappliedfor=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 12, ColumnCounter);
			String ImmigrationDocumentsSponsor=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 13, ColumnCounter);
			String ImmigrationDocumentsCaseorReceiptNo=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 14, ColumnCounter);
			String ImmigrationDocumentsGrantedorDenied=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 15, ColumnCounter);
			String ImmigrationDocumentsGrantedOrDeniedDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 16, ColumnCounter);
			String ImmigrationDocumentsValidityStartDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 17, ColumnCounter);
			String ImmigrationDocumentsValidityEndDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 18, ColumnCounter);
			String ImmigrationDocumentsDocumentID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 19, ColumnCounter);
			String ImmigrationDocumentsBeneficiaryID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 20, ColumnCounter);
			String ImmigrationDocumentsTermsandConditions=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 21, ColumnCounter);
			String ImmigrationDocumentsConsulate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 22, ColumnCounter);
			String ImmigrationDocumentsNotesAdditionalInformation=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 23, ColumnCounter);

			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 24, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 25, ColumnCounter);
		 */

		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 0, ColumnCounter);
		String ImmigrationDocumentsScenerio=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 2, ColumnCounter);
		String ImmigrationDocumentsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 3, ColumnCounter);		

		String ImmigrationDocumentsSelectcountry=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 4, ColumnCounter);
		String ImmigrationDocumentsselectdocument=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 5, ColumnCounter);

		String ImmigrationDocumentsDateApplied=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 6, ColumnCounter);
		String ImmigrationDocumentsAppliedatCountry=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 7, ColumnCounter);
		String ImmigrationDocumentsAppliedatCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 8, ColumnCounter);
		String ImmigrationDocumentsAppliedatStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 9, ColumnCounter);
		String ImmigrationDocumentsClassificationappliedfor=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 10, ColumnCounter);
		String ImmigrationDocumentsSponsor=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 11, ColumnCounter);
		String ImmigrationDocumentsCaseorReceiptNo=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 12, ColumnCounter);

		String ImmigrationDocumentsGrantedorDenied=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 13, ColumnCounter);
		String ImmigrationDocumentsGrantedOrDeniedDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 14, ColumnCounter);
		//New added string	
		String ImmigrationDocumentsIfDeniedProvideResion=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 15, ColumnCounter);

		String ImmigrationDocumentsValidityStartDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 16, ColumnCounter);
		String ImmigrationDocumentsValidityEndDate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 17, ColumnCounter);
		String ImmigrationDocumentsDocumentID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 18, ColumnCounter);
		String ImmigrationDocumentsBeneficiaryID=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 19, ColumnCounter);
		String ImmigrationDocumentsTermsandConditions=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 20, ColumnCounter);
		String ImmigrationDocumentsConsulate=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 21, ColumnCounter);
		String ImmigrationDocumentsNotesAdditionalInformation=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 22, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 23, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Immigration_Documents", 24, ColumnCounter);


		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		String ImmigrationDocuments_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String ImmigrationDocumentsCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Immigration Documents and Applications";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=ImmigrationDocumentsScenerio;
		description=ImmigrationDocumentsTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String ImmigrationDocumentsURLwithID=ImmigrationDocumentsPageURL+ImmigrationDocumentsID;

					 utilfunc.NavigatetoURL(ImmigrationDocumentsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String ImmigrationDocumentscountryselectxpath=".//*[@id='CountryCode']";
					String ImmigrationDocumentsselectdocxpath=".//*[@id='DocumentTypeId']";

					utilfunc.Selectdropdownvaluebyvalue(ImmigrationDocumentscountryselectxpath, ImmigrationDocumentsSelectcountry);
					//utilfunc.Selectdropdownvaluebyvalue(ImmigrationDocumentsselectdocxpath, ImmigrationDocumentsselectdocument);
					Thread.sleep(3000);
					utilfunc.Selectdropdownvaluebyindex(ImmigrationDocumentsselectdocxpath,2);

					String AddbuttonXpath="//*[@class='btn']";
					utilfunc.MakeElement(AddbuttonXpath).click();
					Thread.sleep(1000);


					int ObjCount=utilfunc.GetObjectCount(ImmigrationDocumentsCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewXpath=ImmigrationDocuments_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("AppliedDate")){	
								Thread.sleep(300);
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsDateApplied);

							}	
							else if(AttributeName.equals("AppliedAtCountry")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, ImmigrationDocumentsAppliedatCountry);
							}
							else if(AttributeName.equals("AppliedAtCity")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsAppliedatCityTownLocality);
							}
							else if(AttributeName.equals("AppliedAtStateOrProvince")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsAppliedatStateProvinceRegion);
							}
							else if(AttributeName.equals("VisaClassId")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, ImmigrationDocumentsClassificationappliedfor);
							}
							else if(AttributeName.equals("Sponsor")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsSponsor);
							}
							else if(AttributeName.equals("CaseOrReceiptNumber")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsCaseorReceiptNo);
							}
							else if(AttributeName.equals("ApprovalResult")){							
								    
								/*try{Thread.sleep(1000); 
								utilfunc.MakeElement(NewXpath).click();
								Thread.sleep(1000);
								}catch(Exception error){}
								*/
								try{
									String Denied_XPATH=".//*[@id='ApprovalResult' and contains(@Value,'DENIED')]";
									String Granted_XPATH=".//*[@id='ApprovalResult' and contains(@Value,'GRANTED')]";
									String RefList_XPATH=".//*[@id='ApprovalResult' and contains(@Value,'Test')]";
									Thread.sleep(3000);
									System.out.println("value of ImmigrationDocumentsGrantedorDenied is :---"+ImmigrationDocumentsGrantedorDenied+"---");
									if(ImmigrationDocumentsGrantedorDenied.contains("Denied"))
									{
										Thread.sleep(1000);
										utilfunc.MakeElement(Denied_XPATH).click();	
										Thread.sleep(1000);
										
									}
									else if(ImmigrationDocumentsGrantedorDenied.contains("Granted"))
									{
										Thread.sleep(1000);
										utilfunc.MakeElement(Granted_XPATH).click();
										Thread.sleep(1000);
									}
									else if(ImmigrationDocumentsGrantedorDenied.contains("RefList"))
									{
										Thread.sleep(1000);
										utilfunc.MakeElement(RefList_XPATH).click();
										Thread.sleep(1000);
									}
								}catch(Exception error){}
							}
							else if(AttributeName.equals("ApprovalResultReason")){
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsIfDeniedProvideResion);
							}
							else if(AttributeName.equals("ApprovalResultDate")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsGrantedOrDeniedDate);
							}
							else if(AttributeName.equals("EffectiveDate")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsValidityStartDate);
							}
							else if(AttributeName.equals("ExpirationDate")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsValidityEndDate);
							}
							else if(AttributeName.equals("DocumentNumber")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsDocumentID);
							}
							else if(AttributeName.equals("BeneficiaryNumber")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsBeneficiaryID);
							}
							else if(AttributeName.equals("TermsAndConditions")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsTermsandConditions);
							}
							else if(AttributeName.equals("Consulate")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsConsulate);
							}
							else if(AttributeName.equals("Note")){							
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsNotesAdditionalInformation);
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
					//////////////////////Additional info handle///////////////////////////////
					try{	 utilfunc.dynamic_data(ImmigrationDocumentsCounterXpath, ImmigrationDocuments_attributeFiledXpath);
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


				}catch(Exception e){

				}


			}else if(mode.equals(ACTION1)){

				try{
					/*String ImmigrationDocumentsURLwithID=ImmigrationDocumentsPageURL+ImmigrationDocumentsID;

					 utilfunc.NavigatetoURL(ImmigrationDocumentsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();

					int ObjCount=utilfunc.GetObjectCount(ImmigrationDocumentsCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=ImmigrationDocuments_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+" is : "+AttributeName+" And Xpath is:\n\t"+NewXpath);

							if(AttributeName.equals("AppliedDate")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsDateApplied);

							}	
							else if(AttributeName.equals("AppliedAtCountry")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, ImmigrationDocumentsAppliedatCountry);
							}
							else if(AttributeName.equals("AppliedAtCity")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsAppliedatCityTownLocality);
							}
							else if(AttributeName.equals("AppliedAtStateOrProvince")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsAppliedatStateProvinceRegion);
							}
							else if(AttributeName.equals("VisaClassId")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, ImmigrationDocumentsClassificationappliedfor);
							}
							else if(AttributeName.equals("Sponsor")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsSponsor);
							}
							else if(AttributeName.equals("CaseOrReceiptNumber")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsCaseorReceiptNo);
							}
							else if(AttributeName.equals("ApprovalResult")){
								Thread.sleep(2000);
								try{
									utilfunc.MakeElement(NewXpath).click();
									Thread.sleep(2000);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("ApprovalResultDate")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsGrantedOrDeniedDate);
							}
							else if(AttributeName.equals("EffectiveDate")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsValidityStartDate);
							}
							else if(AttributeName.equals("ExpirationDate")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsValidityEndDate);
							}
							else if(AttributeName.equals("DocumentNumber")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsDocumentID);
							}
							else if(AttributeName.equals("BeneficiaryNumber")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsBeneficiaryID);
							}
							else if(AttributeName.equals("TermsAndConditions")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsTermsandConditions);
							}
							else if(AttributeName.equals("Consulate")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsConsulate);
							}
							else if(AttributeName.equals("Note")){		
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationDocumentsNotesAdditionalInformation);
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
					//////////////////////Additional info handle///////////////////////////////
					utilfunc.dynamic_data(ImmigrationDocumentsCounterXpath, ImmigrationDocuments_attributeFiledXpath);

					utilfunc.savebutton();

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
					}else if (error_flag.equals("")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else{
						Flag=false;
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
					/*String ImmigrationDocumentsURLwithID=ImmigrationDocumentsPageURL+ImmigrationDocumentsID;

					 utilfunc.NavigatetoURL(ImmigrationDocumentsURLwithID);*/
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
