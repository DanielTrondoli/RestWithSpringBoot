package br.com.erudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Startup.class, args);
		
	}

}
