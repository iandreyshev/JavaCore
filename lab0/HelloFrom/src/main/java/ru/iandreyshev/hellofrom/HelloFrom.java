package ru.iandreyshev.hellofrom;

class HelloFrom {
	public static void main(String[] args) {
		if (args.length < MyConst.ARGS_COUNT) {
			System.out.println(MyConst.ARGS_COUNT_ERROR);
			return;
		}

		if (args[0] == "") {
			System.out.println(MyConst.EMPTY_NAME_ERROR);
			return;
		}

		PrintMessage(args[0]);
	}

	private static void PrintMessage(String name) {
		System.out.printf(MyConst.MESSAGE_PATTERN, name);
		System.out.printf("%s ", System.getProperty(MyConst.OS_NAME_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.OS_VERSION_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.JDK_VERSION_KEY));
		System.out.println(System.getenv(MyConst.JDK_PATH_KEY));
	}
}