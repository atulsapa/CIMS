package CIMS.Modules.Advanced;

import java.awt.AWTException;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.collection.IsEmptyCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import util.UtilFunction;

public class Project_Search {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description	=	null;

	public Project_Search(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}



	public boolean advanced_Project_Search(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
	{

		boolean flag=false;

		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);

		if(TestcaseRunMode.equals("Y"))
		{
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);

			String Name											=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String Email										=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String BalNumber									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String ProjectReference								=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String Comapny										=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);

			String Destination									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String ProjectType									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String Status										=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String Role											=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String Person										=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);

			String Principalonly								=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			String IncludeIndividual							=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;


			//remove # from Project Reference.
			try{
				if(ProjectReference.contains("#"))
				{
					ProjectReference		=	ProjectReference.replace("#", "");
				}
			}catch(Exception error)
			{
				System.out.println("ubable to remove # from project reference.");
			}

			if((mode.equalsIgnoreCase("New"))||(mode.equalsIgnoreCase("Edit"))||(mode.equalsIgnoreCase("Delete"))){

				String MoreOption_xpath				=	"//*[@id='panel-body-container']//*[@id='spanProject' and contains(text(),'More options')]";
				String ProjectSearchCounter_xpath	=	"//*[contains(@class,'projectSearchFields')]//*[contains(@class,'form-horizontal')]";
				String rowelement1and3_xapth		=	".//*[@id='panel-body-container']//*[contains(@class,'projectSearchFields')]//*[contains(@class,'form-horizontal')][xx]//*[@name and @type!='hidden']";
				String rowelement1and32_xapth		=	".//*[@id='panel-body-container']//*[contains(@class,'projectSearchFields')]//*[contains(@class,'form-horizontal')][xx]/div[yy]//*[@name and @type!='hidden']";

				String row2counter					=	".//*[@id='panel-body-container']//*[contains(@class,'projectSearchFields')]//*[contains(@class,'form-horizontal')][2]/div";
				String Companytextbox_xpath			=	".//*[@id='GetCompanyIdProject' and contains(@class,'span2')]";
				String Destination_xpath			=	".//*[@id='DestinationCountryCode' and contains(@class,'span2')]";
				String Processtype_xpath			=	".//*[@id='ProcessType' and contains(@class,'span2')]";
				String Status_xpath					=	".//*[@id='StatusProject' and contains(@name,'Status')]";

				String SearchBtn_xpath				=	".//*[@id='divSearchProject']//*[@id='btnSearchProject' and contains(@class,'blue-search')]";
				String Validationmsg_xpath			=	"//*[@id='page-message' and contains(@class,'alert')]";
				String validationmsg				=	"";
				String CheckRecordFoundorNot_xpath	=	".//*[@id='visacase-list-header']/tbody/tr[1]/td[1]";
				String RecordFound_xpath			=	".//*[@id='visacase-list-header']/tbody/tr[1]/td[2]/a";

				//xpaths for after search
				String sliderPanel_xpath			=	"//*[@class='slider-parent']//*[@id='profile-slider']//*[@id='slider-icon' and @class='initiated']";
				String matchBalNumber_xpath			=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[2]/td[2]";
				String matchDestination				=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[7]/td[2]";
				String matchProjectReference		=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[6]/td[2]";
				String matchRole					=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[5]/td[2]";
				String matchemail					=	"//*[@id='rnav-principal-contact-info' and @class='sidebarTable']//*[@href]";
				String matchCompany					=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[2]/td[4]";
				String matchName					=	"//*[@id='prg-hdr-main']//*[contains(@class,'header2')]";
				String matchStatus					=	".//*[@class='form-horizontal']//*[@id='prg-hdr-detail' and @class='table']/tbody/tr[1]/td[2]";
				String matchProjecttype				=	"//*[@id='panel-header']//*[@class='dvMaisnCaseNumber']";



				int numberOfAdvFieldCounter				=	0;
				int innerFieldCounter					=	0;
				String AttributeId						=	"";
				String newCounterXPath1					=	"";
				String GetTextForCheckRecordFoundorNot	=	"";
				String GetBalNumber						=	"";
				String GetDestination					=	"";
				String GetProjectReference				=	"";
				String GetRole							=	"";
				String GetEmail							=	"";
				String GetCompany						=	"";
				String GetName							=	"";
				String GetStatus						=	"";
				String GetProjecttype					=	"";
				boolean matchflag						=	false;


				//all variable(s) are assigned and our script start from here
				System.out.println("\n=========\nTestcase id is: "+TestcaseID+" with "+Scenario+" Scenario.\n=========\n");

				utilfunc.ErrorMessage1="";
				utilfunc.ErrorMessage2="";
				utilfunc.globalerrormessage="";
				utilfunc.ErrorMessage4="";
				utilfunc.ErrorMessage5="";


				//first of all click on more option link
				try {
					Thread.sleep(1500);
					utilfunc.MakeElement(MoreOption_xpath).click();
					Thread.sleep(1500);
					//get number of rows for search fields
					try{
						numberOfAdvFieldCounter		=		utilfunc.GetObjectCount(ProjectSearchCounter_xpath);
					}catch(Exception e){
						System.out.println("unable to get row count of \"Advanced Project Search\".");
					}

					// run only if number of records are present
					if(numberOfAdvFieldCounter>0){
						for (int j = 1; j <= numberOfAdvFieldCounter; j++) {
							Thread.sleep(800);
							String newCounterXPath="";
							AttributeId="";
							newCounterXPath1="";
							if(j==2)
							{
								int innerelementcountforrow2=utilfunc.GetObjectCount(row2counter);
								for(int k=1;k<=innerelementcountforrow2;k++)
								{
									if(k==1){newCounterXPath1=Companytextbox_xpath;}
									else if(k==2){newCounterXPath1=Destination_xpath;}
									else if(k==3){newCounterXPath1=Processtype_xpath;}
									else if(k==4){newCounterXPath1=Status_xpath;}

									try{
										AttributeId					=		utilfunc.MakeElement(newCounterXPath1).getAttribute("id");
										//System.out.println("AttributeId :"+AttributeId);
									}catch(Exception error){}
									//run only if attributeid is not blank... 
									if(!AttributeId.equals(""))
									{
										Thread.sleep(800);
										if(AttributeId.equalsIgnoreCase("GetCompanyIdProject"))
										{
											try{
												utilfunc.MakeElement(newCounterXPath1).clear();
												utilfunc.MakeElement(newCounterXPath1).sendKeys(Comapny);
												try {
													Thread.sleep(2000);
													utilfunc.MakeElement("//*[@class='ui-menu-item']/a").click();
												} catch (Exception e) {
													System.out.println("first record selected..");
												}
											}catch(Exception error){System.out.println("unable to set Company...");}
										}
										else if(AttributeId.equalsIgnoreCase("DestinationCountryCode"))
										{
											try{
												utilfunc.DeSelectdropdownvalue(newCounterXPath1);
												utilfunc.Selectdropdownvaluebytext(newCounterXPath1, Destination);
											}catch(Exception error){System.out.println("unable to set Destination...");}
										}
										else if(AttributeId.equalsIgnoreCase("ProcessType"))
										{
											try{
												utilfunc.DeSelectdropdownvalue(newCounterXPath1);
												utilfunc.Selectdropdownvaluebytext(newCounterXPath1, ProjectType);
											}catch(Exception error){System.out.println("unable to set Process Type...");}
										}
										else if(AttributeId.equalsIgnoreCase("StatusProject"))
										{
											try{
												utilfunc.DeSelectdropdownvalue(newCounterXPath1);
												utilfunc.Selectdropdownvaluebytext(newCounterXPath1, Status);
											}catch(Exception error){System.out.println("unable to set Status...");}
										}
									}


								}
							}//if(j==2) ends here
							else
							{
								newCounterXPath=rowelement1and3_xapth;
								newCounterXPath		=	newCounterXPath.replace("xx", Integer.toString(j));
								// now let us find out counter inside each row of counter..
								innerFieldCounter=0;
								innerFieldCounter=utilfunc.GetObjectCount(newCounterXPath);
								if(innerFieldCounter>=1)
								{
									for(int l=1;l<=innerFieldCounter;l++)
									{

										newCounterXPath1		=	rowelement1and32_xapth.replace("xx", Integer.toString(j));
										newCounterXPath1		=	newCounterXPath1.replace("yy", Integer.toString(l));	
										//try to get attribut ID
										try{
											AttributeId					=		utilfunc.MakeElement(newCounterXPath1).getAttribute("id");
											//	System.out.println("AttributeId :"+AttributeId);
										}catch(Exception error){}
										//run only if attributeid is not blank... 
										if(!AttributeId.equals(""))
										{
											//Thread.sleep(1000);
											if(AttributeId.equalsIgnoreCase("SearchTextProject"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(Name);
												}catch(Exception error){System.out.println("unable to set Name...");}
											}
											else if(AttributeId.equalsIgnoreCase("EmailProject"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(Email);
												}catch(Exception error){System.out.println("unable to set Email...");}
											}
											else if(AttributeId.equalsIgnoreCase("BalNumberProject"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(BalNumber);
												}catch(Exception error){System.out.println("unable to set Bal Number...");}
											}
											else if(AttributeId.equalsIgnoreCase("caseNumber"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(ProjectReference);
												}catch(Exception error){System.out.println("unable to set Project Reference...");}
											}
											else if(AttributeId.equalsIgnoreCase("GetAppRoleId"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(Role);
												}catch(Exception error){System.out.println("unable to set Role...");}
											}
											else if(AttributeId.equalsIgnoreCase("AppRolePerson"))
											{
												try{
													utilfunc.MakeElement(newCounterXPath1).clear();
													utilfunc.MakeElement(newCounterXPath1).sendKeys(Person);
												}catch(Exception error){System.out.println("unable to set Person...");}
											}
											else if(AttributeId.equalsIgnoreCase("AppRolePerson"))
											{
												try{
													if(Principalonly.equalsIgnoreCase("Yes")){
														utilfunc.enableOrDisableCheckbox(newCounterXPath1, true);
													}else{
														utilfunc.enableOrDisableCheckbox(newCounterXPath1,false);
													}
												}catch(Exception error){System.out.println("unable to set Principal only...");}
											}
											else if(AttributeId.equalsIgnoreCase("AppRolePerson"))
											{
												try{
													if(IncludeIndividual.equalsIgnoreCase("Yes")){
														utilfunc.enableOrDisableCheckbox(newCounterXPath1, true);
													}else{
														utilfunc.enableOrDisableCheckbox(newCounterXPath1,false);
													}
												}catch(Exception error){System.out.println("unable to set Include Individual...");}
											}//	else if(AttributeId.equalsIgnoreCase("AppRolePerson")) ends here
										}//if(!AttributeId.equals("")) ends here
									}//for(int l=1;l<=innerFieldCounter;l++) ends here
								}//if(innerFieldCounter>=1) ends here
							}//else ends here

						}//for loop for j ends here


						//click the search Button
						try{
							//System.out.println("We are going to click search button");
							Thread.sleep(900);
							utilfunc.MakeElement(SearchBtn_xpath).click();
							validationmsg=utilfunc.MakeElement(Validationmsg_xpath).getText();
							Thread.sleep(3000);
						}catch(Exception Error){System.out.println("Unable to click Search Button.");}

						if(validationmsg.equalsIgnoreCase(""))
						{
							//check record found or not
							try
							{
								GetTextForCheckRecordFoundorNot=utilfunc.MakeElement(CheckRecordFoundorNot_xpath).getText();
							}catch(Exception error){System.out.println("Unable to check rocord found or not.");}

							if((GetTextForCheckRecordFoundorNot.contains("No"))||(GetTextForCheckRecordFoundorNot.contains("no")))
							{ //Record not found
								//utilfunc.ErrorMessage4	=	GetTextForCheckRecordFoundorNot;
								utilfunc.TakeScreenshot();
								if(ExpectedErrorMessage!=null)
								{

									try{
										if((ExpectedErrorMessage.contains(GetTextForCheckRecordFoundorNot))||(ExpectedErrorMessage.equalsIgnoreCase(GetTextForCheckRecordFoundorNot)))

										{
											flag=true;
											utilfunc.ErrorMessage4=GetTextForCheckRecordFoundorNot;
											utilfunc.globalerrormessage=GetTextForCheckRecordFoundorNot;
										}
									}
									catch(Exception err){}
								}
								else
								{
									utilfunc.ErrorMessage4=GetTextForCheckRecordFoundorNot;
									utilfunc.globalerrormessage=GetTextForCheckRecordFoundorNot;
								}



								return flag;
							}
							else
							{ //Record Found

								try {
									System.out.println("we are going to click our searched record...");
									Thread.sleep(1000);
									try{
										utilfunc.MakeElement(RecordFound_xpath).click();
										Thread.sleep(3000);

										//Check for server error
										String error_flag="";
										try{
											System.out.println("We are done with error check....");
											error_flag=utilfunc.ErrorMessagehandlerExperiment();
											System.out.println("We are done with error check.");
										}
										catch(Exception e){}

										//System.out.println("error_flag---"+error_flag);
										if(error_flag.equals("Server Error in '/' Application.")){
											flag=false;
											utilfunc.TakeScreenshot();
											webdriver.navigate().back();
										}
										else{


											//now getthe values from form to match with current provided values....
											try{	GetName				=	utilfunc.MakeElement(matchName).getText();				}catch(Exception Error){	System.out.println("unable to get Name.");						}
											try{	GetBalNumber		=	utilfunc.MakeElement(matchBalNumber_xpath).getText();	}catch(Exception Error){	System.out.println("unable to get BalNumber.");					}								

											try{
												GetProjectReference	=	utilfunc.MakeElement(matchProjectReference).getText();	
												try{
													GetProjectReference		=	GetProjectReference.replace("#", "");
												}catch(Exception Error){
													System.out.println("Unable to remove # from Project Reference.");}
											}catch(Exception Error){
												System.out.println("unable to get Project Reference Number.");}

											try{	GetCompany			=	utilfunc.MakeElement(matchCompany).getText();			}catch(Exception Error){	System.out.println("unable to get Company.");					}								
											try{	GetDestination		=	utilfunc.MakeElement(matchDestination).getText();		}catch(Exception Error){	System.out.println("unable to get Destination.");				}								
											try{	GetProjecttype		=	utilfunc.MakeElement(matchProjecttype).getText();		}catch(Exception Error){	System.out.println("unable to get project type.");				}								
											try{	GetStatus			=	utilfunc.MakeElement(matchStatus).getText();			}catch(Exception Error){	System.out.println("unable to get project type.");				}								
											try{	GetRole				=	utilfunc.MakeElement(matchRole).getText();				}catch(Exception Error){	System.out.println("unable to get Role.");						}								
											//click the sliding panel to get the email.
											try{utilfunc.MakeElement(sliderPanel_xpath).click();
											Thread.sleep(2000);
											try{GetEmail		=	utilfunc.MakeElement(matchemail).getText();					}catch(Exception Error){	System.out.println("unable to get email.");						}
											utilfunc.MakeElement(sliderPanel_xpath).click();
											}catch(Exception error){System.out.println("Unable to click sliderPanel");}

											System.out.println("Name is :"+GetName);
											System.out.println("Bal Number is :"+GetBalNumber);
											System.out.println("Project Reference is :"+GetProjectReference);
											System.out.println("Company is :"+GetCompany);
											System.out.println("Destination is :"+GetDestination);
											System.out.println("Projecttype is :"+GetProjecttype);
											System.out.println("Status is :"+GetStatus);
											System.out.println("Role is :"+GetRole);
											System.out.println("Email is :"+GetEmail);

											//match the values

											//name
											if(StringUtils.isEmpty(Name)==false)
											{
												try{
													String[] namesplit = Name.split(",");
													for (int namearrcount = 0; namearrcount < namesplit.length; namearrcount++) 
													{
														if(Name.contains(namesplit[namearrcount].trim()))
														{
															matchflag=true;
															break;
														}
													}
												}catch(Exception error){}
											}
											//email
											if(StringUtils.isEmpty(Email)==false)
											{
												if(GetEmail.equalsIgnoreCase(Email))
												{matchflag=true;}
											}
											//balnumber
											if(StringUtils.isEmpty(BalNumber)==false)
											{
												if(GetBalNumber.equals(BalNumber))
												{
													matchflag=true;
												}
											}
											//Reference Type
											if(StringUtils.isEmpty(ProjectReference)==false)
											{
												if(GetProjectReference.equals(ProjectReference))
												{
													matchflag=true;
												}
											}
											//company
											if(StringUtils.isEmpty(Comapny)==false)
											{
												if(GetCompany.contains(Comapny))
												{matchflag=true;}
											}
											//Destination
											if(StringUtils.isEmpty(Destination)==false)
											{
												if(GetDestination.contains(Destination))
												{matchflag=true;}
											}
											//Project Type
											if(StringUtils.isEmpty(ProjectType)==false)
											{
												if(GetProjecttype.contains(ProjectType))
												{matchflag=true;}
											}
											//Status
											if(StringUtils.isEmpty(Status)==false)
											{
												if(GetStatus.equalsIgnoreCase("Initiated"))
												{
													GetStatus="Open";
												}
												if(GetStatus.equalsIgnoreCase(Status))
												{
													matchflag=true;
												}
											}
											//Role
											if(StringUtils.isEmpty(Role)==false)
											{
												String[] rolesplit = GetRole.split(",");
												for (int rolearrcount = 0; rolearrcount < rolesplit.length; rolearrcount++) {
													if(Name.contains(rolesplit[rolearrcount].trim()))
													{matchflag=true;break;}
												}
											}


											System.out.println("matchflag is :"+matchflag);
											if(matchflag==true)
											{
												flag=true;
											}
											else
											{
												utilfunc.TakeScreenshot();
												utilfunc.ErrorMessage4="Information not match!!!";
												utilfunc.globalerrormessage=ExpectedErrorMessage;
											}
										}

									}catch(Exception error){System.out.println(error);}



								} catch (Exception e) {System.out.println("unable to click on founded record.");}
							}
						}
						else
						{
							utilfunc.TakeScreenshot();
							if(validationmsg.contains(ExpectedErrorMessage))
							{
								flag=true;
								utilfunc.ErrorMessage4=validationmsg;
								utilfunc.globalerrormessage=validationmsg;
							}
							else
							{
								utilfunc.ErrorMessage4=validationmsg;
								utilfunc.globalerrormessage=validationmsg;
							}
						}



					}//	if(numberOfAdvFieldCounter>0) ends here
				} catch (Exception e) {
					System.out.println("Unable to click on more button..");
				}



			}//if(mode.equalsIgnoreCase("New")) ends here

		}//if(TestcaseRunMode.equals("Y")) ends here


		return flag;
	}
}
