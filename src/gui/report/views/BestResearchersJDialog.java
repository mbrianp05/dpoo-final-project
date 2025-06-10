package gui.report.views;

import gui.component.TitleLabel;
import gui.views.ResearchersTableView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.Researcher;

public class BestResearchersJDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	public BestResearchersJDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BestResearchersJDialog.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Copy.png")));
		setTitle("Reporte de mejores invetigadores");
		setLocationRelativeTo(null);
		setModal(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBounds(100, 100, 552, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{34, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			TitleLabel tlblMejoresInvetigadores = new TitleLabel();
			
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/research.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			tlblMejoresInvetigadores.setIcon(icon);
			tlblMejoresInvetigadores.setText("Mejores invetigadores");
			GridBagConstraints gbc_tlblMejoresInvetigadores = new GridBagConstraints();
			gbc_tlblMejoresInvetigadores.insets = new Insets(0, 0, 5, 5);
			gbc_tlblMejoresInvetigadores.anchor = GridBagConstraints.NORTHWEST;
			gbc_tlblMejoresInvetigadores.gridx = 0;
			gbc_tlblMejoresInvetigadores.gridy = 0;
			contentPanel.add(tlblMejoresInvetigadores, gbc_tlblMejoresInvetigadores);
		}
		{
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/close-x.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			JButton btnNewButton = new JButton(icon);
			btnNewButton.setBorder(null);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 0;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 2;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] {
							"Nombre", "Puntuaci\u00F3n"
						}
					) {
						private static final long serialVersionUID = 6062319489520125102L;
						
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					});
					
					Faculty faculty = Faculty.newInstance();
					
					for (Researcher r: faculty.bestResearchers()) {
						((DefaultTableModel)table.getModel()).addRow(new Object[] { r.getName(), r.getScore() });
					}
					
					table.setRowHeight(24);
					table.getColumnModel().getColumn(0).setPreferredWidth(150);
					table.getColumnModel().getColumn(1).setPreferredWidth(80);
					table.setFillsViewportHeight(true);
					table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
					scrollPane.setViewportView(table);
				}
			}
		}
	}

}
