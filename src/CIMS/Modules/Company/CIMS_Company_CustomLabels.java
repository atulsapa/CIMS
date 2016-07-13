package CIMS.Modules.Company;
//**//

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Company_CustomLabels {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
//	private String filename	=	"Test Company Data.xls";
//	private String sheetName	=	"CustomLabels";
//	private String mode			=	"Edit";
	
	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String testcasedescription	=	null;

	public CIMS_Company_CustomLabels(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}
	
	
	
	public boolean Add_CustomLabels(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		System.out.println("User is on Add Custom Labels module");
		boolean Flag	=	false;
		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String Questionnaire								=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String Company										=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String Description									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String Application									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String Module										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String Field										=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String Default_label								=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String Label										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String Show											=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String UsersView									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String HelpText										=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);

				
				System.out.println("\n---------\n\tWe are ready to work with "+sheetName+" Module");
				if(TestcaseRunMode.equals("Y")){

					testcaseid			=	TestcaseID;
					scenerio			=	Scenario;
					testcasedescription = Description;
//					
							
		
							if(mode.equals("New")){
								
								String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
								String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']//*[@class='controls']";
								
								String newBtn	=	".//a[contains(@class,'btn') and text()='Add Custom Label']";
			    	        	utilfunc.MakeElement(newBtn).click();
			    	        	Thread.sleep(4000);

								
			    	        	try{
									Thread.sleep(2000);
									System.out.println("now add the data to custom labels form");
									int rowCount	=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
									for(int r=1;r<=rowCount;r++){
										String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(r));
										String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
										System.out.println("Attribute Name is:"+AttributeName);
										if(AttributeName.equals("ApplicationId")){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebytext(NewXpath, Application);
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
										}
										
										else if(AttributeName.equals("ModuleId")){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebytext(NewXpath, Module);												
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
										}
										
										else if(AttributeName.equals("DataFieldId")){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebytext(NewXpath, Field);
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
										}
										
																					
										else if(AttributeName.equals("QuestionnaireType") && Application.equals("CIMS") ){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebytext(NewXpath, Questionnaire);
											Thread.sleep(1000);		
											utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);}
										
										
										else if(AttributeName.equals("DefaultLabel" ) && Default_label.equalsIgnoreCase("Yes") ){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											}
										
										else if(AttributeName.equals("Label" ) && Default_label.equalsIgnoreCase("No")){
											utilfunc.MakeElement(NewXpath).sendKeys(Label);
											
											}
										
										
										else if(AttributeName.equals("Show" ) && Show.equalsIgnoreCase("No") ){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											}
										
										
										
										else if(AttributeName.equals("UserType") ){
											utilfunc.MakeElement(NewXpath).click();
											Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebytext(NewXpath, UsersView);
											Thread.sleep(1000);		
											utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);}
										
										
										else if(AttributeName.equals("ParamHelpText" )){
											utilfunc.MakeElement(NewXpath).sendKeys(HelpText);
											
											}
										
										
										
									}
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to insert data into Company's Custom Label form");
								}
							}
							if(mode.equals("Delete"))
							{
								
								int SearchResultCount=0;
								
								System.out.println("Delete the record");
								String TableFieldXPath=".//*[@class='project-search']//tbody//tr[xx]//td";
								//String ColumnFieldXpath=".//*[@class='project-search']//tbody//tr[xx]";
								String TableFieldCounterXPath=".//*[@class='project-search']//tbody//tr";
								String TableFieldXPath2=".//*[@class='project-search']//tbody//tr[xx]//td[yy]//*[@name]";
								
								try{
									Thread.sleep(200);
								int rowCount	=	utilfunc.GetObjectCount(TableFieldCounterXPath);
								for(int r=1;r<=rowCount;r++){
									
									String Xpath="";
									try{
									 Xpath	=	TableFieldXPath.replace("xx",Integer.toString(r));}
									//ColumnFieldXpath=ColumnFieldXpath.replace("xx",Integer.toString(r));}
									catch(Exception e){}
									int ColumnCount	=	utilfunc.GetObjectCount(Xpath);
									for(int j=1;j<=ColumnCount;j++)
									{
										String NewXpath1	=	TableFieldXPath2.replace("xx",Integer.toString(r));
										String NewXpath	=	NewXpath1.replace("yy",Integer.toString(j));
										String AttributeName="";
										try{
									 AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");}
										catch(Exception e){}
										
									if(AttributeName.equals("Label" )){
										utilfunc.MakeElement(NewXpath).sendKeys(Label);
										
										}
									else if(AttributeName.equals("ApplicationId")){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, Application);
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
									}
									
									/*else if(AttributeName.equals("ModuleId")){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, Module);												
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
									}*/
									
									else if(AttributeName.equals("DataFieldId")){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, Field);
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
										break;
									}
									
																				
									else if(AttributeName.equals("QuestionnaireType") ){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, Questionnaire);
										Thread.sleep(1000);		
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);}
									
									
									
									
								
								}
									}
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to insert data into Company's Custom Label form");
								}
			
						 try{
			 // search button after saving all data..
							String SearchButton=".//*[@id='btnSearch']";
							 utilfunc.MakeElement(SearchButton).click();
						     	Thread.sleep(4000);
						     	String SearchResultPath=".//*[@class='table table-item-list']//tbody//tr//td";
						      SearchResultCount	=	utilfunc.GetObjectCount(SearchResultPath);
							
								
						 }catch(Exception e){
								Flag	=	false;
								System.out.println("Data is not Searched because all fields are not set in the form.");
							}
								
							if(SearchResultCount>1)	
							{
							try
							{
								Thread.sleep(4000);
							String DeleteButton=".//*[@class='table table-item-list']//tbody//tr[1]//td[5]//i[@class='icon-trash']";
							utilfunc.MakeElement(DeleteButton).click();
					     	Thread.sleep(4000);
					     	Alert alt= webdriver.switchTo().alert();
					     	alt.accept();
							
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Data is not Searched because all fields are not set in the form.");
							}
							Flag=true;
							}
							else
							{
								System.out.println("Record not found.");	
							
							}
								
							}
							
							
							if(mode.equals("Edit"))
							{
								
								
								System.out.println("We are for edit here ");
								Thread.sleep(1000);
								int SearchResultCount=0;
								
								String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
								String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']//*[@class='controls']";
								
								System.out.println("Edit the record");
								String TableFieldXPath=".//*[@class='project-search']//tbody//tr[xx]//td";
								//String ColumnFieldXpath=".//*[@class='project-search']//tbody//tr[xx]";
								String TableFieldCounterXPath=".//*[@class='project-search']//tbody//tr";
								String TableFieldXPath2=".//*[@class='project-search']//tbody//tr[xx]//td[yy]//*[@name]";
								
								try{
									Thread.sleep(200);
								int rowCount	=	utilfunc.GetObjectCount(TableFieldCounterXPath);
								for(int r=1;r<=rowCount;r++){
									
									String Xpath="";
									try{
									 Xpath	=	TableFieldXPath.replace("xx",Integer.toString(r));}
									//ColumnFieldXpath=ColumnFieldXpath.replace("xx",Integer.toString(r));}
									catch(Exception e){}
									int ColumnCount	=	utilfunc.GetObjectCount(Xpath);
									for(int j=1;j<=ColumnCount;j++)
									{
										String NewXpath1	=	TableFieldXPath2.replace("xx",Integer.toString(r));
										String NewXpath	=	NewXpath1.replace("yy",Integer.toString(j));
										String AttributeName="";
										try{
									 AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");}
										catch(Exception e){}
										
									if(AttributeName.equals("Label" )){
										try{
											utilfunc.MakeElement(NewXpath).sendKeys(Label);
									}catch(Exception  e){}
										}
									else if(AttributeName.equals("ApplicationId")){
										try{
										utilfunc.Selectdropdownvaluebytext(NewXpath, Application);
										}catch(Exception  e){}
									}
									
									/*else if(AttributeName.equals("ModuleId")){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, Module);												
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
									}*/
									
									else if(AttributeName.equals("DataFieldId")){
										try{
										utilfunc.Selectdropdownvaluebytext(NewXpath, Field);
										}catch(Exception  e){}
										break;
									}
									
																				
									else if(AttributeName.equals("QuestionnaireType") ){
										try{
										utilfunc.Selectdropdownvaluebytext(NewXpath, Questionnaire);
										}catch(Exception  e){}
										
									}
									
									
									
									
								
								}
									}
								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to insert data into Company's Custom Label form");
								}
			
						 try{
			 // search button after saving all data..
							String SearchButton=".//*[@id='btnSearch']";
							try{ utilfunc.MakeElement(SearchButton).click();}catch(Exception  e){}
						     	Thread.sleep(5000);
						     	String SearchResultPath=".//*[@class='table table-item-list']//tbody//tr//td";
							      SearchResultCount	=	utilfunc.GetObjectCount(SearchResultPath);
							
								
						 }catch(Exception e){
								Flag	=	false;
								System.out.println("Data is not Searched because all fields are not set in the form.");
							}
								
						 if(SearchResultCount>1)	
							{	
							
							try
							{
							String EditButton=".//*[@class='table table-item-list']//tbody//tr[1]//td[5]//i[@class='icon-edit']";
							utilfunc.MakeElement(EditButton).click();
					     	Thread.sleep(10000);
							
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Data is not Searched because all fields are not set in the form.");
							}
							
						
							
							
							
							try{
								Thread.sleep(1000);
								System.out.println("now add the data to custom labels form");
								int rowCount	=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
								for(int r=1;r<=rowCount;r++){
									String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(r));
									String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
									System.out.println("Attribute Name is:"+AttributeName);
									
									
									if(AttributeName.equals("DefaultLabel" ) && Default_label.equalsIgnoreCase("No")){
										
										try{
											utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Label);
										}catch(Exception  e){}
										}
									
									
									else if(AttributeName.equals("Show" ) && Show.equalsIgnoreCase("No") ){
									try{	
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).click();}catch(Exception  e){}
										Thread.sleep(1000);
										}
									
									
									
									else if(AttributeName.equals("UserType") ){
										try{
										utilfunc.Selectdropdownvaluebytext(NewXpath, UsersView);
										}catch(Exception  e){}
										}
									
									
									else if(AttributeName.equals("ParamHelpText" )){
										try{utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(HelpText);}catch(Exception  e){}
										
										}
									
									
									
								}
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to insert data into Company's Custom Label form");
							}
							}
						 else
						 {
							 System.out.println("Record Not Found");
						 }
							
							}
							
						 
							

							// now adding the data

									
				}
				if(mode.equals("Edit") || mode.equals("New")  )
				{
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