@echo off
set COMPILE=javac @CompileOptions.txt
set PROGRAM=java -cp build/ ru.iandreyshev.typesTable.TypesTable
%COMPILE%

%PROGRAM%