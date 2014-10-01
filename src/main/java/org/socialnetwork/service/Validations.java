package org.socialnetwork.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.socialnetwork.profile.Profile;
import org.socialnetwork.profile.UnauthorizedException;

@Aspect
public class Validations {

	static Logger log = Logger.getLogger(ProfileServiceImpl.class.getName());

	@Before("execution(* org.socialnetwork.service.ProfileService.readProfile(..))")
	public void checkAccess(JoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		String userId = (String) args[0];
		String profileUserId = (String) args[1];
		List<Profile> profiles = (List<Profile>) args[2];

		boolean readAccess = false;

		if (userId == profileUserId) {
			readAccess = true;
		}

		for (Profile profile : profiles) {
			if (profile.getUserId() == userId) {

				System.out.println("got profile in list");
				List<String> readProfiles = profile.getReadProfile();
				for (String readP : readProfiles) {
					if (readP == profileUserId) {
						System.out.println("user exist in readList");
						readAccess = true;
					}
				}

			}
		}

		if (!readAccess) {
			
				log.info("Access denied");
				UnauthorizedException unauthorizedException = new UnauthorizedException(
						"Access Denied");
				throw unauthorizedException;
			
		}

		System.out.println("ACCESS ALLOWED: USER  " + userId
				+ " can access profile of USER " + profileUserId);
		// System.out.println("profileUserId captured is -->" + profileUserId);

		// System.out.println("Checking before readProfile ");
		System.out.println("  : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}

	@Before("execution(* org.socialnetwork.service.ProfileService.shareProfile(..))")
	public void checkAccess2(JoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		String userId = (String) args[0];
		System.out.println("userId is " + userId);

		String profileUserId = (String) args[1];
		System.out.println("profile id is " + profileUserId);

		List<Profile> profiles = (List<Profile>) args[3];
		System.out.println("in check access2");

		boolean readAccess = false;

		if (userId == profileUserId) {
			readAccess = true;
		}

		for (Profile profile : profiles)
			System.out.println(profile.getUserId());

		for (Profile profile : profiles) {
			System.out.println(profileUserId);
			System.out.println(profile.getUserId());
			if (profile.getUserId() == userId) {

				System.out.println("got profile in list2");
				List<String> readProfiles = profile.getReadProfile();
				System.out.println("read profile for " + profile.getUserId()
						+ " is " + readProfiles.toString());
				for (String readP : readProfiles) {
					if (readP == profileUserId) {
						System.out.println("user exist in readList");
						readAccess = true;
					}
				}

			}
		}

		if (!readAccess) {
			
			log.info("Access denied");
				UnauthorizedException unauthorizedException = new UnauthorizedException(
						"Access Denied");
				throw unauthorizedException;
			
		}

		System.out.println("ACCESS ALLOWED: USER  " + userId
				+ " can access profile of USER " + profileUserId);
		// System.out.println("profileUserId captured is -->" + profileUserId);

		// System.out.println("Checking before readProfile ");
		System.out.println("  : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}

}
