package gui.report.views;

import gui.component.TitleLabel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import schooling.Faculty;
import schooling.ResearchLine;
import utils.Constants;

public class TrendingMasteriesJDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	final private Color mainColor;
	final private Color borderColor;
	private JTable table;
	
	public TrendingMasteriesJDialog() {
		mainColor = new Color(238, 255, 157);
		borderColor = new Color(119, 128, 72);

		setTitle("Los planes de maestr�as con mayor cantidad de matriculados");
		setUndecorated(true);
		setModal(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBounds(100, 100, 552, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mainColor);
		contentPanel.setBorder(new CompoundBorder(new LineBorder(borderColor), new EmptyBorder(10, 10, 10, 10)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{34, 10, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			TitleLabel tlblMaestriasListas = new TitleLabel();

			ImageIcon icon = new ImageIcon(TrendingMasteriesJDialog.class.getResource("/resources/images/course.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			tlblMaestriasListas.setIcon(icon);
			tlblMaestriasListas.setText("Maestr\u00EDas con mayor matr\u00EDcula");
			GridBagConstraints gbc_tlblMaestriasListas = new GridBagConstraints();
			gbc_tlblMaestriasListas.insets = new Insets(0, 0, 5, 5);
			gbc_tlblMaestriasListas.anchor = GridBagConstraints.NORTHWEST;
			gbc_tlblMaestriasListas.gridx = 0;
			gbc_tlblMaestriasListas.gridy = 0;
			contentPanel.add(tlblMaestriasListas, gbc_tlblMaestriasListas);
		}
		{
			ImageIcon icon = new ImageIcon(TrendingMasteriesJDialog.class.getResource("/resources/images/close-x.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			final JLabel btnCloseButton = new JLabel(icon);
			
			btnCloseButton.setOpaque(false);
			btnCloseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCloseButton.setBorder(BorderFactory.createEmptyBorder());
			btnCloseButton.setBackground(new Color(0, 0, 0, 0f));
			btnCloseButton.setBackground(Color.WHITE);
			btnCloseButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			
			btnCloseButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					closeDialog();
				}
			});
			
			GridBagConstraints gbc_btnCloseButton = new GridBagConstraints();
			gbc_btnCloseButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnCloseButton.fill = GridBagConstraints.BOTH;
			gbc_btnCloseButton.gridx = 1;
			gbc_btnCloseButton.gridy = 0;
			contentPanel.add(btnCloseButton, gbc_btnCloseButton);
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
									"Maestr�a", "Matr�cula total"
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

					for (ResearchLine r: faculty.trendingMasteryPlans()) {
						((DefaultTableModel)table.getModel()).addRow(new Object[] { r.getName(), r.getMasteryPlan().getMatriculations().size() });
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
