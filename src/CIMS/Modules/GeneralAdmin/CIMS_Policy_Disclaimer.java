package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;

public class CIMS_Policy_Disclaimer {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Policy_Disclaimer(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Policy_Disclaimer(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String ddlApplicationList                           =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String txtCompanyId                                 =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ddlStatus                                    =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String ddlAgreementOption                           =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		    String Policy_DisclaimerBeneficiary	                =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String Policy_DisclaimernHR	                        =	        UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String Policy_DisclaimerManager					    =	        UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String Policy_DisclaimerNetworkPartner				=	        UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String Policy_Desc				                    =	        UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
		    String Policy_DisclaimerBeneficiarySec   	        =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
	     	String Policy_DisclaimernHRSec                      =	        UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String Policy_DisclaimerManagerSec				    =	        UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			String Policy_DisclaimerNetworkPartnerSec		    =	        UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
			String Policy_DisclaimerDescSec				        =	        UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
			String Policy_DisclaimerBeneficiaryThree	        =           UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
			String Policy_DisclaimernHRThree                    =	        UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
			String Policy_DisclaimerManagerThree		        =	        UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
			String Policy_DisclaimerNetworkPartnerThree	        =	        UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
			String Policy_DisclaimerDescThree			        =	        UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
			String Policy_DisclaimerBeneficiaryFour	            =           UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
			String Policy_DisclaimernHRFour                     =	        UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
			String Policy_DisclaimerManagerFour			        =	        UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
			String Policy_DisclaimerNetworkPartnerFour	        =	        UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
			String Policy_DisclaimerDescFour			        =	        UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
			String Search_App                                   =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String AddNewPolicyDisclaimerBtnXpath  =".//a[contains(@class,'btn') and contains(text(),'Add New Policy Disclaimer')]";
				String FormFieldXpath		=	"//*[@id='form1']//*[contains(@class,'control-group')][xx]//*[@name]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[contains(@class,'control-group')]";
				String AutoSuggestionXpath=".//*[@id='ui-id-1']/li[1]/a";
				
				String AddContentXpath= ".//*[contains(@id,'ContentGroup')][nn]//div//*[contains(text(),'Add C')]";
            	String AddContentCounterXpath= ".//*[contains(@id,'ContentGroup')]//div//*[contains(text(),'Add C')]";
        		String ReportlistIfrXpath=".//*[contains(@id,'tinymce-33')]//*[@id='Content_ifr']";
        		
        		String Reportlist1IfrXpath=".//*[contains(@id,'tinymce-67')]//*[@id='Content1_ifr']";
        		String Reportlist2IfrXpath=".//*[contains(@id,'tinymce-101')]//*[@id='Content2_ifr']";
        		String Reportlist3IfrXpath=".//*[contains(@id,'tinymce-135')]//*[@id='Content3_ifr']";
        		
        		
        		
				
				
				
				String NewXpath;
				String AttributeName;
				
				if(mode.equals("New")){
					
					try {
						utilfunc.MakeElement(AddNewPolicyDisclaimerBtnXpath).click();
					}catch (Exception e) {
						System.out.println("===Unable to click on the Add new Resources Type button===+");
					}
					
					
                	
                
                	int AddContentcount = utilfunc.GetObjectCount(AddContentCounterXpath);
                	
                	try {
						for(int h=1; h<=AddContentcount;h++){
							
							Thread.sleep(1000);
							
							String NewAddContentXpath	=	AddContentXpath.replace("nn", Integer.toString(h));
							String AddContecntlink		=	utilfunc.MakeElement(NewAddContentXpath).getAttribute("href");
//						
							System.out.println("NewAddContentXpath" + NewAddContentXpath);
							System.out.println("AddContecntlink" + AddContecntlink);
							
							
							utilfunc.MakeElement(NewAddContentXpath).click();
							
							
							
						}
					} catch (Exception e) {
						System.out.println("Unable to click on the Add more");
					}
					
					
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					try{
						for(int i=1; i<=resultCount; i++){							
	                        Thread.sleep(3000);
	                        NewXpath = FormFieldXpath.replace("xx",Integer.toString(i));
	                        
	                        
	                        
	                        try {
								AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute Name is" + " " + AttributeName);
								System.out.println("New Xpath is:" + " "+ NewXpath);
							
	                        if(AttributeName.equals("ddlApplicationList")){
	                        	
	                        	try {
	                        	Thread.sleep(300);
									utilfunc.Selectdropdownvaluebytext(NewXpath, ddlApplicationList);
								} catch (Exception e) {
												}
	                        }else if(AttributeName.equals("txtCompanyId")){
	                        	
	                        	utilfunc.MakeElement(NewXpath).clear();
	                        	Thread.sleep(1000);
	                        	utilfunc.MakeElement(NewXpath).sendKeys(txtCompanyId);
	                        	
	                        	try {
	                        		Thread.sleep(4000);
									utilfunc.selectFirstResultFromAutoSuggestion(AutoSuggestionXpath);
									Thread.sleep(4000);
								} catch (Exception e) {}
	                        	
	                        	
	                        }else if(AttributeName.equals("ddlStatus")){
	                        	
	                        	try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, ddlStatus);
								} catch (Exception e) {
									
								}
	                        	
	                        }else if(AttributeName.equals("ddlAgreementOption")){
	                        	try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, ddlAgreementOption);
								} catch (Exception e) {
									
								}
						
								
	                        	}
	                        else if(AttributeName.equals("RoleTypesList")){
	                        	
	                        	
	                        	String CheckboxXpath	=	"//input[@name='RoleTypesList' and @type='checkbox'][cc]";
	            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList' and @type='checkbox']";
								
								int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
								
								for(int c=1; c<=chkbxCount; c++){
									Thread.sleep(2000);		
									//check the checkbox if its value is yes for this test case..
									String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
									String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//									utilfunc.MakeElement(NewChkBoxXpath).clear();
									System.out.print("ChkBxValue - " + ChkBxValue);

									if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
										try{
										if(Policy_DisclaimerBeneficiary.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
//										utilfunc.MakeElement(NewChkBoxXpath).click();
									}
									if(ChkBxValue.equalsIgnoreCase("HR")){
										try{
										if(Policy_DisclaimernHR.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("Manager")){
										try{
										if(Policy_DisclaimerManager.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
										try{
										if(Policy_DisclaimerNetworkPartner.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception Error){}
									}
									
								}
							
								 try{
									
									 WebDriverWait wait = new WebDriverWait(webdriver, 15);
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ReportlistIfrXpath)));
										webdriver.switchTo().frame(utilfunc.MakeElement(ReportlistIfrXpath));
										System.out.println("Switched to frame");

										WebElement element = webdriver.findElement(By.cssSelector("body"));
										element.clear(); // clear the content of tiny mce editor
										element.sendKeys(Policy_Desc);
										System.out.println("SnippetHTML is set in tiny mce editor");
								       } catch(Exception e){
									 System.out.println("Unalbe to switch iframe");
								       }
									 try{
										 
										 webdriver.switchTo().defaultContent();
										 
										 
									 }catch(Exception s){
										 System.out.println("Unable to back to main window");
									 }
		                    	
	                        }else if(AttributeName.equals("RoleTypesList1")){
	                        	
	                        	
	                        	String CheckboxXpath	        =	"//input[@name='RoleTypesList1' and @type='checkbox'][cc]";
	            				String CheckboxCounterXpathSec	=   "//input[@name='RoleTypesList1' and @type='checkbox']";
								int chkbxCountSec			    =	utilfunc.GetObjectCount(CheckboxCounterXpathSec);
								
								for(int b=1; b<=chkbxCountSec; b++){
									Thread.sleep(2000);		
									//check the checkbox if its value is yes for this test case..
									String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(b));
									String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//									utilfunc.MakeElement(NewChkBoxXpath).clear();
									System.out.print("ChkBxValue - " + ChkBxValue);

									if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
										try{
										if(Policy_DisclaimerBeneficiarySec.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
//										utilfunc.MakeElement(NewChkBoxXpath).click();
									}
									if(ChkBxValue.equalsIgnoreCase("HR")){
										try{
										if(Policy_DisclaimernHRSec.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("Manager")){
										try{
										if(Policy_DisclaimerManagerSec.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
										try{
										if(Policy_DisclaimerNetworkPartnerSec.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception Error){}
									}
									
								}
								
								
								
								try{
									
									 WebDriverWait wait = new WebDriverWait(webdriver, 15);
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist1IfrXpath)));
										webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist1IfrXpath));
										System.out.println("Switched to frame");

										WebElement element = webdriver.findElement(By.cssSelector("body"));
										element.clear(); // clear the content of tiny mce editor
										element.sendKeys(Policy_DisclaimerDescSec);
										System.out.println("SnippetHTML is set in tiny mce editor");
								       } catch(Exception e){
									 System.out.println("Unalbe to switch iframe");
								       }
									 try{
										 
										 webdriver.switchTo().defaultContent();
										 
										 
									 }catch(Exception s){
										 System.out.println("Unable to back to main window");
									 }

	                        	
	                        	
	                        	
	                        	
	                        	
	                        }else if(AttributeName.equals("RoleTypesList2")){
	                        	
	                        	String CheckboxXpath	    =	"//input[@name='RoleTypesList2' and @type='checkbox'][cc]";
	            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList2' and @type='checkbox']";
                                int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
								
								for(int e=1; e<=chkbxCount; e++){
									Thread.sleep(2000);		
									//check the checkbox if its value is yes for this test case..
									String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(e));
									String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//									utilfunc.MakeElement(NewChkBoxXpath).clear();
									System.out.print("ChkBxValue - " + ChkBxValue);

									if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
										try{
										if(Policy_DisclaimerBeneficiaryThree.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
//										utilfunc.MakeElement(NewChkBoxXpath).click();
									}
									if(ChkBxValue.equalsIgnoreCase("HR")){
										try{
										if(Policy_DisclaimernHRThree.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("Manager")){
										try{
										if(Policy_DisclaimerManagerThree.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
										try{
										if(Policy_DisclaimerNetworkPartnerThree.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception Error){}
									}
									
								}
								
								
								try{
									
									 WebDriverWait wait = new WebDriverWait(webdriver, 15);
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist2IfrXpath)));
										webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist2IfrXpath));
										System.out.println("Switched to frame");

										WebElement element = webdriver.findElement(By.cssSelector("body"));
										element.clear(); // clear the content of tiny mce editor
										element.sendKeys(Policy_DisclaimerDescThree);
										System.out.println("SnippetHTML is set in tiny mce editor");
								       } catch(Exception e){
									 System.out.println("Unalbe to switch iframe");
								       }
									 try{
										 
										 webdriver.switchTo().defaultContent();
										 
										 
									 }catch(Exception s){
										 System.out.println("Unable to back to main window");
									 }
	                        	
	                        	
	                        	
	                        }else if(AttributeName.equals("RoleTypesList3")){
	                        	
	                        	String CheckboxXpath	    = "//input[@name='RoleTypesList3' and @type='checkbox'][cc]";
            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList3' and @type='checkbox']";
	                        	
                                  int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
								
								    for(int c=1; c<=chkbxCount; c++){
									Thread.sleep(2000);		
									//check the checkbox if its value is yes for this test case..
									String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
									String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//									utilfunc.MakeElement(NewChkBoxXpath).clear();
									System.out.print("ChkBxValue - " + ChkBxValue);

									if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
										try{
										if(Policy_DisclaimerBeneficiaryFour.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
//										utilfunc.MakeElement(NewChkBoxXpath).click();
									}
									if(ChkBxValue.equalsIgnoreCase("HR")){
										try{
										if(Policy_DisclaimernHRFour.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("Manager")){
										try{
										if(Policy_DisclaimerManagerFour.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception error){}
									}
									if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
										try{
										if(Policy_DisclaimerNetworkPartnerFour.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
										}}catch(Exception Error){}
									}
									
								}
								    
								    try{
										
										 WebDriverWait wait = new WebDriverWait(webdriver, 15);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist3IfrXpath)));
											webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist3IfrXpath));
											System.out.println("Switched to frame");

											WebElement element = webdriver.findElement(By.cssSelector("body"));
											element.clear(); // clear the content of tiny mce editor
											element.sendKeys(Policy_DisclaimerDescFour);
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
	                        	System.out.println("Plese select the mandatory field.");
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
					
					String SearcApplicationDropDownXpath=".//*[@id='ddlApplication']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[4]//.[contains(@class,'edit')]";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearcApplicationDropDownXpath, Search_App);
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
	            		   
	            		   int AddContentcount = utilfunc.GetObjectCount(AddContentCounterXpath);
	                   	
	                     	try {
	   						for(int h=1; h<=AddContentcount;h++){
	   							
	   							Thread.sleep(1000);
	   							
	   							String NewAddContentXpath	=	AddContentXpath.replace("nn", Integer.toString(h));
	   							String AddContecntlink		=	utilfunc.MakeElement(NewAddContentXpath).getAttribute("href");
//	   						
	   							System.out.println("NewAddContentXpath" + NewAddContentXpath);
	   							System.out.println("AddContecntlink" + AddContecntlink);
	   							
	   							
	   							utilfunc.MakeElement(NewAddContentXpath).click();
	   							
	   							
	   							
	   						}
	   					} catch (Exception e) {
	   						System.out.println("Unable to click on the Add more");
	   					}
	            		   
	            		   Thread.sleep(1000);
	            		   
	            		   int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
							for(int i=1; i<=resultCount; i++){							
		                        Thread.sleep(3000);
		                        NewXpath = FormFieldXpath.replace("xx",Integer.toString(i));
		                        
		                        
		                        
		                        try {
									AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
									System.out.println("Attribute Name is" + " " + AttributeName);
									System.out.println("New Xpath is:" + " "+ NewXpath);
								
		                        if(AttributeName.equals("ddlApplicationList")){
		                        	
		                        	try {
		                        	Thread.sleep(300);
										utilfunc.Selectdropdownvaluebytext(NewXpath, ddlApplicationList);
									} catch (Exception e) {
													}
		                        }else if(AttributeName.equals("txtCompanyId")){
		                        	
		                        	utilfunc.MakeElement(NewXpath).clear();
		                        	Thread.sleep(1000);
		                        	utilfunc.MakeElement(NewXpath).sendKeys(txtCompanyId);
		                        	Thread.sleep(4000);
		                        	try {
										utilfunc.selectFirstResultFromAutoSuggestion(AutoSuggestionXpath);
									} catch (Exception e) {}
		                        	
		                        	
		                        }else if(AttributeName.equals("ddlStatus")){
		                        	
		                        	try {
										utilfunc.Selectdropdownvaluebytext(NewXpath, ddlStatus);
									} catch (Exception e) {
										
									}
		                        	
		                        }else if(AttributeName.equals("ddlAgreementOption")){
		                        	try {
										utilfunc.Selectdropdownvaluebytext(NewXpath, ddlAgreementOption);
									} catch (Exception e) {
										
									}
							
									
		                        	}
		                        else if(AttributeName.equals("RoleTypesList")){
		                        	
		                        	
		                        	String CheckboxXpath	=	"//input[@name='RoleTypesList' and @type='checkbox'][cc]";
		            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList' and @type='checkbox']";
									
									int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
									
									for(int c=1; c<=chkbxCount; c++){
										Thread.sleep(2000);		
										//check the checkbox if its value is yes for this test case..
										String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
										String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//										utilfunc.MakeElement(NewChkBoxXpath).clear();
										System.out.print("ChkBxValue - " + ChkBxValue);

										if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
											try{
											if(Policy_DisclaimerBeneficiary.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
//											utilfunc.MakeElement(NewChkBoxXpath).click();
										}
										if(ChkBxValue.equalsIgnoreCase("HR")){
											try{
											if(Policy_DisclaimernHR.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("Manager")){
											try{
											if(Policy_DisclaimerManager.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
											try{
											if(Policy_DisclaimerNetworkPartner.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception Error){}
										}
										
									}
								
									 try{
										
									   	 WebDriverWait wait = new WebDriverWait(webdriver, 15);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ReportlistIfrXpath)));
											webdriver.switchTo().frame(utilfunc.MakeElement(ReportlistIfrXpath));
											System.out.println("Switched to frame");

											WebElement element = webdriver.findElement(By.cssSelector("body"));
											element.clear(); // clear the content of tiny mce editor
											element.sendKeys(Policy_Desc);
											System.out.println("SnippetHTML is set in tiny mce editor");
									       } catch(Exception e){
										 System.out.println("Unalbe to switch iframe");
									       }
										 try{
											 
											 webdriver.switchTo().defaultContent();
											 
											 
										 }catch(Exception s){
											 System.out.println("Unable to back to main window");
										 }
			                    	
		                        }else if(AttributeName.equals("RoleTypesList1")){
		                        	
		                        	
		                        	String CheckboxXpath	        =	"//input[@name='RoleTypesList1' and @type='checkbox'][cc]";
		            				String CheckboxCounterXpathSec	=   "//input[@name='RoleTypesList1' and @type='checkbox']";
									int chkbxCountSec			    =	utilfunc.GetObjectCount(CheckboxCounterXpathSec);
									
									for(int b=1; b<=chkbxCountSec; b++){
										Thread.sleep(2000);		
										//check the checkbox if its value is yes for this test case..
										String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(b));
										String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//										utilfunc.MakeElement(NewChkBoxXpath).clear();
										System.out.print("ChkBxValue - " + ChkBxValue);

										if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
											try{
											if(Policy_DisclaimerBeneficiarySec.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
//											utilfunc.MakeElement(NewChkBoxXpath).click();
										}
										if(ChkBxValue.equalsIgnoreCase("HR")){
											try{
											if(Policy_DisclaimernHRSec.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("Manager")){
											try{
											if(Policy_DisclaimerManagerSec.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
											try{
											if(Policy_DisclaimerNetworkPartnerSec.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception Error){}
										}
										
									}
									
									
									
									try{
										
										 WebDriverWait wait = new WebDriverWait(webdriver, 15);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist1IfrXpath)));
											webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist1IfrXpath));
											System.out.println("Switched to frame");

											WebElement element = webdriver.findElement(By.cssSelector("body"));
											element.clear(); // clear the content of tiny mce editor
											element.sendKeys(Policy_DisclaimerDescSec);
											System.out.println("SnippetHTML is set in tiny mce editor");
									       } catch(Exception e){
										 System.out.println("Unalbe to switch iframe");
									       }
										 try{
											 
											 webdriver.switchTo().defaultContent();
											 
											 
										 }catch(Exception s){
											 System.out.println("Unable to back to main window");
										 }

		                        	
		                        	
		                        	
		                        	
		                        	
		                        }else if(AttributeName.equals("RoleTypesList2")){
		                        	
		                        	String CheckboxXpath	    =	"//input[@name='RoleTypesList2' and @type='checkbox'][cc]";
		            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList2' and @type='checkbox']";
	                                int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
									
									for(int e=1; e<=chkbxCount; e++){
										Thread.sleep(2000);		
										//check the checkbox if its value is yes for this test case..
										String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(e));
										String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//										utilfunc.MakeElement(NewChkBoxXpath).clear();
										System.out.print("ChkBxValue - " + ChkBxValue);

										if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
											try{
											if(Policy_DisclaimerBeneficiaryThree.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
//											utilfunc.MakeElement(NewChkBoxXpath).click();
										}
										if(ChkBxValue.equalsIgnoreCase("HR")){
											try{
											if(Policy_DisclaimernHRThree.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("Manager")){
											try{
											if(Policy_DisclaimerManagerThree.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
											try{
											if(Policy_DisclaimerNetworkPartnerThree.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception Error){}
										}
										
									}
									
									
									try{
										
										 WebDriverWait wait = new WebDriverWait(webdriver, 15);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist2IfrXpath)));
											webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist2IfrXpath));
											System.out.println("Switched to frame");

											WebElement element = webdriver.findElement(By.cssSelector("body"));
											element.clear(); // clear the content of tiny mce editor
											element.sendKeys(Policy_DisclaimerDescThree);
											System.out.println("SnippetHTML is set in tiny mce editor");
									       } catch(Exception e){
										 System.out.println("Unalbe to switch iframe");
									       }
										 try{
											 
											 webdriver.switchTo().defaultContent();
											 
											 
										 }catch(Exception s){
											 System.out.println("Unable to back to main window");
										 }
		                        	
		                        	
		                        	
		                        }else if(AttributeName.equals("RoleTypesList3")){
		                        	
		                        	String CheckboxXpath	    = "//input[@name='RoleTypesList3' and @type='checkbox'][cc]";
	            				String CheckboxCounterXpath	=	"//input[@name='RoleTypesList3' and @type='checkbox']";
		                        	
	                                  int chkbxCount			=	utilfunc.GetObjectCount(CheckboxCounterXpath);
									
									    for(int c=1; c<=chkbxCount; c++){
										Thread.sleep(2000);		
										//check the checkbox if its value is yes for this test case..
										String NewChkBoxXpath	=	CheckboxXpath.replace("cc", Integer.toString(c));
										String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
//										utilfunc.MakeElement(NewChkBoxXpath).clear();
										System.out.print("ChkBxValue - " + ChkBxValue);

										if(ChkBxValue.equalsIgnoreCase("Beneficiary")){
											try{
											if(Policy_DisclaimerBeneficiaryFour.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
//											utilfunc.MakeElement(NewChkBoxXpath).click();
										}
										if(ChkBxValue.equalsIgnoreCase("HR")){
											try{
											if(Policy_DisclaimernHRFour.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("Manager")){
											try{
											if(Policy_DisclaimerManagerFour.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception error){}
										}
										if(ChkBxValue.equalsIgnoreCase("NetworkPartner")){
											try{
											if(Policy_DisclaimerNetworkPartnerFour.equalsIgnoreCase("Yes")){
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
											}else{
												utilfunc.enableOrDisableCheckbox(NewChkBoxXpath,false);
											}}catch(Exception Error){}
										}
										
									}
									    
									    try{
											
											 WebDriverWait wait = new WebDriverWait(webdriver, 15);
												wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reportlist3IfrXpath)));
												webdriver.switchTo().frame(utilfunc.MakeElement(Reportlist3IfrXpath));
												System.out.println("Switched to frame");

												WebElement element = webdriver.findElement(By.cssSelector("body"));
												element.clear(); // clear the content of tiny mce editor
												element.sendKeys(Policy_DisclaimerDescFour);
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
		                        	System.out.println("Plese select the mandatory field.");
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
					String error_flag=utilfunc.PoclassificationErrorMessageHandler();
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
				

				if(mode.equals("Delete")){
					return false;
				}

			
			}
		return Flag;
	}

}
