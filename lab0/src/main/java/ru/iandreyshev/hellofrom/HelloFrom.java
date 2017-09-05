package ru.iandreyshev.hellofrom;

class HelloFrom {
	public static void main(String[] args) {
		System.out.printf("%s ", MyConst.HELLO_MESSAGE);
		System.out.printf("%s ", System.getProperty(MyConst.OS_NAME_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.OS_VERSION_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.JDK_VERSION_KEY));
		System.out.printf("%s ", System.getProperty(MyConst.JDK_PATH_KEY));
	}
}