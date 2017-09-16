package ru.iandreyshev.caesarCipher;

import ru.iandreyshev.utils.StrUtils;

class CaesarCipher {
	public static void main(String[] args) {
		try {
			if (args.length < ARGUMENTS_COUNT) {
				throw new IllegalArgumentException("Invalid arguments count.\n" +
					"Use: CaesarCipher.exe <work type(-e / -d)> <key> <string>.");
			}

			WorkType workType = getWorkType(args[0]);
			Integer codeKey = getCodeKey(args[1]);
			String result = encode(args[3], codeKey, workType);
			System.out.println(result);
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
	private static final String DECODE_KEY = "-d";
	private static final String ENCODE_KEY = "-e";
	private static enum WorkType {
		ENCODE,
		DECODE,
	}

	private static WorkType getWorkType(String workTypeStr) {
		workTypeStr = StrUtils.clearExtraSpaces(workTypeStr);
		if (workTypeStr.compareTo(DECODE_KEY) == 0) {
			return WorkType.DECODE;
		} else if (workTypeStr.compareTo(ENCODE_KEY) == 0) {
			return WorkType.ENCODE;
		}

		throw new IllegalArgumentException("Invalid work type.\n" +
			"Use: '-e' to encode and '-d' to decode.");
	}
	private static Integer getCodeKey(String codeKeyStr) {
		Integer result = 0;
		Operationable operation = () -> {
			throw new IllegalArgumentException("Invalid cipher key.\n" +
				"Use values from 0 to " + MAX_KEY.toString() + ".");
		};

		try {
			codeKeyStr = StrUtils.clearExtraSpaces(codeKeyStr);
			result = Integer.parseInt(codeKeyStr);
		}
		catch (Exception e) {
			operation.convertationError();
		}

		if (result < 0) {
			operation.convertationError();
		}

		return result;
	}
	private static String encode(String str, Integer key, WorkType workType) {
		return "";
	}
}

interface Operationable{
	void convertationError();
}