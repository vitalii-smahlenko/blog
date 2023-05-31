package com.gmail.smaglenko.blog;

import com.gmail.smaglenko.blog.model.Role;
import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.model.service.UserService;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ArticleServiceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceAppApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            Optional<User> userFromDb = userService.findByUsername("admin");
            if(userFromDb.isEmpty()){
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin");
                admin.getRoles().add(Role.ADMIN);
                userService.save(admin);
            }
        };
    }

    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gmail.smaglenko"))
                .build();
    }
}
