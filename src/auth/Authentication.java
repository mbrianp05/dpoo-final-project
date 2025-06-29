package auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import utils.Validation;

public class Authentication {
	private static boolean hasAccess = false;

	public static boolean hasSource() {
		File source = new File("passcode.txt");
		boolean result = false;

		if (source.exists() && !source.isDirectory()) {
			Scanner reader;
			try {
				reader = new Scanner(source);

				String realUsername = reader.nextLine().trim();
				String realPassword = reader.nextLine().trim();

				result = realUsername != null && realPassword != null;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static void setCredentials(String username, String password) {
		if (!Validation.validGmail(username)) {
			throw new IllegalArgumentException("Given username is not a valid gmail address");
		}

		if (!Validation.validPassword(password)) {
			throw new IllegalArgumentException("Given password is not valid");
		}

		if (!hasSource()) {

			Path path = Paths.get("passcode.txt");

			if (!Files.exists(path)) {
				try {
					Files.createFile(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				File source = new File("passcode.txt");
				FileWriter writer = new FileWriter(source);

				writer.write(username.trim() + "\n" + password.trim());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

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
			System.out.println("No se pudo encontrar la fuente del código de acceso");
		}

		return correctCredentials;
	}

	public static boolean authorize(String username, String password) {
		hasAccess = validateCredentials(username, password);

		return hasAccess;
	}

	public static boolean hasAccess() {
		// return hasAccess;
		return true;
	}
}
