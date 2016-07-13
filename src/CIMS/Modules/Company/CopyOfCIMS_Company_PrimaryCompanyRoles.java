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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;
import  org.apache.commons.lang3.StringUtils;

import util.UtilFunction;

public class CopyOfCIMS_Company_PrimaryCompanyRoles {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CopyOfCIMS_Company_PrimaryCompanyRoles(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_PrimaryCompanyRoles(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");
		

		boolean Flag	=	false;

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String PCR_Primary_Company_Roles					=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);

		String PCR_BALGlobalChekAdministrator				=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);	
		String PCR_BALGlobalChekUser						=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);	
		String PCR_CompanyAdminAssistant					=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);	
		String PCR_CompanyAdministrator						=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String PCR_CompanyAssistant							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		
		String PCR_CompanyAttorney_Manager					=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String PCR_CompanyClientServices					=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String PCR_CompanyGVResponsibleAttorney_Manager		=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String PCR_CompanyResponsibleAttorney_Manager1		=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String PCR_CompanyResponsibleAttorney_Manager2		=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		
		String PCR_InitiationRecipient						=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String PCR_GlobalChekInitiator						=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String PCR_Initiator								=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String PCR_oldHRContactSurvey						=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String PCR_ReportUser								=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		
		String PCR_NetworkPartnerAssistant					=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String PCR_NetworkPartnerAttorney_Manager_Manager	=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);


		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;
			Thread.sleep(1000);
			
			if((mode.equalsIgnoreCase("New"))||(mode.equalsIgnoreCase("Edit")))
			{
				try
				{
					//set value in dropdown box
					String drpdwnbx_xpath="//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select";
					utilfunc.Selectdropdownvaluebytext(drpdwnbx_xpath, PCR_Primary_Company_Roles);
					Thread.sleep(4000);
					String autodrop_xpath=".//*[@class='dropdown-menu ng-isolate-scope']//li";
					String table_row_count=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]";
					Thread.sleep(1000); // Wait for 1 sec before count rows in table
					int tbl_row_count=utilfunc.GetObjectCount(table_row_count);

					if(PCR_Primary_Company_Roles.equalsIgnoreCase("BAL"))
					{
						try
						{
							boolean flag_B1=false;boolean flag_B2=false;boolean flag_B3=false;
							boolean flag_B4=false;boolean flag_B5=false;boolean flag_B6=false;
							boolean flag_B7=false;boolean flag_B8=false;boolean flag_B9=false;
							boolean flag_B10=false;boolean flag_B11=false;
							//System.out.println("\n\n"+tbl_row_count);

							//for count the elements to deleted by selected Primary Company Roles
							//for BAL
							int bal_addedit_counter=0;
							for(int bal=1;bal<=tbl_row_count;bal++)
							{
								Thread.sleep(1000);
								try{
									if((!StringUtils.isEmpty(PCR_BALGlobalChekAdministrator))&&(flag_B1==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B1=true;
										}catch(Exception error){}
									}
									else if((!StringUtils.isEmpty(PCR_BALGlobalChekUser))&&(flag_B2==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B2=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAdminAssistant)&&(flag_B3==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B3=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAdministrator)&&(flag_B4==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B4=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAssistant)&&(flag_B5==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B5=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAttorney_Manager)&&(flag_B6==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B6=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyClientServices)&&(flag_B7==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B7=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyGVResponsibleAttorney_Manager)&&(flag_B8==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B8=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager1)&&(flag_B9==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B9=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager2)&&(flag_B10==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B10=true;
										}catch(Exception error){}
									}
									else if(!StringUtils.isEmpty(PCR_InitiationRecipient)&&(flag_B11==false))
									{
										try{
											bal_addedit_counter=bal_addedit_counter+1;
											flag_B11=true;
										}catch(Exception error){}
									}

								}catch(Exception error){}
							}
							System.out.print("\n=======\n-----User want to aad/edit "+bal_addedit_counter+" roles for BAL.-----\n=======\n");

							//for BAL END END END

							/*========================*/

							for(int l=1;l<=tbl_row_count;l++)
							{
								try{
									Thread.sleep(1000);
									String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
									String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
									String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div";
									String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/input";

									if(gettext.equalsIgnoreCase("BAL GlobalChek Administrator")&&(StringUtils.isEmpty(PCR_BALGlobalChekAdministrator)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_BALGlobalChekAdministrator);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("BAL GlobalChek User")&&(StringUtils.isEmpty(PCR_BALGlobalChekUser)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_BALGlobalChekUser);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Admin Assistant")&&(StringUtils.isEmpty(PCR_CompanyAdminAssistant)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyAdminAssistant);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Administrator")&&(StringUtils.isEmpty(PCR_CompanyAdministrator)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyAdministrator);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Assistant")&&(StringUtils.isEmpty(PCR_CompanyAssistant)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyAssistant);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyAttorney_Manager)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyAttorney_Manager);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Client Services")&&(StringUtils.isEmpty(PCR_CompanyClientServices)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyClientServices);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company GV Responsible Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyGVResponsibleAttorney_Manager)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyGVResponsibleAttorney_Manager);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 1")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager1)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyResponsibleAttorney_Manager1);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 2")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager2)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_CompanyResponsibleAttorney_Manager2);
										}catch(Exception error){}
									}
									else if(gettext.equalsIgnoreCase("Initiation Recipient")&&(StringUtils.isEmpty(PCR_InitiationRecipient)==false))
									{
										try{
											edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_InitiationRecipient);
										}catch(Exception error){}
									}
									else{System.out.println("Unknown Field!!!!\t\""+gettext+"\"");}
								}catch(Exception error){}
							} // for loop ENDS HERE

							//for refresh the page
							webdriver.navigate().refresh();
							//	utilfunc.zoomOut(1);

							//Now again set value in drop down
							utilfunc.Selectdropdownvaluebytext("//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select", PCR_Primary_Company_Roles);
							Thread.sleep(1000);
							//now we are going to match the value
							flag_B1=false; flag_B2=false; flag_B3=false;
							flag_B4=false; flag_B5=false; flag_B6=false;
							flag_B7=false; flag_B8=false; flag_B9=false;
							flag_B10=false; flag_B11=false;

							int bal_addedit_cuntr=0;
							for(int l=1;l<=tbl_row_count;l++)
							{
								try{
									Thread.sleep(1000);
									String xpath_get_ele_set_value=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span";
									String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
									String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
									System.out.println(gettext);


									String get_element_set_value=utilfunc.MakeElement(".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span").getText();
									System.out.println(get_element_set_value+"\n");
									//Check for BAL GlobalChek Administrator
									if((gettext.equalsIgnoreCase("BAL GlobalChek Administrator"))&&(StringUtils.isEmpty(PCR_BALGlobalChekAdministrator)==false)){
										flag_B1=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_BALGlobalChekAdministrator);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for BAL GlobalChek User
									else if(gettext.equalsIgnoreCase("BAL GlobalChek User")&&(StringUtils.isEmpty(PCR_BALGlobalChekUser)==false)){
										flag_B2=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_BALGlobalChekUser);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Admin Assistant
									else if(gettext.equalsIgnoreCase("Company Admin Assistant")&&(StringUtils.isEmpty(PCR_CompanyAdminAssistant)==false)){
										flag_B3=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyAdminAssistant);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Administrator
									else if(gettext.equalsIgnoreCase("Company Administrator")&&(StringUtils.isEmpty(PCR_CompanyAdministrator)==false)){
										flag_B4=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyAdministrator);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Assistant
									else if(gettext.equalsIgnoreCase("Company Assistant")&&(StringUtils.isEmpty(PCR_CompanyAssistant)==false)){
										flag_B5=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyAssistant);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Attorney/Manager
									else if(gettext.equalsIgnoreCase("Company Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyAttorney_Manager)==false)){
										flag_B6=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyAttorney_Manager);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Client Services
									else if(gettext.equalsIgnoreCase("Company Client Services")&&(StringUtils.isEmpty(PCR_CompanyClientServices)==false)){
										flag_B7=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyClientServices);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company GV Responsible Attorney/Manager
									else if(gettext.equalsIgnoreCase("Company GV Responsible Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyGVResponsibleAttorney_Manager)==false)){
										flag_B8=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyGVResponsibleAttorney_Manager);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Responsible Attorney/Manager 1
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 1")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager1)==false)){
										flag_B9=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyResponsibleAttorney_Manager1);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Company Responsible Attorney/Manager 2
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 2")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager2)==false)){
										flag_B10=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_CompanyResponsibleAttorney_Manager2);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									//Check for Initiation Recipient
									else if(gettext.equalsIgnoreCase("Initiation Recipient")&&(StringUtils.isEmpty(PCR_InitiationRecipient)==false)){
										flag_B11=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_InitiationRecipient);
										bal_addedit_cuntr=bal_addedit_cuntr+1;
									}
									else{System.out.println("Unknown Field!!!!\t\""+gettext+"\"");}
								}catch(Exception error){}
							}
							System.out.print("\n---User add/edit "+bal_addedit_cuntr+" roles for BAL.\n");

							System.out.println("\n\n\nbal_addedit_cuntr == bal_addedit_counter \n"+bal_addedit_cuntr+" == "+bal_addedit_counter+"\n\n\n");

							// Now we are going to check the flags
							if(bal_addedit_cuntr==bal_addedit_counter)
							{
								try{
									//Flag=true; 
									//	System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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
								}catch(Exception e){
									Flag	=	false;
									utilfunc.TakeScreenshot();
									System.out.println("Data is not saved. Some error occured.");
								}
							}
							else
							{
								utilfunc.ErrorMessage1="Invalid user name passed by user.";
								Flag= true;
								utilfunc.TakeScreenshot();
								utilfunc.globalerrormessage="Invalid user name passed by user.";
								return Flag;
							}
						}
						catch(Exception error)
						{
							Flag=false;
							utilfunc.TakeScreenshot();
							System.out.println("Error occured during edit \"BAL\".");
						}

					}
					else if(PCR_Primary_Company_Roles.equalsIgnoreCase("Client"))
					{
						boolean flag_C1=false;
						boolean flag_C2=false;
						boolean flag_C3=false;
						boolean flag_C4=false;

						//for count the elements to deleted by selected Primary Company Roles
						//for client
						int client_addedit_counter=0;
						for(int client=1;client<=tbl_row_count;client++)
						{
							Thread.sleep(1000);
							try{
								if((!StringUtils.isEmpty(PCR_GlobalChekInitiator))&&(flag_C1==false))
								{
									client_addedit_counter=client_addedit_counter+1;
									flag_C1=true;
								}
								else if((!StringUtils.isEmpty(PCR_Initiator))&&(flag_C2==false))
								{
									client_addedit_counter=client_addedit_counter+1;
									flag_C2=true;
								}
								else if(!StringUtils.isEmpty(PCR_oldHRContactSurvey)&&(flag_C3==false))
								{
									client_addedit_counter=client_addedit_counter+1;
									flag_C3=true;
								}
								else if(!StringUtils.isEmpty(PCR_ReportUser)&&(flag_C4==false))
								{
									client_addedit_counter=client_addedit_counter+1;
									flag_C4=true;
								}
							}catch(Exception error){}
						}
						System.out.print("\n=======\n-----User want to delet "+client_addedit_counter+" roles for client.-----\n=======\n");
						//for count the elements to deleted by selected Primary Company Roles
						//for client END END END

						//System.out.println("\n\n"+tbl_row_count);
						for(int l=1;l<=tbl_row_count;l++)
						{
							try{
								Thread.sleep(400);
								String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
								String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
								String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div";
								String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/input";
								if(gettext.equalsIgnoreCase("GlobalChek Initiator")&&(StringUtils.isEmpty(PCR_GlobalChekInitiator)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_GlobalChekInitiator);
									}catch(Exception error){}
								}
								else if(gettext.equalsIgnoreCase("Initiator")&&(StringUtils.isEmpty(PCR_Initiator)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_Initiator);
									}catch(Exception error){}
								}
								else if(gettext.equalsIgnoreCase("old HR Contact Survey")&&(StringUtils.isEmpty(PCR_oldHRContactSurvey)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_oldHRContactSurvey);
									}catch(Exception error){}
								}
								else if(gettext.equalsIgnoreCase("Report User")&&(StringUtils.isEmpty(PCR_ReportUser)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_ReportUser);
									}catch(Exception error){}
								}
								else{System.out.println("Unknown Field!!!\n\""+gettext+"\"");}
							}catch(Exception error){}
						}// for loop ENDS HERE

						//for refresh the page
						webdriver.navigate().refresh();
						//utilfunc.zoomOut(1);

						//Now again set value in drop down
						utilfunc.Selectdropdownvaluebytext("//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select", PCR_Primary_Company_Roles);
						Thread.sleep(1000);
						//now we are going to match the value

						int client_addedit_cuntr=0;
						for(int l=1;l<=tbl_row_count;l++)
						{Thread.sleep(1000);
						try{
							String xpath_get_ele_set_value=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span";
							String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
							String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
							System.out.println(gettext);


							String get_element_set_value=utilfunc.MakeElement(".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span").getText();
							System.out.println(get_element_set_value+"\n");
							//Check for BAL GlobalChek Administrator
							if((gettext.equalsIgnoreCase("GlobalChek Initiator"))&&(StringUtils.isEmpty(PCR_GlobalChekInitiator)==false)){
								flag_C1=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_GlobalChekInitiator);
								client_addedit_cuntr=client_addedit_cuntr+1;
							}
							else if((gettext.equalsIgnoreCase("Initiator"))&&(StringUtils.isEmpty(PCR_Initiator)==false)){
								flag_C2=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_Initiator);
								client_addedit_cuntr=client_addedit_cuntr+1;
							}
							else if((gettext.equalsIgnoreCase("old HR Contact Survey"))&&(StringUtils.isEmpty(PCR_oldHRContactSurvey)==false)){
								flag_C3=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_oldHRContactSurvey);
								client_addedit_cuntr=client_addedit_cuntr+1;
							}
							else if((gettext.equalsIgnoreCase("Report User"))&&(StringUtils.isEmpty(PCR_ReportUser)==false)){
								flag_C4=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_ReportUser);
								client_addedit_cuntr=client_addedit_cuntr+1;
							}
							else{
								System.out.println("Unknown Field!!!\n\""+gettext+"\"");
							}
						}catch(Exception error){}
						}
						System.out.print("\n---User add/edit "+client_addedit_cuntr+" roles for BAL.\n");

						System.out.println("\n\n\nbal_addedit_cuntr == bal_addedit_counter \n"+client_addedit_cuntr+" == "+client_addedit_counter+"\n\n\n");

						// Now we are going to check the flags
						if(client_addedit_cuntr==client_addedit_counter)
						{
							try{
								//Flag=true; 
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario excution completed.");
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
							}catch(Exception e){
								Flag	=	false;
								utilfunc.TakeScreenshot();
								System.out.println("Data is not saved. Some error occured.");
							}
						}
						else
						{
							utilfunc.ErrorMessage1="Invalid user name passed by user.";
							Flag= true;
							utilfunc.TakeScreenshot();
							utilfunc.globalerrormessage="Invalid user name passed by user.";
							return Flag;
						}

					}

					else if(PCR_Primary_Company_Roles.equalsIgnoreCase("Network Partner"))
					{
						System.out.println("\n\n----User is going for add/edit Network Partner primary roles.----\n\n");

						boolean flag_np1=false;
						boolean flag_np2=false;

						int np_addedit_counter=0;
						//for count how many roles user want to add or edit
						for(int bal=1;bal<=tbl_row_count;bal++)
						{
							Thread.sleep(1000);
							try{
								if((!StringUtils.isEmpty(PCR_NetworkPartnerAssistant))&&(flag_np1==false))
								{
									np_addedit_counter=np_addedit_counter+1;
									flag_np1=true;
								}
								else if((!StringUtils.isEmpty(PCR_NetworkPartnerAttorney_Manager_Manager))&&(flag_np2==false))
								{
									np_addedit_counter=np_addedit_counter+1;
									flag_np2=true;
								}
							}catch(Exception e){}
						}

						System.out.print("\n=======\n-----User want to add/edit "+np_addedit_counter+" roles for Network Partner.-----\n=======\n");
						//for count the elements to deleted by selected Primary Company Roles

						for(int l=1;l<=tbl_row_count;l++)
						{
							Thread.sleep(1000);
							try{
								String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
								String gettext="";
								try
								{
									gettext=utilfunc.MakeElement(gettxt_xpath).getText();
								}
								catch(Exception e)
								{
									System.out.println("Error in getting value from below path.\n\t"+gettxt_xpath+"\n");	
								}
								System.out.println("Gettext for count number "+l+" is :"+gettext);
								String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div";
								String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/input";
								Thread.sleep(1000);
								if(gettext.equalsIgnoreCase("Network Partner Assistant")&&(StringUtils.isEmpty(PCR_NetworkPartnerAssistant)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_NetworkPartnerAssistant);
									}catch(Exception error){}
								}
								else if(gettext.equalsIgnoreCase("Network Partner Attorney/Manager/Manager")&&(StringUtils.isEmpty(PCR_NetworkPartnerAttorney_Manager_Manager)==false))
								{
									try{
										edit_auto_drpdwn_click(clk_txt_path, clk_txt_path1,autodrop_xpath,PCR_NetworkPartnerAttorney_Manager_Manager);
									}catch(Exception error){}
								}

							}catch(Exception e){}
						}
						//for refresh the page
						webdriver.navigate().refresh();
						//utilfunc.zoomOut(1);
						//Now again set value in drop down
						Thread.sleep(2000);
						utilfunc.Selectdropdownvaluebytext("//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select", PCR_Primary_Company_Roles);
						Thread.sleep(2000);
						//now we are going to match the value
						flag_np1=false;
						flag_np2=false;
						int np_addedit_cuntr=0;
						for(int l=1;l<=tbl_row_count;l++)
						{
							Thread.sleep(1000);
							try{
								String xpath_get_ele_set_value=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span";
								String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
								String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
								System.out.println(gettext);
								String get_element_set_value=utilfunc.MakeElement(".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span").getText();
								System.out.println(get_element_set_value+"\n");

								//check for Network Partner Assistant
								if(gettext.equalsIgnoreCase("Network Partner Assistant")&&(StringUtils.isEmpty(PCR_NetworkPartnerAssistant)==false)){
									flag_np1=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_NetworkPartnerAssistant);
									np_addedit_cuntr=np_addedit_cuntr+1;
								}
								//check for Network Partner Attorney/Manager/Manager
								else if(gettext.equalsIgnoreCase("Network Partner Attorney/Manager/Manager")&&(StringUtils.isEmpty(PCR_NetworkPartnerAttorney_Manager_Manager)==false)){
									flag_np2=PrimaryCompany_Roles_Compare(xpath_get_ele_set_value,PCR_NetworkPartnerAttorney_Manager_Manager);
									np_addedit_cuntr=np_addedit_cuntr+1;
								}
								else{System.out.println("Unknown Field!!!!\t\""+gettext+"\"");}
							}catch(Exception e){}
						}
						System.out.print("\n---User add/edit "+np_addedit_cuntr+" roles for BAL.\n");

						System.out.println("\n\n\nnp_addedit_cuntr == bal_addedit_counter \n"+np_addedit_cuntr+" == "+np_addedit_counter+"\n\n\n");

						// Now we are going to check the flags
						if(np_addedit_cuntr==np_addedit_counter)
						{
						
							if((flag_np2==true)&&(flag_np1==true))
							{	Flag=true;	}
							else
							{	Flag=false;	}
							
							try{
								//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
								String  error_flag="";
								try{
									error_flag=utilfunc.ErrorMessagehandlerExperiment();}
								catch(Exception e){}

								System.out.println("error_flag is :"+error_flag);
								if (error_flag.equals(ExpectedErrorMessage)){
									Flag=true;
									utilfunc.TakeScreenshot();
								}else if(error_flag.equals("Server Error in '/' Application.")){
									Flag=false;
									webdriver.navigate().back();
								}
								
							}catch(Exception e){
								Flag	=	false;
								utilfunc.TakeScreenshot();
								System.out.println("Data is not saved. Some error occured.");
							}
						}
						else
						{
							utilfunc.ErrorMessage1="Invalid user name passed by user.";
							Flag= true;
							utilfunc.TakeScreenshot();
							utilfunc.globalerrormessage="Invalid user name passed by user.";
							return Flag;
						}

					}
					else{}

				} // try block
				catch(Exception error)
				{	Flag=false;
				utilfunc.TakeScreenshot();
				System.out.println("Error Detils  :\n"+error);
				}

			} // if(mode.equalsIgnoreCase("1Edit")) ENDS here

			/**
			 * 
			 */
			if(mode.equalsIgnoreCase("Delete"))
			{	
				try
				{
					boolean flag_B1=false;boolean flag_B2=false;boolean flag_B3=false;
					boolean flag_B4=false;boolean flag_B5=false;boolean flag_B6=false;
					boolean flag_B7=false;boolean flag_B8=false;boolean flag_B9=false;
					boolean flag_B10=false;boolean flag_B11=false;
					//set value in dropdown box
					String drpdwnbx_xpath="//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select";
					utilfunc.Selectdropdownvaluebytext(drpdwnbx_xpath, PCR_Primary_Company_Roles);
					Thread.sleep(2000);//wait for 2 sec. till then page content should be update
					//String autodrop_xpath=".//*[@class='dropdown-menu ng-isolate-scope']//li";
					String table_row_count=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]";
					Thread.sleep(1000); // Wait for 1 sec before count rows in table
					int tbl_row_count=utilfunc.GetObjectCount(table_row_count);

					if(PCR_Primary_Company_Roles.equalsIgnoreCase("BAL"))
					{
						try
						{
							//System.out.println("\n\n"+tbl_row_count);

							//for count the elements to deleted by selected Primary Company Roles
							//for BAL
							int bal_del_counter=0;
							for(int bal=1;bal<=tbl_row_count;bal++)
							{
								Thread.sleep(1000); 
								try{
									if((!StringUtils.isEmpty(PCR_BALGlobalChekAdministrator))&&(flag_B1==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B1=true;
									}
									else if((!StringUtils.isEmpty(PCR_BALGlobalChekUser))&&(flag_B2==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B2=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAdminAssistant)&&(flag_B3==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B3=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAdministrator)&&(flag_B4==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B4=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAssistant)&&(flag_B5==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B5=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyAttorney_Manager)&&(flag_B6==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B6=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyClientServices)&&(flag_B7==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B7=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyGVResponsibleAttorney_Manager)&&(flag_B8==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B8=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager1)&&(flag_B9==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B9=true;
									}
									else if(!StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager2)&&(flag_B10==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B10=true;
									}
									else if(!StringUtils.isEmpty(PCR_InitiationRecipient)&&(flag_B11==false))
									{
										bal_del_counter=bal_del_counter+1;
										flag_B11=true;
									}
								}catch(Exception e){}
							}
							System.out.print("\n---User want to delet "+bal_del_counter+" roles for BAL.\n");
							//for count the elements to deleted by selected Primary Company Roles
							//for BAL END END END
							int bal_deleted_cuntr=0;
							for(int l=1;l<=tbl_row_count;l++)
							{
								Thread.sleep(1000);
								try{
									String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
									String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div/span";
									//String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div//input";
									String del_btn_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//*[@class='icon icon-trash']";
									String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
									String input_txt_get = utilfunc.MakeElement(clk_txt_path).getText();



									if(gettext.equalsIgnoreCase("BAL GlobalChek Administrator")&&(StringUtils.isEmpty(PCR_BALGlobalChekAdministrator)==false))
									{
										flag_B1=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_BALGlobalChekAdministrator);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---BAL GlobalChek Administrator & bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("BAL GlobalChek User")&&(StringUtils.isEmpty(PCR_BALGlobalChekUser)==false))
									{
										flag_B2=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_BALGlobalChekUser);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---BAL GlobalChek User & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Admin Assistant")&&(StringUtils.isEmpty(PCR_CompanyAdminAssistant)==false))
									{
										flag_B3=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyAdminAssistant);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Admin Assistant & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Administrator")&&(StringUtils.isEmpty(PCR_CompanyAdministrator)==false))
									{
										flag_B4=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyAdministrator);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Administrator & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Assistant")&&(StringUtils.isEmpty(PCR_CompanyAssistant)==false))
									{

										flag_B5=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyAssistant);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Assistant & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyAttorney_Manager)==false))
									{
										flag_B6=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyAttorney_Manager);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Attorney/Manager & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Client Services")&&(StringUtils.isEmpty(PCR_CompanyClientServices)==false))
									{
										flag_B7=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyClientServices);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Client Services & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company GV Responsible Attorney/Manager")&&(StringUtils.isEmpty(PCR_CompanyGVResponsibleAttorney_Manager)==false))
									{
										flag_B8=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyGVResponsibleAttorney_Manager);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company GV Responsible Attorney/Manager & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 1")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager1)==false))
									{
										flag_B9=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyResponsibleAttorney_Manager1);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Responsible Attorney/Manager 1 & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Company Responsible Attorney/Manager 2")&&(StringUtils.isEmpty(PCR_CompanyResponsibleAttorney_Manager2)==false))
									{
										flag_B10=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_CompanyResponsibleAttorney_Manager2);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Company Responsible Attorney/Manager 2 & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Initiation Recipient")&&(StringUtils.isEmpty(PCR_InitiationRecipient)==false))
									{
										flag_B11=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_InitiationRecipient);
										bal_deleted_cuntr=bal_deleted_cuntr+1;
										System.out.println("---Initiation Recipient & now bal_deleted_cuntr is :"+bal_deleted_cuntr);
									}
									else
									{
										System.out.println("User don't want to delete role for \n\t\t\""+gettext+"\" type.");
									}

								}catch(Exception e){}
							} // for loop ENDS HERE

							System.out.println("\nCounter total for deleted roles is : "+bal_deleted_cuntr);
							if(bal_del_counter==bal_deleted_cuntr)
							{
								try{
									//Flag=true; 

									System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario excecuted");
									//System.out.println("Test case id:");
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
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Data is not saved. Some error occured.");
								}
							}
							else
							{
								utilfunc.ErrorMessage1="Invalid user name passed by user.";
								Flag= true;
								utilfunc.TakeScreenshot();
								utilfunc.globalerrormessage="Invalid user name passed by user.";
								return Flag;
							}

						}
						catch(Exception Error)
						{
							Flag=false;
							System.out.println("Error occured during perform delete operation in \"BAL\". ");
						}
					}
					else if(PCR_Primary_Company_Roles.equalsIgnoreCase("Client"))
					{
						try
						{
							boolean flag_C1=false;boolean flag_C2=false;
							boolean flag_C3=false;boolean flag_C4=false;
							//System.out.println("\n\n"+tbl_row_count);
							//for count the elements to deleted by selected Primary Company Roles
							//for Client
							int client_del_counter=0;
							for(int client=1;client<=tbl_row_count;client++)
							{Thread.sleep(1000);
							try{
								if((!StringUtils.isEmpty(PCR_GlobalChekInitiator))&&(flag_C1==false))
								{
									client_del_counter=client_del_counter+1;
									flag_C1=true;
								}
								else if((!StringUtils.isEmpty(PCR_Initiator))&&(flag_C2==false))
								{
									client_del_counter=client_del_counter+1;
									flag_C2=true;
								} 
								else if((!StringUtils.isEmpty(PCR_oldHRContactSurvey))&&(flag_C3==false))
								{
									client_del_counter=client_del_counter+1;
									flag_C3=true;
								}
								else if((!StringUtils.isEmpty(PCR_ReportUser))&&(flag_C4==false))
								{
									client_del_counter=client_del_counter+1;
									flag_C4=true;
								}
							}catch(Exception e){}
							}
							System.out.print("\n---User want to delet "+client_del_counter+" roles for CLIENT.\n");
							//for count the elements to deleted by selected Primary Company Roles
							//for Client END END END
							int client_deleted_cuntr=0;
							for(int l=1;l<=tbl_row_count;l++)
							{
								Thread.sleep(1000);
								try{
									String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
									String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div";
									//String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/input";
									String del_btn_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//*[@class='icon icon-trash']";
									String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
									String input_txt_get = utilfunc.MakeElement(clk_txt_path).getText();
									if(gettext.equalsIgnoreCase("GlobalChek Initiator")&&(StringUtils.isEmpty(PCR_GlobalChekInitiator)==false))
									{
										flag_C1=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_GlobalChekInitiator);
										client_deleted_cuntr=client_deleted_cuntr+1;
										System.out.println("---GlobalChek Initiator & client_deleted_cuntr is :"+client_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Initiator")&&(StringUtils.isEmpty(PCR_Initiator)==false))
									{
										del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_Initiator);
										client_deleted_cuntr=client_deleted_cuntr+1;
										System.out.println("---Initiator & client_deleted_cuntr is :"+client_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("old HR Contact Survey")&&(StringUtils.isEmpty(PCR_oldHRContactSurvey)==false))
									{
										del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_oldHRContactSurvey);
										client_deleted_cuntr=client_deleted_cuntr+1;
										System.out.println("---old HR Contact Survey & client_deleted_cuntr is :"+client_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Report User")&&(StringUtils.isEmpty(PCR_ReportUser)==false))
									{
										del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_ReportUser);
										client_deleted_cuntr=client_deleted_cuntr+1;
										System.out.println("---Report User & client_deleted_cuntr is :"+client_deleted_cuntr);
									}
									else{
										System.out.println("User don't want to delete role for \n\t\t\""+gettext+"\" type.");
									}
								}catch(Exception e){}
							}
							System.out.println("\nclient_deleted_cuntr: "+client_deleted_cuntr);

							if(client_deleted_cuntr==client_del_counter)
							{
								try{
									//Flag=true; 
									System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");

									String  error_flag="";
									try{
										error_flag=utilfunc.ErrorMessagehandlerExperiment();
									}
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
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Data is not saved. Some error occured.");
								}
							}
							else
							{
								Flag=false;
								utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"User tried to assign Primary company roles but roles are not assigned.";
								utilfunc.TakeScreenshot();
							}
						}
						catch(Exception error)
						{
							Flag=false;
							System.out.println("Error occured during perfom delete operationn in \"Client\".");
						}

					}
					else if(PCR_Primary_Company_Roles.equalsIgnoreCase("Network Partner"))
					{
						try
						{
							boolean flag_np1=false;
							boolean flag_np2=false;
							//System.out.println("\n\n"+tbl_row_count);
							int np_del_counter=0;
							for(int client=1;client<=tbl_row_count;client++)
							{
								Thread.sleep(1000);
								try{
									if((!StringUtils.isEmpty(PCR_NetworkPartnerAssistant))&&(flag_np1==false))
									{
										np_del_counter=np_del_counter+1;
										flag_np1=true;
									}
									else if((!StringUtils.isEmpty(PCR_NetworkPartnerAttorney_Manager_Manager))&&(flag_np2==false))
									{
										np_del_counter=np_del_counter+1;
										flag_np2=true;
									} 
								}catch(Exception e){}
							}
							System.out.print("\n---User want to delet "+np_del_counter+" roles for Network Partner.\n");
							//for count the elements to deleted by selected Primary Company Roles
							//for Network Partner END END END
							int np_deleted_cuntr=0;
							for(int l=1;l<=tbl_row_count;l++)
							{
								Thread.sleep(1000);
								try{
									String gettxt_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//div[contains(@class,'col0')]//div[2]/div";
									String clk_txt_path=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/div";
									//String clk_txt_path1=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div["+l+"]/div[2]/div[2]/div/div/input";
									String del_btn_xpath=".//*[@class='ngCanvas']//*[contains(@class, 'ng-scope ngRow')]["+l+"]//*[@class='icon icon-trash']";
									String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
									String input_txt_get = utilfunc.MakeElement(clk_txt_path).getText();
									if(gettext.equalsIgnoreCase("Network Partner Assistant")&&(StringUtils.isEmpty(PCR_NetworkPartnerAssistant)==false))
									{
										flag_np1=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_NetworkPartnerAssistant);
										np_deleted_cuntr=np_deleted_cuntr+1;
										System.out.println("---Network Partner Assistant & np_deleted_cuntr is :"+np_deleted_cuntr);
									}
									else if(gettext.equalsIgnoreCase("Network Partner Attorney/Manager/Manager")&&(StringUtils.isEmpty(PCR_NetworkPartnerAttorney_Manager_Manager)==false))
									{
										flag_np2=del_btn_click(gettext,del_btn_xpath,input_txt_get,PCR_NetworkPartnerAttorney_Manager_Manager);
										np_deleted_cuntr=np_deleted_cuntr+1;
										System.out.println("---Network Partner Attorney/Manager/Manager & np_deleted_cuntr is :"+np_deleted_cuntr);
									}
									else{
										System.out.println("User don't want to delete role for \n\t\t\""+gettext+"\" type.");
									}
								}catch(Exception e){}
							}
							System.out.println("\nnp_deleted_cuntr: "+np_deleted_cuntr);

							if(np_deleted_cuntr==np_del_counter)
							{

								try{
									//									Flag=true; 
									System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
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
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Data is not saved. Some error occured.");
								}
							}
							else
							{
								utilfunc.ErrorMessage1="Invalid user name passed by user.";
								Flag= true;
								utilfunc.TakeScreenshot();
								utilfunc.globalerrormessage="Invalid user name passed by user.";
								return Flag;
							}
						}
						catch(Exception error)
						{
							Flag=false;
							System.out.println("Error occured during perform delete operation on \"Network Partner\".");
						}

					}
					else{}
				} // try block
				catch(Exception error)
				{	System.out.println("Error Detils  :\n"+error);
				}
			} // if(mode.equalsIgnoreCase("Delete")) ENDS here
		}
		return Flag;
	}

	public void auto_drpdwn_click(String clk_txt_path, String clk_txt_path1,String autodrop_xpath, String val) throws InterruptedException
	{
		try
		{
			try{utilfunc.MakeElement(clk_txt_path).click();}catch(Exception e){System.out.println(e);}
			Thread.sleep(1000);
			utilfunc.MakeElement(clk_txt_path1).clear();
			utilfunc.MakeElement(clk_txt_path1).sendKeys(val);
			Thread.sleep(500);
			try
			{
				int lok=utilfunc.GetObjectCount(autodrop_xpath);
				if(lok>0)
				{
					for(int asw=1;asw<=lok;asw++)
					{
						Thread.sleep(500);
						String autodrop_xpath1=autodrop_xpath+"["+asw+"]";
						String wsa=utilfunc.MakeElement(autodrop_xpath1).getText();
						if(wsa!="No data found")
						{
							if(val.equalsIgnoreCase(wsa))
							{
								try{utilfunc.MakeElement(autodrop_xpath1).click();}catch(Exception e){System.out.println(e);}
								Thread.sleep(500);
								break;
							}
							else
							{
								System.out.println("No value match with in dropdown.");
							}
						}
						else
						{
							System.out.println("\n-----\nNo data found\n-----No value match with in dropdown.");
						}
					}
				}
			}//try end
			catch(Exception error)
			{
				System.out.println("Some error occured during set value in textbox. Error discription is: "+error);
			}
		}
		catch(Exception error)
		{
			System.out.println("Error "+error);
		}

	}

	public boolean edit_auto_drpdwn_click(String clk_txt_path, String clk_txt_path1, String autodrop_xpath, String val) throws InterruptedException
	{
		boolean editautodrpdwnclickFlag=false;

		try{
			utilfunc.MakeElement(clk_txt_path).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		Thread.sleep(100);
		utilfunc.MakeElement(clk_txt_path1).clear();
		utilfunc.MakeElement(clk_txt_path1).sendKeys(val);
		Thread.sleep(300);
		int AutoDrpdwnCount=0;
		try
		{
			AutoDrpdwnCount=utilfunc.GetObjectCount(autodrop_xpath);
		}
		catch(Exception e)
		{System.out.println("\n"+e);}
		if(AutoDrpdwnCount==0)
		{
			System.out.println("User not enter value or enter \"\" (blank) value.");	
		}
		else{
			for(int asw=1;asw<=AutoDrpdwnCount;asw++)
			{
				//System.out.println("\n\n----------"+autodrop_xpath);
				String autodrop_xpath1=autodrop_xpath+"["+asw+"]";
				//System.out.print("\n----------"+autodrop_xpath1);
				String wsa="";
				try{wsa=utilfunc.MakeElement(autodrop_xpath1).getText();}catch(Exception e){}
				if(wsa.equalsIgnoreCase("No data found"))
				{
					utilfunc.TakeScreenshot();
					return editautodrpdwnclickFlag;
				}
				else if(val.equalsIgnoreCase(wsa))
				{
					try{utilfunc.MakeElement(autodrop_xpath1).click();}catch(Exception e){System.out.println(e);}
					Thread.sleep(100);
					editautodrpdwnclickFlag=true;
					return editautodrpdwnclickFlag;
				}
				else
				{
					System.out.println("error");//never reached condition
				}
			}
		}

return 	editautodrpdwnclickFlag;			
	}

	public boolean del_btn_click(String gettext,String del_btn_xpath, String input_txt_get, String val) throws InterruptedException
	{
		boolean flag=false;
		//Thread.sleep(500);
		if(input_txt_get.equalsIgnoreCase(val)){
			try{utilfunc.MakeElement(del_btn_xpath).click();}catch(Exception e){System.out.println(e);}
			flag=true;
			Thread.sleep(1000);
			return flag;
		}
		else{
			System.out.println("===\n" +"Type \""+gettext+"\" is not having \""+val+"\" value in Name/Position column.\n "+"     \"Name/Position\" column is having \""+input_txt_get+"\" value.\n===");
		}
		Thread.sleep(1000);
		return flag;
	}

	public boolean PrimaryCompany_Roles_Compare(String xpath_get_ele_set_value, String val)
	{
		String get_element_set_value="";
		boolean flag=false;

		try{
			get_element_set_value=utilfunc.MakeElement(xpath_get_ele_set_value).getText();
			Thread.sleep(1000);
			if(StringUtils.isEmpty(val)==false)
			{
				if(val.equalsIgnoreCase(get_element_set_value))
				{
					flag=true;
				}
			}
			else
			{
				if((StringUtils.isEmpty(val)) && (StringUtils.isEmpty(get_element_set_value)))
				{
					flag=true;
				}
			}
		}
		catch(Exception error)
		{
			System.out.println("Error while get_element_set_value.");
		}

		
		return flag;

	}
}