@echo off
echo Launching Appium Server...

REM Start Appium using npx in background
start /B "" npx appium --base-path /wd/hub --port 4723
