package gui.researchers;

import gui.event.OnAddedResearcher;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Profesor;
import schooling.Researcher;

import java.awt.Color;

import schooling.Faculty;

import java.awt.Toolkit;

public class EditResearcherJDialog extends JDialog {
	private static final long serialVersionUID = -8039865322179654975L;
	private final JPanel contentPanel = new JPanel();

	private Researcher researcher;
	private Faculty faculty;
	
	private ProfesorForm profesorForm;
	
	public EditResearcherJDialog(Faculty faculty, Researcher researcher) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		this.researcher = researcher;
		this.faculty = faculty;
		
		setResizable(false);
		setTitle("Editar datos de investigador");
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 897, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
	
		if (researcher instanceof Profesor) {
			contentPanel.add(getProfesorForm(), BorderLayout.CENTER);
		}
	}
	
	public void listenTo(OnAddedResearcher listener) {
		if (researcher instanceof Profesor) {
			profesorForm.listenTo(listener);
		}
	}
	
	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(faculty, (Profesor)researcher);
		}
		
		return profesorForm;
	}
}
