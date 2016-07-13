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



public class CIMS_Company_Communication {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public static String Deletecheck="";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";



	public CIMS_Company_Communication(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Communication(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on communication module");
		boolean Flag	=	false;

		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String CanBALDirectContactEmployee					=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		
		String CanBALProvideEmployeeReceiptNumber			=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String CanBALContactHiringManager					=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String ProvideStatusChekAccesstoManagers			=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String WhoInitiatesProjects							=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String DoesClientUseCIMSHR							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String GenerateReportsRegularly						=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);

		String NumberOfReports								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String ReportName									=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String ReportFrequency								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String PreparedBy									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String BalOrHrPreparer								=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);

		String DoesConferenceCallRegularly					=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String NumberOFConferenceCallRegularly				=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String ConferenceName								=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String Participants									=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		String CallFrequency								=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String Description									=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		
		String DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance			=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
		String CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceText			=			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);

		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);

		testcaseid=TestcaseID;
		scenerio=Scenario;
		description=TestCaseDescription;


		if(TestcaseRunMode.equals("Y")){
			String reportpasswithfail="";
			String conference_GlobalErrorMessage="";

			System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
			if(mode.equals("Delete")){
				System.out.println("User is deleting "+sheetName+" module");
				utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
				Flag= true;
				utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
				return Flag;			
			}else{

				//							utilfunc.NavigatetoURL(URLwithID);

				//							utilfunc.ServerErrorHandler();

				System.out.println("entering "+mode+" mode for communication protocol module");

				try{
					String FormFieldsCounterXPath										=	"//*[@id='form1']//*[@class='control-group']//*[@class='controls']";
					String FormFieldXpath												=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
					String WhoInitiatesProjectsXPath									=	"//*[@name='WhoInitiatesProjects']";
					String CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceTextXPath	=	"//*[@name='CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceText']";
					String XPathPrefix													=	"//*[@name='";
					String XPathSufixTrue												=	"' and @value='True']";
					String XPathSufixFalse												=	"' and @value='False']";
					String XPathSufix													=	"']";

					String	NewRadioXPath												=	"";
					boolean AddClientCommunicationProtocolReports_FLAG=false;

					/**
					 * in case reports & call frequency data is present then let us fill it before filling the rest of the form as its data gets clear
					 */
					try{
						if(GenerateReportsRegularly.equalsIgnoreCase("Yes")){
							NewRadioXPath	=	XPathPrefix+"GenerateReportsRegularly"+XPathSufixTrue;
							try{utilfunc.MakeElement(NewRadioXPath).click();}catch(Exception error){System.out.println("Error while click on GenerateReportsRegularly");}
							// now add new entries for report..
							System.out.println("Now add new report entries..");
							System.out.println("Let us find out how many reports we need to add");

							String[]	ReportNames=null;
							String[]	ReportFrequencys=null;
							String[]	PreparedBys=null;
							String[]	BalOrHrPreparers=null;

							System.out.println("ReportName :"+ReportName);
							System.out.println("ReportFrequency :"+ReportFrequency);
							System.out.println("PreparedBy :"+PreparedBy);
							System.out.println("BalOrHrPreparer :"+BalOrHrPreparer);


							try{ReportNames				=	ReportName.split(",");}catch(Exception Error){System.out.println(Error);}
							try{ReportFrequencys		=	ReportFrequency.split(",");}catch(Exception Error){System.out.println(Error);}
							try{PreparedBys				=	PreparedBy.split(",");}catch(Exception Error){System.out.println(Error);}
							try{BalOrHrPreparers		=	BalOrHrPreparer.split(",");}catch(Exception Error){System.out.println(Error);}



							for(int a1=0;a1<  Integer.parseInt(NumberOfReports.replaceAll("\\.0*$", ""));a1++){
								Thread.sleep(2000);

								try{


									try{utilfunc.MakeElement("//*[@id='dvReport']/a").click();}catch(Exception error){System.out.println("Error while click on //*[@id='dvReport']/a");}
									Thread.sleep(2000);
									System.out.println("User is now on new page where he can add new report for "+a1+ " times");
									System.out.println("We will wait here to load all elements");

									try{System.out.println("a is:"+a1);}catch(Exception error){}
									try{System.out.println("ReportNames["+a1+"].trim() :"+ReportNames[a1]);}catch(Exception error){System.out.println("ReportNames["+a1+"].trim() have :"+error);}
									try{System.out.println("ReportFrequencys["+a1+"].trim() :"+ReportFrequencys[a1]);}catch(Exception error){System.out.println("ReportFrequencys["+a1+"].trim() have :"+error);}
									try{System.out.println("PreparedBys["+a1+"].trim() :"+PreparedBys[a1]);}catch(Exception error){System.out.println("PreparedBys["+a1+"].trim() have :"+error);}
									try{System.out.println("BalOrHrPreparers["+a1+"].trim() :"+BalOrHrPreparers[a1]);}catch(Exception error){System.out.println("BalOrHrPreparers["+a1+"].trim() have :"+error);}


									Thread.sleep(3000);
									try{utilfunc.MakeElement(XPathPrefix+"ReportName"+XPathSufix).sendKeys(ReportNames[a1]);
									}catch(Exception error){System.out.println("fail to set ReportName");}
									Thread.sleep(3000);
									try{utilfunc.MakeElement(XPathPrefix+"Frequency"+XPathSufix).sendKeys(ReportFrequencys[a1]);
									}catch(Exception error){System.out.println("fail to set Frequency");}
									Thread.sleep(3000);
									try{utilfunc.MakeElement(XPathPrefix+"PreparedBy"+XPathSufix).sendKeys(PreparedBys[a1]);
									}catch(Exception error){System.out.println("fail to set PreparedBy");}
									Thread.sleep(3000);
									try{utilfunc.MakeElement(XPathPrefix+"BalOrHrPreparer"+XPathSufix).sendKeys(BalOrHrPreparers[a1]);
									}catch(Exception error){System.out.println("fail to set BalOrHrPreparer");}

									try{
										utilfunc.MakeElement("//*[@id='btnSave']").click();
										Thread.sleep(2000);
									}catch(Exception s){
										System.out.println("unable to click on save button for regular reports");
									}
									String innereerror_flag="";
									try{
										innereerror_flag=utilfunc.ErrorMessagehandlerExperiment();
									}catch(Exception error){}
									System.out.println("error_flag\n"+innereerror_flag);
									if (innereerror_flag.equals(ExpectedErrorMessage)){
										AddClientCommunicationProtocolReports_FLAG=true;
										reportpasswithfail="globalerrormsg";
										utilfunc.TakeScreenshot();Thread.sleep(1000);
										webdriver.navigate().back();
									}else if (innereerror_flag.equals("")){
										AddClientCommunicationProtocolReports_FLAG=true;
									}else if (innereerror_flag.contains("Success!")){
										AddClientCommunicationProtocolReports_FLAG=true;
									}else if(innereerror_flag.equals("Server Error in '/' Application.")){
										AddClientCommunicationProtocolReports_FLAG=false;
										webdriver.navigate().back();
									}else{
										AddClientCommunicationProtocolReports_FLAG=false;
									}

									if(AddClientCommunicationProtocolReports_FLAG!=true)
									{
										Flag=false;
										utilfunc.TakeScreenshot();
										return Flag;
									}
//									else{
//										webdriver.navigate().back();
//										System.out.println("We have added a new report");
//									}







								}catch(Exception s){
									System.out.println("Some error occured while add reports");
								}
							}

						}else if(GenerateReportsRegularly.equalsIgnoreCase("No")){
							NewRadioXPath	=	XPathPrefix+"GenerateReportsRegularly"+XPathSufixFalse;
							try{utilfunc.MakeElement(NewRadioXPath).click();}catch(Exception error){System.out.println("Error while click no for GenerateReportsRegularly");}
						}
					}catch(Exception error){}


					if(AddClientCommunicationProtocolReports_FLAG==true)
					{
						Thread.sleep(2000);
						try{
							if(DoesConferenceCallRegularly.equalsIgnoreCase("Yes")){

								NewRadioXPath	=	XPathPrefix+"DoesConferenceCallRegularly"+XPathSufixTrue;
								try{utilfunc.MakeElement(NewRadioXPath).click();}catch(Exception error){System.out.println("Error while click DoesConferenceCallRegularly");}
								// now add new entries for report..
								System.out.println("Now add new conference call entries..");
								System.out.println("Let us find out how many conference we need to add");
								String[]	ConferenceNames=null;
								String[]	Participantss=null;
								String[]	CallFrequencys=null;
								String[]	Descriptions=null;


								System.out.println("ConferenceName :"+ConferenceName);
								System.out.println("Participants :"+Participants);
								System.out.println("CallFrequency :"+CallFrequency);
								System.out.println("Description :"+Description);


								try{ConferenceNames		=	ConferenceName.split(",");}catch(Exception error){}
								try{Participantss		=	Participants.split(",");}catch(Exception error){}
								try{CallFrequencys		=	CallFrequency.split(",");}catch(Exception error){}
								try{Descriptions		=	Description.split(",");}catch(Exception error){}

								boolean conference_FLAG=false;

								for(int a=0;a<Integer.parseInt(NumberOFConferenceCallRegularly.replaceAll("\\.0*$", ""));a++){


									try{
										try{utilfunc.MakeElement(".//*[@id='dvCon']/a").click();}catch(Exception error){System.out.println("Error while click on .//*[@id='dvCon']/a");}
										Thread.sleep(2000);
										System.out.println("User is now on new page where he can add new conference for "+a+ " times");
										System.out.println("We will wait here to load all elements");


										try{System.out.println("a is:"+a);}catch(Exception error){}
										try{System.out.println("ConferenceNames["+a+"].trim() :"+ConferenceNames[a]);}catch(Exception error){System.out.println(error);}
										try{System.out.println("Participantss["+a+"].trim() :"+Participantss[a]);}catch(Exception error){System.out.println(error);}
										try{System.out.println("CallFrequencys["+a+"].trim() :"+CallFrequencys[a]);}catch(Exception error){System.out.println(error);}
										try{System.out.println("Descriptions["+a+"].trim() :"+Descriptions[a]);}catch(Exception error){System.out.println(error);}


										Thread.sleep(3000);
										try{utilfunc.MakeElement(XPathPrefix+"ConferenceName"+XPathSufix).sendKeys(ConferenceNames[a]);}catch(Exception error){System.out.println("fail to set ConferenceName");}
										Thread.sleep(3000);
										try{utilfunc.MakeElement(XPathPrefix+"Participants"+XPathSufix).sendKeys(Participantss[a]);}catch(Exception error){System.out.println("fail to set Participants");}
										Thread.sleep(3000);
										try{utilfunc.MakeElement(XPathPrefix+"Frequency"+XPathSufix).sendKeys(CallFrequencys[a]);}catch(Exception error){System.out.println("fail to set Frequency in Con");}
										Thread.sleep(3000);
										try{utilfunc.MakeElement(XPathPrefix+"Description"+XPathSufix).sendKeys(Descriptions[a]);}catch(Exception error){System.out.println("fail to set Description");}

										try{
											utilfunc.MakeElement("//*[@id='btnSave']").click();
											Thread.sleep(2000);
										}catch(Exception s){
											System.out.println("unable to click on save button for conference call");
										}


										String conferenceerror_flag="";
										try{
											conferenceerror_flag=utilfunc.ErrorMessagehandlerExperiment();
										}catch(Exception error){}
										System.out.println("error_flag for conference call:- \n"+conferenceerror_flag);
										if (conferenceerror_flag.equals(ExpectedErrorMessage)){
											conference_FLAG=true;
											conference_GlobalErrorMessage="some msg";
										}else if (conferenceerror_flag.equals("")){
											conference_FLAG=true;
										}else if (conferenceerror_flag.contains("Success!")){
											conference_FLAG=true;
										}else if(conferenceerror_flag.equals("Server Error in '/' Application.")){
											conference_FLAG=false;
											webdriver.navigate().back();
										}else{
											conference_FLAG=false;
										}

										if(conference_FLAG!=true)
										{
											Flag=false;
											utilfunc.TakeScreenshot();
											return Flag;
										}



										System.out.println("We have added a new conference call info");
									}catch(Exception s){
										System.out.println("Some error occured while adding conference call");
									}
								}

							}else if(DoesConferenceCallRegularly.equalsIgnoreCase("No")){
								NewRadioXPath		=	XPathPrefix+"DoesConferenceCallRegularly"+XPathSufixFalse;
								try{utilfunc.MakeElement(NewRadioXPath).click();}catch(Exception errro){System.out.println("Errro while click on DoesConferenceCallRegularly");}
							}
						}catch(Exception error){}
					}


					// now let us fill the rest of the form..
					int count	=	utilfunc.GetObjectCount(FormFieldsCounterXPath);
					try{
						for(int c=1;c<=count;c++){
							//									if(c==5){
							//										continue;
							//									}
							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(c));
							String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");


							//									if(AttributeName.equals("GenerateReportsRegularly")){
							//										
							//									}
							//									if(AttributeName.equals("DoesConferenceCallRegularly")){

							//									}
							if(AttributeName.equals("CanBALDirectContactEmployee")){
								if(CanBALDirectContactEmployee.equalsIgnoreCase("Yes")){
									NewRadioXPath	=	XPathPrefix+"CanBALDirectContactEmployee"+XPathSufixTrue;
									utilfunc.MakeElement(NewRadioXPath).click();
								}else if(CanBALDirectContactEmployee.equalsIgnoreCase("No")){
									NewRadioXPath	=	XPathPrefix+"CanBALDirectContactEmployee"+XPathSufixFalse;
									utilfunc.MakeElement(NewRadioXPath).click();
								}
							}
							else if(AttributeName.equals("CanBALProvideEmployeeReceiptNumber")){
								if(CanBALProvideEmployeeReceiptNumber.equalsIgnoreCase("Yes")){
									NewRadioXPath		=	XPathPrefix+"CanBALProvideEmployeeReceiptNumber"+XPathSufixTrue;
									utilfunc.MakeElement(NewRadioXPath).click();
								}else if(CanBALProvideEmployeeReceiptNumber.equalsIgnoreCase("No")){
									NewRadioXPath		=	XPathPrefix+"CanBALProvideEmployeeReceiptNumber"+XPathSufixFalse;
									utilfunc.MakeElement(NewRadioXPath).click();
								}
							}
							else if(AttributeName.equals("CanBALContactHiringManager")){
								if(CanBALContactHiringManager.equalsIgnoreCase("Yes")){
									utilfunc.MakeElement(XPathPrefix+"CanBALContactHiringManager"+XPathSufixTrue).click();
								}else if(CanBALContactHiringManager.equalsIgnoreCase("No")){
									utilfunc.MakeElement(XPathPrefix+"CanBALContactHiringManager"+XPathSufixFalse).click();
								}
							}
							else if(AttributeName.equals("ProvideStatusChekAccesstoManagers")){
								if(ProvideStatusChekAccesstoManagers.equalsIgnoreCase("Yes")){
									utilfunc.MakeElement(XPathPrefix+"ProvideStatusChekAccesstoManagers"+XPathSufixTrue).click();
									System.out.println("Now fill textbox associated with this radio selection");
									utilfunc.MakeElement(WhoInitiatesProjectsXPath).clear();
									utilfunc.MakeElement(WhoInitiatesProjectsXPath).sendKeys(WhoInitiatesProjects);
								}else if(ProvideStatusChekAccesstoManagers.equalsIgnoreCase("No")){
									utilfunc.MakeElement(XPathPrefix+"ProvideStatusChekAccesstoManagers"+XPathSufixFalse).click();
								}
								// scroll to bottom so that 
								utilfunc.scrollToBottom();
							}
							else if(AttributeName.equals("DoesClientUseCIMSHR")){
								if(DoesClientUseCIMSHR.equalsIgnoreCase("Yes")){
									System.out.println(XPathPrefix+"DoesClientUseCIMSHR"+XPathSufixTrue);
									utilfunc.MakeElement(XPathPrefix+"DoesClientUseCIMSHR"+XPathSufixTrue).click();
								}else if(DoesClientUseCIMSHR.equalsIgnoreCase("No")){
									utilfunc.MakeElement(XPathPrefix+"DoesClientUseCIMSHR"+XPathSufixFalse).click();
								}

							}

							else if(AttributeName.equals("DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance")){
								if(DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance.equalsIgnoreCase("Yes")){
									utilfunc.MakeElement(XPathPrefix+"DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance"+XPathSufixTrue).click();
									System.out.println("Now let us fill textbox associated with this radio selection for special billing instruction for filling");
									utilfunc.MakeElement(CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceTextXPath).clear();
									utilfunc.MakeElement(CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceTextXPath).sendKeys(CompanyIssueFilingFeeChecksAndSendOfficeInAdvanceText);
								}else if(DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance.equalsIgnoreCase("No")){
									utilfunc.MakeElement(XPathPrefix+"DoesCompanyIssueFilingFeeChecksAndSendOfficeInAdvance"+XPathSufixFalse).click();
								}
							}
							System.out.println("new radio xpath: " + NewRadioXPath);
						}
					}catch(Exception error){}
					//									Flag	=	true;
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Unable to add communication protocal");
				}

				//						if(Flag==true){

				try{
					// save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
					try{utilfunc.MakeElement(saveBtn).click();}catch(Exception error){System.out.println("Unable to click save button");}
					//								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					Thread.sleep(2000);
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();

					System.out.println("error_flag\n"+error_flag);
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
					}
					else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}
					
					if((!reportpasswithfail.equals(""))||(!conference_GlobalErrorMessage.equals("")))
					{
						//Flag=false;
						utilfunc.globalerrormessage="In case of pass wih negative";
						utilfunc.ErrorMessage1=ExpectedErrorMessage;
						
					}
					
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
				}

				if(Flag==true)
				{

				}
				//						}
			}
		}	
		/**
		 * scroll to top in order to catch the company slider icon
		 */
		utilfunc.scrollToTop();

		return Flag;
	}
}
