package CIMS.Modules.Custom;

import java.awt.List;
import java.util.ArrayList;

import javax.mail.Flags.Flag;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;


public class Company_Role {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	public Company_Role(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	
	/**
	 * in order to set role's i.e, for primary company roles, BAL Contacts, Network Partner Contacts, call this function and provide following parameters filename(like Test Data.xls, Test Regression Suite.xls, etc), sheetname( like Initiate a single project, Primary company roles, etc)
	 * @param filename
	 * @param sheetName
	 * @param RoleCounterPrefixClassName
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean CompanyRole(String filename, String sheetName, String RoleCounterPrefixClassName, String RoleType, String testcaseid, boolean match_or_not) throws InterruptedException{


//		webdriver.get("http://cobaltqa.daxima.com/SinglepageInitiation#/single/balAssignment/15459");

		utilfunc.ErrorMessage1	=	"";
		boolean flag	=	false;
		boolean matchFlag	=	true;
		
		int intValOfNumberOfRoles			=	0;
				
		// collect data from regression's excel sheet > BAL Contact sheet

		String BalContactSheet					=		"BAL Contacts";
		int CompanyRoleRowCount					=		UtilFunction.usedRowCount(filename, BalContactSheet);
    	int columnNumber_SPI_Module_nm			=		UtilFunction.getColumnWithCellData(filename, BalContactSheet, "Module Name");
    	int columnNumber_SPI_Module_roleType	=		UtilFunction.getColumnWithCellData(filename, BalContactSheet, "Role Type");
    	int columnNumber_CaseId					=		UtilFunction.getColumnWithCellData(filename, BalContactSheet, "TCID");
    	int columnNumber_max_num					=		UtilFunction.getColumnWithCellData(filename, BalContactSheet, "No. of Roles (Max upto 15)");
    	

    	String []	RoleNames				=	{};
    	

    	try{
    		
    		Thread.sleep(4500);

	    	for(int roleCounter = 1;roleCounter<CompanyRoleRowCount;roleCounter++){

	    		try{
		    		if(UtilFunction.getCellData(filename, BalContactSheet, columnNumber_SPI_Module_nm, roleCounter).equals(sheetName) && 
		    				UtilFunction.getCellData(filename, BalContactSheet, columnNumber_SPI_Module_roleType, roleCounter).equals(RoleType) && 
		    				UtilFunction.getCellData(filename, BalContactSheet, columnNumber_CaseId, roleCounter).equals(testcaseid)

		    				){
		    			// we have check if data is present in Bal Contact sheet now let us pull record according to 
		    			System.out.println("we have check if data is present in "+ RoleType +" sheet now let us pull record according to test case id: "+testcaseid);

		    			try{
		    					String numberOfRoles				=		UtilFunction.getCellData(filename, BalContactSheet, columnNumber_max_num, roleCounter);
		    					
		    					try {
									intValOfNumberOfRoles			=		Integer.parseInt(numberOfRoles);

									intValOfNumberOfRoles	=	(intValOfNumberOfRoles<15) ? intValOfNumberOfRoles : 15; // max up to 15 records
								} catch (Exception e1) {
									System.out.println("some issue with number of roles in sheet");
								}

		    					RoleNames				=	new String[intValOfNumberOfRoles];

		    					for(int r=0;r<intValOfNumberOfRoles;r++){
		    						try{
		    						String newRecord	=	UtilFunction.getCellData(filename, BalContactSheet, r+(columnNumber_max_num+1), roleCounter);
		    						if(newRecord!=null){
		    							RoleNames[r]=newRecord;
		    						}
		    						System.out.println("new record: "+newRecord);
		    						}catch(Exception e){
		    							System.out.println("some issue with setting role names..");
		    						}
		    					}
		    			}catch(Exception e){
		    				System.out.println("unable to get data from excel for "+ sheetName+" =>  "+RoleType);
		    			}

		    		}
	    		}catch(Exception e){
	    			System.out.println("some issue with collecting data from sheet "+ BalContactSheet);
	    		}
	    	}
    	}catch(Exception e){
    		System.out.println("unable to count records from "+BalContactSheet);
    	}

		System.out.println("yes we are on step third now..");

		// now set company contacts...

//		System.out.println("array: "+RoleNames.toString());

		int counterOfBalFullName								=		1; // starts with 0,
		String RoleCounterPrefixClassXpath						=		"//*[contains(@class,'"+RoleCounterPrefixClassName+"')]"; //*[contains(@class,'networkContacts')]
		String BalContactRoleAssigmentCounterXPath				=		RoleCounterPrefixClassXpath+"//*[contains(@class,'ng-scope')]["+counterOfBalFullName+"]//*[contains(@class,'ngRow') and contains(@class,'ng-scope')]/*[contains(@class,'colt"+counterOfBalFullName+"')]";
//		String BalContactRoleAssigmentXPath						=		RoleCounterPrefix+"//*[contains(@class,'ng-scope')]//*[contains(@class,'ngRow')][xx]//*[contains(@class,'colt"+counterOfBalFullName+"')]";
		String BalContactRoleAssigmentXPath						=		RoleCounterPrefixClassXpath+"//*[contains(@class,'ng-scope')]["+counterOfBalFullName+"]//*[contains(@class,'ngRow') and contains(@class,'ng-scope')][xx]/*[contains(@class,'col1')]";
		String BalContactRoleTextXPath							=		RoleCounterPrefixClassXpath+"//*[contains(@class,'ng-scope')]["+counterOfBalFullName+"]//*[contains(@class,'ngRow') and contains(@class,'ng-scope')][xx]//*[contains(@class,'colt1')]/span";


		int BCRACounter							=				utilfunc.GetObjectCount(BalContactRoleAssigmentCounterXPath);

		if(BCRACounter>0){
		
			// first of all assign data...
		for(int b=1;b<=BCRACounter;b++){

			Thread.sleep(3000);
			try {
				if(!RoleNames[b-1].isEmpty()){

				String NewBalContactXPath				=			BalContactRoleAssigmentXPath.replace("xx", Integer.toString(b))+ "//*[@ng-dblclick]";
				String NewBalContactInputXPath			=			NewBalContactXPath+"//input"; 
				try {
					utilfunc.MakeElement(NewBalContactXPath).click();
					Thread.sleep(2000);
					try{
					utilfunc.MakeElement(NewBalContactInputXPath).click();
					Thread.sleep(2000);
					}catch(Exception e){
						System.out.println("unable to click on on edit inputbox");
					}
					try{
					utilfunc.MakeElement(NewBalContactInputXPath).clear();
					Thread.sleep(2000);
					}catch(Exception e){
						System.out.println("unable clear the textbox..");
					}
					try{
					utilfunc.MakeElement(NewBalContactInputXPath).sendKeys(RoleNames[b-1]);
					Thread.sleep(2500);
					
					//START Code updated by Lokesh for check is there any user or not in auto dropdown
					int AutoDrpdwnCount=0;
					String autodrop_xpath=".//*[@class='dropdown-menu ng-isolate-scope']//li";
					String autodrop_xpath1=".//*[@class='dropdown-menu ng-isolate-scope']//li[1]";
					try
					{
						AutoDrpdwnCount=utilfunc.GetObjectCount(autodrop_xpath);
					}
					catch(Exception e)
					{System.out.println("some error while showing autodropdown");}
					String wsa="";
					try{wsa=utilfunc.MakeElement(autodrop_xpath1).getText();}catch(Exception e){}
					if(wsa.equalsIgnoreCase("No data found"))
					{
						utilfunc.ErrorMessage1	=	"No Data found";
						matchFlag=false;
						utilfunc.TakeScreenshot();
						return matchFlag;
					}
					//END Code updated by Lokesh for check is there any user or not in auto dropdown


					// now select first suggestion from auto suggestion..
//				utilfunc.selectFirstResultFromAutoSuggestion(NewBalContactInputXPath);
					try {
						webdriver.findElement(By.xpath(NewBalContactInputXPath)).sendKeys(Keys.ENTER);
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.println("first record selected..");
					}
					
					
					
					}catch(Exception e){
						System.out.println("unable to set value in textbox...");
					}
				} catch (Exception e) {
					System.out.println("unable to get input box for xpath: "+NewBalContactInputXPath);
				}

				}
			} catch (Exception e) {
				System.out.println("out of loop "+b);
			}
		}
		
		System.out.println("after adding data let us check if all data is set or not..");
		

		if(match_or_not==true){
	
			//for refresh the page
			webdriver.navigate().refresh();
			
			Thread.sleep(5000);
			// now set the role assignment
			
			//set value in dropdown box
			
			try {
				String drpdwnbx_xpath="//*[@class='"+RoleCounterPrefixClassName+"']//*[@ng-hide='hideRoleTypeList']//select";
				utilfunc.Selectdropdownvaluebytext(drpdwnbx_xpath, RoleType);
			}catch (Exception e1) {
				System.out.println("Unable to set value in drop down");
			}
	
			// now verify if data is placed successfully or not..
	
		
			for(int b=1;b<=BCRACounter;b++){
				Thread.sleep(2000);
				BalContactRoleTextXPath="//*[contains(@class,'"+RoleCounterPrefixClassName+"')]//*[contains(@class,'ng-scope')][1]//*[contains(@class,'ngRow')][xx]//*[contains(@class,'colt1') and contains(@class,'ngCellText')]/span[contains(@class,'ng-binding')]";
	//			BalContactRoleTextXPath=".//*[@id='form1']/div[1]/primary-contacts/div[3]/div/div[2]/div[2]/div/div[xx]/div[2]/div[2]/div/div/div/span";
				String NewBalContactTextXPath				=			BalContactRoleTextXPath.replace("xx", Integer.toString(b));
				String BalContactText					=			""; 
				try {
					// get each text from records..
					Thread.sleep(2000);
					try{
						//try{utilfunc.MakeElement(NewBalContactTextXPath).click();}catch(Exception error){System.out.println("unable to click with this xpath");}
						//Thread.sleep(1200);
						//System.out.println("NewBalContactTextXPath is : "+NewBalContactTextXPath);
						BalContactText	=	utilfunc.MakeElement(NewBalContactTextXPath).getText();
						//System.out.println("BalContactText is : ---"+BalContactText+"---");
					}catch(Exception e){
						System.out.println("unable to get text for : "+NewBalContactTextXPath);
					}
	
					// now compare the text with data, in order to make sure it is set..
					try{
	
						Thread.sleep(2500);
					if( (RoleNames[b-1]==null)){
						
					}
					else if( RoleNames[b-1].equals(BalContactText)){
						System.out.println("content matched.. for : "+RoleNames[b-1]);
						System.out.println("flag: "+matchFlag);
					}
					else{
						matchFlag	=	false;
					}
	
	
					} catch (Exception e) {
						System.out.println("unable to compare text");
					}
				} catch (Exception e) {
					System.out.println("unable to get content from roles in order to compare the text");
				}
	
				if(!matchFlag){
					utilfunc.ErrorMessage1	=	"Some error occured while adding roles";
					utilfunc.TakeScreenshot();
					flag=false;
				}else{
					flag=true;
				}
				
			}
		}else{
			flag=true;
		}

		}else{
			System.out.println("no "+RoleType+" present");
		}

		return flag;
			
	}
	
}
