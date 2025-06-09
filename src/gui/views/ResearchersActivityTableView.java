package gui.views;

import gui.component.TitleLabel;
import gui.model.ResearchersActivityTableModel;
import gui.researchers.activity.EditBreakthroughJDialog;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import schooling.Breakthrough;
import schooling.Faculty;
import schooling.Researcher;
import utils.Constants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResearchersActivityTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblFiltrar;
	private JScrollPane scrollPane;

	private Faculty faculty;
	
	private ResearchersActivityTableModel researcherModel;
	private JTable table;

	private TitleLabel lblDatosDeInvestigadores;
	
	public ResearchersActivityTableView() {
		this.faculty = Faculty.newInstance();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 100, 100, 30, 100, 0, 0, 70, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 35, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 9;
		gbc_lblDatosDeInvestigadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDeInvestigadores.gridx = 1;
		gbc_lblDatosDeInvestigadores.gridy = 1;
		add(getLblDatosDeInvestigadores(), gbc_lblDatosDeInvestigadores);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.BOTH;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 1;
		gbc_lblFiltrar.gridy = 3;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		researcherModel = new ResearchersActivityTableModel();
		table.setModel(researcherModel);
	}

	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			lblFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}

		return lblFiltrar;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		
		return scrollPane;
	}
	
	private ResearchersActivityTableModel getTableModel() {
		return (ResearchersActivityTableModel)table.getModel();
	}
	
	private void openEditBreakthroughDialog() {
		try {
			int selectedIndex = table.getSelectedRow();
			Breakthrough selectedBreakthrough = getTableModel().getData().get(selectedIndex);
			Researcher researcher = faculty.findResearcherByBreakthrough(selectedBreakthrough);
			
			EditBreakthroughJDialog dialog = new EditBreakthroughJDialog(researcher, selectedBreakthrough);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1) {
						openEditBreakthroughDialog();
					}
				}
			});
			table.setFont(Constants.getLabelFont());
			table.setRowHeight(24);
			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		
		return table;
	}

	public void updateTable() {
		((ResearchersActivityTableModel)table.getModel()).fill();
	}
	
	private TitleLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new TitleLabel();
			lblDatosDeInvestigadores.setText("Datos de la actividad investigativa");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		
		return lblDatosDeInvestigadores;
	}
}
