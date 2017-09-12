package ru.iandreyshev.topwords;

import java.io.BufferedReader;
import java.util.

class WordsCounter {
	public WordsCounter(BufferedReader reader) {
		try {
			m_topCount = Integer.parseInt(reader.readLine());
		}
		catch(Exception e) {
		}
	}

	public String getTopWords() {
		return m_topCount.toString();
	}

	private Integer m_topCount = 0;
}