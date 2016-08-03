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

import javax.swing.text.StyledEditorKit.BoldAction;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.sun.org.apache.xml.internal.serialize.Printer;

import util.UtilFunction;



public class CIMS_Company_Subscribed_Services {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Company_Subscribed_Services(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_Subscribed_Services(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on Subscribed services module");
		boolean Flag	=	false;

		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CaseManagement								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String Cobalt										=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String DocumentGeneration							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String Resources									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String FrequentlyAskQuestions						=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String GlobalCheck									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String VisaForTravelerInitiation					=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String Initiation									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String InitiationServiceModule						=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String ShowNews										=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String ShowPolicies									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String ProjectDetail								=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String ProjectSummary								=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String ProjectSummaryFeatures						=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String Roster										=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String SecureMessage								=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String TopRecentPopup								=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				String TwoFactorsAuthentication						=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				
				String FAQCountrySummaries_linkCountry					=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
				String FAQDecisionTreesCountry					=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
				String FAQProcessOutlinesCountry					=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
				String FAQRecruiterResourcesCountry					=			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					Thread.sleep(1000);
					// pull data from 
					String SubscribedService_attributeFiledXpath=".//*[@id='company-subscribed-service']/tbody/tr[xx]//*[@name]";
					String SubscribedServiceCounterXpath=".//*[@id='company-subscribed-service']/tbody/tr";
					
					String Countrysummaries_link_xpath=".//*[@id='FAQ.CountrySummaries_link']";
					String DecisionTrees_link_xpath=".//*[@id='FAQ.DecisionTrees_link']";
					String ProcessOutlines_link_xpath=".//*[@id='FAQ.ProcessOutlines_link']";
					String RecruiterResources_link_xpath=".//*[@id='FAQ.RecruiterResources_link']";
					
					int ObjCount=utilfunc.GetObjectCount(SubscribedServiceCounterXpath);

					if(mode.equalsIgnoreCase("Delete")){
						System.out.println("User is deleting "+sheetName+" module");
						utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
						Flag= true;
						utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
						return Flag;				
						}
					if(mode.equalsIgnoreCase("Edit")){

//						System.out.println("Let us clear all subscribed service form data before updating the new one");
//						for(int count=1; count<=ObjCount; count++)
//						 {
//							try{
//								Thread.sleep(800);
//								String NewXpath=SubscribedService_attributeFiledXpath.replace("xx", Integer.toString(count));
//								System.out.println("data cleared for "+count+" element");
//								
//							}catch(Exception d){
//								System.out.println("Some error oddured while clearing field data");
//							}
//						 }
					}	
					// now adding the data

						 for(int count=1; count<=ObjCount; count++)
						 {
							try{

								Thread.sleep(800);
								String NewXpath					=	SubscribedService_attributeFiledXpath.replace("xx", Integer.toString(count));
								String AttributeName			=	utilfunc.MakeElement(NewXpath).getAttribute("name");

								System.out.println("Attribute: " + AttributeName.toString());

								if(AttributeName.equals("CaseManagement")){
									if(CaseManagement.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("Cims")){
									if(Cobalt.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}

								else if(AttributeName.equals("DocGen")){
									if(DocumentGeneration.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("FAQ")){
									if(Resources.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);

									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(FrequentlyAskQuestions, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'FAQ.') and contains(@name,'FAQ.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
									//for FAQ-CountrySummaries linkCountry
									try{
									countries(FAQCountrySummaries_linkCountry,Countrysummaries_link_xpath);
									}catch(Exception e){}

									
									//for FAQ-DecisionTrees country
									try{
										countries(FAQDecisionTreesCountry,DecisionTrees_link_xpath);
										}catch(Exception e){}
									
									
									//for FAQ-ProcessOutlines Country
									try{
										countries(FAQProcessOutlinesCountry,ProcessOutlines_link_xpath);
										}catch(Exception e){}
									//for FAQ-RecruiterResources Country
									
									try{
										countries(FAQRecruiterResourcesCountry,RecruiterResources_link_xpath);
										}catch(Exception e){}
										
								}
								else if(AttributeName.equalsIgnoreCase("GlobalCheck")){
									// some issue with code it is redirecting to 
									if(GlobalCheck.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(VisaForTravelerInitiation, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'GlobalCheck.') and contains(@name,'GlobalCheck.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
									// scroll to bottom so that 
									utilfunc.scrollToBottom();
								}
								else if(AttributeName.equals("Initiation")){
									if(Initiation.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(InitiationServiceModule, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'Initiation.') and contains(@name,'Initiation.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
								}
								else if(AttributeName.equals("News")){
									if(ShowNews.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("Policies")){
									if(ShowPolicies.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectDetail")){
									if(ProjectDetail.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectSummary")){
									if(ProjectSummary.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectSummary")){

									if(ProjectSummaryFeatures.equalsIgnoreCase("Status and Documents")){
										utilfunc.MakeElement("//input[@id='ProjectSummary.StatusDoc']").click();
									}
									else if(ProjectSummaryFeatures.equalsIgnoreCase("VisaBase Projects")){
										utilfunc.MakeElement("//input[@id='ProjectSummary.VisaBaseProject']").click();
									}
								}
								else if(AttributeName.equals("Roster")){
									if(Roster.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("SecureMessage")){
									if(SecureMessage.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("TopRecentPopup")){
									if(TopRecentPopup.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("TwoFactorAuth")){
									if(TwoFactorsAuthentication.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
							}catch(Exception e){
								Flag	=	false;
								
							}
						 }
//					}
//					else if(mode.equals("Edit")){
//						
//					}

					 try{
						 // save button after saving all data..
						String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	    	        	utilfunc.MakeElement(saveBtn).click();

	    	        	String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;utilfunc.TakeScreenshot();
							 webdriver.navigate().back();
						 }else{
							 Flag=false;
							 utilfunc.TakeScreenshot();
						 }
						 System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					}catch(Exception e){
						Flag	=	false;utilfunc.TakeScreenshot();
						System.out.println("Data is not saved because all fields are not set in the form.");
						System.out.println("Unable to insert data into Company's General Info form");
					}
				}
				
				
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();

		return Flag;
	}
	
	
	public void SelectDeselectall() throws InterruptedException
	{ Thread.sleep(2000);
	 int totalcheckboxcount=utilfunc.GetObjectCount(".//*[@id='Modal_SCountry']//table/tbody/tr/td//*[@name]");
	 String alreadycheckedcount=utilfunc.MakeElement(".//*[@id='lblCountryCount']").getText();
	 int int_alreadycheckedcount=Integer.parseInt(alreadycheckedcount);

	 
	String SelectDeselectAll_xpath= ".//*[@id='selectall']";
if(totalcheckboxcount==int_alreadycheckedcount)
{//all check box already selected so we have to unselect them
Thread.sleep(2000);
utilfunc.MakeElement(SelectDeselectAll_xpath).click();
}
if(int_alreadycheckedcount<totalcheckboxcount)
{
Thread.sleep(2000);
utilfunc.MakeElement(SelectDeselectAll_xpath).click();
Thread.sleep(2000);
utilfunc.MakeElement(SelectDeselectAll_xpath).click();
Thread.sleep(2000);
}
}

	
	public void countries(String Countrylist, String CountryPopUPlink_xpath)
	{
		String user_countrystring=Countrylist;
		String saveBtnPopUp_xpath=".//*[@id='btnSaveCountry']";
		String popupCloseBtn=".//*[@class='close' and @type='button']";
		try{
			
			String countrytd_xpath=".//*[@id='Modal_SCountry']//table/tbody/tr[2]/td[1]";
			String popuprowcounter=".//*[@id='Modal_SCountry']//table/tbody/tr";
			String popupcolcounter=".//*[@id='Modal_SCountry']//table/tbody/tr[2]/td";
			String country_checbox_xpath=".//*[@id='Modal_SCountry']//table/tbody/tr[xxyy]/td[xxzz]";
			
//			String country_checbox_xpath=".//*[@id='Modal_SCountry']//table/tbody/tr[xxyy]/td[xxzz]//*[@type='checkbox']";
			
			utilfunc.MakeElement(CountryPopUPlink_xpath).click();
			Thread.sleep(1000);
			SelectDeselectall();
			int rowcount=utilfunc.GetObjectCount(popuprowcounter);
			int colcount=utilfunc.GetObjectCount(popupcolcounter);
			String[] countryarray=null;
			if((!user_countrystring.equals(null))||(!user_countrystring.equals("null"))||(!user_countrystring.isEmpty()))
			{
				try{
					countryarray=user_countrystring.split(",");
				}catch(Exception e){}
				
				int countryarraylength=countryarray.length;
				
				int countryaddedcounter=0;
				boolean loopflag=false;
				try{
					
				for(int rowloop=1;rowloop<=rowcount;rowloop++)
				{
					if(!loopflag)
					{
						String Row_xpath=country_checbox_xpath.replace("xxyy", Integer.toString(rowloop)); 
					try{
					for(int colloop=1;colloop<=colcount;colloop++)
					{
						if(!loopflag)
						{
						String element_xpath=Row_xpath.replace("xxzz",Integer.toString(colloop));
						String attribute=null;
						try{attribute=utilfunc.MakeElement(element_xpath).getText();}catch(Exception e){}
						
						
						//loop for get and match values from provided country list by testcase
						try{
						for(int arr=0;arr<=countryarraylength;arr++)
						{
							String arratycoun="";
							try{arratycoun=countryarray[arr];
								}catch(Exception error){System.out.println(error);}
							
							if(countryarray[arr].equalsIgnoreCase(attribute))
							{
								try{
									Thread.sleep(800);
									utilfunc.MakeElement(element_xpath+"//*[@type='checkbox']").click();
									countryaddedcounter++;
								}catch(Exception e){}
							}
							if(countryaddedcounter==countryarraylength)
							{
								loopflag=true;
								break;
							}
							
						}
						}catch(Exception e){System.out.println(e);}
						
					}
					}
					}catch(Exception e){System.out.println(e);}
				}
				}
				}catch(Exception e){System.out.println(e);}
			
			}
			
			try{
				Thread.sleep(1000);
				utilfunc.MakeElement(saveBtnPopUp_xpath).click();
				Thread.sleep(1000);
			}catch(Exception p){}
			
		}catch(Exception e){}
		
		
		try{
			utilfunc.MakeElement(popupCloseBtn).click();
			Thread.sleep(1000);			
		}
		catch(Exception e){}
	}
	
	
	
}
