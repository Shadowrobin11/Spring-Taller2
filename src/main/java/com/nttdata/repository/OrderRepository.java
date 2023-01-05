package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Order;


/**
 * Repositorio de pedido
 * 
 * @author Christian
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
