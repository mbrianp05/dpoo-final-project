package utils;

import schooling.Degree;
import schooling.ProfesorCategory;
import schooling.TargetedGroup;

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
	
	public static String group(TargetedGroup group) {
		String g = "";
		
		switch (group) {
		case Wos:
			g = "Web de ciencia";
			break;
		case Group1:
			g = "Grupo 1";
			break;
		case Group2:
			g = "Grupo 2";
			break;
		case Group3:
			g = "Grupo 3";
			break;
		default:
		case Group4:
			g = "Grupo 4";
		}
		
		return g;
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
