package CIMS.Modules.Counter;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import listner.ErrorUtil;
import util.UtilFunction;


public class CIMS_Left_Navigation_Counter 
{
	
	private String sysDate;
	private WebDriver webdriver;
	private UtilFunction utilfunc;
	
	
	@Test
	public void CIMSLeftNavigation() throws InterruptedException, IOException, AWTException 
	{
		System.out.println("hello");
		try {

			/**
			 * code for Left Navigation starts here
			 * @author Lokesh
			 */

			//initialize variables that will be used..
			String fileName							=	"Test Left Navigation Data.xls";       
			String 	LeftNavigation				=		"Left Navigation";

			int RowCount							=		UtilFunction.usedRowCount(fileName, LeftNavigation);
			int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, LeftNavigation, "Suite Name");



			// loop running for regression suites
			System.out.println("Positive Scenario"+"\t"+"Negative Scenario"+"\t"+"Module Group"+"\t"+"Module Name");
			for(int modCounter = 1;modCounter<RowCount;modCounter++){
				try{
					// counter variables for scenarios..
					int positiveScenarioCounter						=	0;
					int negativeScenarioCounter						=	0;

					String SuiteName				=		UtilFunction.getCellData(fileName, LeftNavigation, columnNumber_SuiteName, modCounter);
					String sheetName				=	SuiteName;
					int rowCount					=	UtilFunction.usedRowCount(fileName,sheetName);
					int columnNumber_Scenario		=	UtilFunction.getColumnWithCellData(fileName, sheetName, "Scenario");
					
					for(int count=1; count<rowCount; count++)
					{
						String Scenerio					=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
						if(Scenerio.equals("Positive")){
							positiveScenarioCounter++;
						}
						if(Scenerio.equals("Negative")){
							negativeScenarioCounter++;
						}
					}
					System.out.println(positiveScenarioCounter + "               \t" + negativeScenarioCounter+"                 \t"+LeftNavigation + "            \t" + sheetName);
				}catch(Exception e){
				}
			}
		}
		catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed!!!");
			utilfunc.assertion();
		}

	}

	public UtilFunction getUtilfunc() {
		return utilfunc;
	}

	public void setUtilfunc(UtilFunction utilfunc) {
		this.utilfunc = utilfunc;
	}		
}