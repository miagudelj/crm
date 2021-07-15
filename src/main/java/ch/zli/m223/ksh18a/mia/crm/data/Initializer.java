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
		
		userRepository.insertUser("Max", "max", user);
		userRepository.insertUser("Mia", "mia", admin);
		userRepository.insertUser("Nici", "nici", usemin);
	}
}
