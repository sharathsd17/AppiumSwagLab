@echo off
echo Launching Appium Server...

REM Kill if already running
for /f "tokens=5" %%a in ('netstat -aon ^| find ":4723" ^| find "LISTENING"') do (
    taskkill /F /PID %%a >nul 2>&1
)

REM Start Appium server
start "" /MIN cmd /c "appium --base-path /wd/hub --port 4723"
