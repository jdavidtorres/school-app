package co.com.jdti.school;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
}
