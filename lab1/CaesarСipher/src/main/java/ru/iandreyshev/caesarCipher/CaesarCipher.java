package ru.iandreyshev.caesarCipher;

import ru.iandreyshev.utils.StrUtils;

class CaesarCipher {
	public static void main(String[] args) {
		try {
			if (args.length < ARGUMENTS_COUNT) {
				throw new IllegalArgumentException("Invalid arguments count.\n" +
					"Use: CaesarCipher.exe <work type(-e / -d)> <key> <string>.");
			}

			clearExtraSpacesFromArgs(args);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(EXIT_FAILURE);
		}

		System.exit(EXIT_SUCCESS);
	}

	private static final Integer ARGUMENTS_COUNT = 3;
	private static final Integer MAX_KEY = Integer.MAX_VALUE;
	private static final Integer EXIT_SUCCESS = 0;
	private static final Integer EXIT_FAILURE = 1;
	private static enum WorkType {
		ENCODE,
		DECODE,
	}

	private static void clearExtraSpacesFromArgs(String[] args) {
		args[0] = StrUtils.clearExtraSpaces(args[0]);
		if (args[0].compareTo("") == 0) {
			throw new IllegalArgumentException("Work type can not be empty.\n" +
				"Use: '-e' to encode or '-d' to decode.");
		}

		args[1] = StrUtils.clearExtraSpaces(args[1]);
		if (args[1].compareTo("") == 0) {
			throw new IllegalArgumentException("Cipher key can not be empty.\n" +
				"Use value from 0 to " + MAX_KEY.toString() + ".");
		}
	}

	private static String encode(String str, Integer key, WorkType workType) {
		return "";
	}
}