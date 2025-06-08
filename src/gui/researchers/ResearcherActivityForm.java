package gui.researchers;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

import schooling.Researcher;
import gui.event.OnResearchActivityActionTriggered;
import gui.researchers.activity.BookChapterForm;

import java.awt.GridBagLayout;
import java.awt.Font;

import gui.researchers.activity.PaperForm;
import gui.researchers.activity.PresentationForm;

public class ResearcherActivityForm extends JPanel {
	private Researcher researcher;
	
	private static final long serialVersionUID = 8784191316235786417L;
	private JTabbedPane tabbedPane;
	private BookChapterForm bookChapterForm;
	private PaperForm paperForm;
	private PresentationForm presentationForm;
	
	public ResearcherActivityForm(Researcher researcher) {
		this.researcher = researcher;
		
		setBackground(Color.WHITE);
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
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.addTab("Capítulo", null, getBookChapterForm(), null);
			tabbedPane.addTab("Artículo", null, getPaperForm(), null);
			tabbedPane.addTab("Ponencia", null, getPresentationForm(), null);
		}
		return tabbedPane;
	}
	private BookChapterForm getBookChapterForm() {
		if (bookChapterForm == null) {
			bookChapterForm = new BookChapterForm(researcher);
			GridBagLayout gridBagLayout = (GridBagLayout) bookChapterForm.getLayout();
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
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
