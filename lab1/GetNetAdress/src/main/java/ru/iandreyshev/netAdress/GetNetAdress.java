package ru.iandreyshev.netAdress;

class GetNetAdress {
	public static void main(String[] args) {
		try {
			validateArgs(args);
			IPAdress adress = new IPAdress(args[0]);
			IPAdress netMask = new IPAdress(args[1]);
			IPAdress netAdress = IPAdress.getNetAdress(adress, netMask);
			if (netAdress == null) {
				throw new Exception("Memory error. Can not to create IPAdress object.");
			}
			System.out.println(netAdress.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void validateArgs(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			throw new IllegalArgumentException("Invalid arguments count.\n" +
				"Use: GetNetAdress.exe <IP adress> <Net mask>.");
		}
	}

	private static final Integer ARGUMENTS_COUNT = 2;
}