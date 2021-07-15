package ch.zli.m223.ksh18a.mia.crm.repository;

import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.mia.crm.model.Termin;
import ch.zli.m223.ksh18a.mia.crm.model.TerminImpl;

public interface TerminRepository extends CrudRepository<TerminImpl, Long> {
	
	/**
	 * 
	 * @param beschreibung
	 * @param date
	 * @return
	 */
	default Termin createTermin(String beschreibung, String date) {
		return save(new TerminImpl(beschreibung, date));
	}
	
}
