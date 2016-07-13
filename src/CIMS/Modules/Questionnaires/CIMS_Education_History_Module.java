package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.DocAttribute;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.sun.javafx.scene.accessibility.Attribute;

import CIMS.CIMS_MainProject;
import util.UtilFunction;

public class CIMS_Education_History_Module
{


	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	private WebElement Webelement;
	//Veriables-------------

	public static String ErrorMessage="";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	//Constructor----------

	public CIMS_Education_History_Module(WebDriver driver,UtilFunction utilfunc) 
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
	public boolean Education_HistoryPage(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{


		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Education_History", 0, ColumnCounter);
		String Education_HistoryScenerio=UtilFunction.getCellData("Test Data.xls", "Education_History", 2, ColumnCounter);
		String Education_HistoryTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Education_History", 3, ColumnCounter);		
		String Education_HistoryPageURL=UtilFunction.getCellData("Test Data.xls", "Education_History", 4, ColumnCounter);
		String Education_HistoryID=UtilFunction.getCellData("Test Data.xls", "Education_History", 5, ColumnCounter);			

		String Education_HistoryStartDate=UtilFunction.getCellData("Test Data.xls", "Education_History", 6, ColumnCounter);
		String Education_HistoryEndDate=UtilFunction.getCellData("Test Data.xls", "Education_History", 7, ColumnCounter);
		String Education_HistoryNameofInstitution=UtilFunction.getCellData("Test Data.xls", "Education_History", 8, ColumnCounter);
		String Education_HistoryTypeOfInstitution=UtilFunction.getCellData("Test Data.xls", "Education_History", 9, ColumnCounter);
		String Education_Historycountry=UtilFunction.getCellData("Test Data.xls", "Education_History", 10, ColumnCounter);
		String Education_HistoryAddressLookup=UtilFunction.getCellData("Test Data.xls", "Education_History", 11, ColumnCounter);
		String Education_HistoryStreetAddress=UtilFunction.getCellData("Test Data.xls", "Education_History", 12, ColumnCounter);
		String Education_HistoryCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Education_History", 13, ColumnCounter);
		String Education_HistoryStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Education_History", 14, ColumnCounter);
		String Education_HistoryZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Education_History", 15, ColumnCounter);
		String Education_HistoryPhoneNumber=UtilFunction.getCellData("Test Data.xls", "Education_History", 16, ColumnCounter);
		String Education_HistoryDegreeReceived=UtilFunction.getCellData("Test Data.xls", "Education_History", 17, ColumnCounter);
		String Education_HistoryFieldofStudy=UtilFunction.getCellData("Test Data.xls", "Education_History", 18, ColumnCounter);
		String Education_HistoryOtherCertificates=UtilFunction.getCellData("Test Data.xls", "Education_History", 19, ColumnCounter);
		String Education_HistoryFullTimeYears=UtilFunction.getCellData("Test Data.xls", "Education_History", 20, ColumnCounter);
		String Education_HistoryThesisorSchoolProjectradio=UtilFunction.getCellData("Test Data.xls", "Education_History", 21, ColumnCounter);
		String Education_HistoryTitleofThesis=UtilFunction.getCellData("Test Data.xls", "Education_History", 22, ColumnCounter);
		String Education_HistoryStartDateofThesis=UtilFunction.getCellData("Test Data.xls", "Education_History", 23, ColumnCounter);
		String Education_HistoryEndDateofThesis=UtilFunction.getCellData("Test Data.xls", "Education_History", 24, ColumnCounter);
		String Education_HistoryDescriptionofThesis=UtilFunction.getCellData("Test Data.xls", "Education_History", 25, ColumnCounter);
		String Education_HistoryPleaselistanddescribetheskills=UtilFunction.getCellData("Test Data.xls", "Education_History", 26, ColumnCounter);
		String Education_HistoryCanYouObtainradio=UtilFunction.getCellData("Test Data.xls", "Education_History", 27, ColumnCounter);

		//Reference
		String Education_HistoryReferenceFirstName=UtilFunction.getCellData("Test Data.xls", "Education_History", 28, ColumnCounter);
		String Education_HistoryReferenceLastName=UtilFunction.getCellData("Test Data.xls", "Education_History", 29, ColumnCounter);
		String Education_HistoryReferenceRelationshiptoYou=UtilFunction.getCellData("Test Data.xls", "Education_History", 30, ColumnCounter);
		String Education_HistoryReferenceOtherRelationshiptoYou=UtilFunction.getCellData("Test Data.xls", "Education_History", 31, ColumnCounter);
		String Education_HistoryReferenceCurrentEmployer=UtilFunction.getCellData("Test Data.xls", "Education_History", 32, ColumnCounter);
		String Education_HistoryReferenceCurrentTitle=UtilFunction.getCellData("Test Data.xls", "Education_History", 33, ColumnCounter);
		String Education_HistoryReferenceCountry=UtilFunction.getCellData("Test Data.xls", "Education_History", 34, ColumnCounter);
		String Education_HistoryReferenceAddressLookup=UtilFunction.getCellData("Test Data.xls", "Education_History", 35, ColumnCounter);
		String Education_HistoryReferenceStreetAddress1=UtilFunction.getCellData("Test Data.xls", "Education_History", 36, ColumnCounter);
		String Education_HistoryReferenceStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Education_History", 37, ColumnCounter);
		String Education_HistoryReferenceAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Education_History", 38, ColumnCounter);
		String Education_HistoryReferenceCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Education_History", 39, ColumnCounter);
		String Education_HistoryReferenceStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Education_History", 40, ColumnCounter);
		String Education_HistoryReferenceZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Education_History", 41, ColumnCounter);
		String Education_HistoryReferenceEmails=UtilFunction.getCellData("Test Data.xls", "Education_History", 42, ColumnCounter);
		String Education_HistoryReferencePhoneType=UtilFunction.getCellData("Test Data.xls", "Education_History", 43, ColumnCounter);
		String Education_HistoryReferencePhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "Education_History", 44, ColumnCounter);
		String Education_HistoryReferencePhoneNumber=UtilFunction.getCellData("Test Data.xls", "Education_History", 45, ColumnCounter);
		String Education_HistoryReferencePhoneExt=UtilFunction.getCellData("Test Data.xls", "Education_History", 46, ColumnCounter);
		String EducationEmployerName_HistoryReferenceManagersFirstName=UtilFunction.getCellData("Test Data.xls", "Education_History", 47, ColumnCounter);
		String Education_HistoryReferenceManagersLastName=UtilFunction.getCellData("Test Data.xls", "Education_History", 48, ColumnCounter);
		String Education_HistoryReferenceManagerPhonenumber=UtilFunction.getCellData("Test Data.xls", "Education_History", 49, ColumnCounter);
		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Education_History", 50, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Education_History", 51, ColumnCounter);
		/////upload document popup element value(s)/////////////////
		String Education_HistoryDocumentUploadPopUpDocName=UtilFunction.getCellData("Test Data.xls", "Education_History", 52, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpProjectAssociated=UtilFunction.getCellData("Test Data.xls", "Education_History", 53, ColumnCounter);
		String Education_HistoryDocumentUploadPopUpDocVisibility=UtilFunction.getCellData("Test Data.xls", "Education_History", 54, ColumnCounter);



		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		//Custom Field  
		String EducationHistory_mainxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String EducationHistory_maincounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		String EducationHistory_secGraduationDateondxpath=".//*[@id='DvTheiseOrProject']//*[@class='control-group'][xx]//*[@name]";
		String EducationHistory_secondcounterpath=".//*[@id='DvTheiseOrProject']//*[@class='control-group']//*[@name]";

		String EducationHistory_thesisxpath=".//*[@id='DivTheiseOrProject']//*[@class='control-group']//*[@id]";
		String EducationHistory_thesisxpath1=".//*[@id='DivTheiseOrProject']//*[@class='control-group']//*[@class='controls']/div[xx]/input";

		String EducationHistory_additionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String EducationHistory_additionalcounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		String addreslookupxpath=".//*[@class='panel-body-main']//*[@class='question-group-address']//*[@name]";

		String Referencefieldxpath=".//*[@id='ReferenceDiv']//*[@class='control-group'][xx]//*[@id]";
		String Referencecounterxpath=".//*[@id='ReferenceDiv']//*[@class='control-group']//*[@id]";

		String Referenceaddresslookupxpath=".//*[@id='ReferenceDiv']//*[@class='question-group-address']//*[@id]";

		String Referenceemail=".//*[@id='grp-email']//*[@name]";

		String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
		String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

		//////////////////Pop-up window controls xpath/////////////////////////////
		String DocumentUploadControlcounterxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group']";
		String DocumentUploadControlsxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][xyz]//*[@class='controls']//*[@name]";
		String DocumentUploadUpdatexpath= "//*[@name and contains(@class,'HelpText')]";
		String DocumentUploadProjectAssociAddBtnxpath=".//*[@id='DocUploadModal']//*[@class='editUploadControls'][1]//*[@class='control-group'][3]//*[@class='controls']//*[contains(@class,'btn')]";


		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Education History";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Education_HistoryScenerio;
		description=Education_HistoryTestcaseDescription;

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

					//String Education_HistoryURLwithID=Education_HistoryPageURL+Education_HistoryID;

					
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					try{
						String AddbuttonXpath="//*[@class='btn']";
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);	

						int ObjCount=utilfunc.GetObjectCount(EducationHistory_maincounterxpath);
						//////////////////
						for(int count=1; count<=ObjCount; count++){
							Thread.sleep(300);
							String NewXpath=EducationHistory_mainxpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName="";
								AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								//System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.contains("StartDate")){			
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStartDate);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("GraduationDate")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryEndDate);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("NameOfInstitution")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryNameofInstitution);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("TypeOfInstitution")){
									//	utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryTypeOfInstitution);
									try{utilfunc.Selectdropdownvaluebytext(NewXpath, Education_HistoryTypeOfInstitution);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("form2_country")){
									//utilfunc.MakeElement(NewXpath).sendKeys(Education_Historycountry);
									try{utilfunc.Selectdropdownvaluebytext(NewXpath, Education_Historycountry);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("form2_route")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStreetAddress);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("form2_locality")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("form2_administrative_area_level_1")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("form2_postal_code")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryZipPostalCode);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("Number")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryPhoneNumber);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("DegreeReceived")){
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Education_HistoryDegreeReceived);
									}catch(Exception error){}
									//utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryZipPostalCode);
								}
								else if(AttributeName.contains("FieldOfStudy")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryFieldofStudy);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("CertificatesOrGrades")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryOtherCertificates);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("FullTimeYears")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryFullTimeYears);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("CanObtainReferenceLetter1")){
									if(Education_HistoryCanYouObtainradio.equals("Yes")){
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='controls']/input[1]");
											//System.out.println(NewXpath1);
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception error){}
									}else{
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='controls']/input[2]");
											//System.out.println(NewXpath1);
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception error){}
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
								///////////////////////////////////reference end//////////////////////////////////////////////
							}catch(Exception e){
							}
						}
						//////////////////////////////////////address lookup////////////////////////////////
						try{
							String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
							if(AttributeName.contains("form2_autocomplete")){			
								try{
									utilfunc.MakeElement(addreslookupxpath).sendKeys(Education_HistoryAddressLookup);
									utilfunc.mouseaction();
									Thread.sleep(2000);
								}catch(Exception error){}
							}
						}
						catch(Exception f){}
						//////////////////////////Thesis or School Project handled ////////////////////////////////
						try{
							String AttributeName=utilfunc.MakeElement(EducationHistory_thesisxpath).getAttribute("name");
							if(AttributeName.contains("WorkType")){
								if(Education_HistoryThesisorSchoolProjectradio.equalsIgnoreCase("None"))
								{	String SchoolProjectXpath=".//*[@id='DivTheiseOrProject']//*[@class='control-group']//*[@class='controls']/div[1]/input";
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(SchoolProjectXpath).click();
									Thread.sleep(1000);
								}catch(Exception error){}

								}
								else if(Education_HistoryThesisorSchoolProjectradio.equalsIgnoreCase("Project"))
								{	String SchoolProjectXpath=".//*[@id='DivTheiseOrProject']//*[@class='control-group']//*[@class='controls']/div[2]/input";
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(SchoolProjectXpath).click();
									Thread.sleep(1000);
								}catch(Exception error){}
								}
								else if(Education_HistoryThesisorSchoolProjectradio.equalsIgnoreCase("Thesis"))
								{	String SchoolProjectXpath=".//*[@id='DivTheiseOrProject']//*[@class='control-group']//*[@class='controls']/div[3]/input";
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(SchoolProjectXpath).click();
									Thread.sleep(1000);
								}catch(Exception error){}
								}
								//utilfunc.MakeElement(EducationHistory_thesisxpath).click();
							}
						}
						catch(Exception g){
						}
						////////////////////////////Thesis detailed handled/////////////////////////////////
						try{
							int ObjCount2=utilfunc.GetObjectCount(EducationHistory_secondcounterpath);

							for(int count=1; count<=ObjCount2; count++){
								Thread.sleep(300);
								String NewXpath=EducationHistory_secGraduationDateondxpath.replace("xx", Integer.toString(count));

								try{
									String AttributeName="";
									AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									//System.out.println("Attribute name "+count+"is : "+AttributeName);
									if(AttributeName.contains("TitleThesis")){			
										try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryTitleofThesis);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("StartThesisDate")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStartDateofThesis);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("EndThesisDate")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryEndDateofThesis);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("Description")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryDescriptionofThesis);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("SkillGained")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryPleaselistanddescribetheskills);
										}catch(Exception error){}
									}
								}
								catch(Exception c){
								}

							}

						}catch(Exception z){

						}
						/////////////////////////reference handled///////////////////////
						int ObjCount1=utilfunc.GetObjectCount(Referencecounterxpath);

						for(int count1=1; count1<=ObjCount1; count1++){
							Thread.sleep(300);
							String NewXpath2=Referencefieldxpath.replace("xx", Integer.toString(count1));

							try{
								String AttributeName1=utilfunc.MakeElement(NewXpath2).getAttribute("id");
								//System.out.println("Attribute name "+count1+"is : "+AttributeName1);

								if(AttributeName1.equals("FirstName")){			
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceFirstName);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("LastName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceLastName);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipal")){
									try{utilfunc.Selectdropdownvaluebytext(NewXpath2, Education_HistoryReferenceRelationshiptoYou);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipalDescription")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceOtherRelationshiptoYou);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("EmployerName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceCurrentEmployer);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("TitleEducationReference")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceCurrentTitle);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form1_country")){
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Education_HistoryReferenceCountry);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form1_route")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStreetAddress1);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("StreetAddress2EducationReference")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStreetAddress2);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("UnitTypeEducationReference")){
									try{
										String Newpath=NewXpath2+"[1]";
										utilfunc.Selectdropdownvaluebyvalue(Newpath, Education_HistoryReferenceAptSteFlr);
									}catch(Exception error){}
									try{
										String Newpath1=NewXpath2+"[2]";
										utilfunc.MakeElement(Newpath1).sendKeys(Education_HistoryReferenceAptSteFlr);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form1_locality")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form1_administrative_area_level_1")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form1_postal_code")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceZipPostalCode);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("fld-primary-email")){
									try{
										Thread.sleep(2000);
										utilfunc.MakeElement(NewXpath2).click();
									}catch(Exception error){}

									String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
									if(AttributeNameemail.equals("Email")){
										try{	utilfunc.MakeElement(Referenceemail).sendKeys(Education_HistoryReferenceEmails);
										}catch(Exception error){}
									}
								}
								else if(AttributeName1.equals("PhoneNumber1")){
									int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
									for(int count2=1; count2<=ObjCount2; count2++){
										Thread.sleep(300);
										String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
										try{
											String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											//System.out.println("Attribute name "+count2+"is : "+AttributeName2);

											if(AttributeName2.contains("PhoneNumberType")){	
												try{utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Education_HistoryReferencePhoneType);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneCountryCode")){
												try{utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneCountrycode);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneNumber1")){
												try{
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneNumber);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneExtension")){
												try{utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneExt);
												}catch(Exception error){}
											}
										}catch(Exception e){
										}
									}
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath2).click();	
										Thread.sleep(2000);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersFirstName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(EducationEmployerName_HistoryReferenceManagersFirstName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersLastName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceManagersLastName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersPhoneNumber")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceManagerPhonenumber);
									}catch(Exception error){}
								}
							}catch(Exception error){}
						}
						//////Addresslookup for reference.
						try{
							String AttributeName1=utilfunc.MakeElement(Referenceaddresslookupxpath).getAttribute("name");
							if(AttributeName1.contains("form2_autocomplete")){			
								try{
									utilfunc.MakeElement(Referenceaddresslookupxpath).sendKeys(Education_HistoryReferenceAddressLookup);
									utilfunc.mouseaction();
								}catch(Exception error){}
							}
						}
						catch(Exception f){
						}
						/////////////////////////////Additional info handled////////////////////////////////
						try{ utilfunc.dynamic_data(EducationHistory_additionalcounterxpath, EducationHistory_additionalinfoxpath);
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

					}catch(Exception error){	utilfunc.NavigatetoURL(URLwithID);	}
				}catch(Exception e){}

			}else if(mode.equals(ACTION1)){
				try{

					//String Education_HistoryURLwithID=Education_HistoryPageURL+Education_HistoryID;
					//utilfunc.NavigatetoURL(Education_HistoryURLwithID);

					
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					try{
						utilfunc.MakeElement(EditbuttonXpath).click();
						Thread.sleep(2000);

						int ObjCount=utilfunc.GetObjectCount(EducationHistory_maincounterxpath);
						//////////////////
						for(int count=1; count<=ObjCount; count++){
							Thread.sleep(300);
							String NewXpath=EducationHistory_mainxpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.contains("StartDate")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStartDate);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("GraduationDate")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryEndDate);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("NameOfInstitution")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryNameofInstitution);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("TypeOfInstitution")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryTypeOfInstitution);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("form2_country")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_Historycountry);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("form2_route")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStreetAddress);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("form2_locality")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryCityTownLocality);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("form2_administrative_area_level_1")){
									try{utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStateProvinceRegion);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("form2_postal_code")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryZipPostalCode);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("Number")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryPhoneNumber);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("DegreeReceived")){
									try{
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, Education_HistoryDegreeReceived);
										//utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryZipPostalCode);
									}catch(Exception e){}								
								}
								else if(AttributeName.contains("FieldOfStudy")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryFieldofStudy);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("CertificatesOrGrades")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryOtherCertificates);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("FullTimeYears")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryFullTimeYears);
									}catch(Exception e){}
								}
								else if(AttributeName.contains("CanObtainReferenceLetter1")){
									if(Education_HistoryCanYouObtainradio.equals("Yes")){
										try{	String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										//System.out.println(NewXpath1);
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception e){}
									}else{
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
											//System.out.println(NewXpath1);
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception e){}
									} 	
								}	
								else if(AttributeName.contains("btnShowDocUpload")){

									if(Fileupload.equals("Yes")){
										try{
											try{utilfunc.MakeElement(showbuttonxpath).click();
											Thread.sleep(2000);}catch(Exception e){}
											try{utilfunc.MakeElement(uploadbuttonxpath).click();
											Thread.sleep(1000);    }catch(Exception e){}
											try{utilfunc.uploadfile(fileuploadpath);
											Thread.sleep(5000);}catch(Exception e){}
											try{utilfunc.MakeElement(fileuploadbutton).click();}catch(Exception e){}
										}catch(Exception e){}
									}
								}
								/////////////////////reference end//////////////////////////////////////////////
							}catch(Exception e){
							}
						}
						//////////////////////////////////////address lookup////////////////////////////////
						try{
							String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
							if(AttributeName.contains("form2_autocomplete")){	
								try{
									utilfunc.MakeElement(addreslookupxpath).clear();
									utilfunc.MakeElement(addreslookupxpath).sendKeys(Education_HistoryAddressLookup);
									utilfunc.mouseaction();
								}catch(Exception e){}
							}
						}catch(Exception f){	}
						//////////////////////////Thesis or School Project handled ////////////////////////////////
						try{
							String AttributeName=utilfunc.MakeElement(EducationHistory_thesisxpath).getAttribute("name");
							if(AttributeName.contains("WorkType")){			
								try{utilfunc.MakeElement(EducationHistory_thesisxpath).click();
								}catch(Exception e){}
							}
						}catch(Exception e){}
						////////////////////////////Thesis detailed handled/////////////////////////////////
						try{
							int ObjCount2=utilfunc.GetObjectCount(EducationHistory_secondcounterpath);

							for(int count=1; count<=ObjCount2; count++){
								Thread.sleep(300);
								String NewXpath=EducationHistory_secGraduationDateondxpath.replace("xx", Integer.toString(count));

								try{
									String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.contains("TitleThesis")){		
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryTitleofThesis);
										}catch(Exception e){}
									}
									else if(AttributeName.contains("StartThesisDate")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryStartDateofThesis);
										}catch(Exception e){}
									}
									else if(AttributeName.contains("EndThesisDate")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryEndDateofThesis);
										}catch(Exception e){}
									}
									else if(AttributeName.contains("Description")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryDescriptionofThesis);
										}catch(Exception e){}
									}
									else if(AttributeName.contains("SkillGained")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Education_HistoryPleaselistanddescribetheskills);
										}catch(Exception e){}
									}
								}catch(Exception e){}

							}

						}catch(Exception e){}
						/////////////////////////reference handled///////////////////////
						int ObjCount1=utilfunc.GetObjectCount(Referencecounterxpath);
						//////////////////
						for(int count1=1; count1<=ObjCount1; count1++){
							Thread.sleep(300);
							String NewXpath2=Referencefieldxpath.replace("xx", Integer.toString(count1));

							try{
								String AttributeName1=utilfunc.MakeElement(NewXpath2).getAttribute("id");
								System.out.println("Attribute name "+count1+"is : "+AttributeName1);

								if(AttributeName1.equals("FirstName")){	
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceFirstName);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("LastName")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceLastName);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipal")){
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Education_HistoryReferenceRelationshiptoYou);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipalDescription")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceOtherRelationshiptoYou);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("EmployerName")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceCurrentEmployer);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("TitleEducationReference")){
									try{	utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceCurrentTitle);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("form1_country")){
									try{	utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Education_HistoryReferenceCountry);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("form1_route")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStreetAddress1);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("StreetAddress2EducationReference")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStreetAddress2);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("UnitTypeEducationReference")){
									try{
										String Newpath=NewXpath2+"[1]";
										utilfunc.Selectdropdownvaluebyvalue(Newpath, Education_HistoryReferenceAptSteFlr);
									}catch(Exception e){}
									try{
										String Newpath1=NewXpath2+"[2]";
										utilfunc.MakeElement(Newpath1).sendKeys(Education_HistoryReferenceAptSteFlr);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("form1_locality")){
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Education_HistoryReferenceCityTownLocality);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("form1_administrative_area_level_1")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceStateProvinceRegion);
									}catch(Exception e){}}
								else if(AttributeName1.equals("form1_postal_code")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceZipPostalCode);
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("fld-primary-email")){
									try{
										Thread.sleep(2000);
										utilfunc.MakeElement(NewXpath2).click();
										String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
										if(AttributeNameemail.equals("Email")){
											try{
												utilfunc.MakeElement(Referenceemail).clear();
												utilfunc.MakeElement(Referenceemail).sendKeys(Education_HistoryReferenceEmails);
											}catch(Exception e){}
										}
									}catch(Exception e){}
								}
								else if(AttributeName1.equals("PhoneNumber1")){
									int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
									for(int count2=1; count2<=ObjCount2; count2++){
										Thread.sleep(300);
										String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
										try{
											String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											System.out.println("Attribute name "+count2+"is : "+AttributeName2);

											if(AttributeName2.contains("PhoneNumberType")){	
												try{utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Education_HistoryReferencePhoneType);
												}catch(Exception e){}
											}
											else if(AttributeName2.contains("PhoneCountryCode")){
												try{
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneCountrycode);
												}catch(Exception e){}
											}
											else if(AttributeName2.contains("PhoneNumber1")){
												try{
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneNumber);
												}catch(Exception e){}
											}
											else if(AttributeName2.contains("PhoneExtension")){
												try{
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Education_HistoryReferencePhoneExt);
												}catch(Exception e){}
											}

										}catch(Exception e){

										}
									}
									try{
										Thread.sleep(2000);
										utilfunc.MakeElement(NewXpath2).click();	
										Thread.sleep(2000);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersFirstName")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(EducationEmployerName_HistoryReferenceManagersFirstName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersLastName")){
									try{utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceManagersLastName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersPhoneNumber")){
									try{
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Education_HistoryReferenceManagerPhonenumber);
									}catch(Exception error){}
								}
							}catch(Exception e){
							}

						}
						//////Addresslookup for reference.
						try{
							String AttributeName1=utilfunc.MakeElement(Referenceaddresslookupxpath).getAttribute("name");
							if(AttributeName1.contains("form2_autocomplete")){			
								try{
									utilfunc.MakeElement(Referenceaddresslookupxpath).sendKeys(Education_HistoryReferenceAddressLookup);
									utilfunc.mouseaction();
								}catch(Exception error){}
							}
						}
						catch(Exception f){
						}
						/////////////////////////////Additional info handled////////////////////////////////
						try{utilfunc.dynamic_data(EducationHistory_additionalcounterxpath, EducationHistory_additionalinfoxpath);}catch(Exception error){}

						try{utilfunc.savebutton();}catch(Exception error){}

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
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					//String Education_HistoryURLwithID=Education_HistoryPageURL+Education_HistoryID;
					//utilfunc.NavigatetoURL(Education_HistoryURLwithID);

					
					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(DeletebuttonXpath).click();
						Thread.sleep(3000);
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



