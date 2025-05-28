package gui.views;

import gui.event.OnAddedResearcher;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import schooling.Faculty;
import schooling.Profesor;
import schooling.Researcher;

public class UpdateResearcherPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AddProfesorForm addProfesorForm;

	private Faculty faculty;
	private Profesor profesor;
	
	/**
	 * Create the dialog.
	 */
	public UpdateResearcherPopup(Faculty faculty, Profesor profesor) {
		this.profesor = profesor;
		this.faculty = faculty;
		
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDatosDelInvestigador = new JLabel("Datos del investigador");
			lblDatosDelInvestigador.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
			lblDatosDelInvestigador.setBounds(12, 13, 200, 41);
			contentPanel.add(lblDatosDelInvestigador);
		}
		contentPanel.add(getAddProfesorForm());
	}
	private AddProfesorForm getAddProfesorForm() {
		if (addProfesorForm == null) {
			addProfesorForm = new AddProfesorForm(faculty, profesor);
			addProfesorForm.listenTo(new OnAddedResearcher() {
				@Override
				public void added(Researcher researcher, String matter) {
					setVisible(false);
				}
			});
			addProfesorForm.setBounds(0, 67, 432, 103);
		}
		return addProfesorForm;
	}
}
