$maxRetries = 15
$retryCount = 0
$serverUrl = "http://localhost:4723/wd/hub/status"

while ($retryCount -lt $maxRetries) {
    try {
        $response = Invoke-WebRequest -Uri $serverUrl -UseBasicParsing -TimeoutSec 3
        if ($response.StatusCode -eq 200) {
            Write-Host "✅ Appium server is UP!"
            break
        }
    } catch {
        Write-Host "Waiting for Appium to be ready..."
    }
    Start-Sleep -Seconds 2
    $retryCount++
}

if ($retryCount -eq $maxRetries) {
    throw "❌ Appium server did not start in time."
}
