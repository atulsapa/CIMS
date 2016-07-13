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

import org.junit.experimental.categories.Categories;
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



public class CIMS_Company_VisaProfile {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	
	public CIMS_Company_VisaProfile(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean VisaProfile(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on Visa Profile module");
		boolean Flag	=	false;

		
		//excel data sheet collection..
				String 	TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String 	TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String 	Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String 	TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String 	CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String	UseCustomVisaPurposeOfVisit					=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String	UseVisaPurposeOfVisitCategory				=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String	RefGroup									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String	Description									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String	ParentPurposeId								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String	LongDescription								=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String	PurposeCategory								=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String	EditDescription									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String	EditParentPurposeId								=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String	EditLongDescription								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String	EditPurposeCategory								=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				
				String 	ExpectedErrorMessage						=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					
					System.out.println("entering "+mode+" mode for "+sheetName+" module");

					String UseCustomVisaPurposeOfVisitXPath		=	"";

							if(UseCustomVisaPurposeOfVisit.equalsIgnoreCase("Yes")){
								utilfunc.MakeElement("//*[@name='UseCustomVisaPurposeOfVisit' and @value='True']").click();
							}else{
								utilfunc.MakeElement("//*[@name='UseCustomVisaPurposeOfVisit' and @value='False']").click();
							}
						}
							if(UseVisaPurposeOfVisitCategory.equalsIgnoreCase("Yes")){
								utilfunc.MakeElement("//*[@name='UseVisaPurposeOfVisitCategory' and @value='True']").click();
							}else{
								utilfunc.MakeElement("//*[@name='UseVisaPurposeOfVisitCategory' and @value='False']").click();
							}
							
							if(RefGroup!=null){
								utilfunc.Selectdropdownvaluebytext("//*[@name='RefGroup']", RefGroup);
							}

							System.out.println("now let us wait in order to filter the result according to country");
							Thread.sleep(1500);

					
						if(mode.equals("New")){
							Thread.sleep(2000);
							
							String AddNewBtnXpath	=	"//a[contains(@class,'btn') and contains(text(),'Add New Purpose')]"; // and id='btnAddNew'
							utilfunc.MakeElement(AddNewBtnXpath).click();
							System.out.println("User is now about to add visa profile");
							
						}else if(mode.equals("Edit") || mode.equals("Delete")){
							Thread.sleep(2000);
//
							System.out.println("User has entered "+mode+" mode");
							// just to reduce loops let us select country first
//							System.out.println("just to reduce loops let us select country first");
//							utilfunc.Selectdropdownvaluebytext("//*[@name='RefGroup']", RefGroup);


//							//*[@id='dvReport']//*[@class='table-rec-container']//table//tbody//tr[position() mod 2 = 1 and position() > 1]
							String VisaProfileListCounterXPath		=	"//*[@id='dvReport']//*[@class='table-rec-container']//table//tbody//tr";
							String VisaProfileListXPath				=	"//*[@id='dvReport']//*[@class='table-rec-container']//table/tbody/tr[yy]";
							
							int rCount	=	utilfunc.GetObjectCount(VisaProfileListCounterXPath);
							String EditXpath						=	"";
							String DescriptionList					=	null;
							String CompanyPurposeList				=	null;
							String GenericPurposeList				=	null;
							
							for(int a=1;a<=rCount;a++){
								Thread.sleep(2000);

								String CategoriesList					=	"";
								System.out.println("checking for number "+ a);
								
								String NewXPath							=	VisaProfileListXPath.replace("yy", Integer.toString(a));

								if(a%2==0){

									if(PurposeCategory!=null){
										////*[@id='dvReport']//*[@class='table-rec-container']//table//tbody//tr[10]//td//div//div//div[1]//ul//li
										String CategoriesListXPath	=	NewXPath+"//td//div//div//div[1]//ul//li";
										int	catCount				=	utilfunc.GetObjectCount(CategoriesListXPath);
										for(int cc=1;cc<=catCount;cc++){
											Thread.sleep(2000);
											CategoriesList					=	CategoriesList 	+ ";" +	utilfunc.MakeElement(CategoriesListXPath+"["+Integer.toString(cc)+"]").getText();
										}
//										System.out.println("category list: " + CategoriesList.substring(1));
										CategoriesList		=	(CategoriesList.length()>2) ? CategoriesList.trim().substring(1) : CategoriesList.trim();

									}
									if(LongDescription!=null){
										DescriptionList					=	utilfunc.MakeElement(NewXPath+"//td//div//div//div[2]").getText();
										String[] desc					=	DescriptionList.split("\n");
										DescriptionList					=	desc[1].trim();
										System.out.println("now we have collected 2 rows and all 4 variable let us compare and proceed with "+mode + " mode");
									}

									System.out.println("purpose: " + PurposeCategory );
									System.out.println( "catg list: "	+CategoriesList );
									System.out.println("long desc: " + LongDescription );
									System.out.println( "Descrp " + DescriptionList );
									System.out.println( "comp prps list" + CompanyPurposeList );
									System.out.println( "desc: " + Description );
									System.out.println( "generic " +	GenericPurposeList );
									System.out.println( "parentpurpose: " + (ParentPurposeId) );
									
									if(PurposeCategory.equals(CategoriesList) && LongDescription.equalsIgnoreCase(DescriptionList)
											 && CompanyPurposeList.equalsIgnoreCase(Description) && GenericPurposeList.equalsIgnoreCase(ParentPurposeId)){
										if(mode.equals("Edit")){
											Thread.sleep(2000);
											System.out.println("Record found in the list, now let us open the same for edit");
											EditXpath	=	NewXPath.replace("["+a+"]", "["+(a-1)+"]")+""+"/td[4]//*[@class='icon-edit']";
											System.out.println("Editpath: "+EditXpath);
											try{
												Thread.sleep(2000);
												utilfunc.MakeElement(EditXpath).click();
												System.out.println("clicked on edit icon successfully!");
												Thread.sleep(1000);
												break;
											}catch(Exception e){
												System.out.println("unable to click on edit icon of the record");
											}
										}else if(mode.equals("Delete")){
											Thread.sleep(2000);
	
											System.out.println("Record found in the list, now let us delete the record");
											String BatchListDeleteXPath	=	NewXPath.replace("["+a+"]", "["+(a-1)+"]")+""+"/td[4]//*[@class='icon-trash']";
											Thread.sleep(2000);
											try{
												utilfunc.MakeElement(BatchListDeleteXPath.trim()).click();
												Thread.sleep(2000);
//												utilfunc.isAlertPresent();
												System.out.println("record deleted succesfully!");
												
											}catch(Exception s){
												Flag	=	false;
												System.out.println("unable to delete record successfully!");
											}
											return Flag;

										}
									}
									
								}else{

									CompanyPurposeList				=	utilfunc.MakeElement(NewXPath+"/td[1]").getText();
									GenericPurposeList				=	utilfunc.MakeElement(NewXPath+"/td[3]").getText();

								}
								}
							}

						if(mode.equals("New")){
							try{
									String InnerFormFieldCounterXPath					=		".//*[@id='form1']//*[@class='control-group']";
									String InnerFormFieldXPath							=		".//*[@id='form1']//*[@class='control-group'][gg]//*[@class='controls']//*[@name]";
	
									int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);
	
									for(int r=1;r<=innerCount;r++){
										Thread.sleep(2000);
	
										String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
										String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
										
										if(AttributeName.equals("Description")){
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(Description);
										}
										else if(AttributeName.equals("ParentPurposeId")){
											try{
											utilfunc.Selectdropdownvaluebytext(NewFieldXPath, ParentPurposeId);
										}catch(Exception error){}}
										else if(AttributeName.equals("LongDescription")){
											utilfunc.MakeElement(NewFieldXPath).clear();
											utilfunc.MakeElement(NewFieldXPath).sendKeys(LongDescription);
										}
										else if(AttributeName.equals("PurposeCategory")){
	
											// for loop for more than one values
											String[]	PurposeCategories	=	PurposeCategory.split(";");
											if(PurposeCategories.length>1){
												int ar	=	1;
												try{
												for(String purCat	:	PurposeCategories ){
													Thread.sleep(2000);
													utilfunc.Selectdropdownvaluebytext(NewFieldXPath, purCat);
													utilfunc.MakeElement("//a[contains(@class,'btn') and contains(text(),'Add')]").click(); // click add
													ar++;
												}}catch(Exception error ){}
											}
										}
	
									}

								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to excute Visa profile");
								}
						}
						if(mode.equals("Edit"))
						try{
							String InnerFormFieldCounterXPath					=		".//*[@id='form1']//*[@class='control-group']";
							String InnerFormFieldXPath							=		".//*[@id='form1']//*[@class='control-group'][gg]//*[@class='controls']//*[@name]";

							int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);

							for(int r=1;r<=innerCount;r++){
								Thread.sleep(2000);

								String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
								String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");
								
								if(AttributeName.equals("Description")){
									utilfunc.MakeElement(NewFieldXPath).clear();
									utilfunc.MakeElement(NewFieldXPath).sendKeys(EditDescription);
								}
								else if(AttributeName.equals("ParentPurposeId")){
									try{
									utilfunc.Selectdropdownvaluebytext(NewFieldXPath, EditParentPurposeId);
								}catch(Exception error){}}
								else if(AttributeName.equals("LongDescription")){
									utilfunc.MakeElement(NewFieldXPath).clear();
									utilfunc.MakeElement(NewFieldXPath).sendKeys(EditLongDescription);
								}
								else if(AttributeName.equals("PurposeCategory")){

									// for loop for more than one values
									String[]	PurposeCategories	=	EditPurposeCategory.split(";");
									if(PurposeCategories.length>1){
										int ar	=	1;
										try{
										for(String purCat	:	PurposeCategories ){
											Thread.sleep(2000);
											utilfunc.Selectdropdownvaluebytext(NewFieldXPath, purCat);
											utilfunc.MakeElement("//a[contains(@class,'btn') and contains(text(),'Add')]").click(); // click add
											ar++;
										}}catch(Exception error ){}
									}
								}

							}

						}catch(Exception e){
							Flag	=	false;
							System.out.println("Unable to excute Visa profile");
						}
							
							
						
//						if(Flag==true){

						 try{
							 // save button after saving all data..
							String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		    	        	utilfunc.MakeElement(saveBtn).click();
							System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed");
						 }catch(Exception e){}
						 try{
							String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
						}catch(Exception e){
							Flag	=	false;
							System.out.println("Data is not saved because all fields are not set in the form.");
						}//						}
//					}
//				}		
							 /**
								 * scroll to top in order to catch the company slider icon
								 */
								utilfunc.scrollToTop();
		return Flag;
	}
}
