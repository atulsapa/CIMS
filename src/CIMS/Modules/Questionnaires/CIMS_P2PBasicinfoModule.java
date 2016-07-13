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

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

@SuppressWarnings("unused")
public class CIMS_P2PBasicinfoModule {
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String parentprojectxpath=".//*[@class='sub-menu']/ul/li[2]/a";
	 public static String Transfertoprojectxpath=".//*[@class='sub-menu']/ul/li[1]/a";
	
	 

	 //parent
	 public static String BasicInformationPrefix;
	 public static String BasicInformationFirstName;
	 public static String BasicInformationMiddleName;
	 public static String BasicInformationLastName;
	 public static String BasicInformationPreferredName;
	 public static String BasicInfoClanOrTribeName;
	 public static String BasicInfoMaidenOrOtherNames; 	
	 public static String BasicInfoGender; 
	 public static String BasicInfoMaritalStatusCode; 
	 public static String BasicInfoDateOfBirth; 
	 public static String BasicInfoCountryOfBirth; 
	 public static String BasicInfoCityOfBirth; 
	 public static String BasicInfoStateOrProvinceOfBirth;
	 public static String BasicInfoCountryCode;
	 public static String BasicInfoOccupation;
	 public static String Basicinfovisaorpermitwasissued;
	 public static String BasicinfoSelectyourvalidvisaofpermit;
	 public static String BasicinfoVisaExpirationdate;
	 public static String BasicinfoVisareference;
	 
	 //child
	 public static String BasicInformationPrefix1;
	 public static String BasicInformationFirstName1;
	 public static String BasicInformationMiddleName1;
	 public static String BasicInformationLastName1;
	 public static String BasicInformationPreferredName1;
	 public static String BasicInfoClanOrTribeName1;
	 public static String BasicInfoMaidenOrOtherNames1; 	
	 public static String BasicInfoGender1; 
	 public static String BasicInfoMaritalStatusCode1; 
	 public static String BasicInfoDateOfBirth1; 
	 public static String BasicInfoCountryOfBirth1; 
	 public static String BasicInfoCityOfBirth1; 
	 public static String BasicInfoStateOrProvinceOfBirth1;
	 public static String BasicInfoCountryCode1;
	 public static String BasicInfoOccupation1;
	 public static String Basicinfovisaorpermitwasissued1;
	 public static String BasicinfoSelectyourvalidvisaofpermit1;
	 public static String BasicinfoVisaExpirationdate1;
	 public static String BasicinfoVisareference1;
	
	 //Constructor----------
	 
		public CIMS_P2PBasicinfoModule(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Basic_Information_info() throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			//Excel sheet Data collection
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@name]";
			
			String Basic_Information_attributeFiledXpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@name]";
			String Basic_InformationCounterXpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@name]";

			String citizenshipaddbutton=".//*[@id='btnAddCitzenship']";
			
			String Basicinfonamefieldxpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			String Basicinfonamecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";
			
			String visaorpermitxpath=".//*[@id='SpecialConditionCountry']";
			String Selectyourvalidvisaxpath=".//*[@class='FieldValue span3']/select[2]";
			
			String visapermitsbuttonxpath=".//*[@id='btnAddSpecialCondition']";
			String visaexpirationdatexpath=".//*[@id='dp1431095525540']";
			String visareferencexpath=".//*[@name='fld-referencenumber']";
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			
			
			boolean Flag =false;
						 
			 String ACTION="New";
			 String ACTION1="Edit";
		
			 		 
			 try{
					 /*String Basic_InformationURLwithID=Basic_InformationPageURL+Basic_InformationID;
					 utilfunc.NavigatetoURL(Basic_InformationURLwithID);*/
					 utilfunc.MakeElement(parentprojectxpath).click();
					 
					 String QuestionarieName="Basic Information";
					 //String URLwithID=UtilFunction.geturl(QuestionarieName);
					 URLwithID=utilfunc.geturldirectp2p(QuestionarieName);
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 int ObjCount1=utilfunc.GetObjectCount(Basicinfonamecounterxpath);
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=Basicinfonamefieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){								
								 BasicInformationFirstName=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals(".MiddleName")){								 
								 BasicInformationMiddleName=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("LastName")){								 
								 BasicInformationLastName=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
						 }catch(Exception f){
							 
						 }
					 }
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Basic_InformationCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Basic_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("NamePrefix")){	
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInformationPrefix=selectedOption;
								 //BasicInformationPrefix=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}	
							 else if(AttributeName.equals("PreferredName")){
								 BasicInformationPreferredName=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("ClanOrTribeName")){	
								 BasicInfoClanOrTribeName=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("MaidenOrOtherNames")){
								 BasicInfoMaidenOrOtherNames=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("Gender")){
								 String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
								 String NewXpath2=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
								 try{
								 if(utilfunc.MakeElement(NewXpath1).isSelected()){
								 BasicInfoGender=utilfunc.MakeElement(NewXpath1).getAttribute("value");
								 }else if(utilfunc.MakeElement(NewXpath2).isSelected()){
								 BasicInfoGender=utilfunc.MakeElement(NewXpath2).getAttribute("value");
								 }
								 }catch(Exception e){
									 
								 }
					        	}
							 else if(AttributeName.equals("MaritalStatusCode")){
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoMaritalStatusCode=selectedOption;
								 
					        	}
							 else if(AttributeName.equals("DateOfBirth")){	
								 BasicInfoDateOfBirth=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CountryOfBirth")){
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryOfBirth=selectedOption;
					        	}
							 else if(AttributeName.equals("CityOfBirth")){	
								 BasicInfoCityOfBirth=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfBirth")){	
								 BasicInfoStateOrProvinceOfBirth=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CitizenShipCountryCode")){	
								// String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryCode=utilfunc.MakeElement(NewXpath).getAttribute("value");
								}
							 else if(AttributeName.equals("Occupation")){	
								 BasicInfoOccupation=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CountryCode")){	
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryCode=selectedOption;
								}
							
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 /////////////////////////visa permit/////////////////////////////////////
				
					 try{
						 String selectedOption1 = new Select(webdriver.findElement(By.xpath(visaorpermitxpath))).getFirstSelectedOption().getText();
						 Basicinfovisaorpermitwasissued=selectedOption1;
						
						 String selectedOption2 = new Select(webdriver.findElement(By.xpath(Selectyourvalidvisaxpath))).getFirstSelectedOption().getText();
						 BasicinfoSelectyourvalidvisaofpermit=selectedOption2;
							
						 try{
						 BasicinfoVisaExpirationdate=utilfunc.MakeElement(visaexpirationdatexpath).getAttribute("value");
						 }
						 catch(Exception e){
							 
						 }
						 try{
						 BasicinfoVisareference=utilfunc.MakeElement(visareferencexpath).getAttribute("value");
						 }catch(Exception e){
							 
						 }
						 
						 
					 }catch(Exception e){
						 
					 } 
					//////////////////////////////////////////////////////////////////////////// 
					 
				 }catch(Exception e){
					 
				 }
				 
				 //////Transfer Questionnaire
				 
				 try{

					 /*String Basic_InformationURLwithID=Basic_InformationPageURL+Basic_InformationID;
					 utilfunc.NavigatetoURL(Basic_InformationURLwithID);*/
					 utilfunc.MakeElement(Transfertoprojectxpath).click();
					 
					 String QuestionarieName="Basic Information";
					 //String URLwithID=UtilFunction.geturl(QuestionarieName);
					 URLwithID=utilfunc.geturldirectp2p(QuestionarieName);
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 int ObjCount1=utilfunc.GetObjectCount(Basicinfonamecounterxpath);
					 
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=Basicinfonamefieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("FirstName")){								
								 BasicInformationFirstName1=utilfunc.MakeElement(NewXpath).getAttribute("value");
								 if(BasicInformationFirstName1.equals(BasicInformationFirstName)){
									 Reporter.log("FirstName Tranfered sucessfuly");
								 }
					        	}
							 else if(AttributeName.equals(".MiddleName")){								 
								 BasicInformationMiddleName1=utilfunc.MakeElement(NewXpath).getAttribute("value");
								 if(BasicInformationMiddleName1.equals(BasicInformationMiddleName)){
									 Reporter.log("MiddleName Tranfered sucessfuly");
								 }
					        	}
							 else if(AttributeName.equals("LastName")){								 
								 BasicInformationLastName1=utilfunc.MakeElement(NewXpath).getAttribute("value");
								 if(BasicInformationLastName1.equals(BasicInformationLastName)){
									 Reporter.log("LastName Tranfered sucessfuly");
								 }
					        	}
						 }catch(Exception f){
							 
						 }
					 }
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Basic_InformationCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Basic_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("NamePrefix")){	
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInformationPrefix1=selectedOption;
								 //BasicInformationPrefix=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}	
							 else if(AttributeName.equals("PreferredName")){
								 BasicInformationPreferredName1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("ClanOrTribeName")){	
								 BasicInfoClanOrTribeName1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("MaidenOrOtherNames")){
								 BasicInfoMaidenOrOtherNames1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("Gender")){
								 String NewXpath1=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][1]/input");
								 String NewXpath2=NewXpath.replace("//*[@name]", "//*[@class='radio inline'][2]/input");
								 try{
								 if(utilfunc.MakeElement(NewXpath1).isSelected()){
								 BasicInfoGender1=utilfunc.MakeElement(NewXpath1).getAttribute("value");
								 }else if(utilfunc.MakeElement(NewXpath2).isSelected()){
								 BasicInfoGender1=utilfunc.MakeElement(NewXpath2).getAttribute("value");
								 }
								 }catch(Exception e){
									 
								 }
					        	}
							 else if(AttributeName.equals("MaritalStatusCode")){
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoMaritalStatusCode1=selectedOption;
								 
					        	}
							 else if(AttributeName.equals("DateOfBirth")){	
								 BasicInfoDateOfBirth1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CountryOfBirth")){
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryOfBirth1=selectedOption;
					        	}
							 else if(AttributeName.equals("CityOfBirth")){	
								 BasicInfoCityOfBirth1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("StateOrProvinceOfBirth")){	
								 BasicInfoStateOrProvinceOfBirth1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CitizenShipCountryCode")){	
								// String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryCode1=utilfunc.MakeElement(NewXpath).getAttribute("value");
								}
							 else if(AttributeName.equals("Occupation")){	
								 BasicInfoOccupation1=utilfunc.MakeElement(NewXpath).getAttribute("value");
					        	}
							 else if(AttributeName.equals("CountryCode")){	
								 String selectedOption = new Select(webdriver.findElement(By.xpath(NewXpath))).getFirstSelectedOption().getText();
								 BasicInfoCountryCode1=selectedOption;
								}
							
							 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 /////////////////////////visa permit/////////////////////////////////////
				
					 try{
						 String selectedOption1 = new Select(webdriver.findElement(By.xpath(visaorpermitxpath))).getFirstSelectedOption().getText();
						 Basicinfovisaorpermitwasissued1=selectedOption1;
						
						 String selectedOption2 = new Select(webdriver.findElement(By.xpath(Selectyourvalidvisaxpath))).getFirstSelectedOption().getText();
						 BasicinfoSelectyourvalidvisaofpermit1=selectedOption2;
							
						 try{
						 BasicinfoVisaExpirationdate1=utilfunc.MakeElement(visaexpirationdatexpath).getAttribute("value");
						 }
						 catch(Exception e){
							 
						 }
						 try{
						 BasicinfoVisareference1=utilfunc.MakeElement(visareferencexpath).getAttribute("value");
						 }catch(Exception e){
							 
						 }
						 
						 
					 }catch(Exception e){
						 
					 } 
					//////////////////////////////////////////////////////////////////////////// 
					 
				 
					 
				 }catch(Exception e){
					 
				 }
				 
				 /////////////////////
				 
				 
				 
			 
				
				 
				 
			
			 return true;
	 	}

}
