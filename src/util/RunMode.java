package util;

import listner.ErrorUtil;
import org.testng.SkipException;

public class RunMode extends SkipException {

	// This is the Constructor of the class.
	public RunMode(String skipMessage) {
		super(skipMessage);
	}
	

	// This method below is written to test weather current test should run or not. It is pointing to the Test Data excel in source Folder.
	public static boolean isSkip(String excelSheetName,String className){
		
		boolean skip	=	true	;
		
		String fileName	=	excelSheetName;
		
		String sheetName	=	"TestCases";
		
		String columnName_TESTCASENAME	=	"TESTCASENAME";
		
		String columnName_RUNMODE	=	"RUNMODE";
			
		try {
			
			int columnNumber_TESTCASENAME	=	UtilFunction.getColumnWithCellData(fileName,sheetName,columnName_TESTCASENAME);
			
			int columnNumber_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName,sheetName,columnName_RUNMODE);
			
			int rowCount	=	UtilFunction.usedRowCount(fileName,sheetName);
			
			for(int i = 2;i<=rowCount;i++){
				
				if(UtilFunction.getCellData(fileName, sheetName, columnNumber_TESTCASENAME, i-1).equals(className)){
					
					if(UtilFunction.getCellData(fileName, sheetName, columnNumber_RUNMODE, i-1).equals("Y")){
						
						skip	=	false;
						
					}
					
				}
				
			}
			
		}catch (Throwable e) {
			
			ErrorUtil.addVerificationFailure(new Throwable(e.getMessage()));
			
		}
		
	return skip;
		
	}

}