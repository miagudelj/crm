package ch.zli.m223.ksh18a.mia.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.mia.crm.exception.UserNotFoundException;
import ch.zli.m223.ksh18a.mia.crm.model.Termin;
import ch.zli.m223.ksh18a.mia.crm.repository.TerminRepository;

/**
 * @author Mia Gudelj
 * @since 15-07-2021
 */

@Service
public class TerminServiceImpl implements TerminService {

	// variables
	@Autowired
	private TerminRepository terminRepository;

	@Override
	public List<Termin> getAllTermine() {
		List<Termin> res = new ArrayList<>();
		for (Termin termin : terminRepository.findAll()) {
			res.add(termin);
		}
		return res;
	} // end of getAllTermine

	@Override
	public Termin getTerminById(long terminId) {
		// TODO Auto-generated method stub
		return terminRepository.findById(terminId).orElseThrow(UserNotFoundException::new);
	} // end of getTerminById

//	@Override
//	public Termin addTermin(String beschreibung, String date) {
//		return terminRepository.addTermin(beschreibung, date);
//	} // end of addTermin
//
//	@Override
//	public void deleteTerminById(long terminId) {
//		getTerminById(terminId);
//		terminRepository.deleteById(terminId);
//	} // end of deleteTerminById

}
