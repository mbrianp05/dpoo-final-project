package gui.researchers;

import gui.event.OnResearchActivityActionTriggered;
import gui.researchers.activity.BookChapterForm;
import gui.researchers.activity.PaperForm;
import gui.researchers.activity.PresentationForm;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import schooling.Researcher;

public class ResearcherActivityForm extends JPanel {
	private Researcher researcher;

	private static final long serialVersionUID = 8784191316235786417L;
	private JTabbedPane tabbedPane;
	private BookChapterForm bookChapterForm;
	private PaperForm paperForm;
	private PresentationForm presentationForm;

	public ResearcherActivityForm(Researcher researcher) {
		this.researcher = researcher;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getTabbedPane());
	}

	public void listenTo(OnResearchActivityActionTriggered listener) {
		bookChapterForm.listenTo(listener);
		paperForm.listenTo(listener);
		presentationForm.listenTo(listener);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			tabbedPane.addTab("Cap�tulo", null, getBookChapterForm(), null);
			tabbedPane.addTab("Art�culo", null, getPaperForm(), null);
			tabbedPane.addTab("Ponencia", null, getPresentationForm(), null);
		}
		return tabbedPane;
	}

	private BookChapterForm getBookChapterForm() {
		if (bookChapterForm == null) {
			bookChapterForm = new BookChapterForm(researcher);
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
