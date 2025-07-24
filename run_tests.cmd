@echo off
echo ==============================
echo 🟢 Starting Appium server...
echo ==============================

call src\test\resources\start_appium.cmd

echo ==============================
echo ⏳ Waiting for Appium server to be ready...
echo ==============================

powershell -Command ^
  "$maxTries = 15; $try = 0; while ($try -lt $maxTries) { try { $r = Invoke-RestMethod -Uri 'http://127.0.0.1:4723/wd/hub/status'; if ($r.status -eq 0) { Write-Host '✅ Appium is ready'; exit 0 } } catch { Write-Host '⏳ Still waiting...'; Start-Sleep -Seconds 2 }; $try++ }; Write-Host '❌ Appium server failed to start. Aborting test run.'; exit 1"

echo ==============================
echo 🚀 Running tests...
echo ==============================
