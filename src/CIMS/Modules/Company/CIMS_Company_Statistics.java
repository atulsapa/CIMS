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


public class CIMS_Company_Statistics {


	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;


	public CIMS_Company_Statistics(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Statistics(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module");
		boolean Flag	=	false;

		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);	
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Year_founded									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String Year_became_a_client							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String Federal_Tax_ID							    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String State_Tax_ID								    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String World_Wide_Employee_Count				    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String US_Employee_Count						    =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String TARP_Recipent							    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String Gross_Revenues							    =			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String Net_Revenues								    =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String Reporting_Year							    =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String ExpectedErrorMessage							= 			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);		

		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;
			if((mode.equalsIgnoreCase("Edit"))||(mode.equalsIgnoreCase("New")))
			{
				String xpath1		=		".//*[@id='form1']//*[@class='control-group']";
				String xpath2		=		"//*[@id]";
				int count			=		utilfunc.GetObjectCount(xpath1);
				//Execute only if number of elements are found..
				if(count>=1)
				{
					System.out.println("\nReady to set values in "+sheetName+"module in "+mode+" mode.\n");
					for(int i=1;i<=count;i++)
					{
						try{
							Thread.sleep(1000);
							String mypath	=	xpath1 + "["+Integer.toString(i)+"]" + xpath2;
							String myattributename	=	utilfunc.MakeElement(mypath).getAttribute("name");
							System.out.println("New path:  "+mypath);
							System.out.println("atrr: "+myattributename);

							if (myattributename.equalsIgnoreCase("YearFounded"))
							{
								try{
									if(Year_founded!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Year_founded);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Year_founded+" is not exists inside the drop down.");
									}
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+Year_founded+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("YearBecameClient"))
							{
								try{
									if(Year_became_a_client!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Year_became_a_client);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Year_became_a_client+" is not exists inside the drop down.");
									}
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+Year_became_a_client+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("FederalTaxId"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(Federal_Tax_ID);
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+Federal_Tax_ID+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("StateTaxId"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(State_Tax_ID);
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+State_Tax_ID+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("WorldwidEmployeeCount"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(World_Wide_Employee_Count);
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+World_Wide_Employee_Count+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("UnitedStatesEmployeeCount"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(US_Employee_Count);
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+US_Employee_Count+" is Set for "+i+"th field.");
							}

							else if(myattributename.equalsIgnoreCase("IsTARP_Recipient"))
							{
								try{
									if(TARP_Recipent!=null)
									{
										try{
											if(TARP_Recipent.equalsIgnoreCase("true"))
											{
												mypath=mypath+"[@value='True']";
												utilfunc.MakeElement(mypath).click();
												//System.out.println(" -0- Value YES is Set for "+i+"th field.");
											}
											else if(TARP_Recipent.equalsIgnoreCase("false"))
											{
												mypath=mypath+"[@value='False']";
												utilfunc.MakeElement(mypath).click();
												//System.out.println(" -0- Value NO is Set for "+i+"th field.");
											}
										}catch (Exception e1) {}
									}
									else
									{

										System.out.println("\nValue -"+TARP_Recipent+" is not exists within the radio button.");
									}
								}catch (Exception e1) {}

							}
							else if (myattributename.equalsIgnoreCase("GrossRevenue"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(Gross_Revenues);
								}catch (Exception e1) {}//System.out.println(" -0- Value "+Gross_Revenues+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("NetRevenue"))
							{
								try{
									utilfunc.MakeElement(mypath).clear();
									utilfunc.MakeElement(mypath).sendKeys(Net_Revenues);
								}catch (Exception e1) {}//System.out.println(" -0- Value "+Net_Revenues+" is Set for "+i+"th field.");
							}
							else if (myattributename.equalsIgnoreCase("ReportingYear"))
							{
								try{
									if(Reporting_Year!=null)
									{
										utilfunc.Selectdropdownvaluebytext(mypath, Reporting_Year);
									}
									else
									{
										utilfunc.DeSelectdropdownvalue(mypath);
										System.out.println("\nValue -"+Reporting_Year+" is not exists inside the drop down.");
									}
								}catch (Exception e1) {}
								//System.out.println(" -0- Value "+Reporting_Year+" is Set for "+i+"th field.");
							}
						}catch (Exception e1) {}

					} // for(int i=1;i<=count;i++) ENDS here
					
					
					// Save button click event and Flag assignment...
					try{
						
						String saveBtn	=	".//*[@id='btnSave']";
						try {utilfunc.MakeElement(saveBtn).click();} catch (Exception e1) {System.out.println("Error while click the save button. Error Details are as: "+e1);}
						String  error_flag="";
						try
						{
							error_flag=utilfunc.ErrorMessagehandlerExperiment();
						}
						catch(Exception e)
						{
						}
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
					catch(Exception e)
					{
						Flag	=	false;
						System.out.println("Data is not saved. Some error occured.");
					}
				} // if(count>=1) ENDS here
			} // if(mode.equalsIgnoreCase("Edit")) ENDS here

			
			else if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("User is deleting "+sheetName+" module");
				utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
				Flag= true;
				utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
				return Flag;
			}

		} // if(TestcaseRunMode.equals("Y")).. ENDS here
		return Flag;	
	} // public boolean Company_Statistics... function ENDS here
} // public class CIMS_Company_Statistics.... ENDS here