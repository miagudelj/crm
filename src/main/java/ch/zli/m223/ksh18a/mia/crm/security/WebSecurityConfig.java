/**
 * configurates web security
 */
package ch.zli.m223.ksh18a.mia.crm.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mia Gudelj
 * @since 14-07-2021
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired does not work here, usre ctor
	private UserDetailsService userDetailService;
	private BCryptPasswordEncoder passwordEncoder;

	
	/**
	 * Constructor 
	 * 
	 * @param userDetailsService
	 * @param passwordEncoder
	 */
	public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
	
		this.userDetailService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().and().cors().disable()
			.authorizeRequests()
				.antMatchers("/rest/v1/users/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.httpBasic()
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	} // end configure

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	} // end configure

}
