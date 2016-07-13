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

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;

public class CIMS_Company_Document {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_Company_Document(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Company_Document(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{
		System.out.println("User is on "+sheetName+" Module.");
		boolean Flag	=	false;

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String Company_Description							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Document_Name								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String Document_Type								=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String Document_Type_edit							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String Document_Visibility							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String Region										=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String Country										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		String Country_Edit									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
		String Business_Unit								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		String Entity										=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
		String Fileupload									= 			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
		String ExpectedErrorMessage							= 			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);

		//System.out.println(Fileupload);

		if(TestcaseRunMode.equals("Y")){

			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			testcasedescription = Company_Description;

			if(mode.equalsIgnoreCase("New")){
				System.out.println("User is now on "+sheetName+".");
				/////////////////upload////////////////////////////////////

				String showbuttonxpath=".//*[@id='btnShowDocUpload']"; //Add documents 
				String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
				String fileuploadpath="";
				if(CIMS_MainProject.os.contains("Linux")){
					String msms=System.getProperty("user.dir");
					//System.out.println(msms);
					fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
					//System.out.println("\n"+fileuploadpath+"\n");
				}else if(CIMS_MainProject.os.contains("Windows")){
					fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
				}
				String fileuploadbutton=".//*[@id='btnUploadDocuments']";
				try{
					utilfunc.MakeElement(showbuttonxpath).click();
					Thread.sleep(2000);
					utilfunc.MakeElement(uploadbuttonxpath).click();
					Thread.sleep(1000);    
					utilfunc.uploadfile(fileuploadpath);
					Thread.sleep(2000);
					//now set values in fields
					String CounterXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group']";
					String xpath2=".//*[@class='editUploadControls'][1]//*[@class='control-group'][xxx]//*[@class='controls']//*[@name]";
					String xpath1=".//*[@class='editUploadControls'][1]//*[@class='control-group'][yyy]//*[@class='controls']//*[contains(@class,'btn-primary') and text()='Add']";
					int count_no=utilfunc.GetObjectCount(CounterXpath);
					String myattributename="";
					try{
						for(int i=1;i<=count_no;i++)
						{
							Thread.sleep(1000);
							String NewXpath=xpath2.replace("xxx", Integer.toString(i));
							String AddXpath=xpath1.replace("yyy", Integer.toString(i));
							try{myattributename	=	utilfunc.MakeElement(NewXpath).getAttribute("name");}catch(Exception error){}
							//						System.out.println(NewXpath);
							//						System.out.println(AddXpath);
							//						System.out.println(myattributename);
							if (myattributename.equalsIgnoreCase("fld-title"))
							{
								utilfunc.MakeElement(NewXpath).sendKeys(Document_Name);
							}
							else if (myattributename.equalsIgnoreCase("fld-documentType"))
							{//System.out.println("we are here");
								String doc_NewXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group'][xxx]//*[@class='controls']//select[@name]";
								doc_NewXpath=doc_NewXpath.replace("xxx", Integer.toString(i));
								if(StringUtils.isEmpty(Document_Type)==false){
									String[] split = Document_Type.split(",");
									System.out.println(split.length);
									for (int doc_type = 0; doc_type < split.length; doc_type++) {
										//System.out.println(doc_NewXpath);
										System.out.println(split[doc_type].trim()+"---");
										Thread.sleep(400);
										utilfunc.Selectdropdownvaluebytext(doc_NewXpath,split[doc_type].trim());
										utilfunc.MakeElement(AddXpath).click();
									}
								}
							}
							else if (myattributename.equalsIgnoreCase("fld-documentHighSecurity"))
							{
								utilfunc.Selectdropdownvaluebytext(NewXpath,Document_Visibility);
							}
							else if (myattributename.equalsIgnoreCase("fld-region"))
							{//System.out.println("we are here");
								String region_NewXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group'][xxx]//*[@class='controls']//select[@name]";
								region_NewXpath=region_NewXpath.replace("xxx", Integer.toString(i));
								if(StringUtils.isEmpty(Region)==false){
									String[] split = Region.split(",");
									System.out.println(split.length);
									for (int region_type = 0; region_type < split.length; region_type++) {
										System.out.println(split[region_type].trim()+"---");
										Thread.sleep(400);
										utilfunc.Selectdropdownvaluebytext(region_NewXpath,split[region_type].trim());
										utilfunc.MakeElement(AddXpath).click();
									}
								}
							}
							else if (myattributename.equalsIgnoreCase("fld-country"))
							{//System.out.println("we are here");
								String country_NewXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group'][xxx]//*[@class='controls']//select[@name]";
								country_NewXpath=country_NewXpath.replace("xxx", Integer.toString(i));
								if(StringUtils.isEmpty(Country)==false){
									String[] split = Country.split(",");
									System.out.println(split.length);
									for (int country_type = 0; country_type < split.length; country_type++) {
										System.out.println(split[country_type].trim()+"---");
										Thread.sleep(400);
										utilfunc.Selectdropdownvaluebytext(country_NewXpath,split[country_type].trim());
										utilfunc.MakeElement(AddXpath).click();
									}
								}
							}
							else if (myattributename.equalsIgnoreCase("fld-businessUnit"))
							{//System.out.println("we are here");
								String Business_Unit_NewXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group'][xxx]//*[@class='controls']//select[@name]";
								Business_Unit_NewXpath=Business_Unit_NewXpath.replace("xxx", Integer.toString(i));
								if(StringUtils.isEmpty(Business_Unit)==false){
									String[] split = Business_Unit.split(",");
									System.out.println(split.length);
									for (int bu= 0; bu < split.length; bu++) {
										System.out.println(split[bu].trim()+"---");
										Thread.sleep(400);
										utilfunc.Selectdropdownvaluebytext(Business_Unit_NewXpath,split[bu].trim());
										utilfunc.MakeElement(AddXpath).click();
									}
								}
							}
							else if (myattributename.equalsIgnoreCase("fld-entity"))
							{//System.out.println("we are here");
								String entity_NewXpath=".//*[@class='editUploadControls'][1]//* [@class='control-group'][xxx]//*[@class='controls']//select[@name]";
								entity_NewXpath=entity_NewXpath.replace("xxx", Integer.toString(i));
								if(StringUtils.isEmpty(Entity)==false){
									String[] split = Entity.split(",");
									System.out.println(split.length);
									for (int ent= 0; ent < split.length; ent++) {
										System.out.println(split[ent].trim()+"---");
										Thread.sleep(400);
										utilfunc.Selectdropdownvaluebytext(entity_NewXpath,split[ent].trim());
										utilfunc.MakeElement(AddXpath).click();
									}
								}
								//	utilfunc.Selectdropdownvaluebytext(NewXpath,Entity);
								//	utilfunc.MakeElement(AddXpath).click();
							}
						}
					}
					catch(Exception error){}
					
					Thread.sleep(2000);
					System.out.println("We are going to click Save or final button for the module.");
					Thread.sleep(2000);
					try{

						try{
							DocumentPopupScrollDown();
							utilfunc.MakeElement(fileuploadbutton).click();// Save or click upload....
							System.out.println("We clicked Save or final button for the module.");
							Thread.sleep(7000);
							DocumentPopupScrollDown();
							
						}catch(Exception error){System.out.println("Unable to click upload button");}

						String  error_flag="";
						
						try{
							error_flag=utilfunc.ErrorMessagehandlerExperiment();
							System.out.println("error_flag is :"+error_flag);
						}catch(Exception e){}
						
						
						
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
					}catch(Exception e){
						Flag	=	false;
						System.out.println("Data is not saved. Some error occured.");
					}
				}catch(Exception e){System.out.println("Error occured : "+ e);}
				//System.out.println("We are done :)\n:)");
			}
			if(mode.equalsIgnoreCase("Edit"))
			{
				//int flag=0;
				try
				{
					System.out.println("Search code start here....");
					// set value for search in doc type
					if(StringUtils.isEmpty(Document_Type)==false){//if doc type is not empty
						String[] split = Document_Type.split(",");//split the Document_Type string by ,
						if(split.length>=1){
							utilfunc.Selectdropdownvaluebytext(".//*[@id='sDocumentType']", split[0].trim());//set first element of Document_Type string in dropdown for Search
						}
					}
					else{utilfunc.Selectdropdownvaluebytext(".//*[@id='sDocumentType']", Document_Type);}
					utilfunc.scrollToTop();
					Thread.sleep(1000);
					// set value for search in country type
					if(StringUtils.isEmpty(Country)==false){//if country type is not empty
						String[] split = Country.split(",");//split the Country string by ,
						if(split.length>=1){
							utilfunc.Selectdropdownvaluebytext(".//*[@id='sCountry']", split[0].trim());//set first element of Country string in dropdown for Search
						}
					}
					else{utilfunc.Selectdropdownvaluebytext(".//*[@id='sCountry']", Country);}
					utilfunc.scrollToTop();
					Thread.sleep(3000);
					//click on Search button
					utilfunc.MakeElement(".//*[contains(@id,'btnSearch') and text()='Search']").click();
					Thread.sleep(3000);//wait for 3 sec for filter the result.

					utilfunc.scrollToTop();
					// Now get data from result

					int result_count_tr=utilfunc.GetObjectCount(".//*[@id='documentsList']/tbody/tr");
					//System.out.println(result_count_tr);
					Thread.sleep(1000);

					String gettxt=utilfunc.MakeElement(".//*[@id='documentsList']/tbody/tr[1]/td[1]").getText();
					if(gettxt.contains("No data available in table"))
					{
						Flag=false;
						utilfunc.TakeScreenshot();
						utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";
						return Flag;
					}
					else{


						boolean flag1=false;boolean flag2=false;boolean flag3=false;
						for(int i=1;i<=result_count_tr;i++)
						{
							String xpath1=".//*[@id='documentsList']/tbody/tr["+i+"]/td";
							//System.out.println(xpath1);
							int result_count_td= utilfunc.GetObjectCount(xpath1);
							System.out.println("Current value of i is "+i+" and this row have "+result_count_td+" column.");
							Thread.sleep(200);
							for(int j=1;j<=result_count_td;j++)
							{
								Thread.sleep(1000);

								//System.out.println("This is "+i+" row "+j+" column.");
								String Xpath=xpath1+"["+j+"]";
								//System.out.println(Xpath);
								String get_result_value="";
								try{get_result_value=utilfunc.MakeElement(Xpath).getText();}catch(Exception error){}
								System.out.println("---"+get_result_value+"---");	
								//if record not found
								if(get_result_value.equalsIgnoreCase("No data available in table"))
								{break;}
								else
								{
									String Xpath5=xpath1+"[6]//*[contains(@class,'icon-edit')]";
									//System.out.println(Xpath5);
									//Thread.sleep(1000);
									utilfunc.MakeElement(Xpath5).click(); // Click edit button. // Now we are going to edit the values in pop-up window.
									Thread.sleep(1000);// Waiting for 1 second till pop-up window will be visible & control goes to it.
									//System.out.println("We are on popup window.");
									String edit_xpath_1=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group']";
									int edit_count_tr=utilfunc.GetObjectCount(edit_xpath_1);
									String myattributename="";
									if(flag3!=true)
									{
										for(int w=1;w<=edit_count_tr;w++)
										{
											//System.out.println("Current value of w is : "+w);
											try
											{
												String edit_xpath_2=edit_xpath_1+"["+w+"]";
												String edit_xpath_3=edit_xpath_2+"//*[@class='controls']//*[@name]";
												String edit_xpath_4=edit_xpath_2+"//*[@class='controls']//*[@class='iRow']";
												String edit_xPath_5=edit_xpath_2+"//*[@class='controls']//*[contains(@class,'btn-primary') and text()='Add']";	
												try{myattributename	=	utilfunc.MakeElement(edit_xpath_3).getAttribute("name");}catch(Exception error){}
												//												System.out.println("\n"+edit_xpath_3);
												//												System.out.println("\n"+myattributename);
												//												Thread.sleep(100);
												if (myattributename.equalsIgnoreCase("fld-title")||myattributename.equalsIgnoreCase("title")){
													utilfunc.MakeElement(edit_xpath_3).clear();
													utilfunc.MakeElement(edit_xpath_3).sendKeys(Document_Name);
												}
												else if (myattributename.equalsIgnoreCase("DocTypes")||myattributename.equalsIgnoreCase("fld-DocTypes")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													int del_Doc_type=utilfunc.GetObjectCount(del_Xpath);
													System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
													if (del_Doc_type>=1){//if added doc type is more then one then we have to delete them...
														for(int d=1;d<=del_Doc_type;d++){
															int del_Doc_type2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_Doc_type2+"]//*[@href]";
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													String doc_NewXpath=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group'][xxx]//*[@class='controls']//select[@name]";
													doc_NewXpath=doc_NewXpath.replace("xxx", Integer.toString(w));
													if(StringUtils.isEmpty(Document_Type_edit)==false){
														String[] split = Document_Type_edit.split(",");
														for (int doc_type = 0; doc_type < split.length; doc_type++) {
															//System.out.println(doc_NewXpath);
															utilfunc.Selectdropdownvaluebytext(doc_NewXpath,split[doc_type].trim());
															utilfunc.MakeElement(edit_xPath_5).click();
														}
													}
												}
												else if(myattributename.equalsIgnoreCase("fld-documentHighSecurity")||myattributename.equalsIgnoreCase("documentHighSecurity")){
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Visibility);
												}
												else if (myattributename.equalsIgnoreCase("region")||myattributename.equalsIgnoreCase("fld-region")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													String editpath=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group'][xxx]//*[@class='controls']//select[@name]";
													editpath=editpath.replace("xxx", Integer.toString(w));
													if(StringUtils.isEmpty(Region)==false){
														String[] split = Region.split(",");
														for (int edit_count = 0; edit_count < split.length; edit_count++) {
															//System.out.println(doc_NewXpath);
															utilfunc.Selectdropdownvaluebytext(editpath,split[edit_count].trim());
															utilfunc.MakeElement(edit_xPath_5).click();
														}
													}
												}
												else if (myattributename.equalsIgnoreCase("fld-country")||myattributename.equalsIgnoreCase("Country")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													String editpath=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group'][xxx]//*[@class='controls']//select[@name]";
													editpath=editpath.replace("xxx", Integer.toString(w));
													if(StringUtils.isEmpty(Country_Edit)==false){
														String[] split = Country_Edit.split(",");
														for (int edit_count = 0; edit_count < split.length; edit_count++) {
															//System.out.println(doc_NewXpath);
															utilfunc.Selectdropdownvaluebytext(editpath,split[edit_count].trim());
															utilfunc.MakeElement(edit_xPath_5).click();
														}
													}
												}
												else if (myattributename.equalsIgnoreCase("fld-businessUnit")||myattributename.equalsIgnoreCase("BusinessUnit")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													String editpath=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group'][xxx]//*[@class='controls']//select[@name]";
													editpath=editpath.replace("xxx", Integer.toString(w));
													if(StringUtils.isEmpty(Business_Unit)==false){
														String[] split = Business_Unit.split(",");
														for (int edit_count = 0; edit_count < split.length; edit_count++) {
															//System.out.println(doc_NewXpath);
															utilfunc.Selectdropdownvaluebytext(editpath,split[edit_count].trim());
															utilfunc.MakeElement(edit_xPath_5).click();
														}
													}
												}
												else if (myattributename.equalsIgnoreCase("fld-entity")||myattributename.equalsIgnoreCase("Entity")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													String editpath=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group'][xxx]//*[@class='controls']//select[@name]";
													editpath=editpath.replace("xxx", Integer.toString(w));
													if(StringUtils.isEmpty(Entity)==false){
														String[] split = Entity.split(",");
														for (int edit_count = 0; edit_count < split.length; edit_count++) {
															//System.out.println(doc_NewXpath);
															utilfunc.Selectdropdownvaluebytext(editpath,split[edit_count].trim());
															utilfunc.MakeElement(edit_xPath_5).click();
														}
													}
												}
											}//try  ends
											catch(Exception er){}
										}
										try{
											String save_btn=".//*[@id='btnDocDetailSave']";

											//flag3=true;


											try{
												
												DocumentPopupScrollDown();
												utilfunc.MakeElement(save_btn).click();// Save or click upload....
												System.out.println("We clicked Save or final button for the module.");
												Thread.sleep(7000);
												DocumentPopupScrollDown();
											}catch(Exception error){}
										

											String  error_flag="";
											try{error_flag=utilfunc.ErrorMessagehandlerExperiment();}
											catch(Exception e){}
											//Thread.sleep(1000);
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
										catch(Exception e){
											Flag	=	false;
											System.out.println("Data is not saved. Some error occured.");
										}
									}

								}
								/*
							if((i==1)&&(j==1))
							{
								if((get_result_value.equalsIgnoreCase("No data available in table")==false)&&(StringUtils.isEmpty(Document_Type)))
								{
									System.out.println("Value of i is :"+i);
									System.out.println("Value of j is :"+j);
									System.out.println("Value of get_result_value.equalsIgnoreCase(\"No data available in table\") is :"+get_result_value.equalsIgnoreCase("No data available in table"));
									System.out.println("Value of StringUtils.isEmpty(Document_Type) is :"+StringUtils.isEmpty(Document_Type));

									String Xpath5=xpath1+"[6]/*[@href]";
									//System.out.println(Xpath5);
									//Thread.sleep(1000);
									utilfunc.MakeElement(Xpath5).click(); // Click edit button. // Now we are going to edit the values in pop-up window.
									Thread.sleep(1000);// Waiting for 1 second till pop-up window will be visible & control goes to it.
									//System.out.println("We are on popup window.");
									String edit_xpath_1=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group']";
									int edit_count_tr=utilfunc.GetObjectCount(edit_xpath_1);
									String myattributename="";
									if(flag3!=true)
									{
										for(int w=1;w<=edit_count_tr;w++)
										{
											//System.out.println("Current value of w is : "+w);
											try
											{
												String edit_xpath_2=edit_xpath_1+"["+w+"]";
												String edit_xpath_3=edit_xpath_2+"//*[@class='controls']//*[@name]";
												String edit_xpath_4=edit_xpath_2+"//*[@class='controls']//*[@class='iRow']";
												String edit_xPath_5=edit_xpath_2+"//*[@class='controls']//*[@href]";	
												try{myattributename	=	utilfunc.MakeElement(edit_xpath_3).getAttribute("name");}catch(Exception error){}
												//												System.out.println("\n"+edit_xpath_3);
												//												System.out.println("\n"+myattributename);
												//												Thread.sleep(100);
												if (myattributename.equalsIgnoreCase("fld-title")||myattributename.equalsIgnoreCase("title")){
													utilfunc.MakeElement(edit_xpath_3).clear();
													utilfunc.MakeElement(edit_xpath_3).sendKeys(Document_Name);
												}
												else if (myattributename.equalsIgnoreCase("DocTypes")||myattributename.equalsIgnoreCase("fld-DocTypes")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_Doc_type=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_Doc_type);
													if (del_Doc_type>=1)//if added doc type is more then one then we have to delete them...
													{
														for(int d=1;d<=del_Doc_type;d++)
														{
															int del_Doc_type2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_Doc_type2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Type_edit);
													//System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if(myattributename.equalsIgnoreCase("fld-documentHighSecurity")||myattributename.equalsIgnoreCase("documentHighSecurity")){
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Visibility);
												}
												else if (myattributename.equalsIgnoreCase("region")||myattributename.equalsIgnoreCase("fld-region")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Region);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-country")||myattributename.equalsIgnoreCase("Country")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Country_Edit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-businessUnit")||myattributename.equalsIgnoreCase("BusinessUnit")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Business_Unit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-entity")||myattributename.equalsIgnoreCase("Entity")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Entity);
													//System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
											}//try  ends
											catch(Exception er){}
										}
										try{
											//String save_btn=".//*[@id='btnDocDetailSave']";
											//	utilfunc.MakeElement(save_btn).click();// Click save button after saving all data..
											flag3=true;
											System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
											String  error_flag="";
											try{
												error_flag=utilfunc.ErrorMessagehandlerExperiment();}
											catch(Exception e){}
											//Thread.sleep(1000);
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
										}catch(Exception e){
											Flag	=	false;
											System.out.println("Data is not saved. Some error occured.");
										}
									}

									break;


								}

							}
							/*Here we check is this first row and first column (for first row)
								 * if it is then we check Document_type is empty and first row,first column is not having value "No data available in table", then we edit first record.
								 * 
								 * ENDS HERE
								 * 
								 */

								/*	try{
								//if get_result_value=="no record found" (Not same but similar) then no need to execute further. Means no data found so what we'll edit.
								if(get_result_value.equalsIgnoreCase("No data available in table"))
								{break;}
								//Get result values and compare those with our search values.
								if((get_result_value!="")&&(j!=1)){
								if(Document_Name==""){Document_Name="--";}
								if(get_result_value.equalsIgnoreCase(Document_Name))
								{flag1=true;}
								else if(get_result_value.equalsIgnoreCase(Document_Type))
								{flag2=true;}
								//Check record found or not using if else condition. Code start right now for the same.
								if((flag1==true)&&(flag2==true))
								{
									flag=1; // Record found.
								}
								else
								{
									flag=0; // Record not found.
								}
								// If record found then click on the edit button. 
								if(flag==1)
								{
									String Xpath5=xpath1+"["+(result_count_td-1)+"]/*[@href]";
									System.out.println(Xpath5);
									Thread.sleep(1000);
									utilfunc.MakeElement(Xpath5).click(); // Click edit button.

									// Now we are going to edit the values in pop-up window.
									Thread.sleep(1000);// Waiting for 1 second till pop-up window will be visible & control goes to it.
									System.out.println("We are on popup window.");
									String edit_xpath_1=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group']";
									int edit_count_tr=utilfunc.GetObjectCount(edit_xpath_1);
									String myattributename="";
									if(flag3!=true)
									{
										for(int w=1;w<=edit_count_tr;w++)
										{
											System.out.println("Current value of w is : "+w);
											try
											{
												String edit_xpath_2=edit_xpath_1+"["+w+"]";
												String edit_xpath_3=edit_xpath_2+"//*[@class='controls']//*[@name]";
												String edit_xpath_4=edit_xpath_2+"//*[@class='controls']//*[@class='iRow']";
												String edit_xPath_5=edit_xpath_2+"//*[@class='controls']//*[@href]";	
												try{myattributename	=	utilfunc.MakeElement(edit_xpath_3).getAttribute("name");}catch(Exception error){}
												System.out.println("\n"+edit_xpath_3);
												System.out.println("\n"+myattributename);
												Thread.sleep(100);
												if (myattributename.equalsIgnoreCase("fld-title")||myattributename.equalsIgnoreCase("title"))
												{
													utilfunc.MakeElement(edit_xpath_3).clear();
													utilfunc.MakeElement(edit_xpath_3).sendKeys(Document_Name);
												}
												else if (myattributename.equalsIgnoreCase("DocTypes")||myattributename.equalsIgnoreCase("fld-DocTypes"))
												{
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_Doc_type=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_Doc_type);
													if (del_Doc_type>=1)//if added doc type is more then one then we have to delete them...
													{
														for(int d=1;d<=del_Doc_type;d++)
														{
															int del_Doc_type2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_Doc_type2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Type_edit);
													//System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if(myattributename.equalsIgnoreCase("fld-documentHighSecurity")||myattributename.equalsIgnoreCase("documentHighSecurity"))
												{
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Visibility);
												}
												else if (myattributename.equalsIgnoreCase("region")||myattributename.equalsIgnoreCase("fld-region"))
												{
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Region);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-country")||myattributename.equalsIgnoreCase("Country")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Country_Edit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-businessUnit")||myattributename.equalsIgnoreCase("BusinessUnit"))
												{
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Business_Unit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-entity")||myattributename.equalsIgnoreCase("Entity"))
												{
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Entity);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
											}//try  ends
											catch(Exception er){}


										}

										try{
											// Click save button after saving all data..
											String save_btn=".//*[@id='btnDocDetailSave']";
											utilfunc.MakeElement(save_btn).click();
											flag3=true;
											System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario completed.");
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
										}catch(Exception e){
											Flag	=	false;
											System.out.println("Data is not saved. Some error occured.");
										}
									}
									break;
								}//if(flag==1)ends here
								else
								{
									System.out.println("Record not match so we are going to edit first record.");
									String Xpath5=xpath1+"[6]/*[@href]";
									//System.out.println(Xpath5);
									//Thread.sleep(1000);
									utilfunc.MakeElement(Xpath5).click(); // Click edit button. // Now we are going to edit the values in pop-up window.
									Thread.sleep(1000);// Waiting for 1 second till pop-up window will be visible & control goes to it.
									//System.out.println("We are on popup window.");
									String edit_xpath_1=".//*[@id='DocumentDetailModal']//*[@class='modal-body']/table//*[@class='control-group']";
									int edit_count_tr=utilfunc.GetObjectCount(edit_xpath_1);
									String myattributename="";
									if(flag3!=true)
									{
										for(int w=1;w<=edit_count_tr;w++)
										{
											//System.out.println("Current value of w is : "+w);
											try
											{
												String edit_xpath_2=edit_xpath_1+"["+w+"]";
												String edit_xpath_3=edit_xpath_2+"//*[@class='controls']//*[@name]";
												String edit_xpath_4=edit_xpath_2+"//*[@class='controls']//*[@class='iRow']";
												String edit_xPath_5=edit_xpath_2+"//*[@class='controls']//*[@href]";	
												try{myattributename	=	utilfunc.MakeElement(edit_xpath_3).getAttribute("name");}catch(Exception error){}
												//												System.out.println("\n"+edit_xpath_3);
												//												System.out.println("\n"+myattributename);
												//												Thread.sleep(100);
												if (myattributename.equalsIgnoreCase("fld-title")||myattributename.equalsIgnoreCase("title")){
													utilfunc.MakeElement(edit_xpath_3).clear();
													utilfunc.MakeElement(edit_xpath_3).sendKeys(Document_Name);
												}
												else if (myattributename.equalsIgnoreCase("DocTypes")||myattributename.equalsIgnoreCase("fld-DocTypes")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_Doc_type=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_Doc_type);
													if (del_Doc_type>=1)//if added doc type is more then one then we have to delete them...
													{
														for(int d=1;d<=del_Doc_type;d++)
														{
															int del_Doc_type2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_Doc_type2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Type_edit);
													//System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if(myattributename.equalsIgnoreCase("fld-documentHighSecurity")||myattributename.equalsIgnoreCase("documentHighSecurity")){
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Document_Visibility);
												}
												else if (myattributename.equalsIgnoreCase("region")||myattributename.equalsIgnoreCase("fld-region")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Region);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-country")||myattributename.equalsIgnoreCase("Country")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Country_Edit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-businessUnit")||myattributename.equalsIgnoreCase("BusinessUnit")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Business_Unit);
													System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
												else if (myattributename.equalsIgnoreCase("fld-entity")||myattributename.equalsIgnoreCase("Entity")){
													//try to delete last added value
													String del_Xpath=edit_xpath_4;
													//System.out.println(del_Xpath);
													int del_region=utilfunc.GetObjectCount(del_Xpath);
													//System.out.println(del_region);
													if (del_region>=1)//if added region is more then one then we have to delete them...
													{
														for(int d=1;d<=del_region;d++)
														{
															int del_region2=utilfunc.GetObjectCount(del_Xpath);
															String del_Xpath12=del_Xpath;
															del_Xpath12=del_Xpath12+"["+del_region2+"]//*[@href]";
															//System.out.println(del_Xpath12);
															utilfunc.MakeElement(del_Xpath12).click();
														}
													}
													utilfunc.Selectdropdownvaluebytext(edit_xpath_3,Entity);
													//System.out.println(edit_xPath_5);
													utilfunc.MakeElement(edit_xPath_5).click();
												}
											}//try  ends
											catch(Exception er){}
										}
										try{
											//String save_btn=".//*[@id='btnDocDetailSave']";
											//	utilfunc.MakeElement(save_btn).click();// Click save button after saving all data..
											flag3=true;
											System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
											String  error_flag="";
											try{error_flag=utilfunc.ErrorMessagehandlerExperiment();}
											catch(Exception e){}
											//Thread.sleep(1000);
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
										catch(Exception e){
											Flag	=	false;
											System.out.println("Data is not saved. Some error occured.");
										}
									}
									break;
								}}
							}
							catch(Exception error)
							{System.out.println("Some Error occur while executing comapre search result with our search values.\nError Description: "+error);}
								 */}

						}
					}
				}
				catch(Exception er)
				{
					System.out.println("Some error occur while executing edit code. Error description is :\n"+er);
				}
			}//Edit code ends here...

			if(mode.equalsIgnoreCase("Delete"))
			{
				System.out.println("Delete code start here....");
				try
				{
					System.out.println("Search code start here....");
					// set value for search in doc type
					if(StringUtils.isEmpty(Document_Type)==false){//if doc type is not empty
						String[] split = Document_Type.split(",");//split the Document_Type string by ,
						if(split.length>=1){
							utilfunc.Selectdropdownvaluebytext(".//*[@id='sDocumentType']", split[0].trim());//set first element of Document_Type string in dropdown for Search
						}
					}
					else{utilfunc.Selectdropdownvaluebytext(".//*[@id='sDocumentType']", Document_Type);}
					utilfunc.scrollToTop();
					Thread.sleep(1000);
					// set value for search in country type
					if(StringUtils.isEmpty(Country)==false){//if country type is not empty
						String[] split = Country.split(",");//split the Country string by ,
						if(split.length>=1){
							utilfunc.Selectdropdownvaluebytext(".//*[@id='sCountry']", split[0].trim());//set first element of Country string in dropdown for Search
						}
					}
					else{utilfunc.Selectdropdownvaluebytext(".//*[@id='sCountry']", Country);}
					utilfunc.scrollToTop();
					Thread.sleep(3000);
					//click on Search button
					utilfunc.MakeElement(".//*[contains(@id,'btnSearch') and text()='Search']").click();
					utilfunc.scrollToTop();
					Thread.sleep(3000);//wait for an 3 for filter the result.
					// Now get data from result

					int result_count_tr=utilfunc.GetObjectCount(".//*[@id='documentsList']/tbody/tr");
					Thread.sleep(1000);
					String gettxt=utilfunc.MakeElement(".//*[@id='documentsList']/tbody/tr[1]/td[1]").getText();
					Thread.sleep(1000);
					if(gettxt.equalsIgnoreCase("No data available in table"))
					{
						Flag=false;
						utilfunc.TakeScreenshot();
						utilfunc.ErrorMessage4=utilfunc.ErrorMessage4+"No Data Found!";
						return Flag;
					}
					else{

						//System.out.println(result_count_tr);
						//Thread.sleep(1000);
						for(int i=1;i<=result_count_tr;i++)
						{
							Thread.sleep(2000);

							String xpath1=".//*[@id='documentsList']/tbody/tr["+i+"]/td";
							String xpath2=".//*[@id='documentsList']/tbody/tr["+i+"]";
							//System.out.println(xpath1);
							int result_count_td= utilfunc.GetObjectCount(xpath1);
							System.out.println("Current value of i is "+i+" and this row have "+result_count_td+" column.");
							Thread.sleep(200);
							for(int j=1;j<=result_count_td;j++)
							{
								Thread.sleep(2000);
								System.out.println("This is "+i+" row "+j+" column.");
								String Xpath=xpath1+"["+j+"]";
								//System.out.println(Xpath);
								String get_result_value="";
								try{get_result_value=utilfunc.MakeElement(Xpath).getText();}catch(Exception error){}
								System.out.println("---"+get_result_value+"---");	
								//if record not found
								if(get_result_value.equalsIgnoreCase("No data available in table"))
								{break;}
								else
								{
									String Xpath5=xpath2+"//*[contains(@class,'icon-trash')]";
									System.out.println("\n\n==========we are going to click delete button");
									utilfunc.MakeElement(Xpath5).click();
									System.out.println("\n\n==========we click delete button");
									Thread.sleep(1000);
									Alert alt= webdriver.switchTo().alert();
									alt.accept();
									Thread.sleep(2000);

									String  error_flag="";
									try{error_flag=utilfunc.ErrorMessagehandlerExperiment();}
									catch(Exception e){}
									Thread.sleep(2000);
									System.out.println("error_flag is :"+error_flag);
									Thread.sleep(2000);
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
									System.out.println("Now it should be terminate");
									break;
								}
							}

						}
					}
				}
				catch(Exception e)
				{
					System.out.println("Some error occured: "+e);
				}
			}
		}

		try{
			String popupclose_xpath=".//*[@id='DocUploadModal']//*[contains(@type,'button') and contains(@class,'close')]";
			utilfunc.MakeElement(popupclose_xpath).click();
			Thread.sleep(2000);
		}catch(Exception error){}

		return Flag;
	}

public void DocumentPopupScrollDown() throws InterruptedException
{

	String Xpath	=		".//*[@id='DocUploadModal']/div[2]/table/tbody/tr/td/div[4]";
try{
String scrollTobottom = Keys.chord(Keys.CONTROL, Keys.DOWN);
		webdriver.findElement(By.xpath(Xpath)).sendKeys(scrollTobottom);
		Thread.sleep(200);
	System.out.println("we have scrolled to buttom!");
}catch(Exception e){
	
	String Xpath1=".//*[@id='DocUploadModal']/div[2]/table/tbody/tr/td/div[4]/div/label";
	try{
		String scrollTobottom = Keys.chord(Keys.CONTROL, Keys.DOWN);
		webdriver.findElement(By.xpath(Xpath1)).sendKeys(scrollTobottom);
	Thread.sleep(200);
	System.out.println("we have scrolled to buttom!");
	}catch(Exception error){}
	System.out.println("unable to scroll down to buttom");
}

}

}
