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
		String cleanInput = str.replaceAll("-", "").replaceAll(" ", "");
		boolean valid = unique("ISBN", cleanInput);
		
		if (valid) {
			if (cleanInput.length() == 10 || cleanInput.length() == 13) {
				Pattern pattern = Pattern.compile("^([0-9]{9}|[0-9]{12})([0-9]|X)$");
				Matcher matcher = pattern.matcher(str.trim());
				
				valid = matcher.find();
			}
		}
		
		
		return valid;
	}

	public static boolean validISSN(String str) {
		boolean valid = unique("ISSN", str);

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
}
