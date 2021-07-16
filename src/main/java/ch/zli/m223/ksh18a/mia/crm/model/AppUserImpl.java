/**
 * implementation of AppUser
 */
package ch.zli.m223.ksh18a.mia.crm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mia Gudelj
 * @since 13-07-2021
 */

@SuppressWarnings("serial")
@Entity(name = "AppUser")
//@Table
public class AppUserImpl implements AppUser {

	// variables 
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String passwordHash;
	@ElementCollection(fetch = FetchType.EAGER)
	// For simple types only, no Role objects allowed
	private Set<String> roles;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<TerminImpl> termine;

	
	/**
	 * Constructor 
	 * 
	 * @param userName
	 * @param password
	 */
	public AppUserImpl(String userName, String password, List<String> roles) { //, List<Termin> termine) {
		this.userName = userName;
		this.setPassword(password);
		this.setRoles(roles);
		this.termine = new ArrayList<>();
	} // end of AppUserImpl
	
	/**
	 * protected Constructor
	 * 
	 * For JPA only
	 */
	protected AppUserImpl() {} 

	
	// -- AUTO GENERATED METHODS --
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
			.map(role -> new SimpleGrantedAuthority(role))
			.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {return true;}
	
	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return true;}
	
	@Override
	public Long getId() {return id;}
	
	@Override
	public String getPassword() {return passwordHash;}

	@Override
	public String getUsername() {return userName;}

	@Override
	public List<String> getRoles() {
		return new ArrayList<String>(roles);
	}

	@Override
	public List<Termin> getTermine() {
		// TODO Auto-generated method stub
		return new ArrayList<Termin>(termine);
	}


	/**
	 * set password of user 
	 * encode and hash it
	 * 
	 * @param password
	 */
	private void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		passwordHash = encoder.encode(password);
	} // end of setpassword
	

	 /** 
	  * sets roles of the user into a hash
	  * 
	  * @param roles
	  * @return userImplementation
	  */
	public AppUserImpl setRoles(List<String> roles) {
		this.roles = new HashSet<>(roles);
		return this;
	} // end of setRoles

	public void addTermin(TerminImpl termin) {
		this.termine.add(termin);
	}
	 
//	/** 
//	  * sets roles of the user into a hash
//	  * 
//	  * @param roles
//	  * @return userImplementation
//	  */
//	public AppUserImpl setTermine(List<Termin> termine) {
//		this.termine = new ArrayList<>(termine);
//		return this;
//	} // end of setRoles
}
