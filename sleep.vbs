args = wScript.Arguments.Count
if args <> 1 then
wscript.Echo "usage: " & Wscript.ScriptName & " seconds to sleep" & _
vbCRLF & "Example: " & Wscript.ScriptName & " 10"
wscript.Quit
end if
wscript.sleep wscript.Arguments.Item(0) * 1000