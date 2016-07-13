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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;



public class CIMS_Company_Notes {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_Notes(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Notes(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on Add Notes module");
		boolean Flag	=	false;
		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String Category										=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String Notes										=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String EditNotes									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){

					if(mode.equalsIgnoreCase("Delete")){
						
						// search for note before editing the same..
						String ListCounterXPath		=	"//*[@id='divList']//*[@class='table-rec-container']";
						String CategoryXpath	=	"//span[@class='ICategory']";
						String DescriptionXpath	=	"//tbody//tr//td//p";
						String deleteIconXpath	=	"//*[@id='divList']//*[@class='table-rec-container'][kk]/table/thead/tr/td[3]/i";

						int count	=				utilfunc.GetObjectCount(ListCounterXPath);
						if(count>1){ // execute edit only if number of elements are found..
							for(int l=1;l<=count;l++){Thread.sleep(1000);
								String NewXpath	=	ListCounterXPath + "["+Integer.toString(l)+"]" + CategoryXpath;
								String Attribute	=	utilfunc.MakeElement(NewXpath).getText();

								System.out.println("New path:  "+NewXpath);
								System.out.println("atrr: "+Attribute);
								if(Attribute.equalsIgnoreCase(Category)){
									Thread.sleep(1000);
									System.out.print("category is found");
									//if matched than match the description
									String descriptionElement	=	ListCounterXPath + "["+Integer.toString(l)+"]" + DescriptionXpath;
									String DescriptionContent	=	utilfunc.MakeElement(descriptionElement).getText();
									if(Notes.equalsIgnoreCase(DescriptionContent.trim())){
										Thread.sleep(1000);
										System.out.println("Data found, now update the data");
										// click on edit
										String newDeleteIcon	=	deleteIconXpath.replace("kk", Integer.toString(l));
										System.out.println("We are now deleting the record found");
										utilfunc.MakeElement(newDeleteIcon).click();
										utilfunc.isAlertPresent();
										// now update the form
										break;
									}
								}

							}
						}
						
					}else{	

					if(mode.equals("Edit")){
						
						Thread.sleep(2000);
						// search for note before editing the same..
						String ListCounterXPath		=	"//*[@id='divList']//*[@class='table-rec-container']";
						String CategoryXpath	=	"//span[@class='ICategory']";
						String DescriptionXpath	=	"//tbody//tr//td//p";
						String editIconXpath	=	"//*[@id='divList']//*[@class='table-rec-container'][kk]/table/thead/tr/td[2]/a/i";

						int count	=				utilfunc.GetObjectCount(ListCounterXPath);
						if(count>1){ // execute edit only if number of elements are found..
							for(int l=1;l<=count;l++){
								String NewXpath	=	ListCounterXPath + "["+Integer.toString(l)+"]" + CategoryXpath;
								String Attribute	=	utilfunc.MakeElement(NewXpath).getText();

								System.out.println("New path:  "+NewXpath);
								System.out.println("atrr: "+Attribute);
								if(Attribute.equalsIgnoreCase(Category)){
									System.out.print("category is found");
									//if matched than match the description
									String descriptionElement	=	ListCounterXPath + "["+Integer.toString(l)+"]" + DescriptionXpath;
									String DescriptionContent	=	utilfunc.MakeElement(descriptionElement).getText();
									if(Notes.equalsIgnoreCase(DescriptionContent.trim())){
										System.out.println("Data found, now update the data");
										// click on edit
										String newEditIcon	=	editIconXpath.replace("kk", Integer.toString(l));
										System.out.println("We are now editing record");
										utilfunc.MakeElement(newEditIcon).click();
										Notes	=	EditNotes;
										// now update the form
										break;
									}
								}

							}
						}
						
					}else{
						// click on add new notes button
						String AddNewNotesbutton	=	".//a[contains(@class,'btn') and text()='Add New Note' and contains(@href,'/company/notes/add?company=')]";
						utilfunc.MakeElement(AddNewNotesbutton).click();
						System.out.println("User has clicked on Add new notes");
						
						Thread.sleep(3000);
					}
					
//					webdriver.get("http://cobaltqa.daxima.com/company/notes/add?company=271");
					// pull data from 
					String CategoryXpath	=	"//select[@id='Category']";
					String NotesFrameXpath	=	"//*[@id='tinymce-8']//*[@id='tinymce-14']//*[@id='Note_ifr']";	
					String NoteXpath		=	 "body";//"//*[@id='tinymce']/p";


					// now adding the data

							try{								
								utilfunc.Selectdropdownvaluebytext(CategoryXpath, Category);
								try{
									WebDriverWait wait = new WebDriverWait(webdriver, 15);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NotesFrameXpath)));
									webdriver.switchTo().frame(utilfunc.MakeElement(NotesFrameXpath));
									System.out.println("Switched to frame");

//									utilfunc.MakeElement(NoteXpath).clear();
//									utilfunc.MakeElement(NoteXpath).sendKeys(Notes);
									
									WebElement element = webdriver.findElement(By.cssSelector("body"));
									element.clear(); // clear the content of tiny mce editor
									element.sendKeys(Notes);
									System.out.println("Notes is set in tiny mce editor");
									
								}catch(Exception e){
									System.out.println("Unalbe to switch iframe");
								}
								try{
									webdriver.switchTo().defaultContent();
								}catch(Exception s){
									System.out.println("Unable to back to main window");
								}

								
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to insert data into Company's Add Note form");
							}
						 }
					 
					 try{
						 // save button after saving all data..
						String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	    	        	try{utilfunc.MakeElement(saveBtn).click();}catch(Exception error){}
						Thread.sleep(5000);
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						System.out.println("error_flag---"+error_flag);
						String ErrorMsg=utilfunc.globalerrormessage;
						
						Thread.sleep(1000);
						
						if(mode.equals("Delete")){
							String GotUnexceptedErrorMessage=utilfunc.MakeElement(".//*[contains(@class,'alert-error')]").getText();
							if(GotUnexceptedErrorMessage!=""||(utilfunc.ErrorMessage5!="")){utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+GotUnexceptedErrorMessage;error_flag=utilfunc.ErrorMessagehandlerExperiment();}
							}
						
						
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.ErrorMessage1=ErrorMsg;
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
						System.out.println("Data is not saved because all fields are not set in the form.");
					}
				}
				
		return Flag;
	}
}
