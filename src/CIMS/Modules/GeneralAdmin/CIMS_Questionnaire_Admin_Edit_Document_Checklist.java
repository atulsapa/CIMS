package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Questionnaire_Admin_Edit_Document_Checklist {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Questionnaire_Admin_Edit_Document_Checklist(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Edit_Document_Checklist(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module..");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String DocDesc                                      =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Company                                      =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			String No_of_subitem                                =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String subdesc                                      =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String subcompany                                   =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		    
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			
         int No_of_subitemTobeAdd=0;
			
			try{
				if((StringUtils.isEmpty(No_of_subitem)==false))
				{
					No_of_subitemTobeAdd	=	Integer.parseInt(No_of_subitem);
					
				}
				
			}catch(Exception e){}
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				
			    String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='NewCountryCode']";
				String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
				String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
				String EditCustomLabellinkXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//*[contains(@class,'dropdown-menu pull-right')]//li[3]//.[contains(text(),'Edit Document Checklist')]";
				
				
				try {
					utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
				} catch (Exception e) {}
				
				try {
					utilfunc.MakeElement(SearchBtn).click();
				} catch (Exception e) {}
				
				 try {
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
							Thread.sleep(4000);
							utilfunc.MakeElement(EditCustomLabellinkXpath).click();
							Thread.sleep(4000);
						} catch (Exception e) {}
					   }
				} catch (Exception e1) {}   
            		   Thread.sleep(1000);

            		   if(mode.equals("New")){
            			   
            			   String DocChkListRowXpath=".//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr[xx]"; 
            			   String DocChkListRowCounter=".//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr";
            			   String colXpath=   DocChkListRowXpath+"//td[yy]//*[@class and not(self::i) and not(self::ul) and not(self::li)]";
            			  // .//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr[4]//*[]
            			   
            			   String DOCDesXpathFirstrow=".//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr[1]//td[2]//*[@class and not(self::i) and not(self::ul) and not(self::li)]";
            			   String ComyDropdownXpath =".//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr[1]//td[3]//*[@class and not(self::i) and not(self::ul) and not(self::li)]";
            			   String AddNewLink =".//*[contains(@id,'btnAddItem')]//h5//strong//.[text()='+']";
            			   
            			   String AttributeName ="";
            			   
            			  
            			
            			try {
            				Thread.sleep(1000);
							utilfunc.MakeElement(AddNewLink).click();
							Thread.sleep(1000);
            			} catch (Exception e) {
							System.out.println("Unable to click on the add link..");
						}
            			
            			try {
							utilfunc.MakeElement(DOCDesXpathFirstrow).clear();
							utilfunc.MakeElement(DOCDesXpathFirstrow).sendKeys(DocDesc);
						} catch (Exception e) {
							System.out.println("Enter the value in fir row");
						}
            			 try {
            				 Thread.sleep(1000);
							utilfunc.Selectdropdownvaluebytext(ComyDropdownXpath, Company);
							Thread.sleep(1000);
            			 } catch (Exception e1) {
							System.out.println("Unable to slect the company");						}
            			   
            			 
            			 
            			 try {
							if(No_of_subitemTobeAdd>=1){
								 
								 
								 String SubitemAddbtnXpath =".//*[@id='form1']//*[contains(@class,'ulxref')]/li[4]//*[(@class='table_xref')]//tbody//tr[1]//td[4]//*[contains(@class,'btn')]//h6//strong[text()='+']";
							   for(int j=1;j<=No_of_subitemTobeAdd;j++){
								   System.out.println("value"+j+"record");
								   if(j>=1){
									   
									   try {
										   Thread.sleep(1000);
											utilfunc.MakeElement(SubitemAddbtnXpath).click();
											Thread.sleep(1000);
									   } catch (Exception e) {}
								   }
							 
							 
							int rowcount = utilfunc.GetObjectCount(DocChkListRowCounter);
							
							for(int i=2; i<=rowcount;i++){
								
								String Xpath ="";
								
                                try {
									Xpath = DocChkListRowXpath.replace("xx", Integer.toString(i));
									
									System.out.println("Row Xpath" + Xpath);
								} catch (Exception e) {
									System.out.println("Not able to count");
								}
                                
                                
								int colCounter = utilfunc.GetObjectCount(Xpath+"//td//*[@class and not(self::i) and not(self::ul) and not(self::li)]");
								
								for(int k=1; k<=colCounter;k++){

									
									try {
										String NewXpath1 = colXpath.replace("xx", Integer.toString(i));
										String NewXpath  = NewXpath1.replace("yy", Integer.toString(k));
										
									    AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("class");
										
										System.out.println("new Xpath" +" " + NewXpath);
										System.out.println("AttributeName" +" "+AttributeName);
										
										if(AttributeName.equals("fld-documentname")){
											
											try {
												utilfunc.MakeElement(NewXpath).clear();
												utilfunc.MakeElement(NewXpath).sendKeys(subdesc);
											} catch (Exception e) {
												System.out
														.println("Not able to enter the value");
											}
											
											
										}else if(AttributeName.equals("fld-documentname")){
											
											try {
												Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebytext(NewXpath, subcompany);
												Thread.sleep(1000);
											} catch (Exception e) {
												System.out
														.println("Unable to select the value");
											}
											
											
										}else{};
									} catch (Exception e) {
										System.out.println("not able to find the field");
									}
									
									
									
									
									
								}
								
								
								
								
								
							}
							
							
							

							}
							
							   
							  
							  
       		   }
						} catch (Exception e) {
							System.out.println("Error here");
						}
				
				
				
				
            			 System.out.println("Finaly Done hurre");
				
				
				
			}
            		   

						 try{
			 // save button after saving all data..
			String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
			Thread.sleep(1000);
      	try{utilfunc.MakeElement(saveBtn).click();}catch(Exception  e){}
      	System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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
		}catch(Exception e){
			Flag	=	false;
			System.out.println("Data is not saved because all fields are not set in the form.");
		}
			
            		   
            		   
            		   }
			return Flag;
			
			
			
	}
	
	}


