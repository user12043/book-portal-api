package com.user12043.bookportal;

import com.user12043.bookportal.model.User;
import com.user12043.bookportal.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

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
}
