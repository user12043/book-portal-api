package com.user12043.bookportal;

import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.user12043.bookportal"})
public class BookPortalApplication {
    private final UserRepository userRepository;

    public BookPortalApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookPortalApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    void initFirstUser() {
        if (userRepository.findByRole("ADMIN").size() == 0) {
            User defaultAdmin = new User();
            defaultAdmin.setRole("ADMIN");
            defaultAdmin.setUsername("admin");
            defaultAdmin.setPassword("admin");
            defaultAdmin.setName("Administrator");
            defaultAdmin.setEmail("admin@admin.com");
            userRepository.saveAndFlush(defaultAdmin);
        }
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://bookportal-ui.herokuapp.com");
            }
        };
    }
}
