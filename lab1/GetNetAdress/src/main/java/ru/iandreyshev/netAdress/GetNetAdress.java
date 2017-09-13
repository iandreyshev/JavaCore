package ru.iandreyshev.netAdress;

class GetNetAdress {
	public static void main(String[] args) {
		if (args.length < ARGUMENTS_COUNT) {
			System.out.println("Invalid arguments count " +
				"Use: GetNetAdress.exe <IP adress> <Net mask>.");
			return;
		}

		try {
			IPAdress adress = new IPAdress(args[0]);
			IPAdress netMask = new IPAdress(args[1]);
			IPAdress netAdress = IPAdress.getNetAdress(adress, netMask);
			if (netAdress == null) {
				throw new Exception("Net adress is null");
			}
			System.out.println(netAdress.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	}

	private static final Integer ARGUMENTS_COUNT = 2;
}