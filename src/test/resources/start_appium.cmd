@echo off
echo Launching Appium Server...

REM Kill any old Appium instance on port 4723
for /f "tokens=5" %%a in ('netstat -aon ^| find ":4723" ^| find "LISTENING"') do (
    taskkill /F /PID %%a
)

REM Start Appium minimized in the background
start "" /MIN cmd /c "appium --base-path /wd/hub --port 4723 --log-level error"
