package net.rodor.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/helloXXXOI")
	public String helloXXXOI(){
		return "hello";
	}
	
	@RequestMapping("/helloYYYOI")
	public ModelAndView helloYYYOI(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("helloBis");
		TipoPermiso tp = new TipoPermiso();
		tp.setId(1);
		tp.setNombre("permiso Y");
		tp.setDescripcion("Descripcion permiso Y");
		modelAndView.addObject("tp", tp);
		
		return modelAndView;
	}
	
	@RequestMapping("/helloZZZOI")
	public ModelAndView helloZZZOI(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tipoPermisoAdd");
		return modelAndView;
	}
	
	@RequestMapping(value="/addTipoPermiso", method=RequestMethod.POST)
	public String addTipoPermiso(@ModelAttribute("tp") TipoPermiso tp, ModelMap model){
		System.out.println(tp);
		
		model.addAttribute("tp", tp);
		model.addAttribute("msg", "Tipo Permiso Añadido.");
		
		return "tipoPermisoAdd";
	}
	
	@RequestMapping("/helloAAAOI")
	public ModelAndView helloAAAOI(@RequestParam(value="id", required=false, defaultValue="123") int id){
		System.out.println("Consultando el elemento de id."+id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
