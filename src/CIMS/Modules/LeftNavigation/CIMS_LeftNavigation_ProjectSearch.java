package CIMS.Modules.LeftNavigation;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.UtilFunction;

public class CIMS_LeftNavigation_ProjectSearch {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_LeftNavigation_ProjectSearch(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean ProjectSearch(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module with "+mode+" Mode.");
		boolean Flag	=	false;

		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);

		if(TestcaseRunMode.equals("Y"))
		{
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Page_title									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);


			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;
			
			utilfunc.ErrorMessage1="";
			utilfunc.ErrorMessage2="";
			utilfunc.ErrorMessage4="";
			utilfunc.ErrorMessage5="";
			utilfunc.globalerrormessage="";


			//Now Code here 

			//Variable declare
			String  error_flag="";
			String utilError="";
			try
			{
				Flag=utilfunc.searchandcompare(Page_title);
			}
			catch(Exception error)
			{
				System.out.println("Error while executing script for "+sheetName+"Module." );
			}

			

			if(Flag==false)
			{
				utilError=utilfunc.ErrorMessage4;
				System.out.println("Please wait we are checking for error... ... ...");
				try{
					error_flag=utilfunc.ErrorMessagehandlerExperiment();
				}
				catch(Exception e){}
				System.out.println("We are done with error check.");
				System.out.println("error_flag---"+error_flag);
				if(error_flag.equals("Server Error in '/' Application.")){
					Flag=false;
					utilfunc.TakeScreenshot();
					webdriver.navigate().back();
				}
				else if(utilError.equals(ExpectedErrorMessage))
				{
					Flag=true;
					utilfunc.globalerrormessage=utilError;
					utilfunc.ErrorMessage4=utilError;
				}
				else if (error_flag.equals(ExpectedErrorMessage)){
					Flag=true;
					utilfunc.TakeScreenshot();
					webdriver.navigate().back();
				}
				else if(utilError.equalsIgnoreCase(ExpectedErrorMessage))
				{
					Flag=true;
					utilfunc.TakeScreenshot();
					utilfunc.ErrorMessage1=ExpectedErrorMessage;
					utilfunc.globalerrormessage=ExpectedErrorMessage;
					webdriver.navigate().back();
				}
				else
				{
					utilfunc.ErrorMessage4=utilError;
					//utilfunc.TakeScreenshot();
				}
			}
		}
		return Flag;
	}

}
