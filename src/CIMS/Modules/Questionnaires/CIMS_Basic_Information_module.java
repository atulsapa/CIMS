////////////////new BASIc info//////////
package CIMS.Modules.Questionnaires;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.exec.ExecuteException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

@SuppressWarnings("unused")
public class CIMS_Basic_Information_module {
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	//Veriables-------------

	public static String Deletecheck="";
	public static String ErrorMessage1="";
	public static String ErrorMessage2="";
	public static String URLwithID="";

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";



	//Constructor----------

	public CIMS_Basic_Information_module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Basic_Information_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 0, ColumnCounter);
		String BasicInfoScenerio=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 2, ColumnCounter);
		String BasicInfoTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 3, ColumnCounter);		
		String BasicInformationPageURL=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 4, ColumnCounter);
		String BasicInformationID=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 5, ColumnCounter);			

		String BasicInformationPrefix=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 6, ColumnCounter);
		String BasicInformationFirstName=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 7, ColumnCounter);
		String BasicInformationMiddleName=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 8, ColumnCounter);
		String BasicInformationLastName=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 9, ColumnCounter);
		String BasicInformationPreferredName=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 10, ColumnCounter);

		String BasicInfoClanOrTribeName=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 11, ColumnCounter);
		String BasicInfoMaidenOrOtherNames=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 12, ColumnCounter); 	
		String BasicInfoGender=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 13, ColumnCounter); 
		String BasicInfoMaritalStatusCode=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 14, ColumnCounter); 
		String BasicInfoDateOfBirth=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 15, ColumnCounter); 
		String BasicInfoCountryOfBirth=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 16, ColumnCounter); 
		String BasicInfoCityOfBirth=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 17, ColumnCounter); 
		String BasicInfoStateOrProvinceOfBirth=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 18, ColumnCounter);
		String BasicInfoCountryCode=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 19, ColumnCounter);
		String BasicInfoOccupation=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 20, ColumnCounter);
		String Basicinfovisaorpermitwasissued=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 21, ColumnCounter);
		String BasicinfoSelectyourvalidvisaofpermit=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 22, ColumnCounter);
		String BasicinfoVisaExpirationdate=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 23, ColumnCounter);
		String BasicinfoVisareference=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 24, ColumnCounter);

		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Basic_Information", 25, ColumnCounter);

		String addditionalinfoxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@name]";

		String Basic_Information_attributeFiledXpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
		String Basic_InformationCounterXpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@name]";

		String citizenshipaddbutton=".//*[@id='btnAddCitzenship']";

		String Basicinfonamefieldxpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
		String Basicinfonamecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";

		String visaorpermitxpath=".//*[@id='SpecialConditionCountry']";
		String Selectyourvalidvisaxpath=".//*[@id='Classification']";

		String visapermitsbuttonxpath=".//*[@id='btnAddClassification']";
		String visaexpirationdatexpath=".//*[@class='fld-expirationdate span1 hasDatepicker']";

		//String visareferencexpath=".//*[@name='fld-referencenumber']";
		String visareferencexpath=".//*[@class='special_table']/tbody/tr[2]/td/*[@class='well']/*[@class='pull-left left-margin-10']//*[@name]";
		String status=".//*[@id='special_div']/table/tbody/tr[2]/td/div/div[5]/select";
		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Basic Information";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);

		String ValidVisasandPermitsXpath=".//*[@id='btnAddSpecialCondition']";

		try{
			URLwithID=utilfunc.geturldirect(QuestionarieName);
		}catch(Exception e){
			System.out.println("some issue occured with get url direct method..");
		}

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=BasicInfoScenerio;
		description=BasicInfoTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{


			if(mode.equals(ACTION)|mode.equals(ACTION1)){
				try{
					/*String Basic_InformationURLwithID=Basic_InformationPageURL+Basic_InformationID;
					 utilfunc.NavigatetoURL(Basic_InformationURLwithID);*/

					
						utilfunc.NavigatetoURL(URLwithID);
						utilfunc.ServerErrorHandler();
						Thread.sleep(2000);
					

					int ObjCount1=utilfunc.GetObjectCount(Basicinfonamecounterxpath);
					try{ 
						for(int count=1; count<=ObjCount1; count++)
						{
							Thread.sleep(300);
							String NewXpath=Basicinfonamefieldxpath.replace("xx", Integer.toString(count));
							try{
								String AttributeName="";
								try{
									AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
									//System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.equals("FirstName")){		
										try{ 
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInformationFirstName);
										}catch(Exception Error){}
									}
									else if(AttributeName.equals(".MiddleName")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInformationMiddleName);
										}catch(Exception Error){}
									}
									else if(AttributeName.equals("LastName")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInformationLastName);
										}catch(Exception Error){}
									}
								}catch(Exception error){}
							}catch(Exception f){

							}
						}
					}catch(Exception Error){}

					int ObjCount	=	utilfunc.GetObjectCount(Basic_InformationCounterXpath);
					try{
						for(int count=1; count<=ObjCount; count++)
						{
							Thread.sleep(300);
							String NewXpath=Basic_Information_attributeFiledXpath.replace("xx", Integer.toString(count));

							try{
								String AttributeName="";
								try{
									AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									//System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.equals("NamePrefix")){							
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, BasicInformationPrefix);
										}catch(Exception error){}
									}	
									else if(AttributeName.equals("PreferredName")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInformationPreferredName);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("ClanOrTribeName")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoClanOrTribeName);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("MaidenOrOtherNames")){
										try{utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoMaidenOrOtherNames);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("Gender")){							
										if(BasicInfoGender.equals("Male")){
											try{
												String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
												//System.out.println(NewXpath1);
												Thread.sleep(999);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception error){}
										}else{
											try{
												String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
												//System.out.println(NewXpath1);
												Thread.sleep(999);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception error){}
										}
									}
									else if(AttributeName.equals("MaritalStatusCode")){
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, BasicInfoMaritalStatusCode);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("DateOfBirth")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoDateOfBirth);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("CountryOfBirth")){							
										try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, BasicInfoCountryOfBirth);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("CityOfBirth")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoCityOfBirth);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("StateOrProvinceOfBirth")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoStateOrProvinceOfBirth);
										}catch(Exception error){}
									}
									else if(AttributeName.equals("CitizenShipCountryCode")){			
										try{
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, BasicInfoCountryCode);
											Thread.sleep(800);
											utilfunc.MakeElement(citizenshipaddbutton).click();
										}catch(Exception error){}
									}
									else if(AttributeName.equals("Occupation")){	
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(BasicInfoOccupation);
										}catch(Exception error){}
									}

								}catch(Exception error){}

							}catch(Exception e){

							}
						}
					}catch(Exception Error){}

					/////////////////////////visa permit/////////////////////////////////////
					try{
						utilfunc.Selectdropdownvaluebyvalue(visaorpermitxpath, Basicinfovisaorpermitwasissued);
						Thread.sleep(1000);

						//utilfunc.Selectdropdownvaluebyvalue(Selectyourvalidvisaxpath, BasicinfoSelectyourvalidvisaofpermit);
						utilfunc.Selectdropdownvaluebyvalue(".//*[@id='SpecialCondition']", BasicinfoSelectyourvalidvisaofpermit);

						//////////////////click add button for Valid Visas and permits////////////////
						Thread.sleep(1000);
						try{
							utilfunc.MakeElement(visapermitsbuttonxpath).click();
						}catch(Exception error){}
						try{
							utilfunc.MakeElement(ValidVisasandPermitsXpath).click();
						}catch(Exception error){}
						Thread.sleep(1000);

						utilfunc.MakeElement(visaexpirationdatexpath).clear();
						utilfunc.MakeElement(visaexpirationdatexpath).sendKeys(BasicinfoVisaExpirationdate);

						Thread.sleep(1000);

						try{
							utilfunc.MakeElement(visareferencexpath).clear();
							utilfunc.MakeElement(visareferencexpath).sendKeys(BasicinfoVisareference);
							//System.out.println("visa case reference:---"+BasicinfoVisareference); 
						}catch(Exception e){
							//System.out.println("visa case reference exception:---"+e); 
						}

						//Status added
						try{utilfunc.Selectdropdownvaluebyindex(status, 1);	}catch(Exception error){}

					}catch(Exception e){

					}

					//System.out.println("checking additional in");



					//////////////////////Additional info handle///////////////////////////////
					try{
						utilfunc.custom_field_data("Test Data.xls","Basic_Information",testcaseid,addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception error){}
					/*String SaveButtonXpath=".//*[@class='btn btn-primary']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/

					try{
						utilfunc.savebutton();
					}catch(Exception error){}

					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
						utilfunc.TakeScreenshot();
					}else if (error_flag.contains("Success!")){
						Flag=true;
					}else if (error_flag.equals("")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else{
						Flag=false;
						utilfunc.TakeScreenshot();
					}

					
				}catch(Exception e){

				}


			}else if(mode.equals(ACTION2)){

				try{	
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{
						utilfunc.MakeElement(deletexpath).click();
						utilfunc.isAlertPresent();
					}catch(Exception error){}

					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			
			}
		}///////////url ckeck end
		return Flag;
	}
}
