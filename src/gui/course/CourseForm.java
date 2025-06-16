package gui.course;

import gui.event.OnCoursesFormActionTriggered;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Constants;
import utils.Validation;
import gui.component.ErrorLabel;

public class CourseForm extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblInstructor;
	private JComboBox<String> cmboxInstruct;
	private JLabel lblCredits;
	private JSpinner spinner;
	private JLabel lblDescripcin;
	private JTextArea txtDescr;
	private JButton btnSave;
	private JPanel panel;

	private int[] profIDs;
	private String[] names;

	private OnCoursesFormActionTriggered listener;
	private CourseFormData course;
	private ResearchLine line;
	private Faculty faculty;
	private ErrorLabel errorDescription;
	private JPanel panel_1;
	private ErrorLabel errorCredits;
	private ErrorLabel errorInstructor;
	private ErrorLabel errorName;

	public void listenTo(OnCoursesFormActionTriggered listener) {
		this.listener = listener;
	}

	private void fetchInstructors() {

		ArrayList<Profesor> profs = faculty.getDoctorsSelectedLine(line);
		names = new String[profs.size()];
		profIDs = new int[profs.size()];

		for(int i = 0; i < profs.size(); i++){
			names[i] = profs.get(i).getName();
			profIDs[i] = profs.get(i).getID();
		}

		cmboxInstruct.setModel(new DefaultComboBoxModel<>(names));
	}

	public CourseForm(CourseFormData data, ResearchLine line) {
		faculty = Faculty.newInstance();

		this.line = line;
		this.course = data;

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getPanel());

		hideErrors();
	}

	public void hideErrors() {
		errorName.setVisible(false);
		errorInstructor.setVisible(false);
		errorDescription.setVisible(false);
		errorCredits.setVisible(false);
	}

	private void resetForm() {
		hideErrors();

		txtName.setText("");

		if(cmboxInstruct.getModel().getSize() >= 0) {
			cmboxInstruct.setSelectedIndex(0);
		} else {
			cmboxInstruct.setSelectedIndex(-1);
		}

		spinner.setValue(0);
		txtDescr.setText("");
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¡Se ha actualizado el curso correctamente!", "Mensaje", JOptionPane.PLAIN_MESSAGE);
	}

	private void updateCourse() {
		if(Validation.notEmpty(txtName.getText())) {
			if(Validation.notEmpty(txtDescr.getText())) {
				if (cmboxInstruct.getSelectedIndex() != -1) {
					if((int)spinner.getValue() > 0) {
						int index = cmboxInstruct.getSelectedIndex();

						String name = txtName.getText();
						String description = txtDescr.getText();			
						Profesor instructor = (Profesor)faculty.findResearcher(profIDs[index]);
						int creds = (int)spinner.getValue();

						if(course == null) {
							resetForm();
						}

						if(listener != null) {
							listener.actionPerformed(new CourseFormData(name, description, instructor, creds));
						}

						sendFeedback();
					} else {
						errorCredits.setVisible(true);
					}
				} else {
					errorInstructor.setVisible(true);
				}
			} else {
				errorDescription.setVisible(true);
			}
		} else {
			errorName.setVisible(true);
		}
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			txtName.setColumns(10);

			if(course != null) {
				txtName.setText(course.getName());
			}
		}
		return txtName;
	}
	private JLabel getLblInstructor() {
		if (lblInstructor == null) {
			lblInstructor = new JLabel("Instructor");
			lblInstructor.setFont(new Font("Segoe UI", Font.PLAIN, 15));				
		}
		return lblInstructor;
	}
	private JComboBox<String> getCmboxInstruct() {
		if (cmboxInstruct == null) {
			cmboxInstruct = new JComboBox<String>();
			cmboxInstruct.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

			if(course != null) {
				cmboxInstruct.setSelectedItem(course.getInstructor());
			}

			fetchInstructors();
		}
		return cmboxInstruct;
	}
	private JLabel getLblCredits() {
		if (lblCredits == null) {
			lblCredits = new JLabel("Cr\u00E9ditos");
			lblCredits.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCredits;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

			if(course != null) {
				spinner.setValue(course.getCredits());
			}
		}
		return spinner;
	}
	private JLabel getLblDescripcin() {
		if (lblDescripcin == null) {
			lblDescripcin = new JLabel("Descripci\u00F3n");
			lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblDescripcin;
	}
	private JTextArea getTxtDescr() {
		if (txtDescr == null) {
			txtDescr = new JTextArea();
			txtDescr.setLineWrap(true);
			txtDescr.setWrapStyleWord(true);
			txtDescr.setRows(5);
			txtDescr.setTabSize(2);
			txtDescr.setColumns(10);
			txtDescr.setFont(Constants.getLabelFont());

			if(course != null) {
				txtDescr.setText(course.getDescription());
			}
		}
		return txtDescr;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Guardar");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					updateCourse();
				}
			});
			btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnSave;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{70, 0, 70, 0, 70, 0};
			gbl_panel.rowHeights = new int[]{40, 21, 35, 35, 21, 35, 35, 35, 35, 16, 90, 45, 40, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.gridwidth = 3;
			gbc_lblName.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.anchor = GridBagConstraints.NORTH;
			gbc_txtName.fill = GridBagConstraints.BOTH;
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.gridwidth = 3;
			gbc_txtName.gridx = 1;
			gbc_txtName.gridy = 2;
			panel.add(getTxtName(), gbc_txtName);
			GridBagConstraints gbc_errorName = new GridBagConstraints();
			gbc_errorName.fill = GridBagConstraints.BOTH;
			gbc_errorName.gridwidth = 3;
			gbc_errorName.insets = new Insets(0, 0, 5, 5);
			gbc_errorName.gridx = 1;
			gbc_errorName.gridy = 3;
			panel.add(getErrorLabel_2(), gbc_errorName);
			GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
			gbc_lblInstructor.gridwidth = 3;
			gbc_lblInstructor.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInstructor.gridx = 1;
			gbc_lblInstructor.gridy = 4;
			panel.add(getLblInstructor(), gbc_lblInstructor);
			GridBagConstraints gbc_cmboxInstruct = new GridBagConstraints();
			gbc_cmboxInstruct.anchor = GridBagConstraints.NORTH;
			gbc_cmboxInstruct.fill = GridBagConstraints.BOTH;
			gbc_cmboxInstruct.insets = new Insets(0, 0, 5, 5);
			gbc_cmboxInstruct.gridwidth = 3;
			gbc_cmboxInstruct.gridx = 1;
			gbc_cmboxInstruct.gridy = 5;
			panel.add(getCmboxInstruct(), gbc_cmboxInstruct);
			GridBagConstraints gbc_errorInstructor = new GridBagConstraints();
			gbc_errorInstructor.fill = GridBagConstraints.BOTH;
			gbc_errorInstructor.gridwidth = 3;
			gbc_errorInstructor.insets = new Insets(0, 0, 5, 5);
			gbc_errorInstructor.gridx = 1;
			gbc_errorInstructor.gridy = 6;
			panel.add(getErrorLabel_1(), gbc_errorInstructor);
			GridBagConstraints gbc_lblCredits = new GridBagConstraints();
			gbc_lblCredits.anchor = GridBagConstraints.WEST;
			gbc_lblCredits.fill = GridBagConstraints.VERTICAL;
			gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
			gbc_lblCredits.gridx = 1;
			gbc_lblCredits.gridy = 7;
			panel.add(getLblCredits(), gbc_lblCredits);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.fill = GridBagConstraints.BOTH;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = 7;
			panel.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_errorCredits = new GridBagConstraints();
			gbc_errorCredits.fill = GridBagConstraints.BOTH;
			gbc_errorCredits.insets = new Insets(0, 0, 5, 5);
			gbc_errorCredits.gridx = 3;
			gbc_errorCredits.gridy = 7;
			panel.add(getErrorCredits(), gbc_errorCredits);
			GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
			gbc_lblDescripcin.gridwidth = 3;
			gbc_lblDescripcin.anchor = GridBagConstraints.WEST;
			gbc_lblDescripcin.fill = GridBagConstraints.VERTICAL;
			gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcin.gridx = 1;
			gbc_lblDescripcin.gridy = 9;
			panel.add(getLblDescripcin(), gbc_lblDescripcin);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.gridwidth = 3;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 10;
			panel.add(getPanel_1(), gbc_panel_1);
			GridBagConstraints gbc_errorDescription = new GridBagConstraints();
			gbc_errorDescription.gridwidth = 3;
			gbc_errorDescription.anchor = GridBagConstraints.WEST;
			gbc_errorDescription.insets = new Insets(0, 0, 5, 5);
			gbc_errorDescription.gridx = 1;
			gbc_errorDescription.gridy = 11;
			panel.add(getErrorDescription(), gbc_errorDescription);
			GridBagConstraints gbc_btnSave = new GridBagConstraints();
			gbc_btnSave.anchor = GridBagConstraints.WEST;
			gbc_btnSave.gridwidth = 3;
			gbc_btnSave.insets = new Insets(0, 0, 0, 5);
			gbc_btnSave.fill = GridBagConstraints.VERTICAL;
			gbc_btnSave.gridx = 1;
			gbc_btnSave.gridy = 12;
			panel.add(getBtnSave(), gbc_btnSave);
		}
		return panel;
	}
	private ErrorLabel getErrorDescription() {
		if (errorDescription == null) {
			errorDescription = new ErrorLabel();
			errorDescription.setText("La descripci\u00F3n es requerida");
			errorDescription.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return errorDescription;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			panel_1.add(getTxtDescr());
		}
		return panel_1;
	}
	private ErrorLabel getErrorCredits() {
		if (errorCredits == null) {
			errorCredits = new ErrorLabel();
			errorCredits.setText("El curso debe aportar al menos 1 cr\u00E9dito");
		}
		return errorCredits;
	}
	private ErrorLabel getErrorLabel_1() {
		if (errorInstructor == null) {
			errorInstructor = new ErrorLabel();
			errorInstructor.setText("Selecciona a un instructor");
		}
		return errorInstructor;
	}
	private ErrorLabel getErrorLabel_2() {
		if (errorName == null) {
			errorName = new ErrorLabel();
			errorName.setText("El nommbre es requerido");
		}
		return errorName;
	}
}
