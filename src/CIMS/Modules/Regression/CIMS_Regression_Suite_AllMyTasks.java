package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.hamcrest.text.IsEmptyString;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Regression_Suite_AllMyTasks {
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Regression_Suite_AllMyTasks(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean AllMyTasks(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		boolean Flag	=	false;

		//excel data sheet collection..
		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
		String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String BalNumber									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
		String Name											=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
		String Destination									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
		String Company										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		String Project										=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
		String Task											=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
		String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);

		testcaseid=TestcaseID;
		scenerio=Scenario;
		description=TestCaseDescription;

//		if(TestcaseRunMode.equals("Y")){
//
//			String Searchtextbox_path=".//*[@id='worklist_filter']//*[@type='search']";
//			String KnowrecordfoundorNot_xpath=".//*[@id='worklist']/tbody/tr[1]/td[1]";
//			String recoredfound_clickonrecored_xpath=".//*[@id='worklist']/tbody/tr[1]/td[2]/a";
//			String bal_varify_xpath=".//*[@id='prg-hdr-detail']/tbody/tr[2]/td[2]";
//			String name_varify_xpath=".//*[@id='prg-hdr-main']/tbody/tr[1]/td[1]/span[1]";
//			String destination_varify_xpath=".//*[@id='prg-hdr-detail']/tbody/tr[7]/td[2]";
//			String company_varify_xpath=".//*[@id='prg-hdr-detail']/tbody/tr[2]/td[4]";
//			String project___xpath=".//*[@class='dvMaisnCaseNumber']";
//			String task_viewInitiationDetails_xpath=".//*[@class='dvMaisnCaseNumber']";
//			String task_ViewQuestionnaire_xpath=".//*[@class='dvMaisnCaseNumber']";
//
//			String Searchtext="";
//			String error_flag                ="";
//			String error_msg                ="";
//			String searchby="";
//
//			if(!BalNumber.isEmpty()){
//				Searchtext=BalNumber;
//				searchby="BalNumber";
//			}else if(!Name.isEmpty())
//			{	Searchtext=Name;
//			searchby="Name";
//			}else if(!Destination.isEmpty())
//			{	Searchtext=Destination;
//			searchby="Destination";
//			}else if(!Company.isEmpty())
//			{	Searchtext=Company;
//			searchby="Company";
//			}else if(!Project.isEmpty())
//			{	Searchtext=Project;
//			searchby="Project";
//			}else if(!Task.isEmpty())
//			{	Searchtext=Task;
//			searchby="Task";
//			}
//
//			if(!Searchtext.isEmpty()){
//				utilfunc.MakeElement(Searchtextbox_path).clear();}
//			utilfunc.MakeElement(Searchtextbox_path).sendKeys(Searchtext);
//			Thread.sleep(1000);
//			String getclass="";
//			try{getclass=utilfunc.MakeElement(KnowrecordfoundorNot_xpath).getAttribute("class");}catch(Exception e){}
//			System.out.println(getclass);
//
//			if(getclass.contains("dataTables_empty"))
//			{//No  record found
//				utilfunc.scrollToTop();
//
//				System.out.println("No matching records found");
//				error_msg="No matching records found";
//				Flag=false;
//
//			}else if(getclass.contains("details-control")){//record found
//
//				//check by using which value user search and what we have to compare
//				try{
//					utilfunc.MakeElement(recoredfound_clickonrecored_xpath).click();
//					Thread.sleep(1000);
//					String getvaluetomatch="";
//
//
//					if(searchby.equals("BalNumber"))
//					{
//						getvaluetomatch=utilfunc.MakeElement(bal_varify_xpath).getText();
//						if(getvaluetomatch.equalsIgnoreCase(BalNumber))
//						{Flag=true;}
//						else{Flag=false;}
//					}
//					else if(searchby.equals("Name"))
//					{
//						getvaluetomatch=utilfunc.MakeElement(name_varify_xpath).getText();
//						if(getvaluetomatch.equalsIgnoreCase(Name))
//						{Flag=true;}
//						else{Flag=false;}
//					}
//					else if(searchby.equals("Destination"))
//					{
//						getvaluetomatch=utilfunc.MakeElement(destination_varify_xpath).getText();
//						if(getvaluetomatch.equalsIgnoreCase(Destination))
//						{Flag=true;}
//						else{Flag=false;}
//					}
//					else if(searchby.equals("Company"))
//					{
//						getvaluetomatch=utilfunc.MakeElement(company_varify_xpath).getText();
//						if(getvaluetomatch.equalsIgnoreCase(Company))
//						{Flag=true;}
//						else{Flag=false;}
//					}
//					else if(searchby.equals("Project"))
//					{
//						if(Project.equals("--"))
//						{
//							getvaluetomatch=utilfunc.MakeElement(project___xpath).getText();
//							if(getvaluetomatch.contains("Project Initiation"))
//							{Flag=true;}
//							else{Flag=false;}
//
//						}
//						else{
//							getvaluetomatch=utilfunc.MakeElement(project___xpath).getText();
//							if(getvaluetomatch.equalsIgnoreCase(Project))
//							{Flag=true;}
//							else{Flag=false;}
//						}
//
//					}
//					else if(searchby.equals("Task"))
//					{
//
//						if(Task.equalsIgnoreCase("View Initiation Detail")){
//							getvaluetomatch=utilfunc.MakeElement(task_viewInitiationDetails_xpath).getText();
//							if(getvaluetomatch.contains("Project Initiation"))
//							{Flag=true;}
//							else{Flag=false;}
//						}
//						else if(Task.equalsIgnoreCase("View Questionnaire")){
//							getvaluetomatch=utilfunc.MakeElement(task_ViewQuestionnaire_xpath).getText();
//							if(getvaluetomatch.contains("Project Initiation #"))
//							{Flag=true;}
//							else{Flag=false;}
//						}
//					}
//
//				}catch(Exception e){System.out.println("unable too click on balnumber");}
//			}
//
//
//			if(Flag==false)
//			{
//				System.out.println("Please wait we are checking for error... ... ...");
//				try{
//					error_flag=utilfunc.ErrorMessagehandlerExperiment();
//				}
//				catch(Exception e){}
//				System.out.println("We are done with error check.");
//				System.out.println("error_flag---"+error_flag);
//				if(error_flag.equals("Server Error in '/' Application.")){
//					Flag=false;
//					utilfunc.TakeScreenshot();
//				}
//				else if (error_flag.equals(ExpectedErrorMessage)){
//					Flag=true;
//					utilfunc.TakeScreenshot();
//				}
//				else if (error_msg.equals(ExpectedErrorMessage)){
//					Flag=true;
//					utilfunc.globalerrormessage=error_msg;
//					utilfunc.ErrorMessage4=error_msg;
//					utilfunc.TakeScreenshot();
//					Thread.sleep(1000);
//				}
//				else
//				{
//					Flag=false;
//					utilfunc.TakeScreenshot();
//					utilfunc.globalerrormessage=error_msg;
//					utilfunc.ErrorMessage4=error_msg;
//
//				}
//
//			}
//
//		}

		return Flag;
	}

}
