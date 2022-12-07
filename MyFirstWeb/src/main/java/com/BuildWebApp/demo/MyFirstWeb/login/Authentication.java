package com.BuildWebApp.demo.MyFirstWeb.login;

import org.springframework.stereotype.Service;

@Service
public class Authentication {

	public boolean auth(String username, String psd) {
		boolean nameIsValid = username.equalsIgnoreCase("Naveen");
		boolean psdIsValid = psd.equalsIgnoreCase("Savarala");
		return nameIsValid && psdIsValid;
	}
}
