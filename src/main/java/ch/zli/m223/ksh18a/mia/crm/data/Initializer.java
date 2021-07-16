/**
 * generate objects (user)
 */
package ch.zli.m223.ksh18a.mia.crm.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.repository.UserRepository;
import ch.zli.m223.ksh18a.mia.crm.role.AppRoles;

/**
 * @author Mia Gudelj
 * @since 12-07-2021
 */
@Component
public class Initializer implements ApplicationRunner {

	// variables
	@Autowired
	UserRepository userRepository;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<String> admin = new ArrayList<>();
		List<String> user = new ArrayList<>();
		List<String> usemin= new ArrayList<>();

		admin.add(AppRoles.admin);
		user.add(AppRoles.user);
		usemin.add(AppRoles.admin);
		usemin.add(AppRoles.user);
		

//		List<Termin> termin1 = new ArrayList<>();
//		List<Termin> termin2 = new ArrayList<>();
//
//		termin1.add(new TerminImpl("Zahnarzt", "16.05.2021"));
//		termin2.add(new TerminImpl("Impfen", "06.07.2021"));
//		termin2.add(new TerminImpl("Zahnarzt", "21.07.2021"));
//		
		AppUser max = userRepository.createUser("Max", "max", user);
		AppUser mia = userRepository.createUser("Mia", "mia", admin);
		AppUser nici = userRepository.createUser("Nici", "nici", usemin);
		

	}
}
