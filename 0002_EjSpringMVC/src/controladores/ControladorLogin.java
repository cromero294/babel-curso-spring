package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestScope
public class ControladorLogin {
	
	@GetMapping("login")
	public String verLogin() {
		return "login"; // /WEB-INF/vistas/login.jsp
	}
	
	@PostMapping("altaUsuario")
	public ModelAndView altaUsuario(HttpSession session, @RequestParam("user") String user, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("redirect:ingredientes");
		
		String mensaje = "";
		
		if(!user.equals("user") || !password.equals("password")) {
			mensaje = "Usuario incorrecto.";
			mav = new ModelAndView("login");
			mav.addObject("mensaje", mensaje);
		}
		
		session.setAttribute("userSession", user);
		System.out.println(session.getAttribute("userSession"));
		
		session.setAttribute("passwordSession", password);
		System.out.println(session.getAttribute("passwordSession"));
		
		return mav;
	}
}
