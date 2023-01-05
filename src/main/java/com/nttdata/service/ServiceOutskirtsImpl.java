package com.nttdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;
import com.nttdata.repository.OrderRepository;
import com.nttdata.repository.ProductRepository;

/**
 * Servicio para pedidos fuera de la peninsula
 * 
 * @author Christian
 *
 */

@Service ("outsidePeninsula")
public class ServiceOutskirtsImpl  implements ServiceI{

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository productRepo;
	
	ProductRepository pr;

	//@Autowired
	//JpaRepository addRepo;
	
	@Override
	public void addOrder(Order ord) {
		orderRepo.save(ord);
		
	}

	@Override
	public void deleteOrder(Order ord) {
		orderRepo.delete(ord);
		
	}

	@Override
	public void insertShipping(Order ord, Product pro, Client cli) {
		if(ord.isIndPeninsula()) {
			System.out.println("Es dentro de la peninsula");
		} else {
			double tax = (pro.getRoughPrice() * 4) / 100;

			pro.setPrice(pro.getRoughPrice() + tax);

			//addRepo.save(cli);
			
			productRepo.save(pro);

			orderRepo.save(ord);
		}
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
