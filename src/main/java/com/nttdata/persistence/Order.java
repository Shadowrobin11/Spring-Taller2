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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDERS")
public class Order extends AbstractEntity implements Serializable {

	/**
	 * Clase Pedido
	 * 
	 * @author Christian
	 */

	/** Serial Version **/
	private static final long serialVersionUID = 1L;

	/** Productos asociados **/
	private List<Product> products;

	/** Id de pedido */
	private Long orderId;

	/** Direccion **/
	private String address;

	/** Indicador peninsula **/
	private boolean indPeninsula;

	private Client client;

	/**
	 * Devuelve el id del pedido
	 * 
	 * @return orderId
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Inserta el id del pedido
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Devuelve los productos
	 * 
	 * @return products
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderId")
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Coloca los productos
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Devuelve la direccion
	 * 
	 * @return address
	 */

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	/**
	 * Inserta la direccion
	 * 
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Devuelve si esta en la peninsula
	 * 
	 * @return indPeninsula
	 */
	@Column(name = "PENINSULA")
	public boolean isIndPeninsula() {
		return indPeninsula;
	}

	/**
	 * 
	 * @param indPeninsula
	 */
	public void setIndPeninsula(boolean indPeninsula) {
		this.indPeninsula = indPeninsula;
	}

	@ManyToOne
	@JoinColumn(name = "C_FK_ID_CLIENT", referencedColumnName = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	/**
	 * 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Order.class;
	}

}
