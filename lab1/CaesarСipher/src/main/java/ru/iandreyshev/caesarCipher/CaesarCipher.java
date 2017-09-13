package ru.iandreyshev.caesarCipher;

import ru.iandreyshev.utils.StrUtils;

class CaesarCipher {
	public static void main(String[] args) {
		try {
			validateArgs(args);

			String workType = StrUtils.clearExtraSpaces(args[0]);
			String key = StrUtils.clearExtraSpaces(args[1]);
			String str = StrUtils.clearExtraSpaces(args[2]);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	}

	private static void validateArgs(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			throw new IllegalArgumentException("Invalid arguments count.\n" +
				"Use: CaesarCipher.exe <work type(-e / -d)> <key> <string>.");
		}
	}

	private static final Integer ARGUMENTS_COUNT = 3;
}