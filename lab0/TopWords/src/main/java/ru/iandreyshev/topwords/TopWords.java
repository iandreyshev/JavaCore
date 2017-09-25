package ru.iandreyshev.topwords;

import java.io.*;
import java.util.*;

class TopWords {
	public static void main(String[] args) {
		try {
			initArguments(args);
			readWordsToMemory();
			writeResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(EXIT_FAILURE);
		}
		System.exit(EXIT_SUCCESS);
	}

	private static final Integer ARGUMENTS_COUNT = 2;
	private static final Integer EXIT_SUCCESS = 0;
	private static final Integer EXIT_FAILURE = 1;
	private static final Integer MIN_TOP_SIZE = 1;
	private static final Integer MAX_TOP_SIZE = Integer.MAX_VALUE;

	private static Integer m_topSize;
	private static BufferedReader m_reader;
	private static Map<String, Integer> m_counter;
	private static List<HashSet<String>> m_collection;

	private static void initArguments(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			throw new IllegalArgumentException("Invalid arguments count.\n" +
				"Use: TopWords.exe <filename> <top size>.");
		}

		String fileName = args[0];
		String topSizeStr = args[1];

		try {
			FileReader fReader = new FileReader(fileName);
			m_reader = new BufferedReader(fReader);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Can not open file " + fileName + ".");
		}

		if (!tryParseInt(topSizeStr) || Integer.parseInt(topSizeStr) < MIN_TOP_SIZE) {
			throw new IllegalArgumentException("Invalid top size.\n" +
				"Size can be in range: " + MIN_TOP_SIZE + " to " + MAX_TOP_SIZE);
		}

		m_topSize = Integer.parseInt(topSizeStr);
	}
	private static void readWordsToMemory() throws IOException {
		m_counter = new HashMap<String, Integer>();
		String line;
		while ((line = m_reader.readLine()) != null) {
			Integer freq = m_counter.containsKey(line) ? m_counter.get(line) + 1 : 1;
			m_counter.put(line, freq);
		}

		m_collection = new ArrayList<HashSet<String>>();
		for (Integer i = 0; i <= m_counter.size(); ++i) {
			m_collection.add(new HashSet<String>());
		}

		for (Map.Entry<String, Integer> entry : m_counter.entrySet()) {
			HashSet<String> listByCount = m_collection.get(entry.getValue());
			listByCount.add(entry.getKey());
		}
	}
	private static void writeResult() {
		Integer topSize = m_topSize;
		for (Integer i = m_collection.size(); i != 0; --i) {
			HashSet<String> listByCount = m_collection.get(i - 1);
			Integer frequency = i - 1;
			if (listByCount.size() != 0 && topSize > 0) {
				for (String str : listByCount) {
					System.out.printf("%d: %s\n", frequency, str);
				}
				topSize--;
			}
		}
	}
	private static boolean tryParseInt(String number) {
		try {
			Integer.parseInt(number);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}