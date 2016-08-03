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

public class CIMS_Company_RelocationCompanySetup {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description	=	null;

	public CIMS_Company_RelocationCompanySetup(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_RelocationCompanySetup(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");
		boolean Flag	=	false;

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Company_Name									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);

		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			description = Company_Description;
			
			if((mode.equalsIgnoreCase("New"))||(mode.equalsIgnoreCase("Edit")))
			{
				try
				{
					//System.out.println("test");
					try
					{
					utilfunc.MakeElement(".//*[@id='searchCompanyName']").sendKeys(Company_Name);
					}
					catch(Exception e){}
					int autolist_count=utilfunc.GetObjectCount(".//*[@id='ui-id-1']//li");
					if(autolist_count>1)
					{
						for(int u=1;u<=autolist_count;u++)
						{
							Thread.sleep(100);
							String list_xpath=".//*[@id='ui-id-1']//li["+u+"]";
							Thread.sleep(100);
							String get_text=utilfunc.MakeElement(list_xpath).getText();
							if(get_text.equalsIgnoreCase(Company_Name))
							{
								try{utilfunc.MakeElement(list_xpath).click();}catch(Exception e){}
								try{utilfunc.MakeElement(".//*[@id='btnCompanyAdd']").click();}catch(Exception e){}
								
								break;
							}
						}
					}//if() ENDS HERE
					else if(autolist_count==1)
					{
						String get_text=utilfunc.MakeElement(".//*[@id='ui-id-1']//li[1]").getText();
						if(get_text.equalsIgnoreCase(Company_Name))
						{
							try{utilfunc.MakeElement(".//*[@id='ui-id-1']//li[1]").click();}catch(Exception e){}
							try{utilfunc.MakeElement(".//*[@id='btnCompanyAdd']").click();}catch(Exception e){}
						}
						
					}
					else
					{
						System.out.println("No such company found.");
						Flag=false;
					}
				}
				catch(Exception error)
				{
					Flag=false;
				}
				
				
			}
			
			if(mode.equalsIgnoreCase("Delete"))
			{
				try
				{
					int added_company_count=utilfunc.GetObjectCount(".//*[@id='AddedLinkCompanyList']//li");
					if(added_company_count>1)
					{
						for(int u=1;u<=added_company_count;u++)
						{
							Thread.sleep(100);
							String list_xpath=".//*[@id='AddedLinkCompanyList']//li["+u+"]";
							Thread.sleep(100);
							String get_text=utilfunc.MakeElement(list_xpath).getText();
							if(get_text.equalsIgnoreCase(Company_Name))
							{
								list_xpath=list_xpath+"//*[@name='deleteCompany']";
								utilfunc.MakeElement(list_xpath).click();
								break;
							}
						}
						if(Flag!=true)
						{
							System.out.println("No such company found.");
						}
						
					}//if() ENDS HERE
					else if(added_company_count==1)
					{
						String list_xpath=".//*[@id='AddedLinkCompanyList']//li[1]";
						String get_text=utilfunc.MakeElement(list_xpath).getText();
						if(get_text.equalsIgnoreCase(Company_Name))
						{
							list_xpath=list_xpath+"//*[@name='deleteCompany']";
							try{utilfunc.MakeElement(list_xpath).click();}catch(Exception e){}
							
						}
						else
						{System.out.println("No such company found.");}
					}
					else
					{
						System.out.println("No company found.");
						Flag=false;
					}
				}
				catch(Exception error)
				{
					Flag=false;
				}
			}

		
			/// 
			try{
				try{utilfunc.MakeElement(".//*[@id='btnSave']").click();}catch(Exception e){}
				 
								
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
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
			}catch(Exception e){
				Flag	=	false;
				System.out.println("Data is not saved. Some error occured.");
			}
			
			
		}
		return Flag;
	}

}
