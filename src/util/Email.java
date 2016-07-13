package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import CIMS.CIMS_Company;
import CIMS.CIMS_Left_Navigation;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Email 
{

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
//	private static String fileName		=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator + "dashboard.html";
	private static String fileName		=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator + "dashboard.html"; //home\\dr12\\JavaWorkspace\\CIMS\\src\\CIMS\\Reports\\dashboard.html
	private static String screenFileName		=	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports" + File.separator + "dashboard-screenshot.jpg"; 
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	
	// Add List of Email address to who email needs to be sent to


	public Email(WebDriver driver,UtilFunction utilfunc) 
	{
	this.webdriver =driver;
	this.utilfunc=utilfunc;

	}

	public  void SendMailtoUser() throws Exception
	{

//		Email sendMail = new Email(webdriver,utilfunc);
	  //String[] emailList = {"ryant@daxima.com","semani@balglobal.com","prabhakar@daxima.com","atul@daxima.com","kchiemchitvanicha@balglobal.com","npavuluri@balglobal.com"};
	  String[] emailList = {"vinod.c@daxima.com"};
	  postMail( emailList);
	  System.out.println("Sucessfully Sent mail to All Users");
	}
	 
	public void postMail(String recipients[]) throws MessagingException 
	{
		boolean debug = false;

		//Set the host smtp address
		Properties props = new Properties();

		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");	
	    props.put("mail.smtp.starttls.enable", "true");	 

	    props.put("mail.smtp.EnableSSL.enable","true");
	    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
	    props.setProperty("mail.smtp.socketFactory.fallback", "false");   
	    props.setProperty("mail.smtp.port", "465");   
	    props.setProperty("mail.smtp.socketFactory.port", "465"); 

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth ) ;
		session.setDebug(debug);

		String Date		=		getCurrentTimeStamp();

		// create a message
		Message message = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress("brij.s@daxima.com");
		message.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		message.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		message.setSubject("Cobalt Automation Report - " + Date.toString());


	     // This mail has 2 part, the BODY and the embedded image
        MimeMultipart multipart = new MimeMultipart("related");


		try {
			webdriver.get("file://"+fileName);
			System.out.println("file opened in browser");
			// taking screenshot & adding it to email
//			utilfunc.zoomOut(2);
			getscreenshot(screenFileName);
	         
			
		} catch (Exception e1) {
			System.out.println("unable to open file in browser");
		}


        // first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<strong>Cobalt Automation Report</strong><br/><br/>" +
        		"For more details please download the attachment & open the file named \"<strong>Dashboard.html</strong>\" in browser<br/><br/>" +
        		"<img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");
        // add it
        multipart.addBodyPart(messageBodyPart);

        // second part (the image)
        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(screenFileName);

        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");

        // add image to the multipart
        multipart.addBodyPart(messageBodyPart);


        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	    
	    DataSource source = new FileDataSource(fileName);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName("Dashboard.html");  


	    multipart.addBodyPart(messageBodyPart2);
        

        // put everything together
        message.setContent(multipart);


		// add attachment to email
//		Multipart multipart = getAattachment();
//		message.setContent(multipart);

/*        
        StringWriter writer = new StringWriter();
		try{
			IOUtils.copy(new FileInputStream(new File(fileName)), writer);
		}catch(Exception e){
			System.out.println("unable to read file: "+fileName);
		}

		message.setContent(writer.toString(),"text/html");
		*/


        // Send message
        Transport.send(message);

        System.out.println("Sent message successfully....");
		
		// add attachment to email
//		Multipart multipart = getAattachment();
//		msg.setContent(multipart);

	}
	
	
	public static String emailContent(){

		String fileContent	=	"";
		String fileName		=	System.getProperty("user.dir") + File.separator + "src" + File.separator + 
	    		"CIMS" + File.separator + "Reports" + File.separator + "dashboard.html";

		try{
			StringWriter writer = new StringWriter();
			IOUtils.copy(new FileInputStream(new File(fileName)), writer);
		}catch(Exception e){
			System.out.println("unable to read file: "+fileName);
		}


		return fileContent;
	}

	
	private class SMTPAuthenticator extends javax.mail.Authenticator 
	{

		public PasswordAuthentication getPasswordAuthentication()
		{
			String username = "brij.s@daxima.com";
			String password = "brij098)(*";
			return new PasswordAuthentication(username, password);
		}
	}

	public static Multipart getAattachment() throws MessagingException 
	{

		//3) create MimeBodyPart object and set your message text     
	    BodyPart messageBodyPart1 = new MimeBodyPart();  
	    messageBodyPart1.setText("Please Find the Attached as Selenium Execution Report");  
	      
	    //4) create new MimeBodyPart object and set DataHandler object to this object      
	    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	    
	    //String filename = "C:/JavaWorkspace/CIMS/test-output/index.html";//change accordingly 
//	    String filename = ("user.dir")+"//test-output/index.html";
	    String filename	=	 System.getProperty("user.dir") + File.separator + "src" + File.separator + 
	    		"CIMS" + File.separator + "Reports" + File.separator + "dashboard.html"	;
	    DataSource source = new FileDataSource(filename);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName(filename);  


	    //5) create Multipart object and add MimeBodyPart objects to this object      
	    Multipart multipart = new MimeMultipart();
	    multipart.addBodyPart(messageBodyPart1);  
	    multipart.addBodyPart(messageBodyPart2);
		return multipart;  

		
	}
	
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
	/*
	public static Multipart getAattachment() throws MessagingException 
	{

		//3) create MimeBodyPart object and set your message text     
	    BodyPart messageBodyPart1 = new MimeBodyPart();  
	    messageBodyPart1.setText("Please Find the Attached as Selenium Execution Report");  
	      
	    //4) create new MimeBodyPart object and set DataHandler object to this object      
	    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	    
	    //String filename = "C:/JavaWorkspace/CIMS/test-output/index.html";//change accordingly 
//	    String filename = ("user.dir")+"//test-output/index.html";
	    String filename	=	 System.getProperty("user.dir") + File.separator + "src" + File.separator + 
	    		"CIMS" + File.separator + "Reports" + File.separator + "dashboard.html"	;
	    DataSource source = new FileDataSource(filename);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName(filename);  


	    //5) create Multipart object and add MimeBodyPart objects to this object      
	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart1);  
	    multipart.addBodyPart(messageBodyPart2);
		return multipart;  
	  
		
	}*/


	public void getscreenshot(String Location) throws Exception 
    {
            File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File(Location));
    }
	
}

