package org.socialnetwork.service;

import java.util.List;

import org.socialnetwork.profile.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
	
	
	/**
 	* Read the profile of another user or oneself.
 	* @param userId the ID of the current user
 	* @param profileUserId the ID of user, whose profile is being requested
 	* @return the profile for profileUserId  
 	*/
	Profile readProfile(String userId, String profileUserId,List<Profile> profiles);
    
	/**
 	* Share a profile with another user. The profile may or may not belong to the current user.
 	* @param userId the ID of the current user
 	* @param profileUserId the ID of the user, whose profile is being shared
 	* @param targetUserId the ID of the user to share the profile with
 	*/
	void shareProfile(String userId, String profileUserId, String targetUserId,List<Profile> profiles);
    
	/**
 	* Unshare the current user's own profile with another user.
 	* @param userId
 	* @param targetUserId
 	*/
	void unshareProfile(String userId, String targetUserId,List<Profile> profiles);

}
