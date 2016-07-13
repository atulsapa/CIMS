package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.bouncycastle.eac.EACException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Company_Add_Business_Units {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	private CIMS_Company_PrimaryCompanyRoles obj_CIMS_Company_PrimaryCompanyRoles;
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public CIMS_Company_Add_Business_Units(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;
	
	
	}
	
	//for Company - Primary Company Roles page 
		public void setobj_CIMS_Company_PrimaryCompanyRoles(CIMS_Company_PrimaryCompanyRoles setobj_CIMS_Company_PrimaryCompanyRoles){
			this.obj_CIMS_Company_PrimaryCompanyRoles=setobj_CIMS_Company_PrimaryCompanyRoles;
		}
		
	  public boolean Businessunit_info(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		  
			setobj_CIMS_Company_PrimaryCompanyRoles(new CIMS_Company_PrimaryCompanyRoles(webdriver, utilfunc));
			
		  System.out.println("User is on "+sheetName+" Module..");
			boolean Flag	=	false;

	//Excel sheet Data collection
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String BusinessUnitName								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Notes								        =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			String EditBusinessUnitName						    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String EditNotes					             	=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);

			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			//String BusinessUnit                                 =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				
				System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
			
			if(mode.equalsIgnoreCase("New")){
				
				try{
					String AddNewBusinessUnit	=	".//a[contains(@class,'btn') and text()='Add Business Unit']";
					utilfunc.MakeElement(AddNewBusinessUnit).click();
					System.out.println("======Click on the AddNewBusinessUnit======");
				}catch(Exception e){
					System.out.println("unable to click on add new button");
				}
				
				try{
					String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
					String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){
						Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						if(AttributeName.equals("BusinessUnitName")){
							utilfunc.MakeElement(NewXpath).clear();
							utilfunc.MakeElement(NewXpath).sendKeys(BusinessUnitName);
						    System.out.println("======Enter the BusinessUnit Name in input field======");
							
						}
						else if(AttributeName.equals("Notes")){
							utilfunc.MakeElement(NewXpath).clear();
							utilfunc.MakeElement(NewXpath).sendKeys(Notes);
						    System.out.println("======Enter the note in input field======");
						}
						else{
							System.out.println("Please fill all the mandatory fields.");
						}
						
					}
				}
					
				catch(Exception e){
					Flag	=	false;
					System.out.println("Unable to insert data into "+sheetName+" form");
				
				}
			}
              if(mode.equalsIgnoreCase("Edit")){
            	try{
            	System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
      			System.out.println("search ....");
            	String SearchXpath=".//*[@id='BusinessUnit']";
            	String SearchBtn=".//*[@id='btnSearch']";
            	  Thread.sleep(500);
            	  utilfunc.MakeElement(SearchXpath).sendKeys(BusinessUnitName);
            	  Thread.sleep(3000);
            	  utilfunc.MakeElement(SearchBtn).click();
            	  String NorecordXpath=".//*[@class='table-rec-container']//*[@id='divList']//tbody//tr[1]//td[1]";
            	  String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
            	  if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
            		  
            		Flag=false;
  					return Flag;
            	   }else{
            		   String EditIconXpath=".//*[@id='divList']//tbody//tr[1]//td//*[@class='icon-edit']";
            		   try{
            			   Thread.sleep(2000);
            		   utilfunc.MakeElement(EditIconXpath).click();
            		  System.out.println("===="+EditIconXpath+"====="+"Clicked on the same");
            		   }catch(Exception e){
            			   System.out.println("unable to clicked on edit");
            		   }
            	      Thread.sleep(3000);
            	      
  					  String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
  					  String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
  					  int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
  					
  					      for(int i=1; i<=resultCount; i++){
  					    	  Thread.sleep(2000);
  						
  						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
  						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
  						System.out.println("Attribute Name is" + " " + AttributeName);
  						System.out.println("New Xpath is:" + " "+ NewXpath);
  						if(AttributeName.equals("BusinessUnitName")){
  							try{
  							utilfunc.MakeElement(NewXpath).clear();
  							utilfunc.MakeElement(NewXpath).sendKeys(EditBusinessUnitName);
  						    System.out.println("======Enter the BusinessUnit Name in input field======");
  							
  						}catch(Exception Error){}}
  						else if(AttributeName.equals("Notes")){
  							try{
  							utilfunc.MakeElement(NewXpath).clear();
  							utilfunc.MakeElement(NewXpath).sendKeys(EditNotes);
  						    System.out.println("======Enter the note in input field======");
  						}catch(Exception Error){}}
  						
  						
  						else{
  							System.out.println("Please fill all the mandatory fields.");
  						}
  						String PrimiaryLinkXpath=".//*[@class='controls']//*[contains(text(),'Edit Primary Roles')]";
  						utilfunc.MakeElement(PrimiaryLinkXpath).click();
  						System.out.println("====Click on the Primary Roles(Business Unit Scope)=====");
  						
  						// now calling primare roles module
  						try{
  						boolean Primary_Roles_Page_flag	=	obj_CIMS_Company_PrimaryCompanyRoles.Company_PrimaryCompanyRoles(filename,"Primary Roles",1,"Edit");
  						if(Primary_Roles_Page_flag==true){
  							System.out.println("executed primary reoles/...");
  						}
  						}catch(Exception error){
  							System.out.println("unable to execute primary roles...");
  						}
  						
  						
  						// let us redirect back to business unit in order to save/update...
  						webdriver.navigate().back();
  						
  						
  					}
  				
            	      
            	
            	
            		   
            		  
            		  
            	  }
            	  
            	  }catch(Exception e){
            		  System.out.println("==Error in search data==");
            		  }
            	  
              }
								 
			try{
				 // save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	        	utilfunc.MakeElement(saveBtn).click();
			}
			catch(Exception e){}
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
              

				/**
				* scroll to top in order to catch the company slider icon
				*/
				
            utilfunc.scrollToTop();
            if(mode.equalsIgnoreCase("Delete")){

            	System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
      			System.out.println("search ....");
            	String SearchXpath=".//*[@id='BusinessUnit']";
            	String SearchBtn=".//*[@id='btnSearch']";
            	  Thread.sleep(500);
            	  utilfunc.MakeElement(SearchXpath).sendKeys(BusinessUnitName);
            	  Thread.sleep(3000);
            	  utilfunc.MakeElement(SearchBtn).click();
            	  String NoDataFoundXpath=".//*[@class='table-rec-container']//*[@id='divList']//tbody//tr[1]//td[1]";
            	  String RecordNotFound= utilfunc.MakeElement(NoDataFoundXpath).getText();
            	  if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
            		  
            		Flag=false;
  					return Flag;
  					}
				else
				{
					System.out.println("Record founded. we are going to delete it.");
					try{
						Thread.sleep(1000);
						String DeleteBtnXpath=".//*[@id='divList']//tbody//tr[1]//td//*[@class='icon-trash']";
						utilfunc.MakeElement(DeleteBtnXpath).click();
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

						
				 
		          
				 
				 
				 
				 
				 
				 
				
			 
		

		
			 

