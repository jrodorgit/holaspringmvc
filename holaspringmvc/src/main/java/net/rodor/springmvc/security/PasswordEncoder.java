package net.rodor.springmvc.security;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		System.out.println(encoder.encodePassword("password", null));
		
		StandardPasswordEncoder encoderStd = new StandardPasswordEncoder();
		System.out.println(encoderStd.encode("password"));

		BCryptPasswordEncoder encoderBc = new BCryptPasswordEncoder();
		System.out.println(encoderBc.encode("password"));
		System.out.println(encoderBc.encode("password"));
		System.out.println(encoderBc.encode("password"));
		
	}

}
