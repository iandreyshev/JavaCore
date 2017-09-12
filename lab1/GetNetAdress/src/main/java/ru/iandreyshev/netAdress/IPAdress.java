package ru.iandreyshev.netAdress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPAdress {
	public IPAdress(String name) {
		if (isNameValid(name)) {
			m_firstPar = 1;
		}
	}

	public static IPAdress getNetAdress(IPAdress adress, IPAdress netMask) {
		return null;
	}

	public String toString() {
		return (
			m_firstPar.toString() + "." +
			m_secondPart.toString() + "." +
			m_thirdPart.toString() + "." +
			m_fourthPart.toString());
	}

	private Integer m_firstPar = 0;
	private Integer m_secondPart = 0;
	private Integer m_thirdPart = 0;
	private Integer m_fourthPart = 0;

	private final String NAME_PATTERN = (
		"((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");

	private boolean isNameValid(String name) {
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
}