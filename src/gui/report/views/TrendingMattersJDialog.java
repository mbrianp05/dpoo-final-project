package gui.report.views;

import gui.component.TitleLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import schooling.Faculty;
import schooling.ResearchMatter;
import utils.Constants;

public class TrendingMattersJDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	final private Color mainColor;
	final private Color borderColor;

	public TrendingMattersJDialog() {
		mainColor = new Color(136, 255, 255);
		borderColor = new Color(25, 128, 128);
		
		setTitle("Los temas de investigación más populares");
		setUndecorated(true);
		setModal(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBounds(100, 100, 552, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mainColor);
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{34, 10, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			TitleLabel tlblMejoresInvetigadores = new TitleLabel();

			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/research.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			tlblMejoresInvetigadores.setIcon(icon);
			tlblMejoresInvetigadores.setText("Temas populares");
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

			JLabel btnNewButton = new JLabel(icon);
			btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					closeDialog();
				}
			});
			btnNewButton.setBorder(BorderFactory.createEmptyBorder());
			btnNewButton.setBackground(new Color(0, 0, 0, 0f));
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
					table.setFont(Constants.getLabelFont());
					table.setModel(new DefaultTableModel(
							new Object[][] {},
							new String[] {
									"Materia de investigación", "Cantidad de investigadores"
							}
							) {
						private static final long serialVersionUID = 6062319489520125102L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					});
					table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
						@Override
						public Component getTableCellRendererComponent(JTable table, Object value,
								boolean isSelected, boolean hasFocus, int row, int column) {
							JLabel label = new JLabel(value.toString());
							label.setFont(Constants.getLabelFont().deriveFont(Font.PLAIN, 17));
							label.setBackground(mainColor);
							label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, borderColor));
							label.setOpaque(true);
							
							return label;
						}
					});
					table.getTableHeader().setReorderingAllowed(false);

					Faculty faculty = Faculty.newInstance();

					for (ResearchMatter r: faculty.trendingMatters()) {
						((DefaultTableModel)table.getModel()).addRow(new Object[] { r.getName(), r.getResearchers().size() });
					}

					
					table.setEnabled(false);
					table.setBackground(mainColor);
					table.setGridColor(mainColor);
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

	private void closeDialog() {
		dispose();
	}
}
