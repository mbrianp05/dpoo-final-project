package gui.component;

import gui.event.OnAddedInput;
import gui.event.OnDeletedInput;
import gui.report.views.BestResearchersJDialog;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.ArrayLib;
import utils.Constants;
import utils.Validation;

public class MultipleInput extends JPanel {
	private String mainLabelText;
	private String secondaryLabelText;
	private ArrayList<String> values;
	private ArrayList<String> identifiers;
	
	private OnDeletedInput removedListener;
	private OnAddedInput newListener;
	private CanBeRemoved removePermission;
	
	private String notPermittedDeletionMsg;

	public MultipleInput(String mainLabelText, String secondaryLabelText) {
		this.mainLabelText = mainLabelText;
		this.secondaryLabelText = secondaryLabelText;
		notPermittedDeletionMsg = null;
		identifiers = new ArrayList<>();
		values = new ArrayList<>();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 36, 36, 150, 0, 35, 0};
		gridBagLayout.rowHeights = new int[]{36, 35, 35, 36, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 0;
		add(getBtnEdit(), gbc_btnEdit);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 2;
		gbc_btnRemove.gridy = 0;
		add(getBtnRemove(), gbc_btnRemove);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		add(getLabel(), gbc_label);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.gridx = 5;
		gbc_button.gridy = 2;
		add(getButton(), gbc_button);
		GridBagConstraints gbc_errorMessage = new GridBagConstraints();
		gbc_errorMessage.fill = GridBagConstraints.BOTH;
		gbc_errorMessage.gridwidth = 3;
		gbc_errorMessage.gridx = 1;
		gbc_errorMessage.gridy = 3;
		add(getErrorMessage(), gbc_errorMessage);
	}

	public void setNotPermittedDeletionMsg(String msg) {
		notPermittedDeletionMsg = msg;
	}
	
	public void canRemove(CanBeRemoved voter) {
		removePermission = voter;
	}
	
	public void listenTo(OnDeletedInput listener) {
		this.removedListener = listener;
	}

	public void listenTo(OnAddedInput listener) { 
		this.newListener = listener;
	}

	private static final long serialVersionUID = 7427373212103007553L;

	private JLabel lblNewLabel;
	private JLabel label;
	private JComboBox<String> comboBox;
	private JTextField textField;
	private JButton button;
	private JButton btnEdit;
	private JButton btnRemove;
	private ErrorLabel errorMessage;

	public int amountOfItems() {
		return values.size();
	}

	public int getSelectedIndex() {
		return comboBox.getSelectedIndex();
	}
	
	public void setSelectedIndex(int index) {
		comboBox.setSelectedIndex(index);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(mainLabelText);
			lblNewLabel.setFont(Constants.getLabelFont());
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(secondaryLabelText);
			label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return label;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<>();
			comboBox.setFont(Constants.getLabelFont());
			updateCombobox();
		}
		return comboBox;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent event) {
					int eKeyCode = KeyEvent.getExtendedKeyCodeForChar(event.getKeyChar());
					
					if (eKeyCode == 10) {
						addValue();
					}
				}
			});
			textField.setColumns(10);
			textField.setFont(Constants.getLabelFont());
		}
		return textField;
	}

	public String getIdentifierAt(int index) {
		return identifiers.get(index);
	}
	
	public String getIdentifier(String value) {
		int index = values.indexOf(value);
		if (index == -1) throw new IllegalArgumentException("The value given does not exists");
		
		return getIdentifierAt(values.indexOf(value));
	}
	
	private void addValue() {
		if (Validation.notEmpty(textField.getText())) {
			comboBox.setEnabled(true);
			String newValue = textField.getText();

			errorMessage.setVisible(false);
			values.add(newValue);
			textField.setText("");

			updateCombobox();

			comboBox.setSelectedIndex(comboBox.getModel().getSize() - 1);
			identifiers.add(null);
			
			if (newListener != null) {
				newListener.newItem(newValue);
			}
		} else {
			errorMessage.setVisible(true);
		}
	}
	
	private JButton getButton() {
		if (button == null) {
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/register.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			
			button = new JButton(icon);
			button.setBorder(null);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addValue();
				}
			});
			button.setFont(Constants.getLabelFont());
		}
		return button;
	}

	private JButton getBtnEdit() {
		if (btnEdit == null) {
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/edit.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			btnEdit = new JButton(icon);
			btnEdit.setBorder(null);
			btnEdit.setVisible(false);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String newInput = JOptionPane.showInputDialog(null, "¿Cambiar " + comboBox.getSelectedItem() + "?", "Editar", JOptionPane.PLAIN_MESSAGE);

					if (newInput != null) {
						if (Validation.notEmpty(newInput)) {
							int index = comboBox.getSelectedIndex();

							values.set(index, newInput);
							updateCombobox();

							comboBox.setSelectedIndex(index);
						} else {
							JOptionPane.showMessageDialog(null, "El nuevo nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnEdit.setFont(Constants.getLabelFont());
		}
		return btnEdit;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/trash.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			btnRemove = new JButton(icon);
			btnRemove.setBorder(null);
			btnRemove.setVisible(false);
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean canBeRemoved = true;
					String item = (String)comboBox.getSelectedItem();
					
					if (removePermission != null) canBeRemoved = removePermission.granted(item);
					
					if (canBeRemoved) {
						int input = JOptionPane.showConfirmDialog(null, "¿Eliminar " + item + "?", "Eliminar materia", JOptionPane.WARNING_MESSAGE);
						
						if (input == JOptionPane.YES_OPTION) {
							int index = comboBox.getSelectedIndex();
							
							values.remove(index);
							identifiers.remove(index);
							
							if (index > 0) {
								comboBox.setSelectedIndex(index - 1);
							}
							
							updateCombobox();
							
							if (values.size() == 0) comboBox.setEnabled(false);
							
							if (removedListener != null) {
								removedListener.deletedItem(item);
							}
						}
					} else {
						String msg = "No se puede eliminar este elemento";
						if (notPermittedDeletionMsg != null) {
							msg = notPermittedDeletionMsg;
						}
						
						JOptionPane.showMessageDialog(null, msg, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnRemove.setFont(Constants.getLabelFont());
		}
		return btnRemove;
	}

	private ErrorLabel getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = new ErrorLabel();
			errorMessage.setText("El campo es requerido");
			errorMessage.setVisible(false);
		}
		return errorMessage;
	}

	private void updateCombobox() {
		comboBox.setModel(new DefaultComboBoxModel<>(getValues()));
		boolean visibility = amountOfItems() > 0;

		btnEdit.setVisible(visibility);
		btnRemove.setVisible(visibility);
		comboBox.setEnabled(values.size() != 0);
	}

	public String[] getValues() {
		return ArrayLib.cast(values);
	}

	public void reset() {
		clear();
		textField.setText("");
		errorMessage.setVisible(false);
		updateCombobox();
	}

	public ErrorLabel getErrorLbl() {
		return errorMessage;
	}
	
	public boolean has(String identifier) {
		return identifiers.contains(identifier);
	}
	
	public void clear() {
		values.clear();
		identifiers.clear();
	}

	public void with(String[] values) {
		for (String item: values) {
			if (!Validation.notEmpty(item)) throw new IllegalArgumentException("There is an empty item");
			
			this.values.add(item);
			this.identifiers.add(item);
		}
		
		updateCombobox();
	}
}
