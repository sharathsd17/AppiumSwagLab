@echo off
echo ==============================
echo 🟢 Starting Appium server...
echo ==============================

powershell -ExecutionPolicy Bypass -File src\test\resources\start_appium.ps1

echo ==============================
echo 🧪 Running tests...
echo ==============================

mvn clean test -P AppSwag
