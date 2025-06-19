package utils;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;
import java.util.concurrent.*;

public class Email {
	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String SMTP_PORT = "587";
	private static final String USERNAME = "mbrianp05@gmail.com";
	private static final String PASSWORD = "fomd yusx jdkl rqau";
	private static final String FROM_EMAIL = "facultydataapp@management.com";

	private static ConfirmationCode confirmationCode;

	public static void removeCode() {
		confirmationCode = null;
	}

	public static void sendConfirmationEmail(String recipientEmail) throws AddressException, MessagingException {
		String code = CodeGenerator.generateRandomCode(6);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);

		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(FROM_EMAIL));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
		message.setSubject("C�digo de Confirmaci�n");

		String emailText = "Tu c�digo de confirmaci�n es: " + code + "\n\n" +
				"Este c�digo expirar� en 3 minutos.";
		message.setText(emailText);

		Transport.send(message);

		// Crear el c�digo despu�s de enviar el email
		long expirationTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(3);
		confirmationCode = new ConfirmationCode(code, expirationTime, recipientEmail);
	}

	public static boolean verifyCode(String code) {
		if (confirmationCode == null) {
			return false;
		}

		if (System.currentTimeMillis() > confirmationCode.getExpirationTime()) {
			confirmationCode = null;

			return false;
		}

		return confirmationCode.getCode().equals(code);
	}
}
