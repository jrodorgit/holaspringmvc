package net.rodor.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MenuController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping("/permisos")
	public String goPermisos(){
		System.out.println("goPermisos");
		return "permisos/lstPermisos";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin(){
		System.out.println("entrando en goLogin");
		return "login/login";
	}

}
