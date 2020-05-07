package com.roxket.DAO;

import com.roxket.domain.Persona;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author roxket
 */
public class PersonaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PersonaDAO() {
		//JPA sobre Hibernate
		emf = Persistence.createEntityManagerFactory("HibernatePU");
		em = emf.createEntityManager();
	}

	public List<Persona> listar() {
		String hql = "SELECT p FROM Persona p";
		Query query = em.createQuery(hql); // --> recupera los objectos
		List<Persona> personas = query.getResultList();
//		for (Persona p : personas) {
//			System.out.println("Persona: " + p);
//		}
		return personas;
	}


	public void insertar(Persona persona) {
		try {
			//Abrimos y cerramos la transaccion por no estar desplegado en un servidor
			em.getTransaction().begin();
			em.persist(persona); // guarda el registro
			em.getTransaction().commit();
		} catch (Exception e) { //en caso de exception, hacemos un rollback
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void modificar(Persona persona) {
		try {
			//Abrimos y cerramos la transaccion por no estar desplegado en un servidor
			em.getTransaction().begin();
			em.merge(persona); //sincroniza, actualiza el registro
			em.getTransaction().commit();
		} catch (Exception e) { //en caso de exception, hacemos un rollback
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
		// No cerramos la transaccion para aprovecharla
//		finally{
//			if(em != null){
//				em.close();
//			}
//		}
	}

	public Persona buscarPersonaPorId(Persona p) {
		//No se inicia una transaccion porque es un select
		return em.find(Persona.class, p.getIdPersona());
	}

	public void eliminar(Persona persona) {
		try {
			//Abrimos y cerramos la transaccion por no estar desplegado en un servidor
			em.getTransaction().begin();
			em.remove(em.merge(persona)); //sincroniza, actualiza el registro y lo elimina
			em.getTransaction().commit();
		} catch (Exception e) { //en caso de exception, hacemos un rollback
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
		// No cerramos la transaccion para aprovecharla
//		finally{
//			if(em != null){
//				em.close();
//			}
//		}
	}

}
