package gui.researchers;

import gui.event.OnAddedResearcher;
import gui.event.OnProfesorFormActionTriggered;
import gui.event.OnResearchActivityActionTriggered;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import schooling.Researcher;
import schooling.Student;
import utils.ArrayLib;

public class EditResearcherJDialog extends JDialog {
	private static final long serialVersionUID = -8039865322179654975L;
	private final JPanel contentPanel = new JPanel();

	private Researcher researcher;
	private Faculty faculty;
	
	private JPanel radiosWrapper;
	private JRadioButton rbtnResearcherActivity;
	private JRadioButton rbtnResearcherInfo;
	private ButtonGroup buttonGroup;
	private JPanel panelsWrapper;
	private StudentForm studentForm_1;
	private ProfesorForm profesorForm_1;
	private ResearcherActivityForm researcherActivityForm;
	private JPanel formPannelWrapper;

	public EditResearcherJDialog(Researcher researcher) {
		this.faculty = Faculty.newInstance();
		this.researcher = researcher;
		
		setLocationRelativeTo(null);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setResizable(false);
		setTitle("Editar datos de investigador");
		setBounds(100, 100, 897, 835);
		
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{40, 0, 40, 0};
		gbl_contentPanel.rowHeights = new int[]{30, 20, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		GridBagConstraints gbc_radiosWrapper = new GridBagConstraints();
		gbc_radiosWrapper.gridheight = 2;
		gbc_radiosWrapper.insets = new Insets(0, 0, 5, 5);
		gbc_radiosWrapper.fill = GridBagConstraints.HORIZONTAL;
		gbc_radiosWrapper.gridx = 1;
		gbc_radiosWrapper.gridy = 0;
		contentPanel.add(getRadiosWrapper(), gbc_radiosWrapper);
		GridBagConstraints gbc_panelsWrapper = new GridBagConstraints();
		gbc_panelsWrapper.gridwidth = 3;
		gbc_panelsWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelsWrapper.gridx = 0;
		gbc_panelsWrapper.gridy = 2;
		contentPanel.add(getPanelsWrapper(), gbc_panelsWrapper);
		getButtonGroup();
	}

	public void listenTo(OnResearchActivityActionTriggered listener) {
		researcherActivityForm.listenTo(listener);
	}
	
	public void listenTo(final OnAddedResearcher listener) {
		if (researcher instanceof Profesor) {
			profesorForm_1.listenTo(new OnProfesorFormActionTriggered() {
				@Override
				public void actionPerformed(ProfesorFormData data) {
					Profesor p = (Profesor)researcher;
					
					p.setName(data.getName());
					p.setDegree(data.getDegree());
					p.setCategory(data.getCategory());
					
					faculty.moveToOtherMatter(p.getID(), data.getMatter());
					
					listener.newResearcher(researcher.getID());
				}
			});
		} else {
			studentForm_1.listenTo(listener);
		}
	}
	
	private String[] getMatters() {
		String[] matters = ArrayLib.cast(faculty.getResearchMattersNames());
		
		if (researcher instanceof Profesor) {
			Profesor p = (Profesor)researcher;
			
			if (faculty.isChief(p)) {
				System.out.println(p.getName());
				
				ResearchLine line = faculty.findReseachLineByChief(p);
				matters = new String[line.getMatters().size()];
				
				for (int i = 0; i < line.getMatters().size(); i++) {
					matters[i] = line.getMatters().get(i).getName();
				}
			}
		}
		
		return matters;
	}
	private JPanel getRadiosWrapper() {
		if (radiosWrapper == null) {
			radiosWrapper = new JPanel();
			radiosWrapper.setBorder(null);
			radiosWrapper.add(getRadioButton_2());
			radiosWrapper.add(getRadioButton_1());
		}
		return radiosWrapper;
	}
	
	private void switchPanel(String id) {
		CardLayout cl = (CardLayout)panelsWrapper.getLayout();
		cl.show(panelsWrapper, id);
	}
	
	private JRadioButton getRadioButton_1() {
		if (rbtnResearcherActivity == null) {
			rbtnResearcherActivity = new JRadioButton("Actividad investigativa");
			rbtnResearcherActivity.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Researcher Activity Form");
				}
			});
			
			rbtnResearcherActivity.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return rbtnResearcherActivity;
	}
	private JRadioButton getRadioButton_2() {
		if (rbtnResearcherInfo == null) {
			rbtnResearcherInfo = new JRadioButton("Datos del investigador");
			rbtnResearcherInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Researcher Form");
				}
			});
			rbtnResearcherInfo.setSelected(true);
			rbtnResearcherInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return rbtnResearcherInfo;
	}
	
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(rbtnResearcherActivity);
			buttonGroup.add(rbtnResearcherInfo);
		}
		return buttonGroup;
	}
	private JPanel getPanelsWrapper() {
		if (panelsWrapper == null) {
			panelsWrapper = new JPanel();
			panelsWrapper.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
			panelsWrapper.setLayout(new CardLayout(0, 0));
			
			panelsWrapper.add(getFormPannelWrapper(), "Researcher Form");
			panelsWrapper.add(getResearcherActivityForm(), "Researcher Activity Form");
		}
		return panelsWrapper;
	}
	private StudentForm getStudentForm_1() {
		if (studentForm_1 == null) {
			studentForm_1 = new StudentForm((Student)researcher);
		}
		return studentForm_1;
	}
	private ProfesorForm getProfesorForm_1() {
		if (profesorForm_1 == null) {
			ResearchMatter m = faculty.findMatterOf(researcher.getID());
			String matter = "";
			
			if (m != null) matter = m.getName();
			
			profesorForm_1 = new ProfesorForm(getMatters(), ProfesorFormData.fromResearcher((Profesor)researcher, matter));
		}
		return profesorForm_1;
	}
	private ResearcherActivityForm getResearcherActivityForm() {
		if (researcherActivityForm == null) {
			researcherActivityForm = new ResearcherActivityForm(researcher);
		}
		return researcherActivityForm;
	}
	private JPanel getFormPannelWrapper() {
		if (formPannelWrapper == null) {
			formPannelWrapper = new JPanel();
			GridBagLayout gbl_formPannelWrapper = new GridBagLayout();
			gbl_formPannelWrapper.columnWidths = new int[]{100, 0, 100, 0};
			gbl_formPannelWrapper.rowHeights = new int[]{45, 0, 0};
			gbl_formPannelWrapper.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_formPannelWrapper.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			formPannelWrapper.setLayout(gbl_formPannelWrapper);
			GridBagConstraints formGrid = new GridBagConstraints();
			formGrid.insets = new Insets(0, 0, 5, 5);
			formGrid.fill = GridBagConstraints.BOTH;
			formGrid.gridx = 1;
			formGrid.gridy = 1;
			
			if (researcher instanceof Profesor) {
				formPannelWrapper.add(getProfesorForm_1(), formGrid);
			}
			
			if (researcher instanceof Student) {
				formPannelWrapper.add(getStudentForm_1(), formGrid);
			}
		}
		return formPannelWrapper;
	}
}
