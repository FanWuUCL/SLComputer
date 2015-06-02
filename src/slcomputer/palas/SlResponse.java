package slcomputer.palas;

public class SlResponse {

	public SlResponse(String user, String responseString) {
		if (responseString.equals("error")) {
			throw new RuntimeException("The server responded with an error!");
		} else {
			if (responseString.equals("norecord")) {
				this.valid = false;
			} else {
				this.valid = true;
				this.user = user;
				String responseStringPart = responseString.substring(3);
				int index = responseStringPart.indexOf(":");
				this.type = Integer.parseInt(responseStringPart.substring(0, index));
				this.account = responseStringPart.substring(index + 1);
			}
		}
	}

	private boolean valid; // Indicates whether the user is valid
	
	private String user; // Contains the name of the user
	
	private String account; // Contains the account string
	
	private int type; // Contains the type number

	public boolean isValid() {
		return valid;
	}

	public String getUser() {
		return user;
	}

	public String getAccount() {
		return account;
	}

	public int getType() {
		return type - 1;
	}

}
