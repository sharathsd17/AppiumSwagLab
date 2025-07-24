@echo off
echo ==============================
echo 🟢 Starting Appium server...
echo ==============================

:: Start Appium in background
start /B appium --base-path /wd/hub > appium_log.txt 2>&1

:: Wait for Appium to be ready using PowerShell
echo ==============================
echo ⏳ Waiting for Appium server to be ready...
echo ==============================

powershell -NoProfile -Command ^
  "$maxTries = 15; $try = 0; while ($try -lt $maxTries) { ^
    try { ^
      $response = Invoke-RestMethod -Uri 'http://127.0.0.1:4723/wd/hub/status' -TimeoutSec 2; ^
      if ($response.status -eq 0) { Write-Host '✅ Appium is ready'; exit 0 } ^
    } catch {} ^
    Start-Sleep -Seconds 2; $try++ ^
  }; Write-Error '❌ Appium did not start in time'; exit 1"
