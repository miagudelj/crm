/**
 * 
 */
package ch.zli.m223.ksh18a.mia.crm.service;

import java.util.List;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

public interface UserService {

	/**
	 * gets all users
	 * 
	 * @return list of users
	 */
	public List<AppUser> getAllUsers();

	/**
	 * adds User
	 * 
	 * @param userName
	 * @param password
	 * @param roles
	 * @return user
	 */
	public AppUser addUser(String userName, String password, List<String> roles);

	/**
	 * deletes a user by id 
	 * 
	 * @param userId
	 */
	public void deleteUserById(long userId);

	/**
	 * gets user by username
	 * 
	 * @param userName
	 * @return user
	 */
	public AppUser getByUserName(String userName);

	/**
	 * gets user by id 
	 * 
	 * @param userId
	 * @return user
	 */
	public AppUser getUserById(long userId);

	/**
	 * sets roles of the user
	 * 
	 * @param userId
	 * @param roles
	 * @return user
	 */
	public AppUser setRolesForUser(long userId, List<String> roles);

}
