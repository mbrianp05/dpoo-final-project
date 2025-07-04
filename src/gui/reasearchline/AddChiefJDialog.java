package gui.reasearchline;

import gui.event.OnProfesorFormActionTriggered;
import gui.event.OnSetChief;
import gui.researchers.ProfesorForm;
import gui.researchers.ProfesorFormData;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class AddChiefJDialog extends JDialog {
	private static final long serialVersionUID = 3142798032279882910L;

	private String[] matters;
	private ProfesorForm profesorForm;
	private OnSetChief listener;
	private ProfesorFormData data;
	
	/**
	 * @wbp.parser.constructor
	 */
	public AddChiefJDialog(String[] matters, OnSetChief listener) {
		this(matters, listener, null);
	}

	public AddChiefJDialog(String[] matters, OnSetChief listener, ProfesorFormData data) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddChiefJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		
		setBounds(100, 100, 800, 679);
		
		this.matters = matters;
		this.listener = listener;
		this.data = data;
		setTitle("Insertar datos del jefe de la l\u00EDnea");
		setModal(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 0, 70, 0};
		gridBagLayout.rowHeights = new int[]{70, 545, 70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_profesorForm = new GridBagConstraints();
		gbc_profesorForm.insets = new Insets(0, 0, 5, 5);
		gbc_profesorForm.fill = GridBagConstraints.BOTH;
		gbc_profesorForm.gridx = 1;
		gbc_profesorForm.gridy = 1;
		getContentPane().add(getProfesorForm(), gbc_profesorForm);
	}

	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(matters, data);
			profesorForm.listenTo(new OnProfesorFormActionTriggered() {
				@Override
				public void actionPerformed(ProfesorFormData data) {
					listener.set(data);
					setVisible(false);
				}
			});
		}

		return profesorForm;
	}
}
