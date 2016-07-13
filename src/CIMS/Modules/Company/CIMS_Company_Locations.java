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

import org.junit.experimental.categories.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;



public class CIMS_Company_Locations {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	
	public CIMS_Company_Locations(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Locations(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on "+sheetName+" module..");
		boolean Flag	=	false;


		//excel data sheet collection..
				String 	TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String 	TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String 	Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String 	TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String 	CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);

				String	OfficeName									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String	IsHeadquarter								=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String	CompanyOfficeCountryCode					=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
//				String	addressLookup								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String	StreetAddress1								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String	StreetAddress2								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String	StreetAddress3								=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String	City										=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String	StateOrProvince								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String	PostalCode									=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String	numberOfPhone								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String	PhoneNumberType								=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String	PhoneCountryCode							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String	PhoneNumber									=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String	PhoneExtension								=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String	IsPrimaryPhone								=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String	Notes										=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String	IsActive									=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				
				String	EditOfficeName									=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String	EditIsHeadquarter								=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				String	EditCompanyOfficeCountryCode					=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
				String	EditStreetAddress1								=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
				String	EditStreetAddress2								=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
				String	EditStreetAddress3								=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
				String	EditCity										=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
				String	EditStateOrProvince								=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
				String	EditPostalCode									=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
				String	EditnumberOfPhone								=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
				String	EditPhoneNumberType								=			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
				String	EditPhoneCountryCode							=			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
				String	EditPhoneNumber									=			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
				String	EditPhoneExtension								=			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
				String	EditIsPrimaryPhone								=			UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
				String	EditNotes										=			UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
				String	EditIsActive									=			UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);

				
				String 	ExpectedErrorMessage						=			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
			
		
				
				String[]	PhoneNumberTypes= null;
				String[]	PhoneCountryCodes = null;
				String[]	PhoneNumbers = null;
				String[]	PhoneExtensions= null;
				String[]	IsPrimaryPhones= null;
				String[]	EditPhoneNumberTypes= null;
				String[]	EditPhoneCountryCodes= null;
				String[]	EditPhoneNumbers= null;
				String[]	EditPhoneExtensions= null;
				String[]	EditIsPrimaryPhones= null;
				
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					
					
					int numberOfPhoneToAdd=0;
					
					
					
					// converting string to integer
					
					if(numberOfPhone!=null)
					{
					try{
						numberOfPhoneToAdd	=	Integer.parseInt(numberOfPhone);
						System.out.println("conversion from sting to integer is done");
					}catch(Exception e){
						System.out.println("unable to convert integer to string");
						try{
						numberOfPhone			=	numberOfPhone.substring(0, numberOfPhone.length()-2);
						numberOfPhoneToAdd	=	Integer.parseInt(numberOfPhone);
						}catch(Exception error){numberOfPhoneToAdd=0;}
					}
					}
					else
					{
						numberOfPhoneToAdd=0;
					}
					
try{
					// this is for splitting more than one phone numbers.. doing this on top as it is used in Edit & delete case too

				
					
					System.out.println("entering "+mode+" mode for "+sheetName+" module");

					
						if(mode.equals("New")){
							
							try{
								String AddNewBtnXpath	=	"//*[contains(@class,'btn') and contains(text(),'Add New Location')]"; 
								utilfunc.MakeElement(AddNewBtnXpath).click();
								System.out.println("User is now about to add location");
							}catch(Exception e){
								System.out.println("User unable to click on add button");
							}
							
						}else if(mode.equals("Edit") || mode.equals("Delete")){
							

							
							try{
								PhoneNumberTypes	=	PhoneNumberType.trim().split(",");
								PhoneCountryCodes	=	PhoneCountryCode.trim().split(",");
								PhoneNumbers		=	PhoneNumber.trim().split(",");
								PhoneExtensions		=	PhoneExtension.trim().split(",");
								IsPrimaryPhones		=	IsPrimaryPhone.trim().split(",");
								
								// for edit records
								EditPhoneNumberTypes	=	EditPhoneNumberType.trim().split(",");
								EditPhoneCountryCodes	=	EditPhoneCountryCode.trim().split(",");
								EditPhoneNumbers		=	EditPhoneNumber.trim().split(",");
								EditPhoneExtensions		=	EditPhoneExtension.trim().split(",");
								EditIsPrimaryPhones		=	EditIsPrimaryPhone.trim().split(",");
								}catch(Exception error){}
//
							System.out.println("User has entered "+mode+" mode");

							Thread.sleep(1000);

							boolean	EditClicked					=	false;	
							boolean DeleteClicked				=	false;
							
//							//*[@id='dvReport']//*[@class='table-rec-container']//table//tbody//tr[position() mod 2 = 1 and position() > 1]
							String LocationListCounterXPath		=	"//*[@class='table-rec-container']//table[1]//tbody//tr";
							String LocationListXPath				=	"//*[@class='table-rec-container']//table[1]/tbody/tr[yy]";

							int 	rCount	=	utilfunc.GetObjectCount(LocationListCounterXPath);
							
							for(int r=1;r<=rCount;r++){
								Thread.sleep(1000);
								String NewXPath						=	LocationListXPath.replace("yy", Integer.toString(r));
								String LocationList					=	utilfunc.MakeElement(NewXPath+"/td[1]").getText();
								String AddressList					=	utilfunc.MakeElement(NewXPath+"/td[2]").getText();
								String IsHeadquarterList			=	utilfunc.MakeElement(NewXPath+"/td[3]").getText();
								String PhoneNumberList				=	utilfunc.MakeElement(NewXPath+"/td[4]").getText();
								String ActiveList					=	utilfunc.MakeElement(NewXPath+"/td[5]").getText();
								System.out.println("PhoneNumberList.trim()" + PhoneNumberList.trim());
								String Phone						=	PhoneCountryCodes[0]+"- "+PhoneNumbers[0]+" -"+PhoneExtensions[0];
								System.out.println("phone: "+Phone);
								String AddressToMatch				=	StreetAddress1 + " " + StreetAddress2 + " " + StreetAddress3 + " " + City + " " + StateOrProvince + " " + PostalCode + " " + CompanyOfficeCountryCode;
								System.out.println("add : "+AddressToMatch.replaceAll("null ", ""));

								if(OfficeName.equals(LocationList) && IsHeadquarter.equals(IsHeadquarterList) 
									 	&& Phone.equals(PhoneNumberList.trim()) && IsActive.equals(ActiveList)){

										if(mode.equals("Edit")){

											String EditXPath	=	NewXPath+"//td[6]//*[@class='icon-edit']";
											try{
												utilfunc.MakeElement(EditXPath).click();
												EditClicked		=	true;	
												System.out.println("clicked on edit icon");
											}catch(Exception e){
												System.out.println("unable to find edit icon now click on first edit icon from the list");
											}
											break;
										}
										if(mode.equals("Delete")){
											String DeleteXPath	=	NewXPath+"//td[7]//*[@class='icon-trash']";
											try{
												Thread.sleep(2000);
												System.out
														.println("delete path:"+DeleteXPath);
												utilfunc.MakeElement(DeleteXPath).click();
												Thread.sleep(1000);
												DeleteClicked	=	true;
												Thread.sleep(1000);
												System.out.println("clicked on delete icon");
											}catch(Exception e){
												System.out.println("unable to find delete icon, now click on first record for this");
											}
											break;
										}
								}

							}
							/**
							 * in case no record is matched..
							 */
								if(EditClicked==false || DeleteClicked==false){
									if(EditClicked==false){
										if(mode.equals("Edit")){
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(".//*[@id='divList']/table[1]/tbody/tr[1]//td[6]//*[@class='icon-edit']").click();
											}catch(Exception f){
												System.out.println("no edit reocrd found");
											}
										}
									}
									if(DeleteClicked==false){
										if(mode.equals("Delete")){
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(".//*[@id='divList']/table[1]/tbody/tr[1]//td[7]//*[@class='icon-trash']").click();
												System.out
														.println("clicked o");
											}catch(Exception f){
												System.out.println("no delete reocrd found");
											}
										}
									}
								}
							
						}

						if(mode.equals("New")){

							try{
								Thread.sleep(800);
									String InnerFormFieldCounterXPath					=		".//*[@id='form1']//*[@class='control-group']";
									String InnerFormFieldXPath							=		".//*[@id='form1']//*[@class='control-group'][gg]//*[@name]"; //*[@class='controls']
									
									String RadioTrueSufix								=		"//.[@value='True']";
									String RadioFalseSufix								=		"//.[@value='False']";
									String AddressLookUp								=		".//*[@id='autocomplete']";

									if(StreetAddress1!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(StreetAddress1);
										Thread.sleep(500);
									}
									if(StreetAddress2!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+StreetAddress2);
										Thread.sleep(500);
									}
									if(StreetAddress3!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+StreetAddress3);
										Thread.sleep(500);
									}
									if(City!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+City);
										Thread.sleep(500);
									}
									if(StateOrProvince!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+StateOrProvince);
										Thread.sleep(500);
									}
									if(PostalCode!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+CompanyOfficeCountryCode.toLowerCase());
										Thread.sleep(1000);
									}
									// now full address is placed in field and let us select first record
									utilfunc.selectFirstResultFromAutoSuggestion(AddressLookUp);
									
									int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);
	
									for(int r=1;r<=innerCount;r++){


										String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
										String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

										System.out.println(AttributeName);

										if(AttributeName.equals("OfficeName")){
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(OfficeName);
										}
										else if(AttributeName.equals("IsHeadquarter")){
											if(IsHeadquarter.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement(NewFieldXPath+RadioTrueSufix).click();
											}
											else if(IsHeadquarter.equalsIgnoreCase("No")){
												utilfunc.MakeElement(NewFieldXPath+RadioFalseSufix).click();
											}
										}
//										else if(AttributeName.equals("CompanyOfficeCountryCode")){
//											utilfunc.Selectdropdownvaluebyvalue(NewFieldXPath, CompanyOfficeCountryCode);
//
//										}
										else if(AttributeName.equals("StreetAddress1") || AttributeName.equals("StreetAddress2") || 
												AttributeName.equals("City") || AttributeName.equals("PostalCode") || AttributeName.equals("CompanyOfficeCountryCode") ||
												AttributeName.equals("StateOrProvince") || AttributeName.equals("StreetAddress2")){
											continue;
										}
										
										else if(AttributeName.equals("StreetAddress3")){
											
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(StreetAddress3);

//										}else if(AttributeName.equals("City")){
//											
//											utilfunc.MakeElement(NewFieldXPath).clear();
//											utilfunc.MakeElement(NewFieldXPath).sendKeys(City);
//
//										}else if(AttributeName.equals("StateOrProvince")){
//
//											utilfunc.MakeElement(NewFieldXPath).clear();
//											utilfunc.MakeElement(NewFieldXPath).sendKeys(StateOrProvince);
										}else if(AttributeName.equals("PostalCode")){

											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(PostalCode);

										}else if(AttributeName.equals("PhoneNumberType")){
											
											/**
											 * first of all let us find out how many phone numbers we have to add
											 */
											if(numberOfPhoneToAdd>=1){
												
												String AddMoreBtn				=	"//*[@id='grp-phone']//*[@class='lbl-add' and text()='Add More']";
												String phoneRowCounter			=	".//*[@id='grp-phone']//tbody//tr";
												String phoneRowXPath			=	".//*[@id='grp-phone']//tbody//tr[xx]//*[@name]";

												
												for(int n=1;n<=numberOfPhoneToAdd;n++){

													if(n>1){
														// in case we need to click on add more
														utilfunc.MakeElement(AddMoreBtn).click();
														Thread.sleep(400);
														utilfunc.scrollToBottom();
													}
													Thread.sleep(600);

													// now set data for phone numbers and before that let us find out the number of fields in current table
													String NewPhoneRowCounterXPath		=		phoneRowXPath.replace("xx",Integer.toString(n));
													int s								=		utilfunc.GetObjectCount(NewPhoneRowCounterXPath);
													String NewPhoneXPath				=		".//*[@id='grp-phone']//tbody//tr[xx]//td[yy]//*[@name]";
													for(int m=1;m<=s;m++){

														String NewPhoneFieldXPath		=		NewPhoneXPath.replace("yy", Integer.toString(m)).replace("xx", Integer.toString(n));
														System.out.println("new phone attr xpath: "+NewPhoneFieldXPath);
														String PhoneAttributeName		=		utilfunc.MakeElement(NewPhoneFieldXPath).getAttribute("name");
														
														System.out.println("phone attr name: "+PhoneAttributeName);

														if(PhoneAttributeName.equals("PhoneNumberType")){

															utilfunc.Selectdropdownvaluebyvalue(NewPhoneFieldXPath, PhoneNumberTypes[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneCountryCode")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(PhoneCountryCodes[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneNumber")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(PhoneNumbers[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneExtension")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(PhoneExtensions[n-1]);
														}
														else if(PhoneAttributeName.equals("fld-primary-phone")){
//															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															if(IsPrimaryPhones[n-1].equalsIgnoreCase("Yes")){
																utilfunc.MakeElement(NewPhoneFieldXPath).click();
															}
														}
													}
												}
											}

										}else if(AttributeName.equals("Notes")){
											
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(Notes);

										}else if(AttributeName.equals("IsActive")){
											if(IsActive.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewFieldXPath, true);
											}
											else if(IsActive.equalsIgnoreCase("No")){
												utilfunc.enableOrDisableCheckbox(NewFieldXPath, false);
											}
										}
									
									}

								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to excute "+sheetName);
								}
						}
						
						/**
						 * edit case
						 */

						if(mode.equals("Edit")){

							try{
								Thread.sleep(800);
									String InnerFormFieldCounterXPath					=		".//*[@id='form1']//*[@class='control-group']";
									String InnerFormFieldXPath							=		".//*[@id='form1']//*[@class='control-group'][gg]//*[@name]"; //*[@class='controls']
									
									String RadioTrueSufix								=		"//.[@value='True']";
									String RadioFalseSufix								=		"//.[@value='False']";
									String AddressLookUp								=		".//*[@id='autocomplete']";

									if(StreetAddress1!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(EditStreetAddress1);
										Thread.sleep(500);
									}
									if(StreetAddress2!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+EditStreetAddress2);
										Thread.sleep(500);
									}
									if(StreetAddress3!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+EditStreetAddress3);
										Thread.sleep(500);
									}
									if(City!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+EditCity);
										Thread.sleep(500);
									}
									if(StateOrProvince!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+EditStateOrProvince);
										Thread.sleep(500);
									}
									if(PostalCode!=null){
										utilfunc.MakeElement(AddressLookUp).sendKeys(", "+EditCompanyOfficeCountryCode.toLowerCase());
										Thread.sleep(1000);
									}
									// now full address is placed in field and let us select first record
									utilfunc.selectFirstResultFromAutoSuggestion(AddressLookUp);

									int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);
	
									for(int r=1;r<=innerCount;r++){


										String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
										String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

										System.out.println(AttributeName);
										
										if(AttributeName.equals("OfficeName")){
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(EditOfficeName);
										}
										else if(AttributeName.equals("IsHeadquarter")){
											if(EditIsHeadquarter.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement(NewFieldXPath+RadioTrueSufix).click();
											}
											else if(EditIsHeadquarter.equalsIgnoreCase("No")){
												utilfunc.MakeElement(NewFieldXPath+RadioFalseSufix).click();
											}
										}

										else if(AttributeName.equals("StreetAddress1") || AttributeName.equals("StreetAddress2") || 
												AttributeName.equals("City") || AttributeName.equals("PostalCode") || AttributeName.equals("CompanyOfficeCountryCode") ||
												AttributeName.equals("StateOrProvince") || AttributeName.equals("StreetAddress2")){
											continue;
										}
										
										else if(AttributeName.equals("StreetAddress3")){
											
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(EditStreetAddress3);


										}else if(AttributeName.equals("PostalCode")){

											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(EditPostalCode);

										}else if(AttributeName.equals("PhoneNumberType")){

											/**
											 * before adding phone let us delete all phone records present
											 */
											String DeletePhoneNumbersCounterXPath				=		"//*[@id='grp-phone']//tbody//tr";
											String DeletePhoneNumbersXPath						=		"//*[@id='grp-phone']//tbody//tr[1]//td[6]//*[contains(@class,'icon-trash')]";
											int delCounter										=		utilfunc.GetObjectCount(DeletePhoneNumbersCounterXPath);
											for(int d=1;d<=delCounter;d++){
												
//												String NewDeleteIcon					=			DeletePhoneNumbersXPath.replace("xx", Integer.toString(d));
												try{
													utilfunc.MakeElement(DeletePhoneNumbersXPath).click();
													utilfunc.isAlertPresent();
													System.out.println("icon deleted for occurance: "+d);
												}catch(Exception s){
													System.out.println("unable to locate & deleted icon for occurance: "+d);
												}
											}
											
											/**
											 * first of all let us find out how many phone numbers we have to add
											 */
											
											int EditnumberOfPhoneToAdd;
											// converting string to integer
											try{
												EditnumberOfPhoneToAdd	=	Integer.parseInt(EditnumberOfPhone);
												System.out.println("conversion from sting to integer is done");
											}catch(Exception e){
												System.out.println("unable to convert integer to string");
												EditnumberOfPhone			=	EditnumberOfPhone.substring(0, EditnumberOfPhone.length()-2);
												EditnumberOfPhoneToAdd	=	Integer.parseInt(EditnumberOfPhone);
											}
											
											if(EditnumberOfPhoneToAdd>=1){
												
												String AddMoreBtn				=	"//*[@id='grp-phone']//*[@class='lbl-add' and text()='Add More']";

												String phoneRowXPath			=	".//*[@id='grp-phone']//tbody//tr[xx]//*[@name]";


												for(int n=1;n<=numberOfPhoneToAdd;n++){

													if(n>1){
														// in case we need to click on add more
														utilfunc.MakeElement(AddMoreBtn).click();
														Thread.sleep(400);
														utilfunc.scrollToBottom();
													}
													Thread.sleep(600);

													// now set data for phone numbers and before that let us find out the number of fields in current table
													String NewPhoneRowCounterXPath		=		phoneRowXPath.replace("xx",Integer.toString(n));
													int s								=		utilfunc.GetObjectCount(NewPhoneRowCounterXPath);
													String NewPhoneXPath				=		".//*[@id='grp-phone']//tbody//tr[xx]//td[yy]//*[@name]";
													for(int m=1;m<=s;m++){

														String NewPhoneFieldXPath		=		NewPhoneXPath.replace("yy", Integer.toString(m)).replace("xx", Integer.toString(n));
														System.out.println("new phone attr xpath: "+NewPhoneFieldXPath);
														String PhoneAttributeName		=		utilfunc.MakeElement(NewPhoneFieldXPath).getAttribute("name");
														
														System.out.println("phone attr name: "+PhoneAttributeName);

														if(PhoneAttributeName.equals("PhoneNumberType")){

															utilfunc.Selectdropdownvaluebyvalue(NewPhoneFieldXPath, EditPhoneNumberTypes[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneCountryCode")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(EditPhoneCountryCodes[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneNumber")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(EditPhoneNumbers[n-1]);
														}
														else if(PhoneAttributeName.equals("PhoneExtension")){
															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															utilfunc.MakeElement(NewPhoneFieldXPath).sendKeys(EditPhoneExtensions[n-1]);
														}
														else if(PhoneAttributeName.equals("fld-primary-phone")){
//															utilfunc.MakeElement(NewPhoneFieldXPath).clear();
															if(EditIsPrimaryPhones[n-1].equalsIgnoreCase("Yes")){
																utilfunc.MakeElement(NewPhoneFieldXPath).click();
															}
														}
													}
												}
											}

										}else if(AttributeName.equals("Notes")){
											
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(EditNotes);

										}else if(AttributeName.equals("IsActive")){
											if(EditIsActive.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewFieldXPath, true);
											}
											else if(EditIsActive.equalsIgnoreCase("No")){
												utilfunc.enableOrDisableCheckbox(NewFieldXPath, false);
											}
										}
									
									}

								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to excute "+sheetName);
								}
						}
						
						
							 try{
								 // save button after saving all data..
								String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
			    	        	utilfunc.MakeElement(saveBtn).click();
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed");
							 }catch(Exception e){}
							 try{
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
				}catch(Exception e){
					Flag	=	false;

				}
						
				}
//					}
//				}		
							 /**
								 * scroll to top in order to catch the company slider icon
								 */
								utilfunc.scrollToTop();
		return Flag;
	}
}
