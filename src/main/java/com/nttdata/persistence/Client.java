package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/**
	 * Clase Cliente
	 * 
	 * @author Christian
	 */

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id del cliente */
	private long clientId;

	/** Lista de pedidos */
	private List<Order> orders;

	/** Dni */
	private String dni;

	/** Nombre */
	private String name;

	/** Apellidos */
	private String surname;

	/**
	 * Devuelve el id del cliente
	 * 
	 * @return clientId
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public long getClientId() {
		return clientId;
	}

	/**
	 * Inserta id del cliente
	 * 
	 * @param clientId
	 */

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	/**
	 * Devuelve los pedidos
	 * 
	 * @return orders
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * Inserta los pedidos
	 * 
	 * @param orders
	 */

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * Devuelve el dni
	 * 
	 * @return dni
	 */

	@Column(name = "DNI", nullable = false, unique = true)

	public String getDni() {
		return dni;
	}

	/**
	 * Inserta el dni
	 * 
	 * @param dni
	 */

	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el nombre
	 * 
	 * @return name
	 */

	@Column(name = "NAME")

	public String getName() {
		return name;
	}

	/**
	 * Inserta el nombre
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve los apellidos
	 * 
	 * @return surname
	 */

	@Column(name = "SURNAMES")

	public String getSurname() {
		return surname;
	}

	/**
	 * Inserta los apellidos
	 * 
	 * @param surname
	 */

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

}
