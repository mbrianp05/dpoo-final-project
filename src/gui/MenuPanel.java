package gui;

import gui.event.OnAddedResearcher;
import gui.event.OnCloseApp;
import gui.report.views.ApprovalPendingsJDialog;
import gui.report.views.BestMarksJDialog;
import gui.report.views.BestResearchersJDialog;
import gui.report.views.MostPapersPlublishedByOneResearcherJDialog;
import gui.report.views.TrendingMasteriesJDialog;
import gui.report.views.TrendingMattersJDialog;
import gui.views.CoursesFormView;
import gui.views.CoursesTableView;
import gui.views.ResearchLineFormView;
import gui.views.ResearchLinesTableView;
import gui.views.ResearcherFormView;
import gui.views.ResearchersActivityTableView;
import gui.views.ResearchersTableView;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import schooling.Faculty;

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 3762125698246597691L;

	private Faculty faculty;
	private JMenuBar menuBar;
	private JMenu management;
	private JMenuItem newResearcherMenu;
	private JMenu reports;
	private JMenuItem bestResearchersMenu;
	private JMenuItem trendingMattersMenu;
	private JMenuItem bestMasteryPlansMenu;
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
	private JMenuItem addCourseMenu;
	private JMenuItem coursesTableMenu;
	private CoursesTableView coursesTableView;
	private ResearchersActivityTableView researchersActivityTableView;
	private JMenuItem researchActivityMenu;
	private JLabel btnCerrar;

	private OnCloseApp listener;
	private JPanel panel;

	public MenuPanel() {
		this.faculty = Faculty.newInstance();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1092, 0};
		gridBagLayout.rowHeights = new int[]{74, 421, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.insets = new Insets(0, 20, 5, 20);
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(getMenuBar(), gbc_menuBar);
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 1;
		add(getContentPanel(), gbc_contentPanel);
		
		updateViews();
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getManagement());
			menuBar.add(getMnData());
			menuBar.add(getReports());
			menuBar.add(getPanel());
		}
		return menuBar;
	}
	private JMenu getManagement() {
		if (management == null) {
			management = new JMenu("Administraci\u00F3n");
			management.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			management.add(getAddLineMenu());
			management.add(getNewResearcherMenu());
			management.add(getAddCourseMenu());
		}
		return management;
	}

	private void updateViews() {
		researchLinesTableView.updateTable();
		coursesTableView.updateTable();
		researchersTableView.updateTable();
		researchersActivityTableView.updateTable();

		coursesFormView.update();
		researcherFormView.update();
		
		addCourseMenu.setVisible(faculty.linesWithAtLeastOneInstructorCandidate() > 0);
		newResearcherMenu.setVisible(faculty.getResearchLines().size() > 0);
		
		// Ocultar los reportes cuando no hay nada que mostrar
		trendingMattersMenu.setVisible(faculty.trendingMatters().size() > 0);
		bestMasteryPlansMenu.setVisible(faculty.trendingMasteryPlans().size() > 0);
		bestResearchersMenu.setVisible(faculty.bestResearchers().size() > 0);
		mostPaperMenu.setVisible(faculty.mostPaperPublished().size() > 0);
		bestMarksMenu.setVisible(faculty.profesorsWithBestAverage().size() > 0);
		aprovalPendingMenu.setVisible(faculty.pendingAprovals().size() > 0);
	}
	
	// Actualizar todas las tablas y formularios que se vayan a�adiendo
	private void switchView(String view) {
		CardLayout cl = (CardLayout)(contentPanel.getLayout());
		cl.show(contentPanel, view);

		updateViews();
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

	private JMenuItem getAddCourseMenu() {
		if (addCourseMenu == null) {			
			addCourseMenu = new JMenuItem("Nuevo curso");
			addCourseMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchView("Courses Form");
				}
			});
		}
		
		return addCourseMenu;
	}

	private JMenu getReports() {
		if (reports == null) {
			reports = new JMenu("Reportes");
			reports.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			reports.add(getBestResearchersMenu());
			reports.add(getTrendingMattersMenu());
			reports.add(getMostPaperMenu());
			reports.add(getBestMasteryPlansMenu());
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
	private JMenuItem getBestMasteryPlansMenu() {
		if (bestMasteryPlansMenu == null) {
			bestMasteryPlansMenu = new JMenuItem("Maestr\u00EDas con mayor matr\u00EDcula");
			bestMasteryPlansMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						TrendingMasteriesJDialog dialog = new TrendingMasteriesJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return bestMasteryPlansMenu;
	}
	private JMenuItem getBestMarksMenu() {
		if (bestMarksMenu == null) {
			bestMarksMenu = new JMenuItem("Profesores con mejor promedio");
			bestMarksMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						BestMarksJDialog dialog = new BestMarksJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
		}
		return bestMarksMenu;
	}
	private JMenuItem getAprovalPendingMenu() {
		if (aprovalPendingMenu == null) {
			aprovalPendingMenu = new JMenuItem("Maestr\u00EDas para aprobar");
			aprovalPendingMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						ApprovalPendingsJDialog dialog = new ApprovalPendingsJDialog();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
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
			coursesFormView = new CoursesFormView();
		}
		return coursesFormView;
	}
	private ResearcherFormView getResearcherForm() {
		if (researcherFormView == null) {
			researcherFormView = new ResearcherFormView();
			researcherFormView.listenTo(new OnAddedResearcher() {
				@Override
				public void newResearcher(int researcherID) {
					updateViews();
				}
			});
		}
		return researcherFormView;
	}
	private ResearchersTableView getResearchersTableView() {
		if (researchersTableView == null) {
			researchersTableView = new ResearchersTableView();
			researchersTableView.listenTo(new OnAddedResearcher() {
				@Override
				public void newResearcher(int researcherID) {
					updateViews();
				}
			});
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
			mnData.add(getResearchLinesMenu());
			mnData.add(getResearchersTableMenu());
			mnData.add(getResearchActivityMenu());
			mnData.add(getCoursesTableMenu());
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

	private JLabel getBtnCerrar() {
		if (btnCerrar == null) {
			ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/close-x.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			btnCerrar = new JLabel(icon);
			btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCerrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (listener != null) listener.actionPerformed();
				}
			});
			btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));

			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnCerrar.setBorder(emptyBorder);
		}
		return btnCerrar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{67, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
			gbc_btnCerrar.insets = new Insets(5, 5, 5, 5);
			gbc_btnCerrar.gridx = 1;
			gbc_btnCerrar.gridy = 0;
			panel.add(getBtnCerrar(), gbc_btnCerrar);
		}
		return panel;
	}
}