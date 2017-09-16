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
			String result = encrypt(args[2], codeKey, workType);
			System.out.println(result);
		}
		catch (Exception e) {
			System.out.println("CaesarCipher error:\n" + e.getMessage());
			//System.exit(EXIT_FAILURE);
		}

		//System.exit(EXIT_SUCCESS);
	}

	private static final Integer ARGUMENTS_COUNT = 3;
	private static final Integer MAX_KEY = Integer.MAX_VALUE;
	private static final Integer EXIT_SUCCESS = 0;
	private static final Integer EXIT_FAILURE = 1;
	private static final String DECODE_KEY = "-d";
	private static final String ENCODE_KEY = "-e";
	private static final Integer MAX_LOWER_CODE = "z".codePointAt(0);
	private static final Integer MAX_UPPER_CODE = "Z".codePointAt(0);
	private static final Integer MIN_LOWER_CODE = "a".codePointAt(0);
	private static final Integer MIN_UPPER_CODE = "A".codePointAt(0);
	private static final Integer MAX_MOVEMENT = MAX_LOWER_CODE - MIN_LOWER_CODE;
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
	private static String encrypt(String str, Integer key, WorkType workType) {

		System.out.println(moveToRightInEngAlphabet('A', 25));

		String result = "";
		return result;
	}
	private static char moveToRightInEngAlphabet(char ch, Integer movement) {
		if (ch < 'A' || (ch > 'Z' && ch < 'a') || ch > 'z') {
			throw new IllegalArgumentException("Illegal symbol in encode string.\n" +
				"Use a-zA-Z alphabet only.");
		} else if (movement <= 0) {
			return ch;
		}

		movement = movement % (MAX_MOVEMENT + 1);
		boolean isUpper = Character.isUpperCase(ch);
		Integer maxCode = (isUpper) ? MAX_UPPER_CODE : MAX_LOWER_CODE;
		Integer minCode = (isUpper) ? MAX_LOWER_CODE : MIN_LOWER_CODE;
		Integer newCode = ch + movement;
		newCode = (newCode > maxCode) ? minCode + (newCode - maxCode) : newCode;

		return Character.toChars(newCode)[0];
	}
}

interface Operationable{
	void convertationError();
}

//Character.toChars(43)