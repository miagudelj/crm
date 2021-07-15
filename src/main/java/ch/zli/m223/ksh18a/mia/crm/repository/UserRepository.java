/**
 * gives user data to database
 */
package ch.zli.m223.ksh18a.mia.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.model.AppUserImpl;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */
public interface UserRepository extends CrudRepository<AppUserImpl, Long> {

	/**
	 * inserts new user
	 * 
	 * @param userName
	 * @param password
	 * @param role
	 * @return user
	 */
	default AppUser insertUser(String userName, String password, List<String> role) {
		return save(new AppUserImpl(userName, password, role));

	}

	/**
	 * gets user by username
	 * 
	 * @param userName
	 * @return user
	 */
	public Optional<AppUser> getByUserName(String userName);

	default AppUser setRoles(AppUser user, List<String> roles) {
		return save((AppUserImpl) user).setRoles(roles);
	}
}
