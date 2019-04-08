package controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import entidades.Persona;
import entidades.Saludos;

@Controller
@RequestScope
public class ControladorSaludos {
	@Autowired
	private Saludos saludosSession;
	
	// Por defecto las peticiones que procesamos son get
	@RequestMapping(path="verFormularioSaludo",method=RequestMethod.GET)
	// @GetMapping("verFormularioSaludo")
	public String verFormulario() {
		return "formularioSaludos"; // /WEB-INF/vistas/formularioSaludos.jsp
	}
	
	// Estos metodos estan muy sobrecargados (se hace con reflection),
	// por lo que podemos inyectar muchos tipos de objetos en el metodo.
	@PostMapping("altaSaludo")
	public ModelAndView alta(HttpSession session, HttpServletRequest request, @RequestParam("nombre") String nombre) {
		// Siempre que se ejecute un post se hace un redirect
		// Siempre que se ejecute un get se hace un forward
		ModelAndView mav = new ModelAndView("redirect:verSaludos");
		
		// Aqui podriamos hacer las llamadas a los gestores
		
		String nombreRequest = request.getParameter("nombre");
		System.out.println(nombre);
		System.out.println(nombreRequest);
		session.setAttribute("atributoSession", "Valor 1");
		//List<String> listaSaludos = ((Saludos)session.getAttribute("saludos")).getListaSaludos();
		saludosSession.getListaSaludos().add(nombre);
		System.out.println(saludosSession.getListaSaludos());
		
		// Ya que estamos haciendo un redirect, el nombre se va a mandar como parametro
		// de la request. Si no hicieramos un redirect, el nombre se guardaria en el objeto request.
		mav.addObject("nombre", nombre);
		
		return mav;
	}
	
	@GetMapping("verSaludos")
	public ModelAndView mostrarSaludos(@RequestParam("nombre") String nombre) {
		ModelAndView mav = new ModelAndView("verSaludos");
		
		Persona p = new Persona();
		p.setNombre(nombre);
		
		mav.addObject("persona",p);
		mav.addObject("listaSaludos", saludosSession.getListaSaludos());
		mav.addObject("saludo", nombre);
		
		return mav;
	}
}
