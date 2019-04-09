package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import entidades.Pedido;
import entidades.Pizza;

@Controller
@RequestScope
public class ControladorIngredientes {
	@GetMapping("ingredientes")
	public String verIngredientes() {
		return "ingredientes"; // /WEB-INF/vistas/ingredientes.jsp
	}
	
	@PostMapping("pedirPizza")
	public ModelAndView pedirPizza(HttpSession session, @RequestParam("nombre") String nombre, @RequestParam("direccion") String direccion, 
			@RequestParam("tam") String tam, @RequestParam("ingredientes") String[] ingredientes) {
		ModelAndView mav = new ModelAndView("ingredientes");
		
		Pizza pizza = new Pizza();
		pizza.setIngredientes(ingredientes);
		pizza.setTam(tam);
		
		Pedido p;
		
		if((Pedido)session.getAttribute("pedidoSession") != null) {
			p = (Pedido)session.getAttribute("pedidoSession");
		}else {
			p = new Pedido();
			p.setUsuario(nombre);
			p.setListaPizzas(new ArrayList<Pizza>());
			session.setAttribute("pedidoSession", p);
		}
		
		p.getListaPizzas().add(pizza);
		
		System.out.println((Pedido)session.getAttribute("pedidoSession"));
		
		return mav; // /WEB-INF/vistas/ingredientes.jsp
	}
}
