package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import util.UtilFunction;

public class CIMS_Organization_Info {

	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	private Robot Robot;
	
	private String filename	=	"Test Company Data.xls";
	private String sheetName	=	"Organization_Info";
	
	public CIMS_Organization_Info(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;
	 }
	
	public boolean Organization_Info(int ColumnCounter) throws AWTException, InterruptedException{
	
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String OrgnizationInfoScenerio						=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String OrgnizationInfoCompanyName					=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String OrgnizationInfoOrganizationNickname			=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String OrgnizationInfoClientReceivesLegalServices	=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String OrgnizationInfoGovernmentProcessorOfLegalServices	=	UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String OrgnizationInfoNetworkVendor							=	UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String OrgnizationInfoRelocationCompany						=	UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String OrgnizationInfoIndividual							=	UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String OrgnizationInfoIsUnitedStatesCompany					=	UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String ExpectedErrorMessage									=	UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);;
		
		String OrgnizationInfo_attributeFiledXpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
		String OrgnizationInfoCounterXpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@name]";
		
//	}
	
	//Methods Xpaths	
//	private static String CompanyNameTextBoxXpath="//*[@id='CompanyName']";
//	private static String NickNameTextBoxXpath="//*[@id='CompanyNickname']";
//	private static String ClientReceivesLegalServicesCheckBoxXpath="//span[text()='Client - Receives legal services from BAL']";
//	private static String GovernmentProcessorOfLegalServicesCheckBoxXpath="//span[text()='Government - Processor of legal services']";
//	private static String NetworkVendorCheckBoxXpath="//span[text()='Network Partner/Vendor - Provides services to BAL']";
//	private static String RelocationCompanyCheckBoxXpath="//span[text()='Relocation Company']";
//	
//	private static String SaveButtonXpath="//*[@id='btnSave']";
//	
//	private String fileName="Test Company Data.xls";
//	private String sheetName="URLANDNAME";

	//Excel sheet Data collection
				
	
	// find all fields present in the form by its id
//	private static String Add_Organization_Info_Form_Xpath	=	"//*[@id='form1']/div[@class='control-group']";
	String Add_Organization_Info_Form_Xpath	=	"//*[@id='form1']/div[@class='control-group']/div[@class='controls']";
//	List<WebElement> Add_Organization_Info_FormChildElements = utilFunction.GetObjectCount(By.xpath(Add_Organization_Info_Form_Xpath));
//	for(WebElement item : Add_Organization_Info_FormChildElements )
//	{
//	    if(item.getTagName().equals("input")) {
//	        switch(item.getAttribute("type")) {
//	        case "text": 
//	            //specify text value
//	        	System.out.println("input text");
//	            break;
//	        case "checkbox":
//	            //check or uncheck
//	        	System.out.println("checkbox");
//	            break;
//	        //and so on
//	        }
//	    }
//	    else if(item.getTagName().equals("select")) {
//	        //select an item from the select list
//	    	System.out.println("select");
//	    }  
	return true;
	}
	
}
