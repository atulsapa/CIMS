package CIMS.Modules.Questionnaires;



import java.awt.AWTException;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.Clipboard;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;

import java.security.Key;

import java.util.concurrent.TimeUnit;



import listner.ErrorUtil;



import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.ITestResult;

import org.testng.Reporter;



import util.UtilFunction;



public class Project_Initiation

{

	

	private WebDriver webdriver;	// Will be Provide by Calling Class.	

	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	private Robot Robot;

	//Veriables-------------

	

	//Project_Initiation_login()	 

	//Methods Xpaths	

	private static String UsernameTextBoxXpath="//*[@id='txtUsername']";

	private static String GOButtonXpath="//*[@id='btnLogin']";

	private static String PasswordTextBoxXpath="//*[@id='txtPassword']";

	private static String LoginButtonXpath=".//*[@id='btnLogin']";

	 

	 //Excel sheet Data collection

	private static String Username=UtilFunction.getCellData("Test Data.xls", "Credentials", 2, 1);

	private static String Password=UtilFunction.getCellData("Test Data.xls", "Credentials", 3, 1);

	

	

	//Welcome_Page()

		 

	//Methods Xpaths	

	//private static String WelcomeTextXpath="//*[@class='span10']/div[1]/table/tbody/tr/td[1]";

	private static String WelcomeTextXpath=".//*[@id='main-container']/div/div[1]/span[1]";

	private static String InitiateProjectButtonXpath="//*[@class='btn btn-primary']";



	//Project_Initiation_Page() 



	 //Methods Xpaths	

	 private static String ProjectInitiationxpath="Initiate";

	 private static String PageTitleTextXpath="//*[@id='panel-header']";

	 private static String HelpTextXpath="//*[@class='desc4 muted']";

	 private static String HeadingTextXpath="//*[@id='form1']/h4";

	 private static String CompanyTextboxXpath="//*[@id='GetCompanyId']";

	 private static String Individualxpath=".//*[@id='Individual']";

	 private static String Destinationcountryxpath=".//*[@id='ddlDestinationCountryCode']";

	 private static String Destinationcityxpath=".//*[@id='txtDestinationCity']";

	 private static String BusinessUnitDropdownXpath="//*[@id='buid']";

	 private static String EmployeeIDTextboxXpath="//*[@id='txtEmployeeNumber']";

	 private static String PrefixDropdownXpath="//*[@id='ddlPrefix']";

	 private static String FirstNameTextboxXpath="//*[@id='txtFirstName']";

	 private static String MiddleNameTextboxXpath="//*[@id='txtMiddleName']";

	 private static String LastNameTextboxXpath="//*[@id='txtLastName']";

	 private static String DateOfBirthTextboxXpath="//*[@id='txtDateOfBirth']";

	 private static String EmailTextboxXpath="//*[@id='txtEmail']";

	 private static String NextButtonXpath="//*[@id='btnSearch']";

	 private static String ErrorMessageXpath="//*[@id='page-message']";

	 

	 ///xpath to check if the employee already exist in the cobalt

	 private static String Employeealreadyexistcheckxpath=".//*[@id='divResult']/h5";

	 

	//Excel sheet Data collection

	 public static String testcaseId=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 0, 1);

	 private static String runmode=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 1, 1);

	 public static String testcasescenario=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 2, 1);

	 public static String testcasedescription=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 3, 1);

	 private static String Company=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 4, 1);

	 private static String Individual=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 5, 1);

	 private static String Destinationcountry=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 6, 1);

	 private static String Destinationcity=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 7, 1);

	 private static String BusinessUnit=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 8, 1);

	 private static String EmployeeID=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 9, 1);

	 private static String Prefix=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 10, 1);

	 private static String FirstName=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 11, 1);

	 private static String MiddleName=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 12, 1);

	 private static String LastName=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 13, 1);

	 private static String DateOfBirth=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 14, 1);

	 private static String Email=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 15, 1);

	 

	 //Project_Initiation_Step1_Page() 

	 

	//Methods Xpaths	

	 private static String DuplicateCheckPageBodyXpath=".//*[@id='divResult']";

	 private static String DuplicateCheckPageBackButton="//*[@class='clearfix']//*[@class='btn']";

	 private static String PagetitleTextXpath="//*[@class='form-horizontal']/h5";

	 private static String PagetitleHelpTextXpath="//*[@class='form-horizontal']/p";

	 private static String PageTabelTextXpath="//*[@class='table-datarow']";

	 private static String PageHeadingTextXpath="//*[@class='form-horizontal']/h4[1]";

	 private static String CountryofBirthDropdownXpath="//*[@id='CountryOfBirth']";

	 private static String CountryofCitizenshipDropdownXpath="//*[@id='CitizenShipCountryCodeList']";

	 private static String AddCountryofCitizenshipButtonXpath="//*[@id='btnAddCitzenship']";

	 //private static String PageHeading2TextXpath="//*[@class='form-horizontal']/h4[2]";

	 private static String PageHeading1TextXpath="//*[@id='divEmail']/h4";

	 private static String PageHeading2TextXpath="//*[@id='divPhone']/h4";

	 

	 private static String AddMoreEmailButtonXpath="//*[@id='grp-email']/div/p/a";

	 private static String AddMoreEmailTextboxXpath=".//*[@id='grp-email']/div/table/tbody/tr[1]/td[1]/input";

	 private static String AddMoreEmailTextbox1Xpath=".//*[@id='grp-email']/div/table/tbody/tr[2]/td[1]/input";

	 private static String PhoneNumbersTypeDropdownXpath="//*[@class='fld-type']";

	 private static String PhoneNumbersCountryTextboxXpath="//*[@class='fld-country']";

	 private static String PhoneNumbersCountrynumberTextboxXpath="//*[@class='fld-number']";

	 private static String PhoneNumbersCountryExtTextboxXpath="//*[@class='fld-ext']";

	 private static String AddMorePhoneButtonXpath=".//*[@id='grp-phone']/div/p/a";

	 private static String Step1NextButtonXpath="//*[@id='btnSave']";

	 

	//Excel sheet Data collection		 

	 private static String CountryofBirth=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 16, 1);

	 private static String CountryofCitizenship=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 17, 1);

	 private static String CountryofCitizenshipnew=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 18, 1);

	 private static String PhoneNumbersType=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 19, 1);

	 private static String PhoneNumbersCountry=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 20, 1);

	 private static String PhoneNumbersCountrynumber=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 21, 1);

	 private static String PhoneNumbersCountryExt=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 22, 1);

	 private static String StepOneEmail=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 44, 1);

	

	//Project_Initiation_Step2_Page() 

	 

		//Methods Xpaths	

		 

	 private static String DestinationCountryCodeDropdownXpath="//*[@name='CountryCode']";

	// private static String SponsorEntityIdDropdownXpath="//*[@id='SponsorEntityId']";

	 private static String CategoryIdDropdownXpath="//*[@id='CategoryId']";

	 private static String ClassificationIdDropdownXpath="//*[@id='ClassificationId']";

	 private static String EstimatedTravelDateTextBoxXpath="//*[@id='EstimatedTravelDate']";

	 private static String EstimatedReturnDateTextBoxXpath="//*[@id='EstimatedReturnDate']";			  

	 private static String AssignmentTypeDropdownXpath="//*[@id='AssignmentType']";

	 private static String PositionTitleTextBoxXpath="//*[@id='Title']";			  

	 private static String BaseSalaryTextBoxXpath="//*[@id='BaseSalary']";

	 private static String BaseSalaryCurrencydDropdownXpath="//*[@id='BaseSalaryCurrency']";

	 private static String SpecialInstructionTextBoxXpath="//*[@id='SpecialInstruction']";

	 private static String Page2Heading2TextXpath="//*[@id='divResidence']/h4";

	 private static String StreetAddress1TextBoxXpath="//*[@name='StreetAddress1']";

	 private static String StreetAddress2TextBoxXpath="//*[@name='StreetAddress2']";

	 private static String UnitTypeDropdownXpath="//*[@name='UnitType']";

	 private static String UnitNumberTextBoxXpath="//*[@name='UnitNumber']";

	 private static String CityTextBoxXpath="//*[@name='City']";

	 private static String StateOrProvinceTextBoxXpath="//*[@name='StateOrProvince']";

	 private static String PostalCodeTextBoxXpath=".//*[@name='PostalCode']";

	 

	 //private static String PageHeading31TextXpath="//*[@class='form-horizontal']/h4[3]";

	 private static String PageHeading31TextXpath="//*[@id='divClientContacts']/h4";

	// private static String PageHeading31TextXpath="//*[@class='form-horizontal']//..[text()='Client Contacts']";

	 private static String ClientContactTableXpath="//*[@id='divClientContacts']";	

	 private static String Step2NextButtonXpath=".//*[@id='btnNext']";

	 private static String AddressLookupXpath="//*[@name='autocomplete']";

		 

		//Excel sheet Data collection		 

	 private static String DestinationCountryCode=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 16, 1); //21

	// private static String SponsorEntityId=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 18, 1);

	 private static String CategoryId=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 24, 1);

	 private static String ClassificationId=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 25, 1);			  

	 private static String EstimatedTravelDate=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 26, 1);

	 private static String EstimatedReturnDate=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 27, 1);			  

	 private static String AssignmentType=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 28, 1);

	 private static String PositionTitle=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 29, 1);

	 private static String BaseSalary=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 30, 1);

	 private static String BaseSalaryCurrency=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 31, 1);

	 private static String SpecialInstruction=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 32, 1);

	 private static String StreetAddress=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 33, 1);

	 private static String UnitType=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 34, 1);

	 private static String UnitNumber=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 35, 1);

	 private static String City=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 36, 1);

	 private static String StateOrProvince=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 37, 1);

	 private static String PostalCode=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 38, 1);

	 private static String AddressLookup=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 44, 1);

	 

	 

	//Project_Initiation_Step3_Page() 

	 

		//Methods Xpaths		 

	 private static String PageTitle1TextXpath="//*[@class='form-horizontal']/h5";  

	 private static String PageHelpTextXpath="//*[@class='form-horizontal']/p";

	 private static String PageTableTextXpath="//*[@class='table-rec-container']/table";	 

	 private static String Page3HeadingTextXpath="//*[@id='form1']/div[@class='alert alert-info']/h4";

	 private static String DocumentTypeDropDownXpath="//*[@name='fld-documentType']";

	 private static String SelectUploadButtonXpath="//*[@class='controls']/button[1]";

	 private static String UploadButtonXpath="//*[@id='DocUploadModal']//*[@id='btnUploadDocuments']";

	 private static String Page3NextButtonXpath="//*[@id='btnNext']";

	 

	//Excel sheet Data collection	

	 private static String DocumentType=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 39, 1);

	 private static String FilePath=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 40, 1);

	 



	//Project_Initiation_Step4_Page() 

	 

		//Methods Xpaths		 

	 private static String Page4TitleTextXpath="//*[@class='form-horizontal']/p[1]";  

	 private static String Page4HelpTextXpath="//*[@class='form-horizontal']/p[2]";

	 private static String UserAccountTextXpath="//*[@class='form-horizontal']/div[1]/div/span";

	 private static String EnableLoginRadioButtonXpath="//*[@id='EnableLogin'][1]";

	 private static String DisableLoginRadioButtonXpath="//*[@id='EnableLogin'][2]";

	 private static String controlinfoTextXpath="//*[@class='control-info']/p";

	 private static String Page4EmailTextboxXpath="//*[@name='Email']";

	 

	 

	 

	//Project_Initiation_Step5_Page() 

	 

		//Methods Xpaths		 

	 private static String Page5HelpTextXpath="//*[@class='form-horizontal']/p[1]";

	 private static String Page5TitleTextXpath="//*[@class='form-horizontal']/h4[1]";  

	 private static String QuestionnaireEmployeeContactId="//*[@id='QuestionnaireEmployeeContactId']";	

	 private static String QuestionnaireEmployerContactId="//*[@id='QuestionnaireEmployerContactId']";

	 private static String QuestionerTableValueXpath="//*[@Class='table-rec-container'][1]/table/tbody/tr[xx]/td[2]";

	 private static String QuestionerTableValueCounter="//*[@Class='table-rec-container'][1]/table/tbody/tr/td/div";

	 private static String Page5TabelHeadingTextXpath=".//*[@id='form1']/div[1]/table/thead/tr/td";		 

	 private static String DropDownValueQuestionnaireEmployeeContactId=FirstName+ " "+LastName;

	 private static String Page5Title1TextXpath="//*[@class='form-horizontal']/h4[2]"; 

	 private static String QuestionerTable1ValueCounter="//*[@Class='table-rec-container'][2]/table/tbody/tr/td/div";

	 private static String QuestionerTable1ValueXpath="//*[@Class='table-rec-container'][2]/table/tbody/tr[xx]/td[2]";

	 

	//Excel sheet Data collection	

	 

	 private static String EmployerContactId=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 41, 1);

	 private static String EnableLogin=UtilFunction.getCellData("Test Data.xls", "Project Initiation", 42, 1);

	 

	//Project_Initiation_Step6_Page() 

	 

	//Methods Xpaths		 

	 private static String LastandFirstNameXpath="//*[@class='btn-group']/a";

	 private static String BreadcrumbProjectInititaionXpath="//*[@class='breadcrumb floatL']/li[2]";

	 private static String HeadingProjectInititaionXpath="//*[@id='prg-hdr-main']/tbody/tr[1]/td[1]/span[1]";

	 private static String ProjectInititaionTitleXpath="//*[@id='panel-header']";

	 

	 //Constructor----------

	 

		public Project_Initiation(WebDriver driver,UtilFunction utilfunc) 

		{

		this.webdriver =driver;

		this.utilfunc=utilfunc;

		

		// TODO Auto-generated constructor stub

	 }

		

		//Functions--------------

		/**

		 * Verify that User is able to logged in successfully 

		 * 	

		 * @throws AWTException

		 * @throws InterruptedException

		 */

		 public void Project_Initiation_login() throws AWTException, InterruptedException

		 	{	

			

			 System.out.println("COBAL Project Statstics Report");		 

			 System.out.println("---------------------------------------------------------------------------------------");

			 System.out.println("");	

			 System.out.println("-------------------------------CIMS Login Page Verification----------------------------");

			 try{

			 utilfunc.findElementByXpath(UsernameTextBoxXpath);

			 utilfunc.MakeElement(UsernameTextBoxXpath).sendKeys(Username);		  

			 utilfunc.MakeElement(GOButtonXpath).click();

			 System.out.println("User is successfully clicked on the First Login Page Successfully");

			 

			 utilfunc.MakeElement(PasswordTextBoxXpath).sendKeys(Password);		  

			 utilfunc.MakeElement(LoginButtonXpath).click();

			 System.out.println("User is successfully clicked on the Secound Login Page Successfully");

			 System.out.println("---------------------------------------------------------------------------------------");

			 }

			 catch(Exception e){

				 System.out.println("Login verfication Failed due to an error");

				 System.out.println("------------------------------------------------------------------------------------");

				 utilfunc.TakeScreenshot();

			 }

		   }

	     	

		



	/**

	 * Verify that User is able to logged in successfully 

	 * 	

	 * @throws AWTException

	 * @throws InterruptedException

	 */

	 public void Welcome_Page(){

		 System.out.println("");

		 System.out.println("-------------------------------CIMS Welcome Page Verification---------------------------");

		 try{

			 String Welcometext=utilfunc.MakeElement(WelcomeTextXpath).getText();	

			 if(Welcometext.contains("Welcome")){

				 System.out.println("User is Landed on the CIMS Welcome Page successfully"); 

				 System.out.println("CIMS Page Message is : "+Welcometext);

				 utilfunc.MakeElement(InitiateProjectButtonXpath).click();

				 System.out.println("---------------------------------------------------------------------------------------");

			 }else{

				 System.out.println("User is Landed on the Diffrent Page");

				 System.out.println("---------------------------------------------------------------------------------------");

				 utilfunc.TakeScreenshot();

			 }

		}catch(Exception e){

			System.out.println("Welcome message missing or Project Initiate button is not found");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

	 }

	 

	public void Project_Initiation_Page() {

		Actions act= new Actions(webdriver);

		

		System.out.println("");	 

		System.out.println("---------------------------CIMS Project Initation Page Verifcation---------------------------------");

		 try{

//			 utilfunc.LinkText(ProjectInitiationxpath).click();

			 String Welcometext=utilfunc.MakeElement(PageTitleTextXpath).getText();					 

			 System.out.println("Page Tile is : "+Welcometext);

			 String Helptext=utilfunc.MakeElement(HelpTextXpath).getText();

			 System.out.println("Page Help text is : "+Helptext);

			 String HeadingText=utilfunc.MakeElement(HeadingTextXpath).getText();

			 System.out.println("Page Heading Text is : "+HeadingText);

			 utilfunc.MakeElement(CompanyTextboxXpath).clear();

			 Company	=	Company.substring(0,Company.length()-1);

			 utilfunc.MakeElement(CompanyTextboxXpath).sendKeys(Company);

			 try{

				 Thread.sleep(1000);

				 utilfunc.selectFirstResultFromAutoSuggestion(CompanyTextboxXpath);

				 Thread.sleep(2000);

			 }catch(Exception e){

				 System.out.println("failed to slect from auto suggestion..");

			 }

//			try{

//			 String xpath=".//*[@class='ui-menu-item']";

//			 utilfunc.MakeElement(xpath).click();

//			}catch(Exception e){System.out.println("unable to click on buttin");}

			 /*act.sendKeys(Keys.ARROW_DOWN).build().perform();

			 // act.sendKeys(Keys.ARROW_DOWN).build().perform();

			 act.sendKeys(Keys.ENTER).build().perform();

			 Thread.sleep(1000);*/

			 

			 utilfunc.Selectdropdownvaluebyvalue(Destinationcountryxpath, Destinationcountry);

			 Thread.sleep(1000);

			 utilfunc.MakeElement(Destinationcityxpath).sendKeys(Destinationcity);

			 Thread.sleep(1000);

			 utilfunc.MakeElement(BusinessUnitDropdownXpath).sendKeys(BusinessUnit);

			 //utilfunc.Selectdropdownvaluebytext(BusinessUnitDropdownXpath,BusinessUnit);

//		/home/dr12/JavaWorkspace/CIMS/src/testData/DOCUMENT TETSING.docx

			 try{

			 utilfunc.MakeElement(EmployeeIDTextboxXpath).sendKeys(EmployeeID);

			 }catch(Exception e){System.out.println("unable to put name");}

			 

			 try{

			 utilfunc.Selectdropdownvaluebytext(PrefixDropdownXpath,Prefix.trim());

			 }catch(Exception e){

				 System.out.println("unable to select prefix");

			 }

			 //utilfunc.Selectdropdownvaluebytext(PrefixDropdownXpath,Prefix);

			 utilfunc.MakeElement(FirstNameTextboxXpath).sendKeys(FirstName);

			 utilfunc.MakeElement(MiddleNameTextboxXpath).sendKeys(MiddleName);

			 utilfunc.MakeElement(LastNameTextboxXpath).sendKeys(LastName);

			 utilfunc.MakeElement(DateOfBirthTextboxXpath).sendKeys(DateOfBirth);

			 utilfunc.MakeElement(EmailTextboxXpath).sendKeys(Email);

			 try {

				utilfunc.MakeElement(NextButtonXpath).click();

			} catch (Exception e1) {

				System.out.println("first next...");

			}



			 Thread.sleep(2000);

			 try{

				 String ErrorMSG=utilfunc.MakeElement(ErrorMessageXpath).getText();

				 if(ErrorMSG.equalsIgnoreCase("")){

					 System.out.println("No Error Message is displayed");

					 System.out.println("Successfully Verified Project Inititaion Page ");

					 System.out.println("---------------------------------------------------------------------------------------");

				 } else{						 

					 System.out.println("Error is occured on the Page");

					 System.out.println("Error Description is :"+ErrorMSG);	

					 System.out.println("---------------------------------------------------------------------------------------");

					 utilfunc.TakeScreenshot();

				 }

			 }catch(Exception e){

				 System.out.println("No Error Message is displayed");

				 System.out.println("Successfully Verified Project Inititaion Page ");

				 System.out.println("---------------------------------------------------------------------------------------");

			 }				 

		}catch(Exception e){

			System.out.println("Welcome message missing or Project Initiate button is not found");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		 

		 try{

		 String Employeeexistcheck=utilfunc.MakeElement(Employeealreadyexistcheckxpath).getText();

		 if(Employeeexistcheck.contains("Please check below and indicate if the employee is already in Cobalt.")){

//			 String existxpath=".//*[@id='divResultList']/table[1]/tbody/tr[1]/td[1]/input[1]";

			 Thread.sleep(1500);



			 try {

				String existxpath	=	"//*[@class='alert']//*[@name='selectEmp']";

				utilfunc.MakeElement(existxpath).click();

			} catch (Exception e) {

				System.out.println("unable to find existing and click on next");

			}

			 try {

				 String nextbutton=".//*[contains(@class,'btn') and contains(@href,'GoToStart();')]";

				 utilfunc.MakeElement(nextbutton).click();

			} catch (Exception e) {

				System.out.println("unable to find existing and click on next");

			}

		 }

		 }catch(Exception e){

			 

		 }

		

	}

	

	

	/**

	 * 

	 * Project_Initiation_Step1_Page()

	 * 

	 */

	public boolean Project_Initiation_Step1_Page() {

		 

		 //Veriables		

		 boolean Project_Initiation_Step1_Page_flag=false;

		 System.out.println("");

		 System.out.println("------------------------------CIMS Project Initation- Step 1 Page Verifcation----------------------");

		 

		 try{

			 

			 //Duplicate Employee Page Check			 

			 String DuplicateCheckPageBodyText="";

			 try {	

				 //DuplicateCheckPageBodyText=utilfunc.MakeElement(DuplicateCheckPageBodyXpath).getText();

				 //WebElement DuplicateCheckPageBodyEle=utilfunc.MakeElement(DuplicateCheckPageBodyXpath);

				 DuplicateCheckPageBodyText=utilfunc.MakeElement(DuplicateCheckPageBodyXpath).getText();					 

				 System.out.println("Duplicate Page Found");

				 System.out.println(DuplicateCheckPageBodyText);

				 System.out.println("----------------------------------Duplicate Entry Found--------------------------------------");

				 utilfunc.TakeScreenshot();

				//Back to the Previous Page

				 utilfunc.MakeElement(Page3NextButtonXpath).click();

				//Exit and Failed

				 Project_Initiation_Step1_Page_flag =true;

				 

			 }

			 catch(Exception e){

				 

				 //Step 1 : Start				 

				 String PagetitleText=utilfunc.MakeElement(PagetitleTextXpath).getText();

				 System.out.println("Page Title Text is : "+PagetitleText);

				 String PagetitleHelpText=utilfunc.MakeElement(PagetitleHelpTextXpath).getText();

				 System.out.println("Page Title Help Text is : "+PagetitleHelpText);

				 String PageTabelText=utilfunc.MakeElement(PageTabelTextXpath).getText();

				 System.out.println("Page Tabel Information ----");

				 System.out.println(PageTabelText);

				 String PageHeadingText=utilfunc.MakeElement(PageHeadingTextXpath).getText();

				 System.out.println("Page Heading Text is : "+PageHeadingText);

				 

				 utilfunc.MakeElement(CountryofBirthDropdownXpath).sendKeys(CountryofBirth);

				 utilfunc.MakeElement(CountryofCitizenshipDropdownXpath).sendKeys(CountryofCitizenship);

				

				 

				 //utilfunc.Selectdropdownvaluebytext(CountryofBirthDropdownXpath,CountryofBirth);

				// utilfunc.Selectdropdownvaluebytext(CountryofCitizenshipDropdownXpath,CountryofCitizenship);

				 utilfunc.MakeElement(AddCountryofCitizenshipButtonXpath).click();	

				 utilfunc.MakeElement(CountryofCitizenshipDropdownXpath).sendKeys(CountryofCitizenshipnew);

				 //utilfunc.Selectdropdownvaluebytext(CountryofCitizenshipDropdownXpath,CountryofCitizenshipnew);

				 			 

				 //Emails and Telephone Numbers section			 

				 String PageHeading1Text=utilfunc.MakeElement(PageHeading1TextXpath).getText();

				 System.out.println("Page Heading 1 (Emial) Text is : "+PageHeading1Text);

				// utilfunc.MakeElement(AddMoreEmailTextboxXpath).sendKeys(Email);

//				 utilfunc.MakeElement(AddMoreEmailButtonXpath).click();

//				 utilfunc.MakeElement(AddMoreEmailTextbox1Xpath).clear();

//				 utilfunc.MakeElement(AddMoreEmailTextbox1Xpath).sendKeys(StepOneEmail);

				 String PageHeading2Text=utilfunc.MakeElement(PageHeading2TextXpath).getText();

				 System.out.println("Page Heading 2 (Telephone Numbers) Text is : "+PageHeading2Text);

				 utilfunc.MakeElement(PhoneNumbersTypeDropdownXpath).sendKeys(PhoneNumbersType);



				 //utilfunc.Selectdropdownvaluebytext(PhoneNumbersTypeDropdownXpath,PhoneNumbersType);

				 utilfunc.MakeElement(PhoneNumbersCountryTextboxXpath).clear();

				 utilfunc.MakeElement(PhoneNumbersCountryTextboxXpath).sendKeys(PhoneNumbersCountry);

				 utilfunc.MakeElement(PhoneNumbersCountrynumberTextboxXpath).clear();

				 utilfunc.MakeElement(PhoneNumbersCountrynumberTextboxXpath).sendKeys(PhoneNumbersCountrynumber);

				 utilfunc.MakeElement(PhoneNumbersCountryExtTextboxXpath).clear();

				 utilfunc.MakeElement(PhoneNumbersCountryExtTextboxXpath).sendKeys(PhoneNumbersCountryExt);

//				 utilfunc.MakeElement(AddMorePhoneButtonXpath).click();

				 try {

					utilfunc.MakeElement(Step1NextButtonXpath).click();

				} catch (Exception e1) {

					System.out.println("failed to click on next step for step 1");

				}

				 Project_Initiation_Step1_Page_flag=false;

				 utilfunc.TakeScreenshot();

				 Thread.sleep(2000);

				 System.out.println("---------------------------------------------------------------------------------------");

				 

				

			 }

			 if(Project_Initiation_Step1_Page_flag){

			//Step 1 : Start				 

			 String PagetitleText=utilfunc.MakeElement(PagetitleTextXpath).getText();

			 System.out.println("Page Title Text is : "+PagetitleText);

			 String PagetitleHelpText=utilfunc.MakeElement(PagetitleHelpTextXpath).getText();

			 System.out.println("Page Title Help Text is : "+PagetitleHelpText);

			 String PageTabelText=utilfunc.MakeElement(PageTabelTextXpath).getText();

			 System.out.println("Page Tabel Info---");

			 System.out.println(PageTabelText);

			 String PageHeadingText=utilfunc.MakeElement(PageHeadingTextXpath).getText();

			 System.out.println("Page Heading Text is : "+PageHeadingText);



			 utilfunc.MakeElement(CountryofBirthDropdownXpath).sendKeys(CountryofBirth);

			// utilfunc.Selectdropdownvaluebytext(CountryofBirthDropdownXpath,CountryofBirth);

			 utilfunc.MakeElement(CountryofCitizenshipDropdownXpath).sendKeys(CountryofCitizenship);

			// utilfunc.Selectdropdownvaluebytext(CountryofCitizenshipDropdownXpath,CountryofCitizenship);

			 utilfunc.MakeElement(AddCountryofCitizenshipButtonXpath).click();				 

			 utilfunc.Selectdropdownvaluebytext(CountryofCitizenshipDropdownXpath,CountryofCitizenshipnew);

			 			 

			 //Emails and Telephone Numbers section			 

			 String PageHeading1Text=utilfunc.MakeElement(PageHeading1TextXpath).getText();

			 System.out.println("Page Heading 1 (Emial) Text is : "+PageHeading1Text);

			// utilfunc.MakeElement(AddMoreEmailTextboxXpath).sendKeys(Email);

//			 utilfunc.MakeElement(AddMoreEmailButtonXpath).click();

//			 utilfunc.MakeElement(AddMoreEmailTextbox1Xpath).sendKeys(StepOneEmail);

			 String PageHeading2Text=utilfunc.MakeElement(PageHeading2TextXpath).getText();

			 System.out.println("Page Heading 2 (Telephone Numbers) Text is : "+PageHeading2Text);

			 utilfunc.MakeElement(PhoneNumbersTypeDropdownXpath).sendKeys(PhoneNumbersType);

			 //utilfunc.Selectdropdownvaluebytext(PhoneNumbersTypeDropdownXpath,PhoneNumbersType);

			 utilfunc.MakeElement(PhoneNumbersCountryTextboxXpath).sendKeys(PhoneNumbersCountry);

			 utilfunc.MakeElement(PhoneNumbersCountrynumberTextboxXpath).sendKeys(PhoneNumbersCountrynumber);

			 utilfunc.MakeElement(PhoneNumbersCountryExtTextboxXpath).sendKeys(PhoneNumbersCountryExt);

//			 utilfunc.MakeElement(AddMorePhoneButtonXpath).click();

			 utilfunc.MakeElement(Step1NextButtonXpath).click();			 

			 Thread.sleep(2000);

			 System.out.println("---------------------------------------------------------------------------------------");

			 Project_Initiation_Step1_Page_flag=true;

			 }

			 Project_Initiation_Step1_Page_flag=true; 

		}catch(Exception e){

			System.out.println("Project Initiate Step 1 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step1_Page_flag;

	

	 }

	

	

	

	/**

	 * 

	 * Project_Initiation_Step2_Page()

	 * 

	 */

	public boolean Project_Initiation_Step2_Page() {

		 

		 //Veriables		

		 boolean Project_Initiation_Step2_Page_flag=false;

		 

		

			  

		 System.out.println("");

		 System.out.println("------------------------------CIMS Project Initation- Step 2 Page Verifcation------------------------");

		 

		 try{

			 

				 //Step 2 : Start				 

				 String PagetitleText=utilfunc.MakeElement(PagetitleTextXpath).getText();

				 System.out.println("Step 2 Page Title Text is : "+PagetitleText);

				 String PagetitleHelpText=utilfunc.MakeElement(PagetitleHelpTextXpath).getText();

				 System.out.println("Step 2 Page Title Help Text is : "+PagetitleHelpText);

				 String PageHeadingText=utilfunc.MakeElement(PageHeadingTextXpath).getText();

				 System.out.println("Step 2 Page Heading Text is : "+PageHeadingText);

				 

				 //utilfunc.Selectdropdownvaluebytext(DestinationCountryCodeDropdownXpath,DestinationCountryCode);

				 //utilfunc.MakeElement(DestinationCountryCodeDropdownXpath).sendKeys(DestinationCountryCode);

				// utilfunc.MakeElement(SponsorEntityIdDropdownXpath).sendKeys(SponsorEntityId);

				 utilfunc.MakeElement(CategoryIdDropdownXpath).sendKeys(CategoryId);

				 // prepend country before classification 

				 ClassificationId	=	Destinationcountry + " " + ClassificationId;

				 System.out.println("classified value with country : "+ClassificationId);

				 utilfunc.MakeElement(ClassificationIdDropdownXpath).sendKeys(ClassificationId);

				// utilfunc.Selectdropdownvaluebytext(SponsorEntityIdDropdownXpath,SponsorEntityId);	///not working			 			 

				// utilfunc.Selectdropdownvaluebytext(CategoryIdDropdownXpath,CategoryId);

				 //utilfunc.Selectdropdownvaluebytext(ClassificationIdDropdownXpath,ClassificationId);				 

				 utilfunc.MakeElement(EstimatedTravelDateTextBoxXpath).sendKeys(EstimatedTravelDate);

				 utilfunc.MakeElement(EstimatedReturnDateTextBoxXpath).sendKeys(EstimatedReturnDate);

				 

				 utilfunc.MakeElement(AssignmentTypeDropdownXpath).sendKeys(AssignmentType);

				 //utilfunc.Selectdropdownvaluebytext(AssignmentTypeDropdownXpath,AssignmentType);				 

				 

				 utilfunc.MakeElement(PositionTitleTextBoxXpath).sendKeys(PositionTitle);

				 //utilfunc.MakeElement(BaseSalaryTextBoxXpath).sendKeys(BaseSalary);

				 //utilfunc.MakeElement(BaseSalaryCurrencydDropdownXpath).sendKeys(BaseSalaryCurrency);

				// utilfunc.Selectdropdownvaluebytext(BaseSalaryCurrencydDropdownXpath,BaseSalaryCurrency);

				 utilfunc.MakeElement(SpecialInstructionTextBoxXpath).sendKeys(SpecialInstruction);

				 

				 //Current Residence section		 

				 String PageHeading2Text=utilfunc.MakeElement(Page2Heading2TextXpath).getText();

				 System.out.println("Step 2 Page Heading 2 Text is : "+PageHeading2Text);

//				 utilfunc.MakeElement(DestinationCountryCodeDropdownXpath).sendKeys(DestinationCountryCode);

				 try{

					 utilfunc.Selectdropdownvaluebytext(DestinationCountryCodeDropdownXpath, DestinationCountryCode);

				 }catch(Exception e){ System.out.println("unable to set destination country dropdown.."); }

				 //utilfunc.Selectdropdownvaluebytext(DestinationCountryCodeDropdownXpath,DestinationCountryCode);

				 

				 // address lookup

				 try { //128, B, BK Dutt Colony, New Delhi, Delhi, India

					 Thread.sleep(1000);



					 System.out.println("Add: "+AddressLookup);

					 utilfunc.MakeElement(AddressLookupXpath).clear();

					utilfunc.MakeElement(AddressLookupXpath).sendKeys(AddressLookup);

//					utilfunc.MakeElement(AddressLookupXpath).sendKeys("Baniyas Road - Dubai - United Arab Emirates");

					Thread.sleep(1000);

					utilfunc.selectFirstResultFromAutoSuggestion(AddressLookupXpath);

					// handling in the case of allert

					try{

						utilfunc.isAlertPresent();

						AddressLookup	=	AddressLookup.substring(0,AddressLookup.length()-2);

						utilfunc.MakeElement(AddressLookupXpath).clear();

						utilfunc.MakeElement(AddressLookupXpath).sendKeys(AddressLookup);

					}catch(Exception e){ System.out.println("address alert is not present"); }

					

				} catch (Exception e1) {

					e1.getMessage();

					System.out.println("unabel to set address lookup..");

				}

				 

/*				 try{

					 utilfunc.MakeElement(StreetAddress1TextBoxXpath).sendKeys(StreetAddress);

				 }catch(Exception e){ System.out.println("unable to set StreetAddress dropdown.."); }

				 try{

				 utilfunc.MakeElement(StreetAddress2TextBoxXpath).sendKeys(StreetAddress);

				 }catch(Exception e){ System.out.println("unable to set StreetAddress dropdown.."); }

				 try{

				 utilfunc.MakeElement(UnitTypeDropdownXpath).sendKeys(UnitType);

				 }catch(Exception e){ System.out.println("unable to set Unittype dropdown.."); }

				 //utilfunc.Selectdropdownvaluebytext(UnitTypeDropdownXpath,UnitType);

				 try{

				 utilfunc.MakeElement(UnitNumberTextBoxXpath).sendKeys(UnitNumber);

				 }catch(Exception e){ System.out.println("unable to set unit number dropdown.."); }

				 try{

				 utilfunc.MakeElement(CityTextBoxXpath).sendKeys(City);

				 }catch(Exception e){ System.out.println("unable to set City dropdown.."); }

				 try{

				 utilfunc.MakeElement(StateOrProvinceTextBoxXpath).sendKeys(StateOrProvince);

				 }catch(Exception e){ System.out.println("unable to set State dropdown.."); }

				 try{

				 utilfunc.MakeElement(PostalCodeTextBoxXpath).sendKeys(PostalCode);

				 }catch(Exception e){ System.out.println("unable to set Postal code dropdown.."); }

*/				 

				 

				 // fill custom field data

				 

				 String controlsCounterXpath	=	".//*[@id='panel-body']//*[@class='control-group']//*[@class='controls']";

				 String controlsXpath			=	".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@class='controls']//*[contains(@name,'ctm')]";

				 

				 // add additional/custom fields..

				 try{

				 utilfunc.dynamic_data_ng_scope(controlsCounterXpath, controlsXpath);

				 }catch(Exception e){

					 System.out.println("unable to set additional info custom field");

				 }



				//Client Contacts section		 

				 String PageHeading3Text=utilfunc.MakeElement(PageHeading31TextXpath).getText();

				 System.out.println("Step 2 Page Heading 3 Text is : "+PageHeading3Text);

				 

				 String ClientContactTable	=	"";

				try {

					ClientContactTable = utilfunc.MakeElement(ClientContactTableXpath).getText();

				} catch (Exception e) {

					// TODO Auto-generated catch block

					System.out.println("unable to collect client information");

					System.out.println("");

					 System.out.println("Client Contact Table info------");

					 System.out.println(ClientContactTable);

				}

				 

				 utilfunc.MakeElement(Step2NextButtonXpath).click();

				 Project_Initiation_Step2_Page_flag=true;

				 Thread.sleep(5000);

				 System.out.println("---------------------------------------------------------------------------------------");

				 	 

		}catch(Exception e){

			System.out.println("Project Initiate Step 2 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step2_Page_flag;

	

	 }

	

	

	/**

	 * 

	 * Project_Initiation_Step2_Page()

	 * @Description-Step 3

	 * 

	 * @return

	 */

	

	public boolean Project_Initiation_Step3_Page() {

		 

		 //Veriables		

		 boolean Project_Initiation_Step3_Page_flag=false;		 

		

		 System.out.println("");

		 System.out.println("-----------------------------Project Inititaion -Step 3 Page Verification---------------------------");

		 

		 try{

			 	//Step 3 : Start				 

				 String PagetitleText=utilfunc.MakeElement(PageTitle1TextXpath).getText();

				 System.out.println("Step 3 Page Title Text is : "+PagetitleText);

				 String PagetitleHelpText=utilfunc.MakeElement(PageHelpTextXpath).getText();

				 System.out.println("Step 3 Page Title Help Text is : "+PagetitleHelpText);

				 

				 String PageTableText;

				try {

					PageTableText = utilfunc.MakeElement(PageTableTextXpath).getText();

					 System.out.println("Step 3 Page Table Text--");

					 System.out.println(PageTableText);

				} catch (Exception e1) {



					System.out.println("unable to gte table text for xpath: "+PageTableTextXpath);

				}

				 String PageHeadingText=utilfunc.MakeElement(Page3HeadingTextXpath).getText();

				 System.out.println("Step 3 Page Heading Text is : "+PageHeadingText);

				/* String PageHeading1Text=utilfunc.MakeElement(PageHeading3TextXpath).getText();

				 System.out.println("Step 3 Page Heading Text is : "+PageHeading1Text);*/





				 // click on add document button to upload..

				 String AddDocumentsBtnXPath	=	"//*[@id='btnShowDocUpload']";

				 try {

					 Thread.sleep(1500);

					utilfunc.MakeElement(AddDocumentsBtnXPath).click();

				} catch (Exception e2) {

					System.out.println("add documents not found on the page");

				}

				 //utilfunc.Selectdropdownvaluebytext(DocumentTypeDropDownXpath,DocumentType);

				 String UploadButtonText=utilfunc.MakeElement(SelectUploadButtonXpath).getText();

				 try{

				 if(UploadButtonText.equalsIgnoreCase("Select a file to upload")){

					 utilfunc.MakeElement(SelectUploadButtonXpath).click(); 

					 Thread.sleep(1000);



//					 if(utilfunc.OSDetector().equals("Linux")){

//						 FilePath="/home/dr12/JavaWorkspace/CIMS/src/testData/DOCUMENT TETSING.docx";

//					 }



//					 utilfunc.uploadfile(FilePath);

					 System.out.println("file : " + FilePath);





					 //clipboard copy paste

//					 Thread.sleep(5000);

					 

//					 Thread.sleep(2000);

					 

						try {

							utilfunc.uploadfile(FilePath);///UploadDocuments

							Thread.sleep(1000);

						} catch (Exception e) {

							System.out.println("unable to upload file..");

						}

						

							Thread.sleep(2000);

//							utilfunc.MakeElement("html").sendKeys(Keys.ESCAPE);

							 //close popup window in order to make sure the popup is closed and continue with further process

							 String popupPageTitle	=	utilfunc.MakeElement(".//*[@id='DocUploadModal']/div[1]/h3").getText();

//							 if(popupPageTitle.contains("Document Upload")){

								 // popup is still open so please close the popup..

								 String closePopUpBtn		=	".//*[@id='DocUploadModal']/div[1]//*[@class='close']";

								 Thread.sleep(1000);

								 try {

									utilfunc.MakeElement(closePopUpBtn).click();

								} catch (Exception e1) {

									System.out.println("unable to close popup");

								}

//							 }

//						}

}

				 }catch(Exception e){

					 System.out.println("unable to upload.. document");

				 }

				 try{

					 Thread.sleep(2000);

					 utilfunc.Selectdropdownvaluebytext(DocumentTypeDropDownXpath,DocumentType);

				 }catch(Exception e){

					 System.out.println("unable to set document type");

					 

				 }

				 Thread.sleep(2000);

				 try {

//					 UploadButtonXpath	=	"//*[@id='DocUploadModal']//*[@id='btnUploadDocuments']";

					utilfunc.MakeElement(UploadButtonXpath).click();

				} catch (Exception e1) {

					System.out.println("unable to click on upload button");

				}



				 System.out.println("waiting here after uploading document..");

				 Thread.sleep(5000);



				 try{

					 String UploadError=utilfunc.MakeElement("//*[@id='page-message']").getText();

					 System.out.println("Uploade file Error is:"+UploadError);

					 PageTableText=utilfunc.MakeElement(PageTableTextXpath).getText();

					 System.out.println(PageTableText);

					 utilfunc.MakeElement(Page3NextButtonXpath).click();

					 Project_Initiation_Step3_Page_flag=false;

					 

				 }

				 catch(Exception e){

					 System.out.println("User is sucessfully uploaded the file");

					 System.out.println("Step 3 Page Uploade file Table Details:");

					 PageTableText=utilfunc.MakeElement(PageTableTextXpath).getText();

					 System.out.println(PageTableText);

					 utilfunc.MakeElement(Page3NextButtonXpath).click(); 		 

					 Project_Initiation_Step3_Page_flag=true;

					 Thread.sleep(5000);

					 System.out.println("---------------------------------------------------------------------------------------");

				 }





		}catch(Exception e){

			System.out.println("Project Initiate Step 3 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step3_Page_flag;

	 }





	/**

	 * 

	 * Project_Initiation_Step4_Page()

	 * @Description-Step 4

	 * 

	 * @return

	 */



	public boolean Project_Initiation_Step4_Page() {

		 

		 //Veriables		

		 boolean Project_Initiation_Step4_Page_flag=false;

		 

		System.out.println("");

		System.out.println("----------------------------Project Inititaion -Step 4 Page Verification------------------------------");

		 

		 try{

			 	//Step 4 : Start				 

				 String PagetitleText=utilfunc.MakeElement(Page4TitleTextXpath).getText();

				 System.out.println("Step 4 Page Heading Text is : "+PagetitleText);

				 String PagetitleHelpText=utilfunc.MakeElement(Page4HelpTextXpath).getText();

				 System.out.println("Step 4 Page Help Text is : "+PagetitleHelpText);



				 String PageTableText;

				try {

					PageTableText = utilfunc.MakeElement(UserAccountTextXpath).getText();

					System.out.println("User Account Value is -"+PageTableText);

				} catch (Exception e) {

					System.out.println("some error occured while getting user account details..");

				}





				 try {

					 if(EnableLogin.equalsIgnoreCase("Yes")){

						 // enable login only if enable login is set to Yes

						 utilfunc.MakeElement(EnableLoginRadioButtonXpath).click();

					 }else {

						 // else set it to no

						utilfunc.MakeElement(DisableLoginRadioButtonXpath).click();

					}

				} catch (Exception e) {

					System.out.println("unable to click on enable login buuton!");

				}

				 

				 

				 try {

					String controlinfoText=utilfunc.MakeElement(controlinfoTextXpath).getText();

					 System.out.println("Control Information Text is -"+controlinfoText);

				} catch (Exception e) {

					System.out.println("unable to get control information text");

				}



				 String EmailTextboxText=utilfunc.MakeElement(Page4EmailTextboxXpath).getAttribute("value");

				 System.out.println("Email Textbox Value is -"+EmailTextboxText);



				 try {

					utilfunc.MakeElement(Page3NextButtonXpath).click();

				} catch (Exception e) {

					System.out.println("failed to click on Next button..");

				}



				 Project_Initiation_Step4_Page_flag=true;

				 Thread.sleep(5000);

				 System.out.println("---------------------------------------------------------------------------------------");	 

		  }catch(Exception e){

			System.out.println("Project Initiate Step 4 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step4_Page_flag;

	 }

	 

	/**

	 * 

	 * Project_Initiation_Step5_Page()

	 * @Description-Step 5

	 * 

	 * @return

	 */

	

	public boolean Project_Initiation_Step5_Page() {

		 

		 //Veriables		

		 boolean Project_Initiation_Step5_Page_flag=false;

		 

		 System.out.println("");

		 System.out.println("------------------------Project Inititaion -Step 5 Page Verification--------------------------------");

		 	 

		 try{

			 	//Step 5 : Start				 

				 String PagetitleText=utilfunc.MakeElement(PageTitle1TextXpath).getText();

				 System.out.println("Step 5 Page Heading Text is : "+PagetitleText);

				 String Page5HelpText=utilfunc.MakeElement(Page5HelpTextXpath).getText();

				 System.out.println("Step 5 Page Help Text is : "+Page5HelpText);

				 String Page5TitleText=utilfunc.MakeElement(Page5TitleTextXpath).getText();

				 System.out.println("Step 5 Page Heading Title Text is : "+Page5TitleText);



				 // select questionnaire

				 try {

					 // check if login is enabled or not..

					 if(EnableLogin.equalsIgnoreCase("Yes")){

					

						 try {

							utilfunc.Selectdropdownvaluebytext(QuestionnaireEmployeeContactId,DropDownValueQuestionnaireEmployeeContactId);

						} catch (Exception e) {

							System.out.println("employee name not found in drop down..");

						}

					 }else{

						 try {

							utilfunc.Selectdropdownvaluebytext(QuestionnaireEmployeeContactId,EmployerContactId);

						} catch (Exception e) {

							System.out.println("employer name is not present in drop down");

						}

					 }

					 

					 

				} catch (Exception e) {

					System.out.println("unable to select questionnaire");

				}



				 try {



					String Page5TabelHeadingText=utilfunc.MakeElement(Page5TabelHeadingTextXpath).getText();

					 System.out.println("Step 5 Tabel Heading Text is -"+Page5TabelHeadingText);

				} catch (Exception e) {

					System.out.println("unabelt to get table content");					

				}

				 

				 System.out.println("Step 5 Tabel Heading Values-------");

				 

				 String SecetedCheckbox;

				 

				 SecetedCheckbox = "";

				 

				 // select questionnaires for employer & employee..

				 try{

					 String QuestionnairesCounterXPath	=	"//*[@class='table-rec-container']/table";

					 String QuestionnairesXPath			=	"//*[@class='table-rec-container'][xx]/table";

					 // find number of questionnaires present on the page..

					 int quesCount						=	utilfunc.GetObjectCount(QuestionnairesCounterXPath);



					 if(quesCount>=1){

						 // before selecting all let us find out if they are 

						 for (int i = 1; i <= quesCount; i++) {



							 if(i==2 || i==3){

								 continue;

							 }

								 

							 Thread.sleep(1000);



							 String NewQuestionnairesCheckBoxXPath		=	QuestionnairesXPath.replace("xx", Integer.toString(i)) + "/tbody/tr[1]/td[1]//*[@type='checkbox']";

							 String NewQuestionnairesLabelXPath		=	QuestionnairesXPath.replace("xx", Integer.toString(i)) + "/tbody/tr[1]/td[2]";

							 // now we are in particular Questionnaires table , now let us select first checkbox of each & then go for next to save..

//							 utilfunc.MakeElement(NewQuestionnairesCheckBoxXPath).click();

							 utilfunc.enableOrDisableCheckbox(NewQuestionnairesCheckBoxXPath, true);

							 SecetedCheckbox=utilfunc.MakeElement(NewQuestionnairesLabelXPath).getText();



							 Thread.sleep(900);

						}

						 

					 }

					 System.out.println("Selected Checkbox is : "+SecetedCheckbox);

					 System.out.println("");

				 }catch(Exception e){

					 System.out.println("unable to collect questionnaires..");

				 }

				 

				 

	/*			try {

					int ObjectCounter=utilfunc.GetObjectCount(QuestionerTableValueCounter);

					 

					 //First Table Data

					 for(int counter=1;counter<ObjectCounter;counter++){

							 String QuestionerTableValueXpath1=QuestionerTableValueXpath.replace("xx", Integer.toString(counter));

							 String TableValue=utilfunc.MakeElement(QuestionerTableValueXpath1).getText();

							 System.out.println("Questioner ["+counter+"] Chcekbox Label Text is -"+TableValue);

							 System.out.println("");

						 if(counter==5){

							 utilfunc.MakeElement(QuestionerTableValueXpath1).click();

							 SecetedCheckbox=utilfunc.MakeElement(QuestionerTableValueXpath1).getText();

						 }

						 

					 }	

					 System.out.println("Selected Checkbox is : "+SecetedCheckbox);

					 System.out.println("");

				} catch (Exception e) {

					System.out.println("unable to select check box.. ");

				}	*/			 

				 String Page5Title1Text=utilfunc.MakeElement(Page5Title1TextXpath).getText();

				 System.out.println("Step 5 Page Heading 1 Title Text is : "+Page5Title1Text);

				 System.out.println("Step 5 Tabel 1 Heading Values------");

				 

				 try {

					utilfunc.Selectdropdownvaluebytext(QuestionnaireEmployerContactId,EmployerContactId);

				} catch (Exception e) {

					System.out.println("issue with questionnaire employer contact id..");

				}

				 

/*

				 try {

					int ObjectCounter1=utilfunc.GetObjectCount(QuestionerTable1ValueCounter);

					 

					 //First Table Data

					 for(int counter=1;counter<ObjectCounter1;counter++){

							 String QuestionerTable1ValueXpath1=QuestionerTable1ValueXpath.replace("xx", Integer.toString(counter));

							 String TableValue=utilfunc.MakeElement(QuestionerTable1ValueXpath1).getText();

							 System.out.println("Questioner ["+counter+"] Chcekbox Label Text is -"+TableValue);

							 System.out.println("");

						 if(counter==5){

							 utilfunc.MakeElement(QuestionerTable1ValueXpath1).click();

							 SecetedCheckbox=utilfunc.MakeElement(QuestionerTable1ValueXpath1).getText();

						 }

					 }	

					 System.out.println("Selected Checkbox is : "+SecetedCheckbox);

					 System.out.println("");

				} catch (Exception e) {

					System.out.println("unable to select checkbox..");

				}*/

				 try {

					 Thread.sleep(1000);

					utilfunc.MakeElement(Page3NextButtonXpath).click();

					

				} catch (Exception e) {

					System.out.println("unable to click on next page");

				} 		 

				 Project_Initiation_Step5_Page_flag=true;

				 Thread.sleep(6000);

				 System.out.println("---------------------------------------------------------------------------------------");	 

		  }catch(Exception e){

			System.out.println("Project Initiate Step 5 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step5_Page_flag;

	 }

	

	/**

	 * 

	 * Project_Initiation_Step5_Page()

	 * @Description-Step 5

	 * 

	 * @return

	 */

	

	public boolean Project_Initiation_Step6_Page() {

		 

		 //Variables		

		 boolean Project_Initiation_Step6_Page_flag=false;	 

		

		 System.out.println("");

		 System.out.println("-------------------------Project Inititaion -Step 6 Page Verification-------------------------------");

		 		 

		 try{

			 Thread.sleep(6000);

			 	//Step 6 : Start	

			 

			 	String PagetitleText="";

				try {

					PagetitleText = utilfunc.MakeElement(LastandFirstNameXpath).getText();

				} catch (Exception e1) {

					System.out.println("page title missing");

					Thread.sleep(1000);

				}

			 	System.out.println("Step 6 Page Link Text is : "+PagetitleText);

			 	try{

			 	if(PagetitleText.equalsIgnoreCase(DropDownValueQuestionnaireEmployeeContactId)){

			 		

					String BreadcrumbProjectInititaion=utilfunc.MakeElement(BreadcrumbProjectInititaionXpath).getText();

					System.out.println("Project Inititaion # is-"+BreadcrumbProjectInititaion);

					String ProjectInititaionTitle=utilfunc.MakeElement(ProjectInititaionTitleXpath).getText();

					System.out.println("Project Inititaion Heading is-"+ProjectInititaionTitle);

					String HeadingProjectInititaion=utilfunc.MakeElement(HeadingProjectInititaionXpath).getText();

					System.out.println("Project Inititaion Username is-"+HeadingProjectInititaion);

					System.out.println("");

					System.out.println("User Successfully Inititaed the Project !!!!");

					System.out.println("---------------------------------------------------------------------------------------");

					Project_Initiation_Step6_Page_flag=true;	

			 	}

			 	}catch(Exception e){

			 		System.out.println("unable to select questionaire employee contact..");

			 	}

			 		 

		  }catch(Exception e){

			System.out.println("Project Initiate Step 6 Page Issue");

			System.out.println("---------------------------------------------------------------------------------------");

			Project_Initiation_Step6_Page_flag=false;	

			utilfunc.TakeScreenshot();

		 }

		return Project_Initiation_Step6_Page_flag;

	 }

	 

	//Take a Screen shot

	public void TakeScreenshot(){

		utilfunc.takeScreenShot(System.getProperty("user.dir")+"/test-output/Error Screenshot/errorSceenshot"+UtilFunction.currentDateTime()+".jpg");

	}



	

	

}