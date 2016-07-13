package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Assessment_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	 public static String Deletecheck="";
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 

	
	 //Constructor----------
	 
		public CIMS_Assessment_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Assessment_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Assessment", 0, ColumnCounter);
			String AssessmentScenerio=UtilFunction.getCellData("Test Data.xls", "Assessment", 2, ColumnCounter);
			String AssessmentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Assessment", 3, ColumnCounter);		
			String AssessmentPageURL=UtilFunction.getCellData("Test Data.xls", "Assessment", 4, ColumnCounter);
			String AssessmentID=UtilFunction.getCellData("Test Data.xls", "Assessment", 5, ColumnCounter);
			
			String Firstname=UtilFunction.getCellData("Test Data.xls", "Assessment", 6, ColumnCounter);
			String Middlename=UtilFunction.getCellData("Test Data.xls", "Assessment", 7, ColumnCounter);
			String Lastname=UtilFunction.getCellData("Test Data.xls", "Assessment", 8, ColumnCounter);
			String JobTitle=UtilFunction.getCellData("Test Data.xls", "Assessment", 9, ColumnCounter);
 			String delelecitizenship=UtilFunction.getCellData("Test Data.xls", "Assessment", 10, ColumnCounter);
			String DateTentativeStart=UtilFunction.getCellData("Test Data.xls", "Assessment", 11, ColumnCounter);
			String DateTentativeReturn=UtilFunction.getCellData("Test Data.xls", "Assessment", 12, ColumnCounter);
			String form_DestinationCountryCode=UtilFunction.getCellData("Test Data.xls", "Assessment", 13, ColumnCounter);
			String City=UtilFunction.getCellData("Test Data.xls", "Assessment", 14, ColumnCounter);
			String JobNote=UtilFunction.getCellData("Test Data.xls", "Assessment", 15, ColumnCounter);
			String ThirdPartySite=UtilFunction.getCellData("Test Data.xls", "Assessment", 16, ColumnCounter);
			String OriginCountry=UtilFunction.getCellData("Test Data.xls", "Assessment", 17, ColumnCounter);
			String OriginCity=UtilFunction.getCellData("Test Data.xls", "Assessment", 18, ColumnCounter);
			String HasTravelToDestCountryLastOneYear=UtilFunction.getCellData("Test Data.xls", "Assessment", 19, ColumnCounter);
			String HowDayToDestCountry=UtilFunction.getCellData("Test Data.xls", "Assessment", 20, ColumnCounter);
			String FutureTravelPlans=UtilFunction.getCellData("Test Data.xls", "Assessment", 21, ColumnCounter);
			String YearsOfEducation=UtilFunction.getCellData("Test Data.xls", "Assessment", 22, ColumnCounter);
			String FieldOfStudy=UtilFunction.getCellData("Test Data.xls", "Assessment", 23, ColumnCounter);
			String YearsOfExperience=UtilFunction.getCellData("Test Data.xls", "Assessment", 24, ColumnCounter);
			String DeniedVisa=UtilFunction.getCellData("Test Data.xls", "Assessment", 25, ColumnCounter);
			String Arrested=UtilFunction.getCellData("Test Data.xls", "Assessment", 26, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Assessment", 27, ColumnCounter);
			String CityTownLocality=UtilFunction.getCellData("Test Data.xls", "Assessment", 28, ColumnCounter);
			String StateProvinceTerritory=UtilFunction.getCellData("Test Data.xls", "Assessment", 29, ColumnCounter);
			
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";
			
			String Assessment_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name and not (@type='hidden')]";
			String AssessmentCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name and not (@type='hidden')]";
			
			String Citizenshipbuttonxpath=".//*[@id='btnAddCitizenship']";
			String CitizenshipSpousebuttonxpath=".//*[@id='btnAddCitizenshipSpouse']";
			
			String Firstnamexpath=".//*[@name='FirstName']";
			String Middlenamexpath=".//*[@name='MiddleName']";
			String lastnamexpath=".//*[@name='LastName']";
			
			String SpouseFirstNamexpath=".//*[@id='SpouseFirstName']";
			String SpouseMiddleNamexpath=".//*[@id='SpouseMiddleName']";
			String SpouseLastNamexpath=".//*[@id='SpouseLastName']";
			
			String proposedamountxpath=".//*[@id='Salary']";
			String proposedcurrencyxpath=".//*[@id='SalaryCurrency']";

			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Assessment";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=AssessmentScenerio;
			 description=AssessmentTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 //Assert.assertFalse(URLwithID.equals(""));
				 
				 }else{
				  
			
					 String NewXpath;
					 String AttributeName;
			 if(mode.equals(ACTION)|mode.equals(ACTION1)){
				 
				 try{/*
					 String AssessmentURLwithID=AssessmentPageURL+AssessmentID;
					 utilfunc.NavigatetoURL(AssessmentURLwithID);
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					
					 /////////name////////////////
					 try{
						 utilfunc.MakeElement(Firstnamexpath).clear();
						 utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
						 utilfunc.MakeElement(Middlenamexpath).clear();
						 utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
						 utilfunc.MakeElement(lastnamexpath).clear();
						 utilfunc.MakeElement(lastnamexpath).sendKeys(Lastname);
					 }catch(Exception e){
						 
					 }
					 
					 /////////spouse name////////////////
					 try{
						 utilfunc.MakeElement(SpouseFirstNamexpath).clear();
						 utilfunc.MakeElement(SpouseFirstNamexpath).sendKeys(SpouseFirstName);
						 utilfunc.MakeElement(SpouseMiddleNamexpath).clear();
						 utilfunc.MakeElement(SpouseMiddleNamexpath).sendKeys(SpouseMiddleName);
						 utilfunc.MakeElement(SpouseLastNamexpath).clear();
						 utilfunc.MakeElement(SpouseLastNamexpath).sendKeys(SpouseLastName);
					 }catch(Exception e){
						 
					 }
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(AssessmentCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Assessment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("group_citizenships")){
								 String newpath=NewXpath+"[2]";
							     utilfunc.Selectdropdownvaluebyvalue(newpath, Citizenship);
							     utilfunc.MakeElement(Citizenshipbuttonxpath).click();
					        	}	
							 else if(AttributeName.equals("group_citizenshipsSpouse")){							
								 String newpath=NewXpath+"[2]";
							     utilfunc.Selectdropdownvaluebyvalue(newpath, spousecitizenship);
							     utilfunc.MakeElement(CitizenshipSpousebuttonxpath).click();
					        	}
							 else if(AttributeName.equals("HasUniversityDegree")){							
								 if(DoyouhaveUniversitydegreeradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("IsDegreeRelatedJob")){							
								 if(Isyourdegreerelatedtoyourjobradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("HasExperienceRelatedJob")){							
								 if(Doyouhaveexperienceradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("HowYearExperienceRelatedJob")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Ifyeshowmanyyears);
					        	}
							 else if(AttributeName.equals("DateOfHireSendingCompany")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Dateofhire);
					        	}
							 else if(AttributeName.equals("JobTitle")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Proposedjobtitle);
								 
								 utilfunc.MakeElement(proposedamountxpath).clear();
								 utilfunc.MakeElement(proposedamountxpath).sendKeys(proposedamount);
								 utilfunc.Selectdropdownvaluebyvalue(proposedcurrencyxpath, proposedcurrency);
					        	}
							 else if(AttributeName.equals("ForeignPayrollCountryCode")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, PayrollCountry);
					        	}
							 else if(AttributeName.equals("JobNote")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(JobDescription);
					        	}
							 else if(AttributeName.equals("IsNewOrInternational")){	
								 if(Areyouanewhireradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
								}
							 else if(AttributeName.equals("HomeCountryPayroll")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(ifyouareaninternationalexplain);
					        	}
							 else if(AttributeName.equals("DateTentativeStart")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(TentativestartdateinAUSTRALIA);
					        	}
							 else if(AttributeName.equals("CountryCode")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Country);
					        	} 
							 else if(AttributeName.equals("City")){		
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(CityTownLocality);
					        	}
							 else if(AttributeName.equals("StateOrProvince")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(StateProvinceTerritory);
					        	}
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 String SaveButtonXpath="//*[@id='btnsaveAsDraft']";
					 utilfunc.MakeElement(SaveButtonXpath).click();
					 utilfunc.savebutton();
				        
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
				 */
					 
				 
				 
				 }catch(Exception e){
					/* utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();*/
				 }
				 
				 
				 try{
					 /*String AssessmentURLwithID=AssessmentPageURL+AssessmentID;
					 utilfunc.NavigatetoURL(AssessmentURLwithID);*/
				
					 try {
						 Thread.sleep(1000);
						utilfunc.NavigatetoURL(URLwithID);
						Thread.sleep(1000);
				
					     utilfunc.ServerErrorHandler();
						Thread.sleep(1000);
					
					 
					 
					 
					
					 /////////name////////////////
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
					 
					 /*String SaveButtonXpath="//*[@id='btnsaveAsDraft']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
					 try {
						 String SaveBtn=".//*[contains(@class,'btn') and text()='Save']";
						 Thread.sleep(1000);
						utilfunc.MakeElement(SaveBtn).click();
					} catch (Exception e) {
						
					}
					 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
					 } catch (Exception e1) {
						 
						 utilfunc.NavigatetoURL(URLwithID);
							
						} 
				 }catch(Exception e){
					 utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();
					 
				 }
				 
				 
				 } else if(mode.equals(ACTION2)){
				 
				 try{	
						utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
						
						try {
							utilfunc.NavigatetoURL(URLwithID);
							
							utilfunc.ServerErrorHandler();
							
							String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(deletexpath).click();
							} catch (Exception e) {
								
							}
							utilfunc.isAlertPresent();
							
							boolean error_flag=utilfunc.ErrorMessagehandler();
							 if (error_flag){
								 Flag=true;
							 }else{
								 Flag=false;
							 }
						} catch (Exception e) {
							utilfunc.NavigatetoURL(URLwithID);
							
						}
						 
						}catch(Exception z){
							utilfunc.ErrorMessage="";
							utilfunc.ErrorMessage1="";							
							utilfunc.ErrorMessage4="";
							utilfunc.ErrorMessage5="";
							Deletecheck="Delete";
							testcaseid="TC001";
							scenerio="Positive";
							description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
							utilfunc.ErrorMessage2="Delete option is not Implimented in Assesment Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				 
				
				 }///////////url ckeck end
			 
			
			 return Flag;
	 	}

}
