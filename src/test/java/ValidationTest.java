import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.socialnetwork.profile.Profile;
import org.socialnetwork.profile.UnauthorizedException;
import org.socialnetwork.service.ProfileService;
import org.socialnetwork.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/bean-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidationTest {

	static Logger log = Logger.getLogger(ValidationTest.class.getName());

	@Autowired
	ProfileService profileService;
	static String userId = "xcxux";
	static String targetId = "abc";

	static Profile alice;
	static Profile bob;
	static Profile carl;

	static List<Profile> profiles;

	public  ValidationTest() {
		log.info("hello logger");
		List<String> aliceList = (new ArrayList<String>());
	
		alice = new Profile("Alice", "Alice", aliceList, null);

		List<String> bobList = (new ArrayList<String>());
		
		bob = new Profile("Bob", "Bob", bobList, null);

		List<String> carlList = (new ArrayList<String>());

		carl = new Profile("Carl", "Carl", carlList, null);

		profiles = new ArrayList<Profile>();
		profiles.add(alice);
		profiles.add(bob);
		profiles.add(carl);	}
	
		
	  @Test (expected=UnauthorizedException.class)
	  public void testA() {
	  
	  log.info(
	 "<<----------------------------Test A ---------------------------->>");
	  log.info(
	  "<<--------------------------Bob trying to access Alice Profile------------>> "
	  ); 
	  Profile readProfile = profileService.readProfile("Bob", "Alice",
	  profiles);
	  System.out.println(" read profile successful of " +
	  readProfile.getUserId() + " with username " + readProfile.getUserName());
	  
	  }
	 

	@Test()
	public void testB() {

		log.info("<<----------------------------Test B ---------------------------->>");
		log.info("<<---Alice shares her profile with Bob, and Bob can read Alice’s profile------->> ");
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		Profile readProfile = profileService.readProfile("Bob", "Alice",
				  profiles);
				  System.out.println(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());

	}

	@Test
	public void testC() {

		log.info("<<----------------------------Test C ---------------------------->>");
		for (Profile profile :profiles)
			System.out.println(profile.getUserId());
		log.info("<<---Alice shares her profile with Bob, and Bob shares Alice’s profile with Carl, and Carl can ready Alice’s profile------->> ");
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		profileService.shareProfile("Bob", "Alice", "Carl", profiles);
		
		 Profile readProfile = profileService.readProfile("Carl", "Alice",
				  profiles);
				  System.out.println(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());
				  
		
	}
	
	
	@Test (expected=UnauthorizedException.class)
	public void testD(){
		
		log.info("<<----------------------------Test D ---------------------------->>");
		
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		
		profileService.shareProfile("Bob", "Carl", "Alice", profiles);
	}
	
	
	@Test (expected=UnauthorizedException.class)
	public void testE(){
		

		log.info("<<----------------------------Test E ---------------------------->>");
		
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		log.info("Alice shared his profile with Bob");
		
		profileService.shareProfile("Bob", "Alice", "Carl", profiles);
		log.info("Bob shared Alice profile with Carl ");
		
		profileService.unshareProfile("Alice", "Carl", profiles);
		log.info("Alice unshares with carl");
		
		Profile readProfile = profileService.readProfile("Carl", "Alice",
				  profiles);
				  log.info(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());
				 
		
	}
	

	@Test (expected=UnauthorizedException.class)
	public void testF(){
		
		log.info("<<----------------------------Test F ---------------------------->>");

		
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		log.info("Alice shared his profile with Bob");
		
		profileService.shareProfile("Alice", "Alice", "Carl", profiles);
		log.info("Alice shared his profile with Carl");
		
		profileService.shareProfile("Carl", "Alice", "Bob", profiles);
		log.info("Carl shared Alice profile with Bob");
		
		profileService.unshareProfile("Alice", "Bob", profiles);
		log.info("Alice unshared his profile with Bob");
		
		Profile readProfile = profileService.readProfile("Bob", "Alice",
				  profiles);
		
		log.info(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());
				 
       
					
		
	}
	
	
	@Test (expected=UnauthorizedException.class)
	public void testG(){
		
		log.info("<<-------------------------Test G------------->>");
		
		profileService.shareProfile("Alice", "Alice", "Bob", profiles);
		log.info("Alice shared his profile with Bob");
		
		profileService.shareProfile("Bob", "Alice", "Carl", profiles);
		log.info("Bob shared Alice profile with Carl");
	
		profileService.unshareProfile("Alice", "Bob", profiles);
		
		Profile readProfile = profileService.readProfile("Carl", "Alice",
				  profiles);
		
		log.info(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());
		
		 readProfile = profileService.readProfile("Bob", "Alice",
				  profiles);
		
		log.info(" read profile successful of " +
				  readProfile.getUserId() + " with username " + readProfile.getUserName());
	
		
	
	}
	}