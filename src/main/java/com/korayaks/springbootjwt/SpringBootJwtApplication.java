package com.korayaks.springbootjwt;

import com.korayaks.springbootjwt.domain.Role;
import com.korayaks.springbootjwt.domain.User;
import com.korayaks.springbootjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Koray Aksoy", "korayaks1", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Burak Koray Aksoy", "korayaks2", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "bka", "korayaks3", "1234", new ArrayList<>()));

            userService.addRoleToUser("korayaks1", "ROLE_USER");
            userService.addRoleToUser("korayaks1", "ROLE_ADMIN");
            userService.addRoleToUser("korayaks1", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("korayaks2", "ROLE_USER");
            userService.addRoleToUser("korayaks2", "ROLE_MANAGER");
            userService.addRoleToUser("korayaks3", "ROLE_USER");
        };
    }

}
