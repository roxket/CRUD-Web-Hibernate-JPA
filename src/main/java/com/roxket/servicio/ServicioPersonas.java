package com.roxket.servicio;

import com.roxket.DAO.PersonaDAO;
import com.roxket.domain.Persona;
import java.util.List;

/**
 *
 * @author roxket
 */
public class ServicioPersonas {
	
	private PersonaDAO personaDao;
	
	public ServicioPersonas(){
		this.personaDao = new PersonaDAO();
	}
	public List<Persona> listarPersonas(){
		return this.personaDao.listar();
	}
	
}