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

public class CIMS_Travel_Plans_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	
	 //Constructor----------
	 
		public CIMS_Travel_Plans_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Future_Travel_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 0, ColumnCounter);
			String Future_TravelScenerio=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 2, ColumnCounter);
			String Future_TravelTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 3, ColumnCounter);		
			String Future_TravelPageURL=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 4, ColumnCounter);
			String Future_TravelID=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 5, ColumnCounter);
			
			String Future_TravelCountry=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 6, ColumnCounter);
			String Future_TravelEstimatedDatesarival=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 7, ColumnCounter);
			String Future_TravelEstimatedDatesdeparture=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 8, ColumnCounter);
			String Future_TravelWillyoubeexiting=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 9, ColumnCounter);
			String Future_TravelIfyespleaseexplain=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 10, ColumnCounter);
			String Future_TravelPurposeofvisit=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 11, ColumnCounter);
			String Future_TravelHowareyouarriving=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 12, ColumnCounter);
			String Future_TravelPortofDeparture=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 13, ColumnCounter);
			String Future_TravelCarrier=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 14, ColumnCounter);
			String Future_TravelFlightroutenumber=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 15, ColumnCounter);
			String Future_TravelTypeofresidence=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 16, ColumnCounter);
			String Future_TravelIfotherspecify=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 17, ColumnCounter);
			String Future_TravelHostorhotelname=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 18, ColumnCounter);
			String Future_TravelRelationshiptohost=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 19, ColumnCounter);
			String Future_TravelLodgeCountryCode=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 20, ColumnCounter);
			String Future_TravelLodgeStreetAddress1=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 21, ColumnCounter);
			String Future_TravelLodgeStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 22, ColumnCounter);
			String Future_TravelAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 23, ColumnCounter);
			String Future_TravelLodgeCity=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 24, ColumnCounter);
			String Future_TravelLodgeStateOrProvince=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 25, ColumnCounter);
			String Future_TravelLodgePostalCode=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 26, ColumnCounter);
			String Future_Traveladdresslookup=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 27, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Future_Travel", 28, ColumnCounter);
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";
			
			String Future_Travel_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String Future_TravelCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			
			String Estimateddatearivalxpath=".//*[@class='control-group field-group-inline']//*[@class='field'][1]//*[@id]";
			String EstimateddateDeparturexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][2]//*[@id]";

			String addreslookupxpath=".//*[@class='panel-body-main']//*[@class='question-group-address']//*[@name]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Future Travel";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Future_TravelScenerio;
			 description=Future_TravelTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Future_TravelURLwithID=Future_TravelPageURL+Future_TravelID;
					 utilfunc.NavigatetoURL(Future_TravelURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(1000);
					 String AddbuttonXpath="//*[@class='btn']";
					 try{utilfunc.MakeElement(AddbuttonXpath).click();
					 Thread.sleep(2000);
					 }catch(Exception error){}
					 
					 int ObjCount=utilfunc.GetObjectCount(Future_TravelCounterXpath);
					 try{
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Future_Travel_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CountryCode")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelCountry);
					        	}	
							 else if(AttributeName.equals("WillExitingOrReEntering")){		
								 if(Future_TravelWillyoubeexiting.endsWith("Yes")){
								try{
									String nWeXpth=".//*[@class='form-horizontal']//*[@class='control-group'][2]//input[contains(@type,'radio') and contains(@value,'True')]";
									Thread.sleep(1000);
									utilfunc.MakeElement(nWeXpth).click();
									Thread.sleep(800);
								}catch(Exception eror){}
								 }
								 else{
									 try{
											String nWeXpth=".//*[@class='form-horizontal']//*[@class='control-group'][2]//input[contains(@type,'radio') and contains(@value,'False')]";
											Thread.sleep(1000);
											utilfunc.MakeElement(nWeXpth).click();
											Thread.sleep(800);
										}catch(Exception eror){}
									 
								 }
					        	}
							 else if(AttributeName.equals("WillExitingOrReEnteringExplain")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelIfyespleaseexplain);
					        	}
							 else if(AttributeName.equals("PurposeOfVisit")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelPurposeofvisit);
					        	}
							 else if(AttributeName.equals("HowArriving")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelHowareyouarriving);
								 
								 if(Future_TravelHowareyouarriving.equals("OTHER")){
									 String xpath=NewXpath+"[2]";
									 utilfunc.MakeElement(xpath).sendKeys(Future_TravelHowareyouarriving);
								 }
					        	}
							 else if(AttributeName.equals("PortOfEntryDeparting")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelPortofDeparture);
					        	}
							 else if(AttributeName.equals("CarrierArriving")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelCarrier);
								 
					        	}
							 else if(AttributeName.equals("RouteNumberArriving")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelFlightroutenumber);
					        	}
							 else if(AttributeName.equals("LodgingType")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelTypeofresidence);
					        	}
							 else if(AttributeName.equals("LodgingTypeOther")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelIfotherspecify);
					        	}
							 else if(AttributeName.equals("LodgingName")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelHostorhotelname);
					        	}
							 else if(AttributeName.equals("LodgingRelationship")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelRelationshiptohost);
					        	}
							 else if(AttributeName.equals("LodgeCountryCode")){			
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelLodgeCountryCode);
							 	}
							 else if(AttributeName.equals("LodgeStreetAddress1")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStreetAddress1);
					        	}
							 else if(AttributeName.equals("LodgeStreetAddress2")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStreetAddress2);
					        	}
							 else if(AttributeName.equals("LodgeUnitType")){	
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelAptSteFlr);
								 								 
								 String xpath=NewXpath+"[2]";
								 utilfunc.MakeElement(xpath).sendKeys(Future_TravelAptSteFlr);
								 
					        	}
							 else if(AttributeName.equals("LodgeCity")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeCity);
					        	}
							 else if(AttributeName.equals("LodgeStateOrProvince")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStateOrProvince);
					        	}
							 else if(AttributeName.equals("LodgePostalCode")){							
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgePostalCode);
					        	}
						 
						 }catch(Exception e){
							 
						 }
					 }
					 
					 }catch(Exception error){}
					 
					 
					 /////////////////estimated date handle/////////////////////////////////////
					 try{
					 utilfunc.MakeElement(Estimateddatearivalxpath).sendKeys(Future_TravelEstimatedDatesarival);
					 utilfunc.MakeElement(EstimateddateDeparturexpath).sendKeys(Future_TravelEstimatedDatesdeparture);
					 }catch(Exception e){
						 
					 }
					 ////////////////address lookup////////////////////////////////////////////
					 try{
							String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
							if(AttributeName.contains("form2_autocomplete")){			
							utilfunc.MakeElement(addreslookupxpath).sendKeys(Future_Traveladdresslookup);
							utilfunc.mouseaction();
							}
							}
						catch(Exception f){
							}
					 //////////////////////Additional info handle///////////////////////////////
					 try{
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 }catch(Exception error){}
					 
					 try {
						utilfunc.savebutton();
					} catch (Exception e) {

					}


					 String error_flag=utilfunc.TravelPlanErrorMessageHandler();
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

					 
				 }catch(Exception e){
					 
				 }
				 
				 
			 }else if(mode.equals(ACTION1)){
				 
				 try{
					 /*String Future_TravelURLwithID=Future_TravelPageURL+Future_TravelID;
					 utilfunc.NavigatetoURL(Future_TravelURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 utilfunc.MakeElement(EditbuttonXpath).click();
					 
					 int ObjCount=utilfunc.GetObjectCount(Future_TravelCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Future_Travel_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CountryCode")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelCountry);
					        	}	
							 else if(AttributeName.equals("WillExitingOrReEntering")){		
								 if(Future_TravelWillyoubeexiting.endsWith("Yes")){
								 utilfunc.MakeElement(NewXpath).click();
								 }
					        	}
							 else if(AttributeName.equals("WillExitingOrReEnteringExplain")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelIfyespleaseexplain);
					        	}
							 else if(AttributeName.equals("PurposeOfVisit")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelPurposeofvisit);
					        	}
							 else if(AttributeName.equals("HowArriving")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelHowareyouarriving);
								 
								 if(Future_TravelHowareyouarriving.equals("OTHER")){
									 String xpath=NewXpath+"[2]";
									 utilfunc.MakeElement(xpath).clear();
									 utilfunc.MakeElement(xpath).sendKeys(Future_TravelHowareyouarriving);
								 }
					        	}
							 else if(AttributeName.equals("PortOfEntryDeparting")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelPortofDeparture);
					        	}
							 else if(AttributeName.equals("CarrierArriving")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelCarrier);
					        	}
							 else if(AttributeName.equals("RouteNumberArriving")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelFlightroutenumber);
					        	}
							 else if(AttributeName.equals("LodgingType")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelTypeofresidence);
					        	}
							 else if(AttributeName.equals("LodgingTypeOther")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelIfotherspecify);
					        	}
							 else if(AttributeName.equals("LodgingName")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelHostorhotelname);
					        	}
							 else if(AttributeName.equals("LodgingRelationship")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelRelationshiptohost);
					        	}
							 else if(AttributeName.equals("LodgeCountryCode")){			
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelLodgeCountryCode);
							 	}
							 else if(AttributeName.equals("LodgeStreetAddress1")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStreetAddress1);
					        	}
							 else if(AttributeName.equals("LodgeStreetAddress2")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStreetAddress2);
					        	}
							 else if(AttributeName.equals("LodgeUnitType")){	
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Future_TravelAptSteFlr);
								 								 
								 String xpath=NewXpath+"[2]";
								 utilfunc.MakeElement(xpath).clear();
								 utilfunc.MakeElement(xpath).sendKeys(Future_TravelAptSteFlr);
								 
					        	}
							 else if(AttributeName.equals("LodgeCity")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeCity);
					        	}
							 else if(AttributeName.equals("LodgeStateOrProvince")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgeStateOrProvince);
					        	}
							 else if(AttributeName.equals("LodgePostalCode")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Future_TravelLodgePostalCode);
					        	}
						 
						 }catch(Exception e){
							 
						 }
					 }
					 /////////////////estimated date handle/////////////////////////////////////
					 try{
						 utilfunc.MakeElement(Estimateddatearivalxpath).clear();
					 utilfunc.MakeElement(Estimateddatearivalxpath).sendKeys(Future_TravelEstimatedDatesarival);
					 utilfunc.MakeElement(EstimateddateDeparturexpath).clear();
					 utilfunc.MakeElement(EstimateddateDeparturexpath).sendKeys(Future_TravelEstimatedDatesdeparture);
					 }catch(Exception e){
						 
					 }
					 ////////////////address lookup////////////////////////////////////////////
					 try{
							String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
							if(AttributeName.contains("form2_autocomplete")){			
							utilfunc.MakeElement(addreslookupxpath).sendKeys(Future_Traveladdresslookup);
							utilfunc.mouseaction();
							}
							}
						catch(Exception f){
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
					 }else if(error_flag.equals("Server Error in '/' Application.")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
					 
				 }catch(Exception e){
					 utilfunc.ErrorMessage="";
					 utilfunc.ErrorMessage1="";							
					 utilfunc.ErrorMessage4="";
					 utilfunc.ErrorMessage5="";
					 utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
				
				 
			 }else if(mode.equals(ACTION2)){
				 try{
					 /*String Future_TravelURLwithID=Future_TravelPageURL+Future_TravelID;
					 utilfunc.NavigatetoURL(Future_TravelURLwithID);*/
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					 utilfunc.MakeElement(DeletebuttonXpath).click();
					 
					 Thread.sleep(10000);
					 
					 utilfunc.isAlertPresent();
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
				 }catch(Exception e){
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
						testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					 utilfunc.ErrorMessage2="No Records Found to Delete";
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
				 
			 }
				 
				
				 
				 }///////////url ckeck end
			
			 return Flag;
	 	}

}
