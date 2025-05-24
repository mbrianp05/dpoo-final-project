package auth;

import java.io.File;
import java.util.Scanner;

public class Authentication {
	public static boolean validateAccessCode(String code) {
		boolean granted = false;

		try {
			File srcFile = new File("passcode.txt");
			Scanner reader = new Scanner(srcFile);

			String line = reader.nextLine();

			granted = line.equals(code);
			reader.close();
		} catch (Exception e) {
			System.out.println("No se pudo encontrar la fuente del c�digo de acceso");
		}

		return granted;
	}
}
