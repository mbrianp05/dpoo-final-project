package utils;

import schooling.Degree;
import schooling.ProfesorCategory;

public class EnumsDictionary {
	public static String category(ProfesorCategory category) {
		String r = "";

		switch (category) {
		case Instructor:
			r = "Instructor";
			break;
		case Assistant:
			r = "Asistente";
			break;
		case Auxiliar:
			r = "Auxiliar";
			break;
		case Permanent:
			r = "Titular";
			break;
		}
		
		return r;
	}
	
	public static String degree(Degree degree) {
		String r = "";

		if (degree == null) {
			r = "Ninguna";
		} else {
			switch (degree) {
			case Master:
				r = "Máster";
				break;
			case Doctor:
				r = "Doctor";
				break;
			}
		}
		
		return r;
	}
}
