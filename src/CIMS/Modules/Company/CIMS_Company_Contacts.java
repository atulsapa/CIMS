package CIMS.Modules.Company;
//**//
import java.util.Random;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.DrivenSeleniumLauncher;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;



public class CIMS_Company_Contacts{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_Company_Contacts(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Contacts(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		//Lokesh code this
		
		System.out.println("User is on "+sheetName+" Module with "+mode+" Mode.");
		boolean Flag	=	false;
		System.out.println("Start getting values form excel sheet. Please wait...");
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);	
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String prefix										=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String firstname									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String firstname_edit								=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String middlename									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String middlename_edit								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String lastname										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String lastname_edit								=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String preferredname								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String employee_number								=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String title										=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String position_level								=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String position_Classification						=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String chatID										=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String ReceiveGlobalCheck							=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String numberOfPhone								=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String Phone_type									=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		String Phone_country								=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String Phone_number									=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		String Phone_ext									=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
		String Phone_primary								=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
		String numberOfEmails								=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
		String Emails										=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
		String Emails_primary								=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
		String numberOfRoles								=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
		String Company_Roles								=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
		String Company_Scope								=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
		String Company_BusinessUnit							=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
		String Company_Country								=			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
		String Company_CountryGroup							=			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
		String Company_Entity								=			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
		System.out.println("Getting values from excel is completed. Now proccess is started...");
		// converting string to integer
		int numberOfPhoneToAdd=0;
		int numberOfEmailsToAdd=0;
		int numberOfRolesToAdd=0;
		try{
			if((StringUtils.isEmpty(numberOfPhone)==false)&&(StringUtils.isEmpty(numberOfEmails)==false)&&(StringUtils.isEmpty(numberOfRoles)==false))
			{
				numberOfPhoneToAdd	=	Integer.parseInt(numberOfPhone);
				numberOfEmailsToAdd = Integer.parseInt(numberOfEmails);
				numberOfRolesToAdd = Integer.parseInt(numberOfRoles);
			}
			
		}
		catch(Exception e){}

		testcaseid			=	TestcaseID;
		scenerio			=	Scenario;
		testcasedescription = Company_Description;
		String error_msg="";
		
		if(TestcaseRunMode.equals("Y"))
		{
			
			if(mode.equalsIgnoreCase("New"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				String newadd_xpath=".//*[@class='btn']";
				Thread.sleep(800);
				utilfunc.MakeElement(newadd_xpath).click();
				Thread.sleep(1000);
				int element_row=utilfunc.GetObjectCount(".//*[@id='form1']//*[contains(@class,'control-group')]");
				String row_xpath=".//*[@id='form1']//*[contains(@class,'control-group')][WWW]//*[@class='controls']//*[@name]";
				for(int i=1;i<=element_row;i++)
				{
					Thread.sleep(800);
					try
					{
						Thread.sleep(500);
						String new_row_xpath	=	row_xpath.replace("WWW", Integer.toString(i));
						String myattributename="";
						try{
							myattributename = utilfunc.MakeElement(new_row_xpath).getAttribute("name");
							System.out.println("---"+myattributename+"---");
						}catch(Exception e){}
						// new we are going to set values
						if (myattributename.equalsIgnoreCase("NamePrefix"))
						{
							if(StringUtils.isEmpty(prefix)==false)
							{
								utilfunc.Selectdropdownvaluebytext(new_row_xpath, prefix);
							}
							else
							{
								utilfunc.DeSelectdropdownvalue(new_row_xpath);
								System.out.println("\nValue -"+prefix+"- is not exists inside the drop down.");
							}
						}
						else if(myattributename.equalsIgnoreCase("FirstName"))
						{
							String Name_xpath1=".//*[@id='form1']//*[contains(@class,'control-group')][2]//*[@class='controls']//div[qqq]//input";
							int name_Count=utilfunc.GetObjectCount(new_row_xpath);
							for(int name=1;name<=name_Count;name++)
							{
								String Name_xpath	=	Name_xpath1.replace("qqq", Integer.toString(name));
								String myattributename1="";
								try{
									myattributename1 = utilfunc.MakeElement(Name_xpath).getAttribute("name");
									System.out.println("---"+myattributename1+"---");
								}catch(Exception e){}

								if(myattributename1.equalsIgnoreCase("FirstName"))
								{
									utilfunc.MakeElement(Name_xpath).sendKeys(firstname);
								}
								else if(myattributename1.equalsIgnoreCase("MiddleName"))
								{
									utilfunc.MakeElement(Name_xpath).sendKeys(middlename);
								}
								else if(myattributename1.equalsIgnoreCase("LastName"))
								{
									utilfunc.MakeElement(Name_xpath).sendKeys(lastname);
								}
							}
						}
						else if(myattributename.equalsIgnoreCase("PreferredName"))
						{
							utilfunc.MakeElement(new_row_xpath).sendKeys(preferredname);
						}
						else if(myattributename.equalsIgnoreCase("EmployeeNumber"))
						{
							utilfunc.MakeElement(new_row_xpath).sendKeys(employee_number);
						}
						else if(myattributename.equalsIgnoreCase("Title"))
						{
							utilfunc.MakeElement(new_row_xpath).sendKeys(title);
						}
						else if(myattributename.equalsIgnoreCase("PositionLevel"))
						{
							if(StringUtils.isEmpty(position_level)==false)
							{
								utilfunc.Selectdropdownvaluebytext(new_row_xpath,position_level);
							}
							else
							{
								utilfunc.DeSelectdropdownvalue(new_row_xpath);
								System.out.println("\nValue -"+position_level+"- is not exists inside the drop down.");
							}
						}
						else if(myattributename.equalsIgnoreCase("PositionClassification"))
						{
							if(StringUtils.isEmpty(position_Classification)==false)
							{
								utilfunc.Selectdropdownvaluebytext(new_row_xpath,position_Classification);
							}
							else
							{
								utilfunc.DeSelectdropdownvalue(new_row_xpath);
								System.out.println("\nValue -"+position_Classification+"- is not exists inside the drop down.");
							}
						}
						else if(myattributename.equalsIgnoreCase("SkypeId"))
						{
							utilfunc.MakeElement(new_row_xpath).sendKeys(chatID);
						}
						else if(myattributename.equalsIgnoreCase("ReceiveVisaQueryNotification"))
						{
							//System.out.println("==="+ReceiveGlobalCheck+"===");
							if(ReceiveGlobalCheck!=null)
							{
								if(ReceiveGlobalCheck.equalsIgnoreCase("true")||ReceiveGlobalCheck.equalsIgnoreCase("yes"))
								{
									utilfunc.MakeElement(new_row_xpath+"[@value='True']").click();
								}
								else if(ReceiveGlobalCheck.equalsIgnoreCase("false")||ReceiveGlobalCheck.equalsIgnoreCase("no"))
								{
									utilfunc.MakeElement(new_row_xpath+"[@value='False']").click();
								}
							}
							else
							{
								System.out.println("\nValue -"+ReceiveGlobalCheck+" is not exists within the radio button.");
							}
						}
						else if(myattributename.equalsIgnoreCase("PhoneNumberType1"))
						{
							/**
							 * first of all let us find out how many phone numbers we have to add
							 */
							if(numberOfPhoneToAdd>=1){

								String AddMoreBtn				=	"//*[@id='grp-phone']//*[@class='lbl-add' and text()='Add More']";
								//String phoneRowCounter			=	".//*[@id='grp-phone']//tbody//tr";
								String phoneRowXPath			=	".//*[@id='grp-phone']//tbody//tr[xx]//*[@name]";
								String mynewxpath				=	".//*[@id='grp-phone']//tbody//tr[xx]//td[yy]//*[@name]";

								String[]	PhoneNumberTypes	=	Phone_type.trim().split(",");
								String[]	PhoneCountryCodes	=	Phone_country.trim().split(",");
								String[]	PhoneNumbers		=	Phone_number.trim().split(",");
								String[]	PhoneExtensions		=	Phone_ext.trim().split(",");
								String[]	IsPrimaryPhones		=	Phone_primary.trim().split(",");

								for(int n=1;n<=numberOfPhoneToAdd;n++){
									Thread.sleep(300);
									System.out.println("  ===> values for "+n+" record.");
									if(n>=2){
										// in case we need to click on add more
										utilfunc.MakeElement(AddMoreBtn).click();
									}
									Thread.sleep(100);
									// now set data for phone numbers and before that let us find out the number of fields in current table
									String NewPhoneRowCounterXPath		=		phoneRowXPath.replace("xx",Integer.toString(n));
									//System.out.println("\n"+NewPhoneRowCounterXPath+"\n");
									int s	=	utilfunc.GetObjectCount(NewPhoneRowCounterXPath);
									for(int m=1;m<=s;m++){
										//Thread.sleep(500);
										String NewPhoneRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(n));
										String NewPhoneRowCounterXPath2= NewPhoneRowCounterXPath1.replace("yy", Integer.toString(m));
										String PhoneAttributeName		=		utilfunc.MakeElement(NewPhoneRowCounterXPath2).getAttribute("name");
										if(PhoneAttributeName.equals("PhoneNumberType1")){
											System.out.println("  ---"+PhoneNumberTypes[(n-1)]+"---");
											utilfunc.Selectdropdownvaluebytext(NewPhoneRowCounterXPath2, PhoneNumberTypes[(n-1)]);
										}
										else if(PhoneAttributeName.equals("PhoneCountryCode")){
											System.out.println("  ---"+PhoneCountryCodes[(n-1)]+"---");
											utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneCountryCodes[(n-1)]);
										}
										else if(PhoneAttributeName.equals("PhoneNumber")){
											System.out.println("  ---"+PhoneNumbers[(n-1)]+"---");
											utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneNumbers[(n-1)]);
										}
										else if(PhoneAttributeName.equals("PhoneExtension")){
											System.out.println("  ---"+PhoneExtensions[(n-1)]+"---");
											utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneExtensions[(n-1)]);
										}
										else if(PhoneAttributeName.equals("fld-primary-phone")){
											System.out.println("  ---"+IsPrimaryPhones[(n-1)]+"---");
											if((IsPrimaryPhones[(n-1)]).equalsIgnoreCase("yes")||(IsPrimaryPhones[(n-1)]).equalsIgnoreCase("true"))
											{
												utilfunc.MakeElement(NewPhoneRowCounterXPath2).click();
											}
											else{}
										}
									}
								}
							}

						}
						else if(myattributename.equalsIgnoreCase("Email"))
						{
							/**
							 * first of all let us find out how many Email(s) we have to add
							 */
							if(numberOfEmailsToAdd>=1){

								String AddMoreBtn				=	"//*[@id='grp-email']//*[@class='lbl-add' and text()='Add More']";
								//String emailRowCounter			=	".//*[@id='grp-email']//tbody//tr";
								String emailRowXPath			=	".//*[@id='grp-email']//tbody//tr[xx]//*[@name]";
								String mynewxpath				=	".//*[@id='grp-email']//tbody//tr[xx]//td[yy]//*[@name]";

								String[]	emails				=	Emails.trim().split(",");
								String[]	IsPrimaryemails		=	Emails_primary.trim().split(",");

								for(int n=1;n<=numberOfEmailsToAdd;n++){
									Thread.sleep(300);
									System.out.println("  ===> values for "+n+" record.");
									if(n>=2)
									{	// in case we need to click on add more
										utilfunc.MakeElement(AddMoreBtn).click();
									}
									Thread.sleep(100);

									// now set data for phone numbers and before that let us find out the number of fields in current table
									String NewemailRowCounterXPath		=		emailRowXPath.replace("xx",Integer.toString(n));
									//System.out.println("\n"+NewemailRowCounterXPath+"\n");
									int s	=	utilfunc.GetObjectCount(NewemailRowCounterXPath);
									for(int m=1;m<=s;m++){
										//Thread.sleep(500);
										String emailRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(n));
										String emailRowCounterXPath2= emailRowCounterXPath1.replace("yy", Integer.toString(m));
										//System.out.println(emailRowCounterXPath2);
										//									String NewPhoneFieldXPath		=		utilfunc.MakeElement(NewPhoneRowCounterXPath);
										String EmailAttributeName		=		utilfunc.MakeElement(emailRowCounterXPath2).getAttribute("name");
										//System.out.println(EmailAttributeName);
										if(EmailAttributeName.equals("Email")){
											System.out.println("  ---"+emails[(n-1)]+"---");
											utilfunc.MakeElement(emailRowCounterXPath2).sendKeys(emails[(n-1)]);
										}
										else if(EmailAttributeName.equals("fld-primary-email")){
											System.out.println("  ---"+IsPrimaryemails[(n-1)]+"---");
											if((IsPrimaryemails[(n-1)]).equalsIgnoreCase("yes")||(IsPrimaryemails[(n-1)]).equalsIgnoreCase("true"))
											{
												utilfunc.MakeElement(emailRowCounterXPath2).click();
											}
											else{}
										}
									}//for loop m ends here
								}//for loop n ends here
							}//if(numberOfEmailsToAdd>=1){ ends here
						}//else if(myattributename.equalsIgnoreCase("Email")) ends here
					}//try ends here
					catch(Exception error){System.out.println("Some Error occured during filling the form."+error);}	

				}
				//Company Roles Add More
				try
				{
					System.out.println("---Roles---");

					/**
					 * first of all let us find out how many Roles we have to add
					 */
					if(numberOfRolesToAdd>=1){

						String AddMoreBtn				=	"//*[@id='lnk-addroles' and text()='Add More']";
						//String RoleRowCounter			=	".//*[@id="form_modal"]//*[@class='control-group'][2]//*[@class='controls']";
						String RoleRowXPath				=	".//*[@id='form_modal']//*[@class='control-group']//*[@class='controls']";
						String mynewxpath				=	".//*[@id='form_modal']//*[@class='control-group'][xx]//*[@class='controls']//*[@name]";

						String[]	Company_Roles1			=	Company_Roles.trim().split(",");
						String[]    Company_Scope1			=	Company_Scope.trim().split(",");
						String[]	Company_BusinessUnit1	=	Company_BusinessUnit.trim().split(",");
						String[]    Company_Country1		=	Company_Country.trim().split(",");
						String[]    Company_CountryGroup1	=	Company_CountryGroup.trim().split(",");
						String[]    Company_Entity1			=	Company_Entity.trim().split(",");

						utilfunc.MakeElement(AddMoreBtn).click();

						for(int n=1;n<=numberOfRolesToAdd;n++){
							Thread.sleep(300);
							System.out.println("  ===> values for "+n+" record.");
							if(n>=2){
								// in case we need to click on add more
								utilfunc.MakeElement(AddMoreBtn).click();
							}
							Thread.sleep(100);

							// now set data for phone numbers and before that let us find out the number of fields in current table
							//String NewRoleRowCounterXPath		=		RoleRowXPath.replace("xx",Integer.toString(n));
							//System.out.println("\n"+NewRoleRowCounterXPath+"\n");
							int s	=	utilfunc.GetObjectCount(RoleRowXPath);
							String Company_Scope2="";
							for(int m=1;m<=s;m++){
								//Thread.sleep(500);
								String RoleRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(m));
								//String RoleRowCounterXPath2= RoleRowCounterXPath1.replace("yy", Integer.toString(m));
								//System.out.println(RoleRowCounterXPath1);

								//							String NewPhoneFieldXPath		=		utilfunc.MakeElement(NewPhoneRowCounterXPath);
								String myattributename		=		utilfunc.MakeElement(RoleRowCounterXPath1).getAttribute("name");

								if(myattributename.equalsIgnoreCase("mRole"))
								{
									if(StringUtils.isEmpty(Company_Roles1[(n-1)])==false)
									{
										System.out.println("  ---"+Company_Roles1[(n-1)]+"---");
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, Company_Roles1[(n-1)]);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+Company_Roles1[(n-1)]+"- is not exists inside the drop down.");
									}
								}
								else if(myattributename.equalsIgnoreCase("mRoleScope"))
								{
									if(StringUtils.isEmpty(Company_Scope1[(n-1)])==false)
									{
										System.out.println("  ---"+Company_Scope1[(n-1)]+"---");
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, Company_Scope1[(n-1)]);
										Company_Scope2=Company_Scope1[(n-1)];
										//System.out.println("+"+Company_Scope2+"+");
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+Company_Scope1[(n-1)]+"- is not exists inside the drop down.");
									}
								}
								else if((myattributename.equalsIgnoreCase("mEntity"))&&(Company_Scope2.equalsIgnoreCase("Entity")))
								{
									String enTiTy=Company_Entity1[(n-1)];
									System.out.println("---"+enTiTy+"---");
									if(StringUtils.isEmpty(enTiTy)==false)
									{
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, enTiTy);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+enTiTy+"- is not exists inside the drop down.");
									}
								}
								else if((myattributename.equalsIgnoreCase("mBusinessUnit"))&&(Company_Scope2.equalsIgnoreCase("Business Unit")))
								{
									String businessunit=Company_BusinessUnit1[(n-1)]; 
									System.out.println("---"+businessunit+"---");
									if(StringUtils.isEmpty(businessunit)==false)
									{
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, businessunit);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+businessunit+"- is not exists inside the drop down.");
									}
								}
								else if((myattributename.equalsIgnoreCase("mCountry"))&&(Company_Scope2.equalsIgnoreCase("Country")))
								{
									String coUnTrY=Company_Country1[(n-1)]; 
									System.out.println("---"+coUnTrY+"---");
									if(StringUtils.isEmpty(coUnTrY)==false)
									{
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, coUnTrY);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+coUnTrY+"- is not exists inside the drop down.");
									}
								}
								else if((myattributename.equalsIgnoreCase("mCountryGroup"))&&(Company_Scope2.equalsIgnoreCase("Country Group")))
								{
									String countryGrOuP=Company_CountryGroup1[(n-1)]; 
									System.out.println("---"+countryGrOuP+"---");
									if(StringUtils.isEmpty(countryGrOuP)==false)
									{
										utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, countryGrOuP);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
										System.out.println("\nValue -"+countryGrOuP+"- is not exists inside the drop down.");
									}
								}
								else{continue;}
							}
							utilfunc.MakeElement(".//*[@class='icon-plus icon-white']").click();
							Thread.sleep(1000);
						}
					}


					//				int ElementCountOnPopUP=utilfunc.GetObjectCount(".//*[@id='form_modal']//*[@class='control-group']");
					//				String PopUp_xpath=".//*[@id='form_modal']//*[@class='control-group'][WWW]//*[@class='controls']//*[@name]";
					//				for(int i=1;i<=ElementCountOnPopUP;i++)
					//				{
					//					String PopUp_xpath1=PopUp_xpath.replace("WWW", Integer.toString(i));
					//					String myattributename="";
					//					try{
					//						myattributename = utilfunc.MakeElement(PopUp_xpath1).getAttribute("name");
					//						System.out.println("---"+myattributename+"---");
					//					}catch(Exception e){}
					//					if(myattributename.equalsIgnoreCase("mRole"))
					//					{
					//						if(StringUtils.isEmpty(Company_Roles)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Roles);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_Roles+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else if(myattributename.equalsIgnoreCase("mRoleScope"))
					//					{
					//						if(StringUtils.isEmpty(Company_Scope)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Scope);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_Scope+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else if((myattributename.equalsIgnoreCase("mEntity"))&&(Company_Scope.equalsIgnoreCase("Entity")))
					//					{
					//						if(StringUtils.isEmpty(Company_Entity)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Entity);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_Entity+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else if((myattributename.equalsIgnoreCase("mBusinessUnit"))&&(Company_Scope.equalsIgnoreCase("business unit")))
					//					{
					//						if(StringUtils.isEmpty(Company_BusinessUnit)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_BusinessUnit);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_BusinessUnit+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else if((myattributename.equalsIgnoreCase("mCountry"))&&(Company_Scope.equalsIgnoreCase("Country")))
					//					{
					//						if(StringUtils.isEmpty(Company_Country)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Country);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_Country+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else if((myattributename.equalsIgnoreCase("mCountryGroup"))&&(Company_Scope.equalsIgnoreCase("country group")))
					//					{
					//						if(StringUtils.isEmpty(Company_CountryGroup)==false)
					//						{
					//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_CountryGroup);
					//						}
					//						else
					//						{
					//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
					//							System.out.println("\nValue -"+Company_CountryGroup+"- is not exists inside the drop down.");
					//						}
					//					}
					//					else{continue;}
					//				}
					//Add Role (on Popup window) (save)
					//utilfunc.MakeElement(".//*[@class='icon-plus icon-white']").click();


				}
				catch(Exception error){
					System.out.println("Some Error occured during Assign Role on popup window.");
					utilfunc.TakeScreenshot();
					Flag=false;
					return Flag;
					}

				try{
					Thread.sleep(1000);
					String saveBtn	=	".//*[@class='icon-pencil icon-white']";
					utilfunc.MakeElement(saveBtn).click();
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
					String  error_flag="";
					try{
						error_flag=utilfunc.ErrorMessagehandlerExperiment();}
					catch(Exception e){}
					Thread.sleep(1000);
					System.out.println("error_flag is :"+error_flag);
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
				}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}

			}
			if(mode.equalsIgnoreCase("Edit"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				System.out.println("search ....");
				String search_name=lastname+","+firstname+" "+middlename;
				utilfunc.MakeElement(".//*[@id='SearchText']").sendKeys(search_name);
				Thread.sleep(500);
				utilfunc.MakeElement(".//*[@id='btnSearch']").click();
				Thread.sleep(1000);
				String recordFoundOrNot=utilfunc.MakeElement(".//*[@class='table table-item-list']//tbody//tr[1]//td[1]").getText();
				if(recordFoundOrNot.equalsIgnoreCase("No Data Found!"))
				{
					error_msg="No Data Found!";
					utilfunc.globalerrormessage=error_msg;
					utilfunc.ErrorMessage4=error_msg;
					utilfunc.TakeScreenshot();
					Flag=false;
					return Flag;
				}
				else
				{
					utilfunc.MakeElement(".//*[@id='divList']/table/tbody/tr[1]//*[@class='icon-edit']").click();
					Thread.sleep(1000);
					int element_row=utilfunc.GetObjectCount(".//*[@id='form1']//*[contains(@class,'control-group')]");
					String row_xpath=".//*[@id='form1']//*[contains(@class,'control-group')][WWW]//*[@class='controls']//*[@name]";
					for(int i=1;i<=element_row;i++)
					{
						try
						{
							Thread.sleep(500);
							String new_row_xpath	=	row_xpath.replace("WWW", Integer.toString(i));
							String myattributename="";
							try{
								myattributename = utilfunc.MakeElement(new_row_xpath).getAttribute("name");
								System.out.println("---"+myattributename+"---");
							}catch(Exception e){}
							// new we are going to set values
							if (myattributename.equalsIgnoreCase("NamePrefix"))
							{
								if(StringUtils.isEmpty(prefix)==false)
								{
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.Selectdropdownvaluebytext(new_row_xpath, prefix);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(new_row_xpath);
									System.out.println("\nValue -"+prefix+"- is not exists inside the drop down.");
								}
							}
							else if(myattributename.equalsIgnoreCase("FirstName"))
							{
								String Name_xpath1=".//*[@id='form1']//*[contains(@class,'control-group')][2]//*[@class='controls']//div[qqq]//input";
								int name_Count=utilfunc.GetObjectCount(new_row_xpath);
								for(int name=1;name<=name_Count;name++)
								{
									String Name_xpath	=	Name_xpath1.replace("qqq", Integer.toString(name));
									String myattributename1="";
									try{
										myattributename1 = utilfunc.MakeElement(Name_xpath).getAttribute("name");
										System.out.println("---"+myattributename1+"---");
									}catch(Exception e){}

									if(myattributename1.equalsIgnoreCase("FirstName"))
									{
										utilfunc.MakeElement(Name_xpath).clear();
										utilfunc.MakeElement(Name_xpath).sendKeys(firstname_edit);
									}
									else if(myattributename1.equalsIgnoreCase("MiddleName"))
									{
										utilfunc.MakeElement(Name_xpath).clear();
										utilfunc.MakeElement(Name_xpath).sendKeys(middlename_edit);
									}
									else if(myattributename1.equalsIgnoreCase("LastName"))
									{
										utilfunc.MakeElement(Name_xpath).clear();
										utilfunc.MakeElement(Name_xpath).sendKeys(lastname_edit);
									}
								}
							}
							else if(myattributename.equalsIgnoreCase("PreferredName"))
							{
								utilfunc.MakeElement(new_row_xpath).clear();
								utilfunc.MakeElement(new_row_xpath).sendKeys(preferredname);
							}
							else if(myattributename.equalsIgnoreCase("EmployeeNumber"))
							{
								utilfunc.MakeElement(new_row_xpath).clear();
								utilfunc.MakeElement(new_row_xpath).sendKeys(employee_number);
							}
							else if(myattributename.equalsIgnoreCase("Title"))
							{
								utilfunc.MakeElement(new_row_xpath).clear();
								utilfunc.MakeElement(new_row_xpath).sendKeys(title);
							}
							else if(myattributename.equalsIgnoreCase("PositionLevel"))
							{
								if(StringUtils.isEmpty(position_level)==false)
								{
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.Selectdropdownvaluebytext(new_row_xpath,position_level);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(new_row_xpath);
									System.out.println("\nValue -"+position_level+"- is not exists inside the drop down.");
								}
							}
							else if(myattributename.equalsIgnoreCase("PositionClassification"))
							{
								if(StringUtils.isEmpty(position_Classification)==false)
								{
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.Selectdropdownvaluebytext(new_row_xpath,position_Classification);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(new_row_xpath);
									System.out.println("\nValue -"+position_Classification+"- is not exists inside the drop down.");
								}
							}
							else if(myattributename.equalsIgnoreCase("SkypeId"))
							{
								utilfunc.MakeElement(new_row_xpath).clear();
								utilfunc.MakeElement(new_row_xpath).sendKeys(chatID);
							}
							else if(myattributename.equalsIgnoreCase("ReceiveVisaQueryNotification"))
							{
								//System.out.println("==="+ReceiveGlobalCheck+"===");
								if(ReceiveGlobalCheck!=null)
								{
									if(ReceiveGlobalCheck.equalsIgnoreCase("true")||ReceiveGlobalCheck.equalsIgnoreCase("yes"))
									{
										utilfunc.MakeElement(new_row_xpath+"[@value='True']").click();
									}
									else if(ReceiveGlobalCheck.equalsIgnoreCase("false")||ReceiveGlobalCheck.equalsIgnoreCase("no"))
									{
										utilfunc.MakeElement(new_row_xpath+"[@value='False']").click();
									}
								}
								else
								{
									System.out.println("\nValue -"+ReceiveGlobalCheck+" is not exists within the radio button.");
								}
							}
							else if(myattributename.equalsIgnoreCase("PhoneNumberType1"))
							{
								/**
								 * first of all let us find out how many phone numbers we have to add
								 */
								if(numberOfPhoneToAdd>=1){

									String AddMoreBtn				=	"//*[@id='grp-phone']//*[@class='lbl-add' and text()='Add More']";
									String phoneRowCounter			=	".//*[@id='grp-phone']//tbody//tr";
									String phoneRowXPath			=	".//*[@id='grp-phone']//tbody//tr[xx]//*[@name]";
									String mynewxpath				=	".//*[@id='grp-phone']//tbody//tr[xx]//td[yy]//*[@name]";

									String[]	PhoneNumberTypes	=	Phone_type.trim().split(",");
									String[]	PhoneCountryCodes	=	Phone_country.trim().split(",");
									String[]	PhoneNumbers		=	Phone_number.trim().split(",");
									String[]	PhoneExtensions		=	Phone_ext.trim().split(",");
									String[]	IsPrimaryPhones		=	Phone_primary.trim().split(",");

									//before edit(add New values) delete last added values
									System.out.println("We are going to delete all previous added phone numbers. Please wait... ... ...");
									int del_pre_value=utilfunc.GetObjectCount(phoneRowCounter);
									String del_pre_icon=".//*[@id='grp-phone']//tbody//tr[1]//*[@class='icon-trash icon-muted']";
									for(int del_i=1;del_i<=del_pre_value;del_i++)
									{
										//Thread.sleep(600);
										utilfunc.MakeElement(del_pre_icon).click();
										Thread.sleep(300);
										Alert alt= webdriver.switchTo().alert();
										alt.accept();
									}
									System.out.println("All previous added phone numbers are delete!!!");

									for(int n=1;n<=numberOfPhoneToAdd;n++){
										Thread.sleep(300);
										System.out.println("  ===> values for "+n+" record.");
										if(n>=2){
											// in case we need to click on add more
											utilfunc.MakeElement(AddMoreBtn).click();
										}
										Thread.sleep(100);
										// now set data for phone numbers and before that let us find out the number of fields in current table
										String NewPhoneRowCounterXPath		=		phoneRowXPath.replace("xx",Integer.toString(n));
										//System.out.println("\n"+NewPhoneRowCounterXPath+"\n");
										int s	=	utilfunc.GetObjectCount(NewPhoneRowCounterXPath);
										for(int m=1;m<=s;m++){
											//											Thread.sleep(500);
											String NewPhoneRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(n));
											String NewPhoneRowCounterXPath2= NewPhoneRowCounterXPath1.replace("yy", Integer.toString(m));
											String PhoneAttributeName		=		utilfunc.MakeElement(NewPhoneRowCounterXPath2).getAttribute("name");
											if(PhoneAttributeName.equals("PhoneNumberType1")){
												System.out.println("  ---"+PhoneNumberTypes[(n-1)]+"---");
												utilfunc.Selectdropdownvaluebytext(NewPhoneRowCounterXPath2, PhoneNumberTypes[(n-1)]);
											}
											else if(PhoneAttributeName.equals("PhoneCountryCode")){
												System.out.println("  ---"+PhoneCountryCodes[(n-1)]+"---");
												utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneCountryCodes[(n-1)]);
											}
											else if(PhoneAttributeName.equals("PhoneNumber")){
												System.out.println("  ---"+PhoneNumbers[(n-1)]+"---");
												utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneNumbers[(n-1)]);
											}
											else if(PhoneAttributeName.equals("PhoneExtension")){
												System.out.println("  ---"+PhoneExtensions[(n-1)]+"---");
												utilfunc.MakeElement(NewPhoneRowCounterXPath2).sendKeys(PhoneExtensions[(n-1)]);
											}
											else if(PhoneAttributeName.equals("fld-primary-phone")){
												System.out.println("  ---"+IsPrimaryPhones[(n-1)]+"---");
												if((IsPrimaryPhones[(n-1)]).equalsIgnoreCase("yes")||(IsPrimaryPhones[(n-1)]).equalsIgnoreCase("true"))
												{
													utilfunc.MakeElement(NewPhoneRowCounterXPath2).click();
												}
												else{}
											}
										}
									}
								}

							}
							else if(myattributename.equalsIgnoreCase("Email"))
							{
								/**
								 * first of all let us find out how many Email(s) we have to add
								 */
								if(numberOfEmailsToAdd>=1){

									String AddMoreBtn				=	"//*[@id='grp-email']//*[@class='lbl-add' and text()='Add More']";
									String emailRowCounter			=	".//*[@id='grp-email']//tbody//tr";
									String emailRowXPath			=	".//*[@id='grp-email']//tbody//tr[xx]//*[@name]";
									String mynewxpath				=	".//*[@id='grp-email']//tbody//tr[xx]//td[yy]//*[@name]";

									String[]	emails				=	Emails.trim().split(",");
									String[]	IsPrimaryemails		=	Emails_primary.trim().split(",");

									//before edit(add New values) delete last added values
									System.out.println("We are going to delete all previous added emails. Please wait... ... ...");
									int del_pre_value=utilfunc.GetObjectCount(emailRowCounter);
									String del_pre_icon=".//*[@id='grp-email']//tbody//tr[1]//*[@class='icon-trash icon-muted']";
									for(int del_i=1;del_i<=del_pre_value;del_i++)
									{
										//Thread.sleep(600);
										utilfunc.MakeElement(del_pre_icon).click();
										Thread.sleep(300);
										Alert alt= webdriver.switchTo().alert();
										alt.accept();
									}
									System.out.println("All previous added emails are delete!!!");

									for(int n=1;n<=numberOfEmailsToAdd;n++){
										Thread.sleep(300);
										System.out.println("  ===> values for "+n+" record.");
										if(n>=2)
										{	// in case we need to click on add more
											utilfunc.MakeElement(AddMoreBtn).click();
										}
										Thread.sleep(100);

										// now set data for phone numbers and before that let us find out the number of fields in current table
										String NewemailRowCounterXPath		=		emailRowXPath.replace("xx",Integer.toString(n));
										//System.out.println("\n"+NewemailRowCounterXPath+"\n");
										int s	=	utilfunc.GetObjectCount(NewemailRowCounterXPath);
										for(int m=1;m<=s;m++){
											//Thread.sleep(500);
											String emailRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(n));
											String emailRowCounterXPath2= emailRowCounterXPath1.replace("yy", Integer.toString(m));
											//System.out.println(emailRowCounterXPath2);
											//									String NewPhoneFieldXPath		=		utilfunc.MakeElement(NewPhoneRowCounterXPath);
											String EmailAttributeName		=		utilfunc.MakeElement(emailRowCounterXPath2).getAttribute("name");
											//System.out.println(EmailAttributeName);
											if(EmailAttributeName.equals("Email")){
												System.out.println("  ---"+emails[(n-1)]+"---");
												utilfunc.MakeElement(emailRowCounterXPath2).sendKeys(emails[(n-1)]);
											}
											else if(EmailAttributeName.equals("fld-primary-email")){
												System.out.println("  ---"+IsPrimaryemails[(n-1)]+"---");
												if((IsPrimaryemails[(n-1)]).equalsIgnoreCase("yes")||(IsPrimaryemails[(n-1)]).equalsIgnoreCase("true"))
												{
													utilfunc.MakeElement(emailRowCounterXPath2).click();
												}
												else{}
											}
										}//for loop m ends here
									}//for loop n ends here
								}//if(numberOfEmailsToAdd>=1){ ends here
							}//else if(myattributename.equalsIgnoreCase("Email")) ends here
						}//try ends here
						catch(Exception error){System.out.println("Some Error occured during filling the form."+error);}	

					}
					//Company Roles Add More
					try
					{
						System.out.println("---Roles---");

						/**
						 * first of all let us find out how many Roles we have to add
						 */
						if(numberOfRolesToAdd>=1){

							String AddMoreBtn				=	"//*[@id='lnk-addroles' and text()='Add More']";
							String RoleRowCounter			=	".//*[@id='roleassignment_div']/tbody/tr";
							String RoleRowXPath				=	".//*[@id='form_modal']//*[@class='control-group']//*[@class='controls']";
							String mynewxpath				=	".//*[@id='form_modal']//*[@class='control-group'][xx]//*[@class='controls']//*[@name]";

							String[]	Company_Roles1			=	Company_Roles.trim().split(",");
							String[]    Company_Scope1			=	Company_Scope.trim().split(",");
							String[]	Company_BusinessUnit1	=	Company_BusinessUnit.trim().split(",");
							String[]    Company_Country1		=	Company_Country.trim().split(",");
							String[]    Company_CountryGroup1	=	Company_CountryGroup.trim().split(",");
							String[]    Company_Entity1			=	Company_Entity.trim().split(",");

							//before edit(add New values) delete last added values
							System.out.println("We are going to delete all previous added roles. Please wait... ... ...");
							int del_pre_value=utilfunc.GetObjectCount(RoleRowCounter);
							String del_pre_icon=".//*[@id='roleassignment_div']/tbody/tr[2]//*[@class='icon-trash icon-muted']";
							for(int del_i=2;del_i<=del_pre_value;del_i++)
							{
								//Thread.sleep(600);
								utilfunc.MakeElement(del_pre_icon).click();
								Thread.sleep(300);
								Alert alt= webdriver.switchTo().alert();
								alt.accept();
							}
							System.out.println("All previous added roles are delete!!!");

							utilfunc.MakeElement(AddMoreBtn).click();

							for(int n=1;n<=numberOfRolesToAdd;n++){
								Thread.sleep(300);
								System.out.println("  ===> values for "+n+" record.");
								if(n>=2){
									// in case we need to click on add more
									utilfunc.MakeElement(AddMoreBtn).click();
								}
								Thread.sleep(100);

								// now set data for phone numbers and before that let us find out the number of fields in current table
								//String NewRoleRowCounterXPath		=		RoleRowXPath.replace("xx",Integer.toString(n));
								//System.out.println("\n"+NewRoleRowCounterXPath+"\n");
								int s	=	utilfunc.GetObjectCount(RoleRowXPath);
								String Company_Scope2="";
								for(int m=1;m<=s;m++){
									//Thread.sleep(500);
									String RoleRowCounterXPath1= mynewxpath.replace("xx", Integer.toString(m));
									//String RoleRowCounterXPath2= RoleRowCounterXPath1.replace("yy", Integer.toString(m));
									//System.out.println(RoleRowCounterXPath1);

									//							String NewPhoneFieldXPath		=		utilfunc.MakeElement(NewPhoneRowCounterXPath);
									String myattributename		=		utilfunc.MakeElement(RoleRowCounterXPath1).getAttribute("name");

									if(myattributename.equalsIgnoreCase("mRole"))
									{
										if(StringUtils.isEmpty(Company_Roles1[(n-1)])==false)
										{
											System.out.println("  ---"+Company_Roles1[(n-1)]+"---");
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, Company_Roles1[(n-1)]);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+Company_Roles1[(n-1)]+"- is not exists inside the drop down.");
										}
									}
									else if(myattributename.equalsIgnoreCase("mRoleScope"))
									{
										if(StringUtils.isEmpty(Company_Scope1[(n-1)])==false)
										{
											System.out.println("  ---"+Company_Scope1[(n-1)]+"---");
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, Company_Scope1[(n-1)]);
											Company_Scope2=Company_Scope1[(n-1)];
											System.out.println("+"+Company_Scope2+"+");
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+Company_Scope1[(n-1)]+"- is not exists inside the drop down.");
										}
									}
									else if((myattributename.equalsIgnoreCase("mEntity"))&&(Company_Scope2.equalsIgnoreCase("Entity")))
									{
										String enTiTy=Company_Entity1[(n-1)];
										System.out.println("---"+enTiTy+"---");
										if(StringUtils.isEmpty(enTiTy)==false)
										{
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, enTiTy);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+enTiTy+"- is not exists inside the drop down.");
										}
									}
									else if((myattributename.equalsIgnoreCase("mBusinessUnit"))&&(Company_Scope2.equalsIgnoreCase("Business Unit")))
									{
										String businessunit=Company_BusinessUnit1[(n-1)]; 
										System.out.println("---"+businessunit+"---");
										if(StringUtils.isEmpty(businessunit)==false)
										{
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, businessunit);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+businessunit+"- is not exists inside the drop down.");
										}
									}
									else if((myattributename.equalsIgnoreCase("mCountry"))&&(Company_Scope2.equalsIgnoreCase("Country")))
									{
										String coUnTrY=Company_Country1[(n-1)]; 
										System.out.println("---"+coUnTrY+"---");
										if(StringUtils.isEmpty(coUnTrY)==false)
										{
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, coUnTrY);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+coUnTrY+"- is not exists inside the drop down.");
										}
									}
									else if((myattributename.equalsIgnoreCase("mCountryGroup"))&&(Company_Scope2.equalsIgnoreCase("Country Group")))
									{
										String countryGrOuP=Company_CountryGroup1[(n-1)]; 
										System.out.println("---"+countryGrOuP+"---");
										if(StringUtils.isEmpty(countryGrOuP)==false)
										{
											utilfunc.Selectdropdownvaluebytext(RoleRowCounterXPath1, countryGrOuP);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(RoleRowCounterXPath1);
											System.out.println("\nValue -"+countryGrOuP+"- is not exists inside the drop down.");
										}
									}
									else{continue;}
								}
								utilfunc.MakeElement(".//*[@class='icon-plus icon-white']").click();
								Thread.sleep(1000);
							}
						}


						//				int ElementCountOnPopUP=utilfunc.GetObjectCount(".//*[@id='form_modal']//*[@class='control-group']");
						//				String PopUp_xpath=".//*[@id='form_modal']//*[@class='control-group'][WWW]//*[@class='controls']//*[@name]";
						//				for(int i=1;i<=ElementCountOnPopUP;i++)
						//				{
						//					String PopUp_xpath1=PopUp_xpath.replace("WWW", Integer.toString(i));
						//					String myattributename="";
						//					try{
						//						myattributename = utilfunc.MakeElement(PopUp_xpath1).getAttribute("name");
						//						System.out.println("---"+myattributename+"---");
						//					}catch(Exception e){}
						//					if(myattributename.equalsIgnoreCase("mRole"))
						//					{
						//						if(StringUtils.isEmpty(Company_Roles)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Roles);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_Roles+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else if(myattributename.equalsIgnoreCase("mRoleScope"))
						//					{
						//						if(StringUtils.isEmpty(Company_Scope)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Scope);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_Scope+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else if((myattributename.equalsIgnoreCase("mEntity"))&&(Company_Scope.equalsIgnoreCase("Entity")))
						//					{
						//						if(StringUtils.isEmpty(Company_Entity)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Entity);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_Entity+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else if((myattributename.equalsIgnoreCase("mBusinessUnit"))&&(Company_Scope.equalsIgnoreCase("business unit")))
						//					{
						//						if(StringUtils.isEmpty(Company_BusinessUnit)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_BusinessUnit);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_BusinessUnit+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else if((myattributename.equalsIgnoreCase("mCountry"))&&(Company_Scope.equalsIgnoreCase("Country")))
						//					{
						//						if(StringUtils.isEmpty(Company_Country)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_Country);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_Country+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else if((myattributename.equalsIgnoreCase("mCountryGroup"))&&(Company_Scope.equalsIgnoreCase("country group")))
						//					{
						//						if(StringUtils.isEmpty(Company_CountryGroup)==false)
						//						{
						//							utilfunc.Selectdropdownvaluebytext(PopUp_xpath1, Company_CountryGroup);
						//						}
						//						else
						//						{
						//							utilfunc.DeSelectdropdownvalue(PopUp_xpath1);
						//							System.out.println("\nValue -"+Company_CountryGroup+"- is not exists inside the drop down.");
						//						}
						//					}
						//					else{continue;}
						//				}
						//Add Role (on Popup window) (save)
						//utilfunc.MakeElement(".//*[@class='icon-plus icon-white']").click();


					}
					catch(Exception error){
						System.out.println("Some Error occured during Assign Role on popup window.");
						utilfunc.TakeScreenshot();
						Flag=false;
						return Flag;
						}

					try{
						Thread.sleep(1000);
						String saveBtn	=	".//*[@class='icon-pencil icon-white']";
						utilfunc.MakeElement(saveBtn).click();
						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
						String  error_flag="";
						try{
							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
						catch(Exception e){}
						Thread.sleep(1000);
						System.out.println("error_flag is :"+error_flag);
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
					}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}


				}

			}
			if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				System.out.println("Search ....");
				String search_name=lastname+","+firstname+" "+middlename;
				utilfunc.MakeElement(".//*[@id='SearchText']").sendKeys(search_name);
				Thread.sleep(500);
				utilfunc.MakeElement(".//*[@id='btnSearch']").click();
				System.out.println("Search process is completed.");
				Thread.sleep(1000);
				String recordFoundOrNot=utilfunc.MakeElement(".//*[@class='table table-item-list']//tbody//tr[1]//td[1]").getText();
				if(recordFoundOrNot.equalsIgnoreCase("No Data Found!"))
				{
					System.out.println("No data found!!!");
					error_msg="No Data Found!";
					utilfunc.globalerrormessage=error_msg;
					utilfunc.ErrorMessage4=error_msg;
					utilfunc.TakeScreenshot();
					Flag=false;
					return Flag;
					
				}
				else
				{
					System.out.println("Record founded. we are going to delete it.");
					try{
						Thread.sleep(1000);
						try{utilfunc.MakeElement(".//*[@id='divList']/table/tbody/tr[1]//*[@class='icon-trash']").click();}catch(Exception error){}
						Thread.sleep(300);
						Alert alt= webdriver.switchTo().alert();
						alt.accept();
						//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
						String  error_flag="";
						try{
							Thread.sleep(2000);//wait so it can get error messages
							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
						catch(Exception e){}

						System.out.println("\n===utilfunc.ErrorMessage1 is :"+utilfunc.ErrorMessage1);
						System.out.println("===utilfunc.ErrorMessage2 is :"+utilfunc.ErrorMessage2);
						System.out.println("===utilfunc.ErrorMessage4 is :"+utilfunc.ErrorMessage4);
						System.out.println("===utilfunc.ErrorMessage5 is :"+utilfunc.ErrorMessage5);
						Thread.sleep(1000);
						
						if(mode.equals("Delete")){
							String GotUnexceptedErrorMessage=utilfunc.MakeElement(".//*[contains(@class,'alert-error')]").getText();
							if(GotUnexceptedErrorMessage!=""||(utilfunc.ErrorMessage5!="")){utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+GotUnexceptedErrorMessage;error_flag=utilfunc.ErrorMessagehandlerExperiment();}
							}
						System.out.println("error_flag is :"+error_flag);
						if (error_flag.equals(ExpectedErrorMessage)){
							Flag=true;
							utilfunc.TakeScreenshot();
						}else if (error_flag.equals("")){
							Flag=true;
						}else if(error_flag.equals("Server Error in '/' Application.")){
							Flag=false;
							utilfunc.scrollToTop();
							utilfunc.TakeScreenshot();
							webdriver.navigate().back();
						}else{
							Flag=false;
							utilfunc.scrollToTop();
							utilfunc.TakeScreenshot();
						}
					}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}
				}


			}


		}
		
		try{
			String popupclose_xpath=".//*[@id='Modal_RoleAssignment']//*[contains(@type,'button') and contains(@class,'close')]";
			utilfunc.MakeElement(popupclose_xpath).click();
			Thread.sleep(2000);
		}catch(Exception error){}
		
		return Flag;
	}


}
