package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.ior.MakeImmutable;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;

import util.UtilFunction;



public class CIMS_Company_Entity {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	private String filename	=	"Test Company Data.xls";
	private String sheetName	=	"Entity";
	private String mode			=	"New";
	
	public static String Deletecheck="";
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_Entity(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Entity(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on Add Entity module");
		boolean Flag	=	false;

		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String Primary										=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String EntityName									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String NickName										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String TypeOfBussiness								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String NumberOfEmployess							=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String NationalNumberOfEmployees					=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String NetRevenues									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String GrossRevenues								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String DataYear										=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String FederalTaxID									=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String StateTaxID									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String YearFounded									=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String Description									=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String NumberOfCitizens								=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String NoOfLegalPermanentResidents					=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String NoOfForeignWorkers							=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String CompanyDescription							=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				String BusinessRegistrationNumber					=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String transferredAnEmployee						=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				String transferredAnEmployeeDesc					=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
				String CodeNAF										=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
				String SalaryReference								=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
				String CompanyLegalName								=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
				String employedForeignWorkers						=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
				String employedForeignWorkersDesc					=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
				String employeesLaidOf								=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
				String employeesLaidOfDesc							=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
				String licensesHold									=			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
				String BusinessConductedOutside						=			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
				String TotalCapitalCompany							=			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
				String DateOfIncorporation							=			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
				String EmployerIdNumber								=			UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
				String NumberOfLocationWithinCountry				=			UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
				String CompanyReceivedOneMillion					=			UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);
				String CompanyReceivedOneMillionDesc				=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
				String CompanyTradingName							=			UtilFunction.getCellData(filename, sheetName, 40, ColumnCounter);
				String ReceiveDocViaMail							=			UtilFunction.getCellData(filename, sheetName, 41, ColumnCounter);
				String includeSampleCnfrmLetter						=			UtilFunction.getCellData(filename, sheetName, 42, ColumnCounter);
				String UnderCountryName								=			UtilFunction.getCellData(filename, sheetName, 43, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 44, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){

					String FormFieldXpath				=		"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
					String FormFieldsCounterXpath		=		"//*[@id='form1']//*[@class='control-group']//*[@class='controls']";

					if(mode.equals("Edit") || mode.equals("Delete")){

						// clear previous data
						System.out.println("Before updating new data let us clear previous data saved");
						String EditTableCounterXPath			=		"//*[@id='divList']/tbody/tr";
						String EditEntityXPath					=		"//*[@id='divList']/tbody/tr[dd]";
						System.out.println("let us wait for edit lists to populate");
						Thread.sleep(2000);
						int editCount							=		utilfunc.GetObjectCount(EditTableCounterXPath);

						for(int e=1; e<=editCount;e++){
							
							//String EditTableEntityXPath				=		EditEntityXPath.replace("dd", Integer.toString(e))+"/td[1]/a[contains(text(),'qtest')]";
							String EditTableEntityXPath				=		EditEntityXPath.replace("dd", Integer.toString(e))+"/td[1]";
							String EditIconTableXPath				=		EditEntityXPath.replace("dd", Integer.toString(e))+"/td[3]/a[1]/i";
							String DeleteIconTableXPath				=		EditEntityXPath.replace("dd", Integer.toString(e))+"/td[3]/a[2]/i";
							
							System.out.println("========");
							System.out.println(EditTableEntityXPath);
							System.out.println(EditIconTableXPath);
							System.out.println(DeleteIconTableXPath);
							String NewEditTableEntity="";
							try{NewEditTableEntity			=		utilfunc.MakeElement(EditTableEntityXPath).getText();}catch(Exception ee){}
							System.out.println(NewEditTableEntity);
							System.out.println("========");
								System.out.println("Now selecting record that we have to edit..");
								if(NewEditTableEntity.contains("No Data Found!"))
								{
									Flag	=	false;
									utilfunc.ErrorMessage2="";
									utilfunc.ErrorMessage1="";
									utilfunc.ErrorMessage4="";
									utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No record found!";
									return Flag;
								}
								else{
								//if(NewEditTableEntity.equals(EntityName)){

									System.out.println("record found");
									if(mode.equals("Edit")){

										System.out.println("now click on edit icon to edit current record");
										try{Thread.sleep(800);
											utilfunc.MakeElement(EditIconTableXPath).click();
											Thread.sleep(3000);
										}catch(Exception a){
											System.out.println("unable top edit entity record!");
										}
										System.out.println("user has clicked on edit for selected entity");
										break;
									}
									if(mode.equals("Delete")){

										System.out.println("now click on delete icon to delete current record");
										try{
											try{
												Thread.sleep(800);
											utilfunc.MakeElement(DeleteIconTableXPath).click();
											Thread.sleep(800);
											}catch(Exception error){}
											try{
												utilfunc.isAlertPresent();
												Flag=true;
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
												 return Flag;
											}catch(Exception error){}
											
											System.out.println("user has deleted selected record succesfully!");
										}catch(Exception s){
											System.out.println("unable to delete record!");
										}
										break;
									}
							//}
						}
						}

					}else if(mode.equals("New")){
						String AddNewEntityXPath		=		"//*[@class='btn' and text()='Add Entity']";
						utilfunc.MakeElement(AddNewEntityXPath).click();
					}

					// now adding the data

							try{
								System.out.println("now add the data to entity form");
								int rowCount	=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
								for(int r=1;r<=rowCount;r++){
									try{

										Thread.sleep(800);
										String NewXpath="";
										try{
										NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(r));
										}catch(Exception e){}
										String AttributeName="";
										try{AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");}catch(Exception e){}
	System.out.println("---"+AttributeName);

										if(AttributeName.equals("IsPrimary")){
											if(Primary.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement("//input[@name='IsPrimary' and @value='True']").click();
											}else{
												utilfunc.MakeElement("//input[@name='IsPrimary' and @value='False']").click();
											}
										}
										else if(AttributeName.equals("EntityName")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(EntityName);
										}
										else if(AttributeName.equals("NickName")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NickName);
										}
										else if(AttributeName.equals("TypeOfBusinessItemId")){
											utilfunc.Selectdropdownvaluebytext(NewXpath, TypeOfBussiness);
										}
										else if(AttributeName.equals("NumberOfEmployee")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NumberOfEmployess);
										}
										else if(AttributeName.equals("NationalNumberOfEmployee")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NationalNumberOfEmployees);
										}
										
										else if(AttributeName.equals("NetRevenue")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NetRevenues);
										}

										else if(AttributeName.equals("GrossRevenue")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(GrossRevenues);
										}
										else if(AttributeName.equals("DataYear")){
											utilfunc.Selectdropdownvaluebytext(NewXpath, DataYear.replaceAll("\\.0*$", ""));
										}
										else if(AttributeName.equals("NationalTaxId")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(FederalTaxID);
										}
										else if(AttributeName.equals("LocalTaxId")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(StateTaxID);
										}
										else if(AttributeName.equals("YearFound")){
											utilfunc.Selectdropdownvaluebytext(NewXpath, YearFounded.replaceAll("\\.0*$", ""));
										}
										else if(AttributeName.equals("EntityDescription")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(Description);
										}
										else if(AttributeName.equals("NumberOfCitizen")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NumberOfCitizens.replaceAll("\\.0*$", ""));
										}
										else if(AttributeName.equals("NumberOfPermanentResidents")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NoOfLegalPermanentResidents.replaceAll("\\.0*$", ""));
										}
										else if(AttributeName.equals("NumberOfForeignWorkers")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NoOfForeignWorkers.replaceAll("\\.0*$", ""));
										}
										else if(AttributeName.equals("CompanyDescription")){
											try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(CompanyDescription);}
											catch(Exception e){}
										}
										else if(AttributeName.equals("BusinessRegistrationNumber")){
											try{utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BusinessRegistrationNumber);
											}catch(Exception e){}
										}
										else if(AttributeName.equals("HasTransferEmployee")){
										try{
											if(transferredAnEmployee.equalsIgnoreCase("Yes")){
												try{utilfunc.MakeElement("//input[@name='HasTransferEmployee' and @value='True']").click();
												utilfunc.MakeElement("//*[@name='HasTransferEmployeeDesc']").clear();
												utilfunc.MakeElement("//*[@name='HasTransferEmployeeDesc']").sendKeys(transferredAnEmployeeDesc);
												}catch(Exception e){}
											}else{
												try{
												utilfunc.MakeElement("//input[@name='HasTransferEmployee' and @value='False']").click();
												utilfunc.MakeElement("//*[@name='HasTransferEmployeeDesc']").clear();
												}catch(Exception e){}
											}
										}catch(Exception e){}
										}

										else if(AttributeName.equals("CodeNAF")){
											try{utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(CodeNAF);}catch(Exception e){}
										}
										else if(AttributeName.equals("SalaryReference")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(SalaryReference);
										}
										else if(AttributeName.equals("CompanyLegalName")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(CompanyLegalName);
										}
										else if(AttributeName.equals("HasCompanyEmployForeignWorkerTwoYear")){

												if(employedForeignWorkers.equalsIgnoreCase("Yes")){
													utilfunc.MakeElement("//*[@name='HasCompanyEmployForeignWorkerTwoYear' and @value='True']").click();
													utilfunc.MakeElement("//*[@name='HasCompanyEmployForeignWorkerTwoYearDesc']").clear();
													utilfunc.MakeElement("//*[@name='HasCompanyEmployForeignWorkerTwoYearDesc']").sendKeys(employedForeignWorkersDesc);
												}else{
													utilfunc.MakeElement("//*[@name='HasCompanyEmployForeignWorkerTwoYear' and @value='False']").click();
													utilfunc.MakeElement("//*[@name='HasCompanyEmployForeignWorkerTwoYearDesc']").clear();
												}
										}
										else if(AttributeName.equals("WereLaidOffPastTwelveMonth")){
											if(employeesLaidOf.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement("//*[@name='WereLaidOffPastTwelveMonth' and @value='True']").click();
												utilfunc.MakeElement("//*[@name='WereLaidOffPastTwelveMonthDesc']").clear();
												utilfunc.MakeElement("//*[@name='WereLaidOffPastTwelveMonthDesc']").sendKeys(employeesLaidOfDesc);
											}else{
												utilfunc.MakeElement("//*[@name='WereLaidOffPastTwelveMonth' and @value='False']").click();
												utilfunc.MakeElement("//*[@name='WereLaidOffPastTwelveMonthDesc']").clear();
											}
										}
										else if(AttributeName.equals("LicenseDesc")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(licensesHold);
										}
										else if(AttributeName.equals("PercentageOfBusinessOutside")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BusinessConductedOutside);
										}
										else if(AttributeName.equals("TotalCapitalOfCompany")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(TotalCapitalCompany);
										}
										else if(AttributeName.equals("DateIncorporation")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(DateOfIncorporation);
										}
										else if(AttributeName.equals("EmployerIdentificationNumber")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(EmployerIdNumber);
										}
										else if(AttributeName.equals("NumberLocation")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(NumberOfLocationWithinCountry);
										}
										else if(AttributeName.equals("CompanyRecieveMoreOneMillion")){
											System.out.println(NewXpath.toString());
											if(CompanyReceivedOneMillion.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement("//*[@name='CompanyRecieveMoreOneMillion' and @value='True']").click();
												utilfunc.MakeElement("//*[@name='CompanyRecieveMoreOneMillionDesc']").clear();
												utilfunc.MakeElement("//*[@name='CompanyRecieveMoreOneMillionDesc']").sendKeys(CompanyReceivedOneMillionDesc);
											}else{
												utilfunc.MakeElement("//*[@name='CompanyRecieveMoreOneMillion' and @value='False']").click();
												utilfunc.MakeElement("//*[@name='CompanyRecieveMoreOneMillionDesc']").clear();
											}
											utilfunc.scrollToBottom();
										}
										else if(AttributeName.equals("CompanyTradingName")){
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(CompanyTradingName);
										}

										else if(AttributeName.equals("PreferMailOrSecureMessaging")){
											utilfunc.MakeElement(NewXpath).sendKeys(ReceiveDocViaMail);
										}
										else if(AttributeName.equals("SampleEmployerConfirmationLetter")){
											if(includeSampleCnfrmLetter.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement("//*[@name='SampleEmployerConfirmationLetter' and @value='True']").click();
											}
										}
										else if(AttributeName.equals("OrganizedUnderCountryCode")){
											utilfunc.Selectdropdownvaluebytext(NewXpath, UnderCountryName);
											Flag	=	true;
										}
										
									
									}catch(Exception error){}
								}
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to insert data into Company's Add Note form");
							}
					 if(Flag==true){
						 try{
							 // save button after saving all data..
							try{String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		    	        	utilfunc.MakeElement(saveBtn).click();}catch(Exception e){}
	//						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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
							Flag	=	false;
							System.out.println("Data is not saved because all fields are not set in the form.");
						}
					 }
				}
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();


		return Flag;
	}
}
