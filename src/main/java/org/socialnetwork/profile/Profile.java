package org.socialnetwork.profile;

import java.util.List;

public class Profile {

	private String userId;

	public Profile(String userId, String userName, List<String> readProfile,
			List<String> sharedProfile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.readProfile = readProfile;

	}

	private String userName;
	private List<String> readProfile;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getReadProfile() {
		return readProfile;
	}

	public void setReadProfile(List<String> readProfile) {
		this.readProfile = readProfile;
	}

	

}
