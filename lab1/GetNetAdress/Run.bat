@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.netAdress.GetNetAdress

%COMPILE%
%PROGRAM% "192.192.0.255" "255.128.92.255"