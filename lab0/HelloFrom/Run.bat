@ECHO OFF
set NAME="%~1"
@ECHO ON

rem Normal output
javac @CompileOptions.txt
java -cp build/ ru.iandreyshev.hellofrom.HelloFrom %NAME%

rem No args output
javac @CompileOptions.txt
java -cp build/ ru.iandreyshev.hellofrom.HelloFrom