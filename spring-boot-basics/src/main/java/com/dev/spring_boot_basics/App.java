package com.dev.spring_boot_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

//		ApplicationContext context =  SpringApplication.run(App.class, args);
//		ProductService productService =  context.getBean(ProductService.class);

	}

}
