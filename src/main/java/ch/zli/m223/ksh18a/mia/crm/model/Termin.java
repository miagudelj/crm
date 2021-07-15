/**
 * user
 */
package ch.zli.m223.ksh18a.mia.crm.model;

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
	public String getBeschreibung();

	/**
	 * 
	 * @return
	 */
	public String getDate();
}
