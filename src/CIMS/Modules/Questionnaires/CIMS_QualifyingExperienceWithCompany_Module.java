package CIMS.Modules.Questionnaires;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_QualifyingExperienceWithCompany_Module {
	
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
public CIMS_QualifyingExperienceWithCompany_Module(WebDriver driver,UtilFunction utilfunc) 
{
this.webdriver =driver;
this.utilfunc=utilfunc;		
// TODO Auto-generated constructor stub
}
/**
 * Verify that User is able to landed on the QualifyingExperienceWithCompany Page
 * 	
 * @throws AWTException
 * @throws InterruptedException
 */
public boolean CIMS_QualifyingExperienceWithCompany_ModulePage(int ColumnCounter,String mode) throws AWTException, InterruptedException
{
String TestcaseID=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 0, ColumnCounter);
String QualifyingExperienceWithCompany_Scenerio=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 2, ColumnCounter);
String QualifyingExperienceWithCompany_TestcaseDescription=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 3, ColumnCounter);		
String QualifyingExperienceWithCompany_PageURL=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 4, ColumnCounter);
String QualifyingExperienceWithCompany_ID=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 5, ColumnCounter);
	
String QualifyingExperienceWithCompany_Foreignoperations=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 6, ColumnCounter);

String QualifyingExperienceWithCompany_Trainingreceived=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 7, ColumnCounter);
String QualifyingExperienceWithCompany_Workexperience=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 8, ColumnCounter);
String QualifyingExperienceWithCompany_Contrastduties=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 9, ColumnCounter);
String QualifyingExperienceWithCompany_Assignmentwork=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 10, ColumnCounter);
String QualifyingExperienceWithCompany_Salaryreviews=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 11, ColumnCounter);
String QualifyingExperienceWithCompany_Interviewing=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 12, ColumnCounter);
String QualifyingExperienceWithCompany_Hiring=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 13, ColumnCounter);
String QualifyingExperienceWithCompany_Firing=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 14, ColumnCounter);
String QualifyingExperienceWithCompany_Employeesmanaged=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 15, ColumnCounter);
String QualifyingExperienceWithCompany_Maximumemployeesmanaged=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 16, ColumnCounter);
String QualifyingExperienceWithCompany_Jobtitles=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 17, ColumnCounter);
String QualifyingExperienceWithCompany_Managementpolicies=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 18, ColumnCounter);
String QualifyingExperienceWithCompany_Administrationbudget=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 19, ColumnCounter);
String QualifyingExperienceWithCompany_BudgetAmount=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 20, ColumnCounter);
String QualifyingExperienceWithCompany_BudgetCurrency=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 21, ColumnCounter);
String QualifyingExperienceWithCompany_Enterdetails=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 22, ColumnCounter);
String QualifyingExperienceWithCompany_EstimatedAmount=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 23, ColumnCounter);
String QualifyingExperienceWithCompany_EstimatedCurrency=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 24, ColumnCounter);
String QualifyingExperienceWithCompany_Employeeact=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 25, ColumnCounter);
String QualifyingExperienceWithCompany_Fulldescription=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 26, ColumnCounter);
String QualifyingExperienceWithCompany_beeninUS=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 27, ColumnCounter);
String QualifyingExperienceWithCompany_Numberofdaysindestinationcountry=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 28, ColumnCounter);
String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "QualifyingExperienceWithCompany", 29, ColumnCounter);

String QuestionarieName="Qualifying Experience With Company";
//String URLwithID=UtilFunction.geturl(QuestionarieName);
URLwithID=utilfunc.geturldirect(QuestionarieName);

String QualifyingExperienceWithCompanyXpath=".//*[@class='question-group'][2]//*[@class='control-group'][xx]//*[@name]";
String CounterXpath=".//*[@class='question-group'][2]//*[@class='control-group']//*[@name]";


String QualifyingExperienceWithCompanyXpath1=".//*[@class='question-group'][3]//*[@class='control-group'][xx]//*[@name]";
String CounterXpath1=".//*[@class='question-group'][3]//*[@class='control-group']//*[@name]";

String workxpath10=".//*[@class='question-group'][3]//*[@class='field'][1]//*[@name]";



boolean Flag =false;
testcaseid=TestcaseID;
scenerio=QualifyingExperienceWithCompany_Scenerio;
description=QualifyingExperienceWithCompany_TestcaseDescription;
String ACTION="New";
String ACTION1="Edit";
String ACTION2="Delete";

if(URLwithID.equals("")){
	utilfunc.closesidebar();
Flag=false; 
}else{
 


if(mode.equals(ACTION)|mode.equals(ACTION1)){
	//1st try
	try{
		Thread.sleep(1000);

		utilfunc.NavigatetoURL(URLwithID);
	
		Thread.sleep(1000);

		utilfunc.ServerErrorHandler();
	
	
	String workxpath1=".//*[@class='control-group'] //*[@id='ForeignOperationDesc']";
	utilfunc.MakeElement(workxpath1).clear(); 
	try {
		utilfunc.MakeElement(workxpath1).sendKeys(QualifyingExperienceWithCompany_Foreignoperations);
	} catch (Exception e) {
		
	}
	
	
	String workxpath2=".//*[@class='control-group'] //*[@id='TrainingDesc']";
	utilfunc.MakeElement(workxpath2).clear(); 
	try {
		utilfunc.MakeElement(workxpath2).sendKeys(QualifyingExperienceWithCompany_Trainingreceived);
	} catch (Exception e) {
		
	}
	 
	
	String workxpath3=".//*[@class='control-group'] //*[@id='WorkExperienceDesc']";
	utilfunc.MakeElement(workxpath3).clear(); 
	try {
		utilfunc.MakeElement(workxpath3).sendKeys(QualifyingExperienceWithCompany_Workexperience);
	} catch (Exception e) {
		
	}
	 
	String workxpath4=".//*[@class='control-group'] //*[@id='CompareDutiesDesc']";
	utilfunc.MakeElement(workxpath4).clear(); 
	try {
		utilfunc.MakeElement(workxpath4).sendKeys(QualifyingExperienceWithCompany_Contrastduties);
	} catch (Exception e) {
	}
	
		 
	int ObjCount=utilfunc.GetObjectCount(CounterXpath);
	
	/////////  Loop //////
	for(int count=1; count<=ObjCount; count++)
	{
		 //Label Printing
		 String NewXpath=QualifyingExperienceWithCompanyXpath.replace("xx", Integer.toString(count));
		// String LabelName=utilfunc.MakeElement(NewXpath).getText();
		 
		 try{
			 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
			 System.out.println("Attribute name "+count+"is : "+AttributeName);
			 
			 
			if(AttributeName.contains("Supervision"))
				if(QualifyingExperienceWithCompany_Assignmentwork.equals("Yes")){
					String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'true')]");
					System.out.println(NewXpath2);
					try {
						Thread.sleep(1000);

						utilfunc.MakeElement(NewXpath2).click();
					} catch (Exception e) {
						
					}
				}else{
					String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'false')]");
					System.out.println(NewXpath2);
					try {
						Thread.sleep(1000);

						utilfunc.MakeElement(NewXpath2).click();
					} catch (Exception e) {
						
					}
				}
				 	 else if(AttributeName.contains("Evaluation"))
				 		 if(QualifyingExperienceWithCompany_Salaryreviews.equals("Yes")){
							String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'true')]");
							System.out.println(NewXpath2);
							try {
								Thread.sleep(1000);

								utilfunc.MakeElement(NewXpath2).click();
							} catch (Exception e) {
								
							}
						}else{
							String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'false')]");
							System.out.println(NewXpath2);
							try {
								Thread.sleep(1000);

								utilfunc.MakeElement(NewXpath2).click();
							} catch (Exception e) {
							}
						}
			 
				 	 else if(AttributeName.contains("Interview")) 
				 		 if(QualifyingExperienceWithCompany_Interviewing.equals("Yes")){
							String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'true')]");
							System.out.println(NewXpath2);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath2).click();
							} catch (Exception e) {
							}
						}else{
							String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'false')]");
							System.out.println(NewXpath2);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath2).click();
							} catch (Exception e) {
								}
						}
			 else if(AttributeName.contains("Hiring"))
				 if(QualifyingExperienceWithCompany_Hiring.equals("Yes")){
						String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'true')]");
						System.out.println(NewXpath2);
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(NewXpath2).click();
						} catch (Exception e) {
							
						}
					}else{
						String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'false')]");
						System.out.println(NewXpath2);
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(NewXpath2).click();
						} catch (Exception e) {
							
						}
					}
			 
			 else if(AttributeName.contains("Firing"))
				 if(QualifyingExperienceWithCompany_Firing.equals("Yes")){
						String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'true')]");
						System.out.println(NewXpath2);
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(NewXpath2).click();
						} catch (Exception e) {
							
						}
					}else{
						String NewXpath2=NewXpath.replace("//*[@name]", "//.[contains(@value,'false')]");
						System.out.println(NewXpath2);
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(NewXpath2).click();
						} catch (Exception e) {
							
						}
					}
			 
			 else if(AttributeName.contains("EmployeeManagedMin")){
				 
						String NewXpath3=NewXpath.replace("//*[@name]", "//*[@class='floatL']//*[@name]");
						System.out.println(NewXpath3);
						utilfunc.MakeElement(NewXpath3).clear(); 
						try {
							utilfunc.MakeElement(NewXpath3).sendKeys(QualifyingExperienceWithCompany_Employeesmanaged);
						} catch (Exception e) {
							
						}
						String NewXpath4=NewXpath.replace("//*[@name]", "//*[@class='floatL left-margin-5']//*[@name]");
						System.out.println(NewXpath4);
						utilfunc.MakeElement(NewXpath4).clear(); 
						try {
							utilfunc.MakeElement(NewXpath4).sendKeys(QualifyingExperienceWithCompany_Maximumemployeesmanaged);
						} catch (Exception e) {
							
						}
					
			 } else if(AttributeName.contains("EmployeeJobAcadDesc")){
			 		
			 			utilfunc.MakeElement(NewXpath).clear(); 
			 			try {
							utilfunc.MakeElement(NewXpath).sendKeys(QualifyingExperienceWithCompany_Jobtitles);
						} catch (Exception e) {
							
						}
	          }
			
			
		 }catch(Exception z){
			 
		 }
	}
	
	
	

	int ObjCount1=utilfunc.GetObjectCount(CounterXpath1);
	
	/////////  Loop //////
	for(int count=1; count<=ObjCount1; count++)
	{
		 //Label Printing
		 String NewXpath1=QualifyingExperienceWithCompanyXpath1.replace("xx", Integer.toString(count));
		// String LabelName=utilfunc.MakeElement(NewXpath).getText();
		 
		 try{
			 String AttributeName=utilfunc.MakeElement(NewXpath1).getAttribute("name");
			 System.out.println("Attribute name "+count+"is : "+AttributeName);
			 
			 
			if(AttributeName.contains("ManagementDirection"))
				if(QualifyingExperienceWithCompany_Managementpolicies.equals("Yes")){
					String NewXpath4=NewXpath1.replace("//*[@name]", "//.[contains(@value,'true')]");
					System.out.println(NewXpath4);
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(NewXpath4).click();
					} catch (Exception e) {
						
					}
					 String workxpath11=".//*[@class='question-group'][3]//*[@class='control-group']//*[@id='AdminBudgetDesc']";
						utilfunc.MakeElement(workxpath11).clear(); 
						 try {
							utilfunc.MakeElement(workxpath11).sendKeys(QualifyingExperienceWithCompany_Enterdetails);
						} catch (Exception e) {
							
						}
				}else{
					String NewXpath4=NewXpath1.replace("//*[@name]", "//.[contains(@value,'false')]");
					System.out.println(NewXpath4);
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(NewXpath4).click();
					} catch (Exception e) {
						
					}
					
				}
				 	 else if(AttributeName.contains("AdminBudget"))
				 		 if(QualifyingExperienceWithCompany_Administrationbudget.equals("Yes")){
							String NewXpath4=NewXpath1.replace("//*[@name]", "//.[contains(@value,'true')]");
							System.out.println(NewXpath4);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath4).click();
							} catch (Exception e) {
								
							}
						}else{
							String NewXpath4=NewXpath1.replace("//*[@name]", "//.[contains(@value,'false')]");
							System.out.println(NewXpath4);
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath4).click();
							} catch (Exception e) {
								
							}
						}
		 }catch(Exception z){
			 
		 }
	}
	
	
	 		utilfunc.MakeElement(workxpath10).clear(); 
			try {
				utilfunc.MakeElement(workxpath10).sendKeys(QualifyingExperienceWithCompany_BudgetAmount);
			} catch (Exception e) {
				
			}
			 
			String workxpath11=".//*[@class='question-group'][3]//*[@class='field'][2]//*[@name]";
			try {
				Thread.sleep(1000);
				utilfunc.Selectdropdownvaluebyvalue(workxpath11, QualifyingExperienceWithCompany_BudgetCurrency);
			} catch (Exception e) {
				
			}
				 
			String workxpath12=".//*[@class='question-group'][4]//*[@class='field'][1]//*[@name]";
			utilfunc.MakeElement(workxpath12).clear(); 
			try {
				utilfunc.MakeElement(workxpath12).sendKeys(QualifyingExperienceWithCompany_EstimatedAmount);
			} catch (Exception e) {
				
			}
					 
			String workxpath13=".//*[@class='question-group'][4]//*[@class='field'][2]//*[@name]";
			try {
				Thread.sleep(1000);
				utilfunc.Selectdropdownvaluebyvalue(workxpath13, QualifyingExperienceWithCompany_EstimatedCurrency);
			} catch (Exception e) {
				
			}
				 
				 

	
	String QualifyingExperienceWithCompanyXpath2=".//*[@class='question-group'][4]//*[@class='control-group'][xx]//*[@name]";
	String CounterXpath2=".//*[@class='question-group'][4]//*[@class='control-group']//*[@name]";

	int ObjCount2=utilfunc.GetObjectCount(CounterXpath2);
	
	/////////  Loop //////
	for(int count=1; count<=ObjCount1; count++)
	{
		 //Label Printing
		 String NewXpath=QualifyingExperienceWithCompanyXpath2.replace("xx", Integer.toString(count));
		// String LabelName=utilfunc.MakeElement(NewXpath).getText();
		 
		 try{
			 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
			 System.out.println("Attribute name "+count+"is : "+AttributeName);
			
			  if(AttributeName.contains("ManagerialFunctionDesc")){
				 
			 		utilfunc.MakeElement(NewXpath).clear(); 
					 try {
						utilfunc.MakeElement(NewXpath).sendKeys(QualifyingExperienceWithCompany_Employeeact);
					} catch (Exception e) {
						
					}
	          }
			 else if(AttributeName.contains("ManagerialDutiesDesc")){
				 utilfunc.MakeElement(NewXpath).clear(); 
				 try {
					utilfunc.MakeElement(NewXpath).sendKeys(QualifyingExperienceWithCompany_Fulldescription);
				} catch (Exception e) {
					
				}
	          }		
		 }catch(Exception z){
			 
		 }
	}
		
	String workxpath8=".//*[@class='question-group'][5]//*[@class='control-group']//*[@id='ForeignEmployment']";
	
	String AttributeName3=utilfunc.MakeElement(workxpath8).getAttribute("id");
	if(AttributeName3.contains("ForeignEmployment")){			
	
		
		if( QualifyingExperienceWithCompany_beeninUS.equals("Yes")){
			String NewXpath8=workxpath8.replace("//*[@id]", "//.[contains(@value,'true')]");
			System.out.println(NewXpath8);
			try {
				Thread.sleep(1000);
				utilfunc.MakeElement(NewXpath8).click();
			} catch (Exception e) {
				
			}
		}else{
			String NewXpath8=workxpath8.replace("//*[@id]", "//.[contains(@value,'false')]");
			System.out.println(NewXpath8);
			try {
				Thread.sleep(1000);
				utilfunc.MakeElement(NewXpath8).click();
			} catch (Exception e) {
				
			}
		}

	}
	
	
String workxpath9=".//*[@class='question-group'][5]//*[@class='control-group']//*[@id='ForeignEmploymentDays']";
{
	
utilfunc.MakeElement(workxpath9).clear(); 
try {
	utilfunc.MakeElement(workxpath9).sendKeys(QualifyingExperienceWithCompany_Numberofdaysindestinationcountry);
} catch (Exception e) {
	
}
		}	
	
	}catch (Exception e){
		
	}
	
	
	////////////////Additional info handler ////////////////////
	String Xpathnew1=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
	String Xpathnew2=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";

	//function to call the dynamic text data
	try {
		try {
			Thread.sleep(1000);
			utilfunc.dynamic_data(Xpathnew1, Xpathnew2);
		} catch (Exception e) {
			
		}
	} catch (Exception e) {
			}

	try {Thread.sleep(1000);
		utilfunc.savebutton();
	} catch (Exception e) {
		
	}

	String error_flag=utilfunc.TravelPlanErrorMessageHandler();
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
			 
			}catch(Exception z){
				utilfunc.ErrorMessage="";
				utilfunc.ErrorMessage1="";							
				utilfunc.ErrorMessage4="";
				utilfunc.ErrorMessage5="";
				Deletecheck="Delete";
				testcaseid="TC001";
				scenerio="Positive";
				description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
				utilfunc.ErrorMessage2="Delete option is not Implimented in Qualifying Experience with company Module.";
				utilfunc.TakeScreenshot();
				Flag=false;
		}			
	 
}
}///////////url ckeck end
return Flag;
}
}



