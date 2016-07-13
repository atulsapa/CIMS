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
			
			String No_of_docchklist                             =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		    
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
			
			int No_Of_DocChkListTobeAdd=0;
			
			try{
				if((StringUtils.isEmpty(No_of_docchklist)==false))
				{
					No_Of_DocChkListTobeAdd	=	Integer.parseInt(No_of_docchklist);
					
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
            			   
            			   String DocChkListRowXpath=".//*[@id='form1']//*[contains(@class,'ulxref')]//*[@class='table_xref']//tbody//tr[xx]//.[contains(@class,'main')]"; 
            			   String DocChkListRowCounter=".//*[@id='form1']//*[contains(@class,'ulxref')]//*[@class='table_xref']//tbody//tr//.[contains(@class,'main')]";
            			   
            			   if(No_Of_DocChkListTobeAdd>=1){
            				   
            				   String AddbtnXpath =".//*[contains(@id,'btn')]//strong";
            				   for(int j=1;j<=No_Of_DocChkListTobeAdd;j++){
            					   System.out.println("value"+j+"record");
            					   if(j>=2){
            						   
            						   try {
										utilfunc.MakeElement(AddbtnXpath).click();
									} catch (Exception e) {}
            					   }
            					   int counterXpath= utilfunc.GetObjectCount(DocChkListRowCounter);
                    			   
                    			   for(int i=1;i<=counterXpath;i++ )
                    			   {
                    				  System.out.println("==RowXpath=="+ DocChkListRowXpath);
                    			   }
            					   
            				   }
            			   }
            			   
            			
            			   
            			  
            			  
            		   }
				
				
				
				
				
				
				
				
			}
			return Flag;
	}
	}


