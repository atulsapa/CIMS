package util;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.*;


public class questionariesutility {
	private WebDriver webdriver;		
		private UtilFunction utilfunc;
	
	public questionariesutility(WebDriver driver,UtilFunction utilfunc){
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	
	
	private CIMS_Login obj_CIMS_Login;
	
	public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
		this.obj_CIMS_Login = setobj_CIMS_Login;
	}
public  void questionaries(String object,String fileName,String sheetName1,String columnName,int columnNumber_RUNMODE1,int rowCount1){
	for(int newcounter=1;newcounter<rowCount1;newcounter++){
		if(UtilFunction.getCellData(fileName, sheetName1, columnNumber_RUNMODE1, newcounter).equals("Y")){
		
			try{
				String BasicInformationPage_flag=object+Integer.toString(newcounter);
				/*if (BasicInformationPage_flag){
					
					Reporter.log("3. Exceution Status - PASS");
					Reporter.log("4. Sucess Message - ");
					
					System.out.println("User is Sucessfully Saved the Health_Insurance Information");	
				}
				else{
					Reporter.log("3. Exceution Status - FAIL");
					Reporter.log("4. Error Message - ");
					System.out.println("User is Getting an Error Message while saveing the Information");
					
					obj_CIMS_Login.TakeScreenshot();
				}*/
			}catch(Exception e){
				ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
				System.out.println("Script Failed");
				utilfunc.assertion();			
				obj_CIMS_Login.TakeScreenshot();
			}
			
			
		}
	}
}}

