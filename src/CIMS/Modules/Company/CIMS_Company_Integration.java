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

public class CIMS_Company_Integration {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_Company_Integration(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Integration(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");
		boolean Flag	=	false;
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);	
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Identity_Provider							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String Domain_Identifier							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String SSO_Type										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String IDP_initiated							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String Client_Number							    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String Company_Number							    =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Vendor_Number							    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);

		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;

			if((mode.equalsIgnoreCase("Edit"))||(mode.equalsIgnoreCase("New")))
			{
				boolean flag_i1=false;
				boolean flag_i2=false;
				boolean flag_i3=false;
				boolean flag_i4=false;
				boolean flag_i5=false;
				boolean flag_i6=false;
				boolean flag_i7=false;
				try
				{
					String edit_xpath=".//*[@class='table table-item-list']//tbody//tr[xxx]//td[3]//*[@class='icon-edit']";
					String input_xpath=".//*[@class='table table-item-list']//tbody//tr[xxx]//td[2]//*[2]//*[1]";
					String save_btn_xpath=".//*[@class='table table-item-list']//tbody//tr[xxx]//td[3]//*[contains(text(),'Save')]";
					String match_get_xpath=".//*[@class='table table-item-list']//tbody//tr[xxx]//td[2]//*[2]";
					String xpath1=".//*[@class='table table-item-list']//tbody//tr";

					int count = utilfunc.GetObjectCount(xpath1);

					//Execute only if number of elements are found..
					if(count>=1)
					{
						System.out.println("\n=========================\nReady to set values in "+sheetName+" form in "+mode+" mode.\n========================\n");
						String mypath_edit_icon	= "";
						String xpath_enter_value="";
						String mypath_edit_icon1="";

						for(int i=1;i<=count;i++)
						{
							Thread.sleep(2000);
							String mypath	=	match_get_xpath.replace("xxx", Integer.toString(i));
							String myattributename	=	utilfunc.MakeElement(mypath).getAttribute("name");
							try
							{
								mypath_edit_icon="";
								xpath_enter_value="";
								mypath_edit_icon1="";

								mypath_edit_icon=edit_xpath.replace("xxx", Integer.toString(i));
								xpath_enter_value = input_xpath.replace("xxx", Integer.toString(i));
								mypath_edit_icon1=save_btn_xpath.replace("xxx", Integer.toString(i));
								//								System.out.print("\n\nmypath_edit_icon\n"+mypath_edit_icon);
								//								System.out.print("\nxpath_enter_value\n"+xpath_enter_value);
								//								System.out.print("\nmypath_edit_icon1\n"+mypath_edit_icon1);

								if (myattributename.equalsIgnoreCase("divSSOPartnerIdentityProviderName"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(Identity_Provider);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divDomainIdentifier"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(Domain_Identifier);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divSSOType"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(SSO_Type);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divIdpURL"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(IDP_initiated);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divClientNumber"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(Client_Number);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divCompanyNumber"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(Company_Number);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
										String gettextforvalidation="";
										String validation_xpath=".//*[@id='validation-summary']";
										gettextforvalidation=utilfunc.MakeElement(validation_xpath).getText();
										if(gettextforvalidation.equalsIgnoreCase("Please, enter 13 digits"))
										{
											utilfunc.ErrorMessage1="Please, enter 13 digits";
											utilfunc.globalerrormessage="Please, enter 13 digits";
											if(gettextforvalidation.equalsIgnoreCase(ExpectedErrorMessage))
											{
												Flag=true;
											}
											else
											{
												Flag=false;
											}	
											utilfunc.TakeScreenshot();
											return Flag;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divVendorNumber"))
								{
									try{
										utilfunc.MakeElement(mypath_edit_icon).click();
										Thread.sleep(3000);
										utilfunc.MakeElement(xpath_enter_value).clear();
										utilfunc.MakeElement(xpath_enter_value).sendKeys(Vendor_Number);
										Thread.sleep(3000);
										utilfunc.MakeElement(mypath_edit_icon1).click();
									}catch(Exception e){}
								}
								else{
									System.out.println("Unknown control found!!!");//we hope that this condition will never come.
								}

							}
							catch(Exception error)
							{
								System.out.println("Error: "+ error);
							}
						}
						//System.out.println("\nNow we are here!!!");

						for(int r=1;r<=count;r++)
						{
							Thread.sleep(1000);
							String mypath	=	match_get_xpath.replace("xxx", Integer.toString(r));
							utilfunc.waitForAnElementToLoad(mypath,false);
							String myattributename	=	utilfunc.MakeElement(mypath).getAttribute("name");
							try
							{
								xpath_enter_value="";
								xpath_enter_value = match_get_xpath.replace("xxx", Integer.toString(r));
								if (myattributename.equalsIgnoreCase("divSSOPartnerIdentityProviderName"))
								{
									try{
										String get_Identity_Provider=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_Identity_Provider!="" && Identity_Provider!=null)
										{
											if(get_Identity_Provider.equalsIgnoreCase(Identity_Provider))
											{flag_i1=true;}
											else
											{flag_i1=false;}
										}else{
											flag_i1=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divDomainIdentifier"))
								{
									try{
										String get_Domain_Identifier=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_Domain_Identifier!="" && Domain_Identifier!=null)
										{
											if(get_Domain_Identifier.equalsIgnoreCase(Domain_Identifier))
											{flag_i2=true;}
											else
											{flag_i2=false;}
										}
										else
										{
											flag_i2=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divSSOType"))
								{
									try{
										String get_SSO_Type=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_SSO_Type!="" &&  SSO_Type!=null)
										{
											if(get_SSO_Type.equalsIgnoreCase(SSO_Type))
											{flag_i3=true;}
											else
											{flag_i3=false;}
										}
										else
										{
											flag_i3=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divIdpURL"))
								{
									try{
										String get_IDP_initiated=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_IDP_initiated!=""&& IDP_initiated!=null)
										{
											if(get_IDP_initiated.equalsIgnoreCase(IDP_initiated))
											{flag_i4=true;}
											else
											{flag_i4=false;}
										}
										else
										{
											flag_i4=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divClientNumber"))
								{
									try{
										String get_Client_Number=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_Client_Number!="" && Client_Number!=null)
										{
											if(get_Client_Number.equalsIgnoreCase(Client_Number))
											{flag_i5=true;}
											else
											{flag_i5=false;}
										}
										else
										{
											flag_i5=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divCompanyNumber"))
								{
									try{
										String get_Company_Number=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_Company_Number!="" && Company_Number!=null)
										{
											if(get_Company_Number.equalsIgnoreCase(Company_Number))
											{flag_i6=true;}
											else
											{
												flag_i6=false;
											}
										}
										else
										{
											flag_i6=true;
										}
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("divVendorNumber"))
								{
									try{
										String get_Vendor_Number=utilfunc.MakeElement(xpath_enter_value).getText();
										if(get_Vendor_Number!="" && Vendor_Number!=null)
										{
											if(get_Vendor_Number.equalsIgnoreCase(Vendor_Number))
											{flag_i7=true;}
											else
											{flag_i7=false;}
										}
										else
										{
											flag_i7=true;
										}
									}catch(Exception e){}
								}
								else{
									System.out.println("Unknown control found!!!");//Never reached condition
								}
							}
							catch(Exception error)
							{
								System.out.println("Error: "+ error);
							}
						}//for loop ends here


						try{

							if((flag_i1==true)&&(flag_i2==true)&&(flag_i3==true)&&(flag_i4==true)&&(flag_i5==true)&&(flag_i6==true)&&(flag_i7==true))
							{
								Flag=true; 
								//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
								String  error_flag="";
								try{
									error_flag=utilfunc.ErrorMessagehandlerExperiment();}
								catch(Exception e){}

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
							}
						}catch(Exception e){
							Flag	=	false;
							System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");

						}//for loop ends here
					}// if(count>1) ends here

				}//try Ends here
				catch(Exception error)
				{
					System.out.println("Some error in Edit Section. Error details are as :"+error);
				}
			}//if(mode.equalsIgnoreCase("New")) ends here
			else if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("User is deleting "+sheetName+" module");
				utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
				Flag= true;
				utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
				return Flag;
			}
		}


		return Flag;
	}



}
