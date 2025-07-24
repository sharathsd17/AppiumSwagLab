@echo off
echo ========== Starting Appium server ==========
call src\test\resources\start_appium.cmd

echo ========== Waiting for Appium to be ready ==========
powershell -Command ^
    "$maxTries = 15; $try = 0; while ($try -lt $maxTries) { ^
        try { ^
            $response = Invoke-RestMethod http://127.0.0.1:4723/wd/hub/status; ^
            if ($response.status -eq 0) { Write-Host 'Appium is ready'; break } ^
        } catch { Write-Host 'Waiting for Appium...'; Start-Sleep -Seconds 2 } ^
        $try++ ^
    }; ^
    if ($try -eq $maxTries) { Write-Host 'Appium did not start in time'; exit 1 }"

echo ========== Running Maven Tests ==========
mvn clean test
