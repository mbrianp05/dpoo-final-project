package gui;

import gui.event.OnCloseApp;
import gui.report.views.BestResearchersJDialog;
import gui.report.views.MostPapersPlublishedByOneResearcherJDialog;
import gui.report.views.TrendingMattersJDialog;
import gui.views.CoursesFormView;
import gui.views.CoursesTableView;
import gui.views.ResearchLineFormView;
import gui.views.ResearchLinesTableView;
import gui.views.ResearcherFormView;
import gui.views.ResearchersActivityTableView;
import gui.views.ResearchersTableView;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import schooling.Degree;
import schooling.Faculty;
import utils.Mock;

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
	private JMenuItem researchersTableMenu;
	private JPanel contentPanel;
	private ResearcherFormView researcherFormView;
	private ResearchersTableView researchersTableView;
	private CoursesFormView coursesFormView;
	private JMenuItem addLineMenu;
	private ResearchLineFormView researchLineFormView;
	private JMenu mnData;
	private JMenuItem researchLinesMenu;
	private ResearchLinesTableView researchLinesTableView;
	private JMenuItem addCourse;
	private JMenuItem coursesTableMenu;
	private CoursesTableView coursesTableView;
	private ResearchersActivityTableView researchersActivityTableView;
	private JMenuItem researchActivityMenu;
	private JButton btnCerrar;

	private OnCloseApp listener;
	private JMenuItem padding;

	public MenuPanel() {
		this.faculty = Faculty.newInstance();

		// Mock data
		Mock.mockFacultyData(faculty);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1092, 1092, 0};
		gridBagLayout.rowHeights = new int[]{74, 421, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.gridwidth = 2;
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(getMenuBar(), gbc_menuBar);
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.gridwidth = 2;
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 1;
		add(getContentPanel(), gbc_contentPanel);
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getManagement());
			menuBar.add(getMnData());
			menuBar.add(getReports());
			menuBar.add(getPadding());
			menuBar.add(getBtnCerrar());
		}
		return menuBar;
	}
	private JMenu getManagement() {
		if (management == null) {
			management = new JMenu("Administraci\u00F3n");
			management.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			management.add(getNewResearcherMenu());
			management.add(getAddCourse());
			management.add(getAddLineMenu());
		}
		return management;
	}

	// Actualizar todas las tablas y formularios que se vayan añadiendo
	private void switchView(String view) {
		CardLayout cl = (CardLayout)(contentPanel.getLayout());
		cl.show(contentPanel, view);

		researchLinesTableView.updateTable();
		coursesTableView.updateTable();
		researchersTableView.updateTable();
		researchersActivityTableView.updateTable();

		coursesFormView.update();
		researcherFormView.update();
	}

	private JMenuItem getNewResearcherMenu() {
		if (newResearcherMenu == null) {
			newResearcherMenu = new JMenuItem("Insertar investigadores");
			newResearcherMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Researcher Form");
				}
			});
			newResearcherMenu.setSelected(true);
		}
		return newResearcherMenu;
	}

	// boton de insertar curso
	private JMenuItem getAddCourse() {
		if (addCourse == null) {			
				addCourse = new JMenuItem("Nuevo curso");
				addCourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						switchView("Courses Form");
					}
				});
			}
		if(faculty.getReseachLines().size() > 0 && faculty.getProfesorsWithDegree(Degree.Doctor).size() > 0) {
			addCourse.setVisible(true);
		} else {
			addCourse.setVisible(false);
		}
		return addCourse;
	}

	private JMenu getReports() {
		if (reports == null) {
			reports = new JMenu("Reportes");
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
			bestResearchersMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						BestResearchersJDialog dialog = new BestResearchersJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return bestResearchersMenu;
	}
	private JMenuItem getTrendingMattersMenu() {
		if (trendingMattersMenu == null) {
			trendingMattersMenu = new JMenuItem("Temas populares");
			trendingMattersMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						TrendingMattersJDialog dialog = new TrendingMattersJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return trendingMattersMenu;
	}
	private JMenuItem getTotalCoursesMenu() {
		if (totalCoursesMenu == null) {
			totalCoursesMenu = new JMenuItem("Total de cursos");
		}
		return totalCoursesMenu;
	}
	private JMenuItem getBestMarksMenu() {
		if (bestMarksMenu == null) {
			bestMarksMenu = new JMenuItem("Mejores notas");
		}
		return bestMarksMenu;
	}
	private JMenuItem getAprovalPendingMenu() {
		if (aprovalPendingMenu == null) {
			aprovalPendingMenu = new JMenuItem("Maestr\u00EDas para aprobar");
		}
		return aprovalPendingMenu;
	}
	private JMenuItem getMostPaperMenu() {
		if (mostPaperMenu == null) {
			mostPaperMenu = new JMenuItem("Investigadores con m\u00E1s art\u00EDculos");
			mostPaperMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						MostPapersPlublishedByOneResearcherJDialog dialog = new MostPapersPlublishedByOneResearcherJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return mostPaperMenu;
	}
	private JMenuItem getResearchersTableMenu() {
		if (researchersTableMenu == null) {
			researchersTableMenu = new JMenuItem("Investigadores");
			researchersTableMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Researchers Table");
				}
			});
		}
		return researchersTableMenu;
	}
	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new CardLayout(0, 0));	
			contentPanel.add(getResearchLinesFormView(), "Research Lines Form");
			contentPanel.add(getResearcherForm(), "Researcher Form");
			contentPanel.add(getCoursesFormView(), "Courses Form");
			contentPanel.add(getResearchersTableView(), "Researchers Table");
			contentPanel.add(getResearchLinesTableView(), "Research Lines Table");
			contentPanel.add(getCoursesTableView(), "Courses Table");
			contentPanel.add(getResearchersActivityTableView(), "Researchers Activity Table");
		}
		return contentPanel;
	}
	private CoursesFormView getCoursesFormView() {
		if (coursesFormView == null) {
			coursesFormView = new CoursesFormView(faculty);
		}
		return coursesFormView;
	}
	private ResearcherFormView getResearcherForm() {
		if (researcherFormView == null) {
			researcherFormView = new ResearcherFormView();
		}
		return researcherFormView;
	}
	private ResearchersTableView getResearchersTableView() {
		if (researchersTableView == null) {
			researchersTableView = new ResearchersTableView();
		}
		return researchersTableView;
	}

	//lista de cursos de postgrado
	private JMenuItem getCoursesTableMenu() {
		if (coursesTableMenu == null) {
			coursesTableMenu = new JMenuItem("Cursos de postgrado");
			coursesTableMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Courses Table");
				}
			});
		}
		return coursesTableMenu;
	}

	private CoursesTableView getCoursesTableView() {
		if (coursesTableView == null) {
			coursesTableView = new CoursesTableView();
		}
		return coursesTableView;
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
	private ResearchLineFormView getResearchLinesFormView() {
		if (researchLineFormView == null) {
			researchLineFormView = new ResearchLineFormView();
		}
		return researchLineFormView;
	}
	private JMenu getMnData() {
		if (mnData == null) {
			mnData = new JMenu("Datos");
			mnData.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			mnData.add(getResearchersTableMenu());
			mnData.add(getResearchLinesMenu());
			mnData.add(getCoursesTableMenu());
			mnData.add(getResearchActivityMenu());
		}
		return mnData;
	}
	private JMenuItem getResearchLinesMenu() {
		if (researchLinesMenu == null) {
			researchLinesMenu = new JMenuItem("L\u00EDneas de investigaci\u00F3n");
			researchLinesMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Research Lines Table");
				}
			});
		}
		return researchLinesMenu;
	}
	private ResearchLinesTableView getResearchLinesTableView() {
		if (researchLinesTableView == null) {
			researchLinesTableView = new ResearchLinesTableView();
		}
		return researchLinesTableView;
	}
	private ResearchersActivityTableView getResearchersActivityTableView() {
		if (researchersActivityTableView == null) {
			researchersActivityTableView = new ResearchersActivityTableView();
		}
		return researchersActivityTableView;
	}
	private JMenuItem getResearchActivityMenu() {
		if (researchActivityMenu == null) {
			researchActivityMenu = new JMenuItem("Actividad investigativa");
			researchActivityMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Researchers Activity Table");
				}
			});
		}
		return researchActivityMenu;
	}

	public void listenTo(OnCloseApp listener) {
		this.listener = listener;
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/close-x.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			btnCerrar = new JButton(icon);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (listener != null) listener.actionPerformed();
				}
			});
			btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));

			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnCerrar.setBorder(emptyBorder);
		}
		return btnCerrar;
	}
	private JMenuItem getPadding() {
		if (padding == null) {
			padding = new JMenuItem("");
		}
		return padding;
	}
}