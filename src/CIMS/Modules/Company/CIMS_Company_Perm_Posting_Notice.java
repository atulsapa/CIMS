package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;


public class CIMS_Company_Perm_Posting_Notice {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Company_Perm_Posting_Notice(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

	}


	public boolean Company_Perm_Posting_Notice(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module with "+mode+" Mode.");
		boolean Flag	=	false;
		System.out.println("Start getting values form excel sheet. Please wait...");
		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);	
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String PermPostingNoticeNumber						=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String PermPostingNoticeNumber_edit					=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String LocationName									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String LocationName_edit							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String StreetAddress								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String StreetAddress2								=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Apt_Ste_Flr									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String Apt_Ste_Flr_value							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String City_Town_Locality							=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String State_Province_Region						=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String Postal_code									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
		String Country										=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
		String SentClientPostingDate1						=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
		String PhysicalPostingPostedDate1					=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String PhysicalPostingRemovedDate1					=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String InHouseMediaPostedDate1						=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		String InHouseMediaRemovedDate1						=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String ConfirmationsReceivedDate1					=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);


		String SentClientPostingDate="";
		String PhysicalPostingPostedDate="";
		String PhysicalPostingRemovedDate="";
		String InHouseMediaPostedDate="";
		String InHouseMediaRemovedDate="";
		String ConfirmationsReceivedDate="";

		//update date format.

		try{SentClientPostingDate= utilfunc.changeDateFormat(SentClientPostingDate1)  ;//append
		}catch(Exception e){System.out.println("Error occured during checking date.");}  
		
		try{PhysicalPostingPostedDate= utilfunc.changeDateFormat(PhysicalPostingPostedDate1)  ;//append  
		}catch(Exception e){System.out.println("Error occured during checking date.");}
		
		try{PhysicalPostingRemovedDate= utilfunc.changeDateFormat(PhysicalPostingRemovedDate1)  ;//append  
		}catch(Exception e){System.out.println("Error occured during checking date.");}
		
		try{InHouseMediaPostedDate= utilfunc.changeDateFormat(InHouseMediaPostedDate1)  ;//append  
		}catch(Exception e){System.out.println("Error occured during checking date.");}
		
		try{InHouseMediaRemovedDate= utilfunc.changeDateFormat(InHouseMediaRemovedDate1)  ;//append  
		}catch(Exception e){System.out.println("Error occured during checking date.");}
		
		try{ConfirmationsReceivedDate= utilfunc.changeDateFormat(ConfirmationsReceivedDate1)  ;//append  
		}catch(Exception e){System.out.println("Error occured during checking date.");}

		System.out.println("Getting values from excel is completed. Now proccess is started...");

		testcaseid			=	TestcaseID;
		scenerio			=	Scenario;
		description = Company_Description;

		if(TestcaseRunMode.equals("Y"))
		{
			if(mode.equalsIgnoreCase("New"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
				String add_new_xpath=".//*[@class='btn' and contains(text(),'Add Perm Posting Notice')]";
				String row_xpath=".//*[@id='form1']//*[@class='control-group'][yyy]//*[@class='controls']//*[@name]";
				try{utilfunc.MakeElement(add_new_xpath).click();}catch(Exception error){System.out.println("Unable to click add button.");}
				Thread.sleep(1000);
				int element_row=utilfunc.GetObjectCount(".//*[@id='form1']//*[@class='control-group']");
				try
				{
					for(int i=1;i<=element_row;i++)
					{
						Thread.sleep(1000);
						try
						{
							String new_row_xpath	=	row_xpath.replace("yyy", Integer.toString(i));
							String myattributename="";
							try
							{
								myattributename = utilfunc.MakeElement(new_row_xpath).getAttribute("name");
								System.out.println("---"+myattributename+"---");
							}
							catch(Exception e)
							{}
							if (myattributename.equalsIgnoreCase("PNConfirmationNumber"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(PermPostingNoticeNumber);
							}else if (myattributename.equalsIgnoreCase("LocationName"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(LocationName);
							}else if (myattributename.equalsIgnoreCase("PNAddress1"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(StreetAddress);
							}else if (myattributename.equalsIgnoreCase("PNAddress2"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(StreetAddress2);
							}else if (myattributename.equalsIgnoreCase("PNUnitType"))
							{	
								int element_Count=utilfunc.GetObjectCount(new_row_xpath);
								for(int name=1;name<=element_Count;name++)
								{
									String inner_row_xpath=new_row_xpath+"["+name+"]";
									String myattributename1="";
									try
									{
										myattributename1 = utilfunc.MakeElement(inner_row_xpath).getAttribute("name");
										System.out.println("---"+myattributename1+"---");
									}catch(Exception e){}

									if (myattributename1.equalsIgnoreCase("PNUnitType"))
									{
										if(StringUtils.isEmpty(Apt_Ste_Flr)==false)
										{
											utilfunc.MakeElement(inner_row_xpath).click();
											utilfunc.Selectdropdownvaluebytext(inner_row_xpath, Apt_Ste_Flr);
										}
										else
										{
											utilfunc.MakeElement(inner_row_xpath).click();
											Thread.sleep(200);
											utilfunc.DeSelectdropdownvalue(inner_row_xpath);
											System.out.println("\nValue -"+Apt_Ste_Flr+"- is not exists inside the drop down.");
										}
									}
									else if (myattributename1.equalsIgnoreCase("PNUnitNumber"))
									{
										utilfunc.MakeElement(inner_row_xpath).sendKeys(Apt_Ste_Flr_value);
									}
								}
							}else if (myattributename.equalsIgnoreCase("PNCity"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(City_Town_Locality);
							}else if (myattributename.equalsIgnoreCase("PNStateOrProvince"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(State_Province_Region);
							}else if (myattributename.equalsIgnoreCase("PNPostalCode"))
							{
								utilfunc.MakeElement(new_row_xpath).sendKeys(Postal_code);
							}else if (myattributename.equalsIgnoreCase("PNCountryCode"))
							{
								if(StringUtils.isEmpty(Country)==false)
								{
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.Selectdropdownvaluebytext(new_row_xpath, Country);
								}
								else
								{
									Thread.sleep(200);
									utilfunc.DeSelectdropdownvalue(new_row_xpath);
									System.out.println("\nValue -"+Country+"- is not exists inside the drop down.");
								}
							}else if (myattributename.equalsIgnoreCase("DateSent"))
							{
								Thread.sleep(1000);
								try{
								utilfunc.MakeElement(new_row_xpath).sendKeys(SentClientPostingDate);
								}catch(Exception error){System.out.println("Unable to set DateSent");}
							}else if (myattributename.equalsIgnoreCase("PhysicalPostingPostedDate"))
							{	Thread.sleep(1000);
								try{
									utilfunc.MakeElement(new_row_xpath).sendKeys(PhysicalPostingPostedDate);
								}catch(Exception error){System.out.println("Unable to set PhysicalPostingPostedDate");}
							}else if (myattributename.equalsIgnoreCase("PhysicalPostingRemovedDate"))
							{
								Thread.sleep(1000);
								try{
									utilfunc.MakeElement(new_row_xpath).sendKeys(PhysicalPostingRemovedDate);
								}catch(Exception error){System.out.println("Unable to set PhysicalPostingRemovedDate");}
							}else if (myattributename.equalsIgnoreCase("InHouseMediaPostedDate"))
							{
								Thread.sleep(1000);
								try{
									utilfunc.MakeElement(new_row_xpath).sendKeys(InHouseMediaPostedDate);
								}catch(Exception error){System.out.println("Unable to set InHouseMediaPostedDate");}
							}else if (myattributename.equalsIgnoreCase("InHouseMediaRemovedDate"))
							{
								Thread.sleep(1000);
								try{
								utilfunc.MakeElement(new_row_xpath).sendKeys(InHouseMediaRemovedDate);
								}catch(Exception error){System.out.println("Unable to set InHouseMediaRemovedDate");}
							}else if (myattributename.equalsIgnoreCase("ConfirmationsReceivedDate"))
							{
								Thread.sleep(1000);
								try{utilfunc.MakeElement(new_row_xpath).sendKeys(ConfirmationsReceivedDate);
								}catch(Exception error){System.out.println("Unable to set ConfirmationsReceivedDate");}
							}

						}
						catch(Exception error)
						{
							System.out.println("Some Error occured during setting values in fields. Error description: "+error);
						}
					}

					try{
						Thread.sleep(1000);
						String saveBtn	=	".//*[@id='btnSave' and contains(text(),'Save')]";
						try{utilfunc.MakeElement(saveBtn).click();}catch(Exception error){System.out.println("Unable to click save button.");}

						String  error_flag="";
						try{
							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
						catch(Exception e){}
						Thread.sleep(500);
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
					}catch(Exception error){System.out.println("Error occured during click the save button: "+error+"\n===");}


				}
				catch(Exception Error){System.out.println("Some error occured. Error description details are: "+Error);}

			}
			else if(mode.equalsIgnoreCase("Edit"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");



				//call search function
				search(PermPostingNoticeNumber,LocationName);
				Thread.sleep(4000);
				String SearchResult=utilfunc.MakeElement(".//*[@id='divList']/tbody/tr[1]/td[1]").getText();
				System.out.println("\t---\t---"+SearchResult+"---");
				Thread.sleep(2000);
				if(SearchResult.equalsIgnoreCase("No Data Found!"))
				{
					Flag=false;
					utilfunc.TakeScreenshot();
					utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";
					return Flag;
				}
				else
				{
					System.out.println("we are going to click on edit btn");
					utilfunc.MakeElement(".//*[@id='divList']/tbody/tr[1]/td//*[@class='icon-edit']").click();
					Thread.sleep(500);
					System.out.println("we clicked on edit btn");
					Thread.sleep(200);
					String row_xpath=".//*[@id='form1']//*[@class='control-group'][yyy]//*[@class='controls']//*[@name]";
					int element_row=utilfunc.GetObjectCount(".//*[@id='form1']//*[@class='control-group']");
					try
					{
						for(int i=1;i<=element_row;i++)
						{
							Thread.sleep(100);
							try
							{
								String new_row_xpath	=	row_xpath.replace("yyy", Integer.toString(i));
								String myattributename="";
								try
								{
									myattributename = utilfunc.MakeElement(new_row_xpath).getAttribute("name");
									System.out.println("---"+myattributename+"---");
								}
								catch(Exception e)
								{}
								if (myattributename.equalsIgnoreCase("PNConfirmationNumber"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(PermPostingNoticeNumber_edit);
								}else if (myattributename.equalsIgnoreCase("LocationName"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(LocationName_edit);
								}else if (myattributename.equalsIgnoreCase("PNAddress1"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(StreetAddress);
								}else if (myattributename.equalsIgnoreCase("PNAddress2"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(StreetAddress2);
								}else if (myattributename.equalsIgnoreCase("PNUnitType"))
								{	
									int element_Count=utilfunc.GetObjectCount(new_row_xpath);
									for(int name=1;name<=element_Count;name++)
									{
										String inner_row_xpath=new_row_xpath+"["+name+"]";
										String myattributename1="";
										try
										{
											myattributename1 = utilfunc.MakeElement(inner_row_xpath).getAttribute("name");
											System.out.println("---"+myattributename1+"---");
										}catch(Exception e){}

										if (myattributename1.equalsIgnoreCase("PNUnitType"))
										{
											if(StringUtils.isEmpty(Apt_Ste_Flr)==false)
											{
												utilfunc.MakeElement(inner_row_xpath).click();
												utilfunc.DeSelectdropdownvalue(inner_row_xpath);
												utilfunc.MakeElement(inner_row_xpath).click();
												utilfunc.Selectdropdownvaluebytext(inner_row_xpath, Apt_Ste_Flr);
											}
											else
											{
												utilfunc.MakeElement(inner_row_xpath).click();
												Thread.sleep(200);
												utilfunc.DeSelectdropdownvalue(inner_row_xpath);
												System.out.println("\nValue -"+Apt_Ste_Flr+"- is not exists inside the drop down.");
											}
										}
										else if (myattributename1.equalsIgnoreCase("PNUnitNumber"))
										{
											utilfunc.MakeElement(inner_row_xpath).clear();
											utilfunc.MakeElement(inner_row_xpath).sendKeys(Apt_Ste_Flr_value);
										}
									}
								}else if (myattributename.equalsIgnoreCase("PNCity"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(City_Town_Locality);
								}else if (myattributename.equalsIgnoreCase("PNStateOrProvince"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(State_Province_Region);
								}else if (myattributename.equalsIgnoreCase("PNPostalCode"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).sendKeys(Postal_code);
								}else if (myattributename.equalsIgnoreCase("PNCountryCode"))
								{
									if(StringUtils.isEmpty(Country)==false)
									{
										utilfunc.MakeElement(new_row_xpath).click();
										utilfunc.DeSelectdropdownvalue(new_row_xpath);
										utilfunc.MakeElement(new_row_xpath).click();
										utilfunc.Selectdropdownvaluebytext(new_row_xpath, Country);
									}
									else
									{
										utilfunc.MakeElement(new_row_xpath).click();
										Thread.sleep(200);
										utilfunc.DeSelectdropdownvalue(new_row_xpath);
										System.out.println("\nValue -"+Country+"- is not exists inside the drop down.");
									}
								}else if (myattributename.equalsIgnoreCase("DateSent"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(SentClientPostingDate);
								}else if (myattributename.equalsIgnoreCase("PhysicalPostingPostedDate"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(PhysicalPostingPostedDate);
								}else if (myattributename.equalsIgnoreCase("PhysicalPostingRemovedDate"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(PhysicalPostingRemovedDate);
								}else if (myattributename.equalsIgnoreCase("InHouseMediaPostedDate"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(InHouseMediaPostedDate);
								}else if (myattributename.equalsIgnoreCase("InHouseMediaRemovedDate"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(InHouseMediaRemovedDate);
								}else if (myattributename.equalsIgnoreCase("ConfirmationsReceivedDate"))
								{
									utilfunc.MakeElement(new_row_xpath).clear();
									utilfunc.MakeElement(new_row_xpath).click();
									utilfunc.MakeElement(new_row_xpath).sendKeys(ConfirmationsReceivedDate);
								}

							}
							catch(Exception error)
							{
								System.out.println("Some Error occured during setting values in fields. Error description: "+error);
							}
						}


						try{
							Thread.sleep(100);
							String saveBtn	=	".//*[@id='btnSave' and contains(text(),'Save')]";
							utilfunc.MakeElement(saveBtn).click();
							System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
							String  error_flag="";
							try{
								error_flag=utilfunc.ErrorMessagehandlerExperiment();}
							catch(Exception e){}
							Thread.sleep(100);
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
						}catch(Exception error){System.out.println("Error occured during click the save button: "+error+"\n===");}


					}
					catch(Exception Error){System.out.println("Some error occured. Error description details are: "+Error);}
				}

			}
			else if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");

				//call search function
				search(PermPostingNoticeNumber,LocationName);
				Thread.sleep(4000);
				String SearchResult=utilfunc.MakeElement(".//*[@id='divList']/tbody/tr[1]/td[1]").getText();
				Thread.sleep(2000);
				System.out.println("\t---\t---"+SearchResult+"---");
				if(SearchResult.equalsIgnoreCase("No Data Found!"))
				{
					Flag=false;
					utilfunc.TakeScreenshot();
				}
				else
				{
					try{
						utilfunc.MakeElement(".//*[@id='divList']/tbody/tr[1]/td//*[@class='icon-trash']").click();
						Thread.sleep(200);
						Alert alt= webdriver.switchTo().alert();
						alt.accept();
						String  error_flag="";
						try{
							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
						catch(Exception e){}
						Thread.sleep(100);
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

					}
					catch(Exception error){System.out.println("Error occured during executing delete code."+error);}


				}
			}



		}
		return Flag;
	}

	public void search(String PermPostingNoticeNumber,String LocationName) throws InterruptedException
	{
		System.out.println("\t\t---Search functionality start.");
		String search_btn_xpath=".//*[contains(@class,'btn') and text()='Search']";
		String search_row_xpath=".//*[@class='project-search']/tbody//tr//td[hhh]//*[@id]";
		int search_td_count=utilfunc.GetObjectCount(".//*[@class='project-search']/tbody//tr//td");

		for(int srh_i=1;srh_i<=search_td_count;srh_i++)
		{
			Thread.sleep(200);
			String new_row_xpath	=	search_row_xpath.replace("hhh", Integer.toString(srh_i));
			String search_myattributeid="";
			try
			{
				search_myattributeid = utilfunc.MakeElement(new_row_xpath).getAttribute("id");
			}
			catch(Exception e)
			{}

			if(search_myattributeid.equalsIgnoreCase("PostingNoticeNumber"))
			{
				utilfunc.MakeElement(new_row_xpath).clear();
				utilfunc.MakeElement(new_row_xpath).sendKeys(PermPostingNoticeNumber);					
			}
			else if(search_myattributeid.equalsIgnoreCase("LocationName"))
			{
				utilfunc.MakeElement(new_row_xpath).clear();
				utilfunc.MakeElement(new_row_xpath).sendKeys(LocationName);					
			}else 
			{
			}

		}
		Thread.sleep(300);	
		utilfunc.MakeElement(search_btn_xpath).click();
		Thread.sleep(300);
		System.out.println("\t\t---Search functionality finished.");
		Thread.sleep(400);
	}
}
