package util;

import java.io.*;
import java.util.zip.*;

public class zip {
	
	
	public static void main(String[] args)  throws Exception  {

		String fileLocation			=	"";
		String archiveLocation		=	"";
		// input file 
	    FileInputStream in = new FileInputStream("F:/sometxt.txt");
	
	    // out put file 
	    ZipOutputStream out = new ZipOutputStream(new FileOutputStream("F:/tmp.zip"));
	
	    // name the file inside the zip  file 
	    out.putNextEntry(new ZipEntry("zippedjava.txt")); 
	
	    // buffer size
	    byte[] b = new byte[1024];
	    int count;
	
	    while ((count = in.read(b)) > 0) {
	        System.out.println();
	        out.write(b, 0, count);
	    }
	    out.close();
	    in.close();
	}
}
