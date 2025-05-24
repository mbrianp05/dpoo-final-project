package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class AuthenticationPanel extends JPanel {
	private JTextField txtXxxxxxxxxxxxxx;
	private JLabel lblAutorizacin;
	private JLabel lblIngresaElCdigo;
	public AuthenticationPanel() {
		setLayout(null);
		add(getTxtXxxxxxxxxxxxxx());
		add(getLblAutorizacin());
		add(getLblIngresaElCdigo());
	}
	private JTextField getTxtXxxxxxxxxxxxxx() {
		if (txtXxxxxxxxxxxxxx == null) {
			txtXxxxxxxxxxxxxx = new JTextField();
			txtXxxxxxxxxxxxxx.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtXxxxxxxxxxxxxx.setToolTipText("C\u00F3digo");
			txtXxxxxxxxxxxxxx.setBounds(43, 79, 201, 50);
			txtXxxxxxxxxxxxxx.setColumns(10);
		}
		return txtXxxxxxxxxxxxxx;
	}
	private JLabel getLblAutorizacin() {
		if (lblAutorizacin == null) {
			lblAutorizacin = new JLabel("Autorizaci\u00F3n");
			lblAutorizacin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
			lblAutorizacin.setBounds(43, 0, 201, 50);
		}
		return lblAutorizacin;
	}
	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			lblIngresaElCdigo = new JLabel("Ingresa el c\u00F3digo de acceso");
			lblIngresaElCdigo.setBounds(43, 50, 201, 16);
		}
		return lblIngresaElCdigo;
	}
}
