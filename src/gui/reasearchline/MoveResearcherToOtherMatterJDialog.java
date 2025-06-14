package gui.reasearchline;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Profesor;

import java.awt.GridBagLayout;

import gui.component.TitleLabel;
import gui.event.OnMovedChief;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MoveResearcherToOtherMatterJDialog extends JDialog {
	private static final long serialVersionUID = 2259866614314741132L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public MoveResearcherToOtherMatterJDialog(Profesor profesor, String[] matters, final OnMovedChief listener) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MoveResearcherToOtherMatterJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Cambiar de materia a inevstigador");
		setBounds(100, 100, 588, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 0, 70, 0};
		gbl_contentPanel.rowHeights = new int[]{70, 0, 0, 30, 35, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCambiarAlInvestigador = new JLabel("Cambiar al investigador de materia de investigaci\u00F3n");
			lblCambiarAlInvestigador.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCambiarAlInvestigador = new GridBagConstraints();
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
			gbc_tlblCambiarAlInvestigador.insets = new Insets(0, 0, 5, 5);
			gbc_tlblCambiarAlInvestigador.fill = GridBagConstraints.BOTH;
			gbc_tlblCambiarAlInvestigador.gridx = 1;
			gbc_tlblCambiarAlInvestigador.gridy = 2;
			contentPanel.add(tlblCambiarAlInvestigador, gbc_tlblCambiarAlInvestigador);
		}
			final JComboBox<String> comboBox = new JComboBox<>();
			comboBox.setModel(new DefaultComboBoxModel<>(matters));
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 4;
			contentPanel.add(comboBox, gbc_comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (listener != null) {
							listener.moved((String)comboBox.getSelectedItem());
						}
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
