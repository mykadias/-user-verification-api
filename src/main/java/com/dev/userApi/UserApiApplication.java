package com.dev.userApi;

import com.dev.userApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enviando e-mail de teste...");
		emailService.sendTestEmail("seu_email@exemplo.com");
		System.out.println("E-mail de teste enviado com sucesso!");
	}
}