package gui.researchers;

import gui.component.TitleLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import schooling.Faculty;
import schooling.Matriculation;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Constants;
import javax.swing.JSeparator;

public class ResearcherResultsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ResearchLine line;
	private Profesor profesor;
	private Faculty faculty;
	private ArrayList<Matriculation> matriculations;
	

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private TitleLabel lblResearcherName;
	
	public ResearcherResultsPanel(Profesor profesor) {
		faculty = Faculty.newInstance();
		line = faculty.findResearchLineByResearcher(profesor);
		matriculations = line.getMasteryPlan().findMatriculations(profesor);
		this.profesor = profesor;

		setLayout(new BorderLayout());
		add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 0, 0, 0, 70};
		gbl_contentPanel.rowHeights = new int[]{40, 34, 10, 0, 0, 40, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblResultadosAcadmicos = new JLabel("Resultados acad\u00E9micos");
			GridBagConstraints gbc_lblResultadosAcadmicos = new GridBagConstraints();
			gbc_lblResultadosAcadmicos.gridwidth = 3;
			gbc_lblResultadosAcadmicos.fill = GridBagConstraints.BOTH;
			gbc_lblResultadosAcadmicos.insets = new Insets(0, 0, 5, 5);
			gbc_lblResultadosAcadmicos.gridx = 1;
			gbc_lblResultadosAcadmicos.gridy = 1;
			contentPanel.add(lblResultadosAcadmicos, gbc_lblResultadosAcadmicos);
		}
		{
			lblResearcherName = new TitleLabel();
			lblResearcherName.setText(profesor.getName());
			GridBagConstraints gbc_lblResearcherName = new GridBagConstraints();
			gbc_lblResearcherName.gridwidth = 3;
			gbc_lblResearcherName.insets = new Insets(0, 0, 15, 5);
			gbc_lblResearcherName.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblResearcherName.gridx = 1;
			gbc_lblResearcherName.gridy = 2;
			contentPanel.add(lblResearcherName, gbc_lblResearcherName);
		}
		{
			{
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(Constants.getFormBtnForeground(), 1));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 1;
				gbc_panel.gridy = 3;
				contentPanel.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0};
				gbl_panel.rowHeights = new int[]{30, 0, 0, 30, 0};
				gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				JLabel lblNewLabel = new JLabel("Progreso en la maestría");
				lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));

				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 10, 0, 10);
				gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel.add(lblNewLabel, gbc_lblNewLabel);
				{
					double percentage = line.getMasteryPlan().progressMade(matriculations) * 100;
					{
						JSeparator separator = new JSeparator();
						separator.setForeground(Constants.getFormBtnForeground());
						GridBagConstraints gbc_separator = new GridBagConstraints();
						gbc_separator.fill = GridBagConstraints.BOTH;
						gbc_separator.insets = new Insets(0, 0, 5, 0);
						gbc_separator.gridx = 0;
						gbc_separator.gridy = 1;
						panel.add(separator, gbc_separator);
					}
					JLabel label = new JLabel(String.valueOf(percentage) + "%");
					label.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 5, 0);
					gbc_label.gridx = 0;
					gbc_label.gridy = 2;
					panel.add(label, gbc_label);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(new Color(33, 107, 101), 1));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 2;
				gbc_panel.gridy = 3;
				contentPanel.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0};
				gbl_panel.rowHeights = new int[]{30, 0, 0, 30, 0};
				gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel lblPromedioDeNotas = new JLabel("Promedio de notas");
					lblPromedioDeNotas.setFont(new Font("Segoe UI", Font.ITALIC, 14));
					GridBagConstraints gbc_lblPromedioDeNotas = new GridBagConstraints();
					gbc_lblPromedioDeNotas.fill = GridBagConstraints.BOTH;
					gbc_lblPromedioDeNotas.insets = new Insets(0, 10, 0, 10);
					gbc_lblPromedioDeNotas.gridx = 0;
					gbc_lblPromedioDeNotas.gridy = 0;
					panel.add(lblPromedioDeNotas, gbc_lblPromedioDeNotas);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setForeground(new Color(33, 107, 101));
					GridBagConstraints gbc_separator = new GridBagConstraints();
					gbc_separator.fill = GridBagConstraints.BOTH;
					gbc_separator.insets = new Insets(0, 0, 5, 0);
					gbc_separator.gridx = 0;
					gbc_separator.gridy = 1;
					panel.add(separator, gbc_separator);
				}
				{
					JLabel label = new JLabel(String.valueOf(faculty.getAverageMarksOf(profesor.getID())));
					label.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 5, 0);
					gbc_label.gridx = 0;
					gbc_label.gridy = 2;
					panel.add(label, gbc_label);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(new Color(68,38,24), 1));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 3;
				gbc_panel.gridy = 3;
				contentPanel.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0};
				gbl_panel.rowHeights = new int[]{30, 0, 0, 30, 0};
				gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel lblAsignaturasAprobadas = new JLabel("Cursos aprobados");
					lblAsignaturasAprobadas.setFont(new Font("Segoe UI", Font.ITALIC, 14));
					GridBagConstraints gbc_lblAsignaturasAprobadas = new GridBagConstraints();
					gbc_lblAsignaturasAprobadas.fill = GridBagConstraints.BOTH;
					gbc_lblAsignaturasAprobadas.insets = new Insets(0, 10, 0, 10);
					gbc_lblAsignaturasAprobadas.gridx = 0;
					gbc_lblAsignaturasAprobadas.gridy = 0;
					panel.add(lblAsignaturasAprobadas, gbc_lblAsignaturasAprobadas);
				}
				{
					int aproved = 0;
					for (Matriculation m: matriculations) {
						if (m.getMark() >= 3) {
							aproved++;
						}
					}
					{
						JSeparator separator = new JSeparator();
						separator.setForeground(new Color(68,38,24));
						GridBagConstraints gbc_separator = new GridBagConstraints();
						gbc_separator.fill = GridBagConstraints.BOTH;
						gbc_separator.insets = new Insets(0, 0, 5, 0);
						gbc_separator.gridx = 0;
						gbc_separator.gridy = 1;
						panel.add(separator, gbc_separator);
					}
					
					JLabel label = new JLabel(String.valueOf(aproved));
					label.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 5, 0);
					gbc_label.gridx = 0;
					gbc_label.gridy = 2;
					panel.add(label, gbc_label);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 3;
				gbc_scrollPane.insets = new Insets(15, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 4;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					table = new JTable();
					table.setFont(Constants.getLabelFont());
					table.setModel(new DefaultTableModel(
							new Object[][] {},
							new String[] {"Curso", "Nota"}
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
							label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(200, 200, 200)));
							label.setOpaque(true);
							label.setBackground(new Color(255, 255, 255));

							return label;
						}
					});

					table.getTableHeader().setReorderingAllowed(false);

					for (Matriculation m: line.getMasteryPlan().findMatriculations(profesor)) {
						String mark = "-";
						if (m.hasMark()) mark = String.valueOf(m.getMark());

						((DefaultTableModel)table.getModel()).addRow(new Object[] { m.getCourse().getName(), mark });
					}

					table.setBackground(new Color(255, 255, 255));
					table.setEnabled(false);
					table.setGridColor(new Color(255, 255, 255, 255));
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
	
	public void update() {
		lblResearcherName.setText(profesor.getName());
	}
}
