@echo off
chcp 1251
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.caesarCipher.CaesarCipher
set ENCODE="-e"
set DECODE="-d"
set TMP_OUT=%TEMP%/out.txt
%COMPILE%

echo:Запуск без необходимого количества аргументов
%PROGRAM%
if %ERRORLEVEL% EQU 0 goto err
%PROGRAM% %ENCODE%
if %ERRORLEVEL% EQU 0 goto err
%PROGRAM% %DECODE% 11
if %ERRORLEVEL% EQU 0 goto err

echo Program testing succeeded
exit 0

:err
echo Program testing failed
exit 1