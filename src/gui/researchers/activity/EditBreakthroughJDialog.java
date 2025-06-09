package gui.researchers.activity;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Breakthrough;
import schooling.Chapter;
import schooling.Paper;
import schooling.Presentation;
import schooling.Researcher;

public class EditBreakthroughJDialog extends JDialog {
	private static final long serialVersionUID = -6779952241775451053L;
	private Breakthrough breakthrough;
	private Researcher researcher;

	private BookChapterForm bookChapterForm;
	private PaperForm paperForm;
	private PresentationForm presentationForm;

	private final JPanel contentPanel = new JPanel();
	
	public EditBreakthroughJDialog(Researcher researcher, Breakthrough breakthrough) {
		this.breakthrough = breakthrough;
		this.researcher = researcher;
		
		setModal(true);
		setResizable(false);
		setTitle("Editar aporte investigativo");
		setLocationRelativeTo(null);
		setBounds(100, 100, 897, 835);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		if (breakthrough instanceof Chapter) contentPanel.add(getBookChapterForm());
		if (breakthrough instanceof Paper) contentPanel.add(getPaperForm());
		if (breakthrough instanceof Presentation) contentPanel.add(getPresentationForm());
	}
	
	private BookChapterForm getBookChapterForm() {
		if (bookChapterForm == null) {
			bookChapterForm = new BookChapterForm(researcher, (Chapter)breakthrough);
		}
		return bookChapterForm;
	}
	
	private PaperForm getPaperForm() {
		if (paperForm == null) {
			paperForm = new PaperForm(researcher);
		}
		return paperForm;
	}
	
	private PresentationForm getPresentationForm() {
		if (presentationForm == null) {
			presentationForm = new PresentationForm(researcher);
		}
		return presentationForm;
	}
}
