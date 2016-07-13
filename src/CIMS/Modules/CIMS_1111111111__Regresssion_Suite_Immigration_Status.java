package CIMS.Modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_1111111111__Regresssion_Suite_Immigration_Status {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */
	
	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	 public CIMS_1111111111__Regresssion_Suite_Immigration_Status(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 public boolean Immigration_Documents_info(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			System.out.println("user is on '"+sheetName+"' module");
			System.out.println("entering "+mode+" mode for "+sheetName+" module");
			return false;
		// TODO Auto-generated method stub

	}

}
