package gui.report.views;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import gui.component.TitleLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.SwingConstants;

import schooling.Faculty;
import schooling.Researcher;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BestResearchersJDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	public BestResearchersJDialog() {
		setModal(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBounds(100, 100, 552, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{34, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			TitleLabel tlblMejoresInvetigadores = new TitleLabel();
			tlblMejoresInvetigadores.setText("Mejores invetigadores");
			GridBagConstraints gbc_tlblMejoresInvetigadores = new GridBagConstraints();
			gbc_tlblMejoresInvetigadores.insets = new Insets(0, 0, 5, 0);
			gbc_tlblMejoresInvetigadores.anchor = GridBagConstraints.NORTHWEST;
			gbc_tlblMejoresInvetigadores.gridx = 0;
			gbc_tlblMejoresInvetigadores.gridy = 0;
			contentPanel.add(tlblMejoresInvetigadores, gbc_tlblMejoresInvetigadores);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			
			String text = "<html>";
			
			Faculty faculty = Faculty.newInstance();
			
			for (Researcher r: faculty.bestResearchers()) {
				text += "Nombre: " + r.getName() + " Puntución: " + r.getScore() + "<br>";
			}
			
			lblNewLabel.setText(text + "</html>");
		}
		{
			JButton btnNewButton = new JButton("Cerrar");
			btnNewButton.setBorder(null);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.EAST;
			gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 3;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
	}

}
