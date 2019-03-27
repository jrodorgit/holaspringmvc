package net.rodor.springmvc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

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
	/**
	@RequestMapping("/contact")
	public String goContact(){
		System.out.println("Entrando en goContact");
		return "contact/contacto";
	}
	***/
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin(){
		System.out.println("Entrando en goLogin");
		return "login/login";
	}

	
}
