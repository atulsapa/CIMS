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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Destination_Country_Employment_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------
	public static String Deletecheck="";
	public static String ErrorMessage="";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";


	//Constructor----------

	public CIMS_Destination_Country_Employment_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Destination_Country_Employment_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 0, ColumnCounter);
		String Destination_Country_EmploymentScenerio=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 2, ColumnCounter);
		String Destination_Country_EmploymentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 3, ColumnCounter);		
		String Destination_Country_EmploymentPageURL=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 4, ColumnCounter);
		String Destination_Country_EmploymentID=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 5, ColumnCounter);

		String Destination_CountrySponsorEntity=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 6, ColumnCounter);
		String Destination_CountryAcquiredCompany=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 7, ColumnCounter);
		String Destination_CountryAssignmentType=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 8, ColumnCounter);
		String Destination_CountryDesiredStartDate=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 9, ColumnCounter);
		String Destination_CountryDesiredendDate=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 10, ColumnCounter);
		String Destination_CountryLengthofAssignment=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 11, ColumnCounter);
		String Destination_CountryRadio1=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 12, ColumnCounter);
		String Destination_CountryRadio1desc=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 13, ColumnCounter);
		String Destination_CountryRadio2=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 14, ColumnCounter);
		String Destination_CountryRadio2desc=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 15, ColumnCounter);
		String Destination_CountryRadio3=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 16, ColumnCounter);
		String Destination_CountryRadio3desc=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 17, ColumnCounter);
		String Destination_CountryRadio4=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 18, ColumnCounter);
		String Destination_CountryRadio4desc=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 19, ColumnCounter);
		String Destination_CountrySalaryAmount=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 20, ColumnCounter);
		String Destination_CountrySalaryCurrency=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 21, ColumnCounter);
		String Destination_CountrySalaryPer=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 22, ColumnCounter);
		String Destination_CountryPayrollEntity=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 23, ColumnCounter);
		String Destination_CountryPayrollEntitydesc=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 24, ColumnCounter);
		String Destination_CountryForeignPayrollradio=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 25, ColumnCounter);
		String Foreignpayrollcountry=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 26, ColumnCounter);
		String Destination_CountryHousingAllocationamount=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 27, ColumnCounter);
		String Destination_CountryHousingAllocationcurrency=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 28, ColumnCounter);
		String Destination_CountrySalaryAdditionalamount=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 29, ColumnCounter);
		String Destination_CountrySalaryAdditionalcurrency=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 30, ColumnCounter);
		String Destination_CountryWorkgroup=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 31, ColumnCounter);
		String Destination_CountryTitle=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 32, ColumnCounter);
		String Destination_CountryLevelGrade=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 33, ColumnCounter);
		String Destination_CountryJobCode=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 34, ColumnCounter);
		String Destination_CountryVessel=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 35, ColumnCounter);
		String Destination_CountryProject=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 36, ColumnCounter);
		String Destination_CountryDescriptionDuties=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 37, ColumnCounter);
		String Destination_CountryPrefix=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 38, ColumnCounter);
		String Destination_CountryNameFirst=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 39, ColumnCounter);
		String Destination_CountryNamemiddle=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 40, ColumnCounter);
		String Destination_CountryNamelast=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 41, ColumnCounter);

		String Destination_CountryJobDescription=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 42, ColumnCounter);
		String Destination_Country=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 43, ColumnCounter);
		String Destination_CountryAddressLookup=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 44, ColumnCounter);
		String Destination_CountryStreetAddress=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 45, ColumnCounter);
		String Destination_CountryStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 46, ColumnCounter);
		String Destination_CountryAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 47, ColumnCounter);
		String DestinDestination_CountryCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 48, ColumnCounter);
		String Destination_CountryStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 49, ColumnCounter);
		String Destination_CountryZipPostalCode=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 50, ColumnCounter);
		String Destination_CountryEmails=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 51, ColumnCounter);

		String Destination_CountryIsphonenumberisprimary=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 52, ColumnCounter);
		String Destination_CountryPhoneType=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 53, ColumnCounter);
		String Destination_CountryPhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 54, ColumnCounter);
		String Destination_CountryPhoneNumber=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 55, ColumnCounter);
		String Destination_CountryPhoneExt=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 56, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Destination_Country_Employment", 57, ColumnCounter);

		String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";

		String Destination_Country_Employment_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String Destination_Country_EmploymentCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		String radiobuttonfieldxpath=".//*[@class='question-group'][xx]//*[@class='control-group']//*[@id]";
		String radiobuttoncounterxpath=".//*[@class='question-group']//*[@class='control-group']//*[@id]";

		String Amountxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//*[@class='field'][1]//*[@id]";
		String Currencyxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//*[@class='field'][2]//*[@id]";
		String Perxpath=".//*[@class='form-horizontal']//*[@class='control-group'][7]//*[@class='field'][3]//*[@id]";

		String HousingAllocationamountxpath=".//*[@id='HousingAllocation']";
		String HousingAllocationCurrencyxpath=".//*[@id='HousingAllocationCurrency']";

		String AdditionalRelocationBenefitsamountxpath=".//*[@id='AdditionalRelocationBenefit']";
		String AdditionalRelocationBenefitsCurrencyxpath=".//*[@id='AdditionalRelocationBenefitCurrency']";

		String CompanyContactFirstnamexpath=".//*[@id='FirstName']";
		String CompanyContactMiddlenamexpath=".//*[@id='MiddleName']";
		String CompanyContactlastnamexpath=".//*[@id='LastName']";

		String Referenceaddresslookupxpath=".//*[@class='question-group-address']//*[@class='control-group']//*[@id]";

		String Referenceemail=".//*[@id='grp-email']//*[@name]";

		String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
		String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Destination Country Employment";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Destination_Country_EmploymentScenerio;
		description=Destination_Country_EmploymentTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)| mode.equals(ACTION1)){
				try{
					/*String Destination_Country_EmploymentURLwithID=Destination_Country_EmploymentPageURL+Destination_Country_EmploymentID;
					 utilfunc.NavigatetoURL(Destination_Country_EmploymentURLwithID);*/

					try{ utilfunc.NavigatetoURL(URLwithID);Thread.sleep(2000);}catch(Exception error){}

					utilfunc.ServerErrorHandler();

					int ObjCount=utilfunc.GetObjectCount(Destination_Country_EmploymentCounterXpath);
					try{
						for(int count=1; count<=ObjCount; count++)
						{
							String NewXpath=Destination_Country_Employment_attributeFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("SponsorEntityId")){							
									Thread.sleep(1500);
									try {
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, Destination_CountrySponsorEntity);
									} catch (Exception e) {
										
									}
								}	
								else if(AttributeName.equals("AcquiredCompanyName")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryAcquiredCompany);
								}
								else if(AttributeName.equals("AssignmentType")){							
									try {
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, Destination_CountryAssignmentType);
									} catch (Exception e) {
										
									}

								}
								else if(AttributeName.equals("StartDate")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryDesiredStartDate);
								}
								else if(AttributeName.equals("EndDate")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryDesiredendDate);
								}
								else if(AttributeName.equals("AssignmentLength")){			
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryLengthofAssignment);
								}
								else if(AttributeName.equals("Salary")){		
									///do some stuff

									utilfunc.MakeElement(Amountxpath).clear();
									utilfunc.MakeElement(Amountxpath).sendKeys(Destination_CountrySalaryAmount);

									if(utilfunc.MakeElement(NewXpath).isEnabled()){
										try{
											utilfunc.Selectdropdownvaluebyvalue(Currencyxpath, Destination_CountrySalaryCurrency);
											Thread.sleep(1100);								 
											utilfunc.Selectdropdownvaluebyvalue(Perxpath, Destination_CountrySalaryPer);

										}catch(Exception e){
											System.out.println("Exceptiion is"+e);
										}
									}
								}
								else if(AttributeName.equals("PayRollEntityId")){							
									try{
										String Newpath=NewXpath+"[1]";
										try {
											utilfunc.Selectdropdownvaluebyvalue(Newpath, Destination_CountryPayrollEntity);
										} catch (Exception e) {
											
										}
										String Newpath1=NewXpath+"[2]";
										utilfunc.MakeElement(Newpath1).clear();
										utilfunc.MakeElement(Newpath1).sendKeys(Destination_CountryPayrollEntitydesc);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("IsForeignPayRoll")){
									if(Destination_CountryForeignPayrollradio.equals("Yes")){
										try{
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
											String newpath=NewXpath.replace("//*[@id]", "//*[@id='dvForeignPayrollCountryCode']//*[@id]");
											try {
												Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebyvalue(newpath,Foreignpayrollcountry);
											} catch (Exception e) {
												
											}
										}catch(Exception error){}
									}
								}
								else if(AttributeName.equals("BusinessUnitId")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryWorkgroup);
								}
								else if(AttributeName.equals("Title")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryTitle);
								}
								else if(AttributeName.equals("LevelOrGrade")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryLevelGrade);
								}
								else if(AttributeName.equals("JobCode")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryJobCode);
								}
								else if(AttributeName.equals("Vessel")){		
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryVessel);
								}
								else if(AttributeName.equals("Project")){		
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryProject);
								}
								else if(AttributeName.equals("mceu_8")){
									/* utilfunc.iframe(Destination_CountryDescriptionDuties);*/
									try{
										webdriver.switchTo().frame("JobDescription_ifr");
										webdriver.findElement(By.id("tinymce")).clear();
										((JavascriptExecutor) webdriver).executeScript("document.body.innerHTML = '<h3> "+Destination_CountryDescriptionDuties+"</h3>'");
										webdriver.switchTo().defaultContent();
									}catch(Exception error){}
								}
								else if(AttributeName.equals("ddlPrefix")){	
									try {
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, Destination_CountryPrefix);
									} catch (Exception e) {
										
									}

								}
								else if(AttributeName.equals("CountJobDescription")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryJobDescription);
								}
								else if(AttributeName.equals("country")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_Country);
								}
								else if(AttributeName.equals("route")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryStreetAddress);
								}
								else if(AttributeName.equals("StreetAddress2")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryStreetAddress2);
								}
								else if(AttributeName.equals("UnitType")){							
									try{
										String Newpath=NewXpath+"[1]";
										try {
											utilfunc.Selectdropdownvaluebyvalue(Newpath, Destination_CountryAptSteFlr);
										} catch (Exception e) {
											
										}
										String Newpath1=NewXpath+"[2]";
										utilfunc.MakeElement(Newpath1).clear();
										utilfunc.MakeElement(Newpath1).sendKeys(Destination_CountryAptSteFlr);
									}catch(Exception error){}
								}
								else if(AttributeName.equals("locality")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(DestinDestination_CountryCityTownLocality);
								}
								else if(AttributeName.equals("administrative_area_level_1")){	
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryStateProvinceRegion);
								}
								else if(AttributeName.equals("postal_code")){		
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Destination_CountryZipPostalCode);
								}
								else if(AttributeName.equals("fld-primary-email")){							
									try{

										String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
										if(AttributeNameemail.equals("Email")){
											utilfunc.MakeElement(Referenceemail).clear();
											utilfunc.MakeElement(Referenceemail).sendKeys(Destination_CountryEmails);
										}
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
											
										}
									}catch(Exception error){}
								}
								else if(AttributeName.equals("fld-primary-phone")){							
									try{
										int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);

										for(int count2=1; count2<=ObjCount2; count2++){

											String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
											try{
												String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
												System.out.println("Attribute name "+count2+"is : "+AttributeName2);

												if(AttributeName2.contains("PhoneNumberType")){	
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Destination_CountryPhoneType);
												}
												else if(AttributeName2.contains("PhoneCountryCode")){
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Destination_CountryPhoneCountrycode);
												}
												else if(AttributeName2.contains("PhoneNumber")){
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Destination_CountryPhoneNumber);
												}
												else if(AttributeName2.contains("PhoneExtension")){
													utilfunc.MakeElement(NewXpath3).clear();
													utilfunc.MakeElement(NewXpath3).sendKeys(Destination_CountryPhoneExt);
												}

											}catch(Exception e){

											}
										}
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {
											
										}
									}catch(Exception error){}
								}

							}catch(Exception e){

							}
						}}catch(Exception error){}
					/////////////////////////radio/////////////////////////////////////////////
					int ObjCount1=utilfunc.GetObjectCount(radiobuttoncounterxpath);
					try{
						for(int count=1; count<=ObjCount1; count++)
						{
							String NewXpath=radiobuttonfieldxpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.equals("F201a")){	
									if(Destination_CountryRadio1.equals("Yes")){
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();
											} catch (Exception e) {
												
											}

											String NewXpath2=NewXpath.replace("//*[@id]", "//textarea");
											utilfunc.MakeElement(NewXpath2).clear();
											utilfunc.MakeElement(NewXpath2).sendKeys(Destination_CountryRadio1desc);
										}catch(Exception error){}
									}else{
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception error){}
									}
								}	
								else if(AttributeName.equals("F202a")){							
									if(Destination_CountryRadio2.equals("Yes")){
										try{String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										} catch (Exception e) {
										}

										String NewXpath2=NewXpath.replace("//*[@id]", "//textarea");
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Destination_CountryRadio2desc);
										}catch(Exception error){}
									}else{
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception error){}
									}
								}
								else if(AttributeName.equals("F203a")){							
									if(Destination_CountryRadio3.equals("Yes")){
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
											Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();

										String NewXpath2=NewXpath.replace("//*[@id]", "//textarea");
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Destination_CountryRadio3desc);
										}catch(Exception error){}
									}else{
						try{				String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										utilfunc.MakeElement(NewXpath1).click();
						}catch(Exception error){}
									}
								}
								else if(AttributeName.equals("F204a")){							
									if(Destination_CountryRadio4.equals("Yes")){
										try{
											
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();

										String NewXpath2=NewXpath.replace("//*[@id]", "//textarea");
										utilfunc.MakeElement(NewXpath2).clear();
										utilfunc.MakeElement(NewXpath2).sendKeys(Destination_CountryRadio4desc);
										}catch(Exception error){}
									}else{
										try{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath1).click();
										}catch(Exception error){}
									}
								}
							}catch(Exception e){

							}
						}
					}catch(Exception error){}
					//////Address lookup for reference.
					try{
						String AttributeName1=utilfunc.MakeElement(Referenceaddresslookupxpath).getAttribute("id");
						if(AttributeName1.contains("autocomplete")){			
							utilfunc.MakeElement(Referenceaddresslookupxpath).sendKeys(Destination_CountryAddressLookup);
							utilfunc.mouseaction();
						}
					}
					catch(Exception f){
					}
					/////////////////// Housing Allocation and Additional Relocation Benefits//////////

					try{
						utilfunc.MakeElement(HousingAllocationamountxpath).clear();
						utilfunc.MakeElement(HousingAllocationamountxpath).sendKeys(Destination_CountryHousingAllocationamount);
						utilfunc.Selectdropdownvaluebyvalue(HousingAllocationCurrencyxpath, Destination_CountryHousingAllocationcurrency);

						utilfunc.MakeElement(AdditionalRelocationBenefitsamountxpath).clear();
						utilfunc.MakeElement(AdditionalRelocationBenefitsamountxpath).sendKeys(Destination_CountrySalaryAdditionalamount);
						utilfunc.Selectdropdownvaluebyvalue(AdditionalRelocationBenefitsCurrencyxpath, Destination_CountrySalaryAdditionalcurrency);

					}catch(Exception e){

					}

					///////////////////company contact name////////////////////////////////////
					try{
						utilfunc.MakeElement(CompanyContactFirstnamexpath).clear();
						utilfunc.MakeElement(CompanyContactFirstnamexpath).sendKeys(Destination_CountryNameFirst);

						utilfunc.MakeElement(CompanyContactMiddlenamexpath).clear();
						utilfunc.MakeElement(CompanyContactMiddlenamexpath).sendKeys(Destination_CountryNamemiddle);

						utilfunc.MakeElement(CompanyContactlastnamexpath).clear();
						utilfunc.MakeElement(CompanyContactlastnamexpath).sendKeys(Destination_CountryNamelast);
					}catch(Exception e){

					}


					//////////////////////Additional info handle///////////////////////////////
					try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);}catch(Exception error){}

					String SaveButtonXpath=".//*[@class='action-bar']//*[@class='btn btn-primary']";
					try{ utilfunc.MakeElement(SaveButtonXpath).click();}catch(Exception Error){}
					//utilfunc.savebutton();

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.equals("")){
						Flag=true;
					}else if (error_flag.contains("Success!")){
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


			}else if(mode.equals(ACTION2)){

				try{	
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					utilfunc.MakeElement(deletexpath).click();
					utilfunc.isAlertPresent();

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}

				}catch(Exception z){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					Deletecheck="Delete";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			

			}

		}///////////url ckeck end



		return Flag;
	}

}
