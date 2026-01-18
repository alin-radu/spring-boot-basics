package com.dev.spring_boot_basics;

import com.dev.spring_boot_basics.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(App.class, args);

		ProductService productService =  context.getBean(ProductService.class);

	}

}
