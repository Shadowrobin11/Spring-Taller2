package com.nttdata.service;

import java.util.List;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;

/**
 * Interfaz de servicios
 *  
 * @author Christian
 *
 */

public interface ServiceI {

	public void addOrder(Order ord);
	
	public void deleteOrder(Order ord);
	
	
	public void insertShipping(Order ord, Product pro, Client cli);
	
	
	public List<Product> findAll();
	
	
	public Product findById(Long id);
	
	
}
