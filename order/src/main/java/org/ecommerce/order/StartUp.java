package org.ecommerce.order;

import jakarta.transaction.Transactional;
import org.ecommerce.order.dao.domain.Product;
import org.ecommerce.order.dao.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;



@Service
public class StartUp implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartUp.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... strings) throws Exception {
		saveProduct();
	}

	@Transactional
	public void saveProduct() {
		LOGGER.info("saveProduct ...");
		Product product;

		productRepository.deleteAll();

		// ajout des données de tests
		for (int i = 1; i < 4; i++) {
			product = new Product();
			product.setName(String.format("Product %02d", i));
			product.setQuantite(100 + 50 * i);

			LOGGER.info("save ...");
			productRepository.save(product);
		}


		LOGGER.info("saveProduct OK");
	}
}
