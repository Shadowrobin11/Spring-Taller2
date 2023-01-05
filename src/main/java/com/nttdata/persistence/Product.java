package com.nttdata.persistence;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Christian
 *
 */

@Entity
@Table (name = "PRODUCTS")
public class Product extends AbstractEntity implements Serializable{
	
	/**
	 * Clase Producto
	 * 
	 * @author Christian
	 */

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Id del producto */
	private Long productId;
	
	/** Id del pedido*/
	private Order orderId;
	
	/** Nombre del producto*/
	private String name;
	
	/** Precio bruto*/
	private Double roughPrice;
	
	/** Precio*/
	private Double price;
	
	

	/**
	 * Devuelve el id del producto
	 * 
	 * @return productId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	public Long getProductId() {
		return productId;
	}
	
	/**
	 * Inserta id del producto
	 * 
	 * @param productId 
	 */

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	/**
	 * Devuelve el nombre
	 * 
	 * @return name
	 */
    @Column(name="C_NAME")
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
	 * Devuelve el precio sin impuesto
	 * 
	 * @return roughPrice
	 */
	
	@Column(name = "ROUGH_PRICE")
	public Double getRoughPrice() {
		return roughPrice;
	}
	
	/**
	 * Inserta el precio sin impuesto
	 * 
	 * @param roughPrice 
	 */

	public void setRoughPrice(Double roughPrice) {
		this.roughPrice = roughPrice;
	}

	
	/**
	 * Devuelve el precio con impuesto
	 * 
	 * @return Price
	 */
	
	@Column(name = "PRICE", nullable = true)
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Inserta el precio con impuesto
	 * 
	 * @return Price
	 */

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	/**
	 * Devuelve la id del pedido
	 * 
	 * @return orderId
	 */
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID", nullable = true)
	public Order getOrderId() {
		return orderId;
	}
	
	/**
	 * Inserta la id del pedido
	 * 
	 * @return orderId
	 */

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Añade el producto y los atributos
	 * 
	 * @author toString
	 */

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", roughPrice=" + roughPrice + ", price=" + price
				+ "]";
	}
	
	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	
	@Transient
	public Class<?> getClase() {
		return Product.class;
	}
	
	
}
