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
import org.openqa.selenium.Keys;
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

public class CIMS_Company_ReferenceList {
	private static WebDriver webdriver;	// Will be Provide by Calling Class.	
	private static UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_ReferenceList(WebDriver driver,UtilFunction utilfunc) 
	{
	    this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_ReferenceList(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		
		boolean Flag	=	false;

		

		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String RefGroup								        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String Refcode								        =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String Description								    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String EditCode								    	=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String EditDescription								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);

				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				
				//String RefGroupXpath =".//*[@id='RefGroup']";
				

				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n==="+sheetName+"\n===");
					testcaseid=TestcaseID;
					scenerio=Scenario;
					description=TestCaseDescription;


					if(mode.equalsIgnoreCase("New")){
						
						String RefGroupXpath=".//*[@id='RefGroup']";
							try{
								utilfunc.Selectdropdownvaluebytext(RefGroupXpath, RefGroup);
								Thread.sleep(1000);
								System.out.println("User has been selectd from Reference Group*: ");
							}catch(Exception e){
								System.out.println("unable to slect group reference");
							}
							try{
								String AddNewReferencebutton	=	".//a[contains(@class,'btn') and text()='Add New Reference']";
								utilfunc.MakeElement(AddNewReferencebutton).click();
							}catch(Exception e){
								System.out.println("unable to click on add new button");
							}
						
						         try{        		
							        String RefCodeXpath ="//*[@class='controls']//*[@name='RefCode']";
							        utilfunc.MakeElement(RefCodeXpath).clear();
							        utilfunc.MakeElement(RefCodeXpath).sendKeys(Refcode);
							        
							        String DescriptionXpath ="//*[@class='controls']//*[@name='Description']";
							        utilfunc.MakeElement(DescriptionXpath).clear();
							        utilfunc.MakeElement(DescriptionXpath).sendKeys(Description);
	    	        				
						}
						catch(Exception e){
							Flag	=	false;
							System.out.println("Unable to insert data into "+sheetName+" form");
						
						}
						
					}
					if(mode.equalsIgnoreCase("Edit")){
						
						
						// Select the value from the drop down
						String editRefGroupXpath=".//*[@id='RefGroup']";
						
						try{
							utilfunc.Selectdropdownvaluebytext(editRefGroupXpath, RefGroup);
							Thread.sleep(1000);
							System.out.println("User has been selectd from Reference Group*: ");
						}catch(Exception e){
							System.out.println("unable to slect group reference");
						}
						
						
						
						
						String NoDataFoundXpath=".//*[@class='table-rec-container']//*[@id='divList']//tbody//tr[1]//td[1]";
		            	  String RecordNotFound= utilfunc.MakeElement(NoDataFoundXpath).getText();
		            	  if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
		            		  
		            		Flag=false;
		  					return Flag;
		            	   }else{
		            		   
		            		String EditRefListXpath ="//*[@class='panel-body-main']//*[@id='divList']//tbody//tr[1]//td//*[@class='icon-edit']";
							//Clicked on the edit icon
							Thread.sleep(3000);
							utilfunc.MakeElement(EditRefListXpath).click();
						
						//Moved on the Edit Reference list page
						
						 try{        		
						        String RefCodeXpath ="//*[@class='controls']//*[@name='RefCode']";
						        utilfunc.MakeElement(RefCodeXpath).clear();
						        utilfunc.MakeElement(RefCodeXpath).sendKeys(EditCode);
						        
						        String DescriptionXpath ="//*[@class='controls']//*[@name='Description']";
						        utilfunc.MakeElement(DescriptionXpath).clear();
						        utilfunc.MakeElement(DescriptionXpath).sendKeys(EditDescription);
 	        				
					}
					catch(Exception e){
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
					
					}
						
						
					}}

					try{

						String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	    	        	utilfunc.MakeElement(saveBtn).click();
					}catch(Exception e){}
					try{

						
						Thread.sleep(5000);
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//						System.out.println("---X---"+error_flag+"---X---");
//						System.out.println("---X---"+ExpectedErrorMessage+"---X---");
						
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.ErrorMessage1=ExpectedErrorMessage;
							 utilfunc.globalerrormessage=ExpectedErrorMessage;									 
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
					}catch (Exception e){
						System.out.println("Error occured due to following reason: "+e.getMessage());
						System.out.println(ExpectedErrorMessage);
					}
					
					if(mode.equalsIgnoreCase("Delete")){
						// Select the value from the drop down
						String editRefGroupXpath=".//*[@id='RefGroup']";
						
						try{
							utilfunc.Selectdropdownvaluebyvalue(editRefGroupXpath, RefGroup.toUpperCase());
							Thread.sleep(1000);
							System.out.println("User has been selectd from Reference Group*: ");
						}catch(Exception e){
							System.out.println("unable to slect group reference");
						}
						
						
						String NoDataFoundXpath=".//*[@class='table-rec-container']//*[@id='divList']//tbody//tr[1]//td[1]";
		            	  String RecordNotFound= utilfunc.MakeElement(NoDataFoundXpath).getText();
		            	  if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
		            		  
		            		Flag=false;
		  					return Flag;
		            	   }
						
					else{
						System.out.println("Record founded. we are going to delete it.");
						try{
							Thread.sleep(1000);
							String DeleteBtnXpath=".//*[@class='panel-body-main']//*[@id='divList']//tbody//tr[1]//td//*[@class='icon-trash']";
							utilfunc.MakeElement(DeleteBtnXpath).click();
							Thread.sleep(300);
							Alert alt= webdriver.switchTo().alert();
							alt.accept();
							System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
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
							}else if(error_flag.equals("Server Error in '/' Application.")){
								Flag=false;
								webdriver.navigate().back();
							}else{
								Flag=false;
								utilfunc.TakeScreenshot();
							}
						}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}
					
						
					}}
					
					
					
				}		
				return Flag;
	}
}


				
	


	
				




