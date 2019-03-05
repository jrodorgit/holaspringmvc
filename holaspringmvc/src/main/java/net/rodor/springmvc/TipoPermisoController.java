package net.rodor.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TipoPermisoController {

	@Autowired
	private TipoPermisoService service;

	public TipoPermisoService getService() {
		return service;
	}

	public void setService(TipoPermisoService service) {
		this.service = service;
	}
	
	@RequestMapping("/nuevoTipoPermiso")
	public String nuevoTipoPermiso(){
		return "tipoPermisoAddBis";
	}
	
	@RequestMapping(value="/addTipoPermisoBis", method=RequestMethod.POST)
	public String addTipoPermiso(@ModelAttribute("tp") TipoPermiso tp, ModelMap model){
		System.out.println(tp);
		
		int idTP = service.save(tp);
		model.addAttribute("msg", "Tipo Permiso Añadido con ID:"+idTP);
		
		return "tipoPermisoAddBis";
	}
	
}
