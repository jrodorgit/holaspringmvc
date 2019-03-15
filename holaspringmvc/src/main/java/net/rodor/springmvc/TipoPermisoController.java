package net.rodor.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
/** quitar***/
	@RequestMapping("/")
	public String goPermisos(ModelMap model){
		System.out.println("Entrando en goPermisos");

		// llamada al servicio de listar permisos
		List<TipoPermiso> permisos = serviceTP.listar();
		model.addAttribute("lstTP", permisos);
		return "permisos/lstPermisos";
	}
	
	//@RequestMapping(value = "/permisos/add", method = RequestMethod.POST)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTipoPermiso(@ModelAttribute("tp") TipoPermiso tp, ModelMap model) {
		
		System.out.println("Entrando en addTipoPermiso");
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
