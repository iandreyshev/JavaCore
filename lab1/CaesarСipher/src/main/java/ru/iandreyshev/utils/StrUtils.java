package ru.iandreyshev.utils;

public class StrUtils {
	public static String clearExtraSpaces(String str) {
		char[] cStr = str.toCharArray();
		Integer startPos = 0;
		for (; startPos < cStr.length; startPos++) {
			if (cStr[startPos] != SPACE) {
				break;
			}
		}

		if (startPos >= cStr.length) {
			return "";
		}

		Integer endPos = cStr.length - 1;
		for (; endPos >= 0; endPos--) {
			if (cStr[endPos] != SPACE) {
				break;
			}
		}

		String result = "";
		for (; startPos <= endPos; startPos++) {
			result += cStr[startPos];
		}

		return result;
	}

	private static char SPACE = ' ';
}