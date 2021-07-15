/**
 * main class
 */
package ch.zli.m223.ksh18a.mia.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mia Gudelj
 * @since 12-07-2021
 */
@SpringBootApplication
public class CrmApplication {

	/**
	 * main runs the programm
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	/**
	 * gets password encoder
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return  new BCryptPasswordEncoder();
	}
}
