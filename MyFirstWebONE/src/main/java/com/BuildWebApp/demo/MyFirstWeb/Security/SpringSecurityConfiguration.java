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
		
		//String username = "Naveen";
		//String password = "Naveen@050";
		
		UserDetails userDetails1 = createNewUser("Naveen", "Naveen@050");
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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}














