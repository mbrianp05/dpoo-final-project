package gui;

import gui.event.OnAuthenticate;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import auth.Authentication;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AuthenticationPanel extends JPanel {
	private JLabel lblAutorizacin;
	private JLabel lblIngresaElCdigo;
	private LengthTextField passcode;
	private JButton submitBtn;
	private JLabel errorMsg;
	private OnAuthenticate onAuthenticateEvent;

	public AuthenticationPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setLayout(null);
		add(getLblAutorizacin());
		add(getLblIngresaElCdigo());
		add(getPasscode());
		add(getSubmitBtn());
		add(getErrorMsg());
	}
	
	public void listenTo(OnAuthenticate listener) {
		onAuthenticateEvent = listener;
	}

	private void verifyPasscode() {
		String input = passcode.getText();
		boolean allowAccess = Authentication.authorize(input);
		
		if (!allowAccess) {
			errorMsg.setText("El código es incorrecto");
		} else {
			onAuthenticateEvent.exec();
		}
	}
	
	private JLabel getLblAutorizacin() {
		if (lblAutorizacin == null) {
			lblAutorizacin = new JLabel("Autorizaci\u00F3n");
			lblAutorizacin.setBounds(27, 13, 199, 32);
			lblAutorizacin.setHorizontalAlignment(SwingConstants.LEFT);
			lblAutorizacin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		}
		
		return lblAutorizacin;
	}

	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			lblIngresaElCdigo = new JLabel("Ingresa el c\u00F3digo de acceso");
			lblIngresaElCdigo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lblIngresaElCdigo.setBounds(27, 45, 188, 32);
			lblIngresaElCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
		return lblIngresaElCdigo;
	}
	
	private LengthTextField getPasscode() {
		if (passcode == null) {
			passcode = new LengthTextField();
			passcode.setMaxLength(7);
			passcode.setBounds(27, 110, 215, 32);
		}
		
		return passcode;
	}
	
	private JButton getSubmitBtn() {
		if (submitBtn == null) {
			submitBtn = new JButton("Acceder");
			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					verifyPasscode();
				}
			});
			submitBtn.setBounds(27, 160, 215, 32);
		}
		
		return submitBtn;
	}
	
	private JLabel getErrorMsg() {
		if (errorMsg == null) {
			errorMsg = new JLabel("");
			errorMsg.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			errorMsg.setForeground(new Color(204, 102, 102));
			errorMsg.setBounds(27, 80, 215, 16);
		}
		
		return errorMsg;
	}
}
