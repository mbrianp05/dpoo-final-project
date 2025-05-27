package auth;

import java.io.File;
import java.util.Scanner;

public class Authentication {
	private static boolean hasAccess = false;
	private static String accessCode;
	
	private static String fetchAccessCode() {
		if (accessCode == null) {
			try {
				File srcFile = new File("passcode.txt");
				Scanner reader = new Scanner(srcFile);

				accessCode = reader.nextLine();
				reader.close();
			} catch (Exception e) {
				System.out.println("No se pudo encontrar la fuente del c�digo de acceso");
			}
		}
	
		return accessCode;
	}
	
	public static int accessCodeLength() {
		return fetchAccessCode().length();
	}

	private static boolean validateAccessCode(String code) {
		return fetchAccessCode().equals(code);
	}

	public static boolean authorize(String passcode) {
		hasAccess = validateAccessCode(passcode);

		return hasAccess;
	}

	public static boolean hasAccess() {
		return hasAccess;
	}
}
