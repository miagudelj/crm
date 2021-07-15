package ch.zli.m223.ksh18a.mia.crm.controller;

import ch.zli.m223.ksh18a.mia.crm.model.Termin;

public class TerminDto {
	// variables
		public Long id;
		public String beschreibung;
		public String date;
		

		/**
		 * 
		 * @param termin
		 */
		public TerminDto(Termin termin) {
			this.id = termin.getId();
			this.beschreibung = termin.getBeschreibung();
			this.date = termin.getDate();
		}
}
