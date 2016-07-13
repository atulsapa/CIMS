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

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
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



public class CIMS_Company_Report_List{

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_Company_Report_List(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Report_List(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");
		boolean Flag	=	false;

		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Role											=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String Type											=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String Name										    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String Report_category							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String Description								    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String Report_category_edit						    =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Description_edit							    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);


		if(TestcaseRunMode.equals("Y")){
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;
			/**
			 * New Report code START HERE
			 */
			String error_msg="";
			if(mode.equalsIgnoreCase("New")){

				// Code for click the Add New Report Button
				String newBtn	=	".//*[@id='panel-body']//*[@class='btn']";
				utilfunc.MakeElement(newBtn).click();

				String xpath=".//*[@id='panel-body']//*[@class='btn']";

				// update xpath form here LOKESH
				String xpath1=".//*[@id='form1']//*[@class='control-group']";
				String xpath2="//*[@id]";
				int count	= utilfunc.GetObjectCount(xpath1);

				//Execute only if number of elements are found..
				if(count>1){
					System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
					for(int i=1;i<=count;i++)
					{
						String mypath	=	xpath1 + "["+Integer.toString(i)+"]" + xpath2;
						String myattributename	=	utilfunc.MakeElement(mypath).getAttribute("name");
						System.out.println("New path:  "+mypath);
						System.out.println("atrr: "+myattributename);
						Thread.sleep(800);

						try
						{
							if (myattributename.equalsIgnoreCase("RoleId"))
							{
								try{
									if(Role!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Role);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Role+" is not exists inside the drop down.");
									}
								}catch(Exception e){}
								//System.out.println("Value "+Role+" is Set for "+i+"th field.");
							}
							if (myattributename.equalsIgnoreCase("ReportType"))
							{
								try{
									if(Type!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Type);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Type+" is not exists inside the drop down.");
									}
								}catch(Exception e){}
								//System.out.println("Value "+Type+" is Set for "+i+"th field.");
							}
							if (myattributename.equalsIgnoreCase("ReportId"))
							{
								try{
									if(Name!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Name);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Name+" is not exists inside the drop down.");
									}
								}catch(Exception e){}
								//System.out.println("Value "+Name+" is Set for "+i+"th field.");
							}
							if (myattributename.equalsIgnoreCase("Category"))
							{
								try{
									if(Report_category!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Report_category);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Report_category+" is not exists inside the drop down.");
									}
								}catch(Exception e){}
								//System.out.println("Value "+Report_category+" is Set for "+i+"th field.");
							}
							if (myattributename.equalsIgnoreCase("Description"))
							{
								try{
									utilfunc.MakeElement(mypath).sendKeys(Description);
								}catch(Exception e){}
								//System.out.println("Value "+Description+" is Set for "+i+"th field.");
							}

						}
						catch(Exception error)
						{
							System.out.println("Error: "+ error);
						}
					}


					try{
						// save button after saving all data..
						String saveBtn	=	".//*[@class='pull-right']//*[@id='btnSave']";
						try {
							utilfunc.MakeElement(saveBtn).click();
						} catch (Exception e1) {
							System.out.println("Error while click on save button. "+e1);
						}
						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario execution completed");
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
						System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
					}

				}
			}
			/**
			 * New Report code ENDS HERE
			 */
			//******************************//
			/**
			 * Edit Report code START HERE
			 */

			if(mode.equalsIgnoreCase("Edit")){
				// Search record code START Here. Before edit we search for record
				System.out.println("Edit mode start");
				try
				{
					/*Set value & click Search Btn*/ 
					Search(Role, Type, Name, Report_category, Description);	 //obj_CIMS_Company_Report_List.Search(Role,Type,Name,Report_category,Description);
					/*Match the record value*/ 
					Thread.sleep(1000);
					int row_number=matchrecord(Role, Type, Name, Report_category, Description);   //row_number	=	obj_CIMS_Company_Report_List.matchrecord(Role,Type,Name,Report_category,Description);  
					System.out.println("\n\n=====\n---matchrecord return value is :"+row_number+"\n---\n=====\n");
					/*if record value match */		 
					if(row_number>0)
					{	
						Thread.sleep(250);
						String EditBtn= ".//*[@class='table table-item-list']//tbody//tr["+row_number+"]//*[@class='icon-edit']";
						System.out.println(EditBtn);
						Thread.sleep(1000);
						utilfunc.MakeElement(EditBtn).click();
						System.out.println("User Click on the record number "+row_number+" in Search result for edit.");

						String xpath_search1=".//*[@id='form1']//div[@class='control-group']";
						String xpath_search2="//div[@class='controls']//*[@name]";

						int count_tr=utilfunc.GetObjectCount(xpath_search1);
						for(int i=1;i<=count_tr;i++)
						{
							String xpath_search=xpath_search1+"["+i+"]"+xpath_search2;
							String myattributename	=	utilfunc.MakeElement(xpath_search).getAttribute("name");
							//System.out.println(myattributename);
						}
						Thread.sleep(100);
						//* Search record code ENDS Here
						String xpath=".//*[@id='panel-body']//*[@class='btn']";

						// update xpath form here LOKESH
						String xpath1=".//*[@id='form1']//*[@class='control-group']";
						String xpath2="//*[@id]";
						int count	=	utilfunc.GetObjectCount(xpath1);

						//Execute only if number of elements are found..
						if(count>1){
							System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
							for(int i=1;i<=count;i++)
							{
								String mypath	=	xpath1 + "["+Integer.toString(i)+"]" + xpath2;
								String myattributename	=	utilfunc.MakeElement(mypath).getAttribute("name");
								//System.out.println("New path:  "+mypath);
								//System.out.println("atrr: "+myattributename);
								Thread.sleep(1000);

								try
								{
									//				if (myattributename.equalsIgnoreCase("RoleId"))
									//				{
									//					utilfunc.Selectdropdownvaluebytext(mypath, Role);
									//					System.out.println("Value "+Role+" is Set for "+i+"th field.");
									//				}
									//				if (myattributename.equalsIgnoreCase("ReportType"))
									//				{
									//					utilfunc.Selectdropdownvaluebytext(mypath, Type);
									//					System.out.println("Value "+Type+" is Set for "+i+"th field.");
									//				}
									//				if (myattributename.equalsIgnoreCase("ReportId"))
									//				{
									//					utilfunc.Selectdropdownvaluebytext(mypath, Name);
									//					System.out.println("Value "+Name+" is Set for "+i+"th field.");
									//				}
									if (myattributename.equalsIgnoreCase("Category"))
									{
										if(Report_category_edit!=null)
										{
											utilfunc.DeSelectdropdownvalue(mypath);
											Thread.sleep(800);
											utilfunc.Selectdropdownvaluebytext(mypath, Report_category_edit);
										}
										else
										{
											utilfunc.DeSelectdropdownvalue(mypath);
											System.out.println("\nValue -"+Report_category_edit+" is not exists inside the drop down.");
										}
										//System.out.println("Value "+Report_category+" is Set for "+i+"th field.");
									}
									else if (myattributename.equalsIgnoreCase("Description"))
									{
										utilfunc.MakeElement(mypath).clear();
										Thread.sleep(800);
										utilfunc.MakeElement(mypath).sendKeys(Description_edit);
										//System.out.println("Value "+Description+" is Set for "+i+"th field.");
									}
								}
								catch(Exception error)
								{
									System.out.println("Error: "+ error);
								}
							}



						}
					}

					else
					{
						System.out.println("No Data Found!");
						error_msg="No Data Found!";
						Flag=false;
						utilfunc.TakeScreenshot();
					}

					try{
						// save button
						String saveBtn	=	".//*[@class='pull-right']//*[@id='btnSave']";
						try{
							utilfunc.MakeElement(saveBtn).click();
						}catch(Exception error){}
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

					}catch(Exception e){
						Flag	=	false;
						utilfunc.TakeScreenshot();
						System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
					}


				}
				catch(Exception error)
				{System.out.println("Error occured for "+sheetName+ " sheet, due to following error: "+error.getMessage());
				}
			}

			/**
			 * Edit Report code ENDS HERE
			 */
			if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				/*Set value & click Search Btn*/	
				Search(Role, Type, Name, Report_category, Description);					//obj_CIMS_Company_Report_List.Search(Role,Type,Name,Report_category,Description);
				/*Match the record value*/ 		    
				int row_number=matchrecord(Role, Type, Name, Report_category, Description); //row_number	=	obj_CIMS_Company_Report_List.matchrecord(Role,Type,Name,Report_category,Description);  
				/*if record value match */			
				if(row_number>0)
				{	
					String DeleteBtn= ".//*[@class='table table-item-list']//tbody//tr["+row_number+"]//*[@class='icon-trash']";
					//				System.out.println(DeleteBtn);
					try{utilfunc.MakeElement(DeleteBtn).click();}catch(Exception error){System.out.println("Error while click delete button. "+error);}
					System.out.println("User Click on the record number "+row_number+" in Search result for Delete.");

					try{
						Alert alt= webdriver.switchTo().alert();
						alt.accept();
						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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

					}catch(Exception e){
						Flag	=	false;
						utilfunc.TakeScreenshot();
						System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
					}
				}else
				{
					System.out.println("No Data Found!");
					error_msg="No Data Found!";
					/*
					utilfunc.ErrorMessage1=utilfunc.ErrorMessage1+"No Data Found!";
					utilfunc.ErrorMessage2=utilfunc.ErrorMessage2+"No Data Found!";
					utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";*/
					
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

			}

		}

		return Flag;
	}

	public void Search(String Role,String Type,String Name,String Report_category,String Description)
	{
		// Search code Start here
		System.out.println("Prepare record search....");
		String serach_xpath=".//*[@id='panel-body']/tbody/tr/td/div/table//tr//td//*[@name]";
		int count_SE = utilfunc.GetObjectCount(serach_xpath);
		System.out.print("\n---\ncount_SE\t\t"+count_SE);
		try
		{
			if(count_SE>=1){
				String xpath=".//*[@id='panel-body']/tbody/tr/td/div/table//tr";
				String xpath1="//td";
				String xpath2="//*[@name]";
				String xpath4="";
				int count_tr=utilfunc.GetObjectCount(xpath);
				System.out.print("\n---\ncount_tr\t\t"+count_tr);
				String myattributename="";

				for(int e=1;e<=count_tr;e++){
					String xpath3=xpath+"["+e+"]"+xpath1;
					int count_td=utilfunc.GetObjectCount(xpath3);
					System.out.print("\n---\ncount_td\t\t"+count_td+"\n");
					for(int f=1;f<=count_td;f++){
						xpath4=xpath3+"["+f+"]"+xpath2;
						/* try catch in one line*/			try{
							//	utilfunc.waitForAnElementToLoad(xpath4, false);
							myattributename="";
							myattributename	=	utilfunc.MakeElement(xpath4).getAttribute("id");}	catch(Exception er){}
						// Now get values from xls sheet
						System.out.println("\n---myattributename's value is :"+myattributename);
						if(StringUtils.isEmpty(myattributename)==false)
						{
							try{
								if (myattributename.equalsIgnoreCase("RoleId"))
								{
									if(Role!=null)
									{
										utilfunc.Selectdropdownvaluebytext(xpath4, Role);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(xpath4);
										System.out.println("\nValue -"+Role+" is not exists inside the drop down.");
									}
									//System.out.println(Role);
								}
								else if (myattributename.equalsIgnoreCase("ReportType"))
								{
									if(Type!=null)
									{
										utilfunc.Selectdropdownvaluebytext(xpath4, Type);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(xpath4);
										System.out.println("\nValue -"+Role+" is not exists inside the drop down.");
									}
									//System.out.println(Type);
								}
								else if (myattributename.equalsIgnoreCase("ReportId"))
								{
									if(Name!=null)
									{
										utilfunc.Selectdropdownvaluebytext(xpath4, Name);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(xpath4);
										System.out.println("\nValue -"+Name+" is not exists inside the drop down.");
									}
									//System.out.println(Name);
								}
								else if (myattributename.equalsIgnoreCase("Category"))
								{
									if(Report_category!=null)
									{
										utilfunc.Selectdropdownvaluebytext(xpath4, Report_category);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(xpath4);
										System.out.println("\nValue -"+Report_category+" is not exists inside the drop down.");
									}
									//System.out.println(Report_category);
								}
								else if (myattributename.equalsIgnoreCase("Description"))
								{
									utilfunc.MakeElement(xpath4).sendKeys(Description);
									System.out.println(Description);
								}
								else if(myattributename.equalsIgnoreCase("divSearch"))
								{
									// Click on search button			
									try{
										String SearchBtn	=	".//*[@id='btnSearch']";
										utilfunc.MakeElement(SearchBtn).click();
										break;

									}catch(Exception err){
										System.out.println("Error occured during click the Search button."+err);
									}
								}
							}
							catch(Exception err){
								System.out.println("Some Error occure. Error description : "+err);
							}
						}//if ends here
					}
				}
			}//if(count_SE>=1)ENDS HERE

		}//try ENDS HERE
		catch(Exception error)
		{

			System.out.println("Error occure during Search. Error Description : "+ error);
		}
		// Search code Ends here
	}

	public int matchrecord(String Role,String Type,String Name,String Report_category,String Description) throws InterruptedException
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
			boolean flag1=false;boolean flag2=false;boolean flag3=false;boolean flag4=false;boolean flag5=false;
			for(int l=1;l<=count;l++)
			{
				System.out.println("Value of l is :"+l+"\n");
				Thread.sleep(1000);
				result_td_count_xpath=result_row_count_xpath+"["+l+"]//td";
				System.out.println("result_td_count_xpath: "+result_td_count_xpath);
				int count_td=utilfunc.GetObjectCount(result_td_count_xpath);
				System.out.println("Count_td ="+count_td);
				for(int p=1;p<=count_td;p++)
				{
					Thread.sleep(1000);
					xpath	=	result_td_count_xpath+"["+p+"]";
					String get_result_value="";
					get_result_value=utilfunc.MakeElement(xpath).getText();

					try{
						// Code if no record found 
						if(get_result_value.equalsIgnoreCase("No Data Found!"))
						{
							System.out.println("No Data Found!");
							No_data_Found=1;
							flag=0; //set flag false or 0 
							break;
						}

						if(get_result_value.equalsIgnoreCase(Role))
						{flag1=true;}
						else if(get_result_value.equalsIgnoreCase(Type))
						{flag2=true;}
						else if(get_result_value.equalsIgnoreCase(Name))
						{flag3=true;}
						else if(get_result_value.equalsIgnoreCase(Report_category))
						{flag4=true;}
						else if(get_result_value.equalsIgnoreCase(Description))
						{flag5=true;}
						else{}
					}
					catch(Exception e){}
				}
				// Now Check all flags
				if((flag1==true)&&(flag2==true)&&(flag3==true)&&(flag4==true)&&(flag5==true))
				{
					flag=1;
				}
				else{flag=0;}
				if(No_data_Found==1)
				{
					flag=0;
				}
				else if((l==total_result_row_count)&&(flag==0))
				{
					System.out.println("\n\nNo record Match with values provided by user so we are going to edit/delete first record in result.\n\n");
					flag=1;
				}
			}
		}

		return flag;
	}


}