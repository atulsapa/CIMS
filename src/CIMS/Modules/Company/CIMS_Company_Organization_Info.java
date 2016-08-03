package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
//import com.sun.xml.internal.ws.server.sei.EndpointArgumentsBuilder;

import util.UtilFunction;



public class CIMS_Company_Organization_Info {

	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
//	private Robot Robot;
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public CIMS_Company_Organization_Info(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;
	 }
	
	public boolean Add_Organization_Info(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
		{
		
		System.out.print("We are going to work with Organization Info Module");

		boolean Flag=false;
	
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);		
		String OrgnizationInfoScenerio						=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestcaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String OrgnizationInfoCompanyName					=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String OrgnizationInfoOrganizationNickname			=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String OrgnizationInfoClientReceivesLegalServices	=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String OrgnizationInfoGovernmentProcessorOfLegalServices	=	UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String OrgnizationInfoNetworkVendor							=	UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String OrgnizationInfoRelocationCompany						=	UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String OrgnizationInfoIndividual							=	UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String OrgnizationInfoIsUnitedStatesCompany					=	UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String ExpectedErrorMessage									=	UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);

		testcaseid=TestcaseID;
		scenerio=OrgnizationInfoScenerio;
		description=TestcaseDescription;

		//System.out.println("\n=======\nhello-"+CIMS.Modules.Company.CIMS_Company_Functions.companyName+"\n=======");
		if(TestcaseRunMode.equals("Y")){
			Thread.sleep(1000);

			if(mode.equals("Delete")){
				String FileName=CIMS.Modules.Company.CIMS_Company_Functions.companyName;
				
				Flag=deleteCompanyByName(FileName,mode);
			}
			
			if(mode.equals("New")){
				
				String AddNewXPath		=	"//a[contains(@class,'btn') and text()='Add New']";
				try{
					Thread.sleep(1000);
					utilfunc.MakeElement(AddNewXPath).click();
					Thread.sleep(1000);
				}catch(Exception e){
					System.out.println("Unable to click on add new button");
				}
			}
			
			System.out.println("Lets proceed with add new company details");
			String OrgnizationInfo_attributeFiledXpath="//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
			String OrgnizationInfoCounterXpath="//*[@class='form-horizontal']/*[@class='control-group']/*[@class='controls']"; //.//*[@class='form-horizontal']/*[@class='control-group']

			int ObjCount				=			utilfunc.GetObjectCount(OrgnizationInfoCounterXpath);

			 for(int count=1; count<=ObjCount; count++)
			 {
				 Thread.sleep(1000);
				try{
					String NewXpath			=		OrgnizationInfo_attributeFiledXpath.replace("xx", Integer.toString(count));
					String AttributeName	=		utilfunc.MakeElement(NewXpath).getAttribute("name");
					 System.out.println(AttributeName);
		//			 String AttributeTitle=utilfunc.MakeElement(NewXpath).getAttribute("title");
		//			 String AttributeLabel=utilfunc.MakeElement(NewXpath).getAttribute("label");
		//			 System.out.println("Attribute name "+count+"is : "+AttributeName);
	
					 if(AttributeName.equalsIgnoreCase("CompanyName")){
						 
						 utilfunc.MakeElement(NewXpath).clear();
						 utilfunc.MakeElement(NewXpath).sendKeys(OrgnizationInfoCompanyName);
						 
				     }else if(AttributeName.equalsIgnoreCase("CompanyNickname")){
				    	 utilfunc.MakeElement(NewXpath).clear();
				    	 utilfunc.MakeElement(NewXpath).sendKeys(OrgnizationInfoOrganizationNickname);
					 
				     }else if(AttributeName.equals("RoleType")){
				    	 Thread.sleep(2000);
				    	 	// get list of checkboxes label present in this control group..
							String CheckboxXpath	=	"//input[@name='RoleType' and @type='checkbox'][cc]";
							String CheckboxCounterXpath	=	"//input[@name='RoleType' and @type='checkbox']";
							int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
							for(int c=1; c<=chkbxCount; c++){
								Thread.sleep(2000);		
								//check the checkbox if its value is yes for this test case..
								String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
								String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//								utilfunc.MakeElement(NewChkBoxXpath).clear();
								System.out.print("ChkBxValue - " + ChkBxValue);

								if(ChkBxValue.equalsIgnoreCase("CLIENT")){
									try{
									if(OrgnizationInfoClientReceivesLegalServices.equalsIgnoreCase("Yes")){
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
									}}catch(Exception error){}
//									utilfunc.MakeElement(NewChkBoxXpath).click();
								}
								if(ChkBxValue.equalsIgnoreCase("GOVERNMENT")){
									try{
									if(OrgnizationInfoGovernmentProcessorOfLegalServices.equalsIgnoreCase("Yes")){
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
									}}catch(Exception error){}
								}
								if(ChkBxValue.equalsIgnoreCase("NETWORK_PARTNER")){
									try{
									if(OrgnizationInfoNetworkVendor.equalsIgnoreCase("Yes")){
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
									}}catch(Exception error){}
								}
								if(ChkBxValue.equalsIgnoreCase("RELOCATION_COMPANY")){
									try{
									if(OrgnizationInfoRelocationCompany.equalsIgnoreCase("Yes")){
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
									}}catch(Exception Error){}
								}
								
							}
				     }
				     else if(AttributeName.equalsIgnoreCase("IsIndividual")){
				    	 try{
				    	 if(OrgnizationInfoIndividual.equalsIgnoreCase("Yes")){
				    		 utilfunc.MakeElement(NewXpath).click();
				    	 }}catch(Exception Error){}
				     }
				     else if(AttributeName.equalsIgnoreCase("IsUSCompany")){
				    	 try{
				    	 if(OrgnizationInfoIsUnitedStatesCompany.equalsIgnoreCase("Yes")){
				    		 utilfunc.MakeElement(NewXpath).click();
				    	 }}catch(Exception Error){}
				     }
				 }catch(Exception e){
					 
			     }
				
			 }
			 Thread.sleep(1000);
			 
//	System.out.print("All values are set and we are breaking here to confirm whether all data is added and then proceed with save..");

				/**
				 * all information is added to form, now let us submit the form and incase any expected error occured then use the message from the error expected message column of the sheet..
				 * 
				 */
				try{

					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
    	        	utilfunc.MakeElement(saveBtn).click();

					System.out.println("Test case id: "+ TestcaseID + " with  "+OrgnizationInfoScenerio + " scenario succeed ");

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//					ExpectedErrorMessage=ExpectedErrorMessage.trim();
//					System.out.println("---"+ExpectedErrorMessage+"---");
					System.out.println("---"+error_flag+"---");
					System.out.println("---"+ExpectedErrorMessage+"---");
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
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
			}else{
				System.out.println("skipped for test case: "+ TestcaseID);
			}
		return Flag;
	}

	public boolean deleteCompanyByName(String companyName, String ActionName)throws AWTException, InterruptedException
	{
		
		
		String searchFieldXPath="//*[@id='CompanyName']";
		String searchButtonXPath="//a[@id='btnSearch' and text()='Search']";
		String searchResultListLiXpath="//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a";
		String EditorRequest_xpath="//*[@id='dvList']/table/tbody/tr[dd]/td[3]/*[contains(@class,'dropdown') ]/*[contains(@class,'dropdown-toggle')]";
		String dropdown_xpath="//*[@id='dvList']/table/tbody/tr[dd]/td[3]//*[contains(@class,'dropdown-menu')]/li";
		
		// first of all let us make sure that user on company page..
		boolean flag	=	false;
//		System.out.println("\n\n");
//		System.out.println("User is looking for: "+companyName);
//		System.out.println("User is looking for: "+ActionName+" mode.");
		String CompanyResultCounterXpath	=	searchResultListLiXpath.replace("[dd]", ""); //"//*[@id='dvList']/table/tbody/tr/td[1]/a";

			try{

				System.out.println("Let us wait for listing to load for the first time");
				Thread.sleep(1500);
				try{utilfunc.MakeElement(searchFieldXPath).clear();
				utilfunc.MakeElement(searchFieldXPath).sendKeys(companyName);
				}catch(Exception error){}
				System.out.println("Company name is set in search box");
				Thread.sleep(1600);
				utilfunc.waitForAnElementToLoad(searchButtonXPath, true);
				try{utilfunc.MakeElement(searchButtonXPath).click();}catch(Exception error){}
				}catch(Exception s){
				System.out.println("Unable to set search for company "+companyName);
			}
		
				System.out.println("wating for company search result to populate");
			
				try{

					Thread.sleep(3000);
					CompanyResultCounterXpath	=	null;
					CompanyResultCounterXpath	=	searchResultListLiXpath.replace("[dd]", "");
					utilfunc.waitForAnElementToLoad(CompanyResultCounterXpath, false);
					//Search Result row Counter
					int resultCount			=	utilfunc.GetObjectCount(CompanyResultCounterXpath);
		
					for(int r=1;r<=resultCount;r++){
						Thread.sleep(1000);
						String NewXpath			=	searchResultListLiXpath.replace("dd", Integer.toString(r));
					//	System.out.println("New string" + NewXpath.toString());
						utilfunc.waitForAnElementToLoad(NewXpath, true);
						String AttributeName="";
						try{
						AttributeName	=	utilfunc.MakeElement(NewXpath).getText();
						}catch(Exception error){}
						System.out.println("\nNow Attribute Name is:"+AttributeName);
						//AttributeName equals to companyName that means company found
						if(AttributeName.equals(companyName)){
							try{
						
								System.out.println("We have found the company in the result");
								
								//************************************//
								EditorRequest_xpath=EditorRequest_xpath.replace("dd", Integer.toString(r));
								dropdown_xpath=dropdown_xpath.replace("dd", Integer.toString(r));
								//if mode is Delete so
								if(ActionName.equalsIgnoreCase("Delete"))
								{
									try{
										utilfunc.MakeElement(EditorRequest_xpath).click();
										Thread.sleep(1000);
										int li_count=utilfunc.GetObjectCount(dropdown_xpath);
										for(int li_c=1;li_c<=li_count;li_c++)
										{
											String currentdropdown_xpath=dropdown_xpath+"["+li_c+"]";
											String li_gettext=utilfunc.MakeElement(currentdropdown_xpath).getText();
											if(li_gettext.equalsIgnoreCase("Delete"))
											{
												try{
													System.out.println("We are going to Click Delete... ... ...");
													try{
														utilfunc.MakeElement(currentdropdown_xpath).click();
													System.out.println("We clicked Delete... ... ...");
													}catch(Exception error){}
													Alert alt= webdriver.switchTo().alert();
					/*
					 * 
					 * Uncomment below line for accept alert box for delete the company
					 *
					 **/
													//alt.accept();
													flag	=	true;
													break;
												}catch(Exception error){}
											}
											
										}
										
										}catch(Exception e){}
								}
								//************************************//
								try{utilfunc.MakeElement(NewXpath).click();}catch(Exception e){}
								System.out.println("User has clicked on the selected company");
							}catch(Exception d){
								System.out.println("some error occured while finding the company from the search result");
							}
							flag	=	true;
							return flag;
						}
						//else company not found 
						else
						{
							System.out.println("Search Company not found!!!");
							utilfunc.ErrorMessage1="Company not Found!!!";
							flag= false;
							utilfunc.globalerrormessage="Company not Found!!!";
							return flag;
						}
					}
				}
				catch(Exception s){
					System.out.println("Some error occured while selecting/finding company record from the result");
				}
//		}else{
//			System.out.println("unable to open company menu");
//		}
		return flag;
	}



	
	
	
}//public class CIMS_Company_Organization_Info  ends here
	