package org.socialnetwork.service;



import java.util.List;

import org.apache.log4j.Logger;
import org.socialnetwork.profile.Profile;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImpl implements ProfileService {

	static Logger log = Logger.getLogger(ProfileServiceImpl.class.getName());

	private List<Profile> profiles;

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}


	@Override
	public Profile readProfile(String userId, String profileUserId,
			List<Profile> profiles) {


		for (Profile profile : profiles) {
			if (profile.getUserId() == profileUserId) {
				return profile;
			}

		}

		return null;

	}

	@Override
	public void shareProfile(String userId, String profileUserId,
			String targetUserId, List<Profile> profiles) {

		System.out.println("in share profile");
		for (Profile profile : profiles) {
			if (profile.getUserId() == targetUserId) {
				
				List<String> tempReadProfile = profile.getReadProfile();
								
				boolean nameExists=false;
				
				for(String name:tempReadProfile){
					
					if(name==profileUserId)
					 	nameExists=true;
				}
				
				if(!nameExists){
				tempReadProfile.add(profileUserId);
				profile.setReadProfile(tempReadProfile);}
				

				
			}

		}

	}

	@Override
	public void unshareProfile(String userId, String targetUserId,
			List<Profile> profiles) {
		// TODO Auto-generated method stub

		for (Profile profile : profiles) {

			if (profile.getUserId() == targetUserId) {
				
				List<String> tempReadProfile = profile.getReadProfile();
				tempReadProfile.remove(userId);
				profile.setReadProfile(tempReadProfile);

			}

		}

	}

}
