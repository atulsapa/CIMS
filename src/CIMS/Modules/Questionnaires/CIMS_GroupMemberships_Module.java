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

public class CIMS_GroupMemberships_Module
{


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

	public CIMS_GroupMemberships_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}


	//Functions--------------
	/**
	 * Verify that User is able to landed on the Project Initiation Page
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean PassportPage(int ColumnCounter, String mode) throws AWTException, InterruptedException
	{	

		//Passport Page	

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 0, ColumnCounter);
		String GroupMembershipsScenerio=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 2, ColumnCounter);
		String GroupMembershipsTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 3, ColumnCounter);		
		String GroupMembershipsPageURL=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 4, ColumnCounter);
		String GroupMembershipsID=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 5, ColumnCounter);

		String GroupMembershipsGroupName=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 6, ColumnCounter);
		String GroupMembershipsCountry=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 7, ColumnCounter);
		String GroupMembershipsCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 8, ColumnCounter);
		String GroupMembershipsStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 9, ColumnCounter);
		String GroupMembershipsMembershipStartDate=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 10, ColumnCounter);
		String GroupMembershipsMembershipMembershipEndDate=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 11, ColumnCounter);
		String GroupMembershipsMembershipDescription=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 12, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Group_Memberships", 15, ColumnCounter);

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Group Memberships";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=GroupMembershipsScenerio;
		description=GroupMembershipsTestcaseDescription;

		String ACTION="New";
		String ACTION1="Edit";
		String ACTION2="Delete";
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		if(URLwithID.equals("")){
			utilfunc.closesidebar();
			Flag=false; 
		}else{



			if(mode.equals(ACTION)){
				try{
					/*String GroupMembershipsURLwithID=GroupMembershipsPageURL+GroupMembershipsID;

				 utilfunc.NavigatetoURL(GroupMembershipsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					try{ String AddbuttonXpath="//*[@class='btn']";
					utilfunc.MakeElement(AddbuttonXpath).click();
					Thread.sleep(2000);
					String GroupMembershipsFiledXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]";
					//attribute checking
					String GroupMembershipsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]//*[@id]";
					// String GroupMembershipsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
					String CounterXpath=".//*[@id='form1']//*[@class='control-group']";

					int ObjCount=utilfunc.GetObjectCount(CounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300); //Label Printing
						String NewXpath=GroupMembershipsLabelXpath.replace("xx", Integer.toString(count));
						//String LabelName=utilfunc.MakeElement(NewXpath).getText();
						String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
						//System.out.println("Attribute name "+count+"is : "+AttributeName);

						//Filed value Entering
						String NewXpath1=GroupMembershipsFiledXpath.replace("xx", Integer.toString(count));
						try {
							String SelectXpath1=NewXpath1+"/select";	
							utilfunc.Selectdropdownvaluebyvalue(SelectXpath1, GroupMembershipsCountry);
							String DropDownvalue=utilfunc.MakeElement(SelectXpath1).getText();
							// System.out.println("Drop Down Value is : "+DropDownvalue);
						}
						catch(Exception e){
							try{
								String FiledXpath1=NewXpath1+"/input";	

								if(AttributeName.contains("NameOfOrganization")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsGroupName);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("City")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsCityTownLocality);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("StateOrProvince")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsStateProvinceRegion);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("StartDate")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipStartDate);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("EndDate")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipMembershipEndDate);
									}catch(Exception error){}
								}
								else if(AttributeName.contains("NatureOfOrganization")) {
									try{utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipDescription);
									}catch(Exception error){}
								}
							}
							catch(Exception f){	 
							}
						}
					}

					String radioclick=".//*[@id='form1']//*[@class='question-option']//*[@name]";
					String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
					String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					}catch(Exception error){}

					try{utilfunc.savebutton();
					}catch(Exception error){}

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

					// return Flag;
					}catch(Exception error){}
				}catch(Exception Ex){

				}



			}else if(mode.equals(ACTION1)){
				try{
					/*String GroupMembershipsURLwithID=GroupMembershipsPageURL+GroupMembershipsID;

				 utilfunc.NavigatetoURL(GroupMembershipsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
try{
					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();
					Thread.sleep(2000);
					
					String GroupMembershipsFiledXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]";
					//attribute checking
					String GroupMembershipsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/div[1]//*[@id]";
					// String GroupMembershipsLabelXpath=".//*[@id='form1']//*[@class='control-group'][xx]/label";
					String CounterXpath=".//*[@id='form1']//*[@class='control-group']";

					int ObjCount=utilfunc.GetObjectCount(CounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);
						//Label Printing
						String NewXpath=GroupMembershipsLabelXpath.replace("xx", Integer.toString(count));
						//String LabelName=utilfunc.MakeElement(NewXpath).getText();
						String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
						//System.out.println("Attribute name "+count+"is : "+AttributeName);

						//Filed value Entering
						String NewXpath1=GroupMembershipsFiledXpath.replace("xx", Integer.toString(count));
						try {
							String SelectXpath1=NewXpath1+"/select";	
							utilfunc.Selectdropdownvaluebyvalue(SelectXpath1, GroupMembershipsCountry);
							String DropDownvalue=utilfunc.MakeElement(SelectXpath1).getText();
							//System.out.println("Drop Down Value is : "+DropDownvalue);
						}
						catch(Exception e){
							try{
								String FiledXpath1=NewXpath1+"/input";	

								if(AttributeName.contains("NameOfOrganization")) {
									try{
										utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsGroupName);
									}catch(Exception error){}
									}
								else if(AttributeName.contains("City")) {
								try{
									utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsCityTownLocality);
								}catch(Exception error){}
								}
								else if(AttributeName.contains("StateOrProvince")) {
									try{
										utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsStateProvinceRegion);
									}catch(Exception error){}
									}
								else if(AttributeName.contains("StartDate")) {
									try{
										utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipStartDate);
									}catch(Exception error){}
									}
								else if(AttributeName.contains("EndDate")) {
								try{
									utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipMembershipEndDate);
								}catch(Exception error){}
								}
								else if(AttributeName.contains("NatureOfOrganization")) {
								try{
									utilfunc.MakeElement(FiledXpath1).clear();
									utilfunc.MakeElement(FiledXpath1).sendKeys(GroupMembershipsMembershipDescription);
								}catch(Exception error){}
								}
							}
							catch(Exception f){	 
							}
						}
					}
					String Xpathnew1=".//*[@class='control-group']//*[@class='controls']//*[@id]";
					String Xpathnew2=".//*[@class='control-group'][xx]//*[@class='controls']//*[@id]";

					//function to call the dynamic text data
					try{utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
					}catch(Exception error){}
					
					try{utilfunc.savebutton();
					}catch(Exception error){}
					
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

					// return Flag;
}catch(Exception error){utilfunc.NavigatetoURL(URLwithID);}
				}catch(Exception Ex){
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
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					/* String GroupMembershipsURLwithID=GroupMembershipsPageURL+GroupMembershipsID;

					 utilfunc.NavigatetoURL(GroupMembershipsURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String delete=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					try{utilfunc.MakeElement(delete).click();
					Thread.sleep(5000);				
					utilfunc.isAlertPresent();
					}catch(Exception error){}
					boolean error_flag=utilfunc.ErrorMessagehandler();
					if (error_flag){
						Flag=true;
					}else{
						Flag=false;
					}
				}catch(Exception s){
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