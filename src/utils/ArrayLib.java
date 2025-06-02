package utils;

import java.util.ArrayList;

public class ArrayLib {
	public static String join(ArrayList<String> items) {
		String result = "";
		
		for (int i = 0; i < items.size(); i++) {
			result += items.get(i);
			
			if (i + 1 != items.size()) {
				if (i == items.size() - 2) {
					result += " y ";
				} else {
					result += ", ";
				}
			}
		}
		
		return result;
	}
}
