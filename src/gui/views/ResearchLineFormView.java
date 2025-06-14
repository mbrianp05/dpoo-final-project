package gui.views;

import gui.component.TitleLabel;
import gui.reasearchline.ResearchLineForm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import utils.Constants;

public class ResearchLineFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;

	private TitleLabel lblAgregarLneaDe;
	private ResearchLineForm researchLineForm;

	public ResearchLineFormView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAgregarLneaDe = new GridBagConstraints();
		gbc_lblAgregarLneaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarLneaDe.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarLneaDe.gridx = 1;
		gbc_lblAgregarLneaDe.gridy = 1;
		add(getLblAgregarLneaDe(), gbc_lblAgregarLneaDe);
		GridBagConstraints gbc_researchLineForm = new GridBagConstraints();
		gbc_researchLineForm.gridwidth = 3;
		gbc_researchLineForm.fill = GridBagConstraints.BOTH;
		gbc_researchLineForm.gridx = 0;
		gbc_researchLineForm.gridy = 2;
		add(getResearchLineForm(), gbc_researchLineForm);
	}

	private TitleLabel getLblAgregarLneaDe() {
		if (lblAgregarLneaDe == null) {
			lblAgregarLneaDe = new TitleLabel();
			lblAgregarLneaDe.setText("Agregar l\u00EDnea de investigaci\u00F3n");
			lblAgregarLneaDe.setFont(Constants.getTitleFont());
		}
		return lblAgregarLneaDe;
	}

	private ResearchLineForm getResearchLineForm() {
		if (researchLineForm == null) {
			researchLineForm = new ResearchLineForm();
		}
		return researchLineForm;
	}
}
