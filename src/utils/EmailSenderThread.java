package utils;

import javax.swing.SwingWorker;

public class EmailSenderThread extends SwingWorker<Void, Void> {
	private String email;
	
	public EmailSenderThread(String email) {
		this.email = email;
	}
	
	@Override
	protected Void doInBackground() {
		Email.sendConfirmationEmail(email);
		
		return null;
	}
}
