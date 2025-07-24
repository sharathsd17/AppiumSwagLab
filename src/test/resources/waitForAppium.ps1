$maxTries = 30
$try = 0

while ($try -lt $maxTries) {
    try {
        $response = Invoke-WebRequest -Uri "http://localhost:4723/wd/hub/status" -UseBasicParsing -TimeoutSec 2
        if ($response.StatusCode -eq 200) {
            Write-Host "✅ Appium is ready!"
            exit 0
        }
    } catch {
        Start-Sleep -Seconds 2
        $try++
    }
}

Write-Error "❌ Appium did not start within expected time!"
exit 1
