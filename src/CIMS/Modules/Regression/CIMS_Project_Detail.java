package CIMS.Modules.Regression;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import CIMS.CIMS_Company;
import CIMS.CIMS_MainProject;

import util.UtilFunction;

public class CIMS_Project_Detail {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";



		public CIMS_Project_Detail(WebDriver driver,UtilFunction utilfunc) {
			this.webdriver =driver;
			this.utilfunc=utilfunc;
		}


		public boolean Project_Detail(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;

			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module..");

			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String InfoRecd							            =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String DocsOut                                      =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Filed							            =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String Decision                                     =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String ProjectEndDate							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			String ExpectedErrorMessage      				    =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String ProjectStageOpen                             =			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String ProjectStageClosed							    =			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);

			String ProjectReportNote                                     =			UtilFunction.getCellData(filename, sheetName,12, ColumnCounter);
			String ProjectReportNoteDate							    =			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);

			
			
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				
				
				//** code for below tables ***/
				System.out.println("now let us find out how may rows are there");
				String MainTablesContainerCounterXPath	=	".//*[@id='formProjectStages']/div";
				
				int MainRowCount	=	utilfunc.GetObjectCount(MainTablesContainerCounterXPath);
				
				if(MainRowCount>0){
					// get it in loop for each row..
					for(int i=1;i<=MainRowCount;i++){
						String valOne	=	"";
						String valScnd	=   "";
						if(i==1){
							valOne	=	ProjectStageOpen;
							valScnd	=	ProjectStageClosed;
						}
						else if(i==2){
							valOne	=	ProjectReportNote;
							valScnd	=	ProjectReportNoteDate;
						}
						else if(i==3){
							valOne	=	ProjectStageOpen;
							valScnd	=	ProjectStageClosed;
						}
						else if(i==4){
							valOne	=	ProjectReportNote;
							valScnd	=	ProjectReportNoteDate;
						}
						else if(i==5){
							valOne	=	ProjectStageOpen;
							valScnd	=	ProjectStageClosed;
						}
						else if(i==6){
							valOne	=	ProjectReportNote;
							valScnd	=	ProjectReportNoteDate;
						}
						else if(i==7){
							valOne	=	ProjectStageOpen;
							valScnd	=	ProjectStageClosed;
						}
						else if(i==8){
							valOne	=	ProjectReportNote;
							valScnd	=	ProjectReportNoteDate;
						}else{
							System.out.println("row not found");
						}
						
						boolean val = setAllDataInPorjectDetailRow(i,valOne,valScnd,ExpectedErrorMessage);
						
						
						
					}
				}
				
				//** code for below tables ends here by Brij ***/				
				
				/// first form code
				
				String FirstTableCounter=".//*[@id='panel-body-container']//.[@id='panel-body']//tbody//tr//*[@class='form-horizontal']//*[contains(@id,'formProject')][1]//*[contains(@class,'panel-body-main')]//tr//td//.[contains(@class,'hasDatepicker')]";
				
				String FirstTableFieldXpath =".//*[@id='panel-body-container']//.[@id='panel-body']//tbody//tr//*[@class='form-horizontal']//*[contains(@id,'formProject')][1]//*[contains(@class,'panel-body-main')]//tr//td[xx]//.[contains(@class,'hasDatepicker')]//.[@name]";
				
				String NewXpath;
			    String AttributeName;
					if(mode.equals("New")){
					
					int resultcount= utilfunc.GetObjectCount(FirstTableCounter);
					
					for(int i=1; i<=resultcount;i++){
						
						NewXpath = FirstTableFieldXpath.replace("xx", Integer.toString(i));
						
					
						try {
							AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							
							System.out.println("NewXpath is" +" "+NewXpath );
							System.out.println("AttributeName is "+" "+AttributeName);
							
							if(AttributeName.equals("InfoRecd")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									
									utilfunc.MakeElement(NewXpath).sendKeys(InfoRecd);
								} catch (Exception e) {
									System.out.println("unable to enter the value");
								}
						 }else if(AttributeName.equals("DocsOut")){

								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									
									utilfunc.MakeElement(NewXpath).sendKeys(DocsOut);
								} catch (Exception e) {
									System.out.println("unable to enter the value");
								}
						 }
						 else if(AttributeName.equals("Filed")){

								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									
									utilfunc.MakeElement(NewXpath).sendKeys(Filed);
								} catch (Exception e) {
									System.out.println("unable to enter the value");
								}
						 }
						 else if(AttributeName.equals("Decision")){

								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									
									utilfunc.MakeElement(NewXpath).sendKeys(Decision);
								} catch (Exception e) {
									System.out.println("unable to enter the value");
								}
						 }
						 else if(AttributeName.equals("ProjectEndDate")){

								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									
									utilfunc.MakeElement(NewXpath).sendKeys(ProjectEndDate);
								} catch (Exception e) {
									System.out.println("unable to enter the value");
								}
						 }
						
						
						
						} catch (Exception e) {
							System.out.println("i m here......");
						}
						
						
						
					}
					
				}
				
				
					try{
						 // save button after saving all data..
						String sendBtn	=	".//a[contains(@class,'btn') and text()='Save Changes']";
			        	
						Thread.sleep(1000);
						utilfunc.MakeElement(sendBtn).click();
						Thread.sleep(1000);
					}
					catch(Exception e){}
					try{
						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed.ss. ");
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						//ExpectedErrorMessage=ExpectedErrorMessage.trim();
						System.out.println("==="+ExpectedErrorMessage+"====");
						System.out.println("==="+error_flag+"===");
						
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
						Flag	=	false;
						System.out.println("Data is not saved because all fields are not set in the form.");
					}
					
					
					
					
					
					
					
					
					
					
				}
				return Flag;
				}
				
			

		public boolean setAllDataInPorjectDetailRow(int row, String StageOpenOrReportNote, String CloseOrReportDate,String ExpectedErrorMessage){
            
			boolean innerFlag = false;
			
//			row=row+1;
			String InnerRowCounterXpath			=	".//*[@id='formProjectStages']/div["+Integer.toString(row)+"]//table[1]//tr";
			String InnerRowXpath				=	".//*[@id='formProjectStages']/div["+Integer.toString(row)+"]//table[1]//tr";
			String InnerCoulumnCounterXpath		=	InnerRowXpath+"[xx]/td";
			String closebtn=".//*[@id='MessagePopupModal']/div/div[2]/a";


			// this is row count
			int count	=	utilfunc.GetObjectCount(InnerRowCounterXpath);

			if(count>0){
				for(int c=1;c<=count;c++){
					// count inner coulmn..
					String InnerCoulumnXpath		=	InnerCoulumnCounterXpath.replace("xx", Integer.toString(c));
					int colCount	=	utilfunc.GetObjectCount(InnerCoulumnXpath);
					if(colCount>0){
						for(int ic=1;ic<=colCount;ic++){
							// input box counter..
							String InputBoxCounterXPath			=	InnerCoulumnXpath+"[yy]//*[@name and not(@type='hidden')]";
							String InputBoxXPath			=	InputBoxCounterXPath.replace("yy", Integer.toString(ic));
							String textValue	=	"";

							int InputBoxCounter		=	utilfunc.GetObjectCount(InputBoxXPath);
							
							System.out.println(InputBoxCounter);
							if(InputBoxCounter>0){
								
								if(InputBoxCounter>1){
									// code for new xpath
									for(int r=1;r<=InputBoxCounter;r++){
										String NewInputXpath = InputBoxXPath+"["+Integer.toString(r)+"]";

										if(ic==1 || ic==2){
											if(ic==1){
												textValue	=	StageOpenOrReportNote;
											}else if(ic==2){
												textValue	=	 CloseOrReportDate;
											}
												try {
													utilfunc.MakeElement(NewInputXpath).clear();
													utilfunc.MakeElement(NewInputXpath).sendKeys(textValue);
												} catch (Exception e) {
													System.out
															.println("i m here");
												}
											}else if(ic==3){
												try {
													utilfunc.MakeElement(NewInputXpath).click();
												} catch (Exception e) {
													System.out.println("Unable to click on the button");
												}
												try{
												String error_flag=ProjectDetailErrorMessagehandlerExperiment();
												
												 if (error_flag.equals(ExpectedErrorMessage)){
													 innerFlag=true;
													 utilfunc.TakeScreenshot();
													 try {
															utilfunc.MakeElement(closebtn).click();
														} catch (Exception e) {
														System.out
																.println("Unable to click on the btn");
														}
												 }else if (error_flag.equals("")){
													 innerFlag=true;
													 try {
															utilfunc.MakeElement(closebtn).click();
														} catch (Exception e) {
														System.out
																.println("Unable to click on the btn");
														}
												 }else if (error_flag.contains("Success!")){
													 innerFlag=true;
												 }else if(error_flag.equals("Server Error in '/' Application.")){
													 innerFlag=false;
													 webdriver.navigate().back();
												 }else{
													 innerFlag=false;
													 utilfunc.TakeScreenshot();
													 
													 try {
														utilfunc.MakeElement(closebtn).click();
													} catch (Exception e) {
													System.out
															.println("Unable to click on the btn");
													}
												 }
												
												}
												catch(Exception e){
													System.out.println("some issue while error handling for row number"+row);
												}
											}
									}
									
								}else{
									// set values 

									if(ic==1 || ic==2){
									if(ic==1){
										textValue	=	StageOpenOrReportNote;
									}else if(ic==2){
										textValue	=	 CloseOrReportDate;
									}
										utilfunc.MakeElement(InputBoxXPath).clear();
										utilfunc.MakeElement(InputBoxXPath).sendKeys(textValue);
										
										String Add_Note_Xpath=".//*[@id='formProjectStages']/div[4]//table[1]//tr[1]/td[2]//*[text()='Add Note']";
										try {
											utilfunc.MakeElement(Add_Note_Xpath).click();
										} catch (Exception e) {
											System.out.println("Unable to click on the button");
										}
										
										
									}
									
									
									else if(ic==3){
									
										try {
											utilfunc.MakeElement(InputBoxXPath).click();
											
										} catch (Exception e) {
											System.out.println("Unable to click on the button");
										}
										
										try{
											String error_flag=ProjectDetailErrorMessagehandlerExperiment();
											
											 if (error_flag.equals(ExpectedErrorMessage)){
												 innerFlag=true;
												 try {
														utilfunc.MakeElement(closebtn).click();
													} catch (Exception e) {
													System.out
															.println("Unable to click on the btn");
													}
												 utilfunc.TakeScreenshot();
											 }else if (error_flag.equals("")){
												 innerFlag=true;
												 try {
														utilfunc.MakeElement(closebtn).click();
													} catch (Exception e) {
													System.out
															.println("Unable to click on the btn");
													}
											 }else if (error_flag.contains("Success!")){
												 innerFlag=true;
											 }else if(error_flag.equals("Server Error in '/' Application.")){
												 innerFlag=false;
												 webdriver.navigate().back();
											 }else{
												 innerFlag=false;
												 utilfunc.TakeScreenshot();
												 
												 try {
														utilfunc.MakeElement(closebtn).click();
													} catch (Exception e) {
													System.out
															.println("Unable to click on the btn");
													}
												 
											 }
											
											}
											catch(Exception e){
												System.out.println("some issue while error handling for row number"+row);
											}
									}
									
								}
							}
							
						}
						
					}
				}
			}
			
			return true;
		}
		// ///////////////////////ERROR
		// HANDLER////////////////////////////////////////////////////////

		public String ProjectDetailErrorMessagehandlerExperiment() {

			webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			String ErrorMessage4 = "";

			String ErrorMessage1 = "";

			String ErrorMessage2 = "";

			String ErrorMessage5 = "";

			String globalerrormessage = "";

			// //////////////////ERROR4/////////////////////////////////////////////////

			try {

				// String
				// errorcounterxpath=".//*[@class='control-group']//*[@class='error']";

				String errorcounterxpath = ".//*[@id='modal_body']";

				String errorfieldxpath = ".//*[@id='modal_body'][xx]";

				int ObjCount2 = utilfunc.GetObjectCount(errorcounterxpath);

				for (int count = 1; count <= ObjCount2; count++) {

					String NewXpath = errorfieldxpath.replace("xx",
							Integer.toString(count));

					try {

						String Error = utilfunc.MakeElement(NewXpath).getText();

						System.out.println("Error " + count + "is : " + Error);

						ErrorMessage4 = Error + ErrorMessage4;

					} catch (Exception e) {

					}

				}

			} catch (Exception e) {

			}

			// //////////////////ERROR4
			// END/////////////////////////////////////////////////

			// //////////////////ERROR
			// 1,2,5////////////////////////////////////////////////

			try {

				String compensationErrorMessageXpath = "//*[@id='page-message']";

				ErrorMessage5 = utilfunc.MakeElement(compensationErrorMessageXpath)
						.getText();

				String errormessage = ".//*[@id='validation-summary']";

				ErrorMessage2 = utilfunc.MakeElement(errormessage).getText();

				ErrorMessage1 = utilfunc.MakeElement(compensationErrorMessageXpath)
						.getText();

				try {

					String compensationErrorMessageXpath1 = "//*[@id='page-message1']";

					ErrorMessage5 = utilfunc.MakeElement(compensationErrorMessageXpath1)
							.getText();

				} catch (Exception e) {

				}

				// Code appended by Lokesh on 13-April-2016 for check if
				// ErrorMessage1==ErrorMessage5 then make ErrorMessage1="" (Remove
				// duplicate message in ErrorMessage1 or ErrorMessage5)
				try {
					if (ErrorMessage1.equalsIgnoreCase(ErrorMessage5)) {
						ErrorMessage5 = "";
					}
				} catch (Exception error) {
				}

				System.out.println("The Error1 is " + ErrorMessage1);

				System.out.println("The Error2 is " + ErrorMessage2);

				System.out.println("The Error5 is " + ErrorMessage5);

			} catch (Exception e) {

				System.out.println("Exception occured: " + e);

			}

			// //////////////////ERROR 1,2,5
			// END///////////////////////////////////////////

			// ///////////////////server error
			// handle//////////////////////////////////////

			try {

				String servererrorxpath = "html/body/span/h1";

				ErrorMessage1 = utilfunc.MakeElement(servererrorxpath).getText();

				if (ErrorMessage1.equals("Server Error in '/' Application.")) {

					utilfunc.TakeScreenshot();

					globalerrormessage = ErrorMessage1;

					return globalerrormessage;

				}

			} catch (Exception e) {

			}

			// ///////////////////server error handle
			// END//////////////////////////////////////

			if (!CIMS_Company.ExcelFileName.equals("Test Company Data.xls"))

			{

				if (CIMS_MainProject.questionarie_name1.equals("awards")
						| CIMS_MainProject.questionarie_name1
								.equals("Commercial_Success")
						| CIMS_MainProject.questionarie_name1.equals("Citizenship")
						| CIMS_MainProject.questionarie_name1
								.equals("Contacts_and_References")) {

					globalerrormessage = ErrorMessage4 + ErrorMessage2
							+ ErrorMessage5;

				} else if (CIMS_MainProject.questionarie_name1
						.equals("Residence_History")
						| CIMS_MainProject.questionarie_name1
								.equals("Travel_Plans")) {

					globalerrormessage = ErrorMessage1 + ErrorMessage2
							+ ErrorMessage5;

				}

			}

			else {

				globalerrormessage = ErrorMessage4 + ErrorMessage1 + ErrorMessage2
						+ ErrorMessage5;

				if (globalerrormessage.contains("Success"))

				{

					globalerrormessage = "";

				}

			}

			globalerrormessage = globalerrormessage.replaceAll("\n", " ");

			return globalerrormessage;

		}

		// //////////////////////////////////////ERROR HANDLER
		// END////////////////////////////////////////
		
	
}
