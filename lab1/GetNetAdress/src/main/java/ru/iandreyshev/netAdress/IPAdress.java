package ru.iandreyshev.netAdress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPAdress {
	public IPAdress(String name) throws IllegalArgumentException {
		if (!isNameValid(name)) {
			throw new IllegalArgumentException("Invalid ip adress name.\n" +
				"Use: [0-255].[0-255].[0-255].[0-255]");
		}

		String[] parts = name.split(SEPARATOR);
		m_firstPart = Integer.parseInt(parts[0]);
		m_secondPart = Integer.parseInt(parts[1]);
		m_thirdPart = Integer.parseInt(parts[2]);
		m_fourthPart = Integer.parseInt(parts[3]);
	}
	public IPAdress(Integer first, Integer second, Integer third, Integer fourth) throws IllegalArgumentException {
		if (!isPartValid(first) ||
			!isPartValid(second) ||
			!isPartValid(third) ||
			!isPartValid(fourth))
		{
			throw new IllegalArgumentException(
				"Can not create ip adress.\n" +
				"The part of ip adress(IPv4) can be only in randge" +
				"[" + MIN_PART_VALUE.toString() + ", " + MAX_PART_VALUE.toString() + "]");
		}

		m_firstPart = first;
		m_secondPart = second;
		m_thirdPart = third;
		m_fourthPart = fourth;
	}

	public static IPAdress getNetAdress(IPAdress adress, IPAdress netMask) {
		Integer newFirst = adress.m_firstPart & netMask.m_firstPart;
		Integer newSecond = adress.m_secondPart & netMask.m_secondPart;
		Integer newThird = adress.m_thirdPart & netMask.m_thirdPart;
		Integer newFourth = adress.m_fourthPart & netMask.m_fourthPart;
		return new IPAdress(newFirst, newSecond, newThird, newFourth);
	}

	public String toString() {
		return (
			m_firstPart.toString() + "." +
			m_secondPart.toString() + "." +
			m_thirdPart.toString() + "." +
			m_fourthPart.toString());
	}

	private Integer m_firstPart = 0;
	private Integer m_secondPart = 0;
	private Integer m_thirdPart = 0;
	private Integer m_fourthPart = 0;

	private static final Integer MIN_PART_VALUE = 0;
	private static final Integer MAX_PART_VALUE = 255;
	private static final String NAME_PATTERN = (
		"((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
	private static final String SEPARATOR = "\\.";

	private IPAdress() {}
	private static boolean isNameValid(String name) {
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
	private static boolean isPartValid(Integer part) {
		return part >= MIN_PART_VALUE && part <= MAX_PART_VALUE;
	}
}