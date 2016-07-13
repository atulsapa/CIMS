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

import util.UtilFunction;

public class CIMS_Employment_History_Module {
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

	public CIMS_Employment_History_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Employment_History_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Employment_History", 0, ColumnCounter);
		String Employment_HistoryScenerio=UtilFunction.getCellData("Test Data.xls", "Employment_History", 2, ColumnCounter);
		String Employment_HistoryTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Employment_History", 3, ColumnCounter);		
		String Employment_HistoryPageURL=UtilFunction.getCellData("Test Data.xls", "Employment_History", 4, ColumnCounter);
		String Employment_HistoryID=UtilFunction.getCellData("Test Data.xls", "Employment_History", 5, ColumnCounter);

		String Employment_HistoryStartdate=UtilFunction.getCellData("Test Data.xls", "Employment_History", 6, ColumnCounter);
		String Employment_HistoryEnddate=UtilFunction.getCellData("Test Data.xls", "Employment_History", 7, ColumnCounter);
		String Employment_HistoryEmploymentStatus=UtilFunction.getCellData("Test Data.xls", "Employment_History", 8, ColumnCounter);
		String Employment_HistoryYahooorAffiliatedEntity=UtilFunction.getCellData("Test Data.xls", "Employment_History", 9, ColumnCounter);
		String Employment_HistoryCompanyname=UtilFunction.getCellData("Test Data.xls", "Employment_History", 10, ColumnCounter);
		String Employment_HistoryTypeofBusiness=UtilFunction.getCellData("Test Data.xls", "Employment_History", 11, ColumnCounter);
		String Employment_HistoryCompanyStillOperating=UtilFunction.getCellData("Test Data.xls", "Employment_History", 12, ColumnCounter);
		String Employment_HistoryIsthecompanyenteredabove=UtilFunction.getCellData("Test Data.xls", "Employment_History", 13, ColumnCounter);
		String Employment_HistoryCountry=UtilFunction.getCellData("Test Data.xls", "Employment_History", 14, ColumnCounter);
		String Employment_HistoryAddressLookup=UtilFunction.getCellData("Test Data.xls", "Employment_History", 15, ColumnCounter);

		String Employment_HistoryStreetAddress1=UtilFunction.getCellData("Test Data.xls", "Employment_History", 16, ColumnCounter);
		String Employment_HistoryStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Employment_History", 17, ColumnCounter);
		String Employment_HistoryCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Employment_History", 18, ColumnCounter);
		String Employment_HistoryStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Employment_History", 19, ColumnCounter);
		String Employment_HistoryZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Employment_History", 20, ColumnCounter);
		String Employment_HistoryPhoneNumber=UtilFunction.getCellData("Test Data.xls", "Employment_History", 21, ColumnCounter);
		String Employment_HistoryTitleOccupation=UtilFunction.getCellData("Test Data.xls", "Employment_History", 22, ColumnCounter);
		String Employment_HistoryDepartment=UtilFunction.getCellData("Test Data.xls", "Employment_History", 23, ColumnCounter);
		String Employment_HistoryDetailedJobDescription=UtilFunction.getCellData("Test Data.xls", "Employment_History", 24, ColumnCounter);
		String Employment_HistoryBaseSalaryamount=UtilFunction.getCellData("Test Data.xls", "Employment_History", 25, ColumnCounter);
		String Employment_HistoryBaseSalarycurrency=UtilFunction.getCellData("Test Data.xls", "Employment_History", 26, ColumnCounter);
		String Employment_HistoryHoursperWeek=UtilFunction.getCellData("Test Data.xls", "Employment_History", 27, ColumnCounter);
		String Employment_HistoryCanYouObtainaReferenceLetter=UtilFunction.getCellData("Test Data.xls", "Employment_History", 28, ColumnCounter);

		//Reference
		String Employment_HistoryReferenceFirstName=UtilFunction.getCellData("Test Data.xls", "Employment_History", 29, ColumnCounter);
		String Employment_HistoryReferenceLastName=UtilFunction.getCellData("Test Data.xls", "Employment_History", 30, ColumnCounter);
		String Employment_HistoryReferenceRelationshiptoYou=UtilFunction.getCellData("Test Data.xls", "Employment_History", 31, ColumnCounter);
		String Employment_HistoryReferenceOtherRelationshiptoYou=UtilFunction.getCellData("Test Data.xls", "Employment_History", 32, ColumnCounter);
		String Employment_HistoryReferenceCurrentEmployer=UtilFunction.getCellData("Test Data.xls", "Employment_History", 33, ColumnCounter);
		String Employment_HistoryReferenceCurrentTitle=UtilFunction.getCellData("Test Data.xls", "Employment_History", 34, ColumnCounter);
		String Employment_HistoryReferenceCountry=UtilFunction.getCellData("Test Data.xls", "Employment_History", 35, ColumnCounter);
		String Employment_HistoryReferenceAddressLookup=UtilFunction.getCellData("Test Data.xls", "Employment_History", 36, ColumnCounter);
		String Employment_HistoryReferenceStreetAddress1=UtilFunction.getCellData("Test Data.xls", "Employment_History", 37, ColumnCounter);
		String Employment_HistoryReferenceStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Employment_History", 38, ColumnCounter);
		String Employment_HistoryReferenceAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Employment_History", 39, ColumnCounter);
		String Employment_HistoryReferenceCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Employment_History", 40, ColumnCounter);
		String Employment_HistoryReferenceStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Employment_History", 41, ColumnCounter);
		String Employment_HistoryReferenceZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Employment_History", 42, ColumnCounter);
		String Employment_HistoryReferenceEmails=UtilFunction.getCellData("Test Data.xls", "Employment_History", 43, ColumnCounter);
		String Employment_HistoryReferencePhoneType=UtilFunction.getCellData("Test Data.xls", "Employment_History", 44, ColumnCounter);
		String Employment_HistoryReferencePhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "Employment_History", 45, ColumnCounter);
		String Employment_HistoryReferencePhoneNumber=UtilFunction.getCellData("Test Data.xls", "Employment_History", 46, ColumnCounter);
		String Employment_HistoryReferencePhoneExt=UtilFunction.getCellData("Test Data.xls", "Employment_History", 47, ColumnCounter);
		String Employment_HistoryReferenceManagersFirstName=UtilFunction.getCellData("Test Data.xls", "Employment_History", 48, ColumnCounter);
		String Employment_HistoryReferenceManagersLastName=UtilFunction.getCellData("Test Data.xls", "Employment_History", 49, ColumnCounter);
		String Employment_HistoryReferenceManagerPhonenumber=UtilFunction.getCellData("Test Data.xls", "Employment_History", 50, ColumnCounter);

		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Employment_History", 51, ColumnCounter);


		String addditionalinfoxpath=".//*[@class='form-horizontal ng-pristine ng-valid']/div[26]//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal ng-pristine ng-valid']/div[26]//*[@class='control-group']//*[@id]";

		String Employment_History_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
		String Employment_HistoryCounterXpath=".//*[@class='control-group']//*[@id]";

		String addreslookupxpath=".//*[@class='panel-body-main']//*[@class='question-group-address']//*[@name]";

		String Referencefieldxpath=".//*[@id='ReferenceDiv']//*[@class='control-group'][xx]//*[@id]";
		String Referencecounterxpath=".//*[@id='ReferenceDiv']//*[@class='control-group']//*[@id]";

		String Referenceaddresslookupxpath=".//*[@id='ReferenceDiv']//*[@class='question-group-address']//*[@id]";

		String Referenceemail=".//*[@id='grp-email']//*[@name]";

		String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
		String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Employment History";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Employment_HistoryScenerio;
		description=Employment_HistoryTestcaseDescription;

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
					/*String Employment_HistoryURLwithID=Employment_HistoryPageURL+Employment_HistoryID;
					 utilfunc.NavigatetoURL(Employment_HistoryURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					try{

						String AddbuttonXpath="//*[@class='btn']";
						utilfunc.MakeElement(AddbuttonXpath).click();



						int ObjCount=utilfunc.GetObjectCount(Employment_HistoryCounterXpath);

						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Employment_History_attributeFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								//System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("StartDate")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStartdate);
									webdriver.findElement(By.xpath("//*[@id='form1']/h4[1]")).click();
									Thread.sleep(2000);
									}catch(Exception error){}
								}	
								else if(AttributeName.equals("EndDate")){							
									try{
										utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryEnddate);
										webdriver.findElement(By.xpath("//*[@id='form1']/h4[1]")).click();
										Thread.sleep(2000);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("EmploymentStatus")){		
									if(Employment_HistoryEmploymentStatus.equals("Employed")){
										if(utilfunc.MakeElement(NewXpath).isEnabled()){
											try{utilfunc.MakeElement(NewXpath).click();
											}catch(Exception error){}
										}
									}
								}
								else if(AttributeName.equals("EntityId")){							
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Employment_HistoryYahooorAffiliatedEntity);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("CompanyName")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryCompanyname);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("TypeOfBusiness")){							
									try{ utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryTypeofBusiness);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("CompanyStillOperating1")){	
									if(Employment_HistoryCompanyStillOperating.equals("Yes")){
										try{
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
										}catch(Exception error){}
									}
								}
								else if(AttributeName.equals("AffiliatedCompany1")){	
									if(Employment_HistoryIsthecompanyenteredabove.equals("Yes")){
										try{
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
										}catch(Exception error){}	 
									}
								}
								else if(AttributeName.equals("InspectedByImmigrantOfficer")){							
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}}
								else if(AttributeName.equals("EntryDenied")){							
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
								else if(AttributeName.equals("form1_country")){							
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Employment_HistoryCountry);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("form1_route")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStreetAddress1);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("form1_locality")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("StreetAddress2")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStreetAddress2);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("form1_administrative_area_level_1")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("form1_postal_code")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryZipPostalCode);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("Number")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryPhoneNumber);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("Title")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryTitleOccupation);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("Department")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryDepartment);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("JobDescription")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryDetailedJobDescription);
									}catch(Exception error){}
								}

								else if(AttributeName.equals("BaseSalary")){	
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='field'][1]//*[@id]");
										String NewXpath2=NewXpath.replace("//*[@id]", "//*[@class='field'][2]//*[@id]");
										utilfunc.MakeElement(NewXpath1).sendKeys(Employment_HistoryBaseSalaryamount);
										utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryBaseSalarycurrency);
									}catch(Exception error){}
								}							 
								else if(AttributeName.equals("HoursPerWeek")){							
									try{utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryHoursperWeek);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("CanObtainReferenceLetter1")){
									if(Employment_HistoryCanYouObtainaReferenceLetter.equals("Yes")){
										try{
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										}catch(Exception error){}}
								}
							}catch(Exception e){
							}
						}
						//////////////////////////////////////address lookup////////////////////////////////
						try{
							String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
							if(AttributeName.contains("form1_autocomplete")){			
								try{
									utilfunc.MakeElement(addreslookupxpath).sendKeys(Employment_HistoryAddressLookup);
									utilfunc.mouseaction();
								}catch(Exception error){}
							}
						}
						catch(Exception f){
						}
						/////////////////////////reference handled///////////////////////
						int ObjCount1=utilfunc.GetObjectCount(Referencecounterxpath);
						//////////////////
						for(int count1=1; count1<=ObjCount1; count1++){
							Thread.sleep(300);
							String NewXpath2=Referencefieldxpath.replace("xx", Integer.toString(count1));

							try{
								String AttributeName1=utilfunc.MakeElement(NewXpath2).getAttribute("id");
								//System.out.println("Attribute name "+count1+"is : "+AttributeName1);

								if(AttributeName1.equals("FirstName")){			
									try{ utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceFirstName);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("LastName")){
									try{ utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceLastName);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipal")){
									try{	utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryReferenceRelationshiptoYou);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("RelationshipToPrincipalDescription")){
									try{ 	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceOtherRelationshiptoYou);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("EmployerName")){
									try{ 	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCurrentEmployer);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("TitleEmploymentReference")){
									try{ 	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCurrentTitle);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form2_country")){
									try{	utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryReferenceCountry);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form2_route")){
									try{ 	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStreetAddress1);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("StreetAddress2EmploymentReference")){
									try{ 	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStreetAddress2);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("UnitTypeEmploymentReference")){
									try{ 	String Newpath=NewXpath2+"[1]";
									utilfunc.Selectdropdownvaluebyvalue(Newpath, Employment_HistoryReferenceAptSteFlr);
									String Newpath1=NewXpath2+"[2]";
									utilfunc.MakeElement(Newpath1).sendKeys(Employment_HistoryReferenceAptSteFlr);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form2_locality")){
									try{	utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form2_administrative_area_level_1")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("form2_postal_code")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceZipPostalCode);
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("fld-primary-email")){
									String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
									if(AttributeNameemail.equals("Email")){
										utilfunc.MakeElement(Referenceemail).sendKeys(Employment_HistoryReferenceEmails);
									}
									try{utilfunc.MakeElement(NewXpath2).click();
									}catch(Exception error){}
								}
								else if(AttributeName1.equals("fld-primary-phone")){


									int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);

									for(int count2=1; count2<=ObjCount2; count2++){
										String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
										try{
											String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											//System.out.println("Attribute name "+count2+"is : "+AttributeName2);

											if(AttributeName2.contains("PhoneNumberType")){	
												try{utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Employment_HistoryReferencePhoneType);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneCountryCode")){
												try{utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneCountrycode);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneNumber")){
												try{utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneNumber);
												}catch(Exception error){}
											}
											else if(AttributeName2.contains("PhoneExtension")){
												try{utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneExt);
												}catch(Exception error){}
											}
										}catch(Exception e){

										}
									}
									try{
										utilfunc.MakeElement(NewXpath2).click();
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersFirstName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagersFirstName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersLastName")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagersLastName);
									}catch(Exception error){}
								}
								else if(AttributeName1.contains("ManagersPhoneNumber")){
									try{utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagerPhonenumber);
									}catch(Exception error){}
								}
							}catch(Exception e){

							}


						}
						//////Addresslookup for reference.
						try{
							String AttributeName1=utilfunc.MakeElement(Referenceaddresslookupxpath).getAttribute("name");
							if(AttributeName1.contains("form2_autocomplete")){			
								try{utilfunc.MakeElement(Referenceaddresslookupxpath).sendKeys(Employment_HistoryReferenceAddressLookup);
								utilfunc.mouseaction();
								}catch(Exception error){}
							}
						}
						catch(Exception f){
						}

						//////////////////////Additional info handle///////////////////////////////
						try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
						}catch(Exception error){}	 

						try{utilfunc.savebutton();
						}catch(Exception error){}

						String error_flag=utilfunc.ErrorMessagehandlerExperiment();

						System.out.println("Error_flag			 :"+error_flag);
						System.out.println("ExpectedErrorMessage :"+ExpectedErrorMessage);
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

					}catch(Exception e){utilfunc.NavigatetoURL(URLwithID);}
				}
				catch(Exception e){

				}


			}else if(mode.equals(ACTION1)){

				try{
					/* String Employment_HistoryURLwithID=Employment_HistoryPageURL+Employment_HistoryID;
					 utilfunc.NavigatetoURL(Employment_HistoryURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);	 

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					try{utilfunc.MakeElement(EditbuttonXpath).click();



					int ObjCount=utilfunc.GetObjectCount(Employment_HistoryCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						String NewXpath=Employment_History_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							//System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("StartDate")){	
								try{ 
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStartdate);
								}catch(Exception error){}
							}	
							else if(AttributeName.equals("EndDate")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryEnddate);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("EmploymentStatus")){		
								if(Employment_HistoryEmploymentStatus.equals("Employed")){
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("EntityId")){							
								try{ utilfunc.Selectdropdownvaluebyvalue(NewXpath, Employment_HistoryYahooorAffiliatedEntity);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("CompanyName")){	
								try{ utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryCompanyname);
								}catch(Exception error){}
							}

							else if(AttributeName.equals("TypeOfBusiness")){
								try{ utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryTypeofBusiness);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("CompanyStillOperating1")){
								try{ if(Employment_HistoryCompanyStillOperating.equals("Yes")){
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								}
								}catch(Exception error){}

							}
							else if(AttributeName.equals("AffiliatedCompany1")){	
								if(Employment_HistoryIsthecompanyenteredabove.equals("Yes")){
									try{ 
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("InspectedByImmigrantOfficer")){							
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								}catch(Exception error){}
							}
							else if(AttributeName.equals("EntryDenied")){							
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								}catch(Exception error){}
							}
							else if(AttributeName.equals("form1_country")){							
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Employment_HistoryCountry);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("form1_route")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStreetAddress1);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("form1_locality")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryCityTownLocality);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("StreetAddress2")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStreetAddress2);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("form1_administrative_area_level_1")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryStateProvinceRegion);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("form1_postal_code")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryZipPostalCode);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("Number")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryPhoneNumber);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("Title")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryTitleOccupation);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("Department")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryDepartment);
								}catch(Exception error){}	
							}

							else if(AttributeName.equals("JobDescription")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryDetailedJobDescription);
								}catch(Exception error){}
							}

							else if(AttributeName.equals("BaseSalary")){	
								try{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='field'][1]//*[@id]");
									String NewXpath2=NewXpath.replace("//*[@id]", "//*[@class='field'][2]//*[@id]");
									utilfunc.MakeElement(NewXpath1).clear();
									utilfunc.MakeElement(NewXpath1).sendKeys(Employment_HistoryBaseSalaryamount);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryBaseSalarycurrency);
								}catch(Exception error){}
							}

							else if(AttributeName.equals("HoursPerWeek")){	
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Employment_HistoryHoursperWeek);
								}catch(Exception error){}
							}
							else if(AttributeName.equals("CanObtainReferenceLetter1")){
								if(Employment_HistoryCanYouObtainaReferenceLetter.equals("Yes")){
									try{Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
							}	 


						}catch(Exception e){

						}
					}
					//////////////////////////////////////address lookup////////////////////////////////
					try{
						String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
						if(AttributeName.contains("form1_autocomplete")){			
							try{
								utilfunc.MakeElement(addreslookupxpath).sendKeys(Employment_HistoryAddressLookup);
								utilfunc.mouseaction();
							}catch(Exception error){}
						}
					}
					catch(Exception f){
					}
					/////////////////////////reference handled///////////////////////
					int ObjCount1=utilfunc.GetObjectCount(Referencecounterxpath);
					//////////////////
					for(int count1=1; count1<=ObjCount1; count1++){
						Thread.sleep(300);
						String NewXpath2=Referencefieldxpath.replace("xx", Integer.toString(count1));

						try{
							String AttributeName1=utilfunc.MakeElement(NewXpath2).getAttribute("id");
							//System.out.println("Attribute name "+count1+"is : "+AttributeName1);

							if(AttributeName1.equals("FirstName")){		
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceFirstName);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("LastName")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceLastName);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("RelationshipToPrincipal")){
								try{	utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryReferenceRelationshiptoYou);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("RelationshipToPrincipalDescription")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceOtherRelationshiptoYou);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("EmployerName")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCurrentEmployer);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("TitleEmploymentReference")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCurrentTitle);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("form2_country")){
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath2, Employment_HistoryReferenceCountry);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("form2_route")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStreetAddress1);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("StreetAddress2EmploymentReference")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStreetAddress2);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("UnitTypeEmploymentReference")){
								try{
									String Newpath=NewXpath2+"[1]";
									utilfunc.Selectdropdownvaluebyvalue(Newpath, Employment_HistoryReferenceAptSteFlr);
									String Newpath1=NewXpath2+"[2]";
									utilfunc.MakeElement(Newpath1).clear();
									utilfunc.MakeElement(Newpath1).sendKeys(Employment_HistoryReferenceAptSteFlr);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("form2_locality")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceCityTownLocality);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("form2_administrative_area_level_1")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceStateProvinceRegion);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("form2_postal_code")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceZipPostalCode);
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("fld-primary-email")){

								try{
									String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
									if(AttributeNameemail.equals("Email")){
										try{
											utilfunc.MakeElement(Referenceemail).clear();
											utilfunc.MakeElement(Referenceemail).sendKeys(Employment_HistoryReferenceEmails);
										}catch(Exception error){}
									}
									Thread.sleep(1000);							 	
									utilfunc.MakeElement(NewXpath2).click();
								}catch(Exception error){}
							}
							else if(AttributeName1.equals("fld-primary-phone")){


								int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);

								for(int count2=1; count2<=ObjCount2; count2++){
									Thread.sleep(300);
									String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
									try{
										String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
										//System.out.println("Attribute name "+count2+"is : "+AttributeName2);

										if(AttributeName2.contains("PhoneNumberType")){	
											try{utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Employment_HistoryReferencePhoneType);
											}catch(Exception error){}
										}
										else if(AttributeName2.contains("PhoneCountryCode")){
											try{
												utilfunc.MakeElement(NewXpath3).clear();
												utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneCountrycode);
											}catch(Exception error){}
										}
										else if(AttributeName2.contains("PhoneNumber")){
											try{
												utilfunc.MakeElement(NewXpath3).clear();
												utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneNumber);
											}catch(Exception error){}
										}
										else if(AttributeName2.contains("PhoneExtension")){
											try{
												utilfunc.MakeElement(NewXpath3).clear();
												utilfunc.MakeElement(NewXpath3).sendKeys(Employment_HistoryReferencePhoneExt);
											}catch(Exception error){}
										}																		 			
									}catch(Exception e){

									}
								}
								try{
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath2).click();
								}catch(Exception error){}

							}
							else if(AttributeName1.contains("ManagersFirstName")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagersFirstName);
								}catch(Exception error){}
							}
							else if(AttributeName1.contains("ManagersLastName")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagersLastName);
								}catch(Exception error){}
							}
							else if(AttributeName1.contains("ManagersPhoneNumber")){
								try{
									utilfunc.MakeElement(NewXpath2).clear();
									utilfunc.MakeElement(NewXpath2).sendKeys(Employment_HistoryReferenceManagerPhonenumber);
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
								utilfunc.MakeElement(Referenceaddresslookupxpath).sendKeys(Employment_HistoryReferenceAddressLookup);
								utilfunc.mouseaction();
							}catch(Exception error){}
						}
					}
					catch(Exception f){
					}

					//////////////////////Additional info handle///////////////////////////////
					try{	utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
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
					}catch(Exception error){utilfunc.NavigatetoURL(URLwithID);}

				}
				catch(Exception e){
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
					/*String Employment_HistoryURLwithID=Employment_HistoryPageURL+Employment_HistoryID;
					 utilfunc.NavigatetoURL(Employment_HistoryURLwithID);*/
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
						String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
						utilfunc.MakeElement(DeletebuttonXpath).click();

						Thread.sleep(10000);

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