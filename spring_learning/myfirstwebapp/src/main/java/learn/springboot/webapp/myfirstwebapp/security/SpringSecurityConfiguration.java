package learn.springboot.webapp.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	// Typically we use LDAP for security or atleast database
	// Here, we will use InMemoryUserDetailsManager
	/*
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("Ranga").password("dummy")
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
	*/
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("Ranga", "dummy");
		UserDetails userDetails2 = createNewUser("Priya", "dummy");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
										.passwordEncoder(passwordEncoder)
										.username(username).password(password)
										.roles("USER", "ADMIN")
										.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// By default, all URLs are protected
	// A login form is shown for all unauthorized requests
	// By default, spring doesn't allow Frames and CSRF is also enabled // mandatory for h2-console
	
	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity httpSec) throws Exception {
		httpSec.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		httpSec.formLogin(withDefaults());
		httpSec.csrf().disable();
		httpSec.headers().frameOptions().disable();
		return httpSec.build();
	}
}
