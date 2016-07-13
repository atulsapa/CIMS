package CIMS.Modules.Questionnaires;

import listner.ErrorUtil;
import util.UtilFunction;

public class test_bkp {/*
	

	if(TabName.equals("Organization_Info")){

		/**
		 *  
		 * start with form organization info..
		 */

/*
		for(int count=1; count<=rowCount1; count++)
		{

			System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

					try{								

						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

							if(ActionName.equalsIgnoreCase("New")){
			    				// click on add new button to add new company
			    	        	String newBtn	=	".//a[contains(@class,'btn') and text()='Add New']";
			    	        	utilfunc.MakeElement(newBtn).click();
		    				}else{

		    					System.out.println("We are now on create a new company page");
								 // visit company page first by searching it from the record
								 companyName = UtilFunction.getCellData(fileName, TabName, columnNumber_CompanyName, count);

								 
		    				}

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module

										 try{

												boolean OrganizationInfoPage_flag=obj_CIMS_Organization_Info.Add_Organization_Info(count,ActionName);
												if(OrganizationInfoPage_flag==true){
													System.out.println("add company code executed successfully!");
												}
												else{
													System.out.println("some error occured while adding a company.");
												}
										 }catch(Exception e){
											 System.out.println("error occured during filling the general info form.");
										 }

							}else{
								System.out.println("unable to find company in search list for entity module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
			 }
		 }
	}
	else if(TabName.equals("GeneralInfo")){
		if(ActionName.equals("New")){
			/**
			 * Find next link and add general info
			 

			String NextButtonXPath	=	"//a[contains(text(),'Next')]";
			String URLCompare	=	utilfunc.MakeElement(NextButtonXPath).getAttribute("href");

			if(URLCompare.contains("GeneralInfo")){
				utilfunc.MakeElement(NextButtonXPath).click();
	        	System.out.println("Now you may add general info");
			}
		}
		else if(ActionName.equals("Edit")){

        	System.out.println("Now you may update general info");
//        	goToCompanyModuleByName("General Info");

        	for(int count=1; count<=rowCount1; count++)
			{
        		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
				// if found that we have to add new company's organization tab data then call add organization info function..
				 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

					 try{

							if(visitCompanyMenu==true){

								System.out.println("user has clicked on company page successfully!");

							 // visit company page first by searching it from the record
							 

							 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

							 if(VisitCompanyPage_flag==true){

									System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

									 // visit the module
									 VisitModule_flag	= goToCompanyModuleByName("General Info");

									 if(VisitCompanyPage_flag==true){
			            	        	try{
		
			            	        		boolean GeneralInfoPage_flag	=	obj_CIMS_Company_General_Info.Add_General_Info(count,ActionName);
											if(GeneralInfoPage_flag	==	true){
												System.out.println("add general info code executed successfully!");
											}
											else{
												System.out.println("some error occured while adding general info of company.");
											}
										 }catch(Exception e){
											 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
										 }
									 }else{
										 System.out.println("Unable to visit general info module of "+companyName+" ");
									 }
		
								}else{
									System.out.println("unable to find company in search list for entity module");
								}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
				 }
			}

		}

	}
	else if(TabName.equals("Service")){

		System.out.println("User is about to add or update subscribed services.");
//		goToCompanyModuleByName("Subscribed Services");
//    	webdriver.get("http://cobaltqa.daxima.com/Company/271/Service");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{

						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

						 // visit company page first by searching it from the record
						 

						 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module
								 VisitModule_flag	= goToCompanyModuleByName("Subscribed Services");

								 if(VisitCompanyPage_flag==true){
		            	        	try{
		
		            	        		boolean SubscribedServicePage_flag	=	obj_CIMS_Company_Subscribed_Services.Add_Subscribed_Services(count,ActionName);
										if(SubscribedServicePage_flag	==	true){
											System.out.println("Subscribed services add or update code executed successfully!");
										}
										else{
											System.out.println("unale to visit subscribed services module of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit subscribed services module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for entity module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
			 }
		}
	}
	else if(TabName.equals("Notes")){

		System.out.println("User is about to add or update Notes");


    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

    				try{
						
						if(visitCompanyMenu==true){
							System.out.println("user has clicked on company page successfully!");
							
							 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");
							 if(VisitCompanyPage_flag==true){
								 System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");
								 VisitModule_flag	=	goToCompanyModuleByName("Notes");
								 if(VisitModule_flag==true){
				 
		            	        	try{
		
		            	        		boolean NotesPage_flag	=	obj_CIMS_Company_Notes.Company_Notes(count,ActionName);
										if(NotesPage_flag	==	true){
											System.out.println("Notes add or update code executed successfully!");
										}
										else{
											System.out.println("some error occured while adding notes of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit entity module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for entity module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
			 }
		}
	}
	else if(TabName.equals("Entity")){

		System.out.println("User is about to add or update Entity");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				try{

					if(visitCompanyMenu==true){
						System.out.println("user has clicked on company page successfully!");
				 
					 // visit company page first by searching it from the record
					 

					 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

					 if(VisitCompanyPage_flag==true){

							System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

							 // visit the module
							 VisitModule_flag	= goToCompanyModuleByName("Entity");
							 if(VisitModule_flag==true){
	            	        	try{

	            	        		boolean EntityPage_flag	=	obj_CIMS_Company_Entity.Company_Entity(count,ActionName);

									if(EntityPage_flag	==	true){
										System.out.println("Notes add or update code executed successfully!");
									}
									else{
										System.out.println("some error occured while adding notes of company.");
									}
								 }catch(Exception e){
									 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
								 }
							 }else{
								 System.out.println("Unable to visit entity module of "+companyName+" ");
							 }

						}else{
							System.out.println("unable to find company in search list for entity module");
						}
						}
					}catch(Exception a){
						System.out.println("unable to visit company page");
					}
			 }
		}
	}
	
	else if(TabName.equals("CountryList")){

		System.out.println("User is about to add or update Country List");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{
	
						if(visitCompanyMenu==true){
							System.out.println("user has clicked on company page successfully!");

						 // visit company page first by searching it from the record
						 

						 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module
								 VisitModule_flag	= goToCompanyModuleByName("Origin/Destination Countries");
								 if(VisitCompanyPage_flag==true){
		            	        	try{
		
		            	        		boolean CountryPage_flag	=	obj_CIMS_Company_CountryList.Add_Country(count,ActionName);
		
										if(CountryPage_flag	==	true){
											System.out.println("Country List add or update code executed successfully!");
										}
										else{
											System.out.println("some error occured while adding notes of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit origin/destination module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for entity module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
						 
			 }
		}
	}
	
	
	else if(TabName.equals("Client Communication Protocol")){

		System.out.println("User is about to add or update "+TabName);

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{
						

						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

							 // visit company page first by searching it from the record
							 

							 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

							 if(VisitCompanyPage_flag==true){

									System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

									 // visit the module
									 VisitModule_flag	= goToCompanyModuleByName("Client Communication Protocol");

									 if(VisitCompanyPage_flag==true){

			            	        	try{

			            					////TIMER START///////
			            					long startTime = System.currentTimeMillis();

			            	        		boolean CommunicationPage_flag	=	obj_CIMS_Company_Communication.Communication(fileName, TabName,count,ActionName);

			            	        		///////TIMER END/////////////
			            					long endTime = System.currentTimeMillis();
			            					float seconds = (endTime - startTime) / 1000F;
			            					System.out.println();
			            					System.out.println("Test total run time = "+Float.toString(seconds) + " seconds");
			            					timer=Float.toString(seconds);
			            					System.out.println();
			            					
			            					if(obj_CIMS_Company_Communication.URLwithID.equals("")){
												
				            						status="PASS";
				            						String Errormessage=""+TabName+" Module is not working fine ";
				            						System.out.println(Errormessage);
				            						utilfunc.TestngReportFail(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, Errormessage);
				            												
		            						}else{
			            						if (CommunicationPage_flag){

			            							status="PASS";

				            						if(utilfunc.globalerrormessage.equals("")|utilfunc.globalerrormessage.contains("Success!")){
				            							utilfunc.TestngReportPass(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status);
				            						}else{
				            							utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
				            						}
			            							System.out.println("User is Sucessfully Saved the Health_Insurance Information");
			            												
			            						}
			            						else{
				            						status="FAIL";
				            						utilfunc.TestngReportFail1(obj_CIMS_Company_Communication.testcaseid, utilfunc.Actualbrw, obj_CIMS_Company_Communication.scenerio,ActionName, obj_CIMS_Company_Communication.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
				            						System.out.println("User is Getting an Error Message while saveing the Information");
				            						utilfunc.TakeScreenshot();
			            						}
		            						}
			            					
											if(CommunicationPage_flag	==	true){
												System.out.println("Communication protocol add or update code executed successfully!");
											}
											else{
												System.out.println("some error occured while working on communication protocol of company.");
											}
										 }catch(Exception e){

											 	ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
												System.out.println("Script Failed");
												utilfunc.assertion();			
												utilfunc.TakeScreenshot();
//											 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
										 }
									 }else{
										 System.out.println("Unable to visit communication protocol module of "+companyName+" ");
									 }

								}else{
									System.out.println("unable to find company in search list for communication protocol module");
								}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
						 
			 }
		}
	}
	
	else if(TabName.equals("RoleAssignment")){

		System.out.println("User is about to add or update Role Assignment");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{
	
						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

						 // visit company page first by searching it from the record
						 

						 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module
								 VisitModule_flag	= goToCompanyModuleByName("Roles Assignment");
								 if(VisitCompanyPage_flag==true){
		            	        	try{
		
		            	        		boolean RoleAssignmentPage_flag	=	obj_CIMS_Company_RoleAssignment.RoleAssignment(count,ActionName);
		
										if(RoleAssignmentPage_flag	==	true){
											System.out.println("Roles Assignment add or update code executed successfully!");
										}
										else{
											System.out.println("some error occured while working on Roles Assignment of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit Roles Assignment module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for Roles Assignment module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}
						 
			 }
		}
	}
	
	else if(TabName.equals("CompanyBatchRecruitment")){

		System.out.println("User is about to add or update Company Batch Recruitment");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{
	
						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

						 // visit company page first by searching it from the record
						 

						 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module
								 VisitModule_flag	= goToCompanyModuleByName("Batch Recruitment");

								 if(VisitCompanyPage_flag==true){
		            	        	try{

		            	        		boolean CompanyBatchRecruitmentPage_flag	=	obj_CIMS_Company_CompanyBatchRecruitment.BatchRecruitment(count,ActionName);

										if(CompanyBatchRecruitmentPage_flag	==	true){
											System.out.println("Company Batch Recruitment add or update code executed successfully!");
										}
										else{
											System.out.println("some error occured while working on Company Batch Recruitment of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit Company Batch Recruitment module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for Company Batch Recruitment module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}

			 }
		}
	}
	
	else if(TabName.equals("VisaProfile")){

		System.out.println("User is about to add or update Company Visa Profile");

    	for(int count=1; count<=rowCount1; count++)
		{
    		System.out.println("Sheet name "+ TabName +" Run mode for row number "+ count + " is "+UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count));
			// if found that we have to add new company's organization tab data then call add organization info function..
			 if(UtilFunction.getCellData(fileName, TabName, columnCount_RUNMODE, count).equals("Y")){

				 try{

						if(visitCompanyMenu==true){

							System.out.println("user has clicked on company page successfully!");

						 // visit company page first by searching it from the record
						 

						 VisitCompanyPage_flag	=	getCompanyByName(companyName, "//*[@id='CompanyName']", "//a[@id='btnSearch' and text()='Search']", "//*[@id='dvList']/table/tbody/tr[dd]/td[1]/a");

						 if(VisitCompanyPage_flag==true){

								System.out.println("----- User is on selected company name " + companyName	 + " for tab "+ TabName +" ----");

								 // visit the module
								 VisitModule_flag	= goToCompanyModuleByName("Visa Profile");

								 if(VisitCompanyPage_flag==true){
		            	        	try{

		            	        		boolean CompanyVisaProfilePage_flag	=	obj_CIMS_Company_VisaProfile.VisaProfile(fileName,TabName,count,ActionName);

										if(CompanyVisaProfilePage_flag	==	true){
											System.out.println("Company Visa Profile add or update code executed successfully!");
										}
										else{
											System.out.println("some error occured while working on Visa Profile of company.");
										}
									 }catch(Exception e){
										 System.out.println("error occured for "+TabName+ " sheet, due to following error: "+e.getMessage());
									 }
								 }else{
									 System.out.println("Unable to visit Company Visa Profile module of "+companyName+" ");
								 }

							}else{
								System.out.println("unable to find company in search list for Visa Profile module");
							}
							}
						}catch(Exception a){
							System.out.println("unable to visit company page");
						}

			 }
		}
	}
	*/
}
