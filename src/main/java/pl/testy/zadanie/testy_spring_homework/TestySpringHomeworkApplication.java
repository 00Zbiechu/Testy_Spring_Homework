package pl.testy.zadanie.testy_spring_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TestySpringHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestySpringHomeworkApplication.class, args);
    }

}
