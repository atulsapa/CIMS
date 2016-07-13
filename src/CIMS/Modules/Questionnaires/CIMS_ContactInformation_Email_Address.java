package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_ContactInformation_Email_Address {

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
	 public CIMS_ContactInformation_Email_Address(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }


	public boolean ContactInformation_Email_Address(int ColumnCounter,String mode)throws AWTException, InterruptedException {

		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 0, ColumnCounter);
	   
		String Contact_InformationScenerio=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 2, ColumnCounter);
		String Contact_InformationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 3, ColumnCounter);		
		
		
		
		String Contact_InformationEmail=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 4, ColumnCounter);
	    String Contact_InformationIsphonenumberisprimary=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 5, ColumnCounter);

		
		
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Email", 6, ColumnCounter);
		
		String Contact_Information_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
		String Contact_InformationCounterXpath=".//*[@class='control-group']//*[@id]";
		
		String countryxpath=".//*[@id='country']";
		
//		String ResidenceAddressxpath=".//*[@id='divResidence']//*[@class='icon-pencil icon-block']";
		String MailingAddressxpath=".//*[@class='form-horizontal']/div[4]//*[@class='control-group']//*[@class='btn']";
//		String PermanentAddressinHomeCountryxpath=".//*[@id='divPermanet']//*[@class='icon-pencil icon-block']";
//		String EmailAddressxpath=".//*[@id='divEmail']//*[@class='icon-pencil icon-block']";
//		String PhoneNumberxpath=".//*[@id='divPhone']//*[@class='icon-pencil icon-block']";
		
		String addresslookupxpath=".//*[@class='question-group-address']//*[@id]";
		String Emailxpath	=	".//*[@name='Email']";//".//*[@class='fld-email']";
		String EmailIsPrimaryXPath		=	".//*[@id='fld-primary-email']";
		
		String phonenumberenterxpath=".//*[@class='control-group']//*[@id]";
		
		String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
		String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

		/////////////////////////////////URL FETCH///////////////////////////////////
		String QuestionarieName="Contact Info";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		try {
			Thread.sleep(1000);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			
			
			
		} catch (Exception e1) {}			
		boolean Flag =false;
		 testcaseid=TestcaseID;
		 scenerio=Contact_InformationScenerio;
		 description=Contact_InformationTestcaseDescription;
		 
		 String ACTION="New";
		 String ACTION1="Edit";
		 String ACTION2="Delete";
		 
		 if(URLwithID.equals("")){
			 utilfunc.closesidebar();
			 Flag=false; 
			 }else{
				 if(mode.equals(ACTION)||mode.equals(ACTION1)){
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 

					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(MailingAddressxpath).click();
						
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {}
					 
					 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
					 
					 
					 // email code...

					 try {
						 utilfunc.MakeElement(Emailxpath).clear();
						 utilfunc.MakeElement(Emailxpath).sendKeys(Contact_InformationEmail);
					} catch (Exception e1) {
						System.out.println("email not placed");
					}
					 

					 // primary...
					 if(Contact_InformationIsphonenumberisprimary.equals("Yes")){
						 try {
							 Thread.sleep(1000);
						 		utilfunc.MakeElement(EmailIsPrimaryXPath).click();
						} catch (Exception e1) {
							System.out.println("email is primary not clicked");
						}
					 }

						try {
							Thread.sleep(3000);
							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
							Thread.sleep(3000);
						} catch (Exception e) {
							
							System.out.println("Dynamic Data not set");
						}
						
					
					 
				 }
				 try {
					 Thread.sleep(1000);
					utilfunc.savebutton();
				} catch (Exception e) {	}
			        
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
					 
			 
				 if(mode.equals(ACTION2)){
					 
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
							
							boolean error_flag1=utilfunc.ErrorMessagehandler();
							 if (error_flag1){
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
			 
	  }
	 return Flag;
 	
	}
	 





}
