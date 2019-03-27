package net.rodor.springmvc;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rodor.springmvc.security.UsuarioPermisos;

@Controller
@RequestMapping("/permisos")
public class TipoPermisoController {

	@Autowired
	private TipoPermisoService serviceTP;

	public TipoPermisoService getService() {
		return serviceTP;
	}

	public void setService(TipoPermisoService service) {
		this.serviceTP = service;
	}
	@ModelAttribute("estaAutorizado")
	public boolean estaAutorizado(Authentication auth){
		return auth != null
				&& auth.getAuthorities().contains(AuthorityUtils.createAuthorityList("ROLE_ADMIN").get(0));
	}
	@RequestMapping("/")
	public String goPermisos(ModelMap model){
		System.out.println("Entrando en goPermisos");

		// llamada al servicio de listar permisos
		List<TipoPermiso> permisos = serviceTP.listar();
		model.addAttribute("lstTP", permisos);
		return "permisos/lstPermisos";
	}
	
//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@RolesAllowed("ROLE_USER")
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addTipoPermiso(@ModelAttribute("tp") TipoPermiso tp, ModelMap model) {
		
		System.out.println("Entrando en addTipoPermiso...");
		// quien realiza la accion
		//UsuarioPermisos up =(UsuarioPermisos) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails up = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("... con el usuario:"+up.getUsername());
		System.out.println(tp);
		int idTP = serviceTP.save(tp);
		
		// llamada al servicio de listar permisos
		List<TipoPermiso> permisos = serviceTP.listar();
		System.out.println(permisos);
		model.addAttribute("lstTP", permisos);
		
		return "permisos/lstPermisos";
	}

	/***
	 * @RequestMapping("/tipoPermiso/nuevo") public String nuevoTipoPermiso(){
	 * System.out.println(service.findById(22)); return "tipoPermiso/AddBis"; }
	 * 
	 * @RequestMapping(value="/tipoPermiso/AddBis", method=RequestMethod.POST)
	 *                                              public String
	 *                                              addTipoPermiso(
	 *                                              @ModelAttribute("tp")
	 *                                              TipoPermiso tp, ModelMap
	 *                                              model){
	 *                                              System.out.println(tp);
	 * 
	 *                                              int idTP = service.save(tp);
	 *                                              model.addAttribute("msg",
	 *                                              "Tipo Permiso Añadido con ID:"
	 *                                              +idTP);
	 * 
	 *                                              return "tipoPermiso/AddBis";
	 *                                              }
	 ***/
}
