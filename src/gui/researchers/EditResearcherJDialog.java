package gui.researchers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Researcher;

import java.awt.Color;

public class EditResearcherJDialog extends JDialog {
	private static final long serialVersionUID = -8039865322179654975L;
	private final JPanel contentPanel = new JPanel();

	private Researcher researcher;
	
	public EditResearcherJDialog(Researcher researcher) {
		this.researcher = researcher;
		
		setResizable(false);
		setTitle("Editar datos de investigador");
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 583, 411);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

}
