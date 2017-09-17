@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.createPassword.CreatePassword
%COMPILE%

%PROGRAM% 6 "BBB47234932409fjsiodfoadhguifda__+_+_+"