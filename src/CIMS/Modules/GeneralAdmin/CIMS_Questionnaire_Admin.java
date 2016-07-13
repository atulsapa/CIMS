package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Questionnaire_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Questionnaire_Admin(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Questionnaire_Admin(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module.....");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String GetCompanyId                                 =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Title                                        =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String DisplayedTitle                               =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String TargetRoleType                               =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String IsActive                                     =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String IsTemplate                                   =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String SectionTypeId                                =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String CategoryId                                   =           UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			String ClassificationId                             =           UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String AddNewQuestionnaireAdminBtnXpath  =".//a[contains(@class,'btn') and contains(text(),'Add New Questionnaire Admin')]";
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@type='hidden')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				//String AutoSuggestionXpath =".//*[@id='ui-id-1']//li[1]/a";
			    String  AddSectionBtnXpath = "//*[@id='form1']//*[contains(@class,'control-group')]//*[contains(@class,'btn') and text()='Add Section']";
			    String  AddClassificationIdNewBtnXpath = "//*[@id='form1']//*[contains(@class,'control-group')]//*[contains(@class,'btn') and text()='Assign to Category/Classification']";
			    String NewXpath;
			    String AttributeName;

				if(mode.equals("New")){
					
					
					try {
						utilfunc.MakeElement(AddNewQuestionnaireAdminBtnXpath).click();
					} catch (Exception e) {
						System.out.println("===Unable to click on the Add new Resources Type button===");
					}
				
				    int resultcount= utilfunc.GetObjectCount(FormFieldsCounterXpath);
				    
				    for(int i=1; i<resultcount; i++){
				    	
				    	NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
				    	//String AddBtnXpath = AddSectionBtnXpath.replace("pp", Integer.toString(i));
				    	
				    	AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
				    	
				    	System.out.println("New Xpath" + " "+ NewXpath);
				    	System.out.println("AttributeName"+" " + AttributeName);
				    	
				    	if(AttributeName.equals("CountryCode")){
				    		
				    		try {
				    			Thread.sleep(500);
								utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    	
				    	}else if(AttributeName.equals("GetCompanyId")){
				    		utilfunc.MakeElement(NewXpath+"[1]").clear();
				    		Thread.sleep(500);
				    		try {
								utilfunc.MakeElement(NewXpath+"[1]").sendKeys(GetCompanyId);
							} catch (Exception e1) {}
				    		try {
								Thread.sleep(3000);
								utilfunc.selectFirstResultFromAutoSuggestion(NewXpath+"[1]");
								Thread.sleep(8000);
							} catch (Exception e) {}
				    	
				    	}else if(AttributeName.equals("Title")){
				    		
				    		utilfunc.MakeElement(NewXpath).clear();
				    		
				    		try {
								utilfunc.MakeElement(NewXpath).sendKeys(Title);
							} catch (Exception e) {}
				    		
				    	}else if(AttributeName.equals("DisplayedTitle")){
				    		
				    		utilfunc.MakeElement(NewXpath).clear();
				    		
				    		try {
								utilfunc.MakeElement(NewXpath).sendKeys(DisplayedTitle);
							} catch (Exception e) {}
				    		
				    	}else if(AttributeName.equals("TargetRoleType")){
				    		
				    		try {
								utilfunc.Selectdropdownvaluebytext(NewXpath, TargetRoleType);
							} catch (Exception e) {}
				    	
				    	}else if(AttributeName.equals("IsActive")){
				    		
				    		try {
								if(IsActive.equalsIgnoreCase("Yes")){
									
									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
									
								}else{
									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
								}
							} catch (Exception e) {}
				    	}else if(AttributeName.equals("IsTemplate")){
				    		
				    		try {
				    			Thread.sleep(1500);
								if(IsTemplate.equalsIgnoreCase("Yes")){
									
									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
									
								}else{
									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
								}
							} catch (Exception e) {}
				    	}else if(AttributeName.equals("SectionTypeId")){
				    		
				    		String SectionTypeIdXpath   ="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li[yy]//.[text()]";
				    		String SectionTypeIdCounterXpath="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li";
				    		
				    		int SectionTypeIdCount= utilfunc.GetObjectCount(SectionTypeIdCounterXpath);
				    		
				    		for(int x=1; x<=SectionTypeIdCount; x++){
				    			Thread.sleep(1000);
				    		   
				    			String linkXpath= SectionTypeIdXpath.replace("yy", Integer.toString(x));
				    			
				    			System.out.println("linkXpath" + linkXpath);
				    			
				    			try {
				    				Thread.sleep(500);
									utilfunc.MakeElement(linkXpath).click();
								} catch (Exception e1) {}
				    			
				    			String QuestionnaireNewXpath="//*[@id='form1']//*[@class='control-group'][8]//select//.[@name and not(@type='hidden')]";
								//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
								if(StringUtils.isEmpty(SectionTypeId)==false){
									String[] split = SectionTypeId.split(",");
									System.out.println(split.length);
									for (int Section_TypeId = 0; Section_TypeId < split.length; Section_TypeId++) {
										//System.out.println(doc_NewXpath);
										System.out.println(split[Section_TypeId].trim()+"---");
										Thread.sleep(400);
										try {
											utilfunc.Selectdropdownvaluebytext(QuestionnaireNewXpath,split[Section_TypeId].trim());
										} catch (Exception e) {
											
										}
										try {
											utilfunc.MakeElement(AddSectionBtnXpath).click();
										} catch (Exception e) {
											System.out.println(e);
											
										}
									}
								}
				    			
				    		
				    			
				    		}
				    		
				    		
				    	
				    		
				    	}else if(AttributeName.equals("CategoryId")){
				    		
				    		try {
				    			Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, CategoryId);
							} catch (Exception e1) {}
				    		
				    		String ClassificationIdNewXpath="//*[@id='form1']//*[@class='control-group'][9]//select//.[@name='ClassificationId']";
							//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
							if(StringUtils.isEmpty(ClassificationId)==false){
								String[] split = ClassificationId.split(",");
								System.out.println(split.length);
								for (int Classification_Id = 0; Classification_Id < split.length; Classification_Id++) {
									//System.out.println(doc_NewXpath);
									System.out.println(split[Classification_Id].trim()+"---");
									Thread.sleep(400);
									try {
										utilfunc.Selectdropdownvaluebytext(ClassificationIdNewXpath,split[Classification_Id].trim());
									} catch (Exception e) {
										
									}
									try {
										utilfunc.MakeElement(AddClassificationIdNewBtnXpath).click();
									} catch (Exception e) {
										
									}
								}
							}
				    		
				    		
				    		
				    		
				    	}else{
				    		System.out.println("==Please fill all the mandatory fields.==");
				    	}
				  
				    }
				}
				
				if(mode.equals("Edit")){
					
					String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='NewCountryCode']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
					String EditlinkXpath=".//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//*[contains(@class,'dropdown-menu pull-right')]//li[1]//.[text()='Edit']";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
					 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
	            		   utilfunc.scrollToTop();
	            		   
	            		   try {
	            			   Thread.sleep(1000);
							utilfunc.MakeElement(EditIconXpath).click();
							Thread.sleep(4000);
							utilfunc.MakeElement(EditlinkXpath).click();
							Thread.sleep(4000);
						} catch (Exception e) {}
	            	   }   
	            		   Thread.sleep(1000);
	            		   
	            		   int resultcount= utilfunc.GetObjectCount(FormFieldsCounterXpath);
	   				    
	   				    for(int i=1; i<resultcount; i++){
	   				    	
	   				    	NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
	   				    	//String AddBtnXpath = AddSectionBtnXpath.replace("pp", Integer.toString(i));
	   				    	
	   				    	AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
	   				    	
	   				    	System.out.println("New Xpath" + " "+ NewXpath);
	   				    	System.out.println("AttributeName"+" " + AttributeName);
	   				    	
	   				    	if(AttributeName.equals("CountryCode")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(500);
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
	   							} catch (Exception e) {
	   								// TODO Auto-generated catch block
	   								e.printStackTrace();
	   							}
	   				    	
	   				    	}else if(AttributeName.equals("GetCompanyId")){
	   				    		utilfunc.MakeElement(NewXpath+"[1]").clear();
	   				    		Thread.sleep(500);
	   				    		try {
	   								utilfunc.MakeElement(NewXpath+"[1]").sendKeys(GetCompanyId);
	   							} catch (Exception e1) {}
	   				    		try {
	   								Thread.sleep(3000);
	   								utilfunc.selectFirstResultFromAutoSuggestion(NewXpath+"[1]");
	   								Thread.sleep(8000);
	   							} catch (Exception e) {}
	   				    	
	   				    	}else if(AttributeName.equals("Title")){
	   				    		
	   				    		//utilfunc.MakeElement(NewXpath).clear();
	   				    		
	   				    		try {
	   								utilfunc.MakeElement(NewXpath).sendKeys(Title);
	   							} catch (Exception e) {}
	   				    		
	   				    	}else if(AttributeName.equals("DisplayedTitle")){
	   				    		
	   				    		utilfunc.MakeElement(NewXpath).clear();
	   				    		
	   				    		try {
	   								utilfunc.MakeElement(NewXpath).sendKeys(DisplayedTitle);
	   							} catch (Exception e) {}
	   				    		
	   				    	}else if(AttributeName.equals("TargetRoleType")){
	   				    		
	   				    		try {
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, TargetRoleType);
	   							} catch (Exception e) {}
	   				    	
	   				    	}else if(AttributeName.equals("IsActive")){
	   				    		
	   				    		try {
	   								if(IsActive.equalsIgnoreCase("Yes")){
	   									
	   									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
	   									
	   								}else{
	   									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
	   								}
	   							} catch (Exception e) {}
	   				    	}else if(AttributeName.equals("IsTemplate")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(1500);
	   								if(IsTemplate.equalsIgnoreCase("Yes")){
	   									
	   									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
	   									
	   								}else{
	   									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
	   								}
	   							} catch (Exception e) {}
	   				    	}else if(AttributeName.equals("SectionTypeId")){
	   				    		
	   				    		String SectionTypeIdXpath   ="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li[yy]//.[text()]";
	   				    		String SectionTypeIdCounterXpath="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li";
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		int SectionTypeIdCount= utilfunc.GetObjectCount(SectionTypeIdCounterXpath);
	   				    		
	   				    		for(int x=1; x<=SectionTypeIdCount; x++){
	   				    			Thread.sleep(1000);
	   				    		   
	   				    			String linkXpath= SectionTypeIdXpath.replace("yy", Integer.toString(x));
	   				    			
	   				    			System.out.println("linkXpath" + linkXpath);
	   				    			
	   				    			try {
	   				    				Thread.sleep(500);
	   									utilfunc.MakeElement(linkXpath).click();
	   								} catch (Exception e1) {}
	   				    			
	   				    			
	   				    			String del_Ques_Xpath="//*[@id='table_section']//tr//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
									int del_Ques_type=utilfunc.GetObjectCount(del_Ques_Xpath);
									//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
									if (del_Ques_type>=1){//if added doc type is more then one then we have to delete them...
										for(int d=1;d<=del_Ques_type;d++){
											Thread.sleep(1000);
											
											del_Ques_Xpath="//*[@id='table_section']//tr[2]//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(del_Ques_Xpath).click();
											} catch (Exception e) {}
											utilfunc.isAlertPresent();
										}
									}
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			String QuestionnaireNewXpath="//*[@id='form1']//*[@class='control-group'][8]//select//.[@name and not(@type='hidden')]";
	   								//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
	   								if(StringUtils.isEmpty(SectionTypeId)==false){
	   									String[] split = SectionTypeId.split(",");
	   									System.out.println(split.length);
	   									for (int Section_TypeId = 0; Section_TypeId < split.length; Section_TypeId++) {
	   										//System.out.println(doc_NewXpath);
	   										System.out.println(split[Section_TypeId].trim()+"---");
	   										Thread.sleep(400);
	   										try {
	   											utilfunc.Selectdropdownvaluebytext(QuestionnaireNewXpath,split[Section_TypeId].trim());
	   										} catch (Exception e) {
	   											
	   										}
	   										try {
	   											utilfunc.MakeElement(AddSectionBtnXpath).click();
	   										} catch (Exception e) {
	   											System.out.println(e);
	   											
	   										}
	   									}
	   								}
	   				    			
	   				    		
	   				    			
	   				    		}
	   				    		
	   				    		
	   				    	
	   				    		
	   				    	}else if(AttributeName.equals("CategoryId")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(1000);
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, CategoryId);
	   							} catch (Exception e1) {}
	   				    		
	   				    		Thread.sleep(1000);
								String del_Cmp_Xpath="//*[@id='table_xref']//tr//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
								int del_Company_type=utilfunc.GetObjectCount(del_Cmp_Xpath);
								//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
								if (del_Company_type>=1){//if added doc type is more then one then we have to delete them...
									for(int d=1;d<=del_Company_type;d++){
										Thread.sleep(1500);
										
										del_Cmp_Xpath="//*[@id='table_xref']//tr[2]//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
										Thread.sleep(1000);
										utilfunc.MakeElement(del_Cmp_Xpath).click();
										Thread.sleep(1000);
										utilfunc.isAlertPresent();
									}
								}
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		String ClassificationIdNewXpath="//*[@id='form1']//*[@class='control-group'][9]//select//.[@name='ClassificationId']";
	   							//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
	   							if(StringUtils.isEmpty(ClassificationId)==false){
	   								String[] split = ClassificationId.split(",");
	   								System.out.println(split.length);
	   								for (int Classification_Id = 0; Classification_Id < split.length; Classification_Id++) {
	   									//System.out.println(doc_NewXpath);
	   									System.out.println(split[Classification_Id].trim()+"---");
	   									Thread.sleep(1500);
	   									try {
	   										Thread.sleep(1500);
	   										utilfunc.Selectdropdownvaluebytext(ClassificationIdNewXpath,split[Classification_Id].trim());
	   									} catch (Exception e) {
	   										
	   									}
	   									try {
	   										Thread.sleep(1500);
	   										utilfunc.MakeElement(AddClassificationIdNewBtnXpath).click();
	   									} catch (Exception e) {
	   										
	   									}
	   								}
	   							}
	   				    		
	   				    		
	   				    		
	   				    		
	   				    	}else{
	   				    		System.out.println("==Please fill all the mandatory fields.==");
	   				    	}
	   				  
	   				    }
		            
					
					
	            	   
	           }
				if(mode.equals("Copy")){

					
					String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='NewCountryCode']";
					String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
					String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
					String CopylinkXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//*[contains(@class,'dropdown-menu pull-right')]//li[2]//.[contains(text(),'Copy')]";
					
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
					 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
	            		   utilfunc.scrollToTop();
	            		   
	            		   try {
	            			   Thread.sleep(1000);
							utilfunc.MakeElement(EditIconXpath).click();
							Thread.sleep(4000);
							utilfunc.MakeElement(CopylinkXpath).click();
							Thread.sleep(4000);
						} catch (Exception e) {}
	            	   }   
	            		   Thread.sleep(1000);
	            		   
	            		   int resultcount= utilfunc.GetObjectCount(FormFieldsCounterXpath);
	   				    
	   				    for(int i=1; i<resultcount; i++){
	   				    	
	   				    	NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
	   				    	//String AddBtnXpath = AddSectionBtnXpath.replace("pp", Integer.toString(i));
	   				    	
	   				    	AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
	   				    	
	   				    	System.out.println("New Xpath" + " "+ NewXpath);
	   				    	System.out.println("AttributeName"+" " + AttributeName);
	   				    	
	   				    	if(AttributeName.equals("CountryCode")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(500);
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
	   							} catch (Exception e) {
	   								// TODO Auto-generated catch block
	   								e.printStackTrace();
	   							}
	   				    	
	   				    	}else if(AttributeName.equals("GetCompanyId")){
	   				    		utilfunc.MakeElement(NewXpath+"[1]").clear();
	   				    		Thread.sleep(500);
	   				    		try {
	   								utilfunc.MakeElement(NewXpath+"[1]").sendKeys(GetCompanyId);
	   							} catch (Exception e1) {}
	   				    		try {
	   								Thread.sleep(3000);
	   								utilfunc.selectFirstResultFromAutoSuggestion(NewXpath+"[1]");
	   								Thread.sleep(8000);
	   							} catch (Exception e) {}
	   				    	
	   				    	}else if(AttributeName.equals("Title")){
	   				    		
	   				    		//utilfunc.MakeElement(NewXpath).clear();
	   				    		
	   				    		try {
	   								utilfunc.MakeElement(NewXpath).sendKeys(Title);
	   							} catch (Exception e) {}
	   				    		
	   				    	}else if(AttributeName.equals("DisplayedTitle")){
	   				    		
	   				    		utilfunc.MakeElement(NewXpath).clear();
	   				    		
	   				    		try {
	   								utilfunc.MakeElement(NewXpath).sendKeys(DisplayedTitle);
	   							} catch (Exception e) {}
	   				    		
	   				    	}else if(AttributeName.equals("TargetRoleType")){
	   				    		
	   				    		try {
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, TargetRoleType);
	   							} catch (Exception e) {}
	   				    	
	   				    	}else if(AttributeName.equals("IsActive")){
	   				    		
	   				    		try {
	   								if(IsActive.equalsIgnoreCase("Yes")){
	   									
	   									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
	   									
	   								}else{
	   									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
	   								}
	   							} catch (Exception e) {}
	   				    	}else if(AttributeName.equals("IsTemplate")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(1500);
	   								if(IsTemplate.equalsIgnoreCase("Yes")){
	   									
	   									utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
	   									
	   								}else{
	   									utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
	   								}
	   							} catch (Exception e) {}
	   				    	}else if(AttributeName.equals("SectionTypeId")){
	   				    		
	   				    		String SectionTypeIdXpath   ="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li[yy]//.[text()]";
	   				    		String SectionTypeIdCounterXpath="//*[@id='form1']//*[@class='control-group'][8]//.[@class='nav nav-tabs']//li";
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		int SectionTypeIdCount= utilfunc.GetObjectCount(SectionTypeIdCounterXpath);
	   				    		
	   				    		for(int x=1; x<=SectionTypeIdCount; x++){
	   				    			Thread.sleep(1000);
	   				    		   
	   				    			String linkXpath= SectionTypeIdXpath.replace("yy", Integer.toString(x));
	   				    			
	   				    			System.out.println("linkXpath" + linkXpath);
	   				    			
	   				    			try {
	   				    				Thread.sleep(500);
	   									utilfunc.MakeElement(linkXpath).click();
	   								} catch (Exception e1) {}
	   				    			
	   				    			
	   				    			String del_Ques_Xpath="//*[@id='table_section']//tr//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
									int del_Ques_type=utilfunc.GetObjectCount(del_Ques_Xpath);
									//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
									if (del_Ques_type>=1){//if added doc type is more then one then we have to delete them...
										for(int d=1;d<=del_Ques_type;d++){
											Thread.sleep(1000);
											
											del_Ques_Xpath="//*[@id='table_section']//tr[2]//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
											try {
												Thread.sleep(1000);
												utilfunc.MakeElement(del_Ques_Xpath).click();
											} catch (Exception e) {}
											utilfunc.isAlertPresent();
										}
									}
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			
	   				    			String QuestionnaireNewXpath="//*[@id='form1']//*[@class='control-group'][8]//select//.[@name and not(@type='hidden')]";
	   								//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
	   								if(StringUtils.isEmpty(SectionTypeId)==false){
	   									String[] split = SectionTypeId.split(",");
	   									System.out.println(split.length);
	   									for (int Section_TypeId = 0; Section_TypeId < split.length; Section_TypeId++) {
	   										//System.out.println(doc_NewXpath);
	   										System.out.println(split[Section_TypeId].trim()+"---");
	   										Thread.sleep(400);
	   										try {
	   											utilfunc.Selectdropdownvaluebytext(QuestionnaireNewXpath,split[Section_TypeId].trim());
	   										} catch (Exception e) {
	   											
	   										}
	   										try {
	   											utilfunc.MakeElement(AddSectionBtnXpath).click();
	   										} catch (Exception e) {
	   											System.out.println(e);
	   											
	   										}
	   									}
	   								}
	   				    			
	   				    		
	   				    			
	   				    		}
	   				    		
	   				    		
	   				    	
	   				    		
	   				    	}else if(AttributeName.equals("CategoryId")){
	   				    		
	   				    		try {
	   				    			Thread.sleep(1000);
	   								utilfunc.Selectdropdownvaluebytext(NewXpath, CategoryId);
	   							} catch (Exception e1) {}
	   				    		
	   				    		Thread.sleep(1000);
								String del_Cmp_Xpath="//*[@id='table_xref']//tr//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
								int del_Company_type=utilfunc.GetObjectCount(del_Cmp_Xpath);
								//System.out.println("We have to delete "+del_Doc_type+" records here before updaing now values here.");
								if (del_Company_type>=1){//if added doc type is more then one then we have to delete them...
									for(int d=1;d<=del_Company_type;d++){
										Thread.sleep(1500);
										
										del_Cmp_Xpath="//*[@id='table_xref']//tr[2]//*[contains(@class,'lbl-del')]//*[contains(@class,'icon-trash')]";
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(del_Cmp_Xpath).click();
											Thread.sleep(1000);
										} catch (Exception e) {}
										utilfunc.isAlertPresent();
									}
								}
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		
	   				    		String ClassificationIdNewXpath="//*[@id='form1']//*[@class='control-group'][9]//select//.[@name='ClassificationId']";
	   							//Country_CodeNewXpath=Country_CodeNewXpath.replace("aa", Integer.toString(i));
	   							if(StringUtils.isEmpty(ClassificationId)==false){
	   								String[] split = ClassificationId.split(",");
	   								System.out.println(split.length);
	   								for (int Classification_Id = 0; Classification_Id < split.length; Classification_Id++) {
	   									//System.out.println(doc_NewXpath);
	   									System.out.println(split[Classification_Id].trim()+"---");
	   									Thread.sleep(1500);
	   									try {
	   										Thread.sleep(1500);
	   										utilfunc.Selectdropdownvaluebytext(ClassificationIdNewXpath,split[Classification_Id].trim());
	   									} catch (Exception e) {
	   										
	   									}
	   									try {
	   										Thread.sleep(1500);
	   										utilfunc.MakeElement(AddClassificationIdNewBtnXpath).click();
	   									} catch (Exception e) {
	   										
	   									}
	   								}
	   							}
	   				    		
	   				    		
	   				    		
	   				    		
	   				    	}else{
	   				    		System.out.println("==Please fill all the mandatory fields.==");
	   				    	}
	   				  
	   				    }
		         }
				
				
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
				    Thread.sleep(1000);
		        	utilfunc.MakeElement(saveBtn).click();
		        	Thread.sleep(2000);
				}catch(Exception e){}
//				try {
//					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
//					utilfunc.MakeElement(updateBtnXpath).click();
//				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessageHandlerofGEN();
					//ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.equals("")){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if(error_flag.equals("Server Error in '/' Application.")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else if(error_flag.contains("Error! Title is duplicated.")){
							Flag=false;
							utilfunc.TakeScreenshot();
							webdriver.navigate().back();
						}
					 
					 else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
				}catch(Exception e){
					Flag	=	false;
					utilfunc.TakeScreenshot();
					System.out.println("Data is not saved because all fields are not set in the form.");
					
			}	
				
			}

			
			return Flag;
	}
}
