@echo off
setlocal

echo ==============================
echo 🟢 Starting Appium server...
echo ==============================

:: Start Appium via internal script
call src\test\resources\start_appium.cmd

echo ==============================
echo ⏳ Waiting for Appium server to be ready...
echo ==============================

powershell -NoProfile -Command ^
  "$maxTries = 15; $try = 0; while ($try -lt $maxTries) { ^
    try { ^
      $response = Invoke-RestMethod -Uri 'http://127.0.0.1:4723/wd/hub/status'; ^
      if ($response.status -eq 0) { Write-Host '✅ Appium is ready'; break } ^
    } catch { Write-Host '⏳ Waiting for Appium...'; Start-Sleep -Seconds 2 } ^
    $try++ ^
  }; if ($try -eq $maxTries) { Write-Error '❌ Appium did not start in time'; exit 1 }"

if %ERRORLEVEL% NEQ 0 (
  echo ❌ Appium server failed to start. Aborting test run.
  exit /b 1
)

echo ==============================
echo 🚀 Running Maven tests...
echo ==============================

mvn clean test -P AppSwag

set status=%ERRORLEVEL%

if %status% NEQ 0 (
  echo ❌ Test run failed with exit code %status%
  exit /b %status%
) else (
  echo ✅ Tests completed successfully
)

endlocal
exit /b 0
