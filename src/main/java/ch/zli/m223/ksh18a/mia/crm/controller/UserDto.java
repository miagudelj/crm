/**
 * communicates user information to client
 */
package ch.zli.m223.ksh18a.mia.crm.controller;

import java.util.List;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */
public class UserDto {
	// variables
	public Long id;
	public final String userName;
	public List<String> roles;
	

	/**
	 * Constructor
	 *  
	 * @param user
	 */
	public UserDto(AppUser user) {
		this.id = user.getId();
		this.userName = user.getUsername();
		this.roles = user.getRoles();
	}
}