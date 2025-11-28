# Get all .java files recursively
$files = Get-ChildItem -Path "." -Recurse -Filter *.java

# Initialize total line count
$totalLines = 0

# Process each file
$results = foreach ($file in $files) {
    $lineCount = (Get-Content $file.FullName).Count
    $totalLines += $lineCount

    [PSCustomObject]@{
        FileName   = $file.Name
        LineCount  = $lineCount
    }
}

# Display individual file counts
$results | Format-Table -AutoSize

# Display total line count
Write-Host "`nTotal Lines in All .java Files: $totalLines"
