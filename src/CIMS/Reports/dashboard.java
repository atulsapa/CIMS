package CIMS.Reports;

import java.awt.AWTException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.hamcrest.text.IsEmptyString;
import org.testng.annotations.Test;

public class dashboard {


	public static String projectReportPath					=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator	;
    public static String projectReportTempSuitePath			=	projectReportPath + "temp"	+ File.separator + "suites" + File.separator;
    public static String projectReportTemplatePath			=	projectReportPath + "templates"	+ File.separator;
    public static String projectReportTempPath				=	projectReportPath + "temp"	+ File.separator;
    public static String dashboardFile 						= 	projectReportPath	+	"dashboard.html";

    // template variables
    public static String headerTemplateFile 				= 	projectReportTemplatePath + "header_template.html";
    public static String belowNavigationTemplateFile 		= 	projectReportTemplatePath + "below_navigation.html";
    public static String footerTemplateFile 				= 	projectReportTemplatePath + "footer_template.html";
    public static String belowFooterTemplateFile 			= 	projectReportTemplatePath + "below_footer.html";


	// counter variables..
    public static String passCounterFilePath				=	projectReportTempPath + "pass_counter";
    public static String failCounterFilePath				=	projectReportTempPath + "fail_counter";
    public static String moduleNotAssignedCounterFilePath	=	projectReportTempPath + "module_not_assigned_counter";
    public static String totalTimeFilePath					=	projectReportTempPath + "total_time";
    public static String barGraphFilePath					=	projectReportTempPath + "bar_graph";

    public static boolean firstPass							=	false;
	public static boolean firstFail							=	false;


@Test
public void main()
					throws InterruptedException, IOException, AWTException 
    {
/*	String mahra_time1	=	"31.565";

	String seconds1	=	mahra_time1;

	System.out.println("seconds involved: "+seconds1);

	String time11 = convertSecondsInHourMinuteSeconds(seconds1);
	System.out.println("time involved: "+time11);
	
	
	String FileTime="12.234";
	String timer="19.331";
	Float newtime;
	
try{
	newtime=	Float.parseFloat(FileTime) + (Float.parseFloat(timer));
	System.out.println(newtime);
}
catch(Exception e){}
	*/
	
	//////////////////////////////////////////

		try{


//			int millis = 5000;
//			int seconds = millis / 1000; // Maybe no need to divide if the input is in seconds
//			LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
//			String time = timeOfDay.toString();


			try {
				writePassReportHeader("Left Navigation", "Notes");
				writeDashBoardPassReport("Left Navigation","Brij","TC001","FireFOX","Positive","New","some desc..","Pass","2 second");
				writeDashBoardPassReport("Left Navigation","Brij","TC006","FIREFOX","Positive","New","some desc. 1.","Pass","4 second");

				writePassReportHeader("Left Navigation", "Subscribed Services");
				writeDashBoardPassReport("Left Navigation","Brij","TC001","FireFOX","Positive","New","some desc 2..","Pass","3 second");
				writeDashBoardPassReport("Left Navigation","Brij","TC003","FIREFOX","Positive","New","some desc. 2.1.","Pass","5.9 second");
			} catch (Exception e2) {
				System.out.println("file executed success fully!");
			}


			try {

				System.out.println("hhhhhh");

				String testNg	=	copyTestNGReport();

				try {
					WriteToFile(testNg, projectReportTempPath + "testng_file");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				String mahra_time	=	"214.654";

				String seconds	=	mahra_time;

				System.out.println("seconds involved: "+seconds);

				String time = convertSecondsInHourMinuteSeconds(seconds);
				System.out.println("time involved: "+time);
//				parseTime(time);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			

			//define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();

         // file path variables..
            

			// content variables
						String headerContent					=	"";
						String navigationContent				=	"";
						String belowNavigationContent			=	"";
						String footerContent					=	"";
						String mainDashboardContent				=	"";
						String leftNavigationContent			=	"";
						String companyContent					=	"";

						// before generating report let us clear previous report data
						WriteToFile("",dashboardFile);


						// now write into dash board file.

						// add header to dash board..

						try {
							Thread.sleep(800);
							headerContent			=		ReadFromFile(headerTemplateFile);
							htmlStringBuilder.append(headerContent);
							System.out.println("added header to dashboard file");
						} catch (Exception e) {
							System.out.println("unable to set header of dashboard");
						}
						
						// add navigation to dash board report..

						try {
							Thread.sleep(800);
							String[] ModuleLists		=	{"Company", "Left Navigation"};
							navigationContent			=		DashboardNavigation(ModuleLists);
							htmlStringBuilder.append(navigationContent);
							System.out.println("added header to dashboard file");
						} catch (Exception e) {
							System.out.println("unable to set header of dashboard");
						}
						
						// add navigation below to dash board report..

						try {
							Thread.sleep(800);
							belowNavigationContent			=		ReadFromFile(belowNavigationTemplateFile);
							htmlStringBuilder.append(belowNavigationContent);
							System.out.println("added header to dashboard file");
						} catch (Exception e) {
							System.out.println("unable to set header of dashboard");
						}

			// add main content for dash board..
			try {
				Thread.sleep(800);
				mainDashboardContent	=	dashboardMainContent("Dashboard","1042", "298", "360", "250","485", "55", "350 minutes","44");
				htmlStringBuilder.append(mainDashboardContent);
				System.out.println("added main content to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set main content of dash board");
			}


			// add main content for left navigation to dash board..
			try {
				Thread.sleep(800);
				mainDashboardContent	=	dashboardMainContent("Left Navigation","32", "98", "60", "20","45", "5", "3 minutes","47");
				htmlStringBuilder.append(mainDashboardContent);
				System.out.println("added main content of left navigation to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set main content of left navigation ");
			}

			
			// add footer to dash board
			try {
				Thread.sleep(800);
				footerContent	=	ReadFromFile(footerTemplateFile);
				htmlStringBuilder.append(footerContent);
				System.out.println("added footer to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to add footer content to dashboard");
			}

			// now write all content into dashboard file..
			dashboardFile 		= 				projectReportPath	+	"dashboard.html";

			WriteToFile(htmlStringBuilder.toString(),dashboardFile);

		}catch(Exception e){
			System.out.println("unable to write in dasboard file");
		}

    }


	public String copyTestNGReport() throws InterruptedException{

		String testNgReportContent	=	"<div class=\"col-md-12 admin-content\" id=\"report\">" +
												"<div class=\"row\">" +
												"<div class=\"col-md-12\">";

		StringWriter writer = new StringWriter();
		String fileName	=	System.getProperty("user.dir") + File.separator + "test-output"+ File.separator + "index.html";
		try{
			IOUtils.copy(new FileInputStream(new File(fileName)), writer);
		}catch(Exception e){
			System.out.println("unable to read file: "+fileName);
		}
	Thread.sleep(2000);
		String[] reportContent			=	writer.toString().split("<div panel-name=\"reporter-All_Suites\" class=\"panel\">");

//		System.out.println("I am text after  report: "+ reportContent[1].toString());

		try{
			Thread.sleep(1800);
			if(reportContent.length>=1){
				// now reduce extra content
				String[] removeExtraContentStr	=		reportContent[1].toString().split("<div panel-name=\"ignored-methods-All_Suites\" class=\"panel\">");
//				chronological-Test_Suite
				testNgReportContent				+= removeExtraContentStr[0].toString();
			}
		}catch(Exception e){
			System.out.println("unable to read content from test ng report file..");
		}

		testNgReportContent.replace("</body>", "").replace("</html>", "");
//		testNgReportContent.replace("<img class='image1' style='width:100%;height:30px;' src='/home/dr12/JavaWorkspace/CIMS/CIMS/img.png'/>", "");
//		
		testNgReportContent.replace("CIMS/CIMS/img.png", "CIMS/img.png");
		testNgReportContent	+=	"</div></div>";

//		System.out.println(testNgReportContent);

		return testNgReportContent;
	}

	
	public void generateReportForSuite(String moduleName, String numberOfModule, String numberOfTotalCases, String numberOfPositive, String numberOfNegative,
			String numberOfPass, String NumberOfFail, String timeInvolved, String NotAssignedModuleCount)
					throws InterruptedException, IOException, AWTException 
    {

		try{

			//define a HTML String Builder
            StringBuilder htmlStringBuilder			=	new StringBuilder();
/*
            // file path variables..
            String projectReportPath				=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator	;
            String projectReportTempPath			=	projectReportPath + "temp"	+ File.separator;
			String contentTemplateFile 				= 	projectReportTempPath + moduleName.toLowerCase().replace(" ", "_")+".html";
//			String extraTemplateFile 				= 	projectReportTempPath + "extra.html";
			String passCounterFilePath				=	projectReportTempPath + "pass_counter";
			String failCounterFilePath				=	projectReportTempPath + "fail_counter";
			String moduleNotAssignedCounterFilePath	=	projectReportTempPath + "module_not_assigned_counter";
			String totalTimeFilePath				=	projectReportTempPath + "total_time";
			String barGraphFilePath					=	projectReportTempPath + "bar_graph";
			*/

            String contentTemplateFile 				= 	projectReportTempPath + moduleName.toLowerCase().replace(" ", "_")+".html";

			String passCounter						=		"";
			String failCounter						=		"";
			String moduleNACounter					=		"";
			String totalTime						=		"";

			// content variables
			String mainDashboardContent	=	"";

			try {
				// before generating report let us clear previous data..
				WriteToFile("",contentTemplateFile);
			} catch (Exception e1) {
				System.out.println("Unable to clear template file: "+contentTemplateFile);
			}


			// add main content for module..
			System.out.println("add main content for module.. "+moduleName);

			// add main content for left navigation to dash board..
			try {
				Thread.sleep(800);
				mainDashboardContent	=	dashboardInnerContent(moduleName, numberOfModule, numberOfTotalCases, numberOfPositive, numberOfNegative, numberOfPass, NumberOfFail, timeInvolved, NotAssignedModuleCount);

				htmlStringBuilder.append(mainDashboardContent);
				System.out.println("added main content of "+moduleName+" to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set main content of left navigation ");
			}

			// now write all content into module file..
			System.out.println("now write all content into module file.. "+moduleName);
			WriteToFile(htmlStringBuilder.toString(),contentTemplateFile);


			// now writing bar graph code
			// let us read the file & append
			String barGraphContent		=	"['"+moduleName+"', "+numberOfPass+", "+NumberOfFail+"],\n";
//			WriteToFile(barGraphContent,barGraphFilePath);

			try {
			    Files.write(Paths.get(barGraphFilePath), barGraphContent.getBytes(), StandardOpenOption.APPEND);
			}catch (IOException e) {
			    //exception handling left as an exercise for the reader
				System.out.println("issue while appending data for bar graph");
			}
			// now saving no. of pass, fail, time taken and not assigned so that we can use them later for main dashboard report..


			// before re-writing the extra file, let us read out & add to it..
			// total pass cases..

			try{
				passCounter				=		ReadFromFile(passCounterFilePath);
				if(!passCounter.isEmpty()){
					int totalPass		=		Integer.parseInt(numberOfPass) + Integer.parseInt(passCounter);
					numberOfPass		=	Integer.toString(totalPass);
				}
			}catch(Exception e){
				System.out.println("unable to set pass counter..");
			}

			WriteToFile(numberOfPass, passCounterFilePath);


			// before re-writing the extra file, let us read out & add to it..
			// total number of fail counters

			try {
				failCounter				=		ReadFromFile(failCounterFilePath);
				if(!failCounter.isEmpty()){
					int totalFail		=		Integer.parseInt(NumberOfFail) + Integer.parseInt(failCounter);
	
					NumberOfFail		=	Integer.toString(totalFail);
				}
			} catch (Exception e) {
				System.out.println("unable to set fail counter..");
			}

			WriteToFile(NumberOfFail, failCounterFilePath);


			// before re-writing the extra file, let us read out & add to it..
			// not assigned module counter
			
			try {
				moduleNACounter					=		ReadFromFile(moduleNotAssignedCounterFilePath);
				System.out.println("new NS mcoule count : "+NotAssignedModuleCount);

				if(!moduleNACounter.isEmpty()){
					int totalModuleNA			=		Integer.parseInt(NotAssignedModuleCount) + Integer.parseInt(moduleNACounter);

					NotAssignedModuleCount				=		Integer.toString(totalModuleNA);
					System.out.println("new NS mcoule count : "+NotAssignedModuleCount);
				}
			} catch (Exception e) {
				System.out.println("unable to set module not assigned counter..");
			}

			WriteToFile(NotAssignedModuleCount, moduleNotAssignedCounterFilePath);


			// before re-writing the extra file, let us read out & add to it..

			// total time

			try {
				totalTime				=		ReadFromFile(totalTimeFilePath);

				if(!totalTime.isEmpty()){
				
					float totalTimeExe		=		Float.parseFloat(timeInvolved) + Float.parseFloat(totalTime);
	
					timeInvolved		=	Float.toString(totalTimeExe);
				}
			} catch (Exception e) {
				System.out.println("unable to set total time counter..");
			}

			WriteToFile(timeInvolved, totalTimeFilePath);


//			String extraContent		= numberOfPass +","+ NumberOfFail+","+ timeInvolved+","+ NotAssignedModuleCount;
//			WriteToFile( extraContent, extraTemplateFile );

		}catch(Exception e){
			System.out.println("unable to write in dasboard file");
		}

    }

	public void generateReport(String[] ModuleLists, String numberOfModule, String numberOfTotalCases, String numberOfPositive, String numberOfNegative
		)
					throws InterruptedException, IOException, AWTException 
    {


		try{

			//define a HTML String Builder
            StringBuilder htmlStringBuilder			=	new StringBuilder();

//            // file path variables..
//            String projectReportPath				=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator	;
//            String projectReportTemplatePath		=	projectReportPath + "templates"	+ File.separator;
//            String projectReportTempPath			=	projectReportPath + "temp"	+ File.separator;
//			String headerTemplateFile 				= 	projectReportTemplatePath + "header_template.html";
//			String belowNavigationTemplateFile 		= 	projectReportTemplatePath + "below_navigation.html";
//			String footerTemplateFile 				= 	projectReportTemplatePath + "footer_template.html";
//			String belowFooterTemplateFile 			= 	projectReportTemplatePath + "below_footer.html";
//			String dashboardFile 					= 	projectReportPath	+	"dashboard.html";


			String passCounter						=		"";
			String failCounter						=		"";
			String moduleNACounter					=		"";
			String totalTime						=		"";

			// content variables
			String headerContent					=	"";
			String navigationContent				=	"";
			String belowNavigationContent			=	"";
			String footerContent					=	"";
			String belowFooterContent				=	"";
			String mainDashboardContent				=	"";
			String leftNavigationContent			=	"";
			String barGraphContent					=	"";
			String moduleContent					=	"";

//			String generalAdminContent				=	"";
//			String companyContent					=	"";
//			
//			String profileContent					=	"";




			// before generating report let us clear previous report data
			WriteToFile("",dashboardFile);


			// now write into dash board file.

			// add header to dash board..

			try {
				Thread.sleep(800);
				headerContent			=		ReadFromFile(headerTemplateFile);
				htmlStringBuilder.append(headerContent);
				System.out.println("added header to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set header of dashboard");
			}

			// add navigation to dash board report..

			try {
				Thread.sleep(800);
//				String[] ModuleLists		=	{"Company", "Left Navigation", "General Admin"};
				navigationContent			=		DashboardNavigation(ModuleLists);
				htmlStringBuilder.append(navigationContent);
				System.out.println("added header to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set header of dashboard");
			}

			// add navigation below to dash board report..

			try {
				Thread.sleep(800);
				belowNavigationContent			=		ReadFromFile(belowNavigationTemplateFile);
				htmlStringBuilder.append(belowNavigationContent);
				System.out.println("added header to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set header of dashboard");
			}



			// before adding data to main dashboard, let us get counter & other details..
			// total pass cases..
			passCounter				=		ReadFromFile(passCounterFilePath);
			// total number of fail counters
			failCounter				=		ReadFromFile(failCounterFilePath);
			// not assigned module counter
			moduleNACounter			=		ReadFromFile(moduleNotAssignedCounterFilePath);

			// total time
			totalTime				=		ReadFromFile(totalTimeFilePath);

			System.out.println("p: "+passCounter + "\tf: "+ failCounter + "\t na: "+moduleNACounter + "\t t:"+totalTime);
			
			// add main content for dash board..
			try {
				Thread.sleep(800);
				mainDashboardContent	=	dashboardMainContent("Dashboard",numberOfModule, numberOfTotalCases, numberOfPositive, numberOfNegative,passCounter, failCounter, totalTime, moduleNACounter);
				htmlStringBuilder.append(mainDashboardContent);
				System.out.println("added main content to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set main content of dash board");
			}

/*
			// add main content for left navigation to dash board..
			try {
				Thread.sleep(800);
				leftNavigationContent	=	ReadFromFile(projectReportTempPath+"left_navigation.html");
				htmlStringBuilder.append(leftNavigationContent);
				System.out.println("added main content of left navigation to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to set main content of left navigation ");
			}
*/

			for(int m=0;m<ModuleLists.length;m++){
				moduleContent	=	"";
				String moduleName		=	ModuleLists[m];
				
				if(moduleName.equals("Regression Suites")){
					moduleName	=	"Initiate a single project";
				}

				// add main content for profile questionnaire to dash board..
				try {
					Thread.sleep(800);
					moduleContent	=	ReadFromFile(projectReportTempPath+ moduleName.toLowerCase().replace(" ", "_") + ".html");
					htmlStringBuilder.append(moduleContent);
					System.out.println("added main content of "+ moduleName +" to dashboard file");
				} catch (Exception e) {
					System.out.println("unable to set main content of "+ moduleName );
				}
				
			}

			
			// add reports table
			/*try {
				Thread.sleep(1000);
				htmlStringBuilder.append(copyTestNGReport().toString());
				System.out.println("added testng reports content to dashboard file");
			} catch (Exception e1) {
				System.out.println("adding testing report fails");
			}*/
			
			
			/**
			 * now call all suites temp file to generate report for each suite..
			 */
			
			String ReporterFooter	= 	ReadFromFile(projectReportTemplatePath+"suite_footer.html");

			String ReporterMainContainer	=	"<div class=\"col-md-12 admin-content\" id=\"report\">" +
					"<div class=\"row\">" +
					"<div class=\"col-md-12\">";
			
			htmlStringBuilder.append(ReporterMainContainer);
			
			
			if(ModuleLists.length>0){

				firstPass	=	false;
				firstFail	=	false;
				int w=0;
				for(String Module : ModuleLists){
					
					

					String FirstPassReport	=	(w==0) ? "<span id='first-pass'></span>" : "";

					String FirstFailReport	=	(w==0) ? "<span id='first-fail'></span>" : "";

					// updated for regression dashboard reports
					if(Module.equals("Regression Suites")){
						String regString	=	regressionSuiteDashboard(firstPass, FirstPassReport, firstFail, FirstFailReport, ReporterFooter);
						htmlStringBuilder.append(regString);
					}

					String passfile	=	projectReportTempSuitePath	+ Module.toLowerCase().replace(" ", "_") + "_pass.html";

					// before adding pass report let us confirm if file is present or not
					if(checkFileExists(passfile)){
						try {

							String PassReporterHeader	=  "";
							if(firstPass==false){
								PassReporterHeader		+= FirstPassReport;	firstPass=true;
							}
							// now add left navigation pass report
							PassReporterHeader		+= 	dashboardPassHeader(Module);

							PassReporterHeader	+=	ReadFromFile(passfile);
							System.out.println("added "+Module+" pass report");
							htmlStringBuilder.append(PassReporterHeader);
							htmlStringBuilder.append(ReporterFooter);
						} catch (Exception e) {
							System.out.println("failed to write pass report for "+Module);
						}
					}

					// negative pass suite..
					String negPassFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_negative_pass.html";
					if(checkFileExists(negPassFile)){
						try {

							String negativePassReporterHeader	=	"";
							if(firstPass==false){
								negativePassReporterHeader		+= FirstPassReport;	firstPass=true;
							}
							// now add left navigation fail report
							negativePassReporterHeader	+=	dashboardNegativePassHeader(Module);

							negativePassReporterHeader	+=	ReadFromFile(negPassFile);
							System.out.println("added "+Module+" negative pass report");
							htmlStringBuilder.append(negativePassReporterHeader);
							htmlStringBuilder.append(ReporterFooter);
						} catch (Exception e) {
							System.out.println("failed to write fail report for "+Module);
						}
					}


					// fail content of suite
					String failFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_fail.html";
					if(checkFileExists(failFile)){
						try {

							String FailReporterHeader	=	"";
							if(firstFail==false){
								FailReporterHeader		+= FirstFailReport;	firstFail=true;
							}
							// now add left navigation fail report
							FailReporterHeader		+=	dashboardFailHeader(Module);

							FailReporterHeader	+=	ReadFromFile(failFile);
							System.out.println("added "+Module+" pass report");
							htmlStringBuilder.append(FailReporterHeader);
							htmlStringBuilder.append(ReporterFooter);
						} catch (Exception e) {
							System.out.println("failed to write fail report for "+Module);
						}
					}

					// not assigned suite..
					String nAFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_not_assigned.html";
					if(checkFileExists(nAFile)){
						try {

							String NotAssignedReporterHeader	=	"";
							if(firstFail==false){
								NotAssignedReporterHeader		+= FirstFailReport;	firstFail=true;
							}
							// now add left navigation fail report
							NotAssignedReporterHeader		+= 	dashboardNotAssignedHeader(Module);

							NotAssignedReporterHeader	+=	ReadFromFile(nAFile);
							System.out.println("added "+Module+" not assigned report");
							htmlStringBuilder.append(NotAssignedReporterHeader);
							htmlStringBuilder.append(ReporterFooter);
						} catch (Exception e) {
							System.out.println("failed to write fail report for "+Module);
						}
					}
					
					w++;
				}

			}

			// closing reporter div..
			htmlStringBuilder.append("</div></div></div>");
			
			

			// add footer to dash board
			try {
				Thread.sleep(800);
				footerContent	=	ReadFromFile(footerTemplateFile);
				htmlStringBuilder.append(footerContent);
				System.out.println("added footer to dashboard file");
			} catch (Exception e) {
				System.out.println("unable to add footer content to dashboard");
			}


			// add chart code to the file..

			try{
				Thread.sleep(1000);
				barGraphContent	=	ReadFromFile(barGraphFilePath);
				htmlStringBuilder.append(barGraphContent);
			}catch(Exception e){
				System.out.println("unable to write bar graph code");
			}

			
			
			try{
				// below footer
				Thread.sleep(1000);
				belowFooterContent		=	ReadFromFile(belowFooterTemplateFile);
				htmlStringBuilder.append(belowFooterContent);
				System.out.println("below footer content added..");
			}catch(Exception e){
				System.out.println("unable to write below footer content");
			}
			
			// now write all content into dashboard file..

			WriteToFile(htmlStringBuilder.toString(),dashboardFile);

			System.out.println("now let us clear temp file so that it won't use old data in report generation for the next time");

			// after generating let us clean temp files that were used to generate report
			/*WriteToFile("",projectReportTempPath+"left_navigation.html");
			WriteToFile("",projectReportTempPath+"company.html");
			WriteToFile("",projectReportTempPath+"general_admin.html");*/

		}catch(Exception e){
			System.out.println("unable to write in dasboard file");
		}

    }

	
	public String dashboardPassHeader(String SuiteName){
		String PassHeader	=	"<div class=\"bs-example bs-green\" id=\"" + SuiteName.toString().toLowerCase().replace(" ", "-") + "-pass-report\">" +
				"<table class=\"table table-striped\" ><caption>" + SuiteName + "  - Pass Report</caption>" +
				"<thead><tr><td>Test Case ID</td><td>Browser</td><td>Scenario</td><td >Action</td><td >Test Case Description</td><td>Employee Name</td><td >Execution Status</td><td>Time taken to Execute</td></tr></thead><tbody>";
		
		return PassHeader;
	}
	
	public String dashboardNotAssignedHeader(String SuiteName){
		String NotAssignedHeader	=	"<div class=\"bs-example bs-blue\" id=\"" + SuiteName.toString().toLowerCase().replace(" ", "-") + "-not-assigned-report\">" +
				"<table class=\"table table-striped\" ><caption>" + SuiteName + "  - Not Assigned Report</caption>" +
				"<thead><tr><td>Test Case ID</td><td>Browser</td><td>Scenario</td><td >Action</td><td >Test Case Description</td><td>Employee Name</td><td >Execution Status</td><td>Time taken to Execute</td></tr></thead><tbody>";

		return NotAssignedHeader;
	}
	
	public String dashboardFailHeader(String SuiteName){
		String FailHeader	=	"<div class=\"bs-example bs-red\" id=\"" + SuiteName.toString().toLowerCase().replace(" ", "-") + "-fail-report\">" +
				"<table class=\"table table-striped\" ><caption>" + SuiteName + "  - Fail Report</caption>" +
				"<thead><tr><td>Test Case ID</td><td>Browser</td><td>Scenario</td><td >Action</td><td >Test Case Description</td><td>Employee Name</td><td >Execution Status</td><td>Error Message</td><td>Error Screenshot</td><td>Time taken to Execute</td></tr></thead><tbody>";
		
		return FailHeader;
	}
	
	
	public String dashboardNegativePassHeader(String SuiteName){
		String FailHeader	=	"<div class=\"bs-example bs-olive\" id=\"" + SuiteName.toString().toLowerCase().replace(" ", "-") + "-negative-pass-report\">" +
				"<table class=\"table table-striped\" ><caption>" + SuiteName + "  - Negative Pass Report</caption>" +
				"<thead><tr><td>Test Case ID</td><td>Browser</td><td>Scenario</td><td >Action</td><td >Test Case Description</td><td>Employee Name</td><td >Execution Status</td><td>Error Message</td><td>Error Screenshot</td><td>Time taken to Execute</td></tr></thead><tbody>";
		
		return FailHeader;
	}
	

	public String dashboardMainContent(String moduleName, String numberOfModule, String numberOfTotalCases, String numberOfPositive, String numberOfNegative,
					String numberOfPass, String NumberOfFail, String timeInvolved, String NotAssignedModuleCount){

		String Content	=	"";

//		String TestNgReportLink		=	System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "index.html#reports";
		String TestNgReportLink		=	"#\" data-target-id=\"report\"" ;

		String startDateTime	=	"";
		try {
			startDateTime = ReadFromFile(projectReportTempPath+"start_time");
		} catch (FileNotFoundException e) {

		}
		Content	=
				"<section class=\"content-header\">" +
				"<h1> Dashboard " +
//				"<small>Cobalt Automation Report</small>" +
				" </h1>" +
				"<ol class=\"breadcrumb\">" +
				"<li><a href=\"#\"> " +
				"<strong style=\"margin-right:5px; color:#000;font-size: 12px;\">" +
				"Execution Started </strong>"+ startDateTime +"</a></li>" +
				"<li><a href=\"#\"> " +
				"<strong style=\"margin-right:5px; color:#000;font-size: 12px;\">" +
				"Total Time (HH:MM:SS) </strong>"+ convertSecondsInHourMinuteSeconds(timeInvolved) +"</a></li>" +
				"<li><a href=\"#\"> " +
				"<strong style=\"margin-right:5px; color:#000;font-size: 12px;\">" +
				"Modules Not assigned</strong>" + NotAssignedModuleCount + "</a>" +
				"</li>" +
				"</ol>" +
				"</section>" +
				"<section class=\"content\">" +
				"<div class=\"row\">" +
				"<div class=\"col-md-12 admin-content\" id=\"" + moduleName.toLowerCase().replace(" ", "-") + "\">" + "\n" +
				"<div class=\"row\">" + "\n" +
				"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
				"<div class=\"small-box bg-teal\">" + "\n" +
				"<div class=\"inner\">" + "\n" +
				"<p>Modules executed</p>" + "\n" +
				"<h3>"+numberOfModule+"</h3>" + "\n" +
				"</div>" + "\n" +
				"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
				"</div>" + "\n" +
				"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
				"<div class=\"small-box bg-fuchsia\">" + "\n" +
				"<div class=\"inner\">" + "\n" +
						"<p>Test cases executed</p>" + "\n" +
						"<h3>" + "\n" + numberOfTotalCases + "</h3>" + "\n" +
						"</div>" + "\n" +
						"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
						"</div>" + "\n" +
						"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
						"<div class=\"small-box bg-green\">" + "\n" +
						"<div class=\"inner\">" + "\n" +
						"<p>Positive Test Cases</p>" + "\n" +
						"<h3>" + "\n" + numberOfPositive + "</h3>" + "\n" +
						"</div>" + "\n" +
						"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
						"</div>" + "\n" +
						"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
						"<div class=\"small-box bg-lime\">" + "\n" +
						"<div class=\"inner\">" + "\n" +
						"<p>Negative Test Cases</p>" + "\n" +
						"<h3>" + "\n" + numberOfNegative + "</h3>" + "\n" +
						"</div>" + "\n" +
						"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
						"</div>" + "\n" +
						"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
						"<div class=\"small-box bg-olive\">" + "\n" +
						"<div class=\"inner\">" + "\n" +
						"<p>Test Cases (PASS)</p>" + "\n" +
						"<h3>" + "\n" + numberOfPass + "</h3>" + "\n" +
						"</div>" + "\n" +
						"<a href=\""+ TestNgReportLink.replace("#", "#first-pass") + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
						"</div>" + "\n" +
						"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
						"<div class=\"small-box bg-red\">" + "\n" +
						"<div class=\"inner\">" + "\n" +
						"<p>Test Cases (FAIL)</p>" + "\n" +
						"<h3>" + "\n" + NumberOfFail + "</h3>" + "\n" +
						"</div>" + "\n" +
						"<a href=\""+ TestNgReportLink.replace("#", "#first-fail") + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
						"</div>" + "\n" +
						"</div>" + "\n" +
								"<div class=\"row\"><div class=\"col-md-12\"><div id=\"chart_div\"></div></div></div>" +
						"</div>" ;
		
		return Content;
	}
	
	public String dashboardInnerContent(String moduleName, String numberOfModule, String numberOfTotalCases, String numberOfPositive, String numberOfNegative,
			String numberOfPass, String NumberOfFail, String timeInvolved, String NotAssignedModuleCount){

		String Content	=	"";
		
		//String TestNgReportLink		=	System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "index.html#reports";
		String TestNgReportLink		=	"#\" data-target-id=\"report\"" ;
		
		Content	=
			"<div class=\"col-md-12 admin-content\" id=\"" + moduleName.toLowerCase().replace(" ", "-") + "\">" + "\n" +
			"<div class=\"row\">" + "\n" +
			"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
			"<div class=\"small-box bg-teal\">" + "\n" +
			"<div class=\"inner\">" + "\n" +
			"<p>Modules executed</p>" + "\n" +
			"<h3>"+numberOfModule+"</h3>" + "\n" +
			"</div>" + "\n" +
			"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
			"</div>" + "\n" +
			"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
			"<div class=\"small-box bg-fuchsia\">" + "\n" +
			"<div class=\"inner\">" + "\n" +
					"<p>Test cases executed</p>" + "\n" +
					"<h3>" + "\n" + numberOfTotalCases + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-green\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Positive Test Cases</p>" + "\n" +
					"<h3>" + "\n" + numberOfPositive + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-lime\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Negative Test Cases</p>" + "\n" +
					"<h3>" + "\n" + numberOfNegative + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-olive\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Test Cases (PASS)</p>" + "\n" +
					"<h3>" + "\n" + numberOfPass + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\"#" + moduleName.toLowerCase().replace(" ", "-") + "-pass-report\" data-target-id=\"report\" class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-red\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Test Cases (FAIL)</p>" + "\n" +
					"<h3>" + "\n" + NumberOfFail + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\"#" + moduleName.toLowerCase().replace(" ", "-") + "-fail-report\" data-target-id=\"report\" class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-light-blue\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Modules Not assigned</p>" + "\n" +
					"<h3>" + "\n" + NotAssignedModuleCount + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\"#" + moduleName.toLowerCase().replace(" ", "-") + "-not-assigned-report\" data-target-id=\"report\" class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"<div class=\"col-lg-4 col-xs-6\">" + "\n" +
					"<div class=\"small-box bg-blue\">" + "\n" +
					"<div class=\"inner\">" + "\n" +
					"<p>Total Time</p>" + "\n" +
					"<h3>" + "\n" + convertSecondsInHourMinuteSeconds(timeInvolved) + "</h3>" + "\n" +
					"</div>" + "\n" +
					"<a href=\""+ TestNgReportLink + " class=\"small-box-footer\"> More info </a> </div>" + "\n" +
					"</div>" + "\n" +
					"</div>" + "\n" +
					"</div>" ;

		return Content;
	}

	
	public String barGraph() {
		String barGraphContent	=	
						"['Regression', 9, 2]," +
						"['Left Navigation', 11, 3]," +
						"['Company', 24, 0]" +
						"]);" +
						"" +
						"var options = {" +
						"title: 'Pass and fail counter of Suite executed'," +
						"chartArea: {width: '80%'}," +
						"isStacked: true," +
						"hAxis: {" +
						"title: 'Total number of Test cases'," +
						"minValue: 0" +
						"}," +
						"" +
						"vAxis: {" +
						"title: 'Suites'" +
						"}" +
						"};" +
						"var chart = new google.visualization.BarChart(document.getElementById('chart_div'));" +
						"chart.draw(data, options);" +
						"}";
		return barGraphContent;
	}

	
	public String DashboardNavigation(String[] ModuleLists){
		String navigation="";

		for(int m=0;m<ModuleLists.length;m++){
			//updated for regression suite
			if(ModuleLists[m].equals("Regression Suites")){
				navigation	+=	"<li><a href=\"#\" data-target-id=\"old-initiation\">Old Initiation</a></li>\n";
			}else{
				navigation	+=	"<li><a href=\"#\" data-target-id=\""+ ModuleLists[m].toLowerCase().replace(" ", "-") +"\">"+ ModuleLists[m].toString() +"</a></li>\n";
			}
			
		}
		
		return navigation;
	}
	
	

	public void writeReportHeader(String SuiteName,String moduleName, String Status)
			throws InterruptedException, IOException, AWTException {
		
		String passReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_" + Status.toString().toLowerCase().replace(" ", "_") + ".html";
		String content								=	"";
		// now write the header to file..
		try {
			// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(passReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ passReportFilePath +" file");
			}
        	content				+=	"<tr><td class=\"td-heading\" colspan=\"10\">"+ moduleName.toString() +"</td></tr>" +
        							"\n";
			WriteToFile(content, passReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write sub heading of module: "+moduleName+ " :: Suite Name: "+SuiteName);
		}
	}
	
	
	
	
	public void writePassReportHeader(String SuiteName,String moduleName)
			throws InterruptedException, IOException, AWTException {
		
		String passReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_pass.html";
		String content								=	"";
		// now write the header to file..
		try {
			// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(passReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ passReportFilePath +" file");
			}
        	content				+=	"<tr><td class=\"td-heading\" colspan=\"10\">"+ moduleName.toString() +"</td></tr>" +"\n";
			WriteToFile(content, passReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write sub heading of module: "+moduleName+ " :: Suite Name: "+SuiteName);
		}
	}


	public void writeDashBoardPassReport(String SuiteName,String Employee_name,String TestcaseID, String browser,String scenario, 
			String ActionName, String testcasedescription,String status, String Timer) 
					throws InterruptedException, IOException, AWTException {

        // file path variables..
        String passReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_pass.html";

        String content								=	"";

        // after preparing content let us write into file
        try {
        	// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(passReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ passReportFilePath +" file");
			}
        	content			+=	"<tr>" +
					"<td>" +TestcaseID+"</td>" +
					"<td>"+browser+"</td>" +
							"<td>"+scenario+"</td>" +
									"<td>"+ActionName+"</td>"
							+"<td>"+testcasedescription+"</td>" +
									"<td>"+Employee_name+"</td>" +
											"<td>"
									+status+"</td>" +
											"<td>" + Timer +
											" seconds" +
											"</td>" +
											"</tr>" +
											"\n";
			WriteToFile(content, passReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write pass report for: "+SuiteName);
		}
	}


	public void writeDashBoardNotAssignedReport(String SuiteName,String Employee_name,String TestcaseID, String browser,String scenario, 
			String ActionName, String testcasedescription,String status, String Timer) 
					throws InterruptedException, IOException, AWTException {

        // file path variables..
        String notAssignedReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_not_assigned.html";

        String content								=	"";

        // after preparing content let us write into file
        try {
        	// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(notAssignedReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ notAssignedReportFilePath +" file");
			}
        	content			+=	"<tr>" +
					"<td>" +TestcaseID+"</td>" +
					"<td>"+browser+"</td>" +
							"<td>"+scenario+"</td>" +
									"<td>"+ActionName+"</td>"
							+"<td>"+testcasedescription+"</td>" +
									"<td>"+Employee_name+"</td>" +
											"<td>"
									+status+"</td>" +
											"<td>" + Timer +
											" seconds" +
											"</td>" +
											"</tr>" +
											"\n";
			WriteToFile(content, notAssignedReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write pass report for: "+SuiteName);
		}
	}
	
	
	public void writeDashBoardFailReport(String SuiteName,String Employee_name,String TestcaseID, String browser,String scenario, 
			String ActionName, String testcasedescription,String status, String Timer, String errormessage, String errormessage1,
			String ModuleErrorMessage) 
					throws InterruptedException, IOException, AWTException {

        // file path variables..
        String passReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_fail.html";

        String content								=	"";

        // after preparing content let us write into file
        try {
        	// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(passReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ passReportFilePath +" file");
			}

        	try{
        	content			+=	
				"<tr><td>"+TestcaseID+"</td><td>" +
						browser+"</td><td>"+scenario+"</td><td>"+ActionName+"</td><td>"+testcasedescription+"</td><td>"+ Employee_name +"</td><td>"+status+"</td><td>"+errormessage +errormessage1+ModuleErrorMessage +"</td><td>" +
								"<a href=file:///" + util.UtilFunction.FilePath+ " target=_blank>Check Error</a></td><td>"	+	Timer	+" seconds</td>" +
										"</tr>" +
											"\n";
        	}catch(Exception e){
        		System.out.println("unable to cacth file path");
        	}
			WriteToFile(content, passReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write pass report for: "+SuiteName);
		}
	}
	
	
	public void writeDashBoardNegativePassReport(String SuiteName,String Employee_name,String TestcaseID, String browser,String scenario, 
			String ActionName, String testcasedescription,String status, String Timer, String errormessage, String errormessage1,
			String ModuleErrorMessage) 
					throws InterruptedException, IOException, AWTException {

        // file path variables..
        String negativePassReportFilePath					=	projectReportTempSuitePath + SuiteName.toLowerCase().replace(" ", "_") + "_negative_pass.html";

        String content								=	"";

        // after preparing content let us write into file
        try {
        	// before writing let us read & concatenate previous data..
        	try {
				content			=	ReadFromFile(negativePassReportFilePath);
			} catch (Exception e) {
				System.out.println("unable to reader "+ negativePassReportFilePath +" file");
			}

        	try{
        	content			+=	
				"<tr><td>"+TestcaseID+"</td><td>" +
						browser+"</td><td>"+scenario+"</td><td>"+ActionName+"</td><td>"+testcasedescription+"</td><td>"+ Employee_name +"</td><td>"+status+"</td><td>"+errormessage +errormessage1+ModuleErrorMessage +"</td><td>" +
								"<a href=file:///" + util.UtilFunction.FilePath+ " target=_blank>Check Error</a></td><td>"	+	Timer	+" seconds</td>" +
										"</tr>" +
											"\n";
        	}catch(Exception e){
        		System.out.println("unable to cacth file path");
        	}
			WriteToFile(content, negativePassReportFilePath);
		} catch (Exception e) {
			System.out.println("unable to write pass report for: "+SuiteName);
		}
	}
	

	public String regressionSuiteDashboard(boolean firstPass, String FirstPassReport, boolean firstFail, 
			String FirstFailReport, String ReporterFooter) throws IOException {

		// before generating report for each regression suite let us call enabled modules of the same

		String Module	=	"Old Initiation";

		String regressionSuiteData = "";
		String passfile	=	projectReportTempSuitePath	+ Module.toLowerCase().replace(" ", "_") + "_pass.html";

		// before adding pass report let us confirm if file is present or not
		if(checkFileExists(passfile)){
			try {

				String PassReporterHeader	=  "";
				if(firstPass==false){
					PassReporterHeader		+= FirstPassReport;	firstPass=true;
				}
				// now add left navigation pass report
				PassReporterHeader		+= 	dashboardPassHeader(Module);

				PassReporterHeader	+=	ReadFromFile(passfile);
				System.out.println("added "+Module+" pass report");
				regressionSuiteData		+=	PassReporterHeader;
				regressionSuiteData		+=	ReporterFooter;
			} catch (Exception e) {
				System.out.println("failed to write pass report for "+Module);
			}
		}

		// negative pass suite..
		String negPassFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_negative_pass.html";
		if(checkFileExists(negPassFile)){
			try {

				String negativePassReporterHeader	=	"";
				if(firstPass==false){
					negativePassReporterHeader		+= FirstPassReport;	firstPass=true;
				}
				// now add left navigation fail report
				negativePassReporterHeader	+=	dashboardNegativePassHeader(Module);

				negativePassReporterHeader	+=	ReadFromFile(negPassFile);
				System.out.println("added "+Module+" negative pass report");
				regressionSuiteData		+=	negativePassReporterHeader;
				regressionSuiteData		+=	ReporterFooter;
			} catch (Exception e) {
				System.out.println("failed to write fail report for "+Module);
			}
		}


		// fail content of suite
		String failFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_fail.html";
		if(checkFileExists(failFile)){
			try {

				String FailReporterHeader	=	"";
				if(firstFail==false){
					FailReporterHeader		+= FirstFailReport;	firstFail=true;
				}
				// now add left navigation fail report
				FailReporterHeader		+=	dashboardFailHeader(Module);

				FailReporterHeader	+=	ReadFromFile(failFile);
				System.out.println("added "+Module+" pass report");
				regressionSuiteData		+=	FailReporterHeader;
				regressionSuiteData		+=	ReporterFooter;
			} catch (Exception e) {
				System.out.println("failed to write fail report for "+Module);
			}
		}

		// not assigned suite..
		String nAFile	=	projectReportTempSuitePath+ Module.toLowerCase().replace(" ", "_") + "_not_assigned.html";
		if(checkFileExists(nAFile)){
			try {

				String NotAssignedReporterHeader	=	"";
				if(firstFail==false){
					NotAssignedReporterHeader		+= FirstFailReport;	firstFail=true;
				}
				// now add left navigation fail report
				NotAssignedReporterHeader		+= 	dashboardNotAssignedHeader(Module);

				NotAssignedReporterHeader	+=	ReadFromFile(nAFile);
				System.out.println("added "+Module+" not assigned report");
				regressionSuiteData		+=	NotAssignedReporterHeader;
				regressionSuiteData		+=	ReporterFooter;
			} catch (Exception e) {
				System.out.println("failed to write fail report for "+Module);
			}
		}
		
		return regressionSuiteData;
		
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public String ReadFromFile(String fileName) throws FileNotFoundException {

		String fileContent = "";

		 //Reading from file. 
		//Create Object of java FileReader and BufferedReader class. 

		try{
		FileReader FR = new FileReader(fileName); 
		BufferedReader BR = new BufferedReader(FR); 
		String Content = "";
		while((Content = BR.readLine())!= null){
			fileContent	=	fileContent + Content;
//			System.out.println(Content); 
		}
		}catch(Exception e){
			System.out.println("unable to read file: "+fileName);
		}
		return fileContent;
	}

	
	public boolean checkFileExists(String fileName){
		boolean flag=false;
		File file = new File(fileName);
        // if file does exists, then delete and create a new file
        if (file.exists()) {

        	if(file.length()>0){
        	/*BufferedReader br = new BufferedReader(file);     
        	if (br.readLine() == null) {
        	    System.out.println("No errors, and file empty");
        	}*/
        	
        	flag=true;
        	}

        }else{
        	flag=false;
        }
		return flag;
	}

    public void WriteToFile(String fileContent, String fileName) throws IOException {

//        String tempFile = projectPath + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator	+	fileName;
        File file = new File(fileName);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectReportPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
//                System.out.println("unable to write at : "+projectReportPath + File.separator+ "backup_"+fileName);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("unable to write at : "+projectReportPath + File.separator+ "backup_"+fileName);
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
    
    public String convertSecondsInHourMinuteSeconds(String secondsStr){
    	
    	System.out.println("we got "+secondsStr+"second to convert.");
    	
    	// now splitting it with decimal value..

    	int seconds				=	0;
    	String hrStr 			= "";
		String mnStr 			= "";
		String secStr 			= "";

    	try{
    		String newSecStr	=	secondsStr.split("\\.")[0];
    		seconds				=	Integer.parseInt(newSecStr);
    	}catch(Exception e){
    		try {
				seconds				=	Integer.parseInt(secondsStr);
			} catch (NumberFormatException e1) {
				System.out.println("some issue with time passed");
			}
    		System.out.println("unable to convert string into int");
    	}

		  try {
			  int hr 			= seconds/3600;
			  int rem 			= seconds%3600;
			  int mn 			= rem/60;
			  int sec 			= rem%60;
			  hrStr 			= (hr<10 ? "0" : "")+hr;
			  mnStr 			= (mn<10 ? "0" : "")+mn;
			  secStr 			= (sec<10 ? "0" : "")+sec;
		} catch (Exception e) {
			System.out.println("some issue occured while converting time in H:M:S format");
		} 

		  System.out.println("time in hours:  "+hrStr+":"+ mnStr +":" + secStr);
    	return hrStr+":"+ mnStr +":" + secStr;
    }

    public String parseTime(String Time) {
        String FORMAT = "%02d:%02d:%02d";
        float millisecs	=	Long.parseLong(Time) * 1000F;
        long milliseconds	=	Long.parseLong(Float.toString(millisecs));
		return String.format(FORMAT,
                TimeUnit.MILLISECONDS.toHours(milliseconds),
                TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(milliseconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
     }

}
