package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilFunction;

public class CIMS_Company_Company_Job_Catalog {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public CIMS_Company_Company_Job_Catalog(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;
	
	}
	  public boolean CompanyJobCatalog_info(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		  System.out.println("User is on "+sheetName+" Module");
			boolean Flag	=	false;
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String EntityId								        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String CountryCode								    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String BusinessUnitId								=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String OfficeId								        =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String JobCode								        =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String Title								        =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String Category								        =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String SubCategory								    =			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String Level								        =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			String BriefDescription								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String DetailedDescription						    =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			String JobRequirements							    =			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
			String EffectiveDate								=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
			String EndDate								        =			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
			String IndustryOrGovernmentClassificationType       =			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
			String IndustryOrGovernmentClassificationCode	    =			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
			String Currency								        =			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
			String SalarySurveyName							    =			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
			String SalarySurveyCode							    =			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
			String SalarySurveyTitle						    =			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
			String SalarySurveyLevel						    =			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
			String SalarySurveyDate								=			UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
			String HeadquartersSalaryGrade					    =			UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
			String HeadquartersSalaryRangeMinimum				=			UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
			String HeadquartersSalaryRange25thPercentile	    =			UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
			String HeadquartersSalaryRange50thPercentile		=			UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
			String HeadquartersSalaryRange75thPercentile		=			UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
			String HeadquartersSalaryRangeMaximum			    =			UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
			String SalaryGrade			                        =			UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
			String SalaryRangeMinimum			                =			UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
			String SalaryRange25thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
			String SalaryRange50thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
			String SalaryRange75thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
			String SalaryRangeMaximum			                =			UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);
			String EditEntityId								    =			UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
			String EditCountryCode								    =			UtilFunction.getCellData(filename, sheetName, 40, ColumnCounter);
			String EditBusinessUnitId								=			UtilFunction.getCellData(filename, sheetName, 41, ColumnCounter);
			String EditOfficeId								        =			UtilFunction.getCellData(filename, sheetName, 42, ColumnCounter);
			String EditJobCode								        =			UtilFunction.getCellData(filename, sheetName, 43, ColumnCounter);
			String EditTitle								        =			UtilFunction.getCellData(filename, sheetName, 44, ColumnCounter);
			String EditCategory								        =			UtilFunction.getCellData(filename, sheetName, 45, ColumnCounter);
			String EditSubCategory								    =			UtilFunction.getCellData(filename, sheetName, 46, ColumnCounter);
			String EditLevel								        =			UtilFunction.getCellData(filename, sheetName, 47, ColumnCounter);
			String EditBriefDescription								=			UtilFunction.getCellData(filename, sheetName, 48, ColumnCounter);
			String EditDetailedDescription						    =			UtilFunction.getCellData(filename, sheetName, 49, ColumnCounter);
			String EditJobRequirements							    =			UtilFunction.getCellData(filename, sheetName, 50, ColumnCounter);
			String EditEffectiveDate								=			UtilFunction.getCellData(filename, sheetName, 51, ColumnCounter);
			String EditEndDate								        =			UtilFunction.getCellData(filename, sheetName, 52, ColumnCounter);
			String EditIndustryOrGovernmentClassificationType       =			UtilFunction.getCellData(filename, sheetName, 53, ColumnCounter);
			String EditIndustryOrGovernmentClassificationCode	    =			UtilFunction.getCellData(filename, sheetName, 54, ColumnCounter);
			String EditCurrency								        =			UtilFunction.getCellData(filename, sheetName, 55, ColumnCounter);
			String EditSalarySurveyName							    =			UtilFunction.getCellData(filename, sheetName, 56, ColumnCounter);
			String EditSalarySurveyCode							    =			UtilFunction.getCellData(filename, sheetName, 57, ColumnCounter);
			String EditSalarySurveyTitle						    =			UtilFunction.getCellData(filename, sheetName, 58, ColumnCounter);
			String EditSalarySurveyLevel						    =			UtilFunction.getCellData(filename, sheetName, 59, ColumnCounter);
			String EditSalarySurveyDate								=			UtilFunction.getCellData(filename, sheetName, 60, ColumnCounter);
			String EditHeadquartersSalaryGrade					    =			UtilFunction.getCellData(filename, sheetName, 61, ColumnCounter);
			String EditHeadquartersSalaryRangeMinimum				=			UtilFunction.getCellData(filename, sheetName, 62, ColumnCounter);
			String EditHeadquartersSalaryRange25thPercentile	    =			UtilFunction.getCellData(filename, sheetName, 63, ColumnCounter);
			String EditHeadquartersSalaryRange50thPercentile		=			UtilFunction.getCellData(filename, sheetName, 64, ColumnCounter);
			String EditHeadquartersSalaryRange75thPercentile		=			UtilFunction.getCellData(filename, sheetName, 65, ColumnCounter);
			String EditHeadquartersSalaryRangeMaximum			    =			UtilFunction.getCellData(filename, sheetName, 66, ColumnCounter);
			String EditSalaryGrade			                        =			UtilFunction.getCellData(filename, sheetName, 67, ColumnCounter);
			String EditSalaryRangeMinimum			                =			UtilFunction.getCellData(filename, sheetName, 68, ColumnCounter);
			String EditSalaryRange25thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 69, ColumnCounter);
			String EditSalaryRange50thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 70, ColumnCounter);
			String EditSalaryRange75thPercentile			        =			UtilFunction.getCellData(filename, sheetName, 71, ColumnCounter);
			String EditSalaryRangeMaximum			                =			UtilFunction.getCellData(filename, sheetName, 72, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 73, ColumnCounter);
			
			//Excel sheet Data collection

			if(TestcaseRunMode.equals("Y")){
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
			if(mode.equalsIgnoreCase("New")){
				
				try{
					String AddNewJOb	=	".//a[contains(@class,'btn') and text()='Add New Job']";
					utilfunc.MakeElement(AddNewJOb).click();
					System.out.println("======Click on the AddNewJobCatalog======");
				}catch(Exception e){
					System.out.println("unable to click on add new button");
				}
				try{
					String fromFieldXpath=".//*[@id='form1']//*[@class='control-group'][aa]//*[@name]";
					String fromFieldCounterXpath=".//*[@id='form1']//*[@class='control-group']";
					
					String BriefDescriptionIF=".//*[@id='panel-body-container']//*[@id='BriefDescription_ifr']";
		
					String BDXpath="body";
					String DetailedDescriptionIFR=".//*[@id='panel-body-container']//*[@id='DetailedDescription_ifr']";
		            String JobRequirementsIFR=".//*[@id='panel-body-container']//*[@id='JobRequirements_ifr']";
				
					int resultcount = utilfunc.GetObjectCount(fromFieldCounterXpath);
					for(int i=1; i<=resultcount; i++){
						String NewXpath=fromFieldXpath.replace("aa", Integer.toString(i));
						String AttrName=utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Print Attribute Name:" + AttrName);
						System.out.println("Print New Xpath:" + NewXpath);
					
					if(AttrName.equals("EntityId")){
						utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(2000);
						utilfunc.Selectdropdownvaluebytext(NewXpath, EntityId);
						Thread.sleep(2000);
						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						System.out.println("==Entity Id has been slected==");
					}else if (AttrName.equals("CountryCode")){
						utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(2000);
						utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
						Thread.sleep(2000);
						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						System.out.println("==CountryCode has been selected==");
						}else if (AttrName.equals("BusinessUnitId")){
							utilfunc.MakeElement(NewXpath).click();
							Thread.sleep(2000);
							utilfunc.Selectdropdownvaluebytext(NewXpath, BusinessUnitId);
							Thread.sleep(2000);
							utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
							System.out.println("==BusinessUnitId has been selected==");
					}else if (AttrName.equals("OfficeId")){
						utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(2000);
						utilfunc.Selectdropdownvaluebytext(NewXpath, OfficeId);
						Thread.sleep(2000);
						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						System.out.println("==OfficeId has been selected==");
				}else if(AttrName.equals("JobCode")){
					utilfunc.MakeElement(NewXpath).sendKeys(JobCode);
					System.out.println("==Enter the job Code==");
					}else if(AttrName.equals("Title")){
						utilfunc.MakeElement(NewXpath).sendKeys(Title);
						System.out.println("==Enter the Title==");
					}else if(AttrName.equals("Category")){
						utilfunc.MakeElement(NewXpath).sendKeys(Category);
						System.out.println("==Enter the Category==");
					}else if(AttrName.equals("SubCategory")){
						utilfunc.MakeElement(NewXpath).sendKeys(SubCategory);
						System.out.println("==Enter the SubCategory==");
					}
					else if(AttrName.equals("Level")){
						utilfunc.MakeElement(NewXpath).sendKeys(Level);
						System.out.println("==Enter the Level==");
					}
					else if(AttrName.equals("BriefDescription")){
					 try{
						 
						 
						 WebDriverWait wait = new WebDriverWait(webdriver, 15);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BriefDescriptionIF)));
							webdriver.switchTo().frame(utilfunc.MakeElement(BriefDescriptionIF));
							System.out.println("Switched to frame");

							WebElement element = webdriver.findElement(By.cssSelector("body"));
							element.clear(); // clear the content of tiny mce editor
							element.sendKeys(BriefDescription);
							System.out.println("BriefDescription is set in tiny mce editor");
					       } catch(Exception e){
						 System.out.println("Unalbe to switch iframe");
					       }
						 try{
							 
							 webdriver.switchTo().defaultContent();
							 
							 
						 }catch(Exception s){
							 System.out.println("Unable to back to main window");
						 }
                    						 
					 }     
					
					
					else if(AttrName.equals("DetailedDescription")){
						try{
						 WebDriverWait wait = new WebDriverWait(webdriver, 15);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetailedDescriptionIFR)));
							webdriver.switchTo().frame(utilfunc.MakeElement(DetailedDescriptionIFR));
							System.out.println("Switched to frame");

							WebElement element = webdriver.findElement(By.cssSelector("body"));
							element.clear(); // clear the content of tiny mce editor
							element.sendKeys(DetailedDescription);
							System.out.println("DetailedDescription is set in tiny mce editor");
					       } catch(Exception e){
						 System.out.println("Unalbe to switch iframe");
					       }
						 try{
							 
							 webdriver.switchTo().defaultContent();
							 }catch(Exception v){
							 System.out.println("Unable to back to main window");
						 }
                        }
					else if(AttrName.equals("JobRequirements")){
						try{
							 WebDriverWait wait = new WebDriverWait(webdriver, 15);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JobRequirementsIFR)));
								webdriver.switchTo().frame(utilfunc.MakeElement(JobRequirementsIFR));
								System.out.println("Switched to frame");

								WebElement element = webdriver.findElement(By.cssSelector("body"));
								element.clear(); // clear the content of tiny mce editor
								element.sendKeys(JobRequirements);
								System.out.println("JobRequirements is set in tiny mce editor");
						       } catch(Exception e){
							 System.out.println("Unalbe to switch iframe");
						       }
							 try{
								 
								 webdriver.switchTo().defaultContent();
								 }catch(Exception b){
								 System.out.println("Unable to back to main window");
							 }
						
						
					}else if (AttrName.equals("EffectiveDate")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(EffectiveDate);
						System.out.println("==EffectiveDate has been selected==");
					
					}else if (AttrName.equals("EndDate")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(EndDate);
						System.out.println("==EndDate has been selected==");
					
					}else if (AttrName.equals("IndustryOrGovernmentClassificationType")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(IndustryOrGovernmentClassificationType);
						System.out.println("==IndustryOrGovernmentClassificationType has been selected==");
					
					}else if (AttrName.equals("IndustryOrGovernmentClassificationCode")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(IndustryOrGovernmentClassificationCode);
						System.out.println("==IndustryOrGovernmentClassificationCode has been selected==");
					
					}else if (AttrName.equals("Currency")){
						utilfunc.MakeElement(NewXpath).click();
						Thread.sleep(2000);
						utilfunc.Selectdropdownvaluebytext(NewXpath, Currency);
						Thread.sleep(2000);
						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
						System.out.println("==Currency has been selected==");
					}else if (AttrName.equals("SalarySurveyName")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalarySurveyName);
						System.out.println("==SalarySurveyName has been selected==");
					
					}else if (AttrName.equals("SalarySurveyCode")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalarySurveyCode);
						System.out.println("==SalarySurveyCode has been selected==");
					
					}else if (AttrName.equals("SalarySurveyTitle")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalarySurveyTitle);
						System.out.println("==SalarySurveyTitle has been selected==");
					
					}else if (AttrName.equals("SalarySurveyLevel")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalarySurveyLevel);
						System.out.println("==SalarySurveyLevel has been selected==");
					
					}else if (AttrName.equals("SalarySurveyDate")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalarySurveyDate);
						System.out.println("==SalarySurveyDate has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryGrade")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryGrade);
						System.out.println("==HeadquartersSalaryGrade has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryRangeMinimum")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryRangeMinimum);
						System.out.println("==HeadquartersSalaryRangeMinimum has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryRange25thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryRange25thPercentile);
						System.out.println("==HeadquartersSalaryRange25thPercentile has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryRange50thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryRange50thPercentile);
						System.out.println("==HeadquartersSalaryRange50thPercentile has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryRange75thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryRange75thPercentile);
						System.out.println("==HeadquartersSalaryRange75thPercentile has been selected==");
					
					}else if (AttrName.equals("HeadquartersSalaryRangeMaximum")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(HeadquartersSalaryRangeMaximum);
						System.out.println("==HeadquartersSalaryRangeMaximum has been selected==");
					
					}else if (AttrName.equals("SalaryGrade")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryGrade);
						System.out.println("==SalaryGrade has been selected==");
					
					}else if (AttrName.equals("SalaryRangeMinimum")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryRangeMinimum);
						System.out.println("==SalaryRangeMinimum has been selected==");
					
					}else if (AttrName.equals("SalaryRange25thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryRange25thPercentile);
						System.out.println("==SalaryRange25thPercentile has been selected==");
					
					}else if (AttrName.equals("SalaryRange50thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryRange50thPercentile);
						System.out.println("==SalaryRange50thPercentile has been selected==");
					
					}else if (AttrName.equals("SalaryRange75thPercentile")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryRange75thPercentile);
						System.out.println("==SalaryRange75thPercentile has been selected==");
					
					}else if (AttrName.equals("SalaryRangeMaximum")){
						
						utilfunc.MakeElement(NewXpath).sendKeys(SalaryRangeMaximum);
						System.out.println("==SalaryRangeMaximum has been selected==");
					
					}else {
						System.out.println("==Select all mandatory fields==");
					
					}
					
					}
					
				}catch(Exception e){
					Flag=false;
					          System.out.println("==Unable to insert data into "+sheetName+" form==");
				}
			}
			
			if(mode.equalsIgnoreCase("Edit")){
				Thread.sleep(2000);
				
				System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
      			System.out.println("search ....");
      			
      		    
      			
            	String SearchXpath=".//*[@id='form2']//tbody//tr//td[1]//*[contains(@type,'text')]";
            	String SearchBtn=".//*[@id='form2']//a[contains(text(),'Search')]";
            	  Thread.sleep(500);
            	  utilfunc.MakeElement(SearchXpath).sendKeys(JobCode);
            	  Thread.sleep(3000);
            	  try{
            	  utilfunc.MakeElement(SearchBtn).click();
            	  }catch(Exception error){}
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
            			   System.out.println("unable to clicked on edit"+e);
            		   }
            	      Thread.sleep(3000);
            	      
            	      try{

  					String fromFieldXpath=".//*[@id='form1']//*[@class='control-group'][aa]//*[@name]";
  					String fromFieldCounterXpath=".//*[@id='form1']//*[@class='control-group']";
  					
  					String BriefDescriptionIF=".//*[@id='panel-body-container']//*[@id='BriefDescription_ifr']";
  		
  					String BDXpath="body";
  					String DetailedDescriptionIFR=".//*[@id='panel-body-container']//*[@id='DetailedDescription_ifr']";
  		            String JobRequirementsIFR=".//*[@id='panel-body-container']//*[@id='JobRequirements_ifr']";
  				
  					int resultcount = utilfunc.GetObjectCount(fromFieldCounterXpath);
  					for(int i=1; i<=resultcount; i++){
  						String NewXpath=fromFieldXpath.replace("aa", Integer.toString(i));
  						String AttrName=utilfunc.MakeElement(NewXpath).getAttribute("name");
  						System.out.println("Print Attribute Name:" + AttrName);
  						System.out.println("Print New Xpath:" + NewXpath);
  					
  					if(AttrName.equals("EntityId")){
  						utilfunc.MakeElement(NewXpath).click();
  						Thread.sleep(2000);
  						utilfunc.Selectdropdownvaluebytext(NewXpath, EditEntityId);
  						Thread.sleep(2000);
  						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
  						System.out.println("==Entity Id has been slected==");
  					}else if (AttrName.equals("CountryCode")){
  						utilfunc.MakeElement(NewXpath).click();
  						Thread.sleep(2000);
  						utilfunc.Selectdropdownvaluebytext(NewXpath, EditCountryCode);
  						Thread.sleep(2000);
  						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
  						System.out.println("==CountryCode has been selected==");
  						}else if (AttrName.equals("BusinessUnitId")){
  							utilfunc.MakeElement(NewXpath).click();
  							Thread.sleep(2000);
  							utilfunc.Selectdropdownvaluebytext(NewXpath, EditBusinessUnitId);
  							Thread.sleep(2000);
  							utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
  							System.out.println("==BusinessUnitId has been selected==");
  					}else if (AttrName.equals("OfficeId")){
  						utilfunc.MakeElement(NewXpath).click();
  						Thread.sleep(2000);
  						utilfunc.Selectdropdownvaluebytext(NewXpath, EditOfficeId);
  						Thread.sleep(2000);
  						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
  						System.out.println("==OfficeId has been selected==");
  				}else if(AttrName.equals("JobCode")){
  					utilfunc.MakeElement(NewXpath).clear();
  					utilfunc.MakeElement(NewXpath).sendKeys(EditJobCode);
  					System.out.println("==Enter the job Code==");
  					}else if(AttrName.equals("Title")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditTitle);
  						System.out.println("==Enter the Title==");
  					}else if(AttrName.equals("Category")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditCategory);
  						System.out.println("==Enter the Category==");
  					}else if(AttrName.equals("SubCategory")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSubCategory);
  						System.out.println("==Enter the SubCategory==");
  					}
  					else if(AttrName.equals("Level")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditLevel);
  						System.out.println("==Enter the Level==");
  					}
  					else if(AttrName.equals("BriefDescription")){
  					 try{
  						 
  						 
  						 WebDriverWait wait = new WebDriverWait(webdriver, 15);
  							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BriefDescriptionIF)));
  							webdriver.switchTo().frame(utilfunc.MakeElement(BriefDescriptionIF));
  							System.out.println("Switched to frame");

  							WebElement element = webdriver.findElement(By.cssSelector("body"));
  							element.clear(); // clear the content of tiny mce editor
  							element.sendKeys(EditBriefDescription);
  							System.out.println("BriefDescription is set in tiny mce editor");
  					       } catch(Exception e){
  						 System.out.println("Unalbe to switch iframe");
  					       }
  						 try{
  							 
  							 webdriver.switchTo().defaultContent();
  							 
  							 
  						 }catch(Exception s){
  							 System.out.println("Unable to back to main window");
  						 }
                      						 
  					 }     
  					
  					
  					else if(AttrName.equals("DetailedDescription")){
  						try{
  						 WebDriverWait wait = new WebDriverWait(webdriver, 15);
  							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetailedDescriptionIFR)));
  							webdriver.switchTo().frame(utilfunc.MakeElement(DetailedDescriptionIFR));
  							System.out.println("Switched to frame");

  							WebElement element = webdriver.findElement(By.cssSelector("body"));
  							element.clear(); // clear the content of tiny mce editor
  							element.sendKeys(EditDetailedDescription);
  							System.out.println("DetailedDescription is set in tiny mce editor");
  					       } catch(Exception e){
  						 System.out.println("Unalbe to switch iframe");
  					       }
  						 try{
  							 
  							 webdriver.switchTo().defaultContent();
  							 }catch(Exception v){
  							 System.out.println("Unable to back to main window");
  						 }
                          }
  					else if(AttrName.equals("JobRequirements")){
  						try{
  							 WebDriverWait wait = new WebDriverWait(webdriver, 15);
  								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JobRequirementsIFR)));
  								webdriver.switchTo().frame(utilfunc.MakeElement(JobRequirementsIFR));
  								System.out.println("Switched to frame");

  								WebElement element = webdriver.findElement(By.cssSelector("body"));
  								element.clear(); // clear the content of tiny mce editor
  								element.sendKeys(EditJobRequirements);
  								System.out.println("JobRequirements is set in tiny mce editor");
  						       } catch(Exception e){
  							 System.out.println("Unalbe to switch iframe");
  						       }
  							 try{
  								 
  								 webdriver.switchTo().defaultContent();
  								 }catch(Exception b){
  								 System.out.println("Unable to back to main window");
  							 }
  						
  						
  					}else if (AttrName.equals("EffectiveDate")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditEffectiveDate);
  						System.out.println("==EffectiveDate has been selected==");
  					
  					}else if (AttrName.equals("EndDate")){
  						utilfunc.MakeElement(NewXpath).clear();
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditEndDate);
  						System.out.println("==EndDate has been selected==");
  					
  					}else if (AttrName.equals("IndustryOrGovernmentClassificationType")){
  						utilfunc.MakeElement(NewXpath).clear();
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditIndustryOrGovernmentClassificationType);
  						System.out.println("==IndustryOrGovernmentClassificationType has been selected==");
  					
  					}else if (AttrName.equals("IndustryOrGovernmentClassificationCode")){
  						utilfunc.MakeElement(NewXpath).clear();
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditIndustryOrGovernmentClassificationCode);
  						System.out.println("==IndustryOrGovernmentClassificationCode has been selected==");
  					
  					}else if (AttrName.equals("Currency")){
  						utilfunc.MakeElement(NewXpath).click();
  						Thread.sleep(2000);
  						utilfunc.Selectdropdownvaluebytext(NewXpath, Currency);
  						Thread.sleep(2000);
  						utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
  						System.out.println("==Currency has been selected==");
  					}else if (AttrName.equals("SalarySurveyName")){
  						utilfunc.MakeElement(NewXpath).clear();
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalarySurveyName);
  						System.out.println("==SalarySurveyName has been selected==");
  					
  					}else if (AttrName.equals("SalarySurveyCode")){
  						utilfunc.MakeElement(NewXpath).clear();	
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalarySurveyCode);
  						System.out.println("==SalarySurveyCode has been selected==");
  					
  					}else if (AttrName.equals("SalarySurveyTitle")){
  						utilfunc.MakeElement(NewXpath).clear();	
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalarySurveyTitle);
  						System.out.println("==SalarySurveyTitle has been selected==");
  					
  					}else if (AttrName.equals("SalarySurveyLevel")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalarySurveyLevel);
  						System.out.println("==SalarySurveyLevel has been selected==");
  					
  					}else if (AttrName.equals("SalarySurveyDate")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalarySurveyDate);
  						System.out.println("==SalarySurveyDate has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryGrade")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryGrade);
  						System.out.println("==HeadquartersSalaryGrade has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryRangeMinimum")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryRangeMinimum);
  						System.out.println("==HeadquartersSalaryRangeMinimum has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryRange25thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryRange25thPercentile);
  						System.out.println("==HeadquartersSalaryRange25thPercentile has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryRange50thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryRange50thPercentile);
  						System.out.println("==HeadquartersSalaryRange50thPercentile has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryRange75thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryRange75thPercentile);
  						System.out.println("==HeadquartersSalaryRange75thPercentile has been selected==");
  					
  					}else if (AttrName.equals("HeadquartersSalaryRangeMaximum")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditHeadquartersSalaryRangeMaximum);
  						System.out.println("==HeadquartersSalaryRangeMaximum has been selected==");
  					
  					}else if (AttrName.equals("SalaryGrade")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryGrade);
  						System.out.println("==SalaryGrade has been selected==");
  					
  					}else if (AttrName.equals("SalaryRangeMinimum")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryRangeMinimum);
  						System.out.println("==SalaryRangeMinimum has been selected==");
  					
  					}else if (AttrName.equals("SalaryRange25thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryRange25thPercentile);
  						System.out.println("==SalaryRange25thPercentile has been selected==");
  					
  					}else if (AttrName.equals("SalaryRange50thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryRange50thPercentile);
  						System.out.println("==SalaryRange50thPercentile has been selected==");
  					
  					}else if (AttrName.equals("SalaryRange75thPercentile")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryRange75thPercentile);
  						System.out.println("==SalaryRange75thPercentile has been selected==");
  					
  					}else if (AttrName.equals("SalaryRangeMaximum")){
  						utilfunc.MakeElement(NewXpath).clear();
  						utilfunc.MakeElement(NewXpath).sendKeys(EditSalaryRangeMaximum);
  						System.out.println("==SalaryRangeMaximum has been selected==");
  					
  					}else {
  						System.out.println("==Select all mandatory fields==");
  					
  					}
  					
  					}
  					
  				
            		   
            		   
            	   }
					
				catch(Exception e){
					
					          System.out.println("==Unable to insert data into "+sheetName+" form==");
				
				}
				
			}
			}
			
			 try{
				 // save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	        	utilfunc.MakeElement(saveBtn).click();
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
				String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
                	String SearchXpath=".//*[@id='form2']//tbody//tr//td[1]//*[contains(@type,'text')]";
                	String SearchBtn=".//*[@id='form2']//a[contains(text(),'Search')]";
                	  Thread.sleep(500);
                	  utilfunc.MakeElement(SearchXpath).sendKeys(JobCode);
                	  Thread.sleep(3000);
                	  try{
                	  utilfunc.MakeElement(SearchBtn).click();
                	  }catch(Exception error){}
                	  String NorecordXpath=".//*[@class='table-rec-container']//*[@id='divList']//tbody//tr[1]//td[1]";
                	  String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
                	  if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
                		  
                		Flag=false;
      					return Flag;
                	   }else{

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
	  
