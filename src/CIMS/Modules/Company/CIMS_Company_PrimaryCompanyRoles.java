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
import CIMS.Modules.Custom.Company_Role;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;
import  org.apache.commons.lang3.StringUtils;

import util.UtilFunction;

public class CIMS_Company_PrimaryCompanyRoles {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;
	public String Primary_Company_Roles=null;
	
	private Company_Role obj_Company_Role;

	public CIMS_Company_PrimaryCompanyRoles(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_PrimaryCompanyRoles(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");

		setobj_Company_Role(new Company_Role(webdriver,utilfunc));

		boolean Flag	=	false;

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String PCR_Primary_Company_Roles					=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);


		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;
			Primary_Company_Roles=PCR_Primary_Company_Roles;

			Thread.sleep(1000);

			if((mode.equalsIgnoreCase("New"))||(mode.equalsIgnoreCase("Edit")))
			{

				String error_flag="";
				try{
					error_flag=utilfunc.ErrorMessagehandlerExperiment();
				}catch(Exception error){}

				if(error_flag.equals("Server Error in '/' Application.")){
					Flag=false;
					webdriver.navigate().back();
				}
				else
				{

					try
					{
						//set value in dropdown box
						String drpdwnbx_xpath="//*[@class='primaryContacts']//*[@ng-hide='hideRoleTypeList']//select";
						try {
							utilfunc.Selectdropdownvaluebytext(drpdwnbx_xpath, PCR_Primary_Company_Roles);
						} catch (Exception e1) {System.out.println("Unable to set value in drop down");}
						
						Thread.sleep(4000);
						
						try{
							 Flag = obj_Company_Role.CompanyRole(filename,sheetName,"primaryContacts",PCR_Primary_Company_Roles,TestcaseID,true);
							 
							 System.out.println("obj_Company_Role.CompanyRole Flag :"+Flag);
						}catch(Exception e){System.out.println("place ur message here..");}
						
					} 
					catch(Exception error)
					{	Flag=false;
					utilfunc.TakeScreenshot();
					System.out.println("Error Detils  :\n"+error);
					}
				}

			} 


		}
		System.out.println("Final flag before return :"+Flag);
		return Flag;
	}

	public void setobj_Company_Role(Company_Role setobj_Company_Role) {
		this.obj_Company_Role = setobj_Company_Role;
	}
}