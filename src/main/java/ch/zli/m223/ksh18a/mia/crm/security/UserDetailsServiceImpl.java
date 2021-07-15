/**
 * Implements userDetailsService
 */

package ch.zli.m223.ksh18a.mia.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.mia.crm.model.AppUser;
import ch.zli.m223.ksh18a.mia.crm.repository.UserRepository;

/**
 * @author Mia Gudelj
 * @since 14-07-2021
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	//variables 
	@Autowired 
	UserRepository userRepository;
	
	
	/**
	 * loads user by username
	 * 
	 * @param username
	 * @return user UserDetail
	 */
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		AppUser user = userRepository.getByUserName(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("User " + username + " not found");
		});
		
		return user;
	} //end loadUserByUsername

}
