package ru.iandreyshev.hellofrom;

class MyConst {
	public static final String OS_NAME_KEY = "os.name";
	public static final String OS_VERSION_KEY = "os.version";
	public static final String JDK_VERSION_KEY = "java.version";
	public static final String JDK_PATH_KEY = "JAVA_HOME";
	public static final String MESSAGE_PATTERN = "Hello, %s from: ";
	public static final String ARGS_COUNT_ERROR = "Invalid arguments count. Use: HelloFrom <name>";
	public static final String EMPTY_NAME_ERROR = "Name can not be empty.";

	public static Integer MIN_ARGS_COUNT = 1;
}