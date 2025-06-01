package gui;

import gui.event.OnAddedResearcher;
import gui.views.ResearcherFormView;

import javax.swing.JPanel;

import java.awt.Color;

import schooling.Faculty;
import utils.Mock;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import gui.views.ResearchersTableView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import gui.views.ResearchLinesFormView;

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 3762125698246597691L;

	private Faculty faculty;
	private JMenuBar menuBar;
	private JMenu management;
	private JMenuItem newResearcherMenu;
	private JMenu reports;
	private JMenuItem bestResearchersMenu;
	private JMenuItem trendingMattersMenu;
	private JMenuItem totalCoursesMenu;
	private JMenuItem bestMarksMenu;
	private JMenuItem aprovalPendingMenu;
	private JMenuItem mostPaperMenu;
	private JMenu researchersSubmenu;
	private JMenuItem researchersTableMenu;
	private JPanel contentPanel;
	private ResearcherFormView researcherFormView;
	private ResearchersTableView researchersTableView;
	private JMenu linesSubemenu;
	private JMenuItem addLineMenu;
	private ResearchLinesFormView researchLinesFormView;

	public MenuPanel(Faculty faculty) {
		this.faculty = faculty;
		
		// Mock data
		Mock.mockFacultyData(faculty);

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1092, 0};
		gridBagLayout.rowHeights = new int[]{74, 421, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(getMenuBar(), gbc_menuBar);
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 1;
		add(getContentPanel(), gbc_contentPanel);
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getManagement());
			menuBar.add(getReports());
		}
		return menuBar;
	}
	private JMenu getManagement() {
		if (management == null) {
			management = new JMenu("Administraci\u00F3n");
			management.setBackground(Color.WHITE);
			management.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			management.add(getResearchersSubmenu());
			management.add(getLinesSubemenu());
		}
		return management;
	}

	private void switchView(String view) {
		CardLayout cl = (CardLayout)(contentPanel.getLayout());
		cl.show(contentPanel, view);
	}

	private JMenuItem getNewResearcherMenu() {
		if (newResearcherMenu == null) {
			newResearcherMenu = new JMenuItem("Insertar investigadores");
			newResearcherMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Researcher Form");
				}
			});
			newResearcherMenu.setBackground(Color.WHITE);
			newResearcherMenu.setSelected(true);
		}
		return newResearcherMenu;
	}
	private JMenu getReports() {
		if (reports == null) {
			reports = new JMenu("Reportes");
			reports.setBackground(Color.WHITE);
			reports.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			reports.add(getBestResearchersMenu());
			reports.add(getTrendingMattersMenu());
			reports.add(getMostPaperMenu());
			reports.add(getTotalCoursesMenu());
			reports.add(getBestMarksMenu());
			reports.add(getAprovalPendingMenu());
		}
		return reports;
	}
	private JMenuItem getBestResearchersMenu() {
		if (bestResearchersMenu == null) {
			bestResearchersMenu = new JMenuItem("Mejores investigadores");
			bestResearchersMenu.setBackground(Color.WHITE);
		}
		return bestResearchersMenu;
	}
	private JMenuItem getTrendingMattersMenu() {
		if (trendingMattersMenu == null) {
			trendingMattersMenu = new JMenuItem("Temas populares");
			trendingMattersMenu.setBackground(Color.WHITE);
		}
		return trendingMattersMenu;
	}
	private JMenuItem getTotalCoursesMenu() {
		if (totalCoursesMenu == null) {
			totalCoursesMenu = new JMenuItem("Total de cursos");
			totalCoursesMenu.setBackground(Color.WHITE);
		}
		return totalCoursesMenu;
	}
	private JMenuItem getBestMarksMenu() {
		if (bestMarksMenu == null) {
			bestMarksMenu = new JMenuItem("Mejores notas");
			bestMarksMenu.setBackground(Color.WHITE);
		}
		return bestMarksMenu;
	}
	private JMenuItem getAprovalPendingMenu() {
		if (aprovalPendingMenu == null) {
			aprovalPendingMenu = new JMenuItem("Maestr\u00EDas para aprobar");
			aprovalPendingMenu.setBackground(Color.WHITE);
		}
		return aprovalPendingMenu;
	}
	private JMenuItem getMostPaperMenu() {
		if (mostPaperMenu == null) {
			mostPaperMenu = new JMenuItem("Investigadores con m\u00E1s art\u00EDculos");
			mostPaperMenu.setBackground(Color.WHITE);
		}
		return mostPaperMenu;
	}
	private JMenu getResearchersSubmenu() {
		if (researchersSubmenu == null) {
			researchersSubmenu = new JMenu("Investigadores");
			researchersSubmenu.setBackground(Color.WHITE);
			researchersSubmenu.add(getNewResearcherMenu());
			researchersSubmenu.add(getResearchersTableMenu());
		}
		return researchersSubmenu;
	}
	private JMenuItem getResearchersTableMenu() {
		if (researchersTableMenu == null) {
			researchersTableMenu = new JMenuItem("Tabla de datos");
			researchersTableMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Researchers Table");
				}
			});
			researchersTableMenu.setBackground(Color.WHITE);
		}
		return researchersTableMenu;
	}
	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setBackground(Color.WHITE);
			contentPanel.setLayout(new CardLayout(0, 0));	
			contentPanel.add(getResearcherForm(), "Researcher Form");
			contentPanel.add(getResearchersTableView(), "Researchers Table");
			contentPanel.add(getResearchLinesFormView(), "Research Lines Form");
		}
		return contentPanel;
	}
	private ResearcherFormView getResearcherForm() {
		if (researcherFormView == null) {
			researcherFormView = new ResearcherFormView(faculty);
			researcherFormView.listenTo(new OnAddedResearcher() {
				@Override
				public void added(int researcherID) {
					researchersTableView.updateTable();
				}
			});
		}
		return researcherFormView;
	}
	private ResearchersTableView getResearchersTableView() {
		if (researchersTableView == null) {
			researchersTableView = new ResearchersTableView(faculty);
		}
		return researchersTableView;
	}
	private JMenu getLinesSubemenu() {
		if (linesSubemenu == null) {
			linesSubemenu = new JMenu("L\u00EDneas de investigaci\u00F3n");
			linesSubemenu.add(getAddLineMenu());
		}
		return linesSubemenu;
	}
	private JMenuItem getAddLineMenu() {
		if (addLineMenu == null) {
			addLineMenu = new JMenuItem("Agregar l\u00EDnea");
			addLineMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Research Lines Form");
				}
			});
		}
		return addLineMenu;
	}
	private ResearchLinesFormView getResearchLinesFormView() {
		if (researchLinesFormView == null) {
			researchLinesFormView = new ResearchLinesFormView(faculty);
		}
		return researchLinesFormView;
	}
}
