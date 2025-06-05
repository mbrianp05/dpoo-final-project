package gui.reasearchline;

import gui.event.OnSetChief;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;

import schooling.Degree;
import schooling.ProfesorCategory;
import utils.Constants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddChiefJDialog extends JDialog {
	private static final long serialVersionUID = 3142798032279882910L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblName;
	private JTextField textFieldName;
	private JLabel lblCategora;
	private JComboBox<String> comboBoxCat;
	private JLabel lblCategoraCientfica;
	private JComboBox<String> comboBoxDegree;
	private JLabel lblTemaDeInvestigacin;
	private JComboBox<String> comboBoxMatter;
	private JPanel panel;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private String[] matters;
	private OnSetChief listener;

	public AddChiefJDialog(String[] matters, OnSetChief listener) {
		setResizable(false);
		this.matters = matters;
		this.listener = listener;
		
		setAlwaysOnTop(true);
		setTitle("Insertar datos el jefe de la l\u00EDnea");
		setModal(true);
		setBackground(Color.WHITE);
		setBounds(100, 100, 626, 580);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{30, 0, 30, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 35, 50, 0, 35, 50, 0, 35, 50, 0, 35, 50, 35, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		contentPanel.add(getLblName(), gbc_lblName);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 2;
		contentPanel.add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_lblCategora = new GridBagConstraints();
		gbc_lblCategora.fill = GridBagConstraints.BOTH;
		gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategora.gridx = 1;
		gbc_lblCategora.gridy = 4;
		contentPanel.add(getLblCategora(), gbc_lblCategora);
		GridBagConstraints gbc_comboBoxCat = new GridBagConstraints();
		gbc_comboBoxCat.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCat.fill = GridBagConstraints.BOTH;
		gbc_comboBoxCat.gridx = 1;
		gbc_comboBoxCat.gridy = 5;
		contentPanel.add(getComboBoxCat(), gbc_comboBoxCat);
		GridBagConstraints gbc_lblCategoraCientfica = new GridBagConstraints();
		gbc_lblCategoraCientfica.fill = GridBagConstraints.BOTH;
		gbc_lblCategoraCientfica.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoraCientfica.gridx = 1;
		gbc_lblCategoraCientfica.gridy = 7;
		contentPanel.add(getLblCategoraCientfica(), gbc_lblCategoraCientfica);
		GridBagConstraints gbc_comboBoxDegree = new GridBagConstraints();
		gbc_comboBoxDegree.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDegree.fill = GridBagConstraints.BOTH;
		gbc_comboBoxDegree.gridx = 1;
		gbc_comboBoxDegree.gridy = 8;
		contentPanel.add(getComboBox_1(), gbc_comboBoxDegree);
		GridBagConstraints gbc_lblTemaDeInvestigacin = new GridBagConstraints();
		gbc_lblTemaDeInvestigacin.fill = GridBagConstraints.BOTH;
		gbc_lblTemaDeInvestigacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemaDeInvestigacin.gridx = 1;
		gbc_lblTemaDeInvestigacin.gridy = 10;
		contentPanel.add(getLblTemaDeInvestigacin(), gbc_lblTemaDeInvestigacin);
		GridBagConstraints gbc_comboBoxMatter = new GridBagConstraints();
		gbc_comboBoxMatter.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMatter.fill = GridBagConstraints.BOTH;
		gbc_comboBoxMatter.gridx = 1;
		gbc_comboBoxMatter.gridy = 11;
		contentPanel.add(getComboBox_2(), gbc_comboBoxMatter);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 13;
		contentPanel.add(getPanel(), gbc_panel);
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JLabel getLblCategora() {
		if (lblCategora == null) {
			lblCategora = new JLabel("Categor\u00EDa");
			lblCategora.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCategora;
	}
	private JComboBox<String> getComboBoxCat() {
		if (comboBoxCat == null) {
			comboBoxCat = new JComboBox<String>();
			comboBoxCat.setModel(new DefaultComboBoxModel<>(new String[] {"Instructor", "Asistente", "Auxiliar", "Titular"}));
			comboBoxCat.setSelectedIndex(0);
		}
		return comboBoxCat;
	}
	private JLabel getLblCategoraCientfica() {
		if (lblCategoraCientfica == null) {
			lblCategoraCientfica = new JLabel("Categor\u00EDa cient\u00EDfica");
			lblCategoraCientfica.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCategoraCientfica;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBoxDegree == null) {
			comboBoxDegree = new JComboBox<String>();
			comboBoxDegree.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
			comboBoxDegree.setSelectedIndex(0);
		}
		return comboBoxDegree;
	}
	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTemaDeInvestigacin;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBoxMatter == null) {
			comboBoxMatter = new JComboBox<String>();
			comboBoxMatter.setModel(new DefaultComboBoxModel<>(matters));
		}
		return comboBoxMatter;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(getBtnAceptar());
			panel.add(getBtnCancelar());
		}
		return panel;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setForeground(Color.WHITE);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listener.set(textFieldName.getText(), getCategory(), getDegree(), getMatter());
					setVisible(false);
				}
			});
			btnAceptar.setFont(Constants.getLabelFont());
			btnAceptar.setBackground(Constants.getInsertionBtnColor());
		}
		return btnAceptar;
	}
	
	private Degree getDegree() {
		Degree degree;

		switch (comboBoxDegree.getSelectedIndex()) {
		case 1:
			degree = Degree.Master;
			break;
		case 2:
			degree = Degree.Doctor;
			break;
		case 0:
		default:
			degree = null;
		}

		return degree;
	}

	private ProfesorCategory getCategory() {
		ProfesorCategory category;

		switch (comboBoxCat.getSelectedIndex()) {
		case 0:
			category = ProfesorCategory.Instructor;
			break;
		case 1:
			category = ProfesorCategory.Assistant;
			break;
		case 2:
			category = ProfesorCategory.Auxiliar;
			break;
		case 3:
		default:
			category = ProfesorCategory.Permanent;
		}

		return category;
	}

	private String getMatter() {
		return (String)comboBoxMatter.getModel().getSelectedItem();
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnCancelar.setFont(Constants.getLabelFont());
			btnCancelar.setBackground(Color.WHITE);
		}
		return btnCancelar;
	}
}
