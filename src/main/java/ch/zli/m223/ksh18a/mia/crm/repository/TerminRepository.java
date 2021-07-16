package ch.zli.m223.ksh18a.mia.crm.repository;

import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.model.AppUserImpl;
import ch.zli.m223.ksh18a.mia.crm.model.Termin;
import ch.zli.m223.ksh18a.mia.crm.model.TerminImpl;

public interface TerminRepository extends CrudRepository<TerminImpl, Long> {
	
	
	/*default Termin createTermin(String beschreibung, String date) {
		return save(new TerminImpl(beschreibung, date));
	}*/
	
	public default Termin addTermin(AppUser user, String beschreibung, String datum) {
		AppUserImpl appUserImpl = (AppUserImpl)user;
		
		TerminImpl termin = new TerminImpl(appUserImpl, beschreibung, datum);
		appUserImpl.addTermin(termin);
		save(termin);
		return termin;
	}
	
	default public Termin editTermin(Termin termin, String beschreibung, String date) {
		TerminImpl terminImpl = (TerminImpl)termin;
		terminImpl.setBeschreibung(beschreibung);
		terminImpl.setDate(date);
		return save(terminImpl);
	}
}
