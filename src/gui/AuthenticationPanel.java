package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

@SuppressWarnings("serial")
public class AuthenticationPanel extends JPanel {
	private JTextField passcode;
	private JLabel lblAutorizacin;
	private JLabel lblIngresaElCdigo;
	public AuthenticationPanel() {
		setLayout(null);
		add(getPasscode());
		add(getLblAutorizacin());
		add(getLblIngresaElCdigo());
	}
	private JTextField getPasscode() {
		if (passcode == null) {
			passcode = new JTextField();
			passcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
			passcode.setToolTipText("C\u00F3digo");
			passcode.setBounds(43, 79, 201, 50);
			passcode.setColumns(10);
		}
		return passcode;
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
