package gui.reasearchline;

import gui.component.TitleLabel;
import gui.event.OnMovedChief;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Profesor;
import utils.Constants;

public class MoveResearcherToOtherMatterJDialog extends JDialog {
	private static final long serialVersionUID = 2259866614314741132L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public MoveResearcherToOtherMatterJDialog(Profesor profesor, String[] matters, final OnMovedChief listener) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MoveResearcherToOtherMatterJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Cambiar de materia a inevstigador");
		setBounds(100, 100, 588, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 0, 0, 0, 70, 0};
		gbl_contentPanel.rowHeights = new int[]{50, 0, 0, 30, 35, 30, 35, 50, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCambiarAlInvestigador = new JLabel("Cambiar al investigador de materia de investigaci\u00F3n");
			lblCambiarAlInvestigador.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCambiarAlInvestigador = new GridBagConstraints();
			gbc_lblCambiarAlInvestigador.gridwidth = 3;
			gbc_lblCambiarAlInvestigador.fill = GridBagConstraints.BOTH;
			gbc_lblCambiarAlInvestigador.insets = new Insets(0, 0, 5, 5);
			gbc_lblCambiarAlInvestigador.gridx = 1;
			gbc_lblCambiarAlInvestigador.gridy = 1;
			contentPanel.add(lblCambiarAlInvestigador, gbc_lblCambiarAlInvestigador);
		}
		{
			TitleLabel tlblCambiarAlInvestigador = new TitleLabel();
			tlblCambiarAlInvestigador.setText(profesor.getName());
			GridBagConstraints gbc_tlblCambiarAlInvestigador = new GridBagConstraints();
			gbc_tlblCambiarAlInvestigador.gridwidth = 3;
			gbc_tlblCambiarAlInvestigador.insets = new Insets(0, 0, 5, 5);
			gbc_tlblCambiarAlInvestigador.fill = GridBagConstraints.BOTH;
			gbc_tlblCambiarAlInvestigador.gridx = 1;
			gbc_tlblCambiarAlInvestigador.gridy = 2;
			contentPanel.add(tlblCambiarAlInvestigador, gbc_tlblCambiarAlInvestigador);
		}
			final JComboBox<String> comboBox = new JComboBox<>();
			comboBox.setMaximumRowCount(5);
			comboBox.setModel(new DefaultComboBoxModel<>(matters));
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.gridwidth = 3;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 4;
			contentPanel.add(comboBox, gbc_comboBox);
		{
			JButton okButton = new JButton("Aceptar");
			okButton.setForeground(Constants.getFormBtnForeground());
			okButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
			GridBagConstraints gbc_okButton = new GridBagConstraints();
			gbc_okButton.fill = GridBagConstraints.BOTH;
			gbc_okButton.insets = new Insets(0, 0, 5, 5);
			gbc_okButton.gridx = 2;
			gbc_okButton.gridy = 6;
			contentPanel.add(okButton, gbc_okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (listener != null) {
						listener.moved((String)comboBox.getSelectedItem());
					}
					
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_cancelButton = new GridBagConstraints();
			gbc_cancelButton.fill = GridBagConstraints.BOTH;
			gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
			gbc_cancelButton.gridx = 3;
			gbc_cancelButton.gridy = 6;
			contentPanel.add(cancelButton, gbc_cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

}
