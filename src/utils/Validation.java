package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public static boolean notEmpty(String str) {
		return !str.trim().isEmpty();
	}
	
	public static boolean validISSN(String str) {
		 Pattern pattern = Pattern.compile("ISSN [0-9]{4}-(([0-9]{4})|([0-9]{3}X))");
		 Matcher matcher = pattern.matcher(str);
		 
		 return matcher.find();
	}
}
