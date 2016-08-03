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

public class CIMS_Company_Custom_Field {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description	=	null;

	public CIMS_Company_Custom_Field(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Custom_Field(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module with "+mode+" Mode.");
		boolean Flag	=	false;
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);	
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String CF_Application								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		
		String CF_Application_Edit							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String CF_Module									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String CF_Module_Edit								=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String CF_Active									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String CF_Input_Type							    =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		
		String CF_Selection_Fields_Count_s				    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String CF_Selection_Fields_Value				    =			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String CF_Required_Input						    =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String CF_Name									    =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String CF_Name_Edit								    =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		
		String CF_Help_Text								    =			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String CF_Note								    	=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		
		int CF_Selection_Fields_Count=0;
		String intornot="";
		
		try{
			Integer.parseInt(CF_Selection_Fields_Count_s);
			intornot= "true";
		}
		catch(NumberFormatException ex){
			intornot= "false";
		}
		if(intornot.equalsIgnoreCase("true"))
		{
			CF_Selection_Fields_Count = Integer.parseInt(CF_Selection_Fields_Count_s);/* convert string to int */
		}
		else
		{
			CF_Selection_Fields_Count=0;
		}
		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			description = Company_Description;
			String error_msg="";

			if(mode.equalsIgnoreCase("New"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				try
				{

					// Code for click the Add New Report Button
					try{utilfunc.MakeElement(".//*[@id='panel-body']/tbody/tr/td/div/div[1]/a").click();}catch(Exception error){}
					//					Thread.sleep(2000);
					//					System.out.println("User is Add Custom Field Form");
					String xpath=".//*[@id='form1']//*[@class='control-group']//div";
					int count = utilfunc.GetObjectCount(xpath);
					//					System.out.println(count);
					if(count>=1)
					{
						//System.out.println("Ready to set values in Company Add Custom Fields form....");
						String xpath1=".//*[@id='form1']//*[@class='control-group']";
						String xpath2="//*[@class='controls']//*[@name]";
						for(int i=1;i<=count;i++)
						{
							Thread.sleep(2000);
							String my_xpath=xpath1+"["+i+"]"+xpath2;
							String myattributename="";
							try{myattributename	=	utilfunc.MakeElement(my_xpath).getAttribute("id");}
							catch(Exception e){}

							try
							{
								if (myattributename.equalsIgnoreCase("ApplicationId"))
								{
									try
									{
										if(StringUtils.isEmpty(CF_Application)==false)
										{
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Application);
											Thread.sleep(2000);//wait for 1 sec. So  ModuleId drop-down should load values accordingly
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Application+" is not exists inside the drop down.");
										}
									}catch(Exception error){System.out.println("Unable to set value into Application.");}
								}
								else if (myattributename.equalsIgnoreCase("ModuleId"))
								{
									try
									{
										if(StringUtils.isEmpty(CF_Module)==false)
										{
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Module);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Module+" is not exists inside the drop down.");
										}
									}catch(Exception error){System.out.println("Unable to set value into custom field module.");}
								}
								else if (myattributename.equalsIgnoreCase("IsActive"))
								{
									try
									{
										if(StringUtils.isEmpty(CF_Active)==false)
										{
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Active);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Active+" is not exists inside the drop down.");
										}
									}catch(Exception error){System.out.println("Unable to set value for Active?.");}
								}
								else if (myattributename.equalsIgnoreCase("InputType"))
								{
									try{
										if(StringUtils.isEmpty(CF_Input_Type)==false)
										{
											try{
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Input_Type);
											if(CF_Input_Type.equalsIgnoreCase("Drop Down Selection"))
											{
												Thread.sleep(2000);

												if(CF_Selection_Fields_Count>1)
												{
													for(int g=1;g<=CF_Selection_Fields_Count;g++)
													{
														Thread.sleep(900);
														String CF_Selection_Fields_Value1=CF_Selection_Fields_Value+g;
														String IT_xpath=".//*[@id='grp-selection']//table/tbody/tr["+g+"]/td[1]/input";
														//													System.out.println(CF_Selection_Fields_Value);
														//													System.out.println(IT_xpath);
														try{
															utilfunc.MakeElement(IT_xpath).sendKeys(CF_Selection_Fields_Value1);
														}catch(Exception error){System.out.println("Some problem here... ... ...");}
														if(g<CF_Selection_Fields_Count)
														{
															String add_more=".//*[@id='grp-selection']//*[@class='lbl-add']";
															try{utilfunc.MakeElement(add_more).click();}catch(Exception error){System.out.println("Unable to click on add more link or button");}
														}
													}
												}
											}
										}catch(Exception error){System.out.println("Something goes worng.");}
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Input_Type+" is not exists inside the drop down.");
										}
									}catch(Exception error){System.out.println("Unable to set value for Input type");}
								}
								else if (myattributename.equalsIgnoreCase("IsRequired"))
								{
									try
									{
									if(StringUtils.isEmpty(CF_Required_Input)==false)
									{
										//System.out.println("\n\n==========\n"+my_xpath);
										//System.out.println("\n\n==========\n"+CF_Required_Input);
										utilfunc.DeSelectdropdownvalue(my_xpath);
										utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Required_Input);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(my_xpath);
										System.out.println("\nValue -"+CF_Required_Input+" is not exists inside the drop down.");
									}
									}catch(Exception errro){System.out.println("Unable to set IsRequired.");}
								}
								else if (myattributename.equalsIgnoreCase("DataFieldName"))
								{
									try{utilfunc.MakeElement(my_xpath).sendKeys(CF_Name);}catch(Exception error){System.out.println("Unable to set DataFieldName.");}
								}
								else if (myattributename.equalsIgnoreCase("HelpText"))
								{
									try{utilfunc.MakeElement(my_xpath).sendKeys(CF_Help_Text);}catch(Exception error){System.out.println("Unable to set Helptext.");}
								}
								else if (myattributename.equalsIgnoreCase("Note"))
								{
									try{utilfunc.MakeElement(my_xpath).sendKeys(CF_Note);}catch(Exception error){System.out.println("Unable to set Note.");}
								}
							}
							catch(Exception err)
							{
								System.out.println("Some Error occure. Error description : "+err);
							}
						}
					}

				}
				catch(Exception err)
				{
					System.out.println(err);
				}

				try{
					// save button after saving all data..
					String saveBtn	=	".//*[@id='btnSave']";
					try{utilfunc.MakeElement(saveBtn).click();}catch(Exception error){System.out.println("Unable to click on save button.");}

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
						utilfunc.TakeScreenshot();
						webdriver.navigate().back();
					}else if (error_flag.contains("Success!")){
						Flag=true;
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}
				}
				catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
				}

			}//if(mode.equalsIgnoreCase("New")) Ends Here

			/**
			 * 
			 * 
			 * 
			 */

			if(mode.equalsIgnoreCase("Edit"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				try
				{
					//					System.out.println("User is Edit Custom Field Form");

					boolean Search_Page_flag	=	Search(CF_Name,CF_Application,CF_Input_Type,CF_Module);
					Thread.sleep(2000);
					System.out.println("\n=====\nSearch operation finished!!!\n=====\n");
					/*Match the record value*/
					int row_number	=	matchrecord(CF_Name,CF_Application,CF_Input_Type,CF_Module); 
					System.out.println("\n=====\nMatch operation finished!!!\n=====\n");
					Thread.sleep(2000);
					/*if record value match */
					if(row_number>0)
					{
						String EditBtn = ".//*[@class='table table-item-list']//tbody//tr["+row_number+"]//td//*[@class='icon-edit']";
						try
						{
							utilfunc.MakeElement(EditBtn).click();
						}
						catch(Exception error)
						{
							System.out.println("\nError occured during click the edit button!!!.\n");
						}
						System.out.println("User Click on the record number "+row_number+" in Search result for edit.");
						System.out.println("\n=====\nUser should be redirected to edit page!!!\n=====\n");
						int count=0;
						String xpath=".//*[@id='form1']//*[@class='control-group']//div";
						count = utilfunc.GetObjectCount(xpath);
						//						System.out.println(count);
						if(count>=1)
						{
							System.out.println("Ready to set values in Company Add Custom Fields form....");
							String xpath1=".//*[@id='form1']//*[@class='control-group']";
							String xpath2="//*[@class='controls']//*[@name]";
							for(int i=1;i<=count;i++)
							{
								Thread.sleep(2000);
								String my_xpath=xpath1+"["+i+"]"+xpath2;
								String myattributename="";
								try{
									myattributename	=	utilfunc.MakeElement(my_xpath).getAttribute("id");}
								catch(Exception e){}
								//											if(myattributename.isEmpty())
								//											{
								//												continue;
								//											}

								//								System.out.println("New path:  "+my_xpath);
								//								System.out.println("atrr: "+myattributename);

								try
								{
									if (myattributename.equalsIgnoreCase("ApplicationId"))
									{
										if(StringUtils.isEmpty(CF_Application_Edit)==false)
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Application_Edit);
											Thread.sleep(2000);//wait for 1 sec. So  ModuleId drop-down should load values accordingly
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Application_Edit+" is not exists inside the drop down.");
										}
									}
									else if (myattributename.equalsIgnoreCase("ModuleId"))
									{
										if(StringUtils.isEmpty(CF_Module_Edit)==false)
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Module_Edit);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Module_Edit+" is not exists inside the drop down.");
										}
									}
									else if (myattributename.equalsIgnoreCase("IsActive"))
									{
										if(StringUtils.isEmpty(CF_Active)==false)
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Active);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Active+" is not exists inside the drop down.");
										}
									}
									else if (myattributename.equalsIgnoreCase("InputType"))
									{
										if(StringUtils.isEmpty(CF_Input_Type)==false)
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Input_Type);
											//Check if Selected option is not dropdown Selection
											if(CF_Input_Type.equalsIgnoreCase("Drop Down Selection"))
											{
												String del_old_xpath=".//*[@id='grp-selection']//table/tbody/tr";
												String del_addmore_xpath2="/td[2]//*[@class='icon-trash icon-muted']";
												int count_no_addmore_int=utilfunc.GetObjectCount(del_old_xpath);
												//This loop will delete add last values and textbox 
												for(int w=count_no_addmore_int;w>=1;w--)
												{
													Thread.sleep(400);
													String del_addmore_xpath=del_old_xpath+"["+w+"]"+del_addmore_xpath2;
													//													System.out.println("Current Delete xpath : "+del_addmore_xpath);
													utilfunc.MakeElement(del_addmore_xpath).click();
													Alert alt= webdriver.switchTo().alert();
													Thread.sleep(600);
													alt.accept();
												}
												//												Thread.sleep(10000);
												//												System.out.println("\n-\n-\n-\n-\n-All previious values are deleted.\n-\n-\n-\n-\n-");
												//												Thread.sleep(10000);
												Random randomGenerator = new Random();
												for(int g=1;g<=CF_Selection_Fields_Count;g++)
												{
													Thread.sleep(700);
													String IT_xpath=".//*[@id='grp-selection']//table/tbody/tr["+g+"]/td[1]/input";
													//System.out.println(CF_Selection_Fields_Value);
													//System.out.println(IT_xpath);
													utilfunc.MakeElement(IT_xpath).clear();
													int randomInt = randomGenerator.nextInt(999);
													utilfunc.MakeElement(IT_xpath).sendKeys(CF_Selection_Fields_Value+"_"+randomInt+"_"+g);
													if(g<CF_Selection_Fields_Count)
													{
														String add_more=".//*[@id='grp-selection']//*[@class='lbl-add']";
														utilfunc.MakeElement(add_more).click();
													}
												}
											}
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Input_Type+" is not exists inside the drop down.");	
										}
									}
									else if (myattributename.equalsIgnoreCase("IsRequired"))
									{
										if(StringUtils.isEmpty(CF_Required_Input)==false)
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											utilfunc.Selectdropdownvaluebytext(my_xpath, CF_Required_Input);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(my_xpath);
											System.out.println("\nValue -"+CF_Required_Input+" is not exists inside the drop down.");
										}
									}
									else if (myattributename.equalsIgnoreCase("DataFieldName"))
									{
										utilfunc.MakeElement(my_xpath).clear();
										utilfunc.MakeElement(my_xpath).sendKeys(CF_Name_Edit);

									}
									else if (myattributename.equalsIgnoreCase("HelpText"))
									{
										utilfunc.MakeElement(my_xpath).clear();
										utilfunc.MakeElement(my_xpath).sendKeys(CF_Help_Text);
									}
									else if (myattributename.equalsIgnoreCase("Note"))
									{
										utilfunc.MakeElement(my_xpath).clear();
										utilfunc.MakeElement(my_xpath).sendKeys(CF_Note);
									}
								}
								catch(Exception err)
								{
									System.out.println("Some Error occure. Error description : "+err);
								}
							}


						}

					}
					else
					{
						System.out.println("No Data Found!");
						error_msg="No Data Found!";
						utilfunc.TakeScreenshot();
						Flag=false;
					}

					try{
						// save button after saving all data..
						String saveBtn	=	".//*[@id='btnSave']";
						try{
							utilfunc.MakeElement(saveBtn).click();
						}catch(Exception error){}

						//								System.out.println("Test case id:");
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
						}else if (error_flag.contains("Success!")){
							Flag=true;
						}else if (error_msg.equals(ExpectedErrorMessage)){
							Flag=true;
							utilfunc.globalerrormessage=error_msg;
							utilfunc.ErrorMessage4=error_msg;
							utilfunc.TakeScreenshot();
							Thread.sleep(1000);
						}else{
							Flag=false;
							utilfunc.TakeScreenshot();
						}
					}
					catch(Exception e){
						Flag	=	false;
						System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
					}	



				}
				catch(Exception err)
				{
					System.out.println(err);
				}





			}//if(mode.equalsIgnoreCase("New")) Ends Here

			/**
			 * Delete 
			 */
			if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");						
				try{
					boolean Search_Page_flag	=	Search(CF_Name,CF_Application,CF_Input_Type,CF_Module);
					Thread.sleep(2000);
					/*Match the record value*/
					int row_number	=	matchrecord(CF_Name,CF_Application,CF_Input_Type,CF_Module);  
					Thread.sleep(2000);
					/*if record value match */
					if(row_number>=1)
					{
						String EditBtn = ".//*[@class='table table-item-list']//tbody//tr["+row_number+"]//td//*[@class='icon-trash']";
						utilfunc.MakeElement(EditBtn).click();
						System.out.println("User Click on the record number "+row_number+" in Search result for Delete.");
						Alert alt= webdriver.switchTo().alert();
						alt.accept();

					}
					else
					{
						System.out.println("No Data Found!");
						error_msg="No Data Found!";

					}



					String  error_flag="";
					try{
						error_flag=utilfunc.ErrorMessagehandlerExperiment();
					}
					catch(Exception e){}
					if (error_flag.equals("")){
						Flag=false;
					}else if (error_flag.contains("Success!")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else if (error_msg.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.globalerrormessage=error_msg;
						utilfunc.ErrorMessage4=error_msg;
						utilfunc.TakeScreenshot();
						Thread.sleep(1000);
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}
					utilfunc.TakeScreenshot();



				}
				catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
				}


			}
		}//if(TestcaseRunMode.equals("Y")) Ends Here
		return Flag;
	}//public boolean Company_Custom_Field.... Ends here

	public boolean Search(String CF_Name,String CF_Application,String CF_Input_Type,String CF_Module)
	{
		boolean Flag	=	false;
		// Search code Start here
		String serach_xpath=".//*[@class='project-search']//tr//td//*[@name]";
		int count_SE = utilfunc.GetObjectCount(serach_xpath);
		try
		{
			if(count_SE>=1){
				String xpath=".//*[@class='project-search']//tr";
				String xpath1="//td";
				String xpath2="//*[@name]";
				String xpath4="";
				int count_tr=utilfunc.GetObjectCount(xpath);
				String myattributename="";
				for(int e=1;e<=count_tr;e++){
					String xpath3=xpath+"["+e+"]"+xpath1;
					int count_td=utilfunc.GetObjectCount(xpath3);
					for(int f=1;f<=count_td;f++){
						xpath4=xpath3+"["+f+"]"+xpath2;
						/* try catch in one line*/			try{ myattributename	=	utilfunc.MakeElement(xpath4).getAttribute("id");}	catch(Exception er){}
						// Now get values from xls sheet
						try{
							if (myattributename.equalsIgnoreCase("ApplicationName"))
							{
								if(CF_Application!=null)
								{
									utilfunc.Selectdropdownvaluebytext(xpath4, CF_Application);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(xpath4);
									System.out.println("\nValue -"+CF_Application+" is not exists inside the drop down.");
								}
								//System.out.println(CF_Application);
							}
							else if (myattributename.equalsIgnoreCase("ModuleId"))
							{
								if(CF_Module!=null)
								{
									utilfunc.Selectdropdownvaluebytext(xpath4, CF_Module);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(xpath4);
									System.out.println("\nValue -"+CF_Module+" is not exists inside the drop down.");
								}
								//System.out.println(CF_Module);
							}
							else if (myattributename.equalsIgnoreCase("InputType"))
							{
								if(CF_Input_Type!=null)
								{
									utilfunc.Selectdropdownvaluebytext(xpath4, CF_Input_Type);
								}
								else
								{
									utilfunc.DeSelectdropdownvalue(xpath4);
									System.out.println("\nValue -"+CF_Input_Type+" is not exists inside the drop down.");								
								}
								//System.out.println(CF_Input_Type);
							}
							else if (myattributename.equalsIgnoreCase("txtDataFieldName"))
							{
								utilfunc.MakeElement(xpath4).sendKeys(CF_Name);
								//System.out.println(CF_Name);
							}
						}
						catch(Exception err){
							System.out.println("Some Error occure. Error description : "+err);
						}
					}
				}
				// Click on search button			
				try{
					String SearchBtn	=	".//*[@id='btnSearch']";
					utilfunc.MakeElement(SearchBtn).click();
				}catch(Exception e){
					System.out.println("Error occured during click the Search button.");
				}

				String result_row_count_xpath=".//*[@class='table table-item-list']//tbody//tr";
				int count=utilfunc.GetObjectCount(result_row_count_xpath);
				if(count>=1){Flag=true;}else{Flag=false;}

			}//if(count_SE>=1)ENDS HERE
		}//try ENDS HERE
		catch(Exception error)
		{
			Flag=false;
			System.out.println("Error occure during Search. Error Description : "+ error);
		}
		// Search code Ends here
		return Flag;	
	}

	public int matchrecord(String CF_Name,String CF_Application,String CF_Input_Type,String CF_Module)
	{
		int No_data_Found=0;
		int flag=0;
		System.out.println("Record matching start. Please wait... ... ...");
		String xpath,result_row_count_xpath,result_td_count_xpath="";
		result_row_count_xpath=".//*[@class='table table-item-list']//tbody//tr";
		int count=utilfunc.GetObjectCount(result_row_count_xpath);
		int total_result_row_count=count;
		System.out.println("Count ="+count);
		if(count>=1)
		{

			for(int l=1;l<=count;l++)
			{
				result_td_count_xpath=result_row_count_xpath+"["+l+"]//td";
				int count_td=utilfunc.GetObjectCount(result_td_count_xpath);

				boolean flag1=false;boolean flag2=false;boolean flag3=false;boolean flag4=false;
				for(int p=1;p<=count_td;p++)
				{
					xpath	=	result_td_count_xpath+"["+p+"]";
					String get_result_value="";
					get_result_value=utilfunc.MakeElement(xpath).getText();
					System.out.println(get_result_value);
					try{

						if(get_result_value.equalsIgnoreCase("No Data Found!"))
						{
							System.out.println("No Data Found!");
							flag=0; //set flag false or 0 
							No_data_Found=1;
							break;

						}
						if(get_result_value.equalsIgnoreCase(CF_Name))
						{flag1=true;}
						else if(get_result_value.equalsIgnoreCase(CF_Application))
						{flag2=true;}
						else if(get_result_value.equalsIgnoreCase(CF_Input_Type))
						{flag3=true;}
						else if(get_result_value.equalsIgnoreCase(CF_Module))
						{flag4=true;}
						else{}

					}
					catch(Exception e){}
				}

				/*
					System.out.println(flag1);
					System.out.println(flag2);
					System.out.println(flag3);
					System.out.println(flag4);
				 */
				// Now Check all flags
				if((flag1==true)&&(flag2==true)/*&&(flag3==true)*/&&(flag4==true))
				{
					flag=l;
					break;
				}
				else{flag=0;}

				if(No_data_Found==1)
				{
					flag=0;
				}
				else if((l==total_result_row_count)&&(flag==0))
				{
					System.out.println("\n\nNow record Match with values provided by user so we are going to edit/delete first record in result.\n\n");
					flag=1;
				}

			}
		}


		return flag;
	}
}
