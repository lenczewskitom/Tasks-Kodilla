call runcrud
if "%ERRORLEVEL%" == "0" goto openurl
echo.
echo RUNCRUD has errors - breaking work
goto fail

:openurl
start "" http://localhost:8080/crud/v1/tasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.