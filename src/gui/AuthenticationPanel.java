package gui;

import gui.event.OnAuthenticate;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import auth.Authentication;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

<<<<<<< HEAD
public class AuthenticationPanel extends JPanel {
	private JLabel lblAuthorization;
	private JLabel lblIngresaElCdigo;
	
	private JButton submitBtn;
	private JLabel errorMsg;
	private LengthTextField passcode;
	private OnAuthenticate onAuthenticateEvent;

	public AuthenticationPanel() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(204, 0, 102), 2, true));
		setLayout(null);
		add(getLblAuthorization());
		add(getLblIngresaElCdigo());
		
		add(getSubmitBtn());
		add(getErrorMsg());
		add(getPasscode());
=======
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
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
	}

	public void listenTo(OnAuthenticate listener) {
		onAuthenticateEvent = listener;
	}

	private void verifyPasscode() {
		String input = passcode.getText();
		boolean allowAccess = Authentication.authorize(input);

		if (!allowAccess) {
<<<<<<< HEAD
			errorMsg.setText("El código es incorrecto");
			passcode.setText("");
=======
			errorMsg.setText("El c�digo es incorrecto");
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
		} else {
			onAuthenticateEvent.exec();
		}
	}

<<<<<<< HEAD
	private JLabel getLblAuthorization() {
		if (lblAuthorization == null) {
			lblAuthorization = new JLabel("Autorizaci\u00F3n");
			lblAuthorization.setBounds(27, 13, 199, 32);
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		}

		return lblAuthorization;
=======
	private JLabel getLblAutorizacin() {
		if (lblAutorizacin == null) {
			lblAutorizacin = new JLabel("Autorizaci\u00F3n");
			lblAutorizacin.setBounds(27, 13, 199, 32);
			lblAutorizacin.setHorizontalAlignment(SwingConstants.LEFT);
			lblAutorizacin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		}

		return lblAutorizacin;
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
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

<<<<<<< HEAD
	private JButton getSubmitBtn() {
		if (submitBtn == null) {
			submitBtn = new JButton("Acceder");
			submitBtn.setForeground(Color.DARK_GRAY);
			submitBtn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			submitBtn.setBackground(new Color(204, 0, 102));
	
=======
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
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
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
<<<<<<< HEAD
	
	private LengthTextField getPasscode() {
		if (passcode == null) {
			passcode = new LengthTextField();
			passcode.setBounds(27, 109, 215, 32);
		}
		return passcode;
	}
=======
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
}
