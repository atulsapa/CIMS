package util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;



public class Log4jXml {
	

	private  Logger Log ; //This Parameter will be set in the Calling Class(Test).
	
	
	//Below is the Constructor of the Class.
	public Log4jXml(Logger log){
		
		this.Log	=	log;
		
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\log4j.xml");
	}
	
	
	// Below Method will be used to write in Log file for Event Info.
	public  void logEventInfo(String log){
		
		Log.info("--------------------------------------");
		
		Log.info(log);
  		
	}
	

	// Below Method will be used to write in Log file for Event Error.
	public  void logEventError(String log){
		
		Log.error("xxxxxxxx An error has occured xxxxxxxx");
    	
    	Log.error(log);
		
	}
	
	
	// Below Method will be used to write in Log file for Event Warning.
	public  void logEventWarning(String log){
		
		Log.warn("******** Please check the warning log below ********");
    	
    	Log.warn(log);
		
	}
	

/*	public Logger getLog() {
		return Log;
	}

	public void setLog(Logger log) {
		Log = log;
	}*/
	
	
}