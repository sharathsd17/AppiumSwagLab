@echo off
echo Launching Appium Server...
start /b appium --base-path /wd/hub --port 4723 --log-level error
timeout /t 2
