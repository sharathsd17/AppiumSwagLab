# Start Appium server in the background
Start-Process -NoNewWindow -FilePath "appium" -ArgumentList "--base-path /wd/hub" -PassThru | Out-Null

Write-Host "`n=============================="
Write-Host "⏳ Waiting for Appium server to be ready..."
Write-Host "==============================`n"

$maxTries = 15
$try = 0
$ready = $false

while ($try -lt $maxTries) {
    try {
        $response = Invoke-RestMethod -Uri 'http://127.0.0.1:4723/wd/hub/status' -UseBasicParsing
        if ($response.status -eq 0) {
            Write-Host "✅ Appium is ready!"
            $ready = $true
            break
        }
    } catch {
        Write-Host "⏳ Attempt $($try + 1): Waiting for Appium..."
        Start-Sleep -Seconds 2
    }
    $try++
}

if (-not $ready) {
    Write-Error "❌ Appium did not start in time."
    exit 1
}
