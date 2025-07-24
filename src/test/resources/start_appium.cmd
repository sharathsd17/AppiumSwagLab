@echo off
echo Launching Appium Server...
start "" /MIN cmd /c "appium --base-path /wd/hub --port 4723 --log-level error"
timeout /t 10 >nul
