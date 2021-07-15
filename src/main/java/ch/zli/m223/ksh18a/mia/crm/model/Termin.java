/**
 * user
 */
package ch.zli.m223.ksh18a.mia.crm.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

public interface Termin {

	/**
	 * gets id of user
	 * 
	 * @return id of user
	 */
	public Long getId();
	
	/**
	 * 
	 * @return
	 */
	public String beschreibung();
	
	/**
	 * 
	 * @return
	 */

    @Pattern(regexp = "([0-9]{2}/){2}[0-9]{4}")
	public LocalDateTime datum();
	
	/**
	 * 
	 * @return
	 */
	public AppUser getUser();
}
