cd C:\JavaWorkspace\CIMS
cscript sleep.vbs 5
call TestRun.bat
cscript sleep.vbs 20
call TestResult.bat
cd ..
cscript sleep.vbs 20
cscript copyResults.vbs
cscript sleep.vbs 30