package gui.reasearchline;

import gui.event.OnAddedResearchLine;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.ResearchLine;

public class EditResearchLineJDialog extends JDialog {
	private static final long serialVersionUID = 3372777757785359805L;
	private final JPanel contentPanel = new JPanel();
	private ResearchLineForm researchLineForm;
	private ResearchLine line;

	/**
	 * Create the dialog.
	 */
	public EditResearchLineJDialog(ResearchLine line) {
		this.line = line;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearchLineJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Editar datos de la l\u00EDena");
		setModal(true);
		setBounds(100, 100, 891, 685);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		contentPanel.add(getResearchLineForm());
	}
	
	public void listenTo(OnAddedResearchLine listener) {
		researchLineForm.listenTo(listener);
	}

	private ResearchLineForm getResearchLineForm() {
		if (researchLineForm == null) {
			researchLineForm = new ResearchLineForm(line);
		}
		return researchLineForm;
	}
}
