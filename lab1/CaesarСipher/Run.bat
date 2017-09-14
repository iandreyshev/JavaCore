@echo off
chcp 1251
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.caesarCipher.CaesarCipher
set ENCODE="-e"
set DECODE="-d"
set TMP_OUT=%TEMP%\out.txt
%COMPILE%

echo:Запуск без необходимого количества аргументов
%PROGRAM% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

%PROGRAM% %ENCODE% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

%PROGRAM% %DECODE% 11 > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

echo:Запуск с пустым кодом или типом кодирования
%PROGRAM% "    " 11 string > %TMP_OUT%   
fc %TMP_OUT% reference/empty_work_type.txt
if ERRORLEVEL 1 goto err

%PROGRAM% "-e" "    " string > %TMP_OUT%
fc %TMP_OUT% reference/empty_cipher_key.txt
if ERRORLEVEL 1 goto err

echo Program testing succeeded
exit 0

:err
echo Program testing failed
exit 1