package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Travel_History {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Travel_History(WebDriver driver,UtilFunction utilfunc) {
	    	  {
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    			}
	}


		public boolean Travel_History(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String GCPDestinationOriginCountryCode              =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String GCPDestinationCountryCode                    =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			 
			String GCPDestinationCity                           =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String GCPDestinationPurposeId                      =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			 
		    String GCPDestinationDateOfArrival                  =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			String GCPDestinationDateOfDeparture                =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String Note							                =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				String AddNewDestinationButtontXpath=".//*[@id='new-destination-trigger']";
				String AddDescXpath =".//*[@id='tblDestination']//tbody//tr[4]//*[contains(@class,'btn') and text()='Add ']";
				String NoteXpath =".//*[@id='Note']";
				
				String AddNewXpath = ".//*[@id='panel-body-container']/div[2]/div[1]/div[2]/a";
				String NewDestinationCounter=".//*[@id='tblDestination']//tbody//tr//*[@name]";
				String NewDestinationXpath =".//*[@id='tblDestination']//tbody//tr[ww]//*[@name]";
				String NewDestination;
				String AttributeName;
				
				if(mode.equals("New")){
					
					try {
						utilfunc.MakeElement(AddNewXpath).click();
					} catch (Exception e1) {
						
					}
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(AddNewDestinationButtontXpath).click();
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.println("Unable to click on the link");
					}
					
//					String NewDestinationCounter=".//*[@id='tblDestination']//tbody//tr//*[@name]";
//					String NewDestinationXpath =".//*[@id='tblDestination']//tbody//tr[ww]//*[@name]";
//					String NewDestination;
//					String AttributeName;
					
					int resultcountDestation = utilfunc.GetObjectCount(NewDestinationCounter);
					
					for(int k=1; k<=resultcountDestation; k++){
						
						NewDestination = NewDestinationXpath.replace("ww", Integer.toString(k));
						
						AttributeName =utilfunc.MakeElement(NewDestination).getAttribute("name");
						
						System.out.println("AttributeName  is" +" "+AttributeName);
						
						if(AttributeName.equals("form_OriginCountryCode")){
							
							try {
								utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationOriginCountryCode);
							} catch (Exception e) {
								
							}
						}else if(AttributeName.equals("form_DestinationCountryCode")){
							
							try {
								utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationCountryCode);
							} catch (Exception e) {
								
							}
							
						}else if(AttributeName.equals("form_DestinationCity")){
							
							utilfunc.MakeElement(NewDestination).clear();
							
							utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationCity);
						}
						
						else if(AttributeName.equals("form_PurposeId")){
							Thread.sleep(1000);
							try {
								utilfunc.MakeElement(".//*[@id='form_PurposeId']").click();
							} catch (Exception e) {
								
							}
							Thread.sleep(2000);
							try {
								utilfunc.MakeElement("//*[@class='purpose-options']//*[text()='"+ GCPDestinationPurposeId +"']").click();
							} catch (Exception e) {
								
							}
							Thread.sleep(1500);
							
							try {
								utilfunc.MakeElement(AddDescXpath).click();
							} catch (Exception e) {
								
							}
						}
						
						else if(AttributeName.equals("form_DateOfArrival")){		
							utilfunc.MakeElement(NewDestination).clear();
							
							try {
								utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfArrival);
							} catch (Exception e) {
								
							}
						}
						else if(AttributeName.equals("form_DateOfDeparture")){
							utilfunc.MakeElement(NewDestination).clear();
							
							try {
								utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfDeparture);
							} catch (Exception e) {
								}
							
						}
						
						
					}
					utilfunc.MakeElement(NoteXpath).clear();
					utilfunc.MakeElement(NoteXpath).sendKeys(Note);
					
					
				}
				if(mode.equals("Edit")){
					
					try{
						

		            	System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
		      			System.out.println("search ....");
		      			String SearchCreatedDateFromXpath=".//*[contains(@id,'CreatedDateFrom')]//.[contains(@class,'hasDatepicker')]";
	                  	String SearchtxttodateXpath=".//*[contains(@id,'txttodate')]//.[contains(@class,'hasDatepicker')]";
	                  	String SearchBtn=".//*[contains(@class,'btn') and contains(text(),'Search')]";
		            	  try {
							Thread.sleep(1000);
							
			            	  utilfunc.MakeElement(SearchCreatedDateFromXpath).clear();
			            	  utilfunc.MakeElement(SearchCreatedDateFromXpath).sendKeys(GCPDestinationDateOfArrival);
			            	  Thread.sleep(3000);
						} catch (Exception e1) {
							
						}
		            	  Thread.sleep(500);
		            	  utilfunc.MakeElement(SearchtxttodateXpath).clear();
		            	  utilfunc.MakeElement(SearchtxttodateXpath).sendKeys(GCPDestinationDateOfDeparture);
		            	  Thread.sleep(3000);
		            	  try {
							utilfunc.MakeElement(SearchBtn).click();
						} catch (Exception e1) {}
		            	 try {
							String NorecordXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//*[@id='searchpanel']//tbody//tr[1]//td[1]";
							 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
							 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
								  
								Flag=false;
								return Flag;
							   }else{
								   utilfunc.scrollToTop();
								   String EditFirstRecordXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//*[@id='searchpanel']//tbody//tr[1]//td[2]//a";
								   try{
									   Thread.sleep(2000);
								   utilfunc.MakeElement(EditFirstRecordXpath).click();
								  System.out.println("===="+EditFirstRecordXpath+"====="+"Clicked on the same");
								   }catch(Exception e){
									   System.out.println("unable to clicked on edit");
								   }
							      Thread.sleep(3000);
							      
							      String EditIconXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//.[contains(@id,'destination-tbody')]//tr[3]//*[contains(@class,'edit')]";
							      
							      try {
							    	  Thread.sleep(1000);
									utilfunc.MakeElement(EditIconXpath).click();
								} catch (Exception e1) {
									System.out.println(" Unable to click on the same.");
								}
							      
								  
							      int resultcountDestation = utilfunc.GetObjectCount(NewDestinationCounter);
								      for(int i=1; i<=resultcountDestation; i++){
										
										NewDestination = NewDestinationXpath.replace("ww", Integer.toString(i));
										
										AttributeName =utilfunc.MakeElement(NewDestination).getAttribute("name");
										
										System.out.println("AttributeName  is" +" "+AttributeName);
										
										if(AttributeName.equals("form_OriginCountryCode")){
											
											try {
												utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationOriginCountryCode);
											} catch (Exception e) {
												
											}
										}else if(AttributeName.equals("form_DestinationCountryCode")){
											
											try {
												utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationCountryCode);
											} catch (Exception e) {
												
											}
											
										}else if(AttributeName.equals("form_DestinationCity")){
											
											utilfunc.MakeElement(NewDestination).clear();
											
											utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationCity);
										}
										
										else if(AttributeName.equals("form_PurposeId")){
											Thread.sleep(1000);
											try {
												utilfunc.MakeElement(".//*[@id='form_PurposeId']").click();
											} catch (Exception e) {
												
											}
											Thread.sleep(2000);
											try {
												utilfunc.MakeElement("//*[@class='purpose-options']//*[text()='"+ GCPDestinationPurposeId +"']").click();
											} catch (Exception e) {
												
											}
											Thread.sleep(1500);
											
											try {
												utilfunc.MakeElement(AddDescXpath).click();
											} catch (Exception e) {
												
											}
										}
										
										else if(AttributeName.equals("form_DateOfArrival")){		
											utilfunc.MakeElement(NewDestination).clear();
											
											try {
												utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfArrival);
											} catch (Exception e) {
												
											}
										}
										else if(AttributeName.equals("form_DateOfDeparture")){
											utilfunc.MakeElement(NewDestination).clear();
											
											try {
												utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfDeparture);
											} catch (Exception e) {
												}
											
										}
										
										
									}
								      
								    utilfunc.MakeElement(NoteXpath).clear();
									utilfunc.MakeElement(NoteXpath).sendKeys(Note);
							
							  }
						} catch (Exception e) {
							System.out.println("Record not found");
						}
		            	  
		            	  
						
						
					}catch(Exception e){}
					
					
					
				}
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()=' Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
				
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessageGCPTravelHistoyhandlerExperiment();
				    ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"====");
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
					

					System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
	      			System.out.println("search ....");
	      			String SearchCreatedDateFromXpath=".//*[contains(@id,'CreatedDateFrom')]//.[contains(@class,'hasDatepicker')]";
                  	String SearchtxttodateXpath=".//*[contains(@id,'txttodate')]//.[contains(@class,'hasDatepicker')]";
                  	String SearchBtn=".//*[contains(@class,'btn') and contains(text(),'Search')]";
                  	try {
						Thread.sleep(1000);
						
		            	  utilfunc.MakeElement(SearchCreatedDateFromXpath).clear();
		            	  utilfunc.MakeElement(SearchCreatedDateFromXpath).sendKeys(GCPDestinationDateOfArrival);
		            	  Thread.sleep(3000);
					} catch (Exception e1) {
						
					}
	            	  Thread.sleep(500);
	            	  utilfunc.MakeElement(SearchtxttodateXpath).clear();
	            	  utilfunc.MakeElement(SearchtxttodateXpath).sendKeys(GCPDestinationDateOfDeparture);
	            	  Thread.sleep(3000);
	            	  try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e1) {}
	            	  String NorecordXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//*[@id='searchpanel']//tbody//tr[1]//td[1]";
		            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
		            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
		            		  
		            		Flag=false;
		  					return Flag;
		            	   }else{
		            		   utilfunc.scrollToTop();
       					System.out.println("Record founded. we are going to delete it.");
       					try{ 
       						
       						String EditFirstRecordXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//*[@id='searchpanel']//tbody//tr[1]//td[2]//a";
						   try{
							   Thread.sleep(2000);
						   utilfunc.MakeElement(EditFirstRecordXpath).click();
						  System.out.println("===="+EditFirstRecordXpath+"====="+"Clicked on the same");
						   }catch(Exception e){
							   System.out.println("unable to clicked on edit");
						   }
       						
       						
       						
       						Thread.sleep(2000);
       						String DeleteBtnXpath=".//*[@id='form1']//*[contains(@class,'form-horizontal')]//.[contains(@id,'destination-tbody')]//tr[3]//*[contains(@class,'trash')]";
       						utilfunc.MakeElement(DeleteBtnXpath).click();
       						Thread.sleep(300);
       						Alert alt= webdriver.switchTo().alert();
       						alt.accept();
       						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
       						
       						String  error_flag="";
       						ExpectedErrorMessage=ExpectedErrorMessage.trim();
       						System.out.println("==="+ExpectedErrorMessage+"===");
       						System.out.println("==="+error_flag+"===");
       						try{
       							error_flag=utilfunc.ErrorMessageGCPTravelHistoyhandlerExperiment();}
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
