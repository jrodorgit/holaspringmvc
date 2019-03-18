package net.rodor.springmvc.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService {


	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("Entrando en loadUserByUserName:"+userName);
		// en este punto habria que ir a la bbdd a coger el usuario cuyo nombre es userName, junto con sus permisos
		// y crearlo para que spring lo autentifique y autorize lo que definido.
		return new UsuarioPermisos();
	}

}
