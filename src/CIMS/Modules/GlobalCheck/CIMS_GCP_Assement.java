package CIMS.Modules.GlobalCheck;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import CIMS.Modules.Questionnaires.CIMS_Assessment_Module;

import util.UtilFunction;

public class CIMS_GCP_Assement {	private WebDriver webdriver;	// Will be Provide by Calling Class.	
private UtilFunction utilfunc;	// Will be Provide by Calling Class.
private CIMS_Assessment_Module obj_CIMS_Assessment_Module;
/**
 * @param args
 */

 public static String testcaseid="";
 public static String scenerio="";
 public static String description="";
 private static String GCPNewQueryTitleXpath="//*[@id='panel-header']";

 

	
 
 public CIMS_GCP_Assement(WebDriver driver,UtilFunction utilfunc) {
	 {
			this.webdriver =driver;
			this.utilfunc=utilfunc;
			
	}	
	 
 }
 
 public boolean GCP_NewQuery_Initiation_Page(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
	
	 //setobj_CIMS_Assessment_Module(new CIMS_Assessment_Module(webdriver,utilfunc));
	 boolean Flag	=	false;
		
		
		String error_flag                ="";
      			
		
		System.out.println("user is on '"+sheetName+"' module...");
		System.out.println("entering "+mode+" mode for "+sheetName+" module.....");
		
		 String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		 String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		 String Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		 String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		 
		 
		 
		    String Firstname                                =           UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
			String Middlename                               =           UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
			String Lastname                                 =           UtilFunction.getCellData(filename, sheetName, 26, ColumnCounter);
			String JobTitle                                 =           UtilFunction.getCellData(filename, sheetName, 27, ColumnCounter);
			String delelecitizenship                        =           UtilFunction.getCellData(filename, sheetName, 28, ColumnCounter);
			String DateTentativeStart                       =           UtilFunction.getCellData(filename, sheetName, 29, ColumnCounter);
			String DateTentativeReturn                      =           UtilFunction.getCellData(filename, sheetName, 30, ColumnCounter);
			String form_DestinationCountryCode              =           UtilFunction.getCellData(filename, sheetName, 31, ColumnCounter);
			String City                                     =           UtilFunction.getCellData(filename, sheetName, 32, ColumnCounter);
			String JobNote                                  =           UtilFunction.getCellData(filename, sheetName, 33, ColumnCounter);
			String ThirdPartySite                           =           UtilFunction.getCellData(filename, sheetName, 34, ColumnCounter);
			String OriginCountry                            =           UtilFunction.getCellData(filename, sheetName, 35, ColumnCounter);
			String OriginCity                               =           UtilFunction.getCellData(filename, sheetName, 36, ColumnCounter);
			String HasTravelToDestCountryLastOneYear        =           UtilFunction.getCellData(filename, sheetName, 37, ColumnCounter);
			String HowDayToDestCountry                      =           UtilFunction.getCellData(filename, sheetName, 38, ColumnCounter);
			String FutureTravelPlans                        =           UtilFunction.getCellData(filename, sheetName, 39, ColumnCounter);
			String YearsOfEducation                         =           UtilFunction.getCellData(filename, sheetName, 40, ColumnCounter);
			String FieldOfStudy                             =           UtilFunction.getCellData(filename, sheetName, 41, ColumnCounter);
			String YearsOfExperience                        =           UtilFunction.getCellData(filename, sheetName, 42, ColumnCounter);
			String DeniedVisa                               =           UtilFunction.getCellData(filename, sheetName, 43, ColumnCounter);
			String Arrested                                 =           UtilFunction.getCellData(filename, sheetName, 44, ColumnCounter);
			//String ExpectedErrorMessage                     =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String CityTownLocality                         =           UtilFunction.getCellData(filename, sheetName, 45, ColumnCounter);
			String StateProvinceTerritory                   =           UtilFunction.getCellData(filename, sheetName, 46, ColumnCounter);
			
		 
		   String ExpectedErrorMessage                      =            UtilFunction.getCellData(filename, sheetName,47, ColumnCounter);
		   
		   testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				

				String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
				String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";
				
				String Assessment_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name and not (@type='hidden')]";
				String AssessmentCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name and not (@type='hidden')]";
				
				String Citizenshipbuttonxpath=".//*[@id='btnAddCitizenship']";
				//String CitizenshipSpousebuttonxpath=".//*[@id='btnAddCitizenshipSpouse']";
				
				String Firstnamexpath=".//*[@name='FirstName']";
				String Middlenamexpath=".//*[@name='MiddleName']";
				String lastnamexpath=".//*[@name='LastName']";
				
				String NewXpath;
				 String AttributeName;
				
				if(mode.equals("New")){
					
					 try{
						 try {
							utilfunc.MakeElement(Firstnamexpath).clear();
						} catch (Exception e) {
							
						}
						 try {
							utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
						} catch (Exception e) {
							
						}
						 try {
							utilfunc.MakeElement(Middlenamexpath).clear();
						} catch (Exception e) {
							
						}
						 try {
							utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
						} catch (Exception e) {
							
						}
						 try {
							utilfunc.MakeElement(lastnamexpath).clear();
						} catch (Exception e) {
							
						}
						 try {
							utilfunc.MakeElement(lastnamexpath).sendKeys(Lastname);
						} catch (Exception e) {
							
						}
					 }catch(Exception e){
						 
					 }
					 
					 /////////spouse name////////////////
					 /*try{
						 utilfunc.MakeElement(SpouseFirstNamexpath).clear();
						 utilfunc.MakeElement(SpouseFirstNamexpath).sendKeys(SpouseFirstName);
						 utilfunc.MakeElement(SpouseMiddleNamexpath).clear();
						 utilfunc.MakeElement(SpouseMiddleNamexpath).sendKeys(SpouseMiddleName);
						 utilfunc.MakeElement(SpouseLastNamexpath).clear();
						 utilfunc.MakeElement(SpouseLastNamexpath).sendKeys(SpouseLastName);
					 }catch(Exception e){
						 
					 }*/
					 
					 try{
					 
					 int ObjCount=utilfunc.GetObjectCount(AssessmentCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 Thread.sleep(1000);
						 NewXpath=Assessment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 
							 try {
								AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 
								 if(AttributeName.equals("JobTitle")){
									 
									 
									 utilfunc.MakeElement(NewXpath).clear();
									 try {
										utilfunc.MakeElement(NewXpath).sendKeys(JobTitle);
									} catch (Exception e) {
										
									}
								 }	
								 else if(AttributeName.equals("delelecitizenship")){
								 String newpath=NewXpath+"[2]";
								     try {
										utilfunc.Selectdropdownvaluebyvalue(newpath, delelecitizenship);
										 try {
											utilfunc.MakeElement(Citizenshipbuttonxpath).click();
										} catch (Exception e) {
											
										}
									} catch (Exception e) {
										System.out.println("unable to set citizenship");
									}}
								 else if(AttributeName.equals("DateTentativeStart")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(DateTentativeStart);
									} catch (Exception e) {
									}
										
						        	}
								 else if(AttributeName.equals("DateTentativeReturn")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(DateTentativeReturn);
									} catch (Exception e) {
									}
										
						        	}
								 else if(AttributeName.equals("form_DestinationCountryCode")){
									 
									 try {
										 Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, form_DestinationCountryCode);
									} catch (Exception e) {
									}
								 }
								 else if(AttributeName.equals("City")){		
									 try {
										 utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(City);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("JobNote")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(JobNote);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("ThirdPartySite")){
									 
									 
											if(ThirdPartySite.equals("Yes")){
												
												try {
													String thirdpartySiteXpath=NewXpath+"//.[@value='True']";
													Thread.sleep(3000);
													utilfunc.MakeElement(thirdpartySiteXpath).click();
												} catch (Exception e) {
													
												}
											}else{
												try {
													String thirdpartySiteXpath=NewXpath+"//.[@value='False']";
													Thread.sleep(3000);
													utilfunc.MakeElement(thirdpartySiteXpath).click();
												} catch (Exception e) {
												}
											}
									 
									}
								 else if(AttributeName.equals("OriginCountry")){							
									 try {
										 Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, OriginCountry);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("OriginCity")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(OriginCity);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("HasTravelToDestCountryLastOneYear")){	
									 if(HasTravelToDestCountryLastOneYear.equals("Yes")){
											
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
											} catch (Exception e) {
												
											}
										}else{
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
												Thread.sleep(1000);
											} catch (Exception e) {
											}
										}
									    if(AttributeName.equals("HowDayToDestCountry")){
									    	
									    	try {
												utilfunc.MakeElement(NewXpath).clear();
												utilfunc.MakeElement(NewXpath).sendKeys(HowDayToDestCountry);
											} catch (Exception e) {
												
											}
									    	
									    }
									}
								 else if(AttributeName.equals("FutureTravelPlans")){
									 
									 if(FutureTravelPlans.equals("Yes")){
										
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
										} catch (Exception e) {
											
										}
									}else{
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
										}
									}
								 }
								 else if(AttributeName.equals("YearsOfEducation")){
									 try {
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, YearsOfEducation);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("FieldOfStudy")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(FieldOfStudy);
									} catch (Exception e) {
										
									}
						        	} 
								 else if(AttributeName.equals("YearsOfExperience")){		
									 try {
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, YearsOfExperience);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("DeniedVisa")){
									 
									 if(DeniedVisa.equals("Yes")){
										
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
										} catch (Exception e) {
											
										}
									}else{
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
										}
									}
								 }else if(AttributeName.equals("Arrested")){
									 
									 if(Arrested.equals("Yes")){
											
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
											} catch (Exception e) {
												
											}
										}else{
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
												Thread.sleep(1000);
											} catch (Exception e) {
											}
										}
									 
									 
								 }else{
									 System.out.println("Field not found");
								 }

							
							 
							 } catch (Exception e) {
								System.out.println("Attribute name not found");
							}
							 
							 
					}
					 }catch(Exception e){
						 
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e) {
						System.out.println("unable to set additional info..");
					}
					
					
				}
				
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
//				try {
//					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
//					utilfunc.MakeElement(updateBtnXpath).click();
//				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					error_flag=utilfunc.ErrorMessagehandlerExperiment();
					//ExpectedErrorMessage=ExpectedErrorMessage.trim();
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
					 }else if(error_flag.contains("Error! This role name is already existed.")){
						 Flag= false;
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
			
			String DoneBtnXpath ="//*[contains(@class,'btn') and text()='Done']";
			
			try {
				utilfunc.MakeElement(DoneBtnXpath).click();
			} catch (Exception e) {
			System.out.println("Not Able to click on the Done Btn");
			}
				
				 
	
	
	
	
	
	return Flag;
	 	}



}
