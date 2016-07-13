package CIMS.Modules.Company;
//**//
import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Company_PurposeCategories {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public static String testcaseid="";
	public static String scenerio="";
	public static String testcasedescription="";

	public CIMS_Company_PurposeCategories(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_PurposeCategories(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		boolean Flag	=	false;

		//Get Test case run mode from Excel sheet.
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);

		if(TestcaseRunMode.equals("Y")){

			//excel data sheet collection..
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String CategoryName									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Country										=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);

			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;

			// xpath variables
			String Element_xpath							=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
			String Form_Fields_Count_Xpath					=	"//*[@id='form1']//*[@class='control-group']//*[@class='controls']";
			String Add_New_Category_btn						=	"//*[contains(@class,'btn') and contains(text(),'Add New Category')]";
			String Add_Country_Btn							=	"//*[@id='form1']//*[contains(@id,'btnAddCountry') and contains(text(),'Add')]";
			String Save_Btn									=	"//*[contains(@class,'btn') and contains(text(),'Save')]";
			String allready_added_countery_count			=	"//*[@id='form1']//tbody/tr";
			String Search_Result_rows_count_xpath			=	".//*[@id='divList']/table[1]/tbody/tr";
			String Search_Result_record_foundORnot_xpath	=	".//*[@id='divList']/table[1]/tbody/tr[1]/td[1]";
			String Search_Result_row_td_count_xpath	=	".//*[@id='divList']/table[1]/tbody/tr[aa]/td";
			String Search_match_xpath	=	".//*[@id='divList']/table[1]/tbody/tr[aa]/td[bb]";
			String Edit_icon=".//*[@id='divList']/table[1]/tbody/tr[1]//*[contains(@class,'icon-edit')]";
			String delete_icon=".//*[@id='divList']/table[1]/tbody/tr[1]//*[contains(@class,'icon-trash')]";
			String AllreadyAddedCountyDelBtn="//*[@id='form1']//tbody/tr[2]//*[contains(@class,'icon-trash')]";
//New mode start here
			if(mode.equals("New")){
				Thread.sleep(1000);
				//click on "Add New Category" button
				try{
					utilfunc.MakeElement(Add_New_Category_btn).click();
					Thread.sleep(1000);
				}
				catch(Exception error){System.out.println("Error while click \"Add New Category\" button.");}

				try{
					//get element row count
					int Form_Fields_Count=utilfunc.GetObjectCount(Form_Fields_Count_Xpath);

					for(int i=1;i<=Form_Fields_Count;i++)
					{
						Thread.sleep(1000);
						String Current_Element_xpath=Element_xpath.replaceAll("xx", Integer.toString(i));
						String myattributename="";
						try{myattributename	=	utilfunc.MakeElement(Current_Element_xpath).getAttribute("name");}catch(Exception e){}
						if(!myattributename.equals(""))
						{
							try
							{
								if (myattributename.equalsIgnoreCase("PurposeCategoryName"))
								{
									try
									{
										utilfunc.MakeElement(Current_Element_xpath).sendKeys(CategoryName);
									}catch(Exception e){}
								}
								else if (myattributename.equalsIgnoreCase("CountryCode"))
								{
									try
									{
										String CountryArr[]=Country.split(",");
										for(int country_i=0;country_i<CountryArr.length;country_i++)
										{
											utilfunc.Selectdropdownvaluebytext(Current_Element_xpath, CountryArr[country_i]);
											utilfunc.MakeElement(Add_Country_Btn).click();
										}
									}catch(Exception e){}
								}

							}
							catch(Exception e){}
						}

					}
				}
				catch(Exception e)
				{
					System.out.println("Error :"+e);
				}
			
				//Save btn click code start here			
				try{			
					utilfunc.MakeElement(Save_Btn).click();
					}catch(Exception e){System.out.println("Error while click on save button");}
				try{
					
					String  error_flag="";
					try{
						error_flag=utilfunc.ErrorMessagehandlerExperiment();}
					catch(Exception e){}
					
					System.out.println("error_flag is :"+error_flag);
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.equals("")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						utilfunc.TakeScreenshot();
						webdriver.navigate().back();
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}
				}
				catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
				}
			
			}
			
		
//Edit and delete mode Start here 			
			if(mode.equals("Edit"))
			{
				System.out.println("we are going to edit");
				Thread.sleep(1000);
				int Search_Result_rows_count=utilfunc.GetObjectCount(Search_Result_rows_count_xpath);
				//check is there any record or not
				String gettxt=utilfunc.MakeElement(Search_Result_record_foundORnot_xpath).getText();
				if(gettxt.equalsIgnoreCase("No Data Found!"))
				{
					//no record found
					Flag=false;
					utilfunc.TakeScreenshot();
					utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";
					return Flag;
				}
				else
				{
					//record found
					Thread.sleep(1000);
								try {
									utilfunc.MakeElement(Edit_icon).click(); Thread.sleep(1000);
								} catch (Exception e) {System.out.println("error while click edit icon");}
								
								try{
									//get element row count
									int Form_Fields_Count=utilfunc.GetObjectCount(Form_Fields_Count_Xpath);

									for(int w=1;w<=Form_Fields_Count;w++)
									{
										Thread.sleep(1000);
										String Current_Element_xpath=Element_xpath.replaceAll("xx", Integer.toString(w));
										String myattributename="";
										try{myattributename	=	utilfunc.MakeElement(Current_Element_xpath).getAttribute("name");}catch(Exception e){}
										if(!myattributename.equals(""))
										{
											try
											{
												if (myattributename.equalsIgnoreCase("PurposeCategoryName"))
												{
													try
													{
														utilfunc.MakeElement(Current_Element_xpath).clear();
														utilfunc.MakeElement(Current_Element_xpath).sendKeys(CategoryName);
													}catch(Exception e){}
												}
												else if (myattributename.equalsIgnoreCase("CountryCode"))
												{
													try
													{
														
														//delete last added country
														int lastadded_contry_cunt = utilfunc.GetObjectCount(allready_added_countery_count);
														for(int m=2;m<=lastadded_contry_cunt;m++)
														{
															Thread.sleep(300);
															try{
																utilfunc.MakeElement(AllreadyAddedCountyDelBtn).click();
																Thread.sleep(300);
																Alert alt= webdriver.switchTo().alert();
																alt.accept();
															}catch(Exception e){}
														}
														
														
														//now add fresh country
														String CountryArry[]=Country.trim().split(",");
														for(int country_i=0;country_i<CountryArry.length;country_i++)
														{
															Thread.sleep(300);
															try{utilfunc.Selectdropdownvaluebytext(Current_Element_xpath, CountryArry[country_i]);}catch(Exception e){}
															Thread.sleep(300);
															utilfunc.MakeElement(Add_Country_Btn).click();
														}
													}catch(Exception e){}
												}

											}
											catch(Exception e){}
										}

									}
								}
								catch(Exception e)
								{
									System.out.println("Error :"+e);
								}
								
							}
							
						
						
//Save btn click code start here			
			try{			
				utilfunc.MakeElement(Save_Btn).click();
				}catch(Exception e){System.out.println("Error while click on save button");}
			try{
				
				String  error_flag="";
				try{
					error_flag=utilfunc.ErrorMessagehandlerExperiment();}
				catch(Exception e){}
				
				System.out.println("error_flag is :"+error_flag);
				if (error_flag.equals(ExpectedErrorMessage)){
					Flag=true;
					utilfunc.TakeScreenshot();
				}else if (error_flag.equals("")){
					Flag=true;
				}else if(error_flag.equals("Server Error in '/' Application.")){
					Flag=false;
					utilfunc.TakeScreenshot();
					webdriver.navigate().back();
				}else{
					Flag=false;
					utilfunc.TakeScreenshot();
				}
			}
			catch(Exception e){
				Flag	=	false;
				System.out.println("Data is not saved. Some error occured. Error Description :\n"+e+"\n");
			}
			}
			
			if(mode.equals("Delete"))
			{
				Thread.sleep(1000);
				
				try {
					int Search_Result_rows_count=utilfunc.GetObjectCount(Search_Result_rows_count_xpath);
					//check is there any record or not
					String gettxt=utilfunc.MakeElement(Search_Result_record_foundORnot_xpath).getText();
					if(gettxt.equalsIgnoreCase("No Data Found!"))
					{
						//no record found
						Flag=false;
						utilfunc.TakeScreenshot();
						utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";
						return Flag;
					}
					else
					{
					try{
					utilfunc.MakeElement(delete_icon).click();
					Thread.sleep(800);
					Alert alt= webdriver.switchTo().alert();
					alt.accept();}catch(Exception e){}
					
					String  error_flag="";
					try{
						error_flag=utilfunc.ErrorMessagehandlerExperiment();}
					catch(Exception e){}
					
					System.out.println("error_flag is :"+error_flag);
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.equals("")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						utilfunc.TakeScreenshot();
						webdriver.navigate().back();
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}
					
					}
				} catch (Exception e) {System.out.println("error while click delete icon");}
				
			}
			
		}//if(TestcaseRunMode.equals("Y")) ends here

		return Flag;

	}//public boolean Add_PurposeCategories ends here


}//public class CIMS_Company_PurposeCategories ends here