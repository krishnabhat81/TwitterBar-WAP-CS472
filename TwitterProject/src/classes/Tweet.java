package classes;

public class Tweet {
	private String userId;
	private String userName;
	private String userImage;
	private String userText;
	
	public Tweet(String userId, String userName, String userImage, String userText) {
		this.userId = userId;
		this.userName = userName;
		this.userImage = userImage;
		this.userText = userText;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}
	
	

}
