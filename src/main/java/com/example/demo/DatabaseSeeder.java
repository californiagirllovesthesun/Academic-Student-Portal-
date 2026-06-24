package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(CourseRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Course c1 = new Course();
                c1.setName("Cosmic Architecture 101");
                repository.save(c1);

                Course c2 = new Course();
                c2.setName("Data Networks in Space");
                repository.save(c2);
            }
        };
    }
}
