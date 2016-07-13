package util;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.Test;



public class ZipFiles {

@Test
public void main() throws InterruptedException, IOException, AWTException  {

	System.out.println("m here");;
		try {
			createArchiveForDashboardReport();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String createArchiveForDashboardReport(){

		String archiveLocation	= 	System.getProperty("user.dir") + File.separator + "src" + File.separator + "CIMS" + File.separator + "Reports";

		try {
			File directoryToZip = new File(archiveLocation);

			List<File> fileList = new ArrayList<File>();
			System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
			getAllFiles(directoryToZip, fileList);
			System.out.println("---Creating zip file");
			writeZipFile(directoryToZip, fileList);
			System.out.println("---Done");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return archiveLocation;
	}

	public String FilesListToCreateArchive(String[] FileFolderLists){
		
		String archiveLocation= System.getProperty("user.dir") + File.separator + "archive.zip";
		
		try {
			FileOutputStream fos = new FileOutputStream(archiveLocation);
			ZipOutputStream zos = new ZipOutputStream(fos);

			String file1Name = "file1.txt";
			String file2Name = "file2.txt";
			String file3Name = "folder/file3.txt";
			String file4Name = "folder/file4.txt";
			String file5Name = "f1/f2/f3/file5.txt";

			addToZipFile(file1Name, zos);
			addToZipFile(file2Name, zos);
			addToZipFile(file3Name, zos);
			addToZipFile(file4Name, zos);
			addToZipFile(file5Name, zos);

			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return archiveLocation;
	}
	

	public String addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
		
		return fileName;
	}
	
	
	public void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeZipFile(File directoryToZip, List<File> fileList) {

		try {
			FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
	IOException {
		
		FileInputStream fis = new FileInputStream(file);
		
		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);
		
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		
		zos.closeEntry();
		fis.close();
		}

	
}