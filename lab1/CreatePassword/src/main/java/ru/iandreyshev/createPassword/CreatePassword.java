package ru.iandreyshev.createPassword;

import java.util.Random;
import java.util.Calendar;

class CreatePassword {
	public static void main(String[] args) {
		try {
			if (args.length < ARGUMENTS_COUNT) {
				throw new IllegalArgumentException("Invalid arguments count.\n" +
					"Use: CreatePassword.exe <pass length> <symbols list>.");
			}

			Integer passLength = getPassLength(args[0]);
			String symbolsList = getSymbolsList(args[1]);
			String password = getPassword(passLength, symbolsList);

			System.out.println(password);
			}
		catch(Exception e) {
			System.out.println("Error:\n" + e.getMessage());
		}
	}

	private static final Integer ARGUMENTS_COUNT = 2;
	private static final Integer MIN_PASS_LENGHT = 6;
	private static final Integer MAX_PASS_LENGTH = 36;
	private static final char ALLOWED_SYMBOLS_BEGIN = ' ' + 1;
	private static final char ALLOWED_SYMBOLS_END = '~';

	private static String getSymbolsList(String symbolsList) {
		if (symbolsList.length() == 0) {
			throw new IllegalArgumentException("Symbols list can not be empty.");
		}

		for (Integer i = 0; i < symbolsList.length(); ++i) {
			char ch = symbolsList.charAt(i);
			if (ch < ALLOWED_SYMBOLS_BEGIN || ch > ALLOWED_SYMBOLS_END) {
				throw new IllegalArgumentException(
					"Invalid symbol in list at position: " + i.toString() + ".");
			}
		}

		return symbolsList;
	}
	private static Integer getPassLength(String passLengthStr) {
		IllegalArgumentException lengthException = new IllegalArgumentException(
			"Invalid password length.\nLength can be from " +
				MIN_PASS_LENGHT.toString() + " to " +
				MAX_PASS_LENGTH.toString() + ".");
		Integer result = MIN_PASS_LENGHT;
		try {
			result = Integer.parseInt(passLengthStr);
		}
		catch (Exception e) {
			throw lengthException;
		}

		if (result < MIN_PASS_LENGHT || result > MAX_PASS_LENGTH) {
			throw lengthException;
		}

		return result;
	}
	private static String getPassword(Integer passLength, String symbolsList) {
		Integer maxListIndex = symbolsList.length() - 1;
		long currTime = Calendar.getInstance().getTimeInMillis();
		Random random = new Random(currTime);
		StringBuilder builder = new StringBuilder();

		for (Integer i = 0; i < passLength; ++i) {
			Integer randomPos = random.nextInt(maxListIndex);
			char randomCh = symbolsList.charAt(randomPos);
			builder.append(randomCh);
		}

		return builder.toString();
	}
}