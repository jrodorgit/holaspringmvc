package net.rodor.springmvc.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class UsuarioPermisos implements UserDetails {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("Obteniendo lista de autorizaciones del usuario");
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}

	@Override
	public String getPassword() {
		// se deberia de cargar utilizando la base de datos para traerse la password del usuario accedido por nombre.
		System.out.println("Accediendo a su password para chequear???");
		return "password";
	}

	@Override
	public String getUsername() {
		System.out.println("Accediendo a su nombre para chequear???");
		return "user";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
