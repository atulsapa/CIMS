package CIMS.Modules.Regression;

import java.awt.AWTException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Project_Summary {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description	=	null;

	public CIMS_Project_Summary(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}



	public boolean Project_Summary(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException
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


//
//				int numberOfAdvFieldCounter				=	0;
//				int innerFieldCounter					=	0;
//				String AttributeId						=	"";
//				String newCounterXPath1					=	"";
//				String GetTextForCheckRecordFoundorNot	=	"";
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
								
									try{
										
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
										

									}catch(Exception error){System.out.println(error);}



								
							
						
						



					//	if(numberOfAdvFieldCounter>0) ends here
				



			}//if(mode.equalsIgnoreCase("New")) ends here

		}//if(TestcaseRunMode.equals("Y")) ends here


		return flag;
	}


}
