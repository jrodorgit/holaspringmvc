package net.rodor.springmvc.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		System.out.println("Entrando en CustomAuthenticationProvider.... ");
		
		// aqui iria a la bbdd o a un ldap o a lo que sea para pillar password del usuario que intenta logarse
		UsuarioPermisos user = new UsuarioPermisos();
		
		if(!user.getPassword().equalsIgnoreCase(token.getCredentials().toString())){
			throw new BadCredentialsException("The credentials are invalid");
		}
		
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
