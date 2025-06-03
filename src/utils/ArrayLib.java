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
	
	public static String[] cast(ArrayList<String> items) {
		String[] data = new String[items.size()];
		
		for (int i = 0; i < items.size(); i++) {
			data[i] = items.get(i);
		}
		
		return data;
	}
}
