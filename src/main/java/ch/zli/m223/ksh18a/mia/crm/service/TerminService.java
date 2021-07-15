package ch.zli.m223.ksh18a.mia.crm.service;

import java.util.List;

import ch.zli.m223.ksh18a.mia.crm.model.Termin;


/**
 * @author Mia Gudelj
 * @since 15-07-2021
 */

public interface TerminService {
	/**
	 * gets all termin
	 * 
	 * @return list of termin
	 */
	public List<Termin> getAllTermine();

	/**
	 * gets termin by id 
	 * 
	 * @param terminId
	 * @return termin
	 */
	public Termin getTerminById(long terminId);

	/**
	 * adds termin
	 * 
	 * @param beschreibung
	 * @param date
	 * @return termin
	 */
	public Termin addTermin(String beschreibung, String date);

	/**
	 * deletes a termin by id 
	 * 
	 * @param userId
	 */
	public void deleteTerminById(long terminId);

}
