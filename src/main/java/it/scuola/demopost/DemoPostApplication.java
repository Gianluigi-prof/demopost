package it.scuola.demopost;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoPostApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoPostApplication.class, args);
    }
		
    @Bean
    public CommandLineRunner init(MessageRepository repo) {
        return args -> {

            Message m1 = new Message();
            m1.setText("Primo messaggio");

            Message m2 = new Message();
            m2.setText("Secondo messaggio");

            repo.save(m1);
            repo.save(m2);
        };
	// }
    }
}
