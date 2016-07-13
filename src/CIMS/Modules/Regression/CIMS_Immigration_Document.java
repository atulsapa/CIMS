package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Immigration_Document {



		private WebDriver webdriver;	// Will be Provide by Calling Class.	
		private UtilFunction utilfunc;	// Will be Provide by Calling Class.
		/**
		 * @param args
		 */

		public static String testcaseid="";
		 public static String scenerio="";
		 public static String description="";

		 
		 public CIMS_Immigration_Document(WebDriver driver,UtilFunction utilfunc) 
			{
			this.webdriver =driver;
			this.utilfunc=utilfunc;
			}
		 

		      public boolean Documents(String filename, String sheetName,int ColumnCounter,String mode,String current_baseurl) throws AWTException, InterruptedException{

				boolean Flag	=	false;

				String FieldXpath						=".//*[@id='form1']//*[@class='control-group']";
				String FormFieldXpath					=".//*[@id='form1']//*[@class='control-group'][bb]//*[@name]"; 

				String AuthorizedWorkCityProvinceX		=".//*[@id='form1']//*[@class='control-group']//*[@id='AuthorizedWorkCityOrProvince']";
				
				String IssueDateXpath			=	".//*[@id='form1']//*[@class='controls dates']//*[@name='IssueDate']";
				String ExpirationDateXpath  	= 	".//*[@id='form1']//*[@class='controls dates']//*[@name='ExpirationDate']";
				String StartDateXpath     		=	".//*[@id='form1']//*[@class='controls dates']//*[@name='StartDate']";
				String EndDateXpath				=	".//*[@id='form1']//*[@class='controls dates']//*[@name='EndDate']";
				
				
				String Addbtn					=	".//*[@id='form1']//*[@class='control-group'][6]//*[contains(text(),'Add') and contains(@class,'btn')]";
				
				String TrueSufix				=	"//.[@value='True']";
				String FalseSufix				=	"//.[@value='False']";
				
				String uploadDocFormBtnXPath	=	"//*[@id='form1']//*[@id='btnShowDocUpload']";
				String selectAFileBtnXPath		=	".//*[@id='DocUploadModal']//*[@class='controls']//button[1]";
				String uploadDocBtnXPath		=	".//*[@class='controls']//*[@id='btnUploadDocuments']";
				String saveBtn					=	".//*[@id='form1']//*[contains(@class,'btn') and text()='Save']";

				
				System.out.println("user is on '"+sheetName+"' module...");
				System.out.println("entering "+mode+" mode for "+sheetName+" module.");
				
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String Name                                         =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String AuthorizedWorkCityOrProvince                 =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String DocumentNumber                               =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String DocumentTypeId                               =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String ClassificationId                             =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			    String ProjectsAssociated                           =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
		        String IssueDate                                    =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String ExpirationDate                               =           UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String StartDate                                    =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String EndDate                                      =           UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String LegalStatusCode                              =           UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String IssuingAgency                                =           UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String IssuedAtCity                                 =           UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String IssuedAtStateOrProvince                      =           UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String IssuedAtCountryCode                          =           UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String TermsAndCondtions                                  =           UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String Tracking                            =           UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				String Sponsor                                     =           UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String ReceiptNumber                                      =           UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				String BeneficiaryNumber                                =           UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
				String Intermittent                            =           UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
				String NoExpirationDate                                 =           UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
				String Renewing                             =           UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
				String DocumentToBeUploaded                                     =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
				String ExpectedErrorMessage                         =           UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
				//String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);

				if(TestcaseRunMode.equals("Y")){

					testcaseid		=		TestcaseID;
					scenerio		=		Scenario;
					description		=		TestCaseDescription;
					
					if(mode.equals("Delete")){

						String DeleteXPath	=	".//*[contains(@id,'Document')]//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Delete Record')]";
								// now code for delete button here...
						System.out.println("now code for delete button here...");
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(DeleteXPath).click();
							Thread.sleep(1000);
							utilfunc.isAlertPresent();

						} catch (Exception e) {
						
							System.out.println("Unable to delete the record");
						}
						
						}
					
					if(mode.equals("New") || mode.equals("Edit")){
						String DocEditXpath=".//*[contains(@id,'Document')]//tbody/tr[2]//*[contains(@class,'btn-group')]//ul/li//*[contains(text(),'Edit')]";
						
						System.out.println("Now code here for Edit button");
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(DocEditXpath).click();
							Thread.sleep(1000);
							} catch (Exception e) {
						
							System.out.println("Unable to Edit the record");
						}
						
						
						
						

				

                try{
				utilfunc.MakeElement(AuthorizedWorkCityProvinceX).sendKeys(AuthorizedWorkCityOrProvince);}catch(Exception error){}

                
                try{ 
                utilfunc.MakeElement(IssueDateXpath).sendKeys(IssueDate);}catch(Exception error){}
                try{
                utilfunc.MakeElement(ExpirationDateXpath).sendKeys(ExpirationDate);}catch(Exception error){}
                try{
                utilfunc.MakeElement(StartDateXpath).sendKeys(StartDate);}catch(Exception error){}
                try{
                utilfunc.MakeElement(EndDateXpath).sendKeys(EndDate);}catch(Exception error){}



				int counta=0;
				 counta=utilfunc.GetObjectCount(FieldXpath);
				  for(int a=1; a<=counta; a++){

					  Thread.sleep(900);

					String NewXpath=FormFieldXpath.replace("bb",Integer.toString(a));
					System.out.println("Print NeWxPATH"+ ""+ NewXpath);
					String AttributeName="";

					try{
					AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
					System.out.println("Print AttributeName" +""+AttributeName);
					}catch(Exception e){
						System.out.println("Error Message" +e);
					}
					if(AttributeName.equalsIgnoreCase("CountryCode")){
						
						try {
							utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
							utilfunc.scrollToTop();
						} catch (Exception e) {
							System.out.println("unable to select country code");
						}
//						Thread.sleep(200);
//						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
					    System.out.println("Country has been selected");
					    utilfunc.scrollToTop();					    
					    }
					
					

					
					
					// document number
					else if (AttributeName.equals("DocumentNumber")){
						utilfunc.MakeElement(NewXpath).clear();
						utilfunc.MakeElement(NewXpath).sendKeys(DocumentNumber);
					}else if (AttributeName.equalsIgnoreCase("DocumentTypeId")){
					     
					     try {
							utilfunc.Selectdropdownvaluebytext(NewXpath, DocumentTypeId);
						} catch (Exception e) {
							System.out.println("unable to select document number");
						}
//					     Thread.sleep(200);
//					     utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
					     System.out.println("ClassificationId has been selected");
						
					      }
					else if (AttributeName.equalsIgnoreCase("ClassificationId")){
//					     utilfunc.MakeElement(NewXpath).click();
//					     Thread.sleep(200);
					     utilfunc.Selectdropdownvaluebytext(NewXpath, ClassificationId);
					     Thread.sleep(200);
//					     utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
					     System.out.println("ClassificationId has been selected");
						
					      }
					else if (AttributeName.equals("ProjectsAssociated")){
//					     utilfunc.MakeElement(NewXpath).click();
//					     Thread.sleep(200);
					     utilfunc.Selectdropdownvaluebytext(NewXpath, ProjectsAssociated);
					     Thread.sleep(200);
//					     utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
					     System.out.println("ClassificationId has been selected");
					     
					     
					     utilfunc.MakeElement(Addbtn).click();
					     System.out.println("Value has been added");
					     
					     utilfunc.scrollToBottom();
					     
						}else if (AttributeName.equals("LegalStatusCode")){
//						    		utilfunc.MakeElement(NewXpath).click();
						    		
						    		Thread.sleep(300);
						    		utilfunc.Selectdropdownvaluebytext(NewXpath, LegalStatusCode);
//						    		Thread.sleep(300);
//						    		utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						    		System.out.println("LegalStatusCode has been selected");
						    		}
						else if(AttributeName.equals("IssuingAgency")){
							utilfunc.MakeElement(NewXpath).clear();
			    			utilfunc.MakeElement(NewXpath).sendKeys(IssuingAgency);
			    			
			    		}
						else if(AttributeName.equals("IssuedAtCity")){
							utilfunc.MakeElement(NewXpath).clear();
						    			utilfunc.MakeElement(NewXpath).sendKeys(IssuedAtCity);
						    			
						    		}else if(AttributeName.equals("IssuedAtStateOrProvince")){
						    			utilfunc.MakeElement(NewXpath).sendKeys(IssuedAtStateOrProvince);
						    			
						    			
						    		}else if (AttributeName.equals("IssuedAtCountryCode")){
						    			
						              utilfunc.MakeElement(NewXpath).click();
						              Thread.sleep(200);
						              utilfunc.Selectdropdownvaluebytext(NewXpath, IssuedAtCountryCode);
						              Thread.sleep(200);
						              utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						              System.out.println("Issue country has been selected");
						    		}else if(AttributeName.equals("TermsAndCondtions")){
						    			utilfunc.MakeElement(NewXpath).clear();
						    			utilfunc.MakeElement(NewXpath).sendKeys(TermsAndCondtions);
						    		}else if(AttributeName.equalsIgnoreCase("Tracking")){
						    			Thread.sleep(1000);
						    			try{
										if(Tracking.equalsIgnoreCase("Yes")){
											utilfunc.MakeElement(NewXpath+TrueSufix).click();
										}else{
											utilfunc.MakeElement(NewXpath+FalseSufix).click();
										}
										}catch(Exception error){
											
										}
										}else if (AttributeName.equals("Sponsor")){
											utilfunc.MakeElement(NewXpath).clear();
								    		utilfunc.MakeElement(NewXpath).sendKeys(Sponsor);
								    		}else if (AttributeName.equals("ReceiptNumber")){
								    			try{
								    				utilfunc.MakeElement(NewXpath).clear();
									    		utilfunc.MakeElement(NewXpath).sendKeys(ReceiptNumber);
									    		
								    			}catch(Exception error){}}
								    		else if (AttributeName.equals("BeneficiaryNumber")){
								    			utilfunc.scrollToBottom(); //in order to make sure that it scroll downs the page & find all elements
								    			Thread.sleep(1000);
								    			utilfunc.MakeElement(NewXpath).clear();
									    		utilfunc.MakeElement(NewXpath).sendKeys(BeneficiaryNumber);
									    		}
					                  
											else if (AttributeName.equalsIgnoreCase("Intermittent")){
												try{
											       Thread.sleep(1000);
												if(Intermittent.equalsIgnoreCase("Yes")){
													 Thread.sleep(1000);
													utilfunc.MakeElement(NewXpath+TrueSufix).click();
												}else{
													utilfunc.MakeElement(NewXpath+FalseSufix).click();
												}}catch(Exception error){}
											    System.out.println("Value has been selected");
											}else if(AttributeName.equals("NoExpirationDate")){
									    			
									    			Thread.sleep(1000);
													try{
													if(NoExpirationDate.equalsIgnoreCase("Yes")){
														Thread.sleep(1000);
														utilfunc.MakeElement(NewXpath+TrueSufix).click();
													}else{
														utilfunc.MakeElement(NewXpath+FalseSufix).click();
													}}catch(Exception error){}
									    		}else if(AttributeName.equalsIgnoreCase("Renewing")){
									    			try{
									    			Thread.sleep(500);
									    			utilfunc.Selectdropdownvaluebytext(NewXpath, Renewing);
													Thread.sleep(200);
												    System.out.println("Value has been selected");
									    			}catch(Exception error){}}
									    		else{
									    			System.out.println("Please fill all the mandatory fields.");
									    		}
				                          }
					                     System.out.println("Upload The document ");
					                     if(DocumentToBeUploaded==null){}
					   				  else{
					                   	   System.out.println("Upload The document ");
			      try{
			      Thread.sleep(1000);

			      utilfunc.MakeElement(uploadDocFormBtnXPath).click();
			      }catch(Exception e){
			    	  System.out.println("unable to click on upload document button");
			      }
			      
				  try{
					  Thread.sleep(1000);
				  utilfunc.MakeElement(selectAFileBtnXPath).click();
				  System.out.println("yes clicked on button to upload files...");
				  Thread.sleep(1000);
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

					 try{
	    	        	try{
	    	        		Thread.sleep(500);
						utilfunc.MakeElement(saveBtn).click();
						Thread.sleep(500);
						}
	    	        	catch(Exception error){
	    	        		System.out.println("some error during click save button" + error);
	    	        		}
						//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
							 webdriver.get(current_baseurl);
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;
							 webdriver.navigate().back();
						 }else if ((error_flag.contains("Error!"))||(error_flag.contains("Please"))){
								Flag=false;
								utilfunc.TakeScreenshot();
								Thread.sleep(500);
								webdriver.get(current_baseurl);
							}
							else{
								Flag=false;
								utilfunc.TakeScreenshot();
								webdriver.get(current_baseurl);
							}
					}catch(Exception e){
						Flag	=	false;
						System.out.println("Data is not saved because all fields are not set in the form.");
					}

				}
				return Flag;

	}

		      }
