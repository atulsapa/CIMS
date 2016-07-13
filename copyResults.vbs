Dim sysDate,destinationFolder
sysDate		=	now()
sysDate		=	Replace(sysDate,"/","")
sysDate		=	Replace(sysDate," ","")
sysDate		=	Replace(sysDate,":","")
sysDate		=	Left(sysDate,12)
destinationFolder	=	"C:\Selenium Results\CIMS\Run"&sysDate
set filesys=CreateObject("Scripting.FileSystemObject")
if((filesys.FolderExists("C:\Selenium Result"))=false ) Then
	filesys.CreateFolder("C:\Selenium Results")
end If
if((filesys.FolderExists("C:\Selenium Results\CIMS"))=false ) Then
	filesys.CreateFolder("C:\Selenium Results\CIMS")
end If
filesys.CreateFolder(destinationFolder)
filesys.CopyFolder "C:\JavaWorkspace\CIMS\testng-xslt\LogReport", destinationFolder&"\"
filesys.CopyFolder "C:\JavaWorkspace\CIMS\testng-xslt\test\single\output", destinationFolder&"\"
filesys.CopyFolder "C:\JavaWorkspace\CIMS\test-output", destinationFolder&"\"
If filesys.FileExists("C:\JavaWorkspace\CIMS\testng-xslt\LogReport\log4j.log") Then
   filesys.DeleteFile "C:\JavaWorkspace\CIMS\testng-xslt\LogReport\log4j.log"
End If
Set f = filesys.GetFolder("C:\JavaWorkspace\CIMS\src\testData")
Set fc = f.Files
   For Each f1 in fc
      if(f1.name="Test Data.xls") then
	  else
		f1.delete
	  end if
   Next
set fc	=	nothing
set f = nothing
set filesys	= Nothing