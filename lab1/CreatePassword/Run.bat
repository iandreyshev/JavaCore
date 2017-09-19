@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.createPassword.CreatePassword
set TMP_OUT=%TEMP%\out.txt
%COMPILE%

echo:Run without all arguments.
%PROGRAM% > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

%PROGRAM% 6 > %TMP_OUT%
fc %TMP_OUT% reference/invalid_args_count.txt
if ERRORLEVEL 1 goto err

echo:Invalid pass length
%PROGRAM% 5 "abc" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_pass_len.txt
if ERRORLEVEL 1 goto err

%PROGRAM% 37 "abc" > %TMP_OUT%
fc %TMP_OUT% reference/invalid_pass_len.txt
if ERRORLEVEL 1 goto err

echo:Invalid symbol in list at position 2
%PROGRAM% 6 "ab " > %TMP_OUT%
fc %TMP_OUT% reference/invalid_symbol.txt
if ERRORLEVEL 1 goto err

echo:Empty symbols list
%PROGRAM% 6 "" > %TMP_OUT%
fc %TMP_OUT% reference/empty_symbols_list.txt
if ERRORLEVEL 1 goto err

echo:Normal password      
%PROGRAM% 6 "aaa" > %TMP_OUT%
fc %TMP_OUT% reference/normal_pass.txt
if ERRORLEVEL 1 goto err

echo:Program testing succeeded
exit 0

:err
echo:Program testing failed
exit 1