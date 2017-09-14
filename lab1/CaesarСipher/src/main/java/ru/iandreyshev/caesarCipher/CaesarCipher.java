package ru.iandreyshev.caesarCipher;

import ru.iandreyshev.utils.StrUtils;

class CaesarCipher {
	public static void main(String[] args) {
		try {
			prepareArgs(args);

			for (Integer i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	}

	private static void prepareArgs(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			throw new IllegalArgumentException(CaesarCipherErrors.INVALID_ARGS);
		}

		for (Integer i = 0; i < ARGUMENTS_COUNT; i++) {
			args[i] = StrUtils.clearExtraSpaces(args[i]);
			if (args[i].compareTo("") == 0) {
				throw new IllegalArgumentException("Arguments can`t be empty.");
			}
		}
	}

	private static final Integer ARGUMENTS_COUNT = 3;
	private static enum WorkType {
		ENCODE,
		DECODE,
	}

	private static String encode(String str, Integer key, WorkType workType) {
		return "";
	}
}