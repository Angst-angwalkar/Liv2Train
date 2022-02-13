package io.Aniket.Liv2Train;

import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongoRepositories
public class Liv2TrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(Liv2TrainApplication.class, args);
	}

}
