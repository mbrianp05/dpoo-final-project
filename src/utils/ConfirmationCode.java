package utils;

public class ConfirmationCode {
	private final String code;
	private final String recipientEmail;
	private final long expirationTime;
	
	public ConfirmationCode(String code, long expirationTime, String recipientEmail) {
		this.code = code;
		this.recipientEmail = recipientEmail;
		this.expirationTime = expirationTime;
	}

	public String getCode() {
		return code;
	}
	
	public String getEmail() {
		return recipientEmail;
	}
	
	public long getExpirationTime() {
		return expirationTime;
	}
}
