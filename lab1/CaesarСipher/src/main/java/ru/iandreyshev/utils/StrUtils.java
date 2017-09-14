package ru.iandreyshev.utils;

public class StrUtils {
	public static void clearExtraSpaces(String str) {
		Integer startPos = 0;
		for (; startPos < str.length(); startPos++) {
			if (str.charAt(startPos) != SPACE) {
				break;
			}
		}

		if (startPos >= str.length()) {
			return;
		}

		Integer endPos = str.length() - 1;
		for (; endPos >= 0; endPos--) {
			if (str.charAt(endPos) != SPACE) {
				break;
			}
		}

		String result = "";
		for (; startPos <= endPos; startPos++) {
			result += str.charAt(startPos);
		}
		str = result;
	}

	private static char SPACE = ' ';
}