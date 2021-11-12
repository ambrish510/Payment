package com.upgrad.Payment;

import com.upgrad.Payment.services.PaymentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaymentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PaymentApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
