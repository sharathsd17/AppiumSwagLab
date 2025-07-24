
@echo off
echo Launching Appium Server...

REM Use npx to run appium from node_modules (local or global)
start /B "" npx appium --base-path /wd/hub --port 4723
