/**
 * implementation of UserService
 */
package ch.zli.m223.ksh18a.mia.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.mia.crm.exception.InvalidArgumentsException;
import ch.zli.m223.ksh18a.mia.crm.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh18a.mia.crm.exception.UserNotFoundException;
import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.model.Termin;
import ch.zli.m223.ksh18a.mia.crm.repository.UserRepository;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> res = new ArrayList<>();
		for (var user : userRepository.findAll()) {
			res.add(user);
		}
		return res;
	} // end of getAllUsers

	@Override
	public AppUser getUserById(long userId) {

		return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
	} // end of getUserById

	@Override
	public AppUser getByUserName(String userName) {
		if (userName == null) {
			// TODO: better exception
			throw new UserNotFoundException();
		}
		return userRepository.getByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));
	} // end of findByUserName

	@Override
	public AppUser addUser(String userName, String password, List<String> role, List<Termin> termin) {
		// check parameter
		if (userName == null || password == null) {
			throw new InvalidArgumentsException();
		}
		// check if already exist
		if (userRepository.getByUserName(userName).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		return userRepository.createUser(userName, password, role == null ? new ArrayList<>() : role,  termin == null ? new ArrayList<>() : termin);
	} // end of addUser

	@Override
	public void deleteUserById(long userId) {
		getUserById(userId);
		userRepository.deleteById(userId);
	} // end of deleteUserById

	@Override
	public AppUser setRolesForUser(long userId, List<String> roles) {
		if (roles == null) { 
			throw new InvalidArgumentsException();
		}
		AppUser user = getUserById(userId);
		return userRepository.setRoles(user, roles);
	} // end of setRolesForuser

}
