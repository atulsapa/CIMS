package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;

public class CIMS_Email_Snippet_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Email_Snippet_Admin(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean Email_Snippet_Admin(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String EmailType							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String SnippetType							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String GetCompanyId							        =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String IsActive							            =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String SnippetHTML							        =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String SearchText							        =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				
				if(mode.equals("Delete")){
					return false;
				}
				
				// String for Add New
				String AddNewEmailSnippet	=	".//a[contains(@class,'btn') and contains(text(),'Add New')]";
				String Email_IfrXpath=".//*[@id='panel-body-container']//*[@id='SnippetHTML_ifr']";
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				String AutoSegXpath=".//*[@id='ui-id-2']";
				String CompanyAutoSuggestXpath="//*[contains(@id,'GetCompanyId')]";
				
				String BDXpath="body";
				
				// String for Edit
				
				String SearchTextXpath="//*[contains(@id,'SearchText') and (@class='span3')]";
              	String SearchEmailCompanyTpyeXpath=".//*[contains(@id,'GetCompanyId') and (@class='ui-autocomplete-input')]";
              	String SearchEmailTpyeXpath=".//*[contains(@id,'EmailType')]";
              	String SearchSnippetTypeXpath=".//*[contains(@id,'SnippetType')]";
              	
              	String SearchBtn=".//*[@id='btnSearch']";
              	
				
				if(mode.equalsIgnoreCase("New")){
					
					
                  	 
					
					try{
						
						utilfunc.MakeElement(AddNewEmailSnippet).click();
						System.out.println("======Click on the Add Email Snippet Type ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					try{
				    
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){
						Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
                             if(AttributeName.equals("EmailType")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, EmailType);
								
							} catch (Exception e) {
								System.out.println("===Unable to select the value from EmailType ===");
							}
							
							
						}else if (AttributeName.equals("SnippetType")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, SnippetType);
								
							} catch (Exception e) {
								System.out.println("===Unable to select the value from SnippetType ===");
							}
							}else if (AttributeName.equals("GetCompanyId")){
								Thread.sleep(2000);
								utilfunc.MakeElement(NewXpath+"[1]").clear();
								try {
									
									utilfunc.MakeElement(NewXpath+"[1]").sendKeys(GetCompanyId);
									Thread.sleep(3000);
									utilfunc.selectFirstResultFromAutoSuggestion(NewXpath+"[1]");
									Thread.sleep(1500);
									
									
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else if(AttributeName.equals("IsActive")){
								Thread.sleep(1000);
								try{
										if(IsActive.equalsIgnoreCase("Yes"))
										{
										utilfunc.MakeElement(NewXpath+"//.[@value='TRUE']").click();
										}
										else
										{
											utilfunc.MakeElement(NewXpath+"//.[@value='FALSE']").click();
										}
									}catch(Exception errror){}
				
							}else if(AttributeName.equals("SnippetHTML")){

								 try{
									
									 WebDriverWait wait = new WebDriverWait(webdriver, 15);
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Email_IfrXpath)));
										webdriver.switchTo().frame(utilfunc.MakeElement(Email_IfrXpath));
										System.out.println("Switched to frame");

										WebElement element = webdriver.findElement(By.cssSelector("body"));
										element.clear(); // clear the content of tiny mce editor
										element.sendKeys(SnippetHTML);
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
								
								System.out.println("Please select the mandatory fields.");
							}
			
					}
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Unable to insert data into "+sheetName+" form");
					
				}
			
			}
				
				if(mode.equals("Edit")){
					try{
//					try {
//						 Thread.sleep(300);
//						utilfunc.MakeElement(SearchTextXpath).clear();
//						 utilfunc.MakeElement(SearchTextXpath).sendKeys(SearchText);
//					} catch (Exception e2) {
//										}
	            	 
//	            	 try {
//	            		 
//	            		 utilfunc.MakeElement(SearchEmailCompanyTpyeXpath).clear();
//	            		 Thread.sleep(500);
//					     
//						 utilfunc.MakeElement(SearchEmailCompanyTpyeXpath).sendKeys(GetCompanyId);
//						 Thread.sleep(1000);
//						 utilfunc.selectFirstResultFromAutoSuggestion(GetCompanyId);
//					} catch (Exception e1) {
//						
//					}
	            	 
                 	try {
                 		 Thread.sleep(1000);
						utilfunc.Selectdropdownvaluebytext(SearchEmailTpyeXpath, EmailType);
					} catch (Exception e1) {
						
					}
//                 	
//                 	try {
//                 		Thread.sleep(1000);
//						utilfunc.Selectdropdownvaluebytext(SearchSnippetTypeXpath, SnippetType);
//					} catch (Exception e1) {
//						
//					}
                 	
                 	try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e1) {
						
					}
                 	
                 	String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
		            		Flag=false;
		  					return Flag;
		            	   }else{
		            		   
		            		   utilfunc.scrollToTop();
		            		   String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//*[contains(@class,'edit')]";
		            		   try{
		            			   Thread.sleep(2000);
		            		   utilfunc.MakeElement(EditIconXpath).click();
		            		  System.out.println("===="+EditIconXpath+"====="+"Clicked on the same");
		            		   }catch(Exception e){
		            			   System.out.println("unable to clicked on edit");
		            		   }
		            	      Thread.sleep(3000);
		            	      
		   				    
		   					
		   					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
		   					
		   					for(int i=1; i<=resultCount; i++){
		   						Thread.sleep(3000);
		   						
		   						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
		   						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
		   						System.out.println("Attribute Name is" + " " + AttributeName);
		   						System.out.println("New Xpath is:" + " "+ NewXpath);
		   						
		                                if(AttributeName.equals("EmailType")){
		   							
		   							try {
		   								Thread.sleep(1000);
		   								utilfunc.Selectdropdownvaluebytext(NewXpath, EmailType);
		   								
		   							} catch (Exception e) {
		   								System.out.println("===Unable to select the value from EmailType ===");
		   							}
		   							
		   							
		   						}else if (AttributeName.equals("SnippetType")){
		   							
		   							try {
		   								Thread.sleep(1000);
		   								utilfunc.Selectdropdownvaluebytext(NewXpath, SnippetType);
		   								
		   							} catch (Exception e) {
		   								System.out.println("===Unable to select the value from SnippetType ===");
		   							}
		   							}else if (AttributeName.equals("GetCompanyId")){
		   								
		   								utilfunc.MakeElement(NewXpath).clear();

		   								
		   								try {
		   									GetCompanyId		=	GetCompanyId.substring(0, GetCompanyId.length()-1);
		   									Thread.sleep(2000);
		   									utilfunc.MakeElement(NewXpath).sendKeys(GetCompanyId);
		   									Thread.sleep(3000);
//		   									webdriver.findElement(By.xpath(NewXpath)).sendKeys(Keys.ARROW_DOWN);
//		   									Thread.sleep(3000);
//		   									webdriver.findElement(By.xpath(NewXpath)).sendKeys(Keys.ENTER);
		   									utilfunc.selectFirstResultFromAutoSuggestion(CompanyAutoSuggestXpath);
		   									Thread.sleep(4000);
		   									
		   								} catch (Exception e) {
		   									
		   									System.out.println("===Unable to entered the value===");
		   								}
		   								
		   								
		   							}else if(AttributeName.equals("IsActive")){
		   								Thread.sleep(1000);
		   								try{
		   										if(IsActive.equalsIgnoreCase("Yes"))
		   										{
		   										utilfunc.MakeElement(NewXpath+"//.[@value='TRUE']").click();
		   										}
		   										else
		   										{
		   											utilfunc.MakeElement(NewXpath+"//.[@value='FALSE']").click();
		   										}
		   									}catch(Exception errror){}
		   				
		   							}else if(AttributeName.equals("SnippetHTML")){

		   								 try{
		   									
		   									 WebDriverWait wait = new WebDriverWait(webdriver, 15);
		   										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Email_IfrXpath)));
		   										webdriver.switchTo().frame(utilfunc.MakeElement(Email_IfrXpath));
		   										System.out.println("Switched to frame");

		   										WebElement element = webdriver.findElement(By.cssSelector("body"));
		   										element.clear(); // clear the content of tiny mce editor
		   										element.sendKeys(SnippetHTML);
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
		   								
		   								System.out.println("Please select the mandatory fields.");
		   							}
		   			
		   					}
		   				
		            		   
		            		   
		            	   }
					} catch(Exception e){
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
					 }else if(error_flag.contains("Error! You cannot create duplicate snippets.")){
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 webdriver.navigate().back();
						 
					 }
					 else{
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
