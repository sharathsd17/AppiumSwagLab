@echo off
echo Starting Appium server...

REM Start Appium in background (minimized, no input redirection issues)
start /min "" cmd /c "appium --base-path /wd/hub --port 4723 --log-level error"

REM Give Appium server time to start
ping 127.0.0.1 -n 10 >nul
