package ru.iandreyshev.typesTable;

class TypesTable {
	public static void main(String[] args) {
		System.out.printf(HEAD_PATTERN, "Type", "Min", "Max", "Size");
		System.out.printf(INT_PATTERN, "Long", -Long.MAX_VALUE - 1, Long.MAX_VALUE, Long.SIZE / 8);
		System.out.printf(INT_PATTERN, "Integer", -Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.SIZE / 8);
		System.out.printf(INT_PATTERN, "Short", -Short.MAX_VALUE - 1, Short.MAX_VALUE, Short.SIZE / 8);
		System.out.printf(INT_PATTERN, "Byte", -Byte.MAX_VALUE - 1, Byte.MAX_VALUE, Byte.SIZE / 8);
		System.out.printf(FLOAT_PATTERN, "Double", -Double.MAX_VALUE - 1, Double.MAX_VALUE, Double.SIZE / 8);
		System.out.printf(FLOAT_PATTERN, "Float", -Float.MAX_VALUE - 1, Float.MAX_VALUE, Float.SIZE / 8);
		System.out.printf(INT_PATTERN, "Char", -Character.MAX_VALUE - 1, Character.MAX_VALUE + 0, Character.SIZE / 8);
	}

	private static final String HEAD_PATTERN = "%-24s%-24s%-24s%-24s\n";
	private static final String INT_PATTERN = "%-24s%-24d%-24d%-24d\n";
	private static final String FLOAT_PATTERN = "%-24s%-24.1f%-24.1f%-24d\n";
}