@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.netAdress.GetNetAdress
set TMP_OUT=%TEMP%\out.txt
%COMPILE%

echo:Run without all arguments     
%PROGRAM% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err
%PROGRAM% "0.0.0.0" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

echo:Invalid ip adress
%PROGRAM% ".0.0.0" "0.0.0.0" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_ip_adress.txt
if ERRORLEVEL 1 goto err
%PROGRAM% "256.0.0.0" "0.0.0.0" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_ip_adress.txt
if ERRORLEVEL 1 goto err
%PROGRAM% "" "0.0.0.0" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_ip_adress.txt
if ERRORLEVEL 1 goto err
%PROGRAM% "0.0.0.0" "" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_ip_adress.txt
if ERRORLEVEL 1 goto err

%PROGRAM% 192.168.1.2 255.255.254.0 > %TMP_OUT%
fc %TMP_OUT% reference/normal_result.txt
if ERRORLEVEL 1 goto err

echo:Program testing succeeded
exit 0
:err
echo:Program testing failed
exit 1