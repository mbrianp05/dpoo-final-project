package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static HashMap<String, ArrayList<String>> storage = new HashMap<>();

	public static boolean notEmpty(String str) {
		return !str.trim().isEmpty();
	}

	public static boolean unique(String entity, String value) {
		ArrayList<String> values = storage.get(entity);
		boolean exists = false;

		if (values == null) {
			storage.put(entity, new ArrayList<String>(Arrays.asList(value)));
		} else {
			if (values.indexOf(value) == -1) {
				values.add(value);
			} else {
				exists = true;
			}
		}

		return !exists;
	}

	public static boolean validISBN(String str) {
		String cleanInput = str.replaceAll("-", "").replaceAll(" ", "").replaceAll("_", "");
		boolean valid = false;

		if (cleanInput.length() == 10 || cleanInput.length() == 13) {
			Pattern pattern = Pattern.compile("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$");
			Matcher matcher = pattern.matcher(str.trim());

			valid = matcher.find();
		}

		return valid;
	}

	public static boolean validISSN(String str) {
		boolean valid = true;

		if (valid) {
			valid = str.trim().length() == 14;

			if (valid) {
				Pattern pattern = Pattern.compile("^ISSN [0-9]{4}-(([0-9]{4})|([0-9]{3}X))$");
				Matcher matcher = pattern.matcher(str.trim());

				valid = matcher.find();
			}
		}

		return valid;
	}
	
	public static boolean validGmail(String str) {
		boolean isValid = false;
		
		 if (str != null) {
			 Pattern pattern = Pattern.compile("^(?!\\.)(?!.*\\.\\.)([a-zA-Z0-9._%+-]{1,64})@gmail\\.com$");
			 isValid = pattern.matcher(str).matches();
		 }
	        
	     return isValid;
	}

	public static void removeValue(String entity, String value) {
		ArrayList<String> values = storage.get(entity);
		
		if (values != null) {
			values.remove(value);
		}
	}

	public static boolean validPassword(String password) {
		return password.length() > 8;
	}
	
	public static boolean validName(String name) {
		boolean isValid = true;
		
		for (int i = 0; i < name.length() && isValid; i++) {
			char c = name.charAt(i);
			
			isValid = Character.isAlphabetic(c) || c == ' ';
		}
		
		return isValid;
	}
}
