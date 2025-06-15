package utils;

import java.util.Random;

public class CodeGenerator {
	public static String generateRandomCode(int length) {
		String numbers = "0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(numbers.charAt(random.nextInt(numbers.length())));
		}

		return sb.toString();
	}
}
