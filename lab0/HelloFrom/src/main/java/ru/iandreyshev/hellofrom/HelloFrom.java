package ru.iandreyshev.hellofrom;

class HelloFrom {
	public static void main(String[] args) {
		if (args.length < MyConst.MIN_ARGS_COUNT) {
			System.out.println(MyConst.ARGS_COUNT_ERROR);
			return;
		}

		String name = ConcatArgs(args);

		if (name.compareTo("") == 0) {
			System.out.println(MyConst.EMPTY_NAME_ERROR);
			return;
		}

		PrintMessage(name);
	}

	private static String ConcatArgs(String[] args) {
		String result = "";
		for (Integer i = 0; i < args.length; i++) {
			result += args[i];
		}
		return result;
	}

	private static void PrintMessage(String name) {
		System.out.printf(MyConst.MESSAGE_PATTERN, name);
		System.out.printf("%s ", System.getProperty(MyConst.OS_NAME_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.OS_VERSION_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.JDK_VERSION_KEY));
		System.out.println(System.getenv(MyConst.JDK_PATH_KEY));
	}
}