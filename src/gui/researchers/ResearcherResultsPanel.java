package gui.researchers;

import gui.component.TitleLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import schooling.Faculty;
import schooling.Matriculation;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Constants;

public class ResearcherResultsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ResearchLine line;
	private Profesor profesor;
	private Faculty faculty;
	private ArrayList<Matriculation> matriculations;

	private JButton btnEdit;
	private JSlider sliderMark;
	private JCheckBox checkBoxAssignMark;
	private JLabel markLabel;

	private JLabel aprovedLbl;
	private JLabel progressLbl;
	private JLabel averageLbl;

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
		gbl_contentPanel.columnWidths = new int[] { 70, 0, 0, 0, 0, 0, 70 };
		gbl_contentPanel.rowHeights = new int[] { 40, 34, 10, 0, 15, 40, 0, 40, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblResultadosAcadmicos = new JLabel("Resultados acad\u00E9micos");
			GridBagConstraints gbc_lblResultadosAcadmicos = new GridBagConstraints();
			gbc_lblResultadosAcadmicos.gridwidth = 5;
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
			gbc_lblResearcherName.gridwidth = 5;
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
				gbl_panel.columnWidths = new int[] { 0, 0 };
				gbl_panel.rowHeights = new int[] { 30, 0, 0, 30, 0 };
				gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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
					progressLbl = new JLabel(String.valueOf(percentage) + "%");
					progressLbl.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_progressLbl = new GridBagConstraints();
					gbc_progressLbl.insets = new Insets(0, 0, 5, 0);
					gbc_progressLbl.gridx = 0;
					gbc_progressLbl.gridy = 2;
					panel.add(progressLbl, gbc_progressLbl);
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
				gbl_panel.columnWidths = new int[] { 0, 0 };
				gbl_panel.rowHeights = new int[] { 30, 0, 0, 30, 0 };
				gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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
					averageLbl = new JLabel(String.valueOf(faculty.getAverageMarksOf(profesor.getID())));
					averageLbl.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_averageLbl = new GridBagConstraints();
					gbc_averageLbl.insets = new Insets(0, 0, 5, 0);
					gbc_averageLbl.gridx = 0;
					gbc_averageLbl.gridy = 2;
					panel.add(averageLbl, gbc_averageLbl);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(new Color(68, 38, 24), 1));
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.gridwidth = 3;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 3;
				gbc_panel.gridy = 3;
				contentPanel.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 0, 0 };
				gbl_panel.rowHeights = new int[] { 30, 0, 0, 30, 0 };
				gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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
					for (Matriculation m : matriculations) {
						if (m.getMark() >= 3) {
							aproved++;
						}
					}
					{
						JSeparator separator = new JSeparator();
						separator.setForeground(new Color(68, 38, 24));
						GridBagConstraints gbc_separator = new GridBagConstraints();
						gbc_separator.fill = GridBagConstraints.BOTH;
						gbc_separator.insets = new Insets(0, 0, 5, 0);
						gbc_separator.gridx = 0;
						gbc_separator.gridy = 1;
						panel.add(separator, gbc_separator);
					}

					aprovedLbl = new JLabel(String.valueOf(aproved));
					aprovedLbl.setFont(new Font("Segoe UI", Font.PLAIN, 45));
					GridBagConstraints gbc_aprovedLlbl = new GridBagConstraints();
					gbc_aprovedLlbl.insets = new Insets(0, 0, 5, 0);
					gbc_aprovedLlbl.gridx = 0;
					gbc_aprovedLlbl.gridy = 2;
					panel.add(aprovedLbl, gbc_aprovedLlbl);
				}
			}
			{
				btnEdit = new JButton("Editar");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Matriculation m = matriculations.get(table.getSelectedRow());

						if (checkBoxAssignMark.isSelected()) {
							m.setMark(sliderMark.getValue());
						} else {
							m.noMarkYet();
						}

						JOptionPane.showMessageDialog(null, "¡Se ha actualizado la nota exitosamente!");

						loadData();
						initTable();
					}
				});
				GridBagConstraints gbc_btnEdit = new GridBagConstraints();
				gbc_btnEdit.anchor = GridBagConstraints.EAST;
				gbc_btnEdit.fill = GridBagConstraints.VERTICAL;
				gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
				gbc_btnEdit.gridx = 5;
				gbc_btnEdit.gridy = 5;
				btnEdit.setVisible(false);
				{
					checkBoxAssignMark = new JCheckBox("Asignar nota");
					checkBoxAssignMark.setFont(new Font("Segoe UI", Font.PLAIN, 15));

					checkBoxAssignMark.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (!checkBoxAssignMark.isSelected()) {
								sliderMark.setValue(2);
							}

							sliderMark.setEnabled(checkBoxAssignMark.isSelected());
						}
					});

					GridBagConstraints gbc_checkBoxAssignMark = new GridBagConstraints();
					gbc_checkBoxAssignMark.anchor = GridBagConstraints.EAST;
					gbc_checkBoxAssignMark.fill = GridBagConstraints.VERTICAL;
					gbc_checkBoxAssignMark.insets = new Insets(0, 0, 5, 5);
					gbc_checkBoxAssignMark.gridx = 2;
					gbc_checkBoxAssignMark.gridy = 5;

					contentPanel.add(checkBoxAssignMark, gbc_checkBoxAssignMark);
				}
				{
					markLabel = new JLabel("2");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 5, 5, 5);
					gbc_label.gridx = 4;
					gbc_label.gridy = 5;
					contentPanel.add(markLabel, gbc_label);
				}
				contentPanel.add(btnEdit, gbc_btnEdit);
				{
					sliderMark = new JSlider();
					sliderMark.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent arg0) {
							markLabel.setText(String.valueOf(sliderMark.getValue()));
						}
					});
					sliderMark.setEnabled(false);
					sliderMark.setBackground(Color.WHITE);
					sliderMark.setMinimum(2);
					sliderMark.setMaximum(5);
					sliderMark.setValue(2);
					GridBagConstraints gbc_sliderMark = new GridBagConstraints();
					gbc_sliderMark.fill = GridBagConstraints.BOTH;
					gbc_sliderMark.insets = new Insets(0, 0, 5, 5);
					gbc_sliderMark.gridx = 3;
					gbc_sliderMark.gridy = 5;
					contentPanel.add(sliderMark, gbc_sliderMark);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 5;
				gbc_scrollPane.insets = new Insets(5, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 6;
				contentPanel.add(scrollPane, gbc_scrollPane);
				{
					table = new JTable();
					table.setFont(Constants.getLabelFont());
					table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Curso", "Nota" }) {
						private static final long serialVersionUID = 6062319489520125102L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					});
					table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
						@Override
						public void valueChanged(ListSelectionEvent arg0) {
							handleEditMarkVisibility();
						}
					});
					table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
						@Override
						public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
								boolean hasFocus, int row, int column) {
							JLabel label = new JLabel(value.toString());
							label.setFont(Constants.getLabelFont().deriveFont(Font.PLAIN, 17));
							label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(200, 200, 200)));
							label.setOpaque(true);
							label.setBackground(new Color(255, 255, 255));

							return label;
						}
					});

					table.getTableHeader().setReorderingAllowed(false);

					initTable();

					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setBackground(new Color(255, 255, 255));
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

		handleEditMarkVisibility();
	}

	private void initTable() {
		((DefaultTableModel) table.getModel()).setRowCount(0);

		for (Matriculation m : matriculations) {
			String mark = "-";
			if (m.hasMark())
				mark = String.valueOf(m.getMark());
			((DefaultTableModel) table.getModel()).addRow(new Object[] { m.getCourse().getName(), mark });
		}
	}

	private void loadData() {
		double percentage = line.getMasteryPlan().progressMade(matriculations) * 100;

		progressLbl.setText(String.valueOf(percentage));
		averageLbl.setText(String.valueOf(faculty.getAverageMarksOf(profesor.getID())));

		int aproved = 0;
		for (Matriculation m : matriculations) {
			if (m.getMark() >= 3) {
				aproved++;
			}
		}
		aprovedLbl.setText(String.valueOf(aproved));
	}

	private void handleEditMarkVisibility() {
		boolean visible = table.getSelectedRow() >= 0;

		btnEdit.setVisible(visible);
		sliderMark.setVisible(visible);
		checkBoxAssignMark.setVisible(visible);
		markLabel.setVisible(visible);

		if (visible) {
			Matriculation m = matriculations.get(table.getSelectedRow());

			sliderMark.setValue(m.getMark());
			checkBoxAssignMark.setSelected(m.hasMark());
			sliderMark.setEnabled(checkBoxAssignMark.isSelected());
		}
	}

	public void update() {
		lblResearcherName.setText(profesor.getName());
	}
}
