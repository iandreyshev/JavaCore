package ru.iandreyshev.topwords;

import java.io.FileReader;
import java.io.BufferedReader;

class TopWords {
	public static void main(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			System.out.println("Invalid arguments count. " +
				"Use: TopWords.exe <filename>.");
			return;
		}

		try	{
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			WordsCounter counter = new WordsCounter(reader);
			System.out.printf(counter.getTopWords());
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	private static final Integer ARGUMENTS_COUNT = 1;
}