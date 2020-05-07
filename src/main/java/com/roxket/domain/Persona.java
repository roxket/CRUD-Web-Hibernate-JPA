/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roxket.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 *
 * @author Roxket
 */

@Entity
@Table(name="persona") // notacion si el nombre de la tabla difiere del nombre de la clase
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_persona") //@Column --> se marca la notacion por ser la columna en bbdd != atributo
	@Id //primary key
	private int idPersona;
	
	//@Column --> no se marca la notacion por ser la columna en bbdd = atributo
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	//Default Constructor
	public Persona(){}
	
	//Getter and Setters
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// toString
	@Override
	public String toString() {
		return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
	}
	
	
}
