@echo off
echo Launching Appium Server...

REM Use start /B to avoid opening a new window, and let Appium run in background
start /B "" appium --base-path /wd/hub --port 4723
