package ru.iandreyshev.utils;

import java.io.*;
import java.util.*;


public class Utils {
	public static ArrayList<String> readAllWords (BufferedReader reader)
	throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			result.add(line);
		}

		return result;
	}
}