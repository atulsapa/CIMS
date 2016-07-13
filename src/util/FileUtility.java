package util;

import java.io.File;
import java.io.IOException;

import listner.ErrorUtil;

//import org.apache.commons.io.FileUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileUtility {
	

	// Below Method is used to copy source file to target file.
	public static void copyFiles(String sourceFile , String targetFile ){
		
		File sourceFile1	=	new File(sourceFile)	;
		
		File targetFile1	=	new File(targetFile)	;	
		
		try {
			FileUtils.copyFile(sourceFile1, targetFile1)	;
			
		} catch (IOException e) {
			
			ErrorUtil.addVerificationFailure(new Throwable("Error occoured coying the File : "+ e.getMessage()));

		}
		
	}
	
	
}