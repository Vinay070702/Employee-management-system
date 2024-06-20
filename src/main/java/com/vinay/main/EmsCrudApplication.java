package com.vinay.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@ComponentScan(basePackageClasses=EmployeeController.class)
public class EmsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsCrudApplication.class, args);
	}

}
