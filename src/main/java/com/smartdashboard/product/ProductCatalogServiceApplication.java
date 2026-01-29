package com.smartdashboard.product;

import com.smartdashboard.product.model.Product;
import com.smartdashboard.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
	}

	// මේ කොටසින් තමයි ඩේටා ඇතුලත් කරන්නේ
	@Bean
	public CommandLineRunner loadData(ProductRepository repository) {
		return args -> {
			// Database එක හිස් නම් විතරක් ඩේටා දාන්න
			if (repository.count() == 0) {
				repository.save(new Product("Gaming Laptop", "High performance laptop", 250000.00, 10));
				repository.save(new Product("Wireless Mouse", "Silent click mouse", 3500.00, 20));
				repository.save(new Product("Mechanical Keyboard", "RGB Keyboard", 8500.00, 15));
				System.out.println("Data Loaded Successfully!");
			}
		};
	}
}