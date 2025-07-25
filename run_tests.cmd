@echo off
echo ==============================
echo 🟢 Starting Appium server...
echo ==============================

call scripts\start_appium.cmd

powershell -ExecutionPolicy Bypass -File scripts\waitForAppium.ps1

echo ==============================
echo 🧪 Running tests...
echo ==============================

mvn clean test -P AppSwag
