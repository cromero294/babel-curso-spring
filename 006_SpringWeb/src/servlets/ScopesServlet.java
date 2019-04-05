package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import modelo.entidades.Mensaje;

public class ScopesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private ApplicationContext context;

	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils
					.getRequiredWebApplicationContext
					(getServletContext());
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("nombre", request.getParameter("nombre")); // Inicializando la sesion
		
		Mensaje msingleton = context.getBean("singleton", Mensaje.class);
		Mensaje mprototype1 = context.getBean("prototype", Mensaje.class);
		Mensaje mprototype2 = context.getBean("prototype", Mensaje.class);
		Mensaje mrequest1 = context.getBean("request", Mensaje.class);
		Mensaje mrequest2 = context.getBean("request", Mensaje.class);
		Mensaje msession = context.getBean("session", Mensaje.class);
		
		request.setAttribute("msingleton", msingleton);
		request.setAttribute("mprototype1", mprototype1);
		request.setAttribute("mprototype2", mprototype2);
		request.setAttribute("mrequest1", mrequest1);
		request.setAttribute("mrequest2", mrequest2);
		request.setAttribute("msession", msession);
		
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
