package net.rodor.springmvc.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoderBc = new BCryptPasswordEncoder();
		System.out.println(encoderBc.encode("password"));
		System.out.println(encoderBc.encode("password"));
		System.out.println(encoderBc.encode("password"));
		
	}

}
