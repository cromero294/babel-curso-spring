package controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import entidades.Pedido;
import entidades.Pizza;

@Controller
@RequestScope
public class ControladorPedido {
	@GetMapping("compraFinal")
	public ModelAndView comprarPedido(HttpSession session) {
		ModelAndView mav = new ModelAndView("compraFinal");
		
		List<Pizza> lista = ((Pedido)session.getAttribute("pedidoSession")).getListaPizzas();
		
		int precio = 0;
		
		for(Pizza pizza : lista) {
			if(pizza.getTam().equals("small")) {
				precio += 5;
			}else if(pizza.getTam().equals("medium")) {
				precio += 10;
			}else {
				precio += 15;
			}
		}
		
		mav.addObject("nombre", ((Pedido)session.getAttribute("pedidoSession")).getUsuario());
		mav.addObject("pizzas", lista);
		mav.addObject("direccion", ((Pedido)session.getAttribute("pedidoSession")).getDireccion());
		mav.addObject("precio", precio);
		
		return mav;
	}
}
