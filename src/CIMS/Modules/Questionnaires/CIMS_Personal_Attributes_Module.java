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
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Personal_Attributes_Module {
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

	public CIMS_Personal_Attributes_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Personal_Attributes_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 0, ColumnCounter);
		String Personal_AttributesScenerio=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 2, ColumnCounter);
		String Personal_AttributesTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 3, ColumnCounter);		
		String Personal_AttributesPageURL=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 4, ColumnCounter);
		String Personal_AttributesID=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 5, ColumnCounter);

		String Personal_AttributesReligion=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 6, ColumnCounter);
		String Personal_AttributesRace=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 7, ColumnCounter);
		String Personal_AttributesHeight=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 8, ColumnCounter);
		String Personal_AttributesCentimeters=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 9, ColumnCounter);
		String Personal_AttributesWeight=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 10, ColumnCounter);
		String Personal_AttributesKilograms=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 11, ColumnCounter);
		String Personal_AttributesEyeColor=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 12, ColumnCounter);
		String Personal_AttributesHairColor=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 13, ColumnCounter);
		String Personal_AttributesComplexion=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 14, ColumnCounter);
		String Personal_AttributesBloodType=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 15, ColumnCounter);
		String Personal_AttributesScarsRadio=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 16, ColumnCounter);
		String Personal_AttributesScarsRadiodescribe=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 17, ColumnCounter);
		String Personal_AttributesBirthmarksradio=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 18, ColumnCounter);
		String Personal_AttributesBirthmarksdescribe=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 19, ColumnCounter);
		String Personal_AttributesTattoosradio=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 20, ColumnCounter);
		String Personal_AttributesTattoosdescribe=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 21, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Personal_Attributes", 22, ColumnCounter);

		String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		String Personal_Attributes_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
		String Personal_AttributesCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

		//String Personal_Attributesradio_fieldxpath=".//*[@class='form-horizontal']//*[@class='question-group'][xx]//*[@id]";
		String Personal_Attributesradio_fieldxpath=".//*[@class='form-horizontal']//*[@class='question-group'][xx]//*[@class='question-option']//*[@id]";
		String Personal_Attributesradio_counterxpath=".//*[@class='form-horizontal']//*[@class='question-group']//*[@id]";

		String scarxpath=".//*[@id='ScarsDescription']";
		String bithmarkxpath=".//*[@id='BirthmarksDescrption']";
		String tatooxpath=".//*[@id='TattoosDescription']";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Personal Attributes";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Personal_AttributesScenerio;
		description=Personal_AttributesTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";

		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String Personal_AttributesURLwithID=Personal_AttributesPageURL+Personal_AttributesID;
					 utilfunc.NavigatetoURL(Personal_AttributesURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();

					int ObjCount=utilfunc.GetObjectCount(Personal_AttributesCounterXpath);
					int ObjCount1=utilfunc.GetObjectCount(Personal_Attributesradio_counterxpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=Personal_Attributes_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("Religion")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesReligion);
							}	
							else if(AttributeName.equals("Race")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesRace);
							}
							else if(AttributeName.equals("HeightUnit")){							
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesHeight);}catch(Exception error){}
								try{utilfunc.Selectdropdownvaluebytext(NewXpath, Personal_AttributesHeight);}catch(Exception error){}
							}
							else if(AttributeName.equals("div_height_english")){							
								try{utilfunc.MakeElement(NewXpath).sendKeys(Personal_AttributesCentimeters);}catch(Exception error){}
							}
							else if(AttributeName.equals("WeightUnit")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesWeight);
							}
							else if(AttributeName.equals("div_weight_english")){							
								utilfunc.MakeElement(NewXpath).sendKeys(Personal_AttributesKilograms);
							}
							else if(AttributeName.equals("EyeColor")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesEyeColor);
							}
							else if(AttributeName.equals("HairColor")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesHairColor);
							}
							else if(AttributeName.equals("Complexion")){							
								try{utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesComplexion);}catch(Exception error){}
								try{utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Personal_AttributesComplexion);}catch(Exception error){}
							}
							else if(AttributeName.equals("BloodType")){		
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesBloodType);
							}

						}catch(Exception e){

						}
					}
					////////////////////////radio//////////////
					for(int count=1; count<=ObjCount1; count++)
					{
						String NewXpath=Personal_Attributesradio_fieldxpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("HasScars")){	

								if(Personal_AttributesScarsRadio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(scarxpath).clear();
										utilfunc.MakeElement(scarxpath).sendKeys(Personal_AttributesScarsRadiodescribe);
									}catch(Exception error){}
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input[1]");
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(scarxpath).clear();
										utilfunc.MakeElement(scarxpath).sendKeys(Personal_AttributesScarsRadiodescribe);
									}catch(Exception error){}
								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input/[2]");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("HasBirthmarks")){

								if(Personal_AttributesBirthmarksradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(bithmarkxpath).clear();
										utilfunc.MakeElement(bithmarkxpath).sendKeys(Personal_AttributesBirthmarksdescribe);
									}catch(Exception error){}

									try{ String NewXpath1=NewXpath.replace("//*[@id]", "//input[1]");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(bithmarkxpath).clear();
									utilfunc.MakeElement(bithmarkxpath).sendKeys(Personal_AttributesBirthmarksdescribe);
									}catch(Exception error){}

								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input[2]");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}
							else if(AttributeName.equals("HasTattoos")){

								if(Personal_AttributesTattoosradio.equals("Yes")){
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(tatooxpath).clear();
										utilfunc.MakeElement(tatooxpath).sendKeys(Personal_AttributesTattoosdescribe); 
									}catch(Exception error){}

									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input[1]");
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(tatooxpath).clear();
										utilfunc.MakeElement(tatooxpath).sendKeys(Personal_AttributesTattoosdescribe); 
									}catch(Exception error){}

								}else{
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
									try{
										String NewXpath1=NewXpath.replace("//*[@id]", "//input[2]");
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception error){}
								}
							}


						}catch(Exception e){

						}
					}
					//////////////////////Additional info handle///////////////////////////////
					utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);

					utilfunc.savebutton();


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

				}


			}else if(mode.equals(ACTION1)){
				try{
					/*String Personal_AttributesURLwithID=Personal_AttributesPageURL+Personal_AttributesID;
					 utilfunc.NavigatetoURL(Personal_AttributesURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);

					utilfunc.ServerErrorHandler();


					int ObjCount=utilfunc.GetObjectCount(Personal_AttributesCounterXpath);
					int ObjCount1=utilfunc.GetObjectCount(Personal_Attributesradio_counterxpath);

					for(int count=1; count<=ObjCount; count++)
					{
						String NewXpath=Personal_Attributes_attributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("Religion")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesReligion);
							}	
							else if(AttributeName.equals("Race")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesRace);
							}
							else if(AttributeName.equals("HeightUnit")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesHeight);
							}
							else if(AttributeName.equals("div_height_english")){
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Personal_AttributesCentimeters);
							}
							else if(AttributeName.equals("WeightUnit")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesWeight);
							}
							else if(AttributeName.equals("div_weight_english")){	
								utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(Personal_AttributesKilograms);
							}
							else if(AttributeName.equals("EyeColor")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesEyeColor);
							}
							else if(AttributeName.equals("HairColor")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesHairColor);
							}
							else if(AttributeName.equals("Complexion")){							
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesComplexion);
							}
							else if(AttributeName.equals("BloodType")){		
								utilfunc.Selectdropdownvaluebyvalue(NewXpath, Personal_AttributesBloodType);
							}

						}catch(Exception e){

						}
					}
					////////////////////////radio//////////////
					for(int count=1; count<=ObjCount1; count++)
					{
						String NewXpath=Personal_Attributesradio_fieldxpath.replace("xx", Integer.toString(count));
						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("HasScars")){	

								if(Personal_AttributesScarsRadio.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(scarxpath).clear();
									utilfunc.MakeElement(scarxpath).sendKeys(Personal_AttributesScarsRadiodescribe);
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									utilfunc.MakeElement(NewXpath1).click();
								}
							}
							else if(AttributeName.equals("HasBirthmarks")){

								if(Personal_AttributesBirthmarksradio.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(bithmarkxpath).clear();
									utilfunc.MakeElement(bithmarkxpath).sendKeys(Personal_AttributesBirthmarksdescribe);

								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									utilfunc.MakeElement(NewXpath1).click();
								}
							}
							else if(AttributeName.equals("HasTattoos")){

								if(Personal_AttributesTattoosradio.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									utilfunc.MakeElement(NewXpath1).click();

									utilfunc.MakeElement(tatooxpath).clear();
									utilfunc.MakeElement(tatooxpath).sendKeys(Personal_AttributesTattoosdescribe); 
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									utilfunc.MakeElement(NewXpath1).click();
								}
							}


						}catch(Exception e){

						}
					}
					//////////////////////Additional info handle///////////////////////////////
					utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);

					utilfunc.savebutton();


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

					String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					utilfunc.MakeElement(deletexpath).click();
					utilfunc.isAlertPresent();

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
					utilfunc.ErrorMessage2="Delete option is not Implimented in Personal Attributes Module.";
					utilfunc.TakeScreenshot();
					Flag=false;
				}			

			}
		}///////////url ckeck end
		return Flag;
	}

}
