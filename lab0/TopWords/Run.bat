@echo off
set FILE="%~1"
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.topwords.TopWords

%COMPILE%
%PROGRAM% %FILE%