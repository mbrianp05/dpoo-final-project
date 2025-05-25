import auth.Authentication;
// import schooling.Chapter;

public class Testing {
	public static void main(String[] args) {
		// Chapter ch = new Chapter("Cells", new String[]{"Brian"}, new String[]{""},
		// "Nature", "ISSN 0302-0000", "Natural Selection", 1);
		boolean granted = Authentication.authorize("XABA");

		if (granted) {
			System.out.println("Estas autenticado");
		} else {
			System.out.println("Acceso denegado");
		}
	}
}
