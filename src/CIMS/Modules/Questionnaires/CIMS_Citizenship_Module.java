package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Citizenship_Module
{


	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------

	public static String ErrorMessage="";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String globalerrormessage="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	//Constructor----------

	public CIMS_Citizenship_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}


	//Functions--------------
	/**
	 * Verify that User is able to landed on the Project Initiation Page
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean CitizenshipPage(int ColumnCounter, String mode) throws AWTException, InterruptedException
	{	

		//Passport Page	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Citizenship", 0, ColumnCounter);
		String CitizenshipScenerio=UtilFunction.getCellData("Test Data.xls", "Citizenship", 2, ColumnCounter);
		String CitizenshipTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Citizenship", 3, ColumnCounter);		
		String CitizenshipPageURL=UtilFunction.getCellData("Test Data.xls", "Citizenship", 4, ColumnCounter);


		String CitizenshipID=UtilFunction.getCellData("Test Data.xls", "Citizenship", 5, ColumnCounter);			
		String CitizenshipCountry=UtilFunction.getCellData("Test Data.xls", "Citizenship", 6, ColumnCounter);
		String Citizenshipprimarycitizenship=UtilFunction.getCellData("Test Data.xls", "Citizenship", 7, ColumnCounter);
		String CitizenshipDateObtained=UtilFunction.getCellData("Test Data.xls", "Citizenship", 8, ColumnCounter);
		String CitizenshipCountry1=UtilFunction.getCellData("Test Data.xls", "Citizenship", 9, ColumnCounter);


		String CitizenshipCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Citizenship", 10, ColumnCounter);
		String CitizenshipStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Citizenship", 11, ColumnCounter);
		String CitizenshipHowdidyouacquirethiscitizenship=UtilFunction.getCellData("Test Data.xls", "Citizenship", 12, ColumnCounter);
		String CitizenshipAbandoned=UtilFunction.getCellData("Test Data.xls", "Citizenship", 13, ColumnCounter);
		String CitizenshipAbandoneddate=UtilFunction.getCellData("Test Data.xls", "Citizenship", 14, ColumnCounter);
		String CitizenshipAbandonedreason=UtilFunction.getCellData("Test Data.xls", "Citizenship", 15, ColumnCounter);

		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Citizenship", 16, ColumnCounter);
		//Custom Field  


		//Methods Xpath
		//String CitizenshipFiledXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]";
		String CitizenshipLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
		//String CounterXpath=".//*[@id='form1']//*[@class='control-group']";

		String CitizenshipFieldxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]/div[1]//*[@id]";
		String CounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']/div[1]//*[@id]";
		String radiobuttonclickYes=".//*[@class='question-group']//*[@class='control-group'][1]//*[@class='controls'][1]//*[@type='radio'][1]";
		String radiobuttonclickNo=".//*[@class='question-group']//*[@class='control-group'][1]//*[@class='controls'][1]//*[@type='radio'][2]";
		String Abandoneddate=".//*[@id='AbandonedDate']";
		String Abandonedreason=".//*[@id='AbandonedDescription']";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Citizenship";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=CitizenshipScenerio;
		description=CitizenshipTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);


		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String CitizenshipURLwithID=CitizenshipPageURL+CitizenshipID;
				 utilfunc.NavigatetoURL(CitizenshipURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String AddbuttonXpath="//*[@class='btn']";
					try{ 
						utilfunc.MakeElement(AddbuttonXpath).click();
						Thread.sleep(2000);

						int ObjCount=utilfunc.GetObjectCount(CounterXpath);
						//////////////////
						try{
							for(int count=1; count<=ObjCount; count++)
							{
								Thread.sleep(300);
								//Label Printing
								String NewXpath=CitizenshipFieldxpath.replace("xx", Integer.toString(count));
								// String LabelName=utilfunc.MakeElement(NewXpath).getText();

								try{
									String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
									System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.contains("CountryCode")){			
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, CitizenshipCountry);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("IsApplicantCare")){
										try{
											Thread.sleep(2000);
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(800);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("ObtainedDate")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipDateObtained);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("ObtainedCountryCode")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipCountry1);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("ObtainedCity")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipCityTownLocality);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("ObtainedStateOrProvince")){
										try{utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipStateProvinceRegion);
										}catch(Exception error){}
									}
									else if(AttributeName.contains("HowAcquireCitizenship")){
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, CitizenshipHowdidyouacquirethiscitizenship);
										}catch(Exception error){}
									}

								}catch(Exception z){}	

							}
						}catch(Exception error){}

						//Lokesh::: code added for click on Is this your primary citizenship? Date 13June2016
						//START
						try{
							
							
							if(Citizenshipprimarycitizenship.equalsIgnoreCase("Yes"))
							{String isPrimary_xpath=".//*[@id='IsApplicantCare' and contains(@value,'True')]";
								Thread.sleep(2000);
								utilfunc.MakeElement(isPrimary_xpath).click();
								Thread.sleep(800);
							}	
						}catch(Exception error){}
						//Ends
						
						////////////////radio button handled////////////////////////

						try{
							if(CitizenshipAbandoned.contains("Yes")){
								try{
									utilfunc.MakeElement(radiobuttonclickYes).click();	
									utilfunc.MakeElement(Abandoneddate).sendKeys(CitizenshipAbandoneddate);
									utilfunc.MakeElement(Abandonedreason).sendKeys(CitizenshipAbandonedreason);
								}catch(Exception error){}

							}else{
								try{utilfunc.MakeElement(radiobuttonclickNo).click();	
								}catch(Exception error){}
							}

						}catch(Exception error){}
						////////////////Additional info handler ////////////////////
						String Xpathnew1=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";
						String Xpathnew2=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";

						//function to call the dynamic text data
						try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
						}catch(Exception error){}


						/*String SaveButtonXpath=".//*[@id='btnSave']";
		 		 utilfunc.MakeElement(SaveButtonXpath).click();*/
						try{utilfunc.savebutton();
						}catch(Exception error){}

						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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

					}catch(Exception Error){utilfunc.NavigatetoURL(URLwithID);}
				}catch(Exception e){

				}

			}else if(mode.equals(ACTION1)){
				try{
					/*String CitizenshipURLwithID=CitizenshipPageURL+CitizenshipID;
				 utilfunc.NavigatetoURL(CitizenshipURLwithID);*/


					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					try{
						String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
						utilfunc.MakeElement(EditbuttonXpath).click();
						Thread.sleep(2000);

						int ObjCount=utilfunc.GetObjectCount(CounterXpath);
						//////////////////
						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							//Label Printing
							String NewXpath=CitizenshipFieldxpath.replace("xx", Integer.toString(count));
							// String LabelName=utilfunc.MakeElement(NewXpath).getText();

							try{
								String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								//System.out.println("Attribute name "+count+"is : "+AttributeName);

								if(AttributeName.contains("CountryCode")){			
									try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, CitizenshipCountry);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("IsApplicantCare")){
									try{utilfunc.MakeElement(NewXpath).click();
									}catch(Exception error){}
								}
								else if(AttributeName.contains("ObtainedDate")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipDateObtained);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("ObtainedCountryCode")){
									try{
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipCountry1);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("ObtainedCity")){
									try{		utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("ObtainedStateOrProvince")){
									try{		utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(CitizenshipStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("HowAcquireCitizenship")){
									try{	utilfunc.Selectdropdownvaluebyvalue(NewXpath, CitizenshipHowdidyouacquirethiscitizenship);
									}catch(Exception error){}
								}
							}catch(Exception error){}
						}


						////////////////radio button handled////////////////////////
						try{
							if(CitizenshipAbandoned.contains("Yes")){
								try{	
									Thread.sleep(1000);
									utilfunc.MakeElement(radiobuttonclickYes).click();	
									try{
										utilfunc.MakeElement(Abandoneddate).clear();
										utilfunc.MakeElement(Abandoneddate).sendKeys(CitizenshipAbandoneddate);
										utilfunc.MakeElement(Abandonedreason).clear();
										utilfunc.MakeElement(Abandonedreason).sendKeys(CitizenshipAbandonedreason);
									}catch(Exception error){}
								}catch(Exception error){}

							}else{
								try{utilfunc.MakeElement(radiobuttonclickNo).click();	
								}catch(Exception error){}
							}

						}catch(Exception z){

						}
						////////////////Additional info handler ////////////////////
						String Xpathnew1=".//*[@class='form-horizontal']/div[9]//*[@class='control-group']//*[@id]";
						String Xpathnew2=".//*[@class='form-horizontal']/div[9]//*[@class='control-group'][xx]//*[@id]";

						//function to call the dynamic text data
						try{
							utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
						}catch(Exception error){}


						/*String SaveButtonXpath=".//*[@id='btnSave']";
		 		 utilfunc.MakeElement(SaveButtonXpath).click();*/
						try{utilfunc.savebutton();
						}catch(Exception error){}

						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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

					}catch(Exception error){utilfunc.NavigatetoURL(URLwithID);}
				}
				catch(Exception e){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					utilfunc.ErrorMessage2="No Records Found to Edit";
					Flag=false;
					utilfunc.TakeScreenshot();
				}
			}else if(mode.equals(ACTION2)){
				try{
					/* String CitizenshipURLwithID=CitizenshipPageURL+CitizenshipID;
				 utilfunc.NavigatetoURL(CitizenshipURLwithID);*/
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{utilfunc.MakeElement(DeletebuttonXpath).click();
					utilfunc.isAlertPresent();
					}catch(Exception error){}

					String compensationErrorMessageXpath="//*[@id='page-message']";
					ErrorMessage1=utilfunc.MakeElement(compensationErrorMessageXpath).getText();

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}

				}catch(Exception e){
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					utilfunc.ErrorMessage2="No Records Found to Delete";
					Flag=false;
					utilfunc.TakeScreenshot();
				}
			}
		}///////////url ckeck end
		return Flag; 
	}
}