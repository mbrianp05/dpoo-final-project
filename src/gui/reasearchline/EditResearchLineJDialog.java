package gui.reasearchline;

import gui.views.ResearchLineFormView;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.ResearchLine;

import java.awt.Toolkit;

public class EditResearchLineJDialog extends JDialog {
	private static final long serialVersionUID = 3372777757785359805L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public EditResearchLineJDialog(ResearchLine line) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearchLineJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Editar datos de la l\u00EDena");
		setModal(true);
		setBounds(100, 100, 891, 878);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			ResearchLineFormView researchLineFormView = new ResearchLineFormView(line);
			contentPanel.add(researchLineFormView);
		}
	}

}
