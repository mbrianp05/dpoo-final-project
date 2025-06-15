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

	public static void sendConfirmationEmail(String recipientEmail) {
		String code = CodeGenerator.generateRandomCode(6);
		long expirationTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1) + TimeUnit.SECONDS.toMillis(30);

		confirmationCode = new ConfirmationCode(code, expirationTime, recipientEmail);

		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", SMTP_HOST);
			props.put("mail.smtp.port", SMTP_PORT);
			
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

			// Crear sesión
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USERNAME, PASSWORD);
				}
			});

			// Crear mensaje
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(FROM_EMAIL));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Código de Confirmación");

			// Cuerpo del mensaje con el código y tiempo de expiración
			String emailText = "Tu código de confirmación es: " + code + "\n\n" +
					"Este código expirará en 1 minuto y 30 segundos.\n" +
					"Por favor, no compartas este código con nadie.";
			message.setText(emailText);

			Transport.send(message);
		} catch (MessagingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
		}
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
