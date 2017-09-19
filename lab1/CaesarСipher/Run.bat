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

echo:Run with invalid work type, work type is 100 
%PROGRAM% "100" "10" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_work_type.txt
if ERRORLEVEL 1 goto err

echo:Run with invalid cipher key
echo:  Cipher key is -1
%PROGRAM% %ENCODE% "-1" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_cipher_key.txt
if ERRORLEVEL 1 goto err
echo:  Cipher key is 1000000000000
%PROGRAM% %ENCODE% "1000000000000" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_cipher_key.txt
if ERRORLEVEL 1 goto err
echo:Cipher key is AAA
%PROGRAM% %ENCODE% "AAA" "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_cipher_key.txt
if ERRORLEVEL 1 goto err
echo:Run with empty cipher key
%PROGRAM% "-e" "    " "string" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_cipher_key.txt
if ERRORLEVEL 1 goto err

echo:Convert str aaa to ccc with work type -e and key 2
%PROGRAM% %ENCODE% 2 "aaa" > %TMP_OUT%
fc %TMP_OUT% reference/ccc.txt
if ERRORLEVEL 1 goto err

echo:Convert str ccc to aaa with work type -d and key 2
%PROGRAM% %DECODE% 2 "ccc" > %TMP_OUT%
fc %TMP_OUT% reference/aaa.txt
if ERRORLEVEL 1 goto err

echo:Convert str aaa to aaa with work type -e and key 26
%PROGRAM% %ENCODE% 26 "aaa" > %TMP_OUT%
fc %TMP_OUT% reference/aaa.txt
if ERRORLEVEL 1 goto err

echo:Convert str aaa to aaa with work type -d and key 52
%PROGRAM% %DECODE% 52 "aaa" > %TMP_OUT%
fc %TMP_OUT% reference/aaa.txt
if ERRORLEVEL 1 goto err

echo:Program testing succeeded
exit 0

:err
echo:Program testing failed
exit 1