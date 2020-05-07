package com.roxket.web;

import com.roxket.domain.Persona;
import com.roxket.servicio.ServicioPersonas;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author roxket
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		//aplica el patron MVC
		ServicioPersonas servicioPersonas = new ServicioPersonas();
		
		List<Persona> personas = servicioPersonas.listarPersonas();
		
		//Aplica la lista en el front, en el alcance del request
		request.setAttribute("personas", personas);
		
		try {
			request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace(System.out);
		} catch (IOException e){
			e.printStackTrace(System.out);
		}
		
	}
}
