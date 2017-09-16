@echo off
chcp 1251
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.caesarCipher.CaesarCipher
set ENCODE="-e"
set DECODE="-d"
set TMP_OUT=%TEMP%\out.txt
%COMPILE%

echo:Run without the required number of arguments
%PROGRAM% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

%PROGRAM% %ENCODE% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

%PROGRAM% %DECODE% 11 > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

echo:Run with empty work type
%PROGRAM% "    " 11 "string" > %TMP_OUT%   
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err

echo:Run with empty cipher key
%PROGRAM% "-e" "    " "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_cipher_key.txt
if ERRORLEVEL 1 goto err

echo:Run with invalid work type, work type is 100 
%PROGRAM% "100" "10" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err

echo:Run with invalid cipher key
echo:  Cipher key is -1
%PROGRAM% ENCODE "-1" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err
  
echo:  Cipher key is 1000000000000
%PROGRAM% ENCODE "1000000000000" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err

echo:Cipher key is AAA
%PROGRAM% ENCODE "AAA" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err

%PROGRAM% -d 1 string

echo:Program testing succeeded
exit 0

:err
echo:Program testing failed
exit 1