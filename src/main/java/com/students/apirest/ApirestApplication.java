package com.students.apirest;

import com.students.apirest.entity.Student;
import com.students.apirest.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initDatabase(StudentRepository repository) {
//
//		return args -> {
//			System.out.println("Preloading " + repository.save(new Student("João joão", "123456", "joao@joao.com")));
//			System.out.println("Preloading " + repository.save(new Student("Emilia", "487569", "emilia@teste.com")));
//			System.out.println("Preloading " + repository.save(new Student("Ana Clara", "445879", "an@clara.com")));
//		};
//	}
}
