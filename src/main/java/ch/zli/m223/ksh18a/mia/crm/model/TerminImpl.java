package ch.zli.m223.ksh18a.mia.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="Termin")
public class TerminImpl implements Termin {

	// variables 
	
	@Id 
	@GeneratedValue
	private Long id;
	private String beschreibung;
	@DateTimeFormat(style = "dd.mm.yyyy")
	private String date;

	public TerminImpl(String beschreibung, String date) {
		this.setBeschreibung(beschreibung);
		this.setDate(date);
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getBeschreibung() {
		return beschreibung;
	}

	@Override
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param beschreibung
	 */
	@Override
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * 
	 * @param date
	 */
	@Override
	public void setDate(String date) {
		this.date = date;
	}

}
