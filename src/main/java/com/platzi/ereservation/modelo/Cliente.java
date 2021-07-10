/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * This class represent Reserva table
 * This class represent Cliente table.
 * @author sorth_
 *
 */
@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query="SELECT c FROM Cliente c WHERE c.identificacionCli = ?1")
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;
	
	
	
	public Cliente() {
		
	}



	/**
	 * @return the idCli
	 */
	public String getIdCli() {
		return idCli;
	}



	/**
	 * @param idCli the idCli to set
	 */
	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}



	/**
	 * @return the nombreCli
	 */
	public String getNombreCli() {
		return nombreCli;
	}



	/**
	 * @param nombreCli the nombreCli to set
	 */
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}



	/**
	 * @return the apellidoCli
	 */
	public String getApellidoCli() {
		return apellidoCli;
	}



	/**
	 * @param apellidoCli the apellidoCli to set
	 */
	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}



	/**
	 * @return the identificacionCli
	 */
	public String getIdentificacionCli() {
		return identificacionCli;
	}



	/**
	 * @param identificacionCli the identificacionCli to set
	 */
	public void setIdentificacionCli(String identificacionCli) {
		this.identificacionCli = identificacionCli;
	}



	/**
	 * @return the direccionCli
	 */
	public String getDireccionCli() {
		return direccionCli;
	}



	/**
	 * @param direccionCli the direccionCli to set
	 */
	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}



	/**
	 * @return the telefonoCli
	 */
	public String getTelefonoCli() {
		return telefonoCli;
	}



	/**
	 * @param telefonoCli the telefonoCli to set
	 */
	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}



	/**
	 * @return the emailCli
	 */
	public String getEmailCli() {
		return emailCli;
	}



	/**
	 * @param emailCli the emailCli to set
	 */
	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}



	/**
	 * @return the reservas
	 */
	public Set<Reserva> getReservas() {
		return reservas;
	}



	/**
	 * @param reservas the reservas to set
	 */
	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	
	

}
