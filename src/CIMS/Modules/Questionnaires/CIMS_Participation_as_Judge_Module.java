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

import CIMS.CIMS_MainProject;
import util.UtilFunction;

public class CIMS_Participation_as_Judge_Module {
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

	public CIMS_Participation_as_Judge_Module(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;

		// TODO Auto-generated constructor stub
	}
	public boolean Participation_as_Judge_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		//Excel sheet Data collection
		String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 0, ColumnCounter);
		String Participation_as_JudgeScenerio=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 2, ColumnCounter);
		String Participation_as_JudgeTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 3, ColumnCounter);		
		String Participation_as_JudgePageURL=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 4, ColumnCounter);
		String Participation_as_JudgeID=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 5, ColumnCounter);

		String IsThisPeerReviewedJournalArticle=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 6, ColumnCounter);
		String IsPublication=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 7, ColumnCounter);
		String Documentation=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 8, ColumnCounter);
		String YourRole=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 9, ColumnCounter);
		String ReasonsYouWereSelected=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 10, ColumnCounter);
		String NamePeerReviewed=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 11, ColumnCounter);
		String Date=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 12, ColumnCounter);

		String Fileupload=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 13, ColumnCounter);
		String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Participation_as_Judge", 14, ColumnCounter);

		String showbuttonxpath=".//*[@id='btnShowDocUpload']";
		String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
		String fileuploadpath="";
		if(CIMS_MainProject.os.contains("Linux")){
			fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
		}else if(CIMS_MainProject.os.contains("Windows")){
			fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
		}
		String fileuploadbutton=".//*[@id='btnUploadDocuments']";

		String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div[xx]//*[@id]";
		String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//../h4//../div//*[@id]";

		String ParticipationattributeFiledXpath=".//*[@class='question-group'][xx]//*[@id]";
		String ParticipationJudgeCounterXpath=".//*[@class='question-group']//*[@id]";

		//*[@id='form1']//*[@class='control-group']//*[@name]
		String ParticipationattributeFiledXpath1=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
		String ParticipationJudgeCounterXpath1=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";

		String NamePeerReviewedJournalArticle=".//*[@id='NamePeerReviewedJournalArticle']";
		String DateOfPublication=".//*[@id='DateOfPublication']";

		/////////////////////////////////URL FETCH///////////////////////////////////

		String QuestionarieName="Participation as Judge or Reviewer";
		//String URLwithID=UtilFunction.geturl(QuestionarieName);
		URLwithID=utilfunc.geturldirect(QuestionarieName);

		boolean Flag =false;
		testcaseid=TestcaseID;
		scenerio=Participation_as_JudgeScenerio;
		description=Participation_as_JudgeTestcaseDescription;

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
					/*String Participation_as_JudgeURLwithID=Participation_as_JudgePageURL+Participation_as_JudgeID;
					 utilfunc.NavigatetoURL(Participation_as_JudgeURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					try{
						String AddbuttonXpath="//*[@class='btn']";
						try {
							utilfunc.MakeElement(AddbuttonXpath).click();
						} catch (Exception e1) {

						}
						Thread.sleep(2000);
						int ObjCount=utilfunc.GetObjectCount(ParticipationJudgeCounterXpath);

						for(int count=1; count<=ObjCount; count++)
						{
							try{
								String NewXpath=ParticipationattributeFiledXpath.replace("xx", Integer.toString(count));

								try{
									String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									// System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.equals("IsThisPeerReviewedJournalArticle")){
										if(IsThisPeerReviewedJournalArticle.equals("Yes")){
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
											//	System.out.println(NewXpath1);
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();


												utilfunc.MakeElement(NamePeerReviewedJournalArticle).clear();
												utilfunc.MakeElement(NamePeerReviewedJournalArticle).sendKeys(NamePeerReviewed);

												utilfunc.MakeElement(DateOfPublication).clear();
												utilfunc.MakeElement(DateOfPublication).sendKeys(Date);
											}catch(Exception Error){}
										}else{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
											//System.out.println(NewXpath1);
											try{utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception Error){}
										}

									}	
									else if(AttributeName.equals("IsPublication")){							
										if(IsPublication.equals("Yes")){
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
											//System.out.println(NewXpath1);
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception Error){}
										}else{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
											//System.out.println(NewXpath1);
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception Error){}
										}
									}
									else if(AttributeName.equals("Documentation")){							
										if(Documentation.equals("Yes")){
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
											//System.out.println(NewXpath1);
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception Error){}
										}else{
											String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
											//System.out.println(NewXpath1);
											try{
												Thread.sleep(1000);
												utilfunc.MakeElement(NewXpath1).click();
											}catch(Exception Error){}}
									}

								}catch(Exception e){

								}
							}catch(Exception Error){}
						}
						//////////////////////////////////////////////////////////////////////////
						int ObjCount1=utilfunc.GetObjectCount(ParticipationJudgeCounterXpath1);

						for(int count=1; count<=ObjCount1; count++)
						{
							Thread.sleep(300);
							try{
								String NewXpath=ParticipationattributeFiledXpath1.replace("xx", Integer.toString(count));

								try{
									String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
									System.out.println("Attribute name "+count+"is : "+AttributeName);

									if(AttributeName.equals("YourRole")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(YourRole);
										}catch(Exception Error){}
									}	
									else if(AttributeName.equals("ReasonsYouWereSelected")){
										try{
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(ReasonsYouWereSelected);
										}catch(Exception Error){}
									}
									else if(AttributeName.contains("btn_uploader")){
									}

								}catch(Exception Error){}
							}catch(Exception Error){}

						}
						
						
						// code updated by brij ///
						
						try{
							
							String IsThisPeerReviewedJournalArticleXPath	=	"//*[@id='IsThisPeerReviewedJournalArticle']";
							
						if(IsThisPeerReviewedJournalArticle.equalsIgnoreCase("yes")){
							
							try {
								utilfunc.MakeElement(IsThisPeerReviewedJournalArticleXPath+"//.[@value='True']").click();
							} catch (Exception e) {

							}
							
						String NamePeerReviewedJournalArticleXPath	=	"//*[@id='NamePeerReviewedJournalArticle']";
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(NamePeerReviewedJournalArticleXPath).clear();
							utilfunc.MakeElement(NamePeerReviewedJournalArticleXPath).sendKeys(NamePeerReviewed);
						} catch (Exception e1) {
						}
						
						String DateOfPublicationXPath	=	"//*[@id='DateOfPublication']";
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(DateOfPublicationXPath).clear();
							utilfunc.MakeElement(DateOfPublicationXPath).sendKeys(Date);
						} catch (Exception e1) {
						}
						}else{
							try {
								utilfunc.MakeElement(IsThisPeerReviewedJournalArticleXPath+"//.[@value='False']").click();
							} catch (Exception e) {

							}
						}
						}catch(Exception e){}
						/////////////////upload////////////////////////////////////
						try{
							if(Fileupload.equals("Yes")){
								utilfunc.MakeElement(showbuttonxpath).click();
								Thread.sleep(2000);
								utilfunc.MakeElement(uploadbuttonxpath).click();
								Thread.sleep(1000);    
								utilfunc.uploadfile(fileuploadpath);
								Thread.sleep(5000);
								utilfunc.MakeElement(fileuploadbutton).click();
							}

						}catch(Exception e){

						}
						//////////////////////Additional info handle///////////////////////////////
						try{utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
						}catch(Exception Error){}

						try{
							utilfunc.savebutton();
						}catch(Exception Error){}

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
					}catch(Exception Error){}
				}catch(Exception Error){}


			}else if(mode.equals(ACTION1)){

				try{
					/*String Participation_as_JudgeURLwithID=Participation_as_JudgePageURL+Participation_as_JudgeID;
					 utilfunc.NavigatetoURL(Participation_as_JudgeURLwithID);*/

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);

					String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					utilfunc.MakeElement(EditbuttonXpath).click();

					int ObjCount=utilfunc.GetObjectCount(ParticipationJudgeCounterXpath);

					for(int count=1; count<=ObjCount; count++)
					{
						Thread.sleep(300);

						String NewXpath=ParticipationattributeFiledXpath.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							//System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("IsThisPeerReviewedJournalArticle")){
								if(IsThisPeerReviewedJournalArticle.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
									//System.out.println(NewXpath1);
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();

										utilfunc.MakeElement(NamePeerReviewedJournalArticle).clear();
										utilfunc.MakeElement(NamePeerReviewedJournalArticle).sendKeys(NamePeerReviewed);

										utilfunc.MakeElement(DateOfPublication).clear();
										utilfunc.MakeElement(DateOfPublication).sendKeys(Date);
									}catch(Exception Error){}

								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
									//System.out.println(NewXpath1);
									try{
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Error){}
								}

							}	
							else if(AttributeName.equals("IsPublication")){							
								if(IsPublication.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
									//System.out.println(NewXpath1);
									try{	utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Error){}
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
									//System.out.println(NewXpath1);
									try{utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Error){}
								}
							}
							else if(AttributeName.equals("Documentation")){							
								if(Documentation.equals("Yes")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][1]");
									//System.out.println(NewXpath1);
									try{utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Error){}
								}else{
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@type='radio'][2]");
									//System.out.println(NewXpath1);
									try{utilfunc.MakeElement(NewXpath1).click();
									}catch(Exception Error){}
								}
							}
						}catch(Exception e){
						}
					}
					//////////////////////////////////////////////////////////////////////////
					int ObjCount1=utilfunc.GetObjectCount(ParticipationJudgeCounterXpath1);

					for(int count=1; count<=ObjCount1; count++)
					{
						String NewXpath=ParticipationattributeFiledXpath1.replace("xx", Integer.toString(count));

						try{
							String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("name");
							//							System.out.println("Attribute name "+count+"is : "+AttributeName);

							if(AttributeName.equals("YourRole")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(YourRole);
								}catch(Exception Error){}
							}	
							else if(AttributeName.equals("ReasonsYouWereSelected")){
								try{
									utilfunc.MakeElement(NewXpath).clear();
								utilfunc.MakeElement(NewXpath).sendKeys(ReasonsYouWereSelected);
								}catch(Exception Error){}
								}
							else if(AttributeName.contains("btn_uploader")){
							}

						}catch(Exception e){

						}

					}
					/////////////////upload////////////////////////////////////
					try{
						if(Fileupload.equals("Yes")){
							utilfunc.MakeElement(showbuttonxpath).click();
							Thread.sleep(2000);
							utilfunc.MakeElement(uploadbuttonxpath).click();
							Thread.sleep(1000);    
							utilfunc.uploadfile(fileuploadpath);
							Thread.sleep(5000);
							utilfunc.MakeElement(fileuploadbutton).click();
						}
						}catch(Exception Error){}	
					//////////////////////Additional info handle///////////////////////////////
					try{
					utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					}catch(Exception Error){}
					
					try{
					utilfunc.savebutton();
					}catch(Exception Error){}
					
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
					if (error_flag.equals(ExpectedErrorMessage)){
						Flag=true;
					}else if (error_flag.equals("")){
						Flag=true;
					}else if(error_flag.equals("Server Error in '/' Application.")){
						Flag=false;
						webdriver.navigate().back();
					}else{
						Flag=false;
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
					/*String Participation_as_JudgeURLwithID=Participation_as_JudgePageURL+Participation_as_JudgeID;
					 utilfunc.NavigatetoURL(Participation_as_JudgeURLwithID);*/
					utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
					testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";

					utilfunc.NavigatetoURL(URLwithID);
					utilfunc.ServerErrorHandler();
					Thread.sleep(2000);
					
					String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					
					try{
					utilfunc.MakeElement(DeletebuttonXpath).click();
					Thread.sleep(10000);
					utilfunc.isAlertPresent();
					}catch(Exception Error){}
					
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