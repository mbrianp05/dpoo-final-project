package gui.reasearchline;

import gui.event.OnCoursesFormActionTriggered;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CourseForm extends JPanel {
	public CourseForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{500, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(getPanel(), gbc_panel);
	}

	private static final long serialVersionUID = 1L;
	private OnCoursesFormActionTriggered listener;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblInstructor;
	private JComboBox cmboxInstruct;
	private JLabel lblCredits;
	private JSpinner spinner;
	private JLabel lblDescripcin;
	private JTextField textField;
	private JButton btnSave;
	private JPanel panel;
	
	public void listenTo(OnCoursesFormActionTriggered listener) {
		this.listener = listener;
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
	private JComboBox getCmboxInstruct() {
		if (cmboxInstruct == null) {
			cmboxInstruct = new JComboBox();
			cmboxInstruct.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Guardar");
			btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnSave;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{97, 311, 0};
			gbl_panel.rowHeights = new int[]{21, 27, 21, 27, 16, 22, 16, 90, 45, 40, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.anchor = GridBagConstraints.NORTH;
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.insets = new Insets(0, 0, 5, 0);
			gbc_txtName.gridwidth = 2;
			gbc_txtName.gridx = 0;
			gbc_txtName.gridy = 1;
			panel.add(getTxtName(), gbc_txtName);
			GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
			gbc_lblInstructor.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInstructor.gridx = 0;
			gbc_lblInstructor.gridy = 2;
			panel.add(getLblInstructor(), gbc_lblInstructor);
			GridBagConstraints gbc_cmboxInstruct = new GridBagConstraints();
			gbc_cmboxInstruct.anchor = GridBagConstraints.NORTH;
			gbc_cmboxInstruct.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmboxInstruct.insets = new Insets(0, 0, 5, 0);
			gbc_cmboxInstruct.gridwidth = 2;
			gbc_cmboxInstruct.gridx = 0;
			gbc_cmboxInstruct.gridy = 3;
			panel.add(getCmboxInstruct(), gbc_cmboxInstruct);
			GridBagConstraints gbc_lblCredits = new GridBagConstraints();
			gbc_lblCredits.anchor = GridBagConstraints.WEST;
			gbc_lblCredits.fill = GridBagConstraints.VERTICAL;
			gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
			gbc_lblCredits.gridx = 0;
			gbc_lblCredits.gridy = 4;
			panel.add(getLblCredits(), gbc_lblCredits);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.fill = GridBagConstraints.VERTICAL;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 0;
			gbc_spinner.gridy = 5;
			panel.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
			gbc_lblDescripcin.anchor = GridBagConstraints.WEST;
			gbc_lblDescripcin.fill = GridBagConstraints.VERTICAL;
			gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcin.gridx = 0;
			gbc_lblDescripcin.gridy = 6;
			panel.add(getLblDescripcin(), gbc_lblDescripcin);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridwidth = 2;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 7;
			panel.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_btnSave = new GridBagConstraints();
			gbc_btnSave.insets = new Insets(0, 0, 0, 5);
			gbc_btnSave.fill = GridBagConstraints.VERTICAL;
			gbc_btnSave.gridx = 0;
			gbc_btnSave.gridy = 9;
			panel.add(getBtnSave(), gbc_btnSave);
		}
		return panel;
	}
}
