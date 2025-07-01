package gui.researchers;

import schooling.Degree;
import schooling.Profesor;
import schooling.ProfesorCategory;

public final class ProfesorFormData {
	private String name;
	private String matter;
	private Degree degree;
	private ProfesorCategory category;
	
	public ProfesorFormData(String name, String matter, Degree degree, ProfesorCategory category) {
		this.name = name;
		this.matter = matter;
		this.degree = degree;
		this.category = category;
	}
	
	public static ProfesorFormData fromResearcher(Profesor profesor, String matter) {
		return new ProfesorFormData(profesor.getName(), matter, profesor.getDegree(), profesor.getCategory());
	}
	
	public String getName() {
		return name;
	}
	
	public String getMatter() {
		return matter;
	}
	public Degree getDegree() {
		return degree;
	}
	public ProfesorCategory getCategory() {
		return category;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}
}
