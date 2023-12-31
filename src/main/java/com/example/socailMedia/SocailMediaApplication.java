package com.example.socailMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.*")
@SpringBootApplication
public class SocailMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocailMediaApplication.class, args);
	}

}
