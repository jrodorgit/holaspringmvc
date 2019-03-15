package net.rodor.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//


@Controller
@RequestMapping("/")
public class MenuController {
	
	@Autowired
	private TipoPermisoService serviceTP;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	/*@RequestMapping("/permisos")
	public String goPermisos(ModelMap model){
		System.out.println("Entrando en goPermisos");

		// llamada al servicio de listar permisos
		List<TipoPermiso> permisos = serviceTP.listar();
		model.addAttribute("lstTP", permisos);
		return "permisos/lstPermisos";
	}*/
	
	@RequestMapping("/contact")
	public String goContact(){
		System.out.println("Entrando en goContact");
		return "contact/contacto";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin(){
		System.out.println("Entrando en goLogin");
		return "login/login";
	}

}
