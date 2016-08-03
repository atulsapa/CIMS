package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;

import bsh.This;
import CIMS.CIMS_Company;
import CIMS.CIMS_MainProject;
import CIMS.CIMS_Regression_Suite;
import CIMS.Modules.*;
import CIMS.Modules.GeneralAdmin.thread;
import CIMS.Reports.dashboard;



public class UtilFunction {

	private Robot Robot;

	// /ERROR MESSAGE VARIABLE/////

	public static String ErrorMessage = "";

	public static String ErrorMessage1 = "";

	public static String ErrorMessage2 = "";

	public static String ErrorMessage4 = "";

	public static String ErrorMessage5 = "";

	public static String ErrorMessage6 = "";

	public static String globalerrormessage = "";

	// /URL FETCH VARIABLE/////

	private static String fileName = CIMS_Regression_Suite.ExcelFileName;

	private static String sheetName = "URLANDNAME";

	private static String columnName = "Name";

	private static String columnName1 = "URL";

	public static String QuestionarieURL = null;

	public static String QuestionaireURL1 = "";

	public static String QuestionaireName = "";

	public static String moduleName = "";

	public static String Employee_namecheck = null;

	public static String timer;

	// screenshot link///

	public static String FilePath = "";

	private WebDriver driver;

	private String nodeId;
	
	
	private dashboard 									obj_Report_Dashboard;
	
	// Getter for driver.

	public WebDriver getDriver() {

		return driver;

	}

	// Setter for driver.

	public void setDriver(WebDriver driver) {

		this.driver = driver;

	}

	public static String Actualbrw = "";

	// //dsfs

	// Defining the Constructor of the Class

	public UtilFunction(WebDriver driver) {

		this.driver = driver;

		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		setobj_dashboard((new dashboard()));
		
	}

	/*
	 * ===================================Application access
	 * methods-Begin================================
	 */

	// Below method is written to start the application.

	public boolean startApplication(String fileName) {

		boolean startApplicationflag = false;

		try {

			Reporter.log("Opening Application URL is :"
					+ UtilFunction.getCellData(fileName, "Credentials", 1, 1));

			driver.get(UtilFunction.getCellData(fileName, "Credentials", 1, 1));

			// driver.get(getValueFromPropertiesFile("Config.properties",
			// "url_Tvesite"));

			startApplicationflag = true;

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(new Throwable(
					"Error occoured Opening the Application."));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return startApplicationflag;

	}

	// Below method is written to Log In the application.

	public boolean logIn() {

		boolean b = false;

		try {

			// driver.manage().deleteAllCookies();

			System.out.println("Login Call..");

			/*
			 * this.getWebelement("id",getValueFromPropertiesFile(
			 * "OR-Login&Logout.properties",
			 * "lh.login.username.textbox.id")).sendKeys
			 * (getValueFromPropertiesFile("Config.properties","username_LH"));

			 * 
			 * 
			 * this.getWebelement("id",getValueFromPropertiesFile(
			 * "OR-Login&Logout.properties",
			 * "lh.login.password.textbox.id")).clear();
	
			 * this.getWebelement("id",getValueFromPropertiesFile(
			 * "OR-Login&Logout.properties",
			 * "lh.login.password.textbox.id")).sendKeys
			 * (getValueFromPropertiesFile("Config.properties","password_LH"));
			 * 
			 * 
			 * this.getWebelement("class",getValueFromPropertiesFile(
			 * "OR-Login&Logout.properties",
			 * "lh.login.ok.button.class")).click();
			 */

			// if(this.getWebelement("linkText",getValueFromPropertiesFile("OR-Login&Logout.properties",
			// "lh.home.signout.link.textlink")).getText().equalsIgnoreCase("Log Out")){

			//

			// b=true;

			//

			// }

			b = true;

		} catch (Throwable e) {

			/*
			 * if(this.getWebelement("linkText",
			 * getValueFromPropertiesFile("OR-Login&Logout.properties",
			 * "lh.home.signout.link.textlink")).getText().equals("Log Out")){
			 * 
			 * b=false;
			 * 

			 * }else{

			 * 
			 * ErrorUtil.addVerificationFailure(e);

			 * this.takeScreenShot(System.getProperty("user.dir")+
			 * "/test-output/Error Screenshot/errorSceenshot"
			 * +UtilFunction.currentDateTime()+".jpg");
			 * 
			 * }
			 */

		}

		return b;

	}

	// Below method is written to Log Out the application.

	public boolean logOut() {

		boolean b = false;

		try {

			getWebelement(
					"linkText",
					getValueFromPropertiesFile("OR-Login&Logout.properties",
							"lh.home.signout.link.textlink")).click();

			Thread.sleep(5000);

			b = true;

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

			this.takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return b;

	}

	// Below method is written to start the application.

	public boolean closeWebDriver() {

		boolean b = false;

		try {

			driver.quit();

			b = true;

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return b;

	}

	/*
	 * ===================================Application access
	 * methods-End==================================
	 */

	/*
	 * ===================================Excel access
	 * methods-Begin========================================
	 */

	// Below method is written to read cell data from excel File.

	public static String getCellData(String fileName, String sheetNm,
			int coulmnNumber, int rowNumber) {

		String cellData = null;

		try {

			String filePath = System.getProperty("user.dir") + "/src/testData/"
					+ fileName;

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetNm.trim());

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(coulmnNumber);

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

				cellData = cell.getStringCellValue();

			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

				cellData = String.valueOf(cell.getNumericCellValue());

			}

		} catch (Throwable e) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while fetching the data from excel sheet."));

		}

		return cellData;

	}

	// Below Method is written to find the number of rows used in the excel
	// file.

	public static int usedRowCount(String fileName, String sheetName1) {

		int usedRows = 0;

		try {

			String filePath = System.getProperty("user.dir") + "/src/testData/"
					+ fileName;

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetName1.trim());

			usedRows = sheet.getPhysicalNumberOfRows();

			// usedRows=sheet.getLastRowNum()-sheet.getFirstRowNum();

		} catch (Throwable e) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while counting excel sheet used row count."));

		}

		// System.out.println("Used Rows are : " +usedRows);

		return usedRows;

	}

	// Below Method is written to find the number of columns used in the excel
	// file.

	public static int usedColumnCount(String fileName, String sheetName) {

		int usedColumns = 0;

		try {

			String filePath = System.getProperty("user.dir") + "/src/testData/"
					+ fileName;

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetName.trim());

			Row row = sheet.getRow(0);

			// changed

			for (int k = 0; k < 200; k++) {

				Cell cell = row.getCell(k);

				try {

					String cellData = cell.getStringCellValue();

				} catch (NullPointerException n) {

					usedColumns = k;

					break;

				}

			}

		} catch (Throwable e) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while counting  excel sheet used column count."));

		}

		return usedColumns;

	}

	// Below Method is written to get the Row Number of the Cell with a given
	// data cell data

	public static int getRowWithCellData(String fileName, String sheetName,
			String celldata) {

		int rowNumber = 0;

		String filePath = System.getProperty("user.dir") + "/src/testData/"
				+ fileName;

		try {

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetName.trim());

			int s = usedRowCount(fileName, sheetName);

			for (int j = 0; j < s; j++) {

				Row row = sheet.getRow(j);

				for (int k = 0; k <= 24; k++) {

					String cellData1 = "ABCDEFGHIJKLMOPQRSTUVWXYZ";

					Cell cell = row.getCell(k);

					try {

						cellData1 = cell.getStringCellValue();

					} catch (NullPointerException n) {

					}

					if (cellData1.equals(celldata)) {

						rowNumber = j;

						break;

					}

				}

			}

		} catch (Throwable t) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while getting the row number with data from excel sheet."));

		}

		return rowNumber;

	}

	// This method is to get the row count used of the excel sheet

	public static int getRowCount(String fileName, String sheetName,
			String celldata) {

		int number = 0;

		String filePath = System.getProperty("user.dir") + "/src/testData/"
				+ fileName;

		try {

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetName.trim());

			sheet = wb.getSheet(sheetName);

			number = sheet.getLastRowNum() + 1;

		} catch (Throwable t) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while getting the row count number with data from excel sheet."));

		}

		return number;

	}

	// Below Method is written to get the column Number of the Cell with a given
	// data cell data

	public static int getColumnWithCellData(String fileName, String sheetName,
			String celldata) {

		int columnNumber = 0;

		String filePath = System.getProperty("user.dir") + "/src/testData/"
				+ fileName;

		sheetName = sheetName.trim();

		try {

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			Sheet sheet = wb.getSheet(sheetName);

			int rowCount = usedRowCount(fileName, sheetName);

			int coulmnCount = usedColumnCount(fileName, sheetName);

			for (int i = 0; i < rowCount; i++) {

				Row row = sheet.getRow(i);

				for (int j = 0; j < coulmnCount; j++) {

					Cell cell = row.getCell(j);

					String cellData1 = cell.getStringCellValue();

					if (cellData1.equals(celldata)) {

						columnNumber = j;

						break;

					}

				}

			}

		} catch (Throwable t) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while getting the column number with data from excel sheet."));

		}

		return columnNumber;

	}

	// Below Method is written to Compare the column of two of excel.

	public static boolean areColumnEqual(String fileName, String sheetName,
			int firstColumn, int secondColumn) {

		boolean equal = true;

		for (int i = 1; i <= usedRowCount(fileName, sheetName) - 1; i++) {

			if (!(getCellData(fileName, sheetName, firstColumn, i)
					.equalsIgnoreCase(getCellData(fileName, sheetName,
							secondColumn, i)))) {

				if (!(getCellData(fileName, sheetName, 1, i)
						.equalsIgnoreCase("N/A"))) {

					ErrorUtil.addVerificationFailure(new Throwable(
							"Expected value in web service is not equal to actaul value for Tag Nmae :"
									+ (UtilFunction.getCellData(fileName,
											sheetName, 0, i))));

					equal = false;

					continue;

				}

			}

		}

		return equal;

		// commenting the below code and testing the above one.

		/*
		 * boolean equal = true ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * for(int i=1;i<=usedRowCount(fileName, sheetName)-1;i++){
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if(getCellData(fileName, sheetName, firstColumn,
		 * i).equalsIgnoreCase(getCellData(fileName, sheetName, secondColumn,
		 * i))){
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //equal = true ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }else{
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if(!(getCellData(fileName, sheetName, 1, i).equalsIgnoreCase("N/A")))
		 * {
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ErrorUtil.addVerificationFailure(new Throwable(
		 * "Expected value in web service is not equal to actaul value for Tag Nmae :"
		 * +(UtilFunction.getCellData(fileName, sheetName, 0, i))));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * equal = false ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * break ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */

	}

	// Below Method is written to get the add a cell in excel with data

	public static void setCellData(String fileName, String sheetName,
			int coulmnNumber, int rowNumber, String data) {

		try {

			String filePath = System.getProperty("user.dir") + "/src/testData/"
					+ fileName;

			InputStream inps = new FileInputStream(filePath);

			Workbook wb = new HSSFWorkbook(inps);

			/*
			 * Row = ExcelWSheet.getRow(RowNum);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			 */

			sheetName = sheetName.trim();

			Sheet sheet = wb.getSheet(sheetName);

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(coulmnNumber, Row.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				/*
				 * Cell = Row.createCell(ColNum);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * Cell.setCellValue(Result);
				 */

				cell = row.createCell(coulmnNumber);

				cell.setCellType(Cell.CELL_TYPE_STRING);

				cell.setCellValue(data);

			} else {

				cell.setCellValue(data);

			}

			FileOutputStream fileOut = new FileOutputStream(filePath);

			wb.write(fileOut);

			fileOut.close();

		} catch (Throwable t) {

			ErrorUtil.addVerificationFailure(new Throwable(
					"Error occoured while setting the data in Cell("
							+ rowNumber + "," + coulmnNumber
							+ ") in excel sheet."));

		}

	}

	/*
	 * ===================================Excel access
	 * methods-End========================================
	 */

	/*
	 * ===================================Utility
	 * methods-Begin===========================================
	 */

	// The method below is used to click on all the links on page with linked
	// text as linkText

	public void clickLinks(String linkText) {

		java.util.List<WebElement> list = driver.findElements(By
				.linkText(linkText));

		int numberOfWebElements = list.size();

		if (numberOfWebElements > 0) {

			try {

				for (int i = 0; i < numberOfWebElements; i++) {

					list.get(i).click();

					try {

						Thread.sleep(1000);

					} catch (InterruptedException e) {

						// TODO Auto-generated catch block

						e.printStackTrace();

					}

				}

			} catch (Throwable t) {

			}

		}

	}

	// Below Method is used to focus on a Web Element where the application has
	// lost the focus before reaching the specified control.

	public void focusWebelement(String elementID) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById('" + elementID + "').focus()");

	}

	// Below Method is written to take the Screen shot and save it at
	// Location(location)

	public void takeScreenShot(String location) {

		try {

			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshot, new File(location));

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

		}

	}

	// Below Method is written to get the web element at Location(locator) by
	// Method(byMethod)

	public WebElement getWebelement(String byMethod, String locator) {

		WebElement element = null;

		try {

			if (byMethod.equalsIgnoreCase("xpath")) {

				element = driver.findElement(By.xpath(locator));

			} else if (byMethod.equalsIgnoreCase("id")) {

				element = driver.findElement(By.id(locator));

			} else if (byMethod.equalsIgnoreCase("linkText")) {

				element = driver.findElement(By.linkText(locator));

			} else if (byMethod.equalsIgnoreCase("class")) {

				element = driver.findElement(By.className(locator));

			} else if (byMethod.equalsIgnoreCase("css")) {

				element = driver.findElement(By.cssSelector(locator));

			}

		} catch (NoSuchElementException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not Found in the Page Source"));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (ElementNotVisibleException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not visible  in the screen."));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (NotFoundException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not found."));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return element;

	}

	// Find elements

	public void findElementByXpath(String xpathExpression)

	{

		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		try {

			driver.findElement(By.xpath(xpathExpression));

		}

		catch (NoSuchElementException e) {

			System.out.println("Web Element xpath " + xpathExpression
					+ " is not Found in the Page Source");

			assertion();

		}

		catch (ElementNotVisibleException e) {

			System.out.println("Web Element " + xpathExpression
					+ "is not visible  in the screen.");

			assertion();

		}

		catch (NotFoundException e) {

			System.out.println("Web Element " + xpathExpression
					+ " is not found.");

			assertion();

		}

	}

	public int GetObjectCount(String xpathExpression)

	{

		int Count = 0;

		try {

			Count = driver.findElements(By.xpath(xpathExpression)).size();

		}

		catch (NoSuchElementException e) {

			System.out.println("Web Element is not Found in the Page Source");

			assertion();

		}

		catch (ElementNotVisibleException e) {

			System.out.println("Web Element is not visible  in the screen.");

			assertion();

		}

		catch (NotFoundException e) {

			System.out.println("Web Element is not found.");

			assertion();

		}

		return Count;

	}

	// ////////////////////////////date picker/////////////////

	public WebElement datepicker(String datepickerxpath) {

		WebElement datewidget = driver.findElement(By.xpath(datepickerxpath));

		List<WebElement> rows = datewidget.findElements(By.tagName("tr"));

		List<WebElement> columns = datewidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			if (cell.getText().equals("23")) {

				cell.findElement(By.linkText("23")).click();

				break;

			}

		}

		return datewidget;

	}

	public WebElement MakeElement(String xpathExpression)

	{

		WebElement Element = null;

		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		try

		{

			Element = driver.findElement(By.xpath(xpathExpression));

		}

		catch (NoSuchElementException e) {

			System.out.println("Web Element " + xpathExpression
					+ " is not Found in the Page Source");

			assertion();

		}

		catch (ElementNotVisibleException e) {

			System.out.println("Web Element " + xpathExpression
					+ "is not visible  in the screen.");

			assertion();

		}

		catch (NotFoundException e) {

			System.out.println("Web Element " + xpathExpression
					+ " is not found.");

			assertion();

		}

		return Element;

	}

	public WebElement LinkText(String xpathExpression)

	{

		WebElement Element = null;

		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		try

		{

			Element = driver.findElement(By.partialLinkText(xpathExpression));

		}

		catch (NoSuchElementException e) {

			System.out.println("Web Element " + xpathExpression
					+ " is not Found in the Page Source");

			assertion();

		}

		catch (ElementNotVisibleException e) {

			System.out.println("Web Element " + xpathExpression
					+ "is not visible  in the screen.");

			assertion();

		}

		catch (NotFoundException e) {

			System.out.println("Web Element " + xpathExpression
					+ " is not found.");

			assertion();

		}

		return Element;

	}

	public void Selectdropdownvaluebytext(String xpath, String VisibleText) {

		try {

			WebElement Boxelement = MakeElement(xpath);

			Select selectdropdwon = new Select(Boxelement);

			selectdropdwon.selectByVisibleText(VisibleText);

		} catch (Exception e) {

			System.out.println("Text - " + VisibleText
					+ " is not exists inside the drop down");

			assertion();

		}

	}

	public void Selectdropdownvaluebyvalue(String xpath, String Value) {

		try {

			WebElement Boxelement = MakeElement(xpath);

			Select selectdropdwon = new Select(Boxelement);

			selectdropdwon.selectByValue(Value);

			/*
			 * 
			 * 
			 * 
			 * Thread.sleep(1000);
			 * 
			 * 
			 * 
			 * Actions act= new Actions(driver);
			 * 
			 * 
			 * 
			 * act.sendKeys(Keys.ARROW_DOWN).build().perform();
			 * 
			 * 
			 * 
			 * act.sendKeys(Keys.ENTER).build().perform();
			 */

		} catch (Exception e) {

			System.out.println("Value - " + Value
					+ " is not exists inside the drop down");

			assertion();

		}

	}

	public void Selectdropdownvaluebyindex(String xpath, int index) {

		try {

			WebElement Boxelement = MakeElement(xpath);

			Select selectdropdwon = new Select(Boxelement);

			selectdropdwon.selectByIndex(index);

		} catch (Exception e) {

			System.out.println("Index Value - " + index
					+ " is not exists inside the drop down");

			assertion();

		}

	}

	// This Method is written to get the page source of a URL.

	public String getPageSource(String url) {

		String pageSource = null;

		driver.get(url);

		pageSource = driver.getPageSource();

		return pageSource;

	}

	public WebElement getWebelementByDriver(String byMethod, String locator,
			WebDriver driver) {

		WebElement element = null;

		try {

			System.out.println(driver.getWindowHandle());

			if (byMethod.equalsIgnoreCase("xpath")) {

				element = driver.findElement(By.xpath(locator));

			} else if (byMethod.equalsIgnoreCase("id")) {

				element = driver.findElement(By.id(locator));

			} else if (byMethod.equalsIgnoreCase("linkText")) {

				element = driver.findElement(By.linkText(locator));

			} else if (byMethod.equalsIgnoreCase("class")) {

				element = driver.findElement(By.className(locator));

			} else if (byMethod.equalsIgnoreCase("css")) {

				element = driver.findElement(By.cssSelector(locator));

			}

		} catch (NoSuchElementException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not Found in the Page Source"));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (ElementNotVisibleException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not visible  in the screen."));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (NotFoundException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not found."));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return element;

	}

	// //alert handler/////

	public boolean isAlertPresent() {

		boolean presentFlag = false;

		try {

			// Check the presence of alert

			Alert alert = driver.switchTo().alert();

			// Alert present; set the flag

			presentFlag = true;

			// if present consume the alert

			alert.accept();

		} catch (NoAlertPresentException ex) {

			// Alert not present

			ex.printStackTrace();

		}

		return presentFlag;

	}

	// //alert handler closed////

	// Below Method is Written to get the window handler which will be used to
	// switch between the windows opened by Selenium Web-driver.

	public ArrayList<String> getWindowHandlers() {

		Set s1 = driver.getWindowHandles();

		Iterator it = s1.iterator();

		ArrayList<String> hendler = new ArrayList<String>();

		int numberOfWindow = 0;

		while (it.hasNext()) {

			hendler.add(numberOfWindow, (String) it.next());

			numberOfWindow = numberOfWindow + 1;

		}

		return hendler;

	}

	public void getwindowname() {

		String parentWindowHandle = driver.getWindowHandle(); // save the
																// current
																// window
																// handle.

		WebDriver popup = null;

		Iterator<String> windowIterator = (Iterator<String>) driver
				.getWindowHandles();

		while (windowIterator.hasNext()) {

			String windowHandle = windowIterator.next();

			popup = driver.switchTo().window(windowHandle);

			/*
			 * if (popup.getTitle().equals("Google") {
			 * 
			 * 
			 * 
			 * break;
			 */

			System.out.println("Title is" + popup.getTitle().toString());

		}

	}

	// Below Method is used to get the list of all Web Elements which share same
	// locator.

	public List<WebElement> getListOfWebelementAtOneLocation(String byMethod,
			String locator) {

		List<WebElement> liwelm = null;

		try {

			if (byMethod.equalsIgnoreCase("xpath")) {

				liwelm = this.driver.findElements(By.xpath(locator));

			} else if (byMethod.equalsIgnoreCase("id")) {

				liwelm = this.driver.findElements(By.id(locator));

			} else if (byMethod.equalsIgnoreCase("linkText")) {

				liwelm = this.driver.findElements(By.linkText(locator));

			} else if (byMethod.equalsIgnoreCase("class")) {

				liwelm = this.driver.findElements(By.className(locator));

			}

		} catch (NoSuchElementException e) {

			ErrorUtil.addVerificationFailure(new Throwable("Web Element "
					+ locator + " is not Found in the Page Source"));

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

			takeScreenShot(System.getProperty("user.dir")
					+ "/test-output/Error Screenshot/errorSceenshot"
					+ UtilFunction.currentDateTime() + ".jpg");

		}

		return liwelm;

	}

	public String getPageUrl() {

		return driver.getCurrentUrl();

	}

	/*
	 * ===================================Utility
	 * methods-End=============================================
	 */

	/*
	 * ===================================Static access
	 * methods-Begin=====================================
	 */

	// Below Method is written to get current system data time in the format
	// ddmmyyyyhhmmss so that we can use it as unique Number.

	public static String currentDateTime() {

		String dateTime = null;

		try {

			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

			Date date = new Date();

			dateTime = dateFormat.format(date).replace(".", "-");

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

		}

		return dateTime;

	}

	// Below method is written to read data from property file.

	public static String getValueFromPropertiesFile(String fileName,
			String propertyName) {

		String propertyValue = null;

		try {

			Properties configProp = new Properties();

			FileInputStream fp = new FileInputStream(
					System.getProperty("user.dir") + "/src/config/" + fileName);

			configProp.load(fp);

			propertyValue = configProp.getProperty(propertyName);

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(e);

		}

		return propertyValue;

	}

	// Below Method is written to set the browser from test data excel sheet.

	public static String getBrowser(String className, String Filenname) {

		Actualbrw = "FIREFOX";

		//String fileName = UtilFunction.fileName;
		
		String fileName =Filenname; 
		
		String sheetName = "TestCases";

		String columnName_TESTCASENAME = "BROWSER";

		// String filePath =
		// System.getProperty("user.dir")+"/src/testData/"+fileName;

		try {

			// Workbook workbook = Workbook.getWorkbook(new File(filePath));

			// Sheet sheet = workbook.getSheet(sheetName);

			int rowNumber_TESTCASENAME = UtilFunction.getRowWithCellData(
					fileName, sheetName, className);

			int coulmn_TESTCASENAME = UtilFunction.getColumnWithCellData(
					fileName, sheetName, columnName_TESTCASENAME);

			Actualbrw = UtilFunction.getCellData(fileName, sheetName,
					coulmn_TESTCASENAME, rowNumber_TESTCASENAME);
System.out.println("hello");
		} catch (Throwable t) {

			ErrorUtil
					.addVerificationFailure(new Throwable(
							"Error occoured while fetching the data from excel sheet."));

		}

		Reporter.log("Opening the " + Actualbrw + " Browser");

		return Actualbrw;

	}
	
	

	// Below method is written to get WebDriver to get the Browser which we
	// want.

	public static WebDriver getDriver(String browser) {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("CHROME")) {

			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/chromedriver.exe");

			if (CIMS_MainProject.os.contains("Linux")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/chromedriver");

			} else if (CIMS_MainProject.os.contains("Windows")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/chromedriver.exe");

			}

			// DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			ChromeOptions options = new ChromeOptions();

			/*
			 * Map<String, Object> prefs = new HashMap<String, Object>();
			 * 
			 * 
			 * 
			 * prefs.put("profile.default_content_settings.popups", 0);
			 * 
			 * 
			 * 
			 * options.setExperimentalOption("prefs", prefs);
			 */

			/*
			 * the below code is applicable on selenium standalone server 2.15.0
			 * . We are replacing this as now we will use
			 * 
			 * 
			 * 
			 * selenium java client 2.16.1
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * capabilities.setCapability("chrome.switches",
			 * Arrays.asList("--disable-popup-blocking"));
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * driver = new ChromeDriver(capabilities);
			 */

			options.addArguments("--disable-popup-blocking");

			options.addArguments("--start-maximized");

			// capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("IE")) {

			/*
			 * System.setProperty("webdriver.ie.driver",
			 * System.getProperty("user.dir")+"//IEDriverServer.exe");
			 * 
			 * 
			 * 
			 * DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * //driver = new Augmenter().augment(driver);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * cap.setCapability("ignoreZoomSetting", true);
			 * 
			 * 
			 * 
			 * cap.setCapability("nativeEvents",false);
			 * 
			 * 
			 * 
			 * driver = new InternetExplorerDriver(cap);
			 */

			if (CIMS_MainProject.osbit.equals("64")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "//IEDriverServer_64.exe");

				DesiredCapabilities cap = DesiredCapabilities
						.internetExplorer();

				cap.setCapability("ignoreZoomSetting", true);

				cap.setCapability("nativeEvents", false);

				driver = new InternetExplorerDriver(cap);

			} else if (CIMS_MainProject.osbit.equals("32")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "//IEDriverServer_32.exe");

				DesiredCapabilities cap = DesiredCapabilities
						.internetExplorer();

				cap.setCapability("ignoreZoomSetting", true);

				cap.setCapability("nativeEvents", false);

				driver = new InternetExplorerDriver(cap);

			}

		}

		else

		{

			FirefoxProfile fp = new FirefoxProfile();

			DesiredCapabilities dc = DesiredCapabilities.firefox();

			dc.setCapability(FirefoxDriver.PROFILE, fp);

			driver = new FirefoxDriver(fp);

			driver.manage().window().maximize();

		}

		return driver;

	}

	// Below method is written to get the Run Time Property from Application
	// e.g. GUID or site Path.

	public static String getRoTextProperty(WebElement webelement,
			String attribute) {

		return webelement.getAttribute(attribute);

	}

	// This function will return the 2 dimensional Array based on regular
	// expression.

	public static String[] getArray(String string, String regex) {

		String[] str = new String[2];

		return string.split(regex);

	}

	// Below Method is Written to convert String to integer

	public static int convertStringToInt(String string) {

		int i = Integer.parseInt(string);

		return i;

	}

	public static String getStatus(String str, Integer pos) {

		String status = null;

		try {

			String[] strarray = str.split("/");

			status = strarray[pos];

		} catch (Throwable t) {

			ErrorUtil.addVerificationFailure(new Throwable(
					"Error Occured while fetching the Status"));

			return status;

		}

		return status;

	}

	public Assertion assertion() {

		Assertion hardAssert = new Assertion();

		return hardAssert;

	}

	public void NavigatetoURL(String URL) {

		driver.navigate().to(URL);

	}

	// static access method for dynamic text boxes

	public void dynamic_data(String Xpathnew1, String Xpathnew2) throws InterruptedException {

		String FileName = "Test Data.xls";
		String sheetName = "Additionalinfo";
		int column_Number = 1;

		// /////excel data for additional info////////////

		String Additionalinfobutton = getCellData(FileName, sheetName, 0,column_Number);

		String Additionalinfoselect = getCellData(FileName, sheetName, 1,column_Number);

		String Additionalinfotext = getCellData(FileName, sheetName, 2,column_Number);

		String Additionalinfotextarea = getCellData(FileName, sheetName, 3,column_Number);

		String Additionalinfonnumber = getCellData(FileName, sheetName, 4,column_Number);

		String Additionalinfodate = getCellData(FileName, sheetName, 5,column_Number);

		String Additionalinfodecimalnumber = getCellData(FileName, sheetName,6, column_Number);

		int ObjCount1 = GetObjectCount(Xpathnew1);

		String DropDownXpath = "";

		int Value = 0;

		for (int ControlCount = 1; ControlCount <= ObjCount1; ControlCount++) {

			Thread.sleep(800);

			String ObjectControlsXpath = Xpathnew2.replace("xx",Integer.toString(ControlCount));

			try {

				String ControlType = MakeElement(ObjectControlsXpath).getAttribute("id");

				if (ControlType.contains("ctm_bt")) {

//					MakeElement(ObjectControlsXpath).click();
					try {
						Thread.sleep(1000);
						MakeElement(ObjectControlsXpath).click();
					} catch (Exception e) {

					}
					try {
						Thread.sleep(1000);
						MakeElement(ObjectControlsXpath+"//.[contains(@value,'True') or contains(@value,'true') or contains(@value,'yes') or contains(@value,'Yes') or contains(@value,'1')]").click();
					} catch (Exception e1) {

					}
				}

				else if (ControlType.contains("ctm_sl")) {

					// Selectdropdownvaluebyvalue(ObjectControlsXpath, "589");

					Selectdropdownvaluebyindex(ObjectControlsXpath, 1);

				}

				else if (ControlType.contains("ctm_tx") && Value != 1) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfotext);

					Value = 1;

				}

				else if (ControlType.contains("ctm_ta")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfotextarea);

				}

				else if (ControlType.contains("ctm_tx")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfotext);

				}

				else if (ControlType.contains("ctm_bt")) {

					try {
						Thread.sleep(1000);
						MakeElement(ObjectControlsXpath+"//.[contains(@value,'True') or contains(@value,'true') or contains(@value,'yes') or contains(@value,'Yes') or contains(@value,'1')]").click();
					} catch (Exception e) {
					}
					try {
						Thread.sleep(1000);
						MakeElement(ObjectControlsXpath).click();
					} catch (Exception e1) {
					}

				}

				else if (ControlType.contains("ctm_in")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfonnumber);

				}

				else if (ControlType.contains("ctm_dt")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfodate);
					
					try {
						Thread.sleep(800);
						MakeElement(".//*[@id='form1']").click();
						Thread.sleep(800);
					} catch (Exception e) {

					}

				}

				else if (ControlType.contains("ctm_de")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(Additionalinfodecimalnumber);

				}

			} catch (Exception e) {

			}

		}
	}



	public void custom_field_data(String FileName, String questionnaireName,
			String testcaseId, String Xpathnew1, String Xpathnew2) {

		// before getting values for custom fields let us pick test case id &
		// questionnaire name, in order to get respective data..

		String sheetName = "Additionalinfo";
		int TestcaseColumnNumber = getColumnWithCellData(FileName, sheetName,
				"TestCases");
		int quesionnaireNmColumnNumber = getColumnWithCellData(FileName,
				sheetName, "Questionnair Name");
		int numberOfRecords = usedRowCount(FileName, sheetName);
		int column_Number = 0;

		for (int n = 1; n < numberOfRecords; n++) {

			String TestCase_id = getCellData(FileName, sheetName,
					TestcaseColumnNumber, n);
			String quesionnaireNm = getCellData(FileName, sheetName,
					quesionnaireNmColumnNumber, n);
			if (TestCase_id.equals(testcaseId)
					&& quesionnaireNm.equals(questionnaireName)) {

				System.out.println("Selected row number :  " + n
						+ " for questionnaire: " + quesionnaireNm);
				column_Number = n;
				break;
			}
			// getCellData(FileName, sheetName,
			// RUNMODEemployeesearch,j).equals("Y")
		}

		if (column_Number > 0) {

			// /////excel data for additional info////////////

			String Additionalinfobutton = getCellData(FileName, sheetName, 0,
					column_Number);

			String Additionalinfoselect = getCellData(FileName, sheetName, 1,
					column_Number);

			String Additionalinfotext = getCellData(FileName, sheetName, 2,
					column_Number);

			String Additionalinfotextarea = getCellData(FileName, sheetName, 3,
					column_Number);

			String Additionalinfonnumber = getCellData(FileName, sheetName, 4,
					column_Number);

			String Additionalinfodate = getCellData(FileName, sheetName, 5,
					column_Number);

			String Additionalinfodecimalnumber = getCellData(FileName,
					sheetName, 6, column_Number);

			int ObjCount1 = GetObjectCount(Xpathnew1);

			String DropDownXpath = "";

			int Value = 0;

			for (int ControlCount = 1; ControlCount <= ObjCount1; ControlCount++) {
				String ObjectControlsXpath = Xpathnew2.replace("xx",
						Integer.toString(ControlCount));

				try {

					String ControlType = MakeElement(ObjectControlsXpath)
							.getAttribute("id");
					if (ControlType.contains("ctm_bt")) {

						MakeElement(ObjectControlsXpath).click();
					}

					else if (ControlType.contains("ctm_sl")) {
						// Selectdropdownvaluebyvalue(ObjectControlsXpath,
						// "589");

						Selectdropdownvaluebyindex(ObjectControlsXpath, 1);
					} else if (ControlType.contains("ctm_tx") && Value != 1) {
						MakeElement(ObjectControlsXpath).clear();
						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfotext);
						Value = 1;
					} else if (ControlType.contains("ctm_ta")) {
						MakeElement(ObjectControlsXpath).clear();
						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfotextarea);
					}

					else if (ControlType.contains("ctm_tx")) {

						MakeElement(ObjectControlsXpath).clear();
						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfotext);
					} else if (ControlType.contains("ctm_bt")) {

						MakeElement(ObjectControlsXpath).click();
					} else if (ControlType.contains("ctm_in")) {
						MakeElement(ObjectControlsXpath).clear();
						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfonnumber);
					} else if (ControlType.contains("ctm_dt")) {

						MakeElement(ObjectControlsXpath).clear();

						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfodate);

					}

					else if (ControlType.contains("ctm_de")) {
						MakeElement(ObjectControlsXpath).clear();

						MakeElement(ObjectControlsXpath).sendKeys(
								Additionalinfodecimalnumber);

					}

				} catch (Exception e) {

				}

			}

		}
	}

	// static access method for dynamic text boxes

	public void dynamic_data_ng_scope(String Xpathnew1, String Xpathnew2) {

		// /////excel data for additional info////////////

		String Additionalinfobutton = "Yes";

		String Additionalinfoselect = "1";

		String Additionalinfotext = "Dynamic Text";

		String Additionalinfotextarea = "Dynamic Text Area";

		String Additionalinfonnumber = "1234";

		String Additionalinfodate = "03/04/2016";

		String Additionalinfodecimalnumber = "2.03";

		int ObjCount1 = GetObjectCount(Xpathnew1);

		String DropDownXpath = "";

		int Value = 0;

		for (int ControlCount = 1; ControlCount <= ObjCount1; ControlCount++) {

			String ObjectControlsXpath = Xpathnew2.replace("xx",
					Integer.toString(ControlCount));

			try {

				String ControlType = MakeElement(ObjectControlsXpath)
						.getAttribute("name");

				if (ControlType.contains("ctm_bt")) {

					MakeElement(ObjectControlsXpath).click();

				}

				else if (ControlType.contains("ctm_sl")) {

					// Selectdropdownvaluebyvalue(ObjectControlsXpath, "589");

					Selectdropdownvaluebyindex(ObjectControlsXpath, 1);

				}

				else if (ControlType.contains("ctm_tx") && Value != 1) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotext);

					Value = 1;

				}

				else if (ControlType.contains("ctm_ta")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotextarea);

				}

				else if (ControlType.contains("ctm_tx")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotext);

				}

				else if (ControlType.contains("ctm_bt")) {

					MakeElement(ObjectControlsXpath).click();

				}

				else if (ControlType.contains("ctm_in")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfonnumber);

				}

				else if (ControlType.contains("ctm_dt")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfodate);

				}

				else if (ControlType.contains("ctm_de")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfodecimalnumber);

				}

			} catch (Exception e) {

			}

		}
	}

	// /////////////dynamic input ends//////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////////////

	public void mouseaction() {

		Actions act = new Actions(driver);

		try {

			Thread.sleep(1000);

			act.sendKeys(Keys.ARROW_DOWN).build().perform();

			Thread.sleep(1000);

			act.sendKeys(Keys.ENTER).build().perform();

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	// ////////////////////report generation log////////////////////////////////

	public void TestngReportFail(String TestcaseID, String browser,
			String scenario, String action, String testcasedescription,
			String excecutionstatus, String errormessage) {

		String PageTitle	=	"";
		String EmployeeName	=	"";
		String Time	=	"";


		try {
			if(!CIMS_MainProject.questionarie_name1.isEmpty()){
				PageTitle		=	CIMS_MainProject.questionarie_name1;
			}
		} catch (Exception e) {
		}
		try {
			if(!this.moduleName.isEmpty()){
				PageTitle		=	this.moduleName;
			}
		} catch (Exception e) {
			
		}
			
		try {
			if(!CIMS_MainProject.Employee_namecheck.isEmpty()){
				EmployeeName	=	CIMS_MainProject.Employee_namecheck;
			}
		} catch (Exception e) {

		}
		try {
			if (!this.Employee_namecheck.isEmpty()) {
				EmployeeName	=	this.Employee_namecheck;
			}
		} catch (Exception e1) {
		}
		

		try {
			if (!CIMS_MainProject.timer.isEmpty()) {

				Time =	CIMS_MainProject.timer;

			}
		} catch (Exception e) {

		} 
		try {
			if (!this.timer.isEmpty()) {

				Time =	this.timer;

			}
		} catch (Exception e) {

		}
		
		Reporter.log("<table border='1' style='background-color:white;border-color:black;width:100%;text-align:center'>" +
				"<tr style='color: rgb(255, 255, 255); background-color: rgb(0, 102, 255);'><td><b>"
				+ PageTitle + " Page Report</b></td></tr></table>" +
				"<table cellspacing='1' cellpadding='3' border='1' style='background-color:white;width:100%;border-color:black'>" +
				"<thead style='color: rgb(255, 255, 255); background-color: rgb(0, 102, 255);'>" +
				"<tr><td>Test Case ID</td><td>Browser</td><td>Scenerio</td><td>Action</td><td>Test Case Description</td><td>Employee Name</td><td>Exceution Status</td><td>Reason</td><td>Time taken to Execute</td></tr></thead>" +
				"<tbody><tr><td>"+		TestcaseID+"</td>"+"<td>"+
				browser+"</td><td>"+scenario+"</td><td>"+action+"</td><td>"+

		testcasedescription+"</td><td>"+EmployeeName+"</td><td>"+excecutionstatus+"</td><td>"+errormessage+"</td><td>"+Time+" seconds</td>" +
				"</tr></tbody></table>");
		
		// to generate not assigned dashboard report for questionnaire
		try{
		if(!CIMS_MainProject.questionarie_name1.isEmpty()){
			try {
				obj_Report_Dashboard.writeDashBoardNotAssignedReport(CIMS_MainProject.sheetName, EmployeeName, TestcaseID, browser, scenario, action, testcasedescription, "Not Assigned", Time);
			} catch (InterruptedException e) {
				System.out.println("unable to write pass report for : "+  CIMS_MainProject.sheetName + " > " +PageTitle);
			}
		}
		}catch(Exception w){
			System.out.println("unable to write questionnaire not assigned report for dashboard");
		}

	}

	// ////////////////////////////////////////

	// ////////////////////testng report pass///////////////////////

	public void TestngReportPass(String TestcaseID, String browser,
			String scenario, String action, String testcasedescription,
			String excecutionstatus) throws IOException, AWTException, InterruptedException {

		String PageTitle	=	"";
		String EmployeeName	=	"";
		String Time	=	"";

	
		try {
			if(!CIMS_MainProject.questionarie_name1.isEmpty()){
				PageTitle		=	CIMS_MainProject.questionarie_name1;
			}
		} catch (Exception e) {
		}
		try {
			if(!this.moduleName.isEmpty()){
				PageTitle		=	this.moduleName;
			}
		} catch (Exception e) {
			
		}
			
		try {
			if(!CIMS_MainProject.Employee_namecheck.isEmpty()){
				EmployeeName	=	CIMS_MainProject.Employee_namecheck;
			}
		} catch (Exception e) {

		}
		try {
			if (!this.Employee_namecheck.isEmpty()) {
				EmployeeName	=	this.Employee_namecheck;
			}
		} catch (Exception e1) {
		}
		

		try {
			if (!CIMS_MainProject.timer.isEmpty()) {

				Time =	CIMS_MainProject.timer;

			}
		} catch (Exception e) {

		} 
		try {
			if (!this.timer.isEmpty()) {

				Time =	this.timer;

			}
		} catch (Exception e) {

		}
		
		Reporter.log("<table border='1' style='background-color:white;border-color:black;width:100%;text-align:center'>" +
				"<tr style='color: rgb(255, 255, 255); background-color: rgb(0, 99, 0);'>" +
				"<td><b>" + PageTitle + " Page Report" +
						"</b></td>" +
						"</tr>" +
						"</table>" +
						"<table cellspacing='1' cellpadding='3' border='1' style='background-color:white;width:100%;border-color:black'>" +
						"<thead style='color: rgb(255, 255, 255); background-color: rgb(0, 99, 0);'>" +
						"<tr><td>Test Case ID</td><td>Browser</td><td>Scenerio</td><td>Action</td><td>Test Case Description" +
						"</td><td>Employee Name</td><td>Exceution Status</td><td>Time taken to Execute" +
						"</td>" +
						"</tr>" +
						"</thead>" +
						"<tbody>" +
						"<tr>" +
						"<td>" +TestcaseID +"</td>" +
						"<td>"+browser+"</td>"+
						"<td>"+scenario+"</td>"+
						"<td>"+ action +"</td>"+
						"<td>"+testcasedescription+"</td>"+
						"<td>"+ EmployeeName + "</td>"+
						"<td>"+excecutionstatus+"</td>"+
						"<td>"+ Time + " seconds </td>"+
						"</tr>"+"</tbody>"+"</table>");

		// to generate pass dashboard report for questionnaire
		try{
		if(!CIMS_MainProject.questionarie_name1.isEmpty()){
			try {
				obj_Report_Dashboard.writeDashBoardPassReport(CIMS_MainProject.sheetName, EmployeeName, TestcaseID, browser, scenario, action, testcasedescription, "Pass", Time);
			} catch (InterruptedException e) {
				System.out.println("unable to write pass report for : "+  CIMS_MainProject.sheetName + " > " +PageTitle);
			}
		}
		}catch(Exception w){
			System.out.println("unable to write questionnaire pass report for dashboard");
		}

	}

	// ////////////////////report generation log////////////////////////////////

	public void TestngReportFail1(String TestcaseID, String browser,
			String scenario, String action, String testcasedescription,
			String excecutionstatus, String errormessage, String errormessage1,
			String ModuleErrorMessage) {


		String PageTitle	=	"";
		String EmployeeName	=	"";
		String Time	=	"";

	
		try {
			if(!CIMS_MainProject.questionarie_name1.isEmpty()){
				PageTitle		=	CIMS_MainProject.questionarie_name1;
			}
		} catch (Exception e) {
		}
		try {
			if(!this.moduleName.isEmpty()){
				PageTitle		=	this.moduleName;
			}
		} catch (Exception e) {
			
		}
			
		try {
			if(!CIMS_MainProject.Employee_namecheck.isEmpty()){
				EmployeeName	=	CIMS_MainProject.Employee_namecheck;
			}
		} catch (Exception e) {

		}
		try {
			if (!this.Employee_namecheck.isEmpty()) {
				EmployeeName	=	this.Employee_namecheck;
			}
		} catch (Exception e1) {
		}
		

		try {
			if (!CIMS_MainProject.timer.isEmpty()) {

				Time =	CIMS_MainProject.timer;

			}
		} catch (Exception e) {

		} 
		try {
			if (!this.timer.isEmpty()) {

				Time =	this.timer;

			}
		} catch (Exception e) {

		}

		System.out.println("filepath in report generation for failure case: "
				+ FilePath);
		
		Reporter.log("<table border='1' style='background-color:white;border-color:black;width:100%;text-align:center'>" +
				"<tr style='color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);'>" +
				"<td><b>"+
				PageTitle +" Page Report</b></td></tr>" +
				"</table>" +
				"<table cellspacing='1' cellpadding='3' border='1' style='background-color:white;width:100%;border-color:black'>" +
				"<thead style='color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);'>" +
				"<tr><td>Test Case ID</td><td>Browser</td><td>Scenerio</td><td>Action</td><td>Test Case Description</td><td>Employee Name</td><td>Exceution Status</td><td>Error Message</td><td>Error Screenshot</td><td>Time taken to Execute</td>" +
				"</tr></thead><tbody>" +
				"<tr><td>"+TestcaseID+"</td><td>" +
						browser+"</td><td>"+scenario+"</td><td>"+action+"</td><td>"+testcasedescription+"</td><td>"+ EmployeeName +"</td><td>"+excecutionstatus+"</td><td>"+errormessage +errormessage1+ModuleErrorMessage+"</td><td>" +
								"<a href=file:///" + FilePath.replaceAll(" ", "%20") + " target=_blank>Check Error</a></td><td>"	+	Time	+" seconds</td>" +
										"</tr></tbody></table>");
		
		// to generate fail dashboard report for questionnaire
		try{
		if(!CIMS_MainProject.questionarie_name1.isEmpty()){
			try {
				obj_Report_Dashboard.writeDashBoardFailReport(CIMS_MainProject.sheetName, EmployeeName, TestcaseID, browser, scenario, action, testcasedescription, "Fail", Time,errormessage, errormessage1,ModuleErrorMessage);
			} catch (InterruptedException e) {
				System.out.println("unable to write negative pass report for : "+  CIMS_MainProject.sheetName + " > " +PageTitle);
			}
		}
		}catch(Exception w){
			System.out.println("unable to write questionnaire negative pass report for dashboard");
		}

	}

	// ////////////////////////////////////////<a target="_blank"
	// href="https://developer.android.com/sdk/index.html">

	// <input type="button" value="Click Me"></a>

	/*
	 * public void TakeScreenshot(){
	 * 
	 * 
	 * 
	 * takeScreenShot(System.getProperty("user.dir")+
	 * "/test-output/Error Screenshot/errorSceenshot"
	 * +CIMS_MainProject.questionarie_name1
	 * +UtilFunction.currentDateTime()+".jpg");
	 * 
	 * 
	 * 
	 * }
	 */

	public void TakeScreenshot() {

		String FilePath1 = null;

		if (CIMS_MainProject.os.contains("Linux")) {

			FilePath1 = System.getProperty("user.dir") + "/test-output/ErrorScreenshot/";

			// "/home/dr13/JavaWorkspace/CIMS/test-output/ErrorScreenshot/"

		} else if (CIMS_MainProject.os.contains("Windows")) {

			FilePath1 = System.getProperty("user.dir") + "\\test-output\\ErrorScreenshot\\";

			// FilePath1="c:\\JavaWorkspace\\CIMS\\test-output\\ErrorScreenshot\\";

		} else {

			FilePath1 = System.getProperty("user.dir") + "\\test-output\\ErrorScreenshot\\";

		}

		// takeScreenShot(System.getProperty("user.dir")+"C:\JavaWorkspace\CIMS\test-output\Error
		// Screenshot"+CIMS_MainProject.questionarie_name1+UtilFunction.currentDateTime()+".jpg");

		// takeScreenShot(System.getProperty("C:\\JavaWorkspace\\CIMS\\test-output\\Error Screenshot"+".jpg"));

		// String
		// FilePath1="/home/dr13/JavaWorkspace/CIMS/test-output/ErrorScreenshot/";

		// String
		// FilePath1="c:\\JavaWorkspace\\CIMS\\test-output\\ErrorScreenshot\\";

		String DateandTime = UtilFunction.currentDateTime().replaceAll(" ", "_");

		DateandTime = DateandTime.replaceAll("-", "_");

		DateandTime = DateandTime.replaceAll(":", "_");

		String FileNamePrefix = ""; // module name

		if (CIMS_MainProject.questionarie_name1 != null) {
			FileNamePrefix = CIMS_MainProject.questionarie_name1;
		}
		else 
		if (!this.moduleName.isEmpty()) {

			FileNamePrefix = this.moduleName;

		} 
		else if (CIMS_Regression_Suite.questionarie_name1 != null) {

			FileNamePrefix = (CIMS_Regression_Suite.questionarie_name1);

		} 

		FileNamePrefix = FileNamePrefix.replaceAll(" ", "_");

		FilePath = FilePath1 + FileNamePrefix + "_" + DateandTime + ".jpg"; // "YYYY_MM_DD_HH_MM_SS"+

		System.out.println("filepath: " + FilePath);

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy
		// somewhere

		try {

			FileUtils.copyFile(scrFile, new File(FilePath));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public void iframe(String senddata) {

		/*
		 * WebElement frame = driver.findElement(By.tagName("iframe"));
		 * 
		 * 
		 * 
		 * driver.switchTo().frame(frame);
		 * 
		 * 
		 * 
		 * WebElement body = driver.findElement(By.id("tinymce"));
		 * 
		 * 
		 * 
		 * body.clear();
		 * 
		 * 
		 * 
		 * body.sendKeys(senddata);
		 * 
		 * 
		 * 
		 * driver.switchTo().defaultContent();
		 */

		driver.switchTo().frame("WorkPerformed_ifr");

		WebElement body = driver.findElement(By.id("tinymce"));

		/*
		 * body.clear();
		 * 
		 * 
		 * 
		 * body.sendKeys(senddata);
		 * 
		 * 
		 * 
		 * body.sendKeys(Keys.CONTROL + "a");
		 */

		body.sendKeys(senddata);

		driver.switchTo().defaultContent();

	}

	/*
	 * ===================================Static access
	 * methods-End=======================================
	 */

	public void explicitwait(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 2);

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(xpath)));

		element.click();

	}

	// ///////////////////////////////////////DELETE ERROR
	// HANDLER///////////////////////////////////////////////////

	public boolean ErrorMessagehandler() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		boolean Flag = false;

		// ///////////////////////error handler/////////////////////////

		ErrorMessage4 = "";

		ErrorMessage1 = "";

		ErrorMessage2 = "";

		ErrorMessage5 = "";

		globalerrormessage = "";

		try {

			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

			String errorcounterxpath = ".//*[@class='control-group']";

			String errorfieldxpath = ".//*[@class='control-group'][xx]//*[@class='error']";

			int ObjCount2 = GetObjectCount(errorcounterxpath);

			for (int count = 1; count <= ObjCount2; count++) {

				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));

				try {

					String Error = MakeElement(NewXpath).getText();

					System.out.println("Error " + count + "is : " + Error);

					ErrorMessage4 = Error + ErrorMessage4;

					Flag = false;

				} catch (Exception e) {

				}

			}

			// ////////////////////////////

			try {

				String compensationErrorMessageXpath = "//*[@id='page-message']";

				String errormessage = ".//*[@id='validation-summary']";

				ErrorMessage2 = MakeElement(errormessage).getText();

				ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
						.getText();

				System.out.println("The Error is " + ErrorMessage1);

				System.out.println("The Error is " + ErrorMessage2);

				boolean check = false;

				try {

					if (ErrorMessage1.contains("Success!")) {

						if (ErrorMessage2.equals("")) {

							try {

								Flag = true;

								// Reporter.log("#ERROR: "+ErrorMessage1);

							}

							catch (Exception j) {

							}
						}

					} else if (ErrorMessage1.equals("")) {

						try {

							if (ErrorMessage2.equals("")) {

								Flag = true;

								// Reporter.log("#ERROR: "+ErrorMessage1);

							} else {

								Flag = false;

								TakeScreenshot();

								// Reporter.log("#ERROR: "+ErrorMessage2);

							}

						}

						catch (Exception j) {

						}

					} else {

						Flag = false;

						TakeScreenshot();

						// Reporter.log("#ERROR: "+ErrorMessage2);

					}

				} catch (Exception er) {

				}

				// catch handle for the validation summary

			} catch (Exception r) {

				boolean check = false;

				try {

					String compensationErrorMessageXpath = "//*[@id='page-message']";

					ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
							.getText();

					// Reporter.log("The Message"+ErrorMessage);

					System.out.println(ErrorMessage);

					if (ErrorMessage1.contains("Success!")) {

						try {

							Flag = true;

							// Reporter.log("#ERROR: "+ErrorMessage1);

						} catch (Exception j) {

						}

					} else if (ErrorMessage1.contains("")) {

						try {

							if (ErrorMessage4.equals("")) {

								Flag = true;

								// Reporter.log("#ERROR: "+ErrorMessage1);

							} else {

								Flag = false;

								TakeScreenshot();

								// Reporter.log("#ERROR: "+ErrorMessage2);

							}

						}

						catch (Exception j) {

						}

					} else {

						Flag = false;

						TakeScreenshot();

						// Reporter.log("#ERROR: "+ErrorMessage2);

					}

				} catch (Exception er) {

					Flag = true;

				}

			}

		}

		catch (Exception g) {

			// try message to check if the validation summary field is present
			// in the page. if not it will throw an exception

			try {

				String compensationErrorMessageXpath = "//*[@id='page-message']";

				String errormessage = ".//*[@id='validation-summary']";

				ErrorMessage2 = MakeElement(errormessage).getText();

				System.out.println("The Error is" + ErrorMessage1);

				System.out.println("The Error is" + ErrorMessage2);

				boolean check = false;

				try {

					ErrorMessage = MakeElement(compensationErrorMessageXpath)
							.getText();

					// Reporter.log("The Message"+ErrorMessage);

					System.out.println(ErrorMessage);

					if (ErrorMessage1.contains("Success!")) {

						try {

							Flag = true;

							// Reporter.log("#ERROR: "+ErrorMessage1);

						}

						catch (Exception j) {

						}

					} else if (ErrorMessage1.equals("")) {

						try {

							if (ErrorMessage2.equals("")) {

								Flag = true;

								// Reporter.log("#ERROR: "+ErrorMessage1);

							} else {

								Flag = false;

								TakeScreenshot();

								// Reporter.log("#ERROR: "+ErrorMessage2);

							}

						}

						catch (Exception j) {

						}

					} else {

						Flag = false;

						TakeScreenshot();

						// Reporter.log("#ERROR: "+ErrorMessage2);

					}

				} catch (Exception er) {

				}

				// catch handle for the validation summary

			} catch (Exception r) {

				boolean check = false;

				try {

					String compensationErrorMessageXpath = "//*[@id='page-message']";

					ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
							.getText();

					// Reporter.log("The Message"+ErrorMessage);

					System.out.println(ErrorMessage);

					if (ErrorMessage1.contains("Success!")) {

						try {

							Flag = true;

							// Reporter.log("#ERROR: "+ErrorMessage1);

						} catch (Exception j) {

						}

					} else if (ErrorMessage1.contains("")) {

						try {

							if (ErrorMessage4.equals("")) {

								Flag = true;

								// Reporter.log("#ERROR: "+ErrorMessage1);

							} else {

								Flag = false;

								TakeScreenshot();

								// Reporter.log("#ERROR: "+ErrorMessage2);

							}

						}

						catch (Exception j) {

						}

					} else {

						Flag = false;

						TakeScreenshot();

						// Reporter.log("#ERROR: "+ErrorMessage2);

					}

				} catch (Exception er) {

					Flag = true;

				}

			}

		}

		return Flag;

		// /////////////////Error HANDLER end//////////////////

	}

	// /////////////////////////////////URL fetch from excel
	// sheet//////////////////////

	public static String geturl(String QuestionarieName) {

		String QuestionarieURL = null;

		try {

			int rowCount = UtilFunction.usedRowCount(fileName, sheetName);

			int columnNumber_RUNMODE = UtilFunction.getColumnWithCellData(
					fileName, sheetName, columnName);

			int questionarie_name = UtilFunction.getColumnWithCellData(
					fileName, sheetName, columnName1);

			for (int i = 1; i <= rowCount; i++) {

				if (UtilFunction.getCellData(fileName, sheetName,
						columnNumber_RUNMODE, i).equals(QuestionarieName)) {

					QuestionarieURL = UtilFunction.getCellData(fileName,
							sheetName, questionarie_name, i);

					System.out.println("URL is :" + QuestionarieURL);

				}
			}

		} catch (Throwable e) {

			ErrorUtil.addVerificationFailure(new Throwable(
					"Error occoured while fetching the url from excel sheet."));

		}

		return QuestionarieURL;

	}

	// ////////////////////////DIRECT URL
	// FETCH////////////////////////////////////////////////////////

	public String geturldirect_prev(String QuestionarieName) {
		
		String sidebarxpath=".//*[@id='slider-icon']";
		

		if (CIMS_Regression_Suite.SelectQuestionnairetype.equals("PROFILE")) {

			try {

				/*
				 * String
				 * Principalheaderxpath=".//*[@id='rnav-principal-header']/a";
				 * 
				 * 
				 * 
				 * MakeElement(Principalheaderxpath).click();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * String Basicinfoxpath=".//*[@id='sectBasicInformation']/a";
				 * 
				 * 
				 * 
				 * MakeElement(Basicinfoxpath).click();
				 */

				QuestionaireURL1 = "";

				String Fieldxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr[xx]/td/a";

				String Counterxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr";

				int ObjCount1 = GetObjectCount(Counterxpath);

				// modification

				/*
				 * String sidebarxpath=".//*[@id='slider-icon']";
				 * 
				 * 
				 * 
				 * MakeElement(sidebarxpath).click();
				 * 
				 * 
				 * 
				 * Thread.sleep(2000);
				 */

				WebElement element = driver.findElement(By
						.xpath(".//*[@id='slider-icon']"));

				JavascriptExecutor executor = (JavascriptExecutor) driver;

				executor.executeScript("arguments[0].click();", element);

				Thread.sleep(2000);

				// String QuestionnaireXPath =
				// ".//*[@class='sidebarTable profileTable'][1]//tbody//td//a[text()='"+QuestionarieName+"']";
try{
				for (int count = 1; count <= ObjCount1; count++) {

					String NewXpath = Fieldxpath.replace("xx",
							Integer.toString(count));

					try {

						// QuestionaireURL1=MakeElement(NewXpath).getAttribute("href");

						QuestionaireName = MakeElement(NewXpath).getText();

						System.out.println("The Questionarie is :"
								+ QuestionaireName);

						if (QuestionaireName.equals(QuestionarieName)) {

							QuestionaireURL1 = MakeElement(NewXpath)
									.getAttribute("href");

							System.out.println("The Questionarie is :"
									+ QuestionaireURL1);

						}

					} catch (Exception e) {

					}

				}
				}catch(Exception error){}

			} catch (Exception e) {

			}

		}

		else if (CIMS_MainProject.SelectQuestionnairetype.equals("PROJECT")) {

			try {

				QuestionaireURL1 = "";

				String Fieldxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr[xx]/td/a";

				String Counterxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr";

				int ObjCount1 = GetObjectCount(Counterxpath);

				// modification

				/*
				 * String sidebarxpath=".//*[@id='slider-icon']";
				 * 
				 * 
				 * 
				 * MakeElement(sidebarxpath).click();
				 * 
				 * 
				 * 
				 * Thread.sleep(2000);
				 */
//Side BAr Click Commented---20/05/2016
				
				
				/*WebElement element = driver.findElement(By
						.xpath(".//*[@id='slider-icon']"));

				JavascriptExecutor executor = (JavascriptExecutor) driver;

				executor.executeScript("arguments[0].click();", element);

				Thread.sleep(2000);*/
				String SliderPath=".//*[@id='profile-slider']";
				String SliderStatus="";
		
				SliderStatus=MakeElement(SliderPath).getAttribute("class");
				Thread.sleep(1000);
						if(SliderStatus.equals("")){
										
											MakeElement(sidebarxpath).click();
											Thread.sleep(2000);
											System.out.println("Slider Was Closed)");
							}
try{
				for (int count = 1; count <= ObjCount1; count++) {

					String NewXpath = Fieldxpath.replace("xx",Integer.toString(count));

					try {

						// QuestionaireURL1=MakeElement(NewXpath).getAttribute("href");
						QuestionaireName = MakeElement(NewXpath).getText();

						System.out.println("The Questionarie is :"+ QuestionaireName);

						if (QuestionaireName.equals(QuestionarieName)) {

							QuestionaireURL1 = MakeElement(NewXpath)
									.getAttribute("href");

							System.out.println("The Questionarie is :"
									+ QuestionaireURL1);

						}

					} catch (Exception e) {

					}

				}
}catch(Exception error){}

			} catch (Exception d) {

			}

		} else if (CIMS_MainProject.SelectQuestionnairetype.equals("PROFILE")) {

			try {

				/*
				 * String
				 * Principalheaderxpath=".//*[@id='rnav-principal-header']/a";
				 * 
				 * 
				 * 
				 * MakeElement(Principalheaderxpath).click();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * String Basicinfoxpath=".//*[@id='sectBasicInformation']/a";
				 * 
				 * 
				 * 
				 * MakeElement(Basicinfoxpath).click();
				 */

				QuestionaireURL1 = "";

				String Fieldxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr[xx]/td/a";

				String Counterxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr";

				int ObjCount1 = GetObjectCount(Counterxpath);

				// modification

				/*
				 * String sidebarxpath=".//*[@id='slider-icon']";
				 * 
				 * 
				 * 
				 * MakeElement(sidebarxpath).click();
				 * 
				 * 
				 * 
				 * Thread.sleep(2000);
				 */

				WebElement element = driver.findElement(By
						.xpath(".//*[@id='slider-icon']"));

				JavascriptExecutor executor = (JavascriptExecutor) driver;

				executor.executeScript("arguments[0].click();", element);

				Thread.sleep(2000);
try{
				for (int count = 1; count <= ObjCount1; count++) {

					String NewXpath = Fieldxpath.replace("xx",
							Integer.toString(count));

					try {

						// QuestionaireURL1=MakeElement(NewXpath).getAttribute("href");

						QuestionaireName = MakeElement(NewXpath).getText();

						System.out.println("The Questionarie is :"
								+ QuestionaireName);

						if (QuestionaireName.equals(QuestionarieName)) {

							QuestionaireURL1 = MakeElement(NewXpath)
									.getAttribute("href");

							System.out.println("The Questionarie is :"
									+ QuestionaireURL1);

						}

					} catch (Exception e) {

					}

				}
}catch(Exception error){}

			} catch (Exception e) {

			}

		}

		return QuestionaireURL1;

	}

	
	public String geturldirect(String QuestionarieName) throws InterruptedException {

		/**
		 * first of all let us confirm if slider icon is already 
		 */

		String sidebarxpath=".//*[@id='slider-icon']";

		String SliderPath=".//*[@id='profile-slider']";
		String SliderStatus="";

		SliderStatus=MakeElement(SliderPath).getAttribute("class");
		Thread.sleep(1000);
		if(SliderStatus.equals("")){

			try {
				MakeElement(sidebarxpath).click();
			} catch (Exception e) {
				System.out.println("unable to click on slider icon");
			}
			Thread.sleep(2500);
			System.out.println("Slider Was Closed)");
		}
		
		QuestionaireURL1 = "";
		
		try{
		String QuestionnaireXPath	="//*[@class='sidebarTable profileTable'][1]//*[contains(text(),'"+QuestionarieName+"')]"; ////*[contains(text(),'Language Study')]
		
		QuestionaireURL1	= 	MakeElement(QuestionnaireXPath).getAttribute("href");
		
		System.out.println("url for "+QuestionarieName+ " - is - "+QuestionaireURL1);
		}catch(Exception e){
			System.out.println(QuestionarieName + " not assigned");
		}
		
		return QuestionaireURL1;

	}	
	
	
	
	// ////////////////////////DIRECT URL FETCH
	// END////////////////////////////////////////////////

	// ///////////////////////ERROR
	// HANDLER////////////////////////////////////////////////////////

	public String ErrorMessagehandlerInAngularFormExperiment() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		ErrorMessage4 = "";

		ErrorMessage1 = "";

		ErrorMessage2 = "";

		ErrorMessage5 = "";

		globalerrormessage = "";

		// //////////////////ERROR4/////////////////////////////////////////////////

		try {

			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

			String errorcounterxpath = "//*[contains(@class,'error-messages')]//*[@class='ng-scope']";

			String errorfieldxpath = "//*[contains(@class,'error-messages')][xx]//*[@class='ng-scope']";

			int ObjCount2 = GetObjectCount(errorcounterxpath);

			for (int count = 1; count <= ObjCount2; count++) {

				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));

				try {

					String Error = MakeElement(NewXpath).getText();

					System.out.println("Error " + count + "is : " + Error);

					ErrorMessage4 = Error + ErrorMessage4;

				} catch (Exception e) {

				}

			}

		} catch (Exception e) {

		}

		// //////////////////ERROR4
		// END/////////////////////////////////////////////////

		// //////////////////ERROR
		// 1,2,5////////////////////////////////////////////////

		try {

			String compensationErrorMessageXpath = "//*[@id='page-message']";

			ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
					.getText();

			String errormessage = ".//*[@id='validation-summary']";

			ErrorMessage2 = MakeElement(errormessage).getText();

			ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
					.getText();

			try {

				String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

				ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
						.getText();

			} catch (Exception e) {

			}

			System.out.println("The Error1 is " + ErrorMessage1);

			System.out.println("The Error2 is " + ErrorMessage2);

			System.out.println("The Error5 is " + ErrorMessage5);

		} catch (Exception e) {

			System.out.println("Exception occured: " + e);

		}

		// //////////////////ERROR 1,2,5
		// END///////////////////////////////////////////

		// ///////////////////server error
		// handle//////////////////////////////////////

		try {

			String servererrorxpath = "html/body/span/h1";

			ErrorMessage1 = MakeElement(servererrorxpath).getText();

			if (ErrorMessage1.equals("Server Error in '/' Application.")) {

				TakeScreenshot();

				globalerrormessage = ErrorMessage1;

				return globalerrormessage;

			}

		} catch (Exception e) {

		}

		// ///////////////////server error handle
		// END//////////////////////////////////////

		if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

		{

			if (CIMS_MainProject.questionarie_name1.equals("awards")
					| CIMS_Regression_Suite.questionarie_name1.equals("awards")
					| CIMS_MainProject.questionarie_name1
							.equals("Commercial_Success")
					| CIMS_MainProject.questionarie_name1.equals("Citizenship")
					| CIMS_MainProject.questionarie_name1
							.equals("Contacts_and_References")) {

				globalerrormessage = ErrorMessage4 + ErrorMessage2
						+ ErrorMessage5;

			} else if (CIMS_MainProject.questionarie_name1
					.equals("Residence_History")
					| CIMS_MainProject.questionarie_name1
							.equals("Travel_Plans")) {

				globalerrormessage = ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

			}

		}

		else {

			globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
					+ ErrorMessage5;

			if (globalerrormessage.contains("Success"))

			{

				globalerrormessage = "";

			}

		}

		return globalerrormessage;

	}

	// //////////////////////////////////////ERROR HANDLER
	// END////////////////////////////////////////

	
	// ///////////////////////ERROR
		// HANDLER////////////////////////////////////////////////////////

		public String ErrorMessageHandlerInSPI(String ContainerPrefix) {

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			ErrorMessage4 = "";

			ErrorMessage1 = "";

			ErrorMessage2 = "";

			ErrorMessage5 = "";

			globalerrormessage = "";

			// //////////////////ERROR4/////////////////////////////////////////////////

			try {

				String errorMainCounterXPath	=	ContainerPrefix + "//*[@ng-messages and not(contains(@class,'ng-inactive'))]";
				
				String errorMainfieldxpath 		= 	ContainerPrefix + "[yy]//*[@ng-messages and not(contains(@class,'ng-inactive'))]";

				int ObjCount1 = GetObjectCount(errorMainCounterXPath);

				for (int c = 1; c <= ObjCount1; c++) {

					// now first record is found
					String errorcounterxpath		=	errorMainfieldxpath.replace("yy", Integer.toString(c));
					
					// now create inner counter if it has inner errors too.
					
				
					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";
	
//					String errorcounterxpath = ContainerPrefix + "//*[contains(@class,'error-messages')]//*[@class='ng-scope']";
	
	//				System.out.println("err countr xpath- "+errorcounterxpath);
					
//					String errorfieldxpath = ContainerPrefix + "[xx]//*[contains(@class,'error-messages')]//*[@class='ng-scope']";
					String errorfieldxpath = ContainerPrefix + "[xx]";
	
					int ObjCount2 = GetObjectCount(errorcounterxpath);
	
					for (int count = 1; count <= ObjCount2; count++) {
	
						String NewXpath = errorfieldxpath.replace("xx",Integer.toString(count));
	//					String NewXpath	=	errorcounterxpath;
						try {
	
							String Error = MakeElement(NewXpath).getText();
	
							System.out.println("Error " + count + "is : " + Error);
	
							Error	=	Error.replaceAll("\n", "");

							if(Error.contains("PREFIX") || Error.contains("MR.") || Error.contains("MRS.") || Error.contains("MS.") || Error.contains("DR.")){
								Error	=	Error.replace("PREFIX", "");
								Error	=	Error.replace("MR.", "");
								Error	=	Error.replace("MRS.", "");
								Error	=	Error.replace("MS.", "");
								Error	=	Error.replace("DR.", "");
								if(!ErrorMessage4.contains(Error)){
									ErrorMessage4 = ErrorMessage4 + Error;
								}

							}
							else 
								if(!ErrorMessage4.contains(Error)){

								ErrorMessage4 = ErrorMessage4 + Error;
							} 
	
						} catch (Exception e) {
	
						}
	
					}
				}

			} catch (Exception e) {

			}

			// //////////////////ERROR4
			// END/////////////////////////////////////////////////

			// //////////////////ERROR
			// 1,2,5////////////////////////////////////////////////

			try {

				String compensationErrorMessageXpath = "//*[@id='page-message']";

				ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
						.getText();

				String errormessage = ".//*[@id='validation-summary']";

				ErrorMessage2 = MakeElement(errormessage).getText();

				ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
						.getText();

				try {

					String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

					ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
							.getText();

				} catch (Exception e) {

				}

				System.out.println("The Error1 is " + ErrorMessage1);

				System.out.println("The Error2 is " + ErrorMessage2);

				System.out.println("The Error5 is " + ErrorMessage5);

			} catch (Exception e) {

				System.out.println("Exception occured: " + e);

			}

			// //////////////////ERROR 1,2,5
			// END///////////////////////////////////////////

			// ///////////////////server error
			// handle//////////////////////////////////////

			try {

				String servererrorxpath = "html/body/span/h1";

				ErrorMessage1 = MakeElement(servererrorxpath).getText();

				if (ErrorMessage1.equals("Server Error in '/' Application.")) {

					TakeScreenshot();

					globalerrormessage = ErrorMessage1;

					return globalerrormessage;

				}

			} catch (Exception e) {

			}

			// ///////////////////server error handle
			// END//////////////////////////////////////

			if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

			{

				if (CIMS_MainProject.questionarie_name1.equals("awards")
						| CIMS_Regression_Suite.questionarie_name1.equals("awards")
						| CIMS_MainProject.questionarie_name1
								.equals("Commercial_Success")
						| CIMS_MainProject.questionarie_name1.equals("Citizenship")
						| CIMS_MainProject.questionarie_name1
								.equals("Contacts_and_References")) {

					globalerrormessage = ErrorMessage4 + ErrorMessage2
							+ ErrorMessage5;

				} else if (CIMS_MainProject.questionarie_name1
						.equals("Residence_History")
						| CIMS_MainProject.questionarie_name1
								.equals("Travel_Plans")) {

					globalerrormessage = ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

				}

			}

			else {

				globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

				if (globalerrormessage.contains("Success"))

				{

					globalerrormessage = "";

				}

			}

//			globalerrormessage	=	globalerrormessage.replace("PREFIXMR.MRS.MS", "");


			return globalerrormessage;

		}

		// //////////////////////////////////////ERROR HANDLER
		// END////////////////////////////////////////
	
	
	// ///////////////////////ERROR
	// HANDLER////////////////////////////////////////////////////////

	public String ErrorMessagehandlerExperiment() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		ErrorMessage4 = "";

		ErrorMessage1 = "";

		ErrorMessage2 = "";

		ErrorMessage5 = "";

		globalerrormessage = "";

		// //////////////////ERROR4/////////////////////////////////////////////////

		try {

			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

			String errorcounterxpath = ".//*[@class='control-group']";

			String errorfieldxpath = ".//*[@class='control-group'][xx]//*[@class='error' and not(self::select) and not(self::textarea) and not(self::input)]";

			int ObjCount2 = GetObjectCount(errorcounterxpath);

			for (int count = 1; count <= ObjCount2; count++) {

				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));

				try {

					String Error = MakeElement(NewXpath).getText();

					System.out.println("Error " + count + "is : " + Error);

					ErrorMessage4 = Error + ErrorMessage4;

				} catch (Exception e) {

				}

			}

		} catch (Exception e) {

		}

		// //////////////////ERROR4
		// END/////////////////////////////////////////////////

		// //////////////////ERROR
		// 1,2,5////////////////////////////////////////////////

		try {

			String compensationErrorMessageXpath = "//*[@id='page-message']";

			ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
					.getText();

			String errormessage = ".//*[@id='validation-summary']";

			ErrorMessage2 = MakeElement(errormessage).getText();

			ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
					.getText();

			try {

				String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

				ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
						.getText();

			} catch (Exception e) {

			}

			// Code appended by Lokesh on 13-April-2016 for check if
			// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
			// duplicate message in ErrorMessage1 or ErrorMessage5)
			try {
				if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
					ErrorMessage5 = "";
				}
			} catch (Exception error) {
			}

			System.out.println("The Error1 is " + ErrorMessage1);

			System.out.println("The Error2 is " + ErrorMessage2);

			System.out.println("The Error5 is " + ErrorMessage5);

		} catch (Exception e) {

			System.out.println("Exception occured: " + e);

		}

		// //////////////////ERROR 1,2,5
		// END///////////////////////////////////////////

		// ///////////////////server error
		// handle//////////////////////////////////////

		try {

			String servererrorxpath = "html/body/span/h1";

			ErrorMessage1 = MakeElement(servererrorxpath).getText();

			if (ErrorMessage1.equals("Server Error in '/' Application.")) {

				TakeScreenshot();

				globalerrormessage = ErrorMessage1;

				return globalerrormessage;

			}

		} catch (Exception e) {

		}

		// ///////////////////server error handle
		// END//////////////////////////////////////

		if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

		{

			if (CIMS_MainProject.questionarie_name1.equals("awards")
					| CIMS_MainProject.questionarie_name1
							.equals("Commercial_Success")
					| CIMS_MainProject.questionarie_name1.equals("Citizenship")
					| CIMS_MainProject.questionarie_name1
							.equals("Contacts_and_References")) {

				globalerrormessage = ErrorMessage4 + ErrorMessage2
						+ ErrorMessage5;

			} else if (CIMS_MainProject.questionarie_name1
					.equals("Residence_History")
					| CIMS_MainProject.questionarie_name1
							.equals("Travel_Plans")) {

				globalerrormessage = ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

			}

		}

		else {

			globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
					+ ErrorMessage5;

			if (globalerrormessage.contains("Success"))

			{

				globalerrormessage = "";

			}

		}

		globalerrormessage = globalerrormessage.replaceAll("\n", " ");

		return globalerrormessage;

	}

	// //////////////////////////////////////ERROR HANDLER
	// END////////////////////////////////////////
	
	
	
	// ///////////////////////ERROR
	// HANDLER////////////////////////////////////////////////////////

	public String questionnaireErrorMessageHandler() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		ErrorMessage4 = "";

		ErrorMessage1 = "";

		ErrorMessage2 = "";

		ErrorMessage5 = "";

		globalerrormessage = "";

		// //////////////////ERROR4/////////////////////////////////////////////////

		try {

			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

			String errorcounterxpath = ".//*[@class='control-group']";

			String errorfieldxpath = ".//*[@class='control-group'][xx]//*[@class='error' and not(self::select) and not(self::textarea) and not(self::input)]";

			int ObjCount2 = GetObjectCount(errorcounterxpath);

			for (int count = 1; count <= ObjCount2; count++) {

				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));

				try {

					String Error = MakeElement(NewXpath).getText();

					System.out.println("Error " + count + "is : " + Error);

					ErrorMessage4 = Error + ErrorMessage4;

				} catch (Exception e) {

				}

			}

		} catch (Exception e) {

		}

		// //////////////////ERROR4
		// END/////////////////////////////////////////////////

		// //////////////////ERROR
		// 1,2,5////////////////////////////////////////////////

		try {

			String compensationErrorMessageXpath = "//*[@id='page-message']//*[contains(@class,'error') and not(contains(@class,'HelpText')) and not(self::input) and not(self::select) and not(self::textarea)]";

			try{ErrorMessage5 = MakeElement(compensationErrorMessageXpath).getText();}catch(Exception error){}

			String errormessage = ".//*[@id='validation-summary']";

			try{ErrorMessage2 = MakeElement(errormessage).getText();}catch(Exception error){}

			try{ErrorMessage1 = MakeElement(compensationErrorMessageXpath).getText();}catch(Exception error){}

			try {

				String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

				try{ErrorMessage5 = MakeElement(compensationErrorMessageXpath1).getText();}catch(Exception error){}

			} catch (Exception e) {

			}

			// Code appended by Lokesh on 13-April-2016 for check if
			// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
			// duplicate message in ErrorMessage1 or ErrorMessage5)
			try {
				if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
					ErrorMessage5 = "";
				}
				if (ErrorMessage1.equalsIgnoreCase(ErrorMessage2)) {
					ErrorMessage2 = "";
				}
			} catch (Exception error) {
			}

			System.out.println("The Error1 is " + ErrorMessage1);

			System.out.println("The Error2 is " + ErrorMessage2);

			System.out.println("The Error5 is " + ErrorMessage5);

		} catch (Exception e) {

			System.out.println("Exception occured: " + e);

		}

		// //////////////////ERROR 1,2,5
		// END///////////////////////////////////////////

		// ///////////////////server error
		// handle//////////////////////////////////////

		try {

			String servererrorxpath = "html/body/span/h1";

			ErrorMessage1 = MakeElement(servererrorxpath).getText();

			if (ErrorMessage1.equals("Server Error in '/' Application.")) {

				TakeScreenshot();

				globalerrormessage = ErrorMessage1;

				return globalerrormessage;

			}

		} catch (Exception e) {

		}

		// ///////////////////server error handle
		// END//////////////////////////////////////

		if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

		{

			if (CIMS_MainProject.questionarie_name1.equals("awards")
					| CIMS_MainProject.questionarie_name1
							.equals("Commercial_Success")
					| CIMS_MainProject.questionarie_name1.equals("Citizenship")
					| CIMS_MainProject.questionarie_name1
							.equals("Contacts_and_References")) {

				globalerrormessage = ErrorMessage4 + ErrorMessage2
						+ ErrorMessage5;

			} else if (CIMS_MainProject.questionarie_name1
					.equals("Residence_History")
					| CIMS_MainProject.questionarie_name1
							.equals("Travel_Plans")) {

				globalerrormessage = ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

			}

		}

		else {

			globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
					+ ErrorMessage5;

			if (globalerrormessage.contains("Success"))

			{

				globalerrormessage = "";

			}

		}

		globalerrormessage = globalerrormessage.replaceAll("\n", " ");

		return globalerrormessage;

	}

	// //////////////////////////////////////ERROR HANDLER
	// END////////////////////////////////////////

	// ///////////////////////ERROR
		// HANDLER////////////////////////////////////////////////////////

		public String TravelPlanErrorMessageHandler() {

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			ErrorMessage4 = "";

			ErrorMessage1 = "";

			ErrorMessage2 = "";

			ErrorMessage5 = "";

			globalerrormessage = "";

			// //////////////////ERROR4/////////////////////////////////////////////////

			try {

				// String
				// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

				String errorcounterxpath = ".//*[@class='control-group']";

				String errorfieldxpath = ".//*[@class='control-group'][xx]//*[@class='error' and not(self::select) and not(self::textarea) not(self::input)]";

				int ObjCount2 = GetObjectCount(errorcounterxpath);

				for (int count = 1; count <= ObjCount2; count++) {

					String NewXpath = errorfieldxpath.replace("xx",
							Integer.toString(count));

					try {

						String Error = MakeElement(NewXpath).getText();

						System.out.println("Error " + count + "is : " + Error);

						ErrorMessage4 = Error + ErrorMessage4;

					} catch (Exception e) {

					}

				}

			} catch (Exception e) {

			}

			// //////////////////ERROR4
			// END/////////////////////////////////////////////////

			// //////////////////ERROR
			// 1,2,5////////////////////////////////////////////////

			try {

				String compensationErrorMessageXpath = "//*[@id='page-message']//*[contains(@class,'error') and not(contains(@class,'HelpText'))]";
				try {

					ErrorMessage5 = MakeElement(compensationErrorMessageXpath).getText();
				} catch (Exception e1) {
				}

				String errormessage = ".//*[@id='validation-summary']";

				try {
					ErrorMessage2 = MakeElement(errormessage).getText();

					ErrorMessage1 = MakeElement(compensationErrorMessageXpath).getText();
				} catch (Exception e1) {

				}

				try {

					String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

					ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
							.getText();

				} catch (Exception e) {

				}

				// Code appended by Lokesh on 13-April-2016 for check if
				// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
				// duplicate message in ErrorMessage1 or ErrorMessage5)
				try {
					if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
						ErrorMessage5 = "";
					}
					if (ErrorMessage1.equalsIgnoreCase(ErrorMessage2)) {
						ErrorMessage2 = "";
					}
				} catch (Exception error) {
				}

				System.out.println("The Error1 is " + ErrorMessage1);

				System.out.println("The Error2 is " + ErrorMessage2);

				System.out.println("The Error5 is " + ErrorMessage5);

			} catch (Exception e) {

				System.out.println("Exception occured: " + e);

			}

			// //////////////////ERROR 1,2,5
			// END///////////////////////////////////////////

			// ///////////////////server error
			// handle//////////////////////////////////////

			try {

				String servererrorxpath = "html/body/span/h1";

				ErrorMessage1 = MakeElement(servererrorxpath).getText();

				if (ErrorMessage1.equals("Server Error in '/' Application.")) {

					TakeScreenshot();

					globalerrormessage = ErrorMessage1;

					return globalerrormessage;

				}

			} catch (Exception e) {

			}

			// ///////////////////server error handle
			// END//////////////////////////////////////

			if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

			{

				if (CIMS_MainProject.questionarie_name1.equals("awards")
						| CIMS_MainProject.questionarie_name1
								.equals("Commercial_Success")
						| CIMS_MainProject.questionarie_name1.equals("Citizenship")
						| CIMS_MainProject.questionarie_name1
								.equals("Contacts_and_References")) {

					globalerrormessage = ErrorMessage4 + ErrorMessage2
							+ ErrorMessage5;

				} else if (CIMS_MainProject.questionarie_name1
						.equals("Residence_History")
						| CIMS_MainProject.questionarie_name1
								.equals("Travel_Plans")) {

					globalerrormessage = ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

				}

			}

			else {

				globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

				if (globalerrormessage.contains("Success"))

				{

					globalerrormessage = "";

				}

			}

			globalerrormessage = globalerrormessage.replaceAll("\n", " ");

			return globalerrormessage;

		}

		// //////////////////////////////////////ERROR HANDLER
		// END////////////////////////////////////////
	
	public void TestngReportNegativePassTestcase(String TestcaseID,
			String browser, String scenario, String action,
			String testcasedescription, String excecutionstatus,
			String errormessage, String errormessage1, String ModuleErrorMessage) {

		
		String PageTitle	=	"";
		String EmployeeName	=	"";
		String Time	=	"";

	
		try {
			if(!CIMS_MainProject.questionarie_name1.isEmpty()){
				PageTitle		=	CIMS_MainProject.questionarie_name1;
			}
		} catch (Exception e) {
		}
		try {
			if(!this.moduleName.isEmpty()){
				PageTitle		=	this.moduleName;
			}
		} catch (Exception e) {
			
		}
			
		try {
			if(!CIMS_MainProject.Employee_namecheck.isEmpty()){
				EmployeeName	=	CIMS_MainProject.Employee_namecheck;
			}
		} catch (Exception e) {

		}
		try {
			if (!this.Employee_namecheck.isEmpty()) {
				EmployeeName	=	this.Employee_namecheck;
			}
		} catch (Exception e1) {
		}
		

		try {
			if (!CIMS_MainProject.timer.isEmpty()) {

				Time =	CIMS_MainProject.timer;

			}
		} catch (Exception e) {

		} 
		try {
			if (!this.timer.isEmpty()) {

				Time =	this.timer;

			}
		} catch (Exception e) {

		}
		
		
		Reporter.log("<table border='1' style='background-color:white;border-color:black;width:100%;text-align:center'>" +
				"<tr style='color: rgb(255, 255, 255); background-color: rgb(122, 120, 6);'>" +
				"<td><b>" + PageTitle + " Page Report</b></td></tr></table>" +
			"<table cellspacing='1' cellpadding='3' border='1' style='background-color:white;width:100%;border-color:black'>" +
			"<thead style='color: rgb(255, 255, 255); background-color: rgb(122, 120, 6);'>" +
			"<tr><td>Test Case ID</td><td>Browser</td><td>Scenerio</td><td>Action</td><td>Test Case Description</td><td>Employee Name</td><td>Exceution Status</td><td>Error Message</td><td>Error Screenshot</td><td>Time taken to Execute</td></tr>" +
			"</thead><tbody>" +
			"<tr><td>"+
			TestcaseID+"</td><td>"+browser+"</td><td>"+ scenario+"</td><td>"+	action+ "</td><td>"+
testcasedescription+"</td><td>"+ EmployeeName+"</td><td>"+excecutionstatus+"</td><td>"+errormessage + errormessage1 + ModuleErrorMessage +"</td><td>"+

		"<a href=file:///" + FilePath + " target=_blank>Check Error</a>" +
				"</td><td>"+ Time + " seconds</td></tr></tbody></table>");

		
		// to generate negative pass dashboard report for questionnaire
		try{
			//System.out.println("\n\n\n\n\nI'm here LOKESH\n\n\n\n\n");
		if(!CIMS_MainProject.questionarie_name1.isEmpty()){
			try {
			obj_Report_Dashboard.writeDashBoardNegativePassReport(CIMS_MainProject.sheetName ,EmployeeName, TestcaseID, browser, scenario, action, testcasedescription, "Negative Pass", Time, errormessage, errormessage1, ModuleErrorMessage);	
			} catch (InterruptedException e) {
				System.out.println("unable to write negative pass report for : "+  CIMS_MainProject.sheetName + " > " +PageTitle);
			}
		}
		}catch(Exception w){
			System.out.println("unable to write questionnaire negative pass report for dashboard");
		}
		
	}

	// ////file upload////

	public void uploadfile(String path) {

		try {

			StringSelection stringSelection = new StringSelection(path);

			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();

			clipboard.setContents(stringSelection, null);

			Actions action = new Actions(driver);

			// First, go to your start point or Element

			// Then, move the mouse

			try{
				Thread.sleep(4000);
				action.moveByOffset(300, 150);
				action.perform();
			}catch(Exception error)
			{System.out.println("\n\t-->unable to move mouse pointer at oofset(s).");}

			Robot = new Robot();

			Thread.sleep(3000);

			Robot.keyPress(KeyEvent.VK_CONTROL);

			Robot.keyPress(KeyEvent.VK_V);

			Robot.keyRelease(KeyEvent.VK_CONTROL);

			Robot.keyRelease(KeyEvent.VK_V);

			Thread.sleep(2000);

			Robot.keyPress(KeyEvent.VK_ENTER);

			Robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(1000);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// /////////////////////////////////////////P2P util
	// starts//////////////////////////////////

	public String geturldirectp2p(String QuestionarieName) {

		try {

			QuestionaireURL1 = "";

			String Fieldxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr[xx]/td/a";

			String Counterxpath = ".//*[@class='sidebarTable profileTable'][1]/tbody/tr";

			int ObjCount1 = GetObjectCount(Counterxpath);

			for (int count = 1; count <= ObjCount1; count++) {

				String NewXpath = Fieldxpath.replace("xx",
						Integer.toString(count));

				try {

					// QuestionaireURL1=MakeElement(NewXpath).getAttribute("href");

					QuestionaireName = MakeElement(NewXpath).getText();

					System.out.println("The Questionarie is :"
							+ QuestionaireName);

					if (QuestionaireName.equals(QuestionarieName)) {

						QuestionaireURL1 = MakeElement(NewXpath).getAttribute(
								"href");

						System.out.println("The Questionarie is :"
								+ QuestionaireURL1);

					}

				} catch (Exception e) {

				}

			}

		} catch (Exception d) {

		}

		return QuestionaireURL1;

	}

	// ////////////////////server Error Handler//////////////////////////

	public void ServerErrorHandler() {

		try {

			String servererrorxpath = "html/body/span/h1";

			ErrorMessage1 = MakeElement(servererrorxpath).getText();

			if (ErrorMessage1.equals("Server Error in '/' Application.")) {

				TakeScreenshot();

				driver.navigate().back();

			}

		} catch (Exception e) {

		}

	}

	// ////////////////////server handler closed////////////////////////

	// ////////////if module not found than close the side bar//////////

	public void closesidebar() {

		try {

			WebElement element = driver.findElement(By
					.xpath(".//*[@id='slider-icon']"));

			JavascriptExecutor executor = (JavascriptExecutor) driver;

			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(2000);

		} catch (Exception E) {

			System.out.println("Side bar Exception-->" + E);

		}

	}

	// //////////////save button for all Questionnaire//////////////////

	public void savebutton() {

		try{
			// in order to make sure upload window is closed before saving any form.. 
			Robot = new Robot();
			Robot.keyPress(KeyEvent.VK_ESCAPE);
			Robot.keyRelease(KeyEvent.VK_ESCAPE);
		}catch(Exception error){}

		try {

			String SaveButtonXpath = ".//*[@class='btn btn-primary']";

			MakeElement(SaveButtonXpath).click();
			Thread.sleep(1200);
			scrollToTop();

		} catch (Exception e) {

			System.out.println("Save button Exception-->" + e);

		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param checkboxExcelString
	 *            - excel data of checkbox title
	 * 
	 * 
	 * 
	 * @param elementXpath
	 *            - input xpath like //input[contains(@id,'FAQ.') and
	 *            contains(@name,'FAQ.')]
	 * 
	 * 
	 * 
	 * @param elementCounterXPath
	 *            inner HTML (that holds all or group of checkboxes) container
	 *            xpath
	 * 
	 * 
	 * 
	 * @return
	 * 
	 * 
	 * 
	 * @throws InterruptedException
	 */

	public Boolean getCheckboxFromInnerHtmlAndEnable(
			String checkboxExcelString, String elementXpath,
			String elementCounterXPath) throws InterruptedException {

		Boolean flag = false;

		Thread.sleep(500);

		if (checkboxExcelString.length() > 1) {

			// let us split all data from csv..

			String[] checkboxList = checkboxExcelString.split(",");

			String innerHTML = MakeElement(elementXpath).getAttribute(
					"innerHTML");

			innerHTML = innerHTML
					.substring(innerHTML.indexOf("</span><br>") + 11);

			elementCounterXPath = elementCounterXPath + "[ff]";

			String[] listItems = innerHTML.split("<br>");

			int s = 0;

			String NewFaqXpath;

			for (String faq : listItems) {

				s++;

				faq = faq.substring(faq.indexOf(">") + 1);

				if (Arrays.asList(checkboxList).contains(faq.trim())) {

					System.out.println("checkbox title : " + faq);

					// now get the input of this occurence and check it..

					NewFaqXpath = elementCounterXPath.replace("ff",
							Integer.toString(s));

					Thread.sleep(200);

					enableOrDisableCheckbox(NewFaqXpath, true); // enable is set
																// true because
																// we will find
																// the checkbox
																// only if it
																// has to be
																// checked

				}

			}

			flag = true;

		} else {

			System.out.println("checkbox list was missing");

			flag = false;

		}

		return flag;

	}

	/**
	 * 
	 * 
	 * 
	 * @author <brij.s@datariver.in>
	 * 
	 * 
	 * 
	 * @see bind click to a checkbox
	 * 
	 * 
	 * 
	 * @param String
	 *            checkboxXpath - enter xpath of the checkbox on which you want
	 *            to perform action
	 * 
	 * 
	 * 
	 * @param boolean check - true if you want the checbox to be checked or
	 *        false if you want that to be unchecked
	 * 
	 * 
	 * 
	 * @return
	 */

	public Boolean getCheckboxForNetworkPartnerInfoEnable(
			String checkboxExcelString, String elementXpath,
			String elementCounterXPath) throws InterruptedException {

		Boolean flag = false;

		Thread.sleep(500);
		if (checkboxExcelString.length() > 1) {
			// let us split all data from csv..
			String[] checkboxList = checkboxExcelString.split(",");
			String innerHTML = MakeElement(elementXpath).getAttribute(
					"innerHTML");
			innerHTML = innerHTML.substring(innerHTML.indexOf("<input"));
			elementCounterXPath = elementCounterXPath + "[ff]";
			String[] listItems = innerHTML.split("<br>");
			int s = 0;
			String NewFaqXpath;
			String spanText = "";
			String[] FaqArr = {};
			for (String faq : listItems) {
				s++;
				faq = faq.substring(faq.indexOf(">") + 1);
				FaqArr = faq.split("5px;\">");
				spanText = FaqArr[1].replace("</span>", "");

				if (Arrays.asList(checkboxList).contains(spanText.trim())) {
					System.out.println("checkbox title : " + spanText);
					// now get the input of this occurence and check it..
					NewFaqXpath = elementCounterXPath.replace("ff",
							Integer.toString(s));
					System.out.println("Print NewFaqXpath" + NewFaqXpath);
					System.out.println("Print faq" + spanText);
					Thread.sleep(1000);
					enableOrDisableCheckbox(NewFaqXpath, true); // enable is set
																// true because
																// we will find
																// the checkbox
																// only if it
																// has to be
																// checked
				}
			}
			flag = true;
		} else {
			System.out.println("checkbox list was missing");
			flag = false;
		}
		return flag;
	}

	public void enableOrDisableCheckbox(String checkboxXpath, boolean check) {

		String isCheckboxChecked = MakeElement(checkboxXpath).getAttribute(
				"checked");

		System.out.println("checkbox checkded status is: " + isCheckboxChecked);

		System.out.println("checkbox should be checked: " + check);

		if (check == true) { // we have to check the check box

			// now check if it is not checked

			if (Boolean.parseBoolean(isCheckboxChecked) != true) {

				try {

					MakeElement(checkboxXpath).click();

				} catch (Exception e) {

					System.out.print("unable to check the checkbox with name: "
							+ checkboxXpath);

				}

			}

		} else {

			// disable checkbox..

			if (Boolean.parseBoolean(isCheckboxChecked) == true) {

				try {

					MakeElement(checkboxXpath).click();

				} catch (Exception e) {

					System.out.print("unable to check the checkbox with name: "
							+ checkboxXpath);

				}

			}

		}

	}

	public boolean waitForAnElementToLoad(String elementXpath, boolean clickable) {

		//

		System.out.println("Now we are in waitForAnElementToLoad Function");

		boolean flag = false;

		try {

			WebDriverWait wait = new WebDriverWait(driver, 2);

			if (clickable == true) {

				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(elementXpath)));

				wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath(elementXpath)));

				flag = true;

			} else {

				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(elementXpath)));

				flag = true;

			}

			System.out.println("Element with xpath: " + elementXpath
					+ " found on the page");

		} catch (Exception e) {

			System.out.println("Unable to locate the element with xpath: "
					+ elementXpath);

		}

		return flag;

	}

	/**
	 * 
	 * 
	 * 
	 * This function is appended by Lokesh Kumar Sharma
	 * 
	 * 
	 * 
	 * Purpose of this function is to check and return date in dd mm yyyy
	 * format; means 2 digit date, 2digit month.
	 * 
	 * 
	 * 
	 * 
	 */

	public String changeDateFormat(String date)

	{

		String date1 = date;

		for (int i = -1; (i = date1.indexOf("/", i + 1)) != -1;)

		{

			if (i == 1)

			{

				StringBuffer sb = new StringBuffer(date1);

				sb.insert(0, "0");

				date1 = sb.toString();

				// System.out.println(date);

			}

			if (i == 4)

			{

				StringBuffer sb = new StringBuffer(date1);

				date1 = sb.insert(3, "0").toString();

				// System.out.println(date);

			}

		}

		return date1;

	}

	public void DeSelectdropdownvalue(String my_xpath)

	{

		Selectdropdownvaluebyindex(my_xpath, 0);

	}

	/**
	 * 
	 * 
	 * 
	 * saving class name and other data such as employee name & timer, that can
	 * be used later on (like report generation)
	 * 
	 * 
	 * 
	 * this code is appended by Brij Raj Singh <brij.s@daxima.com>
	 * 
	 * 
	 * 
	 * 
	 */

	public boolean updateModuleDataForReportGeneration(String moduleName,
			String EmployeeName, String timer) {

		if (moduleName != null) {

			this.moduleName = moduleName;

			this.Employee_namecheck = EmployeeName;

			this.timer = timer;
			
			/**
			 * updated code by Brij in order to generate timer..
			 */
			String RegressionModuleTimerPath	=	dashboard.projectReportTempPath + "regression_time"+File.separator+moduleName.toLowerCase().replace(" ", "_")+"_time";
			
			// before adding time to file let us read and add it
			String FileTime			= "00.00";
			try{
				System.out.println("\n file name: "+RegressionModuleTimerPath);
				FileTime		=	obj_Report_Dashboard.ReadFromFile(RegressionModuleTimerPath);
			}catch(Exception e){
				System.out.println("unable to read for module: "+moduleName);
			}
			
			
			// add time into temp file

			try{
				float IntFileTime  	=  (!FileTime.isEmpty())? Float.parseFloat(FileTime) + Float.parseFloat(timer): Float.parseFloat(timer);
				System.out.println("\n file name: "+RegressionModuleTimerPath);
				obj_Report_Dashboard.WriteToFile(Float.toString(IntFileTime), RegressionModuleTimerPath);
			}catch(Exception e){
				System.out.println("unable to write for module: "+moduleName);
			}

			return true;

		} else {

			return false;

		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param MenuString
	 * 
	 * 
	 * 
	 * @return
	 */

	public boolean goToAnyMenuByNavPath(String MenuString) {

		boolean flag = false;

		try {

			String[] NavList = MenuString.split(",");

			int i = 1;

			for (String nav : NavList) {

				String NavXPath = "//a[text()='" + nav + "']";

				waitForAnElementToLoad(NavXPath, true);

				MakeElement(NavXPath).click();

				System.out.println("menu item:" + nav);

				if (i == NavList.length) {

					System.out.println("navigation " + nav + " matched!");

					flag = true;

				}

				i++;

			}

		} catch (Exception e) {

		}

		return flag;

	}

	/**
	 * 
	 * 
	 * 
	 * this function is used to zoon in into current html content
	 * 
	 * 
	 * 
	 * @param counter
	 * 
	 * 
	 * 
	 * @return boolean
	 */

	public boolean zoomIn(int counter) {

		try {

			String increaseScreenSize = Keys.chord(Keys.CONTROL, Keys.ADD);

			for (int c = 1; c <= counter; c++) {

				driver.findElement(By.tagName("html")).sendKeys(
						increaseScreenSize);

				Thread.sleep(250);

			}

			System.out.println("zoom in for " + counter + " time(s)");

			return true;

		} catch (Exception e) {

			System.out.println("unable to zoom in");

			return false;

		}

	}

	public boolean zoomOut(int counter) {

		try {

			String reduceScreenSize = Keys.chord(Keys.CONTROL, Keys.SUBTRACT);

			for (int c = 1; c <= counter; c++) {

				driver.findElement(By.tagName("html")).sendKeys(
						reduceScreenSize);

				Thread.sleep(250);

			}

			System.out.println("zoom out for " + counter + " time(s)");

			return true;

		} catch (Exception e) {

			System.out.println("unable to zoom out");

			return false;

		}

	}

	public void zoomreset() {

		try {

			driver.findElement(By.tagName("html")).sendKeys(
					Keys.chord(Keys.CONTROL, "0"));

		}

		catch (Exception e)

		{
			System.out.println("Error when try to reset the zoom to 100%");
		}

	}

	public boolean selectFirstResultFromAutoSuggestion(String ElementXPath) {

		try {

			Thread.sleep(1000);

			driver.findElement(By.xpath(ElementXPath))
					.sendKeys(Keys.ARROW_DOWN);

			// Robot= new Robot();

			//

			// Thread.sleep(500);

			// Robot.keyPress(KeyEvent.VK_DOWN);

			// Robot.keyRelease(KeyEvent.VK_DOWN);

			// Thread.sleep(400);

			// Robot.keyPress(KeyEvent.VK_ENTER);

			// Robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(1500);

			driver.findElement(By.xpath(ElementXPath)).sendKeys(Keys.ENTER);

			return true;

		} catch (Exception e) {

			System.out.println("unable to select data from auto suggestion");

			return false;

		}

	}

	/**
	 * 
	 * 
	 * 
	 * this function is used to scroll towards top of the current HTML
	 * page/document.
	 * 
	 * 
	 * 
	 * @return boolean
	 */

	public boolean scrollToTop() {

		try {

			String scrollToTop = Keys.chord(Keys.CONTROL, Keys.HOME);

			driver.findElement(By.tagName("html")).sendKeys(scrollToTop);

			Thread.sleep(200);

			System.out.println("we have scrolled to top!");

			return true;

		} catch (Exception e) {

			System.out.println("unable to scroll towards top");

			return false;

		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @return
	 */

	public boolean scrollToBottom() {

		try {

			String scrollToBottom = Keys.chord(Keys.CONTROL, Keys.DOWN);

			driver.findElement(By.tagName("html")).sendKeys(scrollToBottom);

			Thread.sleep(200);

			System.out.println("we have scrolled to bottom!");

			return true;

		} catch (Exception e) {

			System.out.println("unable to scroll towards bottom");

			return false;

		}

	}

	/**
	 * 
	 * 
	 * 
	 * this returns time in milli secs
	 * 
	 * 
	 * 
	 * @param startTime
	 *            long data type
	 * 
	 * 
	 * 
	 * @return
	 */

	public String getTimeTakenByModule(long startTime) {

		// /////TIMER END/////////////

		long endTime = System.currentTimeMillis();

		float seconds = (endTime - startTime) / 1000F;

		System.out.println();

		System.out.println("Test total run time = " + Float.toString(seconds)
				+ " seconds");

		CIMS.CIMS_Company.timer = timer;

		System.out.println();

		return Float.toString(seconds);

	}

	public void addCustomFieldData(String Xpathnew1, String Xpathnew2,
			String Excelsheet, String sheetName) {

		// /////excel data for additional info////////////

		String Additionalinfobutton = getCellData(Excelsheet, sheetName, 0, 1);

		String Additionalinfoselect = getCellData(Excelsheet, sheetName, 1, 1);

		String Additionalinfotext = getCellData(Excelsheet, sheetName, 2, 1);

		String Additionalinfotextarea = getCellData(Excelsheet, sheetName, 3, 1);

		String Additionalinfonnumber = getCellData(Excelsheet, sheetName, 4, 1);

		String Additionalinfodate = getCellData(Excelsheet, sheetName, 5, 1);

		String Additionalinfodecimalnumber = getCellData(Excelsheet, sheetName,
				6, 1);

		int ObjCount1 = GetObjectCount(Xpathnew1);

		String DropDownXpath = "";

		int Value = 0;

		for (int ControlCount = 1; ControlCount <= ObjCount1; ControlCount++) {

			String ObjectControlsXpath = Xpathnew2.replace("xx",
					Integer.toString(ControlCount));

			try {

				String ControlType = MakeElement(ObjectControlsXpath)
						.getAttribute("id");

				if (ControlType.contains("ctm_bt")) {

					MakeElement(ObjectControlsXpath).click();

				}

				else if (ControlType.contains("ctm_sl")) {

					// Selectdropdownvaluebyvalue(ObjectControlsXpath, "589");

					Selectdropdownvaluebyindex(ObjectControlsXpath, 1);

				}

				else if (ControlType.contains("ctm_tx") && Value != 1) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotext);

					Value = 1;

				}

				else if (ControlType.contains("ctm_ta")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotextarea);

				}

				else if (ControlType.contains("ctm_tx")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfotext);

				}

				else if (ControlType.contains("ctm_bt")) {

					MakeElement(ObjectControlsXpath).click();

				}

				else if (ControlType.contains("ctm_in")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfonnumber);

				}

				else if (ControlType.contains("ctm_dt")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfodate);

				}

				else if (ControlType.contains("ctm_de")) {

					MakeElement(ObjectControlsXpath).clear();

					MakeElement(ObjectControlsXpath).sendKeys(
							Additionalinfodecimalnumber);

				}

			} catch (Exception e) {

			}

		}

	}

	public boolean goToMenuSubItems(String MenuItemTitle) {
		boolean flag = false;
		// first of all click on Menu Link so that all sub menus are opened
		try {
			MakeElement("//a[text()='Menu']").click();
			System.out.println("clicked on menu link");
			Thread.sleep(1000);
			// if clicked on menu then move to sub items..
			String SubMenuCounterXPath = "//*[@class='gn-menu']/li";

			String SubItemXPath = "//*[@class='gn-menu']//li[xx]//*[@class='gn-submenu']//*[text()='"
					+ MenuItemTitle + "']";

			int count = GetObjectCount(SubMenuCounterXPath);

			if (flag == false) {

				for (int i = 1; i <= count; i++) {

					Thread.sleep(1000);

					String NewSubMenuITemXPath = SubItemXPath.replace("xx",
							Integer.toString(i));

					boolean readyToClick = waitForAnElementToLoad(
							NewSubMenuITemXPath, true);

					if (readyToClick) {

						try {

							MakeElement(NewSubMenuITemXPath).click();

							flag = true;

							System.out
									.println("user has clicked on menu item: "
											+ MenuItemTitle);

							break;

						} catch (Exception e) {

							System.out.println("link found for "
									+ MenuItemTitle + " in list number " + i
									+ " but not clickable");

						}

					} else {

						System.out.println("unable to find link for "
								+ MenuItemTitle + " in list number " + i);

						continue;

					}

				}

			}

		} catch (Exception e) {

			System.out.println("unable to click on Menu link");

		}

		if (flag == false) {
			try {
				MakeElement("//a[text()='Menu']").click();
			} catch (Exception e) {
			}

		}

		return flag;

	}

	public boolean isAttributePresent(WebElement element, String attribute) {

		Boolean result = false;

		try {

			String value = element.getAttribute(attribute);

			if (value != null && !value.isEmpty()) {

				result = true;

			}

		} catch (Exception e) {
		}

		return result;

	}

	public String OSDetector() {

		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {

			return "Windows";

		} else if (os.contains("nux") || os.contains("nix")) {

			return "Linux";

		} else if (os.contains("mac")) {

			return "Mac";

		} else if (os.contains("sunos")) {

			return "Solaris";

		} else {

			return "Other";

		}

	}

	/*
	 * Code appended by Lokesh for search and match in leftnavigation on
	 * 6-April-2016
	 */

	public boolean searchandcompare(String Page_title)
			throws InterruptedException {

		boolean flag = false;
		ErrorMessage4 = "";
		globalerrormessage = "";
		String checkpermissionxpath="html/body/h2";
		
		//String Previouspagexpath="html/body/ul/li[1]/a";
		String Previouspagexpath=UtilFunction.getCellData(CIMS.CIMS_Left_Navigation.ExcelFileName, "Credentials", 1, 1);

//		System.out.println("\n\n*** ***User enter page title ---" + Page_title+ "---.*** ***\n\n");

		// Variable declare
		String xpath_one = ".//*[text()='" + Page_title + "']";
		String xpath_two = "//*[@class='container']//div[text(),'" + Page_title
				+ "')]";
		String xpath_three = ".//*[@id='panel-header' and contains(text(),'"
				+ Page_title + "')]";
		String xpath_four = ".//*[contains(@id,'panel')]//*[contains(text(),'"
				+ Page_title + "')]";
		String gettext = "";

		Thread.sleep(700);
		try {
			gettext = MakeElement(xpath_one).getText();
		} catch (Exception error) {
		}

		if (gettext.equals(Page_title)) {
			flag = true; // Pass
							// //System.out.println("\n----\n----\nPass with 1st check.");
		} else {
			// Fail; Now try with another xpath
			gettext = "";
			try {
				gettext = MakeElement(xpath_two).getText();
			} catch (Exception error) {
			}
			if (gettext.equals(Page_title)) {
				flag = true; // Pass
								// //System.out.println("\n----\n----\nPass with 2nd check.");
			} else {
				// Fail; Now try with another xpath
				gettext = "";
				try {
					gettext = MakeElement(xpath_three).getText();
				} catch (Exception error) {
				}

				if (gettext.equals(Page_title)) {
					flag = true; // Pass
									// //System.out.println("\n----\n----\nPass with 3rd check.");
				} else {
					// Fail; Now try with another xpath
					gettext = "";
					try {
						gettext = MakeElement(xpath_four).getText();
					} catch (Exception error) {
					}

					if (gettext.equals(Page_title)) {
						flag = true; // Pass
										// //System.out.println("\n----\n----\nPass with 4th check.");
					} else {
//						System.out.println("\n====Not pass with any of check condition.\n===");
						flag = false;
						String checkpermissiontext="";
						try{
						checkpermissiontext=MakeElement(checkpermissionxpath).getText();
						}catch(Exception error){}
						
						if(checkpermissiontext!="")
						{
							TakeScreenshot();	
							ErrorMessage4 = ErrorMessage4+ "You do not have permission to access the specified resource.";
							try{
								Thread.sleep(2000);
								//MakeElement(Previouspagexpath).click();
								driver.navigate().to(Previouspagexpath);
								
								Thread.sleep(2000);
							}catch(Exception error){}
						}
						else
						{TakeScreenshot();
						ErrorMessage4 = ErrorMessage4
								+ "Page title is not match with the page title entered by user.";
						
						}
						}
				}
			}
		}
		return flag;
	}

	/***
	 * @param filename
	 * @param sheetName
	 * @return
	 */

	public boolean CompanyRoles(String filename, String sheetName) {

		boolean flag = false;
		// collect data from regression's excelsheet > BAL Contact sheet

		String BalContactSheet = "BAL Contacts";
		int CompanyRoleRowCount = UtilFunction.usedRowCount(filename,
				BalContactSheet);
		int columnNumber_SPI_Module_nm = UtilFunction.getColumnWithCellData(
				filename, BalContactSheet, "Module Name");

		String[] RoleNames = {};

		try {

			for (int roleCounter = 1; roleCounter < CompanyRoleRowCount; roleCounter++) {

				try {
					if (UtilFunction.getCellData(filename, BalContactSheet,
							columnNumber_SPI_Module_nm, roleCounter).equals(
							sheetName)) {
						// we have check if data is present in Bal Contact sheet
						// now let us pull record according to
						System.out
								.println("we have check if data is present in Bal Contact sheet now let us pull record according to");

						String numberOfRoles = UtilFunction.getCellData(
								filename, BalContactSheet, 1, roleCounter);
						int intValOfNumberOfRoles = Integer
								.parseInt(numberOfRoles);

						for (int r = 1; r <= intValOfNumberOfRoles; r++) {
							RoleNames[r] = UtilFunction.getCellData(filename,
									BalContactSheet, r + 1, roleCounter);
						}

					}
				} catch (Exception e) {
					System.out
							.println("some issue with collecting data from sheet "
									+ BalContactSheet);
				}
			}
		} catch (Exception e) {
			System.out.println("unable to count records from "
					+ BalContactSheet);
		}

		System.out.println("yes we are on step third now..");
		// now set company contacts...

		int counterOfBalFullName = 1; // starts with 0,
		String BalContactRoleAssigmentCounterXPath = "//*[contains(@class,'ng-scope')]//*[contains(@class,'ngRow')]//*[contains(@class,'colt"
				+ counterOfBalFullName + "')]";
		String BalContactRoleAssigmentXPath = "//*[contains(@class,'ng-scope')]//*[contains(@class,'ngRow')][xx]//*[contains(@class,'colt"
				+ counterOfBalFullName + "')]";

		int BCRACounter = GetObjectCount(BalContactRoleAssigmentCounterXPath);

		for (int b = 1; b <= BCRACounter; b++) {
			String NewBalContactXPath = BalContactRoleAssigmentXPath.replace(
					"xx", Integer.toString(b));
			try {
				MakeElement(NewBalContactXPath).click();
				Thread.sleep(2000);
				MakeElement(NewBalContactXPath).sendKeys();
			} catch (Exception e) {
				System.out.println("unable to save middle name");
			}

		}

		return flag;

	}

	/** exception handler for popup notification **/

	public String NotificationErrorMessagehandlerExperiment() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		ErrorMessage4 = "";
		ErrorMessage1 = "";
		ErrorMessage2 = "";
		ErrorMessage5 = "";
		globalerrormessage = "";
		// //////////////////ERROR4/////////////////////////////////////////////////
		try {
			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";
			String errorcounterxpath = ".//*[@class='control-group']";
			String errorfieldxpath = ".//*[@id='validation-summary-popup']";
			int ObjCount2 = GetObjectCount(errorcounterxpath);
			for (int count = 1; count <= ObjCount2; count++) {
				Thread.sleep(500);
				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));
				try {
					String Error = MakeElement(NewXpath).getText();
					System.out.println("Error " + count + "is : " + Error);
					if (!Error.equals(ErrorMessage4)) {
						ErrorMessage4 = Error + ErrorMessage4;
					}
				} catch (Exception e) {
				}
			}
			if (ErrorMessage4.equals("")) {
				String errorfieldxpath1 = "//*[@id='page-message-popup']";
				try {
					String Error1 = "";
					Error1 = MakeElement(errorfieldxpath1).getText();
					if (!Error1.equals(ErrorMessage4)) {
						ErrorMessage4 = Error1 + ErrorMessage4;
					}

				} catch (Exception e) {
				}
			}
			System.out.println("ErrorMessage4 is:" + ErrorMessage4);
		} catch (Exception e) {
		}
		// //////////////////ERROR4
		// END/////////////////////////////////////////////////
		// //////////////////ERROR
		// 1,2,5////////////////////////////////////////////////
		try {
			String compensationErrorMessageXpath = "//*[@id='page-message']";
			ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
					.getText();
			String errormessage = ".//*[@id='validation-summary']";
			ErrorMessage2 = MakeElement(errormessage).getText();
			ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
					.getText();
			try {
				String compensationErrorMessageXpath1 = "//*[@id='page-message1']";
				ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
						.getText();
			} catch (Exception e) {
			}
			// Code appended by Lokesh on 13-April-2016 for check if
			// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
			// duplicate message in ErrorMessage1 or ErrorMessage5)
			try {
				if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
					ErrorMessage5 = "";
				}
			} catch (Exception error) {
			}
			System.out.println("The Error1 is " + ErrorMessage1);
			System.out.println("The Error2 is " + ErrorMessage2);
			System.out.println("The Error5 is " + ErrorMessage5);
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
		}
		// //////////////////ERROR 1,2,5
		// END///////////////////////////////////////////

		// ///////////////////server error
		// handle//////////////////////////////////////
		try {
			String servererrorxpath = "html/body/span/h1";
			ErrorMessage1 = MakeElement(servererrorxpath).getText();
			if (ErrorMessage1.equals("Server Error in '/' Application.")) {
				TakeScreenshot();
				globalerrormessage = ErrorMessage1;
				return globalerrormessage;
			}
		} catch (Exception e) {
		}

		// ///////////////////server error handle
		// END//////////////////////////////////////
		if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls")) {
			if (CIMS_MainProject.questionarie_name1.equals("awards")
					| CIMS_MainProject.questionarie_name1
							.equals("Commercial_Success")
					| CIMS_MainProject.questionarie_name1.equals("Citizenship")
					| CIMS_MainProject.questionarie_name1
							.equals("Contacts_and_References")) {
				globalerrormessage = ErrorMessage4 + ErrorMessage2
						+ ErrorMessage5;
			} else if (CIMS_MainProject.questionarie_name1
					.equals("Residence_History")
					| CIMS_MainProject.questionarie_name1
							.equals("Travel_Plans")) {
				globalerrormessage = ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;
			}
		} else {
			globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
					+ ErrorMessage5;
			if (globalerrormessage.contains("Success")) {
				globalerrormessage = "";
			}
		}
		globalerrormessage = globalerrormessage.replaceAll("\n", " ");
		return globalerrormessage;
	}
	
	//written by dharam 
	
	// ///////////////////////ERROR
	// HANDLER////////////////////////////////////////////////////////

	public String ErrorMessageGCPTravelHistoyhandlerExperiment() {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		ErrorMessage4 = "";

		ErrorMessage1 = "";

		ErrorMessage2 = "";

		ErrorMessage5 = "";

		globalerrormessage = "";

		// //////////////////ERROR4/////////////////////////////////////////////////

		try {

			// String
			// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

			String errorcounterxpath = ".//*[@id='tblDestination']//tr";

			String errorfieldxpath = ".//*[@id='tblDestination']//tr[xx]//label[contains(@class,'error')]";

			int ObjCount2 = GetObjectCount(errorcounterxpath);

			for (int count = 1; count <= ObjCount2; count++) {

				String NewXpath = errorfieldxpath.replace("xx",
						Integer.toString(count));

				try {

					String Error = MakeElement(NewXpath).getText();

					System.out.println("Error " + count + "is : " + Error);

					ErrorMessage4 = Error + ErrorMessage4;

				} catch (Exception e) {

				}

			}

		} catch (Exception e) {

		}

		// //////////////////ERROR4
		// END/////////////////////////////////////////////////

		// //////////////////ERROR
		// 1,2,5////////////////////////////////////////////////

		try {

			String compensationErrorMessageXpath = "//*[@id='page-message']";

			ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
					.getText();

			String errormessage = ".//*[@id='validation-summary']";

			ErrorMessage2 = MakeElement(errormessage).getText();

			ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
					.getText();

			try {

				String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

				ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
						.getText();

			} catch (Exception e) {

			}

			// Code appended by Lokesh on 13-April-2016 for check if
			// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
			// duplicate message in ErrorMessage1 or ErrorMessage5)
			try {
				if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
					ErrorMessage5 = "";
				}
			} catch (Exception error) {
			}

			System.out.println("The Error1 is " + ErrorMessage1);

			System.out.println("The Error2 is " + ErrorMessage2);

			System.out.println("The Error5 is " + ErrorMessage5);

		} catch (Exception e) {

			System.out.println("Exception occured: " + e);

		}

		// //////////////////ERROR 1,2,5
		// END///////////////////////////////////////////

		// ///////////////////server error
		// handle//////////////////////////////////////

		try {

			String servererrorxpath = "html/body/span/h1";

			ErrorMessage1 = MakeElement(servererrorxpath).getText();

			if (ErrorMessage1.equals("Server Error in '/' Application.")) {

				TakeScreenshot();

				globalerrormessage = ErrorMessage1;

				return globalerrormessage;

			}

		} catch (Exception e) {

		}

		// ///////////////////server error handle
		// END//////////////////////////////////////

		if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

		{

			if (CIMS_MainProject.questionarie_name1.equals("awards")
					| CIMS_MainProject.questionarie_name1
							.equals("Commercial_Success")
					| CIMS_MainProject.questionarie_name1.equals("Citizenship")
					| CIMS_MainProject.questionarie_name1
							.equals("Contacts_and_References")) {

				globalerrormessage = ErrorMessage4 + ErrorMessage2
						+ ErrorMessage5;

			} else if (CIMS_MainProject.questionarie_name1
					.equals("Residence_History")
					| CIMS_MainProject.questionarie_name1
							.equals("Travel_Plans")) {

				globalerrormessage = ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

			}

		}

		else {

			globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
					+ ErrorMessage5;

			if (globalerrormessage.contains("Success"))

			{

				globalerrormessage = "";

			}

		}

		globalerrormessage = globalerrormessage.replaceAll("\n", " ");

		return globalerrormessage;

	}

		
		// My code end here 
	
	// Written by dharam-code start here for Permission Admin popup
	
	
			/** exception handler for popup notification **/

			public String PermissionErrorMessagehandlerExperiment() {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				ErrorMessage4 = "";
				ErrorMessage1 = "";
				ErrorMessage2 = "";
				ErrorMessage5 = "";
				globalerrormessage = "";
				// //////////////////ERROR4/////////////////////////////////////////////////
				try {
					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";
					String errorcounterxpath = "//*[contains(@class,'modal-body')]//.[contains(@id,'popup')]//li";
					String errorfieldxpath = "//*[contains(@class,'modal-body')]//.[contains(@id,'popup')]//li[xx]//label[contains(@class,'error')]";
					int ObjCount2 = GetObjectCount(errorcounterxpath);
					for (int count = 1; count <= ObjCount2; count++) {
						Thread.sleep(500);
						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));
						try {
							String Error = MakeElement(NewXpath).getText();
							System.out.println("Error " + count + "is : " + Error);
							if (!Error.equals(ErrorMessage4)) {
								ErrorMessage4 = Error + ErrorMessage4;
							}
						} catch (Exception e) {
						}
					}
					if (ErrorMessage4.equals("")) {
						String errorfieldxpath1 = "//*[@id='page-message-popup']";
						try {
							String Error1 = "";
							Error1 = MakeElement(errorfieldxpath1).getText();
							if (!Error1.equals(ErrorMessage4)) {
								ErrorMessage4 = Error1 + ErrorMessage4;
							}

						} catch (Exception e) {
						}
					}
					System.out.println("ErrorMessage4 is:" + ErrorMessage4);
				} catch (Exception e) {
				}
				// //////////////////ERROR4
				// END/////////////////////////////////////////////////
				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////
				try {
					String compensationErrorMessageXpath = "//*[@id='page-message']";
					ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
							.getText();
					String errormessage = ".//*[@id='validation-summary']";
					ErrorMessage2 = MakeElement(errormessage).getText();
					ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
							.getText();
					try {
						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";
						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();
					} catch (Exception e) {
					}
					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
					} catch (Exception error) {
					}
					System.out.println("The Error1 is " + ErrorMessage1);
					System.out.println("The Error2 is " + ErrorMessage2);
					System.out.println("The Error5 is " + ErrorMessage5);
				} catch (Exception e) {
					System.out.println("Exception occured: " + e);
				}
				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////
				try {
					String servererrorxpath = "html/body/span/h1";
					ErrorMessage1 = MakeElement(servererrorxpath).getText();
					if (ErrorMessage1.equals("Server Error in '/' Application.")) {
						TakeScreenshot();
						globalerrormessage = ErrorMessage1;
						return globalerrormessage;
					}
				} catch (Exception e) {
				}

				// ///////////////////server error handle
				// END//////////////////////////////////////
				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls")) {
					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {
						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;
					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {
						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;
					}
				} else {
					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;
					if (globalerrormessage.contains("Success")) {
						globalerrormessage = "";
					}
				}
				globalerrormessage = globalerrormessage.replaceAll("\n", " ");
				return globalerrormessage;
			}
			
			
			
		// my code end here 	
			
			// written by dharam 
	

			public String PoclassificationErrorMessageHandler() {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				ErrorMessage4 = "";

				ErrorMessage1 = "";

				ErrorMessage2 = "";

				ErrorMessage5 = "";

				globalerrormessage = "";

				// //////////////////ERROR4/////////////////////////////////////////////////

				try {

					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

					String errorcounterxpath = ".//*[@class='control-group']";

					String errorfieldxpath = ".//*[@class='control-group'][xx]//*[@class='error' and not(self::select) and not(self::textarea) and not(self::input)]";

					int ObjCount2 = GetObjectCount(errorcounterxpath);

					for (int count = 1; count <= ObjCount2; count++) {

						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));

						try {

							String Error = MakeElement(NewXpath).getText();

							System.out.println("Error " + count + "is : " + Error);

							ErrorMessage4 = Error + ErrorMessage4;

						} catch (Exception e) {

						}

					}

				} catch (Exception e) {

				}

				// //////////////////ERROR4
				// END/////////////////////////////////////////////////

				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////

				try {

					String compensationErrorMessageXpath = "//*[@id='page-message']//.[contains(@class,'error') and not(contains(@class,'HelpText'))]";
					try {

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {
					}

					String errormessage = ".//*[@id='validation-summary']";

					try {
						ErrorMessage2 = MakeElement(errormessage).getText();

						ErrorMessage1 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {

					}

					try {

						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();

					} catch (Exception e) {

					}

					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage2)) {
							ErrorMessage2 = "";
						}
					} catch (Exception error) {
					}

					System.out.println("The Error1 is " + ErrorMessage1);

					System.out.println("The Error2 is " + ErrorMessage2);

					System.out.println("The Error5 is " + ErrorMessage5);

				} catch (Exception e) {

					System.out.println("Exception occured: " + e);

				}

				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////

				try {

					String servererrorxpath = "html/body/span/h1";

					ErrorMessage1 = MakeElement(servererrorxpath).getText();

					if (ErrorMessage1.equals("Server Error in '/' Application.")) {

						TakeScreenshot();

						globalerrormessage = ErrorMessage1;

						return globalerrormessage;

					}

				} catch (Exception e) {

				}

				// ///////////////////server error handle
				// END//////////////////////////////////////

				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

				{

					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {

						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;

					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {

						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;

					}

				}

				else {

					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

					if (globalerrormessage.contains("Success"))

					{

						globalerrormessage = "";

					}

				}

				globalerrormessage = globalerrormessage.replaceAll("\n", " ");

				return globalerrormessage;

			}

			
			
			//my code end here 
			
			
			// Web access Error handler start here 
			
			

			public String WebAccessErrorMessageHandler() {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				ErrorMessage4 = "";

				ErrorMessage1 = "";

				ErrorMessage2 = "";

				ErrorMessage5 = "";

				globalerrormessage = "";

				// //////////////////ERROR4/////////////////////////////////////////////////

				try {

					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

					String errorcounterxpath = ".//*[@class='action-bar']//li";

					String errorfieldxpath = ".//*[@class='action-bar']//li[xx]//*[@class='error' and not(self::select) and not(self::textarea) and not(self::input)]";

					int ObjCount2 = GetObjectCount(errorcounterxpath);

					for (int count = 1; count <= ObjCount2; count++) {

						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));

						try {

							String Error = MakeElement(NewXpath).getText();

							System.out.println("Error " + count + "is : " + Error);

							ErrorMessage4 = Error + ErrorMessage4;

						} catch (Exception e) {

						}

					}

				} catch (Exception e) {

				}

				// //////////////////ERROR4
				// END/////////////////////////////////////////////////

				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////

				try {

					String compensationErrorMessageXpath = "//*[@id='page-message']//.[contains(@class,'error') and not(contains(@class,'HelpText'))]";
					try {

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {
					}

					String errormessage = ".//*[@id='validation-summary']";

					try {
						ErrorMessage2 = MakeElement(errormessage).getText();

						ErrorMessage1 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {

					}

					try {

						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();

					} catch (Exception e) {

					}

					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage2)) {
							ErrorMessage2 = "";
						}
					} catch (Exception error) {
					}

					System.out.println("The Error1 is " + ErrorMessage1);

					System.out.println("The Error2 is " + ErrorMessage2);

					System.out.println("The Error5 is " + ErrorMessage5);

				} catch (Exception e) {

					System.out.println("Exception occured: " + e);

				}

				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////

				try {

					String servererrorxpath = "html/body/span/h1";

					ErrorMessage1 = MakeElement(servererrorxpath).getText();

					if (ErrorMessage1.equals("Server Error in '/' Application.")) {

						TakeScreenshot();

						globalerrormessage = ErrorMessage1;

						return globalerrormessage;

					}

				} catch (Exception e) {

				}

				// ///////////////////server error handle
				// END//////////////////////////////////////

				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

				{

					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {

						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;

					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {

						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;

					}

				}

				else {

					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

					if (globalerrormessage.contains("Success"))

					{

						globalerrormessage = "";

					}

				}

				globalerrormessage = globalerrormessage.replaceAll("\n", " ");

				return globalerrormessage;

			}

			
			// Web access Error handler end here 
			
			// written by dharam
			
			
			public String ErrorMessageHandlerofGEN(){
				


				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				ErrorMessage4 = "";
				ErrorMessage1 = "";
				ErrorMessage2 = "";
				ErrorMessage5 = "";
				globalerrormessage = "";
				// //////////////////ERROR4/////////////////////////////////////////////////
				try {
					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";
					String errorcounterxpath = ".//*[contains(@id,'validation-summary')]//li";
					String errorfieldxpath = ".//*[contains(@id,'validation-summary')]//li[xx]//*[@class='error']";
					int ObjCount2 = GetObjectCount(errorcounterxpath);
					for (int count = 1; count <= ObjCount2; count++) {
						Thread.sleep(500);
						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));
						try {
							String Error = MakeElement(NewXpath).getText();
							System.out.println("Error " + count + "is : " + Error);
							if (!Error.equals(ErrorMessage4)) {
								ErrorMessage4 = Error + ErrorMessage4;
							}
						} catch (Exception e) {
						}
					}
					if (ErrorMessage4.equals("")) {
						String errorfieldxpath1 = "//*[@id='page-message-popup']";
						try {
							String Error1 = "";
							Error1 = MakeElement(errorfieldxpath1).getText();
							if (!Error1.equals(ErrorMessage4)) {
								ErrorMessage4 = Error1 + ErrorMessage4;
							}

						} catch (Exception e) {
						}
					}
					System.out.println("ErrorMessage4 is:" + ErrorMessage4);
				} catch (Exception e) {
				}
				// //////////////////ERROR4
				// END/////////////////////////////////////////////////
				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////
				try {
					String compensationErrorMessageXpath = "//*[@id='page-message']";
					ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
							.getText();
					String errormessage = ".//*[@id='validation-summary']";
					ErrorMessage2 = MakeElement(errormessage).getText();
					ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
							.getText();
					try {
						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";
						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();
					} catch (Exception e) {
					}
					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
					} catch (Exception error) {
					}
					System.out.println("The Error1 is " + ErrorMessage1);
					System.out.println("The Error2 is " + ErrorMessage2);
					System.out.println("The Error5 is " + ErrorMessage5);
				} catch (Exception e) {
					System.out.println("Exception occured: " + e);
				}
				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////
				try {
					String servererrorxpath = "html/body/span/h1";
					ErrorMessage1 = MakeElement(servererrorxpath).getText();
					if (ErrorMessage1.equals("Server Error in '/' Application.")) {
						TakeScreenshot();
						globalerrormessage = ErrorMessage1;
						return globalerrormessage;
					}
				} catch (Exception e) {
				}

				// ///////////////////server error handle
				// END//////////////////////////////////////
				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls")) {
					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {
						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;
					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {
						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;
					}
				} else {
					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;
					if (globalerrormessage.contains("Success")) {
						globalerrormessage = "";
					}
				}
				globalerrormessage = globalerrormessage.replaceAll("\n", " ");
				return globalerrormessage;
			
			}
			
			
			// my code end here 
	
			// Web access Error handler start here 
			
			

			public String LockedAccountErrorMessageHandler() {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				ErrorMessage4 = "";

				ErrorMessage1 = "";

				ErrorMessage2 = "";

				ErrorMessage5 = "";

				globalerrormessage = "";

				// //////////////////ERROR4/////////////////////////////////////////////////

				try {

					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

					String errorcounterxpath = ".//*[@class='login-error']//li";

					String errorfieldxpath = ".//*[@class='login-error']//li[xx]";

					int ObjCount2 = GetObjectCount(errorcounterxpath);

					for (int count = 1; count <= ObjCount2; count++) {

						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));

						try {

							String Error = MakeElement(NewXpath).getText();

							System.out.println("Error " + count + "is : " + Error);

							ErrorMessage4 = Error + ErrorMessage4;

						} catch (Exception e) {

						}

					}

				} catch (Exception e) {

				}

				// //////////////////ERROR4
				// END/////////////////////////////////////////////////

				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////

				try {

					String compensationErrorMessageXpath = "//*[@id='page-message']//.[contains(@class,'error') and not(contains(@class,'HelpText'))]";
					try {

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {
					}

					String errormessage = ".//*[@id='validation-summary']";

					try {
						ErrorMessage2 = MakeElement(errormessage).getText();

						ErrorMessage1 = MakeElement(compensationErrorMessageXpath).getText();
					} catch (Exception e1) {

					}

					try {

						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();

					} catch (Exception e) {

					}

					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage2)) {
							ErrorMessage2 = "";
						}
					} catch (Exception error) {
					}

					System.out.println("The Error1 is " + ErrorMessage1);

					System.out.println("The Error2 is " + ErrorMessage2);

					System.out.println("The Error5 is " + ErrorMessage5);

				} catch (Exception e) {

					System.out.println("Exception occured: " + e);

				}

				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////

				try {

					String servererrorxpath = "html/body/span/h1";

					ErrorMessage1 = MakeElement(servererrorxpath).getText();

					if (ErrorMessage1.equals("Server Error in '/' Application.")) {

						TakeScreenshot();

						globalerrormessage = ErrorMessage1;

						return globalerrormessage;

					}

				} catch (Exception e) {

				}

				// ///////////////////server error handle
				// END//////////////////////////////////////

				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

				{

					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {

						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;

					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {

						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;

					}

				}

				else {

					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

					if (globalerrormessage.contains("Success"))

					{

						globalerrormessage = "";

					}

				}

				globalerrormessage = globalerrormessage.replaceAll("\n", " ");

				return globalerrormessage;

			}

			
			// Web access Error handler end here 
			
			// written by dharam
			// written by dharam
			
			
			public String GCPQuryHistoryErrorMessageHandler(){
				


				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				ErrorMessage4 = "";
				ErrorMessage1 = "";
				ErrorMessage2 = "";
				ErrorMessage5 = "";
				globalerrormessage = "";
				// //////////////////ERROR4/////////////////////////////////////////////////
				try {
					// String
					// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";
					String errorcounterxpath = ".//*[@class='form-horizontal']//table//tbody//tr//*[@class='alert alert-success']";
					String errorfieldxpath = ".//*[@class='form-horizontal']//table//tbody//tr[xx]//*[@class='alert alert-success']]";
					int ObjCount2 = GetObjectCount(errorcounterxpath);
					for (int count = 1; count <= ObjCount2; count++) {
						Thread.sleep(500);
						String NewXpath = errorfieldxpath.replace("xx",
								Integer.toString(count));
						try {
							String Error = MakeElement(NewXpath).getText();
							System.out.println("Error " + count + "is : " + Error);
							if (!Error.equals(ErrorMessage4)) {
								ErrorMessage4 = Error + ErrorMessage4;
							}
						} catch (Exception e) {
						}
					}
					if (ErrorMessage4.equals("")) {
						String errorfieldxpath1 = "//*[@id='page-message-popup']";
						try {
							String Error1 = "";
							Error1 = MakeElement(errorfieldxpath1).getText();
							if (!Error1.equals(ErrorMessage4)) {
								ErrorMessage4 = Error1 + ErrorMessage4;
							}

						} catch (Exception e) {
						}
					}
					System.out.println("ErrorMessage4 is:" + ErrorMessage4);
				} catch (Exception e) {
				}
				// //////////////////ERROR4
				// END/////////////////////////////////////////////////
				// //////////////////ERROR
				// 1,2,5////////////////////////////////////////////////
				try {
					String compensationErrorMessageXpath = "//*[@id='page-message']";
					ErrorMessage5 = MakeElement(compensationErrorMessageXpath)
							.getText();
					String errormessage = ".//*[@id='validation-summary']";
					ErrorMessage2 = MakeElement(errormessage).getText();
					ErrorMessage1 = MakeElement(compensationErrorMessageXpath)
							.getText();
					try {
						String compensationErrorMessageXpath1 = "//*[@id='page-message1']";
						ErrorMessage5 = MakeElement(compensationErrorMessageXpath1)
								.getText();
					} catch (Exception e) {
					}
					// Code appended by Lokesh on 13-April-2016 for check if
					// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
					// duplicate message in ErrorMessage1 or ErrorMessage5)
					try {
						if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
							ErrorMessage5 = "";
						}
					} catch (Exception error) {
					}
					System.out.println("The Error1 is " + ErrorMessage1);
					System.out.println("The Error2 is " + ErrorMessage2);
					System.out.println("The Error5 is " + ErrorMessage5);
				} catch (Exception e) {
					System.out.println("Exception occured: " + e);
				}
				// //////////////////ERROR 1,2,5
				// END///////////////////////////////////////////

				// ///////////////////server error
				// handle//////////////////////////////////////
				try {
					String servererrorxpath = "html/body/span/h1";
					ErrorMessage1 = MakeElement(servererrorxpath).getText();
					if (ErrorMessage1.equals("Server Error in '/' Application.")) {
						TakeScreenshot();
						globalerrormessage = ErrorMessage1;
						return globalerrormessage;
					}
				} catch (Exception e) {
				}

				// ///////////////////server error handle
				// END//////////////////////////////////////
				if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls")) {
					if (CIMS_MainProject.questionarie_name1.equals("awards")
							| CIMS_MainProject.questionarie_name1
									.equals("Commercial_Success")
							| CIMS_MainProject.questionarie_name1.equals("Citizenship")
							| CIMS_MainProject.questionarie_name1
									.equals("Contacts_and_References")) {
						globalerrormessage = ErrorMessage4 + ErrorMessage2
								+ ErrorMessage5;
					} else if (CIMS_MainProject.questionarie_name1
							.equals("Residence_History")
							| CIMS_MainProject.questionarie_name1
									.equals("Travel_Plans")) {
						globalerrormessage = ErrorMessage1 + ErrorMessage2
								+ ErrorMessage5;
					}
				} else {
					globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;
					if (globalerrormessage.contains("Success")) {
						globalerrormessage = "";
					}
				}
				globalerrormessage = globalerrormessage.replaceAll("\n", " ");
				return globalerrormessage;
			
			}
			
			
			// my code end here 

	
	
	
	public void TestngDashBoardReport(String SuiteName, String PositiveCounter, String negativeCounter) {

		Reporter.log("__________________________________________________________________________________________");

		Reporter.log("<br/>");

		Reporter.log("<br/>");

		Reporter.log("<table border='1' style='background-color:white;border-color:black;width:100%;text-align:center'>");

		Reporter.log("<tr style='color: rgb(255, 255, 255); background-color: rgb(0, 99, 0);'>");

		Reporter.log("<td><b>");


			Reporter.log(SuiteName + " - Report");



		Reporter.log("</b></td>");

		Reporter.log("</tr>");

		Reporter.log("</table>");

		Reporter.log("<table cellspacing='1' cellpadding='3' border='1' style='background-color:white;width:100%;border-color:black'>");

		Reporter.log("<thead style='color: rgb(255, 255, 255); background-color: rgb(0, 99, 0);'>");

		Reporter.log("<tr>");

		Reporter.log("<td>");

		Reporter.log("Positive Counter");

		Reporter.log("</td>");

		Reporter.log("<td>");

		Reporter.log("Negative Counter");

		Reporter.log("</td>");

		Reporter.log("</tr>");

		Reporter.log("</thead>");

		Reporter.log("<tbody>");

		Reporter.log("<tr>");

		Reporter.log("<td>");

		Reporter.log(PositiveCounter);

		Reporter.log("</td>");

		Reporter.log("<td>");

		Reporter.log(negativeCounter);

		Reporter.log("</td>");

	
		Reporter.log("</tr>");

		Reporter.log("</tbody>");

		Reporter.log("</table>");

	}
	

	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}
	
}
