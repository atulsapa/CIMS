package CIMS.Modules.Company;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Company_RequestAccesstoCompany {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
//	private Robot Robot;
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public CIMS_Company_RequestAccesstoCompany(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;
	 }

	
	public boolean Requestaccesstocompany(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		boolean Flag=false;
	//System.out.print("WOW we are here...");
	
	
	String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
	String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);		
	String OrgnizationInfoScenerio						=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
	String TestcaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
	String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
	
	

	testcaseid=TestcaseID;
	scenerio=OrgnizationInfoScenerio;
	description=TestcaseDescription;

	//System.out.println("\n=======\nhello-"+CIMS.Modules.Company.CIMS_Company_Functions.companyName+"\n=======");
	if(TestcaseRunMode.equals("Y")){
		Thread.sleep(1000);
		System.out.println(TestcaseDescription);
		String FileName=CIMS.Modules.Company.CIMS_Company_Functions.companyName;
		
		Flag=requestaccesstocompany_function(FileName);
		
	}

	
	
	return Flag;
	}

	public boolean requestaccesstocompany_function(String companyName)throws AWTException, InterruptedException
	{
		
		
		String searchFieldXPath="//*[@id='CompanyName']";
		String searchButtonXPath="//a[@id='btnSearch' and text()='Search']";
		String searchResultListLiXpath="//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a";
		String EditorRequest_xpath="//*[@id='dvList']/table/tbody/tr[dd]/td[3]/*[contains(@class,'dropdown') ]/*[contains(@class,'dropdown-toggle')]";
		String dropdown_xpath="//*[@id='dvList']/table/tbody/tr[dd]/td[3]//*[contains(@class,'dropdown-menu')]/li";
		
		// first of all let us make sure that user on company page..
		boolean flag	=	false;
		System.out.println("\n\n");
		System.out.println("User is looking for: "+companyName);
		
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
				utilfunc.MakeElement(searchButtonXPath).click();
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
						System.out.println("New string" + NewXpath.toString());
						utilfunc.waitForAnElementToLoad(NewXpath, true);
	
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getText();
						System.out.println("\nNow Attribute Name is:"+AttributeName);
						//AttributeName equals to companyName that means company found
						if(AttributeName.equals(companyName)){
							try{
						
								System.out.println("We have found the company in the result");
								
								//************************************//
								EditorRequest_xpath=EditorRequest_xpath.replace("dd", Integer.toString(r));
								dropdown_xpath=dropdown_xpath.replace("dd", Integer.toString(r));
								//if mode is Delete so
								
									try{
										try{utilfunc.MakeElement(EditorRequest_xpath).click();}catch(Exception error){}
										Thread.sleep(1000);
										int li_count=utilfunc.GetObjectCount(dropdown_xpath);
										for(int li_c=1;li_c<=li_count;li_c++)
										{
											String currentdropdown_xpath=dropdown_xpath+"["+li_c+"]";
											String li_gettext=utilfunc.MakeElement(currentdropdown_xpath).getText();
											if(li_gettext.equalsIgnoreCase("Request Access to Company"))
											{
												try{
													System.out.println("We are going to Click Request Access to Company... ... ...");
													try{
														utilfunc.MakeElement(currentdropdown_xpath).click();
													System.out.println("We clicked Request Access to Company... ... ...");
													}catch(Exception error){}
													
													Alert alt= webdriver.switchTo().alert();
													
			/*
			 * 
			 * Uncomment below line for accept alert box for Request Access to Company
			 *
			 */
												//	alt.accept();
													flag	=	true;
													break;
												}catch(Exception error){}
											}
											
										}
										
										}catch(Exception e){}
								
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


}
