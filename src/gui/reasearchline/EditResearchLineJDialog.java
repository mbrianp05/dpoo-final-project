package gui.reasearchline;

import gui.event.OnAddedResearchLine;
import gui.event.OnNoMatriculableProfesorLeft;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import schooling.ResearchLine;

import java.awt.CardLayout;

import gui.course.MatriculationPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.course.RevertMatriculationPanel;

public class EditResearchLineJDialog extends JDialog {
	private static final long serialVersionUID = 3372777757785359805L;
	private final JPanel contentPanel = new JPanel();
	private ResearchLine line;
	private ButtonGroup buttonGroup;
	private ResearchLineForm researchLineForm;
	private JPanel panel;
	private JRadioButton rBtnEdit;
	private JRadioButton rBtnMatriculation;
	private JPanel wrapper;
	private MatriculationPanel matriculationPanel;
	private JRadioButton rBtnRemoveMatriculation;
	private RevertMatriculationPanel revertMatriculationPanel;

	public EditResearchLineJDialog(ResearchLine line) {
		this.line = line;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearchLineJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Editar datos de la l\u00EDnea");
		setModal(true);
		setBounds(100, 100, 891, 739);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(getPanel(), gbc_panel);
		GridBagConstraints gbc_wrapper = new GridBagConstraints();
		gbc_wrapper.fill = GridBagConstraints.BOTH;
		gbc_wrapper.gridx = 0;
		gbc_wrapper.gridy = 1;
		contentPanel.add(getWrapper(), gbc_wrapper);
		
		getButtonGroup();
		manageVisibility();
	}
	
	public void listenTo(OnAddedResearchLine listener) {
		researchLineForm.listenTo(listener);
	}
	/**
	 * @wbp.nonvisual location=51,714
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(rBtnEdit);
			buttonGroup.add(rBtnMatriculation);
			buttonGroup.add(rBtnRemoveMatriculation);
		}
		return buttonGroup;
	}
	private ResearchLineForm getResearchLineForm() {
		if (researchLineForm == null) {
			researchLineForm = new ResearchLineForm(line);
		}
		return researchLineForm;
	}
	
	private void manageVisibility() {
		boolean oldVisiblity = rBtnMatriculation.isVisible();
		
		rBtnMatriculation.setVisible(line.getMatriculableProfesors().size() > 0);
		
		if (!rBtnMatriculation.isVisible() && oldVisiblity) {
			rBtnEdit.setSelected(true);
		}
		
		oldVisiblity = rBtnRemoveMatriculation.isVisible();
		
		rBtnRemoveMatriculation.setVisible(line.getMasteryPlan().getMatriculations().size() > 0);
		
		if (!rBtnRemoveMatriculation.isVisible() && oldVisiblity) {
			rBtnEdit.setSelected(true);
		}
		
		panel.setVisible(rBtnMatriculation.isVisible() || rBtnRemoveMatriculation.isVisible());
		
		matriculationPanel.fillComboBox();
		revertMatriculationPanel.fillComboBox();
		
		switchPanel("Edit Line");
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getRBtnEdit());
			panel.add(getRBtnMatriculation());
			panel.add(getRBtnRemoveMatriculation());
		}
		return panel;
	}
	private JRadioButton getRBtnEdit() {
		if (rBtnEdit == null) {
			rBtnEdit = new JRadioButton("Editar");
			rBtnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Edit Line");
				}
			});
			rBtnEdit.setSelected(true);
		}
		return rBtnEdit;
	}
	private JRadioButton getRBtnMatriculation() {
		if (rBtnMatriculation == null) {
			rBtnMatriculation = new JRadioButton("Matricular");
			rBtnMatriculation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Matriculation");
				}
			});
		}
		return rBtnMatriculation;
	}
	private JPanel getWrapper() {
		if (wrapper == null) {
			wrapper = new JPanel();
			wrapper.setLayout(new CardLayout(0, 0));
			wrapper.add(getResearchLineForm(), "Edit Line");
			wrapper.add(getMatriculationPanel(), "Matriculation");
			wrapper.add(getRevertMatriculationPanel(), "Remove Matriculation");
		}
		return wrapper;
	}
	private MatriculationPanel getMatriculationPanel() {
		if (matriculationPanel == null) {
			matriculationPanel = new MatriculationPanel(line);
			matriculationPanel.listenTo(new OnNoMatriculableProfesorLeft() {
				@Override
				public void noProfesorLeft() {
					manageVisibility();
				}
			});
		}
		return matriculationPanel;
	}
	
	private void switchPanel(String panel) {
		CardLayout cl = (CardLayout)wrapper.getLayout();
		cl.show(wrapper, panel);
	}
	private JRadioButton getRBtnRemoveMatriculation() {
		if (rBtnRemoveMatriculation == null) {
			rBtnRemoveMatriculation = new JRadioButton("Eliminar matr\u00EDcula");
			rBtnRemoveMatriculation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Remove Matriculation");
				}
			});
		}
		return rBtnRemoveMatriculation;
	}
	private RevertMatriculationPanel getRevertMatriculationPanel() {
		if (revertMatriculationPanel == null) {
			revertMatriculationPanel = new RevertMatriculationPanel(line);
			revertMatriculationPanel.listenTo(new OnNoMatriculableProfesorLeft() {
				@Override
				public void noProfesorLeft() {
					manageVisibility();
				}
			});
		}
		return revertMatriculationPanel;
	}
}
