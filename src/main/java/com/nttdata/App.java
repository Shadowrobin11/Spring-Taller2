package com.nttdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Order;
import com.nttdata.persistence.Product;
import com.nttdata.service.ServiceI;

/**
 * Hello world!
 *
 */
@SpringBootApplication()
public class App implements CommandLineRunner {
	private final static Logger LOG = LoggerFactory.getLogger(App.class);

	@Autowired
	@Qualifier("insidePeninsula")
	private ServiceI service1;

	@Autowired
	@Qualifier("outsidePeninsula")
	private ServiceI service2;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("TRAZA INICIO");

		LOG.info("CREACIÓN DE PEDIDOS");
		// Creacion de pedidos
		Order order1 = new Order();
		order1.setAddress("C/Miramelindo, bq1, bj-c2");
		order1.setIndPeninsula(false);

		Order order2 = new Order();
		order2.setAddress("C/Los Corrales, bq7, 2ºh");
		order2.setIndPeninsula(true);

		Order order3 = new Order();
		order3.setAddress("C/Avila, bq3, 7ºD");
		order3.setIndPeninsula(true);

		LOG.info("INSERCCIÓN DE PEDIDO");
		// Insercion del pedido
		service1.addOrder(order1);
		service2.addOrder(order2);
		service2.addOrder(order3);

		LOG.info("CREACIÓN DE PRODUCTOS");
		// Creacion de productos
		Product product1 = new Product();
		product1.setName("Thermomix");
		product1.setRoughPrice(499.00);

		Product product2 = new Product();
		product2.setName("Televisor");
		product2.setRoughPrice(799.00);

		LOG.info("CREACIÓN DE DESTINATARIO");
		// Creacion de destinatario
		Client add1 = new Client();
		add1.setDni("96385274-T");
		add1.setName("Juan");
		add1.setSurname("Sanchez Hurtado");

		Client add2 = new Client();
		add2.setDni("36925814-R");
		add2.setName("Pepa");
		add2.setSurname("Martin Martin");

		LOG.info("INSERCCIÓN DE DESTINATARIOS Y PRODUCTOS");
		// Inserciones de destinatarios y productos
		service1.insertShipping(order1, product1, add1);
		service2.insertShipping(order2, product2, add2);

		LOG.info("EJEMPLO DE PEDIDO FUERA DE LA PENINSULA");
		// Ejemplo pedido fuera de la peninsula
		service1.insertShipping(order3, product2, add2);

		LOG.info("BORRADO DE PEDIDO");
		// Borrado de pedido
		service1.deleteOrder(order2);
		
		LOG.info("TRAZA FIN");
	}
}
