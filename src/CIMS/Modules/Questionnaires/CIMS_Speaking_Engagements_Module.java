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

public class CIMS_Speaking_Engagements_Module
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

	public CIMS_Speaking_Engagements_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean Speaking_EngagementsPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{	

		//Passport Page	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 0, ColumnCounter);
		String SpeakingEngagementsScenerio=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 2, ColumnCounter);
		String SpeakingEngagementsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 3, ColumnCounter);		
		String SpeakingEngagementsPageURL=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 4, ColumnCounter);
		String SpeakingEngagementsID=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 5, ColumnCounter);	

		String SpeakingEngagementsNameofConference=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 6, ColumnCounter);
		String yourrole=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 7, ColumnCounter);
		String TitlePresentation=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 8, ColumnCounter);
		String SpeakingEngagementsDate=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 9, ColumnCounter);
		String SpeakingEngagementsLocation=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 10, ColumnCounter);
		//String SpeakingEngagementsCountry1=UtilFunction.getCellData("Test Data.xls", "CSpeakingEngagements", 9, ColumnCounter);


		//String SpeakingEngagementsCityTownLocality=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 10, ColumnCounter);
		String SpeakingEngagementsStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 11, ColumnCounter);
		String SpeakingEngagementsHowdidyouacquirethiscitizenship=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 12, ColumnCounter);
		String SpeakingEngagementsAbandoned=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 13, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 14, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "SpeakingEngagements", 15, ColumnCounter);


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

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Speaking Engagements and Presentations";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=SpeakingEngagementsScenerio;
		description=SpeakingEngagementsTestcaseDescription;

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
					/*String SpeakingEngagementsURLwithID=SpeakingEngagementsPageURL+SpeakingEngagementsID;

			 utilfunc.NavigatetoURL(SpeakingEngagementsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					try{
						String AddbuttonXpath="//*[@class='btn']";
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);
						String SpeakingEngagementsFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]/div//*[@name]";
						//String SpeakingEngagementsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
						String CounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']/div//*[@name]";

						int ObjCount=utilfunc.GetObjectCount(CounterXpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);				 
							//Filed value Entering
							String NewXpath1=SpeakingEngagementsFiledXpath.replace("xx", Integer.toString(count));
							try {
								//String FiledXpath1=NewXpath1+"/input";	
								String ControlAttribute=utilfunc.MakeElement(NewXpath1).getAttribute("name");
								// System.out.println("Attribute name is"+ControlAttribute);

								if(ControlAttribute.contains("ConferenceName")) {
									try{utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsNameofConference);
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("SpeakingDate")) {
									try{	utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsDate);
									}catch(Exception Ex){}
								}		

								else if(ControlAttribute.contains("Location")) {
									try{	utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsLocation);
									}catch(Exception Ex){}
								}	

								else if(ControlAttribute.contains("IsConferenceRecognized")) {
									try{	utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}

								else if(ControlAttribute.contains("IsInvitationDocumentExists")) {
									try{	utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}

								else if(ControlAttribute.contains("IsInternationalDocumentExists")) {
									try{	utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("uploaderFile")){

								}
								else if(ControlAttribute.contains("YourRole")){
									try{ utilfunc.MakeElement(NewXpath1).sendKeys(yourrole);
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("TitlePresentation")){
									try{ utilfunc.MakeElement(NewXpath1).sendKeys(TitlePresentation);
									}catch(Exception Ex){}
								}
							}
							catch(Exception e){
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
						}catch(Exception Ex){}

						
						
						//Lokesh-add this code in case values not enterd so once try this - 14June2016
						//START
						try{
							String ConfName_XPATH=".//*[@id='ConferenceName']";
							String YourRole_XPATH=".//*[@id='YourRole']";
							String PresentationTitle_XPATH=".//*[@id='TitlePresentation']";
							String date_XPATH=".//*[@id='SpeakingDate']";
							String Location_XPTAH=".//*[@id='Location']";
							String ConfRecoByFeildYES_XPATH=".//*[@name='IsConferenceRecognized' and contains(@value,'rue')]";
							String ConfRecoByFeildNO_XPATH=".//*[@name='IsConferenceRecognized' and contains(@value,'alse')]";
							String IsInvitationDocumentExistsYES_XPATH=".//*[@name='IsInvitationDocumentExists' and contains(@value,'rue')]";
							String IsInvitationDocumentExistsNO_XPATH=".//*[@name='IsInvitationDocumentExists' and contains(@value,'alse')]";
							String IsInternationalDocumentExistsYES_XPATH=".//*[@name='IsInternationalDocumentExists' and contains(@value,'rue')]";
							String IsInternationalDocumentExistsNO_XPATH=".//*[@name='IsInternationalDocumentExists' and contains(@value,'alse')]";
							try{
								utilfunc.MakeElement(ConfName_XPATH).clear();
								utilfunc.MakeElement(ConfName_XPATH).sendKeys(SpeakingEngagementsNameofConference);
								}catch(Exception error){}
							try{
								utilfunc.MakeElement(YourRole_XPATH).clear();
								utilfunc.MakeElement(YourRole_XPATH).sendKeys(yourrole);								
							}catch(Exception error){}
							try{
								utilfunc.MakeElement(PresentationTitle_XPATH).clear();
								utilfunc.MakeElement(PresentationTitle_XPATH).sendKeys(TitlePresentation);
							}catch(Exception error){}
							try{
								utilfunc.MakeElement(date_XPATH).clear();
								utilfunc.MakeElement(date_XPATH).sendKeys(SpeakingEngagementsDate);
								utilfunc.MakeElement("body").click();
							}catch(Exception error){}
							try{
								Thread.sleep(1000);
								utilfunc.MakeElement(ConfRecoByFeildYES_XPATH).click();
								Thread.sleep(1000);
								utilfunc.MakeElement(IsInvitationDocumentExistsYES_XPATH).click();
								Thread.sleep(1000);
								utilfunc.MakeElement(IsInternationalDocumentExistsYES_XPATH).click();
								Thread.sleep(1000);
							}catch(Exception error){}
							
						}catch(Exception error){}
						//ENDS
						
						
						
						//////////////////////Additional info handle///////////////////////////////
						try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
						}catch(Exception Ex){}

						try{utilfunc.savebutton();
						}catch(Exception Ex){}

						String error_flag=utilfunc.questionnaireErrorMessageHandler();
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


			}else if(mode.equals(Module1)){

				try{
					/*String SpeakingEngagementsURLwithID=SpeakingEngagementsPageURL+SpeakingEngagementsID;

			 utilfunc.NavigatetoURL(SpeakingEngagementsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					try{
						String AddbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);
						String SpeakingEngagementsFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]/div//*[@name]";
						//String SpeakingEngagementsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
						String CounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']/div//*[@name]";

						int ObjCount=utilfunc.GetObjectCount(CounterXpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);


							//Filed value Entering
							String NewXpath1=SpeakingEngagementsFiledXpath.replace("xx", Integer.toString(count));
							try {

								String ControlAttribute=utilfunc.MakeElement(NewXpath1).getAttribute("name");
								//System.out.println("Attribute name is"+ControlAttribute);

								if(ControlAttribute.contains("ConferenceName")) {
									try{ 
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsNameofConference);
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("SpeakingDate")) {
									try{
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsDate);
									}catch(Exception Ex){}
								}		

								else if(ControlAttribute.contains("Location")) {
									try{
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).sendKeys(SpeakingEngagementsLocation);
									}catch(Exception Ex){}
								}	

								else if(ControlAttribute.contains("IsConferenceRecognized")) {
									try{
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}

								else if(ControlAttribute.contains("IsInvitationDocumentExists")) {
									try{
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}

								else if(ControlAttribute.contains("IsInternationalDocumentExists")) {
									try{
										utilfunc.MakeElement(NewXpath1).clear();
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("uploaderFile")){
								}
								else if(ControlAttribute.contains("YourRole")){
									try{ utilfunc.MakeElement(NewXpath1).sendKeys(yourrole);
									}catch(Exception Ex){}
								}
								else if(ControlAttribute.contains("TitlePresentation")){
									try{ utilfunc.MakeElement(NewXpath1).sendKeys(TitlePresentation);
									}catch(Exception Ex){}
								}
							}catch(Exception Ex){}					 		
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
						}catch(Exception Ex){}

						//////////////////////Additional info handle///////////////////////////////
						try{ utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
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
				}catch(Exception Ex){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.ErrorMessage2="No Records Found to Edit";
					Flag=false;
					utilfunc.TakeScreenshot();

				}

			}
			else if(mode.equals(Module2)){
				try{
					/*String SpeakingEngagementsURLwithID=SpeakingEngagementsPageURL+SpeakingEngagementsID;

				 utilfunc.NavigatetoURL(SpeakingEngagementsURLwithID);*/
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
					String delete=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(delete).click();
						Thread.sleep(4000);
						utilfunc.isAlertPresent();
					}catch(Exception Ex){}

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