package utils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.SwingWorker;

public class EmailSenderThread extends SwingWorker<Void, Void> {
	private String email;

	public EmailSenderThread(String email) {
		this.email = email;
	}

	@Override
	protected Void doInBackground() throws AddressException, MessagingException {
		Email.sendConfirmationEmail(email);
		
		return null;
	}
}
