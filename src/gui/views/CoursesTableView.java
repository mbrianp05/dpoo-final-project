package gui.views;

import javax.swing.JPanel;

import schooling.Faculty;
import java.awt.GridBagLayout;
import java.awt.Color;

public class CoursesTableView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CoursesTableView(Faculty faculty) {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}

}
