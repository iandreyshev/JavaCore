@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.hellofrom.HelloFrom
set NAME=Ivan

echo: Test: Normal argument
%COMPILE%
%PROGRAM% %NAME%

echo: Test: No args
%COMPILE%                                                                
%PROGRAM%

echo: Test: Empty argument
%COMPILE%
%PROGRAM% ""