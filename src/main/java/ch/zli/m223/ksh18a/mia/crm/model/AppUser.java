/**
 * user
 */
package ch.zli.m223.ksh18a.mia.crm.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

public interface AppUser extends UserDetails {

	/**
	 * gets id of user
	 * 
	 * @return id of user
	 */
	public Long getId();
	
	/**
	 * gets roles of user
	 * 
	 * @return list of roles
	 */
	public List<String> getRoles();

	/**
	 * get termine of user
	 * 
	 * @return list of termine
	 */
	public List<Termin> getTermine();
}
