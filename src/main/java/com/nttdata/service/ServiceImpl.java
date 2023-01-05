package com.nttdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;
import com.nttdata.repository.ClientRepository;
import com.nttdata.repository.OrderRepository;
import com.nttdata.repository.ProductRepository;

/**
 * Servicio para pedidos de la peninsula
 * 
 * @author Christian
 *
 */

@Service("insidePeninsula")
public class ServiceImpl implements ServiceI{
	
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	ClientRepository addRepo;

	ProductRepository pr;
	
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
			double tax = (pro.getRoughPrice() * 21)/100;
			pro.setPrice(pro.getRoughPrice() + tax);
			addRepo.save(cli);
			pro.setOrderId(ord);
			//ord.setClient(cli);
			productRepo.save(pro);
			orderRepo.save(ord);
		} else {
			System.out.println("El pedido se hace fuera de la peninsula");
		}
		
	}

	@Override
	public List<Product> findAll() {
		
		return pr.findAll();
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
