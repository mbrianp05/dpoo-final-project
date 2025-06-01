package gui.researchers;

import gui.event.OnAddedResearcher;
import gui.event.OnRemovedResearcher;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Profesor;
import schooling.Researcher;

import java.awt.Color;

import schooling.Faculty;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditResearcherJDialog extends JDialog {
	private static final long serialVersionUID = -8039865322179654975L;
	private final JPanel contentPanel = new JPanel();

	private Researcher researcher;
	private Faculty faculty;

	private ProfesorForm profesorForm;
	private JPanel panel;
	private JButton btnRemove;
	private JButton btnA;
	
	private OnRemovedResearcher listener;

	public EditResearcherJDialog(Faculty faculty, Researcher researcher) {
		setAlwaysOnTop(true);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		this.researcher = researcher;
		this.faculty = faculty;

		setResizable(false);
		setTitle("Editar datos de investigador");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 897, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getPanel(), BorderLayout.SOUTH);

		if (researcher instanceof Profesor) {
			contentPanel.add(getProfesorForm(), BorderLayout.CENTER);
		}
	}

	public void listenTo(OnAddedResearcher listener) {
		if (researcher instanceof Profesor) {
			profesorForm.listenTo(listener);
		}
	}
	
	public void listenTo(OnRemovedResearcher listener) {
		this.listener = listener;
	}

	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(faculty, (Profesor)researcher);
		}

		return profesorForm;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnRemove());
			panel.add(getBtnA());
		}
		return panel;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Eliminar");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setAlwaysOnTop(false);
					int input = JOptionPane.showConfirmDialog(null, "Deseas eliminar a este investigador", null, JOptionPane.WARNING_MESSAGE);

					setAlwaysOnTop(true);
					
					if (input == JOptionPane.YES_OPTION) {
						faculty.getResearchers().remove(researcher);

						if (listener != null) {
							listener.removed(researcher.getID());
						}
						
						researcher = null;
						setVisible(false);
					}
				}
			});
			btnRemove.setBackground(Color.WHITE);
		}
		return btnRemove;
	}
	private JButton getBtnA() {
		if (btnA == null) {
			btnA = new JButton("Cerrar");
			btnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnA.setBackground(Color.WHITE);
		}
		return btnA;
	}
}
