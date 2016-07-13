package CIMS.Modules.Custom;

import java.awt.List;
import java.util.ArrayList;

import javax.mail.Flags.Flag;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;


public class Questionnaire_Assignment {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.

	public Questionnaire_Assignment(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	
	/**
	 * in order to set role's i.e, for primary company roles, BAL Contacts, Network Partner Contacts, call this function and provide following parameters filename(like Test Data.xls, Test Regression Suite.xls, etc), sheetname( like Initiate a single project, Primary company roles, etc)
	 * @param filename
	 * @param sheetName
	 * @param RoleCounterPrefixClassName
	 * @return
	 * @throws InterruptedException 
	 */

	public boolean QuestionnaireAssigment(String ExpectedErrorMessage) throws InterruptedException{


		boolean Flag	=	false;
		
//		webdriver.get("http://cobaltqa.daxima.com/SinglepageInitiation#/single/questionnaire/15459");

		String QuestionnairesCounterXPath		=	".//*[@id='panel-body-container']//*[contains(@class,'control-group')]";
		String QuestionnairesXPath				=	".//*[@id='panel-body-container']//*[contains(@class,'control-group')][yyy]//*[contains(@class,'form-row')]";
		

		try{
			int quesCounter								=		utilfunc.GetObjectCount(QuestionnairesCounterXPath);
			
			for(int q=1;q<=quesCounter;q++){

				Thread.sleep(3000);
				
				String newQuestionnairesXPath			=	QuestionnairesXPath.replace("yyy", Integer.toString(q));

				String InnerQuestionnaireCounterXPath	=	newQuestionnairesXPath+"//*[contains(@class,'input-parent')]";

				// now get inner questionnaire counters..
				System.out.println("now get inner questionnaire counter..");
			
				
				try{
					String InnerQuestionnaireXPath			=	newQuestionnairesXPath+"[www]//*[contains(@class,'input-parent')]";
				int innerQuesCount						=	utilfunc.GetObjectCount(InnerQuestionnaireCounterXPath);
				
				for(int iq=1;iq<=innerQuesCount;iq++){
					Thread.sleep(3000);
					String newInnerQuestionnairesXPath		=	InnerQuestionnaireXPath.replace("www", Integer.toString(iq));

					if(iq==1){
//						utilfunc.MakeElement(newInnerQuestionnairesXPath).;
//						utilfunc.MakeElement(newInnerQuestionnairesXPath).click();
						
						try {
							utilfunc.MakeElement(newInnerQuestionnairesXPath+"//*[@name][1]").click();
							utilfunc.selectFirstResultFromAutoSuggestion(newInnerQuestionnairesXPath+"//*[@name][1]");
						} catch (Exception e) {
							System.out.println("attempted to set first record from select drop down..");
						}
						
					}
					else{
						
						try {
							Thread.sleep(2000);
							utilfunc.MakeElement(newInnerQuestionnairesXPath+"//*[contains(@class,'questionnaireItem')][1]//table/tbody/tr/td[2]").click();
							System.out.println("in order to set first questionnaire Item " + iq);
							Thread.sleep(3000);
						} catch (Exception e) {
							System.out.println("unable to set first questionnaire Item : "+iq);
						}
					}
				}
				}catch(Exception e){
					System.out.println("issue with inner questionnaire assignment");
				}
				
				
			}
		}catch(Exception e){
			
		}
		
		// now let us click on complete button in order to assign questionnaire..
		// click on complete or next button..
		String CompletBtnXPath		=	".//*[contains(@id,'ButtonDisplayId')]";//*[contains(@class,'btn') and contains(text(),'Complete')]";
		try{
			Thread.sleep(2500);
			utilfunc.MakeElement(CompletBtnXPath).click();
			
			// handling error for ng-scope errors
			String error_flag = utilfunc.ErrorMessagehandlerExperiment();
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

			Thread.sleep(12500);
		}catch(Exception e){
			System.out.println("unable to click on complete button");
		}
		

		return Flag;
			
	}
	
}
