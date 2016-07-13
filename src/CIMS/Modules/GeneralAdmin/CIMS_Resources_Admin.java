package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;

public class CIMS_Resources_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Resources_Admin(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Resource_Type(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module....");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String FAQType                                      =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String GetCompanyChkboxId                           =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String GetCompanyTextId                             =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		    String Resources_AdminNetworkPartner	            =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String Resources_AdminHR	                        =	        UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String Resources_AdminManager					    =	        UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String Resources_AdminBeneficiary					=	        UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			
			String Title                                        =           UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String Description                                  =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			String Search_Country                                  =           UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				
				String AddNewResourcesBtnXpath  =".//a[contains(@class,'btn') and contains(text(),'Add New')]";
				String FormFieldXpath		=	"//*[@id='form1']//*[contains(@class,'control-group')][xx]//*[contains(@class,'controls')]//*[@name and not(contains(@type,'hidden'))]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[contains(@class,'control-group')]";
				String AddBtnXpath    ="//*[@id='form1']//*[contains(@class,'control-group')][3]//*[contains(@class,'controls')]//*[contains(@class,'btn-primary') and text()='Add']";
				String AddCmpBtnXpath    ="//*[@id='form1']//*[contains(@class,'control-group')][oo]//*[contains(@class,'controls')]//*[contains(@class,'btn-primary') and text()='Add']";
				String DescIfrXpath=".//*[contains(@id,'tinymce-33')]//*[@id='Description_ifr']";
		
				
				String NewXpath;
				String AttributeName;
				
				
				if(mode.equals("New")){
					
					try {
						utilfunc.MakeElement(AddNewResourcesBtnXpath).click();
					}catch (Exception e) {
						System.out.println("===Unable to click on the Add new Resources Type button===+");
					}
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					try{
						for(int i=1; i<=resultCount; i++){							
	                        Thread.sleep(3000);
							
							NewXpath = FormFieldXpath.replace("xx",Integer.toString(i));
							String AddXpath=AddBtnXpath.replace("yy", Integer.toString(i));
							String AddCmpIdBtnXpath=AddCmpBtnXpath.replace("oo", Integer.toString(i));
							try {
								AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute Name is" + " " + AttributeName);
								System.out.println("New Xpath is:" + " "+ NewXpath);
								
								if(AttributeName.equals("FAQType")){
									
									try {
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, FAQType);
									} catch (Exception e) {
										System.out.println("===Unable to select the value===");
									}
									
								}else if(AttributeName.equals("CountryCode")){
									//System.out.println("we are here");
									String Country_CodeNewXpath="//*[@id='form1']//*[contains(@class,'control-group')][3]//*[contains(@class,'controls')]//select[@name]";
									//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
									if(StringUtils.isEmpty(CountryCode)==false){
										String[] split = CountryCode.split(",");
										System.out.println(split.length);
										for (int Country_Code = 0; Country_Code < split.length; Country_Code++) {
											//System.out.println(doc_NewXpath);
											System.out.println(split[Country_Code].trim()+"---");
											Thread.sleep(400);
											try {
												utilfunc.Selectdropdownvaluebytext(Country_CodeNewXpath,split[Country_Code].trim());
											} catch (Exception e) {
												
											}
											try {
												utilfunc.MakeElement(AddXpath).click();
											} catch (Exception e) {
												
											}
										}
									}
								}else if(AttributeName.equals("GetCompanyId"))
								{
									if(GetCompanyChkboxId.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath+"//.[@type='checkbox']", true);
										
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath+"//.[@type='checkbox']", false);
										
										Thread.sleep(1000);
										
										

										//System.out.println("we are here");
										String AutoSuggestionXpath=".//*[@id='ui-id-1']//li[1]/a";
										String CompanyIDNewXpath="//*[@id='form1']//*[contains(@class,'control-group')][aa]//*[contains(@class,'controls')]//*[@type='text']";
										CompanyIDNewXpath=CompanyIDNewXpath.replace("aa", Integer.toString(i));
										if(StringUtils.isEmpty(GetCompanyTextId)==false){
											String[] split = GetCompanyTextId.split(",");
											System.out.println(split.length);
											for (int Country_Code = 0; Country_Code < split.length; Country_Code++) {
												//System.out.println(doc_NewXpath);
												System.out.println(split[Country_Code].trim()+"---");
												Thread.sleep(400);
												utilfunc.MakeElement(CompanyIDNewXpath).clear();
												Thread.sleep(2000);
												utilfunc.MakeElement(CompanyIDNewXpath).sendKeys(split[Country_Code].trim());
												Thread.sleep(4000);
												try {
													utilfunc.selectFirstResultFromAutoSuggestion(AutoSuggestionXpath);
												} catch (Exception e) {
													
												}
												
												
												
												try {
													utilfunc.MakeElement(AddCmpIdBtnXpath).click();
												} catch (Exception e) {
													
												}
											}
										}
									
										
										
										}
									
									}else if(AttributeName.equals("RoleTypes")){
										
										String CheckboxXpath	=	"//input[@name='RoleTypes' and @type='checkbox'][cc]";
										String CheckboxCounterXpath	=	"//input[@name='RoleTypes' and @type='checkbox']";
										
										int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
										
										for(int c=1; c<=chkbxCount; c++){
											Thread.sleep(2000);		
											//check the checkbox if its value is yes for this test case..
											String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
											String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//											utilfunc.MakeElement(NewChkBoxXpath).clear();
											System.out.print("ChkBxValue - " + ChkBxValue);

											if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
												try{
												if(Resources_AdminNetworkPartner.equalsIgnoreCase("Yes")){
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
												}else{
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
												}}catch(Exception error){}
//												utilfunc.MakeElement(NewChkBoxXpath).click();
											}
											if(ChkBxValue.equalsIgnoreCase("HR")){
												try{
												if(Resources_AdminHR.equalsIgnoreCase("Yes")){
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
												}else{
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
												}}catch(Exception error){}
											}
											if(ChkBxValue.equalsIgnoreCase("Manager")){
												try{
												if(Resources_AdminManager.equalsIgnoreCase("Yes")){
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
												}else{
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
												}}catch(Exception error){}
											}
											if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
												try{
												if(Resources_AdminBeneficiary.equalsIgnoreCase("Yes")){
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
												}else{
													utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
												}}catch(Exception Error){}
											}
											
										}

										
										
										
									}else if(AttributeName.equals("Title")){
										
										utilfunc.MakeElement(NewXpath).sendKeys(Title);
										
										
									}
									else if(AttributeName.equals("Description")){
										


										 try{
											
											 WebDriverWait wait = new WebDriverWait(webdriver, 15);
												wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DescIfrXpath)));
												webdriver.switchTo().frame(utilfunc.MakeElement(DescIfrXpath));
												System.out.println("Switched to frame");

												WebElement element = webdriver.findElement(By.cssSelector("body"));
												element.clear(); // clear the content of tiny mce editor
												element.sendKeys(Description);
												System.out.println("SnippetHTML is set in tiny mce editor");
										       } catch(Exception e){
											 System.out.println("Unalbe to switch iframe");
										       }
											 try{
												 
												 webdriver.switchTo().defaultContent();
												 
												 
											 }catch(Exception s){
												 System.out.println("Unable to back to main window");
											 }
					                    						 
										 
									
										
										
										
									}else{
										
										System.out.println("==Please select all the mandatory fields.==");
									}
								
								
								
							} catch (Exception e) {
								System.out.println("no field found");
							}
							
							
							
							
							
						
					
					
						}
					}catch(Exception e){
						
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
					}
					
				}
				
				if(mode.equals("Edit")){
					
					String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='ddlDestinationCountryCode']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[8]//.[contains(@class,'edit')]";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, Search_Country);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
					 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
	            		   utilfunc.scrollToTop();
	            		   
	            		   try {
							utilfunc.MakeElement(EditIconXpath).click();
						} catch (Exception e) {}
	            		   
	            		   Thread.sleep(1000);
		            	      
		            	      int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
		            	      for(int i=1; i<=resultCount; i++){							
			                        Thread.sleep(3000);
									
									NewXpath = FormFieldXpath.replace("xx",Integer.toString(i));
									String AddXpath=AddBtnXpath.replace("yy", Integer.toString(i));
									String AddCmpIdBtnXpath=AddCmpBtnXpath.replace("oo", Integer.toString(i));
									try {
										AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
										System.out.println("Attribute Name is" + " " + AttributeName);
										System.out.println("New Xpath is:" + " "+ NewXpath);
										
										if(AttributeName.equals("FAQType")){
											
											try {
												Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebytext(NewXpath, FAQType);
											} catch (Exception e) {
												System.out.println("===Unable to select the value===");
											}
											
										}else if(AttributeName.equals("CountryCode")){
											
										String del_Xpath="//*[@class='controls dvctrl']//*[@class='iRow']//*[contains(@class,'lbl-del')]";
											int del_Doc_type=utilfunc.GetObjectCount(del_Xpath);
											//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
											if (del_Doc_type>=1){//if added doc type is more then one then we have to delete them...
												for(int d=1;d<=del_Doc_type;d++){
													Thread.sleep(1000);
													del_Xpath="//*[@class='controls dvctrl']//*[@class='iRow'][1]//*[contains(@class,'lbl-del')]";
													
													utilfunc.MakeElement(del_Xpath).click();
												}
											}
											//System.out.println("we are here");
											String Country_CodeNewXpath="//*[@id='form1']//*[contains(@class,'control-group')][3]//*[contains(@class,'controls')]//select[@name]";
											//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
											if(StringUtils.isEmpty(CountryCode)==false){
												String[] split = CountryCode.split(",");
												System.out.println(split.length);
												for (int Country_Code = 0; Country_Code < split.length; Country_Code++) {
													//System.out.println(doc_NewXpath);
													System.out.println(split[Country_Code].trim()+"---");
													Thread.sleep(400);
													try {
														utilfunc.Selectdropdownvaluebytext(Country_CodeNewXpath,split[Country_Code].trim());
													} catch (Exception e) {
														
													}
													try {
														utilfunc.MakeElement(AddXpath).click();
													} catch (Exception e) {
														
													}
												}
											}
										}else if(AttributeName.equals("GetCompanyId"))
										{
											if(GetCompanyChkboxId.equals("Yes")){
												utilfunc.enableOrDisableCheckbox(NewXpath+"//.[@type='checkbox']", true);
												
											}else{
												utilfunc.enableOrDisableCheckbox(NewXpath+"//.[@type='checkbox']", false);
												
												Thread.sleep(1000);
												String del_Cmp_Xpath="//*[@id='group_Company']//*[contains(@class,'iCRow')]//*[contains(@class,'lbl-del')]";
												int del_Company_type=utilfunc.GetObjectCount(del_Cmp_Xpath);
												//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
												if (del_Company_type>=1){//if added doc type is more then one then we have to delete them...
													for(int d=1;d<=del_Company_type;d++){
														Thread.sleep(1000);
														
														del_Cmp_Xpath="//*[@class='controls dvctrl']//*[@class='iRow'][1]//*[contains(@class,'lbl-del')]";
														utilfunc.MakeElement(del_Cmp_Xpath).click();
													}
												}
												
												

												//System.out.println("we are here");
												String AutoSuggestionXpath=".//*[@id='ui-id-1']//li[1]/a";
												String CompanyIDNewXpath="//*[@id='form1']//*[contains(@class,'control-group')][aa]//*[contains(@class,'controls')]//*[@type='text']";
												CompanyIDNewXpath=CompanyIDNewXpath.replace("aa", Integer.toString(i));
												if(StringUtils.isEmpty(GetCompanyTextId)==false){
													String[] split = GetCompanyTextId.split(",");
													System.out.println(split.length);
													for (int Country_Code = 0; Country_Code < split.length; Country_Code++) {
														//System.out.println(doc_NewXpath);
														System.out.println(split[Country_Code].trim()+"---");
														Thread.sleep(400);
														utilfunc.MakeElement(CompanyIDNewXpath).clear();
														Thread.sleep(400);
														utilfunc.MakeElement(CompanyIDNewXpath).sendKeys(split[Country_Code].trim());
														Thread.sleep(4000);
														try {
															utilfunc.selectFirstResultFromAutoSuggestion(AutoSuggestionXpath);
														} catch (Exception e) {
															
														}
														
														
														
														try {
															utilfunc.MakeElement(AddCmpIdBtnXpath).click();
														} catch (Exception e) {
															
														}
													}
												}
											
												
												
												}
											
											}else if(AttributeName.equals("RoleTypes")){
												
												String CheckboxXpath	=	"//input[@name='RoleTypes' and @type='checkbox'][cc]";
												String CheckboxCounterXpath	=	"//input[@name='RoleTypes' and @type='checkbox']";
												
												int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
												
												for(int c=1; c<=chkbxCount; c++){
													Thread.sleep(2000);		
													//check the checkbox if its value is yes for this test case..
													String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
													String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//													utilfunc.MakeElement(NewChkBoxXpath).clear();
													System.out.print("ChkBxValue - " + ChkBxValue);

													if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
														try{
														if(Resources_AdminNetworkPartner.equalsIgnoreCase("Yes")){
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
														}else{
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
														}}catch(Exception error){}
//														utilfunc.MakeElement(NewChkBoxXpath).click();
													}
													if(ChkBxValue.equalsIgnoreCase("HR")){
														try{
														if(Resources_AdminHR.equalsIgnoreCase("Yes")){
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
														}else{
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
														}}catch(Exception error){}
													}
													if(ChkBxValue.equalsIgnoreCase("Manager")){
														try{
														if(Resources_AdminManager.equalsIgnoreCase("Yes")){
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
														}else{
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
														}}catch(Exception error){}
													}
													if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
														try{
														if(Resources_AdminBeneficiary.equalsIgnoreCase("Yes")){
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
														}else{
															utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
														}}catch(Exception Error){}
													}
													
												}

												
												
												
											}else if(AttributeName.equals("Title")){
												
												utilfunc.MakeElement(NewXpath).clear();
												utilfunc.MakeElement(NewXpath).sendKeys(Title);
												
												
											}
											else if(AttributeName.equals("Description")){
												


												 try{
													
													 WebDriverWait wait = new WebDriverWait(webdriver, 15);
														wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DescIfrXpath)));
														webdriver.switchTo().frame(utilfunc.MakeElement(DescIfrXpath));
														System.out.println("Switched to frame");

														WebElement element = webdriver.findElement(By.cssSelector("body"));
														element.clear(); // clear the content of tiny mce editor
														element.sendKeys(Description);
														System.out.println("SnippetHTML is set in tiny mce editor");
												       } catch(Exception e){
													 System.out.println("Unalbe to switch iframe");
												       }
													 try{
														 
														 webdriver.switchTo().defaultContent();
														 
														 
													 }catch(Exception s){
														 System.out.println("Unable to back to main window");
													 }
						
											}else{
												
												System.out.println("==Please select all the mandatory fields.==");
											}
										
										
										
									} catch (Exception e) {
										System.out.println("no field found");
									}
					      }

	            		   
	            		   
	            		   
	            	   }
					
					
					
				}
			
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
				try {
					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
					utilfunc.MakeElement(updateBtnXpath).click();
				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					
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
					
			}
			
				
				if(mode.equalsIgnoreCase("Delete")){
					

					String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='ddlDestinationCountryCode']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String DeleteIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[9]//.[contains(@class,'trash')]";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, Search_Country);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
                  	
                  	 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
		            		   utilfunc.scrollToTop();
	   					System.out.println("Record founded. we are going to delete it.");
	   					try{
	   						Thread.sleep(2000);
	   						
	   						utilfunc.MakeElement(DeleteIconXpath).click();
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
	   				}
	            		   
	            	   
					
					
				}
				
				if(mode.equalsIgnoreCase("Copy")){
					

					String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='ddlDestinationCountryCode']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String CopyIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, Search_Country);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
                  	
                  	 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
		            		   utilfunc.scrollToTop();
	   					System.out.println("Record founded. we are going to delete it.");
	   					try{
	   						Thread.sleep(2000);
	   						
	   						utilfunc.MakeElement(CopyIconXpath).click();
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
	   				}
	            		   
	            	   
					
					
				
					
					
					
				}
				
			}
			return Flag;
}
}
