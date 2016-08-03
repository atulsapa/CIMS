package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;

public class CIMS_Secure_Messaging {

	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	 public CIMS_Secure_Messaging(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 

	      public boolean Secure_Messaging(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String BalNumberSearch							    =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String fullName      							    =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			
			//String NotificationList						    =			UtilFunction.getCellData(filename, sheetName,6, ColumnCounter);
			
			String NotificationListcheckbox_first               =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			String NotificationListcheckbox_scnd                =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			
			
			String BeneficiaryAccessFlag					    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String NetworkPartnerAccessFlag					    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			
			String Subject							            =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String MessageBody							        =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String DocumentToBeUploaded							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String SearchTypeBal							    =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			String RadioButtonvalue							    =			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String Status							            =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
			

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				String FormFieldXpath		=	"//*[@id='form1']//*[contains(@class,'control-group')][xx]//.[contains(@class,'controls')]//*[@name and not(@type='hidden')]";
				String FormFieldsCounterXpath			=	"//*[@id='form1']//*[contains(@class,'control-group')]//.[contains(@class,'controls')]";
				String I_FrameXpath =".//*[contains(@id,'tinymce-14')]//*[@id='txtMessage_ifr']";
				String uploadDocFormBtnXPath	=	"//*[@id='form1']//*[@id='btnShowDocUpload']";
				String selectAFileBtnXPath		=	".//*[@id='DocUploadModal']//*[@class='controls']//button[1]";
				String uploadDocBtnXPath		=	".//*[@class='controls']//*[@id='btnUploadDocuments']";
				
				String NewXpath;
			    String AttributeName;
			    int NoOfRow =0;
			    int NoOfcol=0;
			    

				String BackLink=".//*[@id='panel-body']//a[contains(@class,'back-bg')]";
				
				String AttrLink ="";
				try {
					AttrLink = utilfunc.MakeElement(BackLink).getAttribute("href");
				} catch (Exception e1) {
					System.out.println("Unable to  find the link");
				}
				
							
				System.out.println("AttrLink"+""+AttrLink);
				
				
			
				if(mode.equals("New")){
					
					try{
						String AddNewMessage	=	".//a[contains(@class,'btn') and contains(text(),'New Message')]";
						utilfunc.MakeElement(AddNewMessage).click();
						System.out.println("======Click on the Add AddNewMessage ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					String SearchBtnXpath=".//*[contains(@class,'btn') and text()='Search']";
					try {
						utilfunc.MakeElement(SearchBtnXpath).click();
					} catch (Exception e1) {System.out.println("Unable to click on search button");}
					Thread.sleep(3000);
//				    String RowCounterXpath=".//*[@id='CaseSearchModal']//div//*[@class='form-horizontal']//tbody//tr";
//				    String rowXpath=".//*[@id='CaseSearchModal']//div//*[@class='form-horizontal']//tbody//tr[yy]";
//				    
//				    String colcounterXpath="";
//				    
//				    int rowcount =utilfunc.GetObjectCount(RowCounterXpath);
//				    
//				    if(NoOfRow>0){
//				    for(int j=1; j<=rowcount;j++)
//				    {
//				    	String RowCountXpath		=	rowXpath.replace("yy", Integer.toString(j));
//				    	
//				    	RowCountXpath =RowCountXpath+ "//*[@id]";
//				    	System.out.println("Row count" +" "+RowCountXpath);
//				    	
//				    	
//				    	try{
//				    		
//				    		String AttributeID=utilfunc.MakeElement(RowCountXpath).getAttribute("id");
//				    		
//				    		if(AttributeID.equals("BalNumberSearch")){
//				    			 NoOfcol = utilfunc.GetObjectCount(colcounterXpath);
//				    			 
//				    			 if(NoOfcol>0){
//				    				 
//				    				for(int k=1; k<=NoOfcol;k++){
//				    					String atrbut_id	=	"";
//				    					String col_xpath	=	rowXpath.replace("xx", Integser.toString(j))+"/div"+"["+j+"]"+ "//*[@name]";
//				    					
//				    					atrbut_id			=	utilfunc.MakeElement(col_xpath).getAttribute("id");
//										System.out.println("attribute id is: "+atrbut_id);
//				    					
//				    				}
//				    				 
//				    				 
//				    			 }
//				    		}
//				    		System.out.println();
//				    		
//				    		
//				    	}catch(Exception e){}
//				    	
//				    	
//				    	
//				    }
//				    }
//					
//					String BalNumberXpath=".//*[@id='BalNumberSearch']";
//				    String fullNameXpath=".//*[@id='fullName']";
//				    String searchxpath =".//*[@id='btnSearch']";
//				    String FirstrecordXpath=".//*[@id='dvCaseList']//div//tbody//tr[1]//td[1]//input//.[@name='GetCaseNumber']";
//				   try {
//					utilfunc.MakeElement(BalNumberXpath).clear();
//					   utilfunc.MakeElement(BalNumberXpath).sendKeys(BalNumberSearch);
//				} catch (Exception e1) {System.out.println("Unable to enter the BalNumber");}
//				   
//				   utilfunc.MakeElement(fullNameXpath).clear();
//				   
//				   try {
//					utilfunc.MakeElement(fullNameXpath).sendKeys(fullName);
//				} catch (Exception e1) {System.out.println("Unable to enter the fullname");}
//				   
//				  try {
//					  Thread.sleep(3000);
//					utilfunc.MakeElement(searchxpath).click();
//					Thread.sleep(3000);
//				} catch (Exception e1) {System.out.println("Unable to click on the search button");}
//				  
//				  try {
//					utilfunc.MakeElement(FirstrecordXpath).click();
//				} catch (Exception e1) {System.out.println("Unable to select the record");}
//				   Thread.sleep(2000);
				    
			
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					
						for(int i=1; i <=resultCount;i++){
							
							NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
							
							try {
								AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								
								System.out.println("NewXpath is" +" "+NewXpath );
								System.out.println("AttributeName is "+" "+AttributeName);
								
								
								if(AttributeName.equals("BalNumber")){
									
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(BalNumberSearch);
								} catch (Exception e) {}
									
									
								}else if(AttributeName.equals("NotificationList")){
									
									
									
                                             if(NotificationListcheckbox_first.equals("Yes")){
										
										try {
											Thread.sleep(1000);
											utilfunc.enableOrDisableCheckbox(NewXpath, true);
										} catch (Exception e) {}
										
									}else{
										try {
											utilfunc.enableOrDisableCheckbox(NewXpath, false);
										} catch (Exception e) {}
									
									
//									String ChkBoxXpath ="//*[@class='checkbox'][nn]//*[@name='NotificationList']";
//									String ChkboxCounterXpath ="//*[@class='checkbox']//*[@name='NotificationList']";
//									
//									int chkboxcount = utilfunc.GetObjectCount(ChkboxCounterXpath);
									
//									for(int c=1; c<=chkboxcount; c++){
//										Thread.sleep(2000);		
//										//check the checkbox if its value is yes for this test case..
//										String NewChkBoxXpath	=	ChkBoxXpath.replace("nn", Integer.toString(c));
//										try {
//											String ChkBxValue		=	utilfunc.MakeElement(NewChkBoxXpath).getAttribute("value");
////										utilfunc.MakeElement(NewChkBoxXpath).clear();
//											System.out.println("ChkBxValue - " + ChkBxValue);
//											
//											if(ChkBxValue.equals("1829")){
//												
//												if(NotificationListcheckbox_first.equals("Yes")){
//													try {
//														utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
//													} catch (Exception e) {}
//													
//												}else{
//													try {
//														utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, false);
//													} catch (Exception e) {}
//												}
//												
//												
//												
//											}else if(ChkBxValue.equals("2168")){
//												if(NotificationListcheckbox_scnd.equals("Yes")){
//													try {
//														utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, true);
//													} catch (Exception e) {}
//													
//												}else{
//													try {
//														utilfunc.enableOrDisableCheckbox(NewChkBoxXpath, false);
//													} catch (Exception e) {}
//												}
//												
//											}else{
//												System.out.println("please select the check box");
//											}
//										} catch (Exception e) {System.out.println("Check box not found");}
//										
//									}
									
									
									
									}}else if(AttributeName.equals("BeneficiaryAccessFlag")){
									
									if(BeneficiaryAccessFlag.equals("Yes")){
										
										try {
											Thread.sleep(1000);
											utilfunc.enableOrDisableCheckbox(NewXpath, true);
										} catch (Exception e) {}
										
									}else{
										try {
											utilfunc.enableOrDisableCheckbox(NewXpath, false);
										} catch (Exception e) {}
									}
									
									
								}else if(AttributeName.equals("NetworkPartnerAccessFlag")){
									
									if(NetworkPartnerAccessFlag.equals("Yes")){
										
										try {
											Thread.sleep(2000);
											utilfunc.enableOrDisableCheckbox(NewXpath, true);
											Thread.sleep(2000);
										} catch (Exception e) {
											System.out.println("Unable to click on ");
										}
										
									}else{
										try {
											Thread.sleep(2000);
											utilfunc.enableOrDisableCheckbox(NewXpath, false);
											Thread.sleep(2000);
										} catch (Exception e) {
											System.out.println("Unable to click on no");
										}
									}
									
									
								}
								
								else if(AttributeName.equals("Subject")){
									
									utilfunc.MakeElement(NewXpath).clear();
									
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Subject);
									} catch (Exception e) {}
									
									
								}else if(AttributeName.equals("MessageBody")){
									 try{
									WebDriverWait wait = new WebDriverWait(webdriver, 15);
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(I_FrameXpath)));
										webdriver.switchTo().frame(utilfunc.MakeElement(I_FrameXpath));
										System.out.println("Switched to frame");

										WebElement element = webdriver.findElement(By.cssSelector("body"));
										element.clear(); // clear the content of tiny mce editor
										element.sendKeys(MessageBody);
										System.out.println("SnippetHTML is set in tiny mce editor");
								       } catch(Exception e){
									 System.out.println("Unalbe to switch iframe");
								       }
									 try{
										 
										 webdriver.switchTo().defaultContent();
										 
										 
									 }catch(Exception s){
										 System.out.println("Unable to back to main window");
									 }
									
								}
								
								
								
								
							} catch (Exception e) {System.out.println("Unable to find the element");}
							
						
						
						}
						
						if(DocumentToBeUploaded=="Yes"){
							
						}else{

		                   	   System.out.println("Upload The document ");
//					   try{
//					   Thread.sleep(1000);
//					
//					   utilfunc.MakeElement(uploadDocFormBtnXPath).click();
//					   }catch(Exception e){
//					 	  System.out.println("unable to click on upload document button");
//					   }
//					   
//						  try{
//							  Thread.sleep(3000);
//						  utilfunc.MakeElement(selectAFileBtnXPath).click();
//						  System.out.println("yes clicked on button to upload files...");
//						  Thread.sleep(3000);
//						  }catch(Exception e){ System.out.println("unable to clcik on 'Select a file to upload' buuton"); }
//						  
//						  try{
//							  Thread.sleep(3000);
//					
//					       utilfunc.uploadfile(DocumentToBeUploaded);
//						  utilfunc.MakeElement(uploadDocBtnXPath).click();
//						  System.out.println("Document has been uploaded.");	
//						  }catch(Exception e){
//							  System.out.println("Error" +e);
//						  }
//							   				  
												
											}
											
										
									}
				
				if(mode.equals("Edit")){
					
					String SearchType =".//*[@id='SearchType']";
					String searchText =".//*[@id='SimpleSearchText']";
					String SearchbtnXpath=".//*[@id='SimpleSearch']//.[text()='Search']";
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchType, SearchTypeBal);
					} catch (Exception e) {System.out.println("Unabel to select the search type");}
				     utilfunc.MakeElement(searchText).clear();
					try {
						utilfunc.MakeElement(searchText).sendKeys(BalNumberSearch);
					} catch (Exception e) {System.out.println("Unable to enter the value");}
					
					String radiobuttoncounterXpath=".//*[@id='panel-body']//*[@class='radio inline']/input";
					String RadioButtonXpath=".//*[@id='panel-body']//*[@class='radio inline'][mm]/input";
					String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[4]//a";
					
					int radiobtnCount = utilfunc.GetObjectCount(radiobuttoncounterXpath);
					
					for(int m=1; m<=radiobtnCount; m++){
						
						String RadioBtnXpath =RadioButtonXpath.replace("mm", Integer.toString(m));
						
						try {
							String RadioBtnValue		=	utilfunc.MakeElement(RadioBtnXpath).getAttribute("value");
							
							System.out.println("RadioBtnValue - " + RadioBtnValue);
							
							if(RadioBtnValue.equals("14")){
								if(RadioButtonvalue.equals("Yes")){
								
								utilfunc.MakeElement(RadioBtnXpath).click();
								}
								else{
									utilfunc.MakeElement(RadioBtnXpath).click();
									
								}
							}else if(RadioBtnValue.equals("30")){
								if(RadioButtonvalue.equals("Yes")){
									
									utilfunc.MakeElement(RadioBtnXpath).click();
									}
									else{
										utilfunc.MakeElement(RadioBtnXpath).click();
										
									}
								
							}else if(RadioBtnValue.equals("")){
								if(RadioButtonvalue.equals("Yes")){
									
									utilfunc.MakeElement(RadioBtnXpath).click();
									}
									else{
										utilfunc.MakeElement(RadioBtnXpath).click();
										
									}
							}else{
								System.out.println("Radio button is not found.");
							}
							
							
							
						} catch (Exception e) {}
						
					}
					String Statusdropdown=".//*[@id='IsOpen']";
					
					try {
						Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(Statusdropdown, Status);
					} catch (Exception e2) {System.out.println("Unable to select the status");}
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(SearchbtnXpath).click();
						Thread.sleep(1000);
					} catch (Exception e1) {System.out.println("Unable to click on search button");}
					
					
					
				
					
					
					
					
					
					String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
	            		   utilfunc.scrollToTop();
	            		   
	            		   try {
	            			   Thread.sleep(1000);
							utilfunc.MakeElement(EditIconXpath).click();
							Thread.sleep(1000);
						} catch (Exception e) {}
	            		   
	            		   String ReplybtnXpath =".//*[contains(@class,'btn') and text()='Reply']";
	            		   try {
	            			   Thread.sleep(1000);
							utilfunc.MakeElement(ReplybtnXpath).click();
							Thread.sleep(1000);
						} catch (Exception e) {System.out.println("unable to click on the reply button");}
	            		   
	            		   

							 try{
							WebDriverWait wait = new WebDriverWait(webdriver, 15);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(I_FrameXpath)));
								webdriver.switchTo().frame(utilfunc.MakeElement(I_FrameXpath));
								System.out.println("Switched to frame");

								WebElement element = webdriver.findElement(By.cssSelector("body"));
								element.clear(); // clear the content of tiny mce editor
								element.sendKeys(MessageBody);
								System.out.println("SnippetHTML is set in tiny mce editor");
						       } catch(Exception e){
							 System.out.println("Unalbe to switch iframe");
						       }
							 try{
								 
								 webdriver.switchTo().defaultContent();
								 
								 
							 }catch(Exception s){
								 System.out.println("Unable to back to main window");
							 }
							
							 
							 if(DocumentToBeUploaded=="Yes"){
									
								}else{

				                   	   System.out.println("Upload The document ");
							   try{
							   Thread.sleep(1000);
							
							   utilfunc.MakeElement(uploadDocFormBtnXPath).click();
							   }catch(Exception e){
							 	  System.out.println("unable to click on upload document button");
							   }
							   
								  try{
									  Thread.sleep(3000);
								  utilfunc.MakeElement(selectAFileBtnXPath).click();
								  System.out.println("yes clicked on button to upload files...");
								  Thread.sleep(3000);
								  }catch(Exception e){ System.out.println("unable to clcik on 'Select a file to upload' buuton"); }
								  
								  try{
									  Thread.sleep(3000);
							
							       utilfunc.uploadfile(DocumentToBeUploaded);
								  utilfunc.MakeElement(uploadDocBtnXPath).click();
								  System.out.println("Document has been uploaded.");	
								  }catch(Exception e){
									  System.out.println("Error" +e);
								  }
									   				  
														
													}
													
						
	            		   

					
					
					
	            	}
				}
				
			
				
				
				
				try{
					 // save button after saving all data..
					String sendBtn	=	".//a[contains(@class,'btn') and text()='Send']";
		        	utilfunc.MakeElement(sendBtn).click();
				}
				catch(Exception e){}
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					//ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					 String Secure_Messaging_Xpath=".//*[@id='nav-parent']//*[@class='pull-right']//a[@id='nav-messages']";
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.equals("")){
						 Flag=true;
						 
						
						 
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(Secure_Messaging_Xpath).click();
							Thread.sleep(1000);
						 } catch (Exception e) {
							System.out.println("Unable to click on the button");
							
						}
						 webdriver.navigate().to(AttrLink);
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(Secure_Messaging_Xpath).click();
							Thread.sleep(1000);
						 } catch (Exception e) {
							System.out.println("Unable to click on the button");
							
						}
						 webdriver.navigate().to(AttrLink);
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
			}
			
		
			return Flag;
			}

}
