package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_News_Admin {
	
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_News_Admin(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean News_Admin(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			
			if(TestcaseRunMode.equals("Y")){
			
			System.out.println("user is on '"+sheetName+"' module....");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Filter_By_Country                            =            UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String Title_Content                                =            UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String DateFilter                                =            UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String Type                                =            UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			
  
			String ExpectedErrorMessage                         =           UtilFunction.getCellData(filename, sheetName,8 , ColumnCounter);

			testcaseid         =        TestcaseID;
			scenerio           =        Scenario;
			description        =        TestCaseDescription;
			
			String btnSearchNews_xpath        =    ".//*[@id='btnSearchNews']";
			String filterCountry_xpath        =    ".//*[@id='Category']";
			String titleContect_xpath        =    ".//*[@id='txtTitleNews']";
			String DateFilter_xpath        =    ".//*[@id='DateFilter']";
			
			
			
			String result_row_count            =    ".//*[@id='dvListNews']//*[@role='tab']";
			String result_row                =    ".//*[@id='dvListNews']//*[@role='tab'][1]/a";
			String tabpanel                    =    ".//*[@id='dvListNews']//*[@role='tabpanel'][1]";
			String News_page_xpath            =    ".//*[@id='dvListNews']//*[@role='tabpanel'][1]/a";
			
			String TypeXpath                  = "//*[@id='form1']//*[@id='panel-body']//tbody//*[@class='dvradiotype']//*[@name]";
			String News_page_Title            =    ".//*[@id='panel-body']/tbody//*[@class='form-horizontal']/h4";
			//    String News_page_content            =    ".//*[@id='panel-body']/tbody//*[@class='form-horizontal']";
			String ScrolltoNews                =    ".//*[@id='panel-header' and contains(text(),'News')]";
            String Synchronize_Latest_NewsXpath ="//*[contains(@class,'btn') and text()='Synchronize Latest News']";
			String tab_titel_text            ="";
			String tab_panel_text            ="";
			String Page_news_title            ="";
			//    String Page_news_content        ="";
			String error_flag                ="";
			String error_msg                ="";
			int ResultRowCount=0;
			utilfunc.globalerrormessage="";
			utilfunc.ErrorMessage4="";

			try{
				//For move to the News block
				try{utilfunc.MakeElement(ScrolltoNews).click();}catch(Exception error){}
				//For select country in dropdown for filter the data
				try{utilfunc.Selectdropdownvaluebytext(filterCountry_xpath, Filter_By_Country);}catch(Exception error){}
				
				try{utilfunc.Selectdropdownvaluebytext(DateFilter_xpath, DateFilter);}catch(Exception error){}
				//For set title
				try{utilfunc.MakeElement(titleContect_xpath).clear();
				utilfunc.MakeElement(titleContect_xpath).sendKeys(Title_Content);}catch(Exception error){}
				//For click on search button
				try{utilfunc.MakeElement(btnSearchNews_xpath).click();}catch(Exception error){}
				Thread.sleep(1000);//Wait for 2 sec till data should be filtered
			}catch(Exception error){}
			
			
				try{
						if(TypeXpath.equalsIgnoreCase("Type"))
						{
						utilfunc.MakeElement(TypeXpath+"//.[@value='']").click();
						}
						else
						{
							utilfunc.MakeElement(TypeXpath+"//.[@value='Top(100)']").click();
						}
					}catch(Exception errror){}

			     try {
					utilfunc.MakeElement(Synchronize_Latest_NewsXpath).click();
					utilfunc.isAlertPresent();
					String ErrorOrSuccess="";
					ErrorOrSuccess=utilfunc.MakeElement(".//*[@id='panel-body-main']//*[@id='page-message']").getText();
					System.out.println("ErrorOrSuccess:"+ErrorOrSuccess);
                    
					
				} catch (Exception e1) {}

			try{
				ResultRowCount=utilfunc.GetObjectCount(result_row_count);
			}catch(Exception error){}
			
			try
			{
			if(ResultRowCount>=1)
			{//data found

				try{    utilfunc.MakeElement(result_row).click();    }catch(Exception error){}
				Thread.sleep(1000);

				try{ tab_titel_text=utilfunc.MakeElement(result_row).getText();    }catch(Exception error){}
				//        try{ tab_panel_text=utilfunc.MakeElement(tabpanel).getText();    }catch(Exception error){}

				try{

					try{ utilfunc.MakeElement(News_page_xpath).click();        }catch(Exception error){}
					Thread.sleep(1000);//wait so user can see the popup window
					String Parent_Window=webdriver.getWindowHandle();
					System.out.println("Parent Window : "+Parent_Window);
					try{
						for (String Child_Window : webdriver.getWindowHandles())
						{
							System.out.println("Child Windoww : "+Child_Window);
							if(!Child_Window.equals(Parent_Window))
							{
								webdriver.switchTo().window(Child_Window); 
								utilfunc.waitForAnElementToLoad(News_page_Title, false);
								Page_news_title=utilfunc.MakeElement(News_page_Title).getText();
								webdriver.close();
								webdriver.switchTo().window(Parent_Window);
								if(Page_news_title.equalsIgnoreCase(tab_titel_text))
								{Flag=true;}
								else
								{Flag=false;}
								break;
							}
							else{
								Flag=false;
							}
						}
					}catch(Exception error){}



				}catch(Exception error){}
			}
			else
			{// no data found
				utilfunc.scrollToTop();

				System.out.println("No Data Found!");
				error_msg="No Data Found!";
				Flag=false;

			}
			}catch(Exception error){}
			if(Flag==false)
			{
				System.out.println("Please wait we are checking for error... ... ...");
				try{
					error_flag=utilfunc.ErrorMessagehandlerExperiment();
				}
				catch(Exception e){}
				
				System.out.println("We are done with error check.");
				System.out.println("error_flag---"+error_flag);
				if(error_flag.equals("Server Error in '/' Application.")){
					Flag=false;
					utilfunc.TakeScreenshot();
				}
				else if (error_flag.equals(ExpectedErrorMessage)){
					Flag=true;
					utilfunc.TakeScreenshot();
				}
				else if (error_msg.equals(ExpectedErrorMessage)){
					Flag=true;
					utilfunc.globalerrormessage=error_msg;
					utilfunc.ErrorMessage4=error_msg;
					utilfunc.TakeScreenshot();
					Thread.sleep(1000);
				}
				else
				{
					Flag=false;
					utilfunc.TakeScreenshot();
				}

			}

			}
			
			return Flag;
		}

}
