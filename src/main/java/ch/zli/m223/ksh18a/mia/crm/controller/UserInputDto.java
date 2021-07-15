/**
 * 
 */
package ch.zli.m223.ksh18a.mia.crm.controller;

import java.util.List;

import ch.zli.m223.ksh18a.mia.crm.model.Termin;

/**
 * @author Mia Gudelj
 * @since 12-07-2021
 */

public class UserInputDto {
	
	// variables
	public String userName;
	public String password;
	public List<String> roles;
	public List<Termin> termine;
}
