package CIMS;

import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Reports.*;

public class CIMS_ClearTemp {

	private String 						sysDate;
	private WebDriver 					webdriver;		
	private UtilFunction 				utilfunc;


	private CIMS.Reports.dashboard 		obj_Report_Dashboard;

	//timer
    StopWatch pageLoad = new StopWatch();


	@BeforeClass
	public void Setter(){
		setobj_dashboard((new dashboard()));
	}


@Test
public void ClearTempFiles() throws InterruptedException, IOException, AWTException{

	/**
	 * clear temp files before generating reports
	 */

/*
	System.out.println("now clearing temp...");
	Thread.sleep(1000);
	obj_Report_Dashboard.WriteToFile("",dashboard.barGraphFilePath);
	Thread.sleep(1000);
	obj_Report_Dashboard.WriteToFile("",dashboard.failCounterFilePath);
	Thread.sleep(1000);
	obj_Report_Dashboard.WriteToFile("",dashboard.totalTimeFilePath);
	
*/	Thread.sleep(1000);

	// clear temp files of counter..
		
	File tempDir = new File(dashboard.projectReportTempPath);

	try {
		File[] files = tempDir.listFiles();
		for (File file : files) {
			// skip in case of directory..
			if(!file.isDirectory()){
				Thread.sleep(100);
	//			System.out.println("fff "+file.getCanonicalPath());
				try {
					obj_Report_Dashboard.WriteToFile("", file.getCanonicalPath());
					System.out.println("file : "+file.getCanonicalPath() + " is now clean");
				} catch (Exception e) {
					System.out.println("error occured for "+file.getCanonicalPath());
				}
			}
		}
		System.out.println("suite's temp file is clear");
	} catch (IOException e) {
		System.out.println("unable to clear temp of counters");
	}

	Thread.sleep(1000);
	// clear temp files of suites

	System.out.println("now clearing temp suite...");
		File dir = new File(dashboard.projectReportTempSuitePath);

		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				// skip in case of directory..
				if(!file.isDirectory()){
				Thread.sleep(100);
//				System.out.println("fff "+file.getCanonicalPath());
				try {
					obj_Report_Dashboard.WriteToFile("", file.getCanonicalPath());
					System.out.println("file : "+file.getCanonicalPath() + " is now clean");
				} catch (Exception e) {
					System.out.println("error occured for "+file.getCanonicalPath());
				}
				}
			}
			System.out.println("suite's temp file is clear");
		} catch (IOException e) {
			System.out.println("unable to clear temp of suites");
		}

		String CurrentDateAndTime	=	getCurrentDateAndTime("MM/dd/yyyy HH:mm:ss");

		try {
			System.out.println("curent time is : "+CurrentDateAndTime);
			obj_Report_Dashboard.WriteToFile(CurrentDateAndTime.toString(), dashboard.projectReportTempPath+"start_time");
			System.out.println("added start time to dashboard");
		} catch (Exception e) {
			System.out.println("some issue occured while adding time for dashboard");
		}

		// now save start date & time in temp file to
//		obj_Report_Dashboard.WriteToFile(CurrentDateAndTime.toString(), dashboard.projectReportTempPath+"start_time");
}


public String getCurrentDateAndTime(String myDateFormat){
	 // Create object of SimpleDateFormat class and decide the format
	DateFormat dateFormat = new SimpleDateFormat(myDateFormat);
	//get current date time with Date()
	Date date = new Date();
	// Now format the date
	return dateFormat.format(date);
}



//dashboard report

	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}
	

	// Below Methods are getters and setters for Test Parameters.	


		public String getSysDate() {
			return sysDate;
		}
		
		public WebDriver getDriver() {
			return webdriver;
		}
		
		public void setDriver(String browser) {
			this.webdriver = UtilFunction.getDriver(browser);
		}
		
		public void setSysDate(String sysdate) {
			this.sysDate = sysdate ;
		}
		
		public UtilFunction getUtilfunc() {
			return utilfunc;
		}

		
		public void setUtilfunc(UtilFunction utilfunc) {
			this.utilfunc = utilfunc;
		}

}
