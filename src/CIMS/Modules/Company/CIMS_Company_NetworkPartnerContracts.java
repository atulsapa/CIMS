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

import util.UtilFunction;


public class CIMS_Company_NetworkPartnerContracts {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	private String filename	=	"Test Company Data.xls";
	private String sheetName	=	"Contracts";
	private String mode			=	"New";

	public CIMS_Company_NetworkPartnerContracts(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_NetworkPartnerContracts(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on Company - Network Partner Contracts Module.");
		boolean Flag	=	false;

		String TestcaseID				=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode			=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario					=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company					=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description		=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String NP_C_Title				=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String NP_C_DateEffective1		=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);	
		String NP_C_DateSigned1			=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);	
		String NP_C_ExpiryDate1			=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);	
		String NP_C_ContractStatus		=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String NP_C_IsActive			=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String NP_C_ContractUrl			=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String NP_C_Note				=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String ExpectedErrorMessage		=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		
		
		String NP_C_DateEffective="";
		String NP_C_DateSigned="";
		String NP_C_ExpiryDate="";
		
		try{NP_C_DateEffective= utilfunc.changeDateFormat(NP_C_DateEffective1);}catch(Exception error){}  
		try{NP_C_DateSigned=utilfunc.changeDateFormat(NP_C_DateSigned1);}catch(Exception error){}
		try{NP_C_ExpiryDate=utilfunc.changeDateFormat(NP_C_ExpiryDate1);}catch(Exception error){}
		
		
		if(TestcaseRunMode.equals("Y"))
		{	
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;

			if(mode.equalsIgnoreCase("New"))
			{
				String click_Add_New_Contract=".//*[@id='form1']//*[@class='form-min-height']//*[@class='btn']";
				try{utilfunc.MakeElement(click_Add_New_Contract).click();} catch (Exception e1) {System.out.println("Errro while click add new button");				}
				Thread.sleep(1000);
				String control_count_xpath=".//*[@id='form1']//*[@class='control-group']";
				int control_count=utilfunc.GetObjectCount(control_count_xpath);
				for(int k=1;k<=control_count;k++)
				{
					Thread.sleep(500);
					try{
					String control_path=control_count_xpath+"["+k+"]//*[@class='controls']//*[@name]";
					String get_control_name=utilfunc.MakeElement(control_path).getAttribute("name");
					System.out.println("\n---> "+get_control_name+" <---");
					if(get_control_name.equalsIgnoreCase("Title"))
					{
						try{
						add(control_path, NP_C_Title);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("DateEffective"))
					{
						try{
						add(control_path, NP_C_DateEffective);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("DateSigned"))
					{
						try{
						add(control_path, NP_C_DateSigned);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("DateDelivered"))
					{
						try{
						add(control_path, NP_C_ExpiryDate);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("ContractStatus"))
					{
						try{
						utilfunc.MakeElement(control_path).click();
						utilfunc.Selectdropdownvaluebytext(control_path, NP_C_ContractStatus);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("IsActive"))
					{
						try{
						if(NP_C_IsActive.equalsIgnoreCase("Yes")){
							utilfunc.MakeElement("//input[@name='IsActive' and @value='True']").click();
						}else{
							utilfunc.MakeElement("//input[@name='IsActive' and @value='False']").click();
						}
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("ContractUrl"))
					{
						try{
						add(control_path, NP_C_ContractUrl);
						}catch(Exception e){}
					}
					else if(get_control_name.equalsIgnoreCase("Note"))
					{
						try{
						add(control_path, NP_C_Note);
						}catch(Exception e){}
					}
					else
					{
						
					}
					}catch(Exception error){}
				}
				
				try{
					
					try{utilfunc.MakeElement(".//*[@id='btnSave']").click();}catch(Exception error){}
										
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
					System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
				}

			}//if(mode.equalsIgnoreCase("New")) ENDS HERE
			
			if(mode.equalsIgnoreCase("Edit"))
			{
				Thread.sleep(800);
				String tbl_rows_xpath=".//*[@id='divList']//tbody//tr";
				int tbl_count=utilfunc.GetObjectCount(tbl_rows_xpath);
				boolean flag_m1=false;
				boolean flag_m2=false;
				boolean flag_m3=false;
				boolean flag_m4=false;
				boolean flag_m5=false;//flag for check data from row match with our data
				for(int g=1;g<=tbl_count;g++)
				{
					Thread.sleep(500);
					String tbl_td_xpath=tbl_rows_xpath+"["+g+"]//td";
					int tbl_td_count=utilfunc.GetObjectCount(tbl_td_xpath);
					/////
					try
					{
						for(int r=1;r<=tbl_td_count;r++)
						{
							Thread.sleep(500);
						String gettxt_xpath=tbl_td_xpath+"["+r+"]";
						String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
						if(gettext.equalsIgnoreCase(NP_C_Title))
						{ flag_m1=true;}
						else if(gettext.equalsIgnoreCase(NP_C_ContractStatus))
						{ flag_m2=true;}
						else if(gettext.equalsIgnoreCase(NP_C_DateEffective))
						{ flag_m3=true;}
						else if(gettext.equalsIgnoreCase(NP_C_DateSigned))
						{ flag_m4=true;}
						else if(gettext.equalsIgnoreCase(NP_C_IsActive))
						{ flag_m5=true;}
						else{break;}
						//Check all flags to know is this our required row
						if((flag_m1==true) && (flag_m2==true) && (flag_m3==true) && (flag_m4==true) && (flag_m5==true))
						{
							String edit_btn_xpath=tbl_td_xpath+"//*[@class='icon-edit']";
							try
							{
								utilfunc.MakeElement(edit_btn_xpath).click();// Click on edit icon
								Thread.sleep(800);
								String control_count_xpath=".//*[@id='form1']//*[@class='control-group']";
								int control_count=utilfunc.GetObjectCount(control_count_xpath);
								for(int k=1;k<=control_count;k++)
								{
									Thread.sleep(500);
									String control_path=control_count_xpath+"["+k+"]//*[@class='controls']//*[@name]";
									String get_control_name=utilfunc.MakeElement(control_path).getAttribute("name");
									System.out.println("\n---> "+get_control_name+" <---");
									if(get_control_name.equalsIgnoreCase("Title"))
									{
										try{
										edit(control_path, NP_C_Title);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("DateEffective"))
									{
										try{
										edit(control_path, NP_C_DateEffective);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("DateSigned"))
									{
										try{
										edit(control_path, NP_C_DateSigned);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("DateDelivered"))
									{
										try{
										edit(control_path, NP_C_ExpiryDate);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("ContractStatus"))
									{
										Thread.sleep(1000);
										try{
											utilfunc.DeSelectdropdownvalue(control_path);
										utilfunc.Selectdropdownvaluebytext(control_path, NP_C_ContractStatus);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("IsActive"))
									{
										Thread.sleep(1000);
										try{
										if(NP_C_IsActive.equalsIgnoreCase("Yes")){
											utilfunc.MakeElement("//input[@name='IsActive' and @value='True']").click();
										}else{
											utilfunc.MakeElement("//input[@name='IsActive' and @value='False']").click();
										}
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("ContractUrl"))
									{
										try{
										edit(control_path, NP_C_ContractUrl);
										}catch(Exception e){}
									}
									else if(get_control_name.equalsIgnoreCase("Note"))
									{
										try{
										edit(control_path, NP_C_Note);
										}catch(Exception e){}
									}
									else
									{
									
									}
								}
								
								try{
									utilfunc.MakeElement(".//*[@id='btnSave']").click();
									Flag=true; 
									//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
									
									String  error_flag="";
									try{
									error_flag=utilfunc.ErrorMessagehandlerExperiment();}
									catch(Exception e){}
									//Thread.sleep(1000);
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
									System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
								}
								
							}
							catch(Exception error)
							{
								System.out.println("");
							}
						}
						
					}//for(int r=1;r<=tbl_td_count;r++) ENDS HERE
					/////
					}
					catch(Exception error)
					{}
				}//for(int g=1;g<=tbl_count;g++) ENDS HERE
				
				
			}//if(mode.equalsIgnoreCase("Edit")) ENDS HERE
			
			if(mode.equalsIgnoreCase("Delete"))
			{
				String tbl_rows_xpath=".//*[@id='divList']//tbody//tr";
				int tbl_count=utilfunc.GetObjectCount(tbl_rows_xpath);
				boolean flag_m1=false;
				boolean flag_m2=false;
				boolean flag_m3=false;
				boolean flag_m4=false;
				boolean flag_m5=false;//flag for check data from row match with our data
				for(int g=1;g<=tbl_count;g++)
				{
					String tbl_td_xpath=tbl_rows_xpath+"["+g+"]//td";
					int tbl_td_count=utilfunc.GetObjectCount(tbl_td_xpath);
					/////
					try
					{
						for(int r=1;r<=tbl_td_count;r++)
						{
							Thread.sleep(200);
						String gettxt_xpath=tbl_td_xpath+"["+r+"]";
						String gettext=utilfunc.MakeElement(gettxt_xpath).getText();
						if(gettext.equalsIgnoreCase(NP_C_Title))
						{ flag_m1=true;}
						else if(gettext.equalsIgnoreCase(NP_C_ContractStatus))
						{ flag_m2=true;}
						else if(gettext.equalsIgnoreCase(NP_C_DateEffective))
						{ flag_m3=true;}
						else if(gettext.equalsIgnoreCase(NP_C_DateSigned))
						{ flag_m4=true;}
						else if(gettext.equalsIgnoreCase(NP_C_IsActive))
						{ flag_m5=true;}
						else{break;}
						//Check all flags to know is this our required row
						if((flag_m1==true) && (flag_m2==true) && (flag_m3==true) && (flag_m4==true) && (flag_m5==true))
						{
							
							try{
								String del_btn_xpath=tbl_td_xpath+"//*[@class='icon-trash']";
								try{utilfunc.MakeElement(del_btn_xpath).click();}catch(Exception e){System.out.println("Error during click on delete button"+e);}
								Alert alt= webdriver.switchTo().alert();
								alt.accept();
								Flag=true; 
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario");
								
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
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Error occured.Record not deleted. Error Description :\n"+e+"\n");
							}

						}
						}
					}
						catch(Exception e){}
				}
				
			}//if(mode.equalsIgnoreCase("Delete")) ENDS HERE
		
		}//if(TestcaseRunMode.equals("Y")) ENDS HERE
		
		return Flag; // It is Final return of Flag....
	}//public boolean Company_NetworkPartnerContracts ENDS HERE
	
	
	
	public void add(String add_xpath, String val) throws InterruptedException
	{
		try{utilfunc.MakeElement(add_xpath).click();}catch(Exception e){}
		utilfunc.MakeElement(add_xpath).sendKeys(val);
		Thread.sleep(80);
		try{utilfunc.MakeElement("html").click();}catch(Exception e){}
		Thread.sleep(80);
	}
	
	public void edit(String add_xpath, String val) throws InterruptedException
	{
		try{utilfunc.MakeElement(add_xpath).clear();}catch(Exception e){}
		utilfunc.MakeElement(add_xpath).sendKeys(val);
		Thread.sleep(80);
		try{utilfunc.MakeElement("html").click();}catch(Exception e){}
		Thread.sleep(80);
	}
	
	
	
}//public class CIMS_Company_NetworkPartnerContracts ENDS HERE
