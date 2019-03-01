package net.rodor.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/helloXXXOI")
	public ModelAndView helloXXXOI(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		return modelAndView;
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
	public ModelAndView addTipoPermiso(@ModelAttribute("tp") TipoPermiso tp){
		System.out.println(tp);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tipoPermisoAdd");
		modelAndView.addObject("tp", tp);
		modelAndView.addObject("msg", "Tipo Permiso Añadido.");
		return modelAndView;
	}
}
