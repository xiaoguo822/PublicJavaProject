package org.guojian.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:root.xml")
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class);  
	}

}
