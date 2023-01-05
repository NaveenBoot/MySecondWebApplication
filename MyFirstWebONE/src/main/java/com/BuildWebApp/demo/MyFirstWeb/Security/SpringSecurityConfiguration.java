//package com.BuildWebApp.demo.MyFirstWeb.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SpringSecurityConfiguration {
//
//	//generally to provide our custom username and password we go for LDAP or Database
//	//but as of now we can use InMemory
//	
//	//InMemoryUserDetailsManager
//	//InMemoryUserDetailsManager(UserDetails... users)
//	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//		.username("Naveen")
//		.password("Naveen@050")
//	    .roles("USER","ADMIN")
//	    .build();
//		
//		return new InMemoryUserDetailsManager(userDetails);
//	};
//	
//}


/*package com.BuildWebApp.demo.MyFirstWeb.Security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	//generally to provide our custom username and password we go for LDAP or Database
	//but as of now we can use InMemory
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				                      .passwordEncoder(passwordEncoder)
				                      .username("Naveen")
			                          .password("Naveen@050")
			                          .roles("USER","ADMIN")
			                          .build();
		
		return new InMemoryUserDetailsManager(userDetails);
	};
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}*/



package com.BuildWebApp.demo.MyFirstWeb.Security;

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

	//generally to provide our custom username and password we go for LDAP or Database
	//but as of now we can use InMemory
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		//String username = "Naveen";
		//String password = "Naveen@050";
		
		UserDetails userDetails1 = createNewUser("NaveenS", "Naveen@050");
		UserDetails userDetails2 = createNewUser("Dhanu", "7901505029@aA");
		UserDetails userDetails3 = createNewUser("Whose", "Naveen@050");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);               //InMemoryUserDetailsManager is method in spring security
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				                      .passwordEncoder(passwordEncoder)
				                      .username(username)
			                          .password(password)
			                          .roles("USER","ADMIN")
			                          .build();
		return userDetails;
	};
	
	//spring security will not allow plain text as password it need an encoder we can provide that by using this method
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	//we need this to disable CSRF and Frames so that we can connect h2 database
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(                              //here we make sure that all requests are authenticated
               auth -> auth.anyRequest().authenticated()         //if there is an unauthorized request we are configuring  formLogin so that we can show a page where you can collect the userName and psd
			);
		http.formLogin(withDefaults());           //withDefaults() will in customizer   //we are configuring default features here but since we are overriding security filter chain we need to config
		http.csrf().disable();                                                          //them again
		http.headers().frameOptions().disable();
		return http.build();

	}*/
}














