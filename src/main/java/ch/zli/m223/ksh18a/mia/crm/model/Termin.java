/**
 * user
 */
package ch.zli.m223.ksh18a.mia.crm.model;

/**
 * @author Mia Gudelj
 * @since 15-07-2021
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
	
	public void setBeschreibung(String beschreibung);
	
	public void setDate(String date);
}
