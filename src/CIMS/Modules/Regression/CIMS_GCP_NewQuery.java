package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_GCP_NewQuery {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 private static String GCPNewQueryTitleXpath="//*[@id='panel-header']";

	 
	
		
	 
	 public CIMS_GCP_NewQuery(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean GCP_NewQuery_Initiation_Page(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module..");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			 String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			 String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			 String Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			 String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			 String GCPDestinationcountry	                    =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			 String Email                                       =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			 String GCPFirstName                                =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			 
			 String GCPLastName                                 =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			
			 String GCPEmail                                    =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			 String sCoordinator                                =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			 String GCPEmployeeID                               =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			 String GCPNationalityCountry                       =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			 
			 String GCPSPecialVisa                              =           UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			 String GCPSPecialVisaPermit                        =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			 
			 String GCPDestinationOriginCountryCode             =           UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			 String GCPDestinationCountryCode                   =           UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			 
			 String GCPDestinationCity                          =           UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
			 String GCPDestinationPurposeId                     =           UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
			 
			 String GCPDestinationDateOfArrival                 =           UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
			
			 String GCPDestinationDateOfDeparture               =           UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
			
			 String ExpectedErrorMessage						=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				Robot robot = new Robot();
				
				
				String GCPHeaderTitle=utilfunc.MakeElement(GCPNewQueryTitleXpath).getText();	
				String CompanyXpath =".//*[@id='CompanyList']";
				
				String FindTravelerBtnXpath=".//*[contains(@class,'btn') and text()='Find Traveler']";
				String SelectRecordXpath =".//*[@id='divContactListPartial']//*[@class='table table-item-list']//tbody//tr[1]//td[5]";
				String SearchBtnXpath =".//*[contains(@class,'btn') and text()='Search']";
				String FirstNameXpath =".//*[@class='controls']//*[@class='control-group'][1]//input";
				String LastNameXpath =".//*[@class='controls']//*[@class='control-group'][2]//input";
				String GCPEmployeeIDXpath=".//*[@id='txtEmployeeNumber']";
				String GCPNationalityCountryXpath=".//*[@id='Nationality']";
				String AddBtnXpath ="//*[@id='form1']//*[contains(@class,'control-group')][4]//*[contains(@class,'controls')]//*[contains(@class,'btn') and text()='Add']";
				String AddNewDestinationButtontXpath=".//*[@id='new-destination-trigger']";
				String AddDescXpath =".//*[@id='tblDestination']//tbody//tr[4]//*[contains(@class,'btn') and text()='Add ']";
				//String PurposeIdXpath =".//*[@id='tblDestination']/tbody/tr[4]/td[2]/div[3]/div[2]/div[1]/ul/li[8]";
				if(mode.equals("New")){
					if (GCPHeaderTitle.equalsIgnoreCase(GCPHeaderTitle)){
					
						try {
							utilfunc.Selectdropdownvaluebyvalue(CompanyXpath, GCPDestinationcountry);
						} catch (Exception e2) {
							
						}
						
						try {
							
						    Thread.sleep(800);
							utilfunc.MakeElement(FindTravelerBtnXpath).click();
						} catch (Exception e) {
							System.out.println("Unable to clicked on the find travler btn");
						}
						
						String FindTravlerCounterXpath =".//*[@id='ContactSearchModal']//*[@class='modal-body']//*[contains(@class,'control-group')]//*[@id]";
						String FindTravlerXpath =".//*[@id='ContactSearchModal']//*[@class='modal-body']//*[contains(@class,'control-group')][xx]//*[@id]";
						
						int ResultCountXpath = utilfunc.GetObjectCount(FindTravlerCounterXpath);
						
						for(int i=1; i<=ResultCountXpath; i++){
							
							Thread.sleep(1000);
							
							String NewXpath = FindTravlerXpath.replace("xx",Integer.toString(i));
							
						    String Attr_Name=utilfunc.MakeElement(NewXpath).getAttribute("id");
						    
						    System.out.println("SearchTravlerXpath is" + NewXpath);
						    System.out.println("Attr_Name is" + Attr_Name);
						    
						    if(Attr_Name.equalsIgnoreCase("sEmail")){
						    	
						    	utilfunc.MakeElement(NewXpath).clear();
						    	utilfunc.MakeElement(NewXpath).sendKeys(Email);
						    }
//						    else if(Attr_Name.equalsIgnoreCase("sFname")){
//						    	
//						    	utilfunc.MakeElement(NewXpath).clear();
//						    	utilfunc.MakeElement(NewXpath).sendKeys(GCPFirstName);
//						    	
//						    }else if(Attr_Name.equalsIgnoreCase("sLname")){
//							
//						    utilfunc.MakeElement(NewXpath).clear();
//					    	utilfunc.MakeElement(NewXpath).sendKeys(GCPLastName);
//						}else if(Attr_Name.equalsIgnoreCase("sCoordinatorFlag")){
//							if(sCoordinator.equals("Yes")){
//								
//							  try {
//								utilfunc.enableOrDisableCheckbox(NewXpath, true);
//							} catch (Exception e) {
//								System.out.println("Unable to click on the check box");
//							}
//							}else{
//								utilfunc.enableOrDisableCheckbox(NewXpath, false);
//							}
//						}
						    else{
							System.out.println("please search the record from here");
						}
						
						}
						
						try {
							Thread.sleep(2000);
							utilfunc.MakeElement(SearchBtnXpath).click();
							Thread.sleep(2000);
						} catch (Exception e) {
							System.out.println("Unable to click on the search button");
						}
						
						
						 String NorecordXpath=".//*[@id='divContactListPartial']//*[@class='table table-item-list']//tbody//tr[2]//td[1]";
		            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
		            	 if(RecordNotFound.equalsIgnoreCase("No Results Found.")){
		            		  
		            		Flag=false;
		  					return Flag;
		            	   }else{
		            		   utilfunc.scrollToTop();
		            		   
		            		   try {
		            			   Thread.sleep(2000);
								utilfunc.MakeElement(SelectRecordXpath).click();
								Thread.sleep(2000);
							} catch (Exception e) {}
		            		   
		            		
						try {
							
							utilfunc.MakeElement(FirstNameXpath).clear();
							Thread.sleep(2000);
							utilfunc.MakeElement(FirstNameXpath).sendKeys(GCPFirstName);
						} catch (Exception e1) {
						}
						
						
						
						Thread.sleep(2000);
						 try {
							utilfunc.MakeElement(LastNameXpath).clear();
							 utilfunc.MakeElement(LastNameXpath).sendKeys(GCPLastName);
						} catch (Exception e1) {
							
						}
						 Thread.sleep(2000);
						 try {
							utilfunc.MakeElement(".//*[@id='txtEmployeeNumber']").clear();
							 utilfunc.MakeElement(".//*[@id='txtEmployeeNumber']").sendKeys(GCPEmail);
						} catch (Exception e1) {
							
						}
						 Thread.sleep(2000);
						 try {
							utilfunc.MakeElement(GCPEmployeeIDXpath).clear();
							 utilfunc.MakeElement(GCPEmployeeIDXpath).sendKeys(GCPEmployeeID);
						} catch (Exception e1) {
							
						}
						 
						
						 //utilfunc.Selectdropdownvaluebyvalue(GCPNationalityCountryXpath, GCPNationalityCountry);
						 Thread.sleep(3000);
						 String Country_CodeNewXpath="//*[@id='form1']//*[contains(@class,'control-group')][4]//*[contains(@class,'controls')]//select[@name]";
							//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
							if(StringUtils.isEmpty(GCPNationalityCountry)==false){
								String[] split = GCPNationalityCountry.split(",");
								System.out.println(split.length);
								for (int Country_Code = 0; Country_Code < split.length; Country_Code++) {
									String AddXpath=AddBtnXpath.replace("yy", Integer.toString(Country_Code));
									//System.out.println(doc_NewXpath);
									System.out.println(split[Country_Code].trim()+"---");
									Thread.sleep(400);
									try {
										Thread.sleep(2000);
										
										utilfunc.Selectdropdownvaluebyvalue(Country_CodeNewXpath,split[Country_Code].trim());
										Thread.sleep(2000);
									} catch (Exception e) {
										
									}
									try {
										Thread.sleep(2000);
										utilfunc.MakeElement(AddXpath).click();
										Thread.sleep(2000);
									} catch (Exception e) {
										
									}
								}
							}
							
							Thread.sleep(4000);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(AddNewDestinationButtontXpath).click();
								Thread.sleep(2000);
							} catch (Exception e) {
								System.out.println("Unable to click on the link");
							}
							
							String NewDestinationCounter=".//*[@id='tblDestination']//tbody//tr//*[@name]";
							String NewDestinationXpath =".//*[@id='tblDestination']//tbody//tr[ww]//*[@name]";
							String NewDestination;
							String AttributeName;
							
							int resultcountDestation = utilfunc.GetObjectCount(NewDestinationCounter);
							
							for(int k=1; k<=resultcountDestation; k++){
								
								NewDestination = NewDestinationXpath.replace("ww", Integer.toString(k));
								
								AttributeName =utilfunc.MakeElement(NewDestination).getAttribute("name");
								
								System.out.println("AttributeName  is" +" "+AttributeName);
								
								if(AttributeName.equals("form_OriginCountryCode")){
									
									utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationOriginCountryCode);
								}else if(AttributeName.equals("form_DestinationCountryCode")){
									
									utilfunc.Selectdropdownvaluebyvalue(NewDestination, GCPDestinationCountryCode);
									
								}else if(AttributeName.equals("form_DestinationCity")){
									
									utilfunc.MakeElement(NewDestination).click();
									
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
									
									utilfunc.MakeElement(AddDescXpath).click();
								}
								
								else if(AttributeName.equals("form_DateOfArrival")){		
									utilfunc.MakeElement(NewDestination).clear();
									
									utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfArrival);
								}
								else if(AttributeName.equals("form_DateOfDeparture")){
									utilfunc.MakeElement(NewDestination).clear();
									
									utilfunc.MakeElement(NewDestination).sendKeys(GCPDestinationDateOfDeparture);
									
								}
								
								
							}
							
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(".//*[contains(@class,'btn') and text()='Add This Destination To Your List']").click();
							} catch (Exception e) {
								System.out.println("Unable to click on the Add button");
							}
						 
						 
						
				
							
								
								
					
					
					
				}
			}
					}
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Finish']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
				
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
				//	ExpectedErrorMessage=ExpectedErrorMessage.trim();
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
				
			
				}
			return Flag;
			}

}
