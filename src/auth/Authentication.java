package auth;

import java.io.File;
import java.util.Scanner;

public class Authentication {
	private static boolean hasAccess = false;

	private static boolean validateCredentials(String username, String password) {
		boolean correctCredentials = false;
		
		try {
			File srcFile = new File("passcode.txt");
			Scanner reader = new Scanner(srcFile);

			String realUsername = reader.nextLine().trim();
			String realPassword = reader.nextLine().trim();
			
			correctCredentials = realUsername.equals(username) && realPassword.equals(password);
			
			reader.close();
		} catch (Exception e) {
			System.out.println("No se pudo encontrar la fuente del c�digo de acceso");
		}
	
		return correctCredentials;
	}

	public static boolean authorize(String username, String password) {
		hasAccess = validateCredentials(username, password);

		return hasAccess;
	}

	public static boolean hasAccess() {
//		 return hasAccess;
		 return true;
	}
}
