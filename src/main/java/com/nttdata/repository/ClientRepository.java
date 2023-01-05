package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Client;


/**
 * Repositorio de cliente
 * 
 * @author Christian
 *
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
